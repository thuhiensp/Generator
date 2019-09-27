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
public class PUSBDevice extends PObject2 {
    private PUSBDevice(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<Void> claimInterface(Byte interfaceNumber) {
       return null;
    }


    public PPromise<Void> clearHalt(PUSBDirection direction, Byte endpointNumber) {
       return null;
    }


    public PPromise<Void> clearHalt(String direction, Byte endpointNumber) {
       return null;
    }


    public PPromise<Void> close() {
       return null;
    }


    public PPromise<PUSBInTransferResult> controlTransferIn(PUSBControlTransferParameters setup, Short length) {
       return null;
    }


    public PPromise<PUSBOutTransferResult> controlTransferOut(PUSBControlTransferParameters setup) {
       return null;
    }


    public PPromise<PUSBOutTransferResult> controlTransferOut(PUSBControlTransferParameters setup, PArrayBuffer data) {
       return null;
    }


    public PPromise<PUSBOutTransferResult> controlTransferOut(PUSBControlTransferParameters setup, PArrayBufferView data) {
       return null;
    }


    public PPromise<PUSBIsochronousInTransferResult> isochronousTransferIn(Byte endpointNumber, Double[] packetLengths) {
       return null;
    }


    public PPromise<PUSBIsochronousOutTransferResult> isochronousTransferOut(Byte endpointNumber, PArrayBuffer data, Double[] packetLengths) {
       return null;
    }


    public PPromise<PUSBIsochronousOutTransferResult> isochronousTransferOut(Byte endpointNumber, PArrayBufferView data, Double[] packetLengths) {
       return null;
    }


    public PPromise<Void> open() {
       return null;
    }


    public PPromise<Void> releaseInterface(Byte interfaceNumber) {
       return null;
    }


    public PPromise<Void> reset() {
       return null;
    }


    public PPromise<Void> selectAlternateInterface(Byte interfaceNumber, Byte alternateSetting) {
       return null;
    }


    public PPromise<Void> selectConfiguration(Byte configurationValue) {
       return null;
    }


    public PPromise<PUSBInTransferResult> transferIn(Byte endpointNumber, Double length) {
       return null;
    }


    public PPromise<PUSBOutTransferResult> transferOut(Byte endpointNumber, PArrayBuffer data) {
       return null;
    }


    public PPromise<PUSBOutTransferResult> transferOut(Byte endpointNumber, PArrayBufferView data) {
       return null;
    }


    
}