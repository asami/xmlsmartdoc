/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2002  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc;

import java.util.*;
import java.io.*;
import com.AsamiOffice.jaba2.util.ExtensibleFactory;
import org.xmlsmartdoc.SmartDoc.normalizer.*;
import org.xmlsmartdoc.SmartDoc.control.*;

/**
 * NormalizerFactory
 *
 * @since   Mar. 31, 1999
 * @version Oct. 22, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public final class NormalizerFactory extends ExtensibleFactory {
    protected static NormalizerFactory factory__ = new NormalizerFactory();

    public static NormalizerFactory getFactory() {
        return (factory__);
    }

    protected NormalizerFactory() {
        try {
            _setup(getClass().getResource(
                "/org/xmlsmartdoc/SmartDoc/Normalizer.xml"
            ));
        } catch (IOException e) {
            throw (new SmartDocErrorException(e));
        }
    }

    public INormalizer getNormalizer(String name) {
        if ("none".equals(name)) {
            return (null);
        }
        INormalizer normalizer = (INormalizer)getTargetObject(name);
        if (normalizer == null) {
            USmartDoc.warning("invalid normalizer: " + name);
            return (null);
        }
        return (normalizer);
    }

    public INormalizer[] getNormalizers(String[] names) {
        List list = new ArrayList();
        for (int i = 0;i < names.length;i++) {
            INormalizer normalizer = getNormalizer(names[i]);
            if (normalizer != null) {
                list.add(normalizer);
            }
        }
        INormalizer[] normalizers = new INormalizer[list.size()];
        return ((INormalizer[])list.toArray(normalizers));
    }

    public INormalizer[] getDefaultNormalizers(Content content) {
        if (content instanceof Paragraph) {
            return (null);        // XXX
//            return (new INormalizer[] {getNormalizer("naturallabel")});        // XXX
        } else if (content instanceof Sentence) {
            return (null);
        } else if (content instanceof Table) {
            return (null);
        } else if (content instanceof Colgroup) {
            return (new INormalizer[] {getNormalizer("tag")});
        } else if (content instanceof Col) {
            return (null);
        } else if (content instanceof Pre) {
            return (null);
        } else if (content instanceof Title) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Program) {
            return (new INormalizer[] {getNormalizer("program")});
        } else if (content instanceof Console) {
            return (new INormalizer[] {getNormalizer("console")});
        } else if (content instanceof Equation) {
            return (new INormalizer[] {getNormalizer("tex")});
        } else if (content instanceof Native) {
            return (null);
        } else if (content instanceof THead) {
            return (new INormalizer[] {getNormalizer("csvthead")});
        } else if (content instanceof TFoot) {
            return (new INormalizer[] {getNormalizer("csvthead")});
        } else if (content instanceof TBody) {
            return (new INormalizer[] {getNormalizer("csvtbody")});
        } else if (content instanceof Tr) {
            return (new INormalizer[] {getNormalizer("csvtr")});
        } else if (content instanceof Th) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Td) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Ref) {
            return (new INormalizer[] {getNormalizer("href")});
        } else if (content instanceof Img) {
            return (null);
//            return (new INormalizer[] {getNormalizer("image")});
        } else if (content instanceof ImageFigure) {
            return (null);
//            return (new INormalizer[] {getNormalizer("image")});
        } else if (content instanceof Ul) {
            return (new INormalizer[] {getNormalizer("tag")});
        } else if (content instanceof Ol) {
            return (new INormalizer[] {getNormalizer("tag")});
        } else if (content instanceof Dl) {
            return (new INormalizer[] {getNormalizer("tag")});
        } else if (content instanceof Li) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Dt) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Dd) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Note) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else if (content instanceof Define) {
            return (null);
        } else if (content instanceof Summary) {
            return (new INormalizer[] {getNormalizer("naturallabel")});
        } else {
            switch (content.getEntityType()) {

            case Content.ENTITY_BLOCK:
                return (new INormalizer[] {getNormalizer("natural")});
            case Content.ENTITY_INLINE:
                return (null);
            case Content.ENTITY_CONTAINER:
                return (null);
            case Content.ENTITY_CONTROL:
                return (new INormalizer[] {getNormalizer("tag")});
            default:
                throw (new InternalError());
            }
        }
    }
}
