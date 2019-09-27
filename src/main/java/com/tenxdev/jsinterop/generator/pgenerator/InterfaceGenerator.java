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
import com.tenxdev.jsinterop.generator.generator.jsondocs.Documentation;
import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.Constant;
import com.tenxdev.jsinterop.generator.model.Constructor;
import com.tenxdev.jsinterop.generator.model.InterfaceDefinition;
import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.MethodArgument;
import com.tenxdev.jsinterop.generator.model.types.ArrayType;
import com.tenxdev.jsinterop.generator.model.types.NativeType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import com.tenxdev.jsinterop.generator.processing.TemplateFiller;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class InterfaceGenerator extends XtendTemplate {
  private Documentation documentation;
  
  public InterfaceGenerator(final Documentation documentation) {
    this.documentation = documentation;
  }
  
  public String generate(final String basePackageName, final InterfaceDefinition definition, final TemplateFiller templateFiller) {
    Collections.<Method>sort(definition.getMethods());
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.append("package ");
    _builder.append(basePackageName);
    String _packageName = definition.getPackageName();
    _builder.append(_packageName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _imports = this.imports(basePackageName, definition);
    _builder.append(_imports);
    _builder.newLineIfNotEmpty();
    final Function<String, CharSequence> _function = (String description) -> {
      return this.javadoc(description);
    };
    CharSequence _orElse = this.documentation.getClassDescription(definition.getName()).<CharSequence>map(_function).orElse("");
    _builder.append(_orElse);
    _builder.newLineIfNotEmpty();
    _builder.append("@JsType(namespace = JsPackage.GLOBAL, name=\"");
    String _jsTypeName = definition.getJsTypeName();
    _builder.append(_jsTypeName);
    _builder.append("\", isNative = true)");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    String _adjustJavaName = this.adjustJavaName(definition.getName());
    _builder.append(_adjustJavaName);
    CharSequence _generic = this.generic(definition);
    _builder.append(_generic);
    String _extendsClass = this.extendsClass(definition);
    _builder.append(_extendsClass);
    String _implementsInterfaces = this.implementsInterfaces(definition);
    _builder.append(_implementsInterfaces);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _constants = this.constants(definition);
    _builder.append(_constants, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _unionTypes = this.unionTypes(definition);
    _builder.append(_unionTypes, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _fields = this.fields(definition);
    _builder.append(_fields, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _constructors = this.constructors(definition);
    _builder.append(_constructors, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _nonFieldAttributes = this.nonFieldAttributes(definition);
    _builder.append(_nonFieldAttributes, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _methods = this.methods(definition);
    _builder.append(_methods, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    String _fix = MarginFixer.INSTANCE.fix(templateFiller.fill(definition, basePackageName));
    _builder.append(_fix, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String extendsClass(final InterfaceDefinition definition) {
    String _xifexpression = null;
    Type _parent = definition.getParent();
    boolean _tripleNotEquals = (_parent != null);
    if (_tripleNotEquals) {
      String _displayValue = definition.getParent().displayValue();
      _xifexpression = (" extends " + _displayValue);
    }
    return _xifexpression;
  }
  
  public String implementsInterfaces(final InterfaceDefinition definition) {
    String _xifexpression = null;
    boolean _isEmpty = definition.getImplementedInterfaces().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function<Type, String> _function = (Type type) -> {
        return type.displayValue();
      };
      _xifexpression = definition.getImplementedInterfaces().stream().<String>map(_function).collect(Collectors.joining(", ", " implements ", ""));
    }
    return _xifexpression;
  }
  
  public CharSequence constants(final InterfaceDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Constant> _constants = definition.getConstants();
      boolean _hasElements = false;
      for(final Constant constant : _constants) {
        if (!_hasElements) {
          _hasElements = true;
        }
        _builder.append("public static ");
        String _displayValue = constant.getType().displayValue();
        _builder.append(_displayValue);
        _builder.append(" ");
        String _name = constant.getName();
        _builder.append(_name);
        _builder.append("; /* ");
        String _value = constant.getValue();
        _builder.append(_value);
        _builder.append(" */");
        _builder.newLineIfNotEmpty();
      }
      if (_hasElements) {
        _builder.append("\n");
      }
    }
    return _builder;
  }
  
  public CharSequence constructors(final InterfaceDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Constructor> _constructors = definition.getConstructors();
      for(final Constructor constructor : _constructors) {
        {
          boolean _isHidden = constructor.isHidden();
          if (_isHidden) {
            _builder.append("private ");
            String _name = definition.getName();
            _builder.append(_name);
            _builder.append("(");
            CharSequence _arguments = this.arguments(constructor);
            _builder.append(_arguments);
            _builder.append("){");
            _builder.newLineIfNotEmpty();
            {
              Type _parent = definition.getParent();
              boolean _tripleNotEquals = (_parent != null);
              if (_tripleNotEquals) {
                _builder.append("    ");
                _builder.append("super(");
                CharSequence _superArguments = this.superArguments(constructor);
                _builder.append(_superArguments, "    ");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
            _builder.newLine();
          } else {
            String _safeVarArgs = this.safeVarArgs(constructor);
            _builder.append(_safeVarArgs);
            _builder.newLineIfNotEmpty();
            _builder.append("@JsConstructor");
            _builder.newLine();
            _builder.append("public ");
            String _name_1 = definition.getName();
            _builder.append(_name_1);
            _builder.append("(");
            CharSequence _arguments_1 = this.arguments(constructor);
            _builder.append(_arguments_1);
            _builder.append("){");
            _builder.newLineIfNotEmpty();
            {
              Type _parent_1 = definition.getParent();
              boolean _tripleNotEquals_1 = (_parent_1 != null);
              if (_tripleNotEquals_1) {
                _builder.append("    ");
                _builder.append("super(");
                CharSequence _superArguments_1 = this.superArguments(constructor);
                _builder.append(_superArguments_1, "    ");
                _builder.append(");");
                _builder.newLineIfNotEmpty();
              }
            }
            _builder.append("}");
            _builder.newLine();
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence fields(final InterfaceDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _attributes = definition.getAttributes();
      for(final Attribute attribute : _attributes) {
        {
          Type _enumSubstitutionType = attribute.getEnumSubstitutionType();
          boolean _tripleNotEquals = (_enumSubstitutionType != null);
          if (_tripleNotEquals) {
            String _checkDeprecated = this.checkDeprecated(attribute);
            _builder.append(_checkDeprecated);
            _builder.newLineIfNotEmpty();
            _builder.append("@JsProperty(name=\"");
            String _name = attribute.getName();
            _builder.append(_name);
            _builder.append("\")");
            _builder.newLineIfNotEmpty();
            _builder.append("private ");
            String _staticModifier = this.staticModifier(attribute);
            _builder.append(_staticModifier);
            String _displayValue = attribute.getEnumSubstitutionType().displayValue();
            _builder.append(_displayValue);
            _builder.append(" ");
            String _adjustJavaName = this.adjustJavaName(attribute.getName());
            _builder.append(_adjustJavaName);
            _builder.append(";");
            _builder.newLineIfNotEmpty();
            _builder.newLine();
          } else {
            Type _type = attribute.getType();
            if ((_type instanceof UnionType)) {
              String _checkDeprecated_1 = this.checkDeprecated(attribute);
              _builder.append(_checkDeprecated_1);
              _builder.newLineIfNotEmpty();
              _builder.append("@JsProperty(name=\"");
              String _name_1 = attribute.getName();
              _builder.append(_name_1);
              _builder.append("\")");
              _builder.newLineIfNotEmpty();
              _builder.append("private ");
              String _staticModifier_1 = this.staticModifier(attribute);
              _builder.append(_staticModifier_1);
              String _unionTypeName = this.unionTypeName(attribute.getType(), definition);
              _builder.append(_unionTypeName);
              _builder.append(" ");
              String _adjustJavaName_1 = this.adjustJavaName(attribute.getName());
              _builder.append(_adjustJavaName_1);
              _builder.append(";");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
            } else {
              boolean _isStatic = attribute.isStatic();
              if (_isStatic) {
                String _checkDeprecated_2 = this.checkDeprecated(attribute);
                _builder.append(_checkDeprecated_2);
                _builder.newLineIfNotEmpty();
                _builder.append("@JsProperty(name=\"");
                String _jsPropertyName = attribute.getJsPropertyName();
                _builder.append(_jsPropertyName);
                _builder.append("\")");
                _builder.newLineIfNotEmpty();
                _builder.append("public static ");
                String _displayValue_1 = attribute.getType().displayValue();
                _builder.append(_displayValue_1);
                _builder.append(" ");
                String _adjustJavaName_2 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_2);
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.newLine();
              } else {
                boolean _eventHandler = this.eventHandler(attribute);
                if (_eventHandler) {
                  String _checkDeprecated_3 = this.checkDeprecated(attribute);
                  _builder.append(_checkDeprecated_3);
                  _builder.newLineIfNotEmpty();
                  _builder.append("@JsProperty(name=\"");
                  String _name_2 = attribute.getName();
                  _builder.append(_name_2);
                  _builder.append("\")");
                  _builder.newLineIfNotEmpty();
                  _builder.append("private ");
                  String _staticModifier_2 = this.staticModifier(attribute);
                  _builder.append(_staticModifier_2);
                  String _displayValue_2 = attribute.getType().displayValue();
                  _builder.append(_displayValue_2);
                  _builder.append(" ");
                  String _adjustJavaName_3 = this.adjustJavaName(attribute.getName());
                  _builder.append(_adjustJavaName_3);
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.newLine();
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence nonFieldAttributes(final InterfaceDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> _attributes = definition.getAttributes();
      for(final Attribute attribute : _attributes) {
        {
          Type _enumSubstitutionType = attribute.getEnumSubstitutionType();
          boolean _tripleNotEquals = (_enumSubstitutionType != null);
          if (_tripleNotEquals) {
            {
              boolean _isWriteOnly = attribute.isWriteOnly();
              boolean _not = (!_isWriteOnly);
              if (_not) {
                {
                  Type _type = attribute.getType();
                  if ((_type instanceof ArrayType)) {
                    String _checkDeprecated = this.checkDeprecated(attribute);
                    _builder.append(_checkDeprecated);
                    _builder.newLineIfNotEmpty();
                    _builder.append("@JsOverlay");
                    _builder.newLine();
                    _builder.append("public final ");
                    String _staticModifier = this.staticModifier(attribute);
                    _builder.append(_staticModifier);
                    String _displayValue = attribute.getType().displayValue();
                    _builder.append(_displayValue);
                    _builder.append(" get");
                    String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
                    _builder.append(_firstUpper);
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("   ");
                    _builder.append("return ");
                    String _replace = attribute.getType().displayValue().replace("[]", "");
                    _builder.append(_replace, "   ");
                    _builder.append(".ofArray(");
                    String _adjustJavaName = this.adjustJavaName(attribute.getName());
                    _builder.append(_adjustJavaName, "   ");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.newLine();
                  } else {
                    String _checkDeprecated_1 = this.checkDeprecated(attribute);
                    _builder.append(_checkDeprecated_1);
                    _builder.newLineIfNotEmpty();
                    _builder.append("@JsOverlay");
                    _builder.newLine();
                    _builder.append("public final ");
                    String _staticModifier_1 = this.staticModifier(attribute);
                    _builder.append(_staticModifier_1);
                    String _displayValue_1 = attribute.getType().displayValue();
                    _builder.append(_displayValue_1);
                    _builder.append(" get");
                    String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName());
                    _builder.append(_firstUpper_1);
                    _builder.append("(){");
                    _builder.newLineIfNotEmpty();
                    _builder.append("   ");
                    _builder.append("return ");
                    String _displayValue_2 = attribute.getType().displayValue();
                    _builder.append(_displayValue_2, "   ");
                    _builder.append(".of(");
                    String _adjustJavaName_1 = this.adjustJavaName(attribute.getName());
                    _builder.append(_adjustJavaName_1, "   ");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    _builder.newLine();
                  }
                }
              }
            }
            {
              boolean _isReadOnly = attribute.isReadOnly();
              boolean _not_1 = (!_isReadOnly);
              if (_not_1) {
                String _checkDeprecated_2 = this.checkDeprecated(attribute);
                _builder.append(_checkDeprecated_2);
                _builder.newLineIfNotEmpty();
                _builder.append("@JsOverlay");
                _builder.newLine();
                _builder.append("public final ");
                String _staticModifier_2 = this.staticModifier(attribute);
                _builder.append(_staticModifier_2);
                _builder.append("void set");
                String _firstUpper_2 = StringExtensions.toFirstUpper(attribute.getName());
                _builder.append(_firstUpper_2);
                _builder.append("(");
                String _displayValue_3 = attribute.getType().displayValue();
                _builder.append(_displayValue_3);
                _builder.append(" ");
                String _adjustJavaName_2 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_2);
                _builder.append("){");
                _builder.newLineIfNotEmpty();
                _builder.append("   ");
                String _staticThis = this.staticThis(attribute);
                _builder.append(_staticThis, "   ");
                _builder.append(".");
                String _adjustJavaName_3 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_3, "   ");
                _builder.append(" = ");
                String _adjustJavaName_4 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_4, "   ");
                _builder.append(".getInternalValue();");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
              }
            }
          } else {
            Type _type_1 = attribute.getType();
            if ((_type_1 instanceof UnionType)) {
              {
                boolean _isWriteOnly_1 = attribute.isWriteOnly();
                boolean _not_2 = (!_isWriteOnly_1);
                if (_not_2) {
                  String _checkDeprecated_3 = this.checkDeprecated(attribute);
                  _builder.append(_checkDeprecated_3);
                  _builder.newLineIfNotEmpty();
                  _builder.append("@JsOverlay");
                  _builder.newLine();
                  _builder.append("public ");
                  String _staticModifier_3 = this.staticModifier(attribute);
                  _builder.append(_staticModifier_3);
                  _builder.append("final ");
                  String _unionTypeName = this.unionTypeName(attribute.getType(), definition);
                  _builder.append(_unionTypeName);
                  _builder.append(" get");
                  String _firstUpper_3 = StringExtensions.toFirstUpper(attribute.getName());
                  _builder.append(_firstUpper_3);
                  _builder.append("(){");
                  _builder.newLineIfNotEmpty();
                  _builder.append("    ");
                  _builder.append("return ");
                  String _staticThis_1 = this.staticThis(attribute);
                  _builder.append(_staticThis_1, "    ");
                  _builder.append(".");
                  String _adjustJavaName_5 = this.adjustJavaName(attribute.getName());
                  _builder.append(_adjustJavaName_5, "    ");
                  _builder.append(";");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                  _builder.newLine();
                }
              }
              {
                boolean _isReadOnly_1 = attribute.isReadOnly();
                boolean _not_3 = (!_isReadOnly_1);
                if (_not_3) {
                  {
                    Type _type_2 = attribute.getType();
                    List<Type> _types = ((UnionType) _type_2).getTypes();
                    for(final Type type : _types) {
                      String _checkDeprecated_4 = this.checkDeprecated(attribute);
                      _builder.append(_checkDeprecated_4);
                      _builder.newLineIfNotEmpty();
                      _builder.append("@JsOverlay");
                      _builder.newLine();
                      _builder.append("public ");
                      String _staticModifier_4 = this.staticModifier(attribute);
                      _builder.append(_staticModifier_4);
                      _builder.append("final void set");
                      String _firstUpper_4 = StringExtensions.toFirstUpper(attribute.getName());
                      _builder.append(_firstUpper_4);
                      _builder.append("(");
                      String _displayValue_4 = type.displayValue();
                      _builder.append(_displayValue_4);
                      _builder.append(" ");
                      String _adjustJavaName_6 = this.adjustJavaName(attribute.getName());
                      _builder.append(_adjustJavaName_6);
                      _builder.append("){");
                      _builder.newLineIfNotEmpty();
                      _builder.append("    ");
                      String _staticThis_2 = this.staticThis(attribute);
                      _builder.append(_staticThis_2, "    ");
                      _builder.append(".");
                      String _adjustJavaName_7 = this.adjustJavaName(attribute.getName());
                      _builder.append(_adjustJavaName_7, "    ");
                      _builder.append(" = ");
                      String _displayValue_5 = attribute.getType().displayValue();
                      _builder.append(_displayValue_5, "    ");
                      _builder.append(".of(");
                      String _adjustJavaName_8 = this.adjustJavaName(attribute.getName());
                      _builder.append(_adjustJavaName_8, "    ");
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                      _builder.append("}");
                      _builder.newLine();
                      _builder.newLine();
                    }
                  }
                }
              }
            } else {
              boolean _eventHandler = this.eventHandler(attribute);
              if (_eventHandler) {
                String _checkDeprecated_5 = this.checkDeprecated(attribute);
                _builder.append(_checkDeprecated_5);
                _builder.newLineIfNotEmpty();
                _builder.append("@JsOverlay");
                _builder.newLine();
                _builder.append("public ");
                String _staticModifier_5 = this.staticModifier(attribute);
                _builder.append(_staticModifier_5);
                _builder.append("final ");
                String _displayValue_6 = attribute.getType().displayValue();
                _builder.append(_displayValue_6);
                _builder.append(" get");
                String _eventHandlerName = this.eventHandlerName(attribute);
                _builder.append(_eventHandlerName);
                _builder.append("(){");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("return ");
                String _staticThis_3 = this.staticThis(attribute);
                _builder.append(_staticThis_3, "    ");
                _builder.append(".");
                String _adjustJavaName_9 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_9, "    ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
                String _checkDeprecated_6 = this.checkDeprecated(attribute);
                _builder.append(_checkDeprecated_6);
                _builder.newLineIfNotEmpty();
                _builder.append("@JsOverlay");
                _builder.newLine();
                _builder.append("public ");
                String _staticModifier_6 = this.staticModifier(attribute);
                _builder.append(_staticModifier_6);
                _builder.append("final void set");
                String _eventHandlerName_1 = this.eventHandlerName(attribute);
                _builder.append(_eventHandlerName_1);
                _builder.append("(");
                String _displayValue_7 = attribute.getType().displayValue();
                _builder.append(_displayValue_7);
                _builder.append(" ");
                String _adjustJavaName_10 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_10);
                _builder.append("){");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                String _staticThis_4 = this.staticThis(attribute);
                _builder.append(_staticThis_4, "    ");
                _builder.append(".");
                String _adjustJavaName_11 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_11, "    ");
                _builder.append(" = ");
                String _adjustJavaName_12 = this.adjustJavaName(attribute.getName());
                _builder.append(_adjustJavaName_12, "    ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
              } else {
                boolean _isStatic = attribute.isStatic();
                boolean _not_4 = (!_isStatic);
                if (_not_4) {
                  {
                    boolean _isWriteOnly_2 = attribute.isWriteOnly();
                    boolean _not_5 = (!_isWriteOnly_2);
                    if (_not_5) {
                      String _checkDeprecated_7 = this.checkDeprecated(attribute);
                      _builder.append(_checkDeprecated_7);
                      _builder.newLineIfNotEmpty();
                      _builder.append("@JsProperty(name=\"");
                      String _name = attribute.getName();
                      _builder.append(_name);
                      _builder.append("\")");
                      _builder.newLineIfNotEmpty();
                      _builder.append("public ");
                      String _staticModifier_7 = this.staticModifier(attribute);
                      _builder.append(_staticModifier_7);
                      _builder.append("native ");
                      String _displayValue_8 = attribute.getType().displayValue();
                      _builder.append(_displayValue_8);
                      _builder.append(" ");
                      String _terPrefix = this.getterPrefix(attribute);
                      _builder.append(_terPrefix);
                      String _firstUpper_5 = StringExtensions.toFirstUpper(attribute.getName());
                      _builder.append(_firstUpper_5);
                      _builder.append("();");
                      _builder.newLineIfNotEmpty();
                      _builder.newLine();
                    }
                  }
                  {
                    boolean _isReadOnly_2 = attribute.isReadOnly();
                    boolean _not_6 = (!_isReadOnly_2);
                    if (_not_6) {
                      String _checkDeprecated_8 = this.checkDeprecated(attribute);
                      _builder.append(_checkDeprecated_8);
                      _builder.newLineIfNotEmpty();
                      _builder.append("@JsProperty(name=\"");
                      String _name_1 = attribute.getName();
                      _builder.append(_name_1);
                      _builder.append("\")");
                      _builder.newLineIfNotEmpty();
                      _builder.append("public ");
                      String _staticModifier_8 = this.staticModifier(attribute);
                      _builder.append(_staticModifier_8);
                      _builder.append("native void set");
                      String _firstUpper_6 = StringExtensions.toFirstUpper(attribute.getName());
                      _builder.append(_firstUpper_6);
                      _builder.append("(");
                      String _displayValue_9 = attribute.getType().displayValue();
                      _builder.append(_displayValue_9);
                      _builder.append(" ");
                      String _adjustJavaName_13 = this.adjustJavaName(attribute.getName());
                      _builder.append(_adjustJavaName_13);
                      _builder.append(");");
                      _builder.newLineIfNotEmpty();
                      _builder.newLine();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence methods(final InterfaceDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Method> _methods = definition.getMethods();
      for(final Method method : _methods) {
        String _javadoc = this.javadoc(this.documentation, definition.getName(), method.getName(), method.getArguments());
        _builder.append(_javadoc);
        _builder.newLineIfNotEmpty();
        {
          String _body = method.getBody();
          boolean _tripleNotEquals = (_body != null);
          if (_tripleNotEquals) {
            String _safeVarArgs = this.safeVarArgs(method);
            _builder.append(_safeVarArgs);
            _builder.newLineIfNotEmpty();
            String _checkDeprecated = this.checkDeprecated(method);
            _builder.append(_checkDeprecated);
            _builder.newLineIfNotEmpty();
            _builder.append("@JsOverlay");
            _builder.newLine();
            _builder.append("public ");
            String _staticModifier = this.staticModifier(method);
            _builder.append(_staticModifier);
            _builder.append("final ");
            CharSequence _typeSpecifier = this.typeSpecifier(method);
            _builder.append(_typeSpecifier);
            String _displayValue = method.getReturnType().displayValue();
            _builder.append(_displayValue);
            _builder.append(" ");
            String _adjustJavaName = this.adjustJavaName(method.getJavaName());
            _builder.append(_adjustJavaName);
            _builder.append("(");
            CharSequence _arguments = this.arguments(method);
            _builder.append(_arguments);
            _builder.append("){");
            _builder.newLineIfNotEmpty();
            _builder.append("    ");
            String _replace = method.getBody().replace("$RETURN_TYPE", method.getReturnType().displayValue());
            _builder.append(_replace, "    ");
            _builder.newLineIfNotEmpty();
            _builder.append("}");
            _builder.newLine();
            _builder.newLine();
          } else {
            Method _enumOverlay = method.getEnumOverlay();
            boolean _tripleEquals = (_enumOverlay == null);
            if (_tripleEquals) {
              String _safeVarArgs_1 = this.safeVarArgs(method);
              _builder.append(_safeVarArgs_1);
              _builder.newLineIfNotEmpty();
              String _checkDeprecated_1 = this.checkDeprecated(method);
              _builder.append(_checkDeprecated_1);
              _builder.newLineIfNotEmpty();
              _builder.append("@JsMethod(name = \"");
              String _name = method.getName();
              _builder.append(_name);
              _builder.append("\")");
              _builder.newLineIfNotEmpty();
              _builder.append("public ");
              String _staticModifier_1 = this.staticModifier(method);
              _builder.append(_staticModifier_1);
              String _safeVarArgsFinal = this.safeVarArgsFinal(method);
              _builder.append(_safeVarArgsFinal);
              _builder.append("native ");
              CharSequence _typeSpecifier_1 = this.typeSpecifier(method);
              _builder.append(_typeSpecifier_1);
              String _displayValue_1 = method.getReturnType().displayValue();
              _builder.append(_displayValue_1);
              _builder.append(" ");
              String _adjustJavaName_1 = this.adjustJavaName(method.getJavaName());
              _builder.append(_adjustJavaName_1);
              _builder.append("(");
              CharSequence _arguments_1 = this.arguments(method);
              _builder.append(_arguments_1);
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.newLine();
            } else {
              String _safeVarArgs_2 = this.safeVarArgs(method);
              _builder.append(_safeVarArgs_2);
              _builder.newLineIfNotEmpty();
              String _checkDeprecated_2 = this.checkDeprecated(method);
              _builder.append(_checkDeprecated_2);
              _builder.newLineIfNotEmpty();
              _builder.append("@JsOverlay");
              _builder.newLine();
              _builder.append("public ");
              String _staticModifier_2 = this.staticModifier(method);
              _builder.append(_staticModifier_2);
              _builder.append("final ");
              CharSequence _typeSpecifier_2 = this.typeSpecifier(method);
              _builder.append(_typeSpecifier_2);
              String _displayValue_2 = method.getReturnType().displayValue();
              _builder.append(_displayValue_2);
              _builder.append(" ");
              String _adjustJavaName_2 = this.adjustJavaName(method.getJavaName());
              _builder.append(_adjustJavaName_2);
              _builder.append("(");
              CharSequence _arguments_2 = this.arguments(method);
              _builder.append(_arguments_2);
              _builder.append("){");
              _builder.newLineIfNotEmpty();
              _builder.append("    ");
              String _hasReturn = this.hasReturn(method);
              _builder.append(_hasReturn, "    ");
              CharSequence _hasEnumReturnType = this.hasEnumReturnType(method);
              _builder.append(_hasEnumReturnType, "    ");
              String _javaName = method.getEnumOverlay().getJavaName();
              _builder.append(_javaName, "    ");
              _builder.append("(");
              CharSequence _enumMethodArguments = this.enumMethodArguments(method);
              _builder.append(_enumMethodArguments, "    ");
              _builder.append(");");
              _builder.newLineIfNotEmpty();
              _builder.append("}");
              _builder.newLine();
              _builder.newLine();
            }
          }
        }
      }
    }
    return _builder;
  }
  
  public String enumMethodArgument(final MethodArgument argument) {
    String _xifexpression = null;
    boolean _isEnumSubstitution = argument.isEnumSubstitution();
    if (_isEnumSubstitution) {
      String _name = argument.getName();
      _xifexpression = (_name + ".getInternalValue()");
    } else {
      _xifexpression = argument.getName();
    }
    return _xifexpression;
  }
  
  public boolean hasReturnType(final Method method) {
    return (!((method.getReturnType() instanceof NativeType) && (((NativeType) method.getReturnType()).getTypeName() == "void")));
  }
  
  public String staticThis(final Attribute attribute) {
    String _xifexpression = null;
    boolean _isStatic = attribute.isStatic();
    if (_isStatic) {
      _xifexpression = attribute.getType().displayValue();
    } else {
      _xifexpression = "this";
    }
    return _xifexpression;
  }
  
  public String vararg(final MethodArgument argument) {
    String _xifexpression = null;
    boolean _isVararg = argument.isVararg();
    if (_isVararg) {
      _xifexpression = "...";
    }
    return _xifexpression;
  }
  
  public String staticModifier(final Attribute attribute) {
    String _xifexpression = null;
    boolean _isStatic = attribute.isStatic();
    if (_isStatic) {
      _xifexpression = "static ";
    }
    return _xifexpression;
  }
  
  public String staticModifier(final Method method) {
    String _xifexpression = null;
    boolean _isStatic = method.isStatic();
    if (_isStatic) {
      _xifexpression = "static ";
    }
    return _xifexpression;
  }
  
  public String hasReturn(final Method method) {
    String _xifexpression = null;
    boolean _hasReturnType = this.hasReturnType(method);
    if (_hasReturnType) {
      _xifexpression = "return ";
    }
    return _xifexpression;
  }
  
  public CharSequence hasEnumReturnType(final Method method) {
    CharSequence _xifexpression = null;
    boolean _isEnumReturnType = method.isEnumReturnType();
    if (_isEnumReturnType) {
      StringConcatenation _builder = new StringConcatenation();
      String _displayValue = method.getReturnType().displayValue();
      _builder.append(_displayValue);
      _builder.append(".of(");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  public CharSequence arguments(final Method method) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<MethodArgument> _arguments = method.getArguments();
      boolean _hasElements = false;
      for(final MethodArgument argument : _arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _displayValue = argument.getType().displayValue();
        _builder.append(_displayValue);
        String _vararg = this.vararg(argument);
        _builder.append(_vararg);
        _builder.append(" ");
        String _adjustJavaName = this.adjustJavaName(argument.getName());
        _builder.append(_adjustJavaName);
      }
    }
    return _builder;
  }
  
  public CharSequence argumentNames(final Method method) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<MethodArgument> _arguments = method.getArguments();
      boolean _hasElements = false;
      for(final MethodArgument argument : _arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _adjustJavaName = this.adjustJavaName(argument.getName());
        _builder.append(_adjustJavaName);
      }
    }
    return _builder;
  }
  
  public CharSequence enumMethodArguments(final Method method) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<MethodArgument> _arguments = method.getEnumOverlay().getArguments();
      boolean _hasElements = false;
      for(final MethodArgument argument : _arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _enumMethodArgument = this.enumMethodArgument(argument);
        _builder.append(_enumMethodArgument);
      }
    }
    {
      boolean _isEnumReturnType = method.isEnumReturnType();
      if (_isEnumReturnType) {
        _builder.append(")");
      }
    }
    return _builder;
  }
  
  public CharSequence superArguments(final Constructor constructor) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<MethodArgument> _superArguments = constructor.getSuperArguments();
      boolean _hasElements = false;
      for(final MethodArgument argument : _superArguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append("(");
        String _displayValue = argument.getType().displayValue();
        _builder.append(_displayValue);
        _builder.append(") null");
      }
    }
    return _builder;
  }
  
  public boolean eventHandler(final Attribute attribute) {
    return (attribute.getName().startsWith("on") && attribute.getType().displayValue().startsWith("EventHandler"));
  }
  
  public String eventHandlerName(final Attribute attribute) {
    String _firstUpper = StringExtensions.toFirstUpper(attribute.getName().substring(0, 2));
    String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName().substring(2));
    return (_firstUpper + _firstUpper_1);
  }
  
  public String checkDeprecated(final Attribute attribute) {
    String _xifexpression = null;
    boolean _isDeprecated = attribute.isDeprecated();
    if (_isDeprecated) {
      _xifexpression = "@Deprecated\n";
    }
    return _xifexpression;
  }
  
  public String checkDeprecated(final Method method) {
    String _xifexpression = null;
    boolean _isDeprecated = method.isDeprecated();
    if (_isDeprecated) {
      _xifexpression = "@Deprecated\n";
    }
    return _xifexpression;
  }
  
  public CharSequence generic(final InterfaceDefinition definition) {
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
  
  public CharSequence typeSpecifier(final Method method) {
    CharSequence _xifexpression = null;
    String _genericTypeSpecifiers = method.getGenericTypeSpecifiers();
    boolean _tripleNotEquals = (_genericTypeSpecifiers != null);
    if (_tripleNotEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<");
      String _genericTypeSpecifiers_1 = method.getGenericTypeSpecifiers();
      _builder.append(_genericTypeSpecifiers_1);
      _builder.append("> ");
      _xifexpression = _builder;
    }
    return _xifexpression;
  }
  
  public String safeVarArgs(final Method method) {
    String _xifexpression = null;
    boolean _needsSafeVararg = method.needsSafeVararg();
    if (_needsSafeVararg) {
      _xifexpression = "@SafeVarargs";
    }
    return _xifexpression;
  }
  
  public String safeVarArgsFinal(final Method method) {
    String _xifexpression = null;
    if (((!method.isStatic()) && method.needsSafeVararg())) {
      _xifexpression = "final ";
    }
    return _xifexpression;
  }
  
  public String getterPrefix(final Attribute attribute) {
    String _xifexpression = null;
    boolean _equals = "boolean".equals(attribute.getType().displayValue());
    if (_equals) {
      _xifexpression = "is";
    } else {
      _xifexpression = "get";
    }
    return _xifexpression;
  }
}
