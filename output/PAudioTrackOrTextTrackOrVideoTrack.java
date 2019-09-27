package com.ponysdk.core.ui2;

public abstract class PAudioTrackOrTextTrackOrVideoTrack extends PObject2 {
PAudioTrack valuePAudioTrack;
PTextTrack valuePTextTrack;
PVideoTrack valuePVideoTrack;
    public PAudioTrackOrTextTrackOrVideoTrack(PAudioTrack value){
        valuePAudioTrack = value;
    }
    public PAudioTrackOrTextTrackOrVideoTrack(PTextTrack value){
        valuePTextTrack = value;
    }
    public PAudioTrackOrTextTrackOrVideoTrack(PVideoTrack value){
        valuePVideoTrack = value;
    }
    public PAudioTrack getValuePAudioTrack(){
      return valuePAudioTrack;
    }

    public PTextTrack getValuePTextTrack(){
      return valuePTextTrack;
    }

    public PVideoTrack getValuePVideoTrack(){
      return valuePVideoTrack;
    }

}