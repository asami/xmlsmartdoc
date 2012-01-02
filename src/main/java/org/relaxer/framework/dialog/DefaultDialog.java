/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

/**
 * DefaultDialog
 *
 * @since   May.  8, 2003
 * @version Dec. 29, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DefaultDialog extends AbstractDialog {
    private FCDialog fcDialog_;
    // Map<String, DefaultSlot>
    private Map slots_ = new HashMap();
    private IScene opening_;
    private IScene ending_;
    // Map<String, DefaultScene>
    private Map scenes_ = new HashMap();

    public DefaultDialog(FCDialog fcDialog, RelaxerFramework framework) {
        fcDialog_ = fcDialog;
        FCSlot[] fcSlots = fcDialog.getSlot();
        for (int i = 0;i < fcSlots.length;i++) {
            FCSlot fcSlot = fcSlots[i];
            slots_.put(fcSlot.getName(), new DefaultSlot(fcSlot));
        }
        FCScene[] fcScenes = fcDialog.getScene();
        for (int i = 0;i < fcScenes.length;i++) {
            FCScene fcScene = fcScenes[i];
            String sceneName = fcScene.getName();
            DefaultScene scene = new DefaultScene(fcScene, this, framework);
            scenes_.put(sceneName, scene);
        }
    }

    public FCDialog getFcDialog() {
        return (fcDialog_);
    }

    public IScene getOpening() {
        return (opening_);
    }
    
    public IScene getEnding() {
        return (ending_);
    }

    public IScene getScene(String name) {
        return ((IScene)scenes_.get(name));
    }

    public DefaultSlot getSlot(String name) {
        return ((DefaultSlot)slots_.get(name));
    }
}
