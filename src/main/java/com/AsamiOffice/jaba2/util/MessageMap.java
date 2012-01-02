package com.AsamiOffice.jaba2.util;

import java.util.*;
import java.io.*;
import java.net.URL;

/**
 * MessageMap
 *
 * @since   Oct.  2, 1998
 * @version Oct. 19, 1998
 * @author  ASAMI, Tomoharu (tasami@ibm.net)
 */
public class MessageMap {
    protected Map messages_ = new HashMap();

    public MessageMap(URL url)
	throws IOException, UnsupportedEncodingException {

	String encoding = _searchEncoding(url);
	if (encoding != null) {
	    _init(new InputStreamReader(url.openStream(), encoding));
	} else {
	    _init(new InputStreamReader(url.openStream()));
	}
    }

    public MessageMap(InputStream in) {
	_init(new InputStreamReader(in));
    }

    public MessageMap(InputStream in, String encoding)
	throws UnsupportedEncodingException {

	_init(new InputStreamReader(in, encoding));
    }

    private void _init(Reader reader) {
	BufferedReader br = new BufferedReader(reader);
	try {
	    String line;
	    while ((line = br.readLine()) != null) {
		if (line.charAt(0) == '#') {
		    continue;
		}
		StringTokenizer st = new StringTokenizer(line, "\t");
		String key = st.nextToken();
		String value = st.nextToken();
		messages_.put(key, value);
	    }
	} catch (Exception e) {	// XXX
	    e.printStackTrace();
	}
    }

    public String getMessage(String key) {
	return ((String)messages_.get(key));
    }

    protected String _searchEncoding(URL url) throws IOException {
	String encoding = null;
	BufferedReader br = new BufferedReader(
	    new InputStreamReader(url.openStream())
	);
	try {
	    String line;
	    while ((line = br.readLine()) != null) {
		if (line.charAt(0) == '#') {
		    int index = line.indexOf("encoding=");
		    if (index != -1) {
			return (line.substring(index + "encoding=".length()));
		    }
		}
	    }
	} catch (Exception e) {	// XXX
	    e.printStackTrace();
	}
	return (encoding);
    }
}
