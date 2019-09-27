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
public class PCSS extends PObject2 {
    private PCSS(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PCSSUnitValue Hz(Double value) {
       return null;
    }


    public PCSSUnitValue ch(Double value) {
       return null;
    }


    public PCSSUnitValue cm(Double value) {
       return null;
    }


    public PCSSUnitValue deg(Double value) {
       return null;
    }


    public PCSSUnitValue dpcm(Double value) {
       return null;
    }


    public PCSSUnitValue dpi(Double value) {
       return null;
    }


    public PCSSUnitValue dppx(Double value) {
       return null;
    }


    public PCSSUnitValue em(Double value) {
       return null;
    }


    public void escape(final Consumer<String> cback,String ident){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.ESCAPE_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {ident});
       writer.endObject();
    }

    public PCSSUnitValue ex(Double value) {
       return null;
    }


    public PCSSUnitValue fr(Double value) {
       return null;
    }


    public PCSSUnitValue grad(Double value) {
       return null;
    }


    public PCSSUnitValue in(Double value) {
       return null;
    }


    public PCSSUnitValue kHz(Double value) {
       return null;
    }


    public PCSSUnitValue mm(Double value) {
       return null;
    }


    public PCSSUnitValue ms(Double value) {
       return null;
    }


    public PCSSUnitValue number(Double value) {
       return null;
    }


    public PCSSUnitValue pc(Double value) {
       return null;
    }


    public PCSSUnitValue percent(Double value) {
       return null;
    }


    public PCSSUnitValue pt(Double value) {
       return null;
    }


    public PCSSUnitValue px(Double value) {
       return null;
    }


    public PCSSUnitValue rad(Double value) {
       return null;
    }


    public void registerProperty(PPropertyDescriptor descriptor){
    }

    public PCSSUnitValue rem(Double value) {
       return null;
    }


    public PCSSUnitValue s(Double value) {
       return null;
    }


    public void supports(final Consumer<Boolean> cback,String conditionText){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SUPPORTS_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {conditionText});
       writer.endObject();
    }

    public void supports(final Consumer<Boolean> cback,String property, String value){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SUPPORTS_TYPESTRING_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {property,value});
       writer.endObject();
    }

    public PCSSUnitValue turn(Double value) {
       return null;
    }


    public PCSSUnitValue vh(Double value) {
       return null;
    }


    public PCSSUnitValue vmax(Double value) {
       return null;
    }


    public PCSSUnitValue vmin(Double value) {
       return null;
    }


    public PCSSUnitValue vw(Double value) {
       return null;
    }


    
}