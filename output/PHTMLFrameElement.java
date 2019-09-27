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
public class PHTMLFrameElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLFrameElement.class);
    public PHTMLFrameElement() {
    }

    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setScrolling(final String scrolling)  {
       setAttribute(PAttributeNames.SCROLLING, scrolling);
       log.info("scrolling" + scrolling);
    }
    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setFrameBorder(final String frameBorder)  {
       setAttribute(PAttributeNames.FRAME_BORDER, frameBorder);
       log.info("frameBorder" + frameBorder);
    }
    public void setLongDesc(final String longDesc)  {
       setAttribute(PAttributeNames.LONG_DESC, longDesc);
       log.info("longDesc" + longDesc);
    }
    public void setNoResize(final Boolean noResize)  {
       setAttribute(PAttributeNames.NO_RESIZE, noResize);
       log.info("noResize" + noResize);
    }
    public void setMarginHeight(final String marginHeight)  {
       setAttribute(PAttributeNames.MARGIN_HEIGHT, marginHeight);
       log.info("marginHeight" + marginHeight);
    }
    public void setMarginWidth(final String marginWidth)  {
       setAttribute(PAttributeNames.MARGIN_WIDTH, marginWidth);
       log.info("marginWidth" + marginWidth);
    }

    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getScrolling(){
      return (String) getAttribute(PAttributeNames.SCROLLING);
    }
    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getFrameBorder(){
      return (String) getAttribute(PAttributeNames.FRAME_BORDER);
    }
    public String getLongDesc(){
      return (String) getAttribute(PAttributeNames.LONG_DESC);
    }
    public Boolean getNoResize(){
      return (Boolean) getAttribute(PAttributeNames.NO_RESIZE);
    }
    public String getMarginHeight(){
      return (String) getAttribute(PAttributeNames.MARGIN_HEIGHT);
    }
    public String getMarginWidth(){
      return (String) getAttribute(PAttributeNames.MARGIN_WIDTH);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_FRAME_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}