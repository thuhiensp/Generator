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

import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.Model;

import javax.annotation.Generated;

import org.eclipse.xtend2.lib.StringConcatenation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnionType implements Type {

    private List<Type> types;
    private String name;
    private AbstractDefinition owner;

    public UnionType(String name, List<Type> types) {
        this.name = name;
        this.types = types;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    @Override
    public String displayValue() {
        return owner == null ? name : (owner.getName() + "." + name);
    }

    @Override
    public String getTypeName() {
        return types.stream()
                .map(Type::getTypeName)
                .collect(Collectors.joining()) + "UnionType";
    }

    public AbstractDefinition getOwner() {
        return owner;
    }

    public void setOwner(AbstractDefinition owner) {
        this.owner = owner;
    }

    @Override
    @Generated("IntelliJ")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnionType unionType = (UnionType) o;

        if (!this.listToSetForTypes().equals(unionType.listToSetForTypes())) return false;
        return name != null ? name.equals(unionType.name) : unionType.name == null;
    }

    @Override
    public int hashCode() {
        int result = listToSetForTypes().hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UnionType{" +
                "types=" + types +
                ", name='" + name + '\'' +
                '}';
    }
    
    public CharSequence generateImportForUnionTypeClass() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2.uniontype;");
		_builder.newLineIfNotEmpty();
		_builder.append("import com.ponysdk.core.ui2.PObject2;");
		_builder.newLineIfNotEmpty();
		for (Type type: getTypes()) {
			if (type instanceof ObjectType ) {
				_builder.append("import " + "com.ponysdk.core.ui2" + ((ObjectType) type).getPackageName() + "."+ Type.getTypesNameOfObjectType((ObjectType) type) + ";" );
				_builder.newLineIfNotEmpty();
			}
			if (type instanceof ArrayType) {
				if (((ArrayType) type).getType() instanceof ObjectType) {
					_builder.append("import com.ponysdk.core.ui2." +((ObjectType)((ArrayType) type).getType()).getPackageName()+ ".P" + type.getTypeName() + ";" );
					_builder.newLineIfNotEmpty();
				}
			}
		}
		_builder.newLineIfNotEmpty();
		return _builder.toString();
	}
    
    public CharSequence generateBodyForUnionTypeClass(String nameOfClass) {
    	StringConcatenation _builder = new StringConcatenation();
    	  _builder.append("public abstract class ");
          _builder.append("P"+ nameOfClass);
          _builder.append(" extends PObject2");
          _builder.append(" {");
          _builder.newLineIfNotEmpty();
          _builder.append(Type.declarationUnionType("value", this));
          String[] listOfAttrNameType = Type.getTypesNameOfAttrOfUnionType(this);
          int length = listOfAttrNameType.length;
          for (int index =0; index <length; index++ ) {
         	 _builder.append("    public " + "P"+ nameOfClass + "(" + listOfAttrNameType[index] + " value" + "){");
         	 _builder.newLineIfNotEmpty();
         	 _builder.append("        value" + listOfAttrNameType[index].toUpperCase().substring(0, 1) + listOfAttrNameType[index].substring(1) + " = "+ "value;");
         	 _builder.newLineIfNotEmpty();
//         	 for (int index2 =0; index2 <length ; index2++ ) {
//         		 if (index2 !=index) {
//        		 _builder.append("        value" + listOfAttrNameType[index2].toUpperCase().substring(0, 1) + listOfAttrNameType[index2].substring(1) + " = "+ "null;");
//         		 _builder.newLineIfNotEmpty();
//         		 }
//         	 }
     
         	 _builder.append("    }");
         	 _builder.newLine();
          }
          
          for (int index =0; index <length; index++ ) {
        	  _builder.append("    public " +listOfAttrNameType[index] + " getValue" +listOfAttrNameType[index] + "(){"  );
        	  _builder.newLineIfNotEmpty();
        	  _builder.append("      return value" + listOfAttrNameType[index] + ";");
        	  _builder.newLineIfNotEmpty();
        	  _builder.append("    }");
        	  _builder.newLineIfNotEmpty();
        	  _builder.newLine();
        	  
          }
          
         
 	 
     //}
   
          _builder.append("}");


    		return _builder.toString();
    
    }
    
    
    public Set<Type> listToSetForTypes() {
    	return new HashSet<Type>(types);
    }

	@Override
	public CharSequence contentOfMethod(Model model,Method method) {
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
    
