/*
 * Copyright 2019 SmartTrade Technologies
 *     Pony SDK
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
package  com.ponysdk.core.ui2;
import com.ponysdk.core.model.ServerToClientModel;
import com.ponysdk.core.writer.ModelWriter;
import com.ponysdk.core.server.application.UIContext;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Consumer;
import com.ponysdk.core.ui2.PEventAttributesName;
import java.util.HashMap;
import java.util.Map;
public class PEvent {
    private static final Logger log = LoggerFactory.getLogger(PEvent.class);
    public Map<PEventAttributesName, Object> mapValueByAttributeName = new HashMap<>();

    public PEvent(final Map<PEventAttributesName, Object> mapValueByAttributeName){
       this.mapValueByAttributeName = mapValueByAttributeName;
    }

    public Object getType(){
      return get(PEventAttributesName.TYPE);
    }
    public PEventTarget getTarget(){
      return (PEventTarget) get(PEventAttributesName.TARGET);
    }
    public PEventTarget getCurrentTarget(){
      return (PEventTarget) get(PEventAttributesName.CURRENT_TARGET);
    }
    public Object getEventPhase(){
      return get(PEventAttributesName.EVENT_PHASE);
    }
    public Object getBubbles(){
      return get(PEventAttributesName.BUBBLES);
    }
    public Object getCancelable(){
      return get(PEventAttributesName.CANCELABLE);
    }
    public Object getDefaultPrevented(){
      return get(PEventAttributesName.DEFAULT_PREVENTED);
    }
    public Object getComposed(){
      return get(PEventAttributesName.COMPOSED);
    }
    public Object getIsTrusted(){
      return get(PEventAttributesName.IS_TRUSTED);
    }
    public Object getTimeStamp(){
      return get(PEventAttributesName.TIME_STAMP);
    }
    public PEventTarget getSrcElement(){
      return (PEventTarget) get(PEventAttributesName.SRC_ELEMENT);
    }
    public Object getReturnValue(){
      return get(PEventAttributesName.RETURN_VALUE);
    }
    public Object getCancelBubble(){
      return get(PEventAttributesName.CANCEL_BUBBLE);
    }
    public PEventTarget[] getPath(){
      return (PEventTarget[]) get(PEventAttributesName.PATH);
    }
   protected Object get(final PEventAttributesName attrName) {
      return mapValueByAttributeName.get(attrName);
  }



}