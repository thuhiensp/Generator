package com.ponysdk.core.ui2;

public abstract class PHTMLOptionsUnion extends PObject2 {
PNodeList valuePNodeList;
PElement valuePElement;
    public PHTMLOptionsUnion(PNodeList value){
        valuePNodeList = value;
    }
    public PHTMLOptionsUnion(PElement value){
        valuePElement = value;
    }
    public PNodeList getValuePNodeList(){
      return valuePNodeList;
    }

    public PElement getValuePElement(){
      return valuePElement;
    }

}