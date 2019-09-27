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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PHTMLImageElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLImageElement.class);
    public PHTMLImageElement() {
    }


    public PHTMLImageElement(Double width){
      super(width);
    }

    public PHTMLImageElement(Double width, Double height){
      super(width, height);
    }


    public void setAlt(final String alt)  {
       setAttribute(PAttributeNames.ALT, alt);
       log.info("alt" + alt);
    }
    public void setSrc(final String src)  {
       setAttribute(PAttributeNames.SRC, src);
       log.info("src" + src);
    }
    public void setSrcset(final String srcset)  {
       setAttribute(PAttributeNames.SRCSET, srcset);
       log.info("srcset" + srcset);
    }
    public void setSizes(final String sizes)  {
       setAttribute(PAttributeNames.SIZES, sizes);
       log.info("sizes" + sizes);
    }
    public void setCrossOrigin(final String crossOrigin)  {
       setAttribute(PAttributeNames.CROSS_ORIGIN, crossOrigin);
       log.info("crossOrigin" + crossOrigin);
    }
    public void setUseMap(final String useMap)  {
       setAttribute(PAttributeNames.USE_MAP, useMap);
       log.info("useMap" + useMap);
    }
    public void setIsMap(final Boolean isMap)  {
       setAttribute(PAttributeNames.IS_MAP, isMap);
       log.info("isMap" + isMap);
    }
    public void setWidth(final Double width)  {
       setAttribute(PAttributeNames.WIDTH_DOUBLE, width);
       log.info("width" + width);
    }
    public void setHeight(final Double height)  {
       setAttribute(PAttributeNames.HEIGHT_DOUBLE, height);
       log.info("height" + height);
    }
    public void setReferrerPolicy(final String referrerPolicy)  {
       setAttribute(PAttributeNames.REFERRER_POLICY, referrerPolicy);
       log.info("referrerPolicy" + referrerPolicy);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setLowsrc(final String lowsrc)  {
       setAttribute(PAttributeNames.LOWSRC, lowsrc);
       log.info("lowsrc" + lowsrc);
    }
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setHspace(final Double hspace)  {
       setAttribute(PAttributeNames.HSPACE, hspace);
       log.info("hspace" + hspace);
    }
    public void setVspace(final Double vspace)  {
       setAttribute(PAttributeNames.VSPACE, vspace);
       log.info("vspace" + vspace);
    }
    public void setLongDesc(final String longDesc)  {
       setAttribute(PAttributeNames.LONG_DESC, longDesc);
       log.info("longDesc" + longDesc);
    }
    public void setBorder(final String border)  {
       setAttribute(PAttributeNames.BORDER, border);
       log.info("border" + border);
    }

    public String getAlt(){
      return (String) getAttribute(PAttributeNames.ALT);
    }
    public String getSrc(){
      return (String) getAttribute(PAttributeNames.SRC);
    }
    public String getSrcset(){
      return (String) getAttribute(PAttributeNames.SRCSET);
    }
    public String getSizes(){
      return (String) getAttribute(PAttributeNames.SIZES);
    }
    public String getCrossOrigin(){
      return (String) getAttribute(PAttributeNames.CROSS_ORIGIN);
    }
    public String getUseMap(){
      return (String) getAttribute(PAttributeNames.USE_MAP);
    }
    public Boolean getIsMap(){
      return (Boolean) getAttribute(PAttributeNames.IS_MAP);
    }
    public Double getWidth(){
      return (Double) getAttribute(PAttributeNames.WIDTH_DOUBLE);
    }
    public Double getHeight(){
      return (Double) getAttribute(PAttributeNames.HEIGHT_DOUBLE);
    }
    public String getReferrerPolicy(){
      return (String) getAttribute(PAttributeNames.REFERRER_POLICY);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getLowsrc(){
      return (String) getAttribute(PAttributeNames.LOWSRC);
    }
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public Double getHspace(){
      return (Double) getAttribute(PAttributeNames.HSPACE);
    }
    public Double getVspace(){
      return (Double) getAttribute(PAttributeNames.VSPACE);
    }
    public String getLongDesc(){
      return (String) getAttribute(PAttributeNames.LONG_DESC);
    }
    public String getBorder(){
      return (String) getAttribute(PAttributeNames.BORDER);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_IMAGE_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.HTML_IMAGE_ELEMENT;
    }


    public PPromise decode() {
       return null;
    }


    
}