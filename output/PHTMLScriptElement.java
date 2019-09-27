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
public class PHTMLScriptElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLScriptElement.class);
    public PHTMLScriptElement() {
    }

    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setNoModule(final Boolean noModule)  {
       setAttribute(PAttributeNames.NO_MODULE, noModule);
       log.info("noModule" + noModule);
    }
    public void setCharset(final String charset)  {
       setAttribute(PAttributeNames.CHARSET, charset);
       log.info("charset" + charset);
    }
    public void setAsync(final Boolean async)  {
       setAttribute(PAttributeNames.ASYNC, async);
       log.info("async" + async);
    }
    public void setDefer(final Boolean defer)  {
       setAttribute(PAttributeNames.DEFER, defer);
       log.info("defer" + defer);
    }
    public void setCrossOrigin(final String crossOrigin)  {
       setAttribute(PAttributeNames.CROSS_ORIGIN, crossOrigin);
       log.info("crossOrigin" + crossOrigin);
    }
    public void setText(final String text)  {
       setAttribute(PAttributeNames.TEXT, text);
       log.info("text" + text);
    }
    public void setEvent(final String event)  {
       setAttribute(PAttributeNames.EVENT_STRING, event);
       log.info("event" + event);
    }
    public void setHtmlFor(final String htmlFor)  {
       setAttribute(PAttributeNames.HTML_FOR, htmlFor);
       log.info("htmlFor" + htmlFor);
    }
    public void setIntegrity(final String integrity)  {
       setAttribute(PAttributeNames.INTEGRITY, integrity);
       log.info("integrity" + integrity);
    }

    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public Boolean getNoModule(){
      return (Boolean) getAttribute(PAttributeNames.NO_MODULE);
    }
    public String getCharset(){
      return (String) getAttribute(PAttributeNames.CHARSET);
    }
    public Boolean getAsync(){
      return (Boolean) getAttribute(PAttributeNames.ASYNC);
    }
    public Boolean getDefer(){
      return (Boolean) getAttribute(PAttributeNames.DEFER);
    }
    public String getCrossOrigin(){
      return (String) getAttribute(PAttributeNames.CROSS_ORIGIN);
    }
    public String getText(){
      return (String) getAttribute(PAttributeNames.TEXT);
    }
    public String getEvent(){
      return (String) getAttribute(PAttributeNames.EVENT_STRING);
    }
    public String getHtmlFor(){
      return (String) getAttribute(PAttributeNames.HTML_FOR);
    }
    public String getIntegrity(){
      return (String) getAttribute(PAttributeNames.INTEGRITY);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_SCRIPT_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}