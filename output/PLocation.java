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
public class PLocation extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PLocation.class);
    private PLocation(){
    }

    public void setHref(final String href)  {
       setAttribute(PAttributeNames.HREF, href);
       log.info("href" + href);
    }
    public void setProtocol(final String protocol)  {
       setAttribute(PAttributeNames.PROTOCOL, protocol);
       log.info("protocol" + protocol);
    }
    public void setHost(final String host)  {
       setAttribute(PAttributeNames.HOST, host);
       log.info("host" + host);
    }
    public void setHostname(final String hostname)  {
       setAttribute(PAttributeNames.HOSTNAME, hostname);
       log.info("hostname" + hostname);
    }
    public void setPort(final String port)  {
       setAttribute(PAttributeNames.PORT, port);
       log.info("port" + port);
    }
    public void setPathname(final String pathname)  {
       setAttribute(PAttributeNames.PATHNAME, pathname);
       log.info("pathname" + pathname);
    }
    public void setSearch(final String search)  {
       setAttribute(PAttributeNames.SEARCH, search);
       log.info("search" + search);
    }
    public void setHash(final String hash)  {
       setAttribute(PAttributeNames.HASH, hash);
       log.info("hash" + hash);
    }

    public String getHref(){
      return (String) getAttribute(PAttributeNames.HREF);
    }
    public String getProtocol(){
      return (String) getAttribute(PAttributeNames.PROTOCOL);
    }
    public String getHost(){
      return (String) getAttribute(PAttributeNames.HOST);
    }
    public String getHostname(){
      return (String) getAttribute(PAttributeNames.HOSTNAME);
    }
    public String getPort(){
      return (String) getAttribute(PAttributeNames.PORT);
    }
    public String getPathname(){
      return (String) getAttribute(PAttributeNames.PATHNAME);
    }
    public String getSearch(){
      return (String) getAttribute(PAttributeNames.SEARCH);
    }
    public String getHash(){
      return (String) getAttribute(PAttributeNames.HASH);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void assign(String url){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       ASSIGN_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {url});
       writer.endObject();
    }

    public void reload(){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       RELOAD_VOID.getValue());
       writer.endObject();
    }

    public void replace(String url){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       REPLACE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {url});
       writer.endObject();
    }

    public void toString(final Consumer<String> cback){
       cbacksSequence++;
       cbacks.put(cbacksSequence, cback);
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.TO_STRING_STRING.getValue());
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

    
}