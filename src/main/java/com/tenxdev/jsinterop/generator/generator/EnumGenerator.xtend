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

import com.tenxdev.jsinterop.generator.model.EnumDefinition;

class EnumGenerator extends XtendTemplate{

    def generate(String basePackageName, EnumDefinition definition){
        return '''
«copyright»
package «basePackageName»«definition.getPackageName()»;

import java.util.Arrays;

public enum «definition.name»{
    «FOR value: definition.values SEPARATOR ",\n" AFTER ";\n"
        »«EnumDefinition.toJavaName(value)»(«value»)«ENDFOR»

    private String internalValue;

    «definition.name»(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static «definition.name» of(«definition.javaElementType.displayValue» value){
        switch(value){
            «FOR value: definition.values»
            case «value»:
                return «EnumDefinition.toJavaName(value)»;
            «ENDFOR»
            default:
                return null;
        }
    }

    public static «definition.name»[] ofArray(«definition.javaElementType.displayValue»[] values) {
        return Arrays.<«definition.javaElementType.displayValue»>stream(values)
                .map(«definition.name»::of)
                .toArray(«definition.name»[]::new);
    }

}
    '''
    }


}