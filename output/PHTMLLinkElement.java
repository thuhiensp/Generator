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
public class PHTMLLinkElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLLinkElement.class);
    public PHTMLLinkElement() {
    }

    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }
    public void setHref(final String href)  {
       setAttribute(PAttributeNames.HREF, href);
       log.info("href" + href);
    }
    public void setCrossOrigin(final String crossOrigin)  {
       setAttribute(PAttributeNames.CROSS_ORIGIN, crossOrigin);
       log.info("crossOrigin" + crossOrigin);
    }
    public void setRel(final String rel)  {
       setAttribute(PAttributeNames.REL, rel);
       log.info("rel" + rel);
    }
    public void setMedia(final String media)  {
       setAttribute(PAttributeNames.MEDIA, media);
       log.info("media" + media);
    }
    public void setHreflang(final String hreflang)  {
       setAttribute(PAttributeNames.HREFLANG, hreflang);
       log.info("hreflang" + hreflang);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setAs(final String as)  {
       setAttribute(PAttributeNames.AS, as);
       log.info("as" + as);
    }
    public void setReferrerPolicy(final String referrerPolicy)  {
       setAttribute(PAttributeNames.REFERRER_POLICY, referrerPolicy);
       log.info("referrerPolicy" + referrerPolicy);
    }
    public void setCharset(final String charset)  {
       setAttribute(PAttributeNames.CHARSET, charset);
       log.info("charset" + charset);
    }
    public void setRev(final String rev)  {
       setAttribute(PAttributeNames.REV, rev);
       log.info("rev" + rev);
    }
    public void setTarget(final String target)  {
       setAttribute(PAttributeNames.TARGET, target);
       log.info("target" + target);
    }
    public void setIntegrity(final String integrity)  {
       setAttribute(PAttributeNames.INTEGRITY, integrity);
       log.info("integrity" + integrity);
    }
    public void setScope(final String scope)  {
       setAttribute(PAttributeNames.SCOPE, scope);
       log.info("scope" + scope);
    }

    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }
    public String getHref(){
      return (String) getAttribute(PAttributeNames.HREF);
    }
    public String getCrossOrigin(){
      return (String) getAttribute(PAttributeNames.CROSS_ORIGIN);
    }
    public String getRel(){
      return (String) getAttribute(PAttributeNames.REL);
    }
    public String getMedia(){
      return (String) getAttribute(PAttributeNames.MEDIA);
    }
    public String getHreflang(){
      return (String) getAttribute(PAttributeNames.HREFLANG);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getAs(){
      return (String) getAttribute(PAttributeNames.AS);
    }
    public String getReferrerPolicy(){
      return (String) getAttribute(PAttributeNames.REFERRER_POLICY);
    }
    public String getCharset(){
      return (String) getAttribute(PAttributeNames.CHARSET);
    }
    public String getRev(){
      return (String) getAttribute(PAttributeNames.REV);
    }
    public String getTarget(){
      return (String) getAttribute(PAttributeNames.TARGET);
    }
    public String getIntegrity(){
      return (String) getAttribute(PAttributeNames.INTEGRITY);
    }
    public String getScope(){
      return (String) getAttribute(PAttributeNames.SCOPE);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_LINK_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}