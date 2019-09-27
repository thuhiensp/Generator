package com.ponysdk.core.ui2;

public abstract class PCSSVariableReferenceValueOrString extends PObject2 {
PCSSVariableReferenceValue valuePCSSVariableReferenceValue;
String valueString;
    public PCSSVariableReferenceValueOrString(PCSSVariableReferenceValue value){
        valuePCSSVariableReferenceValue = value;
    }
    public PCSSVariableReferenceValueOrString(String value){
        valueString = value;
    }
    public PCSSVariableReferenceValue getValuePCSSVariableReferenceValue(){
      return valuePCSSVariableReferenceValue;
    }

    public String getValueString(){
      return valueString;
    }

}