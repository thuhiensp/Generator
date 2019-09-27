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
public class PCSSTranslation extends PCSSTransformComponent {
    private static final Logger log = LoggerFactory.getLogger(PCSSTranslation.class);
    public PCSSTranslation(PCSSNumericValue x, PCSSNumericValue y){
      super(x, y);
    }

    public PCSSTranslation(PCSSNumericValue x, PCSSNumericValue y, PCSSNumericValue z){
      super(x, y, z);
    }


    public void setX(final PCSSNumericValue x)  {
       setAttribute(PAttributeNames.X_POBJECT2, x);
       log.info("x" + x);
    }
    public void setY(final PCSSNumericValue y)  {
       setAttribute(PAttributeNames.Y_POBJECT2, y);
       log.info("y" + y);
    }
    public void setZ(final PCSSNumericValue z)  {
       setAttribute(PAttributeNames.Z_POBJECT2, z);
       log.info("z" + z);
    }

    public PCSSNumericValue getX(){
      return (PCSSNumericValue) getAttribute(PAttributeNames.X_POBJECT2);
    }
    public PCSSNumericValue getY(){
      return (PCSSNumericValue) getAttribute(PAttributeNames.Y_POBJECT2);
    }
    public PCSSNumericValue getZ(){
      return (PCSSNumericValue) getAttribute(PAttributeNames.Z_POBJECT2);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.CSS_TRANSLATION;
    }


    
}