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
import com.ponysdk.core.ui2.PEventAttributesName;
import java.util.Map;
public class PSecurityPolicyViolationEvent extends PEvent {
    public PSecurityPolicyViolationEvent(final Map<PEventAttributesName, Object> mapValueByAttributeName){
       super(mapValueByAttributeName);
    }

    public Object getDocumentURI(){
      return get(PEventAttributesName.DOCUMENTURI);
    }
    public Object getReferrer(){
      return get(PEventAttributesName.REFERRER);
    }
    public Object getBlockedURI(){
      return get(PEventAttributesName.BLOCKEDURI);
    }
    public Object getViolatedDirective(){
      return get(PEventAttributesName.VIOLATED_DIRECTIVE);
    }
    public Object getEffectiveDirective(){
      return get(PEventAttributesName.EFFECTIVE_DIRECTIVE);
    }
    public Object getOriginalPolicy(){
      return get(PEventAttributesName.ORIGINAL_POLICY);
    }
    public Object getSourceFile(){
      return get(PEventAttributesName.SOURCE_FILE);
    }
    public Object getStatusCode(){
      return get(PEventAttributesName.STATUS_CODE);
    }
    public Object getLineNumber(){
      return get(PEventAttributesName.LINE_NUMBER);
    }
    public Object getColumnNumber(){
      return get(PEventAttributesName.COLUMN_NUMBER);
    }
    public Object getSample(){
      return get(PEventAttributesName.SAMPLE);
    }
    public PSecurityPolicyViolationEventDisposition getDisposition(){
      return (PSecurityPolicyViolationEventDisposition) get(PEventAttributesName.DISPOSITION);
    }



}