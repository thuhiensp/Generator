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
public class PApplicationCache extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PApplicationCache.class);
    private PApplicationCache(){
    }

    public void setOnchecking(final PEventHandlerNonNull onchecking, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCHECKING, new AttributeCallBack(onchecking, atrsEventName));
       log.info("onchecking" + onchecking.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnnoupdate(final PEventHandlerNonNull onnoupdate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONNOUPDATE, new AttributeCallBack(onnoupdate, atrsEventName));
       log.info("onnoupdate" + onnoupdate.getClass().getName());
    }
    public void setOndownloading(final PEventHandlerNonNull ondownloading, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDOWNLOADING, new AttributeCallBack(ondownloading, atrsEventName));
       log.info("ondownloading" + ondownloading.getClass().getName());
    }
    public void setOnprogress(final PEventHandlerNonNull onprogress, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPROGRESS, new AttributeCallBack(onprogress, atrsEventName));
       log.info("onprogress" + onprogress.getClass().getName());
    }
    public void setOnupdateready(final PEventHandlerNonNull onupdateready, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUPDATEREADY, new AttributeCallBack(onupdateready, atrsEventName));
       log.info("onupdateready" + onupdateready.getClass().getName());
    }
    public void setOncached(final PEventHandlerNonNull oncached, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCACHED, new AttributeCallBack(oncached, atrsEventName));
       log.info("oncached" + oncached.getClass().getName());
    }
    public void setOnobsolete(final PEventHandlerNonNull onobsolete, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONOBSOLETE, new AttributeCallBack(onobsolete, atrsEventName));
       log.info("onobsolete" + onobsolete.getClass().getName());
    }

    public PEventHandlerNonNull getOnchecking(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCHECKING);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnnoupdate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONNOUPDATE);
    }
    public PEventHandlerNonNull getOndownloading(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDOWNLOADING);
    }
    public PEventHandlerNonNull getOnprogress(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPROGRESS);
    }
    public PEventHandlerNonNull getOnupdateready(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUPDATEREADY);
    }
    public PEventHandlerNonNull getOncached(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCACHED);
    }
    public PEventHandlerNonNull getOnobsolete(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONOBSOLETE);
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

    public void swapCache(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SWAP_CACHE_VOID.getValue());
       writer.endObject();
    }

    public void update(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       UPDATE_VOID.getValue());
       writer.endObject();
    }

    
}