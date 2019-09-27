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
public class PHTMLOListElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLOListElement.class);
    public PHTMLOListElement() {
    }

    public void setReversed(final Boolean reversed)  {
       setAttribute(PAttributeNames.REVERSED, reversed);
       log.info("reversed" + reversed);
    }
    public void setStart(final Double start)  {
       setAttribute(PAttributeNames.START, start);
       log.info("start" + start);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setCompact(final Boolean compact)  {
       setAttribute(PAttributeNames.COMPACT, compact);
       log.info("compact" + compact);
    }

    public Boolean getReversed(){
      return (Boolean) getAttribute(PAttributeNames.REVERSED);
    }
    public Double getStart(){
      return (Double) getAttribute(PAttributeNames.START);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public Boolean getCompact(){
      return (Boolean) getAttribute(PAttributeNames.COMPACT);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTMLO_LIST_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}