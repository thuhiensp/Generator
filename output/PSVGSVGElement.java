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
public class PSVGSVGElement extends PSVGGraphicsElement {
    private static final Logger log = LoggerFactory.getLogger(PSVGSVGElement.class);
    public PSVGSVGElement() {
    }

    public void setCurrentScale(final Double currentScale)  {
       setAttribute(PAttributeNames.CURRENT_SCALE, currentScale);
       log.info("currentScale" + currentScale);
    }
    public void setZoomAndPan(final Short zoomAndPan)  {
       setAttribute(PAttributeNames.ZOOM_AND_PAN, zoomAndPan);
       log.info("zoomAndPan" + zoomAndPan);
    }

    public Double getCurrentScale(){
      return (Double) getAttribute(PAttributeNames.CURRENT_SCALE);
    }
    public Short getZoomAndPan(){
      return (Short) getAttribute(PAttributeNames.ZOOM_AND_PAN);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.SVGSVG_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void animationsPaused(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.ANIMATIONS_PAUSED_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void checkEnclosure(final Consumer<Boolean> cback,PSVGElement element, PSVGRect rect){
    }

    public void checkIntersection(final Consumer<Boolean> cback,PSVGElement element, PSVGRect rect){
    }

    public PSVGAngle createSVGAngle() {
       return null;
    }


    public PSVGLength createSVGLength() {
       return null;
    }


    public PSVGMatrix createSVGMatrix() {
       return null;
    }


    public PSVGNumber createSVGNumber() {
       return null;
    }


    public PSVGPoint createSVGPoint() {
       return null;
    }


    public PSVGRect createSVGRect() {
       return null;
    }


    public PSVGTransform createSVGTransform() {
       return null;
    }


    public PSVGTransform createSVGTransformFromMatrix(PSVGMatrix matrix) {
       return null;
    }


    public void deselectAll(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DESELECT_ALL_VOID.getValue());
       writer.endObject();
    }

    public void forceRedraw(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FORCE_REDRAW_VOID.getValue());
       writer.endObject();
    }

    public void getCurrentTime(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_CURRENT_TIME_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public <T extends PElement> T getElementById(String elementId) {
       return null;
    }


    public PNodeList getEnclosureList(PSVGRect rect, PSVGElement referenceElement) {
       return null;
    }


    public PNodeList getIntersectionList(PSVGRect rect, PSVGElement referenceElement) {
       return null;
    }


    public void pauseAnimations(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PAUSE_ANIMATIONS_VOID.getValue());
       writer.endObject();
    }

    public void setCurrentTime(Double seconds){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_CURRENT_TIME_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {seconds});
       writer.endObject();
    }

    public void suspendRedraw(final Consumer<Double> cback,Double maxWaitMilliseconds){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.SUSPEND_REDRAW_TYPEDOUBLE_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {maxWaitMilliseconds});
       writer.endObject();
    }

    public void unpauseAnimations(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       UNPAUSE_ANIMATIONS_VOID.getValue());
       writer.endObject();
    }

    public void unsuspendRedraw(Double suspendHandleId){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       UNSUSPEND_REDRAW_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {suspendHandleId});
       writer.endObject();
    }

    public void unsuspendRedrawAll(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       UNSUSPEND_REDRAW_ALL_VOID.getValue());
       writer.endObject();
    }

    
}