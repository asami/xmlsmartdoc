package com.AsamiOffice.jaba2.awt;

import java.awt.*;
import java.io.File;
import java.net.URL;

/**
 * The UImage is a utility class to manipulate a Image object.
 *
 * @since   Jun.  7, 1998
 * @version May.  8, 1999
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public final class UImage {
    private static Toolkit toolkit__ = Toolkit.getDefaultToolkit();

    /**
     *
     */
    public static Image getImage(String name, Object base) {
	URL url = base.getClass().getResource(name);
	Image image = toolkit__.getImage(url);
	return (image);
    }

    /**
     *
     */
    public static Image getImage(String filename) {
	Image image = toolkit__.getImage(filename);
	return (image);
    }

    /**
     *
     */
    public static Image getImage(File file) {
	Image image = toolkit__.getImage(file.getPath());
	return (image);
    }

    /**
     *
     */
    public static Image getImage(URL url) {
	Image image = toolkit__.getImage(url);
	return (image);
    }

    public static void waitLoading(Image image, Component comp) {
	MediaTracker mt = new MediaTracker(comp);
	mt.addImage(image, 0);
	try {
	    mt.waitForAll();
	} catch (Exception e) {
	}
    }

    public static Dimension getSize(String file) {
	Image image = Toolkit.getDefaultToolkit().getImage(file);
	return (getSize(image));
    }

    public static Dimension getSize(Image image) {
	Component comp = new javax.swing.JPanel();
	waitLoading(image, comp);
	int width = image.getWidth(comp);
	int height = image.getHeight(comp);
	return (new Dimension(width, height));
    }
}
