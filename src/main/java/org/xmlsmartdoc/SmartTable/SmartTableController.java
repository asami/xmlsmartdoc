/*
 * SmartTable
 *  Copyright (C) 1999-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import javax.swing.table.TableModel;

import com.AsamiOffice.jaba2.j2fw.J2Context;
import com.AsamiOffice.jaba2.j2fw.TTYView;
import com.AsamiOffice.jaba2.j2fw.translator.TranslatorController;
import com.AsamiOffice.jaba2.util.D2ArrayTable;
import com.AsamiOffice.util.D2Array;

import org.w3c.dom.Document;

/**
 * SmartTableController
 *
 * @since   Jul. 24, 1999
 * @version oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartTableController extends TranslatorController {
    protected SmartTableConfig config_;
    protected SmartTableModel model_;
    protected TTYView view_;
    protected String[] formats_;

    public SmartTableController(
        SmartTableConfig config,
        SmartTableModel model,
        TTYView view
    ) {
        super(config, model, view);
        config_ = config;
        model_ = model;
        view_ = view;
        J2Context.getJ2Context().getJ2Monitor().setConsole(view.getTTY());
    }

    public TableModel generateTable() {
        return (new D2ArrayTable(generateDataAsD2Array()));
    }

    public D2Array generateHeadAsD2Array() {
        return (model_.getHead());
    }

    public D2Array generateFootAsD2Array() {
        return (null);
    }

    public D2Array generateDataAsD2Array() {
        return (model_.getData());
    }

    public Document generateHTMLTableAsDocument() {
        D2Array data = model_.getData();
        Metadata metadata = model_.getMetadataOut();
        return (metadata.d2Array2HTMLTable(data));
    }
}
