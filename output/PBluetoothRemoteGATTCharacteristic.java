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
public class PBluetoothRemoteGATTCharacteristic extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PBluetoothRemoteGATTCharacteristic.class);
    private PBluetoothRemoteGATTCharacteristic(){
    }

    public void setOncharacteristicvaluechanged(final PEventHandlerNonNull oncharacteristicvaluechanged, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCHARACTERISTICVALUECHANGED, new AttributeCallBack(oncharacteristicvaluechanged, atrsEventName));
       log.info("oncharacteristicvaluechanged" + oncharacteristicvaluechanged.getClass().getName());
    }

    public PEventHandlerNonNull getOncharacteristicvaluechanged(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCHARACTERISTICVALUECHANGED);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<PBluetoothRemoteGATTDescriptor> getDescriptor(String descriptor) {
       return null;
    }


    public PPromise<PBluetoothRemoteGATTDescriptor> getDescriptor(Double descriptor) {
       return null;
    }


    public PPromise<PBluetoothRemoteGATTDescriptor[]> getDescriptors() {
       return null;
    }


    public PPromise<PBluetoothRemoteGATTDescriptor[]> getDescriptors(String descriptor) {
       return null;
    }


    public PPromise<PBluetoothRemoteGATTDescriptor[]> getDescriptors(Double descriptor) {
       return null;
    }


    public PPromise<PDataView> readValue() {
       return null;
    }


    public PPromise<PBluetoothRemoteGATTCharacteristic> startNotifications() {
       return null;
    }


    public PPromise<PBluetoothRemoteGATTCharacteristic> stopNotifications() {
       return null;
    }


    public PPromise<Void> writeValue(PArrayBuffer value) {
       return null;
    }


    public PPromise<Void> writeValue(PArrayBufferView value) {
       return null;
    }


    
}