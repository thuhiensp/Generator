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
public class PDatabase extends PObject2 {
    private PDatabase(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public void changeVersion(String oldVersion, String newVersion){
       final ModelWriter writer = UIContext.get().getWriter();
       writer.beginPObject2();
       writer.write(ServerToClientModel.POBJECT2_METHOD_VOID, getID());
       writer.write(ServerToClientModel.POBJECT2_NUM_METHOD, PMethodNames.
       CHANGE_VERSION_TYPESTRING_TYPESTRING_VOID.getValue());
       writer.write(ServerToClientModel.POBJECT2_ARRAY_ARGUMENTS, new Object[] {oldVersion,newVersion});
       writer.endObject();
    }

    public void changeVersion(String oldVersion, String newVersion, PSQLTransactionCallback callback){
    }

    public void changeVersion(String oldVersion, String newVersion, PSQLTransactionCallback callback, PSQLTransactionErrorCallback errorCallback){
    }

    public void changeVersion(String oldVersion, String newVersion, PSQLTransactionCallback callback, PSQLTransactionErrorCallback errorCallback, PVoidCallback successCallback){
    }

    public void readTransaction(PSQLTransactionCallback callback){
    }

    public void readTransaction(PSQLTransactionCallback callback, PSQLTransactionErrorCallback errorCallback){
    }

    public void readTransaction(PSQLTransactionCallback callback, PSQLTransactionErrorCallback errorCallback, PVoidCallback successCallback){
    }

    public void transaction(PSQLTransactionCallback callback){
    }

    public void transaction(PSQLTransactionCallback callback, PSQLTransactionErrorCallback errorCallback){
    }

    public void transaction(PSQLTransactionCallback callback, PSQLTransactionErrorCallback errorCallback, PVoidCallback successCallback){
    }

    
}