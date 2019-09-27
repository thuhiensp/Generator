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
import java.util.function.Consumer;
public class PWebGLRenderingContextBase extends PObject2 {
    private PWebGLRenderingContextBase(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void activeTexture(Double texture){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ACTIVE_TEXTURE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {texture});
       writer.endObject();
    }

    public void attachShader(PWebGLProgram program, PWebGLShader shader){
    }

    public void bindAttribLocation(PWebGLProgram program, Double index, String name){
    }

    public void bindBuffer(Double target, PWebGLBuffer buffer){
    }

    public void bindFramebuffer(Double target, PWebGLFramebuffer framebuffer){
    }

    public void bindRenderbuffer(Double target, PWebGLRenderbuffer renderbuffer){
    }

    public void bindTexture(Double target, PWebGLTexture texture){
    }

    public void blendColor(Double red, Double green, Double blue, Double alpha){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BLEND_COLOR_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {red,green,blue,alpha});
       writer.endObject();
    }

    public void blendEquation(Double mode){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BLEND_EQUATION_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mode});
       writer.endObject();
    }

    public void blendEquationSeparate(Double modeRGB, Double modeAlpha){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BLEND_EQUATION_SEPARATE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {modeRGB,modeAlpha});
       writer.endObject();
    }

    public void blendFunc(Double sfactor, Double dfactor){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BLEND_FUNC_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {sfactor,dfactor});
       writer.endObject();
    }

    public void blendFuncSeparate(Double srcRGB, Double dstRGB, Double srcAlpha, Double dstAlpha){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BLEND_FUNC_SEPARATE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {srcRGB,dstRGB,srcAlpha,dstAlpha});
       writer.endObject();
    }

    public void bufferData(Double target, Double size, Double usage){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       BUFFER_DATA_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,size,usage});
       writer.endObject();
    }

    public void bufferData(Double target, PArrayBufferView data, Double usage){
    }

    public void bufferData(Double target, PArrayBuffer data, Double usage){
    }

    public void bufferSubData(Double target, Double offset, PArrayBufferView data){
    }

    public void bufferSubData(Double target, Double offset, PArrayBuffer data){
    }

    public void checkFramebufferStatus(final Consumer<Double> cback,Double target){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CHECK_FRAMEBUFFER_STATUS_TYPEDOUBLE_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target});
       writer.endObject();
    }

    public void clear(Double mask){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mask});
       writer.endObject();
    }

    public void clearColor(Double red, Double green, Double blue, Double alpha){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_COLOR_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {red,green,blue,alpha});
       writer.endObject();
    }

    public void clearDepth(Double depth){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_DEPTH_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {depth});
       writer.endObject();
    }

    public void clearStencil(Double s){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLEAR_STENCIL_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {s});
       writer.endObject();
    }

    public void colorMask(Boolean red, Boolean green, Boolean blue, Boolean alpha){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COLOR_MASK_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {red,green,blue,alpha});
       writer.endObject();
    }

    public PPromise commit() {
       return null;
    }


    public void compileShader(PWebGLShader shader){
    }

    public void compressedTexImage2D(Double target, Double level, Double internalformat, Double width, Double height, Double border, PArrayBufferView data){
    }

    public void compressedTexSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double width, Double height, Double format, PArrayBufferView data){
    }

    public void copyTexImage2D(Double target, Double level, Double internalformat, Double x, Double y, Double width, Double height, Double border){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COPY_TEX_IMAGE2D_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,level,internalformat,x,y,width,height,border});
       writer.endObject();
    }

    public void copyTexSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       COPY_TEX_SUB_IMAGE2D_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,level,xoffset,yoffset,x,y,width,height});
       writer.endObject();
    }

    public PWebGLBuffer createBuffer() {
       return null;
    }


    public PWebGLFramebuffer createFramebuffer() {
       return null;
    }


    public PWebGLProgram createProgram() {
       return null;
    }


    public PWebGLRenderbuffer createRenderbuffer() {
       return null;
    }


    public PWebGLShader createShader(Double type) {
       return null;
    }


    public PWebGLTexture createTexture() {
       return null;
    }


    public void cullFace(Double mode){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CULL_FACE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mode});
       writer.endObject();
    }

    public void deleteBuffer(PWebGLBuffer buffer){
    }

    public void deleteFramebuffer(PWebGLFramebuffer framebuffer){
    }

    public void deleteProgram(PWebGLProgram program){
    }

    public void deleteRenderbuffer(PWebGLRenderbuffer renderbuffer){
    }

    public void deleteShader(PWebGLShader shader){
    }

    public void deleteTexture(PWebGLTexture texture){
    }

    public void depthFunc(Double func){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DEPTH_FUNC_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {func});
       writer.endObject();
    }

    public void depthMask(Boolean flag){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DEPTH_MASK_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {flag});
       writer.endObject();
    }

    public void depthRange(Double zNear, Double zFar){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DEPTH_RANGE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {zNear,zFar});
       writer.endObject();
    }

    public void detachShader(PWebGLProgram program, PWebGLShader shader){
    }

    public void disable(Double cap){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DISABLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cap});
       writer.endObject();
    }

    public void disableVertexAttribArray(Double index){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DISABLE_VERTEX_ATTRIB_ARRAY_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index});
       writer.endObject();
    }

    public void drawArrays(Double mode, Double first, Double count){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DRAW_ARRAYS_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mode,first,count});
       writer.endObject();
    }

    public void drawElements(Double mode, Double count, Double type, Double offset){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       DRAW_ELEMENTS_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mode,count,type,offset});
       writer.endObject();
    }

    public void enable(Double cap){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ENABLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cap});
       writer.endObject();
    }

    public void enableVertexAttribArray(Double index){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ENABLE_VERTEX_ATTRIB_ARRAY_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index});
       writer.endObject();
    }

    public void finish(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FINISH_VOID.getValue());
       writer.endObject();
    }

    public void flush(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FLUSH_VOID.getValue());
       writer.endObject();
    }

    public void framebufferRenderbuffer(Double target, Double attachment, Double renderbuffertarget, PWebGLRenderbuffer renderbuffer){
    }

    public void framebufferTexture2D(Double target, Double attachment, Double textarget, PWebGLTexture texture, Double level){
    }

    public void frontFace(Double mode){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       FRONT_FACE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mode});
       writer.endObject();
    }

    public void generateMipmap(Double target){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       GENERATE_MIPMAP_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target});
       writer.endObject();
    }

    public PWebGLActiveInfo getActiveAttrib(PWebGLProgram program, Double index) {
       return null;
    }


    public PWebGLActiveInfo getActiveUniform(PWebGLProgram program, Double index) {
       return null;
    }


    public PWebGLShader[] getAttachedShaders(PWebGLProgram program) {
       return null;
    }


    public void getAttribLocation(final Consumer<Double> cback,PWebGLProgram program, String name){
    }

    public void getBufferParameter(final Consumer<Object> cback,Double target, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_BUFFER_PARAMETER_TYPEDOUBLE_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,pname});
       writer.endObject();
    }

    public PWebGLContextAttributes getContextAttributes() {
       return null;
    }


    public void getError(final Consumer<Double> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_ERROR_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void getExtension(final Consumer<Object> cback,String name){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_EXTENSION_TYPESTRING_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {name});
       writer.endObject();
    }

    public void getFramebufferAttachmentParameter(final Consumer<Object> cback,Double target, Double attachment, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_FRAMEBUFFER_ATTACHMENT_PARAMETER_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,attachment,pname});
       writer.endObject();
    }

    public void getParameter(final Consumer<Object> cback,Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_PARAMETER_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {pname});
       writer.endObject();
    }

    public void getProgramInfoLog(final Consumer<String> cback,PWebGLProgram program){
    }

    public void getProgramParameter(final Consumer<Object> cback,PWebGLProgram program, Double pname){
    }

    public void getRenderbufferParameter(final Consumer<Object> cback,Double target, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_RENDERBUFFER_PARAMETER_TYPEDOUBLE_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,pname});
       writer.endObject();
    }

    public void getShaderInfoLog(final Consumer<String> cback,PWebGLShader shader){
    }

    public void getShaderParameter(final Consumer<Object> cback,PWebGLShader shader, Double pname){
    }

    public PWebGLShaderPrecisionFormat getShaderPrecisionFormat(Double shadertype, Double precisiontype) {
       return null;
    }


    public void getShaderSource(final Consumer<String> cback,PWebGLShader shader){
    }

    public String[] getSupportedExtensions() {
       return null;
    }


    public void getTexParameter(final Consumer<Object> cback,Double target, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_TEX_PARAMETER_TYPEDOUBLE_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,pname});
       writer.endObject();
    }

    public void getUniform(final Consumer<Object> cback,PWebGLProgram program, PWebGLUniformLocation location){
    }

    public PWebGLUniformLocation getUniformLocation(PWebGLProgram program, String name) {
       return null;
    }


    public void getVertexAttrib(final Consumer<Object> cback,Double index, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_VERTEX_ATTRIB_TYPEDOUBLE_TYPEDOUBLE_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index,pname});
       writer.endObject();
    }

    public void getVertexAttribOffset(final Consumer<Double> cback,Double index, Double pname){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.GET_VERTEX_ATTRIB_OFFSET_TYPEDOUBLE_TYPEDOUBLE_DOUBLE.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {index,pname});
       writer.endObject();
    }

    public void hint(Double target, Double mode){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       HINT_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,mode});
       writer.endObject();
    }

    public void isBuffer(final Consumer<Boolean> cback,PWebGLBuffer buffer){
    }

    public void isContextLost(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_CONTEXT_LOST_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void isEnabled(final Consumer<Boolean> cback,Double cap){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_ENABLED_TYPEDOUBLE_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {cap});
       writer.endObject();
    }

    public void isFramebuffer(final Consumer<Boolean> cback,PWebGLFramebuffer framebuffer){
    }

    public void isProgram(final Consumer<Boolean> cback,PWebGLProgram program){
    }

    public void isRenderbuffer(final Consumer<Boolean> cback,PWebGLRenderbuffer renderbuffer){
    }

    public void isShader(final Consumer<Boolean> cback,PWebGLShader shader){
    }

    public void isTexture(final Consumer<Boolean> cback,PWebGLTexture texture){
    }

    public void lineWidth(Double width){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       LINE_WIDTH_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {width});
       writer.endObject();
    }

    public void linkProgram(PWebGLProgram program){
    }

    public void pixelStorei(Double pname, Double param){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       PIXEL_STOREI_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {pname,param});
       writer.endObject();
    }

    public void polygonOffset(Double factor, Double units){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       POLYGON_OFFSET_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {factor,units});
       writer.endObject();
    }

    public void readPixels(Double x, Double y, Double width, Double height, Double format, Double type, PArrayBufferView pixels){
    }

    public void renderbufferStorage(Double target, Double internalformat, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RENDERBUFFER_STORAGE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,internalformat,width,height});
       writer.endObject();
    }

    public void sampleCoverage(Double value, Boolean invert){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SAMPLE_COVERAGE_TYPEDOUBLE_TYPEBOOLEAN_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {value,invert});
       writer.endObject();
    }

    public void scissor(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SCISSOR_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    public void shaderSource(PWebGLShader shader, String string){
    }

    public void stencilFunc(Double func, Double ref, Double mask){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STENCIL_FUNC_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {func,ref,mask});
       writer.endObject();
    }

    public void stencilFuncSeparate(Double face, Double func, Double ref, Double mask){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STENCIL_FUNC_SEPARATE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {face,func,ref,mask});
       writer.endObject();
    }

    public void stencilMask(Double mask){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STENCIL_MASK_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {mask});
       writer.endObject();
    }

    public void stencilMaskSeparate(Double face, Double mask){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STENCIL_MASK_SEPARATE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {face,mask});
       writer.endObject();
    }

    public void stencilOp(Double fail, Double zfail, Double zpass){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STENCIL_OP_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {fail,zfail,zpass});
       writer.endObject();
    }

    public void stencilOpSeparate(Double face, Double fail, Double zfail, Double zpass){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       STENCIL_OP_SEPARATE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {face,fail,zfail,zpass});
       writer.endObject();
    }

    public void texImage2D(Double target, Double level, Double internalformat, Double format, Double type, PImageData pixels){
    }

    public void texImage2D(Double target, Double level, Double internalformat, Double format, Double type, PHTMLImageElement image){
    }

    public void texImage2D(Double target, Double level, Double internalformat, Double format, Double type, PHTMLCanvasElement canvas){
    }

    public void texImage2D(Double target, Double level, Double internalformat, Double format, Double type, PHTMLVideoElement video){
    }

    public void texImage2D(Double target, Double level, Double internalformat, Double format, Double type, PImageBitmap bitmap){
    }

    public void texImage2D(Double target, Double level, Double internalformat, Double width, Double height, Double border, Double format, Double type, PArrayBufferView pixels){
    }

    public void texParameterf(Double target, Double pname, Double param){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       TEX_PARAMETERF_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,pname,param});
       writer.endObject();
    }

    public void texParameteri(Double target, Double pname, Double param){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       TEX_PARAMETERI_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {target,pname,param});
       writer.endObject();
    }

    public void texSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double format, Double type, PImageData pixels){
    }

    public void texSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double format, Double type, PHTMLImageElement image){
    }

    public void texSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double format, Double type, PHTMLCanvasElement canvas){
    }

    public void texSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double format, Double type, PHTMLVideoElement video){
    }

    public void texSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double format, Double type, PImageBitmap bitmap){
    }

    public void texSubImage2D(Double target, Double level, Double xoffset, Double yoffset, Double width, Double height, Double format, Double type, PArrayBufferView pixels){
    }

    public void uniform1f(PWebGLUniformLocation location, Double x){
    }

    public void uniform1fv(PWebGLUniformLocation location, PFloat32Array v){
    }

    public void uniform1fv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform1i(PWebGLUniformLocation location, Double x){
    }

    public void uniform1iv(PWebGLUniformLocation location, PInt32Array v){
    }

    public void uniform1iv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform2f(PWebGLUniformLocation location, Double x, Double y){
    }

    public void uniform2fv(PWebGLUniformLocation location, PFloat32Array v){
    }

    public void uniform2fv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform2i(PWebGLUniformLocation location, Double x, Double y){
    }

    public void uniform2iv(PWebGLUniformLocation location, PInt32Array v){
    }

    public void uniform2iv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform3f(PWebGLUniformLocation location, Double x, Double y, Double z){
    }

    public void uniform3fv(PWebGLUniformLocation location, PFloat32Array v){
    }

    public void uniform3fv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform3i(PWebGLUniformLocation location, Double x, Double y, Double z){
    }

    public void uniform3iv(PWebGLUniformLocation location, PInt32Array v){
    }

    public void uniform3iv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform4f(PWebGLUniformLocation location, Double x, Double y, Double z, Double w){
    }

    public void uniform4fv(PWebGLUniformLocation location, PFloat32Array v){
    }

    public void uniform4fv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniform4i(PWebGLUniformLocation location, Double x, Double y, Double z, Double w){
    }

    public void uniform4iv(PWebGLUniformLocation location, PInt32Array v){
    }

    public void uniform4iv(PWebGLUniformLocation location, Double[] v){
    }

    public void uniformMatrix2fv(PWebGLUniformLocation location, Boolean transpose, PFloat32Array array){
    }

    public void uniformMatrix2fv(PWebGLUniformLocation location, Boolean transpose, Double[] array){
    }

    public void uniformMatrix3fv(PWebGLUniformLocation location, Boolean transpose, PFloat32Array array){
    }

    public void uniformMatrix3fv(PWebGLUniformLocation location, Boolean transpose, Double[] array){
    }

    public void uniformMatrix4fv(PWebGLUniformLocation location, Boolean transpose, PFloat32Array array){
    }

    public void uniformMatrix4fv(PWebGLUniformLocation location, Boolean transpose, Double[] array){
    }

    public void useProgram(PWebGLProgram program){
    }

    public void validateProgram(PWebGLProgram program){
    }

    public void vertexAttrib1f(Double indx, Double x){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       VERTEX_ATTRIB1F_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {indx,x});
       writer.endObject();
    }

    public void vertexAttrib1fv(Double indx, PFloat32Array values){
    }

    public void vertexAttrib1fv(Double indx, Double[] values){
    }

    public void vertexAttrib2f(Double indx, Double x, Double y){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       VERTEX_ATTRIB2F_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {indx,x,y});
       writer.endObject();
    }

    public void vertexAttrib2fv(Double indx, PFloat32Array values){
    }

    public void vertexAttrib2fv(Double indx, Double[] values){
    }

    public void vertexAttrib3f(Double indx, Double x, Double y, Double z){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       VERTEX_ATTRIB3F_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {indx,x,y,z});
       writer.endObject();
    }

    public void vertexAttrib3fv(Double indx, PFloat32Array values){
    }

    public void vertexAttrib3fv(Double indx, Double[] values){
    }

    public void vertexAttrib4f(Double indx, Double x, Double y, Double z, Double w){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       VERTEX_ATTRIB4F_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {indx,x,y,z,w});
       writer.endObject();
    }

    public void vertexAttrib4fv(Double indx, PFloat32Array values){
    }

    public void vertexAttrib4fv(Double indx, Double[] values){
    }

    public void vertexAttribPointer(Double indx, Double size, Double type, Boolean normalized, Double stride, Double offset){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       VERTEX_ATTRIB_POINTER_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEBOOLEAN_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {indx,size,type,normalized,stride,offset});
       writer.endObject();
    }

    public void viewport(Double x, Double y, Double width, Double height){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       VIEWPORT_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_TYPEDOUBLE_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {x,y,width,height});
       writer.endObject();
    }

    
}