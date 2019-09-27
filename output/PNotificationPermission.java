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

public enum PNotificationPermission implements PEnum {
    DEFAULT("default"),
    DENIED("denied"),
    GRANTED("granted");

    private String internalValue;

    PNotificationPermission(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PNotificationPermission of(String value){
        switch(value){
            case "default":
                return DEFAULT;
            case "denied":
                return DENIED;
            case "granted":
                return GRANTED;
            default:
                return null;
        }
    }

    public static PNotificationPermission[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PNotificationPermission::of)
                .toArray(PNotificationPermission[]::new);
    }

}
