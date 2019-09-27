package com.ponysdk.core.ui2;

public abstract class PCanvasGradientOrCanvasPatternOrString extends PObject2 {
PCanvasGradient valuePCanvasGradient;
PCanvasPattern valuePCanvasPattern;
String valueString;
    public PCanvasGradientOrCanvasPatternOrString(PCanvasGradient value){
        valuePCanvasGradient = value;
    }
    public PCanvasGradientOrCanvasPatternOrString(PCanvasPattern value){
        valuePCanvasPattern = value;
    }
    public PCanvasGradientOrCanvasPatternOrString(String value){
        valueString = value;
    }
    public PCanvasGradient getValuePCanvasGradient(){
      return valuePCanvasGradient;
    }

    public PCanvasPattern getValuePCanvasPattern(){
      return valuePCanvasPattern;
    }

    public String getValueString(){
      return valueString;
    }

}