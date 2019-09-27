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
public class PRTCDataChannel extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PRTCDataChannel.class);
    private PRTCDataChannel(){
    }

    public void setBufferedAmountLowThreshold(final Double bufferedAmountLowThreshold)  {
       setAttribute(PAttributeNames.BUFFERED_AMOUNT_LOW_THRESHOLD, bufferedAmountLowThreshold);
       log.info("bufferedAmountLowThreshold" + bufferedAmountLowThreshold);
    }
    public void setOnopen(final PEventHandlerNonNull onopen, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONOPEN, new AttributeCallBack(onopen, atrsEventName));
       log.info("onopen" + onopen.getClass().getName());
    }
    public void setOnbufferedamountlow(final PEventHandlerNonNull onbufferedamountlow, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBUFFEREDAMOUNTLOW, new AttributeCallBack(onbufferedamountlow, atrsEventName));
       log.info("onbufferedamountlow" + onbufferedamountlow.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnclose(final PEventHandlerNonNull onclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLOSE, new AttributeCallBack(onclose, atrsEventName));
       log.info("onclose" + onclose.getClass().getName());
    }
    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }
    public void setBinaryType(final String binaryType)  {
       setAttribute(PAttributeNames.BINARY_TYPE_STRING, binaryType);
       log.info("binaryType" + binaryType);
    }

    public Double getBufferedAmountLowThreshold(){
      return (Double) getAttribute(PAttributeNames.BUFFERED_AMOUNT_LOW_THRESHOLD);
    }
    public PEventHandlerNonNull getOnopen(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONOPEN);
    }
    public PEventHandlerNonNull getOnbufferedamountlow(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBUFFEREDAMOUNTLOW);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLOSE);
    }
    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }
    public String getBinaryType(){
      return (String) getAttribute(PAttributeNames.BINARY_TYPE_STRING);
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

    public void send(String data){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SEND_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {data});
       writer.endObject();
    }

    public void send(PBlob data){
    }

    public void send(PArrayBuffer data){
    }

    public void send(PArrayBufferView data){
    }

    
}