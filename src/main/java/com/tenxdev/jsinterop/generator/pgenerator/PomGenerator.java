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
public class PomGenerator {
  public CharSequence generate(final String version) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<project xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("xmlns=\"http://maven.apache.org/POM/4.0.0\"");
    _builder.newLine();
    _builder.append("         ");
    _builder.append("xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<modelVersion>4.0.0</modelVersion>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<groupId>com.10xdev</groupId>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<artifactId>gwt-jelement</artifactId>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<version>");
    _builder.append(version, "    ");
    _builder.append("</version>");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.append("<packaging>jar</packaging>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<name>GWT JElement</name>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<description>GWT JSInterop classes for Web APIs</description>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<url>https://gwt-jelement.github.io/</url>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<licenses>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<license>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<name>Apache License, Version 2.0</name>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<distribution>repo</distribution>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("</license>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</licenses>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<scm>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<url>https://github.com/gwt-jelement/gwt-jelement</url>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</scm>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<properties>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<maven-compiler-plugin-version>3.6.1</maven-compiler-plugin-version>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<maven.compiler.source>1.8</maven.compiler.source>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<maven.compiler.target>1.8</maven.compiler.target>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</properties>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<build>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<resources>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<resource>");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("<directory>${basedir}/src/main/resources</directory>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("</resource>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("<resource>");
    _builder.newLine();
    _builder.append("                ");
    _builder.append("<directory>${basedir}/src/main/java</directory>");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("</resource>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("</resources>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</build>");
    _builder.newLine();
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<dependencies>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("<dependency>");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("<groupId>com.google.jsinterop</groupId>");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("<artifactId>jsinterop-annotations</artifactId>");
    _builder.newLine();
    _builder.append("          ");
    _builder.append("<version>1.0.1</version>");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("</dependency>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("</dependencies>");
    _builder.newLine();
    _builder.append("</project>");
    _builder.newLine();
    return _builder;
  }
}
