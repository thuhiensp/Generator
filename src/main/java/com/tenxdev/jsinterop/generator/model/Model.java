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

package com.tenxdev.jsinterop.generator.model;

import com.tenxdev.jsinterop.generator.model.interfaces.PartialDefinition;
import com.tenxdev.jsinterop.generator.model.types.ArrayType;
import com.tenxdev.jsinterop.generator.model.types.NativeType;
import com.tenxdev.jsinterop.generator.model.types.ObjectType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import com.tenxdev.jsinterop.generator.pgenerator.PonyInterfaceGenerator;
import com.tenxdev.jsinterop.generator.processing.TypeFactory;

import java.util.*;
import java.util.stream.Collectors;

public class Model {
	private static final Set<String> keyWordsReservedJava = Set.of("abstract", "assert", "boolean", "break", "byte",
			"case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends",
			"final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface",
			"long", "native", "new", "package", "private", "protected", "public", "return", "short", "static",
			"strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void",
			"volatile", "while", "true", "false", "null");

	private static final Map<String, String> typePrimimiteToObject = Map.of("int", "Integer", "char", "Character",
			"float", "Float", "double", "Double", "long", "Long", "boolean", "Boolean", "byte", "Byte", "short",
			"Short", "Void", "Void");
	private final Map<String, AbstractDefinition> definitions = new HashMap<>();
	private final Map<String, List<PartialDefinition>> deferredPartials = new HashMap<>();
	private final Map<String, List<ImplementsDefinition>> deferredImplements = new HashMap<>();
	private final List<Extension> extensions = new ArrayList<>();
	private TypeFactory typeFactory;

	public Collection<AbstractDefinition> getDefinitions() {
		return definitions.values();
	}

	public Map<String, AbstractDefinition> getDefinitionKey() {
		return definitions;
	}

	public AbstractDefinition getDefinition(String name) {
		return definitions.get(name);
	}

	public List<InterfaceDefinition> getInterfaceDefinitions() {
		return definitions.values().stream().filter(definition -> definition instanceof InterfaceDefinition)
				.map(definition -> (InterfaceDefinition) definition).collect(Collectors.toList());
	}

	public List<DictionaryDefinition> getDictionaryDefinitions() {
		return definitions.values().stream().filter(definition -> definition instanceof DictionaryDefinition)
				.map(definition -> (DictionaryDefinition) definition).collect(Collectors.toList());
	}

	public List<CallbackDefinition> getCallBackDefinitions() {
		return getDefinitions().stream().filter(definition -> definition instanceof CallbackDefinition)
				.map(definition -> (CallbackDefinition) definition).collect(Collectors.toList());
	}

	public void registerDefinition(AbstractDefinition definition, String packageSuffix, String filename)
			throws ConflictingNameException {
		definition.setPackageName(packageSuffix);
		definition.setFilename(filename);
		AbstractDefinition existingDefinition = definitions.get(definition.getName());
		if (definition instanceof PartialDefinition) {
			if (existingDefinition == null) {
				deferredPartials.computeIfAbsent(definition.getName(), key -> new ArrayList<>())
						.add((PartialDefinition) definition);
			} else {
				existingDefinition.getPartialDefinitions().add((PartialDefinition) definition);
			}
		} else if (definition instanceof ImplementsDefinition) {
			if (existingDefinition == null) {
				deferredImplements.computeIfAbsent(definition.getName(), key -> new ArrayList<>())
						.add((ImplementsDefinition) definition);
			} else {
				existingDefinition.getImplementsDefinitions().add((ImplementsDefinition) definition);
			}
		} else if (!definition.equals(existingDefinition)) {
			if (existingDefinition != null) {
				throw new ConflictingNameException(existingDefinition);
			}
			definitions.put(definition.getName(), definition);
			List<PartialDefinition> partials = deferredPartials.remove(definition.getName());
			if (partials != null) {
				definition.getPartialDefinitions().addAll(partials);
			}
			List<ImplementsDefinition> implementsDefinitions = deferredImplements.remove(definition.getName());
			if (implementsDefinitions != null) {
				definition.getImplementsDefinitions().addAll(implementsDefinitions);
			}
		}

	}

	@Override
	public String toString() {
		return "Model{" + "definitions=" + definitions + '}';
	}

	public TypeFactory getTypeFactory() {
		return typeFactory;
	}

	public void setTypeFactory(TypeFactory typeFactory) {
		this.typeFactory = typeFactory;
	}

	public List<Extension> getExtensions() {
		return extensions;
	}

	public class ConflictingNameException extends Exception {

		private final transient AbstractDefinition definition;

		private ConflictingNameException(AbstractDefinition definition) {
			this.definition = definition;
		}

		public AbstractDefinition getDefinition() {
			return definition;
		}
	}

	public Set<String> setOFParentElementInterface() {
		Set<String> res = new HashSet<String>();
		for (InterfaceDefinition interDef : getInterfaceDefinitions()) {
			Type typeOfParent = interDef.getParent();
			if (typeOfParent != null)
				res.add(typeOfParent.getTypeName().toString());
		}
		return res;
	}

	public boolean isLeaf(InterfaceDefinition interDef) {
		for (String nameOfParent : setOFParentElementInterface()) {
			if (nameOfParent.equals(interDef.getName()))
				return false;
		}
		return true;
	}

	public Set<String> setOfLeaf() {
		Set<String> res = new HashSet<String>();
		for (InterfaceDefinition interDef : getInterfaceDefinitions()) {
			if (isLeaf(interDef)) {
				res.add(interDef.getName());
			}

		}
		return res;
	}

	public List<String> listOfAllLeafTypeDistinctModifiedName() {
		return setOfLeaf().stream().sorted().map(Model::modifyName).collect(Collectors.toList());
	}

	public List<String> listOfAllLeafTypeConstructorNonArgsModified() {
		return setOfLeaf().stream().filter(name -> hasConstructorNonArg(name)).sorted().map(Model::modifyName)
				.collect(Collectors.toList());
	}

	public List<String> listOfAllLeafTypeConstructorNonArgs() {
		return setOfLeaf().stream().filter(name -> hasConstructorNonArg(name)).sorted().collect(Collectors.toList());
	}

	public List<String> listOfAllLeafTypeConstructorWithArgsModified() {
		return setOfLeaf().stream().filter(name -> hasConstructorWithArg(name)).sorted().map(Model::modifyName)
				.collect(Collectors.toList());
	}

	public List<String> listOfAllLeafTypeConstructorWithArgs() {
		return setOfLeaf().stream().filter(name -> hasConstructorWithArg(name)).sorted().collect(Collectors.toList());
	}

	public Boolean hasConstructorNonArg(String name) {
		InterfaceDefinition interDef = (InterfaceDefinition) getDefinition(name);
		for (Constructor cst : interDef.getConstructors()) {
			if (cst.getArguments().isEmpty())
				return true;
		}
		return (name.startsWith("HTML") && name.endsWith("Element")
				|| (name.startsWith("SVG") && name.endsWith("Element")) || name.equals("Window"));
	} // Window is one special interface car Window is created by client,it has not
		// constructor but we need recover it.

	public Boolean hasConstructorWithArg(String name) {
		InterfaceDefinition interDef = (InterfaceDefinition) getDefinition(name);
		if (interDef.getConstructors().isEmpty())
			return false;
		for (Constructor cst : interDef.getConstructors()) {
			if (!cst.getArguments().isEmpty())
				return true;
		}
		return false;
	}

	public List<String> listOfAllLeafTypeDistinct() {
		return setOfLeaf().stream().sorted().collect(Collectors.toList());
	}

	public boolean isRoot(InterfaceDefinition interDef) {
		return (interDef.getParent() == null);
	}

	public InterfaceDefinition getParent(InterfaceDefinition interDef) {
		String nameOfParent = interDef.getParent().getTypeName();
		return (InterfaceDefinition) definitions.get(nameOfParent);
	}

	public int numberOfOwnAttribute(InterfaceDefinition interDef) {
		if (interDef == null)
			return 0;
		return interDef.getAttributes().size();
	}

	public int numberOfOwnAttrModifiable(InterfaceDefinition interDef) {
		if (interDef == null)
			return 0;
		int res = 0;
		for (Attribute attr : interDef.getAttributes()) {
			if (!attr.isStatic() && !attr.isReadOnly()) {
				res++;
			}
		}
		return res;
	}

	public int numberOfAttrOfParentModifiable(InterfaceDefinition interDef) {
		if (interDef == null)
			return 0;
		else if (isRoot(interDef))
			return 0;
		else
			return numberOfAttrOfParentModifiable(getParent(interDef)) + numberOfOwnAttrModifiable(getParent(interDef));
	}

	public int numOfAttrOfParent(InterfaceDefinition interDef) {
		if (interDef == null)
			return 0;
		else if (isRoot(interDef))
			return 0;
		else
			return numOfAttrOfParent(getParent(interDef)) + numberOfOwnAttribute(getParent(interDef));
	}

	public Set<String> setOfAllAttributesName() {
		Set<String> res = new HashSet<String>();
		for (AbstractDefinition definition : getDefinitions()) {
			if (definition instanceof InterfaceDefinition) {
				List<Attribute> lisOfAttribute = ((InterfaceDefinition) definition).getAttributes();
				for (Attribute attr : lisOfAttribute) {
					if (!attr.isReadOnly() && !attr.isStatic()) {
						res.add(attr.getName());
					}
				}
			}
		}
		return res;
	}

	public Set<Attribute> allAtributesDiffrents() {
		return getDefinitions().stream().filter(d -> d instanceof InterfaceDefinition)
				.flatMap(d -> ((InterfaceDefinition) d).getAttributes().stream())
				.filter(atr -> !atr.isReadOnly() && !atr.isStatic()).map(AttributeWrapper::new).distinct()
				.map(atr -> atr.getAttribute()).collect(Collectors.toSet());
	}

	public List<Attribute> listOfAllAttributeSorted() {
		return allAtributesDiffrents().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
	}

	private Boolean isRepeatedName(Attribute attr0) {
		int count = 0;
		for (Attribute attr : listOfAllAttributeSorted()) {
			if (attr.getName().equals(attr0.getName())) {
				count++;
			}
			if (count > 1)
				return true;
		}
		return false;
	}

	private Boolean isEventAtrRepeatedName(Attribute attr0) {
		int count = 0;
		for (Attribute attr : allAttrsEvent()) {
			if (attr.getName().equals(attr0.getName())) {
				count++;
			}
			if (count > 1)
				return true;
		}
		return false;
	}

	public String nameEventAttributeModfied(Attribute attr0) {
		if (!isEventAtrRepeatedName(attr0))
			return Model.modifyName(attr0.getName());
		return Model.modifyName(attr0.getName()) + "_" + typeAttribute(attr0);
	}

	public String nameAttributeModified(Attribute attr0) {
		if (!isRepeatedName(attr0))
			return Model.modifyName(attr0.getName());
		return Model.modifyName(attr0.getName()) + "_" + typeAttribute(attr0);
	}

	// setOfName.stream().sorted().map(Model::modifyName).collect(Collectors.toList());
	public static String modifyName(String nameOfLeaf) {
		StringBuffer res = new StringBuffer();

		String[] r = nameOfLeaf.split("(?=\\p{Upper}\\p{Lower})");
		for (int i = 0; i < r.length; i++) {
			res.append(r[i].toUpperCase() + "_");
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	public static Set<String> getKeyWordsReservedJava() {
		return keyWordsReservedJava;
	}

	public static Map<String, String> getTypePrimimiteToObject() {
		return typePrimimiteToObject;
	}

	public List<String> listOfAllAttributeNameDistinct(Set<String> setOfName) {
		return setOfName.stream().map(Model::modifyName).collect(Collectors.toList());
	}

	public List<String> listOfAllAttributeNameDistinctLowerCase(Set<String> setOfName) {
		return setOfName.stream().sorted().collect(Collectors.toList());
	}

//    public String hierchyOfBranch(InterfaceDefinition interdef, int level) {
//    	if (interdef == null)
//    		return null;
//    	else if (isLeaf(interdef))
//			return  interdef.getName();
//		else
//		{	String res = new String();
//			String tmp = new String();
//			tmp = tmp + interdef.getName() + "has childs as: ";
//			for (InterfaceDefinition child: allChilds(interdef)) {
//				res = res + ", " + hierchyOfBranch(child);
//				
//				tmp = tmp + "," + child.getName();
//				
//			}
//			System.out.println(tmp);
//			return res;
//		}
//    }

	private void printTree(InterfaceDefinition interdef, int level) {
		for (int i = 0; i < level; i++) {
			System.out.print('\t');
		}
		System.out.println(interdef.getName());
		for (InterfaceDefinition i : allChilds(interdef)) {
			printTree(i, level + 1);
		}
	}

	public void printTree() {
		System.out.println("Root");
		for (InterfaceDefinition interdef : getInterfaceDefinitions()) {
			if (isRoot(interdef)) {
				printTree(interdef, 1);
			}
		}
	}

	public List<InterfaceDefinition> allChilds(InterfaceDefinition interdef) {
		List<InterfaceDefinition> res = new ArrayList<InterfaceDefinition>();
		for (InterfaceDefinition indef : getInterfaceDefinitions()) {
			if (indef.getParent() != null) {
				if (indef.getParent().getTypeName().equals(interdef.getName()))
					res.add(indef);
			}

		}
		return res;
	}

	public List<InterfaceDefinition> getAncestor(InterfaceDefinition interDef) {
		List<InterfaceDefinition> res = new ArrayList<InterfaceDefinition>();
		res.add(interDef);
		while (interDef.getParent() != null) {
			res.add(getParent(interDef));
			interDef = (InterfaceDefinition) definitions.get(interDef.getParent().getTypeName());
		}
		return res;

	}

	public List<InterfaceDefinition> getAncestorWithoutItself(InterfaceDefinition interDef) {
		List<InterfaceDefinition> res = new ArrayList<InterfaceDefinition>();
		while (interDef.getParent() != null) {
			res.add(getParent(interDef));
			interDef = (InterfaceDefinition) definitions.get(interDef.getParent().getTypeName());
		}
		return res;

	}

	public List<Attribute> listAttrsExtend(InterfaceDefinition interDef) {
		List<Attribute> res = new ArrayList<Attribute>();
		for (InterfaceDefinition def : getAncestor(interDef)) {
			res.addAll(def.getAttributes());
		}
		return res;
	}

	public Boolean isEventInterface(InterfaceDefinition interDef) {
		return getAncestor(interDef).contains((InterfaceDefinition) getDefinition("Event"));
	}

	public Boolean isEventTargetInterface(InterfaceDefinition interDef) {
		return getAncestor(interDef).contains((InterfaceDefinition) getDefinition("EventTarget"));
	}

	public Boolean isElementInterface(InterfaceDefinition interDef) {
		return getAncestor(interDef).contains((InterfaceDefinition) getDefinition("Element"));
	}

	public List<InterfaceDefinition> listEventInterface() {
		return getInterfaceDefinitions().stream().filter(interdef -> this.isEventInterface(interdef))
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
	}

	public List<Attribute> attrsInherit(InterfaceDefinition interDef) {
		return getAncestor(interDef).stream().map(inter -> inter.getAttributes()).flatMap(list -> list.stream())
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
	}

	public List<Attribute> attrsInheritWithoutItself(InterfaceDefinition interDef) {
		return getAncestorWithoutItself(interDef).stream().map(inter -> inter.getAttributes())
				.flatMap(list -> list.stream()).sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
	}

	public List<String> attrsInheritString(InterfaceDefinition interDef) {
		return attrsInherit(interDef).stream().map(attr -> attr.getName()).collect(Collectors.toList());
	}

	public List<Attribute> attrsSorted(InterfaceDefinition interDef) {
		return interDef.getAttributes().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.collect(Collectors.toList());
	}

	public List<String> getImportedPackagesAncestor(InterfaceDefinition interDef) {
		return getAncestor(interDef).stream().map(def -> def.getImportedPackages()).flatMap(list -> list.stream())
				.collect(Collectors.toList());
	}

	public List<Attribute> allAttrsEvent() {
		return listEventInterface().stream().map(def -> def.getAttributes()).flatMap(list -> list.stream())
				.map(AttributeWrapper::new).distinct().map(atr -> atr.getAttribute())
				.sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).collect(Collectors.toList());
	}

	public Set<Type> allAttrsEventType() {
		return allAttrsEvent().stream().map(attr -> attr.getType()).collect(Collectors.toSet());
	}

	public Set<Type> attrsEventTypeWithoutObjectType() {
		return allAttrsEventType().stream().filter(type -> !(type instanceof ObjectType)).collect(Collectors.toSet());
	}

	public Set<AbstractDefinition> attrsEventObjectTypeWithoutPObject2() {
		return allAttrsEventType().stream().filter(type -> type instanceof ObjectType)
				.filter(type -> !isInterfaceDefinition(type.getTypeName())).map(type -> type.getTypeName())
				.map(name -> getDefinition(name)).collect(Collectors.toSet());
	}

	public Boolean isInterfaceDefinition(String name) {
		return (getDefinition(name) instanceof InterfaceDefinition);
	}

	public Set<AbstractDefinition> attrsEventDefinitionArray() {
		return allAttrsEventType().stream().filter(type -> type instanceof ArrayType)
				.map(type -> ((ArrayType) type).getType()).filter(type -> !(type instanceof NativeType))
				.map(type -> type.getTypeName()).map(name -> getDefinition(name)).collect(Collectors.toSet());
	}

	public Set<AbstractDefinition> attrsEventDefinitionParameter() {
		return allAttrsEventType().stream().filter(type -> (type instanceof ParameterisedType))
				.map(type -> ((ParameterisedType) type).getBaseType()).filter(type -> !(type instanceof NativeType))
				.map(type -> type.getTypeName()).map(name -> getDefinition(name)).collect(Collectors.toSet());
	};

	public Set<Type> attrsEventTypeUnion() {
		return allAttrsEventType().stream().filter(type -> (type instanceof UnionType)).collect(Collectors.toSet());
	};

	public Set<Type> attrsEventTypeNoPObject2() {
		return allAttrsEventType().stream()
				.filter(type -> !(type instanceof ObjectType) || !isInterfaceDefinition(type.getTypeName()))
				.collect(Collectors.toSet());
	}

	public Set<AbstractDefinition> attrsEventDefinitionParameter2() {
		return allAttrsEventType().stream().filter(type -> (type instanceof ParameterisedType))
				.map(type -> ((ParameterisedType) type).getTypeParameters()).flatMap(list -> list.stream())
				.filter(type -> !(type instanceof NativeType)).map(type -> type.getTypeName())
				.map(name -> getDefinition(name)).collect(Collectors.toSet());
	};

	public Boolean isElement(InterfaceDefinition interDef) {
		return getAncestor(interDef).contains((InterfaceDefinition) getDefinition("Element"));

	}

	public Boolean typeOfLeafNoConstructor(Type type) {
		if (type instanceof ObjectType) {
			AbstractDefinition def = getDefinition(type.getTypeName());
			return (def instanceof InterfaceDefinition && isLeafNoConstructor((InterfaceDefinition) def));
		}
		if (type instanceof ArrayType) {
			String nameArray = ((ArrayType) type).getType().getTypeName();
			if (getDefinition(nameArray) != null) {
				AbstractDefinition def = getDefinition(nameArray);
				return (def instanceof InterfaceDefinition && isLeafNoConstructor((InterfaceDefinition) def));
			}
		}
		if (type instanceof ParameterisedType) {
			String namePara = ((ParameterisedType) type).getBaseType().getTypeName();
			if (getDefinition(namePara) != null) {
				AbstractDefinition def = getDefinition(namePara);
				return (def instanceof InterfaceDefinition && isLeafNoConstructor((InterfaceDefinition) def));
			}
		}

		return false;

	}

	public Boolean isLeafNoConstructor(InterfaceDefinition interDef) {
		return (isLeaf((InterfaceDefinition) interDef) && !isElement((InterfaceDefinition) interDef)
				&& ((InterfaceDefinition) interDef).getConstructors().isEmpty());
	}

	public List<String> eventAtrsName() {
		return allAttrsEvent().stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
				.map(atr -> nameEventAttributeModfied(atr)).collect(Collectors.toList());
	}

	public Set<String> eventAtrsNamesNotModified() {
		return allAttrsEvent().stream().map(atr -> atr.getName()).sorted().collect(Collectors.toSet());
	}

	public Set<Attribute> atrsEventNativeType() {
		return allAttrsEvent().stream().filter(atr -> atr.getType() instanceof NativeType).collect(Collectors.toSet());
	}

	public Set<Attribute> atrsEventObject2Type() {
		return allAttrsEvent().stream()
				.filter(atr -> atr.getType() instanceof ObjectType
						&& (getDefinition(atr.getType().getTypeName()) instanceof InterfaceDefinition))
				.collect(Collectors.toSet());
	}

	public Set<Attribute> atrsEventArrayType() {
		return allAttrsEvent().stream().filter(atr -> atr.getType() instanceof ArrayType).collect(Collectors.toSet());
	}

	public String typeAttribute(Attribute attr) {
		Type type = attr.getType();
		return atrTypeGeneral(type);
	}

	public String atrTypeGeneral(Type type) {
		if (type instanceof NativeType)
			return type.getTypeName().toUpperCase();
		else if (type instanceof ObjectType)
			return getObjectTypeGeneral((ObjectType) type);
		else if (type instanceof ArrayType)
			return getArrayTypeGeneral((ArrayType) type);
		else if (type instanceof UnionType)
			return "UNIONTYPE";
		return "OBJECT";
	}

	private String getArrayTypeGeneral(ArrayType type) {
		Type typebase = type.getType();
		if (typebase instanceof NativeType)
			return "ARRAY_" + typebase.getTypeName().toUpperCase();
		return "ARRAY_OF_OBJECT";
	}

	private String getObjectTypeGeneral(ObjectType type) {
		AbstractDefinition definition = getDefinition(type.getTypeName());
		if (definition instanceof InterfaceDefinition) {
			if (isEventInterface((InterfaceDefinition) definition))
				return "PEVENT";
			else
				return "POBJECT2";
		} else if (definition instanceof EnumDefinition)
			return "PENUM";
		else if (definition instanceof CallbackDefinition)
			return "PCALLBACK";
		else if (definition instanceof DictionaryDefinition)
			return "PDICTIONARY";
		else
			return null;
	}

	 

	public Set<Method> allMethod() {
		return getInterfaceDefinitions().stream().flatMap(def -> def.getMethods().stream()).collect(Collectors.toSet());
	}

	public Set<String> allMethodNames() {
		return getInterfaceDefinitions().stream().flatMap(def -> def.getMethods().stream())
				.map(method -> method.getJavaName()).collect(Collectors.toSet());
	}
	

	public List<String> allMethodNamesModified() {
		return allMethod().stream().distinct().sorted((o1, o2) -> o1.getJavaName().compareTo(o2.getJavaName()))
				.map(method -> Model.modifyName(getNameExtends(method)) + "_" + atrTypeGeneral(method.getReturnType())
						+ "(AttributeType." + atrTypeGeneral(method.getReturnType()) + ")")
				.distinct().collect(Collectors.toList());
	}

	public List<String> allMethodNamesModified2() {
		return allMethod().stream().sorted((o1, o2) -> o1.getJavaName().compareTo(o2.getJavaName()))
				.map(method -> getNameExtends(method) + "_TYPERETURN" + atrTypeGeneral(method.getReturnType())
						+ "(AttributeType." + atrTypeGeneral(method.getReturnType()) + ")")
				.distinct().collect(Collectors.toList());
	}
	public List<String> allMethodNamesModified3() {
		return listMethodInfos().stream()
				.map(method -> methodNameExtend(method))
				.collect(Collectors.toList());
	}
	
	public String methodNameExtend(MethodInfo method) {
		return  Model.modifyName(getNameExtends(method)) + "_" + atrTypeGeneral(method.getReturnType())
		+ "(AttributeType." + atrTypeGeneral(method.getReturnType()) + ")";
	}
	public Set<MethodInfo> getSameMethodInfos() {
		Set<MethodInfo> methodInfos = new HashSet<>();
		for (Method method : allMethod()) {
			MethodInfo element = new MethodInfo(method.getReturnType(), method.getJavaName(),method.getArguments());
			methodInfos.add(element);
		}
		return methodInfos;
	}
	
	public List<MethodInfo> listMethodInfos(){
		return getSameMethodInfos().stream().sorted((o1,o2) ->o1.getJavaName().compareTo(o2.getJavaName())).collect(Collectors.toList());
	}

	public List<String> allMethodTypeReturn() {
		return allMethod().stream().distinct().sorted((o1, o2) -> o1.getJavaName().compareTo(o2.getJavaName()))
				.map(method -> atrTypeGeneral(method.getReturnType())).collect(Collectors.toList());
	}

	public boolean hasPrimitiveReturn(String pMethodNameEnum) {
		return pMethodNameEnum.endsWith("DOUBLE)") || pMethodNameEnum.endsWith("FLOAT)")
				|| pMethodNameEnum.endsWith("LONG)") || pMethodNameEnum.endsWith("BYTE)")
				|| pMethodNameEnum.endsWith("INTEGER)") || pMethodNameEnum.endsWith("BOOLEAN)")
				|| pMethodNameEnum.endsWith("STRING)");
	}

//	public List<String> allMethodNamesModified(){
//		return  allMethodNamesModified0().stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
//	}
//	
	public List<String> allMethodNamesJs() {
		return allMethodNamesModified2().stream().map(name -> getNameNormalFromExtends(name))
				.collect(Collectors.toList());
	}
	
	public List<String> allMethodNamesJs3() {
		return getSameMethodInfos().stream().map(methodInfo -> methodInfo.getJavaName()).sorted()
				.collect(Collectors.toList());
	}

	public String getNameExtends(Method method) {
		StringBuffer extend = new StringBuffer();
		for (MethodArgument arg : method.getArguments()) {
			extend = extend.append("_TYPE" + atrTypeGeneral(arg.getType()));
		}
		return method.getJavaName() + extend.toString();
	}
	
	public String getNameExtends(MethodInfo method) {
		StringBuffer extend = new StringBuffer();
		for (MethodArgument arg : method.arguments) {
			extend = extend.append("_TYPE" + atrTypeGeneral(arg.getType()));
		}
		return method.javaName + extend.toString();
	}

	public String getNameNormalFromExtends(String nameExtend) {
		int index = nameExtend.indexOf("_TYPE");
		if (index == -1)
			return nameExtend;
		return nameExtend.substring(0, index);
	}

	public String getExtends(String nameExtend) {
		return nameExtend.replace(getNameNormalFromExtends(nameExtend), "");
	}

	private class AttributeWrapper {

		private final Attribute attribute;

		protected AttributeWrapper(Attribute attribute) {
			this.attribute = attribute;
		}

		private Attribute getAttribute() {
			return attribute;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;

			AttributeWrapper other = (AttributeWrapper) o;
			return attribute.getName().equals(other.attribute.getName())
					// && attribute.getType().equals(other.attribute.getType())
					&& typeAttribute(attribute).equals(typeAttribute(other.getAttribute()));
		}

		@Override
		public int hashCode() {
			int result = 0;
			result = 31 * result + attribute.getName().hashCode();
			// result = 31 * result + attribute.getType().hashCode();
			result = 31 * result + typeAttribute(attribute).hashCode();
			return result;
		}
	}

	public int numberMethodVoid() {
		Set<Method> voidMethods = allMethod().stream()
				.filter(method -> (method.getReturnType().getTypeName().equals("void"))).collect(Collectors.toSet());
		int res = voidMethods.size();
		return res;
	}

	public int numberMethodPrimative() {
		Set<Method> primativeMethods = allMethod().stream()
				.filter(method -> (method.getReturnType() instanceof NativeType)).collect(Collectors.toSet());
		int res = primativeMethods.size();
		return res - numberMethodVoid();
	}
	
	public class MethodInfo {
		final List<MethodArgument> arguments;
		private final String javaName;
		private final Type returnType;

		MethodInfo(Type returnType, String javaName, List<MethodArgument> arguments) {
			this.returnType = returnType;
			this.javaName = javaName;
			this.arguments = arguments;
		}

		public List<MethodArgument> getArguments() {
			return arguments;
		}
		
		 public Boolean hasArgsNativeType() {
		    	for (MethodArgument arg: arguments) {
		    		if (!(arg.getType() instanceof NativeType))
		    			return false;
		    	}
		    	return true;
		 }
		 public boolean hasPrimitiveArgsAndPrimitveReturn() {
				return hasArgsNativeType() && hasPrimitiveReturn();
			}
		 
		 public boolean hasPrimitiveReturn() {
			 return (returnType instanceof NativeType) && (!returnType.getTypeName().equals("void"));
		 }
		
		public String getJavaName() {
			return javaName;
		}
		
		public Type getReturnType() {
			return returnType;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			MethodInfo method = (MethodInfo) o;
			return methodNameExtend(this).equals(methodNameExtend(method));
		}

		@Override
		public int hashCode() {
			int result = 0;
			result = 31 * result + getNameExtends(this).hashCode();
			result = 31 * result + atrTypeGeneral(this.getReturnType()).hashCode();
			return result;
		}
		
	}

}
