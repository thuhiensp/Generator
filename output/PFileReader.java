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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PFileReader extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PFileReader.class);
    public PFileReader() {
    }



    public void setOnloadstart(final PEventHandlerNonNull onloadstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADSTART, new AttributeCallBack(onloadstart, atrsEventName));
       log.info("onloadstart" + onloadstart.getClass().getName());
    }
    public void setOnprogress(final PEventHandlerNonNull onprogress, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPROGRESS, new AttributeCallBack(onprogress, atrsEventName));
       log.info("onprogress" + onprogress.getClass().getName());
    }
    public void setOnload(final PEventHandlerNonNull onload, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOAD, new AttributeCallBack(onload, atrsEventName));
       log.info("onload" + onload.getClass().getName());
    }
    public void setOnabort(final PEventHandlerNonNull onabort, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONABORT, new AttributeCallBack(onabort, atrsEventName));
       log.info("onabort" + onabort.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnloadend(final PEventHandlerNonNull onloadend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADEND, new AttributeCallBack(onloadend, atrsEventName));
       log.info("onloadend" + onloadend.getClass().getName());
    }

    public PEventHandlerNonNull getOnloadstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADSTART);
    }
    public PEventHandlerNonNull getOnprogress(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPROGRESS);
    }
    public PEventHandlerNonNull getOnload(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOAD);
    }
    public PEventHandlerNonNull getOnabort(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONABORT);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnloadend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADEND);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.FILE_READER;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void abort(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ABORT_VOID.getValue());
       writer.endObject();
    }

    public void readAsArrayBuffer(PBlob blob){
    }

    public void readAsBinaryString(PBlob blob){
    }

    public void readAsDataURL(PBlob blob){
    }

    public void readAsText(PBlob blob){
    }

    public void readAsText(PBlob blob, String label){
    }

    
}