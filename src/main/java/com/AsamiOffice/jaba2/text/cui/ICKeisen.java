/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2001  ASAMI, Tomoharu (asami@zeomtech.com)
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

/**
 * ICKeisen
 *
 * @since   May. 21, 2001
 * @version May. 23, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface ICKeisen {
    String getTopLeft();
    String getTopRight();
    String getBottomLeft();
    String getBottomRight();
    String getTop();
    String getBottom();
    String getLeft();
    String getRight();
    String getLeftThickJoint();
    String getRightThickJoint();
    String getLeftThinJoint();
    String getRightThinJoint();
    String getThickHLine();
    String getThickVLine();
    String getThinHLine();
    String getThinVLine();
    String getTopThickJoint();
    String getBottomThickJoint();
    String getTopThinJoint();
    String getBottomThinJoint();
    String getHThickVThickJoint();
    String getHThickVThinJoint();
    String getHThinVThickJoint();
    String getHThinVThinJoint();
    String getPlainTopLeft();
    String getPlainTopRight();
    String getPlainBottomLeft();
    String getPlainBottomRight();
    String getPlainTop();
    String getPlainBottom();
    String getPlainLeft();
    String getPlainRight();
}
