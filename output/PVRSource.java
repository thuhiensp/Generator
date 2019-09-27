package com.ponysdk.core.ui2;

public abstract class PVRSource extends PObject2 {
PHTMLCanvasElement valuePHTMLCanvasElement;
POffscreenCanvas valuePOffscreenCanvas;
    public PVRSource(PHTMLCanvasElement value){
        valuePHTMLCanvasElement = value;
    }
    public PVRSource(POffscreenCanvas value){
        valuePOffscreenCanvas = value;
    }
    public PHTMLCanvasElement getValuePHTMLCanvasElement(){
      return valuePHTMLCanvasElement;
    }

    public POffscreenCanvas getValuePOffscreenCanvas(){
      return valuePOffscreenCanvas;
    }

}