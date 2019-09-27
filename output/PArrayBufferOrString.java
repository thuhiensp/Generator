package com.ponysdk.core.ui2;

public abstract class PArrayBufferOrString extends PObject2 {
PArrayBuffer valuePArrayBuffer;
String valueString;
    public PArrayBufferOrString(PArrayBuffer value){
        valuePArrayBuffer = value;
    }
    public PArrayBufferOrString(String value){
        valueString = value;
    }
    public PArrayBuffer getValuePArrayBuffer(){
      return valuePArrayBuffer;
    }

    public String getValueString(){
      return valueString;
    }

}