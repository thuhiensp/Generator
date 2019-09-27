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
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PFile extends PBlob {
    public PFile(PArrayBuffer[] fileBits, String fileName){
      super(fileBits, fileName);
    }

    public PFile(PArrayBuffer[] fileBits, String fileName, PFilePropertyBag options){
      super(fileBits, fileName, options);
    }

    public PFile(PArrayBufferView[] fileBits, String fileName){
      super(fileBits, fileName);
    }

    public PFile(PArrayBufferView[] fileBits, String fileName, PFilePropertyBag options){
      super(fileBits, fileName, options);
    }

    public PFile(PBlob[] fileBits, String fileName){
      super(fileBits, fileName);
    }

    public PFile(PBlob[] fileBits, String fileName, PFilePropertyBag options){
      super(fileBits, fileName, options);
    }

    public PFile(String[] fileBits, String fileName){
      super(fileBits, fileName);
    }

    public PFile(String[] fileBits, String fileName, PFilePropertyBag options){
      super(fileBits, fileName, options);
    }




    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.FILE;
    }


    
}