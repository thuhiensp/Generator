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
public class PJSONImpl extends PObject2 {
    private PJSONImpl(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void parse(final Consumer<Object> cback,String text){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.PARSE_TYPESTRING_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {text});
       writer.endObject();
    }

    public void parse(final Consumer<Object> cback,String text, PJSONModifier reviver){
    }

    public void stringify(final Consumer<String> cback,Object value){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.STRINGIFY_TYPEOBJECT_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {value});
       writer.endObject();
    }

    public void stringify(final Consumer<String> cback,Object value, String[] replacer){
    }

    public void stringify(final Consumer<String> cback,Object value, PJSONModifier replacer){
    }

    public void stringify(final Consumer<String> cback,Object value, String[] replacer, String space){
    }

    public void stringify(final Consumer<String> cback,Object value, String[] replacer, Double space){
    }

    public void stringify(final Consumer<String> cback,Object value, PJSONModifier replacer, String space){
    }

    public void stringify(final Consumer<String> cback,Object value, PJSONModifier replacer, Double space){
    }

    
}