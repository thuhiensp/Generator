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
public class PSubtleCrypto extends PObject2 {
    private PSubtleCrypto(){
    }



    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    public PPromise decrypt(PJsObject algorithm, PCryptoKey key, PArrayBuffer data) {
       return null;
    }


    public PPromise decrypt(PJsObject algorithm, PCryptoKey key, PArrayBufferView data) {
       return null;
    }


    public PPromise decrypt(String algorithm, PCryptoKey key, PArrayBuffer data) {
       return null;
    }


    public PPromise decrypt(String algorithm, PCryptoKey key, PArrayBufferView data) {
       return null;
    }


    public PPromise deriveBits(PJsObject algorithm, PCryptoKey baseKey, Double length) {
       return null;
    }


    public PPromise deriveBits(String algorithm, PCryptoKey baseKey, Double length) {
       return null;
    }


    public PPromise deriveKey(PJsObject algorithm, PCryptoKey baseKey, PJsObject derivedKeyType, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise deriveKey(PJsObject algorithm, PCryptoKey baseKey, String derivedKeyType, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise deriveKey(String algorithm, PCryptoKey baseKey, PJsObject derivedKeyType, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise deriveKey(String algorithm, PCryptoKey baseKey, String derivedKeyType, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise digest(PJsObject algorithm, PArrayBuffer data) {
       return null;
    }


    public PPromise digest(PJsObject algorithm, PArrayBufferView data) {
       return null;
    }


    public PPromise digest(String algorithm, PArrayBuffer data) {
       return null;
    }


    public PPromise digest(String algorithm, PArrayBufferView data) {
       return null;
    }


    public PPromise encrypt(PJsObject algorithm, PCryptoKey key, PArrayBuffer data) {
       return null;
    }


    public PPromise encrypt(PJsObject algorithm, PCryptoKey key, PArrayBufferView data) {
       return null;
    }


    public PPromise encrypt(String algorithm, PCryptoKey key, PArrayBuffer data) {
       return null;
    }


    public PPromise encrypt(String algorithm, PCryptoKey key, PArrayBufferView data) {
       return null;
    }


    public PPromise exportKey(String format, PCryptoKey key) {
       return null;
    }


    public PPromise generateKey(PJsObject algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise generateKey(String algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise importKey(String format, PArrayBuffer keyData, PJsObject algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise importKey(String format, PArrayBuffer keyData, String algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise importKey(String format, PArrayBufferView keyData, PJsObject algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise importKey(String format, PArrayBufferView keyData, String algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise importKey(String format, PJsObject keyData, PJsObject algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise importKey(String format, PJsObject keyData, String algorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise sign(PJsObject algorithm, PCryptoKey key, PArrayBuffer data) {
       return null;
    }


    public PPromise sign(PJsObject algorithm, PCryptoKey key, PArrayBufferView data) {
       return null;
    }


    public PPromise sign(String algorithm, PCryptoKey key, PArrayBuffer data) {
       return null;
    }


    public PPromise sign(String algorithm, PCryptoKey key, PArrayBufferView data) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBuffer wrappedKey, PCryptoKey unwrappingKey, PJsObject unwrapAlgorithm, PJsObject unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBuffer wrappedKey, PCryptoKey unwrappingKey, PJsObject unwrapAlgorithm, String unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBuffer wrappedKey, PCryptoKey unwrappingKey, String unwrapAlgorithm, PJsObject unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBuffer wrappedKey, PCryptoKey unwrappingKey, String unwrapAlgorithm, String unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBufferView wrappedKey, PCryptoKey unwrappingKey, PJsObject unwrapAlgorithm, PJsObject unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBufferView wrappedKey, PCryptoKey unwrappingKey, PJsObject unwrapAlgorithm, String unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBufferView wrappedKey, PCryptoKey unwrappingKey, String unwrapAlgorithm, PJsObject unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise unwrapKey(String format, PArrayBufferView wrappedKey, PCryptoKey unwrappingKey, String unwrapAlgorithm, String unwrappedKeyAlgorithm, Boolean extractable, String[] keyUsages) {
       return null;
    }


    public PPromise verify(PJsObject algorithm, PCryptoKey key, PArrayBuffer signature, PArrayBuffer data) {
       return null;
    }


    public PPromise verify(PJsObject algorithm, PCryptoKey key, PArrayBuffer signature, PArrayBufferView data) {
       return null;
    }


    public PPromise verify(PJsObject algorithm, PCryptoKey key, PArrayBufferView signature, PArrayBuffer data) {
       return null;
    }


    public PPromise verify(PJsObject algorithm, PCryptoKey key, PArrayBufferView signature, PArrayBufferView data) {
       return null;
    }


    public PPromise verify(String algorithm, PCryptoKey key, PArrayBuffer signature, PArrayBuffer data) {
       return null;
    }


    public PPromise verify(String algorithm, PCryptoKey key, PArrayBuffer signature, PArrayBufferView data) {
       return null;
    }


    public PPromise verify(String algorithm, PCryptoKey key, PArrayBufferView signature, PArrayBuffer data) {
       return null;
    }


    public PPromise verify(String algorithm, PCryptoKey key, PArrayBufferView signature, PArrayBufferView data) {
       return null;
    }


    public PPromise wrapKey(String format, PCryptoKey key, PCryptoKey wrappingKey, PJsObject wrapAlgorithm) {
       return null;
    }


    public PPromise wrapKey(String format, PCryptoKey key, PCryptoKey wrappingKey, String wrapAlgorithm) {
       return null;
    }


    
}