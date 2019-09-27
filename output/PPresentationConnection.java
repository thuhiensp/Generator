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
public class PPresentationConnection extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PPresentationConnection.class);
    private PPresentationConnection(){
    }

    public void setOnconnect(final PEventHandlerNonNull onconnect, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCONNECT, new AttributeCallBack(onconnect, atrsEventName));
       log.info("onconnect" + onconnect.getClass().getName());
    }
    public void setOnclose(final PEventHandlerNonNull onclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLOSE, new AttributeCallBack(onclose, atrsEventName));
       log.info("onclose" + onclose.getClass().getName());
    }
    public void setOnterminate(final PEventHandlerNonNull onterminate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTERMINATE, new AttributeCallBack(onterminate, atrsEventName));
       log.info("onterminate" + onterminate.getClass().getName());
    }
    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }
    public void setBinaryType(final PBinaryType binaryType)  {
       setAttribute(PAttributeNames.BINARY_TYPE_PENUM, binaryType);
       log.info("binaryType" + binaryType);
    }

    public PEventHandlerNonNull getOnconnect(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCONNECT);
    }
    public PEventHandlerNonNull getOnclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLOSE);
    }
    public PEventHandlerNonNull getOnterminate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTERMINATE);
    }
    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }
    public PBinaryType getBinaryType(){
      return (PBinaryType) getAttribute(PAttributeNames.BINARY_TYPE_PENUM);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public void send(String message){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SEND_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message});
       writer.endObject();
    }

    public void send(PBlob data){
    }

    public void send(PArrayBuffer data){
    }

    public void send(PArrayBufferView data){
    }

    public void terminate(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       TERMINATE_VOID.getValue());
       writer.endObject();
    }

    
}