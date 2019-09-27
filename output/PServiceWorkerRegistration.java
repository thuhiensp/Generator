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
public class PServiceWorkerRegistration extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PServiceWorkerRegistration.class);
    private PServiceWorkerRegistration(){
    }

    public void setOnupdatefound(final PEventHandlerNonNull onupdatefound, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUPDATEFOUND, new AttributeCallBack(onupdatefound, atrsEventName));
       log.info("onupdatefound" + onupdatefound.getClass().getName());
    }

    public PEventHandlerNonNull getOnupdatefound(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUPDATEFOUND);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<PNotification[]> getNotifications() {
       return null;
    }


    public PPromise<PNotification[]> getNotifications(PGetNotificationOptions filter) {
       return null;
    }


    public PPromise showNotification(String title) {
       return null;
    }


    public PPromise showNotification(String title, PNotificationOptions options) {
       return null;
    }


    public PPromise<Boolean> unregister() {
       return null;
    }


    public PPromise<Void> update() {
       return null;
    }


    
}