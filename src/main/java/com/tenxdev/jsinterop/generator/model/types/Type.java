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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.xtend2.lib.StringConcatenation;

import com.google.common.collect.ImmutableMap;
import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.Model;

public interface Type {

	ImmutableMap<String, Type> BOXED_TYPES = ImmutableMap.<String, Type>builder().put("void", new NativeType("Void"))
			.put("short", new NativeType("Double")).put("int", new NativeType("Double"))
			.put("long", new NativeType("Double")).put("float", new NativeType("Double"))
			.put("double", new NativeType("Double")).put("byte", new NativeType("Double"))
			.put("boolean", new NativeType("Boolean")).put("char", new NativeType("String")).build();

	String displayValue();

	String getTypeName();

	default boolean isGwtPrimitiveType() {
		return this instanceof NativeType && ("byte".equals(this.getTypeName()) || "char".equals(this.getTypeName())
				|| "short".equals(this.getTypeName()) || "int".equals(this.getTypeName())
				|| "float".equals(this.getTypeName()) || "double".equals(this.getTypeName())
				|| "boolean".equals(this.getTypeName()));

	}

	default boolean isLongPrimitiveType() {
		return this instanceof NativeType && "long".equals(this.getTypeName());
	}

	default boolean isNativeType() {
		return isGwtPrimitiveType() || isNativeType();
	}

	default Type box() {
		if (this instanceof NativeType) {
			Type boxedType = BOXED_TYPES.get(getTypeName());
			return boxedType != null ? boxedType : this;
		}
		return this;
	}

	static String[] getTypesNameOfAttrOfUnionType(UnionType type) {
		int size = type.getTypes().size();
		String[] res = new String[size];
		int index = 0;
		for (Type typeChild : type.getTypes()) {
			if (typeChild instanceof ObjectType) {
				res[index] = getTypesNameOfObjectType((ObjectType) typeChild);
			}
			if (typeChild instanceof NativeType) {
				res[index] = typeChild.getTypeName();
			}
			if (typeChild instanceof ArrayType) {
				res[index] = getTypesNameOfArrayType((ArrayType) typeChild);
			}
			index++;
		}
		return res;
	}

	static String getTypesNameOfObjectType(ObjectType type) {
		if (type.getTypeName().equals("Window")) return "PWindow2";
		return "P" + type.getTypeName();
	}

	static String getTypesNameOfArrayType(ArrayType type) {
		String typeName = type.getTypeName();
		if (type.getType() instanceof ObjectType) {
			return "P" + typeName.substring(0,typeName.length() -5) +  "[]";
		}
		if (type.getType() instanceof NativeType) {
			return typeName.replace(typeName.substring(typeName.length() -5), "[]");
		}
		if (type.getType() instanceof ArrayType) {
			return getTypesNameOfArrayType((ArrayType)type.getType()) + "[]";
		}
		if (type.getType() instanceof ParameterisedType) {
			return getTypesNameOfParameterisedType((ParameterisedType) type.getType()) + "[]";
		}
		if (type.getType() instanceof UnionType) {
			return nameModifiedOfUnionType((UnionType) type.getType()) + "[]";
		}
		return null;
	}
	
	
	static String getTypesNameOfParameterisedType(ParameterisedType type) {
		String res= type.getBaseType().displayValue()  ;
		 if (!type.getTypeParameters().isEmpty()) res = res+ "<";
		if ("PJsObject".equals(type.getBaseType().displayValue()) && type.getTypeParameters().size() == 2)  res = "Map" + "<";
		boolean _hasElements = false;
  	  for (Type typeChild: type.getTypeParameters()) {
  		 if (!_hasElements) {
	          _hasElements = true;
	        } else {
	         res = res + ",";
	        }
  		  if (typeChild instanceof ObjectType)  res = res + "P"+ typeChild.getTypeName();
  		  else if (typeChild instanceof UnionType) res = res + "P"+ ((UnionType)typeChild).getName() ;
  		  else if (typeChild instanceof NativeType) res = res + typeChild.getTypeName();
  		  else if (typeChild instanceof GenericType) res = res + ((GenericType)typeChild).getTypeName();
  		  else if (typeChild instanceof ArrayType) res = res + Type.getTypesNameOfArrayType((ArrayType) typeChild);
  		  
  	  }
  	  if (!type.getTypeParameters().isEmpty()) res = res + ">";
  	  return res;
	}

	static String nameModifiedOfUnionType(UnionType type) {
		String nameOfType = type.getName();
		StringBuffer nameOfType2 = new StringBuffer();
		if (nameOfType == null) {
			 Comparator<Type> cmp = new Comparator<Type>() {
			      public int compare(Type o1, Type o2) {
			        return o1.getTypeName().compareTo(o2.getTypeName());
			      }
			 };
			 Collections.sort(type.getTypes(), cmp);
			for (int index = 0; index < type.getTypes().size(); index++) {
				nameOfType2.append((type.getTypes().get(index).getTypeName()));
				if (index < (type.getTypes().size() - 1))
					nameOfType2.append("Or");
			}
			return "P" + nameOfType2.toString();
		}
		return "P"+ nameOfType;
	}

	static CharSequence declarationArrayType(String name, ArrayType type) {
		StringConcatenation _builder = new StringConcatenation();
		String typeName = type.getTypeName();
		if (type.getType() instanceof ObjectType) {
			_builder.append("P" + typeName.replace("Array", "[]") + " " + name + ";");
			return _builder;
		}
		if (type.getType() instanceof NativeType) {
			_builder.append(typeName.replace("Array", "[]") + " " + name + ";");
			return _builder;
		}
		return null;
	}

	static String declarationNativeType(String name, NativeType type) {
		return  type.getTypeName() + " " + name + ";";
	}

	static String declarationObjectType(String name, Type type) {
		String typeName = "P" + type.getTypeName();
		return  typeName + " " + name + ";";
	}

	static CharSequence declarationUnionType(String name, UnionType type) {
		StringConcatenation _builder = new StringConcatenation();
		for (Type typeChild : type.getTypes()) {
			if (typeChild instanceof NativeType)
				_builder.append(declarationNativeType(name + typeChild.getTypeName().substring(0, 1).toUpperCase()
						+ typeChild.getTypeName().substring(1), (NativeType) typeChild));
			if (typeChild instanceof ObjectType)
				_builder.append(declarationObjectType(name + "P" + typeChild.getTypeName().substring(0, 1).toUpperCase()
						+ typeChild.getTypeName().substring(1), (ObjectType) typeChild));
			if (typeChild instanceof ArrayType)
				_builder.append(declarationArrayType(name + typeChild.getTypeName().substring(0, 1).toUpperCase()
						+ typeChild.getTypeName().substring(1), (ArrayType) typeChild));
			_builder.newLine();
		}
		return _builder;

	}


	static String getTypesNameOfGenericType(GenericType type) {
		return type.getTypeName();
	}

	static CharSequence declarationGenericType(String name, GenericType type) {
		return  type.getTypeName() + " " + name; 
	} 
	
	public static CharSequence declarationType(String name, Type type) {
		if (type instanceof ObjectType) return Type.declarationObjectType(name,(ObjectType)type);
		if (type instanceof NativeType) return Type.declarationNativeType(name,(NativeType) type);
		if (type instanceof ArrayType) return Type.declarationArrayType(name,(ArrayType) type);
		if (type instanceof UnionType) return declarationUnionType2(name,(UnionType)type);
		if (type instanceof  GenericType) return Type.declarationGenericType(name, (GenericType)type);
		if (type instanceof ParameterisedType) return Type.getTypesNameOfParameterisedType( (ParameterisedType)type) + " " + name + ";";
		return null;
	}
	
	static String declarationUnionType2(String name, UnionType type) {
		return  Type.nameModifiedOfUnionType(type) + " " + name + ";" ;
	}
	
	public static String declarationType(Type type) {
		String res = new String();
		if (type instanceof ObjectType) {
			res = Type.getTypesNameOfObjectType((ObjectType) type);
		}
		if (type instanceof ArrayType) {
			res = Type.getTypesNameOfArrayType((ArrayType) type);
		}
		if (type instanceof NativeType) {
			res = type.getTypeName();
		}
		if (type instanceof UnionType) {
			res = Type.nameModifiedOfUnionType((UnionType) type);
		}
		if (type instanceof ParameterisedType) {
			res = Type.getTypesNameOfParameterisedType((ParameterisedType) type);
		}
		if (type instanceof GenericType) {
			res = Type.getTypesNameOfGenericType((GenericType) type);
		}
		return res;
	}
	
	public CharSequence contentOfMethod(Model model, Method method);

	public static String declarationTypeModif(Type methodType) {
		if (methodType instanceof NativeType)
			return "void";
		return Type.declarationType(methodType);
	}
	

}
