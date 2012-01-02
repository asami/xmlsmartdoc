/*
 * The JabaJaba class library
 *  Copyright (C) 1997-2003  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
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

package org.xmlsmartdoc.SmartDoc.mathml;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xmlsmartdoc.SmartDoc.mathml.*;

import org.xmlsmartdoc.SmartDoc.mathml.rParts.*;

/**
 * LaTeXMaker
 *
 * @since   Sep.  2, 2000
 * @version Oct. 17, 2003
 * @author  ASAMI, Tomoharu (asami@XMLSmartDoc.org)
 */
public class LaTeXMaker implements IRVisitor, IMathMLConstants {
    private List list_;
    private Stack stack_ = new Stack();

    public String getText() {
        StringBuffer buffer = new StringBuffer();
        int size = list_.size();
        for (int i = 0;i < size;i++) {
            buffer.append(list_.get(i).toString());
        }
        return (new String(buffer));
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMath visitable) {
        list_ = new ArrayList();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMath visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMi visitable) {
        _append(visitable.getPcdataAsString());
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMi visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMalignmark visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMalignmark visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMn visitable) {
        _append(visitable.getPcdataAsString());
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMn visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMo visitable) {
        _append(visitable.getPcdataAsString());
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMo visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMtext visitable) {
        _append("\\textrm{");
        _append(visitable.getPcdataAsString());
        _append("}");
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMtext visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMs visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMs visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMspace visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMspace visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMrow visitable) {
        _push();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMrow visitable) {
        _append(_pop());
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMprescripts visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMprescripts visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MNone visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MNone visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMfrac visitable) {
        _push();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMfrac visitable) {
        List list = _pop();
        _append("\\frac{");
        _append(list.get(0));
        _append("}{");
        _append(list.get(1));
        _append("}");
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMsqrt visitable) {
        _push();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMsqrt visitable) {
        List list = _pop();
        _append("\\sqrt");
        if (false) {
            _append("[");
            _append("]");
        }
        _append("{");
        _append(list.get(0));
        _append("}");
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMroot visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMroot visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMstyle visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMstyle visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMerror visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMerror visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMpadded visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMpadded visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMphantom visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMphantom visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMfenced visitable) {
        _push();
        _append("(");
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMfenced visitable) {
        _append(")");
        _append(_pop());
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMsub visitable) {
        _push();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMsub visitable) {
        List list = _pop();
        _append(list.get(0));
        _append("_{");
        _append(list.get(1));
        _append("}");
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMsup visitable) {
        _push();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMsup visitable) {
        List list = _pop();
        _append(list.get(0));
        _append("^{");
        _append(list.get(1));
        _append("}");
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMsubsup visitable) {
        _push();
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMsubsup visitable) {
        List list = _pop();
        _append(list.get(0));
        _append("_{");
        _append(list.get(1));
        _append("}^{");
        _append(list.get(2));
        _append("}");
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMunder visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMunder visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMover visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMover visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMunderover visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMunderover visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMmultiscripts visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMmultiscripts visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMtable visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMtable visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMtr visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMtr visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMtd visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMtd visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMaligngroup visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMaligngroup visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMaction visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMaction visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCi visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCi visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCn visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCn visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSep visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSep visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MApply visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MApply visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MReln visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MReln visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLambda visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLambda visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCondition visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCondition visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MDeclare visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MDeclare visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSemantics visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSemantics visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MAnnotation visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MAnnotation visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MAnnotationXml visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MAnnotationXml visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MInterval visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MInterval visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MList visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MList visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMatrix visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMatrix visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMatrixrow visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMatrixrow visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSet visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSet visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MVector visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MVector visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLowlimit visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLowlimit visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MUplimit visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MUplimit visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MBvar visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MBvar visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MDegree visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MDegree visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLogbase visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLogbase visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MInverse visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MInverse visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MIdent visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MIdent visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MAbs visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MAbs visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MConjugate visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MConjugate visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MExp visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MExp visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MFactorial visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MFactorial visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MNot visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MNot visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLn visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLn visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSin visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSin visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCos visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCos visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MTan visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MTan visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSec visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSec visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCsc visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCsc visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCot visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCot visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSinh visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSinh visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCosh visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCosh visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MTanh visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MTanh visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSech visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSech visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCsch visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCsch visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCoth visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCoth visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MArcsin visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MArcsin visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MArccos visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MArccos visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MArctan visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MArctan visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MDeterminant visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MDeterminant visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MTranspose visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MTranspose visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MQuotient visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MQuotient visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MDivide visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MDivide visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MPower visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MPower visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MRem visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MRem visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MImplies visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MImplies visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSetdiff visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSetdiff visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MFn visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MFn visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MCompose visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MCompose visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MPlus visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MPlus visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MTimes visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MTimes visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMax visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMax visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMin visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMin visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MGcd visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MGcd visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MAnd visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MAnd visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MOr visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MOr visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MXor visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MXor visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MUnion visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MUnion visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MIntersect visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MIntersect visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMean visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMean visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSdev visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSdev visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MVariance visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MVariance visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMedian visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMedian visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMode visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMode visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSelector visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSelector visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MRoot visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MRoot visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMinus visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMinus visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLog visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLog visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MInt visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MInt visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MDiff visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MDiff visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MPartialdiff visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MPartialdiff visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSum visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSum visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MProduct visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MProduct visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLimit visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLimit visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MMoment visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MMoment visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MExists visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MExists visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MForall visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MForall visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MNeq visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MNeq visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MIn visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MIn visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MNotin visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MNotin visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MNotsubset visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MNotsubset visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MNotprsubset visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MNotprsubset visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MTendsto visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MTendsto visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MEq visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MEq visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLeq visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLeq visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MLt visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MLt visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MGeq visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MGeq visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MGt visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MGt visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MSubset visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MSubset visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(MPrsubset visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(MPrsubset visitable) {
    }

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    public void enter(RString visitable) {
    }

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    public void leave(RString visitable) {
    }

    private List _pop() {
        List result = list_;
        list_ = (List)stack_.pop();
        return (result);
    }

    private void _push() {
        stack_.push(list_);
        list_ = new ArrayList();
    }

    private void _append(Object object) {
        _append(object.toString());
    }

    private void _append(List list) {
        StringBuffer buffer = new StringBuffer();
        int size = list.size();
        for (int i = 0;i < size;i++) {
            buffer.append(list.get(i).toString());
        }
        _append(new String(buffer));
    }

    private void _append(String text) {
        list_.add(_escape(text));
    }

    private String _escape(String text) {
        StringBuffer buffer = new StringBuffer();
        char[] chars = text.toCharArray();
        for (int i = 0;i < chars.length;i++) {
            char c = chars[i];
            switch (c) {

            case MATH_PLUS_MINUS:
                buffer.append("{\\pm}");
                break;
            case MATH_INTEGRAL:
                buffer.append("\\int");
                break;
            case MATH_SUM:
                buffer.append("\\sum");
                break;
            case MATH_DIFFERENTIAL_D:
                buffer.append("d");
                break;
            case MATH_INVISIBLE_TIMES:
                // do nothing
                break;
            default:
                buffer.append(c);
            }
        }
        return (new String(buffer));
    }
}
