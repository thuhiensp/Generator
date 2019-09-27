package com.ponysdk.core.ui2;

public abstract class PCredentialBodyType extends PObject2 {
PFormData valuePFormData;
PURLSearchParams valuePURLSearchParams;
    public PCredentialBodyType(PFormData value){
        valuePFormData = value;
    }
    public PCredentialBodyType(PURLSearchParams value){
        valuePURLSearchParams = value;
    }
    public PFormData getValuePFormData(){
      return valuePFormData;
    }

    public PURLSearchParams getValuePURLSearchParams(){
      return valuePURLSearchParams;
    }

}