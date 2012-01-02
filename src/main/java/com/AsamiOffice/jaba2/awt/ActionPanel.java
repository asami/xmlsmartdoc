package com.AsamiOffice.jaba2.awt;

import java.awt.AWTEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.JComponent;

/**
 * The <code>ActionPanel</code> is a JComponent to handle the
 * <code>ActionEvent</code>.
 * <br>
 * The <code>ActionPanel</code> provides sufficient fanctionality to support
 * the <code>ActionEvent</code>, namely, registration of
 * <code>ActionListener</code>s, broadcast of events and a action command.
 * <br>
 * This widget is supposed to be inherited by widgets who want to support
 * the <code>ActionEvent</code>.
 *
 * @since   Apr.  8, 1998
 * @version Oct. 20, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class ActionPanel extends JComponent {
    /**
     * The String represents the action command.
     */
    protected String command_ = "";

    /**
     * Creates a <code>ActionPanel</code>.
     */
    public ActionPanel() {
    }

    /**
     * Sets the action command.
     *
     * @param command  the String to represent the action command
     */
    public void setActionCommand(String command) {
	command_ = command;
    }

    /**
     * Gets the action command.
     *
     * @return  the Stirng to represent the action command
     */
    public String getActionCommand() {
	return (command_);
    }

    /**
     * Adds the <code>ActionListener</code>.
     *
     * @param  the <code>ActionListener</code> to register
     */
    public void addActionListener(ActionListener l) {
	listenerList.add(ActionListener.class, l);
    }

    /**
     * Removes the <code>ActionListener</code>.
     *
     * @param  the <code>ActionListener</code> to remove
     */
    public void removeActionListener(ActionListener l) {
	listenerList.remove(ActionListener.class, l);
    }

    /**
     * Processes events on this panel.
     *
     * @see java.awt.Container
     */
    protected void processEvent(AWTEvent evt) {
	if (evt instanceof ActionEvent) {
	    processActionEvent((ActionEvent)evt);
	} else {
	    super.processEvent(evt);
	}
    }

    /**
     * Processes the <code>ActionEvent</code> occurring on this panel by
     * dispatching them on any registered <code>ActionListener</code> objects.
     */
    protected void processActionEvent(ActionEvent evt) {
	Object[] listeners = listenerList.getListenerList();
	for (int i = listeners.length - 2;i >= 0;i -= 2) {
	    if (listeners[i] == ActionListener.class) {
		((ActionListener)listeners[i + 1]).actionPerformed(evt);
	    }
	}
    }

    /**
     * Broadcasts <code>ActionEvent</code>s.
     * <br>
     * This method generates <code>ActionEvent</code>s automatically using
     * information in the object.
     * <br>
     * It is protected.  If a widget inheriting the <code>ActionPanel</code>
     * want a public broadcast method, make a no underscore name method.
     * (i.e. <code>fireActionPerformed</code>)
     */
    protected void _fireActionPerformed() {
	_fireActionPerformed(
	    new ActionEvent(
		this,
		ActionEvent.ACTION_PERFORMED,
		command_
	    )
	);
    }

    /**
     * Broadcasts <code>ActionEvent</code>s.
     * <br>
     * It is protected.  If a widget inheriting the <code>ActionPanel</code>
     * want a public broadcast method, make a no underscore name method.
     * (i.e. <code>fireActionPerformed</code>)
     *
     * @param evt  the <code>ActionEvent</code> to broadcast
     */
    protected void _fireActionPerformed(ActionEvent evt) {
	processActionEvent(evt);
    }

    // JDK1.2beta2, JDK1.2beta3 adapter
    protected void _putValue(Action action, String key, Object value) {
	Class clazz = action.getClass();
	try {
	    // JDK1.2 beta3
	    Class[] types = new Class[2];
	    types[0] = String.class;
	    types[1] = Object.class;
	    Object[] args = new Object[2];
	    args[0] = key;
	    args[1] = value;
	    java.lang.reflect.Method method = clazz.getMethod("putValue", types);
	    method.invoke(action, args);
	    return;
	} catch (Exception e) {
	}
	try {
	    // JDK1.2 beta2
	    Class[] types = new Class[2];
	    types[0] = String.class;
	    types[1] = String.class;
	    Object[] args = new Object[2];
	    args[0] = key;
	    args[1] = value.toString();
	    java.lang.reflect.Method method = clazz.getMethod("setText", types);
	    method.invoke(action, args);
	    return;
	} catch (Exception e) {
	    throw (new InternalError("bad version"));
	}
    }
}
