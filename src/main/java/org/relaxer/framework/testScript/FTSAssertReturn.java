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

import javax.xml.parsers.ParserConfigurationException;

import org.relaxer.framework.testScript.rTestScript.*;

/**
 * FTSAssertReturn
 *
 * @since   Aug. 20, 2003
 * @version Oct. 30, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FTSAssertReturn extends TSAssertReturn {
    public Object eval(Object[] params, IREvaluationContext context)
        throws REvaluationException {

        FTSEvaluationContext ftsContext = (FTSEvaluationContext)context;
        Object result = ftsContext.getResult();
        if (params.length != 1) {
            throw (new UnsupportedOperationException());
        }
        Object value = _getValue(params[0]);
        if (_equals(value, result)) {
            return (Boolean.TRUE);
        } else {
            throw (new REvaluationException(result + " != " + value));
        }
    }

    public Object _getValue(Object param) throws REvaluationException {
        if (param instanceof TSValueExpressionValue) {
            TSValueExpressionValue value =
                (TSValueExpressionValue)param;
            return (value.getContent());
        } else if (param instanceof TSValueElement) {
            TSValueElement element = (TSValueElement)param;
            try {
                return (element.makeDocument());
            } catch (ParserConfigurationException e) {
                throw (new REvaluationException(e));
            }
        } else if (param instanceof TSExpression) {
            throw (new UnsupportedOperationException());
        } else {
            throw (new InternalError());
        }
    }

    public boolean _equals(Object lhs, Object rhs) {
        if (lhs == null || rhs == null) {
            return (lhs == rhs);
        } else {
            return (lhs.toString().trim().equals(rhs.toString().trim()));
        }
    }
}
