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
public class PCSSUnitValue extends PCSSNumericValue {
    private static final Logger log = LoggerFactory.getLogger(PCSSUnitValue.class);
    public PCSSUnitValue(Double value, String unit){
      super(value, unit);
    }


    public void setValue(final Double value)  {
       setAttribute(PAttributeNames.VALUE_DOUBLE, value);
       log.info("value" + value);
    }
    public void setUnit(final String unit)  {
       setAttribute(PAttributeNames.UNIT, unit);
       log.info("unit" + unit);
    }

    public Double getValue(){
      return (Double) getAttribute(PAttributeNames.VALUE_DOUBLE);
    }
    public String getUnit(){
      return (String) getAttribute(PAttributeNames.UNIT);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.CSS_UNIT_VALUE;
    }


    
}