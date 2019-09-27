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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
public class PBarcodeDetector extends PObject2 {
    public PBarcodeDetector() {
    }





    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.BARCODE_DETECTOR;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise<PDetectedBarcode[]> detect(PHTMLImageElement image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(PSVGImageElement image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(PHTMLVideoElement image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(PHTMLCanvasElement image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(PBlob image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(PImageData image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(PImageBitmap image) {
       return null;
    }


    public PPromise<PDetectedBarcode[]> detect(POffscreenCanvas image) {
       return null;
    }


    
}