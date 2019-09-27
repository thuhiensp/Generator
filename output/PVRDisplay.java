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
public class PVRDisplay extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PVRDisplay.class);
    private PVRDisplay(){
    }

    public void setDepthNear(final Double depthNear)  {
       setAttribute(PAttributeNames.DEPTH_NEAR, depthNear);
       log.info("depthNear" + depthNear);
    }
    public void setDepthFar(final Double depthFar)  {
       setAttribute(PAttributeNames.DEPTH_FAR, depthFar);
       log.info("depthFar" + depthFar);
    }

    public Double getDepthNear(){
      return (Double) getAttribute(PAttributeNames.DEPTH_NEAR);
    }
    public Double getDepthFar(){
      return (Double) getAttribute(PAttributeNames.DEPTH_FAR);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void cancelAnimationFrame(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CANCEL_ANIMATION_FRAME_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public PPromise exitPresent() {
       return null;
    }


    public PVREyeParameters getEyeParameters(PVREye whichEye) {
       return null;
    }


    public PVREyeParameters getEyeParameters(String whichEye) {
       return null;
    }


    public void getFrameData(final Consumer<Boolean> cback,PVRFrameData frameData){
    }

    public PVRLayer[] getLayers() {
       return null;
    }


    public void requestAnimationFrame(final Consumer<Double> cback,PFrameRequestCallback callback){
    }

    public PPromise requestPresent(PVRLayer[] layers) {
       return null;
    }


    public void submitFrame(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SUBMIT_FRAME_VOID.getValue());
       writer.endObject();
    }

    
}