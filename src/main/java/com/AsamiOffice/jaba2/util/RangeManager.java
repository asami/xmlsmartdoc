/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@asamiOffice.com)
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

package com.AsamiOffice.jaba2.util;

import com.AsamiOffice.text.UString;

/**
 * RangeManager
 *
 * @since   Jul. 15, 2000
 * @version Jan. 25, 2004
 * @author  ASAMI, Tomoharu (asami@asamiOffice.com)
 */
public class RangeManager {
    private Range[] ranges_;

    public RangeManager(String range) {
	String[] rangeList = UString.getTokens(range, ", ");
	ranges_ = new Range[rangeList.length];
	for (int i = 0;i < rangeList.length;i++) {
	    ranges_[i] = new Range(rangeList[i]);
	}
    }

    public boolean isValid(int index) {
	for (int i = 0;i < ranges_.length;i++) {
	    if (ranges_[i].isValid(index)) {
		return (true);
	    }
	}
	return (false);
    }

    static class Range {
	private int min_;
	private int max_;

	Range(String range) {
	    String[] numberList = UString.getTokens(range, "-");
	    switch (numberList.length) {

	    case 0:
		_errorStatus();
		break;
	    case 1:
		if ("*".equals(numberList[0])) {
		    min_ = 0;
		    max_ = _getValue(numberList[0]);
		} else {
		    min_ = max_ = _getValue(numberList[0]);
		}
		break;
	    case 2:
		min_ = _getValue(numberList[0]);
		max_ = _getValue(numberList[1]);
		break;
	    default:
		_errorStatus();
	    }
	}

	public boolean isValid(int number) {
	    return (min_ <= number && number <= max_);
	}

	private int _getValue(String number) {
	    if ("*".equals(number)) {
		return (Integer.MAX_VALUE);
	    } else {
		return (Integer.parseInt(number));
	    }
	}

	private void _errorStatus() {
	    min_ = 0;
	    max_ = 0;
	}
    }
}
