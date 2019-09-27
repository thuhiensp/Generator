package com.tenxdev.jsinterop.generator.pgenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.xtend2.lib.StringConcatenation;

import com.tenxdev.jsinterop.generator.generator.jsondocs.Documentation;
import com.tenxdev.jsinterop.generator.logging.Logger;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.CallbackDefinition;
import com.tenxdev.jsinterop.generator.model.DictionaryDefinition;
import com.tenxdev.jsinterop.generator.model.EnumDefinition;
import com.tenxdev.jsinterop.generator.model.InterfaceDefinition;
import com.tenxdev.jsinterop.generator.model.Model;
import com.tenxdev.jsinterop.generator.model.Model.MethodInfo;
import com.tenxdev.jsinterop.generator.model.types.ArrayType;
import com.tenxdev.jsinterop.generator.model.types.NativeType;
import com.tenxdev.jsinterop.generator.model.types.ObjectType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import com.tenxdev.jsinterop.generator.processing.TemplateFiller;

public class PonySourceGenerator {
	private final String fileCaseException = "C:\\Users\\hle\\Desktop\\all_file_pony\\attribute_exception.property";
	private final String fileConstructorExceptionNoTreat = "C:\\Users\\hle\\Desktop\\all_file_pony\\constructor_exception_no_treat.property";
	private final String fileConstructorExceptionHTML = "C:\\Users\\hle\\Desktop\\all_file_pony\\constructor_exception.properties";
	private final static String fileConstructorHTMLExceptionManuelTreat = "C:\\Users\\hle\\Desktop\\all_file_pony\\constructor_exception_html_treat_particulier.txt";
	private final String fileServerToClientModel = "C:\\Users\\hle\\Desktop\\all_file_pony\\ServerToClientModel.txt";
	private final String fileArrayValueModel = "C:\\Users\\hle\\Desktop\\all_file_pony\\ArrayValueModel.txt";
	// private final String fileConstructorExceptionHTML =
	// "constructor_exception.property";
	private final Logger logger;

	public PonySourceGenerator(Logger logger) {
		this.logger = logger;
	}

	public void processModel(Model model, String outputDirectory, String basePackageName, Documentation documentation)
			throws IOException {
		logger.info(() -> "Generating Java source code for Pony");
		PonyInterfaceGenerator ponyInterfaceGenerator = new PonyInterfaceGenerator(documentation);
		PonyCallbackGenerator ponyCallbackGenerator = new PonyCallbackGenerator();
		PonyEnumGenerator ponyenumGenerator = new PonyEnumGenerator();
		PonyDictionaryGenerator ponyDictionaryGenerator = new PonyDictionaryGenerator();
		TemplateFiller templateFiller = new TemplateFiller(model, logger);
		int numOutput = 0;
		// int numOfAttrOfParent;
		int numOfAttrOfParentModifiable =0;
		Set<UnionType> allReturnUnionTypeInterface = new HashSet<UnionType>();
		for (AbstractDefinition definition : model.getDefinitions()) {
			Path filePath = getSourcePath(outputDirectory, "", definition.getName(),
					basePackageName);
			if (definition instanceof InterfaceDefinition) {
					numOfAttrOfParentModifiable = model.numberOfAttrOfParentModifiable((InterfaceDefinition) definition);
					outputFile(filePath, ponyInterfaceGenerator.generate(model, numOfAttrOfParentModifiable,
							basePackageName, (InterfaceDefinition) definition, templateFiller));
					++numOutput;
					allReturnUnionTypeInterface.addAll(((InterfaceDefinition) definition).getUnionReturnTypes());
			} else if (definition instanceof CallbackDefinition) {
				outputFile(filePath, ponyCallbackGenerator.generate(basePackageName, (CallbackDefinition) definition));
				++numOutput;
			} else if (definition instanceof EnumDefinition) {
				outputFile(filePath, ponyenumGenerator.generate(basePackageName, (EnumDefinition) definition));
				++numOutput;
			} else if (definition instanceof DictionaryDefinition) {
				outputFile(filePath, ponyDictionaryGenerator.generate(model,basePackageName,
						(DictionaryDefinition) definition, templateFiller));
				++numOutput;
			}
		}
		
		System.out.println("number of method return void is: " + model.numberMethodVoid());
		System.out.println("number of method return primative is: " + model.numberMethodPrimative());
		System.out.println("number of all method is " + model.allMethod().size());
		outputFileTypesOfElement(model, outputDirectory);
		outputFileAttributionNames(model, outputDirectory);
		outputFilesUnionTypes(model, allReturnUnionTypeInterface, outputDirectory);
		outputFileArrayOfCreateAllLeafType(model, outputDirectory);
		 outputFileArrayOfAllAttributes(model,outputDirectory);
		outputFileTestCreatAllLeafType(model, outputDirectory);
		outputFileEnumConstructorNonArgs(model, outputDirectory);
		outputFileEnumConstructorWithArgs(model, outputDirectory);
		outputFileArrayOfCreateLeafTypeNoArgs(model, outputDirectory);
		outputFileArrayOfCreateLeafTypeWithArgs(model, outputDirectory);
		outputCallBackNames(model, outputDirectory);
		outputFileArrayOfAllAttributes(model, outputDirectory);
		outputFileTestSetAttributes(model, outputDirectory, fileCaseException);
		outputFileTestCreateLeafTypeNoArgs(model, outputDirectory);
		outputFileConstructionEvent(model, outputDirectory, basePackageName);
		//outputFileReadEventInfo(model, outputDirectory, basePackageName);
		outputFileEnumAtributeEvent(model, outputDirectory, basePackageName);
		outputFileAttributeEventJs(model,outputDirectory,basePackageName);
		outputClassHTMLElementExcep(model,outputDirectory,basePackageName);
		outputFileConstantsOfLeafTypeNoArgJs(model,outputDirectory,basePackageName);
		outputFileConstantsServerToClientModel(outputDirectory);
		outputFileConstantsArrayValueModel(outputDirectory);
		outputFileEnumAllMethodNames(model,outputDirectory,basePackageName);
		outputFileArrayOfAllMethodNames(model,outputDirectory,basePackageName);
//		model.printTree(); to print the tree of hierchy.
		int count = numOutput;
		logger.info(
				() -> String.format("Generated %d Java file%s in %s", count, count != 1 ? "s" : "", outputDirectory));

	}

	private void outputFileArrayOfAllMethodNames(Model model, String outputDirectory, String basePackageName) throws IOException {
		CharSequence contents = arrayMethodNames(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"ArrayMethodNamesJs" + ".js");
		outputFile(filePath, contents);
	}

	private CharSequence arrayMethodNames(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("var arrayOfAllMethods = [");
		_builder.newLineIfNotEmpty();
		List<String> allMethodNames = model.allMethodNamesJs3();
		List<MethodInfo> allMethodInfo = model.listMethodInfos();
		int length = allMethodNames.size();
		for (int index = 0; index < length; index++) {
			if (allMethodInfo.get(index).hasPrimitiveArgsAndPrimitveReturn()) {
			_builder.append("   function(object,args){ return object." + allMethodNames.get(index) + "(...args);}");
			}
			else {
				_builder.append("   function(object,args){object." + allMethodNames.get(index) + "(...args);}");
			}
			if (index < length -1) _builder.append(",");
			else _builder.append("];");
			_builder.newLineIfNotEmpty();
		}
		
		return _builder.toString();
	}

	private void outputFileEnumAllMethodNames(Model model,String outputDirectory, String basePackageName) throws IOException {
		CharSequence contents = allMethodNames(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"MethodNames" + ".java");
		outputFile(filePath, contents);
	}

	private CharSequence allMethodNames(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public enum PMethodNames{");
		_builder.newLineIfNotEmpty();
		List<String> methodNames = model.allMethodNamesModified3();
		//List<String> methodNames = new ArrayList<String>();
		//methodNames.addAll(methodNamesSet);
		//List<String> methodReturnType = model.allMethodTypeReturn();
		//List<String> methodReturnType = new ArrayList<String>();
		//methodReturnType.addAll(methodReturnTypeSet);
		for (int index = 0; index < methodNames.size(); index ++) {
			_builder.append(methodNames.get(index));// + "(AttributeType." + methodReturnType.get(index) + ")");
			if (index < methodNames.size()-1) _builder.append(",");
			else _builder.append(";");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLine();
		_builder.append("private static final PMethodNames[] values = PMethodNames.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("private final AttributeType typeReturn;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("private PMethodNames(final AttributeType typeReturn) {");
		_builder.newLineIfNotEmpty();
		_builder.append("    this.typeReturn = typeReturn;");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public final short getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("   return (short) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public AttributeType getTypeReturn(){");
		_builder.newLineIfNotEmpty();
		_builder.append("     return typeReturn;");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append(" public static PMethodNames fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("    return values[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		
		
		return _builder.toString();
	}

	private void outputFileConstantsArrayValueModel(String outputDirectory) throws IOException {
		CharSequence contents = constantsArrayValueModel();
		Path filePath = Paths.get(outputDirectory,
				"constantsArrayValueModelJs" + ".js");
		outputFile(filePath, contents);
		
	}

	private CharSequence constantsArrayValueModel() throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		List<String> allServerToClient = readFileSeverToClientModel(fileArrayValueModel);
		for (int index = 0; index < allServerToClient.size(); index++) {
			_builder.append("const "+ allServerToClient.get(index) + "_ARRAY_MODEL" + " = " + index +" ;");
			_builder.newLineIfNotEmpty();
		}
		return _builder;
	
	}

	private void outputFileConstantsServerToClientModel(String outputDirectory) throws IOException {
		CharSequence contents = constantsServerToClientModelJs();
		Path filePath = Paths.get(outputDirectory,
				"constantsServerToClientModelJs" + ".js");
		outputFile(filePath, contents);
	}

	private CharSequence constantsServerToClientModelJs() throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		List<String> allServerToClient = readFileSeverToClientModel(fileServerToClientModel);
		for (int index = 0; index < allServerToClient.size(); index++) {
			_builder.append("const "+ allServerToClient.get(index) + " = " + index +" ;");
			_builder.newLineIfNotEmpty();
		}
		return _builder;
	}

	private void outputFileConstantsOfLeafTypeNoArgJs(Model model, String outputDirectory, String basePackageName) throws IOException {
		CharSequence contents = constantsOfLeafTypeNoArgJs(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"constantsOfLeafTypeNoArgJs" + ".js");
		outputFile(filePath, contents);
		
	}

	private CharSequence constantsOfLeafTypeNoArgJs(Model model, String basePackageName) throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorNonArgsModified();// not readOnly and not
		for (int index = 0; index < listOfAllNames.size(); index++) {
			if (!readFileConstructorExcepNoTreat(fileConstructorExceptionNoTreat).contains( listOfAllNames.get(index))) {
			_builder.append("const ID_" + listOfAllNames.get(index) + "  = " + index + ";");
			_builder.newLineIfNotEmpty();
			}
		}
		int length = listOfAllNames.size();
		List<String> htmlExcep = model.listOfAllAttributeNameDistinctLowerCase(readFileConstructorExcep(fileConstructorHTMLExceptionManuelTreat).keySet());
		for (String htmlExcepManuel: htmlExcep)  {
			_builder.append("const ID_HTML_" + htmlExcepManuel.toUpperCase() + "_ELEMENT = " + length++ + ";");
			_builder.newLineIfNotEmpty();
		}
		return _builder.toString();
	}

	private void outputClassHTMLElementExcep(Model model, String outputDirectory, String basePackageName) throws IOException {
		Set<String> htmlElementExcep = readFileConstructorExcep(fileConstructorHTMLExceptionManuelTreat).keySet();
		for (String tagHTMLExcep: htmlElementExcep) {
			outputHTMLExcep(model,outputDirectory,basePackageName, tagHTMLExcep,readFileConstructorExcep(fileConstructorHTMLExceptionManuelTreat).get(tagHTMLExcep) );
		}
	}

	private void outputHTMLExcep(Model model, String outputDirectory, String basePackageName, String tagHTMLExcep,
			String htmlInterfaceName) throws IOException {
		InterfaceDefinition interDef = (InterfaceDefinition) model.getDefinition(htmlInterfaceName);
		CharSequence contents = htmlElementExceptClass(model, basePackageName,tagHTMLExcep,interDef);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				interDef.getPackageName().substring(1), "HTML" +  tagHTMLExcep.substring(0, 1).toUpperCase() + tagHTMLExcep.substring(1) + "Element" + ".java");
		outputFile(filePath, contents);
	}

	private CharSequence htmlElementExceptClass(Model model, String basePackageName, String tagHTMLExcep,
			InterfaceDefinition htmlInterface) {
		StringConcatenation _builder = new StringConcatenation();
		//_builder.append("package " + basePackageName + htmlInterface.getPackageName() + ";");
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.append("import com.ponysdk.core.ui2.PLeafTypeNoArgs;");
		_builder.newLineIfNotEmpty();
		String nameOfClass =  "HTML" +  tagHTMLExcep.substring(0, 1).toUpperCase() + tagHTMLExcep.substring(1) + "Element";
		_builder.append("public class P" + nameOfClass + " extends P" + htmlInterface.getName() + "{");
		_builder.newLineIfNotEmpty();
		_builder.append("    public P" + nameOfClass + "(){");
		_builder.newLineIfNotEmpty();
//		_builder.append("         applyInit(widgetNoArgs());");
//		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("      @Override");
		_builder.newLineIfNotEmpty();
		_builder.append("     protected PLeafTypeNoArgs widgetNoArgs() {");
		_builder.newLineIfNotEmpty();
		_builder.append("       return PLeafTypeNoArgs.HTML_" + tagHTMLExcep.toUpperCase()+ "_ELEMENT;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("      @Override");
		_builder.newLineIfNotEmpty();
		_builder.append("    protected PLeafTypeWithArgs widgetWithArgs(){");
		_builder.newLineIfNotEmpty();
		_builder.append("       return null;");
		_builder.newLineIfNotEmpty();
		_builder.append("     }");
		_builder.newLine();
		_builder.append("}");
		return _builder.toString();
	}

	private void outputFileAttributeEventJs(Model model, String outputDirectory, String basePackageName) throws IOException {
		CharSequence contents = EventAttributesJs(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"EventAttributesJs" + ".js");
		outputFile(filePath, contents);
		
	}

	private CharSequence EventAttributesJs(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    var arrayOfAllEventAttributes =[");
		List<Attribute> allEventAtrs = model.allAttrsEvent();
//		Set<String> setOfAllNames = model.eventAtrsNamesNotModified();// not readOnly and not
//		List<String> listOfAllNames = model.listOfAllAttributeNameDistinctLowerCase(setOfAllNames);// not readOnly and
//																									// not stati
		for (int index = 0; index < allEventAtrs.size(); index++) {
			_builder.append("    function(object1,object2) {object1[" + index + "]" 
					+ " = object2." + allEventAtrs.get(index).getName() + ";}");
			if (index < allEventAtrs.size() - 1)
				_builder.append(",");
			else
				_builder.append("];");
			_builder.newLineIfNotEmpty();
			_builder.append("       ");
		}
		return _builder.toString();
	}

	private void outputFileEnumAtributeEvent(Model model, String outputDirectory, String basePackageName) throws IOException {
		CharSequence contents = EventAttributes(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"EventAttributesName" + ".java");
		outputFile(filePath, contents);
		
	}

	private CharSequence EventAttributes(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.append("public enum PEventAttributesName{");
		_builder.newLineIfNotEmpty();
		List<String> listOfAllNames = model.eventAtrsName();// not readOnly and not
		//List<String> setOfAllNames = model.listOfAllAttributeNameDistinctLowerCase(listOfAllNames);
		for (int index = 0; index < listOfAllNames.size(); index++) {
			_builder.append("    " + Model.modifyName(listOfAllNames.get(index)).toUpperCase());
			if (index < listOfAllNames.size() - 1)
				_builder.append(",");
			else
				_builder.append(";");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLine();
		_builder.append("    private static final PEventAttributesName[] VALUES =PEventAttributesName.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("   private PEventAttributesName() {");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public final byte getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return (byte) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();

		_builder.append("    public static PEventAttributesName fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return VALUES[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		return _builder.toString();

	}

	private void outputFileReadEventInfo(Model model, String outputDirectory, String basePackageName)
			throws IOException {
		CharSequence contents = ReadEventInfo2(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"ReadEventInfo" + ".java");
		outputFile(filePath, contents);

	}

	private CharSequence ReadEventInfo2(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		CharSequence _importGeneral = importGeneralConstructionEvent(model);
		_builder.append(_importGeneral);
		CharSequence _importEvent = importEventInfo(model, basePackageName);
		_builder.append(_importEvent);
		_builder.append("public class PReadEventInfo {");
		_builder.newLineIfNotEmpty();
		_builder.append("     private static final Logger log = LoggerFactory.getLogger(PReadEventInfo.class);");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		//toSeeAttributeObjectType(model); // just to see all objectType attribute to treat.
		//toSeeAttributeArrayType(model); // just to see all ArrayType attribute to treat.
		Set<Type> allAttrType = model. attrsEventTypeNoPObject2();
		for (Type attrType : allAttrType) {
			CharSequence _functionDecodeAttrValue = functionDecodeAttrValue(attrType, model);
			_builder.append(_functionDecodeAttrValue);
			_builder.newLineIfNotEmpty();
			_builder.newLine();
//			if (attrType instanceof NativeType) {
//				System.out.println("Haizz" + Type.declarationType(attrType));//just to check.
//			}
			_builder.newLineIfNotEmpty();
		}
		CharSequence _decodeObjectType = functionDecodePObject2("PObject2", "nameOfAttr");
		_builder.append(_decodeObjectType);
		_builder.append("}");
		return _builder.toString();
	}

	private void toSeeAttributeArrayType(Model model) {
		List<InterfaceDefinition> lstEvent = model.listEventInterface();
		for (InterfaceDefinition interDef : lstEvent) {
			for (Attribute attr : interDef.getAttributes()) {
				if (attr.getType() instanceof ArrayType) {
					System.out.println("All ArrayType to treat in Event is: Class " + interDef.getName()
							+ ", Attribute Name: " + attr.getName() + ", Type: "
							+ Type.declarationType(attr.getType()));
				}
			}
		}

	}

	private void toSeeAttributeObjectType(Model model) {
		List<InterfaceDefinition> lstEvent = model.listEventInterface();
		for (InterfaceDefinition interDef : lstEvent) {
			for (Attribute attr : interDef.getAttributes()) {
				if (attr.getType() instanceof ObjectType) {
					System.out.println("All ObjectType to treat in Event is: Class " + interDef.getName()
							+ ", Attribute Name: " + attr.getName() + ", Type: "
							+ Type.declarationType(attr.getType()));
				}
			}
		}

	}

	private CharSequence functionDecodeAttrValue(Type type, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		String typeName = Type.declarationType(type);
		String typeNameInit = type.getTypeName();
		// String typeNameModfif = typeName;
	
		if (type instanceof ParameterisedType) typeNameInit = typeNameInit + ((ParameterisedType) type).typeParametersAsString();
		if(type instanceof ObjectType && 	model.isInterfaceDefinition(type.getTypeName())) {
			_builder.append("    static PObject2 getPObject2((JsonObject eventInfo, String nameOfAttr){)");
		}
		else {
		_builder.append("     static " + typeName + " get" + typeNameInit.substring(0, 1).toUpperCase()
				+ typeNameInit.substring(1) + "(JsonObject eventInfo, String nameOfAttr){");
		}
		_builder.newLineIfNotEmpty();
		_builder.append("        log.info(\"oh, oke!: " +Type.declarationType(type) + "\");");
		_builder.newLineIfNotEmpty();
		if (type instanceof NativeType) {
			CharSequence _decodeNative = functionDecodeNative(typeName, "nameOfAttr");
			_builder.append(_decodeNative);
		} else if (type instanceof ArrayType) {
			CharSequence _decodeArrayType = functionDecodeArray(type, typeName, "nameOfAttr");
			_builder.append(_decodeArrayType);
		} else
			_builder.append("       return null;");
		_builder.newLineIfNotEmpty();
		_builder.append("     }");
		_builder.newLineIfNotEmpty();
		return _builder.toString();
	}

	private CharSequence functionDecodeArray(Type type, String typeName, String nameModif) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("       JsonValue jsonValue = eventInfo.get(" + nameModif + ");");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (jsonValue.getValueType() == ValueType.ARRAY){");
		_builder.newLineIfNotEmpty();
		_builder.append("         JsonArray " + nameModif + "Array = " + "eventInfo.getJsonArray(" + nameModif + ");");
		_builder.newLineIfNotEmpty();
		_builder.append("         int size = " + nameModif + "Array.size();");
		_builder.newLineIfNotEmpty();
		Type typeBase = ((ArrayType) type).getType();
		String typeBaseName = Type.declarationType(typeBase);
		// String typeBaseName = typeBaseNameRaw.substring(0, typeBaseNameRaw.length()
		// -2) + "Array";
		_builder.append("         " + typeBaseName + "[] " + " res = new " + typeBaseName + "[size];");
		_builder.newLineIfNotEmpty();
		_builder.append("         for (int index = 0; index <size; index ++ ){");
		_builder.newLineIfNotEmpty();
		if (typeBase instanceof NativeType) {
			if (typeBaseName.equals("String")) {
				_builder.append("          final String element = " + nameModif + "Array.getString(index);");
				_builder.newLineIfNotEmpty();
				_builder.append("          " + " res[index] = element; ");
			}
			if (typeBaseName.equals("Double")) {
				_builder.append("       JsonValue elementRaw = " + nameModif + "Array.get(index);");
				_builder.append("          if (elementRaw.getValueType() == ValueType.NUMBER)");
				_builder.append("          final double element= ((JsonNumber)elementRaw).doubleValue()");
				_builder.newLineIfNotEmpty();
				_builder.append("        else element = null;");
			}
			if (typeBaseName.equals("Integer")) {
				_builder.append("        JsonValue elementRaw = " + nameModif + "Array.get(index)");
				_builder.append("         if (elementRaw.getValueType() == ValueType.NUMBER)");
				_builder.newLineIfNotEmpty();
				_builder.append("          final int element= ((JsonNumber)elementRaw).intValue()");
				_builder.newLineIfNotEmpty();
				_builder.append("        else element = null;");
			}
			if (typeBaseName.equals("Short")) {
				_builder.append("       JsonValue elementRaw = " + nameModif + "Array.get(index)");
				_builder.append("       if (elementRaw.getValueType() == ValueType.NUMBER)");
				_builder.newLineIfNotEmpty();
				_builder.append("  final double element= (short)((JsonNumber)elementRaw).intValue()");
				_builder.newLineIfNotEmpty();
				_builder.append("        else element = null;");
			}
			if (typeBaseName.equals("Byte")) {
				_builder.append("         JsonValue elementRaw = " + nameModif + "Array.get(index)");
				_builder.append("         if (elementRaw.getValueType() == ValueType.NUMBER)");
				_builder.newLineIfNotEmpty();
				_builder.append(" final double element= (byte) ((JsonNumber)elementRaw).intValue()");
				_builder.newLineIfNotEmpty();
				_builder.append("        else element = null;");
			}
			if (typeBaseName.equals("Boolean")) {
				_builder.append("final Boolean element = " + nameModif + "Array.getBoolean(index)");
			}
		}
		if (typeBase instanceof ObjectType) {
			_builder.append("           JsonValue elementRaw = " + nameModif + "Array.get(index);");
			_builder.newLineIfNotEmpty();
			_builder.append("         " + typeBaseName + " element = null;");
			_builder.newLineIfNotEmpty();
			_builder.append("         if (elementRaw.getValueType() == ValueType.NUMBER){");
			_builder.newLineIfNotEmpty();
			_builder.append("            int idOfObject = ((JsonNumber)elementRaw).intValue();");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"           element = (" + typeBaseName + ") UIContext.get().getPObject2(idOfObject);");
			_builder.newLineIfNotEmpty();
			_builder.newLineIfNotEmpty();
			_builder.append("         }");
			_builder.newLineIfNotEmpty();
			_builder.append("          " + " res[index] = element; ");
		}

		_builder.newLineIfNotEmpty();
		_builder.append("          }");
		_builder.newLineIfNotEmpty();
		_builder.append("       return res;");
		_builder.newLineIfNotEmpty();
		_builder.append("        }");
		_builder.newLineIfNotEmpty();
		_builder.append("     return null;");
		_builder.newLineIfNotEmpty();
		return _builder.toString();
	}

	private CharSequence functionDecodePObject2(String type, String nameModif) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    private PObject2 getPObject2(JsonObject eventInfo, String idOfAttr){");
		_builder.newLineIfNotEmpty();
		_builder.append("       JsonValue jsonValue = eventInfo.get(" + nameModif + ");");
		_builder.newLineIfNotEmpty();
		_builder.append("       if (jsonValue.getValueType() == ValueType.NUMBER){");
		_builder.newLineIfNotEmpty();
		_builder.append("          int idOfObject = eventInfo.getJsonNumber(" + nameModif + ").intValue();");
		_builder.newLineIfNotEmpty();
		_builder.append(
				"          PObject2  res = (PObject2) UIContext.get().getPObject2(idOfObject);");
		_builder.newLineIfNotEmpty();
		_builder.append("          return res;");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("       return null;");
		_builder.newLineIfNotEmpty();
		_builder.append("     }");
		_builder.newLineIfNotEmpty();
		return _builder.toString();
	}

	private CharSequence functionDecodeNative(String type, String nameModif) {
		StringConcatenation _builder = new StringConcatenation();
		;
		if (type.equals("String") ) {
			_builder.append("       return eventInfo.get" + type + "(" + nameModif + ", null);");
			_builder.newLineIfNotEmpty();
		}
		if (type.equals("Boolean")) {
			_builder.append("       return eventInfo.get" + type + "(" + nameModif + ", false);");
			_builder.newLineIfNotEmpty();
		}
		if (type.equals("Double")) {
			_builder.append("       JsonValue jsonValue = eventInfo.get(" + nameModif + ");");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       if (jsonValue.getValueType() == ValueType.NUMBER) return ((JsonNumber)jsonValue).doubleValue();");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       else if (jsonValue.getValueType() == ValueType.STRING) return Double.parseDouble(((JsonString) jsonValue).getString());");
			_builder.newLineIfNotEmpty();
			_builder.append("       return null;");
			_builder.newLineIfNotEmpty();
		}
		if (type.equals("Short")) {
			_builder.append("       JsonValue jsonValue = eventInfo.get(" + nameModif + ");");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       if (jsonValue.getValueType() == ValueType.NUMBER) return (short)((JsonNumber)jsonValue).intValue();");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       else if (jsonValue.getValueType() == ValueType.STRING) return (short) Integer.parseInt(((JsonString) jsonValue).getString());");
			_builder.newLineIfNotEmpty();
			_builder.append("       return null;");
			_builder.newLineIfNotEmpty();
		}

		if (type.equals("Interger")) {
			_builder.append("       JsonValue jsonValue = eventInfo.get(" + nameModif + ");");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       if (jsonValue.getValueType() == ValueType.NUMBER) return ((JsonNumber)jsonValue).intValue();");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       else if (jsonValue.getValueType() == ValueType.STRING) return Integer.parseInt(((JsonString) jsonValue).getString());");
			_builder.newLineIfNotEmpty();
			_builder.append("       return null;");
			_builder.newLineIfNotEmpty();
		}

		if (type.equals("Object")) {
			_builder.append("            return eventInfo.getJsonObject" + "(" + nameModif + ");");
			_builder.newLineIfNotEmpty();
			_builder.newLineIfNotEmpty();
		}

		if (type.equals("Byte")) {
			_builder.append("       JsonValue jsonValue = eventInfo.get(" + nameModif + ");");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       if (jsonValue.getValueType() == ValueType.NUMBER) return (byte)((JsonNumber)jsonValue).intValue();");
			_builder.newLineIfNotEmpty();
			_builder.append(
					"       else if (jsonValue.getValueType() == ValueType.STRING) return (byte) Integer.parseInt(((JsonString) jsonValue).getString());");
			_builder.newLineIfNotEmpty();
			_builder.append("       return null;");
			_builder.newLineIfNotEmpty();
		}
		return _builder.toString();
	}

	private CharSequence importEventInfo(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("import javax.json.JsonString;");
		_builder.newLineIfNotEmpty();
		_builder.append("import com.ponysdk.core.server.application.UIContext;");
		_builder.newLineIfNotEmpty();
		Set<AbstractDefinition> typeEnum = model.attrsEventObjectTypeWithoutPObject2();
		Set<AbstractDefinition> typeArray = model.attrsEventDefinitionArray();
		Set<AbstractDefinition> typeParameterBase = model.attrsEventDefinitionParameter();
		Set<AbstractDefinition> typeParameter = model.attrsEventDefinitionParameter2();
		Set<Type> typeUnion = model.attrsEventTypeUnion();
		Set<AbstractDefinition> restImport = new HashSet<AbstractDefinition>();
		restImport.addAll(typeEnum);
		restImport.addAll(typeArray);
		restImport.addAll(typeParameter);
		restImport.addAll(typeParameterBase);
		//restImport.addAll(model.forImportReadInfoEvent());
		for (AbstractDefinition def : restImport) {
			String packageName = def.getPackageName();
			_builder.append("import " + basePackageName + packageName + ".P" + def.getName() + ";");
			_builder.newLineIfNotEmpty();
		}
		for (Type type: typeUnion) {
			_builder.append("import com.ponysdk.core.ui2.uniontype." + Type.nameModifiedOfUnionType((UnionType)type) + ";");
			_builder.newLineIfNotEmpty();
		}
		return _builder.toString();
	}
	
	private CharSequence importConstructionEvent(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("import javax.json.JsonString;");
		_builder.newLineIfNotEmpty();
		Set<String> restImport = new HashSet<String>();
		for (InterfaceDefinition event : model.listEventInterface()) {
			restImport.addAll(event.getImportedPackages());
		}
		for (final String importName : restImport) {
			String _xifexpression = null;
			boolean _startsWith = importName.startsWith(".");
			if (_startsWith) {
				_xifexpression = basePackageName;
			} else {
				_xifexpression = "";
			}

			int index = importName.lastIndexOf('.');
			String nameOfClassImport = importName.substring(index + 1);
			if (!nameOfClassImport.equals("Js")) {
				_builder.append("import ");
				_builder.append(_xifexpression);
				_builder.append(importName.substring(0, index + 1));
				if (!nameOfClassImport.equals("Map") && !importName.substring(index + 1, index + 2).equals("*"))
					_builder.append("P");
				// if (!importName.substring(index+1, index +2).equals("*"))
				// _builder.append("P");
				_builder.append(nameOfClassImport);
				_builder.append(";");
				_builder.newLineIfNotEmpty();

			}
		}
		return _builder.toString();
	}

	private void outputFileConstructionEvent(Model model, String outputDirectory, String basePackageName)
			throws IOException {
		CharSequence contents = contructionEvent(model, basePackageName);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"ConstructionEvent" + ".java");
		outputFile(filePath, contents);

	}

	private CharSequence contructionEvent(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		CharSequence _importGeneral = importGeneralConstructionEvent(model);
		_builder.append(_importGeneral);
//		CharSequence _importEvent = importEventConstructioEvent(model, basePackageName); for unique package.
//		_builder.append(_importEvent);
//		CharSequence _importEventInfo = importConstructionEvent(model, basePackageName);
//		_builder.append(_importEventInfo);
		_builder.append("public class PConstructionEvent {");
		_builder.newLineIfNotEmpty();
		_builder.append("     private static final Logger log = LoggerFactory.getLogger(PConstructionEvent.class);");
		_builder.newLineIfNotEmpty();	
		CharSequence _constructorEvent = constructorEvent(model);
		_builder.append(_constructorEvent);
		CharSequence _contructorMap = constructorMap(model);
		_builder.append(_contructorMap);
		_builder.newLineIfNotEmpty();
		CharSequence _getValue = getValue(model);
		_builder.append(_getValue);
		_builder.newLineIfNotEmpty();
		
		CharSequence _functionGetNativeType = getNativeType();
		_builder.append(_functionGetNativeType);
		_builder.newLineIfNotEmpty();
		
		CharSequence _functionGetObject2 = functionDecodePObject2("PObject2", "idOfAttr");
		_builder.append(_functionGetObject2);
		_builder.newLineIfNotEmpty();
		
		Set<Attribute> setOfatrsArrayType = model.atrsEventArrayType();
		for (Attribute atr: setOfatrsArrayType) {
			String typeName = Type.declarationType(atr.getType());
			String typeNameInit = ((ArrayType)atr.getType()).getTypeName();
			_builder.append("     private " + typeName + " get" + typeNameInit.substring(0, 1).toUpperCase()
					+ typeNameInit.substring(1) + "(JsonObject eventInfo, String idOfAttr){");
			_builder.newLineIfNotEmpty();
			CharSequence _decodeArrayType = functionDecodeArray(atr.getType(), typeName, "idOfAttr");
			_builder.append(_decodeArrayType);
			_builder.newLineIfNotEmpty();
			_builder.append("    }");
			_builder.newLineIfNotEmpty();
		}
		_builder.append("}");
		return _builder.toString();
	}

	private CharSequence getNativeType() {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    private Object getNativeType(final JsonObject eventInfo, final String key) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       log.info(\"your arrive here in getNativeType \" + eventInfo.get(key));");
		_builder.newLineIfNotEmpty();
		_builder.append("        return eventInfo.get(key);");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		return _builder.toString();
	}

	private CharSequence getValue(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    private Object getValue(final JsonObject eventInfo, final String key, final PEventAttributesName nameOfAtrs) {");
		_builder.newLineIfNotEmpty();
		_builder.append("        switch (nameOfAtrs) {");
		_builder.newLineIfNotEmpty();
		Set<Attribute> setOfAtrsNativeType = model.atrsEventNativeType();
		for(Attribute atrs: setOfAtrsNativeType) {
			_builder.append("          case " + model.nameEventAttributeModfied(atrs).toUpperCase() + ":");
			_builder.newLineIfNotEmpty();
			
		}
		_builder.append("             return getNativeType(eventInfo, key);");
		_builder.newLineIfNotEmpty();
		_builder.newLineIfNotEmpty();
		Set<Attribute> setOfatrsObject2Type = model.atrsEventObject2Type();
		for(Attribute atrs: setOfatrsObject2Type) {
			_builder.append("          case " + model.nameEventAttributeModfied(atrs).toUpperCase() + ":");
			_builder.newLineIfNotEmpty();
			
		}
		_builder.append("             return getPObject2(eventInfo, key);");
		_builder.newLineIfNotEmpty();
		_builder.newLineIfNotEmpty();
		
		Set<Attribute> setOfatrsArrayType = model.atrsEventArrayType();
		for(Attribute atrs: setOfatrsArrayType) {
			_builder.append("          case " + model.nameEventAttributeModfied(atrs).toUpperCase() + ":");
			_builder.newLineIfNotEmpty();
			_builder.append("             return get" + atrs.getType().getTypeName().substring(0, 1).toUpperCase() +  atrs.getType().getTypeName().substring(1) + "(eventInfo,key);");
			_builder.newLineIfNotEmpty();
			_builder.newLineIfNotEmpty();
			
		}
		_builder.append("          default:");
		_builder.newLineIfNotEmpty();
		_builder.append("             log.info(\"we don't treat these case\");");
		_builder.newLineIfNotEmpty();
		_builder.append("             return null;");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("     }");
		_builder.newLineIfNotEmpty();
		return _builder.toString();
		
	}

	private CharSequence constructorMap(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    private Map<PEventAttributesName, Object> constructionMap(final JsonObject eventInfo) {");
		_builder.newLineIfNotEmpty();
		_builder.append("       final Map<PEventAttributesName, Object> map = new HashMap<>();");
		_builder.newLineIfNotEmpty();
		_builder.append("       final Set<String> keySet = eventInfo.keySet();");
		_builder.newLineIfNotEmpty();
		_builder.append("       for (final String key : keySet) {");
		_builder.newLineIfNotEmpty();
		_builder.append("           final int number = Integer.parseInt(key);");
		_builder.newLineIfNotEmpty();
		_builder.append("           final PEventAttributesName nameOfAtrs = PEventAttributesName.fromRawValue(number);");
		_builder.newLineIfNotEmpty();
		_builder.append("           map.put(nameOfAtrs, getValue(eventInfo, key, nameOfAtrs));");
		_builder.newLineIfNotEmpty();
		_builder.append("       }");
		_builder.newLineIfNotEmpty();
		_builder.append("     return map;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		return _builder.toString();
	}

	private String creatEvent(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		String common = "    private static PEvent createP";
		for (InterfaceDefinition interDef : model.listEventInterface()) {
			_builder.append(common + interDef.getName() + "( final JsonObject eventInfo){");
			_builder.newLineIfNotEmpty();
			CharSequence _createEventBody = createEventBody(interDef, model);
			_builder.append(_createEventBody);
			_builder.newLineIfNotEmpty();
			_builder.append("    }");
			_builder.newLine();
		}

		return _builder.toString();
	}

	private CharSequence createEventBody(InterfaceDefinition interDef, Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("      return new P" + interDef.getName() + "(");
		List<Attribute> attrs = model.attrsInherit(interDef);
		int count = 0;
		boolean _hasElements = false;
		for (Attribute attr : attrs) {
			if (!_hasElements) {
				_hasElements = true;
			} else {
				_builder.appendImmediate(", ", "");
			}
			String typeDeclaration = Type.declarationType(attr.getType());
			Type type = attr.getType();
			String typeName = attr.getType().getTypeName();
			if (type instanceof ParameterisedType)
				typeName = typeName + ((ParameterisedType) type).typeParametersAsString();
			String name = attr.getNameModified();
			String _nameFunctionDecodeAttr;
			if (attr.getType() instanceof ObjectType && model.isInterfaceDefinition(typeName)) {
				_nameFunctionDecodeAttr = "(" + typeDeclaration + ") PReadEventInfo.get" +"PObject2(eventInfo, \"" + name + "\")";
			}
			else 
			{_nameFunctionDecodeAttr = "PReadEventInfo.get" + typeName.substring(0, 1).toUpperCase()
					+ typeName.substring(1) + "(eventInfo, \"" + name + "\")";
			}
			_builder.append(_nameFunctionDecodeAttr);
			count++;
			if (count % 3 == 0) {
				_builder.newLineIfNotEmpty();
				_builder.append("            ");
			}
		}
		_builder.append(");");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		return _builder.toString();
	}

	private String constructorEvent(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append(
				"     public PEvent constructorEvent(final String eventName, final JsonObject eventInfo){");
		_builder.newLineIfNotEmpty();
		_builder.append("      final Map<PEventAttributesName, Object> mapByAtrsName = constructionMap(eventInfo);");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("      switch (eventName) {");
		_builder.newLineIfNotEmpty();
		_builder.newLineIfNotEmpty();
		for (InterfaceDefinition interDef : model.listEventInterface()) {
			String nameOfEvent = interDef.getName();
			_builder.append("        case \"" + nameOfEvent + "\": {");
			_builder.newLineIfNotEmpty();
			_builder.append("           return new P" + nameOfEvent + "(mapByAtrsName);");
			_builder.newLineIfNotEmpty();
			_builder.append("        }");
			_builder.newLineIfNotEmpty();
		}

		_builder.append("      }");
		_builder.newLineIfNotEmpty();
		_builder.append("     log.info(\"it has not information of event\");");
		_builder.newLineIfNotEmpty();
		_builder.append("     return null;");
		_builder.newLineIfNotEmpty();
		_builder.append("     }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		return _builder.toString();
	}

	private String importEventConstructioEvent(Model model, String basePackageName) {
		StringConcatenation _builder = new StringConcatenation();
		List<InterfaceDefinition> listEvent = model.listEventInterface();
		for (InterfaceDefinition event : listEvent) {
			String packageName = event.getPackageName();
			_builder.append("import " + basePackageName + packageName + ".P" + event.getName() + ";");
			_builder.newLineIfNotEmpty();
		}
		return _builder.toString();
	}

	private String importGeneralConstructionEvent(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("import java.util.Set;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("import javax.json.JsonArray;");
		_builder.newLineIfNotEmpty();
		_builder.append("import javax.json.JsonObject;");
		_builder.newLineIfNotEmpty();
		_builder.append("import javax.json.JsonValue;");
		_builder.newLineIfNotEmpty();
		_builder.append("import javax.json.JsonNumber;");
		_builder.newLineIfNotEmpty();
		_builder.append("import javax.json.JsonString;");
		_builder.newLineIfNotEmpty();
		_builder.append("import javax.json.JsonValue.ValueType;");
		_builder.newLine();
		_builder.append("import org.slf4j.Logger;");
		_builder.newLineIfNotEmpty();
		_builder.append("import org.slf4j.LoggerFactory;");
		_builder.newLineIfNotEmpty();
		_builder.append("import com.ponysdk.core.server.application.UIContext;");
		_builder.newLineIfNotEmpty();
		_builder.append("import java.util.HashMap;");
		_builder.newLineIfNotEmpty();
		_builder.append("import java.util.Map;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		return _builder.toString();
	}

	private void outputFileTestCreateLeafTypeNoArgs(Model model, String outputDirectory) throws IOException {
		CharSequence contents = testCreateLeafTypeNoArgs(model, fileCaseException);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"testCreateLeafTypeNoArgs" + ".js");
		outputFile(filePath, contents);
	}

	private CharSequence testCreateLeafTypeNoArgs(Model model, String fileCaseException2) throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorNonArgs();
		int index = 0;
		for (index = 0; index < listOfAllNames.size(); index++) {
			String name = listOfAllNames.get(index);
			if (!readFileConstructorExcepNoTreat(fileConstructorExceptionNoTreat).contains(name)
					&& (isHTMLElementLeafType(name) || isSVGElementLeafType(name))) {
				_builder.append("    assert(arrayOfCreateLeafTypeNoArgs[" + index + "]() instanceof "
						+ listOfAllNames.get(index) + "," + "\" false" + listOfAllNames.get(index) + "\"" + ");");
				_builder.newLineIfNotEmpty();
			}
		}
		_builder.append("});");

		return _builder.toString();
	}

	private void outputFileTestSetAttributes(Model model, String outputDirectory, String fileCaseException)
			throws IOException {
		CharSequence contents = testSetterAttribute(model, fileCaseException);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"testSetAttributes" + ".js");
		outputFile(filePath, contents);

	}

	private CharSequence testSetterAttribute(Model model, String filePathException)
			throws FileNotFoundException, IOException {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("var mySVG = document.getElementById(\"mySVG\");");
		List<String> listOfConstructorNonArgs = model.listOfAllLeafTypeConstructorNonArgs();
		Set<String> setOfAllNames = model.setOfAllAttributesName();
		List<String> listOfAllNameAttrs = model.listOfAllAttributeNameDistinctLowerCase(setOfAllNames);
		List<String> attrsExcep = new ArrayList<String>();
		readFileAttributeException(filePathException, attrsExcep);
		for (String str : attrsExcep)
			System.out.println(str);
		Double valDouble = 3.0;
		Boolean valBl = true;
		Integer valInt = 999;
		String valStr = "Soleil";
		Byte valByte = 125;
		Short valShort = 3000;
		int index = 0;
		for (int index1 = 0; index1 < listOfConstructorNonArgs.size(); index1++) {
			String nameOfWidget = listOfConstructorNonArgs.get(index1);
			InterfaceDefinition interDef = (InterfaceDefinition) model.getDefinition(nameOfWidget);
			if (isHTMLElementLeafType(nameOfWidget) || isSVGElementLeafType(nameOfWidget)) {
				_builder.append("var variable" + index + " = arrayOfCreateLeafTypeNoArgs[" + index1 + "]();");
				_builder.newLineIfNotEmpty();
				for (int index2 = 0; index2 < listOfAllNameAttrs.size(); index2++) {
					String nameOfAttr = listOfAllNameAttrs.get(index2);
					String nameOfParent = null;
					Attribute attr = null;
					List<InterfaceDefinition> definitions = model.getAncestor(interDef);
					for (InterfaceDefinition definition : definitions) {
						List<Attribute> attrs = definition.getAttributesModifiable();
						for (Attribute atr : attrs) {
							if (atr.getName().equals(nameOfAttr)) {
								attr = atr;
								nameOfParent = definition.getName();
							}
						}
					}
					String element = nameOfParent + "." + nameOfAttr;
					if (attr != null && !attrsExcep.contains(element) && (attr.getType() instanceof NativeType)) {
						Type type = attr.getType();
						_builder.newLineIfNotEmpty();
//								_builder.append("console.log( \"error is from  " +  nameOfAttr + " and" + nameOfWidget +" \");");
//								_builder.newLineIfNotEmpty();
//								_builder.append(" await sleep(100);");
//								_builder.newLineIfNotEmpty();
						if (type.getTypeName().equals("Double")) {
							_builder.append("arrayOfAllAttributes[" + index2 + "](" + "variable" + index + ","
									+ valDouble + ");");
							_builder.newLineIfNotEmpty();
							_builder.append("assert( variable" + index + "." + nameOfAttr + " ==" + valDouble + ","
									+ " \" false " + nameOfWidget + ", " + nameOfAttr + "\");");
						}
						if (type.getTypeName().equals("Boolean")) {
							_builder.append(
									"arrayOfAllAttributes[" + index2 + "](" + "variable" + index + "," + valBl + ");");
							_builder.newLineIfNotEmpty();
							_builder.append("assert(variable" + index + "." + nameOfAttr + " ," + " \" false "
									+ nameOfWidget + ", " + nameOfAttr + "\");");
						}
						if (type.getTypeName().equals("Integer")) {
							_builder.append(
									"arrayOfAllAttributes[" + index2 + "](" + "variable" + index + "," + valInt + ");");
							_builder.newLineIfNotEmpty();
							_builder.append("assert( variable" + index + "." + nameOfAttr + " !=" + valInt + ","
									+ " \" false " + nameOfWidget + ", " + nameOfAttr + "\");");
						}
						if (type.getTypeName().equals("Short")) {
							_builder.append("arrayOfAllAttributes[" + index2 + "](" + "variable" + index + ","
									+ valShort + ");");
							_builder.newLineIfNotEmpty();
							_builder.append("assert( variable" + index + "." + nameOfAttr + " !=" + valShort + ","
									+ " \" false " + nameOfWidget + " ," + nameOfAttr + "\");");
						}
						if (type.getTypeName().equals("byte")) {
							_builder.append("arrayOfAllAttributes[" + index2 + "](" + "variable" + index + "," + valByte
									+ ");");
							_builder.newLineIfNotEmpty();
							_builder.append("assert( variable" + index + "." + nameOfAttr + " !=" + valByte + ","
									+ " \" false " + nameOfWidget + ", " + nameOfAttr + "\");");
						}
						if (type.getTypeName().equals("String")) {
							_builder.append("arrayOfAllAttributes[" + index2 + "](" + "variable" + index + "," + "\""
									+ valStr + "\"" + ");");
							_builder.newLineIfNotEmpty();
							_builder.append("assert(  (variable" + index + "." + nameOfAttr + ").localeCompare"
									+ "( \" " + valStr + "\" )" + "," + " \" false " + nameOfWidget + " ," + nameOfAttr
									+ "\");");
						}
						_builder.newLineIfNotEmpty();
					}
				}
			}

			index++;
		}

		return _builder.toString();
	}

	private void outputCallBackNames(Model model, String outputDirectory) throws IOException {
		CharSequence contents = callBackNames(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"callBackNames" + ".txt");
		outputFile(filePath, contents);

	}

	private CharSequence callBackNames(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		List<CallbackDefinition> listCallBack = model.getCallBackDefinitions();
		for (CallbackDefinition cb : listCallBack) {
			_builder.append(cb.getName());
			_builder.newLineIfNotEmpty();
		}

		return _builder.toString();
	}

	private void outputFileArrayOfCreateLeafTypeWithArgs(Model model, String outputDirectory) throws IOException {
		CharSequence contents = arrayOfCreateLeafTypeWithArgs(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"arrayOfCreateLeafTypeWithArgs" + ".js");
		outputFile(filePath, contents);
	}

	private CharSequence arrayOfCreateLeafTypeWithArgs(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    var arrayOfCreateLeafTypeWithArgs =[");
		_builder.newLineIfNotEmpty();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorWithArgs();
		for (int index = 0; index < listOfAllNames.size(); index++) {
			String name = listOfAllNames.get(index);
			_builder.append("    function(args) {return new " + name + "(...args); }");
			if (index < listOfAllNames.size() - 1)
				_builder.append(",");
			else
				_builder.append("];");
			_builder.newLineIfNotEmpty();
		}
		return _builder.toString();

	}

	private void outputFileArrayOfCreateLeafTypeNoArgs(Model model, String outputDirectory) throws IOException {
		CharSequence contents = arrayOfCreateLeafTypeNoArgs(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"arrayOfyOfCreateLeafTypeNoArgs" + ".js");
		outputFile(filePath, contents);

	}

	private CharSequence arrayOfCreateLeafTypeNoArgs(Model model) throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    var arrayOfCreateLeafTypeNoArgs =[");
		_builder.newLineIfNotEmpty();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorNonArgs();
		for (int index = 0; index < listOfAllNames.size(); index++) {
			String name = listOfAllNames.get(index);
			AbstractDefinition definition = model.getDefinition(name);
			if (isHTMLElementLeafType(name)) {
				if (readFileConstructorExcep(fileConstructorExceptionHTML).containsKey(name)) {
					_builder.append("    function() { return document.createElement(" + "\""
							+ readFileConstructorExcep(fileConstructorExceptionHTML).get(name) + "\"" + "); }");
				}
//				else if (readFileConstructorExcepNoTreat(fileConstructorExceptionNoTreat).contains(name)) {
//					_builder.append("    function() {return null; }");
//				} 
				else
					_builder.append("    function() { return document.createElement(" + "\""
							+ nameOfHTMLElementLeafType(name).toLowerCase() + "\"" + "); }");
			} else if (isSVGElementLeafType(name)) {
				_builder.append("    function() { return  document.createElementNS(\"http://www.w3.org/2000/svg\", "
						+ " \"" + nameOfSVGElementLeafTypeModified(nameOfSVGElementLeafType(name)) + "\"" + "); }");
			} 
//			else if (definition instanceof InterfaceDefinition
//					&& ((InterfaceDefinition) definition).getConstructors().isEmpty()) {
//				_builder.append("    function() {return null; }");
//			} 
			else if (!((InterfaceDefinition) definition).getConstructors().isEmpty())
				_builder.append("    function() {return new " + name + "(); }");
			else 
				_builder.append("    function() { return window.open(); }");
			_builder.append(",");
			_builder.newLineIfNotEmpty();
		}
		
		Boolean _hasElements = false;
		List<String> htmlExcep = model.listOfAllAttributeNameDistinctLowerCase(readFileConstructorExcep(fileConstructorHTMLExceptionManuelTreat).keySet());
		for (String htmlExcepManuel: htmlExcep) {
			if (!_hasElements == true) {
				_hasElements = true;
			}
			else {
				 _builder.appendImmediate(", ", "");
				 _builder.newLineIfNotEmpty();
				
			}
			_builder.append("    function(){return document.createElement( \"" + htmlExcepManuel + "\"); }");
			_builder.newLineIfNotEmpty();
		}
		_builder.append("];");
		
		return _builder.toString();
	}

	private CharSequence arrayOfCreateLeafTypeNoArgs1(Model model) throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    var arrayOfCreateLeafTypeNoArgs =[");
		_builder.newLineIfNotEmpty();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorNonArgs();
		for (int index = 0; index < listOfAllNames.size(); index++) {
			String name = listOfAllNames.get(index);
			AbstractDefinition definition = model.getDefinition(name);
			if (isHTMLElementLeafType(name)) {
				if (readFileConstructorExcep1(fileConstructorExceptionHTML).containsKey(name)) {
					_builder.append("    function() { return document.createElement(" + "\""
							+ readFileConstructorExcep(fileConstructorExceptionHTML).get(name) + "\"" + "); }");
				} else if (name.equals("HTMLBodyElement"))
					_builder.append("    function() {return document.body; }");
				else if (readFileConstructorExcepNoTreat(fileConstructorExceptionNoTreat).contains(name)) {
					_builder.append("    function() {return new Object(); }");
				} else
					_builder.append("    function() { return document.createElement(" + "\""
							+ nameOfHTMLElementLeafType(name).toLowerCase() + "\"" + "); }");
			} else if (isSVGElementLeafType(name)) {
				_builder.append(
						"    function() { var elementNS = document.createElementNS(\"http://www.w3.org/2000/svg\", "
								+ " \"" + nameOfSVGElementLeafTypeModified(nameOfSVGElementLeafType(name)) + "\""
								+ ");  ");
				_builder.newLineIfNotEmpty();
				_builder.append("       mySVG.appendChild(elementNS);");
				_builder.newLineIfNotEmpty();
				_builder.append("      return elementNS ;}");
			} else if (definition instanceof InterfaceDefinition
					&& ((InterfaceDefinition) definition).getConstructors().isEmpty()) {
				_builder.append("    function() {return new Object(); }");
			} else
				_builder.append("    function() {return new " + name + "(); }");
			if (index < listOfAllNames.size() - 1)
				_builder.append(",");
			else
				_builder.append("];");
			_builder.newLineIfNotEmpty();

		}
		return _builder.toString();
	}

	private void outputFileEnumConstructorWithArgs(Model model, String outputDirectory) throws IOException {
		CharSequence contents = enumOfConstructorWithArgs(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"LeafTypeWithArgs" + ".java");
		outputFile(filePath, contents);
	}

	private CharSequence enumOfConstructorWithArgs(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public enum PLeafTypeWithArgs{");
		_builder.newLineIfNotEmpty();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorWithArgsModified();// not readOnly and not
		for (int index = 0; index < listOfAllNames.size(); index++) {
			_builder.append("    " + listOfAllNames.get(index));
			if (index < listOfAllNames.size() - 1)
				_builder.append(",");
			else
				_builder.append(";");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLine();
		_builder.append("    private static final PLeafTypeWithArgs[] VALUES = PLeafTypeWithArgs.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("   private  PLeafTypeWithArgs() {");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public final byte getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return (byte) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();

		_builder.append("    public static PLeafTypeWithArgs fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return VALUES[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		return _builder.toString();
	}

	private void outputFileEnumConstructorNonArgs(Model model, String outputDirectory) throws IOException {
		CharSequence contents = enumOfConstructorNonArgs(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"LeafTypeNoArgs" + ".java");
		outputFile(filePath, contents);

	}

	private CharSequence enumOfConstructorNonArgs(Model model) throws IOException {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public enum PLeafTypeNoArgs{");
		_builder.newLineIfNotEmpty();
		List<String> listOfAllNames = model.listOfAllLeafTypeConstructorNonArgsModified();// not readOnly and not
		for (int index = 0; index < listOfAllNames.size(); index++) {
			if (!readFileConstructorExcepNoTreat(fileConstructorExceptionNoTreat).contains( listOfAllNames.get(index))) {
			_builder.append("    " + listOfAllNames.get(index) + ",");
			_builder.newLineIfNotEmpty();
			}
		}
		Boolean _hasElements = false;
		List<String> htmlExcep = model.listOfAllAttributeNameDistinctLowerCase(readFileConstructorExcep(fileConstructorHTMLExceptionManuelTreat).keySet());
		for (String htmlExcepManuel: htmlExcep)  {
			 if (!_hasElements) {
		          _hasElements = true;
		        } else {
		          _builder.appendImmediate(", ", "");
		          _builder.newLineIfNotEmpty();
		        }
			_builder.append("    HTML_" + htmlExcepManuel.toUpperCase() + "_ELEMENT" );
			
		}
		_builder.append(";");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("    private static final PLeafTypeNoArgs[] VALUES = PLeafTypeNoArgs.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("   private  PLeafTypeNoArgs() {");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public final short getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return (short) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();

		_builder.append("    public static PLeafTypeNoArgs fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return VALUES[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		return _builder.toString();
	}

	private void outputFileTestCreatAllLeafType(Model model, String outputDirectory) throws IOException {
		CharSequence contents = testCreateLeafType(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"testCreatAllLeafType" + ".js");
		outputFile(filePath, contents);

	}

	private CharSequence testCreateLeafType(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("$.when()");
		_builder.newLineIfNotEmpty();
		_builder.append("     $.getScript( 'arrayOfCreateAllLeafType.js' ),");
		_builder.newLineIfNotEmpty();
		_builder.append("     $.Deferred(function( deferred ){");
		_builder.newLineIfNotEmpty();
		_builder.append("         $( deferred.resolve );");
		_builder.newLineIfNotEmpty();
		_builder.append("     })");
		_builder.newLineIfNotEmpty();
		_builder.append(").done(function(){");
		_builder.newLine();

		List<String> listOfAllNames = model.listOfAllLeafTypeDistinct();
		int index = 0;
		for (index = 0; index < listOfAllNames.size(); index++) {
			String name = listOfAllNames.get(index);
			if (isHTMLElementLeafType(name) || isSVGElementLeafType(name)) {
				_builder.append("    assert(arrayOfCreateAllLeafType[" + index + "]() instanceof "
						+ listOfAllNames.get(index) + "," + "\" false" + listOfAllNames.get(index) + "\"" + ");");
				_builder.newLineIfNotEmpty();
			}
		}
		_builder.append("});");

		return _builder.toString();
	}

	private void outputFileArrayOfAllAttributes(Model model, String outputDirectory) throws IOException {
		CharSequence contents = arrayOfAllAttributes(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"arrayOfAllAttributes" + ".js");
		outputFile(filePath, contents);

	}

	private CharSequence arrayOfAllAttributes(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    var arrayOfAllAttributes =[");
//		Set<String> setOfAllNames = model.setOfAllAttributesName();
//		List<String> listOfAllNames = model.listOfAllAttributeNameDistinctLowerCase(setOfAllNames);// not readOnly and
		List<Attribute> allAtributes = model.listOfAllAttributeSorted();																							// not stati
		for (int index = 0; index < allAtributes.size(); index++) {
			_builder.append("    function(object,valueOfAttribute) {object." + allAtributes.get(index).getName()
					+ " = valueOfAttribute;}");
			if (index < allAtributes.size() - 1)
				_builder.append(",");
			else
				_builder.append("];");
			_builder.newLineIfNotEmpty();
			_builder.append("       ");
		}
		return _builder.toString();
	}

	private void outputFileArrayOfCreateAllLeafType(Model model, String outputDirectory) throws IOException {
		CharSequence contents = arrayOfCreateAllLeafType(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"arrayOfCreateAllLeafType" + ".js");
		outputFile(filePath, contents);

	}

	private CharSequence arrayOfCreateAllLeafType(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("    var arrayOfCreateAllLeafType =[");
		List<String> listOfAllNames = model.listOfAllLeafTypeDistinct();// not readOnly and not static.

		for (int index = 0; index < listOfAllNames.size(); index++) {
			String name = listOfAllNames.get(index);
			if (isHTMLElementLeafType(name)) {
				if (name.equals("HTMLBodyElement"))
					_builder.append("    function() {return document.body; }");
				else
					_builder.append("    function() { return document.createElement(" + "\""
							+ nameOfHTMLElementLeafType(name).toLowerCase() + "\"" + "); }");
			} else if (isSVGElementLeafType(name)) {
				_builder.append("    function() { return  document.createElementNS(\"http://www.w3.org/2000/svg\", "
						+ " \"" + nameOfSVGElementLeafTypeModified(nameOfSVGElementLeafType(name)) + "\"" + "); }");
			} else {
				_builder.append("    function() {return null ;}");
			}
			if (index < listOfAllNames.size() - 1)
				_builder.append(",");
			else
				_builder.append("];");
			_builder.newLineIfNotEmpty();

		}
		return _builder.toString();
	}

	private void outputFilesUnionTypes(Model model, Set<UnionType> allReturnUnionTypeInterface, String outputDirectory)
			throws IOException {
		for (UnionType unionType : allReturnUnionTypeInterface) {
			String nameOfClass = Type.nameModifiedOfUnionType(unionType).substring(1);
			outputFileUniontype(model, unionType, outputDirectory, nameOfClass);
		}

	}

	private void outputFileUniontype(Model model, UnionType unionType, String outputDirectory, String nameOfClass)
			throws IOException {
		CharSequence contents = generateClassForUnionType(unionType, nameOfClass);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2", "uniontype",
				nameOfClass + ".java");
		outputFile(filePath, contents);
	}

	private CharSequence generateClassForUnionType(UnionType unionType, String nameOfClass) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		//_builder.append(unionType.generateImportForUnionTypeClass());
		_builder.append(unionType.generateBodyForUnionTypeClass(nameOfClass));
		return _builder;
	}

	private void outputFileAttributionNames(Model model, String outputDirectory) throws IOException {
		CharSequence contents = nameOfAllAttributes(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"AttributeNames" + ".java");
		outputFile(filePath, contents);
	}

	private CharSequence nameOfAllAttributes1(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public enum PAttributeNames{");
		_builder.newLineIfNotEmpty();
		Set<String> setOfAllNames = model.setOfAllAttributesName();
		List<String> listOfAllNames = model.listOfAllAttributeNameDistinct(setOfAllNames);// not readOnly and not
		for (int index = 0; index < listOfAllNames.size(); index++) {
			_builder.append("    " + listOfAllNames.get(index));
			if (index < listOfAllNames.size() - 1)
				_builder.append(",");
			else
				_builder.append(";");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLine();
		_builder.append("    private static final PAttributeNames[] VALUES = PAttributeNames.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("   private  PAttributeNames() {");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public final short getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return (short) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();

		_builder.append("    public static PAttributeNames fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return VALUES[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		return _builder.toString();
	}
	
	private CharSequence nameOfAllAttributes(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public enum PAttributeNames{");
		_builder.newLineIfNotEmpty();
		//Set<Attribute> setOfAllAtr = model.setOfAllAttribute();
		//List<Attribute> listOfAllNames = model.listOfAllAttributeNameDistinct(setOfAllNames);// not readOnly and not
		List<Attribute> listOfAllAtr =  model.listOfAllAttributeSorted();
		for (int index = 0; index < listOfAllAtr.size(); index++) {
			Attribute atr = listOfAllAtr.get(index);
			_builder.append("    " + model.nameAttributeModified(atr) + "(AttributeType." + model.typeAttribute(atr) +  ")");
			if (index < listOfAllAtr.size() - 1)
				_builder.append(",");
			else
				_builder.append(";");
			_builder.newLineIfNotEmpty();
		}
		_builder.newLine();
		_builder.append("    private static final PAttributeNames[] VALUES = PAttributeNames.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		
		_builder.append("   private final AttributeType type;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("   private  PAttributeNames(final AttributeType type) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      this.type = type;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public final short getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return (short) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();
		
		_builder.append("    public AttributeType getType() {");
		_builder.newLineIfNotEmpty();
		_builder.append("          return type;");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public static PAttributeNames fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return VALUES[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		return _builder.toString();
	}


	private void outputFileTypesOfElement(Model model, String outputDirectory) throws IOException {
		CharSequence contents = getContentOfFileElementType(model);
		Path filePath = Paths.get(outputDirectory, "src", "main", "java", "com", "ponysdk", "core", "ui2",
				"LeafType" + ".java");
		outputFile(filePath, contents);
	}

	private CharSequence getContentOfFileElementType(Model model) {
		StringConcatenation _builder = new StringConcatenation();
		_builder.append("package com.ponysdk.core.ui2;");
		_builder.newLineIfNotEmpty();
		_builder.newLine();
		_builder.append("public enum PLeafType {");
		_builder.newLineIfNotEmpty();
		int index = 0;
		for (String nameOfLeaf : model.listOfAllLeafTypeDistinctModifiedName()) {
			_builder.append("    " + nameOfLeaf);
			if (index < model.listOfAllLeafTypeDistinct().size() - 1)
				_builder.append(",");
			else
				_builder.append(";");
			index++;
			_builder.newLineIfNotEmpty();
		}

		_builder.newLine();
		_builder.append("    private static final PLeafType[] VALUES = PLeafType.values();");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("   private  PLeafType() {");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.newLine();

		_builder.append("    public final short getValue() {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return (short) ordinal();");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLine();

		_builder.append("    public static PLeafType fromRawValue(final int rawValue) {");
		_builder.newLineIfNotEmpty();
		_builder.append("      return VALUES[rawValue];");
		_builder.newLineIfNotEmpty();
		_builder.append("    }");
		_builder.newLineIfNotEmpty();
		_builder.append("}");
		return _builder.toString();
	}

	private Path getSourcePath(String outputDirectory, String definitionPackage, String definitionName,
			String basePackageName) {
		return Paths.get(outputDirectory, "src", "main", "java", packageNameToPath(basePackageName + definitionPackage),
				definitionName + ".java");
	}

	private String packageNameToPath(String packageName) {
		return packageName.replace(".", File.separator);
	}

	private void outputFile(Path filePath, CharSequence contents) throws IOException {
		File parentDirectory = filePath.toFile().getParentFile();
		if (!parentDirectory.exists() && !parentDirectory.mkdirs()) {
			throw new IOException(String.format("Unable to create path %s", parentDirectory.getAbsolutePath()));
		}
		String nameOfOutputFile = filePath.getFileName().toString();
		String nameOfInputFile = "P" + nameOfOutputFile;
		File inputFile = new File(parentDirectory, nameOfInputFile);
		//File inputFile = new File(nameOfInputFile);
		try (FileWriter fileWriter = new FileWriter(inputFile)) {
			fileWriter.write(contents.toString());
		}
	}

	private boolean isHTMLElementLeafType(String name) {
		return (name.startsWith("HTML") && name.endsWith("Element"));
	}

	private boolean isSVGElementLeafType(String name) {
		return (name.startsWith("SVG") && name.endsWith("Element"));
	}

	private String nameOfHTMLElementLeafType(String name) {
		if (isHTMLElementLeafType(name))
			return name.substring(4, name.length() - 7);
		return name;
	}

	private String nameOfSVGElementLeafType(String name) {
		if (isSVGElementLeafType(name))
			return name.substring(3, name.length() - 7);
		return name;
	}

	private String nameOfSVGElementLeafTypeModified(String name) {
		String nameTemporain = "A" + Character.toLowerCase(name.charAt(0)) + name.substring(1);
		StringBuilder tpm = new StringBuilder(nameTemporain);
		for (int i = 1; i < nameTemporain.length() - 1; i++) {
			if (Character.isUpperCase(nameTemporain.charAt(i)) && Character.isUpperCase(nameTemporain.charAt(i + 1))) {
				tpm.setCharAt(i, Character.toLowerCase(nameTemporain.charAt(i)));
			}
		}
		int dernier = nameTemporain.length() - 1;
		if (Character.isUpperCase(nameTemporain.charAt(dernier))
				&& Character.isUpperCase(nameTemporain.charAt(dernier - 1)))
			tpm.setCharAt(dernier, Character.toLowerCase(nameTemporain.charAt(dernier)));
		String res = tpm.toString();
		if (res.length() >= 3)
			res = tpm.substring(0, 3).toLowerCase() + res.substring(3);
		return res.substring(1, res.length());
	}

	private void readFileAttributeException(String filePath, List<String> attrsExcep)
			throws FileNotFoundException, IOException {
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while (line != null) {
			try {
				attrsExcep.add(line);
				line = br.readLine();
			} catch (NumberFormatException ex) {
				System.out.println("error format");
			}
		}
		br.close();

	}

	private static Map<String, String> readFileConstructorExcep(String filePath) throws IOException {
		Map<String, String> res = new HashMap<String, String>();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while (line != null) {
			try {
				String[] tab = line.split("\\s");
				res.put(tab[0], tab[1]);
				line = br.readLine();
			} catch (NumberFormatException ex) {
				System.out.println("error format");
			}
		}
		br.close();
		return res;
	}


	private List<String> readFileConstructorExcepNoTreat(String filePath) throws IOException {
		List<String> res = new ArrayList<String>();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while (line != null) {
			try {
				String[] tab = line.split("\\s");
				res.add(tab[0]);
				line = br.readLine();
			} catch (NumberFormatException ex) {
				System.out.println("error format");
			}
		}
		br.close();
		return res;
	}

	private Properties readFileConstructorExcep1(String fileName) throws IOException {
		Properties prop = new Properties();
		InputStream input = new FileInputStream(fileName);
		prop.load(input);
		return prop;

	}
	
	private List<String> readFileSeverToClientModel(String filePath) throws IOException{
		List<String> res = new ArrayList<String>();
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		while (line !=null) {
			try {
				if (Pattern.matches("^\\s*$", line) || Pattern.matches("^\\s*+\\/+\\/.*$", line)) {
					line = br.readLine();
				}
				else {
				String[] tab = line.split("\\(");
				res.add(tab[0]);
				line = br.readLine();
				}
			} catch (NumberFormatException ex) {
				System.out.println("error format");
			}
		}
		br.close();
		return res;
	}
	
	static Boolean interdefsManyImpl(Model model, InterfaceDefinition interdef) throws IOException{
		Collection<String> interdefManyImpl = readFileConstructorExcep(fileConstructorHTMLExceptionManuelTreat).values();
		return interdefManyImpl.contains(interdef.getName());
				
	}
	
}
