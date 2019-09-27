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
public class PHTMLButtonElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLButtonElement.class);
    public PHTMLButtonElement() {
    }

    public void setAutofocus(final Boolean autofocus)  {
       setAttribute(PAttributeNames.AUTOFOCUS, autofocus);
       log.info("autofocus" + autofocus);
    }
    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
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
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
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
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getValue(){
      return (String) getAttribute(PAttributeNames.VALUE_STRING);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_BUTTON_ELEMENT;
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