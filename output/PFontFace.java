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
public class PFontFace extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PFontFace.class);
    public PFontFace(String family, String source){
      super(family, source);
    }

    public PFontFace(String family, String source, PFontFaceDescriptors descriptors){
      super(family, source, descriptors);
    }

    public PFontFace(String family, PArrayBuffer source){
      super(family, source);
    }

    public PFontFace(String family, PArrayBuffer source, PFontFaceDescriptors descriptors){
      super(family, source, descriptors);
    }

    public PFontFace(String family, PArrayBufferView source){
      super(family, source);
    }

    public PFontFace(String family, PArrayBufferView source, PFontFaceDescriptors descriptors){
      super(family, source, descriptors);
    }


    public void setFamily(final String family)  {
       setAttribute(PAttributeNames.FAMILY, family);
       log.info("family" + family);
    }
    public void setStyle(final String style)  {
       setAttribute(PAttributeNames.STYLE, style);
       log.info("style" + style);
    }
    public void setWeight(final String weight)  {
       setAttribute(PAttributeNames.WEIGHT_STRING, weight);
       log.info("weight" + weight);
    }
    public void setStretch(final String stretch)  {
       setAttribute(PAttributeNames.STRETCH, stretch);
       log.info("stretch" + stretch);
    }
    public void setUnicodeRange(final String unicodeRange)  {
       setAttribute(PAttributeNames.UNICODE_RANGE, unicodeRange);
       log.info("unicodeRange" + unicodeRange);
    }
    public void setVariant(final String variant)  {
       setAttribute(PAttributeNames.VARIANT, variant);
       log.info("variant" + variant);
    }
    public void setFeatureSettings(final String featureSettings)  {
       setAttribute(PAttributeNames.FEATURE_SETTINGS, featureSettings);
       log.info("featureSettings" + featureSettings);
    }
    public void setDisplay(final String display)  {
       setAttribute(PAttributeNames.DISPLAY, display);
       log.info("display" + display);
    }

    public String getFamily(){
      return (String) getAttribute(PAttributeNames.FAMILY);
    }
    public String getStyle(){
      return (String) getAttribute(PAttributeNames.STYLE);
    }
    public String getWeight(){
      return (String) getAttribute(PAttributeNames.WEIGHT_STRING);
    }
    public String getStretch(){
      return (String) getAttribute(PAttributeNames.STRETCH);
    }
    public String getUnicodeRange(){
      return (String) getAttribute(PAttributeNames.UNICODE_RANGE);
    }
    public String getVariant(){
      return (String) getAttribute(PAttributeNames.VARIANT);
    }
    public String getFeatureSettings(){
      return (String) getAttribute(PAttributeNames.FEATURE_SETTINGS);
    }
    public String getDisplay(){
      return (String) getAttribute(PAttributeNames.DISPLAY);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.FONT_FACE;
    }


    public PPromise<PFontFace> load() {
       return null;
    }


    
}