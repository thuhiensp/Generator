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
public class PHTMLTrackElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLTrackElement.class);
    public PHTMLTrackElement() {
    }

    public void setKind(final String kind)  {
       setAttribute(PAttributeNames.KIND, kind);
       log.info("kind" + kind);
    }
    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setSrclang(final String srclang)  {
       setAttribute(PAttributeNames.SRCLANG, srclang);
       log.info("srclang" + srclang);
    }
    public void setLabel(final String label)  {
       setAttribute(PAttributeNames.LABEL, label);
       log.info("label" + label);
    }
    public void setDefault(final Boolean defaultAttribute)  {
       setAttribute(PAttributeNames.DEFAULT, defaultAttribute);
       log.info("defaultAttribute" + defaultAttribute);
    }

    public String getKind(){
      return (String) getAttribute(PAttributeNames.KIND);
    }
    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getSrclang(){
      return (String) getAttribute(PAttributeNames.SRCLANG);
    }
    public String getLabel(){
      return (String) getAttribute(PAttributeNames.LABEL);
    }
    public Boolean getDefaultAttribute(){
      return (Boolean) getAttribute(PAttributeNames.DEFAULT);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_TRACK_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}