/*
 * com.AsamiOffice
 *  Copyright (C) 2000-2004  ASAMI, Tomoharu (asami@relaxer.org)
 */
package com.AsamiOffice.util;

/**
 * UClass
 *
 * @since   2004/04/13
 * @version 2004/04/13
 * @author  ASAMI, Tomoharu (asami@relaxer.org)
 */
public class UClass {
    public static String getPackageName(Class clazz) {
       Package target = clazz.getPackage();
       if (target != null) {
           return (target.getName());
       } else {
           String className = clazz.getName();
           int index = className.lastIndexOf("."); 
           if (index == -1) {
               return (null);
           } else { // JDK problem?
               return (className.substring(0, index));
           }
       }
    }
}
