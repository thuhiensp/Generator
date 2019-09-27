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
public class PPannerNode extends PAudioNode {
    private static final Logger log = LoggerFactory.getLogger(PPannerNode.class);
    public PPannerNode(PBaseAudioContext context){
      super(context);
    }

    public PPannerNode(PBaseAudioContext context, PPannerOptions options){
      super(context, options);
    }


    public void setRefDistance(final Double refDistance)  {
       setAttribute(PAttributeNames.REF_DISTANCE, refDistance);
       log.info("refDistance" + refDistance);
    }
    public void setMaxDistance(final Double maxDistance)  {
       setAttribute(PAttributeNames.MAX_DISTANCE, maxDistance);
       log.info("maxDistance" + maxDistance);
    }
    public void setRolloffFactor(final Double rolloffFactor)  {
       setAttribute(PAttributeNames.ROLLOFF_FACTOR, rolloffFactor);
       log.info("rolloffFactor" + rolloffFactor);
    }
    public void setConeInnerAngle(final Double coneInnerAngle)  {
       setAttribute(PAttributeNames.CONE_INNER_ANGLE, coneInnerAngle);
       log.info("coneInnerAngle" + coneInnerAngle);
    }
    public void setConeOuterAngle(final Double coneOuterAngle)  {
       setAttribute(PAttributeNames.CONE_OUTER_ANGLE, coneOuterAngle);
       log.info("coneOuterAngle" + coneOuterAngle);
    }
    public void setConeOuterGain(final Double coneOuterGain)  {
       setAttribute(PAttributeNames.CONE_OUTER_GAIN, coneOuterGain);
       log.info("coneOuterGain" + coneOuterGain);
    }
    public void setPanningModel(final PPanningModelType panningModel)  {
       setAttribute(PAttributeNames.PANNING_MODEL, panningModel);
       log.info("panningModel" + panningModel);
    }
    public void setDistanceModel(final PDistanceModelType distanceModel)  {
       setAttribute(PAttributeNames.DISTANCE_MODEL, distanceModel);
       log.info("distanceModel" + distanceModel);
    }

    public Double getRefDistance(){
      return (Double) getAttribute(PAttributeNames.REF_DISTANCE);
    }
    public Double getMaxDistance(){
      return (Double) getAttribute(PAttributeNames.MAX_DISTANCE);
    }
    public Double getRolloffFactor(){
      return (Double) getAttribute(PAttributeNames.ROLLOFF_FACTOR);
    }
    public Double getConeInnerAngle(){
      return (Double) getAttribute(PAttributeNames.CONE_INNER_ANGLE);
    }
    public Double getConeOuterAngle(){
      return (Double) getAttribute(PAttributeNames.CONE_OUTER_ANGLE);
    }
    public Double getConeOuterGain(){
      return (Double) getAttribute(PAttributeNames.CONE_OUTER_GAIN);
    }
    public PPanningModelType getPanningModel(){
      return (PPanningModelType) getAttribute(PAttributeNames.PANNING_MODEL);
    }
    public PDistanceModelType getDistanceModel(){
      return (PDistanceModelType) getAttribute(PAttributeNames.DISTANCE_MODEL);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.PANNER_NODE;
    }


    public void setOrientation(Double x, Double y, Double z){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_ORIENTATION_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,z});
       writer.endObject();
    }

    public void setPosition(Double x, Double y, Double z){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_POSITION_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,z});
       writer.endObject();
    }

    
}