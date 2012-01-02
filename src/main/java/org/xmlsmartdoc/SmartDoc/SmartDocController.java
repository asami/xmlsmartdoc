/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.AsamiOffice.jaba2.j2fw.J2Context;
import com.AsamiOffice.jaba2.j2fw.J2Monitor;
import com.AsamiOffice.jaba2.j2fw.TTYView;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorController;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IPackager;

/**
 * SmartDocController
 *
 * @since   Oct. 19, 1998
 * @version Oct. 19, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDocController extends GeneratorController {
    protected SmartDocConfig config_;
    protected SmartDocModel model_;
//    protected SmartDocGenerator generator_;
    protected String[] formats_;

    public SmartDocController(SmartDocConfig config, SmartDocModel model) {
        this(config, model, null);
    }

    public SmartDocController(
        SmartDocConfig config,
        SmartDocModel model,
        TTYView view
    ) {
        super(config, model, view);
        config_ = config;
        model_ = model;
//        generator_ = config.getGenerator();
        formats_ = config.getFormats();
        J2Context.getJ2Context().getJ2Monitor().setConsole(view.getTTY());
    }

    public void showPropertiesConsole() {
        J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
        String file = config_.getSource().toString();
        if (file != null) {
            monitor.println("Source file\t: " + file);
        }
        String propertyFile = config_.getPropertyFile();
        if (propertyFile != null) {
            monitor.println("Property file\t: " + propertyFile);
        }
        Locale[] locales = config_.getLocales();
        if (locales != null) {
            monitor.print("Locales\t: ");
            if (locales.length > 0) {
                monitor.print(locales[0].toString());
                for (int i = 1;i < locales.length;i++) {
                    monitor.print(", ");
                    monitor.print(locales[i].toString());
                }
            }
            monitor.println();
        }
    }

    // XXX : integrate GeneratorController
    public GeneratorResult[] generateFiles() throws IOException {
        List results = new ArrayList();
        J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
        DocContext[] contexts = model_.getDocContexts();
        for (int i = 0;i < contexts.length;i++) {
            DocContext context = contexts[i];
            String format = context.getFormat();
            Locale locale = context.getLocale();
            SmartDocGenerator generator = context.getGenerator();
            if (locale != null) {
                monitor.info(
                    "<<" +
                    context.getFormatName() +
                    "[" + locale + "]>>"
                );
                results.add(
                    _generateFile(
                        generator,
                        model_.getDoc(context),
                        locale,
                        model_
                    )
                );
            } else {
                monitor.info(
                    "<<" + context.getFormatName() + ">>"
                );
                results.add(
                    _generateFile(
                        generator,
                        model_.getDoc(context),
                        model_
                    )
                );
            }
        }
        if (model_.isSdocReport()) {
            results.add(
                _generateReportFile(model_)
            );
        }
        GeneratorResult[] array = new GeneratorResult[results.size()];
        return ((GeneratorResult[])results.toArray(array));
    }

    protected GeneratorResult _generateFile(
        SmartDocGenerator generator,
        Doc doc,
        Locale locale,
        SmartDocModel model
    ) throws IOException {
        J2Monitor monitor = J2Context.getJ2Context().getJ2Monitor();
        DocContext context = doc.getDocContext();
        GeneratorParameter param = new GeneratorParameter();
        param.doc = doc;
        param.model = model;
        param.deploy = config_.getDeploy(); // XXX
        param.project = config_.getProject();
        GeneratorResult result = generator.generate(param);
        GeneratorArtifact[] artifacts = result.getArtifacts();
        String format = context.getFormat();
        IPackager packager = config_.getPackager(format);
        packager.pack(
            artifacts,
            result,
            format,
            doc,
            model_.getTargetDirectory()
        );
        result.cleanup();
        for (int i = 0;i < artifacts.length;i++) {
            monitor.info("\tartifact = " + artifacts[i].getName());
        }
        return (result);
    }

    protected GeneratorResult _generateFile(
        SmartDocGenerator generator,
        Doc doc,
        SmartDocModel model
    ) throws IOException {
        return (_generateFile(generator, doc, null, model));
    }

    protected GeneratorResult _generateReportFile(
        SmartDocModel model
    ) throws IOException {
        GeneratorResult result = new GeneratorResult();
        String text = _makeReportText();
        File dir = model_.getTargetDirectory();
        File file = new File(dir, "SmartDoc.README");
        String fileName = file.toString();
        result.addArtifact(fileName, text, "UTF-8");
//        UFile.createFile(file, text, "UTF-8");
        return (result);
    }

    private String _makeReportText() {
        String[] messages = config_.getVersionMessage();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0;i < messages.length;i++) {
            buffer.append(messages[i]);
            buffer.append("\n");
        }
        return (new String(buffer));
    }
}
