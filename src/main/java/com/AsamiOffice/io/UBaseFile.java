/*
 * Created on 2005/03/25
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.AsamiOffice.io;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author asami
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public final class UBaseFile {
    public static URL getURL(String base, String path) throws MalformedURLException {
        try {
            URL url = new URL(path);
            return (url);
        } catch (MalformedURLException e) {
        }
        File file = new File(path);
        if (file.isAbsolute()) {
            try {
                return (file.toURL());
            } catch (MalformedURLException e) {
            }
        }
        if (!base.endsWith("/")) {
            int index = base.lastIndexOf('/');
            if (index != -1) {
                base = base.substring(0, index + 1);
            }
        }
        URL baseUrl = null;
        try {
            baseUrl = new URL(base);
        } catch (MalformedURLException e) {
            baseUrl = new File(base).toURL();
        }
        return (new URL(baseUrl + path));
    }

    public static URL getURL(URL base, String path) throws MalformedURLException {
        return (getURL(base.toExternalForm(), path));
    }
}
