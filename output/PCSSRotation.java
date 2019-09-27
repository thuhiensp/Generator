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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PCSSRotation extends PCSSTransformComponent {
    private static final Logger log = LoggerFactory.getLogger(PCSSRotation.class);
    public PCSSRotation(PCSSNumericValue angleValue){
      super(angleValue);
    }

    public PCSSRotation(Double x, Double y, Double z, PCSSNumericValue angle){
      super(x, y, z, angle);
    }


    public void setAngle(final PCSSNumericValue angle)  {
       setAttribute(PAttributeNames.ANGLE, angle);
       log.info("angle" + angle);
    }
    public void setX(final Double x)  {
       setAttribute(PAttributeNames.X_DOUBLE, x);
       log.info("x" + x);
    }
    public void setY(final Double y)  {
       setAttribute(PAttributeNames.Y_DOUBLE, y);
       log.info("y" + y);
    }
    public void setZ(final Double z)  {
       setAttribute(PAttributeNames.Z_DOUBLE, z);
       log.info("z" + z);
    }

    public PCSSNumericValue getAngle(){
      return (PCSSNumericValue) getAttribute(PAttributeNames.ANGLE);
    }
    public Double getX(){
      return (Double) getAttribute(PAttributeNames.X_DOUBLE);
    }
    public Double getY(){
      return (Double) getAttribute(PAttributeNames.Y_DOUBLE);
    }
    public Double getZ(){
      return (Double) getAttribute(PAttributeNames.Z_DOUBLE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.CSS_ROTATION;
    }


    
}