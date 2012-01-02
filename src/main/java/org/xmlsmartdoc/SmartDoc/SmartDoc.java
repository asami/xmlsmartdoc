/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2005  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

import java.io.*;
import org.w3c.dom.Document;
import com.AsamiOffice.jaba2.j2fw.*;
import com.AsamiOffice.jaba2.j2fw.generator.*;

/**
 * SmartDoc
 *
 * @since   Sep. 18, 1998
 * @version Jun.  8, 2005
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class SmartDoc {
    public static void main(String[] args) throws Exception {
        SmartDoc app = new SmartDoc(args);
        app.start();
        System.exit(0);
    }

    public SmartDoc(String[] args) throws Exception {
        SmartDocContext context = new SmartDocContext();
        SmartDocContext.setContext(context);
        J2Monitor monitor = context.getMonitor();
        try {
            SmartDocConfig config = new SmartDocConfig(args);
            monitor.setConfig(config);
            SmartDocModel model = new SmartDocModel(config);
            TTYView view = new TTYView(config, model);
            SmartDocController controller
                = new SmartDocController(config, model, view);
            context.setConfig(config);
            context.setModel(model);
            context.setController(controller);
            context.setView(view);
        } catch (SmartDocWarningException e) {
            monitor.warning(e.getMessage());
        } catch (SmartDocErrorException e) {
            monitor.error(e.getMessage());
        }
    }

    public void setup() {
        SmartDocContext context = SmartDocContext.getContext();
        J2Monitor monitor = context.getMonitor();
        try {
            SmartDocModel model = context.getModel();
            model.setup();
        } catch (IOException e) {
            monitor.error(e.getMessage());
        } catch (SmartDocWarningException e) {
            monitor.warning(e.getMessage());
            System.exit(2);
        } catch (SmartDocErrorException e) {
            monitor.error(e.getMessage());
            System.exit(1);
        }
    }

    public void setup(Document doc) {
        SmartDocContext context = SmartDocContext.getContext();
        J2Monitor monitor = context.getMonitor();
        try {
            SmartDocModel model = context.getModel();
            model.setup(doc);
        } catch (IOException e) {
            monitor.error(e.getMessage());
        } catch (SmartDocWarningException e) {
            monitor.warning(e.getMessage());
        } catch (SmartDocErrorException e) {
            monitor.error(e.getMessage());
        }
    }        

    public void start() {
        SmartDocContext context = SmartDocContext.getContext();
        J2Monitor monitor = context.getMonitor();
        try {
            SmartDocConfig config = context.getConfig();
            SmartDocModel model = context.getModel();
            SmartDocController controller = context.getController();

            if (config.showVersion()) {
                controller.showVersionConsole();
            } else if (config.showHelp()) {
                controller.showHelpConsole();
            } else if (config.getSource() == null) {
                controller.showUsageConsole();
            } else {
                String [] message = config.getVersionMessage();
                monitor.info(message[0]);
                monitor.info(message[1]);
                if (config.isVerbose()) {
                    controller.showPropertiesConsole();
                }
                monitor.verbose(
                    "Parse SmartDoc document..."
                );
                model.setup();
                generateFiles();
            }
        } catch (IOException e) {
            monitor.error(e.getMessage());
        } catch (SmartDocWarningException e) {
            monitor.warning(e.getMessage());
            System.exit(2);
        } catch (SmartDocErrorException e) {
            monitor.error(e.getMessage());
            System.exit(1);
        }
    }

    public GeneratorResult[] generateFiles() throws IOException {
        SmartDocContext context = SmartDocContext.getContext();
        J2Monitor monitor = context.getMonitor();
        SmartDocController controller = context.getController();
        monitor.verbose("Start generating files...");
        GeneratorResult[] results = controller.generateFiles();
        monitor.verbose("Done.");
        return (results);
    }
}
