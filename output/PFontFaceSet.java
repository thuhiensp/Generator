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
public class PFontFaceSet extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PFontFaceSet.class);
    private PFontFaceSet(){
    }

    public void setOnloading(final PEventHandlerNonNull onloading, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADING, new AttributeCallBack(onloading, atrsEventName));
       log.info("onloading" + onloading.getClass().getName());
    }
    public void setOnloadingdone(final PEventHandlerNonNull onloadingdone, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADINGDONE, new AttributeCallBack(onloadingdone, atrsEventName));
       log.info("onloadingdone" + onloadingdone.getClass().getName());
    }
    public void setOnloadingerror(final PEventHandlerNonNull onloadingerror, final PEventAttributesName... atrsEventName)  {
       setAttribute(PAttributeNames.ONLOADINGERROR, new AttributeCallBack(onloadingerror, atrsEventName));
       log.info("onloadingerror" + onloadingerror.getClass().getName());
    }

    public PEventHandlerNonNull getOnloading(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADING);
    }
    public PEventHandlerNonNull getOnloadingdone(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADINGDONE);
    }
    public PEventHandlerNonNull getOnloadingerror(){
      return (PEventHandlerNonNull) getAttribute(PAttributeNames.ONLOADINGERROR);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void check(final Consumer<Boolean> cback,String font){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CHECK_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {font});
       writer.endObject();
    }

    public void check(final Consumer<Boolean> cback,String font, String text){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CHECK_TYPESTRING_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {font,text});
       writer.endObject();
    }

    public PPromise<PFontFace[]> load(String font) {
       return null;
    }


    public PPromise<PFontFace[]> load(String font, String text) {
       return null;
    }


    
}