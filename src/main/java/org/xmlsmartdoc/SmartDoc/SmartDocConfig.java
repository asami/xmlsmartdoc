/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2006  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.AsamiOffice.jaba2.j2fw.generator.GeneratorConfig;
import com.AsamiOffice.jaba2.j2fw.generator.IGenerator;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorConfig;
import com.AsamiOffice.jaba2.util.AppParameterInfo;
import com.AsamiOffice.jaba2.util.LocaleMap;
import com.AsamiOffice.jaba2.util.ParameterInfo;
import com.AsamiOffice.jaba2.xml.IProcessor;

import com.AsamiOffice.xml.sax.EmacsErrorHandler;

/**
 * SmartDocConfig
 *
 * @since   Sep. 23, 1998
 *  version Jul.  4, 2007
 * @version Feb. 11, 2012
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocConfig extends GeneratorConfig {
    // LocaleMap<Locale, MessageMap>
    protected LocaleMap messagesByLocale_ = new LocaleMap();
    protected LocaleMap resources_ = new LocaleMap();
    protected URL source_;
    protected String project_;
    protected boolean sdocReport_;
    protected File dir_;
    protected File targetDir_;
    protected File targetDirImage_;
    protected String deploy_;
    protected boolean toc_;
    protected boolean index_;
//    protected SmartDocGenerator generator_;
    protected String[] formats_;
    protected BibliographyDatabase bibDB_;
//    protected PackagerFactory packagerFactory_;
    // Map<String, SmartDocFormatConfig>
    protected Map configs_ = new HashMap();
    protected Locale[] locales_;
    protected Locale masterLocale_;
    protected String key_;
    protected URL header_;
    protected URL footer_;
    protected ClassLoader classloader_;
    protected boolean bigDocument_;
    protected boolean goldenport_;
    protected String localeDelimiter_ = "_";
    protected LocaleMap labelPrefixFigure_;
    protected LocaleMap labelPrefixTable_;
    protected LocaleMap labelPrefixConsole_;
    protected LocaleMap labelPrefixProgram_;
    protected LocaleMap labelPrefixPart_;
    protected LocaleMap labelPrefixChapter_;
    protected LocaleMap labelPrefixSection_;
    protected LocaleMap labelPrefixSubsection_;
    protected LocaleMap labelPrefixSubsubsection_;
    protected LocaleMap labelPrefixEquation_;
    protected LocaleMap labelSuffixFigure_;
    protected LocaleMap labelSuffixTable_;
    protected LocaleMap labelSuffixConsole_;
    protected LocaleMap labelSuffixProgram_;
    protected LocaleMap labelSuffixPart_;
    protected LocaleMap labelSuffixChapter_;
    protected LocaleMap labelSuffixSection_;
    protected LocaleMap labelSuffixSubsection_;
    protected LocaleMap labelSuffixSubsubsection_;
    protected LocaleMap labelSuffixEquation_;
    protected boolean isIdGlobal_;

    public SmartDocConfig(String[] args)
        throws IOException, MalformedURLException {

        ParameterInfo info = new AppParameterInfo(
            "org.xmlsmartdoc.SmartDoc",
            args,
            "org.xmlsmartdoc.SmartDoc.SmartDocResource",
            new File("SmartDoc.properties")
        );
        info.addPackage("org.xmlsmartdoc.SmartDoc.adapter");
        _setup(info);
        sdocReport_ = info.getParameterAsBoolean("sdoc.report");
        URL baseUrl = getClass().getResource(
            info.getParameterAsString("messageBase")
        );
        source_ = info.getArgumentAsURLFromFileOrURL(0);
        if (source_ == null) {
            source_ = info.getParameterAsURLFromFileOrURL("source");
        }
/*
        if (source_.lastIndexOf(".sdoc") == -1) {
            source_ = source_ + ".sdoc";
        }
*/
        if (source_ != null) {
            project_ = getProject_();
            dir_ = _getProjectDirectory(source_.getFile());
        }
        File dir = info.getParameterAsFile("project.dir");
        if (dir != null) {
            dir_ = dir;
        }
        targetDir_ = info.getParameterAsFile("dir");
        targetDirImage_ = info.getParameterAsFile("dir.image");
        deploy_ = info.getParameterAsString("split");
        if (deploy_ == null) {
            deploy_ = info.getParameterAsString("deploy");
        }
        toc_ = info.getParameterAsBoolean("toc");
        index_ = info.getParameterAsBoolean("index");
//        generator_ = null;        // XXX
        formats_ = info.getParameterAsStringList("format");
        if (formats_ == null) {
            USmartDoc.error("formats not configured");
        }
/*
        URL bibFile = info.getParameterAsURLFromFileOrURL("bibdb");
        URL[] bibFiles;
        if (bibFile != null) {
            bibFiles = new URL[1]; // XXX : more dbs
            bibFiles[0] = bibFile;
        } else {
            bibFiles = new URL[0];
        }
*/
        URL[] bibFiles = info.getParameterAsURLListFromFileOrURL("bibdb");
        if (bibFiles == null) {
            bibFiles = new URL[0];
        }
        bibDB_ = new BibliographyDatabase(bibFiles);
        packagerFactory_.append(getClass().getResource(
            "/org/xmlsmartdoc/SmartDoc/Packager.xml"
        ));
        IGeneratorConfig[] configs = getConfigs();
        for (int i = 0;i < configs.length;i++) {
            SmartDocFormatConfig formatConfig
                = (SmartDocFormatConfig)configs[i];
            formatConfig.setup(this, args);
            configs_.put(formatConfig.getID(), formatConfig);
        }
        locales_ = info.getParameterAsLocaleList("locale");
        masterLocale_ = info.getParameterAsLocale("masterLocale");
        key_ = info.getParameterAsString("key");
        if (isDebug()) {
            USmartDoc.setDebug(true);
        }
        header_ = info.getParameterAsURLFromFileOrURL("header");
        footer_ = info.getParameterAsURLFromFileOrURL("footer");
        classloader_ = info.getParameterAsURLClassLoader("classpath");
        bigDocument_ = info.getParameterAsBoolean("bigDocument");
        goldenport_ = info.getParameterAsBoolean("goldenport");
        localeDelimiter_ = info.getParameterAsString("localeDelimiter");
        labelPrefixFigure_
            = info.getParameterAsLocaleMap("label.prefix.figure");
        labelPrefixTable_
            = info.getParameterAsLocaleMap("label.prefix.table");
        labelPrefixConsole_
            = info.getParameterAsLocaleMap("label.prefix.console");
        labelPrefixProgram_
            = info.getParameterAsLocaleMap("label.prefix.program");
        labelPrefixPart_
            = info.getParameterAsLocaleMap("label.prefix.part");
        labelPrefixChapter_
            = info.getParameterAsLocaleMap("label.prefix.chapter");
        labelPrefixSection_
            = info.getParameterAsLocaleMap("label.prefix.section");
        labelPrefixSubsection_
            = info.getParameterAsLocaleMap("label.prefix.subsection");
        labelPrefixSubsubsection_
            = info.getParameterAsLocaleMap("label.prefix.subsubsection");
        labelPrefixEquation_
            = info.getParameterAsLocaleMap("label.prefix.equation");
        labelSuffixFigure_
            = info.getParameterAsLocaleMap("label.suffix.figure");
        labelSuffixTable_
            = info.getParameterAsLocaleMap("label.suffix.table");
        labelSuffixConsole_
            = info.getParameterAsLocaleMap("label.suffix.console");
        labelSuffixProgram_
            = info.getParameterAsLocaleMap("label.suffix.program");
        labelSuffixPart_
            = info.getParameterAsLocaleMap("label.suffix.part");
        labelSuffixChapter_
            = info.getParameterAsLocaleMap("label.suffix.chapter");
        labelSuffixSection_
            = info.getParameterAsLocaleMap("label.suffix.section");
        labelSuffixSubsection_
            = info.getParameterAsLocaleMap("label.suffix.subsection");
        labelSuffixSubsubsection_
            = info.getParameterAsLocaleMap("label.suffix.subsubsection");
        labelSuffixEquation_
            = info.getParameterAsLocaleMap("label.suffix.equation");
        isIdGlobal_
            = info.getParameterAsBoolean("id.global");
    }

    // J2Config
    public String getName() {
        return ("SmartDoc");
    }

    // J2Config
    public String getVersion() {
        return ("2.0b2");
    }

    // J2Config
    public String getBuild() {
        return ("20120212");
    }

    // J2Config
    public String[] getVersionMessage() {
        String[] message = {
            "Copyright(c) 1998-2012 ASAMI,Tomoharu. All rights reserved.",
            "SmartDoc Version " + getVersion() +
            " (" + getBuild() + ")",
        };
        return (message);
    }

    // J2Config
    public String[] getUsageMessage() {
        String[] message = {
            "Usage: sdoc [-options] [args...]",
            "  for more information, use -help option"
        };
        return (message);
    }

    // J2Config
    public String[] getHelpMessage() {
        String[] message = {
            "Usage: sdoc [-options] [args...]",
            "",
            "where options include:",
            "[common]",
            "  -version",
            "\tshow version",
            "  -help",
            "  -?",
            "\tshow help. (this message)",
            "  -verbose[:true|false]",
            "\tenbale verbose output",
            "  -toc[:true|false]",
            "\tmake table of contents",
            "  -index[:true|false]",
            "\tmake index",
            "  -locale:locale_list",
            "\tavailable locales",
            "  -masterLocale:locale",
            "\tmaster locale",
            "  -format:format_list",
            "\tformats to generate",
            "  -key:key_regex",
            "\tselect context by the key regular expression",
            "\t\t[pure]",
            "\t\t[html3]",
            "\t\t[html4]",
            "\t\t[latex2e]",
            "\t\t[javahelp]",
//          "[dvi]"
//        "[postscript]"
//        "[pdf]"
//        "[plain]"
//        "[seetext]"
            "  -packager:package_method",
            "\tpackage method",
            "\t\t[file]",
            "\t\t[dir]",
            "\t\t[jar]",
            "\t\t[dirjar]"
        };
        return (message);
    }

    // J2Config
    public IProcessor getXMLProcessor() {
        IProcessor processor = super.getXMLProcessor();
        processor.setErrorHandler(new EmacsErrorHandler());
        return (processor);
    }

    // GeneratorConfig
    public IGenerator[] getGenerators() {
        int size = formats_.length;
        IGenerator[] generators = new IGenerator[size];
        for (int i = 0;i < size;i++) {
            SmartDocFormatConfig fconfig
                = (SmartDocFormatConfig)configs_.get(formats_[i]);
            if (fconfig == null) {
                USmartDoc.error("invalid format : " + formats_[i]);
            }
            generators[i] = fconfig.getGenerator();
        }
        return (generators);
    }

    public boolean isSdocReport() {
        return (sdocReport_);
    }

    public Locale[] getLocales() {
        return (locales_);
    }

    public Locale getMasterLocale() {
        return (masterLocale_);
    }

    public String getKey() {
        return (key_);
    }

    public URL getSource() {
        return (source_);
    }

    public String getProject() {
        return (project_);
    }

    public File getProjectDirectory() {
        return (dir_);
    }

    public File getTargetDirectory() {
        return (targetDir_);
    }
    
    public File getTargetImageDirectory() {
        return (targetDirImage_);
    }

    public String getDeploy() {
        return (deploy_);
    }

    public boolean makeToc() {
        return (toc_);
    }

    public boolean makeIndex() {
        return (index_);
    }

    public String[] getFormats() {
        return (formats_);
    }

    public BibliographyDatabase getBibliographyDatabase() {
        return (bibDB_);
    }

    public URL getHeader() {
        return (header_);
    }

    public URL getFooter() {
        return (footer_);
    }

    public ClassLoader getClassLoader() {
        return (classloader_);
    }

    public boolean isBigDocument() {
        return (bigDocument_);
    }
    
    public boolean isGoldenport() {
        return (goldenport_);
    }

    public String getLocaleDelimiter() {
        return (localeDelimiter_);
    }

    public SmartDocFormatConfig getFormatConfig(String format) {
        return ((SmartDocFormatConfig)configs_.get(format));
    }

    public String getLabel(String key, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getLabel(key));
    }

    public String[] getLabelParts(String key, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getLabelParts(key));
    }

    public String getPartLabel(int number, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getPartLabel(number));
    }

    public String getChapterLabel(int number, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getChapterLabel(number));
    }

    public String getSectionLabel(int number, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getSectionLabel(number));
    }

    public String getSubSectionLabel(
        int section,
        int subSection,
        Locale locale
    ) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getSubSectionLabel(section, subSection));
    }

    public String getSubSubSectionLabel(
        int section,
        int subSection,
        int subSubSection,
        Locale locale
    ) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (
            resource.getSubSubSectionLabel(section, subSection, subSubSection)
        );
    }

    public String getYearLabel(int year, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getYearLabel(year));
    }

    public String getMonthLabel(int month, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getMonthLabel(month));
    }

    public String getEditionLabel(int edition, Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getEditionLabel(edition));
    }

    public String getEditorLabel(Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getEditorLabel());
    }

    public String getEditorsLabel(Locale locale) {
        ISmartDocResource resource = _getResource(locale);
        if (resource == null) {
            throw (new InternalError());
        }
        return (resource.getEditorsLabel());
    }

    protected ISmartDocResource _getResource(Locale locale) {
        ISmartDocResource resource
            = (ISmartDocResource)resources_.get(locale);
        if (resource == null) {
            Locale backup = Locale.getDefault();
            Locale.setDefault(Locale.ENGLISH);
            resource = (ISmartDocResource)ResourceBundle.getBundle(
                "org.xmlsmartdoc.SmartDoc.SmartDocResource",
                locale
            );
            Locale.setDefault(backup);
            if (resource == null) {
                return (null);
            }
        }
        resources_.put(locale, resource);
        return (resource);
    }

    // XXX : UString
    private String getProject_() {
        String filename = source_.getFile();
        if (filename.indexOf('%') == -1) {
            return (getProject_(filename));
        } else {
            StringBuffer sb = new StringBuffer();
            char[] chars = filename.toCharArray();
            int state = 0;
            char first = 0;
            for (int i = 0;i < chars.length;i++) {
                char c = chars[i];
                if (state == 1) {
                    first = c;
                    state = 2;
                } else if (state == 2) {
                    sb.append(getCharByNumberChar_(first, c));
                    state = 0;
                } else if (c == '%') {
                    state = 1;
                } else {
                    sb.append(c);
                    state = 0;
                }
            }
            return (getProject_(sb.toString()));
        }
    }
    
    private char getCharByNumberChar_(char high, char low) {
        String number = new String(new char[] { high, low });
        return ((char)Integer.parseInt(number, 16));
    }

    private String getProject_(String filename) {
        int first;
        int last;
        first = filename.lastIndexOf("/");
        if (first == -1) {
            first = 0;
        } else {
            first++;
        }
        last = filename.lastIndexOf(".");
        if (last == -1) {
            return (filename.substring(first));
        } else {
            return (filename.substring(first, last));
        }
    }

    // XXX : UString
    protected File _getProjectDirectory(String filename) {
        int index = filename.lastIndexOf("/");
        if (index == -1) {
            return (null);
        } else {
            return (new File(filename.substring(0, index)));
        }
    }

    public String getLabelPrefixFigure(Locale locale) {
        if (labelPrefixFigure_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixFigure_.getDefault());
        }
        return ((String)labelPrefixFigure_.get(locale));
    }        

    public String getLabelPrefixTable(Locale locale) {
        if (labelPrefixTable_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixTable_.getDefault());
        }
        return ((String)labelPrefixTable_.get(locale));
    }        

    public String getLabelPrefixConsole(Locale locale) {
        if (labelPrefixConsole_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixConsole_.getDefault());
        }
        return ((String)labelPrefixConsole_.get(locale));
    }        

    public String getLabelPrefixProgram(Locale locale) {
        if (labelPrefixProgram_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixProgram_.getDefault());
        }
        return ((String)labelPrefixProgram_.get(locale));
    }        

    public String getLabelPrefixPart(Locale locale) {
        if (labelPrefixPart_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixPart_.getDefault());
        }
        return ((String)labelPrefixPart_.get(locale));
    }        

    public String getLabelPrefixChapter(Locale locale) {
        if (labelPrefixChapter_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixChapter_.getDefault());
        }
        return ((String)labelPrefixChapter_.get(locale));
    }        

    public String getLabelPrefixSection(Locale locale) {
        if (labelPrefixSection_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixSection_.getDefault());
        }
        return ((String)labelPrefixSection_.get(locale));
    }        

    public String getLabelPrefixSubsection(Locale locale) {
        if (labelPrefixSubsection_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixSubsection_.getDefault());
        }
        return ((String)labelPrefixSubsection_.get(locale));
    }        

    public String getLabelPrefixSubsubsection(Locale locale) {
        if (labelPrefixSubsubsection_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixSubsubsection_.getDefault());
        }
        return ((String)labelPrefixSubsubsection_.get(locale));
    }        

    public String getLabelPrefixEquation(Locale locale) {
        if (labelPrefixEquation_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelPrefixEquation_.getDefault());
        }
        return ((String)labelPrefixEquation_.get(locale));
    }        

    public String getLabelSuffixFigure(Locale locale) {
        if (labelSuffixFigure_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixFigure_.getDefault());
        }
        return ((String)labelSuffixFigure_.get(locale));
    }        

    public String getLabelSuffixTable(Locale locale) {
        if (labelSuffixTable_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixTable_.getDefault());
        }
        return ((String)labelSuffixTable_.get(locale));
    }        

    public String getLabelSuffixConsole(Locale locale) {
        if (labelSuffixConsole_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixConsole_.getDefault());
        }
        return ((String)labelSuffixConsole_.get(locale));
    }        

    public String getLabelSuffixProgram(Locale locale) {
        if (labelSuffixProgram_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixProgram_.getDefault());
        }
        return ((String)labelSuffixProgram_.get(locale));
    }        

    public String getLabelSuffixPart(Locale locale) {
        if (labelSuffixPart_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixPart_.getDefault());
        }
        return ((String)labelSuffixPart_.get(locale));
    }

    public String getLabelSuffixChapter(Locale locale) {
        if (labelSuffixChapter_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixChapter_.getDefault());
        }
        return ((String)labelSuffixChapter_.get(locale));
    }

    public String getLabelSuffixSection(Locale locale) {
        if (labelSuffixSection_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixSection_.getDefault());
        }
        return ((String)labelSuffixSection_.get(locale));
    }

    public String getLabelSuffixSubsection(Locale locale) {
        if (labelSuffixSubsection_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixSubsection_.getDefault());
        }
        return ((String)labelSuffixSubsection_.get(locale));
    }

    public String getLabelSuffixSubsubsection(Locale locale) {
        if (labelSuffixSubsubsection_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixSubsubsection_.getDefault());
        }
        return ((String)labelSuffixSubsubsection_.get(locale));
    }

    public String getLabelSuffixEquation(Locale locale) {
        if (labelSuffixEquation_ == null) {
            return (null);
        }
        if (locale == null) {
            return ((String)labelSuffixEquation_.getDefault());
        }
        return ((String)labelSuffixEquation_.get(locale));
    }

    public boolean isIdGlobal() {
        return (isIdGlobal_);
    }
}
