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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PMediaSource extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PMediaSource.class);
    public PMediaSource() {
    }



    public void setDuration(final Double duration)  {
       setAttribute(PAttributeNames.DURATION_DOUBLE, duration);
       log.info("duration" + duration);
    }
    public void setOnsourceopen(final PEventHandlerNonNull onsourceopen, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSOURCEOPEN, new AttributeCallBack(onsourceopen, atrsEventName));
       log.info("onsourceopen" + onsourceopen.getClass().getName());
    }
    public void setOnsourceended(final PEventHandlerNonNull onsourceended, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSOURCEENDED, new AttributeCallBack(onsourceended, atrsEventName));
       log.info("onsourceended" + onsourceended.getClass().getName());
    }
    public void setOnsourceclose(final PEventHandlerNonNull onsourceclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSOURCECLOSE, new AttributeCallBack(onsourceclose, atrsEventName));
       log.info("onsourceclose" + onsourceclose.getClass().getName());
    }

    public Double getDuration(){
      return (Double) getAttribute(PAttributeNames.DURATION_DOUBLE);
    }
    public PEventHandlerNonNull getOnsourceopen(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSOURCEOPEN);
    }
    public PEventHandlerNonNull getOnsourceended(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSOURCEENDED);
    }
    public PEventHandlerNonNull getOnsourceclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSOURCECLOSE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.MEDIA_SOURCE;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PSourceBuffer addSourceBuffer(String type) {
       return null;
    }


    public void clearLiveSeekableRange(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_LIVE_SEEKABLE_RANGE_VOID.getValue());
       writer.endObject();
    }

    public void endOfStream(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       END_OF_STREAM_VOID.getValue());
       writer.endObject();
    }

    public void endOfStream(PEndOfStreamError error){
    }

    public void endOfStream(String error){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       END_OF_STREAM_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {error});
       writer.endObject();
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

    public void removeSourceBuffer(PSourceBuffer buffer){
    }

    public void setLiveSeekableRange(Double start, Double end){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_LIVE_SEEKABLE_RANGE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {start,end});
       writer.endObject();
    }

    
}