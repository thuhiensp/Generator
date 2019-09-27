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
public abstract class PBaseAudioContext extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PBaseAudioContext.class);
     protected PBaseAudioContext() {
     }
    protected PBaseAudioContext(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setOnstatechange(final PEventHandlerNonNull onstatechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTATECHANGE, new AttributeCallBack(onstatechange, atrsEventName));
       log.info("onstatechange" + onstatechange.getClass().getName());
    }

    public PEventHandlerNonNull getOnstatechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTATECHANGE);
    }


    public PAnalyserNode createAnalyser() {
       return null;
    }


    public PBiquadFilterNode createBiquadFilter() {
       return null;
    }


    public PAudioBuffer createBuffer(Double numberOfChannels, Double numberOfFrames, Double sampleRate) {
       return null;
    }


    public PAudioBufferSourceNode createBufferSource() {
       return null;
    }


    public PChannelMergerNode createChannelMerger() {
       return null;
    }


    public PChannelMergerNode createChannelMerger(Double numberOfInputs) {
       return null;
    }


    public PChannelSplitterNode createChannelSplitter() {
       return null;
    }


    public PChannelSplitterNode createChannelSplitter(Double numberOfOutputs) {
       return null;
    }


    public PConstantSourceNode createConstantSource() {
       return null;
    }


    public PConvolverNode createConvolver() {
       return null;
    }


    public PDelayNode createDelay() {
       return null;
    }


    public PDelayNode createDelay(Double maxDelayTime) {
       return null;
    }


    public PDynamicsCompressorNode createDynamicsCompressor() {
       return null;
    }


    public PGainNode createGain() {
       return null;
    }


    public PIIRFilterNode createIIRFilter(Double[] feedForward, Double[] feedBack) {
       return null;
    }


    public PMediaElementAudioSourceNode createMediaElementSource(PHTMLMediaElement mediaElement) {
       return null;
    }


    public PMediaStreamAudioDestinationNode createMediaStreamDestination() {
       return null;
    }


    public PMediaStreamAudioSourceNode createMediaStreamSource(PMediaStream mediaStream) {
       return null;
    }


    public POscillatorNode createOscillator() {
       return null;
    }


    public PPannerNode createPanner() {
       return null;
    }


    public PPeriodicWave createPeriodicWave(Double[] real, Double[] imag) {
       return null;
    }


    public PPeriodicWave createPeriodicWave(Double[] real, Double[] imag, PPeriodicWaveConstraints options) {
       return null;
    }


    public PScriptProcessorNode createScriptProcessor() {
       return null;
    }


    public PScriptProcessorNode createScriptProcessor(Double bufferSize) {
       return null;
    }


    public PScriptProcessorNode createScriptProcessor(Double bufferSize, Double numberOfInputChannels) {
       return null;
    }


    public PScriptProcessorNode createScriptProcessor(Double bufferSize, Double numberOfInputChannels, Double numberOfOutputChannels) {
       return null;
    }


    public PStereoPannerNode createStereoPanner() {
       return null;
    }


    public PWaveShaperNode createWaveShaper() {
       return null;
    }


    public PPromise<PAudioBuffer> decodeAudioData(PArrayBuffer audioData) {
       return null;
    }


    public PPromise<PAudioBuffer> decodeAudioData(PArrayBuffer audioData, PDecodeSuccessCallback successCallback) {
       return null;
    }


    public PPromise<PAudioBuffer> decodeAudioData(PArrayBuffer audioData, PDecodeSuccessCallback successCallback, PDecodeErrorCallback errorCallback) {
       return null;
    }


    public PPromise<Void> resume() {
       return null;
    }


    
}