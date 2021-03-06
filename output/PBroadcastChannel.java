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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PBroadcastChannel extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PBroadcastChannel.class);
    public PBroadcastChannel(String name){
      super(name);
    }


    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }
    public void setOnmessageerror(final PEventHandlerNonNull onmessageerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGEERROR, new AttributeCallBack(onmessageerror, atrsEventName));
       log.info("onmessageerror" + onmessageerror.getClass().getName());
    }

    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }
    public PEventHandlerNonNull getOnmessageerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGEERROR);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.BROADCAST_CHANNEL;
    }


    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public void postMessage(Object message){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       POST_MESSAGE_TYPEOBJECT_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message});
       writer.endObject();
    }

    
}