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

package com.tenxdev.jsinterop.generator.processing.packageusage;

import com.tenxdev.jsinterop.generator.model.*;
import com.tenxdev.jsinterop.generator.model.types.PackageType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.model.types.UnionType;
import com.tenxdev.jsinterop.generator.processing.visitors.AbstractInterfaceDefinitionVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterfaceDefinitionUsageVisitor extends AbstractInterfaceDefinitionVisitor<List<String>> {

    private final PackageUsageTypeVisitor typeVisitor = new PackageUsageTypeVisitor();
    private final static MethodVisitor methodVisitor = new MethodVisitor();
    private final Type jsType;

    InterfaceDefinitionUsageVisitor(Type jsType) {
        super();
        this.jsType = jsType;
    }

    @Override
    public List<String> accept(InterfaceDefinition interfaceDefinition) {
        List<String> result = super.accept(interfaceDefinition);
       // result.add("jsinterop.annotations.*"); not need i
        if (interfaceDefinition.getParent() != null) {
            result.addAll(typeVisitor.accept(interfaceDefinition.getParent()));
        } else if (interfaceDefinition.getParent() instanceof ParameterisedType
                && ((ParameterisedType) interfaceDefinition.getParent()).getBaseType() instanceof PackageType) {
            PackageType packageType = (PackageType) ((ParameterisedType) interfaceDefinition.getParent()).getBaseType();
            result.add(packageType.getPackageName() + "." + packageType.getTypeName());
        }
//        if (!interfaceDefinition.getUnionReturnTypes().isEmpty()) {
//          // result.addAll(typeVisitor.accept(jsType));
//            result.addAll(interfaceDefinition.getUnionReturnTypes().stream()
//                    .map(UnionType::getTypes)
//                    .flatMap(List::stream)
//                    .map(typeVisitor::accept)
//                    .flatMap(List::stream)
//                    .collect(Collectors.toList()));
//        }
        result.addAll(interfaceDefinition.getUnionReturnTypes().stream()
                .filter(unionType -> interfaceDefinition != unionType.getOwner())
                .map(unionType -> unionType.getOwner().getPackageName() + "." + unionType.getOwner().getName())
                .collect(Collectors.toList()));
      return result;
    }

    @Override
    protected List<String> visitImplementedInterfaces(List<Type> implementedInterfaces) {
        List<String> result = new ArrayList<>();
        implementedInterfaces.forEach(type -> result.addAll(typeVisitor.accept(type)));
        return result;
    }

    @Override
  protected  List<String> visitConstructors(List<Constructor> constructors) {
        return constructors.stream()
                .map(methodVisitor::accept)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
    
    public static  List<String> visitConstructors2(List<Constructor> constructors) {
        return constructors.stream()
                .map(methodVisitor::accept)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    protected List<String> visitFeatures(List<Feature> features) {
        //TODO revisit
        return Collections.emptyList();
    }

    @Override
    protected List<String> coallesce(List<List<String>> result) {
        return result.stream().flatMap(List::stream).collect(Collectors.toList());
    }

    @Override
    protected List<String> visitConstants(List<Constant> constants) {
        return constants.stream()
                .map(this::visitConstant)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

    }

    private List<String> visitConstant(Constant constant) {
        return typeVisitor.accept(constant.getType());
    }

    @Override
    protected List<String> visitAttributes(List<Attribute> attributes) {
        return new AttributesVisitor(jsType).accept(attributes);
    }

    @Override
    protected List<String> visitMethods(List<Method> methods) {
        return methods.stream()
                .map(methodVisitor::accept)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

	@Override
	protected List<String> visitAttributesEventInterface(List<Attribute> attributes) {
		// TODO Auto-generated method stub
		return null;
	}

}
