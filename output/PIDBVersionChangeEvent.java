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
public class PIDBVersionChangeEvent extends PEvent {
    public PIDBVersionChangeEvent(final Map<PEventAttributesName, Object> mapValueByAttributeName){
       super(mapValueByAttributeName);
    }

    public Object getOldVersion(){
      return get(PEventAttributesName.OLD_VERSION);
    }
    public Object getNewVersion(){
      return get(PEventAttributesName.NEW_VERSION);
    }
    public Object getDataLossMessage(){
      return get(PEventAttributesName.DATA_LOSS_MESSAGE);
    }
    public PIDBDataLossAmount getDataLoss(){
      return (PIDBDataLossAmount) get(PEventAttributesName.DATA_LOSS);
    }



}