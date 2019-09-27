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
public class PAccessibleNodeList extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PAccessibleNodeList.class);
    public PAccessibleNodeList() {
    }


    public PAccessibleNodeList(PAccessibleNode[] nodes){
      super(nodes);
    }


    public void setLength(final Double length)  {
       setAttribute(PAttributeNames.LENGTH_DOUBLE, length);
       log.info("length" + length);
    }

    public Double getLength(){
      return (Double) getAttribute(PAttributeNames.LENGTH_DOUBLE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.ACCESSIBLE_NODE_LIST;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.ACCESSIBLE_NODE_LIST;
    }


    public void add(PAccessibleNode node){
    }

    public void add(PAccessibleNode node, PAccessibleNode before){
    }

    public PAccessibleNode get(Double index) {
       return null;
    }


    public PAccessibleNode item(Double index) {
       return null;
    }


    public void remove(Double index){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index});
       writer.endObject();
    }

    public void set(Double index, PAccessibleNode node){
    }

    
}