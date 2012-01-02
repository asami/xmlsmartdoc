package com.AsamiOffice.jaba2.awt;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

/**
 * LayoutManagerHelper
 *
 * @since   Apr.  9, 1998
 * @version Apr. 25, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class LayoutManagerHelper {
    public Dimension size;
    public Insets insets;
    public int nComps;
    public Component[] comps;
    public Dimension[] maxs;
    public Dimension[] mins;
    public Dimension[] prefs;
    public Dimension maxMax;
    public Dimension minMax;
    public Dimension totalMaxs;
    public Dimension maxMin;
    public Dimension minMin;
    public Dimension totalMins;
    public Dimension maxPref;
    public Dimension minPref;
    public Dimension totalPrefs;
    protected Container container_;
    protected Component[] comps_ = null;

    public LayoutManagerHelper(Container container) {
	container_ = container;
    }

    public LayoutManagerHelper(Container container, Component[] comps) {
	container_ = container;
	comps_ = comps;
    }

    public void setup() {
	size = container_.getSize();
	insets = container_.getInsets();
	if (comps_ != null) {
	    comps = comps_;
	} else {
	    comps = selectVisibleComponents(container_.getComponents());
	}
	nComps = comps.length;
	maxs = makeMaximumSizeList(comps);
	mins = makeMinimumSizeList(comps);
	prefs = makePreferredSizeList(comps);
	maxMax = calcMaximumSize(maxs);
	minMax = calcMinimumSize(maxs);
	totalMaxs = calcTotalSize(maxs);
	maxMin = calcMaximumSize(mins);
	minMin = calcMinimumSize(mins);
	totalMins = calcTotalSize(mins);
	maxPref = calcMaximumSize(prefs);
	minPref = calcMinimumSize(prefs);
	totalPrefs = calcTotalSize(prefs);
    }

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

    public static Dimension[] makeMaximumSizeList(Component[] comps) {
	Dimension[] sizes = new Dimension[comps.length];
	for (int i = 0;i < comps.length;i++) {
	    sizes[i] = comps[i].getMaximumSize();
	}
	return (sizes);
    }

    public static Dimension[] makeMinimumSizeList(Component[] comps) {
	Dimension[] sizes = new Dimension[comps.length];
	for (int i = 0;i < comps.length;i++) {
	    sizes[i] = comps[i].getMinimumSize();
	}
	return (sizes);
    }

    public static Dimension[] makePreferredSizeList(Component[] comps) {
	Dimension[] sizes = new Dimension[comps.length];
	for (int i = 0;i < comps.length;i++) {
	    sizes[i] = comps[i].getPreferredSize();
	}
	return (sizes);
    }

    public static Dimension calcMaximumSize(Dimension[] dims) {
	Dimension max = new Dimension(0, 0);
	for (int i = 0;i < dims.length;i++) {
	    max.width = Math.max(max.width, dims[i].width);
	    max.height = Math.max(max.height, dims[i].height);
	}
	return (max);
    }

    public static Dimension calcMinimumSize(Dimension[] dims) {
	Dimension min = new Dimension(0, 0);
	for (int i = 0;i < dims.length;i++) {
	    min.width = Math.min(min.width, dims[i].width);
	    min.height = Math.min(min.height, dims[i].height);
	}
	return (min);
    }

    public static Dimension calcTotalSize(Dimension[] dims) {
	Dimension total = new Dimension(0, 0);
	for (int i = 0;i < dims.length;i++) {
	    total.width += dims[i].width;
	    total.height += dims[i].height;
	}
	return (total);
    }
}
