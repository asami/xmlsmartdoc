/*
 * org.relaxer.framework
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.framework.rConfig.factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.relaxer.framework.RelaxerFramework;
import org.relaxer.framework.importer.ImporterException;
import org.relaxer.framework.importer.UImporter;
import org.relaxer.framework.logger.IRFrameworkLogger;
import org.relaxer.framework.rConfig.FCActionIn;
import org.relaxer.framework.rConfig.FCActionOut;
import org.relaxer.framework.rConfig.FCComponentAction;
import org.relaxer.framework.rConfig.IREvaluationContext;
import org.relaxer.framework.rConfig.REvaluationException;
import org.relaxer.framework.script.ScriptContext;
import org.relaxer.framework.script.ScriptSpace;
import org.relaxer.framework.script.Slot;

import com.AsamiOffice.text.UString;

/**
 * ScriptComponentAction
 *
 * @since   Jan.  9, 2004
 * @version Aug.  6, 2004
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class ScriptComponentAction extends FCComponentAction {
    public ScriptComponentAction(ScriptSpace scriptSpace) {
        _setScriptSpace(scriptSpace);
    }

    public Object eval(Object[] params, IREvaluationContext context)
      throws REvaluationException {
        ScriptContext scriptContext = (ScriptContext)context.getProperty();
        String componentName = getRef();
        if (UString.isNull(componentName)) {
            throw (new REvaluationException("Component name is unspecified."));
        }
        ScriptSpace space = getScriptSpace();
        Object component = space.getComponent(componentName);
        if (component == null) {
            throw (new REvaluationException("Component '" + componentName + "' is not found."));
        }
        String methodName = getOperation();
        if (UString.isNull(methodName)) {
            throw (new REvaluationException("Method name in Component '" + componentName + "' is not specified."));
        }
        if (isAttribute_(component, methodName)) {
            return (executeAttribute_(
                component,
                methodName,
                componentName,
                scriptContext
            ));
        } else {
            return (executeMethod_(
                component,
                methodName,
                componentName,
                scriptContext
            ));
        }
    }

    private Object executeAttribute_(
        Object component, 
        String methodName, 
        String componentName, 
        ScriptContext scriptContext
    ) throws REvaluationException {
        FCActionIn[] ins = getActionIn();
        Method setter = getSetterMethod_(component, methodName);
        if (setter == null) {
            throw (new REvaluationException("Method '" + methodName + "' in Component '" + componentName + "' is not found."));
        }
        RelaxerFramework framework = _getFramework();
        IRFrameworkLogger logger = framework.getLogger();
        Object[] parameters = getAttributeParameter_(setter, ins, scriptContext);
        try {
            if (parameters == null) {
                String logName = "get" + UString.capitalize(methodName);
                parameters = new Object[0];
                Method getter = getGetterMethod_(component, methodName);
                logger.entering(component, logName, parameters);
                Object result = getter.invoke(component, parameters);
                logger.exiting(component, logName, result);
                FCActionOut out = getActionOut();
                if (out != null) {
                    scriptContext.setSlot(out.getName(), result);
                }
                return (result);
            } else {
                String logName = "set" + UString.capitalize(methodName);
                logger.entering(component, logName, parameters);
                Object result = setter.invoke(component, parameters);
                logger.exiting(component, logName, result);
                FCActionOut out = getActionOut();
                if (out != null) {
                    scriptContext.setSlot(out.getName(), parameters[0]);
                }
                return (result);
            }
        } catch (InvocationTargetException e) {
            Throwable cause = e.getTargetException();
            if (cause == null) {
                cause = e;
            }
            logger.exiting(component, methodName, e);
            throw (getREvaluationException_(e));
        } catch (Exception e) {
            logger.exiting(component, methodName, e);
            throw (getREvaluationException_(e));
        }
    }

    private Object[] getAttributeParameter_(
        Method method, 
        FCActionIn[] ins, 
        ScriptContext scriptContext
    ) throws REvaluationException {
        Class[] types = method.getParameterTypes();
        Object[] parameters = new Object[ins.length];
        if (types.length != parameters.length) {
            return (null);
        }
        for (int i = 0; i < types.length; i++) {
            FCActionIn in = ins[i];
            Slot slot = scriptContext.getSlot(in.getName());
            if (slot == null) {
                return (null);
            }
            try {
                parameters[i] = UImporter.importObject(slot, types[i]);
            } catch (ImporterException e) {
                throw (getREvaluationException_(e));
            }
        }
        return (parameters);
    }

    private Object executeMethod_(
        Object component,
        String methodName,
        String componentName,
        ScriptContext scriptContext
    ) throws REvaluationException {
        FCActionIn[] ins = getActionIn();
        Method method = getMethod_(component, methodName);
        if (method == null) {
            throw (new REvaluationException("Method '" + methodName + "' in Component '" + componentName + "' is not found."));
        }
        RelaxerFramework framework = _getFramework();
        IRFrameworkLogger logger = framework.getLogger();
        Object[] parameters = getParameters_(method, ins, scriptContext);
        try {
            logger.entering(component, methodName, parameters);
            Object result = method.invoke(component, parameters);
            logger.exiting(component, methodName, result);
            FCActionOut out = getActionOut();
            if (out != null) {
                scriptContext.setSlot(out.getName(), result);
            }
            return (result);
        } catch (InvocationTargetException e) {
            Throwable cause = e.getTargetException();
            if (cause == null) {
                cause = e;
            }
            logger.exiting(component, methodName, e);
            throw (getREvaluationException_(e));
        } catch (Exception e) {
            logger.exiting(component, methodName, e);
            throw (getREvaluationException_(e));
        }
    }

    private boolean isAttribute_(Object component, String methodName) {
        return (getGetterMethod_(component, methodName) != null);
    }

    private Object[] getParameters_(
        Method method, 
        FCActionIn[] ins,
        ScriptContext scriptContext
    ) throws REvaluationException {
        Class[] types = method.getParameterTypes();
        Object[] parameters = new Object[ins.length];
        if (types.length != parameters.length) {
            throw (new REvaluationException());
        }
        for (int i = 0; i < types.length; i++) {
            FCActionIn in = ins[i];
            Slot slot = scriptContext.getSlot(in.getName());
            if (slot == null) {
                throw (new REvaluationException());
            }
            try {
                parameters[i] = UImporter.importObject(slot, types[i]);
            } catch (ImporterException e) {
                throw (getREvaluationException_(e));
            }
        }
        return (parameters);
    }

/*
    private Object importParameter_(Class clazz, String[] texts) 
      throws NoSuchMethodException, InstantiationException, 
             IllegalAccessException, InvocationTargetException {
        switch (texts.length) {
          case 0:
            throw (new UnsupportedOperationException());
          case 1:
            return (UImporter.getParameter(texts[0], clazz));
          default:
            return (UImporter.getArrayParameter(texts, clazz)); 
        }
    }
*/

    private Method getMethod_(Object component, String methodName) {
        Method[] methods = component.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (methodName.equals(method.getName())) {
                return (method);
            }
        }
        return (null);
    }

    private Method getGetterMethod_(Object component, String methodName) {
        String name = "get" + UString.capitalize(methodName);
        Method[] methods = component.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (name.equals(method.getName())) {
                return (method);
            }
        }
        return (null);
    }

    private Method getSetterMethod_(Object component, String methodName) {
        String name = "set" + UString.capitalize(methodName);
        Method[] methods = component.getClass().getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            if (name.equals(method.getName())) {
                return (method);
            }
        }
        return (null);
    }

    private REvaluationException getREvaluationException_(
        Exception e
    ) {
        Throwable t = e.getCause();
        if (t == null || e == t || !(t instanceof Exception)) {
            return (new REvaluationException(e.getMessage(), e));
        } else {
            return (getREvaluationException_((Exception)t));
        }
    }

/*
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

    private void setInSlots_(Object[] params, IRModel model) {
        for (int i = 0; i < params.length; i++) {
            Object param = params[i];
            if (param instanceof ScriptParameter.Entry) {
                ScriptParameter.Entry entry = (ScriptParameter.Entry)param;
                model.setProperty(entry.name, entry.data.getValue());
            }
        }
        DefaultImporter importer;
    }
*/
}
