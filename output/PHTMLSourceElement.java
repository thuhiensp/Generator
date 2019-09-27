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
public class PHTMLSourceElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLSourceElement.class);
    public PHTMLSourceElement() {
    }

    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setSrcset(final String srcset)  {
       setAttribute(PAttributeNames.SRCSET, srcset);
       log.info("srcset" + srcset);
    }
    public void setSizes(final String sizes)  {
       setAttribute(PAttributeNames.SIZES, sizes);
       log.info("sizes" + sizes);
    }
    public void setMedia(final String media)  {
       setAttribute(PAttributeNames.MEDIA, media);
       log.info("media" + media);
    }

    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getSrcset(){
      return (String) getAttribute(PAttributeNames.SRCSET);
    }
    public String getSizes(){
      return (String) getAttribute(PAttributeNames.SIZES);
    }
    public String getMedia(){
      return (String) getAttribute(PAttributeNames.MEDIA);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_SOURCE_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}