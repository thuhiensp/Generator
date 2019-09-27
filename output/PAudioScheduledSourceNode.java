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
public abstract class PAudioScheduledSourceNode extends PAudioNode {
    private static final Logger log = LoggerFactory.getLogger(PAudioScheduledSourceNode.class);
     protected PAudioScheduledSourceNode() {
     }
    protected PAudioScheduledSourceNode(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setOnended(final PEventHandlerNonNull onended, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONENDED, new AttributeCallBack(onended, atrsEventName));
       log.info("onended" + onended.getClass().getName());
    }

    public PEventHandlerNonNull getOnended(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONENDED);
    }


    public void start(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_VOID.getValue());
       writer.endObject();
    }

    public void start(Double when){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       START_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {when});
       writer.endObject();
    }

    public void stop(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STOP_VOID.getValue());
       writer.endObject();
    }

    public void stop(Double when){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STOP_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {when});
       writer.endObject();
    }

    
}