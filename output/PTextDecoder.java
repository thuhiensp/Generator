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
import java.util.function.Consumer;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PTextDecoder extends PObject2 {
    public PTextDecoder() {
    }


    public PTextDecoder(String label){
      super(label);
    }

    public PTextDecoder(String label, PTextDecoderOptions options){
      super(label, options);
    }




    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.TEXT_DECODER;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.TEXT_DECODER;
    }


    public void decode(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.DECODE_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void decode(final Consumer<String> cback,PArrayBuffer input){
    }

    public void decode(final Consumer<String> cback,PArrayBufferView input){
    }

    public void decode(final Consumer<String> cback,PArrayBuffer input, PTextDecodeOptions options){
    }

    public void decode(final Consumer<String> cback,PArrayBufferView input, PTextDecodeOptions options){
    }

    
}