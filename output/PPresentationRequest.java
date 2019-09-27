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
public class PPresentationRequest extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PPresentationRequest.class);
    public PPresentationRequest(String url){
      super(url);
    }

    public PPresentationRequest(String[] urls){
      super(urls);
    }


    public void setOnconnectionavailable(final PEventHandlerNonNull onconnectionavailable, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCONNECTIONAVAILABLE, new AttributeCallBack(onconnectionavailable, atrsEventName));
       log.info("onconnectionavailable" + onconnectionavailable.getClass().getName());
    }

    public PEventHandlerNonNull getOnconnectionavailable(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCONNECTIONAVAILABLE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.PRESENTATION_REQUEST;
    }


    public PPromise<PPresentationAvailability> getAvailability() {
       return null;
    }


    public PPromise<PPresentationConnection> reconnect(String id) {
       return null;
    }


    public PPromise<PPresentationConnection> start() {
       return null;
    }


    
}