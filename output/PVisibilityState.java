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

public enum PVisibilityState implements PEnum {
    HIDDEN("hidden"),
    VISIBLE("visible"),
    PRERENDER("prerender"),
    UNLOADED("unloaded");

    private String internalValue;

    PVisibilityState(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PVisibilityState of(String value){
        switch(value){
            case "hidden":
                return HIDDEN;
            case "visible":
                return VISIBLE;
            case "prerender":
                return PRERENDER;
            case "unloaded":
                return UNLOADED;
            default:
                return null;
        }
    }

    public static PVisibilityState[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PVisibilityState::of)
                .toArray(PVisibilityState[]::new);
    }

}
