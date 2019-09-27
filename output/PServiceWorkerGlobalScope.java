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
public class PServiceWorkerGlobalScope extends PWorkerGlobalScope {
    private static final Logger log = LoggerFactory.getLogger(PServiceWorkerGlobalScope.class);
    private PServiceWorkerGlobalScope(){
    }

    public void setOnactivate(final PEventHandlerNonNull onactivate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONACTIVATE, new AttributeCallBack(onactivate, atrsEventName));
       log.info("onactivate" + onactivate.getClass().getName());
    }
    public void setOnfetch(final PEventHandlerNonNull onfetch, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONFETCH, new AttributeCallBack(onfetch, atrsEventName));
       log.info("onfetch" + onfetch.getClass().getName());
    }
    public void setOninstall(final PEventHandlerNonNull oninstall, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONINSTALL, new AttributeCallBack(oninstall, atrsEventName));
       log.info("oninstall" + oninstall.getClass().getName());
    }
    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }
    public void setOnforeignfetch(final PEventHandlerNonNull onforeignfetch, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONFOREIGNFETCH, new AttributeCallBack(onforeignfetch, atrsEventName));
       log.info("onforeignfetch" + onforeignfetch.getClass().getName());
    }
    public void setOnbackgroundfetched(final PEventHandlerNonNull onbackgroundfetched, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBACKGROUNDFETCHED, new AttributeCallBack(onbackgroundfetched, atrsEventName));
       log.info("onbackgroundfetched" + onbackgroundfetched.getClass().getName());
    }
    public void setOnbackgroundfetchfail(final PEventHandlerNonNull onbackgroundfetchfail, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBACKGROUNDFETCHFAIL, new AttributeCallBack(onbackgroundfetchfail, atrsEventName));
       log.info("onbackgroundfetchfail" + onbackgroundfetchfail.getClass().getName());
    }
    public void setOnbackgroundfetchabort(final PEventHandlerNonNull onbackgroundfetchabort, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBACKGROUNDFETCHABORT, new AttributeCallBack(onbackgroundfetchabort, atrsEventName));
       log.info("onbackgroundfetchabort" + onbackgroundfetchabort.getClass().getName());
    }
    public void setOnbackgroundfetchclick(final PEventHandlerNonNull onbackgroundfetchclick, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBACKGROUNDFETCHCLICK, new AttributeCallBack(onbackgroundfetchclick, atrsEventName));
       log.info("onbackgroundfetchclick" + onbackgroundfetchclick.getClass().getName());
    }
    public void setOnsync(final PEventHandlerNonNull onsync, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSYNC, new AttributeCallBack(onsync, atrsEventName));
       log.info("onsync" + onsync.getClass().getName());
    }
    public void setOnnotificationclick(final PEventHandlerNonNull onnotificationclick, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONNOTIFICATIONCLICK, new AttributeCallBack(onnotificationclick, atrsEventName));
       log.info("onnotificationclick" + onnotificationclick.getClass().getName());
    }
    public void setOnnotificationclose(final PEventHandlerNonNull onnotificationclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONNOTIFICATIONCLOSE, new AttributeCallBack(onnotificationclose, atrsEventName));
       log.info("onnotificationclose" + onnotificationclose.getClass().getName());
    }
    public void setOnpush(final PEventHandlerNonNull onpush, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPUSH, new AttributeCallBack(onpush, atrsEventName));
       log.info("onpush" + onpush.getClass().getName());
    }

    public PEventHandlerNonNull getOnactivate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONACTIVATE);
    }
    public PEventHandlerNonNull getOnfetch(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONFETCH);
    }
    public PEventHandlerNonNull getOninstall(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONINSTALL);
    }
    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }
    public PEventHandlerNonNull getOnforeignfetch(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONFOREIGNFETCH);
    }
    public PEventHandlerNonNull getOnbackgroundfetched(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBACKGROUNDFETCHED);
    }
    public PEventHandlerNonNull getOnbackgroundfetchfail(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBACKGROUNDFETCHFAIL);
    }
    public PEventHandlerNonNull getOnbackgroundfetchabort(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBACKGROUNDFETCHABORT);
    }
    public PEventHandlerNonNull getOnbackgroundfetchclick(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBACKGROUNDFETCHCLICK);
    }
    public PEventHandlerNonNull getOnsync(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSYNC);
    }
    public PEventHandlerNonNull getOnnotificationclick(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONNOTIFICATIONCLICK);
    }
    public PEventHandlerNonNull getOnnotificationclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONNOTIFICATIONCLOSE);
    }
    public PEventHandlerNonNull getOnpush(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPUSH);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<Void> skipWaiting() {
       return null;
    }


    
}