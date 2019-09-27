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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class POfflineAudioContext extends PBaseAudioContext {
    private static final Logger log = LoggerFactory.getLogger(POfflineAudioContext.class);
    public POfflineAudioContext(Double numberOfChannels, Double numberOfFrames, Double sampleRate){
      super(numberOfChannels, numberOfFrames, sampleRate);
    }


    public void setOncomplete(final PEventHandlerNonNull oncomplete, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCOMPLETE, new AttributeCallBack(oncomplete, atrsEventName));
       log.info("oncomplete" + oncomplete.getClass().getName());
    }

    public PEventHandlerNonNull getOncomplete(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCOMPLETE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.OFFLINE_AUDIO_CONTEXT;
    }


    public PPromise<PAudioBuffer> startRendering() {
       return null;
    }


    public PPromise<Void> suspend(Double suspendTime) {
       return null;
    }


    
}