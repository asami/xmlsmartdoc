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

package org.xmlsmartdoc.SmartDoc.postscript;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.AbstractSmartDocGenerator;
import org.xmlsmartdoc.SmartDoc.GeneratorParameter;
import org.xmlsmartdoc.SmartDoc.SmartDocConfig;
import org.xmlsmartdoc.SmartDoc.SmartDocFormatConfig;
import org.xmlsmartdoc.SmartDoc.USmartDoc;
import org.xmlsmartdoc.SmartDoc.latex2e.LaTeX2eAgent;
import org.xmlsmartdoc.SmartDoc.latex2e.LaTeX2eGenerator;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorArtifact;
import com.AsamiOffice.jaba2.j2fw.generator.GeneratorResult;
import com.AsamiOffice.jaba2.j2fw.generator.IGeneratorParameter;
import com.AsamiOffice.jaba2.j2fw.generator.LinkArtifact;

import com.AsamiOffice.io.UFile;

/**
 * PostScriptGenerator
 *
 * @since   May. 17, 1999
 * @version Oct. 20, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class PostScriptGenerator extends AbstractSmartDocGenerator {
    protected PostScriptConfig psConfig_;
    protected LaTeX2eGenerator latex2eGenerator_;

    public void init(SmartDocConfig config, SmartDocFormatConfig fconfig) {
        super.init(config, fconfig);
        psConfig_ = (PostScriptConfig)fconfig;
        latex2eGenerator_
            = (LaTeX2eGenerator)psConfig_.getDelegationGenerator();
    }

    // AbstractYaGenerator
    public GeneratorResult generate(IGeneratorParameter iparam) {
        GeneratorParameter param = (GeneratorParameter)iparam;
        GeneratorResult result = latex2eGenerator_.generate(param);
        try {
            File dir = UFile.createTempDir("sdoc");
            // XXX : register to the monitor for cleanup before exiting
            GeneratorArtifact[] artifacts = result.getArtifacts();
            for (int i = 0;i < artifacts.length;i++) {
                GeneratorArtifact artifact = artifacts[i];
                File file = artifact.makeFile(dir);
                if (file != null) {
                    file.deleteOnExit();
                }
/*
                File file = new File(dir, artifact.name);
                if ("link".equals(artifact.encoding)) {
                    UFile.copyFile(new File(artifact.content), file);
                } else {
                    UFile.createFile(
                        file,
                        artifact.content,
                        artifact.encoding
                    );
                }
                file.deleteOnExit();
                // XXX : register to the monitor for cleanup before exiting
*/
            }
            File target = new File(dir, _getTargetFile(artifacts));
            LaTeX2eAgent agent = new LaTeX2eAgent(target);
            File psFile = agent.generatePostScriptFile();
            GeneratorResult finalResult = new GeneratorResult();
            finalResult.addArtifact(
                new LinkArtifact(psFile.getName(), psFile.getPath())
            );
/*
            finalResult.addArtifact(
                psFile.getName(),
                psFile.getPath(),
                "link"
            );
*/
            return (finalResult);
        } catch (IOException e) {
            USmartDoc.error(e.getMessage());
        }
        return (result);
    }

    protected String _getTargetFile(GeneratorArtifact[] artifacts) {
        for (int i = 0;i < artifacts.length;i++) {
            GeneratorArtifact artifact = artifacts[i];
            String name = artifact.getName();
            if (name.endsWith(".tex")) {
                return (name);
            }
        }
        throw (new InternalError());
    }
}
