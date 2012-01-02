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
package org.relaxer.framework.parcel;

import java.net.MalformedURLException;
import java.net.URL;

import com.AsamiOffice.io.UURL;

/**
 * FileParcel
 *
 * @since   Dec. 16, 2003
 * @version Dec. 16, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class UrlParcel extends AbstractParcel {
    public UrlParcel(String urlName) throws MalformedURLException {
        URL url = UURL.getURLFromFileOrURLName(urlName);
        setup_(url);
    }

    public UrlParcel(String[] urlNames) throws MalformedURLException {
        URL[] urls = new URL[urlNames.length];
        for (int i = 0; i < urlNames.length; i++) {
            urls[i] = UURL.getURLFromFileOrURLName(urlNames[i]);
        }
        setup_(urls);
    }

    public UrlParcel(URL url) {
        setup_(url);
    }

    public UrlParcel(URL[] urls) {
        setup_(urls);
    }

    private void setup_(URL url) {
        setup_(new URL[] { url });
    }

    private void setup_(URL[] urls) {
        LightWeightParcelNode root = new LightWeightParcelNode();
        for (int i = 0; i < urls.length; i++) {
            URL url = urls[i];
            UrlParcelNode child = new UrlParcelNode(url);
            root.addChild(child);
        }
        _init(root);
    }
}
