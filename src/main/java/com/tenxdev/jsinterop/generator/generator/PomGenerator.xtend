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
package com.tenxdev.jsinterop.generator.generator

class PomGenerator {

    def generate(String version)'''
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://maven.apache.org/POM/4.0.0"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.10xdev</groupId>
    <artifactId>gwt-jelement</artifactId>
    <version>«version»</version>
    <packaging>jar</packaging>

    <name>GWT JElement</name>
    <description>GWT JSInterop classes for Web APIs</description>
    <url>https://gwt-jelement.github.io/</url>

    <licenses>
        <license>
            <name>Apache License, Version 2.0</name>
            <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
            <distribution>repo</distribution>
        </license>
    </licenses>

    <scm>
        <url>https://github.com/gwt-jelement/gwt-jelement</url>
    </scm>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <maven-compiler-plugin-version>3.6.1</maven-compiler-plugin-version>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <build>
        <resources>
            <resource>
                <directory>${basedir}/src/main/resources</directory>
            </resource>
            <resource>
                <directory>${basedir}/src/main/java</directory>
            </resource>
        </resources>
    </build>

    <dependencies>
        <dependency>
          <groupId>com.google.jsinterop</groupId>
          <artifactId>jsinterop-annotations</artifactId>
          <version>1.0.1</version>
        </dependency>
    </dependencies>
</project>
'''
}