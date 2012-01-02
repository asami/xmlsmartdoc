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

import org.relaxer.framework.rScenario.*;

/**
 * DefaultScenario
 *
 * @since   May.  8, 2003
 * @version May. 10, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class DefaultScenario extends AbstractScenario {
    private FSScenario fsScenario_;
    private FSService currentService_;

    public DefaultScenario() {
	fsScenario_ = new FSScenario();
    }

    public void addPropertyEvent(String name, String value) {
	FSProperty property = new FSProperty();
	property.setName(name);
	property.setContent(value);
	fsScenario_.addEvent(property);
    }

    public void addServiceEvent(String name) {
	FSService service = new FSService();
	service.setName(name);
	fsScenario_.addEvent(service);
	currentService_ = service;
    }

    public void addServiceIn(String name) {
	FSIn in = new FSIn();
	in.setProperty(name);
	currentService_.addIn(in);
    }

    public void addServiceOut(String name) {
	throw (new UnsupportedOperationException());
    }

    public void addSceneEvent(String name) {
	FSScene scene = new FSScene();
	scene.setName(name);
	fsScenario_.addEvent(scene);
    }

    public void addSystemEvent(String name) {
	FSSystem system = new FSSystem();
	system.setName(name);
	fsScenario_.addEvent(system);
    }

    public FSScenario getScenario() {
	return (fsScenario_);
    }
}
