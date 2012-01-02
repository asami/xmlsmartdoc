/*
 * SmartTable
 *  Copyright (C) 1999-2004  ASAMI, Tomoharu (asami@xmlSmartDoc.org)
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

package org.xmlsmartdoc.SmartTable;

import java.io.IOException;

import javax.swing.table.TableModel;

import org.w3c.dom.Document;

import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.TTYView;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * SmartTable
 *
 * @since   Jul. 24, 1999
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@xmlSmartDoc.net)
 */
public class SmartTable {
    public static void main(String[] args) throws Exception {
        SmartTable app = new SmartTable(args);
        app.showPrologue();
        app.setup();
        app.generate();
        System.exit(0);
    }

    protected SmartTableController controller_;

    // JavaBeans
    public SmartTable() throws IOException {
        this(new String[0]);
        setup();
    }

    // Toolkit
    public SmartTable(String param) throws IOException {
        this(UString.getTokens(param, " \n\r\t"));
        setup();
    }

    // Application
    public SmartTable(String[] args) throws IOException {
        SmartTableContext context = new SmartTableContext();
        SmartTableContext.setContext(context);
        J2Monitor monitor = context.getMonitor();
        SmartTableConfig config = new SmartTableConfig(args);
        monitor.setConfig(config);
        SmartTableModel model = new SmartTableModel(config);
        TTYView view = new TTYView(config, model);
        SmartTableController controller =
            new SmartTableController(config, model, view);
        context.setConfig(config);
        context.setModel(model);
        context.setController(controller);
        context.setView(view);
        controller_ = controller;
    }

    public void setup() throws IOException {
        SmartTableContext context = SmartTableContext.getContext();
        SmartTableModel model = context.getModel();
        model.setup();
        controller_.setup(); // XXX
        controller_.importSource();
    }

    public void showPrologue() {
        boolean executed = controller_.executeFrameworkCommand();
        if (executed) {
            System.exit(0);
        }
        controller_.prologueConsole();
    }

    public void generate() throws IOException {
        SmartTableContext context = SmartTableContext.getContext();
        J2Monitor monitor = context.getMonitor();
        monitor.verbose("Start generating files...");
        controller_.generate();
        monitor.verbose("Done.");
    }

    public TableModel getTable() {
        return (controller_.generateTable());
    }

    public D2Array getHeadAsD2Array() {
        return (controller_.generateHeadAsD2Array());
    }

    public D2Array getFootAsD2Array() {
        return (controller_.generateFootAsD2Array());
    }

    public D2Array getDataAsD2Array() {
        return (controller_.generateDataAsD2Array());
    }

    public Document getHTMLTableAsDocument() {
        return (controller_.generateHTMLTableAsDocument());
    }
}
