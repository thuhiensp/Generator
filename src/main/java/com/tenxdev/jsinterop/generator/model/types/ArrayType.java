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

package com.tenxdev.jsinterop.generator.model.types;

import org.eclipse.xtend2.lib.StringConcatenation;

import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.Model;

public class ArrayType implements Type {

    private final Type type;

    public ArrayType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String displayValue() {
        return type.displayValue() + "[]";
    }

    @Override
    public String getTypeName() {
        return getType().getTypeName() + "Array";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArrayType arrayType = (ArrayType) o;

        return type.equals(arrayType.type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public String toString() {
        return "ArrayType{" +
                "type=" + type +
                '}';
    }

	@Override
	public CharSequence contentOfMethod(Model model, Method method) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append(" {");
		_builder.newLineIfNotEmpty();
		_builder.append("       return null;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		return _builder.toString();
	}
}
