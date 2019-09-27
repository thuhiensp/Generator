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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PAudioBufferSourceNode extends PAudioScheduledSourceNode {
    private static final Logger log = LoggerFactory.getLogger(PAudioBufferSourceNode.class);
    public PAudioBufferSourceNode(PBaseAudioContext context){
      super(context);
    }

    public PAudioBufferSourceNode(PBaseAudioContext context, PAudioBufferSourceOptions options){
      super(context, options);
    }


    public void setBuffer(final PAudioBuffer buffer)  {
       setAttribute(PAttributeNames.BUFFER, buffer);
       log.info("buffer" + buffer);
    }
    public void setLoop(final Boolean loop)  {
       setAttribute(PAttributeNames.LOOP_BOOLEAN, loop);
       log.info("loop" + loop);
    }
    public void setLoopStart(final Double loopStart)  {
       setAttribute(PAttributeNames.LOOP_START, loopStart);
       log.info("loopStart" + loopStart);
    }
    public void setLoopEnd(final Double loopEnd)  {
       setAttribute(PAttributeNames.LOOP_END, loopEnd);
       log.info("loopEnd" + loopEnd);
    }

    public PAudioBuffer getBuffer(){
      return (PAudioBuffer) getAttribute(PAttributeNames.BUFFER);
    }
    public Boolean getLoop(){
      return (Boolean) getAttribute(PAttributeNames.LOOP_BOOLEAN);
    }
    public Double getLoopStart(){
      return (Double) getAttribute(PAttributeNames.LOOP_START);
    }
    public Double getLoopEnd(){
      return (Double) getAttribute(PAttributeNames.LOOP_END);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.AUDIO_BUFFER_SOURCE_NODE;
    }


    public void start(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_VOID.getValue());
       writer.endObject();
    }

    public void start(Double when){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {when});
       writer.endObject();
    }

    public void start(Double when, Double grainOffset){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {when,grainOffset});
       writer.endObject();
    }

    public void start(Double when, Double grainOffset, Double grainDuration){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {when,grainOffset,grainDuration});
       writer.endObject();
    }

    
}