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
public abstract class PHTMLMediaElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLMediaElement.class);
     protected PHTMLMediaElement() {
     }
    protected PHTMLMediaElement(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setCrossOrigin(final String crossOrigin)  {
       setAttribute(PAttributeNames.CROSS_ORIGIN, crossOrigin);
       log.info("crossOrigin" + crossOrigin);
    }
    public void setPreload(final String preload)  {
       setAttribute(PAttributeNames.PRELOAD, preload);
       log.info("preload" + preload);
    }
    public void setCurrentTime(final Double currentTime)  {
       setAttribute(PAttributeNames.CURRENT_TIME, currentTime);
       log.info("currentTime" + currentTime);
    }
    public void setDefaultPlaybackRate(final Double defaultPlaybackRate)  {
       setAttribute(PAttributeNames.DEFAULT_PLAYBACK_RATE, defaultPlaybackRate);
       log.info("defaultPlaybackRate" + defaultPlaybackRate);
    }
    public void setPlaybackRate(final Double playbackRate)  {
       setAttribute(PAttributeNames.PLAYBACK_RATE, playbackRate);
       log.info("playbackRate" + playbackRate);
    }
    public void setAutoplay(final Boolean autoplay)  {
       setAttribute(PAttributeNames.AUTOPLAY, autoplay);
       log.info("autoplay" + autoplay);
    }
    public void setLoop(final Boolean loop)  {
       setAttribute(PAttributeNames.LOOP_BOOLEAN, loop);
       log.info("loop" + loop);
    }
    public void setControls(final Boolean controls)  {
       setAttribute(PAttributeNames.CONTROLS_BOOLEAN, controls);
       log.info("controls" + controls);
    }
    public void setVolume(final Double volume)  {
       setAttribute(PAttributeNames.VOLUME, volume);
       log.info("volume" + volume);
    }
    public void setMuted(final Boolean muted)  {
       setAttribute(PAttributeNames.MUTED, muted);
       log.info("muted" + muted);
    }
    public void setDefaultMuted(final Boolean defaultMuted)  {
       setAttribute(PAttributeNames.DEFAULT_MUTED, defaultMuted);
       log.info("defaultMuted" + defaultMuted);
    }
    public void setOnencrypted(final PEventHandlerNonNull onencrypted, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONENCRYPTED, new AttributeCallBack(onencrypted, atrsEventName));
       log.info("onencrypted" + onencrypted.getClass().getName());
    }
    public void setOnwaitingforkey(final PEventHandlerNonNull onwaitingforkey, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWAITINGFORKEY, new AttributeCallBack(onwaitingforkey, atrsEventName));
       log.info("onwaitingforkey" + onwaitingforkey.getClass().getName());
    }
    public void setDisableRemotePlayback(final Boolean disableRemotePlayback)  {
       setAttribute(PAttributeNames.DISABLE_REMOTE_PLAYBACK, disableRemotePlayback);
       log.info("disableRemotePlayback" + disableRemotePlayback);
    }
    public void setSrcObject(final PMediaStream srcObject)  {
       setAttribute(PAttributeNames.SRC_OBJECT, srcObject);
       log.info("srcObject" + srcObject);
    }

    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getCrossOrigin(){
      return (String) getAttribute(PAttributeNames.CROSS_ORIGIN);
    }
    public String getPreload(){
      return (String) getAttribute(PAttributeNames.PRELOAD);
    }
    public Double getCurrentTime(){
      return (Double) getAttribute(PAttributeNames.CURRENT_TIME);
    }
    public Double getDefaultPlaybackRate(){
      return (Double) getAttribute(PAttributeNames.DEFAULT_PLAYBACK_RATE);
    }
    public Double getPlaybackRate(){
      return (Double) getAttribute(PAttributeNames.PLAYBACK_RATE);
    }
    public Boolean getAutoplay(){
      return (Boolean) getAttribute(PAttributeNames.AUTOPLAY);
    }
    public Boolean getLoop(){
      return (Boolean) getAttribute(PAttributeNames.LOOP_BOOLEAN);
    }
    public Boolean getControls(){
      return (Boolean) getAttribute(PAttributeNames.CONTROLS_BOOLEAN);
    }
    public Double getVolume(){
      return (Double) getAttribute(PAttributeNames.VOLUME);
    }
    public Boolean getMuted(){
      return (Boolean) getAttribute(PAttributeNames.MUTED);
    }
    public Boolean getDefaultMuted(){
      return (Boolean) getAttribute(PAttributeNames.DEFAULT_MUTED);
    }
    public PEventHandlerNonNull getOnencrypted(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONENCRYPTED);
    }
    public PEventHandlerNonNull getOnwaitingforkey(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWAITINGFORKEY);
    }
    public Boolean getDisableRemotePlayback(){
      return (Boolean) getAttribute(PAttributeNames.DISABLE_REMOTE_PLAYBACK);
    }
    public PMediaStream getSrcObject(){
      return (PMediaStream) getAttribute(PAttributeNames.SRC_OBJECT);
    }


    public PTextTrack addTextTrack(PTextTrackKind kind) {
       return null;
    }


    public PTextTrack addTextTrack(String kind) {
       return null;
    }


    public PTextTrack addTextTrack(PTextTrackKind kind, String label) {
       return null;
    }


    public PTextTrack addTextTrack(String kind, String label) {
       return null;
    }


    public PTextTrack addTextTrack(PTextTrackKind kind, String label, String language) {
       return null;
    }


    public PTextTrack addTextTrack(String kind, String label, String language) {
       return null;
    }


    public PCanPlayTypeResult canPlayTypeAsCanPlayTypeResult(String type) {
       return null;
    }


    public void canPlayType(final Consumer<String> cback,String type){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CAN_PLAY_TYPE_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {type});
       writer.endObject();
    }

    public PMediaStream captureStream() {
       return null;
    }


    public void load(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       LOAD_VOID.getValue());
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

    public PPromise<Void> play() {
       return null;
    }


    public PPromise setMediaKeys(PMediaKeys mediaKeys) {
       return null;
    }


    public PPromise<Void> setSinkId(String sinkId) {
       return null;
    }


    
}