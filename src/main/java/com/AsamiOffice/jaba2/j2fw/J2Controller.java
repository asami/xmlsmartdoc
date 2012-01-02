/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (tasami@ibm.net)
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

package com.AsamiOffice.jaba2.j2fw;

import java.util.*;
import java.io.*;
import java.awt.event.ActionEvent;

/**
 * J2Controller
 *
 * @since   Nov. 21, 1998
 * @version Feb. 16, 2000
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class J2Controller {
    protected J2Config j2config_;
    protected J2Model j2model_;
    protected J2View j2view_;
    protected Map commands_ = new HashMap(); // Map<String, Command>

    protected J2Controller(J2Config config, J2Model model) {
	this(config, model, null);
    }

    protected J2Controller(
	J2Config config,
	J2Model model,
	J2View view
    ) {
	j2config_ = config;
	j2model_ = model;
	j2view_ = view;

	addCommand(new ExitCommand());
    }

    public void showVersionConsole() {
	J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
	String[] versionMessage = j2config_.getVersionMessage();
	for (int i = 0;i < versionMessage.length;i++) {
	    monitor.println(versionMessage[i]);
	}
    }

    public void showUsageConsole() {
	J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
	showVersionConsole();
	monitor.println();
	String[] usageMessage = j2config_.getUsageMessage();
	for (int i = 0;i < usageMessage.length;i++) {
	    monitor.println(usageMessage[i]);
	}
    }

    public void showHelpConsole() {
	J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
	showVersionConsole();
	monitor.println();
	String[] helpMessage = j2config_.getHelpMessage();
	for (int i = 0;i < helpMessage.length;i++) {
	    monitor.println(helpMessage[i]);
	}
    }

    public void showPropertiesConsole() {
	J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
	String propertyFile = j2config_.getPropertyFile();
	if (propertyFile != null) {
	    monitor.println("Property file\t: " + propertyFile);
	}
    }

    public boolean executeFrameworkCommand() {
	if (j2config_.showVersion()) {
	    showVersionConsole();
	    return (true);
	} else if (j2config_.showHelp()) {
	    showHelpConsole();
	    return (true);
	} else if (j2config_.showUsage()) {
	    showUsageConsole();
	    return (true);
	}
	return (false);
    }

    // XXX : command framework?
    public void executeCommand()
	throws IllegalArgumentException {

	String[] commands = j2config_.getArguments();
	for (int i = 0;i < commands.length;i++) {
	    executeCommand(commands[i]);
	}
    }

    // XXX : command framework?
    public void executeCommand(String name)
	throws IllegalArgumentException {

	J2Command command = (J2Command)commands_.get(name);
	if (command == null) {
	    throw (new IllegalArgumentException());
	}
	command.doAction();
    }

    public void prologueConsole() {
	J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
	String[] versionMessage = j2config_.getVersionMessage();
	for (int i = 0;i < versionMessage.length;i++) {
	    monitor.info(versionMessage[i]);
	}
	if (j2config_.isVerbose()) {
	    showPropertiesConsole();
	}
    }

    public void addCommand(J2Command command) {
	commands_.put(command.getID(), command);
    }

    public J2Command getExitCommand() {
	return (new ExitCommand());
    }

    public void exit() {
	System.exit(0);
    }

    class ExitCommand extends AbstractJ2Command {
	public ExitCommand() {
	    super("exit");
	    putValue(J2Command.ID, "exit");
	    putValue(J2Command.SHORT_DESCRIPTION, "exit");
	    putValue(J2Command.LONG_DESCRIPTION, "exit");
	    // XXX : Icon
	}

	public void doAction() {
	    exit();
	}
    }
}
