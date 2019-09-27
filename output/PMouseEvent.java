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
import java.util.function.Consumer;
import com.ponysdk.core.ui2.PEventAttributesName;
import java.util.Map;
public class PMouseEvent extends PUIEvent {
    public PMouseEvent(final Map<PEventAttributesName, Object> mapValueByAttributeName){
       super(mapValueByAttributeName);
    }

    public Object getScreenX(){
      return get(PEventAttributesName.SCREENX);
    }
    public Object getScreenY(){
      return get(PEventAttributesName.SCREENY);
    }
    public Object getClientX(){
      return get(PEventAttributesName.CLIENTX);
    }
    public Object getClientY(){
      return get(PEventAttributesName.CLIENTY);
    }
    public Object getCtrlKey(){
      return get(PEventAttributesName.CTRL_KEY);
    }
    public Object getShiftKey(){
      return get(PEventAttributesName.SHIFT_KEY);
    }
    public Object getAltKey(){
      return get(PEventAttributesName.ALT_KEY);
    }
    public Object getMetaKey(){
      return get(PEventAttributesName.META_KEY);
    }
    public Object getButton(){
      return get(PEventAttributesName.BUTTON);
    }
    public Object getButtons(){
      return get(PEventAttributesName.BUTTONS);
    }
    public PEventTarget getRelatedTarget(){
      return (PEventTarget) get(PEventAttributesName.RELATED_TARGET);
    }
    public Object getPageX(){
      return get(PEventAttributesName.PAGEX);
    }
    public Object getPageY(){
      return get(PEventAttributesName.PAGEY);
    }
    public Object getX(){
      return get(PEventAttributesName.X);
    }
    public Object getY(){
      return get(PEventAttributesName.Y);
    }
    public Object getOffsetX(){
      return get(PEventAttributesName.OFFSETX);
    }
    public Object getOffsetY(){
      return get(PEventAttributesName.OFFSETY);
    }
    public Object getMovementX(){
      return get(PEventAttributesName.MOVEMENTX);
    }
    public Object getMovementY(){
      return get(PEventAttributesName.MOVEMENTY);
    }
    public Object getRegion(){
      return get(PEventAttributesName.REGION);
    }
    public PNode getFromElement(){
      return (PNode) get(PEventAttributesName.FROM_ELEMENT);
    }
    public PNode getToElement(){
      return (PNode) get(PEventAttributesName.TO_ELEMENT);
    }
    public Object getLayerX(){
      return get(PEventAttributesName.LAYERX);
    }
    public Object getLayerY(){
      return get(PEventAttributesName.LAYERY);
    }



}