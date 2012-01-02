/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import java.io.IOException;

import org.iso_relax.verifier.Schema;
import org.iso_relax.verifier.Verifier;
import org.iso_relax.verifier.VerifierConfigurationException;
import org.iso_relax.verifier.VerifierFactory;
import org.iso_relax.verifier.VerifierHandler;
import org.iso_relax.verifier.impl.VerifierImpl;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * NullVerifierFactory
 *
 * @since   2004/02/17
 * @version 2004/02/17
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class NullVerifierFactory extends VerifierFactory {

    public Schema compileSchema(InputSource arg0)
        throws VerifierConfigurationException, SAXException, IOException {

        return (new NullSchema());
    }

    static class NullSchema implements Schema {
        public Verifier newVerifier() throws VerifierConfigurationException {
            return (new NullVerifier());
        }
    }
    
    static class NullVerifier extends VerifierImpl {
        protected NullVerifier() throws VerifierConfigurationException {
            super();
        }

        public VerifierHandler getVerifierHandler() throws SAXException {
            return (new NullVerifierHandler());
        }
    }
    
    static class NullVerifierHandler extends DefaultHandler
        implements VerifierHandler {
        public boolean isValid() throws IllegalStateException {
            return (true);
        }
    }
}
