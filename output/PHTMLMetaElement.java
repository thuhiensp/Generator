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
public class PHTMLMetaElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLMetaElement.class);
    public PHTMLMetaElement() {
    }

    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setHttpEquiv(final String httpEquiv)  {
       setAttribute(PAttributeNames.HTTP_EQUIV, httpEquiv);
       log.info("httpEquiv" + httpEquiv);
    }
    public void setContent(final String content)  {
       setAttribute(PAttributeNames.CONTENT, content);
       log.info("content" + content);
    }
    public void setScheme(final String scheme)  {
       setAttribute(PAttributeNames.SCHEME, scheme);
       log.info("scheme" + scheme);
    }

    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getHttpEquiv(){
      return (String) getAttribute(PAttributeNames.HTTP_EQUIV);
    }
    public String getContent(){
      return (String) getAttribute(PAttributeNames.CONTENT);
    }
    public String getScheme(){
      return (String) getAttribute(PAttributeNames.SCHEME);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_META_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}