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
public abstract class PCSSRule extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PCSSRule.class);
     protected PCSSRule() {
     }
    protected PCSSRule(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setCssText(final String cssText)  {
       setAttribute(PAttributeNames.CSS_TEXT, cssText);
       log.info("cssText" + cssText);
    }

    public String getCssText(){
      return (String) getAttribute(PAttributeNames.CSS_TEXT);
    }


    
}