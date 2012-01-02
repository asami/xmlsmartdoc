/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@relaxer.org)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package org.relaxer.framework.dialog;

import java.util.*;
import java.io.*;
import org.relaxer.framework.rConfig.*;

/**
 * DefaultConsolePresentation
 *
 * @since   May.  8, 2003
 * @version Jan.  7, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DefaultConsolePresentation extends AbstractPullPresentation {
    private FCDialog fcDialog_;
    private FCScene fcScene_;
    // Map<String, Slot>
    private Map dialogSlots_ = new HashMap();
    // Map<String, Slot>
    private Map sceneSlots_ = new HashMap();
    private FCScenario[] fcScenarios_;
    private Map fcScenarioMap_ = new HashMap();
    private FCScenario currentScenario_;
    private BufferedReader in_
        = new BufferedReader(new InputStreamReader(System.in));

    public DefaultConsolePresentation() {
    }

    public void setPresentationCase(
        IPresentationCase presentationCase
    ) {
        _setPresentationCase((DefaultPresentationCase)presentationCase);
    }

    private void _setPresentationCase(
        DefaultPresentationCase presentationCase
    ) {
        fcDialog_ = presentationCase.getFcDialog();
        fcScene_ = presentationCase.getFcScene();
        _setupDialogSlots(fcDialog_.getSlot());
        _setupSceneSlots(fcScene_.getSlot());
        fcScenarios_ = fcScene_.getScenario();
    }

    public void setPresentationState(
        IPresentationState presentationState
    ) {
        _setPresentationState((DefaultPresentationState)presentationState);
    }

    private void _setPresentationState(
        DefaultPresentationState presentationState
    ) {
        String[] keys = presentationState.getKeys();
        for (int i = 0;i < keys.length;i++) {
            String key = keys[i];
//System.out.println("key:" + key);
            Object value = presentationState.getValue(key);
            Slot slot = _getSlot(key);
            if (slot != null) {
                if (value != null) {
                    slot.value = value.toString();
                }
            }
        }
    }

    private void _setupDialogSlots(FCSlot[] fcSlots) {
        for (int i = 0;i < fcSlots.length;i++) {
            FCSlot fcSlot = fcSlots[i];
            dialogSlots_.put(fcSlot.getName(), new Slot(fcSlot));
        }
    }

    private void _setupSceneSlots(FCSlot[] fcSlots) {
        for (int i = 0;i < fcSlots.length;i++) {
            FCSlot fcSlot = fcSlots[i];
            sceneSlots_.put(fcSlot.getName(), new Slot(fcSlot));
        }
    }

    public IScenario execute() {
        System.out.println("Scene <" + fcScene_.getName() + ">");
        try {
            interaction_();
            return (makeScenario_());
        } catch (IOException e) {
            throw (new UnsupportedOperationException());
        }
    }

    private void interaction_() throws IOException {
        for (;;) {
            currentScenario_ = _chooseScenario();
            Slot[] slots = _getInputSlots(currentScenario_);
            for (int i = 0;i < slots.length;i++) {
                Slot slot = slots[i];
                _inputSlot(slot);
            }
            if (_confirm(currentScenario_)) {
                break;
            }
        }
    }

    private Slot[] _getRelatedSlots(FCScenario scenario) {
        List slots = new ArrayList();
        Set checked = new HashSet();
        IFCScenarioScriptContentChoice[] actions = scenario.getScenarioScriptContent();
        for (int i = 0;i < actions.length;i++) {
            IFCScenarioScriptContentChoice action = actions[i];
            FCActionIn[] ins = action.getActionIn();
            for (int j = 0;j < ins.length;j++) {
                FCActionIn in = ins[j];
                String slotName = in.getName();
                if (checked.contains(slotName)) {
                    continue;
                }
                checked.add(slotName);
                Slot slot = _getSlot(slotName);
                if (slot == null) {
                    throw (new UnsupportedOperationException(slotName));
                }
                slots.add(slot);
            }
        }
        Slot[] result = new Slot[slots.size()];
        return ((Slot[])slots.toArray(result));
    }

    private Slot _getSlot(String slotName) {
        Slot slot = (Slot)sceneSlots_.get(slotName);
        if (slot == null) {
            slot = (Slot)dialogSlots_.get(slotName);
        }
        return (slot);
    }

    private Slot[] _getInputSlots(FCScenario scenario) {
        List slots = new ArrayList();
        Set checked = new HashSet();
        IFCScenarioScriptContentChoice[] actions = scenario.getScenarioScriptContent();
        for (int i = 0;i < actions.length;i++) {
            IFCScenarioScriptContentChoice action = actions[i];
            FCActionIn[] ins = action.getActionIn();
            for (int j = 0;j < ins.length;j++) {
                FCActionIn in = ins[j];
                String slotName = in.getName();
                if (checked.contains(slotName)) {
                    continue;
                }
                checked.add(slotName);
                Slot slot = (Slot)sceneSlots_.get(slotName);
                if (slot != null) {
                    slots.add(slot);
                }
            }
        }
        Slot[] result = new Slot[slots.size()];
        return ((Slot[])slots.toArray(result));
    }

    private boolean _confirm(FCScenario scenario) throws IOException {
        System.out.println("Scenario <" + scenario.getName() + ">");
        Slot[] slots = _getRelatedSlots(scenario);
        for (int i = 0;i < slots.length;i++) {
            Slot slot = slots[i];
            System.out.println(slot.name + " : " + slot.value);
        }
        System.out.print("OK? (yes/no) : ");
        String input = in_.readLine();
        return ("yes".equals(input));
    }

    private FCScenario _chooseScenario() throws IOException {
        for (;;) {
            System.out.print("Select scenario ");
            for (int i = 0;i < fcScenarios_.length;i++) {
                FCScenario fcScenario = fcScenarios_[i];
                System.out.print("[");
                System.out.print(i + 1);
                System.out.print("] ");
                System.out.print(fcScenario.getName());
                System.out.print(", ");
            }
            System.out.print("[exit] exit : ");
            String selection = in_.readLine();
            if ("exit".equals(selection)) {
                System.exit(0);
            }
            try {
                int number = Integer.parseInt(selection);
//                System.out.println("debug3:" + number);
                if (number <= 0 || fcScenarios_.length < number) {
                    continue;
                }
                return (fcScenarios_[number - 1]);
            } catch (NumberFormatException e) {
            }
        }
    }

    private IScenario makeScenario_() {
        DefaultScenario scenario = new DefaultScenario();
        Slot[] slots = _getInputSlots(currentScenario_);
        for (int i = 0;i < slots.length;i++) {
            Slot slot = slots[i];
            scenario.addPropertyEvent(slot.name, slot.value);
        }
        IFCScenarioScriptContentChoice[] fcActions = currentScenario_.getScenarioScriptContent();
        for (int i = 0;i < fcActions.length;i++) {
            IFCScenarioScriptContentChoice fcAction = fcActions[i];
            if (fcAction instanceof FCServiceAction) {
                FCServiceAction serviceAction = (FCServiceAction)fcAction;
                scenario.addServiceEvent(serviceAction.getRef());
                FCActionIn[] ins = serviceAction.getActionIn();
                for (int j = 0;j < ins.length;j++) {
                    FCActionIn in = ins[j];
                    scenario.addServiceIn(in.getName());
                }
                FCActionOut[] outs = serviceAction.getActionOut();
                for (int j = 0;j < outs.length;j++) {
                    FCActionOut out = outs[j];
                    IFCActionOutChoice content = out.getContent();
                    if (content instanceof FCActionOutPoke) {
                        scenario.addServiceOut(content.getContent());
                    } else if (content instanceof FCActionOutPush) {
                        // TODO
                    }
                }
            } else if (fcAction instanceof FCSystemAction) {
                FCSystemAction systemAction = (FCSystemAction)fcAction;
                scenario.addSystemEvent(systemAction.getRef());
            } else if (fcAction instanceof FCMoveSceneAction) {
                FCMoveSceneAction sceneAction = (FCMoveSceneAction)fcAction;
                scenario.addSceneEvent(sceneAction.getRef());
            } else if (fcAction instanceof FCScenarioAction) {
                throw (new UnsupportedOperationException());
            }
        }
        return (scenario);
    }

    private void _inputSlot(Slot slot) throws IOException {
        System.out.print(slot.name);
        System.out.print(": ");
        slot.value = in_.readLine();
    }

/*
    private void _printSlots() {
        for (int i = 0;i < slots_.length;i++) {
            Slot slot = slots_[i];
            System.out.print(slot.name);
            System.out.print(":");
            if (slot.value == null) {
                System.out.print("N/A");
            } else {
                System.out.print(slot.value);
            }
            System.out.println();
        }
    }        
*/

    class Slot {
        public FCSlot fcSlot;
        public String name;
        public String value;

        Slot(FCSlot fcSlot) {
            this.fcSlot = fcSlot;
            name = fcSlot.getName();
        }
    }
}
