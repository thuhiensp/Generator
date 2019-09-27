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
public class PRTCIceCandidate extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PRTCIceCandidate.class);
    public PRTCIceCandidate(PRTCIceCandidateInit candidateInitDict){
      super(candidateInitDict);
    }


    public void setCandidate(final String candidate)  {
       setAttribute(PAttributeNames.CANDIDATE, candidate);
       log.info("candidate" + candidate);
    }
    public void setSdpMid(final String sdpMid)  {
       setAttribute(PAttributeNames.SDP_MID, sdpMid);
       log.info("sdpMid" + sdpMid);
    }
    public void setSdpMLineIndex(final Short sdpMLineIndex)  {
       setAttribute(PAttributeNames.SDPM_LINE_INDEX, sdpMLineIndex);
       log.info("sdpMLineIndex" + sdpMLineIndex);
    }

    public String getCandidate(){
      return (String) getAttribute(PAttributeNames.CANDIDATE);
    }
    public String getSdpMid(){
      return (String) getAttribute(PAttributeNames.SDP_MID);
    }
    public Short getSdpMLineIndex(){
      return (Short) getAttribute(PAttributeNames.SDPM_LINE_INDEX);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.RTC_ICE_CANDIDATE;
    }


    
}