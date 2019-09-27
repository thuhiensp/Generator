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
public class PHTMLObjectElement extends PHTMLElement {
    private static final Logger log = LoggerFactory.getLogger(PHTMLObjectElement.class);
    public PHTMLObjectElement() {
    }

    public void setData(final String data)  {
       setAttribute(PAttributeNames.DATA, data);
       log.info("data" + data);
    }
    public void setType(final String type)  {
       setAttribute(PAttributeNames.TYPE_STRING, type);
       log.info("type" + type);
    }
    public void setName(final String name)  {
       setAttribute(PAttributeNames.NAME, name);
       log.info("name" + name);
    }
    public void setUseMap(final String useMap)  {
       setAttribute(PAttributeNames.USE_MAP, useMap);
       log.info("useMap" + useMap);
    }
    public void setWidth(final String width)  {
       setAttribute(PAttributeNames.WIDTH_STRING, width);
       log.info("width" + width);
    }
    public void setHeight(final String height)  {
       setAttribute(PAttributeNames.HEIGHT_STRING, height);
       log.info("height" + height);
    }
    public void setAlign(final String align)  {
       setAttribute(PAttributeNames.ALIGN_STRING, align);
       log.info("align" + align);
    }
    public void setArchive(final String archive)  {
       setAttribute(PAttributeNames.ARCHIVE, archive);
       log.info("archive" + archive);
    }
    public void setCode(final String code)  {
       setAttribute(PAttributeNames.CODE, code);
       log.info("code" + code);
    }
    public void setDeclare(final Boolean declare)  {
       setAttribute(PAttributeNames.DECLARE, declare);
       log.info("declare" + declare);
    }
    public void setHspace(final Double hspace)  {
       setAttribute(PAttributeNames.HSPACE, hspace);
       log.info("hspace" + hspace);
    }
    public void setStandby(final String standby)  {
       setAttribute(PAttributeNames.STANDBY, standby);
       log.info("standby" + standby);
    }
    public void setVspace(final Double vspace)  {
       setAttribute(PAttributeNames.VSPACE, vspace);
       log.info("vspace" + vspace);
    }
    public void setCodeBase(final String codeBase)  {
       setAttribute(PAttributeNames.CODE_BASE, codeBase);
       log.info("codeBase" + codeBase);
    }
    public void setCodeType(final String codeType)  {
       setAttribute(PAttributeNames.CODE_TYPE, codeType);
       log.info("codeType" + codeType);
    }
    public void setBorder(final String border)  {
       setAttribute(PAttributeNames.BORDER, border);
       log.info("border" + border);
    }

    public String getData(){
      return (String) getAttribute(PAttributeNames.DATA);
    }
    public String getType(){
      return (String) getAttribute(PAttributeNames.TYPE_STRING);
    }
    public String getName(){
      return (String) getAttribute(PAttributeNames.NAME);
    }
    public String getUseMap(){
      return (String) getAttribute(PAttributeNames.USE_MAP);
    }
    public String getWidth(){
      return (String) getAttribute(PAttributeNames.WIDTH_STRING);
    }
    public String getHeight(){
      return (String) getAttribute(PAttributeNames.HEIGHT_STRING);
    }
    public String getAlign(){
      return (String) getAttribute(PAttributeNames.ALIGN_STRING);
    }
    public String getArchive(){
      return (String) getAttribute(PAttributeNames.ARCHIVE);
    }
    public String getCode(){
      return (String) getAttribute(PAttributeNames.CODE);
    }
    public Boolean getDeclare(){
      return (Boolean) getAttribute(PAttributeNames.DECLARE);
    }
    public Double getHspace(){
      return (Double) getAttribute(PAttributeNames.HSPACE);
    }
    public String getStandby(){
      return (String) getAttribute(PAttributeNames.STANDBY);
    }
    public Double getVspace(){
      return (Double) getAttribute(PAttributeNames.VSPACE);
    }
    public String getCodeBase(){
      return (String) getAttribute(PAttributeNames.CODE_BASE);
    }
    public String getCodeType(){
      return (String) getAttribute(PAttributeNames.CODE_TYPE);
    }
    public String getBorder(){
      return (String) getAttribute(PAttributeNames.BORDER);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.HTML_OBJECT_ELEMENT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void checkValidity(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CHECK_VALIDITY_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public PNode get(String name) {
       return null;
    }


    public PDocument getSVGDocument() {
       return null;
    }


    public void reportValidity(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.REPORT_VALIDITY_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public PNode set(String name, PNode value) {
       return null;
    }


    public void setCustomValidity(String error){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       SET_CUSTOM_VALIDITY_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {error});
       writer.endObject();
    }

    
}