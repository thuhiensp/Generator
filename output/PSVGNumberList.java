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
public class PSVGNumberList extends PObject2 {
    private PSVGNumberList(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PSVGNumber appendItem(PSVGNumber newItem) {
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

    public PSVGNumber get(Double index) {
       return null;
    }


    public PSVGNumber getItem(Double index) {
       return null;
    }


    public PSVGNumber initialize(PSVGNumber newItem) {
       return null;
    }


    public PSVGNumber insertItemBefore(PSVGNumber newItem, Double index) {
       return null;
    }


    public PSVGNumber removeItem(Double index) {
       return null;
    }


    public PSVGNumber replaceItem(PSVGNumber newItem, Double index) {
       return null;
    }


    public void set(Double index, PSVGNumber newItem){
    }

    
}