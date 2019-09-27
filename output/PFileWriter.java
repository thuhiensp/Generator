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
public class PFileWriter extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PFileWriter.class);
    private PFileWriter(){
    }

    public void setOnwritestart(final PEventHandlerNonNull onwritestart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWRITESTART, new AttributeCallBack(onwritestart, atrsEventName));
       log.info("onwritestart" + onwritestart.getClass().getName());
    }
    public void setOnprogress(final PEventHandlerNonNull onprogress, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPROGRESS, new AttributeCallBack(onprogress, atrsEventName));
       log.info("onprogress" + onprogress.getClass().getName());
    }
    public void setOnwrite(final PEventHandlerNonNull onwrite, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWRITE, new AttributeCallBack(onwrite, atrsEventName));
       log.info("onwrite" + onwrite.getClass().getName());
    }
    public void setOnabort(final PEventHandlerNonNull onabort, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONABORT, new AttributeCallBack(onabort, atrsEventName));
       log.info("onabort" + onabort.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnwriteend(final PEventHandlerNonNull onwriteend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWRITEEND, new AttributeCallBack(onwriteend, atrsEventName));
       log.info("onwriteend" + onwriteend.getClass().getName());
    }

    public PEventHandlerNonNull getOnwritestart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWRITESTART);
    }
    public PEventHandlerNonNull getOnprogress(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPROGRESS);
    }
    public PEventHandlerNonNull getOnwrite(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWRITE);
    }
    public PEventHandlerNonNull getOnabort(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONABORT);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnwriteend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWRITEEND);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
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

    public void seek(Double position){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SEEK_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {position});
       writer.endObject();
    }

    public void truncate(Double size){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       TRUNCATE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {size});
       writer.endObject();
    }

    public void write(PBlob data){
    }

    
}