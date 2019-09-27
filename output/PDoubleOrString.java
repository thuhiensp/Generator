package com.ponysdk.core.ui2;

public abstract class PDoubleOrString extends PObject2 {
Double valueDouble;
String valueString;
    public PDoubleOrString(Double value){
        valueDouble = value;
    }
    public PDoubleOrString(String value){
        valueString = value;
    }
    public Double getValueDouble(){
      return valueDouble;
    }

    public String getValueString(){
      return valueString;
    }

}