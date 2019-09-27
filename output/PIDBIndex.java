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
public class PIDBIndex extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PIDBIndex.class);
    private PIDBIndex(){
    }

    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }

    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PIDBRequest count() {
       return null;
    }


    public PIDBRequest count(Object key) {
       return null;
    }


    public PIDBRequest get(Object key) {
       return null;
    }


    public PIDBRequest getAll() {
       return null;
    }


    public PIDBRequest getAll(Object query) {
       return null;
    }


    public PIDBRequest getAll(Object query, Double count) {
       return null;
    }


    public PIDBRequest getAllKeys() {
       return null;
    }


    public PIDBRequest getAllKeys(Object query) {
       return null;
    }


    public PIDBRequest getAllKeys(Object query, Double count) {
       return null;
    }


    public PIDBRequest getKey(Object key) {
       return null;
    }


    public PIDBRequest openCursor() {
       return null;
    }


    public PIDBRequest openCursor(Object range) {
       return null;
    }


    public PIDBRequest openCursor(Object range, PIDBCursorDirection direction) {
       return null;
    }


    public PIDBRequest openCursor(Object range, String direction) {
       return null;
    }


    public PIDBRequest openKeyCursor() {
       return null;
    }


    public PIDBRequest openKeyCursor(Object range) {
       return null;
    }


    public PIDBRequest openKeyCursor(Object range, PIDBCursorDirection direction) {
       return null;
    }


    public PIDBRequest openKeyCursor(Object range, String direction) {
       return null;
    }


    
}