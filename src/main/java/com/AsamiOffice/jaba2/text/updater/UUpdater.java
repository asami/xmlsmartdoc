/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package com.AsamiOffice.jaba2.text.updater;

import java.io.IOException;
import java.net.MalformedURLException;
import com.AsamiOffice.jaba2.text.update.rRule.RuleSet;

/**
 * UUpdater
 *
 * @since   Nov.  9, 2000
 * @version Nov.  9, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public final class UUpdater {
    public static String replace(String text, String uri)
	throws MalformedURLException, IOException {
	Updater updater = new Updater();
	return (updater.replace(text, uri));
    }

    public static String replace(String text, RuleSet ruleSet) {
	Updater updater = new Updater();
	return (updater.replace(text, ruleSet));
    }
}
