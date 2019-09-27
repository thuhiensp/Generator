package com.ponysdk.core.ui2;
import java.util.Set;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonNumber;
import javax.json.JsonString;
import javax.json.JsonValue.ValueType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ponysdk.core.server.application.UIContext;
import java.util.HashMap;
import java.util.Map;

public class PConstructionEvent {
     private static final Logger log = LoggerFactory.getLogger(PConstructionEvent.class);
     public PEvent constructorEvent(final String eventName, final JsonObject eventInfo){
      final Map<PEventAttributesName, Object> mapByAtrsName = constructionMap(eventInfo);

      switch (eventName) {
        case "AnimationEvent": {
           return new PAnimationEvent(mapByAtrsName);
        }
        case "AnimationPlaybackEvent": {
           return new PAnimationPlaybackEvent(mapByAtrsName);
        }
        case "ApplicationCacheErrorEvent": {
           return new PApplicationCacheErrorEvent(mapByAtrsName);
        }
        case "AudioProcessingEvent": {
           return new PAudioProcessingEvent(mapByAtrsName);
        }
        case "BackgroundFetchClickEvent": {
           return new PBackgroundFetchClickEvent(mapByAtrsName);
        }
        case "BackgroundFetchEvent": {
           return new PBackgroundFetchEvent(mapByAtrsName);
        }
        case "BackgroundFetchFailEvent": {
           return new PBackgroundFetchFailEvent(mapByAtrsName);
        }
        case "BackgroundFetchedEvent": {
           return new PBackgroundFetchedEvent(mapByAtrsName);
        }
        case "BeforeInstallPromptEvent": {
           return new PBeforeInstallPromptEvent(mapByAtrsName);
        }
        case "BeforeUnloadEvent": {
           return new PBeforeUnloadEvent(mapByAtrsName);
        }
        case "BlobEvent": {
           return new PBlobEvent(mapByAtrsName);
        }
        case "ClipboardEvent": {
           return new PClipboardEvent(mapByAtrsName);
        }
        case "CloseEvent": {
           return new PCloseEvent(mapByAtrsName);
        }
        case "CompositionEvent": {
           return new PCompositionEvent(mapByAtrsName);
        }
        case "CustomEvent": {
           return new PCustomEvent(mapByAtrsName);
        }
        case "DeviceMotionEvent": {
           return new PDeviceMotionEvent(mapByAtrsName);
        }
        case "DeviceOrientationEvent": {
           return new PDeviceOrientationEvent(mapByAtrsName);
        }
        case "DragEvent": {
           return new PDragEvent(mapByAtrsName);
        }
        case "ErrorEvent": {
           return new PErrorEvent(mapByAtrsName);
        }
        case "Event": {
           return new PEvent(mapByAtrsName);
        }
        case "ExtendableEvent": {
           return new PExtendableEvent(mapByAtrsName);
        }
        case "ExtendableMessageEvent": {
           return new PExtendableMessageEvent(mapByAtrsName);
        }
        case "FetchEvent": {
           return new PFetchEvent(mapByAtrsName);
        }
        case "FocusEvent": {
           return new PFocusEvent(mapByAtrsName);
        }
        case "FontFaceSetLoadEvent": {
           return new PFontFaceSetLoadEvent(mapByAtrsName);
        }
        case "ForeignFetchEvent": {
           return new PForeignFetchEvent(mapByAtrsName);
        }
        case "GamepadEvent": {
           return new PGamepadEvent(mapByAtrsName);
        }
        case "HashChangeEvent": {
           return new PHashChangeEvent(mapByAtrsName);
        }
        case "IDBVersionChangeEvent": {
           return new PIDBVersionChangeEvent(mapByAtrsName);
        }
        case "InputEvent": {
           return new PInputEvent(mapByAtrsName);
        }
        case "InstallEvent": {
           return new PInstallEvent(mapByAtrsName);
        }
        case "KeyboardEvent": {
           return new PKeyboardEvent(mapByAtrsName);
        }
        case "MIDIConnectionEvent": {
           return new PMIDIConnectionEvent(mapByAtrsName);
        }
        case "MIDIMessageEvent": {
           return new PMIDIMessageEvent(mapByAtrsName);
        }
        case "MediaEncryptedEvent": {
           return new PMediaEncryptedEvent(mapByAtrsName);
        }
        case "MediaKeyMessageEvent": {
           return new PMediaKeyMessageEvent(mapByAtrsName);
        }
        case "MediaQueryListEvent": {
           return new PMediaQueryListEvent(mapByAtrsName);
        }
        case "MediaStreamEvent": {
           return new PMediaStreamEvent(mapByAtrsName);
        }
        case "MediaStreamTrackEvent": {
           return new PMediaStreamTrackEvent(mapByAtrsName);
        }
        case "MessageEvent": {
           return new PMessageEvent(mapByAtrsName);
        }
        case "MouseEvent": {
           return new PMouseEvent(mapByAtrsName);
        }
        case "MutationEvent": {
           return new PMutationEvent(mapByAtrsName);
        }
        case "NotificationEvent": {
           return new PNotificationEvent(mapByAtrsName);
        }
        case "OfflineAudioCompletionEvent": {
           return new POfflineAudioCompletionEvent(mapByAtrsName);
        }
        case "PageTransitionEvent": {
           return new PPageTransitionEvent(mapByAtrsName);
        }
        case "PointerEvent": {
           return new PPointerEvent(mapByAtrsName);
        }
        case "PopStateEvent": {
           return new PPopStateEvent(mapByAtrsName);
        }
        case "PresentationConnectionAvailableEvent": {
           return new PPresentationConnectionAvailableEvent(mapByAtrsName);
        }
        case "PresentationConnectionCloseEvent": {
           return new PPresentationConnectionCloseEvent(mapByAtrsName);
        }
        case "ProgressEvent": {
           return new PProgressEvent(mapByAtrsName);
        }
        case "PromiseRejectionEvent": {
           return new PPromiseRejectionEvent(mapByAtrsName);
        }
        case "PushEvent": {
           return new PPushEvent(mapByAtrsName);
        }
        case "RTCDTMFToneChangeEvent": {
           return new PRTCDTMFToneChangeEvent(mapByAtrsName);
        }
        case "RTCDataChannelEvent": {
           return new PRTCDataChannelEvent(mapByAtrsName);
        }
        case "RTCPeerConnectionIceEvent": {
           return new PRTCPeerConnectionIceEvent(mapByAtrsName);
        }
        case "ResourceProgressEvent": {
           return new PResourceProgressEvent(mapByAtrsName);
        }
        case "SecurityPolicyViolationEvent": {
           return new PSecurityPolicyViolationEvent(mapByAtrsName);
        }
        case "SensorErrorEvent": {
           return new PSensorErrorEvent(mapByAtrsName);
        }
        case "SpeechRecognitionError": {
           return new PSpeechRecognitionError(mapByAtrsName);
        }
        case "SpeechRecognitionEvent": {
           return new PSpeechRecognitionEvent(mapByAtrsName);
        }
        case "SpeechSynthesisEvent": {
           return new PSpeechSynthesisEvent(mapByAtrsName);
        }
        case "StorageEvent": {
           return new PStorageEvent(mapByAtrsName);
        }
        case "SyncEvent": {
           return new PSyncEvent(mapByAtrsName);
        }
        case "TextEvent": {
           return new PTextEvent(mapByAtrsName);
        }
        case "TouchEvent": {
           return new PTouchEvent(mapByAtrsName);
        }
        case "TrackEvent": {
           return new PTrackEvent(mapByAtrsName);
        }
        case "TransitionEvent": {
           return new PTransitionEvent(mapByAtrsName);
        }
        case "UIEvent": {
           return new PUIEvent(mapByAtrsName);
        }
        case "USBConnectionEvent": {
           return new PUSBConnectionEvent(mapByAtrsName);
        }
        case "VRDisplayEvent": {
           return new PVRDisplayEvent(mapByAtrsName);
        }
        case "WebGLContextEvent": {
           return new PWebGLContextEvent(mapByAtrsName);
        }
        case "WheelEvent": {
           return new PWheelEvent(mapByAtrsName);
        }
      }
     log.info("it has not information of event");
     return null;
     }

    private Map<PEventAttributesName, Object> constructionMap(final JsonObject eventInfo) {
       final Map<PEventAttributesName, Object> map = new HashMap<>();
       final Set<String> keySet = eventInfo.keySet();
       for (final String key : keySet) {
           final int number = Integer.parseInt(key);
           final PEventAttributesName nameOfAtrs = PEventAttributesName.fromRawValue(number);
           map.put(nameOfAtrs, getValue(eventInfo, key, nameOfAtrs));
       }
     return map;
    }
    private Object getValue(final JsonObject eventInfo, final String key, final PEventAttributesName nameOfAtrs) {
        switch (nameOfAtrs) {
          case ORIGINAL_POLICY:
          case ATTR_CHANGE:
          case PRESSURE:
          case SCREENY:
          case ELAPSED_TIME:
          case PSEUDO_ELEMENT:
          case REASON_OBJECT:
          case CANCELABLE:
          case DELTAY:
          case NEW_VALUE:
          case MATCHES:
          case SUBORIGIN:
          case Y:
          case ALPHA:
          case CANCEL_BUBBLE:
          case CLIENT_ID:
          case IS_COMPOSING:
          case TYPE:
          case MESSAGE_STRING:
          case STATUS:
          case BUTTON:
          case WHICH:
          case LAYERY:
          case OLD_VERSION:
          case COLNO:
          case WHEEL_DELTA:
          case CHAR_INDEX:
          case TONE:
          case RESULT_INDEX:
          case SOURCE_FILE:
          case WIDTH:
          case VIOLATED_DIRECTIVE:
          case OLD_VALUE:
          case CODE_STRING:
          case LAST_CHANCE:
          case ERROR_STRING:
          case REPLY:
          case CHAR_CODE:
          case DATA_STRING:
          case CTRL_KEY:
          case KEY_CODE:
          case IS_RELOAD:
          case ERROR_OBJECT:
          case OLDURL:
          case INPUT_TYPE:
          case FILENAME:
          case SHIFT_KEY:
          case NEWURL:
          case IS_PRIMARY:
          case LINE_NUMBER:
          case TILTX:
          case TWIST:
          case BETA:
          case POINTER_ID:
          case RETURN_VALUE:
          case INIT_DATA_TYPE:
          case REPEAT:
          case TIME_STAMP:
          case BLOCKEDURI:
          case MEDIA:
          case OFFSETY:
          case MOVEMENTY:
          case CURRENT_TIME:
          case WAS_CLEAN:
          case REASON_STRING:
          case ATTR_NAME:
          case CLIENTY:
          case GAMMA:
          case URL:
          case PROPERTY_NAME:
          case DEFAULT_PREVENTED:
          case PAGEY:
          case COLUMN_NUMBER:
          case META_KEY:
          case WHEEL_DELTAX:
          case STATUS_MESSAGE:
          case ORIGIN:
          case TAG:
          case STATE_OBJECT:
          case NEW_VERSION:
          case REGION:
          case PERSISTED:
          case HEIGHT:
          case LOADED:
          case TIMECODE:
          case POINTER_TYPE:
          case INTERVAL:
          case LAYERX:
          case DELTA_MODE:
          case DETAIL_DOUBLE:
          case EVENT_PHASE:
          case DATA_OBJECT:
          case TOTAL:
          case LINENO:
          case DETAIL_OBJECT:
          case DATA_LOSS_MESSAGE:
          case LOCATION:
          case REFERRER:
          case IS_TRUSTED:
          case BUBBLES:
          case CLIENTX:
          case DELTAZ:
          case SCREENX:
          case WHEEL_DELTAY:
          case KEY:
          case COMPOSED:
          case PAGEX:
          case ABSOLUTE:
          case MOVEMENTX:
          case PREV_VALUE:
          case EFFECTIVE_DIRECTIVE:
          case NAME:
          case BUTTONS:
          case LAST_EVENT_ID:
          case SAMPLE:
          case PLAYBACK_TIME:
          case CODE_SHORT:
          case DELTAX:
          case X:
          case LENGTH_COMPUTABLE:
          case ACTION:
          case TANGENTIAL_PRESSURE:
          case ANIMATION_NAME:
          case ALT_KEY:
          case OFFSETX:
          case STATUS_CODE:
          case TILTY:
          case DOCUMENTURI:
          case TIMELINE_TIME:
             return getNativeType(eventInfo, key);
          case STREAM:
          case UTTERANCE:
          case CHANGED_TOUCHES:
          case SOURCE_CAPABILITIES:
          case TARGET_TOUCHES:
          case TOUCHES:
          case ERROR_POBJECT2:
          case INTERPRETATION:
          case VIEW:
          case MESSAGE_POBJECT2:
          case INIT_DATA:
          case INPUT_BUFFER:
          case ROTATION_RATE:
          case CANDIDATE:
          case NOTIFICATION:
          case CHANNEL:
          case DATA_TRANSFER:
          case DEVICE:
          case FROM_ELEMENT:
          case SOURCE_POBJECT2:
          case REQUEST:
          case CLIPBOARD_DATA:
          case OUTPUT_BUFFER:
          case TO_ELEMENT:
          case CONNECTION:
          case EMMA:
          case ACCELERATION_INCLUDING_GRAVITY:
          case SRC_ELEMENT:
          case RELATED_TARGET:
          case DATA_POBJECT2:
          case PORT:
          case RENDERED_BUFFER:
          case GAMEPAD:
          case TRACK_POBJECT2:
          case RELATED_NODE:
          case RESULTS:
          case CURRENT_TARGET:
          case DISPLAY:
          case STORAGE_AREA:
          case TARGET:
          case ACCELERATION:
             return getPObject2(eventInfo, key);
          case FONTFACES:
             return getFontFaceArray(eventInfo,key);
          case PLATFORMS:
             return getStringArray(eventInfo,key);
          case PATH:
             return getEventTargetArray(eventInfo,key);
          case FETCHES:
             return getBackgroundFetchSettledFetchArray(eventInfo,key);
          case PORTS:
             return getMessagePortArray(eventInfo,key);
          default:
             log.info("we don't treat these case");
             return null;
       }
     }
    private Object getNativeType(final JsonObject eventInfo, final String key) {
       log.info("your arrive here in getNativeType " + eventInfo.get(key));
        return eventInfo.get(key);
    }
    private PObject2 getPObject2(JsonObject eventInfo, String idOfAttr){
       JsonValue jsonValue = eventInfo.get(idOfAttr);
       if (jsonValue.getValueType() == ValueType.NUMBER){
          int idOfObject = eventInfo.getJsonNumber(idOfAttr).intValue();
          PObject2  res = (PObject2) UIContext.get().getPObject2(idOfObject);
          return res;
       }
       return null;
     }
     private PFontFace[] getFontFaceArray(JsonObject eventInfo, String idOfAttr){
       JsonValue jsonValue = eventInfo.get(idOfAttr);
       if (jsonValue.getValueType() == ValueType.ARRAY){
         JsonArray idOfAttrArray = eventInfo.getJsonArray(idOfAttr);
         int size = idOfAttrArray.size();
         PFontFace[]  res = new PFontFace[size];
         for (int index = 0; index <size; index ++ ){
           JsonValue elementRaw = idOfAttrArray.get(index);
         PFontFace element = null;
         if (elementRaw.getValueType() == ValueType.NUMBER){
            int idOfObject = ((JsonNumber)elementRaw).intValue();
           element = (PFontFace) UIContext.get().getPObject2(idOfObject);
         }
           res[index] = element; 
          }
       return res;
        }
     return null;
    }
     private String[] getStringArray(JsonObject eventInfo, String idOfAttr){
       JsonValue jsonValue = eventInfo.get(idOfAttr);
       if (jsonValue.getValueType() == ValueType.ARRAY){
         JsonArray idOfAttrArray = eventInfo.getJsonArray(idOfAttr);
         int size = idOfAttrArray.size();
         String[]  res = new String[size];
         for (int index = 0; index <size; index ++ ){
          final String element = idOfAttrArray.getString(index);
           res[index] = element; 
          }
       return res;
        }
     return null;
    }
     private PEventTarget[] getEventTargetArray(JsonObject eventInfo, String idOfAttr){
       JsonValue jsonValue = eventInfo.get(idOfAttr);
       if (jsonValue.getValueType() == ValueType.ARRAY){
         JsonArray idOfAttrArray = eventInfo.getJsonArray(idOfAttr);
         int size = idOfAttrArray.size();
         PEventTarget[]  res = new PEventTarget[size];
         for (int index = 0; index <size; index ++ ){
           JsonValue elementRaw = idOfAttrArray.get(index);
         PEventTarget element = null;
         if (elementRaw.getValueType() == ValueType.NUMBER){
            int idOfObject = ((JsonNumber)elementRaw).intValue();
           element = (PEventTarget) UIContext.get().getPObject2(idOfObject);
         }
           res[index] = element; 
          }
       return res;
        }
     return null;
    }
     private PBackgroundFetchSettledFetch[] getBackgroundFetchSettledFetchArray(JsonObject eventInfo, String idOfAttr){
       JsonValue jsonValue = eventInfo.get(idOfAttr);
       if (jsonValue.getValueType() == ValueType.ARRAY){
         JsonArray idOfAttrArray = eventInfo.getJsonArray(idOfAttr);
         int size = idOfAttrArray.size();
         PBackgroundFetchSettledFetch[]  res = new PBackgroundFetchSettledFetch[size];
         for (int index = 0; index <size; index ++ ){
           JsonValue elementRaw = idOfAttrArray.get(index);
         PBackgroundFetchSettledFetch element = null;
         if (elementRaw.getValueType() == ValueType.NUMBER){
            int idOfObject = ((JsonNumber)elementRaw).intValue();
           element = (PBackgroundFetchSettledFetch) UIContext.get().getPObject2(idOfObject);
         }
           res[index] = element; 
          }
       return res;
        }
     return null;
    }
     private PMessagePort[] getMessagePortArray(JsonObject eventInfo, String idOfAttr){
       JsonValue jsonValue = eventInfo.get(idOfAttr);
       if (jsonValue.getValueType() == ValueType.ARRAY){
         JsonArray idOfAttrArray = eventInfo.getJsonArray(idOfAttr);
         int size = idOfAttrArray.size();
         PMessagePort[]  res = new PMessagePort[size];
         for (int index = 0; index <size; index ++ ){
           JsonValue elementRaw = idOfAttrArray.get(index);
         PMessagePort element = null;
         if (elementRaw.getValueType() == ValueType.NUMBER){
            int idOfObject = ((JsonNumber)elementRaw).intValue();
           element = (PMessagePort) UIContext.get().getPObject2(idOfObject);
         }
           res[index] = element; 
          }
       return res;
        }
     return null;
    }
}