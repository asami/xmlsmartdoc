/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.jaba2.util;

import java.io.File;
import java.io.IOException;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.io.UIO;

/**
 * Utilites for Process Management
 *
 * @since   May. 19, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UProcess {
    protected static Runtime runtime__ = Runtime.getRuntime();

    public static String getCommandOutput(String command)
        throws IOException {

        Process proc = runtime__.exec(command);
        return (UIO.stream2String(proc.getInputStream()));
    }

    public static String getCommandOutput(String command, File dir)
        throws IOException {

        File launcher = File.createTempFile("jaba2", ".sh");
        launcher.deleteOnExit();
/*        URL url = UURL.getURLFromResourceName(
            "/jp/gr/java_conf/jaba2/util/lib/launcher-unix",
            UProcess.class
        );
        String content = UIO.URL2String(url);*/
        String content = UIO.resource2String(
            "/jp/gr/java_conf/jaba2/util/lib/launcher-unix",
            UProcess.class
        );
        UFile.createFile(launcher, content);
        return (getCommandOutput(
            "sh " + launcher + " " + dir + " " + command)
        );
    }

    public static Process getCommandProc(String command, File dir)
        throws IOException {

        return (runtime__.exec(command, null, dir)); // J2SE 1.3
    }

/*
    public static Process getCommandProc(String command, File dir)
        throws IOException {

        String oldDir = System.getProperty("user.dir");
        System.setProperty("user.dir", dir.toString());
        Process process = runtime__.exec(command);
        System.setProperty("user.dir", oldDir);
        return (process);
    }
*/

    public static Process getCommandProc0(String command, File dir)
        throws IOException {

        File launcher = File.createTempFile("jaba2", ".sh");
        launcher.deleteOnExit();
        String content = UIO.resource2String(
            "/jp/gr/java_conf/jaba2/util/lib/launcher-unix",
            UProcess.class
        );
        UFile.createFile(launcher, content);
        return (runtime__.exec(
            "sh " + launcher + " " + dir + " " + command)
        );
    }
}
