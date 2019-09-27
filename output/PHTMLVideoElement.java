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
public class PHTMLVideoElement extends PHTMLMediaElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLVideoElement.class);
    public PHTMLVideoElement() {
    }

    public void setWidth(final Double width)  {
       setAttribute(PAttributeNames.WIDTH_DOUBLE, width);
       log.info("width" + width);
    }
    public void setHeight(final Double height)  {
       setAttribute(PAttributeNames.HEIGHT_DOUBLE, height);
       log.info("height" + height);
    }
    public void setPoster(final String poster)  {
       setAttribute(PAttributeNames.POSTER, poster);
       log.info("poster" + poster);
    }

    public Double getWidth(){
      return (Double) getAttribute(PAttributeNames.WIDTH_DOUBLE);
    }
    public Double getHeight(){
      return (Double) getAttribute(PAttributeNames.HEIGHT_DOUBLE);
    }
    public String getPoster(){
      return (String) getAttribute(PAttributeNames.POSTER);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_VIDEO_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PVideoPlaybackQuality getVideoPlaybackQuality() {
       return null;
    }


    public void webkitEnterFullScreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_ENTER_FULL_SCREEN_VOID.getValue());
       writer.endObject();
    }

    public void webkitEnterFullscreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_ENTER_FULLSCREEN_VOID.getValue());
       writer.endObject();
    }

    public void webkitExitFullScreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_EXIT_FULL_SCREEN_VOID.getValue());
       writer.endObject();
    }

    public void webkitExitFullscreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_EXIT_FULLSCREEN_VOID.getValue());
       writer.endObject();
    }

    
}