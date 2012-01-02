package com.AsamiOffice.jaba2.awt;

import java.awt.*;
import javax.swing.*;

/**
 * The UAWT is a utility class to manipulate the AWT facility.
 *
 * @since   Apr.  9, 1998
 * @version Dec.  4, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public final class UAWT {
    private static Toolkit toolkit__ = Toolkit.getDefaultToolkit();

    /**
     * Makes the Rectangle out of the top-left and the bottom-right points.
     *
     * @param p1 the top-left point
     * @param p2 the bottom-right point
     * @return the Rectangle generated
     */
    public static Rectangle makeRectangle(Point p1, Point p2) {
	return (new Rectangle(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y),
			      Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y)));
    }

    public static Point calcPointToDrawCenter(
	Rectangle bounds,
	Dimension size
    ) {
	int x = (bounds.width - size.width) / 2;
	if (x < 0) {
	    x = 0;
	}
	int y = (bounds.height - size.height) / 2;
	if (y < 0) {
	    y = 0;
	}
	return (new Point(bounds.x + x, bounds.y + y));
    }

    public static Point calcCenter(Rectangle bounds) {
	return (new Point(bounds.x + (bounds.width / 2),
			  bounds.y + (bounds.height / 2)));
    }

    public static Point calcGridedPosition(int x, int y, int grid) {
	return (
	    new Point(
		calcGridedPosition(x, grid),
		calcGridedPosition(y, grid)
	    )
	);
    }

    public static Point calcGridedPosition(Point p, int grid) {
	return (
	    new Point(
		calcGridedPosition(p.x, grid),
		calcGridedPosition(p.y, grid)
	    )
	);
    }

    public static int calcGridedPosition(int pos, int grid) {
	return ((pos / grid) * grid +
		(((float)(pos % grid) / (float)grid) > 0.5 ? grid : 0));
    }
}
