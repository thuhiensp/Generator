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

public enum PFontFaceSetLoadStatus implements PEnum {
    LOADING("loading"),
    LOADED("loaded");

    private String internalValue;

    PFontFaceSetLoadStatus(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PFontFaceSetLoadStatus of(String value){
        switch(value){
            case "loading":
                return LOADING;
            case "loaded":
                return LOADED;
            default:
                return null;
        }
    }

    public static PFontFaceSetLoadStatus[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PFontFaceSetLoadStatus::of)
                .toArray(PFontFaceSetLoadStatus[]::new);
    }

}
