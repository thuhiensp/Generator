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
public abstract class PIDBRequest extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PIDBRequest.class);
     protected PIDBRequest() {
     }
    protected PIDBRequest(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setOnsuccess(final PEventHandlerNonNull onsuccess, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSUCCESS, new AttributeCallBack(onsuccess, atrsEventName));
       log.info("onsuccess" + onsuccess.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }

    public PEventHandlerNonNull getOnsuccess(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSUCCESS);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }


    
}