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
public class PHTMLInputElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLInputElement.class);
    public PHTMLInputElement() {
    }

    public void setAccept(final String accept)  {
       setAttribute(PAttributeNames.ACCEPT, accept);
       log.info("accept" + accept);
    }
    public void setAlt(final String alt)  {
       setAttribute(PAttributeNames.ALT, alt);
       log.info("alt" + alt);
    }
    public void setAutocomplete(final String autocomplete)  {
       setAttribute(PAttributeNames.AUTOCOMPLETE, autocomplete);
       log.info("autocomplete" + autocomplete);
    }
    public void setAutofocus(final Boolean autofocus)  {
       setAttribute(PAttributeNames.AUTOFOCUS, autofocus);
       log.info("autofocus" + autofocus);
    }
    public void setDefaultChecked(final Boolean defaultChecked)  {
       setAttribute(PAttributeNames.DEFAULT_CHECKED, defaultChecked);
       log.info("defaultChecked" + defaultChecked);
    }
    public void setChecked(final Boolean checked)  {
       setAttribute(PAttributeNames.CHECKED_BOOLEAN, checked);
       log.info("checked" + checked);
    }
    public void setDirName(final String dirName)  {
       setAttribute(PAttributeNames.DIR_NAME, dirName);
       log.info("dirName" + dirName);
    }
    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }
    public void setFiles(final PFileList files)  {
       setAttribute(PAttributeNames.FILES, files);
       log.info("files" + files);
    }
    public void setFormAction(final String formAction)  {
       setAttribute(PAttributeNames.FORM_ACTION, formAction);
       log.info("formAction" + formAction);
    }
    public void setFormEnctype(final String formEnctype)  {
       setAttribute(PAttributeNames.FORM_ENCTYPE, formEnctype);
       log.info("formEnctype" + formEnctype);
    }
    public void setFormMethod(final String formMethod)  {
       setAttribute(PAttributeNames.FORM_METHOD, formMethod);
       log.info("formMethod" + formMethod);
    }
    public void setFormNoValidate(final Boolean formNoValidate)  {
       setAttribute(PAttributeNames.FORM_NO_VALIDATE, formNoValidate);
       log.info("formNoValidate" + formNoValidate);
    }
    public void setFormTarget(final String formTarget)  {
       setAttribute(PAttributeNames.FORM_TARGET, formTarget);
       log.info("formTarget" + formTarget);
    }
    public void setHeight(final Double height)  {
       setAttribute(PAttributeNames.HEIGHT_DOUBLE, height);
       log.info("height" + height);
    }
    public void setIndeterminate(final Boolean indeterminate)  {
       setAttribute(PAttributeNames.INDETERMINATE, indeterminate);
       log.info("indeterminate" + indeterminate);
    }
    public void setMax(final String max)  {
       setAttribute(PAttributeNames.MAX_STRING, max);
       log.info("max" + max);
    }
    public void setMaxLength(final Double maxLength)  {
       setAttribute(PAttributeNames.MAX_LENGTH, maxLength);
       log.info("maxLength" + maxLength);
    }
    public void setMin(final String min)  {
       setAttribute(PAttributeNames.MIN_STRING, min);
       log.info("min" + min);
    }
    public void setMinLength(final Double minLength)  {
       setAttribute(PAttributeNames.MIN_LENGTH, minLength);
       log.info("minLength" + minLength);
    }
    public void setMultiple(final Boolean multiple)  {
       setAttribute(PAttributeNames.MULTIPLE, multiple);
       log.info("multiple" + multiple);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setPattern(final String pattern)  {
       setAttribute(PAttributeNames.PATTERN, pattern);
       log.info("pattern" + pattern);
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
    public void setSize(final Double size)  {
       setAttribute(PAttributeNames.SIZE_DOUBLE, size);
       log.info("size" + size);
    }
    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setStep(final String step)  {
       setAttribute(PAttributeNames.STEP, step);
       log.info("step" + step);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setDefaultValue(final String defaultValue)  {
       setAttribute(PAttributeNames.DEFAULT_VALUE, defaultValue);
       log.info("defaultValue" + defaultValue);
    }
    public void setValue(final String value)  {
       setAttribute(PAttributeNames.VALUE_STRING, value);
       log.info("value" + value);
    }
    public void setValueAsDate(final PDate valueAsDate)  {
       setAttribute(PAttributeNames.VALUE_AS_DATE, valueAsDate);
       log.info("valueAsDate" + valueAsDate);
    }
    public void setValueAsNumber(final Double valueAsNumber)  {
       setAttribute(PAttributeNames.VALUE_AS_NUMBER, valueAsNumber);
       log.info("valueAsNumber" + valueAsNumber);
    }
    public void setWidth(final Double width)  {
       setAttribute(PAttributeNames.WIDTH_DOUBLE, width);
       log.info("width" + width);
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
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setUseMap(final String useMap)  {
       setAttribute(PAttributeNames.USE_MAP, useMap);
       log.info("useMap" + useMap);
    }
    public void setAutocapitalize(final String autocapitalize)  {
       setAttribute(PAttributeNames.AUTOCAPITALIZE, autocapitalize);
       log.info("autocapitalize" + autocapitalize);
    }
    public void setCapture(final String capture)  {
       setAttribute(PAttributeNames.CAPTURE, capture);
       log.info("capture" + capture);
    }
    public void setWebkitdirectory(final Boolean webkitdirectory)  {
       setAttribute(PAttributeNames.WEBKITDIRECTORY, webkitdirectory);
       log.info("webkitdirectory" + webkitdirectory);
    }
    public void setIncremental(final Boolean incremental)  {
       setAttribute(PAttributeNames.INCREMENTAL, incremental);
       log.info("incremental" + incremental);
    }

    public String getAccept(){
      return (String) getAttribute(PAttributeNames.ACCEPT);
    }
    public String getAlt(){
      return (String) getAttribute(PAttributeNames.ALT);
    }
    public String getAutocomplete(){
      return (String) getAttribute(PAttributeNames.AUTOCOMPLETE);
    }
    public Boolean getAutofocus(){
      return (Boolean) getAttribute(PAttributeNames.AUTOFOCUS);
    }
    public Boolean getDefaultChecked(){
      return (Boolean) getAttribute(PAttributeNames.DEFAULT_CHECKED);
    }
    public Boolean getChecked(){
      return (Boolean) getAttribute(PAttributeNames.CHECKED_BOOLEAN);
    }
    public String getDirName(){
      return (String) getAttribute(PAttributeNames.DIR_NAME);
    }
    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }
    public PFileList getFiles(){
      return (PFileList) getAttribute(PAttributeNames.FILES);
    }
    public String getFormAction(){
      return (String) getAttribute(PAttributeNames.FORM_ACTION);
    }
    public String getFormEnctype(){
      return (String) getAttribute(PAttributeNames.FORM_ENCTYPE);
    }
    public String getFormMethod(){
      return (String) getAttribute(PAttributeNames.FORM_METHOD);
    }
    public Boolean getFormNoValidate(){
      return (Boolean) getAttribute(PAttributeNames.FORM_NO_VALIDATE);
    }
    public String getFormTarget(){
      return (String) getAttribute(PAttributeNames.FORM_TARGET);
    }
    public Double getHeight(){
      return (Double) getAttribute(PAttributeNames.HEIGHT_DOUBLE);
    }
    public Boolean getIndeterminate(){
      return (Boolean) getAttribute(PAttributeNames.INDETERMINATE);
    }
    public String getMax(){
      return (String) getAttribute(PAttributeNames.MAX_STRING);
    }
    public Double getMaxLength(){
      return (Double) getAttribute(PAttributeNames.MAX_LENGTH);
    }
    public String getMin(){
      return (String) getAttribute(PAttributeNames.MIN_STRING);
    }
    public Double getMinLength(){
      return (Double) getAttribute(PAttributeNames.MIN_LENGTH);
    }
    public Boolean getMultiple(){
      return (Boolean) getAttribute(PAttributeNames.MULTIPLE);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getPattern(){
      return (String) getAttribute(PAttributeNames.PATTERN);
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
    public Double getSize(){
      return (Double) getAttribute(PAttributeNames.SIZE_DOUBLE);
    }
    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getStep(){
      return (String) getAttribute(PAttributeNames.STEP);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getDefaultValue(){
      return (String) getAttribute(PAttributeNames.DEFAULT_VALUE);
    }
    public String getValue(){
      return (String) getAttribute(PAttributeNames.VALUE_STRING);
    }
    public PDate getValueAsDate(){
      return (PDate) getAttribute(PAttributeNames.VALUE_AS_DATE);
    }
    public Double getValueAsNumber(){
      return (Double) getAttribute(PAttributeNames.VALUE_AS_NUMBER);
    }
    public Double getWidth(){
      return (Double) getAttribute(PAttributeNames.WIDTH_DOUBLE);
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
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getUseMap(){
      return (String) getAttribute(PAttributeNames.USE_MAP);
    }
    public String getAutocapitalize(){
      return (String) getAttribute(PAttributeNames.AUTOCAPITALIZE);
    }
    public String getCapture(){
      return (String) getAttribute(PAttributeNames.CAPTURE);
    }
    public Boolean getWebkitdirectory(){
      return (Boolean) getAttribute(PAttributeNames.WEBKITDIRECTORY);
    }
    public Boolean getIncremental(){
      return (Boolean) getAttribute(PAttributeNames.INCREMENTAL);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_INPUT_ELEMENT;
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

    public void stepDown(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STEP_DOWN_VOID.getValue());
       writer.endObject();
    }

    public void stepDown(Double n){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STEP_DOWN_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {n});
       writer.endObject();
    }

    public void stepUp(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STEP_UP_VOID.getValue());
       writer.endObject();
    }

    public void stepUp(Double n){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STEP_UP_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {n});
       writer.endObject();
    }

    
}