package com.tenxdev.jsinterop.generator.pgenerator;

import com.tenxdev.jsinterop.generator.generator.jsondocs.Documentation;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.MethodArgument;
import com.tenxdev.jsinterop.generator.model.interfaces.HasUnionReturnTypes;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XtendTemplate {
  private static final Set<String> JAVA_RESERVED_KEYWORDS = new TreeSet<String>(
    Arrays.<String>asList("abstract", "continue", "for", "new", "switch", 
      "assert", "default", "goto", "package", "synchronized", 
      "boolean", "do", "if", "private", "this", 
      "break", "double", "implements", "protected", "throw", 
      "byte", "else", "import", "public", "throws", 
      "case", "enum", "instanceof", "return", "transient", 
      "catch", "extends", "int", "short", "try", 
      "char", "final", "interface", "static", "void", 
      "class", "finally", "long", "strictfp", "volatile", 
      "const", "float", "native", "super", "while", "_"));
  
  public static final List<String> GWT_PRIMITIVE_TYPES = Arrays.<String>asList(
    "boolean", "char", "byte", "short", "int", "float", "double");
  
  public static final List<String> JAVA_PRIMITIVE_TYPES = Arrays.<String>asList(
    "boolean", "char", "byte", "short", "int", "long", "float", "double");
  
  public CharSequence copyright() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Copyright 2017 Abed Tony BenBrahim <tony.benrahim@10xdev.com>");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*     and Gwt-JElement project contributors.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Licensed under the Apache License, Version 2.0 (the \"License\"); you may not");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* use this file except in compliance with the License. You may obtain a copy of");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* the License at");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* http://www.apache.org/licenses/LICENSE-2.0");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* Unless required by applicable law or agreed to in writing, software");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* distributed under the License is distributed on an \"AS IS\" BASIS, WITHOUT");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* License for the specific language governing permissions and limitations under");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* the License.");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence imports(final String basePackageName, final AbstractDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<String> _importedPackages = definition.getImportedPackages();
      for(final String importName : _importedPackages) {
        _builder.append("import ");
        String _xifexpression = null;
        boolean _startsWith = importName.startsWith(".");
        if (_startsWith) {
          _xifexpression = basePackageName;
        } else {
          _xifexpression = "";
        }
        _builder.append(_xifexpression);
        _builder.append(importName);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public String sanitizeName(final String name) {
    return name.replace("[]", "Array    ").replaceAll("<\\.?>", "");
  }
  
  public String adjustJavaName(final String name) {
    String _xifexpression = null;
    boolean _contains = XtendTemplate.JAVA_RESERVED_KEYWORDS.contains(name);
    if (_contains) {
      _xifexpression = (name + "_");
    } else {
      _xifexpression = name;
    }
    return _xifexpression;
  }
  
  public String getCallbackMethodName(final Method method) {
    String _xifexpression = null;
    if (((method.getName() == null) || method.getName().isEmpty())) {
      _xifexpression = "callback";
    } else {
      _xifexpression = method.getName();
    }
    return _xifexpression;
  }
  
  public String unionTypeName(final Type type, final AbstractDefinition definition) {
    String _displayValue = type.displayValue();
    String _name = definition.getName();
    String _plus = (_name + ".");
    return _displayValue.replace(_plus, "");
  }
  
  public CharSequence unionTypes(final HasUnionReturnTypes definition) {
    StringConcatenation _builder = new StringConcatenation();
    {
      List<UnionType> _unionReturnTypes = definition.getUnionReturnTypes();
      for(final UnionType unionType : _unionReturnTypes) {
        {
          AbstractDefinition _owner = ((UnionType) unionType).getOwner();
          boolean _tripleEquals = (_owner == definition);
          if (_tripleEquals) {
            _builder.append("@JsType(isNative = true, name = \"?\", namespace = JsPackage.GLOBAL)");
            _builder.newLine();
            _builder.append("public interface ");
            String _name = ((UnionType) unionType).getName();
            _builder.append(_name);
            _builder.append(" {");
            _builder.newLineIfNotEmpty();
            {
              List<Type> _types = ((UnionType) unionType).getTypes();
              for(final Type type : _types) {
                _builder.append("    ");
                _builder.append("@JsOverlay");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("static ");
                String _name_1 = ((UnionType) unionType).getName();
                _builder.append(_name_1, "    ");
                _builder.append(" of(");
                String _displayValue = type.displayValue();
                _builder.append(_displayValue, "    ");
                _builder.append(" value){");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                _builder.append("return Js.cast(value);");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
              }
            }
            {
              List<Type> _types_1 = ((UnionType) unionType).getTypes();
              for(final Type type_1 : _types_1) {
                _builder.append("    ");
                _builder.append("@JsOverlay");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("default ");
                String _displayValue_1 = type_1.displayValue();
                _builder.append(_displayValue_1, "    ");
                _builder.append(" as");
                String _adjustName = this.adjustName(StringExtensions.toFirstUpper(type_1.displayValue()));
                _builder.append(_adjustName, "    ");
                _builder.append("(){");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                _builder.append("return Js.cast(this);");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
              }
            }
            {
              List<Type> _types_2 = ((UnionType) unionType).getTypes();
              for(final Type type_2 : _types_2) {
                _builder.append("    ");
                _builder.append("@JsOverlay");
                _builder.newLine();
                _builder.append("    ");
                _builder.append("default boolean is");
                String _adjustName_1 = this.adjustName(StringExtensions.toFirstUpper(type_2.displayValue()));
                _builder.append(_adjustName_1, "    ");
                _builder.append("(){");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("    ");
                _builder.append("return (Object) this instanceof ");
                String _removeGeneric = this.removeGeneric(type_2.box().displayValue());
                _builder.append(_removeGeneric, "        ");
                _builder.append(";");
                _builder.newLineIfNotEmpty();
                _builder.append("    ");
                _builder.append("}");
                _builder.newLine();
                _builder.newLine();
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
  
  public String adjustName(final String value) {
    return this.adjustArray(this.removeGeneric(value));
  }
  
  public String removeGeneric(final String value) {
    return value.replaceAll("<.*?>", "");
  }
  
  public String adjustArray(final String value) {
    return this.removeGeneric(value.replace("[]", "Array"));
  }
  
  public CharSequence javadoc(final String description) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* ");
    _builder.append(description, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    return _builder;
  }
  
  public String javadoc(final Documentation documentation, final String className, final String methodName, final List<MethodArgument> arguments) {
    final Function<String, String> _function = (String description) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* ");
      _builder.append(description, " ");
      _builder.newLineIfNotEmpty();
      {
        for(final MethodArgument argument : arguments) {
          _builder.append(" ");
          _builder.append("* @param ");
          String _name = argument.getName();
          _builder.append(_name, " ");
          _builder.append(" ");
          final Function<String, String> _function_1 = (String s) -> {
            return s;
          };
          String _orElse = documentation.getArgumentDescription(className, methodName, arguments.indexOf(argument)).<String>map(_function_1).orElse("");
          _builder.append(_orElse, " ");
          _builder.newLineIfNotEmpty();
        }
      }
      _builder.append(" ");
      _builder.append("**/");
      _builder.newLine();
      return _builder.toString();
    };
    return documentation.getMemberDescription(className, methodName).<String>map(_function).orElse("");
  }
}
