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
public abstract class PTextTrackCue extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PTextTrackCue.class);
     protected PTextTrackCue() {
     }
    protected PTextTrackCue(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setId(final String id)  {
       setAttribute(PAttributeNames.ID, id);
       log.info("id" + id);
    }
    public void setStartTime(final Double startTime)  {
       setAttribute(PAttributeNames.START_TIME, startTime);
       log.info("startTime" + startTime);
    }
    public void setEndTime(final Double endTime)  {
       setAttribute(PAttributeNames.END_TIME, endTime);
       log.info("endTime" + endTime);
    }
    public void setPauseOnExit(final Boolean pauseOnExit)  {
       setAttribute(PAttributeNames.PAUSE_ON_EXIT, pauseOnExit);
       log.info("pauseOnExit" + pauseOnExit);
    }
    public void setOnenter(final PEventHandlerNonNull onenter, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONENTER, new AttributeCallBack(onenter, atrsEventName));
       log.info("onenter" + onenter.getClass().getName());
    }
    public void setOnexit(final PEventHandlerNonNull onexit, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONEXIT, new AttributeCallBack(onexit, atrsEventName));
       log.info("onexit" + onexit.getClass().getName());
    }

    public String getId(){
      return (String) getAttribute(PAttributeNames.ID);
    }
    public Double getStartTime(){
      return (Double) getAttribute(PAttributeNames.START_TIME);
    }
    public Double getEndTime(){
      return (Double) getAttribute(PAttributeNames.END_TIME);
    }
    public Boolean getPauseOnExit(){
      return (Boolean) getAttribute(PAttributeNames.PAUSE_ON_EXIT);
    }
    public PEventHandlerNonNull getOnenter(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONENTER);
    }
    public PEventHandlerNonNull getOnexit(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONEXIT);
    }


    
}