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

public class NativeType implements Type {

    public static final NativeType BYTE = new NativeType("byte");
    public static final NativeType SHORT = new NativeType("short");
    public static final NativeType INT = new NativeType("int");
    public static final NativeType DOUBLE = new NativeType("double");
    public static final NativeType BOOLEAN = new NativeType("boolean");
    public static final NativeType FLOAT = new NativeType("float");
    public static final NativeType LONG = new NativeType("long");
    
    private String typeName;

    public NativeType(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String getTypeName() {
    	if(Model.getTypePrimimiteToObject().keySet().contains(typeName)){
			return Model.getTypePrimimiteToObject().get(typeName);
		}
        return typeName;
    }
    

    @Override
    public String displayValue() {
        return typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NativeType that = (NativeType) o;

        return typeName != null ? typeName.equals(that.typeName) : that.typeName == null;
    }

    @Override
    public int hashCode() {
        return typeName != null ? typeName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "NativeType{" +
                "typeName='" + typeName + '\'' +
                '}';
    }

	@Override
	public CharSequence contentOfMethod(Model model, Method method) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("{");
		_builder.newLineIfNotEmpty();
		if (method.isArgsNativeType()) {
			if (this.getTypeName().equals("void")) {
					_builder.append("       final ModelWriter writer = UIContext.get().getWriter();");
					_builder.newLineIfNotEmpty();
					_builder.append("       writer.beginPObject2();");
					_builder.newLineIfNotEmpty();
					_builder.append("       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());");
					_builder.newLineIfNotEmpty();
					_builder.append("       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.");
					_builder.newLineIfNotEmpty();
					_builder.append("       " + Model.modifyName(model.getNameExtends(method)) + "_"
							+ model.atrTypeGeneral(method.getReturnType()) + ".getValue());");
					_builder.newLineIfNotEmpty();

			} else {
				_builder.append("       cbacksSequence++;");
				_builder.newLineIfNotEmpty();
				_builder.append("       cbacks.put(cbacksSequence, cback);");
				_builder.newLineIfNotEmpty();
				_builder.append("       final ModelWriter writer = UIContext.get().getWriter();");
				_builder.newLineIfNotEmpty();
				_builder.append("       writer.beginPObject2();");
				_builder.newLineIfNotEmpty();
				_builder.append("       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());");
				_builder.newLineIfNotEmpty();
				_builder.append("       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.");
				_builder.append(Model.modifyName(model.getNameExtends(method)) + "_"
						+ model.atrTypeGeneral(method.getReturnType()));
				_builder.append(".getValue());");
				_builder.newLineIfNotEmpty();
				_builder.append("       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);");
				_builder.newLineIfNotEmpty();
			}
			if (!method.getArguments().isEmpty()) {
				_builder.append("       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {");
				for (int index = 0; index < method.getArguments().size(); index++) {
					_builder.append(method.getArguments().get(index).getName());
					if (index < method.getArguments().size() - 1)
						_builder.append(",");
					else
						_builder.append("});");
				}
				_builder.newLineIfNotEmpty();
			}
			_builder.append("       writer.endObject();");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		return _builder.toString();
	}
}
