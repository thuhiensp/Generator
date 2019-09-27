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
public class PHTMLTextAreaElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLTextAreaElement.class);
    public PHTMLTextAreaElement() {
    }

    public void setAutofocus(final Boolean autofocus)  {
       setAttribute(PAttributeNames.AUTOFOCUS, autofocus);
       log.info("autofocus" + autofocus);
    }
    public void setCols(final Double cols)  {
       setAttribute(PAttributeNames.COLS_DOUBLE, cols);
       log.info("cols" + cols);
    }
    public void setDirName(final String dirName)  {
       setAttribute(PAttributeNames.DIR_NAME, dirName);
       log.info("dirName" + dirName);
    }
    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }
    public void setMaxLength(final Double maxLength)  {
       setAttribute(PAttributeNames.MAX_LENGTH, maxLength);
       log.info("maxLength" + maxLength);
    }
    public void setMinLength(final Double minLength)  {
       setAttribute(PAttributeNames.MIN_LENGTH, minLength);
       log.info("minLength" + minLength);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setPlaceholder(final String placeholder)  {
       setAttribute(PAttributeNames.PLACEHOLDER, placeholder);
       log.info("placeholder" + placeholder);
    }
    public void setReadOnly(final Boolean readOnly)  {
       setAttribute(PAttributeNames.READ_ONLY, readOnly);
       log.info("readOnly" + readOnly);
    }
    public void setRequired(final Boolean required)  {
       setAttribute(PAttributeNames.REQUIRED, required);
       log.info("required" + required);
    }
    public void setRows(final Double rows)  {
       setAttribute(PAttributeNames.ROWS_DOUBLE, rows);
       log.info("rows" + rows);
    }
    public void setWrap(final String wrap)  {
       setAttribute(PAttributeNames.WRAP, wrap);
       log.info("wrap" + wrap);
    }
    public void setDefaultValue(final String defaultValue)  {
       setAttribute(PAttributeNames.DEFAULT_VALUE, defaultValue);
       log.info("defaultValue" + defaultValue);
    }
    public void setValue(final String value)  {
       setAttribute(PAttributeNames.VALUE_STRING, value);
       log.info("value" + value);
    }
    public void setSelectionStart(final Double selectionStart)  {
       setAttribute(PAttributeNames.SELECTION_START, selectionStart);
       log.info("selectionStart" + selectionStart);
    }
    public void setSelectionEnd(final Double selectionEnd)  {
       setAttribute(PAttributeNames.SELECTION_END, selectionEnd);
       log.info("selectionEnd" + selectionEnd);
    }
    public void setSelectionDirection(final String selectionDirection)  {
       setAttribute(PAttributeNames.SELECTION_DIRECTION, selectionDirection);
       log.info("selectionDirection" + selectionDirection);
    }
    public void setAutocapitalize(final String autocapitalize)  {
       setAttribute(PAttributeNames.AUTOCAPITALIZE, autocapitalize);
       log.info("autocapitalize" + autocapitalize);
    }

    public Boolean getAutofocus(){
      return (Boolean) getAttribute(PAttributeNames.AUTOFOCUS);
    }
    public Double getCols(){
      return (Double) getAttribute(PAttributeNames.COLS_DOUBLE);
    }
    public String getDirName(){
      return (String) getAttribute(PAttributeNames.DIR_NAME);
    }
    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }
    public Double getMaxLength(){
      return (Double) getAttribute(PAttributeNames.MAX_LENGTH);
    }
    public Double getMinLength(){
      return (Double) getAttribute(PAttributeNames.MIN_LENGTH);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getPlaceholder(){
      return (String) getAttribute(PAttributeNames.PLACEHOLDER);
    }
    public Boolean getReadOnly(){
      return (Boolean) getAttribute(PAttributeNames.READ_ONLY);
    }
    public Boolean getRequired(){
      return (Boolean) getAttribute(PAttributeNames.REQUIRED);
    }
    public Double getRows(){
      return (Double) getAttribute(PAttributeNames.ROWS_DOUBLE);
    }
    public String getWrap(){
      return (String) getAttribute(PAttributeNames.WRAP);
    }
    public String getDefaultValue(){
      return (String) getAttribute(PAttributeNames.DEFAULT_VALUE);
    }
    public String getValue(){
      return (String) getAttribute(PAttributeNames.VALUE_STRING);
    }
    public Double getSelectionStart(){
      return (Double) getAttribute(PAttributeNames.SELECTION_START);
    }
    public Double getSelectionEnd(){
      return (Double) getAttribute(PAttributeNames.SELECTION_END);
    }
    public String getSelectionDirection(){
      return (String) getAttribute(PAttributeNames.SELECTION_DIRECTION);
    }
    public String getAutocapitalize(){
      return (String) getAttribute(PAttributeNames.AUTOCAPITALIZE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_TEXT_AREA_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void checkValidity(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CHECK_VALIDITY_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void reportValidity(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.REPORT_VALIDITY_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void select(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SELECT_VOID.getValue());
       writer.endObject();
    }

    public void setCustomValidity(String error){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_CUSTOM_VALIDITY_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {error});
       writer.endObject();
    }

    public void setRangeText(String replacement){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_RANGE_TEXT_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {replacement});
       writer.endObject();
    }

    public void setRangeText(String replacement, Double start, Double end){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_RANGE_TEXT_TYPESTRING_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {replacement,start,end});
       writer.endObject();
    }

    public void setRangeText(String replacement, Double start, Double end, PSelectionMode selectionMode){
    }

    public void setRangeText(String replacement, Double start, Double end, String selectionMode){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_RANGE_TEXT_TYPESTRING_TYPEDOUBLE_TYPEDOUBLE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {replacement,start,end,selectionMode});
       writer.endObject();
    }

    public void setSelectionRange(Double start, Double end){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_SELECTION_RANGE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {start,end});
       writer.endObject();
    }

    public void setSelectionRange(Double start, Double end, String direction){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_SELECTION_RANGE_TYPEDOUBLE_TYPEDOUBLE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {start,end,direction});
       writer.endObject();
    }

    
}