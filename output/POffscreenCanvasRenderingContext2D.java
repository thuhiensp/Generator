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
public class POffscreenCanvasRenderingContext2D extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(POffscreenCanvasRenderingContext2D.class);
    private POffscreenCanvasRenderingContext2D(){
    }

    public void setGlobalAlpha(final Double globalAlpha)  {
       setAttribute(PAttributeNames.GLOBAL_ALPHA, globalAlpha);
       log.info("globalAlpha" + globalAlpha);
    }
    public void setGlobalCompositeOperation(final String globalCompositeOperation)  {
       setAttribute(PAttributeNames.GLOBAL_COMPOSITE_OPERATION, globalCompositeOperation);
       log.info("globalCompositeOperation" + globalCompositeOperation);
    }
    public void setFilter(final String filter)  {
       setAttribute(PAttributeNames.FILTER, filter);
       log.info("filter" + filter);
    }
    public void setImageSmoothingEnabled(final Boolean imageSmoothingEnabled)  {
       setAttribute(PAttributeNames.IMAGE_SMOOTHING_ENABLED, imageSmoothingEnabled);
       log.info("imageSmoothingEnabled" + imageSmoothingEnabled);
    }
    public void setStrokeStyle(final PCanvasGradientOrCanvasPatternOrString strokeStyle)  {
       setAttribute(PAttributeNames.STROKE_STYLE, strokeStyle);
       log.info("strokeStyle" + strokeStyle);
    }
    public void setFillStyle(final PCanvasGradientOrCanvasPatternOrString fillStyle)  {
       setAttribute(PAttributeNames.FILL_STYLE, fillStyle);
       log.info("fillStyle" + fillStyle);
    }
    public void setShadowOffsetX(final Double shadowOffsetX)  {
       setAttribute(PAttributeNames.SHADOW_OFFSETX, shadowOffsetX);
       log.info("shadowOffsetX" + shadowOffsetX);
    }
    public void setShadowOffsetY(final Double shadowOffsetY)  {
       setAttribute(PAttributeNames.SHADOW_OFFSETY, shadowOffsetY);
       log.info("shadowOffsetY" + shadowOffsetY);
    }
    public void setShadowBlur(final Double shadowBlur)  {
       setAttribute(PAttributeNames.SHADOW_BLUR, shadowBlur);
       log.info("shadowBlur" + shadowBlur);
    }
    public void setShadowColor(final String shadowColor)  {
       setAttribute(PAttributeNames.SHADOW_COLOR, shadowColor);
       log.info("shadowColor" + shadowColor);
    }
    public void setLineWidth(final Double lineWidth)  {
       setAttribute(PAttributeNames.LINE_WIDTH, lineWidth);
       log.info("lineWidth" + lineWidth);
    }
    public void setLineCap(final String lineCap)  {
       setAttribute(PAttributeNames.LINE_CAP, lineCap);
       log.info("lineCap" + lineCap);
    }
    public void setLineJoin(final String lineJoin)  {
       setAttribute(PAttributeNames.LINE_JOIN, lineJoin);
       log.info("lineJoin" + lineJoin);
    }
    public void setMiterLimit(final Double miterLimit)  {
       setAttribute(PAttributeNames.MITER_LIMIT, miterLimit);
       log.info("miterLimit" + miterLimit);
    }
    public void setLineDashOffset(final Double lineDashOffset)  {
       setAttribute(PAttributeNames.LINE_DASH_OFFSET, lineDashOffset);
       log.info("lineDashOffset" + lineDashOffset);
    }
    public void setImageSmoothingQuality(final PImageSmoothingQuality imageSmoothingQuality)  {
       setAttribute(PAttributeNames.IMAGE_SMOOTHING_QUALITY, imageSmoothingQuality);
       log.info("imageSmoothingQuality" + imageSmoothingQuality);
    }

    public Double getGlobalAlpha(){
      return (Double) getAttribute(PAttributeNames.GLOBAL_ALPHA);
    }
    public String getGlobalCompositeOperation(){
      return (String) getAttribute(PAttributeNames.GLOBAL_COMPOSITE_OPERATION);
    }
    public String getFilter(){
      return (String) getAttribute(PAttributeNames.FILTER);
    }
    public Boolean getImageSmoothingEnabled(){
      return (Boolean) getAttribute(PAttributeNames.IMAGE_SMOOTHING_ENABLED);
    }
    public PCanvasGradientOrCanvasPatternOrString getStrokeStyle(){
      return (PCanvasGradientOrCanvasPatternOrString) getAttribute(PAttributeNames.STROKE_STYLE);
    }
    public PCanvasGradientOrCanvasPatternOrString getFillStyle(){
      return (PCanvasGradientOrCanvasPatternOrString) getAttribute(PAttributeNames.FILL_STYLE);
    }
    public Double getShadowOffsetX(){
      return (Double) getAttribute(PAttributeNames.SHADOW_OFFSETX);
    }
    public Double getShadowOffsetY(){
      return (Double) getAttribute(PAttributeNames.SHADOW_OFFSETY);
    }
    public Double getShadowBlur(){
      return (Double) getAttribute(PAttributeNames.SHADOW_BLUR);
    }
    public String getShadowColor(){
      return (String) getAttribute(PAttributeNames.SHADOW_COLOR);
    }
    public Double getLineWidth(){
      return (Double) getAttribute(PAttributeNames.LINE_WIDTH);
    }
    public String getLineCap(){
      return (String) getAttribute(PAttributeNames.LINE_CAP);
    }
    public String getLineJoin(){
      return (String) getAttribute(PAttributeNames.LINE_JOIN);
    }
    public Double getMiterLimit(){
      return (Double) getAttribute(PAttributeNames.MITER_LIMIT);
    }
    public Double getLineDashOffset(){
      return (Double) getAttribute(PAttributeNames.LINE_DASH_OFFSET);
    }
    public PImageSmoothingQuality getImageSmoothingQuality(){
      return (PImageSmoothingQuality) getAttribute(PAttributeNames.IMAGE_SMOOTHING_QUALITY);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void arc(Double x, Double y, Double radius, Double startAngle, Double endAngle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ARC_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radius,startAngle,endAngle});
       writer.endObject();
    }

    public void arc(Double x, Double y, Double radius, Double startAngle, Double endAngle, Boolean anticlockwise){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ARC_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radius,startAngle,endAngle,anticlockwise});
       writer.endObject();
    }

    public void arcTo(Double x1, Double y1, Double x2, Double y2, Double radius){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ARC_TO_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x1,y1,x2,y2,radius});
       writer.endObject();
    }

    public void beginPath(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BEGIN_PATH_VOID.getValue());
       writer.endObject();
    }

    public void bezierCurveTo(Double cp1x, Double cp1y, Double cp2x, Double cp2y, Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BEZIER_CURVE_TO_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cp1x,cp1y,cp2x,cp2y,x,y});
       writer.endObject();
    }

    public void clearRect(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_RECT_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    public void clip(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLIP_VOID.getValue());
       writer.endObject();
    }

    public void clip(PPath2D path){
    }

    public void closePath(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_PATH_VOID.getValue());
       writer.endObject();
    }

    public PPromise commit() {
       return null;
    }


    public PImageData createImageData(PImageData imagedata) {
       return null;
    }


    public PImageData createImageData(Double sw, Double sh) {
       return null;
    }


    public PImageData createImageData(Double sw, Double sh, PImageDataColorSettings imageDataColorSettings) {
       return null;
    }


    public PImageData createImageData(PUint8ClampedArray data, Double sw, Double sh, PImageDataColorSettings imageDataColorSettings) {
       return null;
    }


    public PImageData createImageData(PUint16Array data, Double sw, Double sh, PImageDataColorSettings imageDataColorSettings) {
       return null;
    }


    public PImageData createImageData(PFloat32Array data, Double sw, Double sh, PImageDataColorSettings imageDataColorSettings) {
       return null;
    }


    public PCanvasGradient createLinearGradient(Double x0, Double y0, Double x1, Double y1) {
       return null;
    }


    public PCanvasPattern createPattern(PCSSImageValue image, String repetitionType) {
       return null;
    }


    public PCanvasPattern createPattern(PHTMLImageElement image, String repetitionType) {
       return null;
    }


    public PCanvasPattern createPattern(PSVGImageElement image, String repetitionType) {
       return null;
    }


    public PCanvasPattern createPattern(PHTMLVideoElement image, String repetitionType) {
       return null;
    }


    public PCanvasPattern createPattern(PHTMLCanvasElement image, String repetitionType) {
       return null;
    }


    public PCanvasPattern createPattern(PImageBitmap image, String repetitionType) {
       return null;
    }


    public PCanvasPattern createPattern(POffscreenCanvas image, String repetitionType) {
       return null;
    }


    public PCanvasGradient createRadialGradient(Double x0, Double y0, Double r0, Double x1, Double y1, Double r1) {
       return null;
    }


    public void drawImage(PCSSImageValue image, Double x, Double y){
    }

    public void drawImage(PHTMLImageElement image, Double x, Double y){
    }

    public void drawImage(PSVGImageElement image, Double x, Double y){
    }

    public void drawImage(PHTMLVideoElement image, Double x, Double y){
    }

    public void drawImage(PHTMLCanvasElement image, Double x, Double y){
    }

    public void drawImage(PImageBitmap image, Double x, Double y){
    }

    public void drawImage(POffscreenCanvas image, Double x, Double y){
    }

    public void drawImage(PCSSImageValue image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(PHTMLImageElement image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(PSVGImageElement image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(PHTMLVideoElement image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(PHTMLCanvasElement image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(PImageBitmap image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(POffscreenCanvas image, Double x, Double y, Double width, Double height){
    }

    public void drawImage(PCSSImageValue image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void drawImage(PHTMLImageElement image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void drawImage(PSVGImageElement image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void drawImage(PHTMLVideoElement image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void drawImage(PHTMLCanvasElement image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void drawImage(PImageBitmap image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void drawImage(POffscreenCanvas image, Double sx, Double sy, Double sw, Double sh, Double dx, Double dy, Double dw, Double dh){
    }

    public void ellipse(Double x, Double y, Double radiusX, Double radiusY, Double rotation, Double startAngle, Double endAngle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ELLIPSE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radiusX,radiusY,rotation,startAngle,endAngle});
       writer.endObject();
    }

    public void ellipse(Double x, Double y, Double radiusX, Double radiusY, Double rotation, Double startAngle, Double endAngle, Boolean anticlockwise){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ELLIPSE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,radiusX,radiusY,rotation,startAngle,endAngle,anticlockwise});
       writer.endObject();
    }

    public void fill(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FILL_VOID.getValue());
       writer.endObject();
    }

    public void fill(PCanvasFillRule winding){
    }

    public void fill(PPath2D path){
    }

    public void fill(String winding){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FILL_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {winding});
       writer.endObject();
    }

    public void fill(PPath2D path, PCanvasFillRule winding){
    }

    public void fill(PPath2D path, String winding){
    }

    public void fillRect(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FILL_RECT_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    public PImageData getImageData(Double sx, Double sy, Double sw, Double sh) {
       return null;
    }


    public Double[] getLineDash() {
       return null;
    }


    public void isPointInPath(final Consumer<Boolean> cback,Double x, Double y){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_POINT_IN_PATH_TYPEDOUBLE_TYPEDOUBLE_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void isPointInPath(final Consumer<Boolean> cback,Double x, Double y, PCanvasFillRule winding){
    }

    public void isPointInPath(final Consumer<Boolean> cback,PPath2D path, Double x, Double y){
    }

    public void isPointInPath(final Consumer<Boolean> cback,Double x, Double y, String winding){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_POINT_IN_PATH_TYPEDOUBLE_TYPEDOUBLE_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,winding});
       writer.endObject();
    }

    public void isPointInPath(final Consumer<Boolean> cback,PPath2D path, Double x, Double y, PCanvasFillRule winding){
    }

    public void isPointInPath(final Consumer<Boolean> cback,PPath2D path, Double x, Double y, String winding){
    }

    public void isPointInStroke(final Consumer<Boolean> cback,Double x, Double y){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_POINT_IN_STROKE_TYPEDOUBLE_TYPEDOUBLE_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void isPointInStroke(final Consumer<Boolean> cback,PPath2D path, Double x, Double y){
    }

    public void lineTo(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       LINE_TO_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
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

    public void putImageData(PImageData imagedata, Double dx, Double dy){
    }

    public void putImageData(PImageData imagedata, Double dx, Double dy, Double dirtyX, Double dirtyY, Double dirtyWidth, Double dirtyHeight){
    }

    public void quadraticCurveTo(Double cpx, Double cpy, Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       QUADRATIC_CURVE_TO_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cpx,cpy,x,y});
       writer.endObject();
    }

    public void rect(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RECT_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    public void resetTransform(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESET_TRANSFORM_VOID.getValue());
       writer.endObject();
    }

    public void restore(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RESTORE_VOID.getValue());
       writer.endObject();
    }

    public void rotate(Double angle){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ROTATE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {angle});
       writer.endObject();
    }

    public void save(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SAVE_VOID.getValue());
       writer.endObject();
    }

    public void scale(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCALE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    public void setLineDash(Double[] dash){
    }

    public void setTransform(Double a, Double b, Double c, Double d, Double e, Double f){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_TRANSFORM_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {a,b,c,d,e,f});
       writer.endObject();
    }

    public void stroke(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STROKE_VOID.getValue());
       writer.endObject();
    }

    public void stroke(PPath2D path){
    }

    public void strokeRect(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STROKE_RECT_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    public void transform(Double a, Double b, Double c, Double d, Double e, Double f){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       TRANSFORM_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {a,b,c,d,e,f});
       writer.endObject();
    }

    public void translate(Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       TRANSLATE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y});
       writer.endObject();
    }

    
}