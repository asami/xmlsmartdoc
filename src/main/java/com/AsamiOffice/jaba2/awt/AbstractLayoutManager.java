package com.AsamiOffice.jaba2.awt;

import java.util.*;
import java.awt.LayoutManager2;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Rectangle;
import com.AsamiOffice.jaba2.util.Assert;

/**
 * The <code>AbstractLayoutManager</code> is a powerful helper class to
 * implement LayoutManager2.
 * <br>
 * You must override the <code>layoutContainer</code> and
 * the <code>preferredLayoutSize</code>.
 *
 * @since   Apr.  3, 1998
 * @version Jun. 15, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public abstract class AbstractLayoutManager implements LayoutManager2 {
    protected int hInnerGap_ = 5;
    protected int vInnerGap_ = 5;
    protected int hOuterGap_ = 5;
    protected int vOuterGap_ = 5;
    protected Map constraints_ = new HashMap();

    protected AbstractLayoutManager() {
	_init(hInnerGap_, vInnerGap_, hOuterGap_, vOuterGap_);
    }

    protected AbstractLayoutManager(int hgap, int vgap) {
	_init(hgap, vgap, hgap, vgap);
    }

    protected AbstractLayoutManager(
	int higap,
	int vigap,
	int hogap,
	int vogap
    ) {
	_init(higap, vigap, hogap, vogap);
    }

    private void _init(int higap, int vigap, int hogap, int vogap) {
	hInnerGap_ = higap;
	vInnerGap_ = vigap;
	hOuterGap_ = hogap;
	vOuterGap_ = vogap;
    }

    // LayoutManager2
    public void addLayoutComponent(Component comp, Object constraints) {
	if (constraints == null) { // for JDK1.2 beta2
	    constraints = "";
	}
	constraints_.put(comp, constraints);
    }

    // LayoutManager
    public void removeLayoutComponent(Component comp) {
	constraints_.remove(comp);
    }

    // LayoutManager
    public void addLayoutComponent(String name, Component comp) {
	throw (new UnsupportedOperationException("Deprecated"));
    }

    // LayoutManager2
    public Dimension maximumLayoutSize(Container target) {
	return (new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }

    // LayoutManager2
    public Dimension minimumLayoutSize(Container target) {
	return (preferredLayoutSize(target));
    }

    // LayoutManager2
    public float getLayoutAlignmentX(Container target) {
	return (Component.CENTER_ALIGNMENT);
    }

    // LayoutManager2
    public float getLayoutAlignmentY(Container target) {
	return (Component.CENTER_ALIGNMENT);
    }

    // LayoutManager2
    public void invalidateLayout(Container target) {
	// do nothing
    }

    public void setInnerGap(int gap) {
	hInnerGap_ = gap;
	vInnerGap_ = gap;
    }

    public void setOuterGap(int gap) {
	hOuterGap_ = gap;
	vOuterGap_ = gap;
    }

    public void setHInnerGap(int gap) {
	hInnerGap_ = gap;
    }

    public void setVInnerGap(int gap) {
	vInnerGap_ = gap;
    }
    
    public void setHOuterGap(int gap) {
	hOuterGap_ = gap;
    }

    public void setVOuterGap(int gap) {
	vOuterGap_ = gap;
    }

    protected Object _getConstraint(Component comp) {
	return (constraints_.get(comp));
    }

    protected int _getTopGap(Insets insets) {
	return (insets.top + vOuterGap_);
    }

    protected int _getBottomGap(Insets insets) {
	return (insets.bottom + vOuterGap_);
    }

    protected int _getLeftGap(Insets insets) {
	return (insets.left + hOuterGap_);
    }

    protected int _getRightGap(Insets insets) {
	return (insets.right + hOuterGap_);
    }

    protected int _getTopBottomGaps(Insets insets) {
	return (insets.top + insets.bottom + vOuterGap_ + vOuterGap_);
    }

    protected int _getLeftRightGaps(Insets insets) {
	return (insets.left + insets.right + hOuterGap_ + hOuterGap_);
    }

    protected int _getHInnerGaps(int nElements) {
	return ((nElements - 1) * hInnerGap_);
    }

    protected int _getVInnerGaps(int nElements) {
	return ((nElements - 1) * vInnerGap_);
    }

    protected Dimension _getViewSize(Container target) {
	Insets insets = target.getInsets();
	Dimension size = target.getSize();
	int width = size.width - _getLeftRightGaps(insets);
	if (width < 0) {
	    width = 0;
	}
	int height = size.height - _getTopBottomGaps(insets);
	if (height < 0) {
	    height = 0;
	}
	return (new Dimension(width, height));
    }

    protected Dimension _adjustBorder(Dimension size, Insets insets) {
	size.width += _getLeftRightGaps(insets);
	size.height += _getTopBottomGaps(insets);
	return (size);
    }

    // Array Version
    public static Component[] selectVisibleComponents(Component[] comps) {
	int nTotal = comps.length;
	int nVisible = 0;
	Component[] result = new Component[nTotal];
	for (int i = 0;i < nTotal;i++) {
	    Component comp = comps[i];
	    if (comp.isVisible()) {
		result[nVisible++] = comp;
	    }
	}
	if (nVisible == nTotal) {
	    return (result);
	} else {
	    Component[] newResult = new Component[nVisible];
	    System.arraycopy(result, 0, newResult, 0, nVisible);
	    return (newResult);
	}
    }

    public static Dimension calcMaxPreferredSize(Component[] comps) {
	Dimension max = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    max.width = Math.max(max.width, dim.width);
	    max.height = Math.max(max.height, dim.height);
	}
	return (max);
    }

    public static Dimension calcMinPreferredSize(Component[] comps) {
	Dimension min = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    min.width = Math.min(min.width, dim.width);
	    min.height = Math.min(min.height, dim.height);
	}
	return (min);
    }

    public static Dimension calcTotalPreferredSize(Component[] comps) {
	Dimension total = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    total.width += dim.width;
	    total.height += dim.height;
	}
	return (total);
    }

    public static Dimension calcMaxMinimumSize(Component[] comps) {
	Dimension max = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    max.width = Math.max(max.width, dim.width);
	    max.height = Math.max(max.height, dim.height);
	}
	return (max);
    }

    public static Dimension calcMinMinimumSize(Component[] comps) {
	Dimension min = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    min.width = Math.min(min.width, dim.width);
	    min.height = Math.min(min.height, dim.height);
	}
	return (min);
    }

    public static Dimension calcTotalMinimumSize(Component[] comps) {
	Dimension total = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    total.width += dim.width;
	    total.height += dim.height;
	}
	return (total);
    }

    public static Dimension calcMaxMaximumSize(Component[] comps) {
	Dimension max = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    max.width = Math.max(max.width, dim.width);
	    max.height = Math.max(max.height, dim.height);
	}
	return (max);
    }

    public static Dimension calcMinMaximumSize(Component[] comps) {
	Dimension min = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    min.width = Math.min(min.width, dim.width);
	    min.height = Math.min(min.height, dim.height);
	}
	return (min);
    }

    public static Dimension calcTotalMaximumSize(Component[] comps) {
	Dimension total = new Dimension(0, 0);
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    total.width += dim.width;
	    total.height += dim.height;
	}
	return (total);
    }

    //

    public static int calcMaxPreferredWidth(Component[] comps) {
	int max = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    max = Math.max(max, dim.width);
	}
	return (max);
    }

    public static int calcMinPreferredWidth(Component[] comps) {
	int min = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    min = Math.min(min, dim.width);
	}
	return (min);
    }

    public static int calcTotalPreferredWidth(Component[] comps) {
	int total = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    total += dim.width;
	}
	return (total);
    }

    public static int calcMaxMinimumWidth(Component[] comps) {
	int max = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    max += Math.max(max, dim.width);
	}
	return (max);
    }

    public static int calcMinMinimumWidth(Component[] comps) {
	int min = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    min = Math.min(min, dim.width);
	}
	return (min);
    }

    public static int calcTotalMinimumWidth(Component[] comps) {
	int total = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    total += dim.width;
	}
	return (total);
    }

    public static int calcMaxMaximumWidth(Component[] comps) {
	int max = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    max = Math.max(max, dim.width);
	}
	return (max);
    }

    public static int calcMinMaximumWidth(Component[] comps) {
	int min = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    min = Math.min(min, dim.width);
	}
	return (min);
    }

    public static int calcTotalMaximumWidth(Component[] comps) {
	int total = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    total += dim.width;
	}
	return (total);
    }

    //

    public static int calcMaxPreferredHeight(Component[] comps) {
	int max = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    max = Math.max(max, dim.height);
	}
	return (max);
    }

    public static int calcMinPreferredHeight(Component[] comps) {
	int min = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    min = Math.min(min, dim.height);
	}
	return (min);
    }

    public static int calcTotalPreferredHeight(Component[] comps) {
	int total = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getPreferredSize();
	    total += dim.height;
	}
	return (total);
    }

    public static int calcMaxMinimumHeight(Component[] comps) {
	int max = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    max += Math.max(max, dim.height);
	}
	return (max);
    }

    public static int calcMinMinimumHeight(Component[] comps) {
	int min = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    min = Math.min(min, dim.height);
	}
	return (min);
    }

    public static int calcTotalMinimumHeight(Component[] comps) {
	int total = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMinimumSize();
	    total += dim.height;
	}
	return (total);
    }

    public static int calcMaxMaximumHeight(Component[] comps) {
	int max = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    max = Math.max(max, dim.height);
	}
	return (max);
    }

    public static int calcMinMaximumHeight(Component[] comps) {
	int min = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    min = Math.min(min, dim.height);
	}
	return (min);
    }

    public static int calcTotalMaximumHeight(Component[] comps) {
	int total = 0;
	int size = comps.length;
	for (int i = 0;i < size;i++) {
	    Dimension dim = comps[i].getMaximumSize();
	    total += dim.height;
	}
	return (total);
    }

    //

    protected Dimension calcAdjustedPreferredSize(
	Insets insets,
	Component[] comps
    ) {
	int size = comps.length;
	Dimension compArea = calcTotalPreferredSize(comps);
	int hInnerGaps = _getHInnerGaps(size);
	int vInnerGaps = _getVInnerGaps(size);
	int hOuterGaps = _getLeftRightGaps(insets);
	int vOuterGaps = _getTopBottomGaps(insets);
	return (new Dimension(compArea.width + hInnerGaps + hOuterGaps,
			      compArea.height + vInnerGaps + vOuterGaps));
    }

    protected int calcAdjustedPreferredWdith(
	Insets insets,
	Component[] comps
    ) {
	int size = comps.length;
	int compArea = calcTotalPreferredWidth(comps);
	int hInnerGaps = _getHInnerGaps(size);
	int hOuterGaps = _getLeftRightGaps(insets);
	return (compArea + hInnerGaps + hOuterGaps);
    }

    protected int calcAdjustedPreferredHeight(
	Insets insets,
	Component[] comps
    ) {
	int size = comps.length;
	int compArea = calcTotalPreferredHeight(comps);
	int vInnerGaps = _getVInnerGaps(size);
	int vOuterGaps = _getTopBottomGaps(insets);
	return (compArea + vInnerGaps + vOuterGaps);
    }

    protected void _moveComponents(
	Component[] comps,
	Rectangle[] areas
    ) {
	int length = comps.length;
	// pre-condition
	Assert.check(length == areas.length, "Illegal length");

	for (int i = 0;i < length;i++) {
	    comps[i].setBounds(areas[i]);
	}
    }

    protected void _moveComponentsOnView(
	Component[] comps,
	Rectangle[] areas,
	Insets insets
    ) {
	int baseX = _getLeftGap(insets);
	int baseY = _getTopGap(insets);
	int length = comps.length;
	// pre-condition
	Assert.check(length == areas.length, "Illegal length");

	for (int i = 0;i < length;i++) {
	    comps[i].setBounds(areas[i].x + baseX, areas[i].y + baseY,
			       areas[i].width, areas[i].height);
	}
    }

    // Collection Version
    public static List selectVisibleComponents(List comps) {
	List result = new ArrayList();
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    if (comp.isVisible()) {
		result.add(comp);
	    }
	}
	return (result);
    }

    public static Dimension calcMaxPreferredSize(List comps) {
	Dimension max = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    max.width = Math.max(max.width, dim.width);
	    max.height = Math.max(max.height, dim.height);
	}
	return (max);
    }

    public static Dimension calcMinPreferredSize(List comps) {
	Dimension min = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    min.width = Math.min(min.width, dim.width);
	    min.height = Math.min(min.height, dim.height);
	}
	return (min);
    }

    public static Dimension calcTotalPreferredSize(List comps) {
	Dimension total = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    total.width += dim.width;
	    total.height += dim.height;
	}
	return (total);
    }

    public static Dimension calcMaxMinimumSize(List comps) {
	Dimension max = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    max.width = Math.max(max.width, dim.width);
	    max.height = Math.max(max.height, dim.height);
	}
	return (max);
    }

    public static Dimension calcMinMinimumSize(List comps) {
	Dimension min = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    min.width = Math.min(min.width, dim.width);
	    min.height = Math.min(min.height, dim.height);
	}
	return (min);
    }

    public static Dimension calcTotalMinimumSize(List comps) {
	Dimension total = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    total.width += dim.width;
	    total.height += dim.height;
	}
	return (total);
    }

    public static Dimension calcMaxMaximumSize(List comps) {
	Dimension max = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    max.width = Math.max(max.width, dim.width);
	    max.height = Math.max(max.height, dim.height);
	}
	return (max);
    }

    public static Dimension calcMinMaximumSize(List comps) {
	Dimension min = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    min.width = Math.min(min.width, dim.width);
	    min.height = Math.min(min.height, dim.height);
	}
	return (min);
    }

    public static Dimension calcTotalMaximumSize(List comps) {
	Dimension total = new Dimension(0, 0);
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    total.width += dim.width;
	    total.height += dim.height;
	}
	return (total);
    }

    //

    public static int calcMaxPreferredWidth(List comps) {
	int max = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    max = Math.max(max, dim.width);
	}
	return (max);
    }

    public static int calcMinPreferredWidth(List comps) {
	int min = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    min = Math.min(min, dim.width);
	}
	return (min);
    }

    public static int calcTotalPreferredWidth(List comps) {
	int total = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    total += dim.width;
	}
	return (total);
    }

    public static int calcMaxMinimumWidth(List comps) {
	int max = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    max += Math.max(max, dim.width);
	}
	return (max);
    }

    public static int calcMinMinimumWidth(List comps) {
	int min = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    min = Math.min(min, dim.width);
	}
	return (min);
    }

    public static int calcTotalMinimumWidth(List comps) {
	int total = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    total += dim.width;
	}
	return (total);
    }

    public static int calcMaxMaximumWidth(List comps) {
	int max = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    max = Math.max(max, dim.width);
	}
	return (max);
    }

    public static int calcMinMaximumWidth(List comps) {
	int min = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    min = Math.min(min, dim.width);
	}
	return (min);
    }

    public static int calcTotalMaximumWidth(List comps) {
	int total = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    total += dim.width;
	}
	return (total);
    }

    //

    public static int calcMaxPreferredHeight(List comps) {
	int max = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    max = Math.max(max, dim.height);
	}
	return (max);
    }

    public static int calcMinPreferredHeight(List comps) {
	int min = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    min = Math.min(min, dim.height);
	}
	return (min);
    }

    public static int calcTotalPreferredHeight(List comps) {
	int total = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getPreferredSize();
	    total += dim.height;
	}
	return (total);
    }

    public static int calcMaxMinimumHeight(List comps) {
	int max = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    max += Math.max(max, dim.height);
	}
	return (max);
    }

    public static int calcMinMinimumHeight(List comps) {
	int min = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    min = Math.min(min, dim.height);
	}
	return (min);
    }

    public static int calcTotalMinimumHeight(List comps) {
	int total = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMinimumSize();
	    total += dim.height;
	}
	return (total);
    }

    public static int calcMaxMaximumHeight(List comps) {
	int max = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    max = Math.max(max, dim.height);
	}
	return (max);
    }

    public static int calcMinMaximumHeight(List comps) {
	int min = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    min = Math.min(min, dim.height);
	}
	return (min);
    }

    public static int calcTotalMaximumHeight(List comps) {
	int total = 0;
	int size = comps.size();
	for (int i = 0;i < size;i++) {
	    Component comp = (Component)comps.get(i);
	    Dimension dim = comp.getMaximumSize();
	    total += dim.height;
	}
	return (total);
    }

    //

    protected Dimension calcAdjustedPreferredSize(
	Insets insets,
	List comps
    ) {
	int size = comps.size();
	Dimension compArea = calcTotalPreferredSize(comps);
	int hInnerGaps = _getHInnerGaps(size);
	int vInnerGaps = _getVInnerGaps(size);
	int hOuterGaps = _getLeftRightGaps(insets);
	int vOuterGaps = _getTopBottomGaps(insets);
	return (new Dimension(compArea.width + hInnerGaps + hOuterGaps,
			      compArea.height + vInnerGaps + vOuterGaps));
    }

    protected int calcAdjustedPreferredWdith(
	Insets insets,
	List comps
    ) {
	int size = comps.size();
	int compArea = calcTotalPreferredWidth(comps);
	int hInnerGaps = _getHInnerGaps(size);
	int hOuterGaps = _getLeftRightGaps(insets);
	return (compArea + hInnerGaps + hOuterGaps);
    }

    protected int calcAdjustedPreferredHeight(
	Insets insets,
	List comps
    ) {
	int size = comps.size();
	int compArea = calcTotalPreferredHeight(comps);
	int vInnerGaps = _getVInnerGaps(size);
	int vOuterGaps = _getTopBottomGaps(insets);
	return (compArea + vInnerGaps + vOuterGaps);
    }

    protected void _moveComponents(
	List comps, // List<Component>
	List areas  // List<Rectangle>
    ) {
	int length = comps.size();
	// pre-condition
	Assert.check(length == areas.size(), "Illegal length");

	for (int i = 0;i < length;i++) {
	    Component comp = (Component)comps.get(i);
	    Rectangle area = (Rectangle)areas.get(i);
	    comp.setBounds(area);
	}
    }

    protected void _moveComponentsOnView(
	List comps,
	List areas,
	Insets insets
    ) {
	int baseX = _getLeftGap(insets);
	int baseY = _getTopGap(insets);
	int length = comps.size();
	// pre-condition
	Assert.check(length == areas.size(), "Illegal length");

	for (int i = 0;i < length;i++) {
	    Component comp = (Component)comps.get(i);
	    Rectangle area = (Rectangle)areas.get(i);
	    comp.setBounds(area.x + baseX, area.y + baseY,
			   area.width, area.height);
	}
    }
}
