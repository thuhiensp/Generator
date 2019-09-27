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
public class PHTMLFormElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLFormElement.class);
    public PHTMLFormElement() {
    }

    public void setAcceptCharset(final String acceptCharset)  {
       setAttribute(PAttributeNames.ACCEPT_CHARSET, acceptCharset);
       log.info("acceptCharset" + acceptCharset);
    }
    public void setAction(final String action)  {
       setAttribute(PAttributeNames.ACTION, action);
       log.info("action" + action);
    }
    public void setAutocomplete(final String autocomplete)  {
       setAttribute(PAttributeNames.AUTOCOMPLETE, autocomplete);
       log.info("autocomplete" + autocomplete);
    }
    public void setEnctype(final String enctype)  {
       setAttribute(PAttributeNames.ENCTYPE, enctype);
       log.info("enctype" + enctype);
    }
    public void setEncoding(final String encoding)  {
       setAttribute(PAttributeNames.ENCODING, encoding);
       log.info("encoding" + encoding);
    }
    public void setMethod(final String method)  {
       setAttribute(PAttributeNames.METHOD, method);
       log.info("method" + method);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setNoValidate(final Boolean noValidate)  {
       setAttribute(PAttributeNames.NO_VALIDATE, noValidate);
       log.info("noValidate" + noValidate);
    }
    public void setTarget(final String target)  {
       setAttribute(PAttributeNames.TARGET, target);
       log.info("target" + target);
    }

    public String getAcceptCharset(){
      return (String) getAttribute(PAttributeNames.ACCEPT_CHARSET);
    }
    public String getAction(){
      return (String) getAttribute(PAttributeNames.ACTION);
    }
    public String getAutocomplete(){
      return (String) getAttribute(PAttributeNames.AUTOCOMPLETE);
    }
    public String getEnctype(){
      return (String) getAttribute(PAttributeNames.ENCTYPE);
    }
    public String getEncoding(){
      return (String) getAttribute(PAttributeNames.ENCODING);
    }
    public String getMethod(){
      return (String) getAttribute(PAttributeNames.METHOD);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public Boolean getNoValidate(){
      return (Boolean) getAttribute(PAttributeNames.NO_VALIDATE);
    }
    public String getTarget(){
      return (String) getAttribute(PAttributeNames.TARGET);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_FORM_ELEMENT;
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

    public PElement get(Double index) {
       return null;
    }


    public PFormControlsUnion get(String name) {
       return null;
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

    public void reset(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESET_VOID.getValue());
       writer.endObject();
    }

    public void submit(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SUBMIT_VOID.getValue());
       writer.endObject();
    }

    
}