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

import com.tenxdev.jsinterop.generator.model.ExtendedAttributes;
import com.tenxdev.jsinterop.generator.model.Feature;
import com.tenxdev.jsinterop.generator.model.types.Type;
import com.tenxdev.jsinterop.generator.parsing.ParsingContext;
import org.antlr4.webidl.WebIDLParser;

import java.util.List;

class IterableVisitor extends ContextWebIDLBaseVisitor<Feature> {

    private final List<String> extendedAttributes;

    public IterableVisitor(ParsingContext parsingContext, List<String> extendedAttributes) {
        super(parsingContext);
        this.extendedAttributes = extendedAttributes;
    }

    //see https://heycam.github.io/webidl/#idl-iterable
    @Override
    public Feature visitIterable(WebIDLParser.IterableContext ctx) {
        Type type = ctx.type().accept(new TypeVisitor(parsingContext));
        if (ctx.optionalType() == null || ctx.optionalType().type() == null) {
            return new Feature(Feature.FeatureType.MAP_ITERATOR, type, false,
                    new ExtendedAttributes(extendedAttributes));
        } else {
            Type type2 = ctx.optionalType().type().accept(new TypeVisitor(parsingContext));
            return new Feature(Feature.FeatureType.MAP_ITERATOR, type, type2, false,
                    new ExtendedAttributes(extendedAttributes));
        }
    }
}
