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
public abstract class PDOMMatrixReadOnly extends PObject2 {
     protected PDOMMatrixReadOnly() {
     }
    protected PDOMMatrixReadOnly(final Object...argOfConstructor){
       super(argOfConstructor);
    }



    public PDOMMatrix flipX() {
       return null;
    }


    public PDOMMatrix flipY() {
       return null;
    }


    public PDOMMatrixReadOnly fromFloat32Array(PFloat32Array array32) {
       return null;
    }


    public PDOMMatrixReadOnly fromFloat64Array(PFloat64Array array64) {
       return null;
    }


    public PDOMMatrixReadOnly fromMatrix() {
       return null;
    }


    public PDOMMatrixReadOnly fromMatrix(PDOMMatrixInit other) {
       return null;
    }


    public PDOMMatrix inverse() {
       return null;
    }


    public PDOMMatrix multiply() {
       return null;
    }


    public PDOMMatrix multiply(PDOMMatrixInit other) {
       return null;
    }


    public PDOMMatrix rotate() {
       return null;
    }


    public PDOMMatrix rotate(Double rotX) {
       return null;
    }


    public PDOMMatrix rotate(Double rotX, Double rotY) {
       return null;
    }


    public PDOMMatrix rotate(Double rotX, Double rotY, Double rotZ) {
       return null;
    }


    public PDOMMatrix rotateAxisAngle() {
       return null;
    }


    public PDOMMatrix rotateAxisAngle(Double x) {
       return null;
    }


    public PDOMMatrix rotateAxisAngle(Double x, Double y) {
       return null;
    }


    public PDOMMatrix rotateAxisAngle(Double x, Double y, Double z) {
       return null;
    }


    public PDOMMatrix rotateAxisAngle(Double x, Double y, Double z, Double angle) {
       return null;
    }


    public PDOMMatrix rotateFromVector() {
       return null;
    }


    public PDOMMatrix rotateFromVector(Double x) {
       return null;
    }


    public PDOMMatrix rotateFromVector(Double x, Double y) {
       return null;
    }


    public PDOMMatrix scale() {
       return null;
    }


    public PDOMMatrix scale(Double scaleX) {
       return null;
    }


    public PDOMMatrix scale(Double scaleX, Double scaleY) {
       return null;
    }


    public PDOMMatrix scale(Double scaleX, Double scaleY, Double scaleZ) {
       return null;
    }


    public PDOMMatrix scale(Double scaleX, Double scaleY, Double scaleZ, Double originX) {
       return null;
    }


    public PDOMMatrix scale(Double scaleX, Double scaleY, Double scaleZ, Double originX, Double originY) {
       return null;
    }


    public PDOMMatrix scale(Double scaleX, Double scaleY, Double scaleZ, Double originX, Double originY, Double originZ) {
       return null;
    }


    public PDOMMatrix scale3d() {
       return null;
    }


    public PDOMMatrix scale3d(Double scale) {
       return null;
    }


    public PDOMMatrix scale3d(Double scale, Double originX) {
       return null;
    }


    public PDOMMatrix scale3d(Double scale, Double originX, Double originY) {
       return null;
    }


    public PDOMMatrix scale3d(Double scale, Double originX, Double originY, Double originZ) {
       return null;
    }


    public PDOMMatrix skewX() {
       return null;
    }


    public PDOMMatrix skewX(Double sx) {
       return null;
    }


    public PDOMMatrix skewY() {
       return null;
    }


    public PDOMMatrix skewY(Double sy) {
       return null;
    }


    public PFloat32Array toFloat32Array() {
       return null;
    }


    public PFloat64Array toFloat64Array() {
       return null;
    }


    public PDOMPoint transformPoint() {
       return null;
    }


    public PDOMPoint transformPoint(PDOMPointInit point) {
       return null;
    }


    public PDOMMatrix translate() {
       return null;
    }


    public PDOMMatrix translate(Double tx) {
       return null;
    }


    public PDOMMatrix translate(Double tx, Double ty) {
       return null;
    }


    public PDOMMatrix translate(Double tx, Double ty, Double tz) {
       return null;
    }


    
}