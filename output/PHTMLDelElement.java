package com.ponysdk.core.ui2;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PHTMLDelElement extends PHTMLModElement{
    public PHTMLDelElement(){
    }

      @Override
     protected PLeafTypeNoArgs widgetNoArgs() {
       return PLeafTypeNoArgs.HTML_DEL_ELEMENT;
    }

      @Override
    protected PLeafTypeWithArgs widgetWithArgs(){
       return null;
     }
}