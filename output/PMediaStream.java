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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PMediaStream extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PMediaStream.class);
    public PMediaStream() {
    }


    public PMediaStream(PMediaStream stream){
      super(stream);
    }

    public PMediaStream(PMediaStreamTrack[] tracks){
      super(tracks);
    }


    public void setOnaddtrack(final PEventHandlerNonNull onaddtrack, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONADDTRACK, new AttributeCallBack(onaddtrack, atrsEventName));
       log.info("onaddtrack" + onaddtrack.getClass().getName());
    }
    public void setOnremovetrack(final PEventHandlerNonNull onremovetrack, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREMOVETRACK, new AttributeCallBack(onremovetrack, atrsEventName));
       log.info("onremovetrack" + onremovetrack.getClass().getName());
    }
    public void setOnactive(final PEventHandlerNonNull onactive, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONACTIVE, new AttributeCallBack(onactive, atrsEventName));
       log.info("onactive" + onactive.getClass().getName());
    }
    public void setOninactive(final PEventHandlerNonNull oninactive, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONINACTIVE, new AttributeCallBack(oninactive, atrsEventName));
       log.info("oninactive" + oninactive.getClass().getName());
    }

    public PEventHandlerNonNull getOnaddtrack(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONADDTRACK);
    }
    public PEventHandlerNonNull getOnremovetrack(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREMOVETRACK);
    }
    public PEventHandlerNonNull getOnactive(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONACTIVE);
    }
    public PEventHandlerNonNull getOninactive(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONINACTIVE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.MEDIA_STREAM;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.MEDIA_STREAM;
    }


    public void addTrack(PMediaStreamTrack track){
    }

    public PMediaStream clone() {
       return null;
    }


    public PMediaStreamTrack[] getAudioTracks() {
       return null;
    }


    public PMediaStreamTrack getTrackById(String trackId) {
       return null;
    }


    public PMediaStreamTrack[] getTracks() {
       return null;
    }


    public PMediaStreamTrack[] getVideoTracks() {
       return null;
    }


    public void removeTrack(PMediaStreamTrack track){
    }

    
}