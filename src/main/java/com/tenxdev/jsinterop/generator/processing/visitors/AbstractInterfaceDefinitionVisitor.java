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

package com.tenxdev.jsinterop.generator.processing.visitors;

import com.tenxdev.jsinterop.generator.model.*;
import com.tenxdev.jsinterop.generator.model.types.Type;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInterfaceDefinitionVisitor<T> {

    public T accept(InterfaceDefinition interfaceDefinition) {
        List<T> result = new ArrayList<>();
        //if (model.isEventInterface(interfaceDefinition))//stage Hien Le;
        //result.add(visitConstructors(interfaceDefinition.getConstructors()));
        //result.add(visitMethods(interfaceDefinition.getMethods()));
        //result.add(visitAttributes(interfaceDefinition.getAttributes()));
        //result.add(visitAttributes(interfaceDefinition.getAttributesModifiable()));
        result.add(visitAttributes(interfaceDefinition.getAttributes()));
        //result.add(visitConstants(interfaceDefinition.getConstants()));
        //result.add(visitFeatures(interfaceDefinition.getFeatures()));
        //result.add(visitImplementedInterfaces(interfaceDefinition.getImplementedInterfaces())); 
        return coallesce(result);
    }

    protected abstract T visitImplementedInterfaces(List<Type> implementedInterfaces);

    protected abstract T visitConstructors(List<Constructor> constructors);

    protected abstract T visitFeatures(@SuppressWarnings("unused") List<Feature> features);

    protected abstract T coallesce(List<T> result);

    protected abstract T visitConstants(List<Constant> constants);

    protected abstract T visitAttributes(List<Attribute> attributes);
    protected abstract T visitAttributesEventInterface(List<Attribute> attributes);

    protected abstract T visitMethods(List<Method> methods);

}
