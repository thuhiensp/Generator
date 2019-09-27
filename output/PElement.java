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
import java.util.ArrayList;
import java.util.List;
import com.ponysdk.core.model.ServerToClientModel;
import com.ponysdk.core.writer.ModelWriter;
import com.ponysdk.core.server.application.UIContext;

public abstract class PElement extends PNode {
    private static final Logger log = LoggerFactory.getLogger(PElement.class);
     private List<PElement> children;
     private PElement parent;

    public PElement getChildren(final int indexOfChild) {
       return children.get(indexOfChild);
    }

    public PElement getParent() {
       return parent;
    }

    public void add(final PElement child) {
       if (children == null) children = new ArrayList<>();
       children.add(child);
       adopt(child);
       if (initialized) {
          child.attach(pWindow);
          add0(child);
       }
    }

     protected void adopt(final PElement child) {
       child.parent = this;
    }

    public void removeChild(final PElement child) {

    }

    protected void add0(final PObject2 pObject2) {
       final int childId = pObject2.getID();
       final int parentId = this.getID();
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_TYPE_ADD, childId);
       writer.write(ServerToClientModel.POBJECT2_PARENT_OBJECT_ID, parentId);
       writer.endObject();
    }

    @Override
    public void creatAllChild() {
       if (children != null) {
            for (final PElement child : children) {
                child.attach(pWindow);
                add0(child);
            }
       }
    }


     protected PElement() {
     }
    protected PElement(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setId(final String id)  {
       setAttribute(PAttributeNames.ID, id);
       log.info("id" + id);
    }
    public void setClassName(final String className)  {
       setAttribute(PAttributeNames.CLASS_NAME, className);
       log.info("className" + className);
    }
    public void setSlot(final String slot)  {
       setAttribute(PAttributeNames.SLOT, slot);
       log.info("slot" + slot);
    }
    public void setInnerHTML(final String innerHTML)  {
       setAttribute(PAttributeNames.INNERHTML, innerHTML);
       log.info("innerHTML" + innerHTML);
    }
    public void setOuterHTML(final String outerHTML)  {
       setAttribute(PAttributeNames.OUTERHTML, outerHTML);
       log.info("outerHTML" + outerHTML);
    }
    public void setScrollTop(final Double scrollTop)  {
       setAttribute(PAttributeNames.SCROLL_TOP, scrollTop);
       log.info("scrollTop" + scrollTop);
    }
    public void setScrollLeft(final Double scrollLeft)  {
       setAttribute(PAttributeNames.SCROLL_LEFT, scrollLeft);
       log.info("scrollLeft" + scrollLeft);
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

    public String getId(){
      return (String) getAttribute(PAttributeNames.ID);
    }
    public String getClassName(){
      return (String) getAttribute(PAttributeNames.CLASS_NAME);
    }
    public String getSlot(){
      return (String) getAttribute(PAttributeNames.SLOT);
    }
    public String getInnerHTML(){
      return (String) getAttribute(PAttributeNames.INNERHTML);
    }
    public String getOuterHTML(){
      return (String) getAttribute(PAttributeNames.OUTERHTML);
    }
    public Double getScrollTop(){
      return (Double) getAttribute(PAttributeNames.SCROLL_TOP);
    }
    public Double getScrollLeft(){
      return (Double) getAttribute(PAttributeNames.SCROLL_LEFT);
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


    public final void after(PNode nodes){
    }

    public final void after(String nodes){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       AFTER_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {nodes});
       writer.endObject();
    }

    public PAnimation animate(PJsObject[] effect) {
       return null;
    }


    public PAnimation animate(PJsObject effect) {
       return null;
    }


    public PAnimation animate(PJsObject[] effect, Double options) {
       return null;
    }


    public PAnimation animate(PJsObject[] effect, PKeyframeAnimationOptions options) {
       return null;
    }


    public PAnimation animate(PJsObject effect, Double options) {
       return null;
    }


    public PAnimation animate(PJsObject effect, PKeyframeAnimationOptions options) {
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

    public PShadowRoot attachShadow(PShadowRootInit shadowRootInitDict) {
       return null;
    }


    public final void before(PNode nodes){
    }

    public final void before(String nodes){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BEFORE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {nodes});
       writer.endObject();
    }

    public PElement closest(String selectors) {
       return null;
    }


    public PShadowRoot createShadowRoot() {
       return null;
    }


    public PAnimation[] getAnimations() {
       return null;
    }


    public void getAttribute(final Consumer<String> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_ATTRIBUTE_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void getAttributeNS(final Consumer<String> cback,String namespaceURI, String localName){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_ATTRIBUTENS_TYPESTRING_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {namespaceURI,localName});
       writer.endObject();
    }

    public String[] getAttributeNames() {
       return null;
    }


    public PAttr getAttributeNode(String name) {
       return null;
    }


    public PAttr getAttributeNodeNS(String namespaceURI, String localName) {
       return null;
    }


    public PClientRect getBoundingClientRect() {
       return null;
    }


    public PClientRectList getClientRects() {
       return null;
    }


    public PNodeList getDestinationInsertionPoints() {
       return null;
    }


    public PHTMLCollection getElementsByClassName(String classNames) {
       return null;
    }


    public PHTMLCollection getElementsByTagName(String localName) {
       return null;
    }


    public PHTMLCollection getElementsByTagNameNS(String namespaceURI, String localName) {
       return null;
    }


    public void hasAttribute(final Consumer<Boolean> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_ATTRIBUTE_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void hasAttributeNS(final Consumer<Boolean> cback,String namespaceURI, String localName){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_ATTRIBUTENS_TYPESTRING_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {namespaceURI,localName});
       writer.endObject();
    }

    public void hasAttributes(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_ATTRIBUTES_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void hasPointerCapture(final Consumer<Boolean> cback,Double pointerId){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_POINTER_CAPTURE_TYPEDOUBLE_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {pointerId});
       writer.endObject();
    }

    public PElement insertAdjacentElement(String where, PElement element) {
       return null;
    }


    public void insertAdjacentHTML(String position, String text){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       INSERT_ADJACENTHTML_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {position,text});
       writer.endObject();
    }

    public void insertAdjacentText(String where, String data){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       INSERT_ADJACENT_TEXT_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {where,data});
       writer.endObject();
    }

    public void matches(final Consumer<Boolean> cback,String selectors){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.MATCHES_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {selectors});
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

    public <T extends PElement> T querySelector(String selectors) {
       return null;
    }


    public PNodeList querySelectorAll(String selectors) {
       return null;
    }


    public void releasePointerCapture(Double pointerId){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RELEASE_POINTER_CAPTURE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {pointerId});
       writer.endObject();
    }

    public void remove(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_VOID.getValue());
       writer.endObject();
    }

    public void removeAttribute(String name){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_ATTRIBUTE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void removeAttributeNS(String namespaceURI, String localName){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REMOVE_ATTRIBUTENS_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {namespaceURI,localName});
       writer.endObject();
    }

    public PAttr removeAttributeNode(PAttr attr) {
       return null;
    }


    public final void replaceWith(PNode nodes){
    }

    public final void replaceWith(String nodes){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REPLACE_WITH_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {nodes});
       writer.endObject();
    }

    public void requestFullscreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REQUEST_FULLSCREEN_VOID.getValue());
       writer.endObject();
    }

    public void requestPointerLock(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REQUEST_POINTER_LOCK_VOID.getValue());
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

    public void scrollIntoView(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_INTO_VIEW_VOID.getValue());
       writer.endObject();
    }

    public void scrollIntoView(PScrollIntoViewOptions arg){
    }

    public void scrollIntoView(Boolean arg){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_INTO_VIEW_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {arg});
       writer.endObject();
    }

    public void scrollIntoViewIfNeeded(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_INTO_VIEW_IF_NEEDED_VOID.getValue());
       writer.endObject();
    }

    public void scrollIntoViewIfNeeded(Boolean centerIfNeeded){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCROLL_INTO_VIEW_IF_NEEDED_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {centerIfNeeded});
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

    public void setApplyScroll(PScrollStateCallback scrollStateCallback, PNativeScrollBehavior nativeScrollBehavior){
    }

    public void setApplyScroll(PScrollStateCallback scrollStateCallback, String nativeScrollBehavior){
    }

    public void setAttribute(String name, String value){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_ATTRIBUTE_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name,value});
       writer.endObject();
    }

    public void setAttributeNS(String namespaceURI, String name, String value){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_ATTRIBUTENS_TYPESTRING_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {namespaceURI,name,value});
       writer.endObject();
    }

    public PAttr setAttributeNode(PAttr attr) {
       return null;
    }


    public PAttr setAttributeNodeNS(PAttr attr) {
       return null;
    }


    public void setDistributeScroll(PScrollStateCallback scrollStateCallback, PNativeScrollBehavior nativeScrollBehavior){
    }

    public void setDistributeScroll(PScrollStateCallback scrollStateCallback, String nativeScrollBehavior){
    }

    public void setPointerCapture(Double pointerId){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_POINTER_CAPTURE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {pointerId});
       writer.endObject();
    }

    public void webkitMatchesSelector(final Consumer<Boolean> cback,String selectors){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.WEBKIT_MATCHES_SELECTOR_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {selectors});
       writer.endObject();
    }

    public void webkitRequestFullScreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_REQUEST_FULL_SCREEN_VOID.getValue());
       writer.endObject();
    }

    public void webkitRequestFullscreen(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       WEBKIT_REQUEST_FULLSCREEN_VOID.getValue());
       writer.endObject();
    }

    
}