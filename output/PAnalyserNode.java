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
public class PAnalyserNode extends PAudioNode {
    private static final Logger log = LoggerFactory.getLogger(PAnalyserNode.class);
    public PAnalyserNode(PBaseAudioContext context){
      super(context);
    }

    public PAnalyserNode(PBaseAudioContext context, PAnalyserOptions options){
      super(context, options);
    }


    public void setFftSize(final Double fftSize)  {
       setAttribute(PAttributeNames.FFT_SIZE, fftSize);
       log.info("fftSize" + fftSize);
    }
    public void setMinDecibels(final Double minDecibels)  {
       setAttribute(PAttributeNames.MIN_DECIBELS, minDecibels);
       log.info("minDecibels" + minDecibels);
    }
    public void setMaxDecibels(final Double maxDecibels)  {
       setAttribute(PAttributeNames.MAX_DECIBELS, maxDecibels);
       log.info("maxDecibels" + maxDecibels);
    }
    public void setSmoothingTimeConstant(final Double smoothingTimeConstant)  {
       setAttribute(PAttributeNames.SMOOTHING_TIME_CONSTANT, smoothingTimeConstant);
       log.info("smoothingTimeConstant" + smoothingTimeConstant);
    }

    public Double getFftSize(){
      return (Double) getAttribute(PAttributeNames.FFT_SIZE);
    }
    public Double getMinDecibels(){
      return (Double) getAttribute(PAttributeNames.MIN_DECIBELS);
    }
    public Double getMaxDecibels(){
      return (Double) getAttribute(PAttributeNames.MAX_DECIBELS);
    }
    public Double getSmoothingTimeConstant(){
      return (Double) getAttribute(PAttributeNames.SMOOTHING_TIME_CONSTANT);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.ANALYSER_NODE;
    }


    public void getByteFrequencyData(PUint8Array array){
    }

    public void getByteTimeDomainData(PUint8Array array){
    }

    public void getFloatFrequencyData(PFloat32Array array){
    }

    public void getFloatTimeDomainData(PFloat32Array array){
    }

    
}