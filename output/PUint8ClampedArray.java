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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PUint8ClampedArray extends PArrayBufferView {
    public PUint8ClampedArray(Double length){
      super(length);
    }

    public PUint8ClampedArray(PUint8ClampedArray array){
      super(array);
    }

    public PUint8ClampedArray(Byte[] array){
      super(array);
    }

    public PUint8ClampedArray(PArrayBuffer buffer){
      super(buffer);
    }

    public PUint8ClampedArray(PArrayBuffer buffer, Double byteOffset){
      super(buffer, byteOffset);
    }

    public PUint8ClampedArray(PArrayBuffer buffer, Double byteOffset, Double length){
      super(buffer, byteOffset, length);
    }




    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.UINT8_CLAMPED_ARRAY;
    }


    public void get(final Consumer<Byte> cback,Double index){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_TYPEDOUBLE_BYTE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index});
       writer.endObject();
    }

    public void set(PUint8ClampedArray array){
    }

    public void set(Byte[] array){
    }

    public void set(PUint8ClampedArray array, Double offset){
    }

    public void set(Byte[] array, Double offset){
    }

    public void set(Double index, Byte value){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_TYPEDOUBLE_TYPEBYTE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index,value});
       writer.endObject();
    }

    public PUint8ClampedArray subarray(Double begin) {
       return null;
    }


    public PUint8ClampedArray subarray(Double begin, Double end) {
       return null;
    }


    
}