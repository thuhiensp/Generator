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
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Consumer;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PDOMMatrix extends PDOMMatrixReadOnly {
    private static final Logger log = LoggerFactory.getLogger(PDOMMatrix.class);
    public PDOMMatrix() {
    }


    public PDOMMatrix(String init){
      super(init);
    }

    public PDOMMatrix(Double[] init){
      super(init);
    }


    public void setA(final Double a)  {
       setAttribute(PAttributeNames.A, a);
       log.info("a" + a);
    }
    public void setB(final Double b)  {
       setAttribute(PAttributeNames.B, b);
       log.info("b" + b);
    }
    public void setC(final Double c)  {
       setAttribute(PAttributeNames.C, c);
       log.info("c" + c);
    }
    public void setD(final Double d)  {
       setAttribute(PAttributeNames.D, d);
       log.info("d" + d);
    }
    public void setE(final Double e)  {
       setAttribute(PAttributeNames.E, e);
       log.info("e" + e);
    }
    public void setF(final Double f)  {
       setAttribute(PAttributeNames.F, f);
       log.info("f" + f);
    }
    public void setM11(final Double m11)  {
       setAttribute(PAttributeNames.M11, m11);
       log.info("m11" + m11);
    }
    public void setM12(final Double m12)  {
       setAttribute(PAttributeNames.M12, m12);
       log.info("m12" + m12);
    }
    public void setM13(final Double m13)  {
       setAttribute(PAttributeNames.M13, m13);
       log.info("m13" + m13);
    }
    public void setM14(final Double m14)  {
       setAttribute(PAttributeNames.M14, m14);
       log.info("m14" + m14);
    }
    public void setM21(final Double m21)  {
       setAttribute(PAttributeNames.M21, m21);
       log.info("m21" + m21);
    }
    public void setM22(final Double m22)  {
       setAttribute(PAttributeNames.M22, m22);
       log.info("m22" + m22);
    }
    public void setM23(final Double m23)  {
       setAttribute(PAttributeNames.M23, m23);
       log.info("m23" + m23);
    }
    public void setM24(final Double m24)  {
       setAttribute(PAttributeNames.M24, m24);
       log.info("m24" + m24);
    }
    public void setM31(final Double m31)  {
       setAttribute(PAttributeNames.M31, m31);
       log.info("m31" + m31);
    }
    public void setM32(final Double m32)  {
       setAttribute(PAttributeNames.M32, m32);
       log.info("m32" + m32);
    }
    public void setM33(final Double m33)  {
       setAttribute(PAttributeNames.M33, m33);
       log.info("m33" + m33);
    }
    public void setM34(final Double m34)  {
       setAttribute(PAttributeNames.M34, m34);
       log.info("m34" + m34);
    }
    public void setM41(final Double m41)  {
       setAttribute(PAttributeNames.M41, m41);
       log.info("m41" + m41);
    }
    public void setM42(final Double m42)  {
       setAttribute(PAttributeNames.M42, m42);
       log.info("m42" + m42);
    }
    public void setM43(final Double m43)  {
       setAttribute(PAttributeNames.M43, m43);
       log.info("m43" + m43);
    }
    public void setM44(final Double m44)  {
       setAttribute(PAttributeNames.M44, m44);
       log.info("m44" + m44);
    }

    public Double getA(){
      return (Double) getAttribute(PAttributeNames.A);
    }
    public Double getB(){
      return (Double) getAttribute(PAttributeNames.B);
    }
    public Double getC(){
      return (Double) getAttribute(PAttributeNames.C);
    }
    public Double getD(){
      return (Double) getAttribute(PAttributeNames.D);
    }
    public Double getE(){
      return (Double) getAttribute(PAttributeNames.E);
    }
    public Double getF(){
      return (Double) getAttribute(PAttributeNames.F);
    }
    public Double getM11(){
      return (Double) getAttribute(PAttributeNames.M11);
    }
    public Double getM12(){
      return (Double) getAttribute(PAttributeNames.M12);
    }
    public Double getM13(){
      return (Double) getAttribute(PAttributeNames.M13);
    }
    public Double getM14(){
      return (Double) getAttribute(PAttributeNames.M14);
    }
    public Double getM21(){
      return (Double) getAttribute(PAttributeNames.M21);
    }
    public Double getM22(){
      return (Double) getAttribute(PAttributeNames.M22);
    }
    public Double getM23(){
      return (Double) getAttribute(PAttributeNames.M23);
    }
    public Double getM24(){
      return (Double) getAttribute(PAttributeNames.M24);
    }
    public Double getM31(){
      return (Double) getAttribute(PAttributeNames.M31);
    }
    public Double getM32(){
      return (Double) getAttribute(PAttributeNames.M32);
    }
    public Double getM33(){
      return (Double) getAttribute(PAttributeNames.M33);
    }
    public Double getM34(){
      return (Double) getAttribute(PAttributeNames.M34);
    }
    public Double getM41(){
      return (Double) getAttribute(PAttributeNames.M41);
    }
    public Double getM42(){
      return (Double) getAttribute(PAttributeNames.M42);
    }
    public Double getM43(){
      return (Double) getAttribute(PAttributeNames.M43);
    }
    public Double getM44(){
      return (Double) getAttribute(PAttributeNames.M44);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.DOM_MATRIX;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.DOM_MATRIX;
    }


    public PDOMMatrix fromFloat32Array(PFloat32Array array32) {
       return null;
    }


    public PDOMMatrix fromFloat64Array(PFloat64Array array64) {
       return null;
    }


    public PDOMMatrix fromMatrix() {
       return null;
    }


    public PDOMMatrix fromMatrix(PDOMMatrixInit other) {
       return null;
    }


    public PDOMMatrix invertSelf() {
       return null;
    }


    public PDOMMatrix multiplySelf() {
       return null;
    }


    public PDOMMatrix multiplySelf(PDOMMatrixInit other) {
       return null;
    }


    public PDOMMatrix preMultiplySelf() {
       return null;
    }


    public PDOMMatrix preMultiplySelf(PDOMMatrixInit other) {
       return null;
    }


    public PDOMMatrix rotateAxisAngleSelf() {
       return null;
    }


    public PDOMMatrix rotateAxisAngleSelf(Double x) {
       return null;
    }


    public PDOMMatrix rotateAxisAngleSelf(Double x, Double y) {
       return null;
    }


    public PDOMMatrix rotateAxisAngleSelf(Double x, Double y, Double z) {
       return null;
    }


    public PDOMMatrix rotateAxisAngleSelf(Double x, Double y, Double z, Double angle) {
       return null;
    }


    public PDOMMatrix rotateFromVectorSelf() {
       return null;
    }


    public PDOMMatrix rotateFromVectorSelf(Double x) {
       return null;
    }


    public PDOMMatrix rotateFromVectorSelf(Double x, Double y) {
       return null;
    }


    public PDOMMatrix rotateSelf() {
       return null;
    }


    public PDOMMatrix rotateSelf(Double rotX) {
       return null;
    }


    public PDOMMatrix rotateSelf(Double rotX, Double rotY) {
       return null;
    }


    public PDOMMatrix rotateSelf(Double rotX, Double rotY, Double rotZ) {
       return null;
    }


    public PDOMMatrix scale3dSelf() {
       return null;
    }


    public PDOMMatrix scale3dSelf(Double scale) {
       return null;
    }


    public PDOMMatrix scale3dSelf(Double scale, Double originX) {
       return null;
    }


    public PDOMMatrix scale3dSelf(Double scale, Double originX, Double originY) {
       return null;
    }


    public PDOMMatrix scale3dSelf(Double scale, Double originX, Double originY, Double originZ) {
       return null;
    }


    public PDOMMatrix scaleSelf() {
       return null;
    }


    public PDOMMatrix scaleSelf(Double scaleX) {
       return null;
    }


    public PDOMMatrix scaleSelf(Double scaleX, Double scaleY) {
       return null;
    }


    public PDOMMatrix scaleSelf(Double scaleX, Double scaleY, Double scaleZ) {
       return null;
    }


    public PDOMMatrix scaleSelf(Double scaleX, Double scaleY, Double scaleZ, Double originX) {
       return null;
    }


    public PDOMMatrix scaleSelf(Double scaleX, Double scaleY, Double scaleZ, Double originX, Double originY) {
       return null;
    }


    public PDOMMatrix scaleSelf(Double scaleX, Double scaleY, Double scaleZ, Double originX, Double originY, Double originZ) {
       return null;
    }


    public PDOMMatrix setMatrixValue(String transformList) {
       return null;
    }


    public PDOMMatrix skewXSelf() {
       return null;
    }


    public PDOMMatrix skewXSelf(Double sx) {
       return null;
    }


    public PDOMMatrix skewYSelf() {
       return null;
    }


    public PDOMMatrix skewYSelf(Double sy) {
       return null;
    }


    public PDOMMatrix translateSelf() {
       return null;
    }


    public PDOMMatrix translateSelf(Double tx) {
       return null;
    }


    public PDOMMatrix translateSelf(Double tx, Double ty) {
       return null;
    }


    public PDOMMatrix translateSelf(Double tx, Double ty, Double tz) {
       return null;
    }


    
}