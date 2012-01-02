/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import java.io.IOException;
import java.net.URL;

import org.iso_relax.verifier.Verifier;
import org.iso_relax.verifier.VerifierConfigurationException;
import org.iso_relax.verifier.VerifierFactory;
import org.relaxer.framework.rConfig.DefaultConfigFactory;
import org.relaxer.framework.rConfig.FCActionIn;
import org.relaxer.framework.rConfig.FCActionOut;
import org.relaxer.framework.rConfig.FCComponentAction;
import org.relaxer.framework.rConfig.FCModelAction;
import org.relaxer.framework.rConfig.FCPlainScript;
import org.relaxer.framework.rConfig.FCPlainScriptBody;
import org.relaxer.framework.rConfig.FCResourceAction;
import org.relaxer.framework.rConfig.FCServiceAction;
import org.relaxer.framework.rConfig.FCSystemAction;
import org.relaxer.framework.script.ScriptSpace;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;

import com.AsamiOffice.xml.sax.SimpleEntityResolver;
import com.AsamiOffice.xml.sax.SimpleErrorHandler;

/**
 * FrameworkConfigFactory
 *
 * @since   Jan.  9, 2004
 * @version Apr. 12, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FrameworkConfigFactory extends DefaultConfigFactory {
    private ScriptSpace scriptSpace_;

    public FrameworkConfigFactory(
        ScriptSpace scriptSpace,
        ClassLoader loader
    ) throws VerifierConfigurationException, SAXException, IOException {
        URL schema = getClass().getResource("/org/relaxer/framework/rConfig/config.rng");
        if (schema == null) {
            throw (new IOException("config.rng is not found."));
        }
        scriptSpace_ = scriptSpace;
        ErrorHandler errorHandler = new SimpleErrorHandler();
        EntityResolver entityResolver = new SimpleEntityResolver();
        setErrorHandler(errorHandler);
        setEntityResolver(this.entityResolver);
        VerifierFactory factory = getVerifierFactory_(loader);
        factory.setEntityResolver(entityResolver);
        Verifier verifier = factory.newVerifier(schema.openStream());
        setVerifier(verifier);
    }

    private VerifierFactory getVerifierFactory0_(ClassLoader loader) {
        return (new NullVerifierFactory());
    }

    private VerifierFactory getVerifierFactory_(ClassLoader loader) {
        if (loader == null) {
            loader = getClass().getClassLoader();
        }
        try {
            Class clazz = loader.loadClass("com.thaiopensource.relaxng.jarv.VerifierFactoryImpl");
            if (clazz == null) {
                clazz = loader.loadClass("com.sun.msv.verifier.jarv.TheFactoryImpl");
            }
            if (clazz == null) {
                return (new NullVerifierFactory());
            }
            return (VerifierFactory)(clazz.newInstance());
        } catch (ClassNotFoundException e) {
            return (new NullVerifierFactory());
        } catch (InstantiationException e) {
            return (new NullVerifierFactory());
        } catch (IllegalAccessException e) {
            return (new NullVerifierFactory());
        }
    }

    public FCPlainScript createFCPlainScript() {
        return (new ScriptPlainScript(scriptSpace_));
    }

    public FCPlainScriptBody createFCPlainScriptBody() {
        return (new ScriptPlainScriptBody(scriptSpace_));
    }

    public FCComponentAction createFCComponentAction() {
        return (new ScriptComponentAction(scriptSpace_));
    }

    public FCModelAction createFCModelAction() {
        return (new ScriptModelAction(scriptSpace_));
    }

    public FCResourceAction createFCResourceAction() {
        return (new ScriptResourceAction(scriptSpace_));
    }

    public FCServiceAction createFCServiceAction() {
        return (new ScriptServiceAction(scriptSpace_));
    }

    public FCSystemAction createFCSystemAction() {
        return (new ScriptSystemAction(scriptSpace_));
    }

    public FCActionIn createFCActionIn() {
        return (new ScriptActionIn(scriptSpace_));
    }

    public FCActionOut createFCActionOut() {
        return (new ScriptActionOut(scriptSpace_));
    }
}
