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
public class PSelection extends PObject2 {
    private PSelection(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void addRange(PRange range){
    }

    public void collapse(PNode node){
    }

    public void collapse(PNode node, Double offset){
    }

    public void collapseToEnd(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COLLAPSE_TO_END_VOID.getValue());
       writer.endObject();
    }

    public void collapseToStart(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COLLAPSE_TO_START_VOID.getValue());
       writer.endObject();
    }

    public void containsNode(final Consumer<Boolean> cback,PNode node){
    }

    public void containsNode(final Consumer<Boolean> cback,PNode node, Boolean allowPartialContainment){
    }

    public void deleteFromDocument(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETE_FROM_DOCUMENT_VOID.getValue());
       writer.endObject();
    }

    public void empty(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       EMPTY_VOID.getValue());
       writer.endObject();
    }

    public void extend(PNode node){
    }

    public void extend(PNode node, Double offset){
    }

    public PRange getRangeAt(Double index) {
       return null;
    }


    public void modify(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MODIFY_VOID.getValue());
       writer.endObject();
    }

    public void modify(String alter){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MODIFY_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {alter});
       writer.endObject();
    }

    public void modify(String alter, String direction){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MODIFY_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {alter,direction});
       writer.endObject();
    }

    public void modify(String alter, String direction, String granularity){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MODIFY_TYPESTRING_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {alter,direction,granularity});
       writer.endObject();
    }

    public void removeAllRanges(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_ALL_RANGES_VOID.getValue());
       writer.endObject();
    }

    public void removeRange(PRange range){
    }

    public void selectAllChildren(PNode node){
    }

    public void setBaseAndExtent(PNode baseNode, Double baseOffset, PNode extentNode, Double extentOffset){
    }

    public void setPosition(PNode node){
    }

    public void setPosition(PNode node, Double offset){
    }

    
}