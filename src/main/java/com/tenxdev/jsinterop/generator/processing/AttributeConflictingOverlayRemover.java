/*
 * Copyright 2017 Abed Tony BenBrahim <tony.benrahim@10xdev.com>
 *     and Gwt-JElement project contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.tenxdev.jsinterop.generator.processing;

import com.tenxdev.jsinterop.generator.logging.Logger;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.InterfaceDefinition;
import com.tenxdev.jsinterop.generator.model.Model;
import com.tenxdev.jsinterop.generator.model.types.ExtensionObjectType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttributeConflictingOverlayRemover {

    private final Model model;
    private final Logger logger;

    public AttributeConflictingOverlayRemover(Model model, Logger logger) {
        this.model = model;
        this.logger = logger;
    }

    public void process() {
        logger.info(()->"Removing conflicting overlay methods");
        model.getDefinitions().stream()
                .filter(definition -> definition instanceof InterfaceDefinition)
                .map(definition -> (InterfaceDefinition) definition)
                .filter(definition -> definition.getParent() != null)
                .forEach(this::process);
    }

    private void process(InterfaceDefinition definition) {
        Type parentType = definition.getParent() instanceof ParameterisedType ?
                ((ParameterisedType) definition.getParent()).getBaseType() : definition.getParent();
        if (parentType instanceof ExtensionObjectType) {
            return;
        }
        AbstractDefinition parentDefinition = model.getDefinition(parentType.getTypeName());
        if (parentDefinition == null || !(parentDefinition instanceof InterfaceDefinition)) {
            logger.formatError("AttributeConflictingOverlayRemover: inconsistent parent %s for %s",
                    parentType.getTypeName(), definition.getName());
        } else {
            process(definition, (InterfaceDefinition) parentDefinition);
        }
    }

    private void process(InterfaceDefinition definition, InterfaceDefinition parentDefinition) {
        List<String> parentWritableAttributes = parentDefinition.getAttributes().stream()
                .filter(attribute -> !attribute.isReadOnly())
                .map(Attribute::getName)
                .collect(Collectors.toList());
        List<String> parentReadOnlyAttributes = parentDefinition.getAttributes().stream()
                .filter(Attribute::isReadOnly)
                .map(Attribute::getName)
                .collect(Collectors.toList());
        List<Attribute> attributesToBeRemoved = new ArrayList<>();
        List<Attribute> attributesToBeAdded = new ArrayList<>();
        definition.getAttributes().forEach(attribute -> {
            if (parentWritableAttributes.contains(attribute.getName())) {
                attributesToBeRemoved.add(attribute);
            } else if (parentReadOnlyAttributes.contains(attribute.getName())) {
                attributesToBeRemoved.add(attribute);
                attributesToBeAdded.add(attribute.newWriteOnlyAttribute());
            }
        });
        definition.getAttributes().removeAll(attributesToBeRemoved);
        definition.getAttributes().addAll(attributesToBeAdded);
        //could recurse into parent but not needed so far
    }

}
