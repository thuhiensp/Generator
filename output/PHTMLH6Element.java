package com.ponysdk.core.ui2;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PHTMLH6Element extends PHTMLHeadingElement{
    public PHTMLH6Element(){
    }

      @Override
     protected PLeafTypeNoArgs widgetNoArgs() {
       return PLeafTypeNoArgs.HTML_H6_ELEMENT;
    }

      @Override
    protected PLeafTypeWithArgs widgetWithArgs(){
       return null;
     }
}