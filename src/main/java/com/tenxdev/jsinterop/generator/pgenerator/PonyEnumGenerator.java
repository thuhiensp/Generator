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

import com.tenxdev.jsinterop.generator.generator.XtendTemplate;
import com.tenxdev.jsinterop.generator.model.EnumDefinition;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PonyEnumGenerator extends XtendTemplate {
  public String generate(final String basePackageName, final EnumDefinition definition) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _copyright = this.copyright();
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
//    _builder.append("package ");
//    _builder.append(basePackageName);
//    String _packageName = definition.getPackageName();
//    _builder.append(_packageName);
//    _builder.append(";");
    _builder.append("package com.ponysdk.core.ui2;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.ponysdk.core.ui2.PEnum;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public enum ");
    String _name = definition.getName();
    _builder.append("P"+ _name + " implements PEnum ");
    _builder.append("{");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    {
      List<String> _values = definition.getValues();
      boolean _hasElements = false;
      for(final String value : _values) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",\n", "    ");
        }
        String _javaName = EnumDefinition.toJavaName(value);
        _builder.append(_javaName, "    ");
        _builder.append("(");
        _builder.append(value, "    ");
        _builder.append(")");
      }
      if (_hasElements) {
        _builder.append(";\n", "    ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("private String internalValue;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    String _name_1 = definition.getName();
    _builder.append("P"+_name_1, "    ");
    _builder.append("(String internalValue){");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("this.internalValue = internalValue;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public String getInternalValue(){");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("return this.internalValue;");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public static ");
    String _name_2 = definition.getName();
    _builder.append("P"+_name_2, "    ");
    _builder.append(" of(");
    String _displayValue = definition.getJavaElementType().displayValue();
    _builder.append(_displayValue, "    ");
    _builder.append(" value){");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("switch(value){");
    _builder.newLine();
    {
      List<String> _values_1 = definition.getValues();
      for(final String value_1 : _values_1) {
        _builder.append("            ");
        _builder.append("case ");
        _builder.append(value_1, "            ");
        _builder.append(":");
        _builder.newLineIfNotEmpty();
        _builder.append("            ");
        _builder.append("    ");
        _builder.append("return ");
        String _javaName_1 = EnumDefinition.toJavaName(value_1);
        _builder.append(_javaName_1, "                ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("            ");
    _builder.append("default:");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public static ");
    String _name_3 = definition.getName();
    _builder.append("P"+_name_3, "    ");
    _builder.append("[] ofArray(");
    String _displayValue_1 = definition.getJavaElementType().displayValue();
    _builder.append(_displayValue_1, "    ");
    _builder.append("[] values) {");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    _builder.append("return Arrays.<");
    String _displayValue_2 = definition.getJavaElementType().displayValue();
    _builder.append(_displayValue_2, "        ");
    _builder.append(">stream(values)");
    _builder.newLineIfNotEmpty();
    _builder.append("                ");
    _builder.append(".map(");
    String _name_4 = definition.getName();
    _builder.append("P"+_name_4, "                ");
    _builder.append("::of)");
    _builder.newLineIfNotEmpty();
    _builder.append("                ");
    _builder.append(".toArray(");
    String _name_5 = definition.getName();
    _builder.append("P"+_name_5, "                ");
    _builder.append("[]::new);");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}
