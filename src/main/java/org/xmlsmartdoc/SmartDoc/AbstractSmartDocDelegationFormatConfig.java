/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998,1999  ASAMI, Tomoharu (tasami@ibm.net)
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

import java.util.*;
import com.AsamiOffice.jaba2.util.*;

/**
 * SmartDocFormatConfig
 *
 * @since   May. 21, 1999
 * @version Jun. 25, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractSmartDocDelegationFormatConfig
    extends AbstractSmartDocFormatConfig {

    protected SmartDocFormatConfig delegationConfig_;
    protected SmartDocGenerator delegationGenerator_;

    protected void _init(
	SmartDocConfig config,
	String prefix,
	ParameterInfo info,
	SmartDocFormatConfig delegationConfig,
	SmartDocGenerator delegationGenerator
    ) {
	delegationConfig_ = delegationConfig;
	delegationGenerator_ = delegationGenerator;
	delegationGenerator_.init(config, delegationConfig);
	_init(config, prefix, info);
    }

    // SmartDocFormatConfig
    public String[] getImageCandidates() {
	return (delegationConfig_.getImageCandidates());
    }

    public SmartDocGenerator getDelegationGenerator() {
	return (delegationGenerator_);
    }
}
