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
public class PSVGLength extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PSVGLength.class);
    private PSVGLength(){
    }

    public void setValue(final Double value)  {
       setAttribute(PAttributeNames.VALUE_DOUBLE, value);
       log.info("value" + value);
    }
    public void setValueInSpecifiedUnits(final Double valueInSpecifiedUnits)  {
       setAttribute(PAttributeNames.VALUE_IN_SPECIFIED_UNITS, valueInSpecifiedUnits);
       log.info("valueInSpecifiedUnits" + valueInSpecifiedUnits);
    }
    public void setValueAsString(final String valueAsString)  {
       setAttribute(PAttributeNames.VALUE_AS_STRING, valueAsString);
       log.info("valueAsString" + valueAsString);
    }

    public Double getValue(){
      return (Double) getAttribute(PAttributeNames.VALUE_DOUBLE);
    }
    public Double getValueInSpecifiedUnits(){
      return (Double) getAttribute(PAttributeNames.VALUE_IN_SPECIFIED_UNITS);
    }
    public String getValueAsString(){
      return (String) getAttribute(PAttributeNames.VALUE_AS_STRING);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void convertToSpecifiedUnits(Short unitType){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CONVERT_TO_SPECIFIED_UNITS_TYPESHORT_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {unitType});
       writer.endObject();
    }

    public void newValueSpecifiedUnits(Short unitType, Double valueInSpecifiedUnits){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       NEW_VALUE_SPECIFIED_UNITS_TYPESHORT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {unitType,valueInSpecifiedUnits});
       writer.endObject();
    }

    
}