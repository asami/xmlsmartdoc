package org.relaxer.framework.testScript.rTestScript;

/**
 * REvaluationException
 *
 * @since   Aug. 21, 2001
 * @version Aug. 31, 2001
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class REvaluationException extends Exception {
    private Throwable parent_;

    public REvaluationException() {
	super();
    }

    public REvaluationException(String message) {
	super(message);
    }

    public REvaluationException(Throwable parent) {
	this(parent.getMessage(), parent);
    }

    public REvaluationException(String message, Throwable parent) {
	super(message);
        parent_ = parent;
    }

    public Throwable rGetParent() {
        return (parent_);
    }
}
