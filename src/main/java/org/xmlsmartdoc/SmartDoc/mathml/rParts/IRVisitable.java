package org.xmlsmartdoc.SmartDoc.mathml.rParts;

import java.util.*;
import org.w3c.dom.*;

/**
 * IRVisitable
 *
 * @since   Apr. 30, 2000
 * @version Apr. 30, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface IRVisitable {
    void enter(IRVisitor visitor);
    void leave(IRVisitor visitor);
}
