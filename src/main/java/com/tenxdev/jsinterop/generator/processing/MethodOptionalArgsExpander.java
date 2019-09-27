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

package com.tenxdev.jsinterop.generator.processing;

import com.tenxdev.jsinterop.generator.logging.Logger;
import com.tenxdev.jsinterop.generator.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * This class creates nee methods without optional arguments for methods with optional arguments, and removes all method
 * definitions with optional arguments.
 * For example, given foo(a, b?, c?)
 * the following methods will be added:
 * foo(a)
 * foo(a, b)
 * foo(a, b, c)
 * and the original method will be removed
 */
public class MethodOptionalArgsExpander {

    private final Model model;
    private final Logger logger;

    public MethodOptionalArgsExpander(Model model, Logger logger) {
        this.model = model;
        this.logger = logger;
    }

    public void processModel() {
        logger.info(() -> "Expanding methods with optional arguments");
        model.getInterfaceDefinitions().forEach(this::processInterface);
    }

    private void processInterface(InterfaceDefinition definition) {
        processMethods(definition::getMethods);
        processMethods(definition::getConstructors);
    }

    private <T extends Method> void processMethods(Supplier<List<T>> methodsSupplier) {
        List<T> newMethods = new ArrayList<>();
        methodsSupplier.get().forEach(method -> {
            if (hasOptionalArgs(method)) {
                List<T> expandedMethods = expandMethod(method);
                expandedMethods.removeAll(newMethods);
                newMethods.addAll(expandedMethods);
            } else {
                newMethods.add(method);
            }
        });
        methodsSupplier.get().clear();
        methodsSupplier.get().addAll(newMethods);
    }

    private boolean hasOptionalArgs(Method method) {
        return method.getArguments().stream().anyMatch(MethodArgument::isOptional);
    }

    private <T extends Method> List<T> expandMethod(T method) {
        List<T> expandedMethods = new ArrayList<>();
        expandMethod(method, expandedMethods);
        return expandedMethods;
    }

    private <T extends Method> void expandMethod(T method, List<T> expandedMethods) {
        boolean hasOptions = false;
        List<MethodArgument> newArguments = new ArrayList<>();
        for (MethodArgument argument : method.getArguments()) {
            if ((argument.isOptional()) && !hasOptions) {
                T newMethod = method.newMethodWithArguments(new ArrayList<>(newArguments));
                expandedMethods.add(newMethod);
                hasOptions = true;
                newArguments.add(argument.newRequiredArgument());
            } else {
                newArguments.add(argument);
            }
        }
        T newMethod = method.newMethodWithArguments(newArguments);
        if (hasOptions) {
            expandMethod(newMethod, expandedMethods);
        } else {
            expandedMethods.add(newMethod);
        }
    }

}
