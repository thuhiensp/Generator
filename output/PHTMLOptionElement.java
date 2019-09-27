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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PHTMLOptionElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLOptionElement.class);
    public PHTMLOptionElement() {
    }


    public PHTMLOptionElement(String data){
      super(data);
    }

    public PHTMLOptionElement(String data, String value){
      super(data, value);
    }

    public PHTMLOptionElement(String data, String value, Boolean defaultSelected){
      super(data, value, defaultSelected);
    }

    public PHTMLOptionElement(String data, String value, Boolean defaultSelected, Boolean selected){
      super(data, value, defaultSelected, selected);
    }


    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }
    public void setLabel(final String label)  {
       setAttribute(PAttributeNames.LABEL, label);
       log.info("label" + label);
    }
    public void setDefaultSelected(final Boolean defaultSelected)  {
       setAttribute(PAttributeNames.DEFAULT_SELECTED, defaultSelected);
       log.info("defaultSelected" + defaultSelected);
    }
    public void setSelected(final Boolean selected)  {
       setAttribute(PAttributeNames.SELECTED, selected);
       log.info("selected" + selected);
    }
    public void setValue(final String value)  {
       setAttribute(PAttributeNames.VALUE_STRING, value);
       log.info("value" + value);
    }
    public void setText(final String text)  {
       setAttribute(PAttributeNames.TEXT, text);
       log.info("text" + text);
    }

    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }
    public String getLabel(){
      return (String) getAttribute(PAttributeNames.LABEL);
    }
    public Boolean getDefaultSelected(){
      return (Boolean) getAttribute(PAttributeNames.DEFAULT_SELECTED);
    }
    public Boolean getSelected(){
      return (Boolean) getAttribute(PAttributeNames.SELECTED);
    }
    public String getValue(){
      return (String) getAttribute(PAttributeNames.VALUE_STRING);
    }
    public String getText(){
      return (String) getAttribute(PAttributeNames.TEXT);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_OPTION_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.HTML_OPTION_ELEMENT;
    }


    
}