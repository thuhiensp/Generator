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
public class PGlobalEventHandlers extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PGlobalEventHandlers.class);
    private PGlobalEventHandlers(){
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

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}