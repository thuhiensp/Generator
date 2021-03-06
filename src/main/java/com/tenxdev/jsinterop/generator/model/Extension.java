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

import java.util.Collections;
import java.util.List;

public class Extension {

    private final List<String> imports;
    private final String className;
    private final String packageSuffix;
    private final String template;

    public Extension(String className, String packageSuffix, String template) {
        this.className = className;
        this.packageSuffix = packageSuffix;
        this.template = template;
        this.imports = Collections.emptyList();
    }

    public Extension(String className, String template, List<String> imports) {
        this.className = className;
        this.packageSuffix = null;
        this.template = template;
        this.imports = imports;
    }


    public List<String> getImports() {
        return imports;
    }

    public String getClassName() {
        return className;
    }

    public String getPackageSuffix() {
        return packageSuffix;
    }

    public String getTemplate() {
        return template;
    }
}
