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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PRange extends PObject2 {
    public PRange() {
    }





    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.RANGE;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PDocumentFragment cloneContents() {
       return null;
    }


    public PRange cloneRange() {
       return null;
    }


    public void collapse(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COLLAPSE_VOID.getValue());
       writer.endObject();
    }

    public void collapse(Boolean toStart){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COLLAPSE_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {toStart});
       writer.endObject();
    }

    public void compareBoundaryPoints(final Consumer<Short> cback,Short how, PRange sourceRange){
    }

    public void comparePoint(final Consumer<Short> cback,PNode node, Double offset){
    }

    public PDocumentFragment createContextualFragment(String fragment) {
       return null;
    }


    public void deleteContents(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DELETE_CONTENTS_VOID.getValue());
       writer.endObject();
    }

    public void detach(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DETACH_VOID.getValue());
       writer.endObject();
    }

    public void expand(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       EXPAND_VOID.getValue());
       writer.endObject();
    }

    public void expand(String unit){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       EXPAND_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {unit});
       writer.endObject();
    }

    public PDocumentFragment extractContents() {
       return null;
    }


    public PClientRect getBoundingClientRect() {
       return null;
    }


    public PClientRectList getClientRects() {
       return null;
    }


    public void insertNode(PNode node){
    }

    public void intersectsNode(final Consumer<Boolean> cback,PNode node){
    }

    public void isPointInRange(final Consumer<Boolean> cback,PNode node, Double offset){
    }

    public void selectNode(PNode node){
    }

    public void selectNodeContents(PNode node){
    }

    public void setEnd(PNode node, Double offset){
    }

    public void setEndAfter(PNode node){
    }

    public void setEndBefore(PNode node){
    }

    public void setStart(PNode node, Double offset){
    }

    public void setStartAfter(PNode node){
    }

    public void setStartBefore(PNode node){
    }

    public void surroundContents(PNode newParent){
    }

    
}