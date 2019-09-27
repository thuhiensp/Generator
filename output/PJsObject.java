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
public class PJsObject<T> extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PJsObject.class);
    public PJsObject() {
    }


    public PJsObject(Object value){
      super(value);
    }


    public void set__proto__(final PJsObject __proto__)  {
       setAttribute(PAttributeNames.__PROTO__, __proto__);
       log.info("__proto__" + __proto__);
    }
    public void setConstructor(final PFunction constructor)  {
       setAttribute(PAttributeNames.CONSTRUCTOR, constructor);
       log.info("constructor" + constructor);
    }

    public PJsObject get__proto__(){
      return (PJsObject) getAttribute(PAttributeNames.__PROTO__);
    }
    public PFunction getConstructor(){
      return (PFunction) getAttribute(PAttributeNames.CONSTRUCTOR);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.JS_OBJECT;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.JS_OBJECT;
    }


    public void __defineGetter__(String propertyName, PObjectPropertyGetterFunction func){
    }

    public void __defineSetter__(String propertyName, PObjectPropertySetterFunction func){
    }

    public <U> PObjectPropertyGetterFunction<U> __lookupGetter__(String propertyName) {
       return null;
    }


    public <U> PObjectPropertySetterFunction<U> __lookupSetter__(String propertyName) {
       return null;
    }


    public void apply(final Consumer<Object> cback,Object thisArg){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.APPLY_TYPEOBJECT_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {thisArg});
       writer.endObject();
    }

    public void apply(final Consumer<Object> cback,Object thisArg, Object[] arguments){
    }

    public PJsObject assign(PJsObject target, PJsObject sources) {
       return null;
    }


    public void call(final Consumer<Object> cback,Object thisArg, Object arguments){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.CALL_TYPEOBJECT_TYPEOBJECT_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {thisArg,arguments});
       writer.endObject();
    }

    public PJsObject create(PJsObject proto) {
       return null;
    }


    public PJsObject create(PJsObject proto, PJsObject propertiesObject) {
       return null;
    }


    public <T extends PJsObject> T defineProperties(T obj, PJsObject<PObjectPropertyDescriptor> properties) {
       return null;
    }


    public <T extends PJsObject, U> T defineProperty(T obj, String propertyName, PObjectPropertyDescriptor<U> descriptor) {
       return null;
    }


    public Object[][] entries(PJsObject obj) {
       return null;
    }


    public <T extends PJsObject> T freeze(T obj) {
       return null;
    }


    public <U> PObjectPropertyDescriptor<U> getOwnPropertyDescriptor(PJsObject obj, String propertyName) {
       return null;
    }


    public PJsObject<PObjectPropertyDescriptor> getOwnPropertyDescriptors(PJsObject obj) {
       return null;
    }


    public String[] getOwnPropertyNames(PJsObject obj) {
       return null;
    }


    public Object[] getOwnPropertySymbols(PJsObject obj) {
       return null;
    }


    public PJsObject getPrototypeOf(PJsObject obj) {
       return null;
    }


    public void hasOwnProperty(final Consumer<Boolean> cback,String propertyName){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_OWN_PROPERTY_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {propertyName});
       writer.endObject();
    }

    public void is(final Consumer<Boolean> cback,Object value1, Object value2){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_TYPEOBJECT_TYPEOBJECT_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {value1,value2});
       writer.endObject();
    }

    public void isExtensible(final Consumer<Boolean> cback,PJsObject obj){
    }

    public void isFrozen(final Consumer<Boolean> cback,PJsObject obj){
    }

    public void isPrototypeOf(final Consumer<Boolean> cback,PJsObject obj){
    }

    public void isSealed(final Consumer<Boolean> cback,PJsObject obj){
    }

    public String[] keys(PJsObject obj) {
       return null;
    }


    public PJsObject preventExtensions(PJsObject obj) {
       return null;
    }


    public void propertyIsEnumerable(final Consumer<Boolean> cback,String propertyName){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.PROPERTY_IS_ENUMERABLE_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {propertyName});
       writer.endObject();
    }

    public <T extends PJsObject> T seal(T seal) {
       return null;
    }


    public PJsObject setPrototypeOf(PJsObject obj, Object proto) {
       return null;
    }


    public void toLocaleString(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_LOCALE_STRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void toLocaleString(final Consumer<String> cback,String locales){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_LOCALE_STRING_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {locales});
       writer.endObject();
    }

    public void toLocaleString(final Consumer<String> cback,String[] locales){
    }

    public void toLocaleString(final Consumer<String> cback,String locales, PLocaleOptions options){
    }

    public void toLocaleString(final Consumer<String> cback,String[] locales, PLocaleOptions options){
    }

    public void toSource(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_SOURCE_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public void valueOf(final Consumer<Object> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.VALUE_OF_OBJECT.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public <T> T values(PJsObject<T> obj) {
       return null;
    }


    
}