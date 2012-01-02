/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2002  ASAMI, Tomoharu (asami@relaxer.org)
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

/**
 * IRVerifyReportConstants
 *
 * @since   Mar. 12, 2002
 * @version Mar. 19, 2002
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public interface IRVerifyReportConstants {
    public static final String VERIFY_REPORT_NS
        = "http://www.relaxer.org/xmlns/verifyReport";

    public static final String LACK_OF_ELEMENT = "LACK_OF_ELEMENT";
    public static final String LACK_OF_CONTENT = "LACK_OF_CONTENT";
    public static final String LACK_OF_CHOICE = "LACK_OF_CHOICE";
    public static final String LACK_OF_ATTR = "LACK_OF_ATTR";
    public static final String LACK_OF_DATA = "LACK_OF_DATA";
    public static final String ILLEGAL_ELEMENT = "ILLEGAL_ELEMENT";
    public static final String INVALID_VALUE = "INVALID_VALUE";
}
