package com.ponysdk.core.ui2;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PHTMLThElement extends PHTMLTableCellElement{
    public PHTMLThElement(){
    }

      @Override
     protected PLeafTypeNoArgs widgetNoArgs() {
       return PLeafTypeNoArgs.HTML_TH_ELEMENT;
    }

      @Override
    protected PLeafTypeWithArgs widgetWithArgs(){
       return null;
     }
}