/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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
package org.xmlsmartdoc.SmartDoc.html4;

import org.xmlsmartdoc.SmartDoc.Chapter;
import org.xmlsmartdoc.SmartDoc.Doc;
import org.xmlsmartdoc.SmartDoc.Section;
import org.xmlsmartdoc.SmartDoc.SmartDocModel;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;

/**
 * HTML4Generator
 *
 * @since   Sep. 23, 1998
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class HTML4Generator extends AbstractHTML4Generator {
    public GeneratorArtifact generateWhole(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateWhole(doc, deploy, model));
    }

    public GeneratorArtifact generateTitle(
        Doc doc,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateTitle(doc, deploy, model));
    }

    public GeneratorArtifact generateChapter(
        Doc doc,
        Chapter chapter,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateChapter(doc, chapter, deploy, model));
    }

    public GeneratorArtifact generateSection(
        Doc doc,
        Section section,
        String deploy,
        SmartDocModel model
    ) {
        return (super.generateSection(doc, section, deploy, model));
    }
}
