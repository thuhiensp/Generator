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
import com.ponysdk.core.ui2.PLeafTypeNoArgs;
import com.ponysdk.core.ui2.PLeafTypeWithArgs;
public class PMediaMetadata extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PMediaMetadata.class);
    public PMediaMetadata() {
    }


    public PMediaMetadata(PMediaMetadataInit metadata){
      super(metadata);
    }


    public void setTitle(final String title)  {
       setAttribute(PAttributeNames.TITLE, title);
       log.info("title" + title);
    }
    public void setArtist(final String artist)  {
       setAttribute(PAttributeNames.ARTIST, artist);
       log.info("artist" + artist);
    }
    public void setAlbum(final String album)  {
       setAttribute(PAttributeNames.ALBUM, album);
       log.info("album" + album);
    }
    public void setArtwork(final PMediaImage[] artwork)  {
       setAttribute(PAttributeNames.ARTWORK, artwork);
       log.info("artwork" + artwork);
    }

    public String getTitle(){
      return (String) getAttribute(PAttributeNames.TITLE);
    }
    public String getArtist(){
      return (String) getAttribute(PAttributeNames.ARTIST);
    }
    public String getAlbum(){
      return (String) getAttribute(PAttributeNames.ALBUM);
    }
    public PMediaImage[] getArtwork(){
      return (PMediaImage[]) getAttribute(PAttributeNames.ARTWORK);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
      return PLeafTypeNoArgs.MEDIA_METADATA;
    }

    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
      return PLeafTypeWithArgs.MEDIA_METADATA;
    }


    
}