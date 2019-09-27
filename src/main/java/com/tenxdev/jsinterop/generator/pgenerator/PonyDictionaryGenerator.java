/**
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
package com.tenxdev.jsinterop.generator.pgenerator;

import com.tenxdev.jsinterop.generator.generator.MarginFixer;
import com.tenxdev.jsinterop.generator.generator.XtendTemplate;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.CallbackDefinition;
import com.tenxdev.jsinterop.generator.model.DictionaryDefinition;
import com.tenxdev.jsinterop.generator.model.DictionaryMember;
import com.tenxdev.jsinterop.generator.model.InterfaceDefinition;
import com.tenxdev.jsinterop.generator.model.Model;
import com.tenxdev.jsinterop.generator.model.types.ArrayType;
import com.tenxdev.jsinterop.generator.model.types.ObjectType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import com.tenxdev.jsinterop.generator.processing.TemplateFiller;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class PonyDictionaryGenerator extends XtendTemplate {
  public String generate(Model model,final String basePackageName, final DictionaryDefinition definition, final TemplateFiller templateFiller) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
//    _builder.append("package ");
//    _builder.append(basePackageName);
//    String _packageName = definition.getPackageName();
//    _builder.append(_packageName);
//    _builder.append(";");
    
    _builder.append(" package com.ponysdk.core.ui2;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    //CharSequence _imports = this.imports(basePackageName, definition);
//   CharSequence _imports = this.importDict(model,basePackageName, definition);
//    _builder.append(_imports);
//    _builder.newLineIfNotEmpty();
 
    _builder.newLine();
    _builder.append("public class ");
    String _name = definition.getName();
    _builder.append("P"+_name);
    CharSequence _generic = this.generic(definition);
    _builder.append(_generic);
    {
      Type _parent = definition.getParent();
      boolean _tripleNotEquals = (!_parent.getTypeName().equals("PObject2"));
      if (_tripleNotEquals) {
        _builder.append(" extends ");
        String _displayValue = definition.getParent().displayValue();
        _builder.append(_displayValue);
      }
    }
    
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    
//    
//	CharSequence declarationAttrs = declarationTypeOfAttribution(definition);
//	_builder.append(declarationAttrs);
//	_builder.newLineIfNotEmpty();
//	_builder.newLine();
//
//	CharSequence setAttr = setAttribution3(definition, model);
//	_builder.append(setAttr);
//	_builder.newLineIfNotEmpty();
//	
//	CharSequence getAttr = getAttribution(definition);
//	_builder.append(getAttr);
//	_builder.newLineIfNotEmpty();
	_builder.newLine();
	_builder.append("}");
	
	
	return _builder.toString();
}
  
  private CharSequence setAttribution3(DictionaryDefinition definition, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		{
			List<DictionaryMember> members = definition.getMembers();
			for (final DictionaryMember member : members) {
			
					String name = member.getNameModified();
					Type typeOfAttr = member.getType();
					String typeOfAttrNameType = null;
					typeOfAttrNameType = Type.declarationType(typeOfAttr);
					if (typeOfAttrNameType !=null) {
						_builder.append( setBodyOfAttribution(member,name, typeOfAttrNameType,model));
					}
										
				}

			

		}
		return _builder;
	}

private Object setBodyOfAttribution(DictionaryMember member, String nameArgument, String typeOfArgument, Model model) {
			StringConcatenation _builder = new StringConcatenation();
			_builder.append("    ");
			_builder.append("public void set");
			String nameOfMethode = member.getName().substring(0, 1).toUpperCase() +  member.getName().substring(1) ;
			
			_builder.append(nameOfMethode + "(final");
			_builder.append(" " + typeOfArgument + " " + nameArgument + ")"  + "{");
			_builder.newLineIfNotEmpty();
			_builder.append("       this." + nameArgument + " = " + nameArgument + ";");
			_builder.newLineIfNotEmpty();
			_builder.append("    }");
			_builder.newLineIfNotEmpty();
			return _builder;
		
}

private CharSequence getAttribution(DictionaryDefinition definition) {
	StringConcatenation _builder = new StringConcatenation();
	{
		List<DictionaryMember> members = definition.getMembers();
		for (final DictionaryMember member : members) {
				String name = member.getNameModified();
				Type typeOfAttr = member.getType();
				String typeOfAttrNameType = null;
				typeOfAttrNameType = Type.declarationType(typeOfAttr);
				if (typeOfAttrNameType !=null) {
					_builder.append( getBodyOfAttribution(member,name, typeOfAttrNameType));
				}
									

		}

	}
	return _builder;
}


private CharSequence getBodyOfAttribution(DictionaryMember member, String name, String typeOfAttrNameType) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    public " + typeOfAttrNameType + " get" + name.substring(0, 1).toUpperCase() +  name.substring(1) + "(){");
	_builder.newLineIfNotEmpty();
	_builder.append("      return " + name  + ";");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	_builder.newLine();
	return _builder.toString();
}
private String modifyName(String nameOfLeaf) {
	StringBuffer res = new StringBuffer();
	String[] r = nameOfLeaf.split("(?=\\p{Upper}\\p{Lower})");
	for (int i=0; i < r.length; i++) {
		res.append(r[i].toUpperCase() + "_");
	}
	res.deleteCharAt(res.length()-1);
	return res.toString();
}


private CharSequence declarationTypeOfAttribution(DictionaryDefinition definition) {
	  StringConcatenation _builder = new StringConcatenation();
      List<DictionaryMember> membres = definition.getMembers();
      for(final DictionaryMember member : membres) {
//    	  if (!attribute.isReadOnly() && !attribute.isStatic()) {
    		  Type type = member.getType();
    		  String name = member.getNameModified();
    		  //if (Model.getTypePrimimiteToObject().keySet().contains(name)) name = Model.getTypePrimimiteToObject().get(name);
    		_builder.append("    private " + Type.declarationType(name,type) );
    		  _builder.newLineIfNotEmpty();
//    	  }
    		 
      }
     
    
    return _builder;
}

private CharSequence importDict(Model model, String basePackageName, DictionaryDefinition definition) {

		    StringConcatenation _builder = new StringConcatenation();
//		      List<String> _importedPackages = definition.getImportedPackages();
//		      for(final String importName : _importedPackages) {
//		        String _xifexpression = null;
//		        boolean _startsWith = importName.startsWith(".");
//		        if (_startsWith) {
//		          _xifexpression = basePackageName;
//		        } else {
//		          _xifexpression = "";
//		        }
//		       int index = importName.lastIndexOf('.');
//		       String nameOfClassImport = importName.substring(index+1);
//		       _builder.append("import ");
//		        _builder.append(_xifexpression);
//		       _builder.append(importName.substring(0, index+1));
//		  if (!nameOfClassImport.equals("Map") && !nameOfClassImport.equals("Arrays")  && !importName.substring(index+1, index +2).equals("*")) _builder.append("P");
//		       _builder.append(nameOfClassImport);
//		        _builder.append(";");
//		        _builder.newLineIfNotEmpty();
//		       if (definition.setOfNamesAttrModifiable().contains(nameOfClassImport)) {
//				       _builder.append("import ");
//				        _builder.append(_xifexpression);
//				       _builder.append(importName.substring(0, index+1));
//				       if (!importName.substring(index+1, index +2).equals("*")) _builder.append("P");
//				       _builder.append(nameOfClassImport);
//				        _builder.append(";");
//				        _builder.newLineIfNotEmpty();
//		       }   
//		       }
		      if (definition.getParent().getTypeName() =="PObject2") 
		    	  _builder.append("import com.ponysdk.core.ui2.PObject2;");
		      else {
		    	  String _displayValue = definition.getParent().displayValue();
		    	  AbstractDefinition absdef = model.getDefinition(definition.getParent().getTypeName());
		    	  _builder.append("import " + basePackageName  + absdef.getPackageName() + "." + _displayValue + ";");
		      }
		    
		    return _builder;
		  }
	



public CharSequence generic(final DictionaryDefinition definition) {
    CharSequence _xifexpression = null;
    String[] _genericParameters = definition.getGenericParameters();
    boolean _tripleNotEquals = (_genericParameters != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<");
      {
        String[] _genericParameters_1 = definition.getGenericParameters();
        boolean _hasElements = false;
        for(final String p : _genericParameters_1) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          _builder.append(p);
        }
      }
      _builder.append(">");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  public String getterPrefix(final DictionaryMember member) {
    String _xifexpression = null;
    boolean _equals = "boolean".equals(member.getType().displayValue());
    if (_equals) {
      _xifexpression = "is";
    } else {
      _xifexpression = "get";
    }
    return _xifexpression;
  }
}
//{
//    List<DictionaryMember> _members = definition.getMembers();
//    for(final DictionaryMember member : _members) {
//      {
//        Type _enumSubstitutionType = member.getEnumSubstitutionType();
//        boolean _tripleNotEquals_1 = (_enumSubstitutionType != null);
//        if (_tripleNotEquals_1) {
//          {
//            Type _enumSubstitutionType_1 = member.getEnumSubstitutionType();
//            if ((_enumSubstitutionType_1 instanceof ArrayType)) {
//              _builder.append("    ");
//              //_builder.append("@JsProperty(name=\"");
//             // String _name_1 = member.getName();
//             // _builder.append("P" +_name_1, "    ");
//              //_builder.append("\")");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("private ");
//              String _displayValue_1 = member.getEnumSubstitutionType().displayValue();
//              _builder.append("P" + _displayValue_1, "    ");
//              _builder.append(" ");
//              String _adjustJavaName = this.adjustJavaName(member.getName());
//              _builder.append(_adjustJavaName, "    ");
//              _builder.append(";");
//              _builder.newLineIfNotEmpty();
//              _builder.newLine();
//            } else {
//             // _builder.append("    ");
//             // _builder.append("@JsProperty(name=\"");
//             // String _name_2 = member.getName();
//              //_builder.append("P"+_name_2, "    ");
//              //_builder.append("\")");
//              //_builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("private ");
//              String _displayValue_2 = member.getEnumSubstitutionType().displayValue();
//              if (member.getEnumSubstitutionType() instanceof ObjectType) _displayValue_2 = "P"+ _displayValue_2;
//              _builder.append(_displayValue_2, "    ");
//              _builder.append(" ");
//              String _adjustJavaName_1 = this.adjustJavaName(member.getName());
//              _builder.append(_adjustJavaName_1, "    ");
//              _builder.append(";");
//              _builder.newLineIfNotEmpty();
//              _builder.newLine();
//            }
//          }
//        } else {
//          Type _type = member.getType();
//          if ((_type instanceof UnionType)) {
//            _builder.append("private ");
//            String _unionTypeName = this.unionTypeName(member.getType(), definition);
//            _builder.append(_unionTypeName, "    ");
//            _builder.append(" ");
//            String _adjustJavaName_2 = this.adjustJavaName(member.getName());
//            _builder.append(_adjustJavaName_2, "    ");
//            _builder.append(";");
//            _builder.newLineIfNotEmpty();
//            _builder.newLine();
//          } else {
//            _builder.append("    ");
//            _builder.append("@JsProperty(name=\"");
//            String _name_4 = member.getName();
//            _builder.append(_name_4, "    ");
//            _builder.append("\")");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("private ");
//            String _displayValue_3 = member.getType().displayValue();
//            _builder.append(_displayValue_3, "    ");
//            _builder.append(" ");
//            String _adjustJavaName_3 = this.adjustJavaName(member.getName());
//            _builder.append(_adjustJavaName_3, "    ");
//            _builder.append(";");
//            _builder.newLineIfNotEmpty();
//            _builder.newLine();
//          }
//        }
//      }
//    }
//  }
//  _builder.append("    ");
//  CharSequence _unionTypes = this.unionTypes(definition);
//  _builder.append(_unionTypes, "    ");
//  _builder.newLineIfNotEmpty();
//  _builder.append("    ");
//  _builder.append("public ");
//  String _name_5 = definition.getName();
//  _builder.append(_name_5, "    ");
//  _builder.append("(){");
//  _builder.newLineIfNotEmpty();
//  _builder.append("    ");
//  _builder.append("}");
//  _builder.newLine();
//  _builder.newLine();
//  {
//    List<DictionaryMember> _members_1 = definition.getMembers();
//    for(final DictionaryMember member_1 : _members_1) {
//      {
//        Type _enumSubstitutionType_2 = member_1.getEnumSubstitutionType();
//        boolean _tripleNotEquals_2 = (_enumSubstitutionType_2 != null);
//        if (_tripleNotEquals_2) {
//          {
//            Type _enumSubstitutionType_3 = member_1.getEnumSubstitutionType();
//            if ((_enumSubstitutionType_3 instanceof ArrayType)) {
//              _builder.append("    ");
//              _builder.append("@JsOverlay");
//              _builder.newLine();
//              _builder.append("    ");
//              _builder.append("public final ");
//              String _displayValue_4 = member_1.getType().displayValue();
//              _builder.append(_displayValue_4, "    ");
//              _builder.append(" get");
//              String _firstUpper = StringExtensions.toFirstUpper(member_1.getName());
//              _builder.append(_firstUpper, "    ");
//              _builder.append("(){");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("    ");
//              _builder.append("return ");
//              Type _type_1 = member_1.getType();
//              String _displayValue_5 = ((ArrayType) _type_1).getType().displayValue();
//              _builder.append(_displayValue_5, "        ");
//              _builder.append(".ofArray(this.");
//              String _adjustJavaName_4 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_4, "        ");
//              _builder.append(");");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("}");
//              _builder.newLine();
//              _builder.newLine();
//              _builder.append("    ");
//              _builder.append("@JsOverlay");
//              _builder.newLine();
//              _builder.append("    ");
//              _builder.append("public final void set");
//              String _firstUpper_1 = StringExtensions.toFirstUpper(member_1.getName());
//              _builder.append(_firstUpper_1, "    ");
//              _builder.append("(");
//              String _displayValue_6 = member_1.getType().displayValue();
//              _builder.append(_displayValue_6, "    ");
//              _builder.append(" ");
//              String _adjustJavaName_5 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_5, "    ");
//              _builder.append("){");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("    ");
//              _builder.append("this.");
//              String _adjustJavaName_6 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_6, "        ");
//              _builder.append(" = Arrays.stream(");
//              String _adjustJavaName_7 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_7, "        ");
//              _builder.append(")");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("        ");
//              _builder.append(".map(");
//              Type _type_2 = member_1.getType();
//              String _displayValue_7 = ((ArrayType) _type_2).getType().displayValue();
//              _builder.append(_displayValue_7, "            ");
//              _builder.append("::getInternalValue)");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("        ");
//              _builder.append(".toArray(");
//              Type _enumSubstitutionType_4 = member_1.getEnumSubstitutionType();
//              String _displayValue_8 = ((ArrayType) _enumSubstitutionType_4).getType().displayValue();
//              _builder.append(_displayValue_8, "            ");
//              _builder.append("[]::new);");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("}");
//              _builder.newLine();
//              _builder.newLine();
//            } else {
//              _builder.append("    ");
//              _builder.append("@JsOverlay");
//              _builder.newLine();
//              _builder.append("    ");
//              _builder.append("public final ");
//              String _displayValue_9 = member_1.getType().displayValue();
//              _builder.append(_displayValue_9, "    ");
//              _builder.append(" get");
//              String _firstUpper_2 = StringExtensions.toFirstUpper(member_1.getName());
//              _builder.append(_firstUpper_2, "    ");
//              _builder.append("(){");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("    ");
//              _builder.append("return ");
//              String _displayValue_10 = member_1.getType().displayValue();
//              _builder.append(_displayValue_10, "        ");
//              _builder.append(".of(this.");
//              String _adjustJavaName_8 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_8, "        ");
//              _builder.append(");");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("}");
//              _builder.newLine();
//              _builder.newLine();
//              _builder.append("    ");
//              _builder.append("@JsOverlay");
//              _builder.newLine();
//              _builder.append("    ");
//              _builder.append("public final void set");
//              String _firstUpper_3 = StringExtensions.toFirstUpper(member_1.getName());
//              _builder.append(_firstUpper_3, "    ");
//              _builder.append("(");
//              String _displayValue_11 = member_1.getType().displayValue();
//              _builder.append(_displayValue_11, "    ");
//              _builder.append(" ");
//              String _adjustJavaName_9 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_9, "    ");
//              _builder.append("){");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("    ");
//              _builder.append("this.");
//              String _adjustJavaName_10 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_10, "        ");
//              _builder.append(" = ");
//              String _adjustJavaName_11 = this.adjustJavaName(member_1.getName());
//              _builder.append(_adjustJavaName_11, "        ");
//              _builder.append(".getInternalValue();");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              _builder.append("}");
//              _builder.newLine();
//              _builder.newLine();
//            }
//          }
//        } else {
//          Type _type_3 = member_1.getType();
//          if ((_type_3 instanceof UnionType)) {
//            _builder.append("    ");
//            _builder.append("@JsOverlay");
//            _builder.newLine();
//            _builder.append("    ");
//            _builder.append("public final ");
//            String _displayValue_12 = member_1.getType().displayValue();
//            _builder.append(_displayValue_12, "    ");
//            _builder.append(" get");
//            String _firstUpper_4 = StringExtensions.toFirstUpper(member_1.getName());
//            _builder.append(_firstUpper_4, "    ");
//            _builder.append("(){");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("    ");
//            _builder.append("return this.");
//            String _adjustJavaName_12 = this.adjustJavaName(member_1.getName());
//            _builder.append(_adjustJavaName_12, "        ");
//            _builder.append(";");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("}");
//            _builder.newLine();
//            _builder.newLine();
//            {
//              Type _type_4 = member_1.getType();
//              List<Type> _types = ((UnionType) _type_4).getTypes();
//              for(final Type type : _types) {
//                _builder.append("    ");
//                _builder.append("@JsOverlay");
//                _builder.newLine();
//                _builder.append("    ");
//                _builder.append("public final void set");
//                String _firstUpper_5 = StringExtensions.toFirstUpper(member_1.getName());
//                _builder.append(_firstUpper_5, "    ");
//                _builder.append("(");
//                String _displayValue_13 = type.displayValue();
//                _builder.append(_displayValue_13, "    ");
//                _builder.append(" ");
//                String _adjustJavaName_13 = this.adjustJavaName(member_1.getName());
//                _builder.append(_adjustJavaName_13, "    ");
//                _builder.append("){");
//                _builder.newLineIfNotEmpty();
//                _builder.append("    ");
//                _builder.append("    ");
//                _builder.append("this.");
//                String _adjustJavaName_14 = this.adjustJavaName(member_1.getName());
//                _builder.append(_adjustJavaName_14, "        ");
//                _builder.append(" = ");
//                String _displayValue_14 = member_1.getType().displayValue();
//                _builder.append(_displayValue_14, "        ");
//                _builder.append(".of(");
//                String _adjustJavaName_15 = this.adjustJavaName(member_1.getName());
//                _builder.append(_adjustJavaName_15, "        ");
//                _builder.append(");");
//                _builder.newLineIfNotEmpty();
//                _builder.append("    ");
//                _builder.append("}");
//                _builder.newLine();
//                _builder.newLine();
//              }
//            }
//          } else {
//            _builder.append("    ");
//            _builder.append("@JsOverlay");
//            _builder.newLine();
//            _builder.append("    ");
//            _builder.append("public final ");
//            String _displayValue_15 = member_1.getType().displayValue();
//            _builder.append(_displayValue_15, "    ");
//            _builder.append(" ");
//            String _terPrefix = this.getterPrefix(member_1);
//            _builder.append(_terPrefix, "    ");
//            String _firstUpper_6 = StringExtensions.toFirstUpper(member_1.getName());
//            _builder.append(_firstUpper_6, "    ");
//            _builder.append("(){");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("    ");
//            _builder.append("return this.");
//            String _adjustJavaName_16 = this.adjustJavaName(member_1.getName());
//            _builder.append(_adjustJavaName_16, "        ");
//            _builder.append(";");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("}");
//            _builder.newLine();
//            _builder.newLine();
//            _builder.append("    ");
//            _builder.append("@JsOverlay");
//            _builder.newLine();
//            _builder.append("    ");
//            _builder.append("public final void set");
//            String _firstUpper_7 = StringExtensions.toFirstUpper(member_1.getName());
//            _builder.append(_firstUpper_7, "    ");
//            _builder.append("(");
//            String _displayValue_16 = member_1.getType().displayValue();
//            _builder.append(_displayValue_16, "    ");
//            _builder.append(" ");
//            String _adjustJavaName_17 = this.adjustJavaName(member_1.getName());
//            _builder.append(_adjustJavaName_17, "    ");
//            _builder.append("){");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("    ");
//            _builder.append("this.");
//            String _adjustJavaName_18 = this.adjustJavaName(member_1.getName());
//            _builder.append(_adjustJavaName_18, "        ");
//            _builder.append(" = ");
//            String _adjustJavaName_19 = this.adjustJavaName(member_1.getName());
//            _builder.append(_adjustJavaName_19, "        ");
//            _builder.append(";");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            _builder.append("}");
//            _builder.newLine();
//            _builder.newLine();
//          }
//        }
//      }
//    }
//  }
//  _builder.newLine();
//  _builder.append("    ");
//  String _fix = MarginFixer.INSTANCE.fix(templateFiller.fill(definition, basePackageName));
//  _builder.append(_fix, "    ");
//  _builder.newLineIfNotEmpty();
//  _builder.append("}");
//  _builder.newLine();
//  return _builder.toString();
