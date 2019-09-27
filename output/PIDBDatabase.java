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
public class PIDBDatabase extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PIDBDatabase.class);
    private PIDBDatabase(){
    }

    public void setOnabort(final PEventHandlerNonNull onabort, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONABORT, new AttributeCallBack(onabort, atrsEventName));
       log.info("onabort" + onabort.getClass().getName());
    }
    public void setOnclose(final PEventHandlerNonNull onclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLOSE, new AttributeCallBack(onclose, atrsEventName));
       log.info("onclose" + onclose.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnversionchange(final PEventHandlerNonNull onversionchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONVERSIONCHANGE, new AttributeCallBack(onversionchange, atrsEventName));
       log.info("onversionchange" + onversionchange.getClass().getName());
    }

    public PEventHandlerNonNull getOnabort(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONABORT);
    }
    public PEventHandlerNonNull getOnclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLOSE);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnversionchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONVERSIONCHANGE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public PIDBObjectStore createObjectStore(String name) {
       return null;
    }


    public PIDBObjectStore createObjectStore(String name, PIDBObjectStoreParameters options) {
       return null;
    }


    public void deleteObjectStore(String name){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETE_OBJECT_STORE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public PIDBTransaction transaction(String storeNames) {
       return null;
    }


    public PIDBTransaction transaction(String[] storeNames) {
       return null;
    }


    public PIDBTransaction transaction(String storeNames, PIDBTransactionMode mode) {
       return null;
    }


    public PIDBTransaction transaction(String[] storeNames, PIDBTransactionMode mode) {
       return null;
    }


    public PIDBTransaction transaction(String storeNames, String mode) {
       return null;
    }


    public PIDBTransaction transaction(String[] storeNames, String mode) {
       return null;
    }


    
}