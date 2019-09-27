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

import com.tenxdev.jsinterop.generator.logging.Logger;
import com.tenxdev.jsinterop.generator.model.AbstractDefinition;
import com.tenxdev.jsinterop.generator.model.Model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ImportResolver {

    public void processModel(Model model, Logger logger) {
        logger.info(() -> "Resolving Java package imports");
        Map<AbstractDefinition, List<String>> packagesMap = new PackageUsageModelVisitor().accept(model);
        packagesMap.forEach(this::processPackagesForDefinition);
    }

    private void processPackagesForDefinition(AbstractDefinition definition, List<String> packages) {
        definition.getImportedPackages().addAll(packages.stream()
                //.filter(packageName -> needsImport(definition, packageName))  //stage de Hien Le.
                .distinct()
                .sorted()
                .collect(Collectors.toList()));
    }

    public static boolean needsImport(AbstractDefinition definition, String importName) {
        return importName != null && !samePackage(importName, definition);
    }

    private static boolean samePackage(String importName, AbstractDefinition definition) {
        int lastDot = importName.lastIndexOf('.');
        if (lastDot != -1) {
            String packageName = importName.substring(0, lastDot);
            return packageName.equals(definition.getPackageName());
        }
        return false;
    }
}
