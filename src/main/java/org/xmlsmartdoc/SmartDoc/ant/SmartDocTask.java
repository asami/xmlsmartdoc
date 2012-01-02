/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.ant;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.DirectoryScanner;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.MatchingTask;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlsmartdoc.SmartDoc.SmartDoc;
import org.xmlsmartdoc.goldenport.adapters.WhatsNewMaker;

import com.AsamiOffice.io.UFile;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.xml.UDOM;

/**
 * SmartDocTask
 *
 * @since   Sep. 20, 2003
 * @version Apr. 15, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocTask extends MatchingTask {
    private static final String OLD_STAMP_FILE = "SmartDoc.stamp";
    private static final String STAMP_FILE = ".SmartDoc.stamp";
    private File srcdir_;
    private File destdir_;
    private File destimagedir_;
    private String policy_;
    private String propertyFileName_;
    private File propertyFile_;
    private boolean whatsnew_ = false;
    private Properties properties_;
    private int nCompiling_ = 0;

    public void init() {
        super.fileset.setIncludes("**/*.sdoc **/SmartDoc.properties");
    }

    public final void setSrcdir(File dir) {
        log("srcdir = " + dir, Project.MSG_VERBOSE);
        srcdir_ = dir;
        super.fileset.setDir(dir);
    }

    public final void setDestdir(File dir) {
        log("destdir = " + dir, Project.MSG_VERBOSE);
        destdir_ = dir;
    }
    
    public final void setDestimagedir(File dir) {
        log("destimagedir = " + dir, Project.MSG_VERBOSE);
        destimagedir_ = dir;
    }

    public final void setPolicy(String policy) {
        log("policy = " + policy, Project.MSG_VERBOSE);
        policy_ = policy;
    }

    public final void setPropertyFile(String propertyFile) {
        log("propertyFile = " + propertyFile, Project.MSG_VERBOSE);
        propertyFileName_ = propertyFile;
    }
    
    public final void setWhatsNew(boolean whatsnew) {
        whatsnew_ = whatsnew;
    }

    public void execute() throws BuildException {
        File basedir = super.project.getBaseDir(); 
        log("basedir = " + basedir, Project.MSG_VERBOSE); 
        if (propertyFileName_ != null) {
            propertyFile_ = new File(propertyFileName_);
            if (!propertyFile_.isAbsolute()) {
                propertyFile_ = new File(basedir, propertyFileName_);
            }
            try {
                properties_ = new Properties();
                properties_.load(new FileInputStream(propertyFile_));
            } catch (IOException e) {
                log(e.getMessage(), Project.MSG_ERR);
            }
        }
        try {
            DirectoryScanner scanner
                = super.fileset.getDirectoryScanner(super.project);
            scanner.scan();
            File baseDir = scanner.getBasedir();
            String[] files = scanner.getIncludedFiles();
            String[] specials = getSpecialFiles_(baseDir);
            for (int i = 0;i < files.length;i++) {
                log("file = " + files[i], Project.MSG_DEBUG);
            }
            Map projects = getProjects_(files);
            Object[] entries = projects.entrySet().toArray();
            for (int i = 0;i < entries.length;i++) {
                executeDirectory_((Map.Entry)entries[i], baseDir, specials);
            }
            markStamp_();
        } catch (IOException e) {
            throw (new BuildException(e));
        } catch (ParserConfigurationException e) {
            throw (new BuildException(e));
        } catch (SAXException e) {
            throw (new BuildException(e));
        } catch (Exception e) {
            e.printStackTrace();
        }
        report_();
    }

    private String[] getSpecialFiles_(File baseDir)
      throws IOException, ParserConfigurationException, SAXException {
        if (!whatsnew_) {
            return (new String[0]);
        }
//System.out.println("file** = " + files[0]);
        List list = new ArrayList();
        String baseDirPathName = baseDir.getPath();
        collectWhatsNewUser_(baseDir, baseDirPathName, list);
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    private void collectWhatsNewUser_(
        File file, 
        String baseDirPathName,
        List list
    ) throws IOException, ParserConfigurationException, SAXException {
        String pathName = getPathName_(file, baseDirPathName);
//System.out.println("pathName = " + pathName);
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (int i = 0;i < children.length;i++) {
                collectWhatsNewUser_(
                    children[i], 
                    baseDirPathName, 
                    list
                );
            }
        } else if (pathName == null) {
            return;
        } else if (file.getName().endsWith(".sdoc")) {
            System.out.println("XXX = " + file.getPath());;
            Document doc = UDOM.loadDocumentNs(file);
            NodeList whatsnews = doc.getElementsByTagNameNS(
                WhatsNewMaker.WHATSNEW_NS,
                WhatsNewMaker.ELEMENT_WHATSNEW
            );
            System.out.println(whatsnews.getLength());
            if (whatsnews.getLength() > 0) {
                list.add(pathName);
            }
        }
    }

    private String getPathName_(File file, String baseDirPathName) {
        String filePathName = file.getPath();
//System.out.println("filePathName = " + filePathName);
//System.out.println("baseDirPathName = " + baseDirPathName);
        if (filePathName.equals(baseDirPathName)) {
            return (null);
        }
        int length = baseDirPathName.length();
        return (filePathName.substring(length + 1));
    }

    private void executeDirectory_(
        Map.Entry entry,
        File baseDir,
        String[] specials
    ) throws IOException, BuildException {
        String dirName = (String)entry.getKey();
        List contents = (List)entry.getValue();
        Object[] fileNames = contents.toArray();
        String propertyFileName = getPropertyFileName_(fileNames);
        String sourceFileName
            = getSourceFileName_(fileNames, dirName, baseDir);
        String[] sdocFileNames = getSdocFileNames_(fileNames);
        log("<<<" + dirName + ">>>", Project.MSG_VERBOSE);
        log("Property file = " + propertyFileName, Project.MSG_VERBOSE); 
        log("Source file = " + sourceFileName, Project.MSG_VERBOSE);
        for (int i = 0;i < sdocFileNames.length;i++) {
            String f = sdocFileNames[i];
            log("files = " + f, Project.MSG_VERBOSE);
        }
        if (true) {
            executeSdocFiles_(
                sdocFileNames,
                dirName,
                baseDir,
                propertyFileName,
                specials
            );
        } else if (true) {
            throw (new UnsupportedOperationException());
        } else if (true) {
            throw (new UnsupportedOperationException());
        } else {
            throw (new BuildException());
        }
    }

    private void executeSdocFiles_(
        String[] fileNames,
        String dirName,
        File baseDir,
        String propertyFileName,
        String[] specials
    ) {
        for (int i = 0;i < fileNames.length;i++) {
            String fileName = fileNames[i];
            if (needBuild_(
                    fileName, 
                    dirName, 
                    baseDir, 
                    propertyFileName,
                    specials)) {
                executeSdocFile_(fileName, dirName, baseDir, propertyFileName);
            }
        }
    }

    private void markStamp_() throws IOException {
        File oldStamp = new File(destdir_, OLD_STAMP_FILE);
        if (oldStamp.exists()) {
            oldStamp.delete();
        }
        File stamp = new File(destdir_, STAMP_FILE);
        if (stamp.exists()) {
            stamp.delete();
        }
        UFile.createFile(
            stamp,
            System.currentTimeMillis() + "\n" + 
            new Date().toString() + "\n"
        );
    }

    private boolean needBuild_(
        String fileName,
        String dirName,
        File baseDir,
        String propertyFileName,
        String[] specials
    ) {
        if (isSpecialFile_(fileName, dirName, specials)) {
            return (true);
        }
        File reportFile = new File(destdir_, STAMP_FILE);
        if (!reportFile.exists()) {
            reportFile = new File(destdir_, OLD_STAMP_FILE);
            if (!reportFile.exists()) {
                return (true);
            }
        }
        File from = new File(new File(baseDir, dirName), fileName);
        return (from.lastModified() > reportFile.lastModified());
    }

    private boolean isSpecialFile_(
        String fileName, 
        String dirName, 
        String[] specials
    ) {
        String pathName = dirName + "/" + fileName;
        System.out.println("pathName = " + pathName);
        for (int i = 0;i < specials.length;i++) {
            System.out.println("specials = " + specials[i]);
            String specialDir = UString.getContainerPathname(
                specials[i],
                File.separator
            );
            if (specialDir == null) {
                specialDir = "";
            }
            System.out.println("container = " + specialDir);
            String specialFile = UString.getLastComponent(
                specials[i],
                File.separator
            );
            System.out.println("file = " + specialFile);
            if (dirName.equals(specialDir) && fileName.equals(specialFile)) {
                return (true);
            }
        }
        return (false);
    }

    private boolean needBuild0_(
        String fileName,
        String dirName,
        File baseDir,
        String propertyFileName
    ) {
        File from = new File(new File(baseDir, dirName), fileName);
        File toDir = new File(destdir_, dirName);
        File reportFile = new File(toDir, "SmartDoc.README");
        if (!reportFile.exists()) {
            return (true);
        }
        return (from.lastModified() > reportFile.lastModified());
    }

    private void executeSdocFile_(
        String fileName,
        String dirName,
        File baseDir,
        String propertyFileName
    ) {        
        List list = new ArrayList();
        File from = new File(new File(baseDir, dirName), fileName);
        File toDir = new File(destdir_, dirName);
        log("Execute [" + from + " -> " + toDir + "]", Project.MSG_VERBOSE); 
        list.add("-dir:" + toDir.toString());
        if (destimagedir_ != null) {
            list.add("-dir.image:" + new File(destimagedir_, dirName));
        }
        setupProperties_(list, fileName, dirName, baseDir, propertyFileName);
        list.add(from.toString());
//        list.add("-sdoc.report");
        String[] args = new String[list.size()];
        args = (String[])list.toArray(args);
        for (int j = 0;j < args.length;j++) {
            String a = args[j];
            log("parameter = " + a, Project.MSG_VERBOSE);
        }
        executeSmartDoc_(args);
        countUp_();
    }

    private void setupProperties_(
        List list,
        String fileName,
        String dirName,
        File baseDir,
        String propertyFileName
    ) {
        int depth = calcDepth_(dirName);
        if (propertyFile_ != null) {
            list.add("-properties:" + propertyFile_.toString());
            String cssFile = (String)properties_.get("html4.css.url");
            if (cssFile != null && !isUrl_(cssFile)) {
                list.add("-html4.css.url:" +
                         makeFileName_(depth, cssFile));
            }
        } else if (propertyFileName != null) {
            File propertyFile
                = new File(new File(baseDir, dirName), propertyFileName);
            list.add("-properties:" + propertyFile.toString());
        }
    }

    private boolean isUrl_(String name) {
        try {
            new URL(name);
            return (true);
        } catch (MalformedURLException e) {
            return (false);
        }
    }

    private int calcDepth_(String dirName) {
        if (dirName == null || "".equals(dirName)) {
            return (0);
        }
        int depth = 1;
        for (int index = dirName.indexOf(File.separator);
             index != -1;
             index = dirName.indexOf(File.separator, index + 1)) {
            depth++;
        }
        return (depth);
    }

    private String makeFileName_(int depth, String file) {
        if (depth < 0) {
            throw (new InternalError());
        }
        StringBuffer buffer = new StringBuffer();
        while (depth-- > 0) {
            buffer.append("../");
        }
        buffer.append(file);
        return (new String(buffer));
    }

    private void countUp_() {
        nCompiling_++;
    }

    private String getPropertyFileName_(Object[] fileNames) {
        for (int i = 0;i < fileNames.length;i++) {
            String fileName = (String)fileNames[i];
            if ("SmartDoc.properties".equals(fileName)) {
                return (fileName);
            }
        }
        return (null);
    }

    private String getSourceFileName_(
        Object[] fileNames,
        String dirName,
        File baseDir
    ) throws IOException {
        String propertyFileName = getPropertyFileName_(fileNames);
        if (propertyFileName == null) {
            return (null);
        }
        File propertyFile
            = new File(new File(baseDir, dirName), propertyFileName);
        InputStream in = null;
        BufferedInputStream bin = null;
        try {
            in = new FileInputStream(propertyFile);
            bin = new BufferedInputStream(in);
            Properties props = new Properties();
            props.load(bin);
            String source = (String)props.get("source");
            if (source == null || "".equals(source)) {
                return (null);
            } else {
                return (source);
            }
        } finally {
            if (bin != null) {
                try {
                    bin.close();
                } catch (IOException e) {
                }
            } else if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private String[] getSdocFileNames_(Object[] fileNames) {
        List list = new ArrayList();
        for (int i = 0;i < fileNames.length;i++) {
            String fileName = (String)fileNames[i];
            if (fileName.endsWith(".sdoc")) {
                list.add(fileName);
            }
        }
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    private void executeSmartDoc_(String[] args) throws BuildException {
        try {
            SmartDoc engine = new SmartDoc(args);
            engine.start();
        } catch (Exception e) {
            throw (new BuildException(e));
        }
    }

    private void report_() {
        if (nCompiling_ == 0) {
            return;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("Compiling ");
        switch (nCompiling_) {
        case 0:
            sb.append("no files");
            break;
        case 1:
            sb.append("one file");
            break;
        default:
            sb.append(nCompiling_);
            sb.append(" files");
        }
        sb.append(" to ");
        sb.append(destdir_);
        sb.append(" .");
        log(new String(sb));
    }

    public Map getProjects_(String[] files) {
        Map map = new HashMap();
        for (int i = 0;i < files.length;i++) {
            String file = files[i];
            String container = UString.getContainerPathname(
                file,
                File.separator
            );
            if (container == null) {
                container = "";
            }
            String component = UString.getLastComponent(
                file,
                File.separator
            );
            List contents = (List)map.get(container);
            if (contents == null) {
                contents = new ArrayList();
                map.put(container, contents);
            }
            contents.add(component);
        }
        return (map);
    }
}
