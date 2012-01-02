/*
 * The RelaxerOrg class library
 *  Copyright (C) 1997-2005  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.iso_relax.verifier.VerifierConfigurationException;
import org.relaxer.framework.admin.RelaxerFrameworkMonitor;
import org.relaxer.framework.auth.RAuthManager;
import org.relaxer.framework.datatype.DatatypeFactory;
import org.relaxer.framework.datatype.IDatatype;
import org.relaxer.framework.dialog.DefaultConsolePresentation;
import org.relaxer.framework.dialog.DefaultDialog;
import org.relaxer.framework.dialog.IDialog;
import org.relaxer.framework.dialog.IPullPresentation;
import org.relaxer.framework.dialog.IScenario;
import org.relaxer.framework.dialog.IScene;
import org.relaxer.framework.exporter.ExportResource;
import org.relaxer.framework.exporter.ExporterException;
import org.relaxer.framework.exporter.ExporterFactory;
import org.relaxer.framework.exporter.IExporter;
import org.relaxer.framework.importer.IImporter;
import org.relaxer.framework.importer.ImporterException;
import org.relaxer.framework.importer.ImporterFactory;
import org.relaxer.framework.importer.UImporter;
import org.relaxer.framework.jdbc.DriverDataSource;
import org.relaxer.framework.jdbc.JdbcConfig;
import org.relaxer.framework.jdbc.XaDataSourceDataSource;
import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.logger.RFrameworkLoggerFactory;
import org.relaxer.framework.rConfig.ConfigFactory;
import org.relaxer.framework.rConfig.FCActionIn;
import org.relaxer.framework.rConfig.FCActionInPeek;
import org.relaxer.framework.rConfig.FCActionOut;
import org.relaxer.framework.rConfig.FCActionOutPoke;
import org.relaxer.framework.rConfig.FCAttribute;
import org.relaxer.framework.rConfig.FCComponent;
import org.relaxer.framework.rConfig.FCComponentAction;
import org.relaxer.framework.rConfig.FCComponentOption;
import org.relaxer.framework.rConfig.FCComponentService;
import org.relaxer.framework.rConfig.FCConfig;
import org.relaxer.framework.rConfig.FCConfigComponentRef;
import org.relaxer.framework.rConfig.FCConfigModelRef;
import org.relaxer.framework.rConfig.FCConfigResourceRef;
import org.relaxer.framework.rConfig.FCConstructor;
import org.relaxer.framework.rConfig.FCCopyright;
import org.relaxer.framework.rConfig.FCDatasourceResource;
import org.relaxer.framework.rConfig.FCDialog;
import org.relaxer.framework.rConfig.FCEpilogue;
import org.relaxer.framework.rConfig.FCExtension;
import org.relaxer.framework.rConfig.FCFileResource;
import org.relaxer.framework.rConfig.FCHelp;
import org.relaxer.framework.rConfig.FCJdbcResource;
import org.relaxer.framework.rConfig.FCJndiComponentRef;
import org.relaxer.framework.rConfig.FCJndiResource;
import org.relaxer.framework.rConfig.FCJndiResourceRef;
import org.relaxer.framework.rConfig.FCModel;
import org.relaxer.framework.rConfig.FCModelJavaClass;
import org.relaxer.framework.rConfig.FCModelType;
import org.relaxer.framework.rConfig.FCOperation;
import org.relaxer.framework.rConfig.FCOperationIn;
import org.relaxer.framework.rConfig.FCOperationOut;
import org.relaxer.framework.rConfig.FCOptionSet;
import org.relaxer.framework.rConfig.FCParametersValues;
import org.relaxer.framework.rConfig.FCPrologue;
import org.relaxer.framework.rConfig.FCRealization;
import org.relaxer.framework.rConfig.FCResource;
import org.relaxer.framework.rConfig.FCScriptService;
import org.relaxer.framework.rConfig.FCSlot;
import org.relaxer.framework.rConfig.FCSlotValue;
import org.relaxer.framework.rConfig.FCSystemOption;
import org.relaxer.framework.rConfig.FCUrlResource;
import org.relaxer.framework.rConfig.FCUsage;
import org.relaxer.framework.rConfig.FCValue;
import org.relaxer.framework.rConfig.FCVariable;
import org.relaxer.framework.rConfig.FCVariableResource;
import org.relaxer.framework.rConfig.FCVersion;
import org.relaxer.framework.rConfig.IConfigFactory;
import org.relaxer.framework.rConfig.IFCComponentRefChoice;
import org.relaxer.framework.rConfig.IFCConstructorChoice;
import org.relaxer.framework.rConfig.IFCModelChoice;
import org.relaxer.framework.rConfig.IFCModelRefChoice;
import org.relaxer.framework.rConfig.IFCOptionsChoice;
import org.relaxer.framework.rConfig.IFCResourceChoice;
import org.relaxer.framework.rConfig.IFCResourceRefChoice;
import org.relaxer.framework.rConfig.IFCServiceChoice;
import org.relaxer.framework.rConfig.IFCSlotMixed;
import org.relaxer.framework.rConfig.RString;
import org.relaxer.framework.rConfig.factory.FrameworkConfigFactory;
import org.relaxer.framework.runtime.IJdbcConfig;
import org.relaxer.framework.runtime.RComponentContext;
import org.relaxer.framework.runtime.RContainerContext;
import org.relaxer.framework.runtime.RRuntimeContext;
import org.relaxer.framework.runtime.RSessionContext;
import org.relaxer.framework.runtime.RSystemContext;
import org.relaxer.framework.runtime.RelaxerRuntimeException;
import org.relaxer.framework.runtime.messager.IRFrameworkMessager;
import org.relaxer.framework.runtime.messager.StderrMessager;
import org.relaxer.framework.runtime.model.IRModel;
import org.relaxer.framework.runtime.model.context.IRModelContext;
import org.relaxer.framework.runtime.model.context.RModelContext;
import org.relaxer.framework.runtime.reporter.IRFrameworkReporter;
import org.relaxer.framework.runtime.reporter.PlainReporter;
import org.relaxer.framework.script.BootScript;
import org.relaxer.framework.script.DefaultScript;
import org.relaxer.framework.script.IScriptConstants;
import org.relaxer.framework.script.ScriptClass;
import org.relaxer.framework.script.ScriptEngine;
import org.relaxer.framework.script.ScriptException;
import org.relaxer.framework.script.ScriptSpace;
import org.relaxer.framework.script.Slot;
import org.relaxer.framework.testScript.FTSEvaluationContext;
import org.relaxer.framework.testScript.FTSTestScriptFactory;
import org.relaxer.framework.testScript.rTestScript.ITestScriptFactory;
import org.relaxer.framework.testScript.rTestScript.REvaluationException;
import org.relaxer.framework.testScript.rTestScript.TSBody;
import org.relaxer.framework.testScript.rTestScript.TSTest;
import org.relaxer.framework.testScript.rTestScript.TSTestcase;
import org.relaxer.framework.testScript.rTestScript.TestScriptFactory;
import org.relaxer.j2eecontainer.J2eeContainer;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.AsamiOffice.io.UURL;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.UClass;
import com.AsamiOffice.util.ULocale;
import com.AsamiOffice.xml.UXMLMaker;
import com.AsamiOffice.xml.sax.DTDSkipper;

/**
 * RelaxerFramework
 *
 * @since   May.  3, 2003
 * @version Feb. 14, 2006
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class RelaxerFramework {
    private final static String VERSION = "0.1b";
    private final static String BUILD = "20060214";

    public final static String ROLE_MAIN = "main";
    public final static String SERVICE_SYSTEM_USAGE = "_usage_";

    private IParameterParser parser_;
    private String configName_;
    private IConfigFactory configFactory_;
    private FCConfig fcConfig_;
    private String classPath_;
    private ClassLoader classLoader_;
    private DocumentBuilder builder_;
    private SAXParser saxParser_;
    private XMLReader xmlReader_;
    //
    private String locale_;
    private String textEncoding_ = "UTF-8";
    private String newLine_ = "\n";
    //
    private boolean showVersion_;
    private boolean showHelp_;
    //
    private String sessionName_;
    private String authName_;
    private RAuthManager auth_;
    private String loginName_;
    private String password_;
    //
    private String importer_;
    private String exporter_;
    private String exporterDirectory_;
    private String exporterEncoding_;
    private String exporterName_;
    private String exporterSuffix_;
    private String exporterOutput_;
    //
    private String jdbcConfigName_;
    private String jdbcProfileName_;
    private IJdbcConfig jdbcConfig_;
    private String jdbcUrlName_;
    private String jdbcDriverName_;
    private String jdbcUsername_;
    private String jdbcPassword_;
    private DataSource jdbcDataSource_;
    //
    private String service_;
    private Service mainService_ = null;
    // Map<String, Service>
    private Map services_ = new HashMap();
    // Map<String, Option>
    private Map options_ = new HashMap();
    // Map<String, Object>
    private Map components_ = new HashMap();
    // Map<String, IRModel>
    private Map models_ = new HashMap();
    // Map<String, Object>
    private Map resources_ = new HashMap();
    //
    private DatatypeFactory datatypeFactory_;
    private ScriptSpace scriptSpace_;
    //
    private IDialog dialog_;
    private Map stories_ = new HashMap();
    private IScene currentScene_;
    private Map scenes_ = new HashMap();
    //
    private String testCaseName_;
    private TSTestcase tsTestCase_;
    //
    private boolean junit_;
    private String junitPackage_;
    private String junitDir_;
    private boolean junitDirPackage_;
    //
    private J2eeContainer j2eeContainer_;
    //
    private RelaxerFrameworkMonitor monitor_;
    private String loggerSettings_;
    private IRFrameworkLogger logger_;
    private ExternalServiceManager externalResource_;
    //
    private IRFrameworkMessager messager_;
    private IRFrameworkReporter reporter_;
    //
    private RSystemContext systemContext_;
    private RRuntimeContext runtimeContext_;
    private RContainerContext containerContext_;
    private RSessionContext sessionContext_;
    private RModelContext modelContext_;

    public static void main(String[] args) {
        if (args.length == 0) {
            showFrameworkUsage__();
            System.exit(1);
        } else if (args.length == 1) {
            if ("--version".equals(args[0])) {
                showFrameworkVersion__();
                System.exit(0);
            }
        }
        RelaxerFramework framework = null;
        try {
            framework = new RelaxerFramework(args);
        } catch (RelaxerFrameworkException e) {
            configError__(framework, e);
            System.exit(1);
        }
        try {
            framework.execute();
            System.exit(0);
        } catch (Throwable e) {
            executeError__(framework, e);
        } finally {
            if (framework != null) {
                framework.close();
            }
        }
        System.exit(1);
    }

    private static void configError__(RelaxerFramework framework, Throwable e) {
        showFrameworkVersion__();
        String message = "RelaxerFramework exited abnormally due to configuration problems.";
        if (framework != null) {
            IRFrameworkLogger logger = framework.getLogger();
            if (logger != null) {
                logger.fatal(message);
                return;
            } else {
                System.err.println("Logger does not be initialized.");
            }
        } else {
            System.err.println("RelaxerFramework can not be instantiate.");
        }
        System.err.println(message);
        e.printStackTrace(System.err);
    }

    private static void usageError__(RelaxerFramework framework, Throwable e) {
        String message = "RelaxerFramework exited abnormally due to illegal usage.";
        IRFrameworkLogger logger = framework.getLogger();
        if (logger != null) {
            logger.fatal(message);
        } else {
            System.err.println(message);
        }
    }

    private static void runtimeError__(RelaxerFramework framework, Throwable e) {
        String message = "RelaxerFramework exited abnormally due to application errors.";
        IRFrameworkLogger logger = framework.getLogger();
        if (logger != null) {
            logger.fatal(message, e);
        } else {
            System.err.println(message);
        }
    }

    private static void executeError__(RelaxerFramework framework, Throwable e) {
        Throwable cause = getRootCause__(e);
        if (cause instanceof IllegalArgumentException) {
            usageError__(framework, cause);
        } else {
            runtimeError__(framework, cause);
        }
    }
    
    private static Throwable getRootCause__(Throwable e) {
        Throwable current = e;
        for (;;) {
            if (current instanceof IllegalArgumentException) {
                return (e);
            } else if (current instanceof RelaxerFrameworkException) {
                Throwable cause = ((RelaxerFrameworkException)current).rGetRealCause();
                if (cause == null) {
                    break;
                }
                current = cause;
            } else if (current instanceof InvocationTargetException) {
                Throwable cause = ((InvocationTargetException)current).getTargetException();
                if (cause == null) {
                    break;
                }
                current = cause;
            } else if (current instanceof org.relaxer.framework.rConfig.REvaluationException) {
                Throwable cause = ((org.relaxer.framework.rConfig.REvaluationException)current).rGetParent();
                if (cause == null) {
                    break;
                }
                current = cause;
            } else if (current instanceof REvaluationException) {
                Throwable cause = ((REvaluationException)current).rGetParent();
                if (cause == null) {
                    break;
                }
                current = cause;
            } else {
                try {
                    Throwable cause = current.getCause();
                    if (cause == null) {
                        break;
                    }
                    current = cause;
                } catch (Exception ee) { // NoSuchMethodException
                    break;
                }
            }
        }
        return (current);
    }

    private static void showFrameworkUsage__() {
        showFrameworkVersion__();
        System.out.println();
        System.out.println("relaxerfw --classpath:classpath --config:config.xml [options...] [parameters...]");
    }

    private static void showFrameworkVersion__() {
        System.out.println("Copyright(c) 2000-2004 ASAMI,Tomoharu. All rights reserved.");
        System.out.print("RelaxerFramework Version ");
        System.out.print(VERSION);
        System.out.print(" (");
        System.out.print(BUILD);
        System.out.println(") by asami@relaxer.org");
    }

    public RelaxerFramework(String[] args)
      throws RelaxerFrameworkException {
        try {
            init_(new DefaultParameterParser(args));
        } catch (MalformedURLException e) {
            throw (init_error_(e));
        } catch (IOException e) {
            throw (init_error_(e));
        }
    }

    public RelaxerFramework(URL config)
      throws RelaxerFrameworkException {
        this(config, new HashMap());
    }

    public RelaxerFramework(Class clazz, String[] args) 
      throws RelaxerFrameworkException {
        String packageName = getPackageName_(clazz);
        String classLeafName = _getClassLeafName(clazz.getName());
        String bigName = UString.capitalize(classLeafName);
        String smallName = UString.uncapitalize(classLeafName);
        String dir = getDir_(packageName);
        URL config = clazz.getResource(
            "/WEB-INF/" + packageName + "." + smallName + ".xml"
        );
        if (config == null) {
            config = clazz.getResource(
                "/WEB-INF/" + packageName + "." + bigName + ".xml"
            );
        }
        if (config == null) {
            config = clazz.getResource(
                "/META-INF/" + packageName + "." + smallName + ".xml"
            );
        }
        if (config == null) {
            config = clazz.getResource(
                "/META-INF/" + packageName + "." + bigName + ".xml"
            );
        }
        if (config == null) {
            String configName1 = dir + UString.uncapitalize(classLeafName) + ".xml";
            config = clazz.getResource(configName1);
        }
        if (config == null) {
            String configName2 = dir + UString.capitalize(classLeafName) + ".xml";
            config = clazz.getResource(configName2);
        }
        if (config == null) {
            String message = "Config file '" + smallName + ".xml" +
                             "' is unavailable in the resource '" + dir + "'.";  
            throw (new RelaxerFrameworkException(message));
        }
        try {
            init_(new DefaultParameterParser(args, config, clazz));
        } catch (MalformedURLException e) {
            throw (init_error_(e));
        } catch (IOException e) {
            throw (init_error_(e));
        }
    }

    private String getDir_(String packageName) {
        if (packageName != null) {
            return ("/" + packageName.replace('.', '/') + "/");
        } else {
            return ("/");
        }
    }

    private String getPackageName_(Class clazz) {
        return (UClass.getPackageName(clazz));
    }

    private String _getClassLeafName(String className) {
        int index = className.lastIndexOf('.');
        if (index == -1) {
            return (className);
        } else {
            return (className.substring(index + 1));
        }
    }

    public RelaxerFramework(URL config, String[] args)
      throws RelaxerFrameworkException {
        String[] newArgs = new String[args.length + 1];
        newArgs[0] = "--config:" + config.toExternalForm();
        System.arraycopy(args, 0, newArgs, 1, args.length);
        try {
            init_(new DefaultParameterParser(newArgs));
        } catch (MalformedURLException e) {
            throw (init_error_(e));
        } catch (IOException e) {
            throw (init_error_(e));
        }
    }

    public RelaxerFramework(URL config, Map properties)
      throws RelaxerFrameworkException {
        properties.put("config", config.toExternalForm());
        try {
            init_(new DefaultParameterParser(properties));
        } catch (MalformedURLException e) {
            throw (init_error_(e));
        } catch (IOException e) {
            throw (init_error_(e));
        }
    }

    private void init_(IParameterParser parser)
      throws RelaxerFrameworkException {
        try {
            parser_ = parser;
            setupMonitor_();
            setupJ2eeEnv_();
            setupFramework_(parser);
            logger_.config("Start RelaxerFramework " + VERSION + " (" + BUILD + ")");
            setupScript_();
            setupResources_();
            setupModels_();
            setupComponents_();
            setupServices_();
            setupOptions_();
            setupDialog_();
        } catch (SAXException e) {
            throw (init_error_(e));
        } catch (ParserConfigurationException e) {
            throw (init_error_(e));
        } catch (NamingException e) {
            throw (init_error_(e));
        } catch (IOException e) {
            throw (init_error_(e));
        } catch (VerifierConfigurationException e) {
            throw (init_error_(e));
        }
    }
    
    private RelaxerFrameworkException init_error_(Throwable e) {
        return (new RelaxerFrameworkException("init_", e));
    }

    public Object getService(String serviceName) {
        if (logger_.getLevel() >= IRFrameworkLogger.LOG_TRACE) {
            return (null);
        }
        Service service = _getService(serviceName);
        if (service == null) {
            return (null);
        } else {
            return (service.component);
        }
    }
    
    public Object getOption(String optionName) {
        if (logger_.getLevel() >= IRFrameworkLogger.LOG_TRACE) {
            return (null);
        }
        Option option = _getOption(optionName);
        if (option == null) {
            return (null);
        } else {
            return (option.component);
        }
    }

    public void execute() throws RelaxerFrameworkException {
        if (showVersion_) {
            showVersion_();
        } else if (showHelp_) {
            showHelp_();
        } else {
        	try {
                execute_(parser_);
        	} catch (Throwable e) {
                if (e instanceof ScriptException) {
                    ScriptException se = (ScriptException)e;
                    if (se.getCause() instanceof IllegalArgumentException) {
                        showHelp_();
                        return;
                    }
                }
//                IRFrameworkLogger logger = getLogger();
//                if (logger != null) {
//                    String message = "RelaxerFramework exited abnormally due to application errors.";
//                    logger.debug(message, e);
//                }
        		if (e instanceof RelaxerFrameworkException) {
        		    throw ((RelaxerFrameworkException)e);
                } else {
                    throw (new RelaxerFrameworkException(e));
                }
        	}
        }
    }

    public void handleCommandError(Throwable e) throws RelaxerFrameworkException {
        Throwable cause = getRootCause__(e);
        if (cause instanceof IllegalArgumentException) {
            usageError_(cause);
        } else if (cause instanceof RuntimeException) {
            throw ((RuntimeException)cause);
        } else if (cause instanceof RelaxerFrameworkException) {
            throw ((RelaxerFrameworkException)cause);
        } else if (e instanceof RelaxerFrameworkException) {
            throw ((RelaxerFrameworkException)e);
        } else {
            throw (new RelaxerFrameworkException(e));
        }
    }

    public void close() {
        systemContext_.close();
        // TODO
        logger_.config("End RelaxerFramework");
    }

    private void usageError_(Throwable e) {
        usageError_();
    }

    private void usageError_() {
        showUsage_();
        System.out.println("  for more information, use --help option");
    }

    private void runtimeError_(Throwable e) {
        String message = "RelaxerFramework exited abnormally due to application errors.";
        IRFrameworkLogger logger = getLogger();
        if (logger != null) {
            logger.fatal(message, e);
        } else {
            System.err.println(message);
        }
    }

    private void showVersion_() {
        FCCopyright copyright = getCopyright_();
        if (copyright != null) {
            System.out.println(copyright.getContent());
        }
        FCVersion version = getVersion_();
        if (version != null) {
            System.out.println(makeVersion_(version));
        }
    }

    private void infoVersion_() {
        FCCopyright copyright = getCopyright_();
        if (copyright != null) {
            logger_.info(copyright.getContent());
        }
        FCVersion version = getVersion_();
        if (version != null) {
            logger_.info(makeVersion_(version));
        }
    }

    private String makeVersion_(FCVersion version) {
        String content = version.getContent();
        if (!(content == null || "".equals(content))) {
            return (content);
        }
        String number = version.getNumber();
        String build = version.getBuild();
        String prologue = version.getPrologue();
        String epilogue = version.getEpilogue();
        StringBuffer sb = new StringBuffer();
        if (prologue != null) {
            sb.append(prologue);
            sb.append(" ");
        }
        sb.append(number);
        if (build != null) {
            sb.append(" ");
            sb.append("(");
            sb.append(build);
            sb.append(")");
        }
        if (epilogue != null) {
            sb.append(" ");
            sb.append(epilogue);
        }
        return (new String(sb));
    }

    private void showUsage_() {
        showVersion_();
        System.out.println();
        FCUsage usage = getUsage_();
        if (usage != null) {
            System.out.print("Usage: ");
            System.out.println(usage.getContent());
        }
    }

    private void showHelp_() throws RelaxerFrameworkException {
        showUsage_();
        System.out.println();
        IFCServiceChoice[] services = fcConfig_.getService();
        for (int i = 0; i < services.length; i++) {
            IFCServiceChoice choice = services[i];
            if (choice instanceof FCComponentService) {
                showHelp_((FCComponentService)choice);
            } else if (choice instanceof FCScriptService) {
                throw (new RelaxerFrameworkException());
            } else {
                throw (new RelaxerFrameworkException());
            }
        }
    }

    private void showHelp_(FCComponentService service) {
        Locale envLocale = getLocale();
        FCHelp all = null;
        FCHelp en = null;
        FCHelp current = null;
        FCHelp[] helps = service.getHelp();
        for (int i = 0; i < helps.length; i++) {
            FCHelp help = helps[i];
            if ("short".equals(help.getType())) {
                Locale helpLocale = help.getLocale();
                if (helpLocale == null) {
                    all = help;
                } else { 
                    if ("en".equals(helpLocale.toString())) {
                        en = help;
                    }
                    Locale currentLocale;
                    if (current != null) {
                        currentLocale = current.getLocale();
                    } else {
                        currentLocale = null;
                    }
                    if (ULocale.match(envLocale, helpLocale, currentLocale)) {
                        current = help;
                    }
                }
            }
        }
        FCHelp help = null;
        if (current != null) {
            help = current;
        } else if (en != null) {
            help = en;
        } else if (all != null) { 
            help = all;
        }
        System.out.print("  -");
        System.out.print(service.getName());
        System.out.println();
        if (help != null) {
            System.out.print("    ");
            System.out.print(help.getContent());
            System.out.println();
        }
    }

    private FCCopyright getCopyright_() {
        FCCopyright candidate = null;
        FCCopyright[] copyrights = fcConfig_.getCopyright();
        for (int i = 0;i < copyrights.length;i++) {
            FCCopyright copyright = copyrights[i];
            candidate = copyright;// TODO
        }
        return (candidate);
    }

    private FCVersion getVersion_() {
        FCVersion candidate = null;
        FCVersion[] versions = fcConfig_.getVersion();
        for (int i = 0;i < versions.length;i++) {
            FCVersion version = versions[i];
            candidate = version;// TODO
        }
        return (candidate);
    }

    private FCUsage getUsage_() {
        FCUsage candidate = null;
        FCUsage[] usages = fcConfig_.getUsage();
        for (int i = 0;i < usages.length;i++) {
            FCUsage usage = usages[i];
            candidate = usage;// TODO
        }
        return (candidate);
    }

    public Object executeService() 
      throws RelaxerFrameworkException {
        return (executeService_(parser_));
    }

    private RelaxerFrameworkException executeService_error_(Throwable e) {
        return (new RelaxerFrameworkException("executeService", e));
    }

    public Object invokeService(String service, Object param1)
      throws RelaxerFrameworkException {
        return (invokeService(service, new Object[] { param1 }));
    }

    public Object invokeService(String service, Object param1, Object param2)
      throws RelaxerFrameworkException {
        return (invokeService(service, new Object[] { param1, param2 }));
    }

    public Object invokeService(String service, Object param1, Object param2, Object param3)
      throws RelaxerFrameworkException {
        return (invokeService(service, new Object[] { param1, param2, param3 }));
    }

    public Object invokeService(String service, Object[] parameters)
      throws RelaxerFrameworkException {
        return (invokeService(service, parameters, null));
    }

    public Object invokeService(
        String service, 
        Object[] parameters,
        Map attributes
    ) throws RelaxerFrameworkException {
        return (invokeService_(service, parameters, attributes));
    }

    public Object getOptionValue(String name) {
        throw (new UnsupportedOperationException());
    }

    public void setOptionValue(String name, Object value) 
      throws RelaxerFrameworkException {
        Option option = _getOption(name);
        if (option == null) {
            String message = "Can not use option '" + name + "'.";
            logger_.error(message);
            throw (new RelaxerFrameworkException(message));
        }
        Method method = option.setter;
        try {
            Object param = UImporter.getParameter(
                value, 
                method.getParameterTypes()[0]
            );
            method.invoke(option.component, new Object[] { param });
        } catch (IllegalAccessException e) {
            setOptionValue_error_(e);
        } catch (InvocationTargetException e) {
            setOptionValue_error_(e);
        } catch (ImporterException e) {
            setOptionValue_error_(e);
        } finally {
        }
    }

    public void setOptionValue(String name, int value) 
    throws RelaxerFrameworkException {
      Option option = _getOption(name);
      if (option == null) {
          String message = "Can not use option '" + name + "'.";
          logger_.error(message);
          throw (new RelaxerFrameworkException(message));
      }
      Method method = option.setter;
      try {
          Object param = UImporter.getParameter(
              new Integer(value), 
              method.getParameterTypes()[0]
          );
          method.invoke(option.component, new Object[] { param });
      } catch (IllegalAccessException e) {
          setOptionValue_error_(e);
      } catch (InvocationTargetException e) {
          setOptionValue_error_(e);
      } catch (ImporterException e) {
          setOptionValue_error_(e);
      } finally {
      }
  }

    private void setOptionValue_error_(Exception e) {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException());
    }

    public void executeTestScript(int number) 
        throws RelaxerFrameworkException {
        try {
            TSTest[] tests = tsTestCase_.getTest();
            _executeTestScript(tests[number - 1]);
        } catch (REvaluationException e) {
            Throwable cause = e.getCause();
            if (cause != null) {
                throw (new RelaxerFrameworkException(e.getMessage(), cause));
            } else {
                throw (new RelaxerFrameworkException(e.getMessage(), e));
            }
        }
    }

    private Service _getService(String serviceName) {
        if (serviceName == null) {
            return (mainService_);
        } else {
            Service service = (Service)services_.get(serviceName);
            return (service);
        }
    }
    
    private Option _getOption(String optionName) {
        return ((Option)options_.get(optionName));
    }

    private Object _getComponentInstance(String componentName) {
        Object component = components_.get(componentName);
        return (component);
    }

    private void setupFramework_(IParameterParser parser)
        throws IOException, SAXException, ParserConfigurationException, VerifierConfigurationException {

        configName_ = parser.getFrameworkProperty("config");
        if (configName_ == null) {
            logger_.fatal("No config file is specified.");
            throw (new RelaxerFrameworkException("no config"));
        }
        scriptSpace_ = new ScriptSpace(this);
        configFactory_ = new FrameworkConfigFactory(scriptSpace_, null);
        ConfigFactory.setFactory(configFactory_);
        fcConfig_ = configFactory_.createFCConfig(configName_);
        IParameterParser configedParser = new ConfigedParser(fcConfig_, parser);
        classPath_ = configedParser.getFrameworkProperty("classpath");
        classLoader_ = getClassLoader_(classPath_);
        builder_ = makeDocumentBuilder_();
        saxParser_ = makeSaxParser_();
        xmlReader_ = saxParser_.getXMLReader();
        //
        locale_ = configedParser.getFrameworkProperty("locale");
        textEncoding_ = configedParser.getFrameworkProperty("text.encoding");
        newLine_ = configedParser.getFrameworkProperty("text.newLine");
        //
        showVersion_ = configedParser.isFrameworkProperty("version");
        showHelp_ = configedParser.isFrameworkProperty("help");
        //
        sessionName_ = configedParser.getFrameworkProperty("session");
        authName_ = configedParser.getFrameworkProperty("auth");
        if (authName_ != null) {
            auth_ = new RAuthManager(authName_);
        }
        loginName_ = configedParser.getFrameworkProperty("login");
        password_ = configedParser.getFrameworkProperty("password");
        //
        service_ = configedParser.getService();
        importer_ = configedParser.getFrameworkProperty("importer");
        exporter_ = configedParser.getFrameworkProperty("exporter");
        exporterDirectory_ = configedParser.getFrameworkProperty("exporter.dir");
        exporterEncoding_ = configedParser.getFrameworkProperty("exporter.encoding");
        exporterName_ = configedParser.getFrameworkProperty("exporter.name");
        exporterSuffix_ = configedParser.getFrameworkProperty("exporter.suffix");
        exporterOutput_ = configedParser.getFrameworkProperty("exporter.output");
        //
        jdbcConfigName_ = configedParser.getFrameworkProperty("jdbc.config");
        jdbcProfileName_ = configedParser.getFrameworkProperty("jdbc.profile");
        if (jdbcConfigName_ != null) {
            jdbcConfig_ = new JdbcConfig(jdbcConfigName_, jdbcProfileName_); 
        }
        jdbcUrlName_ = configedParser.getFrameworkProperty("jdbc.url");
        jdbcDriverName_ = configedParser.getFrameworkProperty("jdbc.driver");
        jdbcUsername_ = configedParser.getFrameworkProperty("jdbc.username");
        jdbcPassword_ = configedParser.getFrameworkProperty("jdbc.password");
        if (jdbcUrlName_ != null) {
            if (jdbcUrlName_.startsWith("jdbc:")) {
                if (jdbcDriverName_ != null) {
                    try {
                        Class driverClass = classLoader_.loadClass(jdbcDriverName_);
                        Driver driver = (Driver)driverClass.newInstance();
                        jdbcDataSource_ = new DriverDataSource(jdbcUrlName_, driver);
                    } catch (ClassNotFoundException e) {
                        logger_.warning("\"" + jdbcDriverName_ + "\" is not found.", e);
                    } catch (InstantiationException e) {
                        logger_.warning("\"" + jdbcDriverName_ + "\" can not be instantiated.", e);
                    } catch (IllegalAccessException e) {
                        logger_.warning("\"" + jdbcDriverName_ + "\" can not be accessed.", e);
                    }
                } else {
                    logger_.warning("No jdbc.driver.name is specified.");
                }
            } else {
                try {
                    Context ctx = new InitialContext();
                    Object object = ctx.lookup(jdbcUrlName_);
                    if (object instanceof XADataSource) {
                        jdbcDataSource_ = new XaDataSourceDataSource(
                            (XADataSource)object
                        );
                    } else if (object instanceof DataSource){
                        jdbcDataSource_ = (DataSource)object;
                    } else {
                        logger_.warning("\"" + jdbcUrlName_ + "\" is not DataSource, " + 
                                        "but " + object + "[" + object.getClass() + "]");
                    }
                } catch (NamingException e) {
                    logger_.warning("\"" + jdbcUrlName_ + "\" is unavailable in JNDI.", e);
                }
            }
        }
        //
        testCaseName_ = configedParser.getFrameworkProperty("test");
        if (testCaseName_ != null) {
            ITestScriptFactory testFactory = new FTSTestScriptFactory();
            TestScriptFactory.setFactory(testFactory);
            tsTestCase_ = testFactory.createTSTestcase(testCaseName_);
        }
        //
        junit_ = configedParser.isFrameworkProperty("junit");
        junitPackage_ = configedParser.getFrameworkProperty("junit.package");
        junitDir_ = configedParser.getFrameworkProperty("junit.dir"); 
        junitDirPackage_ = configedParser.isFrameworkProperty("junit.dir.package");
        //
        logger_.config("RelaxerFramework config: " + configName_);
        try {
            logger_.config(fcConfig_.makeTextDocument());
        } catch (Exception e) {
            logger_.fatal("Illegal framework configuration.", e);
        }
        parser_.logConfig(logger_);
        //
        messager_ = new StderrMessager();
        reporter_ = new PlainReporter();
        //
        systemContext_ = new RSystemContext(); // TODO singleton
        runtimeContext_ = new RRuntimeContext(); // TODO singleton
        containerContext_ = new RContainerContext(this);
        containerContext_.setTextEncoding(textEncoding_);
        containerContext_.setNewLine(getNewLine());
        containerContext_.setLogger(logger_);
        containerContext_.setReporter(reporter_);
        containerContext_.setMessager(messager_);
        containerContext_.setDataSource(jdbcDataSource_);
        containerContext_.setJdbcConfig(jdbcConfig_);
        containerContext_.setJdbcUsername(jdbcUsername_);
        containerContext_.setJdbcPassword(jdbcPassword_);
        runtimeContext_.addContainerContext(containerContext_);
        systemContext_.addRuntimeContext(runtimeContext_);
        //
        if (sessionName_ != null) {
            sessionContext_ = new RSessionContext(sessionName_);
        } else {
            sessionContext_ = new RSessionContext();
        }
        if (auth_ != null) {
            if (loginName_ != null) {
                sessionContext_.authenticate(auth_, loginName_, password_);
            } else {
                sessionContext_.authenticate(auth_);
            }
        }
        containerContext_.setSessionContext(sessionContext_);
        modelContext_ = new RModelContext(containerContext_);
    }

    private IRFrameworkLogger _makeLogger() {
        RFrameworkLoggerFactory factory = new RFrameworkLoggerFactory();
        return (factory.getLogger(loggerSettings_));
    }

    private ClassLoader getClassLoader_(String classPath) throws MalformedURLException {
        if (classPath == null) {
            return (getClass().getClassLoader());
//            return (ClassLoader.getSystemClassLoader()); 
        }
        String[] tokens = UString.getTokens(classPath, ",;");
        URL[] urls = new URL[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            urls[i] = UURL.getURLFromFileOrURLName(tokens[i]);
        }
        return (new URLClassLoader(urls));
    }

    private DocumentBuilder makeDocumentBuilder_() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        builder.setEntityResolver(new DTDSkipper());
        // XXX : builder.setErrorHandler();
        return (builder);
    }

    private SAXParser makeSaxParser_() throws ParserConfigurationException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        SAXParser parser = factory.newSAXParser();
        // XXX : parser.setEntityResolver();
        // XXX : builder.setErrorHandler();
        return (parser);
    }

    private void setupMonitor_() {
        loggerSettings_ = parser_.getFrameworkProperty("log");
        if (loggerSettings_ == null) {
            if (parser_.isFrameworkProperty("debug")) {
                loggerSettings_ = "debug:stdout,file";
            } else if (parser_.isFrameworkProperty("verbose")) {
                loggerSettings_ = "info";
            } else if (parser_.isFrameworkProperty("terse")) {
                loggerSettings_ = "none";
            } else {
                loggerSettings_ = "warning";
            }
        }
//        loggerSettings_ = "debug:stdout,file";
        logger_ = _makeLogger();
        monitor_ = new RelaxerFrameworkMonitor(this);
        externalResource_ = new ExternalServiceManager(logger_);
    }

    private void setupJ2eeEnv_() throws IOException, SAXException, ParserConfigurationException, NamingException {
        String config = parser_.getFrameworkProperty("j2ee");
        if (config == null) {
            return;
        }
        j2eeContainer_ = J2eeContainer.getContainer();
        if (j2eeContainer_ == null) {
            j2eeContainer_ = J2eeContainer.newInstance(config, monitor_);
        } else {
            j2eeContainer_.addConfig(config);
        }
    }
    
    //
    private void setupScript_() {
        datatypeFactory_ = new DatatypeFactory(this);
        DatatypeFactory.setFactory(datatypeFactory_);
        ScriptClass rootClass = new ScriptClass("/", scriptSpace_);
        FCPrologue prologue = fcConfig_.getPrologue();
        if (prologue != null) {
            rootClass.setPrologue(
                new DefaultScript(prologue.getPlainScriptBodyContent())
            );
        }
        FCEpilogue epilogue = fcConfig_.getEpilogue();
        if (epilogue != null) {
            rootClass.setEpilogue(
                new DefaultScript(epilogue.getPlainScriptBodyContent())
            );
        }
        rootClass.setBody(new BootScript(this));
        scriptSpace_.addScriptClass(rootClass);
    }

    //
    private void setupResources_() {
        FCResource[] resources = fcConfig_.getResource();
        for (int i = 0;i < resources.length;i++) {
            FCResource resource = resources[i];
            String resourceName = resource.getName();
            if (resources_.containsKey(resourceName)) {
                logger_.warning(
                    "Resource '" + resourceName + "' is duplicated."
                );
                continue;
            }
            setupResource_(resource);
        }
    }

    private void setupResource_(FCResource resource) {
        String resourceName = resource.getName();
        IFCResourceChoice content = resource.getContent();
        if (content instanceof FCJdbcResource) {
        } else if (content instanceof FCDatasourceResource) {
        } else if (content instanceof FCJndiResource) {
        } else if (content instanceof FCFileResource) {
        } else if (content instanceof FCUrlResource) {
        } else if (content instanceof FCVariableResource) {
        } else {
            throw (new InternalError());
        }
    }

    //
    private void setupModels_() {
        FCModel[] models = fcConfig_.getModel();
        for (int i = 0;i < models.length;i++) {
            FCModel model = models[i];
            String modelName = model.getName();
            if (models_.containsKey(modelName)) {
                logger_.warning(
                    "Model '" + modelName + "' is duplicated."
                );
                continue;
            }
            setupModel_(model);
        }
    }

    private void setupModel_(FCModel model) {
        String modelName = model.getName();
        String javaClassName = getJavaClassName_(model);
        FCSlot[] slots = model.getSlot();
        Class modelClass;
        try {
            modelClass = classLoader_.loadClass(javaClassName);
            Map properties = new HashMap();
            for (int i = 0;i < slots.length;i++) {
                FCSlot slot = slots[i];
                String slotName = slot.getName();
                Object value = getValue_(slot);
                properties.put(slotName, value);
            }
            IRModel instance = externalResource_.newInstance(
                modelClass, properties, modelContext_);
            models_.put(modelName, instance);
            setupModelSlot_(modelName, instance);
        } catch (ClassNotFoundException e) {
            logger_.warning(
                "Model '" + modelName + "' can not be initialized, " +
                "because class '" + javaClassName + "' does not found.",
                e
            );
        } catch (InstantiationException e) {
            logger_.warning(
                "Model '" + modelName + "' can not be initialized, " +
                "because class '" + javaClassName + "' does not instantiated.",
                e
            );
        } catch (IllegalAccessException e) {
            logger_.warning(
                "Model '" + modelName + "' can not be initialized, " +
                "because illegal access is occured for class '" + javaClassName + "' .",
                e
            );
        } catch (NoSuchMethodException e) {
            logger_.warning(
                "Model '" + modelName + "' can not be initialized, " +
                "because class '" + javaClassName + "' does not have correct constructor.",
                e
            );
        } catch (InvocationTargetException e) {
            logger_.warning(
                "Model '" + modelName + "' can not be initialized, " +
                "because constructor throws a execption '" + e + "'.",
                e
            );
        }
    }

    private String getJavaClassName_(FCModel model) {
        IFCModelChoice content = model.getContent();
        if (content instanceof FCModelType) {
            FCModelType type = (FCModelType)content;
            String typeName = type.getContent();
            // TODO
            throw (new UnsupportedOperationException());
        } else if (content instanceof FCModelJavaClass) {
            FCModelJavaClass javaClass = (FCModelJavaClass)content;
            return (javaClass.getContent()); 
        } else {
            throw (new InternalError());
        }
    }

    private Object getValue_(FCSlot slot) { 
        IFCSlotMixed content = slot.getContent();
        if (content instanceof FCSlotValue) {
            FCSlotValue value = (FCSlotValue)content;
            return (value.getContent());
        } else if (content instanceof RString){
            RString value = (RString)content;
            return (value.getText());
        } else {
            throw (new InternalError());
        }
    }

    private void setupModelSlot_(String modelName, IRModel model) {
        scriptSpace_.addModelSlot(modelName, model);
    }

    //
    private void setupComponents_() {
        FCComponent[] components = fcConfig_.getComponent();
        List componentNames = new ArrayList();
        for (int i = 0;i < components.length;i++) {
            FCComponent component = components[i];
            String componentName = component.getName();
            if (components_.containsKey(componentName)) {
                logger_.warning(
                    "Component '" + componentName + "' is duplicated."
                );
                continue;
            }
            componentNames.add(componentName);
            try {
                Object instance = createComponentInstance_(component);
                if (instance != null) {
                    components_.put(componentName, instance);
                    setupComponentSlot_(componentName, instance);
                }
            } catch (IllegalArgumentException e) {
                setupComponents_warning_instantiate(e, componentName);
            } finally {
            }
        }
        Object[] names = componentNames.toArray();
        for (int i = 0;i < names.length;i++) {
            String componentName = (String)names[i];
            setupComponent_(componentName);
        }
    }

    private void setupComponents_warning_instantiate(
        Throwable e,
        String componentName
    ) {
        String message = "Component '" + componentName + "' can not be initialized."; 
        logger_.warning(message, e);
    }

    private void setupComponents_warning_setup(
        Throwable e,
        String componentName
    ) {
        String message = "Component '" + componentName + "' can not be setting up."; 
        logger_.warning(message, e);
    }

    private Object createComponentInstance_(FCComponent component) {
        String javaClassName = component.getJavaClass();
        Class componentClass = null;
        try {
            componentClass = classLoader_.loadClass(javaClassName);
        } catch (ClassNotFoundException e) {
            logger_.warning(
                "Java class '" + javaClassName + "' is not found.",
                e
            );
            return (null);
        }
        FCRealization realization = component.getRealization();
        if (realization == null) {
            try {
                return (componentClass.newInstance());
            } catch (InstantiationException e) {
                logger_.warning(
                    "Java class '" + javaClassName + "' can not be initialized. Probably null constructor is unavailable.",
                    e
                );
                return (null);
            } catch (IllegalAccessException e) {
                logger_.warning(
                    "Java class '" + javaClassName + "' can not be initialized.",
                    e
                );
                return (null);
            }
        }
        FCConstructor fcConstructor = realization.getConstructor();
        if (fcConstructor == null) {
            try {
                return (componentClass.newInstance());
            } catch (InstantiationException e) {
                logger_.warning(
                    "Java class " + javaClassName + " can not be initialized. Probably null constructor is unavailable.",
                    e
                );
                return (null);
            } catch (IllegalAccessException e) {
                logger_.warning(
                    "Java class '" + javaClassName + "' can not be initialized.",
                    e
                );
                return (null);
            }
        }
        String[] values = getValues_(fcConstructor);
        Constructor constructor = getConstructor_(componentClass, values);
        if (constructor == null) {
            String message = "Java class '" + javaClassName + "' can not be initialized, becauase constructor is not found."; 
            logger_.warning(message);
            return (null);
        }
        Class[] paramTypes = constructor.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0;i < paramTypes.length;i++) {
            Class type = paramTypes[i];
            // TODO
            params[i] = values[i]; // TODO
        }
        try {
            return (constructor.newInstance(params));
        } catch (IllegalArgumentException e) {
            createComponentInstance_warning_(e, javaClassName, params);
            return (null);
        } catch (InstantiationException e) {
            createComponentInstance_warning_(e, javaClassName, params);
            return (null);
        } catch (IllegalAccessException e) {
            createComponentInstance_warning_(e, javaClassName, params);
            return (null);
        } catch (InvocationTargetException e) {
            createComponentInstance_warning_(e, javaClassName, params);
            return (null);
        }
    }

    private void createComponentInstance_warning_(
        InvocationTargetException e, 
        String javaClassName,
        Object[] params
    ) {
        Throwable cause = e.getTargetException();
        if (cause == null) {
            cause = e;
        }
        logger_.warning(
            "Java class '" + javaClassName + "' can not be initialized.",
            params,
            cause
        );
    }

    private void createComponentInstance_warning_(
        Throwable e, 
        String javaClassName,
        Object[] params
    ) {
        logger_.warning(
            "Java class '" + javaClassName + "' can not be initialized.",
            params,
            e
        );
    }

    private String[] getValues_(FCConstructor fcConstructor) {
        List list = new ArrayList();
        IFCConstructorChoice[] params = fcConstructor.getParameters();
        for (int i = 0;i < params.length;i++) {
            IFCConstructorChoice param = params[i];
            if (param instanceof FCParametersValues) {
                FCParametersValues values = (FCParametersValues)param;
                list.addAll(Arrays.asList(values.getContent()));
            } else if (param instanceof FCValue) {
                FCValue value = (FCValue)param;
                list.add(value.getContent());
            }
        }
        String[] result = new String[list.size()];
        return ((String[])list.toArray(result));
    }

    private Constructor getConstructor_(Class componentClass, String[] values) {
        Constructor[] constructors = componentClass.getConstructors();
        for (int i = 0;i < constructors.length;i++) {
            Constructor constructor = constructors[i];
            if (values.length == constructor.getParameterTypes().length) {
                return (constructor);
            }
        }
        return (null);
    }

    private void setupComponent_(
        String componentName
    ) {
        FCComponent fcComponent
            = fcConfig_.getComponentByName(componentName);
        if (fcComponent == null) {
            logger_.warning(
                "Component '" + componentName + "' does not found in config."
            );
            return;
        }
        Object instance = components_.get(componentName);
        if (instance == null) {
            logger_.warning(
                "Instance of component '" + componentName + "' does not found."
            );
            return;
        }
        RComponentContext context = getComponentContext_(instance);
        if (context == null) {
            return;
        }
        context.setContainerContext(containerContext_);
        FCRealization fcRealization = fcComponent.getRealization();
        if (fcRealization == null) {
            return;
        }
        IFCComponentRefChoice[] cRefs = fcRealization.getComponentRef();
        for (int i = 0;i < cRefs.length;i++) {
            IFCComponentRefChoice cRef = cRefs[i];
            if (cRef instanceof FCJndiComponentRef) {
                setupJndiComponentRef_(
                    (FCJndiComponentRef)cRef,
                    instance,
                    context
                );
            } else if (cRef instanceof FCConfigComponentRef) {
                setupConfigComponentRef_(
                    (FCConfigComponentRef)cRef,
                    instance,
                    context
                );
            } else {
                throw (new InternalError());
            }
        }
        IFCModelRefChoice[] mRefs = fcRealization.getModelRef();
        for (int i = 0; i < mRefs.length; i++) {
            IFCModelRefChoice mRef = mRefs[i];
            if (mRef instanceof FCConfigModelRef) {
                setupConfigModelRef_(
                    (FCConfigModelRef)mRef,
                    instance,
                    context
                );
            } else {
                throw (new InternalError());
            }
        }
        IFCResourceRefChoice[] rRefs = fcRealization.getResourceRef();
        for (int i = 0;i < rRefs.length;i++) {
            IFCResourceRefChoice rRef = rRefs[i];
            if (rRef instanceof FCJndiResourceRef) {
                setupJndiResourceRef_(
                    (FCJndiResourceRef)rRef,
                    instance,
                    context
                );
            } else if (rRef instanceof FCConfigResourceRef) {
                setupConfigResourceRef_(
                    (FCConfigResourceRef)rRef,
                    instance,
                    context
                );
            } else {
                throw (new InternalError());
            }
        }
    }

    //
    private void setupJndiComponentRef_(
        FCJndiComponentRef ref,
        Object instance,
        RComponentContext context
    ) {
        throw (new UnsupportedOperationException()); // TODO
    }

    private void setupConfigComponentRef_(
        FCConfigComponentRef ref,
        Object instance,
        RComponentContext context
    ) {
        String roleName = ref.getRole();
        if (UString.isNull(roleName)) {
            logger_.warning(
                "Role for component can not be initialized, " +
                "because role name is undefined."
            );
            return;
        }
        String targetName = ref.getRef();
        if (UString.isNull(targetName)) {
            logger_.warning(
                "Role '" + roleName + "' can not be initialized, " +
                "because component name is undefined."
            );
            return;
        }
        Object targetComponent = components_.get(targetName);
        if (targetComponent == null) {
            logger_.warning(
                "Role '" + roleName + "' can not be initialized, " +
                "because component '" + targetName + "' is unavailable."
            );
            return;
        }
        setRole_(context, roleName, targetComponent);
    }

    private RComponentContext getComponentContext_(Object component) {
        Method getter = _findSetterMethod(component, "rGetContext");
        if (getter == null) {
            logger_.warning("rGetContext not found in " + component);
            return (null);
        }
        try {
            return ((RComponentContext)getter.invoke(component, new Object[0]));
        } catch (IllegalArgumentException e) {
            getComponentContext_warning_(e);
        } catch (IllegalAccessException e) {
            getComponentContext_warning_(e);
        } catch (InvocationTargetException e) {
            getComponentContext_warning_(e);
        }
        return (null);
    }

    private void getComponentContext_warning_(Throwable e) {
        logger_.warning("rGetContext is unavailable.", e);
    }

    //
    private void setupConfigModelRef_(
        FCConfigModelRef ref, 
        Object instance, 
        RComponentContext context
    ) {
        String roleName = ref.getRole();
        if (UString.isNull(roleName)) {
            logger_.warning(
                "Role for model can not be initialized, " +
                "because role name is undefined."
            );
            return;
        }
        String targetName = ref.getRef();
        if (UString.isNull(targetName)) {
            logger_.warning(
                "Role '" + roleName + "' can not be initialized, " +
                "because model name is undefined."
            );
            return;
        }
        Object targetModel = models_.get(targetName);
        if (targetModel == null) {
            logger_.warning(
                "Role '" + roleName + "' can not be initialized, " +
                "because model '" + targetName + "' is unavailable."
            );
            return;
        }
        setRole_(context, roleName, targetModel);
    }

    //
    private void setupJndiResourceRef_(
        FCJndiResourceRef ref,
        Object instance,
        RComponentContext context
    ) {
        String roleName = ref.getRole();
        String javaType = ref.getJavaType();
        String jndiName = ref.getJndiName();
        Context ctx = null;
        try {
            ctx = new InitialContext();
        } catch (NamingException e) {
            logger_.error("Jndi context is unavailable.", e);
            return;
        }
        if (ctx == null) {
            logger_.error("No jndi root context");
        }
        Object targetResource = null;
        try {
            targetResource = ctx.lookup(jndiName);
        } catch (NamingException e) {
            logger_.error("Jndi name '" + jndiName + "' is unavailable.", e);
            return;
        }
        if (targetResource == null) {
            logger_.warning("Jndi: " + jndiName + " is empty.");
        } else {
            logger_.config("Jndi: " + jndiName + "->" + targetResource);
        }
        setRole_(context, roleName, targetResource);
    }

    private void setupConfigResourceRef_(
        FCConfigResourceRef ref,
        Object instance,
        RComponentContext context
    ) {
        String roleName = ref.getRole();
        if (UString.isNull(roleName)) {
            logger_.warning(
                "Role for resource can not be initialized, " +
                "because role name is undefined."
            );
            return;
        }
        String targetName = ref.getRef();
        if (UString.isNull(targetName)) {
            logger_.warning(
                "Role '" + roleName + "' can not be initialized, " +
                "because resource name is undefined."
            );
            return;
        }
        Object targetResource = resources_.get(targetName);
        if (targetResource == null) {
            logger_.warning(
                "Role '" + roleName + "' can not be initialized, " +
                "because resource '" + targetName + "' is unavailable."
            );
            return;
        }
        setRole_(context, roleName, targetResource);
    }

    //
    private void setRole_(
        RComponentContext context,
        String roleName,
        Object target
    ) {
        Method setter = null;
        String setterName = null;
        try {
            setterName = "setRole" + UString.capitalize(roleName);
            setter = _findSetterMethod(context, setterName);
            if (setter == null) {
                logger_.info(
                    setterName + " method is not found in " + target + ". Probably " + target + " is not the Relaxer Component."
                );
                return;
            }
            setter.invoke(context, new Object[] { target });
        } catch (IllegalArgumentException e) {
            logger_.warning(
                setterName + " method is not available in " + target + 
                ". Probably " + target + " is not the Relaxer Component or the configuration for RelaxerFramework is broken."
            );
        } catch (IllegalAccessException e) {
            logger_.warning(
                setterName + " method is not available in " + target + 
                ". Probably " + target + " is not the Relaxer Component."
            );
        } catch (InvocationTargetException e) {
            Throwable exception = e.getTargetException();
            if (exception == null) {
                exception = e;
            }
            logger_.warning(
                setterName + " method throws exception " + exception.getClass() + 
                "(" + exception.getMessage() + ") in " + target + ".",
                exception
            );
        }
    }

    private Method _findSetterMethod(Object component, String setterName) {
        Method[] methods = component.getClass().getMethods();
        for (int i = 0;i < methods.length;i++) {
            Method method = methods[i];
            if (setterName.equals(method.getName())) {
                return (method);
            }
        }
        return (null);
    }

    private void setupComponentSlot_(
        String componentName, 
        Object component
    ) {
        scriptSpace_.addComponentSlot(componentName, component);
    }

    //
    private void setupServices_() throws RelaxerFrameworkException {
        IFCServiceChoice[] services = fcConfig_.getService();
        for (int i = 0;i < services.length;i++) {
            IFCServiceChoice service = services[i];
            if (service instanceof FCComponentService) {
                setupService_((FCComponentService)service);
            } else if (service instanceof FCScriptService) {
                setupService_((FCScriptService)service);
            } else {
                throw (new InternalError());
            }
        }
        if (mainService_ == null) {
            mainService_ = makeUsageService_();
            FCOperation operation = new FCOperation();
            operation.setName("usage");
            setupServiceScriptClass_(
                mainService_.name,
                mainService_.name,
                operation,
                null
            );
            services_.put(mainService_.name, mainService_);
        }
    }

    private void setupService_(FCComponentService fcService) throws RelaxerFrameworkException {
        String serviceName = fcService.getName();
        FCComponent fcComponent = _getFCComponent(fcService);
        if (fcComponent == null) {
            logger_.warning(
                "service '" + serviceName + "' can not be initialized, " +
                "because component '" + fcService.getComponent() + "' is unavailable."
            );
            return;
        }
        FCOperation fcOperation = _getFCOperation(fcService, fcComponent);
        if (fcOperation == null) {
            logger_.warning(
                "service '" + serviceName + "' can not be initialized, " +
                "because operation '" + fcService.getOperation() + "' is unavailable."
            );
            return;
        }
        FCVariable[] fcVariables = _getFCVariables(fcService, fcComponent);
        String componentName = fcComponent.getName();
        setupServiceScriptClass_(
            serviceName,
            componentName, 
            fcOperation,
            fcVariables
        );
        Object component = _getComponentInstance(componentName);
        if (component == null) {
            logger_.warning(
                "Service '" + serviceName + "' can not be initialized, " +
                "because component '" + componentName + "' is unavailable."
            );
            return;
        }
        Method method;
        try {
            method = _getMethod(component.getClass(), fcOperation);
            if (method == null) {
                logger_.warning(
                    "Service '" + serviceName + "' can not be initialized, " + "" +
                    "because method '" + fcOperation.getName() + 
                    "' in component '" + componentName + "' is unavailable."
                );
                return;
            }
            Method[] varMethods = _getVariableMethod(component.getClass(), fcVariables);
            Service service = new Service(
                serviceName,
                component, 
                method, 
                varMethods
            );
            services_.put(serviceName, service);
            if (ROLE_MAIN.equals(fcService.getRole())) {
                mainService_ = service;
            }
        } catch (NoSuchMethodException e) {
            logger_.warning(
                "Service '" + serviceName + "' can not be initialized, " + "" +
                "because method '" + fcOperation.getName() + 
                "' in component '" + componentName + "' is unavailable."
            );
        }
    }

    private void setupServiceScriptClass_(
        String serviceName,
        String componentName,
        FCOperation fcOperation, 
        FCVariable[] fcVariables
    ) throws RelaxerFrameworkException {
        ScriptClass serviceClass = new ScriptClass(serviceName, scriptSpace_);
        FCComponentAction action = configFactory_.createFCComponentAction();
        action.setRef(componentName);
        action.setOperation(fcOperation.getName());
        FCOperationIn[] ins = fcOperation.getOperationIn();
        for (int i = 0;i < ins.length;i++) {
            FCOperationIn in = ins[i];
            setupServiceScriptClassIn_(serviceClass, action, in, i);
        }
        FCOperationOut out = fcOperation.getOperationOut();
        if (out != null) {
            setupServiceScriptClassOut_(serviceClass, action, out);
        }
        if (fcVariables != null) {
            for (int i = 0;i < fcVariables.length;i++) {
                FCVariable var = fcVariables[i];
                setupServiceScriptClassVar_(var);
            }
        }
        DefaultScript body = new DefaultScript(action);
        serviceClass.setBody(body);
        scriptSpace_.addScriptClass(serviceClass);
    }

    private void setupServiceScriptClassIn_(
        ScriptClass serviceClass,
        FCComponentAction action,
        FCOperationIn in,
        int i
    ) throws RelaxerFrameworkException {
        String javaType = in.getJavaType();
        String inName = in.getName();
        if (inName == null) {
            inName = "argument" + (i + 1);
        }
        try {
            IDatatype datatype = datatypeFactory_.getDatatype(javaType);
            Slot slot = new Slot(inName, datatype);
            serviceClass.addSlot(slot);
            FCActionIn actionIn = new FCActionIn();
            actionIn.setName(inName);
            FCActionInPeek peek = new FCActionInPeek();
            peek.setContent(inName);
            actionIn.setContent(peek);
            action.addActionIn(actionIn);
        } catch (ClassNotFoundException e) {
            warningException_(
                "java.type '" + javaType + "' in out '" + inName + "' is unavailable",
                e
            );
        }
    }

    private void setupServiceScriptClassOut_(
        ScriptClass serviceClass,
        FCComponentAction action,
        FCOperationOut out
    ) throws RelaxerFrameworkException {
        String javaType = out.getJavaType();
        String outName = out.getName();
        if (outName == null) {
            outName = IScriptConstants.SYSTEM_RESULT;
        }
        try {
            Slot slot = new Slot(outName, datatypeFactory_.getDatatype(javaType));
            serviceClass.addSlot(slot);
            FCActionOut actionOut = new FCActionOut();
            actionOut.setName(outName);
            FCActionOutPoke poke = new FCActionOutPoke();
            poke.setContent(outName);
            actionOut.setContent(poke);
            action.setActionOut(actionOut);
        } catch (ClassNotFoundException e) {
            warningException_(
                "java.type '" + javaType + "' in out '" + outName + "' is unavailable",
                e
            );
        }
    }

    private void setupServiceScriptClassVar_(
        FCVariable var
    ) throws RelaxerFrameworkException {
        String javaType = var.getJavaType();
        String varName = var.getName();
        try {
            Slot slot = new Slot(
                varName, 
                datatypeFactory_.getDatatype(javaType)
            );
        } catch (ClassNotFoundException e) {
            warningException_(
                "java.type '" + javaType + "' in variable '" + varName + "' is unavailable",
                e
            );
        }
    }

    private void setupService_(FCScriptService service) {
        // TODO Auto-generated method stub
        throw (new UnsupportedOperationException()); // TODO
    }
    
    private Service makeUsageService_() {
        UsageService service = new UsageService();
        components_.put(SERVICE_SYSTEM_USAGE, service);
        setupComponentSlot_(SERVICE_SYSTEM_USAGE, service);
        try {
            Method method = service.getClass().getMethod("usage", new Class[0]);
            return (
                new Service(
                    SERVICE_SYSTEM_USAGE,
                    service,
                    method,
                    null
                )
            );
        } catch (SecurityException e) {
            throw (new RelaxerFrameworkErrorException(e));
        } catch (NoSuchMethodException e) {
            throw (new RelaxerFrameworkErrorException(e));
        }
    }

    //
    private void setupOptions_() throws RelaxerFrameworkException {
        IFCOptionsChoice[] options = fcConfig_.getOptions();
        for (int i = 0;i < options.length;i++) {
            IFCOptionsChoice option = options[i];
            if (option instanceof FCOptionSet) {
                setupOption_((FCOptionSet)option);
            } else if (option instanceof FCComponentOption) {
                setupOption_((FCComponentOption)option);
            } else if (option instanceof FCSystemOption) {
                setupOption_((FCSystemOption)option);
            } else {
                throw (new InternalError());
            }
        }
    }

    private void setupOption_(FCOptionSet fcOptionSet)
      throws RelaxerFrameworkException {
        throw (new UnsupportedOperationException());
    }

    private void setupOption_(FCComponentOption fcOption)
      throws RelaxerFrameworkException {
        String optionName = fcOption.getName();
        FCComponent fcComponent = _getFCComponent(fcOption);
        if (fcComponent == null) {
            logger_.warning(
                "option '" + optionName + "' can not be initialized, " +
                "because component '" + fcOption.getComponent() + "' is unavailable."
            );
            return;
        }
        FCAttribute fcAttribute = _getFCAttribute(fcOption, fcComponent);
        if (fcAttribute == null) {
            logger_.warning(
                "option '" + optionName + "' can not be initialized, " +
                "because attribute '" + fcOption.getAttribute() + "' is unavailable."
            );
            return;
        }
        String componentName = fcComponent.getName();
        setupOptionScriptClass_(
            optionName,
            componentName, 
            fcAttribute
        );
        Object component = _getComponentInstance(componentName);
        if (component == null) {
            logger_.warning(
                "Option '" + optionName + "' can not be initialized, " +
                "because component '" + componentName + "' is unavailable."
            );
            return;
        }
        Method getter = _getGetter(component.getClass(), fcAttribute);
        if (getter == null) {
            logger_.warning(
                "Option '" + optionName + "' can not be initialized, " + "" +
                "because method '" + fcAttribute.getName() + 
                "' in component '" + componentName + "' is unavailable."
            );
            return;
        }
        Method setter = _getSetter(component.getClass(), fcAttribute);
        if (setter == null) {
            logger_.warning(
                "Option '" + optionName + "' can not be initialized, " + "" +
                "because method '" + fcAttribute.getName() + 
                "' in component '" + componentName + "' is unavailable."
            );
            return;
        }
        Option option = new Option(
            optionName,
            component, 
            getter,
            setter 
        );
        options_.put(optionName, option);
    }

    private Method _getGetter(Class target, FCAttribute fcAttribute) {
        String attrName = UString.capitalize(fcAttribute.getName());
        String methodName = "get" + attrName;
        Method[] methods = target.getMethods();
        for (int i = 0;i < methods.length;i++) {
            Method method = methods[i];
            if (methodName.equals(method.getName()) &&
                method.getParameterTypes().length == 0) {
                return (method);
            }
        }
        return (null);
    }

    private Method _getSetter(Class target, FCAttribute fcAttribute) {
        String attrName = UString.capitalize(fcAttribute.getName());
        String methodName = "set" + attrName;
        Method[] methods = target.getMethods();
        for (int i = 0;i < methods.length;i++) {
            Method method = methods[i];
            if (methodName.equals(method.getName()) &&
                method.getParameterTypes().length == 1) {
                return (method);
            }
        }
        return (null);
    }

    private void setupOptionScriptClass_(
        String optionName, 
        String componentName, 
        FCAttribute fcAttribute
    ) throws RelaxerFrameworkException {
        ScriptClass optionClass = new ScriptClass(optionName, scriptSpace_);
        FCComponentAction action = configFactory_.createFCComponentAction();
        action.setRef(componentName);
        action.setOperation(fcAttribute.getName());
        setupOptionScriptClassIn_(optionClass, action, fcAttribute);
        setupOptionScriptClassOut_(optionClass, action, fcAttribute);
        DefaultScript body = new DefaultScript(action);
        optionClass.setBody(body);
        scriptSpace_.addScriptClass(optionClass);
    }

    private void setupOptionScriptClassIn_(
        ScriptClass optionClass,
        FCComponentAction action,
        FCAttribute attr
    ) throws RelaxerFrameworkException {
        String javaType = attr.getJavaType();
        String inName = attr.getName();
        if (inName == null) {
            throw (new UnsupportedOperationException());
        }
        try {
            IDatatype datatype = datatypeFactory_.getDatatype(javaType);
            Slot slot = new Slot(inName, datatype);
            optionClass.addSlot(slot);
            FCActionIn actionIn = new FCActionIn();
            actionIn.setName(inName);
            FCActionInPeek peek = new FCActionInPeek();
            peek.setContent(inName);
            actionIn.setContent(peek);
            action.addActionIn(actionIn);
        } catch (ClassNotFoundException e) {
            warningException_(
                "java.type '" + javaType + "' in out '" + inName + "' is unavailable",
                e
            );
        }
    }

    private void setupOptionScriptClassOut_(
        ScriptClass optionClass,
        FCComponentAction action,
        FCAttribute attr
    ) throws RelaxerFrameworkException {
        String javaType = attr.getJavaType();
        String outName = attr.getName();
        if (outName == null) {
            throw (new UnsupportedOperationException());
        }
        try {
            Slot slot = new Slot(outName, datatypeFactory_.getDatatype(javaType));
            optionClass.addSlot(slot);
            FCActionOut actionOut = new FCActionOut();
            actionOut.setName(outName);
            FCActionOutPoke poke = new FCActionOutPoke();
            poke.setContent(outName);
            actionOut.setContent(poke);
            action.setActionOut(actionOut);
        } catch (ClassNotFoundException e) {
            warningException_(
                "java.type '" + javaType + "' in out '" + outName + "' is unavailable",
                e
            );
        }
    }

    private void setupOption_(FCSystemOption option) {
        throw (new UnsupportedOperationException());
    }

    //
    private void setupDialog_() {
        FCDialog dialog = fcConfig_.getDialog();
        if (dialog == null) {
            // do nothing
        } else {
            dialog_ = new DefaultDialog(dialog, this);
        } 
    }

    //
    private void execute_(IParameterParser parser) throws ScriptException {
        executeScript_();
    }

    private void executeOld_(IParameterParser parser)
        throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            ParserConfigurationException, 
            RelaxerFrameworkException, InvocationTargetException, IOException {

        if (dialog_ != null) {
            infoVersion_();
            currentScene_ = dialog_.getOpening();
            _executeDialog(parser);
        } else if (service_ != null) {
            infoVersion_();
            executeService_(parser);
        } else if (tsTestCase_ != null) {
            infoVersion_();
            _executeTest(parser);
        } else if (mainService_ != null) {
            infoVersion_();
            executeService_(parser);
        } else {
            showUsage_();
            System.out.println("  for more information, use --help option");
        }
    }

    // Script
    private void executeScript_() throws ScriptException {
        ScriptEngine engine = new ScriptEngine(this);
        engine.execute(parser_);
    }

    // Service
    private Object executeService_(IParameterParser parser)
      throws RelaxerFrameworkException {
        return (executeService_(service_, parser));
    }

    private Object executeService_(String serviceName, IParameterParser parser)
      throws RelaxerFrameworkException {
        logger_.config("Start service execution.");
        Service service = _getService(serviceName);
        if (service == null) {
            logger_.warning("Service '" + serviceName + "' is unavailable.");
            throw (
                new RelaxerFrameworkException(
                    "Service '" + serviceName + "' is unavailable."
                )
            );
        }
        try {
            setVariables_(service, parser);
            Object component = service.component;
            Method method = service.method;
            Object[] parameters = parser.getParameters();
            parameters = importParameters_(method, parameters);
            Object result = method.invoke(component, parameters);
            exportResult_(result);
            logger_.config("End service execution.");
            return (result);
        } catch (IllegalAccessException e) {
            throw (executeService_error_(serviceName, e));
        } catch (InvocationTargetException e) {
            throw (executeService_error_(serviceName, e));
        } catch (IOException e) {
            throw (executeService_error_(serviceName, e));
        }
    }

    private RelaxerFrameworkException executeService_error_(
        String serviceName,
        Throwable e
    ) {
        logger_.warning("Service '" + serviceName + "' is unavailable.");
        return (
            new RelaxerFrameworkException(
                "Service '" + serviceName + "' is unavailable.",
                e
            )
        );
    }

    private void setVariables_(Service service, IParameterParser parser)
      throws RelaxerFrameworkException {
        if (service.varMethods == null) {
            return;
        }
        for (int i = 0;i < service.varMethods.length;i++) {
            Method method = service.varMethods[i];
            String varName = UString.uncapitalize(method.getName().substring(3));
            String value = parser.getProperty(varName);
            if (value != null) {
                try {
                    Object param = UImporter.getParameter(value, method.getParameterTypes()[0]);
                    try {
                        method.invoke(service.component, new Object[] { param });
                    } catch (IllegalArgumentException ee) {
                        throw (setValiables_error_invoke_(ee));
                    } catch (IllegalAccessException ee) {
                        throw (setValiables_error_invoke_(ee));
                    } catch (InvocationTargetException ee) {
                        throw (setValiables_error_invoke_(ee));
                    }
                } catch (RelaxerFrameworkException e) {
                    logger_.error(e.getMessage(), e);
                    throw (e);
                }
            }
        }
    }

    private RelaxerFrameworkException setValiables_error_invoke_(Throwable e) {
        String message = "TODO";
        logger_.warning(message, e); // TODO
        return (new RelaxerFrameworkException(message, e));
    }

    // TODO integrate service script. (with data conversion)
    private Object invokeService_(
        String serviceName, 
        Object[] parameters,
        Map attributes
    ) throws RelaxerFrameworkException {
        Service service = _getService(serviceName);
        if (service == null) {
            warningException_("Service '" + serviceName + "' is unavailable.");
            return (null);
        }
        setVariables_(service, attributes);
        Object component = service.component;
        Method method = service.method;
        if (parameters == null) {
            parameters = new String[0];
        }
        parameters = importParameters_(method, parameters);
        try {
            logger_.entering(component, method.getName(), parameters);
            Object result = method.invoke(component, parameters);
            logger_.exiting(component, method.getName(), result);
            exportResult_(result);
            return (result);
        } catch (Exception e) {
            throw (invokeService_error_(e, serviceName));
        }
    }

    private RelaxerFrameworkException invokeService_error_(
        Throwable e,
        String service
    ) {
        String message = "Can not invoke service '" + service + "'.";
        logger_.error(message, e);
        return (new RelaxerFrameworkException(message, e));
    }

    private void setVariables_(Service service, Map attributes) { 
        if (attributes == null) {
            return;
        }
        if (service.varMethods == null) {
            return;
        }
        for (int i = 0;i < service.varMethods.length;i++) {
            Method method = service.varMethods[i];
            String varName = UString.uncapitalize(method.getName().substring(3));
            Object value = attributes.get(varName);
            if (value != null) {
                try {
                    Object param = UImporter.getParameter(value, method.getParameterTypes()[0]);
                    method.invoke(service.component, new Object[] { param });
                } catch (IllegalAccessException e) {
                    setVariables_error_(e);
                } catch (InvocationTargetException e) {
                    setVariables_error_(e);
                } catch (ImporterException e) {
                    setVariables_error_(e);
                } finally {
                }
            }
        }
    }

    private void setVariables_error_(Throwable e) {
        String message = "setVariable";
        logger_.warning(message, e);
    }

    // Dialog
    private void _executeDialog(IParameterParser parser) {
        logger_.config("Start dialog execution.");
        for (;;) {
            IPullPresentation presentation = new DefaultConsolePresentation();
            presentation.setPresentationCase(
                currentScene_.getPresentationCase());
            presentation.setPresentationState(
                currentScene_.getPresentationState());
            if (presentation == null) {
                break;
            }
            IScenario scenario = presentation.execute();
            if (scenario != null) {
                _executeScenario(scenario);
            }
        }
        logger_.config("End dialog execution.");
    }

    private void _executeScenario(IScenario scenario) {
        currentScene_ = currentScene_.execute(scenario);
    }

    // Test
    private void _executeTest(IParameterParser parser) throws IOException, ParserConfigurationException {
        if (junit_) {
            _generateJUnitTestCase(parser);
        } else {
            _executeTestScript(parser);
        }
    }

    private void _generateJUnitTestCase(IParameterParser parser)
        throws IOException, ParserConfigurationException {
        TSTest[] tests = tsTestCase_.getTest();
        StringBuffer buffer = new StringBuffer();
        if (junitPackage_ != null) {
            buffer.append("package ");
            buffer.append(junitPackage_);
            buffer.append(";\n");
        }
        buffer.append("import java.io.IOException;\n");
        buffer.append("import java.lang.reflect.InvocationTargetException;\n");
        buffer.append("import javax.xml.parsers.ParserConfigurationException;\n");
        buffer.append("import javax.naming.NamingException;\n");
        buffer.append("import org.xml.sax.SAXException;\n");
        buffer.append("import org.relaxer.framework.RelaxerFramework;\n");
        buffer.append("import org.relaxer.framework.RelaxerFrameworkException;\n");
        buffer.append("import org.relaxer.framework.testScript.rTestScript.REvaluationException;\n");
        buffer.append("import junit.framework.TestCase;\n");
        buffer.append("\n");
        buffer.append("public class ");
        buffer.append(_capitalize(_getProjectName()));
        buffer.append("Test extends TestCase {\n");
        _generateJUnitTest(tests, buffer);
        buffer.append("}\n");
        _outputJunitCode(new String(buffer));
    }

    private void _generateJUnitTest(TSTest[] tests, StringBuffer buffer) throws ParserConfigurationException {
        for (int i = 0; i < tests.length; i++) {
            TSTest test = tests[i];
            _generateJUnitTest(test, i + 1, buffer);
        }
    }

    private void _generateJUnitTest(TSTest test, int n, StringBuffer buffer) throws ParserConfigurationException {
        buffer.append("    ");
        buffer.append("public void test");
        buffer.append(n);
        buffer.append("() throws RelaxerFrameworkException, IOException, InvocationTargetException {\n");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("String[] args = {\n");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("\"--config:");
        if (true) {
            _makeConfigString(buffer);
        } else {
            buffer.append(configName_);
        }
        buffer.append("\", \n");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("\"--test:");
        if (true) {
            _makeTestScriptString(buffer);
        } else {
            buffer.append(testCaseName_);
        }
        buffer.append("\"\n");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("};\n");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append(
            "RelaxerFramework framework = new RelaxerFramework(args);\n");
        buffer.append("    ");
        buffer.append("    ");
        buffer.append("framework.executeTestScript(");
        buffer.append(n);
        buffer.append(");\n");
        buffer.append("    ");
        buffer.append("}\n");
    }

    private void _makeConfigString(StringBuffer buffer) throws ParserConfigurationException {
        buffer.append(UXMLMaker.getJavaString(fcConfig_.makeDocument()));
    }

    private void _makeTestScriptString(StringBuffer buffer) throws ParserConfigurationException {
        buffer.append(UXMLMaker.getJavaString(tsTestCase_.makeDocument()));
    }

    private void _outputJunitCode(String code) throws IOException {
        String projectName = _getProjectName();
        String fileName = _capitalize(projectName) + "Test.java";
        if (junitDir_ != null) {
            if (junitDirPackage_) {
                File dir = new File(junitDir_ + "/" + 
                                    junitPackage_.replace('.', '/'));
                dir.mkdirs();                
                fileName = dir.toString() + "/" + fileName;
            } else {
                new File(junitDir_).mkdirs();
                fileName = junitDir_ + "/" + fileName;
            }
        } else {
            if (junitDirPackage_) {
                File dir = new File(junitPackage_.replace('.', '/'));
                dir.mkdirs();                
                fileName = dir.toString() + "/" + fileName;
            }
        }
        Writer writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(code);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
        }
    }

    private void _executeTestScript(IParameterParser parser) {
        logger_.config("Start test execution.");
        TSTest[] tests = tsTestCase_.getTest();
        int total = tests.length;
        int success = 0;
        int fail = 0;
        for (int i = 0; i < tests.length; i++) {
            TSTest test = tests[i];
            try {
                _executeTestScript(test);
                success++;
            } catch (REvaluationException e) {
                fail++;
            }
        }
        String message
            = "Total: " + total + "  Success: " + success + "  Fail: " + fail;
        logger_.info(message);
        logger_.config("End test execution.");
    }

    private void _executeTestScript(TSTest test) throws REvaluationException {
        FTSEvaluationContext context = new FTSEvaluationContext(this);
        TSBody tsBody = test.getBody();
        Object result = tsBody.eval(context);
    }

    //
    private FCComponent _getFCComponent(FCComponentService fcService) {
        String componentName = fcService.getComponent();
        return (fcConfig_.getComponentByName(componentName));
    }

    private FCComponent _getFCComponent(FCComponentOption fcOption) {
        String componentName = fcOption.getComponent();
        return (fcConfig_.getComponentByName(componentName));
    }

    private FCOperation _getFCOperation(
        FCComponentService fcService,
        FCComponent fcComponent
    ) {
        String operationName = fcService.getOperation();
        return (fcComponent.getOperationByName(operationName));
    }

    private FCAttribute _getFCAttribute(
        FCComponentOption fcOption, 
        FCComponent fcComponent
    ) {
        String attributeName = fcOption.getAttribute();
        return (fcComponent.getAttributeByName(attributeName));
    }

    private FCVariable[] _getFCVariables(
        FCComponentService fcService, 
        FCComponent fcComponent
    ) {
        FCExtension fcExtension = fcComponent.getExtension();
        if (fcExtension == null) {
            return (null);
        }
        return (fcExtension.getVariable());
    }

    private Method _getMethod(Class component, FCOperation fcOperation)
        throws NoSuchMethodException {
        String methodName = fcOperation.getName();
        FCOperationIn[] ins = fcOperation.getOperationIn();
        Method[] methods = component.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (methodName.equals(method.getName())
                && ins.length == method.getParameterTypes().length) {

                return (method);
            }
        }
        return (null);
    }

    private Method[] _getVariableMethod(Class targetClass, FCVariable[] fcVariables) {
        if (fcVariables == null) {
            return (null);
        }
        List list = new ArrayList();
        for (int i = 0;i < fcVariables.length;i++) {
            Method method = _getVariableMethod(targetClass, fcVariables[i]);
            if (method != null) {
                list.add(method);
            } else {
                logger_.warning(
                    "No variable '" + fcVariables[i].getName() + 
                    "' in the target class '" + targetClass + "'."
                );
            }
        }
        Method[] result = new Method[list.size()];
        return ((Method[])list.toArray(result));
    }

    private Method _getVariableMethod(Class targetClass, FCVariable fcVariable) {
        String methodName = "set" + UString.capitalize(fcVariable.getName());
        Method[] methods = targetClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (methodName.equals(method.getName())
                && method.getParameterTypes().length == 1) {

                return (method);
            }
        }
        return (null);
    }

    // importer
    private Object[] importParameters_(Method method, Object[] objects)
      throws RelaxerFrameworkException {
        ImporterFactory factory = ImporterFactory.newInstance(modelContext_);
        IImporter importer = factory.getImporter(importer_);
        return (importer.importParameters(method, objects));
    }

    // exporter
    private void exportResult_(Object result) throws ExporterException {
        if (result != null) {
            ExporterFactory factory = ExporterFactory.newInstance(modelContext_);
            ExportResource resource = new ExportResource();
            resource.addObject(result);
            if (exporterDirectory_ == null) {
                resource.setDirectory(new File(System.getProperty("user.dir")));
            } else {
                resource.setDirectory(new File(exporterDirectory_));
            }
            IExporter exporter = factory.getExporter(exporter_);
            exporter.exportResource(resource);
        }
    }

    //
    private String _getProjectName() {
        int index = configName_.lastIndexOf("/");
        String fileName;
        if (index == -1) {
            fileName = configName_;
        } else {
            fileName = configName_.substring(index + 1);
        }
        index = fileName.lastIndexOf(".");
        if (index == -1) {
            return (fileName);
        } else {
            return (fileName.substring(0, index));
        }
    }

    private String _capitalize(String text) {
        char[] chars = text.toCharArray();
        if (chars.length > 0) {
            chars[0] = Character.toUpperCase(chars[0]);
        }
        return (new String(chars));
    }

    private void warningException_(
        String message 
    ) throws RelaxerFrameworkException {
        logger_.warning(message);
        throw (new RelaxerFrameworkException(message));
    }

    private void warningException_(
        String message, 
        ClassNotFoundException e
    ) throws RelaxerFrameworkException {
        logger_.warning(message);
        throw (new RelaxerFrameworkException(message, e));
    }

    /*
        private Object _execute(
    	Object object,
    	Method method,
    	Object[] parameters
        ) throws IllegalAccessException, InvocationTargetException {
    System.out.print("_execute(");
    for (int i = 0;i < parameters.length;i++) {
        System.out.print(" ");
        System.out.print(parameters[i]);
    }
    System.out.println(")\n");
    	return (method.invoke(object, parameters));
        }
    */

    static class Service {
        String name;
        Object component;
        Method method;
        Method[] varMethods;

        public Service(
            String name,
            Object component, 
            Method method, 
            Method[] varMethods
        ) {
            this.name = name;
            this.component = component;
            this.method = method;
            this.varMethods = varMethods;
        }
    }

    static class Option {
        String name;
        Object component;
        Method getter;
        Method setter;

        public Option(
            String name,
            Object component, 
            Method getter,
            Method setter
        ) {
            this.name = name;
            this.component = component;
            this.getter = getter;
            this.setter = setter;
        }
    }
   
    public class UsageService {
        public void usage() {
            usageError_();
        }
    }
    
    // facade
    public IRModelContext getModelContext() {
        return modelContext_;
    }

    public void importContext(String context) {
    }
    
    public String exportContext() {
        return ("");
    }

    public void create() {
    }

    public void activate() {
    }

    public void passivate() {
    }

    public void remove() {
    }

    // context 
    public ClassLoader getClassLoader() {
        return (classLoader_);
    }

    public DocumentBuilder getDocumentBuilder() {
        return (builder_);
    }

    public SAXParser getSAXParser() {
        return saxParser_;
    }

    public XMLReader getXMLReader() {
        return xmlReader_;
    }

    public IRFrameworkLogger getLogger() {
        return (logger_);
    }

    public Locale getLocale() {
        if (locale_ == null) {
            return (Locale.getDefault()); 
        } else {
            return (ULocale.makeLocale(locale_));
        }
    }
    
    public String getNewLine() {
        if (newLine_ == null) {
            return System.getProperty("line.separator"); // XXX : security
        }
        String symbol = newLine_.toUpperCase();
        if ("LF".equals(symbol)) {
            return ("\n");
        } else if ("CR".equals(symbol)) {
            return ("\r");
        } else if ("CRLF".equals(symbol)) {
            return ("\r\n");
        } else {
            return newLine_;
        }
    }

    public Object getComponent(String name) {
        return (_getComponentInstance(name));
    }

    public ScriptSpace getScriptSpace() {
        return (scriptSpace_);
    }

    public DatatypeFactory getDatatypeFactory() {
        return (datatypeFactory_);
    }

    public IParameterParser getParameterParser() {
        return (parser_);
    }

    public String getExporter() {
        return (exporter_);
    }

    public String getExporterDirectory() {
        return (exporterDirectory_);
    }
    
    public String getExporterEncoding() {
        return (exporterEncoding_);
    }

    public String getExporterName() {
        return exporterName_;
    }

    public String getExporterOutput() {
        return exporterOutput_;
    }

    public String getExporterSuffix() {
        return exporterSuffix_;
    }

    public String getProjectName() {
        String[] args = parser_.getParameters();
        if (args == null || args.length == 0) {
            return ("artifact"); // TODO
        } else {
            return (UString.getLastComponentBody(args[0]));
        }
    }

    public String getMainService() {
        return (mainService_.name);
    }

    public Class getJavaClass(String name) throws ClassNotFoundException {
        return (classLoader_.loadClass(name));
    }

    public void rtoSetup(Object rto, IJdbcConfig rdbmsConfig)
      throws RelaxerRuntimeException {
        String quoteId = rdbmsConfig.getQuoteId();
        setQuote_(rto, "setQuoteId", quoteId);
        String quoteWhere = rdbmsConfig.getQuoteWhere();
        setQuote_(rto, "setQuoteWhere", quoteWhere);
        String quoteIdInWhere = rdbmsConfig.getQuoteIdInWhere();
        setQuote_(rto, "setQuoteIdInWhere", quoteIdInWhere);
        setTypeMappings_(rto, rdbmsConfig.getTypeMappings());
    }

    private void setQuote_(Object rto, String methodName, String quote)
      throws RelaxerRuntimeException {
        Class clazz = rto.getClass();
        try {
            Method method = clazz.getMethod(
                methodName, 
                new Class[] { String.class }
            );
            method.invoke(rto, new Object[] { quote });
        } catch (IllegalArgumentException e) {
            throw (setQuote_error_(e));
        } catch (IllegalAccessException e) {
            throw (setQuote_error_(e));
        } catch (InvocationTargetException e) {
            throw (setQuote_error_(e));
        } catch (SecurityException e) {
            throw (setQuote_error_(e));
        } catch (NoSuchMethodException e) {
            throw (setQuote_error_(e));
        }
    }

    private RelaxerRuntimeException setQuote_error_(Throwable e) {
        String message = "Illegal Relaxer Table Object.";
        logger_.warning(message, e);
        return (new RelaxerRuntimeException(message, e));
    }

    private void setTypeMappings_(Object rto, Map mappings)
      throws RelaxerRuntimeException {
        Class clazz = rto.getClass();
        try {
            Method method = clazz.getMethod(
                "setDatatypes",
                new Class[] { Map.class }
            );
            method.invoke(rto, new Object[] { mappings });
        } catch (IllegalArgumentException e) {
            throw (setTypeMappings_error_(e));
        } catch (IllegalAccessException e) {
            throw (setTypeMappings_error_(e));
        } catch (InvocationTargetException e) {
            throw (setTypeMappings_error_(e));
        } catch (SecurityException e) {
            throw (setTypeMappings_error_(e));
        } catch (NoSuchMethodException e) {
            throw (setTypeMappings_error_(e));
        }
    }

    private RelaxerRuntimeException setTypeMappings_error_(Throwable e) {
        String message = "Illegal Relaxer Table Object.";
        logger_.warning(message, e);
        return (new RelaxerRuntimeException(message, e));
    }
}
