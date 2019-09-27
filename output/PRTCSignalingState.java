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

public enum PRTCSignalingState implements PEnum {
    STABLE("stable"),
    HAVE_LOCAL_OFFER("have-local-offer"),
    HAVE_REMOTE_OFFER("have-remote-offer"),
    HAVE_LOCAL_PRANSWER("have-local-pranswer"),
    HAVE_REMOTE_PRANSWER("have-remote-pranswer"),
    CLOSED("closed");

    private String internalValue;

    PRTCSignalingState(String internalValue){
        this.internalValue = internalValue;
    }

    public String getInternalValue(){
        return this.internalValue;
    }

    public static PRTCSignalingState of(String value){
        switch(value){
            case "stable":
                return STABLE;
            case "have-local-offer":
                return HAVE_LOCAL_OFFER;
            case "have-remote-offer":
                return HAVE_REMOTE_OFFER;
            case "have-local-pranswer":
                return HAVE_LOCAL_PRANSWER;
            case "have-remote-pranswer":
                return HAVE_REMOTE_PRANSWER;
            case "closed":
                return CLOSED;
            default:
                return null;
        }
    }

    public static PRTCSignalingState[] ofArray(String[] values) {
        return Arrays.<String>stream(values)
                .map(PRTCSignalingState::of)
                .toArray(PRTCSignalingState[]::new);
    }

}
