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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PVTTRegion extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PVTTRegion.class);
    public PVTTRegion() {
    }



    public void setWidth(final Double width)  {
       setAttribute(PAttributeNames.WIDTH_DOUBLE, width);
       log.info("width" + width);
    }
    public void setLines(final Double lines)  {
       setAttribute(PAttributeNames.LINES, lines);
       log.info("lines" + lines);
    }
    public void setRegionAnchorX(final Double regionAnchorX)  {
       setAttribute(PAttributeNames.REGION_ANCHORX, regionAnchorX);
       log.info("regionAnchorX" + regionAnchorX);
    }
    public void setRegionAnchorY(final Double regionAnchorY)  {
       setAttribute(PAttributeNames.REGION_ANCHORY, regionAnchorY);
       log.info("regionAnchorY" + regionAnchorY);
    }
    public void setViewportAnchorX(final Double viewportAnchorX)  {
       setAttribute(PAttributeNames.VIEWPORT_ANCHORX, viewportAnchorX);
       log.info("viewportAnchorX" + viewportAnchorX);
    }
    public void setViewportAnchorY(final Double viewportAnchorY)  {
       setAttribute(PAttributeNames.VIEWPORT_ANCHORY, viewportAnchorY);
       log.info("viewportAnchorY" + viewportAnchorY);
    }
    public void setScroll(final PScrollSetting scroll)  {
       setAttribute(PAttributeNames.SCROLL, scroll);
       log.info("scroll" + scroll);
    }

    public Double getWidth(){
      return (Double) getAttribute(PAttributeNames.WIDTH_DOUBLE);
    }
    public Double getLines(){
      return (Double) getAttribute(PAttributeNames.LINES);
    }
    public Double getRegionAnchorX(){
      return (Double) getAttribute(PAttributeNames.REGION_ANCHORX);
    }
    public Double getRegionAnchorY(){
      return (Double) getAttribute(PAttributeNames.REGION_ANCHORY);
    }
    public Double getViewportAnchorX(){
      return (Double) getAttribute(PAttributeNames.VIEWPORT_ANCHORX);
    }
    public Double getViewportAnchorY(){
      return (Double) getAttribute(PAttributeNames.VIEWPORT_ANCHORY);
    }
    public PScrollSetting getScroll(){
      return (PScrollSetting) getAttribute(PAttributeNames.SCROLL);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.VTT_REGION;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}