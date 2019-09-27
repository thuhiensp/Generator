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

import com.tenxdev.jsinterop.generator.model.Attribute;
import com.tenxdev.jsinterop.generator.model.ExtendedAttributes;
import com.tenxdev.jsinterop.generator.model.types.GenericType;
import com.tenxdev.jsinterop.generator.model.types.ParameterisedType;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.parsing.ParsingContext;
import org.antlr4.webidl.WebIDLParser;

import java.util.List;

class AttributeRestVisitor extends ContextWebIDLBaseVisitor<Attribute> {

    private final boolean readOnly;
    private final boolean staticAttribute;
    private final List<String> extendedAttributesList;

    AttributeRestVisitor(ParsingContext context, boolean readOnly, boolean staticAttribute, List<String> extendedAttributes) {
        super(context);
        this.readOnly = readOnly;
        this.staticAttribute = staticAttribute;
        this.extendedAttributesList = extendedAttributes;
    }

    @Override
    public Attribute visitAttributeRest(WebIDLParser.AttributeRestContext ctx) {
        String name = ctx.attributeName().getText();
        Type type = ctx.type().accept(new TypeVisitor(parsingContext));
        ExtendedAttributes extendedAttributes = new ExtendedAttributes(extendedAttributesList);
        String genericTypeName = extendedAttributes.extractValue(ExtendedAttributes.GENERIC_PARAMETER, null);
        if (staticAttribute && genericTypeName != null) {
            parsingContext.getLogger().formatError("Ignored generic type specifier %s on static attribute %s",
                    genericTypeName, name);
            genericTypeName = null;
        }
        Type actualType = genericTypeName == null ?
                type : new ParameterisedType(type, new GenericType(genericTypeName));
        return new Attribute(name, actualType, readOnly, staticAttribute, extendedAttributes);
    }

}
