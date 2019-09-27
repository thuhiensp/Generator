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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PDOMQuad extends PObject2 {
    public PDOMQuad() {
    }


    public PDOMQuad(PDOMPointInit p1){
      super(p1);
    }

    public PDOMQuad(PDOMPointInit p1, PDOMPointInit p2){
      super(p1, p2);
    }

    public PDOMQuad(PDOMPointInit p1, PDOMPointInit p2, PDOMPointInit p3){
      super(p1, p2, p3);
    }

    public PDOMQuad(PDOMPointInit p1, PDOMPointInit p2, PDOMPointInit p3, PDOMPointInit p4){
      super(p1, p2, p3, p4);
    }




    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.DOM_QUAD;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.DOM_QUAD;
    }


    public PDOMQuad fromQuad() {
       return null;
    }


    public PDOMQuad fromQuad(PDOMQuadInit other) {
       return null;
    }


    public PDOMQuad fromRect() {
       return null;
    }


    public PDOMQuad fromRect(PDOMRectInit other) {
       return null;
    }


    public PDOMRect getBounds() {
       return null;
    }


    
}