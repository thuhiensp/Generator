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
public class PAccessibleNode extends PObject2 {
    private static final Logger log = LoggerFactory.getLogger(PAccessibleNode.class);
    private PAccessibleNode(){
    }

    public void setActiveDescendant(final PAccessibleNode activeDescendant)  {
       setAttribute(PAttributeNames.ACTIVE_DESCENDANT, activeDescendant);
       log.info("activeDescendant" + activeDescendant);
    }
    public void setAtomic(final Boolean atomic)  {
       setAttribute(PAttributeNames.ATOMIC, atomic);
       log.info("atomic" + atomic);
    }
    public void setAutocomplete(final String autocomplete)  {
       setAttribute(PAttributeNames.AUTOCOMPLETE, autocomplete);
       log.info("autocomplete" + autocomplete);
    }
    public void setBusy(final Boolean busy)  {
       setAttribute(PAttributeNames.BUSY, busy);
       log.info("busy" + busy);
    }
    public void setChecked(final String checked)  {
       setAttribute(PAttributeNames.CHECKED_STRING, checked);
       log.info("checked" + checked);
    }
    public void setColCount(final Double colCount)  {
       setAttribute(PAttributeNames.COL_COUNT, colCount);
       log.info("colCount" + colCount);
    }
    public void setColIndex(final Double colIndex)  {
       setAttribute(PAttributeNames.COL_INDEX, colIndex);
       log.info("colIndex" + colIndex);
    }
    public void setColSpan(final Double colSpan)  {
       setAttribute(PAttributeNames.COL_SPAN, colSpan);
       log.info("colSpan" + colSpan);
    }
    public void setControls(final PAccessibleNodeList controls)  {
       setAttribute(PAttributeNames.CONTROLS_POBJECT2, controls);
       log.info("controls" + controls);
    }
    public void setCurrent(final String current)  {
       setAttribute(PAttributeNames.CURRENT, current);
       log.info("current" + current);
    }
    public void setDescribedBy(final PAccessibleNodeList describedBy)  {
       setAttribute(PAttributeNames.DESCRIBED_BY, describedBy);
       log.info("describedBy" + describedBy);
    }
    public void setDetails(final PAccessibleNode details)  {
       setAttribute(PAttributeNames.DETAILS, details);
       log.info("details" + details);
    }
    public void setDisabled(final Boolean disabled)  {
       setAttribute(PAttributeNames.DISABLED, disabled);
       log.info("disabled" + disabled);
    }
    public void setErrorMessage(final PAccessibleNode errorMessage)  {
       setAttribute(PAttributeNames.ERROR_MESSAGE, errorMessage);
       log.info("errorMessage" + errorMessage);
    }
    public void setExpanded(final Boolean expanded)  {
       setAttribute(PAttributeNames.EXPANDED, expanded);
       log.info("expanded" + expanded);
    }
    public void setFlowTo(final PAccessibleNodeList flowTo)  {
       setAttribute(PAttributeNames.FLOW_TO, flowTo);
       log.info("flowTo" + flowTo);
    }
    public void setHidden(final Boolean hidden)  {
       setAttribute(PAttributeNames.HIDDEN, hidden);
       log.info("hidden" + hidden);
    }
    public void setInvalid(final String invalid)  {
       setAttribute(PAttributeNames.INVALID, invalid);
       log.info("invalid" + invalid);
    }
    public void setKeyShortcuts(final String keyShortcuts)  {
       setAttribute(PAttributeNames.KEY_SHORTCUTS, keyShortcuts);
       log.info("keyShortcuts" + keyShortcuts);
    }
    public void setLabel(final String label)  {
       setAttribute(PAttributeNames.LABEL, label);
       log.info("label" + label);
    }
    public void setLabeledBy(final PAccessibleNodeList labeledBy)  {
       setAttribute(PAttributeNames.LABELED_BY, labeledBy);
       log.info("labeledBy" + labeledBy);
    }
    public void setLevel(final Double level)  {
       setAttribute(PAttributeNames.LEVEL, level);
       log.info("level" + level);
    }
    public void setLive(final String live)  {
       setAttribute(PAttributeNames.LIVE, live);
       log.info("live" + live);
    }
    public void setModal(final Boolean modal)  {
       setAttribute(PAttributeNames.MODAL, modal);
       log.info("modal" + modal);
    }
    public void setMultiline(final Boolean multiline)  {
       setAttribute(PAttributeNames.MULTILINE, multiline);
       log.info("multiline" + multiline);
    }
    public void setMultiselectable(final Boolean multiselectable)  {
       setAttribute(PAttributeNames.MULTISELECTABLE, multiselectable);
       log.info("multiselectable" + multiselectable);
    }
    public void setOrientation(final String orientation)  {
       setAttribute(PAttributeNames.ORIENTATION, orientation);
       log.info("orientation" + orientation);
    }
    public void setOwns(final PAccessibleNodeList owns)  {
       setAttribute(PAttributeNames.OWNS, owns);
       log.info("owns" + owns);
    }
    public void setPlaceholder(final String placeholder)  {
       setAttribute(PAttributeNames.PLACEHOLDER, placeholder);
       log.info("placeholder" + placeholder);
    }
    public void setPosInSet(final Double posInSet)  {
       setAttribute(PAttributeNames.POS_IN_SET, posInSet);
       log.info("posInSet" + posInSet);
    }
    public void setPressed(final String pressed)  {
       setAttribute(PAttributeNames.PRESSED, pressed);
       log.info("pressed" + pressed);
    }
    public void setReadOnly(final Boolean readOnly)  {
       setAttribute(PAttributeNames.READ_ONLY, readOnly);
       log.info("readOnly" + readOnly);
    }
    public void setRelevant(final String relevant)  {
       setAttribute(PAttributeNames.RELEVANT, relevant);
       log.info("relevant" + relevant);
    }
    public void setRequired(final Boolean required)  {
       setAttribute(PAttributeNames.REQUIRED, required);
       log.info("required" + required);
    }
    public void setRole(final String role)  {
       setAttribute(PAttributeNames.ROLE, role);
       log.info("role" + role);
    }
    public void setRoleDescription(final String roleDescription)  {
       setAttribute(PAttributeNames.ROLE_DESCRIPTION, roleDescription);
       log.info("roleDescription" + roleDescription);
    }
    public void setRowCount(final Double rowCount)  {
       setAttribute(PAttributeNames.ROW_COUNT, rowCount);
       log.info("rowCount" + rowCount);
    }
    public void setRowIndex(final Double rowIndex)  {
       setAttribute(PAttributeNames.ROW_INDEX, rowIndex);
       log.info("rowIndex" + rowIndex);
    }
    public void setRowSpan(final Double rowSpan)  {
       setAttribute(PAttributeNames.ROW_SPAN, rowSpan);
       log.info("rowSpan" + rowSpan);
    }
    public void setSelected(final Boolean selected)  {
       setAttribute(PAttributeNames.SELECTED, selected);
       log.info("selected" + selected);
    }
    public void setSetSize(final Double setSize)  {
       setAttribute(PAttributeNames.SET_SIZE, setSize);
       log.info("setSize" + setSize);
    }
    public void setSort(final String sort)  {
       setAttribute(PAttributeNames.SORT, sort);
       log.info("sort" + sort);
    }
    public void setValueMax(final Double valueMax)  {
       setAttribute(PAttributeNames.VALUE_MAX, valueMax);
       log.info("valueMax" + valueMax);
    }
    public void setValueMin(final Double valueMin)  {
       setAttribute(PAttributeNames.VALUE_MIN, valueMin);
       log.info("valueMin" + valueMin);
    }
    public void setValueNow(final Double valueNow)  {
       setAttribute(PAttributeNames.VALUE_NOW, valueNow);
       log.info("valueNow" + valueNow);
    }
    public void setValueText(final String valueText)  {
       setAttribute(PAttributeNames.VALUE_TEXT, valueText);
       log.info("valueText" + valueText);
    }

    public PAccessibleNode getActiveDescendant(){
      return (PAccessibleNode) getAttribute(PAttributeNames.ACTIVE_DESCENDANT);
    }
    public Boolean getAtomic(){
      return (Boolean) getAttribute(PAttributeNames.ATOMIC);
    }
    public String getAutocomplete(){
      return (String) getAttribute(PAttributeNames.AUTOCOMPLETE);
    }
    public Boolean getBusy(){
      return (Boolean) getAttribute(PAttributeNames.BUSY);
    }
    public String getChecked(){
      return (String) getAttribute(PAttributeNames.CHECKED_STRING);
    }
    public Double getColCount(){
      return (Double) getAttribute(PAttributeNames.COL_COUNT);
    }
    public Double getColIndex(){
      return (Double) getAttribute(PAttributeNames.COL_INDEX);
    }
    public Double getColSpan(){
      return (Double) getAttribute(PAttributeNames.COL_SPAN);
    }
    public PAccessibleNodeList getControls(){
      return (PAccessibleNodeList) getAttribute(PAttributeNames.CONTROLS_POBJECT2);
    }
    public String getCurrent(){
      return (String) getAttribute(PAttributeNames.CURRENT);
    }
    public PAccessibleNodeList getDescribedBy(){
      return (PAccessibleNodeList) getAttribute(PAttributeNames.DESCRIBED_BY);
    }
    public PAccessibleNode getDetails(){
      return (PAccessibleNode) getAttribute(PAttributeNames.DETAILS);
    }
    public Boolean getDisabled(){
      return (Boolean) getAttribute(PAttributeNames.DISABLED);
    }
    public PAccessibleNode getErrorMessage(){
      return (PAccessibleNode) getAttribute(PAttributeNames.ERROR_MESSAGE);
    }
    public Boolean getExpanded(){
      return (Boolean) getAttribute(PAttributeNames.EXPANDED);
    }
    public PAccessibleNodeList getFlowTo(){
      return (PAccessibleNodeList) getAttribute(PAttributeNames.FLOW_TO);
    }
    public Boolean getHidden(){
      return (Boolean) getAttribute(PAttributeNames.HIDDEN);
    }
    public String getInvalid(){
      return (String) getAttribute(PAttributeNames.INVALID);
    }
    public String getKeyShortcuts(){
      return (String) getAttribute(PAttributeNames.KEY_SHORTCUTS);
    }
    public String getLabel(){
      return (String) getAttribute(PAttributeNames.LABEL);
    }
    public PAccessibleNodeList getLabeledBy(){
      return (PAccessibleNodeList) getAttribute(PAttributeNames.LABELED_BY);
    }
    public Double getLevel(){
      return (Double) getAttribute(PAttributeNames.LEVEL);
    }
    public String getLive(){
      return (String) getAttribute(PAttributeNames.LIVE);
    }
    public Boolean getModal(){
      return (Boolean) getAttribute(PAttributeNames.MODAL);
    }
    public Boolean getMultiline(){
      return (Boolean) getAttribute(PAttributeNames.MULTILINE);
    }
    public Boolean getMultiselectable(){
      return (Boolean) getAttribute(PAttributeNames.MULTISELECTABLE);
    }
    public String getOrientation(){
      return (String) getAttribute(PAttributeNames.ORIENTATION);
    }
    public PAccessibleNodeList getOwns(){
      return (PAccessibleNodeList) getAttribute(PAttributeNames.OWNS);
    }
    public String getPlaceholder(){
      return (String) getAttribute(PAttributeNames.PLACEHOLDER);
    }
    public Double getPosInSet(){
      return (Double) getAttribute(PAttributeNames.POS_IN_SET);
    }
    public String getPressed(){
      return (String) getAttribute(PAttributeNames.PRESSED);
    }
    public Boolean getReadOnly(){
      return (Boolean) getAttribute(PAttributeNames.READ_ONLY);
    }
    public String getRelevant(){
      return (String) getAttribute(PAttributeNames.RELEVANT);
    }
    public Boolean getRequired(){
      return (Boolean) getAttribute(PAttributeNames.REQUIRED);
    }
    public String getRole(){
      return (String) getAttribute(PAttributeNames.ROLE);
    }
    public String getRoleDescription(){
      return (String) getAttribute(PAttributeNames.ROLE_DESCRIPTION);
    }
    public Double getRowCount(){
      return (Double) getAttribute(PAttributeNames.ROW_COUNT);
    }
    public Double getRowIndex(){
      return (Double) getAttribute(PAttributeNames.ROW_INDEX);
    }
    public Double getRowSpan(){
      return (Double) getAttribute(PAttributeNames.ROW_SPAN);
    }
    public Boolean getSelected(){
      return (Boolean) getAttribute(PAttributeNames.SELECTED);
    }
    public Double getSetSize(){
      return (Double) getAttribute(PAttributeNames.SET_SIZE);
    }
    public String getSort(){
      return (String) getAttribute(PAttributeNames.SORT);
    }
    public Double getValueMax(){
      return (Double) getAttribute(PAttributeNames.VALUE_MAX);
    }
    public Double getValueMin(){
      return (Double) getAttribute(PAttributeNames.VALUE_MIN);
    }
    public Double getValueNow(){
      return (Double) getAttribute(PAttributeNames.VALUE_NOW);
    }
    public String getValueText(){
      return (String) getAttribute(PAttributeNames.VALUE_TEXT);
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