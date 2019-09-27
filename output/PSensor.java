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
public abstract class PSensor extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PSensor.class);
     protected PSensor() {
     }
    protected PSensor(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnreading(final PEventHandlerNonNull onreading, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREADING, new AttributeCallBack(onreading, atrsEventName));
       log.info("onreading" + onreading.getClass().getName());
    }
    public void setOnactivate(final PEventHandlerNonNull onactivate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONACTIVATE, new AttributeCallBack(onactivate, atrsEventName));
       log.info("onactivate" + onactivate.getClass().getName());
    }

    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnreading(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREADING);
    }
    public PEventHandlerNonNull getOnactivate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONACTIVATE);
    }


    public void start(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_VOID.getValue());
       writer.endObject();
    }

    public void stop(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STOP_VOID.getValue());
       writer.endObject();
    }

    
}