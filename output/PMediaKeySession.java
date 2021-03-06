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
public class PMediaKeySession extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PMediaKeySession.class);
    private PMediaKeySession(){
    }

    public void setOnkeystatuseschange(final PEventHandlerNonNull onkeystatuseschange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONKEYSTATUSESCHANGE, new AttributeCallBack(onkeystatuseschange, atrsEventName));
       log.info("onkeystatuseschange" + onkeystatuseschange.getClass().getName());
    }
    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }

    public PEventHandlerNonNull getOnkeystatuseschange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONKEYSTATUSESCHANGE);
    }
    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<Void> close() {
       return null;
    }


    public PPromise<Void> generateRequest(String initDataType, PArrayBuffer initData) {
       return null;
    }


    public PPromise<Void> generateRequest(String initDataType, PArrayBufferView initData) {
       return null;
    }


    public PPromise<Boolean> load(String sessionId) {
       return null;
    }


    public PPromise<Void> remove() {
       return null;
    }


    public PPromise<Void> update(PArrayBuffer response) {
       return null;
    }


    public PPromise<Void> update(PArrayBufferView response) {
       return null;
    }


    
}