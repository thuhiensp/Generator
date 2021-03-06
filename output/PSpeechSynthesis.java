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
public class PSpeechSynthesis extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PSpeechSynthesis.class);
    private PSpeechSynthesis(){
    }

    public void setOnvoiceschanged(final PEventHandlerNonNull onvoiceschanged, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONVOICESCHANGED, new AttributeCallBack(onvoiceschanged, atrsEventName));
       log.info("onvoiceschanged" + onvoiceschanged.getClass().getName());
    }

    public PEventHandlerNonNull getOnvoiceschanged(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONVOICESCHANGED);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void cancel(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CANCEL_VOID.getValue());
       writer.endObject();
    }

    public PSpeechSynthesisVoice[] getVoices() {
       return null;
    }


    public void pause(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PAUSE_VOID.getValue());
       writer.endObject();
    }

    public void resume(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESUME_VOID.getValue());
       writer.endObject();
    }

    public void speak(PSpeechSynthesisUtterance utterance){
    }

    
}