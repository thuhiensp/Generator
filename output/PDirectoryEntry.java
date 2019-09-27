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
public class PDirectoryEntry extends PEntry {
    private PDirectoryEntry(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PDirectoryReader createReader() {
       return null;
    }


    public void getDirectory(String path){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       GET_DIRECTORY_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {path});
       writer.endObject();
    }

    public void getDirectory(String path, PFileSystemFlags options){
    }

    public void getDirectory(String path, PFileSystemFlags options, PEntryCallback successCallback){
    }

    public void getDirectory(String path, PFileSystemFlags options, PEntryCallback successCallback, PErrorCallback errorCallback){
    }

    public void getFile(String path){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       GET_FILE_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {path});
       writer.endObject();
    }

    public void getFile(String path, PFileSystemFlags options){
    }

    public void getFile(String path, PFileSystemFlags options, PEntryCallback successCallback){
    }

    public void getFile(String path, PFileSystemFlags options, PEntryCallback successCallback, PErrorCallback errorCallback){
    }

    public void removeRecursively(PVoidCallback successCallback){
    }

    public void removeRecursively(PVoidCallback successCallback, PErrorCallback errorCallback){
    }

    
}