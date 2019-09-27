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
public class PRemotePlayback extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PRemotePlayback.class);
    private PRemotePlayback(){
    }

    public void setOnconnecting(final PEventHandlerNonNull onconnecting, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCONNECTING, new AttributeCallBack(onconnecting, atrsEventName));
       log.info("onconnecting" + onconnecting.getClass().getName());
    }
    public void setOnconnect(final PEventHandlerNonNull onconnect, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCONNECT, new AttributeCallBack(onconnect, atrsEventName));
       log.info("onconnect" + onconnect.getClass().getName());
    }
    public void setOndisconnect(final PEventHandlerNonNull ondisconnect, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDISCONNECT, new AttributeCallBack(ondisconnect, atrsEventName));
       log.info("ondisconnect" + ondisconnect.getClass().getName());
    }

    public PEventHandlerNonNull getOnconnecting(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCONNECTING);
    }
    public PEventHandlerNonNull getOnconnect(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCONNECT);
    }
    public PEventHandlerNonNull getOndisconnect(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDISCONNECT);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<Void> cancelWatchAvailability() {
       return null;
    }


    public PPromise<Void> cancelWatchAvailability(Double id) {
       return null;
    }


    public PPromise<Void> prompt() {
       return null;
    }


    public PPromise<Double> watchAvailability(PRemotePlaybackAvailabilityCallback callback) {
       return null;
    }


    
}