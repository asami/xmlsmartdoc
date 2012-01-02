/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2005  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.normalizer;

import java.util.Locale;

import org.xmlsmartdoc.SmartDoc.Content;
import org.xmlsmartdoc.SmartDoc.DocContext;
import org.xmlsmartdoc.SmartDoc.Ref;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocContext;
import com.AsamiOffice.text.UString;

/**
 * HrefNormalizer
 * 
 * @since   Jun. 15, 1999
 * @version Jun. 10, 2005
 * @author ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HrefNormalizer extends AbstractNormalizer {
    protected Content[] _normalize(Content[] contents, Content parent,
        DocContext context) {
        if (parent instanceof Ref) { // XXX : HRefable
            Ref ref = (Ref)parent;
            String href = ref.getHref();
            int type = ref.getType();
            if (type == Ref.SITE_LINK) {
                resolveSiteLink_(ref, context);
            }
            if (type == Ref.HYPER_LINK) {
                int index = href.indexOf("#");
                String file;
                String content;
                if (index != -1) {
                    file = href.substring(0, index);
                    content = href.substring(index + 1);
                } else {
                    file = href;
                    content = null;
                }
                if (UString.getSuffix(file) == null && !file.endsWith("/")) {
                    String suffix = context.getFormatConfig().getSuffix();
                    Locale locale = parent.getLocale();
                    SmartDocConfig config = SmartDocContext.getContext()
                            .getConfig();
                    if (locale == null) {
                        file = file + "." + suffix;
                    } else if (locale.equals(config.getMasterLocale())) {
                        file = file + "." + suffix;
                    } else {
                        file = file + "_" + locale + "." + suffix;
                    }
                    if (content == null) {
                        href = file;
                    } else {
                        href = file + "#" + content;
                    }
                    ref.setHref(href);
                }
            }
        }
        return (contents);
    }

    private void resolveSiteLink_(Ref ref, DocContext context) {
        String href = context.resolveSiteLink(ref.getHref());
        if (href != null) {
            ref.setSiteLink(href);
        }
    }
}