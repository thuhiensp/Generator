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
public abstract class PSVGAnimationElement extends PSVGElement {
    private static final Logger log = LoggerFactory.getLogger(PSVGAnimationElement.class);
     protected PSVGAnimationElement() {
     }
    protected PSVGAnimationElement(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setOnbegin(final PEventHandlerNonNull onbegin, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEGIN, new AttributeCallBack(onbegin, atrsEventName));
       log.info("onbegin" + onbegin.getClass().getName());
    }
    public void setOnend(final PEventHandlerNonNull onend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONEND, new AttributeCallBack(onend, atrsEventName));
       log.info("onend" + onend.getClass().getName());
    }
    public void setOnrepeat(final PEventHandlerNonNull onrepeat, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREPEAT, new AttributeCallBack(onrepeat, atrsEventName));
       log.info("onrepeat" + onrepeat.getClass().getName());
    }

    public PEventHandlerNonNull getOnbegin(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEGIN);
    }
    public PEventHandlerNonNull getOnend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONEND);
    }
    public PEventHandlerNonNull getOnrepeat(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREPEAT);
    }


    public void beginElement(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BEGIN_ELEMENT_VOID.getValue());
       writer.endObject();
    }

    public void beginElementAt(Double offset){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BEGIN_ELEMENT_AT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {offset});
       writer.endObject();
    }

    public void endElement(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       END_ELEMENT_VOID.getValue());
       writer.endObject();
    }

    public void endElementAt(Double offset){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       END_ELEMENT_AT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {offset});
       writer.endObject();
    }

    public void getCurrentTime(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_CURRENT_TIME_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void getSimpleDuration(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_SIMPLE_DURATION_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void getStartTime(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_START_TIME_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    
}