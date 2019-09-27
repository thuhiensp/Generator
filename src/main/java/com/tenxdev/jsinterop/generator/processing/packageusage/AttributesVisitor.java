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

package com.tenxdev.jsinterop.generator.processing.packageusage;

import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.types.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class AttributesVisitor {

    private final PackageUsageTypeVisitor typeVisitor = new PackageUsageTypeVisitor();
    private final Type jsType;

    AttributesVisitor(Type jsType) {
        this.jsType = jsType;
    }

    List<String> accept(List<Attribute> attributes) {
        return attributes.stream()
                .map(this::visitAttribute)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private List<String> visitAttribute(Attribute attribute) {
        List<String> result = new ArrayList<>();
       // if (!attribute.isReadOnly() && !attribute.isStatic()) { //stage Hien Le.
	        result.addAll(typeVisitor.accept(attribute.getType()));
	        if (attribute.isWriteOnly()) {
	            //result.add("jsinterop.annotations.JsOverlay");
	            result.addAll(typeVisitor.accept(jsType));
	        }
        //}
        return result;
    }
}
