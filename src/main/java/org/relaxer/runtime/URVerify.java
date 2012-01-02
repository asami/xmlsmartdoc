/*
 * RelaxerOrg class library
 *  Copyright (C) 2000-2003  ASAMI, Tomoharu (asami@relaxer.org)
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

package org.relaxer.runtime;

import java.util.*;
import java.math.*;
import java.lang.reflect.*;
import org.w3c.dom.*;

/**
 * URVerify
 *
 * @since   Apr. 14, 2002
 * @version Oct. 21, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class URVerify implements IRVerifyConstants {
    private static BigInteger ZERO_INTEGER = new BigInteger("0");
    private static BigInteger ONE_INTEGER = new BigInteger("1");
    private static BigInteger MAX_BYTE = new BigInteger("128");
    private static BigInteger MIN_BYTE = new BigInteger("-128");
    private static BigInteger MAX_SHORT = new BigInteger("32767");
    private static BigInteger MIN_SHORT = new BigInteger("-32768");
    private static BigInteger MAX_INT = new BigInteger("2147483647");
    private static BigInteger MIN_INT = new BigInteger("-2147483648");
    private static BigInteger MAX_LONG = new BigInteger("9223372036854775807");
    private static BigInteger MIN_LONG = new BigInteger("-9223372036854775808");
    private static BigInteger MAX_U_BYTE = new BigInteger("255");
    private static BigInteger MAX_U_SHORT = new BigInteger("65535");
    private static BigInteger MAX_U_INT = new BigInteger("4294967295");
    private static BigInteger MAX_U_LONG = new BigInteger("18446744073709551615");
    private static BigDecimal ZERO_DECIMAL = new BigDecimal("0");
    private static BigDecimal ONE_DECIMAL = new BigDecimal("1");
    private static BigDecimal MAX_FLOAT = new BigDecimal("3.40282346638528860e+38");
    private static BigDecimal MIN_FLOAT = new BigDecimal("-3.40282346638528860e+38");
//    private static BigDecimal MIN_FLOAT = new BigDecimal("1.40129846432481707e-45");
    private static BigDecimal MAX_DOUBLE = new BigDecimal("1.79769313486231570e+308");
    private static BigDecimal MIN_DOUBLE = new BigDecimal("-1.79769313486231570e+308");
//    private static BigDecimal MIN_DOUBLE = new BigDecimal("4.94065645841246544e-324");

    public static boolean isOne(Object value) {
        return (value != null);
    }

    public static boolean isOne(boolean value) {
        return (true);
    }

    public static boolean isOne(byte value) {
        return (true);
    }

    public static boolean isOne(short value) {
        return (true);
    }

    public static boolean isOne(int value) {
        return (true);
    }

    public static boolean isOne(long value) {
        return (true);
    }

    public static boolean isOne(float value) {
        return (true);
    }

    public static boolean isOne(double value) {
        return (true);
    }

    public static boolean isOneMore(List values) {
        return (values.size() > 0);
    }

    // simple
    public static String isValidOrNull(Object value, String typeName) {
        return (isValidOrNull(value, typeName, null));
    }

    public static String isValidOrNull(
        Object value,
        String typeName,
        String facets
    ) {
        if (value == null) {
            return (null);
        } else {
            return (isValid(value, typeName, facets));
        }
    }

    public static String isValidOrNull(boolean value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(
        boolean value,
        String typeName,
        String facets
    ) {
        return (isValid(value, typeName, facets));
    }

    public static String isValidOrNull(byte value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(byte value, String typeName, String facets) {
        return (isValid(value, typeName, facets));
    }

    public static String isValidOrNull(short value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(short value, String typeName, String facets) {
        return (isValid(value, typeName, facets));
    }

    public static String isValidOrNull(int value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(int value, String typeName, String facets) {
        return (isValid(value, typeName, facets));
    }

    public static String isValidOrNull(long value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(long value, String typeName, String facets) {
        return (isValid(value, typeName, facets));
    }

    public static String isValidOrNull(float value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(float value, String typeName, String facets) {
        return (isValid(value, typeName, facets));
    }

    public static String isValidOrNull(double value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValidOrNull(double value, String typeName, String facets) {
        return (isValid(value, typeName, facets));
    }

    public static String isValid(Object value, String typeName) {
        return (isValid(value, typeName, null));
    }

    public static String isValid(Object value, String typeName, String facets) {
        List list = makeFacetList(facets);
        if ("string".equals(typeName)) {
            return (isValidString(value, list));
        } else if ("normalizedString".equals(typeName)) {
            return (isValidNormalizedString(value, list));
        } else if ("token".equals(typeName)) {
            return (isValidToken(value, list));
        } else if ("boolean".equals(typeName)) {
            return (isValidBoolean(value, list));
        } else if ("byte".equals(typeName)) {
            return (isValidByte(value, list));
        } else if ("short".equals(typeName)) {
            return (isValidShort(value, list));
        } else if ("int".equals(typeName)) {
            return (isValidInt(value, list));
        } else if ("long".equals(typeName)) {
            return (isValidLong(value, list));
        } else if ("unsignedByte".equals(typeName)) {
            return (isValidUnsignedByte(value, list));
        } else if ("unsignedShort".equals(typeName)) {
            return (isValidUnsignedShort(value, list));
        } else if ("unsignedInt".equals(typeName)) {
            return (isValidUnsignedInt(value, list));
        } else if ("unsignedLong".equals(typeName)) {
            return (isValidUnsignedLong(value, list));
        } else if ("float".equals(typeName)) {
            return (isValidFloat(value, list));
        } else if ("double".equals(typeName)) {
            return (isValidDouble(value, list));
        } else if ("decimal".equals(typeName)) {
            return (isValidDecimal(value, list));
        } else if ("time".equals(typeName)) {
            return (isValidTime(value, list));
        } else if ("date".equals(typeName)) {
            return (isValidDate(value, list));
        } else if ("dateTime".equals(typeName)) {
            return (isValidDateTime(value, list));
        } else if ("gYearMonth".equals(typeName)) {
            return (isValidGYearMonth(value, list));
        } else if ("gYear".equals(typeName)) {
            return (isValidGYear(value, list));
        } else if ("gMonthDay".equals(typeName)) {
            return (isValidGMonthDay(value, list));
        } else if ("gDay".equals(typeName)) {
            return (isValidGDay(value, list));
        } else if ("gMonth".equals(typeName)) {
            return (isValidGMonth(value, list));
        } else if ("duration".equals(typeName)) {
            return (isValidDuration(value, list));
        } else if ("base64Binary".equals(typeName)) {
            return (isValidBase64Binary(value, list));
        } else if ("hexBinary".equals(typeName)) {
            return (isValidHexBinary(value, list));
        } else if ("anyURI".equals(typeName)) {
            return (isValidAnyURI(value, list));
        } else if ("language".equals(typeName)) {
            return (isValidLanguage(value, list));
        } else if ("Name".equals(typeName)) {
            return (isValidName(value, list));
        } else if ("QName".equals(typeName)) {
            return (isValidQName(value, list));
        } else if ("NCName".equals(typeName)) {
            return (isValidNCName(value, list));
        } else if ("integer".equals(typeName)) {
            return (isValidInteger(value, list));
        } else if ("nonNegativeInteger".equals(typeName)) {
            return (isValidNonNegativeInteger(value, list));
        } else if ("positiveInteger".equals(typeName)) {
            return (isValidPositiveInteger(value, list));
        } else if ("nonPositiveInteger".equals(typeName)) {
            return (isValidNonPositiveInteger(value, list));
        } else if ("negativeInteger".equals(typeName)) {
            return (isValidNegativeInteger(value, list));
        } else if ("CDATA".equals(typeName)) {
            return (isValidCDATA(value, list));
        } else if ("NMTOKEN".equals(typeName)) {
            return (isValidNMTOKEN(value, list));
        } else if ("NMTOKENS".equals(typeName)) {
            return (isValidNMTOKENS(value, list));
        } else if ("ID".equals(typeName)) {
            return (isValidID(value, list));
        } else if ("IDREF".equals(typeName)) {
            return (isValidIDREF(value, list));
        } else if ("IDREFS".equals(typeName)) {
            return (isValidIDREFS(value, list));
        } else if ("ENTITY".equals(typeName)) {
            return (isValidENTITY(value, list));
        } else if ("ENTITIES".equals(typeName)) {
            return (isValidENTITIES(value, list));
        } else if ("NOTATION".equals(typeName)) {
            return (isValidNOTATION(value, list));
        } else if ("none".equals(typeName)) {
            throw (new InternalError(typeName));
        } else if ("emptyString".equals(typeName)) {
            throw (new InternalError(typeName));
        } else if (typeName.charAt(0) == '<') {
            return (isValidComplex(value, typeName, list));
        } else {
            throw (new InternalError(typeName));
        }
    }

    public static String isValid(boolean value, String typeName) {
        if ("boolean".equals(typeName)) {
            return (null);
        }
        return (isValid(new Boolean(value), typeName, null));
    }

    public static String isValid(boolean value, String typeName, String facets) {
        return (isValid(new Boolean(value), typeName, facets));
    }

    public static String isValid(byte value, String typeName) {
        if ("byte".equals(typeName) ||
            "short".equals(typeName) ||
            "int".equals(typeName) ||
            "long".equals(typeName) ||
            "integer".equals(typeName) ||
            "nonNegativeInteger".equals(typeName) ||
            "nonPositiveInteger".equals(typeName) ||
            "negativeInteger".equals(typeName) ||
            "positiveInteger".equals(typeName)) {

            return (null);
        }
        return (isValid(new Byte(value), typeName, null));
    }

    public static String isValid(byte value, String typeName, String facets) {
        return (isValid(new Byte(value), typeName, facets));
    }

    public static String isValid(short value, String typeName) {
        if ("short".equals(typeName) ||
            "int".equals(typeName) ||
            "long".equals(typeName) ||
            "integer".equals(typeName) ||
            "nonNegativeInteger".equals(typeName) ||
            "nonPositiveInteger".equals(typeName) ||
            "negativeInteger".equals(typeName) ||
            "positiveInteger".equals(typeName)) {

            return (null);
        }
        return (isValid(new Short(value), typeName, null));
    }

    public static String isValid(short value, String typeName, String facets) {
        return (isValid(new Short(value), typeName, facets));
    }

    public static String isValid(int value, String typeName) {
        if ("int".equals(typeName) ||
            "long".equals(typeName) ||
            "integer".equals(typeName) ||
            "nonNegativeInteger".equals(typeName) ||
            "nonPositiveInteger".equals(typeName) ||
            "negativeInteger".equals(typeName) ||
            "positiveInteger".equals(typeName)) {

            return (null);
        }
        return (isValid(new Integer(value), typeName, null));
    }

    public static String isValid(int value, String typeName, String facets) {
        return (isValid(new Integer(value), typeName, facets));
    }

    public static String isValid(long value, String typeName) {
        if ("long".equals(typeName) ||
            "integer".equals(typeName) ||
            "nonNegativeInteger".equals(typeName) ||
            "nonPositiveInteger".equals(typeName) ||
            "negativeInteger".equals(typeName) ||
            "positiveInteger".equals(typeName)) {

            return (null);
        }
        return (isValid(new Long(value), typeName, null));
    }

    public static String isValid(long value, String typeName, String facets) {
        return (isValid(new Long(value), typeName, facets));
    }

    public static String isValid(float value, String typeName) {
        if ("float".equals(typeName) ||
            "double".equals(typeName)) {

            return (null);
        }
        return (isValid(new Float(value), typeName, null));
    }

    public static String isValid(float value, String typeName, String facets) {
        return (isValid(new Float(value), typeName, facets));
    }

    public static String isValid(double value, String typeName) {
        if ("double".equals(typeName)) {
            return (null);
        }
        return (isValid(new Double(value), typeName, null));
    }

    public static String isValid(double value, String typeName, String facets) {
        return (isValid(new Double(value), typeName, facets));
    }

/*

    public static String isValidList(
        List values,
        String typeName
    ) {
        return (isValidList(values, typeName, null));
    }

    public static String isValidList(
        List values,
        String typeName,
        String facets
    ) {
        return (isValidList(values.toArray(), typeName, facets));
    }

    public static String isValidList(
        Object[] values,
        String typeName,
        String facets
    ) {
        for (int i = 0;i < values.length;i++) {
            String message = isValid(values[i], typeName, facets);
            if (message != null) {
                return (message);
            }
        }
        return (null);
    }
*/

    //
    public static String isValidString(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        } else {
            String message;
            if ((message = isValidAsEnumeration(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(value, facets)) != null) {
                return (message);
            }
            return (null);
        }
    }

    public static String isValidNormalizedString(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String string = value.toString();
        if (string.indexOf('\n') == -1 &&
            string.indexOf('\r') == -1 &&
            string.indexOf('\t') == -1) {

            String message;
            if ((message = isValidAsEnumeration(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(value, facets)) != null) {
                return (message);
            }
            return (null);
        } else {
            return (INVALID_CONTROL_CHAR);
        }
    }

    public static String isValidToken(Object value, List facets) {
        String message;
        if (value == null) {
            return (NULL_VALUE);
        }
        if ((message = isValidNormalizedString(value, facets)) != null) {
            return (message);
        }
        String string = value.toString();
        if (string.length() == 0) {
            if ((message = isValidAsEnumeration(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(value, facets)) != null) {
                return (message);
            }
            return (null);
        } else {
            if (string.charAt(0) == ' ') {
                return (WHITE_FIRST);
            }
            if (string.charAt(string.length() - 1) == ' ') {
                return (WHITE_LAST);
            }
            if (string.indexOf("  ") != -1) {
                return (WHITE_MIDDLE);
            }
            if ((message = isValidAsEnumeration(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(value, facets)) != null) {
                return (message);
            }
            return (null);
        }
    }

    public static String isValidBoolean(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if (value instanceof Boolean && facets == null) {
            return (null);
        }
        String string = value.toString();
        if ("0".equals(string) ||
            "1".equals(string) ||
            "true".equals(string) ||
            "false".equals(string)) {

            String message;
            if ((message = isValidAsEnumeration(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(value, facets)) != null) {
                return (message);
            }
            return (null);
        } else {
            return (INVALID_BOOLEAN);
        }
    }

    public static String isValidByte(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if (value instanceof Byte && facets == null) {
            return (null);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_BYTE) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(MIN_BYTE) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidShort(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if ((value instanceof Byte || value instanceof Short) &&
            facets == null) {

            return (null);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_SHORT) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(MIN_SHORT) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidInt(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if ((value instanceof Byte ||
             value instanceof Short ||
             value instanceof Integer) &&
            facets == null) {

            return (null);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_INT) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(MIN_INT) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidLong(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if ((value instanceof Byte ||
             value instanceof Short ||
             value instanceof Integer ||
             value instanceof Long) &&
            facets == null) {

            return (null);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_LONG) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(MIN_LONG) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidUnsignedByte(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_U_BYTE) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(ZERO_INTEGER) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidUnsignedShort(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_U_SHORT) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(ZERO_INTEGER) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidUnsignedInt(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_U_INT) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(ZERO_INTEGER) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidUnsignedLong(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(MAX_U_LONG) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(ZERO_INTEGER) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidFloat(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if (value instanceof Float && facets == null) {
            return (null);
        }
        try {
            BigDecimal big = _getBigDecimal(value);
            if (big.compareTo(MAX_FLOAT) > 0) {
                return (OUT_OF_RANGE + "FMAX" + big);
            } else if (big.compareTo(MIN_FLOAT) < 0) {
                return (OUT_OF_RANGE + "FMIN" + big + "/" + MIN_FLOAT);
            } else {
                String message;
                if ((message = isValidAsEnumeration(big, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(big, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(big, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidDouble(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if ((value instanceof Float ||
             value instanceof Double) && facets == null) {

            return (null);
        }
        try {
            BigDecimal big = _getBigDecimal(value);
            if (big.compareTo(MAX_DOUBLE) > 0) {
                return (OUT_OF_RANGE);
            } else if (big.compareTo(MIN_DOUBLE) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(big, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(big, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(big, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidDecimal(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if (value instanceof Number && facets == null) {
            return (null);
        }
        try {
            BigDecimal big = _getBigDecimal(value);
            String message;
            if ((message = isValidAsEnumeration(big, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(big, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsNumber(big, facets)) != null) {
                return (message);
            }
            return (null);
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidTime(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if (!(value instanceof java.sql.Time)) {
            String string = _isValidTimeFormat(value.toString(), 0);
            if (string == null) {
                // do nothing
            } else if (TIME_FORMAT.equals(string)) {
                return (string);
            } else {
                return (TIME_FORMAT);
            }
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    private static String _isValidTimeFormat(String string, int offset) {
        int length = string.length();
        if (length < (offset + 8)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 0)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 1)) {
            return (TIME_FORMAT);
        }
        if (!isChar(string, ":", offset + 2)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 3)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 4)) {
            return (TIME_FORMAT);
        }
        if (!isChar(string, ":", offset + 5)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 6)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 7)) {
            return (TIME_FORMAT);
        }
        if (length == (offset + 8)) {
            return (null);
        }
        int offset2;
        if (string.charAt(offset + 8) == '.') {
            offset2 = offset + 9;
            for (;;) {
                if (length <= offset2) {
                    return (null);
                }
                if (!isDigit(string, offset2)) {
                    break;
                }
                offset2++;
            }
        } else {
            offset2 = offset + 8;
        }
        if (length <= offset2) {
            return (null);
        }
        switch (string.charAt(offset2)) {

        case 'Z':
            if (length == (offset2 + 1)) {
                return (null);
            } else {
                return (string.substring(offset2 + 1));
            }
        case '+':
            // continue
        case '-':
            if (length < (offset2 + 6)) {
                return (TIME_FORMAT);
            }
            if (!isDigit(string, offset2 + 1)) {
                return (TIME_FORMAT);
            }
            if (!isDigit(string, offset2 + 2)) {
                return (TIME_FORMAT);
            }
            if (!isChar(string, ":", offset2 + 3)) {
                return (TIME_FORMAT);
            }
            if (!isDigit(string, offset2 + 4)) {
                return (TIME_FORMAT);
            }
            if (!isDigit(string, offset2 + 5)) {
                return (TIME_FORMAT);
            }
            if (length == (offset2 + 6)) {
                return (null);
            } else {
                return (string.substring(offset2 + 6));
            }
        default:
            return (string.substring(offset2));
        }
    }

    public static String isValidDate(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if (!(value instanceof java.sql.Date)) {
            String string = _isValidDateFormat(value.toString(), 0);
            if (string == null) {
                // do nothing
            } else if (TIME_FORMAT.equals(string)) {
                return (string);
            } else {
                return (TIME_FORMAT);
            }
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    private static String _isValidDateFormat(String string, int offset) {
        int length = string.length();
        if (length < (offset + 10)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 0)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 1)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 2)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 3)) {
            return (TIME_FORMAT);
        }
        if (!isChar(string, "-", offset + 4)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 5)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 6)) {
            return (TIME_FORMAT);
        }
        if (!isChar(string, "-", offset + 7)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 8)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, offset + 9)) {
            return (TIME_FORMAT);
        }
        if (length == (offset + 10)) {
            return (null);
        } else {
            return (string.substring(offset + 10));
        }
    }

    public static String isValidDateTime(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String string;
        if (value instanceof java.sql.Timestamp) {
            string = URelaxer.getString((java.sql.Timestamp)value);
        } else {
            string = value.toString();
            if (string.length() < 19) {
                return (TIME_FORMAT);
            }
            String string2 = _isValidDateFormat(string, 0);
            if (string2 == null) {
                return (TIME_FORMAT);
            } else if (TIME_FORMAT.equals(string2)) {
                return (TIME_FORMAT);
            }
            if (string2.charAt(0) != 'T') {
                return (TIME_FORMAT);
            }
            String string3 = _isValidTimeFormat(string2, 1);
            if (string3 == null) {
                // do nothing
            } else if (TIME_FORMAT.equals(string3)) {
                return (TIME_FORMAT);
            } else {
                return (TIME_FORMAT);
            }
            string = string3;
        }
        String message;
        if ((message = isValidAsEnumeration(string, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(string, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidGYearMonth(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidGYear(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String string = value.toString();
        int length = string.length();
        if (length < 4) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 0)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 1)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 2)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 3)) {
            return (TIME_FORMAT);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidGMonthDay(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String string = value.toString();
        int length = string.length();
        if (length < 5) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 0)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 1)) {
            return (TIME_FORMAT);
        }
        if (!isChar(string, "-", 2)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 3)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 4)) {
            return (TIME_FORMAT);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidGDay(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String string = value.toString();
        int length = string.length();
        if (length < 2) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 0)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 1)) {
            return (TIME_FORMAT);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidGMonth(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String string = value.toString();
        int length = string.length();
        if (length < 2) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 0)) {
            return (TIME_FORMAT);
        }
        if (!isDigit(string, 1)) {
            return (TIME_FORMAT);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidDuration(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidBase64Binary(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidHexBinary(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidAnyURI(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidLanguage(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidName(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidQName(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidNCName(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidInteger(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        if ((value instanceof Byte ||
             value instanceof Short ||
             value instanceof Integer ||
             value instanceof Long ||
             value instanceof BigInteger) && facets == null) {

            return (null);
        }
        try {
            BigInteger big = _getBigInteger(value);
            String message;
            if ((message = isValidAsEnumeration(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsString(value, facets)) != null) {
                return (message);
            }
            if ((message = isValidAsNumber(value, facets)) != null) {
                return (message);
            }
            return (null);
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidNonNegativeInteger(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(ZERO_INTEGER) < 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidPositiveInteger(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(ZERO_INTEGER) <= 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidNonPositiveInteger(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(ZERO_INTEGER) > 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidNegativeInteger(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        try {
            BigInteger big = _getBigInteger(value);
            if (big.compareTo(ZERO_INTEGER) >= 0) {
                return (OUT_OF_RANGE);
            } else {
                String message;
                if ((message = isValidAsEnumeration(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsString(value, facets)) != null) {
                    return (message);
                }
                if ((message = isValidAsNumber(value, facets)) != null) {
                    return (message);
                }
                return (null);
            }
        } catch (Exception e) {
            return (NUMBER_FORMAT);
        }
    }

    public static String isValidCDATA(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidNMTOKEN(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidNMTOKENS(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidID(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidIDREF(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidIDREFS(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidENTITY(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidENTITIES(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidNOTATION(Object value, List facets) {
        if (value == null) {
            return (NULL_VALUE);
        }
        String message;
        if ((message = isValidAsEnumeration(value, facets)) != null) {
            return (message);
        }
        if ((message = isValidAsString(value, facets)) != null) {
            return (message);
        }
        return (null);
    }

    public static String isValidComplex(
        Object value,
        String typeName,
        List facets
    ) {
        if (UJAXP.isMatchDataComplex(value.toString(), typeName)) {
            return (null);
        } else {
            return (INVALID_VALUE);
        }
    }

    // list
    public static String isValidListZeroMore(
        String values,
        String typeName
    ) {
        return (isValidListZeroMore(values, typeName, null));
    }

    public static String isValidListZeroMore(
        String values,
        String typeName,
        String facets
    ) {
        List list = URelaxer.makeStringList(values);
        return (isValidListZeroMore(list, typeName, facets));
    }

    public static String isValidListZeroMore(List value, String typeName) {
        return (isValidListZeroMore(value, typeName, null));
    }

    public static String isValidListZeroMore(List value, String typeName, String facets) {
        List list = makeFacetList(facets);
        if ("string".equals(typeName)) {
            return (isValidStringList(value, list));
        } else if ("normalizedString".equals(typeName)) {
            return (isValidNormalizedStringList(value, list));
        } else if ("token".equals(typeName)) {
            return (isValidTokenList(value, list));
        } else if ("boolean".equals(typeName)) {
            return (isValidBooleanList(value, list));
        } else if ("byte".equals(typeName)) {
            return (isValidByteList(value, list));
        } else if ("short".equals(typeName)) {
            return (isValidShortList(value, list));
        } else if ("int".equals(typeName)) {
            return (isValidIntList(value, list));
        } else if ("long".equals(typeName)) {
            return (isValidLongList(value, list));
        } else if ("unsignedByte".equals(typeName)) {
            return (isValidUnsignedByteList(value, list));
        } else if ("unsignedShort".equals(typeName)) {
            return (isValidUnsignedShortList(value, list));
        } else if ("unsignedInt".equals(typeName)) {
            return (isValidUnsignedIntList(value, list));
        } else if ("unsignedLong".equals(typeName)) {
            return (isValidUnsignedLongList(value, list));
        } else if ("float".equals(typeName)) {
            return (isValidFloatList(value, list));
        } else if ("double".equals(typeName)) {
            return (isValidDoubleList(value, list));
        } else if ("decimal".equals(typeName)) {
            return (isValidDecimalList(value, list));
        } else if ("time".equals(typeName)) {
            return (isValidTimeList(value, list));
        } else if ("date".equals(typeName)) {
            return (isValidDateList(value, list));
        } else if ("dateTime".equals(typeName)) {
            return (isValidDateTimeList(value, list));
        } else if ("gYearMonth".equals(typeName)) {
            return (isValidGYearMonthList(value, list));
        } else if ("gYear".equals(typeName)) {
            return (isValidGYearList(value, list));
        } else if ("gMonthDay".equals(typeName)) {
            return (isValidGMonthDayList(value, list));
        } else if ("gDay".equals(typeName)) {
            return (isValidGDayList(value, list));
        } else if ("gMonth".equals(typeName)) {
            return (isValidGMonthList(value, list));
        } else if ("duration".equals(typeName)) {
            return (isValidDurationList(value, list));
        } else if ("base64Binary".equals(typeName)) {
            return (isValidBase64BinaryList(value, list));
        } else if ("hexBinary".equals(typeName)) {
            return (isValidHexBinaryList(value, list));
        } else if ("anyURI".equals(typeName)) {
            return (isValidAnyURIList(value, list));
        } else if ("language".equals(typeName)) {
            return (isValidLanguageList(value, list));
        } else if ("Name".equals(typeName)) {
            return (isValidNameList(value, list));
        } else if ("QName".equals(typeName)) {
            return (isValidQNameList(value, list));
        } else if ("NCName".equals(typeName)) {
            return (isValidNCNameList(value, list));
        } else if ("integer".equals(typeName)) {
            return (isValidIntegerList(value, list));
        } else if ("nonNegativeInteger".equals(typeName)) {
            return (isValidNonNegativeIntegerList(value, list));
        } else if ("positiveInteger".equals(typeName)) {
            return (isValidPositiveIntegerList(value, list));
        } else if ("nonPositiveInteger".equals(typeName)) {
            return (isValidNonPositiveIntegerList(value, list));
        } else if ("negativeInteger".equals(typeName)) {
            return (isValidNegativeIntegerList(value, list));
        } else if ("CDATA".equals(typeName)) {
            return (isValidCDATAList(value, list));
        } else if ("NMTOKEN".equals(typeName)) {
            return (isValidNMTOKENList(value, list));
        } else if ("NMTOKENS".equals(typeName)) {
            return (isValidNMTOKENSList(value, list));
        } else if ("ID".equals(typeName)) {
            return (isValidIDList(value, list));
        } else if ("IDREF".equals(typeName)) {
            return (isValidIDREFList(value, list));
        } else if ("IDREFS".equals(typeName)) {
            return (isValidIDREFSList(value, list));
        } else if ("ENTITY".equals(typeName)) {
            return (isValidENTITYList(value, list));
        } else if ("ENTITIES".equals(typeName)) {
            return (isValidENTITIESList(value, list));
        } else if ("NOTATION".equals(typeName)) {
            return (isValidNOTATIONList(value, list));
        } else if ("none".equals(typeName)) {
            throw (new InternalError(typeName));
        } else if ("emptyString".equals(typeName)) {
            throw (new InternalError(typeName));
        } else {
            throw (new InternalError(typeName));
        }
    }

    public static String isValidListOneMore(
        String values,
        String typeName
    ) {
        return (isValidListOneMore(values, typeName, null));
    }

    public static String isValidListOneMore(
        String values,
        String typeName,
        String facets
    ) {
        List list = URelaxer.makeStringList(values);
        return (isValidListOneMore(list, typeName, facets));
    }

    public static String isValidListOneMore(List value, String typeName) {
        return (isValidListOneMore(value, typeName, null));
    }

    public static String isValidListOneMore(
        List values,
        String typeName,
        String facets
    ) {
        if (values.size() == 0) {
            return (EMPTY_VALUE);
        }
        return (isValidListZeroMore(values, typeName, facets));
    }

    public static String isValidStringList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidString(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNormalizedStringList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNormalizedString(values.get(i),
                                                   facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidTokenList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidToken(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidBooleanList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidBoolean(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidByteList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidByte(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidShortList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidShort(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidIntList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidInt(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidLongList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidLong(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidUnsignedByteList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidUnsignedByte(values.get(i),
                                               facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidUnsignedShortList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidUnsignedShort(values.get(i),
                                                facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidUnsignedIntList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidUnsignedInt(values.get(i),
                                              facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidUnsignedLongList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidUnsignedLong(values.get(i),
                                               facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidFloatList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidFloat(values.get(i),
                                        facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidDoubleList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidDouble(values.get(i),
                                         facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidDecimalList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidDecimal(values.get(i),
                                          facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidTimeList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidTime(values.get(i),
                                       facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidDateList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidDate(values.get(i),
                                       facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidDateTimeList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidDateTime(values.get(i),
                                           facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidGYearMonthList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidGYearMonth(values.get(i),
                                             facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidGYearList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidGYear(values.get(i),
                                        facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidGMonthDayList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidGMonthDay(values.get(i),
                                            facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidGDayList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidGDay(values.get(i),
                                       facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidGMonthList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidGMonth(values.get(i),
                                         facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidDurationList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidDuration(values.get(i),
                                           facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidBase64BinaryList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidBase64Binary(values.get(i),
                                               facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidHexBinaryList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidHexBinary(values.get(i),
                                            facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidAnyURIList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidAnyURI(values.get(i),
                                         facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidLanguageList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidLanguage(values.get(i),
                                           facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNameList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidName(values.get(i),
                                       facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidQNameList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidQName(values.get(i),
                                        facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNCNameList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNCName(values.get(i),
                                         facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidIntegerList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidInteger(values.get(i),
                                          facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNonNegativeIntegerList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNonNegativeInteger(values.get(i),
                                                     facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidPositiveIntegerList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidPositiveInteger(values.get(i),
                                                  facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNonPositiveIntegerList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNonPositiveInteger(values.get(i),
                                                     facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNegativeIntegerList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNegativeInteger(values.get(i),
                                                  facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidCDATAList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidCDATA(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNMTOKENList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNMTOKEN(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNMTOKENSList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNMTOKEN(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidIDList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidID(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidIDREFList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidIDREF(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidIDREFSList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidIDREFS(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidENTITYList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidENTITY(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidENTITIESList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidENTITIES(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    public static String isValidNOTATIONList(List values, List facets) {
        String message;
        int size = values.size();
        for (int i = 0;i < size;i++) {
            if ((message = isValidNOTATION(values.get(i), facets)) != null) {
                return (message);
            }
        }
        return (null);
    }

    //
    public static boolean isDigit(String string, int offset) {
        switch (string.charAt(offset)) {

        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':
            return (true);
        default:
            return (false);
        }
    }

    public static boolean isChar(String string, String candidates, int offset) {
        char target = string.charAt(offset);
        int size = candidates.length();
        for (int i = 0;i < size;i++) {
            if (target == candidates.charAt(i)) {
                return (true);
            }
        }
        return (false);
    }

    //
    public static List makeFacetList(String facets) {
        if (facets == null) {
            return (null);
        }
        List list = new ArrayList();
        StringTokenizer st = new StringTokenizer(facets, ";");
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int index = token.indexOf(":");
            if (index != -1) {
                String name = token.substring(0, + index).trim();
                String value = token.substring(index + 1).trim();
                if ("length".equals(name)) {
                    list.add(new Object[] { name, new Integer(value) } );
                } else if ("minLength".equals(name)) {
                    list.add(new Object[] { name, new Integer(value) } );
                } else if ("maxLength".equals(name)) {
                    list.add(new Object[] { name, new Integer(value) } );
                } else if ("pattern".equals(name)) {
                    list.add(new Object[] { name, value } );
                } else if ("enumeration".equals(name)) {
                    list.add(new Object[] { name, value } );
                } else if ("whiteSpace".equals(name)) {
                    list.add(new Object[] { name, value } );
                } else if ("maxInclusive".equals(name)) {
                    list.add(new Object[] { name, new BigDecimal(value) } );
                } else if ("maxExclusive".equals(name)) {
                    list.add(new Object[] { name, new BigDecimal(value) } );
                } else if ("minInclusive".equals(name)) {
                    list.add(new Object[] { name, new BigDecimal(value) } );
                } else if ("minExclusive".equals(name)) {
                    list.add(new Object[] { name, new BigDecimal(value) } );
                } else if ("totalDigits".equals(name)) {
                    list.add(new Object[] { name, new Integer(value) } );
                } else if ("fractionDigits".equals(name)) {
                    list.add(new Object[] { name, new Integer(value) } );
                }
            }
        }
        return (list);
    }

    public static String isValidAsNumber(Object object, List facets) {
        if (facets == null) {
            return (null);
        }
        BigDecimal number;
        if (object instanceof BigDecimal) {
            number = (BigDecimal)object;
        } else {
            number = new BigDecimal(object.toString());
        }
        int size = facets.size();
        for (int i = 0;i < size;i++) {
            Object[] tuple = (Object[])facets.get(i);
            if ("maxInclusive".equals(tuple[0])) {
                BigDecimal value = (BigDecimal)tuple[1];
//                System.out.println("maxInclusive");
//                System.out.println("facet = " + value.toString());
//                System.out.println("object = " + number.toString());
//                System.out.println(value.compareTo(number));
                if (value.compareTo(number) < 0) { // XXX
//                    System.out.println("outofrange");
                    return (OUT_OF_RANGE);
                }
            } else if ("maxExclusive".equals(tuple[0])) {
                BigDecimal value = (BigDecimal)tuple[1];
//                System.out.println("maxExclusive");
//                System.out.println("facet = " + value.toString());
//                System.out.println("object = " + number.toString());
//                System.out.println(value.compareTo(number));
                if (value.compareTo(number) <= 0) { // XXX
//                    System.out.println("outofrange");
                    return (OUT_OF_RANGE);
                }
            } else if ("minInclusive".equals(tuple[0])) {
                BigDecimal value = (BigDecimal)tuple[1];
//                System.out.println("minInclusive");
//                System.out.println("facet = " + value.toString());
//                System.out.println("object = " + number.toString());
//                System.out.println(value.compareTo(number));
                if (value.compareTo(number) > 0) { // XXX
//                    System.out.println("outofrange");
                    return (OUT_OF_RANGE);
                }
            } else if ("minExclusive".equals(tuple[0])) {
                BigDecimal value = (BigDecimal)tuple[1];
//                System.out.println("minExclusive");
//                System.out.println("facet = " + value.toString());
//                System.out.println("object = " + number.toString());
//                System.out.println(value.compareTo(number));
                if (value.compareTo(number) >= 0) { // XXX
//                    System.out.println("outofrange");
                    return (OUT_OF_RANGE);
                }
            }
        }
        return (null);
    }

    public static String isValidAsScale(Object object, List facets) {
        if (facets == null) {
            return (null);
        }
        BigDecimal number = _getBigDecimal(object);
        int size = facets.size();
        for (int i = 0;i < size;i++) {
            Object[] tuple = (Object[])facets.get(i);
            if ("totalDigits".equals(tuple[0])) {
                Integer value = (Integer)tuple[1];
                // do nothing
            } else if ("fractionDigits".equals(tuple[0])) {
                Integer value = (Integer)tuple[1];
                // do nothing
            }
        }
        return (null);
    }

    public static String isValidAsString(Object object, List facets) {
        if (facets == null) {
            return (null);
        }
        String string = object.toString();
        int length = string.length();
        int size = facets.size();
        for (int i = 0;i < size;i++) {
            Object[] tuple = (Object[])facets.get(i);
            if ("length".equals(tuple[0])) {
                Integer value = (Integer)tuple[1];
                if (length != value.intValue()) {
                    return (ILLEGAL_LENGTH);
                }
            } else if ("maxLength".equals(tuple[0])) {
                Integer value = (Integer)tuple[1];
                if (length > value.intValue()) {
                    return (ILLEGAL_LENGTH);
                }
            } else if ("minLength".equals(tuple[0])) {
                Integer value = (Integer)tuple[1];
                if (length < value.intValue()) {
                    return (ILLEGAL_LENGTH);
                }
            }
        }
        return (null);
    }

    public static String isValidAsEnumeration(Object object, List facets) {
        if (facets == null) {
            return (null);
        }
        String string = object.toString();
        int size = facets.size();
        boolean available = false;
        for (int i = 0;i < size;i++) {
            Object[] tuple = (Object[])facets.get(i);
            if ("enumeration".equals(tuple[0])) {
                if (string.equals(tuple[1])) {
                    return (null);
                }
                available = true;
            }
        }
        if (available) {
            return (ENUMERATION);
        } else {
            return (null);
        }
    }

    //
    private static BigInteger _getBigInteger(Object value)
        throws NumberFormatException {

        if (value instanceof BigInteger) {
            return ((BigInteger)value);
        }
        String string = value.toString();
        if ("0".equals(string)) {
            return (ZERO_INTEGER);
        }
        if ("1".equals(string)) {
            return (ONE_INTEGER);
        }
        return (new BigInteger(string));
    }

    private static BigDecimal _getBigDecimal(Object value)
        throws NumberFormatException {

        if (value instanceof BigDecimal) {
            return ((BigDecimal)value);
        }
        String string = value.toString();
        if ("0".equals(string)) {
            return (ZERO_DECIMAL);
        }
        if ("1".equals(string)) {
            return (ONE_DECIMAL);
        }
        return (new BigDecimal(string));
    }

    // relaxer object
    // XXX : unused
    public static String isValid(
        Object object,
        String path,
        String typeName,
        String facets
    ) {
        try {
            Class clazz = object.getClass();
            Method method = clazz.getMethod("makeDocument", new Class[0]);
            Document doc = (Document)method.invoke(object, new Object[0]);
            return (isValidDocumentPart(doc, path, typeName, facets));
        } catch (Exception e) {
            return ("???");
        }
    }

    // XXX : unused
    public static String isValidDocumentPart(
        Document doc,
        String path,
        String typeName,
        String facets
    ) {
        String value = getPropertyAsString(doc, path);
        return (isValid(value, typeName, facets));
    }

    // ses USQLNS
    public static String getPropertyAsString(Node node, String path) {
        if ("".equals(path)) {
            return (node2Text(node));
        } else {
            Stack pathlist = _makePathlist(path);
            Node context = _getContextNode(node, pathlist);
            if (context == null) {
                return (null);
            }
            String[] leaf = (String[])pathlist.pop();
            return (getPropertyInContextAsString(context, leaf));
        }
    }

    private static Stack _makePathlist(String path) {
        if ("".equals(path)) {
            return (new Stack());
        }
        int state = 0;
        int size = path.length();
        List list = new ArrayList();
        StringBuffer ns = new StringBuffer();
        StringBuffer local = new StringBuffer();
        StringBuffer prefix = null;
        for (int i = 0;i < size;i++) {
            char c = path.charAt(i);
            switch (state) {
            case 0:
                if (c == '<') {
                    state = 1;
                } else if (c == '/') {
                    String[] name = new String[3];
                    name[0] = new String(ns);
                    name[1] = new String(local);
                    if (prefix != null) {
                        name[2] = new String(prefix);
                    }
                    ns = new StringBuffer();
                    local = new StringBuffer();
                    prefix = null;
                    list.add(name);
                } else if (c == ':') {
                    prefix = local;
                    local = new StringBuffer();
                } else {
                    local.append(c);
                }
                break;
            case 1:
                if (c == '>') {
                    state = 0;
                } else {
                    ns.append(c);
                }
                break;
            default:
                throw (new InternalError());
            }
        }
        if (local.length() > 0) {
            String[] name = new String[3];
            name[0] = new String(ns);
            name[1] = new String(local);
            if (prefix != null) {
                name[2] = new String(prefix);
            }
            list.add(name);
        }
        Stack stack = new Stack();
        size = list.size();
        for (int i = size - 1;i >= 0;i--) {
            String[] name = (String[])list.get(i);
            stack.push(name);
        }
        return (stack);
    }

    private static Node _getContextNode(
        Node node,
        Stack pathlist
    ) {
        if (pathlist.size() == 0) {
            return (node);
        }
        if (pathlist.size() == 1) {
        }
        while (!(pathlist.size() == 1)) {
            String[] nodeName = (String[])pathlist.pop();
            Node target = _getTargetNode(node, nodeName);
            if (target == null) {
                return (null);
            }
            node = target;
        }
        return (node);
    }

    private static Node _getTargetNode(
        Node context,
        String[] nodeName
    ) {
        NodeList children = context.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (_isTargetElement(child, nodeName)) {
                return (child);
            }
        }    
        return (null);
    }

    public static String getPropertyInContextAsString(
        Node context,
        String[] leaf
    ) {
        int index = leaf[1].indexOf("@");
        if (index == -1) {
            return (getElementPropertyAsString(context, leaf));
        } else {
            return (getAttributePropertyAsString(context, leaf));
        }
    }

    public static String getAttributePropertyAsString(
        Node node,
        String[] name
    ) {
        Element element = (Element)node;
        String attrName = name[1].substring(1);
        Attr attr;
        if ("".equals(name[0])) {
            attr = element.getAttributeNode(attrName);
        } else {
            attr = element.getAttributeNodeNS(name[0], attrName);
        }
        if (attr == null) {
            return (null);
        }
        return (attr.getValue());
    }

    public static String getElementPropertyAsString(
        Node node,
        String[] name
    ) {
        Element element = (Element)node;
        NodeList children = element.getChildNodes();
        int size = children.getLength();
        for (int i = 0;i < size;i++) {
            Node child = children.item(i);
            if (_isTargetElement(child, name)) {
                return (node2Text(child));
            }
        }
        return (null);
    }

    private static boolean _isTargetElement(
        Node node,
        String[] name
    ) {
        if (!(node instanceof Element)) {
            return (false);
        }
        String ns = node.getNamespaceURI();
        if (ns == null) {
            ns = "";
        }
        String local = node.getLocalName();
        if (local == null) {
            local = node.getNodeName();
        }
        return (name[0].equals(ns) && name[1].equals(local));
    }

    public static String node2Text(Node node) {
        StringBuffer buffer = new StringBuffer();
        node2Text(node, buffer);
        return (new String(buffer));
    }

    public static void node2Text(Node node, StringBuffer buffer) {
        switch(node.getNodeType()) {

        case Node.DOCUMENT_NODE:
        case Node.ELEMENT_NODE:
        case Node.ENTITY_REFERENCE_NODE:
            NodeList nodes = node.getChildNodes();
            int nNodes = nodes.getLength();
            for (int i = 0;i < nNodes;i++) {
                node2Text(nodes.item(i), buffer);
            }
            break;
        case Node.ATTRIBUTE_NODE:
            throw (new UnsupportedOperationException("not supported yet"));
        case Node.COMMENT_NODE:
        case Node.PROCESSING_INSTRUCTION_NODE:
            // do nothing
            break;
        case Node.TEXT_NODE:
        case Node.CDATA_SECTION_NODE:
            Text text = (Text)node;
            buffer.append(text.getData());
            break;
        default:
            throw (new UnsupportedOperationException("not supported yet"));
        }
    }
}
