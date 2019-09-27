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
public class PNamedNodeMap extends PObject2 {
    private PNamedNodeMap(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PAttr get(Double index) {
       return null;
    }


    public PAttr get(String name) {
       return null;
    }


    public PAttr getNamedItem(String name) {
       return null;
    }


    public PAttr getNamedItemNS(String namespaceURI, String localName) {
       return null;
    }


    public PAttr item(Double index) {
       return null;
    }


    public PAttr removeNamedItem(String name) {
       return null;
    }


    public PAttr removeNamedItemNS(String namespaceURI, String localName) {
       return null;
    }


    public PAttr setNamedItem(PAttr attr) {
       return null;
    }


    public PAttr setNamedItemNS(PAttr attr) {
       return null;
    }


    
}