/*
 * Copyright 2019 SmartTrade Technologies
 *     and Pony SDK project.
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
package com.ponysdk.core.ui2;

import java.util.Arrays;
import com.ponysdk.core.ui2.PEnum;

public enum PSupportedType implements PEnum {
    TEXT_HTML("text/html"),
    TEXT_XML("text/xml"),
    APPLICATION_XML("application/xml"),
    APPLICATION_XHTML_XML("application/xhtml+xml"),
    IMAGE_SVG_XML("image/svg+xml");

    private String internalValue;

    PSupportedType(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PSupportedType of(String value){
        switch(value){
            case "text/html":
                return TEXT_HTML;
            case "text/xml":
                return TEXT_XML;
            case "application/xml":
                return APPLICATION_XML;
            case "application/xhtml+xml":
                return APPLICATION_XHTML_XML;
            case "image/svg+xml":
                return IMAGE_SVG_XML;
            default:
                return null;
        }
    }

    public static PSupportedType[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PSupportedType::of)
                .toArray(PSupportedType[]::new);
    }

}
