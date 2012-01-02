package com.AsamiOffice.jaba2.awt;

import java.awt.LayoutManager2;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Insets;
import com.AsamiOffice.jaba2.util.Debug;

/**
 * RowLayout
 *
 * @since   Apr. 13, 1998
 * @version Jun. 24, 1998
 * @author ASAMI, Tomoharu (tasami@ibm.net)
 */
public class RowLayout extends AbstractLayoutManager {
    /**
     * policy
     *
     * HBASE
     *   HBASE_LEFT
     *   HBASE_CENTER
     *   HBASE_RIGHT
     *   HBASE_FILL
     * VBASE
     *   VBASE_TOP
     *   VBASE_CENTER
     *   VBASE_BOTTOM
     *   VBASE_FILL
     * HALIGN
     *   HALIGN_LEFT
     *   HALIGN_CENTER
     *   HALIGN_RIGHT
     *   HALIGN_FILL
     * VALIGN
     *   VALIGN_TOP
     *   VALIGN_CENTER
     *   VALIGN_BOTTOM
     *   VALIGN_FILL
     * WIDTH
     *   WIDTH_PREFERRED
     *   WIDTH_EQUAL
     *   WIDTH_FILL
     *   WIDTH_RELATIVE
     *   WIDTH_ABSOLUTE
     * HEIGHT
     *   HEIGHT_PREFERRED
     *   HEIGHT_EQUAL
     *   HEIGHT_FILL
     *   HEIGHT_RELATIVE
     *   HEIGHT_ABSOLUTE
     * RESIZE
     *   RESIZE_NONE
     *   RESIZE_WIDTH
     *   RESIZE_HEIGHT
     *   RESIZE_BOUND
     */

    // HBASE
    private static final int HBASE_MASK = 0x0000000f;
    public static final int HBASE_DEFAULT = 0x00000000;
    public static final int HBASE_LEFT = 0x00000001;
    public static final int HBASE_CENTER = 0x00000002; // default
    public static final int HBASE_RIGHT = 0x00000003;
    public static final int HBASE_FILL = 0x00000004;
    // VBASE
    private static final int VBASE_MASK = 0x000000f0;
    public static final int VBASE_DEFAULT = 0x00000000;
    public static final int VBASE_TOP = 0x00000010;
    public static final int VBASE_CENTER = 0x00000020; // default
    public static final int VBASE_BOTTOM = 0x00000030;
    public static final int VBASE_FILL = 0x00000040;
    // HALIGN
    private static final int HALIGN_MASK = 0x0000f00;
    public static final int HALIGN_DEFAULT = 0x00000000;
    public static final int HALIGN_LEFT = 0x00000100;
    public static final int HALIGN_CENTER = 0x00000200; // default
    public static final int HALIGN_RIGHT = 0x00000300;
    public static final int HALIGN_FILL = 0x00000400;
    // VALIGN
    private static final int VALIGN_MASK = 0x0000f000;
    public static final int VALIGN_DEFAULT = 0x00000000;
    public static final int VALIGN_TOP = 0x00001000;
    public static final int VALIGN_CENTER = 0x00002000; // default
    public static final int VALIGN_BOTTOM = 0x00003000;
    public static final int VALIGN_FILL = 0x00004000;
    // WIDTH
    private static final int WIDTH_MASK = 0x000f0000;
    public static final int WIDTH_DEFAULT = 0x00000000;
    public static final int WIDTH_PREFERRED = 0x00010000; // default
    public static final int WIDTH_EQUAL = 0x00020000;
    public static final int WIDTH_FILL = 0x00030000;
    public static final int WIDTH_RELATIVE = 0x00040000; // use attr
    public static final int WIDTH_ABSOLUTE = 0x00050000; // use attr
    // HEIGHT
    private static final int HEIGHT_MASK = 0x00f00000;
    public static final int HEIGHT_DEFAULT = 0x00000000;
    public static final int HEIGHT_PREFERRED = 0x00100000;
    public static final int HEIGHT_EQUAL = 0x00200000; // default
    public static final int HEIGHT_FILL = 0x00300000;
    public static final int HEIGHT_RELATIVE = 0x00400000; // use attr
    public static final int HEIGHT_ABSOLUTE = 0x00500000; // use attr
    // RESIZE
    private static final int RESIZE_MASK = 0x0f000000;
    public static final int RESIZE_DEFAULT = 0x00000000;
    public static final int RESIZE_NONE = 0x01000000;
    public static final int RESIZE_WIDTH = 0x02000000;
    public static final int RESIZE_HEIGHT = 0x03000000; // default
    public static final int RESIZE_BOUND = 0x04000000;

    protected int hbasePolicy_;
    protected int vbasePolicy_;
    protected int halignPolicy_;
    protected int valignPolicy_;
    protected int widthPolicy_;
    protected int heightPolicy_;
    protected int resizePolicy_;
 
    public RowLayout() {
	this(
	    HBASE_DEFAULT |
	    VBASE_DEFAULT |
	    HALIGN_DEFAULT |
	    VALIGN_DEFAULT |
	    WIDTH_DEFAULT |
	    HEIGHT_DEFAULT |
	    RESIZE_DEFAULT
	);
    }

    public RowLayout(int policy) {
	this(policy, 5, 5);
    }

    public RowLayout(int policy, int hgap, int vgap) {
	super(hgap, vgap);
	hbasePolicy_ = policy & HBASE_MASK;
	if (hbasePolicy_ == HBASE_DEFAULT) {
	    hbasePolicy_ = HBASE_CENTER;
	}
	vbasePolicy_ = policy & VBASE_MASK;
	if (vbasePolicy_ == VBASE_DEFAULT) {
	    vbasePolicy_ = VBASE_CENTER;
	}
	halignPolicy_ = policy & HALIGN_MASK;
	if (halignPolicy_ == HALIGN_DEFAULT) {
	    halignPolicy_ = HALIGN_CENTER;
	}
	valignPolicy_ = policy & VALIGN_MASK;
	if (valignPolicy_ == VALIGN_DEFAULT) {
	    valignPolicy_ = VALIGN_CENTER;
	}
	widthPolicy_ = policy & WIDTH_MASK;
	if (widthPolicy_ == WIDTH_DEFAULT) {
	    widthPolicy_ = WIDTH_EQUAL;
	}
	heightPolicy_ = policy & HEIGHT_MASK;
	if (heightPolicy_ == HEIGHT_DEFAULT) {
	    heightPolicy_ = HEIGHT_PREFERRED;
	}
	resizePolicy_ = policy & RESIZE_MASK;
	if (resizePolicy_ == RESIZE_DEFAULT) {
	    resizePolicy_ = RESIZE_WIDTH;
	}
	if (!((hbasePolicy_ == HBASE_LEFT ||
	       hbasePolicy_ == HBASE_CENTER ||
	       hbasePolicy_ == HBASE_RIGHT ||
	       hbasePolicy_ == HBASE_FILL) &&
	      (vbasePolicy_ == VBASE_TOP ||
	       vbasePolicy_ == VBASE_CENTER ||
	       vbasePolicy_ == VBASE_BOTTOM ||
	       vbasePolicy_ == VBASE_FILL) &&
	      (halignPolicy_ == HALIGN_LEFT ||
	       halignPolicy_ == HALIGN_CENTER ||
	       halignPolicy_ == HALIGN_RIGHT ||
	       halignPolicy_ == HALIGN_FILL) &&
	      (valignPolicy_ == VALIGN_TOP ||
	       valignPolicy_ == VALIGN_CENTER ||
	       valignPolicy_ == VALIGN_BOTTOM ||
	       valignPolicy_ == VALIGN_FILL) &&
	      (widthPolicy_ == WIDTH_PREFERRED ||
	       widthPolicy_ == WIDTH_EQUAL ||
	       widthPolicy_ == WIDTH_FILL ||
	       widthPolicy_ == WIDTH_RELATIVE ||
	       widthPolicy_ == WIDTH_ABSOLUTE) &&
	      (heightPolicy_ == HEIGHT_PREFERRED ||
	       heightPolicy_ == HEIGHT_EQUAL) &&
	      (resizePolicy_ == RESIZE_NONE ||
	       resizePolicy_ == RESIZE_WIDTH ||
	       resizePolicy_ == RESIZE_HEIGHT ||
	       resizePolicy_ == RESIZE_BOUND))) {
	    throw (new IllegalArgumentException("policy : " + policy));
	}
    }

    public Dimension preferredLayoutSize(Container target) {
	LayoutManagerHelper lmh = new LayoutManagerHelper(target);
	lmh.setup();
	Insets insets = lmh.insets;
	int nComps = lmh.nComps;
	Dimension maxSize = lmh.maxPref;
	Dimension totalSize = lmh.totalPrefs;

	// calculates the height
	int height;
	switch (heightPolicy_) {

	case HEIGHT_PREFERRED:
	    height = totalSize.height;
	    break;
	case HEIGHT_EQUAL:
	    height = nComps * maxSize.height;
	    break;
	case HEIGHT_RELATIVE:
	case HEIGHT_ABSOLUTE:
	default:
	    throw (new InternalError
		   ("Invalid heightPolicy_ : " + heightPolicy_));
	}
	height += _getVInnerGaps(nComps) + _getTopBottomGaps(insets);

	// calculates the height
	int width = maxSize.width + _getLeftRightGaps(insets);

	Dimension result = new Dimension(width, height);
	Debug.log(2, this, "preferredSize = " + result);
	return (result);
    }

    public Dimension minimumLayoutSize(Container target) {
	LayoutManagerHelper lmh = new LayoutManagerHelper(target);
	lmh.setup();
	Insets insets = lmh.insets;
	int width = lmh.maxMin.width;
	int height = lmh.totalMins.height;
	return (new Dimension(
	    _getLeftRightGaps(insets) + width,
	    _getTopBottomGaps(insets) + height
	));
    }

    public void layoutContainer(Container target) {
	LayoutManagerHelper lmh = new LayoutManagerHelper(target);
	lmh.setup();
	if (lmh.size.width == 0 || lmh.size.height == 0 || lmh.nComps == 0) {
	    return;
	}
	Insets insets = lmh.insets;
	Component[] comps = lmh.comps;
	int nComps = lmh.nComps;
	Dimension maxSize = lmh.maxPref;
	Dimension totalSize = lmh.totalPrefs;
	Rectangle[] areas = new Rectangle[nComps];
	for (int i = 0;i < nComps;i++) {
	    areas[i] = new Rectangle(0, 0, 0, 0);
	}

	Debug.log(3, this, "components : " + Debug.a2s(comps));
	Debug.log(3, this, "after initialize : " + Debug.a2s(areas));

	// calc area heights and relative y positions
	switch (heightPolicy_) {

	case HEIGHT_PREFERRED: {
	    int y = 0;
	    for (int i = 0;i < nComps;i++) {
		areas[i].y = y;
		areas[i].height = lmh.prefs[i].height;
		y += areas[i].height + hInnerGap_;
	    }
	    break;
	}
	case HEIGHT_EQUAL: {
	    int y = 0;
	    for (int i = 0;i < nComps;i++) {
		areas[i].y = y;
		areas[i].height = maxSize.height;
		y += areas[i].height + hInnerGap_;
	    }
	    break;
	}
	case HEIGHT_RELATIVE:
	case HEIGHT_ABSOLUTE:
	default:
	    throw (new InternalError
		   ("Invalid height policy : " + heightPolicy_));
	}

	Debug.log(
	    3,
	    this,
	    "after relative y position and height : " + Debug.a2s(areas)
	);

	// calc area widths
	switch (widthPolicy_) {

	case WIDTH_PREFERRED:
	    for (int i = 0;i < nComps;i++) {
		areas[i].width = lmh.prefs[i].width;
	    }
	    break;
	case WIDTH_EQUAL:
	    for (int i = 0;i < nComps;i++) {
		areas[i].width = maxSize.width;
	    }
	    break;
	case WIDTH_FILL:
	    for (int i = 0;i < nComps;i++) {
		areas[i].width = lmh.size.width - _getLeftRightGaps(insets); // XXX : viewWidth
	    }
	    break;
	default:
	    throw (new InternalError
		   ("Invalid width policy : " + widthPolicy_));
	}

	Debug.log(3, this, "after widths : " + Debug.a2s(areas));

	// calc absolute y positons
	Rectangle last = areas[areas.length - 1];
	int compsHeight = last.y + last.height;
	switch (vbasePolicy_) {

	case VBASE_TOP: {
	    int y = _getTopGap(insets);
	    for (int i = 0;i < nComps;i++) {
		areas[i].translate(0, y);
	    }
	    break;
	}
	case VBASE_CENTER: {
	    int viewHeight = lmh.size.height - _getTopBottomGaps(insets);
	    int y;
	    if (viewHeight > compsHeight) {
		y = _getTopGap(insets) + (viewHeight / 2) - (compsHeight / 2);
	    } else {
		y = _getTopGap(insets);
	    }
	    for (int i = 0;i < nComps;i++) {
		areas[i].translate(0, y);
	    }
	    break;
	}
	case VBASE_BOTTOM: {
	    int viewHeight = lmh.size.height - _getTopBottomGaps(insets);
	    int y;
	    if (viewHeight > compsHeight) {
		y = _getTopGap(insets) + viewHeight - compsHeight;
	    } else {
		y = _getTopGap(insets);
	    }
	    for (int i = 0;i < nComps;i++) {
		areas[i].translate(0, y);
	    }
	    break;
	}
	case VBASE_FILL:
	default:
	    throw (new InternalError
		   ("Invalid vbase policy : " + vbasePolicy_));
	}

	Debug.log(3, this, "after absolute y position : " + Debug.a2s(areas));

	// calc absolute x positions
	int viewWidth = lmh.size.width - _getLeftRightGaps(insets);
	switch (hbasePolicy_) {

	case HBASE_LEFT:
	    for (int i = 0;i < nComps;i++) {
		areas[i].x = _getLeftGap(insets);
	    }
	    break;
	case HBASE_CENTER: {
	    int left = _getLeftGap(insets);
	    for (int i = 0;i < nComps;i++) {
		areas[i].x = left + (viewWidth / 2) - (areas[i].width / 2);
	    }
	    break;
	}
	case HBASE_RIGHT: {
	    int left = _getLeftGap(insets);
	    for (int i = 0;i < nComps;i++) {
		areas[i].x = left + viewWidth - areas[i].width;
	    }
	    break;
	}
	case HBASE_FILL:
	    break;
	default:
	    throw (new InternalError
		   ("Invalid base policy : " + hbasePolicy_));
	}

	Debug.log(3, this, "after absolute x position : " + Debug.a2s(areas));

	// calc resize
	switch (resizePolicy_) {

	case RESIZE_NONE:
	    for (int i = 0;i < nComps;i++) {
		Dimension size = lmh.prefs[i];
		Point point = UAWT.calcPointToDrawCenter(areas[i], size);
		areas[i].x = point.x;
		areas[i].y = point.y;
	    }
	    break;
	case RESIZE_WIDTH:
	    for (int i = 0;i < nComps;i++) {
		Dimension size = lmh.prefs[i];
		Point point = UAWT.calcPointToDrawCenter(areas[i], size);
		areas[i].height = size.height;
		areas[i].y = point.y;
	    }
	    break;
	case RESIZE_HEIGHT:
	    for (int i = 0;i < nComps;i++) {
		Dimension size = lmh.prefs[i];
		Point point = UAWT.calcPointToDrawCenter(areas[i], size);
		areas[i].x = point.x;
		areas[i].width = size.width;
	    }
	    break;
	case RESIZE_BOUND:
	    // do nothing
	    break;
	default:
	    throw (new InternalError 
		   ("Bad resizePolicy_ : " + resizePolicy_));
	}

	Debug.log(3, this, "after calculation : " + Debug.a2s(areas));
	// do move
	_moveComponents(comps, areas);
    }
}
