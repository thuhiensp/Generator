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
public class PHTMLDocument extends PDocument {
    private static final Logger log = LoggerFactory.getLogger(PHTMLDocument.class);
    public PHTMLDocument(final PWindow2 window) {
       this.pWindow = window;
    }

    public void setFgColor(final String fgColor)  {
       setAttribute(PAttributeNames.FG_COLOR, fgColor);
       log.info("fgColor" + fgColor);
    }
    public void setLinkColor(final String linkColor)  {
       setAttribute(PAttributeNames.LINK_COLOR, linkColor);
       log.info("linkColor" + linkColor);
    }
    public void setVlinkColor(final String vlinkColor)  {
       setAttribute(PAttributeNames.VLINK_COLOR, vlinkColor);
       log.info("vlinkColor" + vlinkColor);
    }
    public void setAlinkColor(final String alinkColor)  {
       setAttribute(PAttributeNames.ALINK_COLOR, alinkColor);
       log.info("alinkColor" + alinkColor);
    }
    public void setBgColor(final String bgColor)  {
       setAttribute(PAttributeNames.BG_COLOR, bgColor);
       log.info("bgColor" + bgColor);
    }

    public String getFgColor(){
      return (String) getAttribute(PAttributeNames.FG_COLOR);
    }
    public String getLinkColor(){
      return (String) getAttribute(PAttributeNames.LINK_COLOR);
    }
    public String getVlinkColor(){
      return (String) getAttribute(PAttributeNames.VLINK_COLOR);
    }
    public String getAlinkColor(){
      return (String) getAttribute(PAttributeNames.ALINK_COLOR);
    }
    public String getBgColor(){
      return (String) getAttribute(PAttributeNames.BG_COLOR);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_DOCUMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void captureEvents(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CAPTURE_EVENTS_VOID.getValue());
       writer.endObject();
    }

    public void clear(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_VOID.getValue());
       writer.endObject();
    }

    public void releaseEvents(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RELEASE_EVENTS_VOID.getValue());
       writer.endObject();
    }

    
}