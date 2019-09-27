package com.tenxdev.jsinterop.generator.pgenerator;

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

import com.tenxdev.jsinterop.generator.generator.MarginFixer;
import com.tenxdev.jsinterop.generator.generator.XtendTemplate;
import com.tenxdev.jsinterop.generator.generator.jsondocs.Documentation;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.CallbackDefinition;
import com.tenxdev.jsinterop.generator.model.Constant;
import com.tenxdev.jsinterop.generator.model.Constructor;
import com.tenxdev.jsinterop.generator.model.InterfaceDefinition;
import com.tenxdev.jsinterop.generator.model.Method;
import com.tenxdev.jsinterop.generator.model.MethodArgument;
import com.tenxdev.jsinterop.generator.model.Model;
import com.tenxdev.jsinterop.generator.model.interfaces.HasUnionReturnTypes;
import com.tenxdev.jsinterop.generator.model.types.ArrayType;
import com.tenxdev.jsinterop.generator.model.types.GenericType;
import com.tenxdev.jsinterop.generator.model.types.NativeType;
import com.tenxdev.jsinterop.generator.model.types.ObjectType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import com.tenxdev.jsinterop.generator.processing.TemplateFiller;
import com.tenxdev.jsinterop.generator.processing.packageusage.ImportResolver;
import com.tenxdev.jsinterop.generator.processing.packageusage.InterfaceDefinitionUsageVisitor;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.ArrayUtils;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;
//import org.omg.CORBA.TypeCodeHolder;

@SuppressWarnings("all")
public class PonyInterfaceGenerator extends PonyTemplate {
  private Documentation documentation;
  
  public PonyInterfaceGenerator(final Documentation documentation) {
    this.documentation = documentation;
  }
  
  public String generate(Model model, int numOfAttributeParentModifiable, final String basePackageName, final InterfaceDefinition definition, final TemplateFiller templateFiller) throws IOException {
    Collections.<Method>sort(definition.getMethods());
    StringConcatenation _builder = new StringConcatenation();
    
    CharSequence _copyright = this.copyright(); //Creat lines of copyright;
    _builder.append(_copyright);
    _builder.newLineIfNotEmpty();
    _builder.append("package  com.ponysdk.core.ui2;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.ponysdk.core.model.ServerToClientModel;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.ponysdk.core.writer.ModelWriter;");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.ponysdk.core.server.application.UIContext;");
    _builder.newLineIfNotEmpty();

//    _builder.append("package ");
//    _builder.append(basePackageName);
//    String _packageName = definition.getPackageName();
//    _builder.append(_packageName);
//    _builder.append(";");
//    _builder.newLineIfNotEmpty();
   
   
    CharSequence _importsJavaObject = this.importJavaObject(definition);
    		//"import java.util.Objects;"; //this.imports(basePackageName, definition);
    _builder.append(_importsJavaObject);
    _builder.newLineIfNotEmpty();
    if (definition.NumOfAttrModified() >0) {
    CharSequence _importLog = "import org.slf4j.Logger;";
    _builder.append(_importLog);
    _builder.newLineIfNotEmpty();
 
    CharSequence _importLogFactory = "import org.slf4j.LoggerFactory;";
    _builder.append(_importLogFactory);
    _builder.newLineIfNotEmpty();
//    _builder.append("import com.ponysdk.core.ui2.PEventAttributesName;");
//    _builder.newLineIfNotEmpty();
	
    }
    if (definition.hasImportConsumer()) {
    	_builder.append("import java.util.function.Consumer;");
    	_builder.newLineIfNotEmpty();
    	}
    
   
    if (model.isEventInterface(definition)) {
    	_builder.append("import com.ponysdk.core.ui2.PEventAttributesName;");
    	_builder.newLineIfNotEmpty();
    	if (definition.getName().equals("Event")) {
	    	_builder.append("import java.util.HashMap;");
	    	_builder.newLineIfNotEmpty();
    	}
    	_builder.append("import java.util.Map;");
    	_builder.newLineIfNotEmpty();
    }
    
    if (definition.getName().equals("Window")) {
    	_builder.append("import com.ponysdk.core.server.application.UIContext;");
    	_builder.newLineIfNotEmpty();
    }
    
    if (definition.getName().equals("Headers") || definition.getName().equals("URLSearchParams") ) {
    	_builder.append("import java.util.Map;");
    	_builder.newLineIfNotEmpty();
    }
   
    if (definition.getName().equals("Element")) {
    	_builder.append("import java.util.ArrayList;");
    	_builder.newLineIfNotEmpty();
    	_builder.append("import java.util.List;");
    	_builder.newLineIfNotEmpty();
    	_builder.append("import com.ponysdk.core.model.ServerToClientModel;");
    	_builder.newLineIfNotEmpty();
    	_builder.append("import com.ponysdk.core.writer.ModelWriter;");
    	_builder.newLineIfNotEmpty();
    	_builder.append("import com.ponysdk.core.server.application.UIContext;");
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    if (!model.isEventInterface(definition) && model.isLeaf(definition)) {
	    if (model.hasConstructorNonArg(definition.getName()) && !PonySourceGenerator.interdefsManyImpl(model, definition)) {
	    CharSequence _importPLeafTypeNoArgs = this.importLeafTypeNoArgs(model,definition);
	    _builder.append(_importPLeafTypeNoArgs);
	    _builder.newLineIfNotEmpty();
	    }
	  if (model.hasConstructorWithArg(definition.getName()) ) {
	    CharSequence _importPLeafTypeWithArgs = this.importLeafTypeWithArgs(model,definition);
	    _builder.append(_importPLeafTypeWithArgs);
	    _builder.newLineIfNotEmpty();
	    }
	    
    }
//    CharSequence _importClassPLeafType= this.importLeafType(model,definition);
//    _builder.append(_importClassPLeafType);
//    _builder.newLineIfNotEmpty();
//    
//    CharSequence _imports = this.imports(basePackageName, definition, model);
//    _builder.append(_imports);
//    _builder.newLineIfNotEmpty();
//    _builder.newLine();
    
    if (model.isEventInterface(definition))  _builder.append("public class ");
    else if (model.isLeaf(definition) && !PonySourceGenerator.interdefsManyImpl(model, definition)) _builder.append("public class ");
    else  _builder.append("public abstract class ");
    
    String _adjustJavaName = this.adjustJavaName(definition.getName());
    _builder.append(_adjustJavaName);
    CharSequence _generic = this.generic(definition,model);
    _builder.append(_generic);
    String _extendsClass = this.extendsClass(definition);
    _builder.append(_extendsClass);
    String _implementsInterfaces = this.extendsPObject(definition);
    _builder.append(_implementsInterfaces);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    
    if (definition.NumOfAttrModified() >0) {
    _builder.append("    ");
    CharSequence declarationLog = "private static final Logger log = LoggerFactory.getLogger(";
    _builder.append(declarationLog);
    _builder.append(_adjustJavaName);
    _builder.append(".class);");
    _builder.newLineIfNotEmpty();
    }
    if (definition.getName().equals("Event")) {
    	_builder.append("    public Map<PEventAttributesName, Object> mapValueByAttributeName = new HashMap<>();");
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    
 // do not need for nouveau version ArrayList allAttributes in PObject2 of Pony.
//    if (!model.isEventInterface(definition)) {
//    CharSequence typeOfAttr = declarationTypeOfAttribution(definition, model);
//    _builder.append(typeOfAttr);
//    _builder.newLineIfNotEmpty();
//    _builder.newLine();
//    }
//    else {
//    	 CharSequence typeOfAttr = declarationTypeOfAttributionEvent(definition);
//    	    _builder.append(typeOfAttr);
//    	    _builder.newLineIfNotEmpty();
//    	    _builder.newLine();
//    }
    
   
    
    if (definition.getName().equals("Element")) {
    	CharSequence addAttrsAndMethodsForElement = addForElement();
    	_builder.append(addAttrsAndMethodsForElement);
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    
    if (definition.getName().equals("Window")){
		CharSequence addAttrsAndMethodsForWindow = addForWindow();
    	_builder.append(addAttrsAndMethodsForWindow);
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    
    if (definition.getName().equals("HTMLDocument")){
    	CharSequence addAttrsAndMethodsForHTMLDocument = addForHTMLDocument();
    	_builder.append(addAttrsAndMethodsForHTMLDocument);
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    
    if (definition.getName().equals("HTMLBodyElement")) {
    	CharSequence addAttrsAndMethodsForHTMLBody = addForHTMLBody();
    	_builder.append(addAttrsAndMethodsForHTMLBody);
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    
    if (definition.getName().equals("HTMLHtmlElement")) {
    	CharSequence addAttrsAndMethodsForHTMLElement = addForHTMLElement();
    	_builder.append(addAttrsAndMethodsForHTMLElement);
    	_builder.newLineIfNotEmpty();
    	_builder.newLine();
    }
    
    
  
	if (!model.isEventInterface(definition) && model.isLeaf(definition)) {
		if ((model.hasConstructorNonArg(definition.getName()) || model.hasConstructorWithArg(definition.getName())) && !PonySourceGenerator.interdefsManyImpl(model, definition) && !isSpecialCase(definition)) {
			CharSequence _constructors = this.constructors(definition, model);
			_builder.append(_constructors);
			_builder.newLineIfNotEmpty();
			_builder.newLine();
		}
		else if (!isSpecialCase(definition) && !PonySourceGenerator.interdefsManyImpl(model,definition)) {
			_builder.append("    private P" + definition.getName() + "(){");
			_builder.newLineIfNotEmpty();
			_builder.append("    }");
			_builder.newLineIfNotEmpty();
			_builder.newLine();
		}
		
	}
	if (model.isEventInterface(definition)) {
			//CharSequence _constructorsEvent = this.constructorsEvent(definition, model);//version complete of event: constructor complete.
			CharSequence _constructorsEvent = this.constructorsEvent1(definition, model);
			_builder.append(_constructorsEvent);
			_builder.newLineIfNotEmpty();
			_builder.newLine();
		}

	
	if (!model.isEventInterface(definition) && !model.isLeaf(definition)) {
		_builder.append("     protected P" + definition.getName() + "() {");
		_builder.newLineIfNotEmpty();
		_builder.append("     }");
		_builder.newLine();
		
		_builder.append("    protected P" + definition.getName() + "(final Object...argOfConstructor){");
		_builder.newLineIfNotEmpty();
		_builder.append("       super(argOfConstructor);");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
	}
//    if (!model.isEventInterface(definition)) {   
//    CharSequence setAttr = setAttribution3(definition, model);
//    _builder.append(setAttr);
//    _builder.newLineIfNotEmpty();
//    _builder.newLine();
//    
//    }
    
    if (!model.isEventInterface(definition)) {   
        CharSequence setAttr = setAttribution4(definition, model);
        _builder.append(setAttr);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        
        }
    if (!model.isEventInterface(definition)) {
    CharSequence getAttr = getAttribution1(definition, model);
    _builder.append(getAttr);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    }
    else {
    	 CharSequence getAttrEvent = getAttributionEvent(definition, model);
    	    _builder.append(getAttrEvent);
    	    _builder.newLineIfNotEmpty();
    	    _builder.newLine();
    }
    
    
//    CharSequence methodGetTypeOfWidget = getTypeofWidget(model,definition);
//    _builder.append(methodGetTypeOfWidget);
//    _builder.newLineIfNotEmpty();
//    _builder.newLine();
//    
//    _builder.newLine();
    
//  CharSequence _unionTypes = this.unionTypes(definition);
//  _builder.append(_unionTypes, "    ");
//  _builder.newLineIfNotEmpty();
    if (model.isLeaf(definition) && !PonySourceGenerator.interdefsManyImpl(model, definition)&& !model.isEventInterface(definition)) {
	    if (model.hasConstructorNonArg(definition.getName())) {
	    	CharSequence idOfWidgetNoArgs = widgetNoArgs(model,definition);
	        _builder.append(idOfWidgetNoArgs);
	        _builder.newLineIfNotEmpty();
	        _builder.newLine();
	    }
	    else {
	    	_builder.append("    @Override");
	    	_builder.newLineIfNotEmpty();
	    	_builder.append("    protected PLeafTypeNoArgs widgetNoArgs() {");
	    	_builder.newLineIfNotEmpty();
	    	_builder.append("       return null;");
	    	_builder.newLineIfNotEmpty();
	    	_builder.append("    }");
	    	_builder.newLineIfNotEmpty();
	    }
	    
	    if (model.hasConstructorWithArg(definition.getName())) {
	    	CharSequence idOfWidgetWithArgs = widgetWithArgs(model,definition);
	        _builder.append(idOfWidgetWithArgs);
	        _builder.newLineIfNotEmpty();
	        _builder.newLine();
	    }
	    else {
	    	_builder.append("    @Override");
	    	_builder.newLineIfNotEmpty();
	    	_builder.append("    protected PLeafTypeWithArgs widgetWithArgs() {");
	    	_builder.newLineIfNotEmpty();
	    	_builder.append("       return null;");
	    	_builder.newLineIfNotEmpty();
	    	_builder.append("    }");
	    	_builder.newLineIfNotEmpty();
	    }
    }
    
//    if (definition.getName().equals("Window")) {
//    	_builder.append("    private PLeafTypeNoArgs widgetNoArgs() {");
//    	_builder.newLineIfNotEmpty();
//    	_builder.append("      return PLeafTypeNoArgs." + modifyName(definition.getName()) + ";");
//    	_builder.newLineIfNotEmpty();
//    	_builder.append("    }");
//    }
    _builder.newLine();
    if (!model.isEventInterface(definition)) {
	    CharSequence _methods = this.methods(model,definition);
	    _builder.append(_methods);
	    _builder.newLineIfNotEmpty();
	    _builder.append("    ");
    }
  _builder.newLine();
  _builder.append("}");
    
    return _builder.toString();
    
  } 
  
	private CharSequence addForElement() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("     private List<PElement> children;");
		_builder.newLineIfNotEmpty();
		_builder.append("     private PElement parent;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public PElement getChildren(final int indexOfChild) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       return children.get(indexOfChild);");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public PElement getParent() {");
		_builder.newLineIfNotEmpty();
		_builder.append("       return parent;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public void add(final PElement child) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (children == null) children = new ArrayList<>();");
		_builder.newLineIfNotEmpty();
		_builder.append("       children.add(child);");
		_builder.newLineIfNotEmpty();
		_builder.append("       adopt(child);");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (initialized) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          child.attach(pWindow);");
		_builder.newLineIfNotEmpty();
		_builder.append("          add0(child);");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("     protected void adopt(final PElement child) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       child.parent = this;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public void removeChild(final PElement child) {");
		_builder.newLineIfNotEmpty();
		_builder.newLine(); // To add method of remove child here.
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    protected void add0(final PObject2 pObject2) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       final int childId = pObject2.getID();");
		_builder.newLineIfNotEmpty();
		_builder.append("       final int parentId = this.getID();");
		_builder.newLineIfNotEmpty();
		_builder.append("       final ModelWriter writer = UIContext.get().getWriter();");
		_builder.newLineIfNotEmpty();
		_builder.append("       writer.beginPObject2();");
		_builder.newLineIfNotEmpty();
		_builder.append("       writer.write(ServerToClientModel.POBJECT2_TYPE_ADD, childId);");
		_builder.newLineIfNotEmpty();
		_builder.append("       writer.write(ServerToClientModel.POBJECT2_PARENT_OBJECT_ID, parentId);");
		_builder.newLineIfNotEmpty();
		_builder.append("       writer.endObject();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		
		_builder.append("    @Override") ;
		_builder.newLineIfNotEmpty();
		_builder.append("    public void creatAllChild() {");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (children != null) {");
		_builder.newLineIfNotEmpty();
		_builder.append("            for (final PElement child : children) {");
		_builder.newLineIfNotEmpty();
		_builder.append("                child.attach(pWindow);");
		_builder.newLineIfNotEmpty();
		_builder.append("                add0(child);");
		_builder.newLineIfNotEmpty();
		_builder.append("            }");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		return _builder.toString();
		
	}

	private CharSequence addForHTMLElement() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("      PHTMLHtmlElement(final PWindow2 window) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          this.pWindow = window;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public PHTMLHtmlElement() {");
		_builder.append("    }");
	return _builder.toString();
}
	
	private CharSequence addForHTMLElement1() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("      PHTMLHtmlElement(final PWindow2 window, final boolean linktoExisting) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          this.pWindow = window;");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (linktoExisting) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          applyExisting(window,widgetNoArgs());");
		_builder.newLineIfNotEmpty();
		_builder.append("    } else {");
		_builder.newLineIfNotEmpty();
		_builder.append("          applyInit(widgetNoArgs());");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public PHTMLHtmlElement() {");
		_builder.newLineIfNotEmpty();
		_builder.append("       this(null,false);");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
	return _builder.toString();
}


	private CharSequence addForHTMLBody1() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("     PHTMLBodyElement(final PWindow2 window, final boolean linktoExisting) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          this.pWindow = window;");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (linktoExisting) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          applyExisting(window,widgetNoArgs());");
		_builder.newLineIfNotEmpty();
		_builder.append("    } else {");
		_builder.newLineIfNotEmpty();
		_builder.append("          applyInit(widgetNoArgs());");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("    public PHTMLBodyElement() {");
		_builder.newLineIfNotEmpty();
		_builder.append("       this(null,false);");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
	return _builder.toString();
}
	
	private CharSequence addForHTMLBody() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("     PHTMLBodyElement(final PWindow2 window) {");
		_builder.newLineIfNotEmpty();
		_builder.append("          this.pWindow = window;");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLine();
		
		_builder.append("    public PHTMLBodyElement() {");
		_builder.append("    }");
	return _builder.toString();
}	

	private CharSequence addForHTMLDocument() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    public PHTMLDocument(final PWindow2 window) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       this.pWindow = window;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
	return _builder.toString();
}

	private CharSequence addForWindow() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    private static final String CANONICAL_NAME = PWindow.class.getCanonicalName();");
		_builder.newLineIfNotEmpty();
		_builder.append("    private static final PHTMLDocument htmlDocument = new PHTMLDocument();");
		_builder.newLineIfNotEmpty();
		_builder.append("    private final PHTMLHtmlElement html = new PHTMLHtmlElement(true);");
		_builder.newLineIfNotEmpty();
		_builder.append("    private final PHTMLBodyElement body = new PHTMLBodyElement(true);");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("     public static PWindow getMain() {");
		_builder.newLineIfNotEmpty();
		_builder.append("          PWindow mainWindow = UIContext.get().getAttribute(CANONICAL_NAME);");
		_builder.newLineIfNotEmpty();
		_builder.append("            if (mainWindow == null) {");
		_builder.newLineIfNotEmpty();
		_builder.append("                  mainWindow = new PWindow();");
		_builder.newLineIfNotEmpty();
		_builder.append("                  UIContext.get().setAttribute(CANONICAL_NAME, window);");
		_builder.newLineIfNotEmpty();
		_builder.append("            }");
		_builder.newLineIfNotEmpty();
		_builder.append("            return mainWindow;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("     public static PHTMLDocument getHtmlDocument() {");
		_builder.newLineIfNotEmpty();
		_builder.append("        return htmlDocument;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public PHTMLHtmlElement getHtml() {");
		_builder.newLineIfNotEmpty();
		_builder.append("       return html;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public PHTMLBodyElement getBody() {");
		_builder.newLineIfNotEmpty();
		_builder.append("        return body;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("     public PWindow() {");
		_builder.newLineIfNotEmpty();
		_builder.append("         applyExisting(widgetNoArgs());");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		return _builder.toString();
	}

private CharSequence getAttributionEvent(InterfaceDefinition definition, Model model) {
	StringConcatenation _builder = new StringConcatenation();
	{
		List<Attribute> attribues = definition.getAttributes();
		for (final Attribute attribute : attribues) {
				String name = attribute.getNameModified();
				Type typeOfAttr = attribute.getType();
				String typeOfAttrNameType = null;
				typeOfAttrNameType = Type.declarationType(typeOfAttr);
				if (typeOfAttrNameType !=null) {
					_builder.append( getBodyOfAttributionEvent(attribute,name, typeOfAttrNameType,model));
				}
		}
		if (definition.getName().equals("Event")) {
			_builder.append("   protected Object get(final PEventAttributesName attrName) {");
			_builder.newLineIfNotEmpty();
			_builder.append("      return mapValueByAttributeName.get(attrName);");
			_builder.newLineIfNotEmpty();
			_builder.append("  }");
		}
	}
	return _builder.toString();
}

private String getBodyOfAttributionEvent(Attribute attribute, String name, String typeOfAttrNameType,Model model) {
	
	StringConcatenation _builder = new StringConcatenation();
	String declarationType = Type.declarationType(attribute.getType());
	if (attribute.getType() instanceof NativeType) declarationType = "Object";
	String returntype =  " ("+ declarationType + ") ";
	if (attribute.getType() instanceof NativeType) returntype = " ";
	_builder.append("    public " +  declarationType +  " get" + name.substring(0, 1).toUpperCase() +  name.substring(1) + "(){");
	_builder.newLineIfNotEmpty();
	_builder.append("      return" + returntype + "get(PEventAttributesName." + model.nameEventAttributeModfied(attribute).toUpperCase() + ");");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	_builder.newLine();
	return _builder.toString();
}

private CharSequence constructorsEvent1(InterfaceDefinition definition, Model model) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    public P" + definition.getName() + "(");
	_builder.append("final Map<PEventAttributesName, Object> mapValueByAttributeName");
	_builder.append("){");
	_builder.newLineIfNotEmpty();
	if (definition.getName().equals("Event")) {
	_builder.append("       this.mapValueByAttributeName = mapValueByAttributeName;");
	}
	else{
		_builder.append("       super(mapValueByAttributeName);");
	}
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	_builder.newLine();
	return _builder.toString();
}

private CharSequence declarationTypeOfAttributionEvent(InterfaceDefinition definition) {
	 StringConcatenation _builder = new StringConcatenation();
     List<Attribute> attribues = definition.getAttributes();
     for(final Attribute attribute : attribues) {
//   	  if (!attribute.isReadOnly() && !attribute.isStatic()) {
   		  Type type = attribute.getType();
   		  String name = attribute.getNameModified();
   		  //if (Model.getTypePrimimiteToObject().keySet().contains(name)) name = Model.getTypePrimimiteToObject().get(name);
   		  _builder.append("    private final " + Type.declarationType(name,type) );
   		  _builder.newLineIfNotEmpty();
//   	  }
   		 
     }
    
   
   return _builder;
}

private CharSequence constructorsEvent(InterfaceDefinition definition, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    public P" + definition.getName() + "(");
		int count1 = 0;
		List<Attribute> attrs = model.attrsInherit(definition);
		boolean _hasElements = false;
		for (int index = 0; index < attrs.size(); index++) {
			if (!_hasElements) {
				_hasElements = true;
			} else {
				_builder.appendImmediate(", ", "");
			}
			String name = attrs.get(index).getNameModified();
			Type typeOfAttr = attrs.get(index).getType();
			String typeOfAttrNameType = Type.declarationType(typeOfAttr);
			_builder.append(typeOfAttrNameType + " " + name);
			count1++;
			if (count1 % 3 == 0) {
				_builder.newLineIfNotEmpty();
				_builder.append("                ");
			}
		}
		_builder.append("){");
		_builder.newLineIfNotEmpty();
		List<Attribute> attrsWithoutItself = model.attrsInheritWithoutItself(definition);
		if (!attrsWithoutItself.isEmpty()) {
			int count2 = 0;
			_builder.append("       super(");
			boolean _hasElements1 = false;
			for (int index = 0; index < attrsWithoutItself.size(); index++) {
				if (!_hasElements1) {
					_hasElements1 = true;
				} else {
					_builder.appendImmediate(", ", "");
				}
				String name = attrsWithoutItself.get(index).getNameModified();
				_builder.append(name);
				count2++;
				if (count2 % 5 == 0) {
					_builder.newLineIfNotEmpty();
					_builder.append("             ");
				}
			}
			_builder.append(");");
			_builder.newLineIfNotEmpty();
		}
		List<Attribute> attrsItself = model.attrsSorted(definition);
		for (int index = 0; index < attrsItself.size(); index++) {
			String name = attrsItself.get(index).getNameModified();
			_builder.append("        this." + name + " = " + name + ";");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();
		return _builder.toString();
}

private CharSequence setAttributionEvent(InterfaceDefinition definition, Model model) {
	StringConcatenation _builder = new StringConcatenation();
	List<Attribute> attribues = definition.getAttributes();
	for (final Attribute attribute : attribues) {
			String name = attribute.getNameModified();
			Type typeOfAttr = attribute.getType();
			String typeOfAttrNameType = null;
			typeOfAttrNameType = Type.declarationType(typeOfAttr);
			if (typeOfAttrNameType !=null) {
				_builder.append( setBodyAttribution(attribute,name, typeOfAttrNameType));
			}
	}
	return _builder.toString();
}

private Object setBodyAttribution(Attribute attribute, String name, String typeOfAttrNameType) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    public void set" + name.substring(0, 1).toUpperCase() +  name.substring(1) + "(" + typeOfAttrNameType +" " +  name + "){");
	_builder.newLineIfNotEmpty();
	_builder.append("       this." + name + " = " + name + ";");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	_builder.newLine();
	return _builder.toString();
}

private CharSequence getAttribution(InterfaceDefinition definition, Model model) {
	StringConcatenation _builder = new StringConcatenation();
	{
		List<Attribute> attribues = definition.getAttributes();
		for (final Attribute attribute : attribues) {
			if (!attribute.isStatic() && !attribute.isReadOnly()) {
				String name = attribute.getNameModified();
				Type typeOfAttr = attribute.getType();
				String typeOfAttrNameType = null;
				typeOfAttrNameType = Type.declarationType(typeOfAttr);
				if (typeOfAttrNameType !=null) {
					_builder.append( getBodyOfAttribution(attribute,name, typeOfAttrNameType));
				}
									
			}

		}

	}
	return _builder;
}


private CharSequence getAttribution1(InterfaceDefinition definition, Model model) {
	StringConcatenation _builder = new StringConcatenation();
	{
		List<Attribute> attribues = definition.getAttributes();
		for (final Attribute attribute : attribues) {
			if (!attribute.isStatic() && !attribute.isReadOnly()) {
				String name = attribute.getNameModified();
				Type typeOfAttr = attribute.getType();
				String typeOfAttrNameType = null;
				typeOfAttrNameType = Type.declarationType(typeOfAttr);
				if (typeOfAttrNameType !=null) {
					_builder.append( getBodyOfAttribution1(attribute,name, typeOfAttrNameType,model));
				}
									
			}

		}

	}
	return _builder;
}

private CharSequence getBodyOfAttribution(Attribute attribute, String name, String typeOfAttrNameType) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    public " + typeOfAttrNameType + " get" + name.substring(0, 1).toUpperCase() +  name.substring(1) + "(){");
	_builder.newLineIfNotEmpty();
	_builder.append("      return " + name  + ";");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	_builder.newLine();
	return _builder.toString();
}

private CharSequence getBodyOfAttribution1(Attribute attribute, String name, String typeOfAttrNameType, Model model) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    public " + typeOfAttrNameType + " get" + name.substring(0, 1).toUpperCase() +  name.substring(1) + "(){");
	_builder.newLineIfNotEmpty();
	_builder.append("      return " + "(" + typeOfAttrNameType + ") getAttribute(PAttributeNames." + model.nameAttributeModified(attribute)  + ");");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	_builder.newLine();
	return _builder.toString();
}

private CharSequence importLeafTypeWithArgs(Model model, InterfaceDefinition definition) {
	return "import com.ponysdk.core.ui2.PLeafTypeWithArgs;";
}

private CharSequence importLeafTypeNoArgs(Model model, InterfaceDefinition definition) {
	return "import com.ponysdk.core.ui2.PLeafTypeNoArgs;";
}

private CharSequence widgetWithArgs(Model model, InterfaceDefinition definition) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    @Override");
	_builder.newLineIfNotEmpty();
	_builder.append("    protected PLeafTypeWithArgs widgetWithArgs() {");
	_builder.newLineIfNotEmpty();
	_builder.append("      return PLeafTypeWithArgs." + modifyName(definition.getName())  + ";");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	return _builder.toString();
}

private  CharSequence widgetNoArgs(Model model, InterfaceDefinition definition) {
	StringConcatenation _builder = new StringConcatenation();
	_builder.append("    @Override");
	_builder.newLineIfNotEmpty();
	_builder.append("    protected PLeafTypeNoArgs widgetNoArgs() {");
	_builder.newLineIfNotEmpty();
	_builder.append("      return PLeafTypeNoArgs." + modifyName(definition.getName()) + ";");
	_builder.newLineIfNotEmpty();
	_builder.append("    }");
	return _builder.toString();
}


  

public CharSequence unionTypes(final HasUnionReturnTypes definition) {
	    StringConcatenation _builder = new StringConcatenation();
	      List<UnionType> _unionReturnTypes = definition.getUnionReturnTypes();
	      for(final UnionType unionType : _unionReturnTypes) 
	        {
	          //AbstractDefinition _owner = ((UnionType) unionType).getOwner();
	          //boolean _tripleEquals = (_owner == definition);
	          //if (_tripleEquals) {
	            _builder.newLine();
	            _builder.append("static class ");
	            String _name = Type.nameModifiedOfUnionType(unionType);
	            _builder.append(_name);
	            _builder.append(" {");
	            _builder.newLineIfNotEmpty();
	             _builder.append(Type.declarationUnionType("value", unionType));
	             String[] listOfAttrNameType = Type.getTypesNameOfAttrOfUnionType((UnionType)unionType);
	             int length = listOfAttrNameType.length;
	             for (int index =0; index <length; index++ ) {
	            	 _builder.append("    public " + _name + "(" + listOfAttrNameType[index] + " value" + "){");
	            	 _builder.newLineIfNotEmpty();
	            	 _builder.append("        value" + listOfAttrNameType[index].toUpperCase().substring(0, 1) + listOfAttrNameType[index].substring(1) + " = "+ "value;");
	            	 _builder.newLineIfNotEmpty();
	            	 for (int index2 =0; index2 <length ; index2++ ) {
	            		 if (index2 !=index) {
	            		 _builder.append("        value" + listOfAttrNameType[index2].toUpperCase().substring(0, 1) + listOfAttrNameType[index2].substring(1) + " = "+ "null;");
	            		 _builder.newLineIfNotEmpty();
	            		 }
	            	 }
	        
	            	 _builder.append("    }");
	            	 _builder.newLine();
	             }
	          }
	    	 
	        //}
	      
	      if (!_unionReturnTypes.isEmpty()) _builder.append("}");

	   
	    return _builder.toString();
  }
	private String importJavaObject(InterfaceDefinition definition) {
		if (!definition.setOfNamesAttrModifiable().isEmpty()) {
			return "import java.util.Objects;";
		}
	return null;
}

	private CharSequence importLeafType(Model model, InterfaceDefinition definition) {
	 if (model.isLeaf(definition))
		 return "import com.ponysdk.core.ui2.PLeafType;";
	return null;
}

	private String importPObject2(InterfaceDefinition definition) {
		if (definition.getParent() == null)
			return "import com.ponysdk.core.ui2.PObject2;";
	return null;
}

	private String extendsPObject(InterfaceDefinition definition) {
		 String _xifexpression = null;
		    Type _parent = definition.getParent();
		    boolean _tripleNotEquals = (_parent == null);
		    if (_tripleNotEquals && !definition.getName().equals("Event")) {
		      String _displayValue = "PObject2";
		      _xifexpression = (" extends " + _displayValue);
		    }
		    return _xifexpression;
}
  public CharSequence generic(final InterfaceDefinition definition, Model model) {
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
        if (model.getDefinitionKey().keySet().contains(p)) {
        _builder.append("P"+p);
        }
        _builder.append(p);
      }
      _builder.append(">");
    }
   
    _xifexpression = _builder;
  }
  return _xifexpression;
}
public CharSequence imports(final String basePackageName, final InterfaceDefinition definition, Model model) {
  StringConcatenation _builder = new StringConcatenation();
  _builder.newLineIfNotEmpty();
    List<String> _importedPackages = null;
   if (!model.isEventInterface(definition)) { 
	   _importedPackages =  definition.getImportedPackages();
	   _importedPackages.addAll(InterfaceDefinitionUsageVisitor.visitConstructors2(definition.getConstructors()));
   }
   else _importedPackages = model.getImportedPackagesAncestor(definition);
    for(final String importName : _importedPackages) {
      String _xifexpression = null;
      boolean _startsWith = importName.startsWith(".");
      if (_startsWith) {
        _xifexpression = basePackageName;
      } else {
        _xifexpression = "";
      }
      if (ImportResolver.needsImport(definition,importName)) {
     int index = importName.lastIndexOf('.');
     String nameOfClassImport = importName.substring(index+1);
     if (!nameOfClassImport.equals("Js")) {
     _builder.append("import ");
      _builder.append(_xifexpression);
     _builder.append(importName.substring(0, index+1));
     if (!nameOfClassImport.equals("Map") && !importName.substring(index+1, index +2).equals("*")) _builder.append("P");
     //if (!importName.substring(index+1, index +2).equals("*")) _builder.append("P");
     _builder.append(nameOfClassImport);
      _builder.append(";");
      _builder.newLineIfNotEmpty();
     }
      }
     
    }
//      definition.getUnionReturnTypes().stream().distinct().forEach(type->{
//    	  _builder.append("import com.ponysdk.core.ui2.uniontype." + Type.nameModifiedOfUnionType(type) + ";" );
//    	  _builder.newLineIfNotEmpty();
//      });
     
//     }   
     
//    Set<String> modifiedNamesOfUnionTypes = new HashSet<String>();
//    for(UnionType type: definition.getUnionReturnTypes()) {
//  	  modifiedNamesOfUnionTypes.add(Type.nameModifiedOfUnionType((UnionType)type));  
//    }
//  
//    for (String name: modifiedNamesOfUnionTypes) {
//  	  _builder.append("import com.ponysdk.core.ui2.uniontype." + name + ";" );
//  	  _builder.newLineIfNotEmpty();
//    }
    
//    Type typeParent = definition.getParent();
//    if (typeParent instanceof ParameterisedType) {
//    	for (UnionType type: ((ParameterisedType) typeParent).parametersUnionType()) {
//    		_builder.append("import com.ponysdk.core.ui2.uniontype." +Type.nameModifiedOfUnionType((UnionType)type) + ";");
//    	}
//   }
    
  
  return _builder;
}
	private CharSequence getTypeofWidget(Model model, InterfaceDefinition definition) {
		StringConcatenation _builder = new StringConcatenation();
			if (model.setOfLeaf().contains(definition.getName())) {
			_builder.append("    " + "@Override");
			_builder.newLineIfNotEmpty();
			_builder.append("    " + "protected ");
			_builder.append("PLeafType ");
			_builder.append("getPLeafType() {");
			_builder.newLineIfNotEmpty();
			_builder.append("       ");
			_builder.append("return PLeafType."); 
			String name = definition.getName();
			StringBuffer res = new StringBuffer();
			String[] r = name.split("(?=\\p{Upper}\\p{Lower})");
			for (int i=0; i < r.length; i++) {
				res.append(r[i].toUpperCase() + "_");		
			}
			res.deleteCharAt(res.length()-1);
			_builder.append(res + ";");
			_builder.newLineIfNotEmpty();
			_builder.append("    }");
			_builder.newLineIfNotEmpty();
		}
	return _builder;
}

	private CharSequence setAttribution(InterfaceDefinition definition) {
		StringConcatenation _builder = new StringConcatenation();
		{
			List<Attribute> attribues = definition.getAttributes();
			for (final Attribute attribute : attribues) {
				if (!attribute.isReadOnly() && !attribute.isStatic()) {
					_builder.append("    ");
					_builder.append("public void set");
					String name = attribute.getName();
					String nameOfMethode = name.substring(0, 1).toUpperCase() +  name.substring(1) ;
					_builder.append(nameOfMethode + "(final");
					String typeOfAttr =attribute.getType().getTypeName();
					if (attribute.getType() instanceof ObjectType) {
						typeOfAttr = "P" + typeOfAttr;
					}
					_builder.append(" " + typeOfAttr + " " + name + ")" + "  " + "{");
					_builder.newLineIfNotEmpty();
					_builder.append("       if (Objects.equals(this." + name + "," + " " + name + "))" + "return;" );
					_builder.newLineIfNotEmpty();
					_builder.append("       this." + name + " = " + name +";");
					_builder.newLineIfNotEmpty();
					_builder.append("       log.info(\"" + name + "\"" + " + " + name + ");");
					_builder.newLineIfNotEmpty();
					_builder.append("       saveUpdateAttribute(" + name.toUpperCase() + "_" + "ATTRIBUTE," + " " + name + ");");
					_builder.newLineIfNotEmpty();
					_builder.append("    }");
					_builder.newLineIfNotEmpty();
					
					
				}

			}

		}
		return _builder;
	}


private CharSequence declarationTypeOfAttribution(InterfaceDefinition definition, Model model) {
	    StringConcatenation _builder = new StringConcatenation();
	      List<Attribute> attribues = definition.getAttributes();
	      for(final Attribute attribute : attribues) {
	    	 // if (!model.typeOfLeafNoConstructor(attribute.getType())) {
	    	  if (!attribute.isStatic() && !attribute.isReadOnly()) {
	    		  Type type = attribute.getType();
	    		  String name = attribute.getNameModified();
	    		  //if (Model.getTypePrimimiteToObject().keySet().contains(name)) name = Model.getTypePrimimiteToObject().get(name);
	    		  _builder.append("     private " + Type.declarationType(name,type));
	    		  _builder.newLineIfNotEmpty();
	    	  }
	    		 
	      }
	     
	    
	    return _builder;
}

//public CharSequence declarationType(String name, Type type) {
//	//StringConcatenation _builder = new StringConcatenation();
//	if (type instanceof ObjectType) return Type.declarationObjectType(name,(ObjectType)type);
//	if (type instanceof NativeType) return Type.declarationNativeType(name,(NativeType) type);
//	if (type instanceof ArrayType) return Type.declarationArrayType(name,(ArrayType) type);
//	if (type instanceof UnionType) return declarationUnionType2(name,(UnionType)type);
//	if (type instanceof  GenericType) return Type.declarationGenericType(name, (GenericType)type);
//	if (type instanceof ParameterisedType) return Type.getTypesNameOfParameterisedType( (ParameterisedType)type) + " " + name + ";";
//	return null;
//}



//private String declarationUnionType2(String name, UnionType type) {
//	return  Type.nameModifiedOfUnionType(type) + " " + name + ";" ;
//}






public String extendsClass(final InterfaceDefinition definition) {
    String _xifexpression = null;
    Type _parent = definition.getParent();
    boolean _tripleNotEquals = (_parent != null);
    if (_tripleNotEquals) {
      String _displayValue =  null;
      Type parent = definition.getParent();
      if (parent instanceof ParameterisedType) {
    	  _displayValue = ((ParameterisedType)parent).getBaseType().displayValue() + "<" ;
    	  for (Type type: (( ParameterisedType)definition.getParent()).getTypeParameters()) {
    		  if (type instanceof ObjectType) _displayValue = _displayValue + "P"+ type.getTypeName() + ",";
    		  else if (type instanceof UnionType) _displayValue = _displayValue + "P"+ ((UnionType)type).getName() + ",";
    		  else _displayValue = _displayValue +  type.getTypeName() + ",";
  
    	  }
    	_displayValue = _displayValue.substring(0, _displayValue.length()-1) + ">";
      }
      else _displayValue = parent.displayValue();
      _xifexpression = (" extends " + _displayValue);
    }
    return _xifexpression;
  }


  

  public CharSequence declarationAttributesAsConstant(int numOfAttributeParentModifiable,final InterfaceDefinition definition) {
	  //int attributesAsConstant = 0;
    StringConcatenation _builder = new StringConcatenation();
    {
      List<Attribute> attribues = definition.getAttributes();
      boolean _hasElements = false;
      for(final Attribute attribute : attribues) {
    	  if(!attribute.isStatic() && !attribute.isReadOnly()) {
	        _builder.append("    ");
	        _builder.append("private static final int ");
	        String _name = attribute.getName();
	        _builder.append(_name.toUpperCase());
	        _builder.append("_ATTRIBUTE = " + numOfAttributeParentModifiable + ";");
	        _builder.newLineIfNotEmpty();
	        numOfAttributeParentModifiable++;
    	  }
      }
     
    }
    return _builder;
  }
  
  private CharSequence setAttribution2(InterfaceDefinition definition, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		{
			List<Attribute> attribues = definition.getAttributes();
			for (final Attribute attribute : attribues) {
				if (!attribute.isReadOnly() && !attribute.isStatic()) {
					String name = attribute.getName();
					if (name.equals("default")) name = name + "xxx";
					Type typeOfAttr = attribute.getType();
					String typeOfAttrNameType = null;
					String[] listOfAttrNameType = null;
					if (typeOfAttr instanceof ObjectType) {
						typeOfAttrNameType = Type.getTypesNameOfObjectType((ObjectType)typeOfAttr);
					}
					if (typeOfAttr instanceof ArrayType) {
						typeOfAttrNameType = Type.getTypesNameOfArrayType((ArrayType)typeOfAttr);
					}
					if (typeOfAttr instanceof NativeType) {
						typeOfAttrNameType = typeOfAttr.getTypeName();
					}
					if (typeOfAttr instanceof UnionType) {
						listOfAttrNameType = Type.getTypesNameOfAttrOfUnionType((UnionType)typeOfAttr);
					}
					if (typeOfAttrNameType !=null) {
						_builder.append( setBodyOfAttribution(attribute,name, typeOfAttrNameType, model));
					}
					if (listOfAttrNameType !=null) {
						for (int index = 0; index <listOfAttrNameType.length; index++) {
							_builder.append( setBodyOfAttribution(attribute,name + listOfAttrNameType[index].substring(0, 1).toUpperCase() + listOfAttrNameType[index].substring(1) , listOfAttrNameType[index], model));
						}
					}
					
				}

			}

		}
		return _builder;
	}
  
  
  private CharSequence setAttribution4(InterfaceDefinition definition, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		{
			List<Attribute> attribues = definition.getAttributes();
			for (final Attribute attribute : attribues) {
				if (!attribute.isReadOnly() && !attribute.isStatic()) {
					String name = attribute.getNameModified();
					Type typeOfAttr = attribute.getType();
					String typeOfAttrNameType = null;
					typeOfAttrNameType = Type.declarationType(typeOfAttr);
					if (typeOfAttrNameType !=null) {
						_builder.append( setBodyOfAttribution1(attribute,name, typeOfAttrNameType,model));
					}
										
				}

			}

		}
		return _builder;
	}

  
//	public static String declarationType(Type type) {
//		String res = new String();
//		if (type instanceof ObjectType) {
//			res = Type.getTypesNameOfObjectType((ObjectType) type);
//		}
//		if (type instanceof ArrayType) {
//			res = Type.getTypesNameOfArrayType((ArrayType) type);
//		}
//		if (type instanceof NativeType) {
//			res = type.getTypeName();
//		}
//		if (type instanceof UnionType) {
//			res = Type.nameModifiedOfUnionType((UnionType) type);
//		}
//		if (type instanceof ParameterisedType) {
//			res = Type.getTypesNameOfParameterisedType((ParameterisedType) type);
//		}
//		if (type instanceof GenericType) {
//			res = Type.getTypesNameOfGenericType((GenericType) type);
//		}
//		return res;
//	}
  
   public  CharSequence setBodyOfAttribution(Attribute attr,String nameArgument, String typeOfArgument, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    ");
		_builder.append("public void set");
		String nameOfMethode = attr.getName().substring(0, 1).toUpperCase() +  attr.getName().substring(1) ;
		if (model.getDefinition(typeOfArgument.substring(1)) instanceof CallbackDefinition) {
		_builder.append(nameOfMethode + "(final");
		_builder.append(" " + typeOfArgument + " " + nameArgument + ", final PEventAttributesName... atrsName)" + "  " + "{");
		_builder.newLineIfNotEmpty();
		
			_builder.append("       addHandler(" + nameArgument + ");");
			_builder.newLineIfNotEmpty();
			_builder.append("       saveUpdateAttributeCallBack(PAttributeNames." +  model.modifyName(nameArgument) + ", " + nameArgument + ", atrsName);");
		}
		else {
			_builder.append(nameOfMethode + "(final");
			_builder.append(" " + typeOfArgument + " " + nameArgument +")  " + "{");
			_builder.newLineIfNotEmpty();
			_builder.append("       if (Objects.equals(this." + nameArgument + "," + " " + nameArgument + "))" + "return;");
			_builder.newLineIfNotEmpty();
			_builder.append("       this." + nameArgument + " = " + nameArgument + ";");
			_builder.newLineIfNotEmpty();
			_builder.append("       log.info(\"" + nameArgument + "\"" + " + " + nameArgument + ");");
			_builder.newLineIfNotEmpty();
			_builder.append("       saveUpdateAttribute(" + "PAttributeNames."+ modifyName( attr.getName()) + "," + nameArgument + ");");
		}
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		return _builder;
	}
   
   
   public  CharSequence setBodyOfAttribution1(Attribute attr, String nameArgument, String typeOfArgument, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    ");
		_builder.append("public void set");
		String nameOfMethode = attr.getName().substring(0, 1).toUpperCase() +  attr.getName().substring(1) ;
		if (model.getDefinition(typeOfArgument.substring(1)) instanceof CallbackDefinition) 
		{
			_builder.append(nameOfMethode + "(final");
			_builder.append(" " + typeOfArgument + " " + nameArgument + ", final PEventAttributesName... atrsEventName)" + "  " + "{");
			_builder.newLineIfNotEmpty();
			
			//_builder.append("       setAttribute(PAttributeNames." + modifyName( attr.getName()) + ", " + nameArgument + ");");
			_builder.append("       setAttribute(PAttributeNames." + modifyName( attr.getName()) + ", " + "new AttributeCallBack(" + nameArgument + ", atrsEventName));");
			_builder.newLineIfNotEmpty();
			_builder.append("       log.info(\"" + nameArgument + "\"" + " + " + nameArgument + ".getClass().getName());");
		}
		else 
		{
			_builder.append(nameOfMethode + "(final");
			_builder.append(" " + typeOfArgument + " " + nameArgument +")  " + "{");
			_builder.newLineIfNotEmpty();
			_builder.append("       setAttribute(PAttributeNames." + model.nameAttributeModified(attr) + ", " + nameArgument + ");");
			_builder.newLineIfNotEmpty();
			_builder.append("       log.info(\"" + nameArgument + "\"" + " + " + nameArgument + ");");
			_builder.newLineIfNotEmpty();
			//_builder.append("       if (initialized) saveUpdateAttribute(" + "PAttributeNames."+ modifyName( attr.getName()) + "," + nameArgument + ");");
		}
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		return _builder;
	}
  
  private String[] getNameOfAttrOfUnionType(UnionType type) {
	  int size = type.getTypes().size();
	  String[] res = new String[size];
	  int index = 0;
	  for (Type typeChild: type.getTypes()) {
		res[index] = type.getName() + typeChild.getTypeName().substring(0, 1).toUpperCase() + typeChild.getTypeName().substring(1);
		index++;
	  }
	  return res;
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
  
 
	public CharSequence constructors(final InterfaceDefinition definition, final Model model) {
		StringConcatenation _builder = new StringConcatenation();
		{
			List<Constructor> _constructors = definition.getConstructors();
			if (_constructors.isEmpty())
				_builder.append(constructorNonParame(definition));
			for (final Constructor constructor : _constructors) {
				{
					boolean _isHidden = constructor.isHidden();
					if (_isHidden) {
						_builder.append("    private ");
						String _name = "P" + definition.getName();
						_builder.append(_name);
						_builder.append("(");
						CharSequence _arguments = this.arguments(constructor);
						_builder.append(_arguments);
						_builder.append("){");
						_builder.newLineIfNotEmpty();
						_builder.append("}");
						_builder.newLine();
					} else {
						if (constructor.getArguments().isEmpty())
							_builder.append(constructorNonParame(definition));
						else {
//	            String _safeVarArgs = this.safeVarArgs(constructor);
//	            _builder.append(_safeVarArgs);
//	            _builder.newLineIfNotEmpty();
//	            _builder.newLine();
							_builder.append("    public ");
							String _name_1 = "P" + definition.getName();
							_builder.append(_name_1);
							_builder.append("(");
							CharSequence _arguments_1 = this.arguments(constructor);
							_builder.append(_arguments_1);
							_builder.append("){");
							_builder.newLineIfNotEmpty();
							{
//	              Type _parent_1 = definition.getParent();
//	              boolean _tripleNotEquals_1 = (_parent_1 != null);
//	              if (_tripleNotEquals_1) {
//	                _builder.append("      ");
//	                _builder.append("super(");
//	                CharSequence _superArguments_1 = this.superArguments(constructor);
//	                _builder.append(_superArguments_1, "    ");
//	                _builder.append(");");
//	                _builder.newLineIfNotEmpty();

								_builder.append("      super("
										+ this.arguments2(constructor) + ");");
								_builder.newLineIfNotEmpty();
							}
							_builder.append("    }");

						}

						_builder.newLine();
						_builder.newLine();
					}
				}
			}
		}
		return _builder;
	}
	  
  
  
 

private CharSequence constructorNonParame(InterfaceDefinition definition) {
	  StringConcatenation _builder = new StringConcatenation();
	  _builder.append("    public " + "P"+ definition.getName() + "() {");
	  _builder.newLineIfNotEmpty();
//	  _builder.append("      applyInit(widgetNoArgs());");
//	  _builder.newLineIfNotEmpty();
	  _builder.append("    }");
	  _builder.newLine();
	return _builder;
}

public CharSequence arguments(final Method method) {
	    StringConcatenation _builder = new StringConcatenation();
	    {
	      List<MethodArgument> _arguments = method.getArguments();
	      if (method.getReturnType() instanceof NativeType && !method.getReturnType().getTypeName().equals("void")) {
	    	  _builder.append("final Consumer<" + method.getReturnType().getTypeName() + "> cback" );
	    	  if (!_arguments.isEmpty()) _builder.append(",");
	      }
	      boolean _hasElements = false;
	      for(final MethodArgument argument : _arguments) {
	        if (!_hasElements) {
	          _hasElements = true;
	        } else {
	          _builder.appendImmediate(", ", "");
	        }
	        String _displayValue = Type.declarationType(argument.getType());
	        _builder.append(_displayValue);
//	        String _vararg = this.vararg(argument);
//	        _builder.append(_vararg);
	        _builder.append(" ");
	        String _adjustJavaName = this.adjustJavaNameArg(argument.getName());
	        _builder.append(_adjustJavaName);
	      }
	    }
	    return _builder;
	  }


public CharSequence arguments2(final Method method) {
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
//        String _displayValue = declarationType(argument.getType());
//        _builder.append(_displayValue);
//        String _vararg = this.vararg(argument);
//        _builder.append(_vararg);
        String _adjustJavaName = this.adjustJavaNameArg(argument.getName());
        _builder.append(_adjustJavaName);
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
	        String _displayValue = Type.declarationType(argument.getType());
	        _builder.append(_displayValue);
	        _builder.append(") null");
	      }
	    }
	    return _builder;
	  }

  public String safeVarArgs(final Method method) {
	    String _xifexpression = null;
	    boolean _needsSafeVararg = method.needsSafeVararg();
	    if (_needsSafeVararg) {
	      _xifexpression = "@SafeVarargs";
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
  
  private Boolean isSpecialCase(InterfaceDefinition definition) {
	  return definition.getName().equals("Window") || definition.getName().equals("HTMLDocument") ||definition.getName().equals("HTMLHtmlElement") ||definition.getName().equals("HTMLBodyElement");
  }
  
  public CharSequence methods(Model model, final InterfaceDefinition definition) {
	    StringConcatenation _builder = new StringConcatenation();
	    {
	      List<Method> _methods = definition.getMethods();
	      for(final Method method : _methods) {

	              String _checkDeprecated_1 = this.checkDeprecated(method);
	              _builder.append(_checkDeprecated_1);
	              _builder.newLineIfNotEmpty();
	              _builder.append("    public ");
//	              String _staticModifier_1 = this.staticModifier(method);
//	              _builder.append(_staticModifier_1);
	              String _safeVarArgsFinal = this.safeVarArgsFinal(method);
	              _builder.append(_safeVarArgsFinal);
	              CharSequence _typeSpecifier_1 = this.typeSpecifier(method);
	              _builder.append(_typeSpecifier_1);
	              Type methodType = method.getReturnType();
	              String _displayValue1 = Type.declarationTypeModif(methodType);
	              _builder.append(_displayValue1);
//	              String _displayValue = Type.declarationType(methodType);
//	              _builder.append(_displayValue);
	              _builder.append(" ");
	              String _adjustJavaName_1 = this.adjustJavaName(method.getJavaName()).substring(1);
	              _builder.append(_adjustJavaName_1);
	              _builder.append("(");
	              CharSequence _arguments_1 = this.arguments(method);
	              _builder.append(_arguments_1);
	              _builder.append(")");
	              CharSequence _bodyOfMethod = this.bodyOfMethod(model,method);
	              _builder.append(_bodyOfMethod);
	              _builder.newLineIfNotEmpty();
	              _builder.newLine();

	          }
	        }
	
	    return _builder;
	    }
  
  private CharSequence bodyOfMethod(Model model, Method method) {
	  StringConcatenation _builder = new StringConcatenation();
	  Type returnType = method.getReturnType();
	  CharSequence content = returnType.contentOfMethod(model,method);
	  _builder.append(content);
	return _builder.toString();
}

public String checkDeprecated(final Method method) {
	    String _xifexpression = null;
	    boolean _isDeprecated = method.isDeprecated();
	    if (_isDeprecated) {
	      _xifexpression = "@Deprecated\n";
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
  
  public String safeVarArgsFinal(final Method method) {
	    String _xifexpression = null;
	    if (((!method.isStatic()) && method.needsSafeVararg())) {
	      _xifexpression = "final ";
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
  
  public boolean hasReturnType(final Method method) {
	    return (!((method.getReturnType() instanceof NativeType) && (((NativeType) method.getReturnType()).getTypeName() == "void")));
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
	  
  
  
}

//CharSequence _unionTypes = this.unionTypes(definition);
//_builder.append(_unionTypes, "    ");
//_builder.newLineIfNotEmpty();
//_builder.append("    ");
//CharSequence _fields = this.fields(definition);
//_builder.append(_fields, "    ");
//_builder.newLineIfNotEmpty();
//_builder.append("    ");
//CharSequence _constructors = this.constructors(definition);
//_builder.append(_constructors, "    ");
//_builder.newLineIfNotEmpty();
//_builder.append("    ");
//CharSequence _nonFieldAttributes = this.nonFieldAttributes(definition);
//_builder.append(_nonFieldAttributes, "    ");
//_builder.newLineIfNotEmpty();
//_builder.append("    ");
//CharSequence _methods = this.methods(definition);
//_builder.append(_methods, "    ");
//_builder.newLineIfNotEmpty();
//_builder.append("    ");
//String _fix = MarginFixer.INSTANCE.fix(templateFiller.fill(definition, basePackageName));
//_builder.append(_fix, "    ");
//_builder.newLineIfNotEmpty();
//final Function<String, CharSequence> _function = (String description) -> {
//return this.javadoc(description);
//};
//CharSequence _orElse = this.documentation.getClassDescription(definition.getName()).<CharSequence>map(_function).orElse("");
//_builder.append(_orElse);
//_builder.newLineIfNotEmpty();
//_builder.append("@JsType(namespace = JsPackage.GLOBAL, name=\"");
//String _jsTypeName = definition.getJsTypeName();
//_builder.append(_jsTypeName);
//_builder.append("\", isNative = true)");
//_builder.newLineIfNotEmpty();
  
  
  
//public CharSequence constants(final InterfaceDefinition definition) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<Constant> _constants = definition.getConstants();
//      boolean _hasElements = false;
//      for(final Constant constant : _constants) {
//        if (!_hasElements) {
//          _hasElements = true;
//        }
//        _builder.append("public static ");
//        String _displayValue = constant.getType().displayValue();
//        _builder.append(_displayValue);
//        _builder.append(" ");
//        String _name = constant.getName();
//        _builder.append(_name);
//        _builder.append("; /* ");
//        String _value = constant.getValue();
//        _builder.append(_value);
//        _builder.append(" */");
//        _builder.newLineIfNotEmpty();
//      }
//      if (_hasElements) {
//        _builder.append("\n");
//      }
//    }
//    return _builder;
//  }
//}
//_builder.append("    ");
//_builder.append("private ");
//String type = attribute.getType().getTypeName();
//String name = attribute.getName();
//if (attribute.getType() instanceof ObjectType) type = "P" + type;
//if (attribute.getType() instanceof ArrayType) type = "P" + type.replace("Array", "[]");
//if (attribute.getType() instanceof UnionType) {
//}
//_builder.append(type + " ");
//_builder.append(name + ";");
//// _builder.append("\\ "+ "attr is static?" + attribute.isStatic() + "   " + "attr is readOnly?" + attribute.isReadOnly() );
//_builder.newLineIfNotEmpty();
//}
//public CharSequence constructors(final InterfaceDefinition definition) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<Constructor> _constructors = definition.getConstructors();
//      for(final Constructor constructor : _constructors) {
//        {
//          boolean _isHidden = constructor.isHidden();
//          if (_isHidden) {
//            _builder.append("private ");
//            String _name = definition.getName();
//            _builder.append(_name);
//            _builder.append("(");
//            CharSequence _arguments = this.arguments(constructor);
//            _builder.append(_arguments);
//            _builder.append("){");
//            _builder.newLineIfNotEmpty();
//            {
//              Type _parent = definition.getParent();
//              boolean _tripleNotEquals = (_parent != null);
//              if (_tripleNotEquals) {
//                _builder.append("    ");
//                _builder.append("super(");
//                CharSequence _superArguments = this.superArguments(constructor);
//                _builder.append(_superArguments, "    ");
//                _builder.append(");");
//                _builder.newLineIfNotEmpty();
//              }
//            }
//            _builder.append("}");
//            _builder.newLine();
//            _builder.newLine();
//          } else {
//            String _safeVarArgs = this.safeVarArgs(constructor);
//            _builder.append(_safeVarArgs);
//            _builder.newLineIfNotEmpty();
//            _builder.append("@JsConstructor");
//            _builder.newLine();
//            _builder.append("public ");
//            String _name_1 = definition.getName();
//            _builder.append(_name_1);
//            _builder.append("(");
//            CharSequence _arguments_1 = this.arguments(constructor);
//            _builder.append(_arguments_1);
//            _builder.append("){");
//            _builder.newLineIfNotEmpty();
//            {
//              Type _parent_1 = definition.getParent();
//              boolean _tripleNotEquals_1 = (_parent_1 != null);
//              if (_tripleNotEquals_1) {
//                _builder.append("    ");
//                _builder.append("super(");
//                CharSequence _superArguments_1 = this.superArguments(constructor);
//                _builder.append(_superArguments_1, "    ");
//                _builder.append(");");
//                _builder.newLineIfNotEmpty();
//              }
//            }
//            _builder.append("}");
//            _builder.newLine();
//            _builder.newLine();
//          }
//        }
//      }
//    }
//    return _builder;
//  }
//  
//  public CharSequence fields(final InterfaceDefinition definition) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<Attribute> _attributes = definition.getAttributes();
//      for(final Attribute attribute : _attributes) {
//        {
//          Type _enumSubstitutionType = attribute.getEnumSubstitutionType();
//          boolean _tripleNotEquals = (_enumSubstitutionType != null);
//          if (_tripleNotEquals) {
//            String _checkDeprecated = this.checkDeprecated(attribute);
//            _builder.append(_checkDeprecated);
//            _builder.newLineIfNotEmpty();
//            _builder.append("@JsProperty(name=\"");
//            String _name = attribute.getName();
//            _builder.append(_name);
//            _builder.append("\")");
//            _builder.newLineIfNotEmpty();
//            _builder.append("private ");
//            String _staticModifier = this.staticModifier(attribute);
//            _builder.append(_staticModifier);
//            String _displayValue = attribute.getEnumSubstitutionType().displayValue();
//            _builder.append(_displayValue);
//            _builder.append(" ");
//            String _adjustJavaName = this.adjustJavaName(attribute.getName());
//            _builder.append(_adjustJavaName);
//            _builder.append(";");
//            _builder.newLineIfNotEmpty();
//            _builder.newLine();
//          } else {
//            Type _type = attribute.getType();
//            if ((_type instanceof UnionType)) {
//              String _checkDeprecated_1 = this.checkDeprecated(attribute);
//              _builder.append(_checkDeprecated_1);
//              _builder.newLineIfNotEmpty();
//              _builder.append("@JsProperty(name=\"");
//              String _name_1 = attribute.getName();
//              _builder.append(_name_1);
//              _builder.append("\")");
//              _builder.newLineIfNotEmpty();
//              _builder.append("private ");
//              String _staticModifier_1 = this.staticModifier(attribute);
//              _builder.append(_staticModifier_1);
//              String _unionTypeName = this.unionTypeName(attribute.getType(), definition);
//              _builder.append(_unionTypeName);
//              _builder.append(" ");
//              String _adjustJavaName_1 = this.adjustJavaName(attribute.getName());
//              _builder.append(_adjustJavaName_1);
//              _builder.append(";");
//              _builder.newLineIfNotEmpty();
//              _builder.newLine();
//            } else {
//              boolean _isStatic = attribute.isStatic();
//              if (_isStatic) {
//                String _checkDeprecated_2 = this.checkDeprecated(attribute);
//                _builder.append(_checkDeprecated_2);
//                _builder.newLineIfNotEmpty();
//                _builder.append("@JsProperty(name=\"");
//                String _jsPropertyName = attribute.getJsPropertyName();
//                _builder.append(_jsPropertyName);
//                _builder.append("\")");
//                _builder.newLineIfNotEmpty();
//                _builder.append("public static ");
//                String _displayValue_1 = attribute.getType().displayValue();
//                _builder.append(_displayValue_1);
//                _builder.append(" ");
//                String _adjustJavaName_2 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_2);
//                _builder.append(";");
//                _builder.newLineIfNotEmpty();
//                _builder.newLine();
//              } else {
//                boolean _eventHandler = this.eventHandler(attribute);
//                if (_eventHandler) {
//                  String _checkDeprecated_3 = this.checkDeprecated(attribute);
//                  _builder.append(_checkDeprecated_3);
//                  _builder.newLineIfNotEmpty();
//                  _builder.append("@JsProperty(name=\"");
//                  String _name_2 = attribute.getName();
//                  _builder.append(_name_2);
//                  _builder.append("\")");
//                  _builder.newLineIfNotEmpty();
//                  _builder.append("private ");
//                  String _staticModifier_2 = this.staticModifier(attribute);
//                  _builder.append(_staticModifier_2);
//                  String _displayValue_2 = attribute.getType().displayValue();
//                  _builder.append(_displayValue_2);
//                  _builder.append(" ");
//                  String _adjustJavaName_3 = this.adjustJavaName(attribute.getName());
//                  _builder.append(_adjustJavaName_3);
//                  _builder.append(";");
//                  _builder.newLineIfNotEmpty();
//                  _builder.newLine();
//                }
//              }
//            }
//          }
//        }
//      }
//    }
//    return _builder;
//  }
//  
//  public CharSequence nonFieldAttributes(final InterfaceDefinition definition) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<Attribute> _attributes = definition.getAttributes();
//      for(final Attribute attribute : _attributes) {
//        {
//          Type _enumSubstitutionType = attribute.getEnumSubstitutionType();
//          boolean _tripleNotEquals = (_enumSubstitutionType != null);
//          if (_tripleNotEquals) {
//            {
//              boolean _isWriteOnly = attribute.isWriteOnly();
//              boolean _not = (!_isWriteOnly);
//              if (_not) {
//                {
//                  Type _type = attribute.getType();
//                  if ((_type instanceof ArrayType)) {
//                    String _checkDeprecated = this.checkDeprecated(attribute);
//                    _builder.append(_checkDeprecated);
//                    _builder.newLineIfNotEmpty();
//                    _builder.append("@JsOverlay");
//                    _builder.newLine();
//                    _builder.append("public final ");
//                    String _staticModifier = this.staticModifier(attribute);
//                    _builder.append(_staticModifier);
//                    String _displayValue = attribute.getType().displayValue();
//                    _builder.append(_displayValue);
//                    _builder.append(" get");
//                    String _firstUpper = StringExtensions.toFirstUpper(attribute.getName());
//                    _builder.append(_firstUpper);
//                    _builder.append("(){");
//                    _builder.newLineIfNotEmpty();
//                    _builder.append("   ");
//                    _builder.append("return ");
//                    String _replace = attribute.getType().displayValue().replace("[]", "");
//                    _builder.append(_replace, "   ");
//                    _builder.append(".ofArray(");
//                    String _adjustJavaName = this.adjustJavaName(attribute.getName());
//                    _builder.append(_adjustJavaName, "   ");
//                    _builder.append(");");
//                    _builder.newLineIfNotEmpty();
//                    _builder.append("}");
//                    _builder.newLine();
//                    _builder.newLine();
//                  } else {
//                    String _checkDeprecated_1 = this.checkDeprecated(attribute);
//                    _builder.append(_checkDeprecated_1);
//                    _builder.newLineIfNotEmpty();
//                    _builder.append("@JsOverlay");
//                    _builder.newLine();
//                    _builder.append("public final ");
//                    String _staticModifier_1 = this.staticModifier(attribute);
//                    _builder.append(_staticModifier_1);
//                    String _displayValue_1 = attribute.getType().displayValue();
//                    _builder.append(_displayValue_1);
//                    _builder.append(" get");
//                    String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName());
//                    _builder.append(_firstUpper_1);
//                    _builder.append("(){");
//                    _builder.newLineIfNotEmpty();
//                    _builder.append("   ");
//                    _builder.append("return ");
//                    String _displayValue_2 = attribute.getType().displayValue();
//                    _builder.append(_displayValue_2, "   ");
//                    _builder.append(".of(");
//                    String _adjustJavaName_1 = this.adjustJavaName(attribute.getName());
//                    _builder.append(_adjustJavaName_1, "   ");
//                    _builder.append(");");
//                    _builder.newLineIfNotEmpty();
//                    _builder.append("}");
//                    _builder.newLine();
//                    _builder.newLine();
//                  }
//                }
//              }
//            }
//            {
//              boolean _isReadOnly = attribute.isReadOnly();
//              boolean _not_1 = (!_isReadOnly);
//              if (_not_1) {
//                String _checkDeprecated_2 = this.checkDeprecated(attribute);
//                _builder.append(_checkDeprecated_2);
//                _builder.newLineIfNotEmpty();
//                _builder.append("@JsOverlay");
//                _builder.newLine();
//                _builder.append("public final ");
//                String _staticModifier_2 = this.staticModifier(attribute);
//                _builder.append(_staticModifier_2);
//                _builder.append("void set");
//                String _firstUpper_2 = StringExtensions.toFirstUpper(attribute.getName());
//                _builder.append(_firstUpper_2);
//                _builder.append("(");
//                String _displayValue_3 = attribute.getType().displayValue();
//                _builder.append(_displayValue_3);
//                _builder.append(" ");
//                String _adjustJavaName_2 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_2);
//                _builder.append("){");
//                _builder.newLineIfNotEmpty();
//                _builder.append("   ");
//                String _staticThis = this.staticThis(attribute);
//                _builder.append(_staticThis, "   ");
//                _builder.append(".");
//                String _adjustJavaName_3 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_3, "   ");
//                _builder.append(" = ");
//                String _adjustJavaName_4 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_4, "   ");
//                _builder.append(".getInternalValue();");
//                _builder.newLineIfNotEmpty();
//                _builder.append("}");
//                _builder.newLine();
//                _builder.newLine();
//              }
//            }
//          } else {
//            Type _type_1 = attribute.getType();
//            if ((_type_1 instanceof UnionType)) {
//              {
//                boolean _isWriteOnly_1 = attribute.isWriteOnly();
//                boolean _not_2 = (!_isWriteOnly_1);
//                if (_not_2) {
//                  String _checkDeprecated_3 = this.checkDeprecated(attribute);
//                  _builder.append(_checkDeprecated_3);
//                  _builder.newLineIfNotEmpty();
//                  _builder.append("@JsOverlay");
//                  _builder.newLine();
//                  _builder.append("public ");
//                  String _staticModifier_3 = this.staticModifier(attribute);
//                  _builder.append(_staticModifier_3);
//                  _builder.append("final ");
//                  String _unionTypeName = this.unionTypeName(attribute.getType(), definition);
//                  _builder.append(_unionTypeName);
//                  _builder.append(" get");
//                  String _firstUpper_3 = StringExtensions.toFirstUpper(attribute.getName());
//                  _builder.append(_firstUpper_3);
//                  _builder.append("(){");
//                  _builder.newLineIfNotEmpty();
//                  _builder.append("    ");
//                  _builder.append("return ");
//                  String _staticThis_1 = this.staticThis(attribute);
//                  _builder.append(_staticThis_1, "    ");
//                  _builder.append(".");
//                  String _adjustJavaName_5 = this.adjustJavaName(attribute.getName());
//                  _builder.append(_adjustJavaName_5, "    ");
//                  _builder.append(";");
//                  _builder.newLineIfNotEmpty();
//                  _builder.append("}");
//                  _builder.newLine();
//                  _builder.newLine();
//                }
//              }
//              {
//                boolean _isReadOnly_1 = attribute.isReadOnly();
//                boolean _not_3 = (!_isReadOnly_1);
//                if (_not_3) {
//                  {
//                    Type _type_2 = attribute.getType();
//                    List<Type> _types = ((UnionType) _type_2).getTypes();
//                    for(final Type type : _types) {
//                      String _checkDeprecated_4 = this.checkDeprecated(attribute);
//                      _builder.append(_checkDeprecated_4);
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("@JsOverlay");
//                      _builder.newLine();
//                      _builder.append("public ");
//                      String _staticModifier_4 = this.staticModifier(attribute);
//                      _builder.append(_staticModifier_4);
//                      _builder.append("final void set");
//                      String _firstUpper_4 = StringExtensions.toFirstUpper(attribute.getName());
//                      _builder.append(_firstUpper_4);
//                      _builder.append("(");
//                      String _displayValue_4 = type.displayValue();
//                      _builder.append(_displayValue_4);
//                      _builder.append(" ");
//                      String _adjustJavaName_6 = this.adjustJavaName(attribute.getName());
//                      _builder.append(_adjustJavaName_6);
//                      _builder.append("){");
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("    ");
//                      String _staticThis_2 = this.staticThis(attribute);
//                      _builder.append(_staticThis_2, "    ");
//                      _builder.append(".");
//                      String _adjustJavaName_7 = this.adjustJavaName(attribute.getName());
//                      _builder.append(_adjustJavaName_7, "    ");
//                      _builder.append(" = ");
//                      String _displayValue_5 = attribute.getType().displayValue();
//                      _builder.append(_displayValue_5, "    ");
//                      _builder.append(".of(");
//                      String _adjustJavaName_8 = this.adjustJavaName(attribute.getName());
//                      _builder.append(_adjustJavaName_8, "    ");
//                      _builder.append(");");
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("}");
//                      _builder.newLine();
//                      _builder.newLine();
//                    }
//                  }
//                }
//              }
//            } else {
//              boolean _eventHandler = this.eventHandler(attribute);
//              if (_eventHandler) {
//                String _checkDeprecated_5 = this.checkDeprecated(attribute);
//                _builder.append(_checkDeprecated_5);
//                _builder.newLineIfNotEmpty();
//                _builder.append("@JsOverlay");
//                _builder.newLine();
//                _builder.append("public ");
//                String _staticModifier_5 = this.staticModifier(attribute);
//                _builder.append(_staticModifier_5);
//                _builder.append("final ");
//                String _displayValue_6 = attribute.getType().displayValue();
//                _builder.append(_displayValue_6);
//                _builder.append(" get");
//                String _eventHandlerName = this.eventHandlerName(attribute);
//                _builder.append(_eventHandlerName);
//                _builder.append("(){");
//                _builder.newLineIfNotEmpty();
//                _builder.append("    ");
//                _builder.append("return ");
//                String _staticThis_3 = this.staticThis(attribute);
//                _builder.append(_staticThis_3, "    ");
//                _builder.append(".");
//                String _adjustJavaName_9 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_9, "    ");
//                _builder.append(";");
//                _builder.newLineIfNotEmpty();
//                _builder.append("}");
//                _builder.newLine();
//                _builder.newLine();
//                String _checkDeprecated_6 = this.checkDeprecated(attribute);
//                _builder.append(_checkDeprecated_6);
//                _builder.newLineIfNotEmpty();
//                _builder.append("@JsOverlay");
//                _builder.newLine();
//                _builder.append("public ");
//                String _staticModifier_6 = this.staticModifier(attribute);
//                _builder.append(_staticModifier_6);
//                _builder.append("final void set");
//                String _eventHandlerName_1 = this.eventHandlerName(attribute);
//                _builder.append(_eventHandlerName_1);
//                _builder.append("(");
//                String _displayValue_7 = attribute.getType().displayValue();
//                _builder.append(_displayValue_7);
//                _builder.append(" ");
//                String _adjustJavaName_10 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_10);
//                _builder.append("){");
//                _builder.newLineIfNotEmpty();
//                _builder.append("    ");
//                String _staticThis_4 = this.staticThis(attribute);
//                _builder.append(_staticThis_4, "    ");
//                _builder.append(".");
//                String _adjustJavaName_11 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_11, "    ");
//                _builder.append(" = ");
//                String _adjustJavaName_12 = this.adjustJavaName(attribute.getName());
//                _builder.append(_adjustJavaName_12, "    ");
//                _builder.append(";");
//                _builder.newLineIfNotEmpty();
//                _builder.append("}");
//                _builder.newLine();
//                _builder.newLine();
//              } else {
//                boolean _isStatic = attribute.isStatic();
//                boolean _not_4 = (!_isStatic);
//                if (_not_4) {
//                  {
//                    boolean _isWriteOnly_2 = attribute.isWriteOnly();
//                    boolean _not_5 = (!_isWriteOnly_2);
//                    if (_not_5) {
//                      String _checkDeprecated_7 = this.checkDeprecated(attribute);
//                      _builder.append(_checkDeprecated_7);
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("@JsProperty(name=\"");
//                      String _name = attribute.getName();
//                      _builder.append(_name);
//                      _builder.append("\")");
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("public ");
//                      String _staticModifier_7 = this.staticModifier(attribute);
//                      _builder.append(_staticModifier_7);
//                      _builder.append("native ");
//                      String _displayValue_8 = attribute.getType().displayValue();
//                      _builder.append(_displayValue_8);
//                      _builder.append(" ");
//                      String _terPrefix = this.getterPrefix(attribute);
//                      _builder.append(_terPrefix);
//                      String _firstUpper_5 = StringExtensions.toFirstUpper(attribute.getName());
//                      _builder.append(_firstUpper_5);
//                      _builder.append("();");
//                      _builder.newLineIfNotEmpty();
//                      _builder.newLine();
//                    }
//                  }
//                  {
//                    boolean _isReadOnly_2 = attribute.isReadOnly();
//                    boolean _not_6 = (!_isReadOnly_2);
//                    if (_not_6) {
//                      String _checkDeprecated_8 = this.checkDeprecated(attribute);
//                      _builder.append(_checkDeprecated_8);
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("@JsProperty(name=\"");
//                      String _name_1 = attribute.getName();
//                      _builder.append(_name_1);
//                      _builder.append("\")");
//                      _builder.newLineIfNotEmpty();
//                      _builder.append("public ");
//                      String _staticModifier_8 = this.staticModifier(attribute);
//                      _builder.append(_staticModifier_8);
//                      _builder.append("native void set");
//                      String _firstUpper_6 = StringExtensions.toFirstUpper(attribute.getName());
//                      _builder.append(_firstUpper_6);
//                      _builder.append("(");
//                      String _displayValue_9 = attribute.getType().displayValue();
//                      _builder.append(_displayValue_9);
//                      _builder.append(" ");
//                      String _adjustJavaName_13 = this.adjustJavaName(attribute.getName());
//                      _builder.append(_adjustJavaName_13);
//                      _builder.append(");");
//                      _builder.newLineIfNotEmpty();
//                      _builder.newLine();
//                    }
//                  }
//                }
//              }
//            }
//          }
//        }
//      }
//    }
//    return _builder;
//  }
//  
//  public CharSequence methods(final InterfaceDefinition definition) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<Method> _methods = definition.getMethods();
//      for(final Method method : _methods) {
//        String _javadoc = this.javadoc(this.documentation, definition.getName(), method.getName(), method.getArguments());
//        _builder.append(_javadoc);
//        _builder.newLineIfNotEmpty();
//        {
//          String _body = method.getBody();
//          boolean _tripleNotEquals = (_body != null);
//          if (_tripleNotEquals) {
//            String _safeVarArgs = this.safeVarArgs(method);
//            _builder.append(_safeVarArgs);
//            _builder.newLineIfNotEmpty();
//            String _checkDeprecated = this.checkDeprecated(method);
//            _builder.append(_checkDeprecated);
//            _builder.newLineIfNotEmpty();
//            _builder.append("@JsOverlay");
//            _builder.newLine();
//            _builder.append("public ");
//            String _staticModifier = this.staticModifier(method);
//            _builder.append(_staticModifier);
//            _builder.append("final ");
//            CharSequence _typeSpecifier = this.typeSpecifier(method);
//            _builder.append(_typeSpecifier);
//            String _displayValue = method.getReturnType().displayValue();
//            _builder.append(_displayValue);
//            _builder.append(" ");
//            String _adjustJavaName = this.adjustJavaName(method.getJavaName());
//            _builder.append(_adjustJavaName);
//            _builder.append("(");
//            CharSequence _arguments = this.arguments(method);
//            _builder.append(_arguments);
//            _builder.append("){");
//            _builder.newLineIfNotEmpty();
//            _builder.append("    ");
//            String _replace = method.getBody().replace("$RETURN_TYPE", method.getReturnType().displayValue());
//            _builder.append(_replace, "    ");
//            _builder.newLineIfNotEmpty();
//            _builder.append("}");
//            _builder.newLine();
//            _builder.newLine();
//          } else {
//            Method _enumOverlay = method.getEnumOverlay();
//            boolean _tripleEquals = (_enumOverlay == null);
//            if (_tripleEquals) {
//              String _safeVarArgs_1 = this.safeVarArgs(method);
//              _builder.append(_safeVarArgs_1);
//              _builder.newLineIfNotEmpty();
//              String _checkDeprecated_1 = this.checkDeprecated(method);
//              _builder.append(_checkDeprecated_1);
//              _builder.newLineIfNotEmpty();
//              _builder.append("@JsMethod(name = \"");
//              String _name = method.getName();
//              _builder.append(_name);
//              _builder.append("\")");
//              _builder.newLineIfNotEmpty();
//              _builder.append("public ");
//              String _staticModifier_1 = this.staticModifier(method);
//              _builder.append(_staticModifier_1);
//              String _safeVarArgsFinal = this.safeVarArgsFinal(method);
//              _builder.append(_safeVarArgsFinal);
//              _builder.append("native ");
//              CharSequence _typeSpecifier_1 = this.typeSpecifier(method);
//              _builder.append(_typeSpecifier_1);
//              String _displayValue_1 = method.getReturnType().displayValue();
//              _builder.append(_displayValue_1);
//              _builder.append(" ");
//              String _adjustJavaName_1 = this.adjustJavaName(method.getJavaName());
//              _builder.append(_adjustJavaName_1);
//              _builder.append("(");
//              CharSequence _arguments_1 = this.arguments(method);
//              _builder.append(_arguments_1);
//              _builder.append(");");
//              _builder.newLineIfNotEmpty();
//              _builder.newLine();
//            } else {
//              String _safeVarArgs_2 = this.safeVarArgs(method);
//              _builder.append(_safeVarArgs_2);
//              _builder.newLineIfNotEmpty();
//              String _checkDeprecated_2 = this.checkDeprecated(method);
//              _builder.append(_checkDeprecated_2);
//              _builder.newLineIfNotEmpty();
//              _builder.append("@JsOverlay");
//              _builder.newLine();
//              _builder.append("public ");
//              String _staticModifier_2 = this.staticModifier(method);
//              _builder.append(_staticModifier_2);
//              _builder.append("final ");
//              CharSequence _typeSpecifier_2 = this.typeSpecifier(method);
//              _builder.append(_typeSpecifier_2);
//              String _displayValue_2 = method.getReturnType().displayValue();
//              _builder.append(_displayValue_2);
//              _builder.append(" ");
//              String _adjustJavaName_2 = this.adjustJavaName(method.getJavaName());
//              _builder.append(_adjustJavaName_2);
//              _builder.append("(");
//              CharSequence _arguments_2 = this.arguments(method);
//              _builder.append(_arguments_2);
//              _builder.append("){");
//              _builder.newLineIfNotEmpty();
//              _builder.append("    ");
//              String _hasReturn = this.hasReturn(method);
//              _builder.append(_hasReturn, "    ");
//              CharSequence _hasEnumReturnType = this.hasEnumReturnType(method);
//              _builder.append(_hasEnumReturnType, "    ");
//              String _javaName = method.getEnumOverlay().getJavaName();
//              _builder.append(_javaName, "    ");
//              _builder.append("(");
//              CharSequence _enumMethodArguments = this.enumMethodArguments(method);
//              _builder.append(_enumMethodArguments, "    ");
//              _builder.append(");");
//              _builder.newLineIfNotEmpty();
//              _builder.append("}");
//              _builder.newLine();
//              _builder.newLine();
//            }
//          }
//        }
//      }
//    }
//    return _builder;
//  }
//  
//  public String enumMethodArgument(final MethodArgument argument) {
//    String _xifexpression = null;
//    boolean _isEnumSubstitution = argument.isEnumSubstitution();
//    if (_isEnumSubstitution) {
//      String _name = argument.getName();
//      _xifexpression = (_name + ".getInternalValue()");
//    } else {
//      _xifexpression = argument.getName();
//    }
//    return _xifexpression;
//  }
//  
//  public boolean hasReturnType(final Method method) {
//    return (!((method.getReturnType() instanceof NativeType) && (((NativeType) method.getReturnType()).getTypeName() == "void")));
//  }
//  
//  public String staticThis(final Attribute attribute) {
//    String _xifexpression = null;
//    boolean _isStatic = attribute.isStatic();
//    if (_isStatic) {
//      _xifexpression = attribute.getType().displayValue();
//    } else {
//      _xifexpression = "this";
//    }
//    return _xifexpression;
//  }
//  
//  public String vararg(final MethodArgument argument) {
//    String _xifexpression = null;
//    boolean _isVararg = argument.isVararg();
//    if (_isVararg) {
//      _xifexpression = "...";
//    }
//    return _xifexpression;
//  }
//  
//  public String staticModifier(final Attribute attribute) {
//    String _xifexpression = null;
//    boolean _isStatic = attribute.isStatic();
//    if (_isStatic) {
//      _xifexpression = "static ";
//    }
//    return _xifexpression;
//  }
//  
//  public String staticModifier(final Method method) {
//    String _xifexpression = null;
//    boolean _isStatic = method.isStatic();
//    if (_isStatic) {
//      _xifexpression = "static ";
//    }
//    return _xifexpression;
//  }
//  
//  public String hasReturn(final Method method) {
//    String _xifexpression = null;
//    boolean _hasReturnType = this.hasReturnType(method);
//    if (_hasReturnType) {
//      _xifexpression = "return ";
//    }
//    return _xifexpression;
//  }
//  
//  public CharSequence hasEnumReturnType(final Method method) {
//    CharSequence _xifexpression = null;
//    boolean _isEnumReturnType = method.isEnumReturnType();
//    if (_isEnumReturnType) {
//      StringConcatenation _builder = new StringConcatenation();
//      String _displayValue = method.getReturnType().displayValue();
//      _builder.append(_displayValue);
//      _builder.append(".of(");
//      _xifexpression = _builder;
//    }
//    return _xifexpression;
//  }
//  
//  public CharSequence arguments(final Method method) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<MethodArgument> _arguments = method.getArguments();
//      boolean _hasElements = false;
//      for(final MethodArgument argument : _arguments) {
//        if (!_hasElements) {
//          _hasElements = true;
//        } else {
//          _builder.appendImmediate(", ", "");
//        }
//        String _displayValue = argument.getType().displayValue();
//        _builder.append(_displayValue);
//        String _vararg = this.vararg(argument);
//        _builder.append(_vararg);
//        _builder.append(" ");
//        String _adjustJavaName = this.adjustJavaName(argument.getName());
//        _builder.append(_adjustJavaName);
//      }
//    }
//    return _builder;
//  }
//  
//  public CharSequence argumentNames(final Method method) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<MethodArgument> _arguments = method.getArguments();
//      boolean _hasElements = false;
//      for(final MethodArgument argument : _arguments) {
//        if (!_hasElements) {
//          _hasElements = true;
//        } else {
//          _builder.appendImmediate(", ", "");
//        }
//        String _adjustJavaName = this.adjustJavaName(argument.getName());
//        _builder.append(_adjustJavaName);
//      }
//    }
//    return _builder;
//  }
//  
//  public CharSequence enumMethodArguments(final Method method) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<MethodArgument> _arguments = method.getEnumOverlay().getArguments();
//      boolean _hasElements = false;
//      for(final MethodArgument argument : _arguments) {
//        if (!_hasElements) {
//          _hasElements = true;
//        } else {
//          _builder.appendImmediate(", ", "");
//        }
//        String _enumMethodArgument = this.enumMethodArgument(argument);
//        _builder.append(_enumMethodArgument);
//      }
//    }
//    {
//      boolean _isEnumReturnType = method.isEnumReturnType();
//      if (_isEnumReturnType) {
//        _builder.append(")");
//      }
//    }
//    return _builder;
//  }
//  
//  public CharSequence superArguments(final Constructor constructor) {
//    StringConcatenation _builder = new StringConcatenation();
//    {
//      List<MethodArgument> _superArguments = constructor.getSuperArguments();
//      boolean _hasElements = false;
//      for(final MethodArgument argument : _superArguments) {
//        if (!_hasElements) {
//          _hasElements = true;
//        } else {
//          _builder.appendImmediate(", ", "");
//        }
//        _builder.append("(");
//        String _displayValue = argument.getType().displayValue();
//        _builder.append(_displayValue);
//        _builder.append(") null");
//      }
//    }
//    return _builder;
//  }
//  
//  public boolean eventHandler(final Attribute attribute) {
//    return (attribute.getName().startsWith("on") && attribute.getType().displayValue().startsWith("EventHandler"));
//  }
//  
//  public String eventHandlerName(final Attribute attribute) {
//    String _firstUpper = StringExtensions.toFirstUpper(attribute.getName().substring(0, 2));
//    String _firstUpper_1 = StringExtensions.toFirstUpper(attribute.getName().substring(2));
//    return (_firstUpper + _firstUpper_1);
//  }
//  
//  public String checkDeprecated(final Attribute attribute) {
//    String _xifexpression = null;
//    boolean _isDeprecated = attribute.isDeprecated();
//    if (_isDeprecated) {
//      _xifexpression = "@Deprecated\n";
//    }
//    return _xifexpression;
//  }
//  
//  public String checkDeprecated(final Method method) {
//    String _xifexpression = null;
//    boolean _isDeprecated = method.isDeprecated();
//    if (_isDeprecated) {
//      _xifexpression = "@Deprecated\n";
//    }
//    return _xifexpression;
//  }
//  
//  public CharSequence generic(final InterfaceDefinition definition) {
//    CharSequence _xifexpression = null;
//    String[] _genericParameters = definition.getGenericParameters();
//    boolean _tripleNotEquals = (_genericParameters != null);
//    if (_tripleNotEquals) {
//      StringConcatenation _builder = new StringConcatenation();
//      _builder.append("<");
//      {
//        String[] _genericParameters_1 = definition.getGenericParameters();
//        boolean _hasElements = false;
//        for(final String p : _genericParameters_1) {
//          if (!_hasElements) {
//            _hasElements = true;
//          } else {
//            _builder.appendImmediate(",", "");
//          }
//          _builder.append(p);
//        }
//      }
//      _builder.append(">");
//      _xifexpression = _builder;
//    }
//    return _xifexpression;
//  }
//  
//  public CharSequence typeSpecifier(final Method method) {
//    CharSequence _xifexpression = null;
//    String _genericTypeSpecifiers = method.getGenericTypeSpecifiers();
//    boolean _tripleNotEquals = (_genericTypeSpecifiers != null);
//    if (_tripleNotEquals) {
//      StringConcatenation _builder = new StringConcatenation();
//      _builder.append("<");
//      String _genericTypeSpecifiers_1 = method.getGenericTypeSpecifiers();
//      _builder.append(_genericTypeSpecifiers_1);
//      _builder.append("> ");
//      _xifexpression = _builder;
//    }
//    return _xifexpression;
//  }
//  
//  public String safeVarArgs(final Method method) {
//    String _xifexpression = null;
//    boolean _needsSafeVararg = method.needsSafeVararg();
//    if (_needsSafeVararg) {
//      _xifexpression = "@SafeVarargs";
//    }
//    return _xifexpression;
//  }
//  
//  public String safeVarArgsFinal(final Method method) {
//    String _xifexpression = null;
//    if (((!method.isStatic()) && method.needsSafeVararg())) {
//      _xifexpression = "final ";
//    }
//    return _xifexpression;
//  }
//  
//  public String getterPrefix(final Attribute attribute) {
//    String _xifexpression = null;
//    boolean _equals = "boolean".equals(attribute.getType().displayValue());
//    if (_equals) {
//      _xifexpression = "is";
//    } else {
//      _xifexpression = "get";
//    }
//    return _xifexpression;
//  }
//  
// 
//  
//  public CharSequence imports(final String basePackageName, final InterfaceDefinition definition) {
//	    StringConcatenation _builder = new StringConcatenation();
//	      List<String> _importedPackages = definition.getImportedPackages();
//	      for(final String importName : _importedPackages) {
//	        String _xifexpression = null;
//	        boolean _startsWith = importName.startsWith(".");
//	        if (_startsWith) {
//	          _xifexpression = basePackageName;
//	        } else {
//	          _xifexpression = "";
//	        }
//	       int index = importName.lastIndexOf('.');
//	       String nameOfClassImport = importName.substring(index+1);
//	       if (!nameOfClassImport.equals("Js")) {
//	       _builder.append("import ");
//	        _builder.append(_xifexpression);
//	       _builder.append(importName.substring(0, index+1));
//	       if (!importName.substring(index+1, index +2).equals("*")) _builder.append("P");
//	       _builder.append(nameOfClassImport);
//	        _builder.append(";");
//	        _builder.newLineIfNotEmpty();
////	       if (definition.setOfNamesAttrModifiable().contains(nameOfClassImport)) {
////			       _builder.append("import ");
////			        _builder.append(_xifexpression);
////			       _builder.append(importName.substring(0, index+1));
////			       if (!importName.substring(index+1, index +2).equals("*")) _builder.append("P");
////			       _builder.append(nameOfClassImport);
////			        _builder.append(";");
////			        _builder.newLineIfNotEmpty();
//	       }
////	       }   
//	       }
//	      
//	    
//	    return _builder;
//	  }
