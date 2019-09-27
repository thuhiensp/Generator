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
public class PNavigator extends PObject2 {
    private PNavigator(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void cancelKeyboardLock(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CANCEL_KEYBOARD_LOCK_VOID.getValue());
       writer.endObject();
    }

    public PPromise<PBatteryManager> getBattery() {
       return null;
    }


    public PGamepadList getGamepads() {
       return null;
    }


    public PPromise<PRelatedApplication> getInstalledRelatedApps() {
       return null;
    }


    public void getUserMedia(PMediaStreamConstraints constraints, PNavigatorUserMediaSuccessCallback successCallback, PNavigatorUserMediaErrorCallback errorCallback){
    }

    public PPromise getVRDisplays() {
       return null;
    }


    public void isProtocolHandlerRegistered(final Consumer<String> cback,String scheme, String url){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_PROTOCOL_HANDLER_REGISTERED_TYPESTRING_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {scheme,url});
       writer.endObject();
    }

    public void javaEnabled(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.JAVA_ENABLED_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void registerProtocolHandler(String scheme, String url, String title){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REGISTER_PROTOCOL_HANDLER_TYPESTRING_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {scheme,url,title});
       writer.endObject();
    }

    public PPromise<Void> requestKeyboardLock() {
       return null;
    }


    public PPromise<Void> requestKeyboardLock(String[] keyCodes) {
       return null;
    }


    public PPromise requestMIDIAccess() {
       return null;
    }


    public PPromise requestMIDIAccess(PMIDIOptions options) {
       return null;
    }


    public PPromise<PMediaKeySystemAccess> requestMediaKeySystemAccess(String keySystem, PMediaKeySystemConfiguration[] supportedConfigurations) {
       return null;
    }


    public void sendBeacon(final Consumer<Boolean> cback,String url){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SEND_BEACON_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {url});
       writer.endObject();
    }

    public void sendBeacon(final Consumer<Boolean> cback,String url, PArrayBufferView data){
    }

    public void sendBeacon(final Consumer<Boolean> cback,String url, PBlob data){
    }

    public void sendBeacon(final Consumer<Boolean> cback,String url, String data){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SEND_BEACON_TYPESTRING_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {url,data});
       writer.endObject();
    }

    public void sendBeacon(final Consumer<Boolean> cback,String url, PFormData data){
    }

    public PPromise<Void> share(PShareData data) {
       return null;
    }


    public void unregisterProtocolHandler(String scheme, String url){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       UNREGISTER_PROTOCOL_HANDLER_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {scheme,url});
       writer.endObject();
    }

    public void vibrate(final Consumer<Boolean> cback,Double pattern){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.VIBRATE_TYPEDOUBLE_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {pattern});
       writer.endObject();
    }

    public void vibrate(final Consumer<Boolean> cback,Double[] pattern){
    }

    public void webkitGetUserMedia(PMediaStreamConstraints constraints, PNavigatorUserMediaSuccessCallback successCallback, PNavigatorUserMediaErrorCallback errorCallback){
    }

    
}