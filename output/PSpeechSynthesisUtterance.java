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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PSpeechSynthesisUtterance extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PSpeechSynthesisUtterance.class);
    public PSpeechSynthesisUtterance() {
    }


    public PSpeechSynthesisUtterance(String text){
      super(text);
    }


    public void setText(final String text)  {
       setAttribute(PAttributeNames.TEXT, text);
       log.info("text" + text);
    }
    public void setLang(final String lang)  {
       setAttribute(PAttributeNames.LANG, lang);
       log.info("lang" + lang);
    }
    public void setVoice(final PSpeechSynthesisVoice voice)  {
       setAttribute(PAttributeNames.VOICE, voice);
       log.info("voice" + voice);
    }
    public void setVolume(final Double volume)  {
       setAttribute(PAttributeNames.VOLUME, volume);
       log.info("volume" + volume);
    }
    public void setRate(final Double rate)  {
       setAttribute(PAttributeNames.RATE, rate);
       log.info("rate" + rate);
    }
    public void setPitch(final Double pitch)  {
       setAttribute(PAttributeNames.PITCH, pitch);
       log.info("pitch" + pitch);
    }
    public void setOnstart(final PEventHandlerNonNull onstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTART, new AttributeCallBack(onstart, atrsEventName));
       log.info("onstart" + onstart.getClass().getName());
    }
    public void setOnend(final PEventHandlerNonNull onend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONEND, new AttributeCallBack(onend, atrsEventName));
       log.info("onend" + onend.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnpause(final PEventHandlerNonNull onpause, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAUSE, new AttributeCallBack(onpause, atrsEventName));
       log.info("onpause" + onpause.getClass().getName());
    }
    public void setOnresume(final PEventHandlerNonNull onresume, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRESUME, new AttributeCallBack(onresume, atrsEventName));
       log.info("onresume" + onresume.getClass().getName());
    }
    public void setOnmark(final PEventHandlerNonNull onmark, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMARK, new AttributeCallBack(onmark, atrsEventName));
       log.info("onmark" + onmark.getClass().getName());
    }
    public void setOnboundary(final PEventHandlerNonNull onboundary, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBOUNDARY, new AttributeCallBack(onboundary, atrsEventName));
       log.info("onboundary" + onboundary.getClass().getName());
    }

    public String getText(){
      return (String) getAttribute(PAttributeNames.TEXT);
    }
    public String getLang(){
      return (String) getAttribute(PAttributeNames.LANG);
    }
    public PSpeechSynthesisVoice getVoice(){
      return (PSpeechSynthesisVoice) getAttribute(PAttributeNames.VOICE);
    }
    public Double getVolume(){
      return (Double) getAttribute(PAttributeNames.VOLUME);
    }
    public Double getRate(){
      return (Double) getAttribute(PAttributeNames.RATE);
    }
    public Double getPitch(){
      return (Double) getAttribute(PAttributeNames.PITCH);
    }
    public PEventHandlerNonNull getOnstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTART);
    }
    public PEventHandlerNonNull getOnend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONEND);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnpause(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAUSE);
    }
    public PEventHandlerNonNull getOnresume(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRESUME);
    }
    public PEventHandlerNonNull getOnmark(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMARK);
    }
    public PEventHandlerNonNull getOnboundary(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBOUNDARY);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.SPEECH_SYNTHESIS_UTTERANCE;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.SPEECH_SYNTHESIS_UTTERANCE;
    }


    
}