/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc;

import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.generator.AbstractGenerator;

/**
 * AbstractSmartDocGenerator
 *
 * @since   Nov.  7, 1998
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public abstract class AbstractSmartDocGenerator
    extends AbstractGenerator implements SmartDocGenerator {

    protected J2Monitor monitor_;
    protected SmartDocConfig config_;
    protected SmartDocModel model_;
    protected SmartDocFormatConfig formatConfig_;

    // SmartDocGenerator
    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        if (config == null) {
            throw (new InternalError());
        }
        if (fconfig == null) {
            throw (new InternalError());
        }
        SmartDocContext context = SmartDocContext.getContext();
        monitor_ = context.getMonitor();
        config_ = config;
        formatConfig_ = fconfig;
    }

    public String getID() {
        return (formatConfig_.getID());
    }

    public String getName() {
        return (formatConfig_.getName());
    }

    // helper methods
    protected void _info(String message) {
        USmartDoc.info(message);
    }

    protected void _warning(String message) throws SmartDocWarningException {
        USmartDoc.warning(message);
    }

    protected void _error(String message) throws SmartDocErrorException {
        USmartDoc.error(message);
    }
}
