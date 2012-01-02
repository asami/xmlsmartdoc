/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.logger;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * ULogger
 *
 * @since   Sep.  1, 2003
 * @version Sep.  1, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class ULogger {
    public static String getCurrentDateTimeString() {
        Calendar calendar = Calendar.getInstance();
        StringBuffer buffer = new StringBuffer();
        buffer.append(calendar.get(Calendar.YEAR));
        buffer.append("-");
        buffer.append(calendar.get(Calendar.MONTH) + 1);
        buffer.append("-");
        buffer.append(calendar.get(Calendar.DATE));
        buffer.append("T");
        buffer.append(calendar.get(Calendar.HOUR_OF_DAY));
        buffer.append(":");
        buffer.append(calendar.get(Calendar.MINUTE));
        buffer.append(":");
        buffer.append(calendar.get(Calendar.SECOND));
        TimeZone zone = calendar.getTimeZone();
        buffer.append(zone.getDisplayName(false, TimeZone.SHORT));
        return (new String(buffer));
    }
}
