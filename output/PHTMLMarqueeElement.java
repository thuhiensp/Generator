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
public class PHTMLMarqueeElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLMarqueeElement.class);
    public PHTMLMarqueeElement() {
    }

    public void setBehavior(final String behavior)  {
       setAttribute(PAttributeNames.BEHAVIOR, behavior);
       log.info("behavior" + behavior);
    }
    public void setBgColor(final String bgColor)  {
       setAttribute(PAttributeNames.BG_COLOR, bgColor);
       log.info("bgColor" + bgColor);
    }
    public void setDirection(final String direction)  {
       setAttribute(PAttributeNames.DIRECTION_STRING, direction);
       log.info("direction" + direction);
    }
    public void setHeight(final String height)  {
       setAttribute(PAttributeNames.HEIGHT_STRING, height);
       log.info("height" + height);
    }
    public void setHspace(final Double hspace)  {
       setAttribute(PAttributeNames.HSPACE, hspace);
       log.info("hspace" + hspace);
    }
    public void setLoop(final Double loop)  {
       setAttribute(PAttributeNames.LOOP_DOUBLE, loop);
       log.info("loop" + loop);
    }
    public void setScrollAmount(final Double scrollAmount)  {
       setAttribute(PAttributeNames.SCROLL_AMOUNT, scrollAmount);
       log.info("scrollAmount" + scrollAmount);
    }
    public void setScrollDelay(final Double scrollDelay)  {
       setAttribute(PAttributeNames.SCROLL_DELAY, scrollDelay);
       log.info("scrollDelay" + scrollDelay);
    }
    public void setTrueSpeed(final Boolean trueSpeed)  {
       setAttribute(PAttributeNames.TRUE_SPEED, trueSpeed);
       log.info("trueSpeed" + trueSpeed);
    }
    public void setVspace(final Double vspace)  {
       setAttribute(PAttributeNames.VSPACE, vspace);
       log.info("vspace" + vspace);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }

    public String getBehavior(){
      return (String) getAttribute(PAttributeNames.BEHAVIOR);
    }
    public String getBgColor(){
      return (String) getAttribute(PAttributeNames.BG_COLOR);
    }
    public String getDirection(){
      return (String) getAttribute(PAttributeNames.DIRECTION_STRING);
    }
    public String getHeight(){
      return (String) getAttribute(PAttributeNames.HEIGHT_STRING);
    }
    public Double getHspace(){
      return (Double) getAttribute(PAttributeNames.HSPACE);
    }
    public Double getLoop(){
      return (Double) getAttribute(PAttributeNames.LOOP_DOUBLE);
    }
    public Double getScrollAmount(){
      return (Double) getAttribute(PAttributeNames.SCROLL_AMOUNT);
    }
    public Double getScrollDelay(){
      return (Double) getAttribute(PAttributeNames.SCROLL_DELAY);
    }
    public Boolean getTrueSpeed(){
      return (Boolean) getAttribute(PAttributeNames.TRUE_SPEED);
    }
    public Double getVspace(){
      return (Double) getAttribute(PAttributeNames.VSPACE);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_MARQUEE_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void start(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_VOID.getValue());
       writer.endObject();
    }

    public void stop(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STOP_VOID.getValue());
       writer.endObject();
    }

    
}