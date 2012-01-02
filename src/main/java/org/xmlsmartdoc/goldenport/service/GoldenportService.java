/*
 * The Relaxer artifact
 * Copyright (c) 2000-2004, ASAMI Tomoharu, All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * - Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer. 
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.xmlsmartdoc.goldenport.service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xmlsmartdoc.goldenport.*;
import org.xmlsmartdoc.goldenport.engine.GoldenportException;
import org.xmlsmartdoc.goldenport.engine.PortConfig;
import org.xmlsmartdoc.goldenport.engine.PortContext;
import org.xmlsmartdoc.goldenport.engine.PortEngine;

import com.AsamiOffice.io.UURL;

public class GoldenportService extends AbstractGoldenportService {
    /**
     * Implementation of a operation eval.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document eval(String source) 
      throws RemoteException {
        try {
            URL url = UURL.getURLFromFileOrURLName(source);
            File file = UURL.getActiveFile(url);
            DocumentBuilder builder = rGetDocumentBuilder();
            Document doc = builder.parse(file);
            PortConfig config = getPortConfig_();
            PortEngine engine = new PortEngine(config, rGetContext());
            PortContext context = new PortContext();
            context.setEngine(engine);
            context.setBaseFile(file);
            return (engine.eval(doc, context));
        } catch (GoldenportException e) {
            throw (new RemoteException("TODO", e));
        } catch (SAXException e) {
            throw (new RemoteException("TODO", e));
        } catch (IOException e) {
            throw (new RemoteException("TODO", e));
        } finally {
        }
    }

    /**
     * Implementation of a operation evalDocument.
     *
     * @param source
     * @exception RemoteException
     * @return org.w3c.dom.Document
     */
    public org.w3c.dom.Document evalDocument(org.w3c.dom.Document doc)
        throws RemoteException {
        try {
            DocumentBuilder builder = rGetDocumentBuilder();
            PortConfig config = getPortConfig_();
            PortEngine engine = new PortEngine(config, rGetContext());
            PortContext context = new PortContext();
            context.setEngine(engine);
            String baseUri = getXmlBase();
            File baseFile = UURL.getActiveFile(baseUri);
            if (baseFile != null) {
                context.setBaseFile(baseFile);
            }
            return (engine.eval(doc, context));
        } catch (GoldenportException e) {
            throw (new RemoteException("TODO", e));
        } catch (IOException e) {
            throw (new RemoteException("TODO", e));
        } finally {
        }
    }

    private PortConfig getPortConfig_() throws RemoteException, GoldenportException {
        PortConfig config = new PortConfig(rGetContext());
        config.setSystemConfig(getSystemConfig());
        config.setUserConfig(getConfig());
        return (config);
    }
}
