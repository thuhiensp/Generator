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
import com.ponysdk.core.server.application.UIContext;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PWindow extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PWindow.class);
    private static final String CANONICAL_NAME = PWindow.class.getCanonicalName();
    private static final PHTMLDocument htmlDocument = new PHTMLDocument();
    private final PHTMLHtmlElement html = new PHTMLHtmlElement(true);
    private final PHTMLBodyElement body = new PHTMLBodyElement(true);

     public static PWindow getMain() {
          PWindow mainWindow = UIContext.get().getAttribute(CANONICAL_NAME);
            if (mainWindow == null) {
                  mainWindow = new PWindow();
                  UIContext.get().setAttribute(CANONICAL_NAME, window);
            }
            return mainWindow;
    }

     public static PHTMLDocument getHtmlDocument() {
        return htmlDocument;
    }

    public PHTMLHtmlElement getHtml() {
       return html;
    }

    public PHTMLBodyElement getBody() {
        return body;
    }

     public PWindow() {
         applyExisting(widgetNoArgs());
    }


    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setStatus(final String status)  {
       setAttribute(PAttributeNames.STATUS, status);
       log.info("status" + status);
    }
    public void setOpener(final PWindow2 opener)  {
       setAttribute(PAttributeNames.OPENER, opener);
       log.info("opener" + opener);
    }
    public void setOnorientationchange(final PEventHandlerNonNull onorientationchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONORIENTATIONCHANGE, new AttributeCallBack(onorientationchange, atrsEventName));
       log.info("onorientationchange" + onorientationchange.getClass().getName());
    }
    public void setEvent(final PEvent event)  {
       setAttribute(PAttributeNames.EVENT_PEVENT, event);
       log.info("event" + event);
    }
    public void setDefaultStatus(final String defaultStatus)  {
       setAttribute(PAttributeNames.DEFAULT_STATUS, defaultStatus);
       log.info("defaultStatus" + defaultStatus);
    }
    public void setDefaultstatus(final String defaultstatus)  {
       setAttribute(PAttributeNames.DEFAULTSTATUS, defaultstatus);
       log.info("defaultstatus" + defaultstatus);
    }
    public void setWebKitTransitionEvent(final PTransitionEvent WebKitTransitionEvent)  {
       setAttribute(PAttributeNames.WEB_KIT_TRANSITION_EVENT, WebKitTransitionEvent);
       log.info("WebKitTransitionEvent" + WebKitTransitionEvent);
    }
    public void setWebKitAnimationEvent(final PAnimationEvent WebKitAnimationEvent)  {
       setAttribute(PAttributeNames.WEB_KIT_ANIMATION_EVENT, WebKitAnimationEvent);
       log.info("WebKitAnimationEvent" + WebKitAnimationEvent);
    }
    public void setWebkitURL(final PURL webkitURL)  {
       setAttribute(PAttributeNames.WEBKITURL, webkitURL);
       log.info("webkitURL" + webkitURL);
    }
    public void setWebKitMutationObserver(final PMutationObserver WebKitMutationObserver)  {
       setAttribute(PAttributeNames.WEB_KIT_MUTATION_OBSERVER, WebKitMutationObserver);
       log.info("WebKitMutationObserver" + WebKitMutationObserver);
    }
    public void setOnanimationend(final PEventHandlerNonNull onanimationend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONANIMATIONEND, new AttributeCallBack(onanimationend, atrsEventName));
       log.info("onanimationend" + onanimationend.getClass().getName());
    }
    public void setOnanimationiteration(final PEventHandlerNonNull onanimationiteration, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONANIMATIONITERATION, new AttributeCallBack(onanimationiteration, atrsEventName));
       log.info("onanimationiteration" + onanimationiteration.getClass().getName());
    }
    public void setOnanimationstart(final PEventHandlerNonNull onanimationstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONANIMATIONSTART, new AttributeCallBack(onanimationstart, atrsEventName));
       log.info("onanimationstart" + onanimationstart.getClass().getName());
    }
    public void setOnsearch(final PEventHandlerNonNull onsearch, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSEARCH, new AttributeCallBack(onsearch, atrsEventName));
       log.info("onsearch" + onsearch.getClass().getName());
    }
    public void setOntransitionend(final PEventHandlerNonNull ontransitionend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONTRANSITIONEND, new AttributeCallBack(ontransitionend, atrsEventName));
       log.info("ontransitionend" + ontransitionend.getClass().getName());
    }
    public void setOnwebkitanimationend(final PEventHandlerNonNull onwebkitanimationend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWEBKITANIMATIONEND, new AttributeCallBack(onwebkitanimationend, atrsEventName));
       log.info("onwebkitanimationend" + onwebkitanimationend.getClass().getName());
    }
    public void setOnwebkitanimationiteration(final PEventHandlerNonNull onwebkitanimationiteration, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWEBKITANIMATIONITERATION, new AttributeCallBack(onwebkitanimationiteration, atrsEventName));
       log.info("onwebkitanimationiteration" + onwebkitanimationiteration.getClass().getName());
    }
    public void setOnwebkitanimationstart(final PEventHandlerNonNull onwebkitanimationstart, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWEBKITANIMATIONSTART, new AttributeCallBack(onwebkitanimationstart, atrsEventName));
       log.info("onwebkitanimationstart" + onwebkitanimationstart.getClass().getName());
    }
    public void setOnwebkittransitionend(final PEventHandlerNonNull onwebkittransitionend, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWEBKITTRANSITIONEND, new AttributeCallBack(onwebkittransitionend, atrsEventName));
       log.info("onwebkittransitionend" + onwebkittransitionend.getClass().getName());
    }
    public void setOnwheel(final PEventHandlerNonNull onwheel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONWHEEL, new AttributeCallBack(onwheel, atrsEventName));
       log.info("onwheel" + onwheel.getClass().getName());
    }
    public void setWebKitCSSMatrix(final PDOMMatrix WebKitCSSMatrix)  {
       setAttribute(PAttributeNames.WEB_KITCSS_MATRIX, WebKitCSSMatrix);
       log.info("WebKitCSSMatrix" + WebKitCSSMatrix);
    }
    public void setOnappinstalled(final PEventHandlerNonNull onappinstalled, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONAPPINSTALLED, new AttributeCallBack(onappinstalled, atrsEventName));
       log.info("onappinstalled" + onappinstalled.getClass().getName());
    }
    public void setOnbeforeinstallprompt(final PEventHandlerNonNull onbeforeinstallprompt, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEFOREINSTALLPROMPT, new AttributeCallBack(onbeforeinstallprompt, atrsEventName));
       log.info("onbeforeinstallprompt" + onbeforeinstallprompt.getClass().getName());
    }
    public void setOndevicemotion(final PEventHandlerNonNull ondevicemotion, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDEVICEMOTION, new AttributeCallBack(ondevicemotion, atrsEventName));
       log.info("ondevicemotion" + ondevicemotion.getClass().getName());
    }
    public void setOndeviceorientation(final PEventHandlerNonNull ondeviceorientation, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDEVICEORIENTATION, new AttributeCallBack(ondeviceorientation, atrsEventName));
       log.info("ondeviceorientation" + ondeviceorientation.getClass().getName());
    }
    public void setOndeviceorientationabsolute(final PEventHandlerNonNull ondeviceorientationabsolute, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDEVICEORIENTATIONABSOLUTE, new AttributeCallBack(ondeviceorientationabsolute, atrsEventName));
       log.info("ondeviceorientationabsolute" + ondeviceorientationabsolute.getClass().getName());
    }
    public void setWebkitMediaStream(final PMediaStream webkitMediaStream)  {
       setAttribute(PAttributeNames.WEBKIT_MEDIA_STREAM, webkitMediaStream);
       log.info("webkitMediaStream" + webkitMediaStream);
    }
    public void setWebkitRTCPeerConnection(final PRTCPeerConnection webkitRTCPeerConnection)  {
       setAttribute(PAttributeNames.WEBKITRTC_PEER_CONNECTION, webkitRTCPeerConnection);
       log.info("webkitRTCPeerConnection" + webkitRTCPeerConnection);
    }
    public void setWebkitSpeechGrammar(final PSpeechGrammar webkitSpeechGrammar)  {
       setAttribute(PAttributeNames.WEBKIT_SPEECH_GRAMMAR, webkitSpeechGrammar);
       log.info("webkitSpeechGrammar" + webkitSpeechGrammar);
    }
    public void setWebkitSpeechGrammarList(final PSpeechGrammarList webkitSpeechGrammarList)  {
       setAttribute(PAttributeNames.WEBKIT_SPEECH_GRAMMAR_LIST, webkitSpeechGrammarList);
       log.info("webkitSpeechGrammarList" + webkitSpeechGrammarList);
    }
    public void setWebkitSpeechRecognition(final PSpeechRecognition webkitSpeechRecognition)  {
       setAttribute(PAttributeNames.WEBKIT_SPEECH_RECOGNITION, webkitSpeechRecognition);
       log.info("webkitSpeechRecognition" + webkitSpeechRecognition);
    }
    public void setWebkitSpeechRecognitionError(final PSpeechRecognitionError webkitSpeechRecognitionError)  {
       setAttribute(PAttributeNames.WEBKIT_SPEECH_RECOGNITION_ERROR, webkitSpeechRecognitionError);
       log.info("webkitSpeechRecognitionError" + webkitSpeechRecognitionError);
    }
    public void setWebkitSpeechRecognitionEvent(final PSpeechRecognitionEvent webkitSpeechRecognitionEvent)  {
       setAttribute(PAttributeNames.WEBKIT_SPEECH_RECOGNITION_EVENT, webkitSpeechRecognitionEvent);
       log.info("webkitSpeechRecognitionEvent" + webkitSpeechRecognitionEvent);
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
    public void setOnbeforeunload(final PEventHandlerNonNull onbeforeunload, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONBEFOREUNLOAD, new AttributeCallBack(onbeforeunload, atrsEventName));
       log.info("onbeforeunload" + onbeforeunload.getClass().getName());
    }
    public void setOnhashchange(final PEventHandlerNonNull onhashchange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONHASHCHANGE, new AttributeCallBack(onhashchange, atrsEventName));
       log.info("onhashchange" + onhashchange.getClass().getName());
    }
    public void setOnlanguagechange(final PEventHandlerNonNull onlanguagechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLANGUAGECHANGE, new AttributeCallBack(onlanguagechange, atrsEventName));
       log.info("onlanguagechange" + onlanguagechange.getClass().getName());
    }
    public void setOnmessage(final PEventHandlerNonNull onmessage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGE, new AttributeCallBack(onmessage, atrsEventName));
       log.info("onmessage" + onmessage.getClass().getName());
    }
    public void setOnmessageerror(final PEventHandlerNonNull onmessageerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONMESSAGEERROR, new AttributeCallBack(onmessageerror, atrsEventName));
       log.info("onmessageerror" + onmessageerror.getClass().getName());
    }
    public void setOnoffline(final PEventHandlerNonNull onoffline, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONOFFLINE, new AttributeCallBack(onoffline, atrsEventName));
       log.info("onoffline" + onoffline.getClass().getName());
    }
    public void setOnonline(final PEventHandlerNonNull ononline, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONONLINE, new AttributeCallBack(ononline, atrsEventName));
       log.info("ononline" + ononline.getClass().getName());
    }
    public void setOnpagehide(final PEventHandlerNonNull onpagehide, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAGEHIDE, new AttributeCallBack(onpagehide, atrsEventName));
       log.info("onpagehide" + onpagehide.getClass().getName());
    }
    public void setOnpageshow(final PEventHandlerNonNull onpageshow, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPAGESHOW, new AttributeCallBack(onpageshow, atrsEventName));
       log.info("onpageshow" + onpageshow.getClass().getName());
    }
    public void setOnpopstate(final PEventHandlerNonNull onpopstate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONPOPSTATE, new AttributeCallBack(onpopstate, atrsEventName));
       log.info("onpopstate" + onpopstate.getClass().getName());
    }
    public void setOnrejectionhandled(final PEventHandlerNonNull onrejectionhandled, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREJECTIONHANDLED, new AttributeCallBack(onrejectionhandled, atrsEventName));
       log.info("onrejectionhandled" + onrejectionhandled.getClass().getName());
    }
    public void setOnstorage(final PEventHandlerNonNull onstorage, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSTORAGE, new AttributeCallBack(onstorage, atrsEventName));
       log.info("onstorage" + onstorage.getClass().getName());
    }
    public void setOnunhandledrejection(final PEventHandlerNonNull onunhandledrejection, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUNHANDLEDREJECTION, new AttributeCallBack(onunhandledrejection, atrsEventName));
       log.info("onunhandledrejection" + onunhandledrejection.getClass().getName());
    }
    public void setOnunload(final PEventHandlerNonNull onunload, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONUNLOAD, new AttributeCallBack(onunload, atrsEventName));
       log.info("onunload" + onunload.getClass().getName());
    }

    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getStatus(){
      return (String) getAttribute(PAttributeNames.STATUS);
    }
    public PWindow2 getOpener(){
      return (PWindow2) getAttribute(PAttributeNames.OPENER);
    }
    public PEventHandlerNonNull getOnorientationchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONORIENTATIONCHANGE);
    }
    public PEvent getEvent(){
      return (PEvent) getAttribute(PAttributeNames.EVENT_PEVENT);
    }
    public String getDefaultStatus(){
      return (String) getAttribute(PAttributeNames.DEFAULT_STATUS);
    }
    public String getDefaultstatus(){
      return (String) getAttribute(PAttributeNames.DEFAULTSTATUS);
    }
    public PTransitionEvent getWebKitTransitionEvent(){
      return (PTransitionEvent) getAttribute(PAttributeNames.WEB_KIT_TRANSITION_EVENT);
    }
    public PAnimationEvent getWebKitAnimationEvent(){
      return (PAnimationEvent) getAttribute(PAttributeNames.WEB_KIT_ANIMATION_EVENT);
    }
    public PURL getWebkitURL(){
      return (PURL) getAttribute(PAttributeNames.WEBKITURL);
    }
    public PMutationObserver getWebKitMutationObserver(){
      return (PMutationObserver) getAttribute(PAttributeNames.WEB_KIT_MUTATION_OBSERVER);
    }
    public PEventHandlerNonNull getOnanimationend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONANIMATIONEND);
    }
    public PEventHandlerNonNull getOnanimationiteration(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONANIMATIONITERATION);
    }
    public PEventHandlerNonNull getOnanimationstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONANIMATIONSTART);
    }
    public PEventHandlerNonNull getOnsearch(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSEARCH);
    }
    public PEventHandlerNonNull getOntransitionend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONTRANSITIONEND);
    }
    public PEventHandlerNonNull getOnwebkitanimationend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWEBKITANIMATIONEND);
    }
    public PEventHandlerNonNull getOnwebkitanimationiteration(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWEBKITANIMATIONITERATION);
    }
    public PEventHandlerNonNull getOnwebkitanimationstart(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWEBKITANIMATIONSTART);
    }
    public PEventHandlerNonNull getOnwebkittransitionend(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWEBKITTRANSITIONEND);
    }
    public PEventHandlerNonNull getOnwheel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONWHEEL);
    }
    public PDOMMatrix getWebKitCSSMatrix(){
      return (PDOMMatrix) getAttribute(PAttributeNames.WEB_KITCSS_MATRIX);
    }
    public PEventHandlerNonNull getOnappinstalled(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONAPPINSTALLED);
    }
    public PEventHandlerNonNull getOnbeforeinstallprompt(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEFOREINSTALLPROMPT);
    }
    public PEventHandlerNonNull getOndevicemotion(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDEVICEMOTION);
    }
    public PEventHandlerNonNull getOndeviceorientation(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDEVICEORIENTATION);
    }
    public PEventHandlerNonNull getOndeviceorientationabsolute(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDEVICEORIENTATIONABSOLUTE);
    }
    public PMediaStream getWebkitMediaStream(){
      return (PMediaStream) getAttribute(PAttributeNames.WEBKIT_MEDIA_STREAM);
    }
    public PRTCPeerConnection getWebkitRTCPeerConnection(){
      return (PRTCPeerConnection) getAttribute(PAttributeNames.WEBKITRTC_PEER_CONNECTION);
    }
    public PSpeechGrammar getWebkitSpeechGrammar(){
      return (PSpeechGrammar) getAttribute(PAttributeNames.WEBKIT_SPEECH_GRAMMAR);
    }
    public PSpeechGrammarList getWebkitSpeechGrammarList(){
      return (PSpeechGrammarList) getAttribute(PAttributeNames.WEBKIT_SPEECH_GRAMMAR_LIST);
    }
    public PSpeechRecognition getWebkitSpeechRecognition(){
      return (PSpeechRecognition) getAttribute(PAttributeNames.WEBKIT_SPEECH_RECOGNITION);
    }
    public PSpeechRecognitionError getWebkitSpeechRecognitionError(){
      return (PSpeechRecognitionError) getAttribute(PAttributeNames.WEBKIT_SPEECH_RECOGNITION_ERROR);
    }
    public PSpeechRecognitionEvent getWebkitSpeechRecognitionEvent(){
      return (PSpeechRecognitionEvent) getAttribute(PAttributeNames.WEBKIT_SPEECH_RECOGNITION_EVENT);
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
    public PEventHandlerNonNull getOnbeforeunload(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONBEFOREUNLOAD);
    }
    public PEventHandlerNonNull getOnhashchange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONHASHCHANGE);
    }
    public PEventHandlerNonNull getOnlanguagechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLANGUAGECHANGE);
    }
    public PEventHandlerNonNull getOnmessage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGE);
    }
    public PEventHandlerNonNull getOnmessageerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONMESSAGEERROR);
    }
    public PEventHandlerNonNull getOnoffline(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONOFFLINE);
    }
    public PEventHandlerNonNull getOnonline(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONONLINE);
    }
    public PEventHandlerNonNull getOnpagehide(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAGEHIDE);
    }
    public PEventHandlerNonNull getOnpageshow(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPAGESHOW);
    }
    public PEventHandlerNonNull getOnpopstate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONPOPSTATE);
    }
    public PEventHandlerNonNull getOnrejectionhandled(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREJECTIONHANDLED);
    }
    public PEventHandlerNonNull getOnstorage(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSTORAGE);
    }
    public PEventHandlerNonNull getOnunhandledrejection(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUNHANDLEDREJECTION);
    }
    public PEventHandlerNonNull getOnunload(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONUNLOAD);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.WINDOW;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void alert(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ALERT_VOID.getValue());
       writer.endObject();
    }

    public void alert(String message){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ALERT_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message});
       writer.endObject();
    }

    public void atob(final Consumer<String> cback,String atob){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.ATOB_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {atob});
       writer.endObject();
    }

    public void blur(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BLUR_VOID.getValue());
       writer.endObject();
    }

    public void btoa(final Consumer<String> cback,String btoa){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.BTOA_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {btoa});
       writer.endObject();
    }

    public void cancelAnimationFrame(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CANCEL_ANIMATION_FRAME_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public void cancelIdleCallback(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CANCEL_IDLE_CALLBACK_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public void captureEvents(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CAPTURE_EVENTS_VOID.getValue());
       writer.endObject();
    }

    public void clearInterval(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_INTERVAL_VOID.getValue());
       writer.endObject();
    }

    public void clearInterval(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_INTERVAL_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public void clearTimeout(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_TIMEOUT_VOID.getValue());
       writer.endObject();
    }

    public void clearTimeout(Double handle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_TIMEOUT_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handle});
       writer.endObject();
    }

    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public void confirm(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CONFIRM_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void confirm(final Consumer<Boolean> cback,String message){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CONFIRM_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message});
       writer.endObject();
    }

    public PPromise createImageBitmap(PHTMLImageElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLImageElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap, Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PSVGImageElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLVideoElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PHTMLCanvasElement imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PBlob imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageData imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(PImageBitmap imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise createImageBitmap(POffscreenCanvas imageBitmap, Double sx, Double sy, Double sw, Double sh, PImageBitmapOptions options) {
       return null;
    }


    public PPromise<PResponse> fetch(PRequest input) {
       return null;
    }


    public PPromise<PResponse> fetch(String input) {
       return null;
    }


    public PPromise<PResponse> fetch(PRequest input, PJsObject init) {
       return null;
    }


    public PPromise<PResponse> fetch(String input, PJsObject init) {
       return null;
    }


    public void find(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string});
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string, Boolean caseSensitive){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string,caseSensitive});
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string, Boolean caseSensitive, Boolean backwards){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_TYPEBOOLEAN_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string,caseSensitive,backwards});
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string, Boolean caseSensitive, Boolean backwards, Boolean wrap){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string,caseSensitive,backwards,wrap});
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string, Boolean caseSensitive, Boolean backwards, Boolean wrap, Boolean wholeWord){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string,caseSensitive,backwards,wrap,wholeWord});
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string, Boolean caseSensitive, Boolean backwards, Boolean wrap, Boolean wholeWord, Boolean searchInFrames){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string,caseSensitive,backwards,wrap,wholeWord,searchInFrames});
       writer.endObject();
    }

    public void find(final Consumer<Boolean> cback,String string, Boolean caseSensitive, Boolean backwards, Boolean wrap, Boolean wholeWord, Boolean searchInFrames, Boolean showDialog){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.FIND_TYPESTRING_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {string,caseSensitive,backwards,wrap,wholeWord,searchInFrames,showDialog});
       writer.endObject();
    }

    public void focus(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FOCUS_VOID.getValue());
       writer.endObject();
    }

    public PWindow2 get(Double index) {
       return null;
    }


    public void get(final Consumer<Object> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_TYPESTRING_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public PCSSStyleDeclaration getComputedStyle(PElement elt) {
       return null;
    }


    public PCSSStyleDeclaration getComputedStyle(PElement elt, String pseudoElt) {
       return null;
    }


    public PStylePropertyMapReadonly getComputedStyleMap(PElement element) {
       return null;
    }


    public PStylePropertyMapReadonly getComputedStyleMap(PElement element, String pseudoElement) {
       return null;
    }


    public PCSSRuleList getMatchedCSSRules() {
       return null;
    }


    public PCSSRuleList getMatchedCSSRules(PElement element) {
       return null;
    }


    public PCSSRuleList getMatchedCSSRules(PElement element, String pseudoElement) {
       return null;
    }


    public PSelection getSelection() {
       return null;
    }


    public PMediaQueryList matchMedia(String query) {
       return null;
    }


    public void moveBy(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MOVE_BY_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void moveTo(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       MOVE_TO_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public PWindow2 open(String url, String target) {
       return null;
    }


    public PWindow2 open(String url, String target, String features) {
       return null;
    }


    public PDatabase openDatabase(String name, String version, String displayName, Double estimatedSize) {
       return null;
    }


    public PDatabase openDatabase(String name, String version, String displayName, Double estimatedSize, PDatabaseCallback creationCallback) {
       return null;
    }


    public void postMessage(Object message, String targetOrigin){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       POST_MESSAGE_TYPEOBJECT_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message,targetOrigin});
       writer.endObject();
    }

    public void postMessage(Object message, String targetOrigin, PMessagePort[] transfer){
    }

    public void print(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PRINT_VOID.getValue());
       writer.endObject();
    }

    public void prompt(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.PROMPT_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void prompt(final Consumer<String> cback,String message){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.PROMPT_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message});
       writer.endObject();
    }

    public void prompt(final Consumer<String> cback,String message, String defaultValue){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.PROMPT_TYPESTRING_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {message,defaultValue});
       writer.endObject();
    }

    public void releaseEvents(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RELEASE_EVENTS_VOID.getValue());
       writer.endObject();
    }

    public void requestAnimationFrame(final Consumer<Double> cback,PFrameRequestCallback callback){
    }

    public void requestIdleCallback(final Consumer<Double> cback,PIdleRequestCallback callback){
    }

    public void requestIdleCallback(final Consumer<Double> cback,PIdleRequestCallback callback, PIdleRequestOptions options){
    }

    public void resizeBy(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESIZE_BY_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void resizeTo(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESIZE_TO_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void scroll(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_VOID.getValue());
       writer.endObject();
    }

    public void scroll(PScrollToOptions options){
    }

    public void scroll(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void scrollBy(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_BY_VOID.getValue());
       writer.endObject();
    }

    public void scrollBy(PScrollToOptions options){
    }

    public void scrollBy(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_BY_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void scrollTo(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_TO_VOID.getValue());
       writer.endObject();
    }

    public void scrollTo(PScrollToOptions options){
    }

    public void scrollTo(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_TO_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void setInterval(final Consumer<Double> cback,PCallbackFunction handler){
    }

    public void setInterval(final Consumer<Double> cback,String handler){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_INTERVAL_TYPESTRING_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler});
       writer.endObject();
    }

    public void setInterval(final Consumer<Double> cback,PCallbackFunction handler, Double timeout, Object arguments){
    }

    public void setInterval(final Consumer<Double> cback,String handler, Double timeout, Object arguments){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_INTERVAL_TYPESTRING_TYPEDOUBLE_TYPEOBJECT_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler,timeout,arguments});
       writer.endObject();
    }

    public void setTimeout(final Consumer<Double> cback,PCallbackFunction handler){
    }

    public void setTimeout(final Consumer<Double> cback,String handler){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_TIMEOUT_TYPESTRING_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler});
       writer.endObject();
    }

    public void setTimeout(final Consumer<Double> cback,PCallbackFunction handler, Double timeout, Object arguments){
    }

    public void setTimeout(final Consumer<Double> cback,String handler, Double timeout, Object arguments){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SET_TIMEOUT_TYPESTRING_TYPEDOUBLE_TYPEOBJECT_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {handler,timeout,arguments});
       writer.endObject();
    }

    public void stop(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STOP_VOID.getValue());
       writer.endObject();
    }

    public void webkitCancelAnimationFrame(Double id){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_CANCEL_ANIMATION_FRAME_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {id});
       writer.endObject();
    }

    public void webkitRequestAnimationFrame(final Consumer<Double> cback,PFrameRequestCallback callback){
    }

    public void webkitRequestFileSystem(Short type, Double size, PFileSystemCallback successCallback){
    }

    public void webkitRequestFileSystem(Short type, Double size, PFileSystemCallback successCallback, PErrorCallback errorCallback){
    }

    public void webkitResolveLocalFileSystemURL(String url, PEntryCallback successCallback){
    }

    public void webkitResolveLocalFileSystemURL(String url, PEntryCallback successCallback, PErrorCallback errorCallback){
    }

    
}