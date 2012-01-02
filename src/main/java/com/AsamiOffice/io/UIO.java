/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@AsamiOffice.com)
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

package com.AsamiOffice.io;

import java.io.*;
import java.net.*;

import com.AsamiOffice.text.UString;

/**
 * Utilites for I/O operation
 *
 * @since   Feb.  8, 1998
 * @version Dec. 30, 2003
 * @author  ASAMI, Tomoharu (asami@AsamiOffice.com)
 */
public final class UIO {
    public static String uri2String(String uri) throws IOException {
        try {
            URL url = new URL(uri);
            return (URL2String(url));
        } catch (IOException e) {
        }
        return (file2String(uri));
    }

    public static String uri2String(String uri, String encoding)
        throws IOException {

        try {
            URL url = new URL(uri);
            return (URL2String(url, encoding));
        } catch (IOException e) {
        }
        return (file2String(uri, encoding));
    }

    public static String file2String(String file) throws IOException {
        InputStream in = null;
        String result = null;
        try {
            in = new FileInputStream(file);
            result = stream2String(in);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String file2String(File file) {
        InputStream in = null;
        String result = null;
        try {
            in = new FileInputStream(file);
            result = stream2String(in);
        } catch (IOException e) {
            throw (new IllegalArgumentException(e.getMessage()));
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String URL2String(URL url) throws IOException {
        InputStream in = null;
        String result = null;
        try {
            in = url.openStream();
            result = stream2String(in);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String resource2String(String resource, Object base)
        throws IOException {

        return (resource2String(resource, base.getClass()));
    }

    public static String resource2String(String resource, Class clazz)
        throws IOException {

        return (resource2String(resource, clazz.getClassLoader()));
    }

    public static String resource2String(String resource, ClassLoader loader)
        throws IOException {

        InputStream in = null;
        String result = null;
        try {
            URL url = UURL.getURLFromResourceName(resource, loader);
	    if (url == null) {
		throw (new IOException(resource));
	    }
            in = url.openStream();
            result = stream2String(in);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String stream2String(InputStream in) throws IOException {
        Reader reader = null;
        StringWriter writer = null;
        String result = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            writer = new StringWriter();
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            writer.flush();
            result = new String(writer.getBuffer());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return (result);
    }

    public static String file2String(String file, String encoding)
        throws IOException {
        InputStream in = null;
        String result = null;
        try {
            in = new FileInputStream(file);
            result = stream2String(in, encoding);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String file2String(File file, String encoding)
        throws IOException {
        InputStream in = null;
        String result = null;
        try {
            in = new FileInputStream(file);
            result = stream2String(in, encoding);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String URL2String(URL url, String encoding)
        throws IOException {
        InputStream in = null;
        String result = null;
        try {
            in = url.openStream();
            result = stream2String(in, encoding);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String resource2String(
        String resource,
        Object base,
        String encoding)
        throws IOException {
        return (resource2String(resource, base.getClass(), encoding));
    }

    public static String resource2String(
        String resource,
        Class clazz,
        String encoding)
        throws IOException {
        return (resource2String(resource, clazz.getClassLoader(), encoding));
    }

    public static String resource2String(
        String resource,
        ClassLoader loader,
        String encoding)
        throws IOException {
        InputStream in = null;
        String result = null;
        try {
            URL url = UURL.getURLFromResourceName(resource, loader);
            in = url.openStream();
            result = stream2String(in, encoding);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static String stream2String(InputStream in, String encoding)
        throws IOException {
        Reader reader = null;
        StringWriter writer = null;
        String result = null;
        try {
            reader = new BufferedReader(new InputStreamReader(in, encoding));
            writer = new StringWriter();
            int c;
            while ((c = reader.read()) != -1) {
                writer.write(c);
            }
            writer.flush();
            result = new String(writer.getBuffer());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
        return (result);
    }

    public static byte[] file2Bytes(String file) throws IOException {
        InputStream in = null;
        byte[] result = null;
        try {
            in = new FileInputStream(file);
            result = stream2Bytes(in);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static byte[] file2Bytes(File file) throws IOException {
        InputStream in = null;
        byte[] result = null;
        try {
            in = new FileInputStream(file);
            result = stream2Bytes(in);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static byte[] URL2Bytes(URL url) throws IOException {
        InputStream in = null;
        byte[] result = null;
        try {
            in = url.openStream();
            result = stream2Bytes(in);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static byte[] resource2Bytes(String resource, Object base)
        throws IOException {

        return (resource2Bytes(resource, base.getClass()));
    }

    public static byte[] resource2Bytes(String resource, Class clazz)
        throws IOException {

        return (resource2Bytes(resource, clazz.getClassLoader()));
    }

    public static byte[] resource2Bytes(String resource, ClassLoader loader)
        throws IOException {

        InputStream in = null;
        byte[] result = null;
        try {
            URL url = UURL.getURLFromResourceName(resource, loader);
	    in = url.openStream();
            result = stream2Bytes(in);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static byte[] stream2Bytes(InputStream in) throws IOException {
        ByteArrayOutputStream out = null;
        byte[] result = null;
        try {
            byte[] buffer = new byte[8192];
            out = new ByteArrayOutputStream();
            int size;
            while ((size = in.read(buffer)) != -1) {
                out.write(buffer, 0, size);
            }
            out.flush();
            result = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
        }
        return (result);
    }

    public static void concatStreams(InputStream in, OutputStream out)
        throws IOException {

        byte[] buffer = new byte[8192];
        int rsize;
        while ((rsize = in.read(buffer)) != -1) {
            out.write(buffer, 0, rsize);
        }
        out.flush();
    }
    
    public static ClassLoader makeClasspathClassLoader(String classpath)
        throws MalformedURLException {
        return (makeClasspathClassLoader(classpath, ": ,"));
    }

    public static ClassLoader makeClasspathClassLoader(
        String classpath,
        String delimiter
    ) throws MalformedURLException {
        String[] paths = UString.getTokens(classpath, delimiter);
        URL[] urls = new URL[paths.length];
        for (int i = 0; i < paths.length; i++) {
            String path = paths[i];
            urls[i] = UURL.getURLFromFileOrURLName(path);
        }
        return (new URLClassLoader(urls));
    }
}
