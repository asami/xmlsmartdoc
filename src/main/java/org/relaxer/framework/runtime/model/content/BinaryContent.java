/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
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
package org.relaxer.framework.runtime.model.content;

import org.relaxer.framework.runtime.model.RModelException;
import org.relaxer.framework.runtime.model.context.IRModelContext;

/**
 * BinaryContent
 *
 * @since   Aug.  7, 2004
 * @version Aug. 22, 2005
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class BinaryContent extends AbstractRModelContent {
    private final byte[] binary_;

    public BinaryContent(byte[] binary, IRModelContext context) {
        super(context);
        binary_ = binary;
    }

    public boolean isValue() {
        return false;
    }

    public Object getValue() {
        return null;
    }

    public boolean isBinary() {
        return (true);
    }
    
    protected long _getSize() {
        return binary_.length;
    }

    protected byte[] _getBinary() throws RModelException {
        return (binary_);
    }

    public Object getSource() {
        return (binary_);
    }
}
