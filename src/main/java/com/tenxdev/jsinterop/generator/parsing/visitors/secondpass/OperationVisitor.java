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

import com.tenxdev.jsinterop.generator.model.interfaces.InterfaceMember;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.parsing.ParsingContext;
import org.antlr4.webidl.WebIDLParser;

import java.util.List;

class OperationVisitor extends ContextWebIDLBaseVisitor<InterfaceMember> {

    private final String containingType;
    private final List<String> extendedAttributes;

    public OperationVisitor(ParsingContext context, String containingType,
                            List<String> extendedAttributes) {
        super(context);
        this.containingType = containingType;
        this.extendedAttributes = extendedAttributes;
    }

    @Override
    public InterfaceMember visitOperation(WebIDLParser.OperationContext ctx) {
        if (ctx.specialOperation() != null) {
            return ctx.specialOperation().accept(
                    new SpecialOperationVisitor(parsingContext, containingType, extendedAttributes));
        } else if (ctx.operationRest() != null) {
            Type returnType = ctx.returnType().accept(new TypeVisitor(parsingContext));
            return ctx.operationRest().accept(new OperationRestVisitor(parsingContext, returnType,
                    false, extendedAttributes));
        } else {
            parsingContext.getLogger().reportError("Unexpected condition in operation");
            return null;
        }

    }
}


