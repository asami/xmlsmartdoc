/*
 * The RelaxerFramework class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.framework.testScript;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.relaxer.framework.RelaxerFrameworkException;
import org.relaxer.framework.testScript.rTestScript.*;

/**
 * FTSInvokeService
 *
 * @since   Aug. 20, 2003
 * @version Oct.  2, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FTSInvokeService extends TSInvokeService {
    public Object eval(Object[] params, IREvaluationContext context)
        throws REvaluationException {

        FTSEvaluationContext ftsContext = (FTSEvaluationContext)context;
        ftsContext.clear();
        try {
            Object result = ftsContext.invokeService(getService(), params);
            ftsContext.setResult(result);
            return (result);
        } catch (RelaxerFrameworkException e) {
            throw (new REvaluationException(e.rGetRealCause()));
        } catch (IOException e) {
            throw (new REvaluationException(e));
        } catch (InvocationTargetException e) {
            ftsContext.setException(e.getTargetException());
            return (null);
        }
    }
}
