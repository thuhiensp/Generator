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
public class PPasswordCredential extends PCredential {
    private static final Logger log = LoggerFactory.getLogger(PPasswordCredential.class);
    public PPasswordCredential(PPasswordCredentialData data){
      super(data);
    }

    public PPasswordCredential(PHTMLFormElement form){
      super(form);
    }


    public void setIdName(final String idName)  {
       setAttribute(PAttributeNames.ID_NAME, idName);
       log.info("idName" + idName);
    }
    public void setPasswordName(final String passwordName)  {
       setAttribute(PAttributeNames.PASSWORD_NAME, passwordName);
       log.info("passwordName" + passwordName);
    }
    public void setAdditionalData(final PCredentialBodyType additionalData)  {
       setAttribute(PAttributeNames.ADDITIONAL_DATA, additionalData);
       log.info("additionalData" + additionalData);
    }

    public String getIdName(){
      return (String) getAttribute(PAttributeNames.ID_NAME);
    }
    public String getPasswordName(){
      return (String) getAttribute(PAttributeNames.PASSWORD_NAME);
    }
    public PCredentialBodyType getAdditionalData(){
      return (PCredentialBodyType) getAttribute(PAttributeNames.ADDITIONAL_DATA);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.PASSWORD_CREDENTIAL;
    }


    
}