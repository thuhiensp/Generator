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

public enum PImageDataStorageFormat implements PEnum {
    UINT8("uint8"),
    UINT16("uint16"),
    FLOAT32("float32");

    private String internalValue;

    PImageDataStorageFormat(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PImageDataStorageFormat of(String value){
        switch(value){
            case "uint8":
                return UINT8;
            case "uint16":
                return UINT16;
            case "float32":
                return FLOAT32;
            default:
                return null;
        }
    }

    public static PImageDataStorageFormat[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PImageDataStorageFormat::of)
                .toArray(PImageDataStorageFormat[]::new);
    }

}
