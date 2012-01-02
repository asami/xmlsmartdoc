package com.AsamiOffice.jaba2.awt;

import java.awt.Component;
import java.awt.CardLayout;
import javax.swing.JComponent;

/**
 * The <code>CardPanel</code> is a JComponent to use the
 * <code>CardLayout</code> easily.
 *
 * @since   Apr.  7, 1998
 * @version Nov. 20, 1998
 * @author  ASAMI, Tomoharu
 */
public class CardPanel extends ActionPanel {
    /**
     * The <code>CardLayout</code> to manipulate.
     */
    protected CardLayout layout_;

    /**
     * Creates a <code>CardPanel</code>.
     */
    public CardPanel() {
	layout_ = new CardLayout();
	setLayout(layout_);
    }

    /**
     * Adds the <code>Component</code> at the position specified by the index.
     * This position is also used as the name of the component by the
     * <code>CardLayout</code> layout manager to identify the visible
     * component.
     *
     * @param comp  the <code>Component</code> to register
     * @param index  the position to register
     * @return  the <code>Component</code> to register
     * @see java.awt.Container
     */
    public Component add(Component comp, int index) {
	add(comp, Integer.toString(index), index);
	return (comp);
    }

    /**
     * Raises the <code>Component</code> identified by the name.
     *
     * @param name  the <code>Component</code> name
     */
    public void raise(String name) {
	layout_.show(this, name);
    }

    /**
     * Raises the <code>Component</code> identified by the number.
     *
     * @param name  the <code>Component</code> name
     */
    public void raise(int no) {
	layout_.show(this, Integer.toString(no));
    }

    /**
     * Test driver.
     */
    public static void main(String args[]) throws Exception {
	java.awt.Frame f = new java.awt.Frame("CardPanel Test");
	CardPanel panel = new CardPanel();
	panel.add("First", new java.awt.Label("First"));
	panel.add("Second", new java.awt.Label("Second"));
	f.add("Center", panel);
	panel.raise("Second");
	f.pack();
	f.show();
    }
}
