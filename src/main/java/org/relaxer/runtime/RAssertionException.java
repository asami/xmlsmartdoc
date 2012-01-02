/*
 * RelaxerOrg class library
 *  Copyright (C) 2000,2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.relaxer.runtime;

import java.util.*;
import java.math.*;

/**
 * RAssertionException
 *
 * @since   Sep.  2, 2001
 * @version Dec. 27, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public class RAssertionException extends IllegalArgumentException {
    private RVerifyReport report_;

    public RAssertionException() {
	super();
    }

    public RAssertionException(String message) {
	super(message);
    }

    public RAssertionException(RVerifyReport report) {
	super(report.toString());
	report_ = report;
    }

/*
    public final void setVerifyReport(RVerifyReport report) {
	report_ = report;
    }
*/

    public final RVerifyReport getVerifyReport() {
	return (report_);
    }
}
