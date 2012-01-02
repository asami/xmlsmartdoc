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

/**
 * RVerifyContext
 *
 * @since   Aug. 26, 2001
 * @version Oct. 21, 2003
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public final class RVerifyContext implements IRVerifyConstants {
    public boolean isOne(Object value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(boolean value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(byte value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(short value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(int value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(long value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(float value) {
        return (URVerify.isOne(value));
    }

    public boolean isOne(double value) {
        return (URVerify.isOne(value));
    }

    public boolean isOneMore(List values) {
        return (URVerify.isOneMore(values));
    }

    // simple
    public String isValidOrNull(Object value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(
        Object value,
        String typeName,
        String facets
    ) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(boolean value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(
        boolean value,
        String typeName,
        String facets
    ) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(byte value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(byte value, String typeName, String facets) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(short value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(short value, String typeName, String facets) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(int value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(int value, String typeName, String facets) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(long value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(long value, String typeName, String facets) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(float value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(float value, String typeName, String facets) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValidOrNull(double value, String typeName) {
        return (URVerify.isValidOrNull(value, typeName));
    }

    public String isValidOrNull(double value, String typeName, String facets) {
        return (URVerify.isValidOrNull(value, typeName, facets));
    }

    public String isValid(Object value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(Object value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }    

    public String isValid(boolean value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(boolean value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValid(byte value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(byte value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValid(short value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(short value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValid(int value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(int value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValid(long value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(long value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValid(float value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(float value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValid(double value, String typeName) {
        return (URVerify.isValid(value, typeName));
    }

    public String isValid(double value, String typeName, String facets) {
        return (URVerify.isValid(value, typeName, facets));
    }

    public String isValidListZeroMore(String values, String typeName) {
        return (URVerify.isValidListZeroMore(values, typeName));
    }

    public String isValidListZeroMore(
        String values,
        String typeName,
        String facets
    ) {
        return (URVerify.isValidListZeroMore(values, typeName));
    }

    public String isValidListZeroMore(List values, String typeName) {
        return (URVerify.isValidListZeroMore(values, typeName));
    }

    public String isValidListZeroMore(
        List values,
        String typeName,
        String facets
    ) {
        return (URVerify.isValidListZeroMore(values, typeName));
    }

    public String isValidListOneMore(String values, String typeName) {
        return (URVerify.isValidListOneMore(values, typeName));
    }

    public String isValidListOneMore(
        String values,
        String typeName,
        String facets
    ) {
        return (URVerify.isValidListOneMore(values, typeName));
    }

    public String isValidListOneMore(List values, String typeName) {
        return (URVerify.isValidListOneMore(values, typeName));
    }

    public String isValidListOneMore(
        List values,
        String typeName,
        String facets
    ) {
        return (URVerify.isValidListOneMore(values, typeName));
    }

    // XXX : unused
    public String isValid(
        Object value,
        String path,
        String typeName,
        String facets
    ) {
        return (URVerify.isValid(value, path, typeName, facets));
    }
}
