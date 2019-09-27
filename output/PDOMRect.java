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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PDOMRect extends PDOMRectReadOnly {
    private static final Logger log = LoggerFactory.getLogger(PDOMRect.class);
    public PDOMRect() {
    }


    public PDOMRect(Double x){
      super(x);
    }

    public PDOMRect(Double x, Double y){
      super(x, y);
    }

    public PDOMRect(Double x, Double y, Double width){
      super(x, y, width);
    }

    public PDOMRect(Double x, Double y, Double width, Double height){
      super(x, y, width, height);
    }


    public void setX(final Double x)  {
       setAttribute(PAttributeNames.X_DOUBLE, x);
       log.info("x" + x);
    }
    public void setY(final Double y)  {
       setAttribute(PAttributeNames.Y_DOUBLE, y);
       log.info("y" + y);
    }
    public void setWidth(final Double width)  {
       setAttribute(PAttributeNames.WIDTH_DOUBLE, width);
       log.info("width" + width);
    }
    public void setHeight(final Double height)  {
       setAttribute(PAttributeNames.HEIGHT_DOUBLE, height);
       log.info("height" + height);
    }

    public Double getX(){
      return (Double) getAttribute(PAttributeNames.X_DOUBLE);
    }
    public Double getY(){
      return (Double) getAttribute(PAttributeNames.Y_DOUBLE);
    }
    public Double getWidth(){
      return (Double) getAttribute(PAttributeNames.WIDTH_DOUBLE);
    }
    public Double getHeight(){
      return (Double) getAttribute(PAttributeNames.HEIGHT_DOUBLE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.DOM_RECT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.DOM_RECT;
    }


    public PDOMRect fromRect() {
       return null;
    }


    public PDOMRect fromRect(PDOMRectInit other) {
       return null;
    }


    
}