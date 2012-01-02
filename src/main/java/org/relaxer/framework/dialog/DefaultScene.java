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

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.rConfig.*;
import org.relaxer.framework.rScenario.*;

/**
 * DefaultScene
 *
 * @since   May.  8, 2003
 * @version Feb. 13, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DefaultScene extends AbstractScene {
    private FCScene fcScene_;
    private DefaultDialog dialog_;
    private RelaxerFramework framework_;
    // Map<String, DefaultSlot>
    private Map slots_ = new HashMap();
    // Map<String, Scenario>
    private Map scenarios_ = new HashMap();

    public DefaultScene(
        FCScene fcScene,
        DefaultDialog dialog,
        RelaxerFramework framework
    ) {
        fcScene_ = fcScene;
        dialog_ = dialog;
        framework_ = framework;
        FCSlot[] fcSlots = fcScene.getSlot();
        for (int i = 0;i < fcSlots.length;i++) {
            FCSlot fcSlot = fcSlots[i];
            slots_.put(fcSlot.getName(), new DefaultSlot(fcSlot));
        }
/*
        IFCScenarioChoice[] fcScenarios = fcScene.getScenario();
        for (int i = 0;i < fcScenarios.length;i++) {
            IFCScenarioChoice fcScenario = fcScenarios[i];
            if (fcScenario instanceof FCSceneScenario) {
                scenarios_.put(
                    fcScenario.getName(),
                    new SceneScenario((FCSceneScenario)fcScenario)
                );
            } else if (fcScenario instanceof FCSystemScenario) {
                scenarios_.put(
                    fcScenario.getName(),
                    new SystemScenario((FCSystemScenario)fcScenario)
                );
            } else if (fcScenario instanceof FCActionScenario) {
                scenarios_.put(
                    fcScenario.getName(),
                    new ActionScenario((FCActionScenario)fcScenario)
                );
            } else {
                throw (new InternalError());
            }
        }
*/
    }

    public IPresentationCase getPresentationCase() {
        return (
            new DefaultPresentationCase(
                fcScene_,
                dialog_.getFcDialog()
            )
        );
    }

    public IPresentationState getPresentationState() {
        DefaultPresentationState state
            = new DefaultPresentationState();
        DefaultSlot[] slots = _getPresentationSlots();
        for (int i = 0;i < slots.length;i++) {
            DefaultSlot slot = slots[i];
            state.addState(slot.name, slot.value);
        }
        return (state);
    }

    private DefaultSlot[] _getPresentationSlots() {
        List list = new ArrayList();
        DefaultSlot[] result = new DefaultSlot[list.size()];
        _getPresentationSlots(list);
        return ((DefaultSlot[])list.toArray(result));
    }

    private void _getPresentationSlots(List list) {
        FCScenario[] scenarios = fcScene_.getScenario();
        for (int i = 0;i < scenarios.length;i++) {
            FCScenario scenario = scenarios[i];
            _getPresentationSlots((FCScenario)scenarios[i], list);
        }
    }

    private void _getPresentationSlots(FCScenario scenario, List list) {
        IFCScenarioScriptContentChoice[] actions = scenario.getScenarioScriptContent();
        for (int i = 0;i < actions.length;i++) {
            IFCScenarioScriptContentChoice action = actions[i];
            if (action instanceof FCMoveSceneAction) {
                // TODO
            } else if (action instanceof FCSystemAction) {
                // TODO
            } else if (action instanceof FCServiceAction) {
                _getPresentationSlots((FCServiceAction)action, list);
            }
        }
    }

    private void _getPresentationSlots(FCServiceAction action, List list) {
        FCActionIn[] ins = action.getActionIn();
        for (int i = 0;i < ins.length;i++) {
            FCActionIn in = ins[i];
            _getPresentationSlots(in.getName(), list);
        }
        FCActionOut[] outs = action.getActionOut();
        for (int i = 0;i < outs.length;i++) {
            FCActionOut out = outs[i];
            IFCActionOutChoice content = out.getContent();
            if (content instanceof FCActionOutPoke) {
                _getPresentationSlots(content.getContent(), list);
            } else if (content instanceof FCActionOutPush) {
                // TODO
            }
        }
    }

    private void _getPresentationSlots(String slotName, List list) {
        DefaultSlot slot = _getSlot(slotName);
        if (!list.contains(slot)) {
            list.add(slot);
        }
    }

    public IScene execute(IScenario scenario) {
        return (_execute((DefaultScenario)scenario));
    }

    private IScene _execute(DefaultScenario scenario) {
        FSScenario fsScenario = scenario.getScenario();
//        System.out.println("debug2:" + fsScenario);
        IFSEventChoice[] events = fsScenario.getEvent();
        for (int i = 0;i < events.length;i++) {
            IFSEventChoice event = events[i];
            if (event instanceof FSProperty) {
                _executeProperty((FSProperty)event);
            } else if (event instanceof FSService) {
                _executeService((FSService)event);
            } else if (event instanceof FSScene) {
                return (_executeScene((FSScene)event));
            } else if (event instanceof FSSystem) {
                _executeSystem((FSSystem)event);
            } else {
                throw (new InternalError(event.toString()));
            }
        }
        return (this);
    }

    private void _executeProperty(FSProperty event) {
        String slotName = event.getName();
        DefaultSlot sceneSlot = (DefaultSlot)slots_.get(slotName);
        if (sceneSlot != null) {
            sceneSlot.setString(event.getContent());
        }
        DefaultSlot dialogSlot = dialog_.getSlot(slotName);
        if (dialogSlot != null) {
            dialogSlot.setString(event.getContent());
        }
// System.out.println("debug:" + event.getName() + "/" + event.getContent() + ";" + slot);
    }

    private void _executeService(FSService event) {
        try {
            String service = event.getName();
            FSIn[] ins = event.getIn();
            String[] parameters = new String[ins.length];
            for (int i = 0;i < ins.length;i++) {
                FSIn in = ins[i];
                String slotName = in.getProperty();
                DefaultSlot slot = _getSlot(slotName);
//        System.out.println("debug:" + slotName + ";" + slot);
                if (slot.value != null) {
                    parameters[i] = slot.value.toString(); // XXX
                }
            }
            Object result = framework_.invokeService(service, parameters);
            FSOut out = event.getOut();
            if (out != null) {
                String slotName = out.getProperty();
//                    System.out.println("debug4:" + slotName);
                DefaultSlot slot = _getSlot(slotName);
                slot.setValue(result);
            }
        } catch (Exception e) { // XXX
            e.printStackTrace();
            throw (new UnsupportedOperationException());
        }
    }

    private IScene _executeScene(FSScene event) {
        return (dialog_.getScene(event.getName()));
    }

    private void _executeSystem(FSSystem event) {
        String command = event.getName();
        if ("exit".equals(command)) {
            System.exit(0);
        }
    }

    private DefaultSlot _getSlot(String name) {
        DefaultSlot slot = (DefaultSlot)slots_.get(name);
        if (slot == null) {
            slot = dialog_.getSlot(name);
        }
        return (slot);
    }

/*
    class Scenario {
    }

    class SceneScenario extends Scenario {
        SceneScenario(FCSceneScenario fcScenario) {
        }
    }

    class SystemScenario extends Scenario {
        SystemScenario(FCSystemScenario fcScenario) {
        }
    }

    class ActionScenario extends Scenario {
        private List actions_ = new ArrayList();

        ActionScenario(FCActionScenario fcScenario) {
            IFCActionChoice[] fcActions = fcScenario.getAction();
            for (int i = 0;i < fcActions.length;i++) {
                IFCActionChoice fcAction = fcActions[i];
                if (fcAction instanceof FCServiceAction) {
                    actions_.add(new ServiceAction((FCServiceAction)fcAction));
                } else if (fcAction instanceof FCSystemAction) {
                    actions_.add(new SystemAction((FCSystemAction)fcAction));
                } else if (fcAction instanceof FCSceneAction) {
                    actions_.add(new SceneAction((FCSceneAction)fcAction));
                } else {
                    throw (new InternalError());
                }
            }
        }

        Object execute() {
            int size = actions_.size();
            for (int i = 0;i < size;i++) {
                Action action = (Action)actions_.get(i);
                Object result = action.execute();
                if (result instanceof IScene) {
                    return ((IScene)result);
                }
            }
            return (null);
        }
    }

    abstract class Action {
        abstract Object execute();
    }

    class ServiceAction extends Action {
        FCServiceAction fcAction;

        ServiceAction(FCServiceAction fcAction) {
            this.fcAction = fcAction;
        }

        Object execute() {
            try {
                String service = fcAction.getService();
                FCActionIn[] ins = fcAction.getActionIn();
                String[] parameters = new String[ins.length];
                for (int i = 0;i < ins.length;i++) {
                    FCActionIn in = ins[i];
                    String slotName = in.getSlot();
                    DefaultSlot slot = _getSlot(slotName);
                    parameters[i] = slot.value.toString(); // XXX
                }
                Object result = framework_.executeService(service, parameters);
                FCActionOut out = fcAction.getActionOut();
                if (out != null) {
                    String slotName = out.getSlot();
//                    System.out.println("debug4:" + slotName);
                    DefaultSlot slot = _getSlot(slotName);
                    slot.setValue(result);
                }
            } catch (Exception e) { // XXX
                e.printStackTrace();
                throw (new UnsupportedOperationException());
            }
            return (null);
        }
    }

    class SystemAction extends Action {
        FCSystemAction fcAction;
        String command;

        SystemAction(FCSystemAction fcAction) {
            this.fcAction = fcAction;
            command = fcAction.getSystem();
        }

        Object execute() {
            if ("exit".equals(command)) {
                System.exit(0);
            }
            return (null);
        }
    }

    class SceneAction extends Action {
        FCSceneAction fcAction;
        String scene;

        SceneAction(FCSceneAction fcAction) {
            this.fcAction = fcAction;
            scene = fcAction.getScene();
        }

        Object execute() {
            return (dialog_.getScene(scene));
        }
    }
*/
}
