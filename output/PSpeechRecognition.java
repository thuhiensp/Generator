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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PSpeechRecognition extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PSpeechRecognition.class);
    public PSpeechRecognition() {
    }



    public void setGrammars(final PSpeechGrammarList grammars)  {
       setAttribute(PAttributeNames.GRAMMARS, grammars);
       log.info("grammars" + grammars);
    }
    public void setLang(final String lang)  {
       setAttribute(PAttributeNames.LANG, lang);
       log.info("lang" + lang);
    }
    public void setContinuous(final Boolean continuous)  {
       setAttribute(PAttributeNames.CONTINUOUS, continuous);
       log.info("continuous" + continuous);
    }
    public void setInterimResults(final Boolean interimResults)  {
       setAttribute(PAttributeNames.INTERIM_RESULTS, interimResults);
       log.info("interimResults" + interimResults);
    }
    public void setMaxAlternatives(final Double maxAlternatives)  {
       setAttribute(PAttributeNames.MAX_ALTERNATIVES, maxAlternatives);
       log.info("maxAlternatives" + maxAlternatives);
    }
    public void setAudioTrack(final PMediaStreamTrack audioTrack)  {
       setAttribute(PAttributeNames.AUDIO_TRACK, audioTrack);
       log.info("audioTrack" + audioTrack);
    }
    public void setOnaudiostart(final PEventHandlerNonNull onaudiostart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONAUDIOSTART, new AttributeCallBack(onaudiostart, atrsEventName));
       log.info("onaudiostart" + onaudiostart.getClass().getName());
    }
    public void setOnsoundstart(final PEventHandlerNonNull onsoundstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSOUNDSTART, new AttributeCallBack(onsoundstart, atrsEventName));
       log.info("onsoundstart" + onsoundstart.getClass().getName());
    }
    public void setOnspeechstart(final PEventHandlerNonNull onspeechstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSPEECHSTART, new AttributeCallBack(onspeechstart, atrsEventName));
       log.info("onspeechstart" + onspeechstart.getClass().getName());
    }
    public void setOnspeechend(final PEventHandlerNonNull onspeechend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSPEECHEND, new AttributeCallBack(onspeechend, atrsEventName));
       log.info("onspeechend" + onspeechend.getClass().getName());
    }
    public void setOnsoundend(final PEventHandlerNonNull onsoundend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSOUNDEND, new AttributeCallBack(onsoundend, atrsEventName));
       log.info("onsoundend" + onsoundend.getClass().getName());
    }
    public void setOnaudioend(final PEventHandlerNonNull onaudioend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONAUDIOEND, new AttributeCallBack(onaudioend, atrsEventName));
       log.info("onaudioend" + onaudioend.getClass().getName());
    }
    public void setOnresult(final PEventHandlerNonNull onresult, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRESULT, new AttributeCallBack(onresult, atrsEventName));
       log.info("onresult" + onresult.getClass().getName());
    }
    public void setOnnomatch(final PEventHandlerNonNull onnomatch, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONNOMATCH, new AttributeCallBack(onnomatch, atrsEventName));
       log.info("onnomatch" + onnomatch.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnstart(final PEventHandlerNonNull onstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTART, new AttributeCallBack(onstart, atrsEventName));
       log.info("onstart" + onstart.getClass().getName());
    }
    public void setOnend(final PEventHandlerNonNull onend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONEND, new AttributeCallBack(onend, atrsEventName));
       log.info("onend" + onend.getClass().getName());
    }

    public PSpeechGrammarList getGrammars(){
      return (PSpeechGrammarList) getAttribute(PAttributeNames.GRAMMARS);
    }
    public String getLang(){
      return (String) getAttribute(PAttributeNames.LANG);
    }
    public Boolean getContinuous(){
      return (Boolean) getAttribute(PAttributeNames.CONTINUOUS);
    }
    public Boolean getInterimResults(){
      return (Boolean) getAttribute(PAttributeNames.INTERIM_RESULTS);
    }
    public Double getMaxAlternatives(){
      return (Double) getAttribute(PAttributeNames.MAX_ALTERNATIVES);
    }
    public PMediaStreamTrack getAudioTrack(){
      return (PMediaStreamTrack) getAttribute(PAttributeNames.AUDIO_TRACK);
    }
    public PEventHandlerNonNull getOnaudiostart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONAUDIOSTART);
    }
    public PEventHandlerNonNull getOnsoundstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSOUNDSTART);
    }
    public PEventHandlerNonNull getOnspeechstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSPEECHSTART);
    }
    public PEventHandlerNonNull getOnspeechend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSPEECHEND);
    }
    public PEventHandlerNonNull getOnsoundend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSOUNDEND);
    }
    public PEventHandlerNonNull getOnaudioend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONAUDIOEND);
    }
    public PEventHandlerNonNull getOnresult(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRESULT);
    }
    public PEventHandlerNonNull getOnnomatch(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONNOMATCH);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTART);
    }
    public PEventHandlerNonNull getOnend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONEND);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.SPEECH_RECOGNITION;
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

    public void start(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_VOID.getValue());
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