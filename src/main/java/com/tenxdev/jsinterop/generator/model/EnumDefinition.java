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

package com.tenxdev.jsinterop.generator.model;

import com.tenxdev.jsinterop.generator.model.types.NativeType;
import com.tenxdev.jsinterop.generator.model.types.Type;

import java.util.List;

public class EnumDefinition extends AbstractDefinition {

    private final List<String> values;

    public EnumDefinition(String name, List<String> values, @SuppressWarnings("unused") List<String> extendedAttributes) {
        super(name);
        this.values = values;
    }

    public static String toJavaName(String value) {
        String result = value.toUpperCase();
        if (result.startsWith("\"") && result.endsWith("\"")) {
            result = result.substring(1, result.length() - 1);
        }
        if (result.isEmpty()) {
            result = "NONE";
        }
        if (!Character.isAlphabetic(result.charAt(0))) {
            result = "_" + result;
        }
        return result.replaceAll("[^A-Z0-9]", "_");
    }

    public List<String> getValues() {
        return values;
    }

    public Type getJavaElementType() {
        return !values.isEmpty() && values.get(0).startsWith("\"") ?
                new NativeType("String") : new NativeType("int");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnumDefinition that = (EnumDefinition) o;
        return getName().equals(that.getName()) && values.equals(that.values);
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + values.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\nEnumDefinition{" +
                "name='" + getName() + '\'' +
                ", values=" + values +
                '}';
    }
}
