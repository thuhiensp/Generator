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
public class PCacheStorage extends PObject2 {
    private PCacheStorage(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<Boolean> delete(String cacheName) {
       return null;
    }


    public PPromise<Boolean> has(String cacheName) {
       return null;
    }


    public PPromise<String[]> keys() {
       return null;
    }


    public PPromise<Object> match(PRequest request) {
       return null;
    }


    public PPromise<Object> match(String request) {
       return null;
    }


    public PPromise<Object> match(PRequest request, PCacheQueryOptions options) {
       return null;
    }


    public PPromise<Object> match(String request, PCacheQueryOptions options) {
       return null;
    }


    public PPromise<PCache> open(String cacheName) {
       return null;
    }


    
}