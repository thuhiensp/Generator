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
public class PHTMLHRElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLHRElement.class);
    public PHTMLHRElement() {
    }

    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setColor(final String color)  {
       setAttribute(PAttributeNames.COLOR, color);
       log.info("color" + color);
    }
    public void setNoShade(final Boolean noShade)  {
       setAttribute(PAttributeNames.NO_SHADE, noShade);
       log.info("noShade" + noShade);
    }
    public void setSize(final String size)  {
       setAttribute(PAttributeNames.SIZE_STRING, size);
       log.info("size" + size);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }

    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getColor(){
      return (String) getAttribute(PAttributeNames.COLOR);
    }
    public Boolean getNoShade(){
      return (Boolean) getAttribute(PAttributeNames.NO_SHADE);
    }
    public String getSize(){
      return (String) getAttribute(PAttributeNames.SIZE_STRING);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTMLHR_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}