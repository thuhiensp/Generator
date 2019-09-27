package com.ponysdk.core.ui2;

public abstract class PHTMLOrSVGScriptElement extends PObject2 {
PHTMLScriptElement valuePHTMLScriptElement;
PSVGScriptElement valuePSVGScriptElement;
    public PHTMLOrSVGScriptElement(PHTMLScriptElement value){
        valuePHTMLScriptElement = value;
    }
    public PHTMLOrSVGScriptElement(PSVGScriptElement value){
        valuePSVGScriptElement = value;
    }
    public PHTMLScriptElement getValuePHTMLScriptElement(){
      return valuePHTMLScriptElement;
    }

    public PSVGScriptElement getValuePSVGScriptElement(){
      return valuePSVGScriptElement;
    }

}