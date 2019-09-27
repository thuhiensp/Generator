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
public class PWindowEventHandlers extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PWindowEventHandlers.class);
    private PWindowEventHandlers(){
    }

    public void setOnbeforeunload(final PEventHandlerNonNull onbeforeunload, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEFOREUNLOAD, new AttributeCallBack(onbeforeunload, atrsEventName));
       log.info("onbeforeunload" + onbeforeunload.getClass().getName());
    }
    public void setOnhashchange(final PEventHandlerNonNull onhashchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONHASHCHANGE, new AttributeCallBack(onhashchange, atrsEventName));
       log.info("onhashchange" + onhashchange.getClass().getName());
    }
    public void setOnlanguagechange(final PEventHandlerNonNull onlanguagechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLANGUAGECHANGE, new AttributeCallBack(onlanguagechange, atrsEventName));
       log.info("onlanguagechange" + onlanguagechange.getClass().getName());
    }
    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }
    public void setOnmessageerror(final PEventHandlerNonNull onmessageerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGEERROR, new AttributeCallBack(onmessageerror, atrsEventName));
       log.info("onmessageerror" + onmessageerror.getClass().getName());
    }
    public void setOnoffline(final PEventHandlerNonNull onoffline, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONOFFLINE, new AttributeCallBack(onoffline, atrsEventName));
       log.info("onoffline" + onoffline.getClass().getName());
    }
    public void setOnonline(final PEventHandlerNonNull ononline, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONONLINE, new AttributeCallBack(ononline, atrsEventName));
       log.info("ononline" + ononline.getClass().getName());
    }
    public void setOnpagehide(final PEventHandlerNonNull onpagehide, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAGEHIDE, new AttributeCallBack(onpagehide, atrsEventName));
       log.info("onpagehide" + onpagehide.getClass().getName());
    }
    public void setOnpageshow(final PEventHandlerNonNull onpageshow, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAGESHOW, new AttributeCallBack(onpageshow, atrsEventName));
       log.info("onpageshow" + onpageshow.getClass().getName());
    }
    public void setOnpopstate(final PEventHandlerNonNull onpopstate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOPSTATE, new AttributeCallBack(onpopstate, atrsEventName));
       log.info("onpopstate" + onpopstate.getClass().getName());
    }
    public void setOnrejectionhandled(final PEventHandlerNonNull onrejectionhandled, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREJECTIONHANDLED, new AttributeCallBack(onrejectionhandled, atrsEventName));
       log.info("onrejectionhandled" + onrejectionhandled.getClass().getName());
    }
    public void setOnstorage(final PEventHandlerNonNull onstorage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTORAGE, new AttributeCallBack(onstorage, atrsEventName));
       log.info("onstorage" + onstorage.getClass().getName());
    }
    public void setOnunhandledrejection(final PEventHandlerNonNull onunhandledrejection, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUNHANDLEDREJECTION, new AttributeCallBack(onunhandledrejection, atrsEventName));
       log.info("onunhandledrejection" + onunhandledrejection.getClass().getName());
    }
    public void setOnunload(final PEventHandlerNonNull onunload, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUNLOAD, new AttributeCallBack(onunload, atrsEventName));
       log.info("onunload" + onunload.getClass().getName());
    }

    public PEventHandlerNonNull getOnbeforeunload(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEFOREUNLOAD);
    }
    public PEventHandlerNonNull getOnhashchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONHASHCHANGE);
    }
    public PEventHandlerNonNull getOnlanguagechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLANGUAGECHANGE);
    }
    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }
    public PEventHandlerNonNull getOnmessageerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGEERROR);
    }
    public PEventHandlerNonNull getOnoffline(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONOFFLINE);
    }
    public PEventHandlerNonNull getOnonline(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONONLINE);
    }
    public PEventHandlerNonNull getOnpagehide(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAGEHIDE);
    }
    public PEventHandlerNonNull getOnpageshow(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAGESHOW);
    }
    public PEventHandlerNonNull getOnpopstate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOPSTATE);
    }
    public PEventHandlerNonNull getOnrejectionhandled(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREJECTIONHANDLED);
    }
    public PEventHandlerNonNull getOnstorage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTORAGE);
    }
    public PEventHandlerNonNull getOnunhandledrejection(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUNHANDLEDREJECTION);
    }
    public PEventHandlerNonNull getOnunload(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUNLOAD);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}