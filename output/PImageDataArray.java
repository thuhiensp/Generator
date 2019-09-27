package com.ponysdk.core.ui2;

public abstract class PImageDataArray extends PObject2 {
PUint8ClampedArray valuePUint8ClampedArray;
PUint16Array valuePUint16Array;
PFloat32Array valuePFloat32Array;
    public PImageDataArray(PUint8ClampedArray value){
        valuePUint8ClampedArray = value;
    }
    public PImageDataArray(PUint16Array value){
        valuePUint16Array = value;
    }
    public PImageDataArray(PFloat32Array value){
        valuePFloat32Array = value;
    }
    public PUint8ClampedArray getValuePUint8ClampedArray(){
      return valuePUint8ClampedArray;
    }

    public PUint16Array getValuePUint16Array(){
      return valuePUint16Array;
    }

    public PFloat32Array getValuePFloat32Array(){
      return valuePFloat32Array;
    }

}