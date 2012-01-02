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

import org.relaxer.framework.testScript.rTestScript.*;

/**
 * InterpreterTestScriptFactory
 *
 * @since   Aug. 20, 2003
 * @version Aug. 20, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class FTSTestScriptFactory extends DefaultTestScriptFactory {
    public TSBody createTSBody() {
        return (new FTSBody());
    }

    public TSInvokeObject createTSInvokeObject() {
        return (new FTSInvokeObject());
    }

    public TSIn createTSIn() {
        return (new FTSIn());
    }

    public TSInvokeService createTSInvokeService() {
        return (new FTSInvokeService());
    }

    public TSAssert createTSAssert() {
        return (new FTSAssert());
    }

    public TSAssertReturn createTSAssertReturn() {
        return (new FTSAssertReturn());
    }

    public TSAssertException createTSAssertException() {
        return (new FTSAssertException());
    }
}
