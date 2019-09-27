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
public abstract class PAudioNode extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PAudioNode.class);
     protected PAudioNode() {
     }
    protected PAudioNode(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setChannelCount(final Double channelCount)  {
       setAttribute(PAttributeNames.CHANNEL_COUNT, channelCount);
       log.info("channelCount" + channelCount);
    }
    public void setChannelCountMode(final PChannelCountMode channelCountMode)  {
       setAttribute(PAttributeNames.CHANNEL_COUNT_MODE, channelCountMode);
       log.info("channelCountMode" + channelCountMode);
    }
    public void setChannelInterpretation(final PChannelInterpretation channelInterpretation)  {
       setAttribute(PAttributeNames.CHANNEL_INTERPRETATION, channelInterpretation);
       log.info("channelInterpretation" + channelInterpretation);
    }

    public Double getChannelCount(){
      return (Double) getAttribute(PAttributeNames.CHANNEL_COUNT);
    }
    public PChannelCountMode getChannelCountMode(){
      return (PChannelCountMode) getAttribute(PAttributeNames.CHANNEL_COUNT_MODE);
    }
    public PChannelInterpretation getChannelInterpretation(){
      return (PChannelInterpretation) getAttribute(PAttributeNames.CHANNEL_INTERPRETATION);
    }


    public PAudioNode connect(PAudioNode destination) {
       return null;
    }


    public void connect(PAudioParam destination){
    }

    public PAudioNode connect(PAudioNode destination, Double output) {
       return null;
    }


    public void connect(PAudioParam destination, Double output){
    }

    public PAudioNode connect(PAudioNode destination, Double output, Double input) {
       return null;
    }


    public void disconnect(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DISCONNECT_VOID.getValue());
       writer.endObject();
    }

    public void disconnect(Double output){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DISCONNECT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {output});
       writer.endObject();
    }

    public void disconnect(PAudioNode destination){
    }

    public void disconnect(PAudioParam destination){
    }

    public void disconnect(PAudioNode destination, Double output){
    }

    public void disconnect(PAudioParam destination, Double output){
    }

    public void disconnect(PAudioNode destination, Double output, Double input){
    }

    
}