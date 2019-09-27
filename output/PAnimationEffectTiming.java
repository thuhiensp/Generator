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
public class PAnimationEffectTiming extends PAnimationEffectTimingReadOnly {
    private static final Logger log = LoggerFactory.getLogger(PAnimationEffectTiming.class);
    private PAnimationEffectTiming(){
    }

    public void setDelay(final Double delay)  {
       setAttribute(PAttributeNames.DELAY, delay);
       log.info("delay" + delay);
    }
    public void setEndDelay(final Double endDelay)  {
       setAttribute(PAttributeNames.END_DELAY, endDelay);
       log.info("endDelay" + endDelay);
    }
    public void setFill(final String fill)  {
       setAttribute(PAttributeNames.FILL, fill);
       log.info("fill" + fill);
    }
    public void setIterationStart(final Double iterationStart)  {
       setAttribute(PAttributeNames.ITERATION_START, iterationStart);
       log.info("iterationStart" + iterationStart);
    }
    public void setIterations(final Double iterations)  {
       setAttribute(PAttributeNames.ITERATIONS, iterations);
       log.info("iterations" + iterations);
    }
    public void setDuration(final PDoubleOrString duration)  {
       setAttribute(PAttributeNames.DURATION_UNIONTYPE, duration);
       log.info("duration" + duration);
    }
    public void setEasing(final String easing)  {
       setAttribute(PAttributeNames.EASING, easing);
       log.info("easing" + easing);
    }
    public void setDirection(final PPlaybackDirection direction)  {
       setAttribute(PAttributeNames.DIRECTION_PENUM, direction);
       log.info("direction" + direction);
    }

    public Double getDelay(){
      return (Double) getAttribute(PAttributeNames.DELAY);
    }
    public Double getEndDelay(){
      return (Double) getAttribute(PAttributeNames.END_DELAY);
    }
    public String getFill(){
      return (String) getAttribute(PAttributeNames.FILL);
    }
    public Double getIterationStart(){
      return (Double) getAttribute(PAttributeNames.ITERATION_START);
    }
    public Double getIterations(){
      return (Double) getAttribute(PAttributeNames.ITERATIONS);
    }
    public PDoubleOrString getDuration(){
      return (PDoubleOrString) getAttribute(PAttributeNames.DURATION_UNIONTYPE);
    }
    public String getEasing(){
      return (String) getAttribute(PAttributeNames.EASING);
    }
    public PPlaybackDirection getDirection(){
      return (PPlaybackDirection) getAttribute(PAttributeNames.DIRECTION_PENUM);
    }

    @Override
    protected PLeafTypeNoArgs widgetNoArgs() {
       return null;
    }
    @Override
    protected PLeafTypeWithArgs widgetWithArgs() {
       return null;
    }

    
}