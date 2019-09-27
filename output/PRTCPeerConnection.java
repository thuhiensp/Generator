/*
 * Copyright 2019 SmartTrade Technologies
 *     Pony SDK
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package  com.ponysdk.core.ui2;
import com.ponysdk.core.model.ServerToClientModel;
import com.ponysdk.core.writer.ModelWriter;
import com.ponysdk.core.server.application.UIContext;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.Consumer;
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PRTCPeerConnection extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PRTCPeerConnection.class);
    public PRTCPeerConnection() {
    }


    public PRTCPeerConnection(PRTCConfiguration configuration){
      super(configuration);
    }

    public PRTCPeerConnection(PRTCConfiguration configuration, PJsObject mediaConstraints){
      super(configuration, mediaConstraints);
    }


    public void setOnnegotiationneeded(final PEventHandlerNonNull onnegotiationneeded, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONNEGOTIATIONNEEDED, new AttributeCallBack(onnegotiationneeded, atrsEventName));
       log.info("onnegotiationneeded" + onnegotiationneeded.getClass().getName());
    }
    public void setOnicecandidate(final PEventHandlerNonNull onicecandidate, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONICECANDIDATE, new AttributeCallBack(onicecandidate, atrsEventName));
       log.info("onicecandidate" + onicecandidate.getClass().getName());
    }
    public void setOnsignalingstatechange(final PEventHandlerNonNull onsignalingstatechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONSIGNALINGSTATECHANGE, new AttributeCallBack(onsignalingstatechange, atrsEventName));
       log.info("onsignalingstatechange" + onsignalingstatechange.getClass().getName());
    }
    public void setOniceconnectionstatechange(final PEventHandlerNonNull oniceconnectionstatechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONICECONNECTIONSTATECHANGE, new AttributeCallBack(oniceconnectionstatechange, atrsEventName));
       log.info("oniceconnectionstatechange" + oniceconnectionstatechange.getClass().getName());
    }
    public void setOnicegatheringstatechange(final PEventHandlerNonNull onicegatheringstatechange, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONICEGATHERINGSTATECHANGE, new AttributeCallBack(onicegatheringstatechange, atrsEventName));
       log.info("onicegatheringstatechange" + onicegatheringstatechange.getClass().getName());
    }
    public void setOndatachannel(final PEventHandlerNonNull ondatachannel, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONDATACHANNEL, new AttributeCallBack(ondatachannel, atrsEventName));
       log.info("ondatachannel" + ondatachannel.getClass().getName());
    }
    public void setOnaddstream(final PEventHandlerNonNull onaddstream, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONADDSTREAM, new AttributeCallBack(onaddstream, atrsEventName));
       log.info("onaddstream" + onaddstream.getClass().getName());
    }
    public void setOnremovestream(final PEventHandlerNonNull onremovestream, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONREMOVESTREAM, new AttributeCallBack(onremovestream, atrsEventName));
       log.info("onremovestream" + onremovestream.getClass().getName());
    }

    public PEventHandlerNonNull getOnnegotiationneeded(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONNEGOTIATIONNEEDED);
    }
    public PEventHandlerNonNull getOnicecandidate(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONICECANDIDATE);
    }
    public PEventHandlerNonNull getOnsignalingstatechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONSIGNALINGSTATECHANGE);
    }
    public PEventHandlerNonNull getOniceconnectionstatechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONICECONNECTIONSTATECHANGE);
    }
    public PEventHandlerNonNull getOnicegatheringstatechange(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONICEGATHERINGSTATECHANGE);
    }
    public PEventHandlerNonNull getOndatachannel(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONDATACHANNEL);
    }
    public PEventHandlerNonNull getOnaddstream(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONADDSTREAM);
    }
    public PEventHandlerNonNull getOnremovestream(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONREMOVESTREAM);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.RTC_PEER_CONNECTION;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.RTC_PEER_CONNECTION;
    }


    public PPromise<Void> addIceCandidate(PRTCIceCandidateInit candidate) {
       return null;
    }


    public PPromise<Void> addIceCandidate(PRTCIceCandidate candidate) {
       return null;
    }


    public PPromise<Void> addIceCandidate(PRTCIceCandidateInit candidate, PVoidCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback) {
       return null;
    }


    public PPromise<Void> addIceCandidate(PRTCIceCandidate candidate, PVoidCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback) {
       return null;
    }


    public void addStream(PMediaStream stream){
    }

    public void addStream(PMediaStream stream, PJsObject mediaConstraints){
    }

    public void close(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CLOSE_VOID.getValue());
       writer.endObject();
    }

    public PPromise<PRTCSessionDescription> createAnswer() {
       return null;
    }


    public PPromise<PRTCSessionDescription> createAnswer(PRTCAnswerOptions options) {
       return null;
    }


    public PPromise<Void> createAnswer(PRTCSessionDescriptionCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback) {
       return null;
    }


    public PPromise<Void> createAnswer(PRTCSessionDescriptionCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback, PJsObject mediaConstraints) {
       return null;
    }


    public PRTCDTMFSender createDTMFSender(PMediaStreamTrack track) {
       return null;
    }


    public PRTCDataChannel createDataChannel(String label) {
       return null;
    }


    public PRTCDataChannel createDataChannel(String label, PRTCDataChannelInit dataChannelDict) {
       return null;
    }


    public PPromise<PRTCSessionDescription> createOffer() {
       return null;
    }


    public PPromise<PRTCSessionDescription> createOffer(PRTCOfferOptions options) {
       return null;
    }


    public PPromise<Void> createOffer(PRTCSessionDescriptionCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback) {
       return null;
    }


    public PPromise<Void> createOffer(PRTCSessionDescriptionCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback, PJsObject rtcOfferOptions) {
       return null;
    }


    public PPromise<PRTCCertificate> generateCertificate(PJsObject keygenAlgorithm) {
       return null;
    }


    public PPromise<PRTCCertificate> generateCertificate(String keygenAlgorithm) {
       return null;
    }


    public PMediaStream[] getLocalStreams() {
       return null;
    }


    public PRTCRtpReceiver[] getReceivers() {
       return null;
    }


    public PMediaStream[] getRemoteStreams() {
       return null;
    }


    public PRTCRtpSender[] getSenders() {
       return null;
    }


    public PPromise<PRTCStatsReport> getStats() {
       return null;
    }


    public PPromise<Void> getStats(PRTCStatsCallback successCallback) {
       return null;
    }


    public PPromise<Void> getStats(PRTCStatsCallback successCallback, PMediaStreamTrack selector) {
       return null;
    }


    public PMediaStream getStreamById(String streamId) {
       return null;
    }


    public void removeStream(PMediaStream stream){
    }

    public void setConfiguration(PRTCConfiguration configuration){
    }

    public PPromise<Void> setLocalDescription(PRTCSessionDescriptionInit description) {
       return null;
    }


    public PPromise<Void> setLocalDescription(PRTCSessionDescriptionInit description, PVoidCallback successCallback) {
       return null;
    }


    public PPromise<Void> setLocalDescription(PRTCSessionDescriptionInit description, PVoidCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback) {
       return null;
    }


    public PPromise<Void> setRemoteDescription(PRTCSessionDescriptionInit description) {
       return null;
    }


    public PPromise<Void> setRemoteDescription(PRTCSessionDescriptionInit description, PVoidCallback successCallback) {
       return null;
    }


    public PPromise<Void> setRemoteDescription(PRTCSessionDescriptionInit description, PVoidCallback successCallback, PRTCPeerConnectionErrorCallback failureCallback) {
       return null;
    }


    
}