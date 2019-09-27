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

import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.generator.XtendTemplate;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.CallbackDefinition;
import com.tenxdev.jsinterop.generator.model.MethodArgument;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PonyCallbackGenerator extends XtendTemplate {
  public String generate(final String basePackageName, final CallbackDefinition definition) {
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
//    _builder.append("import jsinterop.annotations.JsFunction;");
//    _builder.newLine();
//    {
//      List<String> _importedPackages = definition.getImportedPackages();
//      for(final String importName : _importedPackages) {
//        _builder.append("import ");
//        String _xifexpression = null;
//        boolean _startsWith = importName.startsWith(".");
//        if (_startsWith) {
//          _xifexpression = basePackageName;
//        } else {
//          _xifexpression = "";
//        }
//        _builder.append(_xifexpression);
//        _builder.append(importName);
//        _builder.append(";");
//        _builder.newLineIfNotEmpty();
//      }
//    }
    
    CharSequence _importPObject2 = "import com.ponysdk.core.ui2.PCallBack;";
    _builder.append(_importPObject2);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    
//    CharSequence _imports = this.imports(basePackageName, definition);
//    _builder.append(_imports);
//    _builder.newLineIfNotEmpty();
//    
//    _builder.newLine();
//    _builder.append("@JsFunction");
//    _builder.newLine();
    _builder.append("public interface ");
    String _name = definition.getName();
    _builder.append("P" + _name);
    CharSequence _generic = this.generic(definition);
    _builder.append(_generic);
    _builder.append(" extends PCallBack");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    //String _displayValue = definition.getMethod().getReturnType().displayValue();//to get the type of methode.
     String _displayValue = "void";
    _builder.append(_displayValue, "    ");
    _builder.append(" ");
    String _callbackMethodName = this.getCallbackMethodName(definition.getMethod());
    _builder.append(_callbackMethodName, "    ");
    _builder.append("(");
    {
      List<MethodArgument> _arguments = definition.getMethod().getArguments();
      boolean _hasElements = false;
      for(final MethodArgument argument : _arguments) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "    ");
        }
        String _displayValue_1 = Type.declarationType(argument.getType());
        _builder.append(_displayValue_1, "    ");
        String _vararg = this.vararg(argument);
        _builder.append(_vararg, "    ");
        _builder.append(" ");
        String _name_1 = argument.getName();
        _builder.append(_name_1, "    ");
      }
    }
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("}");
    return _builder.toString();
  }
  
  public String vararg(final MethodArgument argument) {
    String _xifexpression = null;
    boolean _isVararg = argument.isVararg();
    if (_isVararg) {
      _xifexpression = "...";
    }
    return _xifexpression;
  }
  
  public CharSequence generic(final CallbackDefinition definition) {
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
          _builder.append (p);
        }
      }
      _builder.append(">");
      _xifexpression = _builder;
    }
    return _xifexpression;
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
	       int index = importName.lastIndexOf('.');
//	       importName.substring(0, index+1)
//	       importName.substring(index+1);
	       _builder.append(importName.substring(0, index+1));
	       if (!importName.substring(index+1, index +2).equals("*")) _builder.append("P");
	       _builder.append(importName.substring(index+1));
//	       for (int i =0; i<index; i++) {
//	    	   _builder.append(importName.charAt(i));
//	       }
	
//	        String[] res = importName.split("\\.");
//	        for (int i = 0; i < res.length - 1; i++) {
//	        	_builder.append(res[i] + ".");
//	        }
//	        if (res[res.length-1].contains("\\*")) _builder.append("P" + res[res.length-1]);
//	        else  _builder.append(res[res.length-1]);
	        //_builder.append(importName);
	        
	        _builder.append(";");
	        _builder.newLineIfNotEmpty();
	      }
	    }
	    return _builder;
	  }
}


