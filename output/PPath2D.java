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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PPath2D extends PObject2 {
    public PPath2D() {
    }


    public PPath2D(PPath2D path){
      super(path);
    }

    public PPath2D(String text){
      super(text);
    }




    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.PATH2D;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.PATH2D;
    }


    public void addPath(PPath2D path){
    }

    public void addPath(PPath2D path, PSVGMatrix transform){
    }

    public void arc(Double x, Double y, Double radius, Double startAngle, Double endAngle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ARC_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radius,startAngle,endAngle});
       writer.endObject();
    }

    public void arc(Double x, Double y, Double radius, Double startAngle, Double endAngle, Boolean anticlockwise){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ARC_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radius,startAngle,endAngle,anticlockwise});
       writer.endObject();
    }

    public void arcTo(Double x1, Double y1, Double x2, Double y2, Double radius){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ARC_TO_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x1,y1,x2,y2,radius});
       writer.endObject();
    }

    public void bezierCurveTo(Double cp1x, Double cp1y, Double cp2x, Double cp2y, Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BEZIER_CURVE_TO_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cp1x,cp1y,cp2x,cp2y,x,y});
       writer.endObject();
    }

    public void closePath(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_PATH_VOID.getValue());
       writer.endObject();
    }

    public void ellipse(Double x, Double y, Double radiusX, Double radiusY, Double rotation, Double startAngle, Double endAngle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ELLIPSE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radiusX,radiusY,rotation,startAngle,endAngle});
       writer.endObject();
    }

    public void ellipse(Double x, Double y, Double radiusX, Double radiusY, Double rotation, Double startAngle, Double endAngle, Boolean anticlockwise){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ELLIPSE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radiusX,radiusY,rotation,startAngle,endAngle,anticlockwise});
       writer.endObject();
    }

    public void lineTo(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       LINE_TO_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void moveTo(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MOVE_TO_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void quadraticCurveTo(Double cpx, Double cpy, Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       QUADRATIC_CURVE_TO_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cpx,cpy,x,y});
       writer.endObject();
    }

    public void rect(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RECT_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    
}