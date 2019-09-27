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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PHTMLCanvasElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLCanvasElement.class);
    public PHTMLCanvasElement() {
    }

    public void setWidth(final Double width)  {
       setAttribute(PAttributeNames.WIDTH_DOUBLE, width);
       log.info("width" + width);
    }
    public void setHeight(final Double height)  {
       setAttribute(PAttributeNames.HEIGHT_DOUBLE, height);
       log.info("height" + height);
    }

    public Double getWidth(){
      return (Double) getAttribute(PAttributeNames.WIDTH_DOUBLE);
    }
    public Double getHeight(){
      return (Double) getAttribute(PAttributeNames.HEIGHT_DOUBLE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_CANVAS_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PMediaStream captureStream() {
       return null;
    }


    public PMediaStream captureStream(Double frameRate) {
       return null;
    }


    public PRenderingContext getContext(String contextId) {
       return null;
    }


    public PRenderingContext getContext(String contextId, PCanvasContextCreationAttributes attributes) {
       return null;
    }


    public void toBlob(PBlobCallback _callback){
    }

    public void toBlob(PBlobCallback _callback, String type){
    }

    public void toBlob(PBlobCallback _callback, String type, Object arguments){
    }

    public void toDataURL(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_DATAURL_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void toDataURL(final Consumer<String> cback,String type){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_DATAURL_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {type});
       writer.endObject();
    }

    public void toDataURL(final Consumer<String> cback,String type, Object arguments){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_DATAURL_TYPESTRING_TYPEOBJECT_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {type,arguments});
       writer.endObject();
    }

    public POffscreenCanvas transferControlToOffscreen() {
       return null;
    }


    
}