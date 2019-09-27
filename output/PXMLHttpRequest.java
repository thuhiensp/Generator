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
public class PXMLHttpRequest extends PXMLHttpRequestEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PXMLHttpRequest.class);
    public PXMLHttpRequest() {
    }



    public void setOnreadystatechange(final PEventHandlerNonNull onreadystatechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREADYSTATECHANGE, new AttributeCallBack(onreadystatechange, atrsEventName));
       log.info("onreadystatechange" + onreadystatechange.getClass().getName());
    }
    public void setTimeout(final Double timeout)  {
       setAttribute(PAttributeNames.TIMEOUT, timeout);
       log.info("timeout" + timeout);
    }
    public void setWithCredentials(final Boolean withCredentials)  {
       setAttribute(PAttributeNames.WITH_CREDENTIALS, withCredentials);
       log.info("withCredentials" + withCredentials);
    }
    public void setResponseType(final PXMLHttpRequestResponseType responseType)  {
       setAttribute(PAttributeNames.RESPONSE_TYPE, responseType);
       log.info("responseType" + responseType);
    }

    public PEventHandlerNonNull getOnreadystatechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREADYSTATECHANGE);
    }
    public Double getTimeout(){
      return (Double) getAttribute(PAttributeNames.TIMEOUT);
    }
    public Boolean getWithCredentials(){
      return (Boolean) getAttribute(PAttributeNames.WITH_CREDENTIALS);
    }
    public PXMLHttpRequestResponseType getResponseType(){
      return (PXMLHttpRequestResponseType) getAttribute(PAttributeNames.RESPONSE_TYPE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.XML_HTTP_REQUEST;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void abort(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ABORT_VOID.getValue());
       writer.endObject();
    }

    public void getAllResponseHeaders(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_ALL_RESPONSE_HEADERS_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void getResponseHeader(final Consumer<String> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_RESPONSE_HEADER_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void open(String method, String url){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       OPEN_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {method,url});
       writer.endObject();
    }

    public void open(String method, String url, Boolean async){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       OPEN_TYPESTRING_TYPESTRING_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {method,url,async});
       writer.endObject();
    }

    public void open(String method, String url, Boolean async, String username){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       OPEN_TYPESTRING_TYPESTRING_TYPEBOOLEAN_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {method,url,async,username});
       writer.endObject();
    }

    public void open(String method, String url, Boolean async, String username, String password){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       OPEN_TYPESTRING_TYPESTRING_TYPEBOOLEAN_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {method,url,async,username,password});
       writer.endObject();
    }

    public void overrideMimeType(String mime){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       OVERRIDE_MIME_TYPE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mime});
       writer.endObject();
    }

    public void send(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SEND_VOID.getValue());
       writer.endObject();
    }

    public void send(PArrayBuffer body){
    }

    public void send(PArrayBufferView body){
    }

    public void send(PBlob body){
    }

    public void send(PDocument body){
    }

    public void send(String body){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SEND_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {body});
       writer.endObject();
    }

    public void send(PFormData body){
    }

    public void send(PURLSearchParams body){
    }

    public void setRequestHeader(String name, String value){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_REQUEST_HEADER_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name,value});
       writer.endObject();
    }

    
}