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
public class PSVGMatrix extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PSVGMatrix.class);
    private PSVGMatrix(){
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

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PSVGMatrix flipX() {
       return null;
    }


    public PSVGMatrix flipY() {
       return null;
    }


    public PSVGMatrix inverse() {
       return null;
    }


    public PSVGMatrix multiply(PSVGMatrix secondMatrix) {
       return null;
    }


    public PSVGMatrix rotate(Double angle) {
       return null;
    }


    public PSVGMatrix rotateFromVector(Double x, Double y) {
       return null;
    }


    public PSVGMatrix scale(Double scaleFactor) {
       return null;
    }


    public PSVGMatrix scaleNonUniform(Double scaleFactorX, Double scaleFactorY) {
       return null;
    }


    public PSVGMatrix skewX(Double angle) {
       return null;
    }


    public PSVGMatrix skewY(Double angle) {
       return null;
    }


    public PSVGMatrix translate(Double x, Double y) {
       return null;
    }


    
}