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
 * FTSIn
 *
 * @since   Aug. 20, 2003
 * @version Sep. 29, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FTSIn extends TSIn {
    public Object eval(Object[] params, IREvaluationContext context) throws REvaluationException {
        FTSEvaluationContext ftsContext = (FTSEvaluationContext)context;
        ITSValueExpressionChoice choice = getValueExpression();
        if (choice instanceof TSValueExpressionValue) {
            TSValueExpressionValue attr = (TSValueExpressionValue)choice;
            return (attr.getContent());
        } else if (choice instanceof TSValueElement) {
            TSValueElement element = (TSValueElement)choice;
            try {
                return (element.makeDocument());
            } catch (ParserConfigurationException e) {
                throw (new REvaluationException(e));
            }
        } else if (choice instanceof TSExpression) {
            throw (new UnsupportedOperationException());
        } else {
            throw (new InternalError());
        }
    }
}
