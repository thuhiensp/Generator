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
public class PSourceBuffer extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PSourceBuffer.class);
    private PSourceBuffer(){
    }

    public void setTimestampOffset(final Double timestampOffset)  {
       setAttribute(PAttributeNames.TIMESTAMP_OFFSET, timestampOffset);
       log.info("timestampOffset" + timestampOffset);
    }
    public void setAppendWindowStart(final Double appendWindowStart)  {
       setAttribute(PAttributeNames.APPEND_WINDOW_START, appendWindowStart);
       log.info("appendWindowStart" + appendWindowStart);
    }
    public void setAppendWindowEnd(final Double appendWindowEnd)  {
       setAttribute(PAttributeNames.APPEND_WINDOW_END, appendWindowEnd);
       log.info("appendWindowEnd" + appendWindowEnd);
    }
    public void setOnupdatestart(final PEventHandlerNonNull onupdatestart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUPDATESTART, new AttributeCallBack(onupdatestart, atrsEventName));
       log.info("onupdatestart" + onupdatestart.getClass().getName());
    }
    public void setOnupdate(final PEventHandlerNonNull onupdate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUPDATE, new AttributeCallBack(onupdate, atrsEventName));
       log.info("onupdate" + onupdate.getClass().getName());
    }
    public void setOnupdateend(final PEventHandlerNonNull onupdateend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUPDATEEND, new AttributeCallBack(onupdateend, atrsEventName));
       log.info("onupdateend" + onupdateend.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnabort(final PEventHandlerNonNull onabort, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONABORT, new AttributeCallBack(onabort, atrsEventName));
       log.info("onabort" + onabort.getClass().getName());
    }
    public void setTrackDefaults(final PTrackDefaultList trackDefaults)  {
       setAttribute(PAttributeNames.TRACK_DEFAULTS, trackDefaults);
       log.info("trackDefaults" + trackDefaults);
    }
    public void setMode(final PAppendMode mode)  {
       setAttribute(PAttributeNames.MODE, mode);
       log.info("mode" + mode);
    }

    public Double getTimestampOffset(){
      return (Double) getAttribute(PAttributeNames.TIMESTAMP_OFFSET);
    }
    public Double getAppendWindowStart(){
      return (Double) getAttribute(PAttributeNames.APPEND_WINDOW_START);
    }
    public Double getAppendWindowEnd(){
      return (Double) getAttribute(PAttributeNames.APPEND_WINDOW_END);
    }
    public PEventHandlerNonNull getOnupdatestart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUPDATESTART);
    }
    public PEventHandlerNonNull getOnupdate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUPDATE);
    }
    public PEventHandlerNonNull getOnupdateend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUPDATEEND);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnabort(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONABORT);
    }
    public PTrackDefaultList getTrackDefaults(){
      return (PTrackDefaultList) getAttribute(PAttributeNames.TRACK_DEFAULTS);
    }
    public PAppendMode getMode(){
      return (PAppendMode) getAttribute(PAttributeNames.MODE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void abort(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ABORT_VOID.getValue());
       writer.endObject();
    }

    public void appendBuffer(PArrayBuffer data){
    }

    public void appendBuffer(PArrayBufferView data){
    }

    public void remove(Double start, Double end){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {start,end});
       writer.endObject();
    }

    
}