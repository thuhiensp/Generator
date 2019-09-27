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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PXPathEvaluator extends PObject2 {
    public PXPathEvaluator() {
    }





    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.X_PATH_EVALUATOR;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PXPathExpression createExpression(String expression) {
       return null;
    }


    public PXPathExpression createExpression(String expression, PXPathNSResolver resolver) {
       return null;
    }


    public PXPathNSResolver createNSResolver(PNode nodeResolver) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode, PXPathNSResolver resolver) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode, PXPathNSResolver resolver, Short type) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode, PXPathNSResolver resolver, Short type, Object inResult) {
       return null;
    }


    
}