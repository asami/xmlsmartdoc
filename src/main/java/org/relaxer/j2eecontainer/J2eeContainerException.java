/*
 * org.relaxer.j2eecontainer
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package org.relaxer.j2eecontainer;

import java.rmi.RemoteException;

/**
 * J2eeContainerException
 *
 * @since   2004/02/17
 * @version 2004/02/17
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class J2eeContainerException extends RemoteException {
    public J2eeContainerException(String message) {
        super(message);
    }
}
