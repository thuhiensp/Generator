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
public class PPerformance extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PPerformance.class);
    private PPerformance(){
    }

    public void setOnresourcetimingbufferfull(final PEventHandlerNonNull onresourcetimingbufferfull, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRESOURCETIMINGBUFFERFULL, new AttributeCallBack(onresourcetimingbufferfull, atrsEventName));
       log.info("onresourcetimingbufferfull" + onresourcetimingbufferfull.getClass().getName());
    }

    public PEventHandlerNonNull getOnresourcetimingbufferfull(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRESOURCETIMINGBUFFERFULL);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void clearMarks(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_MARKS_VOID.getValue());
       writer.endObject();
    }

    public void clearMarks(String markName){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_MARKS_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {markName});
       writer.endObject();
    }

    public void clearMeasures(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_MEASURES_VOID.getValue());
       writer.endObject();
    }

    public void clearMeasures(String measureName){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_MEASURES_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {measureName});
       writer.endObject();
    }

    public void clearResourceTimings(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_RESOURCE_TIMINGS_VOID.getValue());
       writer.endObject();
    }

    public PPerformanceEntry[] getEntries() {
       return null;
    }


    public PPerformanceEntry[] getEntriesByName(String name) {
       return null;
    }


    public PPerformanceEntry[] getEntriesByName(String name, String entryType) {
       return null;
    }


    public PPerformanceEntry[] getEntriesByType(String entryType) {
       return null;
    }


    public void mark(String markName){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MARK_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {markName});
       writer.endObject();
    }

    public void measure(String measureName){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MEASURE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {measureName});
       writer.endObject();
    }

    public void measure(String measureName, String startMark){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MEASURE_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {measureName,startMark});
       writer.endObject();
    }

    public void measure(String measureName, String startMark, String endMark){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MEASURE_TYPESTRING_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {measureName,startMark,endMark});
       writer.endObject();
    }

    public void now(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.NOW_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void setResourceTimingBufferSize(Double maxSize){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_RESOURCE_TIMING_BUFFER_SIZE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {maxSize});
       writer.endObject();
    }

    
}