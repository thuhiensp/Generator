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
public class PTextTrack extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PTextTrack.class);
    private PTextTrack(){
    }

    public void setOncuechange(final PEventHandlerNonNull oncuechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCUECHANGE, new AttributeCallBack(oncuechange, atrsEventName));
       log.info("oncuechange" + oncuechange.getClass().getName());
    }
    public void setMode(final PTextTrackMode mode)  {
       setAttribute(PAttributeNames.MODE, mode);
       log.info("mode" + mode);
    }

    public PEventHandlerNonNull getOncuechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCUECHANGE);
    }
    public PTextTrackMode getMode(){
      return (PTextTrackMode) getAttribute(PAttributeNames.MODE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void addCue(PTextTrackCue cue){
    }

    public void removeCue(PTextTrackCue cue){
    }

    
}