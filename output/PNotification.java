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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PNotification extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PNotification.class);
    public PNotification(String title){
      super(title);
    }

    public PNotification(String title, PNotificationOptions options){
      super(title, options);
    }


    public void setOnclick(final PEventHandlerNonNull onclick, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLICK, new AttributeCallBack(onclick, atrsEventName));
       log.info("onclick" + onclick.getClass().getName());
    }
    public void setOnshow(final PEventHandlerNonNull onshow, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSHOW, new AttributeCallBack(onshow, atrsEventName));
       log.info("onshow" + onshow.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnclose(final PEventHandlerNonNull onclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLOSE, new AttributeCallBack(onclose, atrsEventName));
       log.info("onclose" + onclose.getClass().getName());
    }

    public PEventHandlerNonNull getOnclick(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLICK);
    }
    public PEventHandlerNonNull getOnshow(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSHOW);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLOSE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.NOTIFICATION;
    }


    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public PPromise<String> requestPermission() {
       return null;
    }


    public PPromise<String> requestPermission(PNotificationPermissionCallback deprecatedCallback) {
       return null;
    }


    
}