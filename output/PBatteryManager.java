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
public class PBatteryManager extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PBatteryManager.class);
    private PBatteryManager(){
    }

    public void setOnchargingchange(final PEventHandlerNonNull onchargingchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCHARGINGCHANGE, new AttributeCallBack(onchargingchange, atrsEventName));
       log.info("onchargingchange" + onchargingchange.getClass().getName());
    }
    public void setOnchargingtimechange(final PEventHandlerNonNull onchargingtimechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCHARGINGTIMECHANGE, new AttributeCallBack(onchargingtimechange, atrsEventName));
       log.info("onchargingtimechange" + onchargingtimechange.getClass().getName());
    }
    public void setOndischargingtimechange(final PEventHandlerNonNull ondischargingtimechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDISCHARGINGTIMECHANGE, new AttributeCallBack(ondischargingtimechange, atrsEventName));
       log.info("ondischargingtimechange" + ondischargingtimechange.getClass().getName());
    }
    public void setOnlevelchange(final PEventHandlerNonNull onlevelchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLEVELCHANGE, new AttributeCallBack(onlevelchange, atrsEventName));
       log.info("onlevelchange" + onlevelchange.getClass().getName());
    }

    public PEventHandlerNonNull getOnchargingchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCHARGINGCHANGE);
    }
    public PEventHandlerNonNull getOnchargingtimechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCHARGINGTIMECHANGE);
    }
    public PEventHandlerNonNull getOndischargingtimechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDISCHARGINGTIMECHANGE);
    }
    public PEventHandlerNonNull getOnlevelchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLEVELCHANGE);
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