package com.ponysdk.core.ui2;

public abstract class PFloatOrString extends PObject2 {
Float valueFloat;
String valueString;
    public PFloatOrString(Float value){
        valueFloat = value;
    }
    public PFloatOrString(String value){
        valueString = value;
    }
    public Float getValueFloat(){
      return valueFloat;
    }

    public String getValueString(){
      return valueString;
    }

}