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
public class PEXTDisjointTimerQuery extends PObject2 {
    private PEXTDisjointTimerQuery(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void beginQueryEXT(Double target, PWebGLTimerQueryEXT query){
    }

    public PWebGLTimerQueryEXT createQueryEXT() {
       return null;
    }


    public void deleteQueryEXT(PWebGLTimerQueryEXT query){
    }

    public void endQueryEXT(Double target){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       END_QUERYEXT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target});
       writer.endObject();
    }

    public void getQueryEXT(final Consumer<Object> cback,Double target, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_QUERYEXT_TYPEDOUBLE_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,pname});
       writer.endObject();
    }

    public void getQueryObjectEXT(final Consumer<Object> cback,PWebGLTimerQueryEXT query, Double pname){
    }

    public void isQueryEXT(final Consumer<Boolean> cback,PWebGLTimerQueryEXT query){
    }

    public void queryCounterEXT(PWebGLTimerQueryEXT query, Double target){
    }

    
}