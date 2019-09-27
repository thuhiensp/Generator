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
public abstract class PSVGGeometryElement extends PSVGGraphicsElement {
     protected PSVGGeometryElement() {
     }
    protected PSVGGeometryElement(final Object...argOfConstructor){
       super(argOfConstructor);
    }



    public PSVGPoint getPointAtLength(Double distance) {
       return null;
    }


    public void getTotalLength(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_TOTAL_LENGTH_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void isPointInFill(final Consumer<Boolean> cback,PSVGPoint point){
    }

    public void isPointInStroke(final Consumer<Boolean> cback,PSVGPoint point){
    }

    
}