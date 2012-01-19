package org.xmlsmartdoc.SmartDoc.latex2e.handler;

import org.xmlsmartdoc.SmartDoc.latex2e.*;

/**
 * TascmacLaTeX2eBoxHandler
 *
 * @since   Jan. 19, 2012
 * @version Jan. 19, 2012
 * @author  ASAMI, Tomoharu (asami@smartdox.org)
 */
public class TascmacLaTeX2eBoxHandler implements LaTeX2eBoxHandler {
    protected String[] packages_ = { "tascmac" };

    // LaTeX2eBoxHandler
    public String[] getPackages() {
        return (packages_);
    }

    // LaTeX2eBoxHandler
    public String makeConsoleBegin() {
        return ("\\begin{screen}\n");
    }

    // LaTeX2eBoxHandler
    public String makeConsoleEnd() {
      	return ("\\end{screen}\n");
    }

    // LaTeX2eBoxHandler
    public String makeFYIBegin(String title) {
	// boxnote doesn't work correctly in some environment.
	// would use shadebox.
      	return ("\\begin{itembox}{" + title + "}\n");
    }

    // LaTeX2eBoxHandler
    public String makeFYIEnd() {
      	return ("\\end{itembox}\n");
    }

    // LaTeX2eBoxHandler
    public String makeCommentBegin() {
      	return ("\\begin{itembox}{comment}\n");
    }

    // LaTeX2eBoxHandler
    public String makeCommentEnd() {
      	return ("\\end{itembox}\n");
    }
}
