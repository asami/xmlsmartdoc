/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@asamiOffice.com)
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

package com.AsamiOffice.jaba2.util;

import java.util.*;
import java.io.*;
import com.AsamiOffice.text.UString;

/**
 * CommandAgent
 *
 * @since   May. 26, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class CommandAgent {
    public static int NONE = 0;
    public static int INIT = 1;
    public static int FINISH = 2;

    protected int state_ = INIT;
    protected Thread inputThread_ = new Thread() {
	public void run() {
	    for (;;) {
		try {
		    String line = fromCommand_.readLine(); // XXX
		    if (line == null) {
			_setState(FINISH);
		    } else {
			if (outputStream_ != null) {
			    outputStream_.println(line);// XXX : as is
			}
			_writelnLog(line);
			_handleInput(line);
		    }
		} catch (IOException e) {
		    // XXX
		}
		if (state_ == FINISH) {
		    break;
		}
	    }
	    inputThread_ = null;
	    errorThread_ = null;
	    if (outputStream_ != null) {
		outputStream_.close();
	    }
	}
    };
    protected Thread errorThread_ = new Thread() {
	public void run() {
	    for (;;) {
		try {
		    String line = fromCommandError_.readLine(); // XXX
		    _handleError(line);
		} catch (IOException e) {
		    // XXX
		}
		if (state_ == FINISH) {
		    break;
		}
	    }
	}
    };
    protected Process proc_;
    protected BufferedReader fromCommand_; // inputThread
    protected BufferedReader fromCommandError_;	// errorThread
    protected BufferedWriter toCommand_; // ?
    protected StringWriter log_; // client, inputThread
    protected List inputHandlers_ = new ArrayList();	// List<Handler>
    protected List errorHandlers_ = new ArrayList();	// List<Handler>
    protected List messages_ = new ArrayList();
    protected File outputFile_ = null;
    protected PrintStream outputStream_ = null;

    public CommandAgent(String command) throws IOException {
	_init(Runtime.getRuntime().exec(command));
    }

    public CommandAgent(String command, File dir) throws IOException {
	_init(UProcess.getCommandProc(command, dir));
    }

    public CommandAgent(
	String template,
	String input,
	File dir
    ) throws IOException {
	String command = UString.replace(template, "$input", input);
	_init(UProcess.getCommandProc(command, dir));
    }

    public CommandAgent(
	String template,
	String input,
	String output,
	File dir
    ) throws IOException {
	String command = UString.replace(template, "$input", input);
	int index = command.indexOf(">$output");
	if (index == -1) {
	    command = UString.replace(command, "$output", output);
	} else {
	    command = UString.truncate(command, ">$output");
	}
	_init(command, dir, output);
    }

    private void _init(String command, File dir, String output)
	throws IOException {

	outputFile_ = new File(dir, output);
	outputStream_
	    = new PrintStream(new FileOutputStream(outputFile_));
	_init(UProcess.getCommandProc(command, dir));
    }

    private void _init(Process proc) throws IOException {
	proc_ = proc;
	fromCommand_ = new BufferedReader(
	    new InputStreamReader(
		proc_.getInputStream()
	    )
	);
	fromCommandError_ = new BufferedReader(
	    new InputStreamReader(
		proc_.getErrorStream()
	    )
	);
	toCommand_ = new BufferedWriter(
	    new OutputStreamWriter(
		proc_.getOutputStream()
	    )
	);
	log_ = new StringWriter();
    }

    public void start() {
	inputThread_.start();
	errorThread_.start();
    }	

    public boolean isFinished() {
	return (state_ == FINISH);
    }

    public synchronized void waitFinish() {
	while (state_ != FINISH) {
	    try {
		wait();
	    } catch (InterruptedException e) {
	    }
	}
    }

    public String getLog() {
	waitFinish();
	return (getCurrentLog());
    }

    public String getCurrentLog() {
	String log;
	synchronized (log_) {
	    log = log_.toString();
	}
	return (log);
    }

    public String[] getMessages() {
	waitFinish();
	return (getCurrentMessages());
    }

    public String[] getCurrentMessages() {
	String[] messages = new String[messages_.size()];
	messages = (String[])messages_.toArray(messages);
	return (messages);
    }

    public void addInputHandler(Handler handler) {
	inputHandlers_.add(handler);
    }

    public void addErrorHandler(Handler handler) {
	errorHandlers_.add(handler);
    }

    protected synchronized void _setState(int state) {
	state_ = state;
	notifyAll();
    }

    protected void _writeLog(String string) throws IOException {
	synchronized (log_) {
	    log_.write(string);
	}
    }

    protected void _writelnLog(String string) throws IOException {
	synchronized (log_) {
	    log_.write(string);
	    log_.write("\n");	// normalized new line
	}
    }

    protected void _writeMessage(String message) {
	synchronized (messages_) {
	    messages_.add(message);
	}
    }

    protected void _sendResponse(String response) throws IOException {
	toCommand_.write(response);
	toCommand_.flush();
    }

    protected void _handleInput(String input) {
	try {
	    Handler[] handlers = new Handler[inputHandlers_.size()];
	    handlers = (Handler[])inputHandlers_.toArray(handlers);
	    for (int i = 0;i < handlers.length;i++) {
		HandlerResult result = handlers[i].handle(input);
		if (result != null) {
		    if (result.response != null) {
			_sendResponse(result.response);
		    }
		    if (result.message != null) {
			_writeMessage(result.message);
		    }
		    if (result.state != NONE) {
			_setState(result.state);
		    }
		    if (state_ == FINISH) {
			return;
		    }
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace(); // XXX
	}
    }

    protected void _handleError(String error) {
	Handler[] handlers = new Handler[errorHandlers_.size()];
	handlers = (Handler[])errorHandlers_.toArray(handlers);
	for (int i = 0;i < handlers.length;i++) {
	    handlers[i].handle(error); // XXX
	}
    }

    public static interface Handler {
	HandlerResult handle(String input);
    }

    public static class HandlerResult {
	public int state = NONE;
	public String response = null;
	public String message = null;
    }

    public static void main(String[] args) throws Exception {
	String command = args[0];
	File dir = new File(args[1]);
	final String pattern = args[2];
	CommandAgent agent = new CommandAgent(command, dir);
	agent.addInputHandler(new Handler() {
	    public HandlerResult handle(String input) {
		HandlerResult result = new HandlerResult();
		if (input.indexOf(pattern) != -1) {
		    result.message = input;
		}
		return (result);
	    }
	});
	agent.start();
	System.out.println(agent.getLog());
	String[] messages = agent.getMessages();
	System.out.println("messages...");
	for (int i = 0;i < messages.length;i++) {
	    System.out.println(messages[i]);
	}
    }
}
