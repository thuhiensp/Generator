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
import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.InterfaceDefinition;
import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.Model;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;

import java.util.Optional;

public class InterfaceDetector {

    private final Type arrayLikeType;
    private final Type isObjectType;
    private final Model model;
    private final Logger logger;

    public InterfaceDetector(Model model, Logger logger) {
        this.model = model;
        this.logger = logger;
        this.arrayLikeType = model.getTypeFactory().getTypeNoParse("ArrayLike");
        this.isObjectType = model.getTypeFactory().getTypeNoParse("IsObject");
    }

    public void process() {
        logger.info(() -> "Detecting implied interfaces");
        model.getInterfaceDefinitions().forEach(this::processInterfaceDefinition);
    }

    private void processInterfaceDefinition(InterfaceDefinition definition) {
        if (definition.getParent() == null) {
            logger.debug(() -> "Adding IsObject to " + definition.getName());
            definition.getImplementedInterfaces().add(isObjectType);
        }
        detectArrayLike(definition);
    }

    private void detectArrayLike(InterfaceDefinition definition) {
        getLengthAttribute(definition).ifPresent(lengthAttribute ->
                getIndexedGetter(definition).ifPresent(getterMethod -> {
                    definition.getMethods().remove(getterMethod);
                    definition.getAttributes().remove(lengthAttribute);
                    Type newInterface = new ParameterisedType(arrayLikeType, getterMethod.getReturnType().box());
                    definition.getImplementedInterfaces().add(newInterface);
                    logger.debug(() -> "Adding " + newInterface.displayValue() +
                            " to " + definition.getName());
                }));
    }

    private Optional<Attribute> getLengthAttribute(InterfaceDefinition definition) {
        return definition.getAttributes().stream()
                .filter(attribute -> "length".equals(attribute.getName()) &&
                        "double".equals(attribute.getType().displayValue()))
                .findAny();
    }

    private Optional<Method> getIndexedGetter(InterfaceDefinition definition) {
        return definition.getMethods().stream()
                .filter(method -> "get".equals(method.getName())
                        && method.getArguments().size() == 1
                        && "double".equals(method.getArguments().get(0).getType().displayValue()))
                .findAny();
    }

}
