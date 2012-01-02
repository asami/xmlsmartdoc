/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package com.AsamiOffice.jaba2.text.cui;

import com.AsamiOffice.text.UString;
import com.AsamiOffice.util.D2Array;

/**
 * CBoardBase
 *
 * @since   Oct. 21, 1999
 * @version Jul. 11, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class CBoardBase implements ICBoard {
    protected D2Array board_ = new D2Array();
    protected String newline_ = "\n";
    protected static final Character AFTER_WIDE_CHARACTER
        = new Character('\uffff');

    public void setNewline(String newline) {
	newline_ = newline;
    }

    public void put(int x, int y, char c) {
	if (board_.getWidth() > x &&
	    board_.getHeight() > y) {

	    Character pc = (Character)board_.get(x, y);
	    if (pc == AFTER_WIDE_CHARACTER) {
                throw (new IllegalArgumentException());
	    }
	}
	board_.put(x, y, new Character(c));
	if (UString.isWideCharacter(c)) {
	    board_.put(x + 1, y, AFTER_WIDE_CHARACTER);
	} else {
	    if (board_.getWidth() > x + 1) {
		Character nc = (Character)board_.get(x + 1, y);
		if (nc == AFTER_WIDE_CHARACTER) {
		    board_.put(x + 1, y, null);
		}
	    }
	}
    }

    public void put(int x, final int y, final String text) {
        _clearArea(x, y, text);
	int size = text.length();
/*
        int xx = x;
        for (int i = 0;i < size;i++) {
            if (board_.getWidth() <= xx) {
                break;
            }
            Character nc = (Character)board_.get(xx, y);
            if (nc != null) {
                char c = nc.charValue();
                System.out.print((int)c);
            } else {
                System.out.print("null");
            }
	    if (UString.isWideCharacter(text.charAt(i))) {
                xx++;
                System.out.print(board_.get(xx, y));
            }
            xx++;
        }
        System.out.println();
*/
	for (int i = 0;i < size;i++) {
	    char c = text.charAt(i);
	    put(x, y, c);
	    if (UString.isWideCharacter(c)) {
		x += 2;
	    } else {
		x++;
	    }
	}
    }

    private void _clearArea(int x, final int y, final String text) {
	int size = text.length();
        if (size == 0) {
            return;
        }
        if (board_.getWidth() <= x) {
            return;
        }
        if (board_.getHeight() <= y) {
            return;
        }
        Character pc = (Character)board_.get(x, y);
        if (pc == AFTER_WIDE_CHARACTER) {
            if (x == 0) {
                throw (new IllegalArgumentException());
            } else {
                board_.put(x - 1, y, null);
            }
        }
        board_.put(x, y, null);
        if (pc != null && UString.isWideCharacter(pc.charValue())) {
            board_.put(x + 1, y, null);
        }
        if (UString.isWideCharacter(text.charAt(0))) {
            x += 2;
        } else {
            x++;
        }
        for (int i = 1;i < size;i++) {
            if (board_.getWidth() <= x) {
                return;
            }
            pc = (Character)board_.get(x, y);
            if (pc == AFTER_WIDE_CHARACTER) {
                board_.put(x - 1, y, null);
            }                
            board_.put(x, y, null);
            if (pc != null && pc != AFTER_WIDE_CHARACTER &&
                UString.isWideCharacter(pc.charValue())) {
                board_.put(x + 1, y, null);
            }
            if (UString.isWideCharacter(text.charAt(i))) {
                x += 2;
            } else {
                x++;
            }
        }
    }

    public String makeScreen() {
	StringBuffer buffer = new StringBuffer();
	makeScreen(buffer);
	return (new String(buffer));
    }

    public void makeScreen(StringBuffer buffer) {
	int width = board_.getWidth();
	int height = board_.getHeight();
	for (int y = 0;y < height;y++) {
	    StringBuffer spaces = new StringBuffer();
	    for (int x = 0;x < width;x++) {
		Character c = (Character)board_.get(x, y);
		if (c == null) {
		    spaces.append(" ");
		} else if (c == AFTER_WIDE_CHARACTER) {
		    // do nothing
		} else {
		    buffer.append(spaces);
		    spaces.setLength(0);
		    buffer.append(c);
		}
	    }
	    buffer.append(newline_);
	}
    }
}
