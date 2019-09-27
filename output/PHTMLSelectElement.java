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
public class PHTMLSelectElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLSelectElement.class);
    public PHTMLSelectElement() {
    }

    public void setAutofocus(final Boolean autofocus)  {
       setAttribute(PAttributeNames.AUTOFOCUS, autofocus);
       log.info("autofocus" + autofocus);
    }
    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }
    public void setMultiple(final Boolean multiple)  {
       setAttribute(PAttributeNames.MULTIPLE, multiple);
       log.info("multiple" + multiple);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setRequired(final Boolean required)  {
       setAttribute(PAttributeNames.REQUIRED, required);
       log.info("required" + required);
    }
    public void setSize(final Double size)  {
       setAttribute(PAttributeNames.SIZE_DOUBLE, size);
       log.info("size" + size);
    }
    public void setLength(final Double length)  {
       setAttribute(PAttributeNames.LENGTH_DOUBLE, length);
       log.info("length" + length);
    }
    public void setSelectedIndex(final Double selectedIndex)  {
       setAttribute(PAttributeNames.SELECTED_INDEX, selectedIndex);
       log.info("selectedIndex" + selectedIndex);
    }
    public void setValue(final String value)  {
       setAttribute(PAttributeNames.VALUE_STRING, value);
       log.info("value" + value);
    }

    public Boolean getAutofocus(){
      return (Boolean) getAttribute(PAttributeNames.AUTOFOCUS);
    }
    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }
    public Boolean getMultiple(){
      return (Boolean) getAttribute(PAttributeNames.MULTIPLE);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public Boolean getRequired(){
      return (Boolean) getAttribute(PAttributeNames.REQUIRED);
    }
    public Double getSize(){
      return (Double) getAttribute(PAttributeNames.SIZE_DOUBLE);
    }
    public Double getLength(){
      return (Double) getAttribute(PAttributeNames.LENGTH_DOUBLE);
    }
    public Double getSelectedIndex(){
      return (Double) getAttribute(PAttributeNames.SELECTED_INDEX);
    }
    public String getValue(){
      return (String) getAttribute(PAttributeNames.VALUE_STRING);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_SELECT_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void add(PHTMLOptionElement element){
    }

    public void add(PHTMLOptGroupElement element){
    }

    public void add(PHTMLOptionElement element, PHTMLElement before){
    }

    public void add(PHTMLOptionElement element, Double before){
    }

    public void add(PHTMLOptGroupElement element, PHTMLElement before){
    }

    public void add(PHTMLOptGroupElement element, Double before){
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

    public PElement get(Double index) {
       return null;
    }


    public PElement item(Double index) {
       return null;
    }


    public PHTMLOptionElement namedItem(String name) {
       return null;
    }


    public void remove(Double index){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index});
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

    public void set(Double index, PHTMLOptionElement option){
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

    
}