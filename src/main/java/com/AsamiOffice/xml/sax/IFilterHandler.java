package com.AsamiOffice.xml.sax;

import org.xml.sax.*;

/**
 * IFilterHandler
 *
 * @since   Feb. 20, 2001
 * @version Apr. 19, 2001
 * @author  ASAMI, Tomoharu (asami@zeomtech.com)
 */
public interface IFilterHandler
    extends EntityResolver, DTDHandler, ContentHandler, ErrorHandler {

    void setEntityResolver(EntityResolver resolver);
    void setDTDHandler(DTDHandler dtd);
    void setContentHandler(ContentHandler content);
    void setErrorHandler(ErrorHandler error);
    EntityResolver getEntityResolver();
    DTDHandler setDTDHandler();
    ContentHandler setContentHandler();
    ErrorHandler setErrorHandler();
}
