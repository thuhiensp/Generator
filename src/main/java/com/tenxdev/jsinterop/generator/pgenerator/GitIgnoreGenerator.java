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

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class GitIgnoreGenerator {
  public CharSequence generate() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("log/");
    _builder.newLine();
    _builder.append("target/");
    _builder.newLine();
    _builder.append(".*/");
    _builder.newLine();
    _builder.append("*.iml");
    _builder.newLine();
    _builder.append(".classpath");
    _builder.newLine();
    _builder.append(".project");
    _builder.newLine();
    _builder.append("*.iml");
    _builder.newLine();
    _builder.append("*.iws");
    _builder.newLine();
    _builder.append(".DS_Store");
    _builder.newLine();
    return _builder;
  }
}
