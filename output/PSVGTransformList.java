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
public class PSVGTransformList extends PObject2 {
    private PSVGTransformList(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PSVGTransform appendItem(PSVGTransform newItem) {
       return null;
    }


    public void clear(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_VOID.getValue());
       writer.endObject();
    }

    public PSVGTransform consolidate() {
       return null;
    }


    public PSVGTransform createSVGTransformFromMatrix(PSVGMatrix matrix) {
       return null;
    }


    public PSVGTransform get(Double index) {
       return null;
    }


    public PSVGTransform getItem(Double index) {
       return null;
    }


    public PSVGTransform initialize(PSVGTransform newItem) {
       return null;
    }


    public PSVGTransform insertItemBefore(PSVGTransform newItem, Double index) {
       return null;
    }


    public PSVGTransform removeItem(Double index) {
       return null;
    }


    public PSVGTransform replaceItem(PSVGTransform newItem, Double index) {
       return null;
    }


    public void set(Double index, PSVGTransform newItem){
    }

    
}