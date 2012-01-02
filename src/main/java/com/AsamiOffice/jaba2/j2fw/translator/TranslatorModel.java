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

package com.AsamiOffice.jaba2.j2fw.translator;

import java.net.URL;
import java.util.Locale;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorModel;

import com.AsamiOffice.text.UString;

/**
 * TranslatorModel
 *
 * @since   Jul. 25, 1999
 * @version Oct. 15, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public abstract class TranslatorModel extends GeneratorModel {
    private TranslatorConfig config_;
    private URL source_;
    private URL target_;

    protected TranslatorModel(TranslatorConfig config) {
        super(config);
        config_ = config;
        source_ = config.getSource();
        target_ = config.getTarget();
    }

    public String getProject() {
        String project = config_.getProject();
        if (project != null) {
            return (project);
        }
        if (source_ != null) {
            String ref = source_.getRef();
            if (ref != null) {
                return (ref);
            } else {
                String file = source_.getFile();
                return (UString.getLastComponentBody(file));
            }
        }
        return ("none"); // XXX
    }

    public URL getSource() {
        return (source_);
    }

    public URL getTarget() {
        return (target_);
    }

    public String getInputEncoding() {
        return (getInputEncoding(getLocale()));
    }

    public String getOutputEncoding() {
        return (getOutputEncoding(getLocale()));
    }

    public String getInputEncoding(Locale locale) {
        String encoding = config_.getInputEncoding(locale);
        if (encoding != null) {
            return (encoding);
        }
        return (getEncoding());
    }

    public String getOutputEncoding(Locale locale) {
        String encoding = config_.getOutputEncoding(locale);
        if (encoding != null) {
            return (encoding);
        }
        return (getEncoding());
    }
}
