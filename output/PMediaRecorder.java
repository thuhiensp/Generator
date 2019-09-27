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
public class PMediaRecorder extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PMediaRecorder.class);
    public PMediaRecorder(PMediaStream stream){
      super(stream);
    }

    public PMediaRecorder(PMediaStream stream, PMediaRecorderOptions options){
      super(stream, options);
    }


    public void setOnstart(final PEventHandlerNonNull onstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTART, new AttributeCallBack(onstart, atrsEventName));
       log.info("onstart" + onstart.getClass().getName());
    }
    public void setOnstop(final PEventHandlerNonNull onstop, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTOP, new AttributeCallBack(onstop, atrsEventName));
       log.info("onstop" + onstop.getClass().getName());
    }
    public void setOndataavailable(final PEventHandlerNonNull ondataavailable, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDATAAVAILABLE, new AttributeCallBack(ondataavailable, atrsEventName));
       log.info("ondataavailable" + ondataavailable.getClass().getName());
    }
    public void setOnpause(final PEventHandlerNonNull onpause, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAUSE, new AttributeCallBack(onpause, atrsEventName));
       log.info("onpause" + onpause.getClass().getName());
    }
    public void setOnresume(final PEventHandlerNonNull onresume, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRESUME, new AttributeCallBack(onresume, atrsEventName));
       log.info("onresume" + onresume.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }

    public PEventHandlerNonNull getOnstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTART);
    }
    public PEventHandlerNonNull getOnstop(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTOP);
    }
    public PEventHandlerNonNull getOndataavailable(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDATAAVAILABLE);
    }
    public PEventHandlerNonNull getOnpause(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAUSE);
    }
    public PEventHandlerNonNull getOnresume(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRESUME);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.MEDIA_RECORDER;
    }


    public void isTypeSupported(final Consumer<Boolean> cback,String type){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_TYPE_SUPPORTED_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {type});
       writer.endObject();
    }

    public void pause(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PAUSE_VOID.getValue());
       writer.endObject();
    }

    public void requestData(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REQUEST_DATA_VOID.getValue());
       writer.endObject();
    }

    public void resume(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESUME_VOID.getValue());
       writer.endObject();
    }

    public void start(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_VOID.getValue());
       writer.endObject();
    }

    public void start(Double timeslice){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {timeslice});
       writer.endObject();
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