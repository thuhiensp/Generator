package com.ponysdk.core.ui2;

public abstract class PFormDataEntryValue extends PObject2 {
PFile valuePFile;
String valueString;
    public PFormDataEntryValue(PFile value){
        valuePFile = value;
    }
    public PFormDataEntryValue(String value){
        valueString = value;
    }
    public PFile getValuePFile(){
      return valuePFile;
    }

    public String getValueString(){
      return valueString;
    }

}