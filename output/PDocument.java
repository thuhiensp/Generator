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
public abstract class PDocument extends PNode {
    private static final Logger log = LoggerFactory.getLogger(PDocument.class);
     protected PDocument() {
     }
    protected PDocument(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setRootScroller(final PElement rootScroller)  {
       setAttribute(PAttributeNames.ROOT_SCROLLER, rootScroller);
       log.info("rootScroller" + rootScroller);
    }
    public void setXmlVersion(final String xmlVersion)  {
       setAttribute(PAttributeNames.XML_VERSION, xmlVersion);
       log.info("xmlVersion" + xmlVersion);
    }
    public void setXmlStandalone(final Boolean xmlStandalone)  {
       setAttribute(PAttributeNames.XML_STANDALONE, xmlStandalone);
       log.info("xmlStandalone" + xmlStandalone);
    }
    public void setDomain(final String domain)  {
       setAttribute(PAttributeNames.DOMAIN, domain);
       log.info("domain" + domain);
    }
    public void setCookie(final String cookie)  {
       setAttribute(PAttributeNames.COOKIE, cookie);
       log.info("cookie" + cookie);
    }
    public void setTitle(final String title)  {
       setAttribute(PAttributeNames.TITLE, title);
       log.info("title" + title);
    }
    public void setDir(final String dir)  {
       setAttribute(PAttributeNames.DIR, dir);
       log.info("dir" + dir);
    }
    public void setBody(final PHTMLElement body)  {
       setAttribute(PAttributeNames.BODY, body);
       log.info("body" + body);
    }
    public void setDesignMode(final String designMode)  {
       setAttribute(PAttributeNames.DESIGN_MODE, designMode);
       log.info("designMode" + designMode);
    }
    public void setOnreadystatechange(final PEventHandlerNonNull onreadystatechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREADYSTATECHANGE, new AttributeCallBack(onreadystatechange, atrsEventName));
       log.info("onreadystatechange" + onreadystatechange.getClass().getName());
    }
    public void setSelectedStylesheetSet(final String selectedStylesheetSet)  {
       setAttribute(PAttributeNames.SELECTED_STYLESHEET_SET, selectedStylesheetSet);
       log.info("selectedStylesheetSet" + selectedStylesheetSet);
    }
    public void setOnpointerlockchange(final PEventHandlerNonNull onpointerlockchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERLOCKCHANGE, new AttributeCallBack(onpointerlockchange, atrsEventName));
       log.info("onpointerlockchange" + onpointerlockchange.getClass().getName());
    }
    public void setOnpointerlockerror(final PEventHandlerNonNull onpointerlockerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERLOCKERROR, new AttributeCallBack(onpointerlockerror, atrsEventName));
       log.info("onpointerlockerror" + onpointerlockerror.getClass().getName());
    }
    public void setOnbeforecopy(final PEventHandlerNonNull onbeforecopy, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEFORECOPY, new AttributeCallBack(onbeforecopy, atrsEventName));
       log.info("onbeforecopy" + onbeforecopy.getClass().getName());
    }
    public void setOnbeforecut(final PEventHandlerNonNull onbeforecut, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEFORECUT, new AttributeCallBack(onbeforecut, atrsEventName));
       log.info("onbeforecut" + onbeforecut.getClass().getName());
    }
    public void setOnbeforepaste(final PEventHandlerNonNull onbeforepaste, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEFOREPASTE, new AttributeCallBack(onbeforepaste, atrsEventName));
       log.info("onbeforepaste" + onbeforepaste.getClass().getName());
    }
    public void setOncopy(final PEventHandlerNonNull oncopy, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCOPY, new AttributeCallBack(oncopy, atrsEventName));
       log.info("oncopy" + oncopy.getClass().getName());
    }
    public void setOncut(final PEventHandlerNonNull oncut, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCUT, new AttributeCallBack(oncut, atrsEventName));
       log.info("oncut" + oncut.getClass().getName());
    }
    public void setOnpaste(final PEventHandlerNonNull onpaste, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPASTE, new AttributeCallBack(onpaste, atrsEventName));
       log.info("onpaste" + onpaste.getClass().getName());
    }
    public void setOnsearch(final PEventHandlerNonNull onsearch, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSEARCH, new AttributeCallBack(onsearch, atrsEventName));
       log.info("onsearch" + onsearch.getClass().getName());
    }
    public void setOnsecuritypolicyviolation(final PEventHandlerNonNull onsecuritypolicyviolation, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSECURITYPOLICYVIOLATION, new AttributeCallBack(onsecuritypolicyviolation, atrsEventName));
       log.info("onsecuritypolicyviolation" + onsecuritypolicyviolation.getClass().getName());
    }
    public void setOnselectionchange(final PEventHandlerNonNull onselectionchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSELECTIONCHANGE, new AttributeCallBack(onselectionchange, atrsEventName));
       log.info("onselectionchange" + onselectionchange.getClass().getName());
    }
    public void setOnselectstart(final PEventHandlerNonNull onselectstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSELECTSTART, new AttributeCallBack(onselectstart, atrsEventName));
       log.info("onselectstart" + onselectstart.getClass().getName());
    }
    public void setOnwheel(final PEventHandlerNonNull onwheel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWHEEL, new AttributeCallBack(onwheel, atrsEventName));
       log.info("onwheel" + onwheel.getClass().getName());
    }
    public void setOnfullscreenchange(final PEventHandlerNonNull onfullscreenchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONFULLSCREENCHANGE, new AttributeCallBack(onfullscreenchange, atrsEventName));
       log.info("onfullscreenchange" + onfullscreenchange.getClass().getName());
    }
    public void setOnfullscreenerror(final PEventHandlerNonNull onfullscreenerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONFULLSCREENERROR, new AttributeCallBack(onfullscreenerror, atrsEventName));
       log.info("onfullscreenerror" + onfullscreenerror.getClass().getName());
    }
    public void setOnwebkitfullscreenchange(final PEventHandlerNonNull onwebkitfullscreenchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWEBKITFULLSCREENCHANGE, new AttributeCallBack(onwebkitfullscreenchange, atrsEventName));
       log.info("onwebkitfullscreenchange" + onwebkitfullscreenchange.getClass().getName());
    }
    public void setOnwebkitfullscreenerror(final PEventHandlerNonNull onwebkitfullscreenerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWEBKITFULLSCREENERROR, new AttributeCallBack(onwebkitfullscreenerror, atrsEventName));
       log.info("onwebkitfullscreenerror" + onwebkitfullscreenerror.getClass().getName());
    }
    public void setOnabort(final PEventHandlerNonNull onabort, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONABORT, new AttributeCallBack(onabort, atrsEventName));
       log.info("onabort" + onabort.getClass().getName());
    }
    public void setOnblur(final PEventHandlerNonNull onblur, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBLUR, new AttributeCallBack(onblur, atrsEventName));
       log.info("onblur" + onblur.getClass().getName());
    }
    public void setOncancel(final PEventHandlerNonNull oncancel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCANCEL, new AttributeCallBack(oncancel, atrsEventName));
       log.info("oncancel" + oncancel.getClass().getName());
    }
    public void setOncanplay(final PEventHandlerNonNull oncanplay, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCANPLAY, new AttributeCallBack(oncanplay, atrsEventName));
       log.info("oncanplay" + oncanplay.getClass().getName());
    }
    public void setOncanplaythrough(final PEventHandlerNonNull oncanplaythrough, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCANPLAYTHROUGH, new AttributeCallBack(oncanplaythrough, atrsEventName));
       log.info("oncanplaythrough" + oncanplaythrough.getClass().getName());
    }
    public void setOnchange(final PEventHandlerNonNull onchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCHANGE, new AttributeCallBack(onchange, atrsEventName));
       log.info("onchange" + onchange.getClass().getName());
    }
    public void setOnclick(final PEventHandlerNonNull onclick, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLICK, new AttributeCallBack(onclick, atrsEventName));
       log.info("onclick" + onclick.getClass().getName());
    }
    public void setOnclose(final PEventHandlerNonNull onclose, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCLOSE, new AttributeCallBack(onclose, atrsEventName));
       log.info("onclose" + onclose.getClass().getName());
    }
    public void setOncontextmenu(final PEventHandlerNonNull oncontextmenu, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCONTEXTMENU, new AttributeCallBack(oncontextmenu, atrsEventName));
       log.info("oncontextmenu" + oncontextmenu.getClass().getName());
    }
    public void setOncuechange(final PEventHandlerNonNull oncuechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONCUECHANGE, new AttributeCallBack(oncuechange, atrsEventName));
       log.info("oncuechange" + oncuechange.getClass().getName());
    }
    public void setOndblclick(final PEventHandlerNonNull ondblclick, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDBLCLICK, new AttributeCallBack(ondblclick, atrsEventName));
       log.info("ondblclick" + ondblclick.getClass().getName());
    }
    public void setOndrag(final PEventHandlerNonNull ondrag, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDRAG, new AttributeCallBack(ondrag, atrsEventName));
       log.info("ondrag" + ondrag.getClass().getName());
    }
    public void setOndragend(final PEventHandlerNonNull ondragend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDRAGEND, new AttributeCallBack(ondragend, atrsEventName));
       log.info("ondragend" + ondragend.getClass().getName());
    }
    public void setOndragenter(final PEventHandlerNonNull ondragenter, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDRAGENTER, new AttributeCallBack(ondragenter, atrsEventName));
       log.info("ondragenter" + ondragenter.getClass().getName());
    }
    public void setOndragleave(final PEventHandlerNonNull ondragleave, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDRAGLEAVE, new AttributeCallBack(ondragleave, atrsEventName));
       log.info("ondragleave" + ondragleave.getClass().getName());
    }
    public void setOndragover(final PEventHandlerNonNull ondragover, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDRAGOVER, new AttributeCallBack(ondragover, atrsEventName));
       log.info("ondragover" + ondragover.getClass().getName());
    }
    public void setOndragstart(final PEventHandlerNonNull ondragstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDRAGSTART, new AttributeCallBack(ondragstart, atrsEventName));
       log.info("ondragstart" + ondragstart.getClass().getName());
    }
    public void setOndrop(final PEventHandlerNonNull ondrop, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDROP, new AttributeCallBack(ondrop, atrsEventName));
       log.info("ondrop" + ondrop.getClass().getName());
    }
    public void setOndurationchange(final PEventHandlerNonNull ondurationchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDURATIONCHANGE, new AttributeCallBack(ondurationchange, atrsEventName));
       log.info("ondurationchange" + ondurationchange.getClass().getName());
    }
    public void setOnemptied(final PEventHandlerNonNull onemptied, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONEMPTIED, new AttributeCallBack(onemptied, atrsEventName));
       log.info("onemptied" + onemptied.getClass().getName());
    }
    public void setOnended(final PEventHandlerNonNull onended, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONENDED, new AttributeCallBack(onended, atrsEventName));
       log.info("onended" + onended.getClass().getName());
    }
    public void setOnerror(final PEventHandlerNonNull onerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONERROR, new AttributeCallBack(onerror, atrsEventName));
       log.info("onerror" + onerror.getClass().getName());
    }
    public void setOnfocus(final PEventHandlerNonNull onfocus, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONFOCUS, new AttributeCallBack(onfocus, atrsEventName));
       log.info("onfocus" + onfocus.getClass().getName());
    }
    public void setOninput(final PEventHandlerNonNull oninput, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONINPUT, new AttributeCallBack(oninput, atrsEventName));
       log.info("oninput" + oninput.getClass().getName());
    }
    public void setOninvalid(final PEventHandlerNonNull oninvalid, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONINVALID, new AttributeCallBack(oninvalid, atrsEventName));
       log.info("oninvalid" + oninvalid.getClass().getName());
    }
    public void setOnkeydown(final PEventHandlerNonNull onkeydown, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONKEYDOWN, new AttributeCallBack(onkeydown, atrsEventName));
       log.info("onkeydown" + onkeydown.getClass().getName());
    }
    public void setOnkeypress(final PEventHandlerNonNull onkeypress, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONKEYPRESS, new AttributeCallBack(onkeypress, atrsEventName));
       log.info("onkeypress" + onkeypress.getClass().getName());
    }
    public void setOnkeyup(final PEventHandlerNonNull onkeyup, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONKEYUP, new AttributeCallBack(onkeyup, atrsEventName));
       log.info("onkeyup" + onkeyup.getClass().getName());
    }
    public void setOnload(final PEventHandlerNonNull onload, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOAD, new AttributeCallBack(onload, atrsEventName));
       log.info("onload" + onload.getClass().getName());
    }
    public void setOnloadeddata(final PEventHandlerNonNull onloadeddata, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADEDDATA, new AttributeCallBack(onloadeddata, atrsEventName));
       log.info("onloadeddata" + onloadeddata.getClass().getName());
    }
    public void setOnloadedmetadata(final PEventHandlerNonNull onloadedmetadata, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADEDMETADATA, new AttributeCallBack(onloadedmetadata, atrsEventName));
       log.info("onloadedmetadata" + onloadedmetadata.getClass().getName());
    }
    public void setOnloadstart(final PEventHandlerNonNull onloadstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADSTART, new AttributeCallBack(onloadstart, atrsEventName));
       log.info("onloadstart" + onloadstart.getClass().getName());
    }
    public void setOnmousedown(final PEventHandlerNonNull onmousedown, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEDOWN, new AttributeCallBack(onmousedown, atrsEventName));
       log.info("onmousedown" + onmousedown.getClass().getName());
    }
    public void setOnmouseenter(final PEventHandlerNonNull onmouseenter, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEENTER, new AttributeCallBack(onmouseenter, atrsEventName));
       log.info("onmouseenter" + onmouseenter.getClass().getName());
    }
    public void setOnmouseleave(final PEventHandlerNonNull onmouseleave, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSELEAVE, new AttributeCallBack(onmouseleave, atrsEventName));
       log.info("onmouseleave" + onmouseleave.getClass().getName());
    }
    public void setOnmousemove(final PEventHandlerNonNull onmousemove, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEMOVE, new AttributeCallBack(onmousemove, atrsEventName));
       log.info("onmousemove" + onmousemove.getClass().getName());
    }
    public void setOnmouseout(final PEventHandlerNonNull onmouseout, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEOUT, new AttributeCallBack(onmouseout, atrsEventName));
       log.info("onmouseout" + onmouseout.getClass().getName());
    }
    public void setOnmouseover(final PEventHandlerNonNull onmouseover, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEOVER, new AttributeCallBack(onmouseover, atrsEventName));
       log.info("onmouseover" + onmouseover.getClass().getName());
    }
    public void setOnmouseup(final PEventHandlerNonNull onmouseup, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEUP, new AttributeCallBack(onmouseup, atrsEventName));
       log.info("onmouseup" + onmouseup.getClass().getName());
    }
    public void setOnmousewheel(final PEventHandlerNonNull onmousewheel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMOUSEWHEEL, new AttributeCallBack(onmousewheel, atrsEventName));
       log.info("onmousewheel" + onmousewheel.getClass().getName());
    }
    public void setOnpause(final PEventHandlerNonNull onpause, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAUSE, new AttributeCallBack(onpause, atrsEventName));
       log.info("onpause" + onpause.getClass().getName());
    }
    public void setOnplay(final PEventHandlerNonNull onplay, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPLAY, new AttributeCallBack(onplay, atrsEventName));
       log.info("onplay" + onplay.getClass().getName());
    }
    public void setOnplaying(final PEventHandlerNonNull onplaying, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPLAYING, new AttributeCallBack(onplaying, atrsEventName));
       log.info("onplaying" + onplaying.getClass().getName());
    }
    public void setOnprogress(final PEventHandlerNonNull onprogress, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPROGRESS, new AttributeCallBack(onprogress, atrsEventName));
       log.info("onprogress" + onprogress.getClass().getName());
    }
    public void setOnratechange(final PEventHandlerNonNull onratechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRATECHANGE, new AttributeCallBack(onratechange, atrsEventName));
       log.info("onratechange" + onratechange.getClass().getName());
    }
    public void setOnreset(final PEventHandlerNonNull onreset, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRESET, new AttributeCallBack(onreset, atrsEventName));
       log.info("onreset" + onreset.getClass().getName());
    }
    public void setOnresize(final PEventHandlerNonNull onresize, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONRESIZE, new AttributeCallBack(onresize, atrsEventName));
       log.info("onresize" + onresize.getClass().getName());
    }
    public void setOnscroll(final PEventHandlerNonNull onscroll, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSCROLL, new AttributeCallBack(onscroll, atrsEventName));
       log.info("onscroll" + onscroll.getClass().getName());
    }
    public void setOnseeked(final PEventHandlerNonNull onseeked, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSEEKED, new AttributeCallBack(onseeked, atrsEventName));
       log.info("onseeked" + onseeked.getClass().getName());
    }
    public void setOnseeking(final PEventHandlerNonNull onseeking, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSEEKING, new AttributeCallBack(onseeking, atrsEventName));
       log.info("onseeking" + onseeking.getClass().getName());
    }
    public void setOnselect(final PEventHandlerNonNull onselect, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSELECT, new AttributeCallBack(onselect, atrsEventName));
       log.info("onselect" + onselect.getClass().getName());
    }
    public void setOnstalled(final PEventHandlerNonNull onstalled, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTALLED, new AttributeCallBack(onstalled, atrsEventName));
       log.info("onstalled" + onstalled.getClass().getName());
    }
    public void setOnsubmit(final PEventHandlerNonNull onsubmit, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSUBMIT, new AttributeCallBack(onsubmit, atrsEventName));
       log.info("onsubmit" + onsubmit.getClass().getName());
    }
    public void setOnsuspend(final PEventHandlerNonNull onsuspend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSUSPEND, new AttributeCallBack(onsuspend, atrsEventName));
       log.info("onsuspend" + onsuspend.getClass().getName());
    }
    public void setOntimeupdate(final PEventHandlerNonNull ontimeupdate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTIMEUPDATE, new AttributeCallBack(ontimeupdate, atrsEventName));
       log.info("ontimeupdate" + ontimeupdate.getClass().getName());
    }
    public void setOntoggle(final PEventHandlerNonNull ontoggle, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTOGGLE, new AttributeCallBack(ontoggle, atrsEventName));
       log.info("ontoggle" + ontoggle.getClass().getName());
    }
    public void setOnvolumechange(final PEventHandlerNonNull onvolumechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONVOLUMECHANGE, new AttributeCallBack(onvolumechange, atrsEventName));
       log.info("onvolumechange" + onvolumechange.getClass().getName());
    }
    public void setOnwaiting(final PEventHandlerNonNull onwaiting, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWAITING, new AttributeCallBack(onwaiting, atrsEventName));
       log.info("onwaiting" + onwaiting.getClass().getName());
    }
    public void setOnauxclick(final PEventHandlerNonNull onauxclick, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONAUXCLICK, new AttributeCallBack(onauxclick, atrsEventName));
       log.info("onauxclick" + onauxclick.getClass().getName());
    }
    public void setOngotpointercapture(final PEventHandlerNonNull ongotpointercapture, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONGOTPOINTERCAPTURE, new AttributeCallBack(ongotpointercapture, atrsEventName));
       log.info("ongotpointercapture" + ongotpointercapture.getClass().getName());
    }
    public void setOnlostpointercapture(final PEventHandlerNonNull onlostpointercapture, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOSTPOINTERCAPTURE, new AttributeCallBack(onlostpointercapture, atrsEventName));
       log.info("onlostpointercapture" + onlostpointercapture.getClass().getName());
    }
    public void setOnpointerdown(final PEventHandlerNonNull onpointerdown, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERDOWN, new AttributeCallBack(onpointerdown, atrsEventName));
       log.info("onpointerdown" + onpointerdown.getClass().getName());
    }
    public void setOnpointermove(final PEventHandlerNonNull onpointermove, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERMOVE, new AttributeCallBack(onpointermove, atrsEventName));
       log.info("onpointermove" + onpointermove.getClass().getName());
    }
    public void setOnpointerup(final PEventHandlerNonNull onpointerup, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERUP, new AttributeCallBack(onpointerup, atrsEventName));
       log.info("onpointerup" + onpointerup.getClass().getName());
    }
    public void setOnpointercancel(final PEventHandlerNonNull onpointercancel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERCANCEL, new AttributeCallBack(onpointercancel, atrsEventName));
       log.info("onpointercancel" + onpointercancel.getClass().getName());
    }
    public void setOnpointerover(final PEventHandlerNonNull onpointerover, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTEROVER, new AttributeCallBack(onpointerover, atrsEventName));
       log.info("onpointerover" + onpointerover.getClass().getName());
    }
    public void setOnpointerout(final PEventHandlerNonNull onpointerout, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTEROUT, new AttributeCallBack(onpointerout, atrsEventName));
       log.info("onpointerout" + onpointerout.getClass().getName());
    }
    public void setOnpointerenter(final PEventHandlerNonNull onpointerenter, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERENTER, new AttributeCallBack(onpointerenter, atrsEventName));
       log.info("onpointerenter" + onpointerenter.getClass().getName());
    }
    public void setOnpointerleave(final PEventHandlerNonNull onpointerleave, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOINTERLEAVE, new AttributeCallBack(onpointerleave, atrsEventName));
       log.info("onpointerleave" + onpointerleave.getClass().getName());
    }
    public void setOntouchcancel(final PEventHandlerNonNull ontouchcancel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTOUCHCANCEL, new AttributeCallBack(ontouchcancel, atrsEventName));
       log.info("ontouchcancel" + ontouchcancel.getClass().getName());
    }
    public void setOntouchend(final PEventHandlerNonNull ontouchend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTOUCHEND, new AttributeCallBack(ontouchend, atrsEventName));
       log.info("ontouchend" + ontouchend.getClass().getName());
    }
    public void setOntouchmove(final PEventHandlerNonNull ontouchmove, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTOUCHMOVE, new AttributeCallBack(ontouchmove, atrsEventName));
       log.info("ontouchmove" + ontouchmove.getClass().getName());
    }
    public void setOntouchstart(final PEventHandlerNonNull ontouchstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTOUCHSTART, new AttributeCallBack(ontouchstart, atrsEventName));
       log.info("ontouchstart" + ontouchstart.getClass().getName());
    }

    public PElement getRootScroller(){
      return (PElement) getAttribute(PAttributeNames.ROOT_SCROLLER);
    }
    public String getXmlVersion(){
      return (String) getAttribute(PAttributeNames.XML_VERSION);
    }
    public Boolean getXmlStandalone(){
      return (Boolean) getAttribute(PAttributeNames.XML_STANDALONE);
    }
    public String getDomain(){
      return (String) getAttribute(PAttributeNames.DOMAIN);
    }
    public String getCookie(){
      return (String) getAttribute(PAttributeNames.COOKIE);
    }
    public String getTitle(){
      return (String) getAttribute(PAttributeNames.TITLE);
    }
    public String getDir(){
      return (String) getAttribute(PAttributeNames.DIR);
    }
    public PHTMLElement getBody(){
      return (PHTMLElement) getAttribute(PAttributeNames.BODY);
    }
    public String getDesignMode(){
      return (String) getAttribute(PAttributeNames.DESIGN_MODE);
    }
    public PEventHandlerNonNull getOnreadystatechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREADYSTATECHANGE);
    }
    public String getSelectedStylesheetSet(){
      return (String) getAttribute(PAttributeNames.SELECTED_STYLESHEET_SET);
    }
    public PEventHandlerNonNull getOnpointerlockchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERLOCKCHANGE);
    }
    public PEventHandlerNonNull getOnpointerlockerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERLOCKERROR);
    }
    public PEventHandlerNonNull getOnbeforecopy(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEFORECOPY);
    }
    public PEventHandlerNonNull getOnbeforecut(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEFORECUT);
    }
    public PEventHandlerNonNull getOnbeforepaste(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEFOREPASTE);
    }
    public PEventHandlerNonNull getOncopy(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCOPY);
    }
    public PEventHandlerNonNull getOncut(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCUT);
    }
    public PEventHandlerNonNull getOnpaste(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPASTE);
    }
    public PEventHandlerNonNull getOnsearch(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSEARCH);
    }
    public PEventHandlerNonNull getOnsecuritypolicyviolation(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSECURITYPOLICYVIOLATION);
    }
    public PEventHandlerNonNull getOnselectionchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSELECTIONCHANGE);
    }
    public PEventHandlerNonNull getOnselectstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSELECTSTART);
    }
    public PEventHandlerNonNull getOnwheel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWHEEL);
    }
    public PEventHandlerNonNull getOnfullscreenchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONFULLSCREENCHANGE);
    }
    public PEventHandlerNonNull getOnfullscreenerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONFULLSCREENERROR);
    }
    public PEventHandlerNonNull getOnwebkitfullscreenchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWEBKITFULLSCREENCHANGE);
    }
    public PEventHandlerNonNull getOnwebkitfullscreenerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWEBKITFULLSCREENERROR);
    }
    public PEventHandlerNonNull getOnabort(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONABORT);
    }
    public PEventHandlerNonNull getOnblur(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBLUR);
    }
    public PEventHandlerNonNull getOncancel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCANCEL);
    }
    public PEventHandlerNonNull getOncanplay(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCANPLAY);
    }
    public PEventHandlerNonNull getOncanplaythrough(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCANPLAYTHROUGH);
    }
    public PEventHandlerNonNull getOnchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCHANGE);
    }
    public PEventHandlerNonNull getOnclick(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLICK);
    }
    public PEventHandlerNonNull getOnclose(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCLOSE);
    }
    public PEventHandlerNonNull getOncontextmenu(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCONTEXTMENU);
    }
    public PEventHandlerNonNull getOncuechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONCUECHANGE);
    }
    public PEventHandlerNonNull getOndblclick(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDBLCLICK);
    }
    public PEventHandlerNonNull getOndrag(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDRAG);
    }
    public PEventHandlerNonNull getOndragend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDRAGEND);
    }
    public PEventHandlerNonNull getOndragenter(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDRAGENTER);
    }
    public PEventHandlerNonNull getOndragleave(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDRAGLEAVE);
    }
    public PEventHandlerNonNull getOndragover(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDRAGOVER);
    }
    public PEventHandlerNonNull getOndragstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDRAGSTART);
    }
    public PEventHandlerNonNull getOndrop(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDROP);
    }
    public PEventHandlerNonNull getOndurationchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDURATIONCHANGE);
    }
    public PEventHandlerNonNull getOnemptied(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONEMPTIED);
    }
    public PEventHandlerNonNull getOnended(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONENDED);
    }
    public PEventHandlerNonNull getOnerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONERROR);
    }
    public PEventHandlerNonNull getOnfocus(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONFOCUS);
    }
    public PEventHandlerNonNull getOninput(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONINPUT);
    }
    public PEventHandlerNonNull getOninvalid(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONINVALID);
    }
    public PEventHandlerNonNull getOnkeydown(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONKEYDOWN);
    }
    public PEventHandlerNonNull getOnkeypress(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONKEYPRESS);
    }
    public PEventHandlerNonNull getOnkeyup(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONKEYUP);
    }
    public PEventHandlerNonNull getOnload(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOAD);
    }
    public PEventHandlerNonNull getOnloadeddata(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADEDDATA);
    }
    public PEventHandlerNonNull getOnloadedmetadata(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADEDMETADATA);
    }
    public PEventHandlerNonNull getOnloadstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADSTART);
    }
    public PEventHandlerNonNull getOnmousedown(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEDOWN);
    }
    public PEventHandlerNonNull getOnmouseenter(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEENTER);
    }
    public PEventHandlerNonNull getOnmouseleave(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSELEAVE);
    }
    public PEventHandlerNonNull getOnmousemove(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEMOVE);
    }
    public PEventHandlerNonNull getOnmouseout(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEOUT);
    }
    public PEventHandlerNonNull getOnmouseover(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEOVER);
    }
    public PEventHandlerNonNull getOnmouseup(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEUP);
    }
    public PEventHandlerNonNull getOnmousewheel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMOUSEWHEEL);
    }
    public PEventHandlerNonNull getOnpause(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAUSE);
    }
    public PEventHandlerNonNull getOnplay(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPLAY);
    }
    public PEventHandlerNonNull getOnplaying(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPLAYING);
    }
    public PEventHandlerNonNull getOnprogress(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPROGRESS);
    }
    public PEventHandlerNonNull getOnratechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRATECHANGE);
    }
    public PEventHandlerNonNull getOnreset(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRESET);
    }
    public PEventHandlerNonNull getOnresize(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONRESIZE);
    }
    public PEventHandlerNonNull getOnscroll(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSCROLL);
    }
    public PEventHandlerNonNull getOnseeked(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSEEKED);
    }
    public PEventHandlerNonNull getOnseeking(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSEEKING);
    }
    public PEventHandlerNonNull getOnselect(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSELECT);
    }
    public PEventHandlerNonNull getOnstalled(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTALLED);
    }
    public PEventHandlerNonNull getOnsubmit(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSUBMIT);
    }
    public PEventHandlerNonNull getOnsuspend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSUSPEND);
    }
    public PEventHandlerNonNull getOntimeupdate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTIMEUPDATE);
    }
    public PEventHandlerNonNull getOntoggle(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTOGGLE);
    }
    public PEventHandlerNonNull getOnvolumechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONVOLUMECHANGE);
    }
    public PEventHandlerNonNull getOnwaiting(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWAITING);
    }
    public PEventHandlerNonNull getOnauxclick(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONAUXCLICK);
    }
    public PEventHandlerNonNull getOngotpointercapture(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONGOTPOINTERCAPTURE);
    }
    public PEventHandlerNonNull getOnlostpointercapture(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOSTPOINTERCAPTURE);
    }
    public PEventHandlerNonNull getOnpointerdown(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERDOWN);
    }
    public PEventHandlerNonNull getOnpointermove(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERMOVE);
    }
    public PEventHandlerNonNull getOnpointerup(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERUP);
    }
    public PEventHandlerNonNull getOnpointercancel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERCANCEL);
    }
    public PEventHandlerNonNull getOnpointerover(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTEROVER);
    }
    public PEventHandlerNonNull getOnpointerout(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTEROUT);
    }
    public PEventHandlerNonNull getOnpointerenter(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERENTER);
    }
    public PEventHandlerNonNull getOnpointerleave(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOINTERLEAVE);
    }
    public PEventHandlerNonNull getOntouchcancel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTOUCHCANCEL);
    }
    public PEventHandlerNonNull getOntouchend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTOUCHEND);
    }
    public PEventHandlerNonNull getOntouchmove(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTOUCHMOVE);
    }
    public PEventHandlerNonNull getOntouchstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTOUCHSTART);
    }


    public PNode adoptNode(PNode node) {
       return null;
    }


    public final void append(PNode nodes){
    }

    public final void append(String nodes){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       APPEND_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {nodes});
       writer.endObject();
    }

    public PRange caretRangeFromPoint() {
       return null;
    }


    public PRange caretRangeFromPoint(Double x) {
       return null;
    }


    public PRange caretRangeFromPoint(Double x, Double y) {
       return null;
    }


    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public PAttr createAttribute(String localName) {
       return null;
    }


    public PAttr createAttributeNS(String namespaceURI, String qualifiedName) {
       return null;
    }


    public PCDATASection createCDATASection(String data) {
       return null;
    }


    public PComment createComment(String data) {
       return null;
    }


    public PDocumentFragment createDocumentFragment() {
       return null;
    }


    public <T extends PElement> T createElement(String localName) {
       return null;
    }


    public <T extends PElement> T createElement(String localName, String options) {
       return null;
    }


    public <T extends PElement> T createElement(String localName, PJsObject options) {
       return null;
    }


    public <T extends PElement> T createElementNS(String namespaceURI, String qualifiedName) {
       return null;
    }


    public <T extends PElement> T createElementNS(String namespaceURI, String qualifiedName, String options) {
       return null;
    }


    public <T extends PElement> T createElementNS(String namespaceURI, String qualifiedName, PJsObject options) {
       return null;
    }


    public PEvent createEvent(String eventType) {
       return null;
    }


    public PXPathExpression createExpression(String expression) {
       return null;
    }


    public PXPathExpression createExpression(String expression, PXPathNSResolver resolver) {
       return null;
    }


    public PXPathNSResolver createNSResolver(PNode nodeResolver) {
       return null;
    }


    public PNodeIterator createNodeIterator(PNode root) {
       return null;
    }


    public PNodeIterator createNodeIterator(PNode root, Double whatToShow) {
       return null;
    }


    public PNodeIterator createNodeIterator(PNode root, Double whatToShow, PNodeFilter filter) {
       return null;
    }


    public PProcessingInstruction createProcessingInstruction(String target, String data) {
       return null;
    }


    public PRange createRange() {
       return null;
    }


    public PText createTextNode(String data) {
       return null;
    }


    public PTouch createTouch(PWindow2 view, PEventTarget target, Double identifier, Double pageX, Double pageY, Double screenX, Double screenY) {
       return null;
    }


    public PTouch createTouch(PWindow2 view, PEventTarget target, Double identifier, Double pageX, Double pageY, Double screenX, Double screenY, Double radiusX) {
       return null;
    }


    public PTouch createTouch(PWindow2 view, PEventTarget target, Double identifier, Double pageX, Double pageY, Double screenX, Double screenY, Double radiusX, Double radiusY) {
       return null;
    }


    public PTouch createTouch(PWindow2 view, PEventTarget target, Double identifier, Double pageX, Double pageY, Double screenX, Double screenY, Double radiusX, Double radiusY, Double rotationAngle) {
       return null;
    }


    public PTouch createTouch(PWindow2 view, PEventTarget target, Double identifier, Double pageX, Double pageY, Double screenX, Double screenY, Double radiusX, Double radiusY, Double rotationAngle, Double force) {
       return null;
    }


    public final PTouchList createTouchList(PTouch touches) {
       return null;
    }


    public PTreeWalker createTreeWalker(PNode root) {
       return null;
    }


    public PTreeWalker createTreeWalker(PNode root, Double whatToShow) {
       return null;
    }


    public PTreeWalker createTreeWalker(PNode root, Double whatToShow, PNodeFilter filter) {
       return null;
    }


    public PElement elementFromPoint(Double x, Double y) {
       return null;
    }


    public PElement[] elementsFromPoint(Double x, Double y) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode, PXPathNSResolver resolver) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode, PXPathNSResolver resolver, Short type) {
       return null;
    }


    public PXPathResult evaluate(String expression, PNode contextNode, PXPathNSResolver resolver, Short type, Object inResult) {
       return null;
    }


    public void execCommand(final Consumer<Boolean> cback,String commandId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.EXEC_COMMAND_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId});
       writer.endObject();
    }

    public void execCommand(final Consumer<Boolean> cback,String commandId, Boolean showUI){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.EXEC_COMMAND_TYPESTRING_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId,showUI});
       writer.endObject();
    }

    public void execCommand(final Consumer<Boolean> cback,String commandId, Boolean showUI, String value){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.EXEC_COMMAND_TYPESTRING_TYPEBOOLEAN_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId,showUI,value});
       writer.endObject();
    }

    public void exitFullscreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       EXIT_FULLSCREEN_VOID.getValue());
       writer.endObject();
    }

    public void exitPointerLock(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       EXIT_POINTER_LOCK_VOID.getValue());
       writer.endObject();
    }

    public PAnimation[] getAnimations() {
       return null;
    }


    public <T extends PElement> T getElementById(String elementId) {
       return null;
    }


    public PHTMLCollection getElementsByClassName(String classNames) {
       return null;
    }


    public PNodeList getElementsByName(String elementName) {
       return null;
    }


    public PHTMLCollection getElementsByTagName(String localName) {
       return null;
    }


    public PHTMLCollection getElementsByTagNameNS(String namespaceURI, String localName) {
       return null;
    }


    public PSelection getSelection() {
       return null;
    }


    public void hasFocus(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_FOCUS_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public PNode importNode(PNode node) {
       return null;
    }


    public PNode importNode(PNode node, Boolean deep) {
       return null;
    }


    public void open(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       OPEN_VOID.getValue());
       writer.endObject();
    }

    public final void prepend(PNode nodes){
    }

    public final void prepend(String nodes){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PREPEND_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {nodes});
       writer.endObject();
    }

    public void queryCommandEnabled(final Consumer<Boolean> cback,String commandId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.QUERY_COMMAND_ENABLED_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId});
       writer.endObject();
    }

    public void queryCommandIndeterm(final Consumer<Boolean> cback,String commandId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.QUERY_COMMAND_INDETERM_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId});
       writer.endObject();
    }

    public void queryCommandState(final Consumer<Boolean> cback,String commandId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.QUERY_COMMAND_STATE_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId});
       writer.endObject();
    }

    public void queryCommandSupported(final Consumer<Boolean> cback,String commandId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.QUERY_COMMAND_SUPPORTED_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId});
       writer.endObject();
    }

    public void queryCommandValue(final Consumer<String> cback,String commandId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.QUERY_COMMAND_VALUE_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {commandId});
       writer.endObject();
    }

    public <T extends PElement> T querySelector(String selectors) {
       return null;
    }


    public PNodeList querySelectorAll(String selectors) {
       return null;
    }


    public PFunction registerElement(String type) {
       return null;
    }


    public PFunction registerElement(String type, PElementRegistrationOptions options) {
       return null;
    }


    public void webkitCancelFullScreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_CANCEL_FULL_SCREEN_VOID.getValue());
       writer.endObject();
    }

    public void webkitExitFullscreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_EXIT_FULLSCREEN_VOID.getValue());
       writer.endObject();
    }

    public final void write(String text){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WRITE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {text});
       writer.endObject();
    }

    public final void writeln(String text){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WRITELN_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {text});
       writer.endObject();
    }

    
}