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
public abstract class PWorkerGlobalScope extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PWorkerGlobalScope.class);
     protected PWorkerGlobalScope() {
     }
    protected PWorkerGlobalScope(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnrejectionhandled(final PEventHandlerNonNull onrejectionhandled, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREJECTIONHANDLED, new AttributeCallBack(onrejectionhandled, atrsEventName));
       log.info("onrejectionhandled" + onrejectionhandled.getClass().getName());
    }
    public void setOnunhandledrejection(final PEventHandlerNonNull onunhandledrejection, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUNHANDLEDREJECTION, new AttributeCallBack(onunhandledrejection, atrsEventName));
       log.info("onunhandledrejection" + onunhandledrejection.getClass().getName());
    }

    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnrejectionhandled(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREJECTIONHANDLED);
    }
    public PEventHandlerNonNull getOnunhandledrejection(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUNHANDLEDREJECTION);
    }


    public void atob(final Consumer<String> cback,String atob){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.ATOB_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {atob});
       writer.endObject();
    }

    public void btoa(final Consumer<String> cback,String btoa){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.BTOA_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {btoa});
       writer.endObject();
    }

    public void clearInterval(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_INTERVAL_VOID.getValue());
       writer.endObject();
    }

    public void clearInterval(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_INTERVAL_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public void clearTimeout(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_TIMEOUT_VOID.getValue());
       writer.endObject();
    }

    public void clearTimeout(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_TIMEOUT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public PPromise createImageBitmap(PHTMLImageElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLImageElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise<PResponse> fetch(PRequest input) {
       return null;
    }


    public PPromise<PResponse> fetch(String input) {
       return null;
    }


    public PPromise<PResponse> fetch(PRequest input, PJsObject init) {
       return null;
    }


    public PPromise<PResponse> fetch(String input, PJsObject init) {
       return null;
    }


    public final void importScripts(String urls){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       IMPORT_SCRIPTS_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {urls});
       writer.endObject();
    }

    public void setInterval(final Consumer<Double> cback,PCallbackFunction handler){
    }

    public void setInterval(final Consumer<Double> cback,String handler){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_INTERVAL_TYPESTRING_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler});
       writer.endObject();
    }

    public void setInterval(final Consumer<Double> cback,PCallbackFunction handler, Double timeout, Object arguments){
    }

    public void setInterval(final Consumer<Double> cback,String handler, Double timeout, Object arguments){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_INTERVAL_TYPESTRING_TYPEDOUBLE_TYPEOBJECT_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler,timeout,arguments});
       writer.endObject();
    }

    public void setTimeout(final Consumer<Double> cback,PCallbackFunction handler){
    }

    public void setTimeout(final Consumer<Double> cback,String handler){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_TIMEOUT_TYPESTRING_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler});
       writer.endObject();
    }

    public void setTimeout(final Consumer<Double> cback,PCallbackFunction handler, Double timeout, Object arguments){
    }

    public void setTimeout(final Consumer<Double> cback,String handler, Double timeout, Object arguments){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_TIMEOUT_TYPESTRING_TYPEDOUBLE_TYPEOBJECT_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler,timeout,arguments});
       writer.endObject();
    }

    
}