/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2000  ASAMI, Tomoharu (asami@zeomtech.com)
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

package org.xmlsmartdoc.SmartDoc.mathml;

/**
 * IMathMLConstants
 *
 * @since   Sep.  2, 2000
 * @version Sep.  2, 2000
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface IMathMLConstants {
    // Non-Marking Entities
    char MATH_TAB = '\t';
    char MATH_NEW_LINE = '\n';
    char MATH_INDENTING_NEW_LINE = '\uE891';
    char MATH_NO_BREAK = '\uE892';
    char MATH_GOOD_BREAK = '\uE893';
    char MATH_BAD_BREAK = '\uE894';
    char MATH_SPACE = '\u0020';
    char MATH_NON_BREAKING_SPACE = '\u00A0';
    char MATH_ZERO_WIDTH_SPACE = '\u200B';
    char MATH_VERY_THIN_SPACE = '\u200A';
    char MATH_THIN_SPACE = '\u2009';
    char MATH_MEDIUM_SPACE = '\u2005';
    char MATH_THICK_SPACE = '\uE897';
    char MATH_NEGATIVE_VERY_THIN_SPACE = '\uE898';
    char MATH_NEGATIVE_THIN_SPACE = '\uE899';
    char MATH_NEGATIVE_MEDIUM_SPACE = '\uE89A';
    char MATH_NEGATIVE_THICK_SPACE = '\uE89B';
    char MATH_INVISIBLE_COMMA = '\uE89C';
    char MATH_IC = '\uE89C';
    char MATH_INVISIBLE_TIMES = '\uE89E';
    char MATH_IT = '\uE89E';
    char MATH_APPLY_FUNCTION = '\uE8A0';
    char MATH_AF = '\uE8A0';
    // Special Constants
    char MATH_CAPITAL_DIFFERENTIAL_D = '\uF74B';
    char MATH_DD = '\uF74B';
    char MATH_DIFFERENTIAL_D = '\uF74C';
    char MATH_dd = '\uF74C';
    char MATH_EXPONENTIAL_E = '\uF74D';
    char MATH_ee = '\uE8A7';
    char MATH_FALSE = '\uE8A7';
    char MATH_IMAGINARY_I = '\uF74E';
    char MATH_ii = '\uF74E';
    char MATH_NOT_A_NUMBER = '\uE8AA';
    char MATH_TRUE = '\uE8AB';
    // ISONUM
    char MATH_PLUS_MINUS = '\u00B1';
    // ISOAMSB
    char MATH_SUM = '\u2211';
    // ISOTECH
    char MATH_INT = '\u8747';
    // MMLALIAS
    char MATH_INTEGRAL = '\u8747';
}
