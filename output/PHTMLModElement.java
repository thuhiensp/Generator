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
public abstract class PHTMLModElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLModElement.class);
    public void setCite(final String cite)  {
       setAttribute(PAttributeNames.CITE, cite);
       log.info("cite" + cite);
    }
    public void setDateTime(final String dateTime)  {
       setAttribute(PAttributeNames.DATE_TIME, dateTime);
       log.info("dateTime" + dateTime);
    }

    public String getCite(){
      return (String) getAttribute(PAttributeNames.CITE);
    }
    public String getDateTime(){
      return (String) getAttribute(PAttributeNames.DATE_TIME);
    }


    
}