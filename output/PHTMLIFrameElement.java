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
public class PHTMLIFrameElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLIFrameElement.class);
    public PHTMLIFrameElement() {
    }

    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setSrcdoc(final String srcdoc)  {
       setAttribute(PAttributeNames.SRCDOC, srcdoc);
       log.info("srcdoc" + srcdoc);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setAllowFullscreen(final Boolean allowFullscreen)  {
       setAttribute(PAttributeNames.ALLOW_FULLSCREEN, allowFullscreen);
       log.info("allowFullscreen" + allowFullscreen);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }
    public void setHeight(final String height)  {
       setAttribute(PAttributeNames.HEIGHT_STRING, height);
       log.info("height" + height);
    }
    public void setReferrerPolicy(final String referrerPolicy)  {
       setAttribute(PAttributeNames.REFERRER_POLICY, referrerPolicy);
       log.info("referrerPolicy" + referrerPolicy);
    }
    public void setCsp(final String csp)  {
       setAttribute(PAttributeNames.CSP, csp);
       log.info("csp" + csp);
    }
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setScrolling(final String scrolling)  {
       setAttribute(PAttributeNames.SCROLLING, scrolling);
       log.info("scrolling" + scrolling);
    }
    public void setFrameBorder(final String frameBorder)  {
       setAttribute(PAttributeNames.FRAME_BORDER, frameBorder);
       log.info("frameBorder" + frameBorder);
    }
    public void setLongDesc(final String longDesc)  {
       setAttribute(PAttributeNames.LONG_DESC, longDesc);
       log.info("longDesc" + longDesc);
    }
    public void setMarginHeight(final String marginHeight)  {
       setAttribute(PAttributeNames.MARGIN_HEIGHT, marginHeight);
       log.info("marginHeight" + marginHeight);
    }
    public void setMarginWidth(final String marginWidth)  {
       setAttribute(PAttributeNames.MARGIN_WIDTH, marginWidth);
       log.info("marginWidth" + marginWidth);
    }

    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getSrcdoc(){
      return (String) getAttribute(PAttributeNames.SRCDOC);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public Boolean getAllowFullscreen(){
      return (Boolean) getAttribute(PAttributeNames.ALLOW_FULLSCREEN);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }
    public String getHeight(){
      return (String) getAttribute(PAttributeNames.HEIGHT_STRING);
    }
    public String getReferrerPolicy(){
      return (String) getAttribute(PAttributeNames.REFERRER_POLICY);
    }
    public String getCsp(){
      return (String) getAttribute(PAttributeNames.CSP);
    }
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getScrolling(){
      return (String) getAttribute(PAttributeNames.SCROLLING);
    }
    public String getFrameBorder(){
      return (String) getAttribute(PAttributeNames.FRAME_BORDER);
    }
    public String getLongDesc(){
      return (String) getAttribute(PAttributeNames.LONG_DESC);
    }
    public String getMarginHeight(){
      return (String) getAttribute(PAttributeNames.MARGIN_HEIGHT);
    }
    public String getMarginWidth(){
      return (String) getAttribute(PAttributeNames.MARGIN_WIDTH);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTMLI_FRAME_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PDocument getSVGDocument() {
       return null;
    }


    
}