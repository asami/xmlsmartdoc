/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package com.AsamiOffice.io;

import java.io.File;
import java.io.FilenameFilter;

import com.AsamiOffice.text.UString;

/**
 * ExcludesFilenameFilter
 *
 * @since   2004/04/20
 * @version 2004/04/20
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ExcludesFilenameFilter implements FilenameFilter {
    private String[] excludes_;

    public ExcludesFilenameFilter(String excludes) {
        excludes_ = UString.getTokens(excludes);
    }

    public boolean accept(File dir, String name) {
        for (int i = 0;i < excludes_.length;i++) {
            if (isMatch_(excludes_[i], name)) {
                return (false);
            }
        }
        return (true);
    }

    private boolean isMatch_(String exclude, String name) {
        if (exclude.startsWith("*.")) {
            return (getSuffix_(exclude).equals(getSuffix_(name)));
        } else if (exclude.endsWith(".*")) {
            return (getPrefix_(exclude).equals(getPrefix_(name)));
        } else {
            return (exclude.equals(name));
        }
    }

    private String getPrefix_(String name) {
        int index = name.lastIndexOf(".");
        if (index == -1) {
            return (null);
        } else {
            return (name.substring(0, index));
        }
    }

    private String getSuffix_(String name) {
        int index = name.lastIndexOf(".");
        if (index == -1) {
            return (null);
        } else {
            return (name.substring(index + 1));
        }
    }
}
