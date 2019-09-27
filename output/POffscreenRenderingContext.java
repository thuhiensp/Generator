package com.ponysdk.core.ui2;

public abstract class POffscreenRenderingContext extends PObject2 {
POffscreenCanvasRenderingContext2D valuePOffscreenCanvasRenderingContext2D;
PWebGLRenderingContext valuePWebGLRenderingContext;
PWebGL2RenderingContext valuePWebGL2RenderingContext;
    public POffscreenRenderingContext(POffscreenCanvasRenderingContext2D value){
        valuePOffscreenCanvasRenderingContext2D = value;
    }
    public POffscreenRenderingContext(PWebGLRenderingContext value){
        valuePWebGLRenderingContext = value;
    }
    public POffscreenRenderingContext(PWebGL2RenderingContext value){
        valuePWebGL2RenderingContext = value;
    }
    public POffscreenCanvasRenderingContext2D getValuePOffscreenCanvasRenderingContext2D(){
      return valuePOffscreenCanvasRenderingContext2D;
    }

    public PWebGLRenderingContext getValuePWebGLRenderingContext(){
      return valuePWebGLRenderingContext;
    }

    public PWebGL2RenderingContext getValuePWebGL2RenderingContext(){
      return valuePWebGL2RenderingContext;
    }

}