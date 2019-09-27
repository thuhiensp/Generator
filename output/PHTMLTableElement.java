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
public class PHTMLTableElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLTableElement.class);
    public PHTMLTableElement() {
    }

    public void setCaption(final PHTMLTableCaptionElement caption)  {
       setAttribute(PAttributeNames.CAPTION, caption);
       log.info("caption" + caption);
    }
    public void setTHead(final PHTMLTableSectionElement tHead)  {
       setAttribute(PAttributeNames.T_HEAD, tHead);
       log.info("tHead" + tHead);
    }
    public void setTFoot(final PHTMLTableSectionElement tFoot)  {
       setAttribute(PAttributeNames.T_FOOT, tFoot);
       log.info("tFoot" + tFoot);
    }
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setBorder(final String border)  {
       setAttribute(PAttributeNames.BORDER, border);
       log.info("border" + border);
    }
    public void setFrame(final String frame)  {
       setAttribute(PAttributeNames.FRAME, frame);
       log.info("frame" + frame);
    }
    public void setRules(final String rules)  {
       setAttribute(PAttributeNames.RULES, rules);
       log.info("rules" + rules);
    }
    public void setSummary(final String summary)  {
       setAttribute(PAttributeNames.SUMMARY, summary);
       log.info("summary" + summary);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }
    public void setBgColor(final String bgColor)  {
       setAttribute(PAttributeNames.BG_COLOR, bgColor);
       log.info("bgColor" + bgColor);
    }
    public void setCellPadding(final String cellPadding)  {
       setAttribute(PAttributeNames.CELL_PADDING, cellPadding);
       log.info("cellPadding" + cellPadding);
    }
    public void setCellSpacing(final String cellSpacing)  {
       setAttribute(PAttributeNames.CELL_SPACING, cellSpacing);
       log.info("cellSpacing" + cellSpacing);
    }

    public PHTMLTableCaptionElement getCaption(){
      return (PHTMLTableCaptionElement) getAttribute(PAttributeNames.CAPTION);
    }
    public PHTMLTableSectionElement getTHead(){
      return (PHTMLTableSectionElement) getAttribute(PAttributeNames.T_HEAD);
    }
    public PHTMLTableSectionElement getTFoot(){
      return (PHTMLTableSectionElement) getAttribute(PAttributeNames.T_FOOT);
    }
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getBorder(){
      return (String) getAttribute(PAttributeNames.BORDER);
    }
    public String getFrame(){
      return (String) getAttribute(PAttributeNames.FRAME);
    }
    public String getRules(){
      return (String) getAttribute(PAttributeNames.RULES);
    }
    public String getSummary(){
      return (String) getAttribute(PAttributeNames.SUMMARY);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }
    public String getBgColor(){
      return (String) getAttribute(PAttributeNames.BG_COLOR);
    }
    public String getCellPadding(){
      return (String) getAttribute(PAttributeNames.CELL_PADDING);
    }
    public String getCellSpacing(){
      return (String) getAttribute(PAttributeNames.CELL_SPACING);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_TABLE_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PHTMLTableCaptionElement createCaption() {
       return null;
    }


    public PHTMLTableSectionElement createTBody() {
       return null;
    }


    public PHTMLTableSectionElement createTFoot() {
       return null;
    }


    public PHTMLTableSectionElement createTHead() {
       return null;
    }


    public void deleteCaption(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETE_CAPTION_VOID.getValue());
       writer.endObject();
    }

    public void deleteRow(Double index){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETE_ROW_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index});
       writer.endObject();
    }

    public void deleteTFoot(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETET_FOOT_VOID.getValue());
       writer.endObject();
    }

    public void deleteTHead(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETET_HEAD_VOID.getValue());
       writer.endObject();
    }

    public PHTMLTableRowElement insertRow() {
       return null;
    }


    public PHTMLTableRowElement insertRow(Double index) {
       return null;
    }


    
}