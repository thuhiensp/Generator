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
public abstract class PNode extends PEventTarget {
    private static final Logger log = LoggerFactory.getLogger(PNode.class);
     protected PNode() {
     }
    protected PNode(final Object...argOfConstructor){
       super(argOfConstructor);
    }
    public void setNodeValue(final String nodeValue)  {
       setAttribute(PAttributeNames.NODE_VALUE, nodeValue);
       log.info("nodeValue" + nodeValue);
    }
    public void setTextContent(final String textContent)  {
       setAttribute(PAttributeNames.TEXT_CONTENT, textContent);
       log.info("textContent" + textContent);
    }

    public String getNodeValue(){
      return (String) getAttribute(PAttributeNames.NODE_VALUE);
    }
    public String getTextContent(){
      return (String) getAttribute(PAttributeNames.TEXT_CONTENT);
    }


    public PNode appendChild(PNode node) {
       return null;
    }


    public PNode cloneNode() {
       return null;
    }


    public PNode cloneNode(Boolean deep) {
       return null;
    }


    public void compareDocumentPosition(final Consumer<Short> cback,PNode other){
    }

    public void contains(final Consumer<Boolean> cback,PNode other){
    }

    public PNode getRootNode() {
       return null;
    }


    public PNode getRootNode(PGetRootNodeOptions options) {
       return null;
    }


    public void hasChildNodes(final Consumer<Boolean> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.HAS_CHILD_NODES_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.endObject();
    }

    public PNode insertBefore(PNode node, PNode child) {
       return null;
    }


    public void isDefaultNamespace(final Consumer<Boolean> cback,String namespaceURI){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.IS_DEFAULT_NAMESPACE_TYPESTRING_BOOLEAN.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {namespaceURI});
       writer.endObject();
    }

    public void isEqualNode(final Consumer<Boolean> cback,PNode otherNode){
    }

    public void isSameNode(final Consumer<Boolean> cback,PNode otherNode){
    }

    public void lookupNamespaceURI(final Consumer<String> cback,String prefix){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.LOOKUP_NAMESPACEURI_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {prefix});
       writer.endObject();
    }

    public void lookupPrefix(final Consumer<String> cback,String namespaceURI){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.LOOKUP_PREFIX_TYPESTRING_STRING.getValue());
       writer.write(ServerToClientModel.POBJECT2_METHOD_CALLBACK, cbacksSequence);
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {namespaceURI});
       writer.endObject();
    }

    public void normalize(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       NORMALIZE_VOID.getValue());
       writer.endObject();
    }

    public PNode removeChild(PNode child) {
       return null;
    }


    public PNode replaceChild(PNode node, PNode child) {
       return null;
    }


    
}