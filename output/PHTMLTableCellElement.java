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
public abstract class PHTMLTableCellElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLTableCellElement.class);
    public void setColSpan(final Double colSpan)  {
       setAttribute(PAttributeNames.COL_SPAN, colSpan);
       log.info("colSpan" + colSpan);
    }
    public void setRowSpan(final Double rowSpan)  {
       setAttribute(PAttributeNames.ROW_SPAN, rowSpan);
       log.info("rowSpan" + rowSpan);
    }
    public void setHeaders(final String headers)  {
       setAttribute(PAttributeNames.HEADERS, headers);
       log.info("headers" + headers);
    }
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setAxis(final String axis)  {
       setAttribute(PAttributeNames.AXIS, axis);
       log.info("axis" + axis);
    }
    public void setHeight(final String height)  {
       setAttribute(PAttributeNames.HEIGHT_STRING, height);
       log.info("height" + height);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }
    public void setCh(final String ch)  {
       setAttribute(PAttributeNames.CH, ch);
       log.info("ch" + ch);
    }
    public void setChOff(final String chOff)  {
       setAttribute(PAttributeNames.CH_OFF, chOff);
       log.info("chOff" + chOff);
    }
    public void setNoWrap(final Boolean noWrap)  {
       setAttribute(PAttributeNames.NO_WRAP, noWrap);
       log.info("noWrap" + noWrap);
    }
    public void setVAlign(final String vAlign)  {
       setAttribute(PAttributeNames.V_ALIGN, vAlign);
       log.info("vAlign" + vAlign);
    }
    public void setBgColor(final String bgColor)  {
       setAttribute(PAttributeNames.BG_COLOR, bgColor);
       log.info("bgColor" + bgColor);
    }
    public void setAbbr(final String abbr)  {
       setAttribute(PAttributeNames.ABBR, abbr);
       log.info("abbr" + abbr);
    }
    public void setScope(final String scope)  {
       setAttribute(PAttributeNames.SCOPE, scope);
       log.info("scope" + scope);
    }

    public Double getColSpan(){
      return (Double) getAttribute(PAttributeNames.COL_SPAN);
    }
    public Double getRowSpan(){
      return (Double) getAttribute(PAttributeNames.ROW_SPAN);
    }
    public String getHeaders(){
      return (String) getAttribute(PAttributeNames.HEADERS);
    }
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getAxis(){
      return (String) getAttribute(PAttributeNames.AXIS);
    }
    public String getHeight(){
      return (String) getAttribute(PAttributeNames.HEIGHT_STRING);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }
    public String getCh(){
      return (String) getAttribute(PAttributeNames.CH);
    }
    public String getChOff(){
      return (String) getAttribute(PAttributeNames.CH_OFF);
    }
    public Boolean getNoWrap(){
      return (Boolean) getAttribute(PAttributeNames.NO_WRAP);
    }
    public String getVAlign(){
      return (String) getAttribute(PAttributeNames.V_ALIGN);
    }
    public String getBgColor(){
      return (String) getAttribute(PAttributeNames.BG_COLOR);
    }
    public String getAbbr(){
      return (String) getAttribute(PAttributeNames.ABBR);
    }
    public String getScope(){
      return (String) getAttribute(PAttributeNames.SCOPE);
    }


    
}