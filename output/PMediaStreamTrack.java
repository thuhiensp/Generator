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
public abstract class PMediaStreamTrack extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PMediaStreamTrack.class);
     protected PMediaStreamTrack() {
     }
    protected PMediaStreamTrack(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setEnabled(final Boolean enabled)  {
       setAttribute(PAttributeNames.ENABLED, enabled);
       log.info("enabled" + enabled);
    }
    public void setOnmute(final PEventHandlerNonNull onmute, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMUTE, new AttributeCallBack(onmute, atrsEventName));
       log.info("onmute" + onmute.getClass().getName());
    }
    public void setOnunmute(final PEventHandlerNonNull onunmute, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUNMUTE, new AttributeCallBack(onunmute, atrsEventName));
       log.info("onunmute" + onunmute.getClass().getName());
    }
    public void setOnended(final PEventHandlerNonNull onended, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONENDED, new AttributeCallBack(onended, atrsEventName));
       log.info("onended" + onended.getClass().getName());
    }
    public void setContentHint(final String contentHint)  {
       setAttribute(PAttributeNames.CONTENT_HINT, contentHint);
       log.info("contentHint" + contentHint);
    }

    public Boolean getEnabled(){
      return (Boolean) getAttribute(PAttributeNames.ENABLED);
    }
    public PEventHandlerNonNull getOnmute(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMUTE);
    }
    public PEventHandlerNonNull getOnunmute(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUNMUTE);
    }
    public PEventHandlerNonNull getOnended(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONENDED);
    }
    public String getContentHint(){
      return (String) getAttribute(PAttributeNames.CONTENT_HINT);
    }


    public PPromise<PMediaTrackConstraints> applyConstraints() {
       return null;
    }


    public PPromise<PMediaTrackConstraints> applyConstraints(PMediaTrackConstraints constraints) {
       return null;
    }


    public PMediaStreamTrack clone() {
       return null;
    }


    public PMediaTrackCapabilities getCapabilities() {
       return null;
    }


    public PMediaTrackConstraints getConstraints() {
       return null;
    }


    public PMediaTrackSettings getSettings() {
       return null;
    }


    public void stop(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STOP_VOID.getValue());
       writer.endObject();
    }

    
}