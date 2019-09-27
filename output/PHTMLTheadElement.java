package com.ponysdk.core.ui2;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PHTMLTheadElement extends PHTMLTableSectionElement{
    public PHTMLTheadElement(){
    }

      @Override
     protected PLeafTypeNoArgs widgetNoArgs() {
       return PLeafTypeNoArgs.HTML_THEAD_ELEMENT;
    }

      @Override
    protected PLeafTypeWithArgs widgetWithArgs(){
       return null;
     }
}