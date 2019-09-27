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

public enum PCanvasPixelFormat implements PEnum {
    _8_8_8_8("8-8-8-8"),
    _10_10_10_2("10-10-10-2"),
    _12_12_12_12("12-12-12-12"),
    FLOAT16("float16");

    private String internalValue;

    PCanvasPixelFormat(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PCanvasPixelFormat of(String value){
        switch(value){
            case "8-8-8-8":
                return _8_8_8_8;
            case "10-10-10-2":
                return _10_10_10_2;
            case "12-12-12-12":
                return _12_12_12_12;
            case "float16":
                return FLOAT16;
            default:
                return null;
        }
    }

    public static PCanvasPixelFormat[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PCanvasPixelFormat::of)
                .toArray(PCanvasPixelFormat[]::new);
    }

}
