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

package com.tenxdev.jsinterop.generator.parsing.visitors.secondpass;

import com.tenxdev.jsinterop.generator.model.DictionaryMember;
import com.tenxdev.jsinterop.generator.model.ExtendedAttributes;
import com.tenxdev.jsinterop.generator.model.types.GenericType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.parsing.ParsingContext;
import org.antlr4.webidl.WebIDLParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DictionaryMemberVisitor extends ContextWebIDLBaseVisitor<List<DictionaryMember>> {

    DictionaryMemberVisitor(ParsingContext parsingContext) {
        super(parsingContext);
    }

    @Override
    public List<DictionaryMember> visitDictionaryMembers(WebIDLParser.DictionaryMembersContext ctx) {
        List<DictionaryMember> members = new ArrayList<>();
        WebIDLParser.DictionaryMembersContext context = ctx;
        while (context != null && context.dictionaryMember() != null) {
            ExtendedAttributes extendedAttributes =
                    new ExtendedAttributes(context.extendedAttributeList() != null ?
                            context.extendedAttributeList().accept(new GenericExtendedAttributeListVisitor())
                            : null);
            WebIDLParser.DictionaryMemberContext memberContext = context.dictionaryMember();
            boolean required = memberContext.required() != null && "required".equals(memberContext.required().getText());

            Type type = memberContext.type().accept(new TypeVisitor(parsingContext));
            String[] genericParameterNames = extendedAttributes.extractValues(ExtendedAttributes.GENERIC_PARAMETER, null);
            if (genericParameterNames!=null){
                List<Type> genericParameters = Arrays.stream(genericParameterNames)
                        .map(param -> param.length() == 1 ?
                                new GenericType(param) :
                                parsingContext.getTypeFactory().getTypeNoParse(param))
                        .collect(Collectors.toList());
                type=new ParameterisedType(type, genericParameters);
            }
            String genericSubstitution = extendedAttributes.extractValue(ExtendedAttributes.GENERIC_SUB, null);
            if (genericSubstitution!=null) {
                type=new GenericType(genericSubstitution);
            }
            String name = memberContext.IDENTIFIER_WEBIDL().getText();
            String defaultValue = memberContext.default_() == null || memberContext.default_().defaultValue() == null ? null :
                    memberContext.default_().defaultValue().getText();


            members.add(new DictionaryMember(name, type, required, defaultValue, extendedAttributes));
            context = context.dictionaryMembers();
        }
        return members;
    }
}
