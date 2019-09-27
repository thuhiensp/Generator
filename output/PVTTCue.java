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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PVTTCue extends PTextTrackCue {
    private static final Logger log = LoggerFactory.getLogger(PVTTCue.class);
    public PVTTCue(Double startTime, Double endTime, String text){
      super(startTime, endTime, text);
    }


    public void setRegion(final PVTTRegion region)  {
       setAttribute(PAttributeNames.REGION, region);
       log.info("region" + region);
    }
    public void setSnapToLines(final Boolean snapToLines)  {
       setAttribute(PAttributeNames.SNAP_TO_LINES, snapToLines);
       log.info("snapToLines" + snapToLines);
    }
    public void setLine(final PDoubleOrString line)  {
       setAttribute(PAttributeNames.LINE, line);
       log.info("line" + line);
    }
    public void setPosition(final PDoubleOrString position)  {
       setAttribute(PAttributeNames.POSITION, position);
       log.info("position" + position);
    }
    public void setSize(final Double size)  {
       setAttribute(PAttributeNames.SIZE_DOUBLE, size);
       log.info("size" + size);
    }
    public void setText(final String text)  {
       setAttribute(PAttributeNames.TEXT, text);
       log.info("text" + text);
    }
    public void setVertical(final PDirectionSetting vertical)  {
       setAttribute(PAttributeNames.VERTICAL, vertical);
       log.info("vertical" + vertical);
    }
    public void setAlign(final PAlignSetting align)  {
       setAttribute(PAttributeNames.ALIGN_PENUM, align);
       log.info("align" + align);
    }

    public PVTTRegion getRegion(){
      return (PVTTRegion) getAttribute(PAttributeNames.REGION);
    }
    public Boolean getSnapToLines(){
      return (Boolean) getAttribute(PAttributeNames.SNAP_TO_LINES);
    }
    public PDoubleOrString getLine(){
      return (PDoubleOrString) getAttribute(PAttributeNames.LINE);
    }
    public PDoubleOrString getPosition(){
      return (PDoubleOrString) getAttribute(PAttributeNames.POSITION);
    }
    public Double getSize(){
      return (Double) getAttribute(PAttributeNames.SIZE_DOUBLE);
    }
    public String getText(){
      return (String) getAttribute(PAttributeNames.TEXT);
    }
    public PDirectionSetting getVertical(){
      return (PDirectionSetting) getAttribute(PAttributeNames.VERTICAL);
    }
    public PAlignSetting getAlign(){
      return (PAlignSetting) getAttribute(PAttributeNames.ALIGN_PENUM);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.VTT_CUE;
    }


    public PDocumentFragment getCueAsHTML() {
       return null;
    }


    
}