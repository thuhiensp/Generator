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
import java.util.Map;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PURLSearchParams extends PObject2 {
    public PURLSearchParams() {
    }


    public PURLSearchParams(String[][] init){
      super(init);
    }

    public PURLSearchParams(Map<String,String> init){
      super(init);
    }

    public PURLSearchParams(String init){
      super(init);
    }




    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.URL_SEARCH_PARAMS;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.URL_SEARCH_PARAMS;
    }


    public void append(String name, String value){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       APPEND_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name,value});
       writer.endObject();
    }

    public void delete(String name){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void get(final Consumer<String> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public String[] getAll(String name) {
       return null;
    }


    public void has(final Consumer<Boolean> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void set(String name, String value){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name,value});
       writer.endObject();
    }

    public void sort(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SORT_VOID.getValue());
       writer.endObject();
    }

    
}