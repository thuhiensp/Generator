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
public class PHTMLEmbedElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLEmbedElement.class);
    public PHTMLEmbedElement() {
    }

    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }
    public void setHeight(final String height)  {
       setAttribute(PAttributeNames.HEIGHT_STRING, height);
       log.info("height" + height);
    }
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }

    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }
    public String getHeight(){
      return (String) getAttribute(PAttributeNames.HEIGHT_STRING);
    }
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_EMBED_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PNode get(String name) {
       return null;
    }


    public PDocument getSVGDocument() {
       return null;
    }


    public PNode set(String name, PNode value) {
       return null;
    }


    
}