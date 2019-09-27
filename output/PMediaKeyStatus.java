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

public enum PMediaKeyStatus implements PEnum {
    USABLE("usable"),
    EXPIRED("expired"),
    RELEASED("released"),
    OUTPUT_RESTRICTED("output-restricted"),
    OUTPUT_DOWNSCALED("output-downscaled"),
    STATUS_PENDING("status-pending"),
    INTERNAL_ERROR("internal-error");

    private String internalValue;

    PMediaKeyStatus(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PMediaKeyStatus of(String value){
        switch(value){
            case "usable":
                return USABLE;
            case "expired":
                return EXPIRED;
            case "released":
                return RELEASED;
            case "output-restricted":
                return OUTPUT_RESTRICTED;
            case "output-downscaled":
                return OUTPUT_DOWNSCALED;
            case "status-pending":
                return STATUS_PENDING;
            case "internal-error":
                return INTERNAL_ERROR;
            default:
                return null;
        }
    }

    public static PMediaKeyStatus[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PMediaKeyStatus::of)
                .toArray(PMediaKeyStatus[]::new);
    }

}
