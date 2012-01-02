/*
 * SmartDoc : Ultimate document format based on XML
 *  Copyright (C) 1998-2004  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.latex2e;

import java.io.File;
import java.io.IOException;

import org.xmlsmartdoc.SmartDoc.SmartDocErrorException;
import com.AsamiOffice.text.UString;
import com.AsamiOffice.jaba2.util.CommandAgent;

import com.AsamiOffice.jaba2.io.FilePath;

import com.AsamiOffice.io.SuffixFilenameFilter;
import com.AsamiOffice.io.UIO;

/**
 * LaTeX2eAgent
 *
 * @since   May. 24, 1999
 * @version Mar. 12, 2004
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class LaTeX2eAgent {
    protected File dir_;
    protected String target_;
    protected String latexCommand_;
    protected String bibtexCommand_;
    protected String dvipsCommand_;
    protected String dvipdfmCommand_;
    protected String out2uniCommand_;
    private boolean makePdf_ = false;

    public LaTeX2eAgent(File target) {
        dir_ = target.getParentFile();
        target_ = target.getName();
        String contents = UIO.file2String(target);
        if (_isAsciiPTeX(contents)) {
            _setupAsciiPTeX();
        } else if (_isNttJTeX(contents)) {
            _setupNttJTeX();
        } else {
            _setupPlainTeX();
        }
    }

    private boolean _isAsciiPTeX(String contents) {
        int index = contents.indexOf("\\documentclass");
        if (index == -1) {
            return (false);
        }
        int end = contents.indexOf("}", index);
        if (end == -1) {
            return (false);
        }
        String area = contents.substring(index, end);
        if (area.indexOf("{j-", index) != -1) {
            return (false);
        }
        if (area.indexOf("{j", index) != -1) {
            return (true);
        }
        return (false);
    }

    private boolean _isNttJTeX(String contents) {
        int index = contents.indexOf("\\documentclass");
        if (index == -1) {
            return (false);
        }
        int end = contents.indexOf("}", index);
        if (end == -1) {
            return (false);
        }
        String area = contents.substring(index, end);
        if (area.indexOf("{j-", index) != -1) {
            return (true);
        }
        return (false);
    }

    private void _setupPlainTeX() {
        System.out.println("Plain TeX");
        latexCommand_ = "latex $input";
        bibtexCommand_ = "bibtex $input";
        dvipsCommand_ = "dvips $input >$output";
        dvipdfmCommand_ = "dvipdfm $input";
        out2uniCommand_ = "out2uni $input";
    }

    private void _setupAsciiPTeX() {
        System.out.println("ASCII p-TeX");
        latexCommand_ = "platex $input";
        bibtexCommand_ = "jbibtex $input";
        dvipsCommand_ = "dvipsk $input >$output";
        dvipdfmCommand_ = "dvipdfm $input";
        out2uniCommand_ = "out2uni $input";
    }

    private void _setupNttJTeX() {
        System.out.println("NTT j-TeX");
        latexCommand_ = "jlatex $input";
        bibtexCommand_ = "jbibtex $input";
        dvipsCommand_ = "dvi2ps $input >$output";
        dvipdfmCommand_ = "dvipdfm $input";
        out2uniCommand_ = "out2uni $input";
    }

    public File generateDVIFile() throws IOException {
        boolean needRetry = _runLaTeXCommand(target_, dir_);
        if (_needBibTeX(dir_)) {
            _runBibTeXCommand(target_, dir_);
            needRetry = true;
        }
        if (needRetry) {
            needRetry = _runLaTeXCommand(target_, dir_);
        }
        if (_needOut2Uni()) {
            _runOut2UniCommand(target_, dir_);
            needRetry = true;
        }
        int retries = 2;
        while (needRetry && --retries > 0) {
            needRetry = _runLaTeXCommand(target_, dir_);
        }
        FilePath path = new FilePath(dir_, target_);
        FilePath newPath = path.changeSuffix("dvi");
        return (newPath.getFile());
    }

    private boolean _needBibTeX(File dir) {
        return (dir.list(new SuffixFilenameFilter("bib")).length > 0);
    }

    private boolean _needOut2Uni() {
        return (makePdf_);
    }

    protected boolean _runLaTeXCommand(String target, File dir)
        throws IOException {

        CommandAgent agent = new CommandAgent(
            latexCommand_,
            target,
            dir
        );
        agent.addInputHandler(new CommandAgent.Handler() {
            public CommandAgent.HandlerResult handle(String input) {
                CommandAgent.HandlerResult result
                    = new CommandAgent.HandlerResult();
                System.out.println(input);
                if (input.indexOf("LaTeX Error:") != -1) {
                    result.message = input;
                    result.state = CommandAgent.FINISH;
                }
                if (input.indexOf("LaTeX Waring:") != -1) {
                    result.message = input;
                }
                if (input.indexOf("No file") != -1) {
                    result.message = input;
                }
                if (input.indexOf("Output written") != -1) {
                    result.state = CommandAgent.FINISH;
                }
                return (result);
            }
        });
        agent.start();
        agent.waitFinish();
        String[] messages = agent.getMessages();
        for (int i = 0;i < messages.length;i++) {
            String message = messages[i];
// No file pre.aux.
            if (message.indexOf("No file") != -1) {
                return (true);
            }
// LaTeX Warning: Label(s) may have changed. Rerun to get cross-references right.
            if (message.indexOf("changed") != -1) {
                return (true);
            }
            if (message.indexOf("LaTeX Error:") != -1) {
                throw (new SmartDocErrorException(message));
            }
        }
        return (false);
    }

    protected void _runBibTeXCommand(String target, File dir)
        throws IOException {

        String body = UString.getLastComponentBody(target);
        CommandAgent agent = new CommandAgent(
            bibtexCommand_,
            body,
            dir
        );
        agent.start();
        agent.waitFinish();
    }

    protected void _runOut2UniCommand(String target, File dir)
        throws IOException {

        String body = UString.getLastComponentBody(target);
        CommandAgent agent = new CommandAgent(
            out2uniCommand_,
            body,
            dir
        );
        agent.start();
        agent.waitFinish();
    }

    public File generatePostScriptFile() throws IOException {
        File dviFile = generateDVIFile();
        String filename = dviFile.getName();
        CommandAgent agent = new CommandAgent(
            dvipsCommand_,
            filename,
            UString.changeSuffix(filename, "ps"),
            dir_
        );
        agent.start();
        agent.waitFinish();
        String[] messages = agent.getMessages();
        for (int i = 0;i < messages.length;i++) {
            String message = messages[i];
        }
        FilePath path = new FilePath(dir_, target_);
        FilePath newPath = path.changeSuffix("ps");
        return (newPath.getFile());
    }

    public File generatePDFFile() throws IOException {
        makePdf_ = true;
        File dviFile = generateDVIFile();
        String filename = dviFile.getName();
        CommandAgent agent = new CommandAgent(
            dvipdfmCommand_,
            filename,
            dir_
        );
        agent.start();
        agent.waitFinish();
        String[] messages = agent.getMessages();
        for (int i = 0;i < messages.length;i++) {
            String message = messages[i];
        }
        FilePath path = new FilePath(dir_, target_);
        FilePath newPath = path.changeSuffix("pdf");
        return (newPath.getFile());
    }

    // test driver
    public static void main(String[] args) throws Exception {
        String file = args[0];
        String dir = args[1];
        LaTeX2eAgent agent = new LaTeX2eAgent(new File(dir, file));
        File dviFile = agent.generateDVIFile();
        System.out.println(dviFile);
//        File psFile = agent.generatePostScriptFile();
//        System.out.println(psFile);
        System.exit(0);
    }
}
