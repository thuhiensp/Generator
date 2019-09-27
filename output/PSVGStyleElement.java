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
public class PSVGStyleElement extends PSVGElement {
    private static final Logger log = LoggerFactory.getLogger(PSVGStyleElement.class);
    public PSVGStyleElement() {
    }

    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setMedia(final String media)  {
       setAttribute(PAttributeNames.MEDIA, media);
       log.info("media" + media);
    }
    public void setTitle(final String title)  {
       setAttribute(PAttributeNames.TITLE, title);
       log.info("title" + title);
    }
    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }

    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getMedia(){
      return (String) getAttribute(PAttributeNames.MEDIA);
    }
    public String getTitle(){
      return (String) getAttribute(PAttributeNames.TITLE);
    }
    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.SVG_STYLE_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}