/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.jaba2.util.property;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.AsamiOffice.jaba2.awt.CardPanel;
import com.AsamiOffice.jaba2.awt.ColumnLayout;
import com.AsamiOffice.jaba2.awt.J2TextField;
import com.AsamiOffice.jaba2.awt.RowLayout;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.io.UURL;

/**
 * TextResource
 *
 * @since   Jul. 14, 1998
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class TextResource extends AbstractPropertyValue {
    protected URL url_ = null;
    protected File file_ = null;
    protected String text_ = "";

    public TextResource() {
    }

    public TextResource(String text) {
        setText(text);
    }

    public TextResource(URL url) throws IOException {
        setURL(url);
    }

    public TextResource(File file) throws IOException {
        setFile(file);
    }

    public void setText(String text) {
        url_ = null;
        file_ = null;
        text_ = text;
        setChanged();
        notifyObservers();
    }

    public void setURL(URL url) throws IOException {
        url_ = url;
        file_ = null;
        text_ = UString.makeStringFromURL(url);
        setChanged();
        notifyObservers();
    }

    public void setFile(File file) throws IOException {
        url_ = null;
        file_ = file;
        text_ = UString.makeStringFromFile(file);
        setChanged();
        notifyObservers();
    }

    public URL getURL() {
        if (url_ != null) {
            return (url_);
        }
        if (file_ != null) {
            try {
                return (UURL.getURLFromFile(file_));
            } catch (MalformedURLException e) {
            }
        }
        return (null);
    }

    // PropertyValue
    public String getString() {
        return (text_);
    }

    // AbstractPropertyValue
    public boolean hasWideViewer() {
        return (true);
    }

    // AbstractPropertyValue
    public boolean hasWideEditor() {
        return (true);
    }

    // AbstractPropertyValue
    public Component getViewer() {
        String type;
        if (url_ != null) {
            type = "URL : " + url_.toString();
        } else if (file_ != null) {
            type = "File : " + file_.getAbsolutePath();
        } else {
            type = "Text";
        }
        return (new JLabel(type));
    }

    // AbstractPropertyValue
    public Component getWideViewer() {
        Component label = getViewer();
        JTextArea area = new JTextArea(text_, 25, 80);
        JScrollPane scroll = new JScrollPane(area);
        area.setEditable(false);
        area.setText(text_);
        area.setFont(new Font("Monospaced", Font.PLAIN, 12)); // XXX
        JPanel panel = new JPanel(new RowLayout());
        panel.add(label);
        panel.add(area);
        return (panel);
    }

    // AbstractPropertyValue
    public Component getWideEditor() {
        TextResourceEditor editor = new TextResourceEditor();
        addObserver(editor);
        return (editor);
    }

    class TextResourceEditor
        extends JComponent
        implements PropertyValueEditor, Observer {

        JTextArea area_;
        JComboBox combo_;

        public TextResourceEditor() {
            setLayout(new RowLayout());
            area_ = new JTextArea(25, 80);
            area_.setText(text_);
            area_.setFont(new Font("Monospaced", Font.PLAIN, 12)); // XXX
            final CardPanel card = new CardPanel();
            JButton textCard = new JButton("Import");
            textCard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    _doImportFromFile();
                }
            });
            JTextField urlCard = new J2TextField("http:// ", 30);
            urlCard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    JTextField widget = (JTextField)evt.getSource();
                    _doSetURL(widget.getText());
                }
            });
            JTextField fileCard = new J2TextField("", 30);
            fileCard.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    JTextField widget = (JTextField)evt.getSource();
                    String name = widget.getText();
                    _doSetFile(name);
                }
            });
            card.add(textCard, "text");
            card.add(urlCard, "url");
            card.add(fileCard, "file");
            combo_ = new JComboBox(new String[] { "Text", "URL", "File" });
            if (url_ != null) {
                combo_.setSelectedItem("URL");
            } else if (file_ != null) {
                combo_.setSelectedItem("File");
            } else {
                combo_.setSelectedItem("Text");
            }
            combo_.addItemListener(new ItemListener() {
                public void itemStateChanged(ItemEvent evt) {
                    String selection = (String)evt.getItem();
                    if (selection.equals("Text")) {
                        card.raise("text");
                    } else if (selection.equals("URL")) {
                        card.raise("url");
                    } else if (selection.equals("File")) {
                        card.raise("file");
                    } else {
                        throw (
                            new InternalError("bad selection : " + selection));
                    }
                }
            });
            JPanel indicator =
                new JPanel(new ColumnLayout(ColumnLayout.HBASE_LEFT));
            indicator.add(combo_);
            indicator.add(card);
            add(indicator);
            add(area_);
        }

        // PropertyValueEditor
        public Object getValue() {
            TextResource tr = new TextResource();
            tr.setText(area_.getText()); // XXX : handle url and file
            return (tr);
        }

        // Observer
        public void update(Observable o, Object arg) {
            // XXX : do work
        }

        protected void _doImportFromFile() {
            JFileChooser chooser = new JFileChooser();
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                _doImportFromFile(file);
            }
        }

        protected void _doImportFromFile(String name) {
            _doImportFromFile(new File(name));
        }

        protected void _doImportFromFile(File file) {
            try {
                String text = UString.makeStringFromFile(file);
                setText(text);
            } catch (IOException e) {
                throw (new InternalError());
            }
        }

        protected void _doImportFromURL(String name) {
            try {
                URL url = new URL(name);
                String text = UString.makeStringFromURL(url);
                setText(text);
            } catch (MalformedURLException e) {
                throw (new InternalError());
            } catch (IOException e) {
                throw (new InternalError());
            }
        }

        protected void _doSetFile(String name) {
            try {
                setFile(new File(name));
            } catch (IOException e) {
                throw (new InternalError());
            }
        }

        protected void _doSetURL(String name) {
            try {
                setURL(new URL(name));
            } catch (MalformedURLException e) {
                throw (new InternalError());
            } catch (IOException e) {
                throw (new InternalError());
            }
        }
    }
}
