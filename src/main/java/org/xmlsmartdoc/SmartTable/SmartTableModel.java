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

import java.io.IOException;
import java.net.URL;

import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.translator.TranslatorModel;
import com.AsamiOffice.jaba2.xml.IConverter;
import com.AsamiOffice.util.D2Array;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.io.UURL;

/**
 * SmartTableModel
 *
 * @since   Jul. 24, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartTableModel extends TranslatorModel {
    protected J2Monitor monitor_;
    protected SmartTableConfig config_;
    protected Metadata metadata_;
    protected Metadata metadataIn_;
    protected Metadata metadataOut_;
    protected D2Array data_;

    public SmartTableModel(SmartTableConfig config) throws IOException {
        super(config);
        config_ = config;
    }

    public void setup() throws IOException {
        monitor_ = SmartTableContext.getContext().getMonitor();
        URL url = config_.getMetadataURL();
        if (url == null) {
            url = UURL.getURLFromFileOrURLName("sxtab.sxt");
            if (!UFile.isExist(url)) {
                url = null;
            }
        }
        if (url != null) {
            metadata_ = new Metadata(url);
        } else {
            metadata_ = new Metadata();
        }
        URL urlIn = config_.getMetadataInURL();
        if (urlIn != null) {
            metadataIn_ = new Metadata(urlIn);
        }
        URL urlOut = config_.getMetadataOutURL();
        if (urlOut != null) {
            metadataOut_ = new Metadata(urlOut);
        }
    }

    public IConverter getConverter(String id) {
        return (config_.getConverter(id));
    }

    public Metadata getMetadata() {
        return (metadata_);
    }

    public Metadata getMetadataIn() {
        if (metadataIn_ != null) {
            return (metadataIn_);
        }
        return (metadata_);
    }

    public Metadata getMetadataOut() {
        if (metadataOut_ != null) {
            return (metadataIn_);
        }
        return (metadata_);
    }

    public D2Array getHead() {
        return (metadata_.getHeadAsD2Array());
    }

    public D2Array getData() {
        return (data_);
    }

    public void setData(D2Array data) {
        data_ = data;
    }
}
