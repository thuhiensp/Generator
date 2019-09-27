package com.ponysdk.core.ui2;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PHTMLQElement extends PHTMLQuoteElement{
    public PHTMLQElement(){
    }

      @Override
     protected PLeafTypeNoArgs widgetNoArgs() {
       return PLeafTypeNoArgs.HTML_Q_ELEMENT;
    }

      @Override
    protected PLeafTypeWithArgs widgetWithArgs(){
       return null;
     }
}