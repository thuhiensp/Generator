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
public class PAnimation extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PAnimation.class);
    public PAnimation() {
    }


    public PAnimation(PAnimationEffectReadOnly effect){
      super(effect);
    }

    public PAnimation(PAnimationEffectReadOnly effect, PAnimationTimeline timeline){
      super(effect, timeline);
    }


    public void setEffect(final PAnimationEffectReadOnly effect)  {
       setAttribute(PAttributeNames.EFFECT, effect);
       log.info("effect" + effect);
    }
    public void setStartTime(final Double startTime)  {
       setAttribute(PAttributeNames.START_TIME, startTime);
       log.info("startTime" + startTime);
    }
    public void setCurrentTime(final Double currentTime)  {
       setAttribute(PAttributeNames.CURRENT_TIME, currentTime);
       log.info("currentTime" + currentTime);
    }
    public void setPlaybackRate(final Double playbackRate)  {
       setAttribute(PAttributeNames.PLAYBACK_RATE, playbackRate);
       log.info("playbackRate" + playbackRate);
    }
    public void setId(final String id)  {
       setAttribute(PAttributeNames.ID, id);
       log.info("id" + id);
    }
    public void setOnfinish(final PEventHandlerNonNull onfinish, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONFINISH, new AttributeCallBack(onfinish, atrsEventName));
       log.info("onfinish" + onfinish.getClass().getName());
    }
    public void setOncancel(final PEventHandlerNonNull oncancel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCANCEL, new AttributeCallBack(oncancel, atrsEventName));
       log.info("oncancel" + oncancel.getClass().getName());
    }

    public PAnimationEffectReadOnly getEffect(){
      return (PAnimationEffectReadOnly) getAttribute(PAttributeNames.EFFECT);
    }
    public Double getStartTime(){
      return (Double) getAttribute(PAttributeNames.START_TIME);
    }
    public Double getCurrentTime(){
      return (Double) getAttribute(PAttributeNames.CURRENT_TIME);
    }
    public Double getPlaybackRate(){
      return (Double) getAttribute(PAttributeNames.PLAYBACK_RATE);
    }
    public String getId(){
      return (String) getAttribute(PAttributeNames.ID);
    }
    public PEventHandlerNonNull getOnfinish(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONFINISH);
    }
    public PEventHandlerNonNull getOncancel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCANCEL);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.ANIMATION;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.ANIMATION;
    }


    public void cancel(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CANCEL_VOID.getValue());
       writer.endObject();
    }

    public void finish(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FINISH_VOID.getValue());
       writer.endObject();
    }

    public void pause(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PAUSE_VOID.getValue());
       writer.endObject();
    }

    public void play(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PLAY_VOID.getValue());
       writer.endObject();
    }

    public void reverse(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REVERSE_VOID.getValue());
       writer.endObject();
    }

    
}