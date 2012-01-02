package org.xmlsmartdoc.SmartDoc.mathml.rParts;

/**
 * @version MathML.rlx 1.0 (Sat Sep 09 10:49:01 JST 2000)
 * @author  Relaxer 0.11b (by ASAMI@Yokohama)
 */
public interface IRVisitor {
    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMath visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMath visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMi visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMi visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMalignmark visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMalignmark visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMn visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMn visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMo visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMo visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMtext visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMtext visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMs visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMs visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMspace visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMspace visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMrow visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMrow visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMprescripts visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMprescripts visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MNone visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MNone visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMfrac visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMfrac visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMsqrt visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMsqrt visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMroot visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMroot visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMstyle visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMstyle visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMerror visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMerror visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMpadded visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMpadded visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMphantom visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMphantom visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMfenced visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMfenced visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMsub visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMsub visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMsup visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMsup visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMsubsup visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMsubsup visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMunder visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMunder visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMover visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMover visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMunderover visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMunderover visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMmultiscripts visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMmultiscripts visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMtable visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMtable visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMtr visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMtr visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMtd visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMtd visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMaligngroup visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMaligngroup visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMaction visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMaction visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCi visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCi visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCn visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCn visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSep visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSep visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MApply visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MApply visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MReln visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MReln visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLambda visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLambda visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCondition visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCondition visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MDeclare visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MDeclare visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSemantics visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSemantics visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MAnnotation visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MAnnotation visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MAnnotationXml visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MAnnotationXml visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MInterval visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MInterval visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MList visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MList visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMatrix visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMatrix visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMatrixrow visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMatrixrow visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSet visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSet visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MVector visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MVector visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLowlimit visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLowlimit visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MUplimit visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MUplimit visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MBvar visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MBvar visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MDegree visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MDegree visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLogbase visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLogbase visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MInverse visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MInverse visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MIdent visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MIdent visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MAbs visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MAbs visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MConjugate visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MConjugate visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MExp visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MExp visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MFactorial visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MFactorial visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MNot visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MNot visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLn visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLn visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSin visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSin visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCos visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCos visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MTan visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MTan visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSec visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSec visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCsc visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCsc visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCot visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCot visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSinh visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSinh visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCosh visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCosh visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MTanh visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MTanh visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSech visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSech visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCsch visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCsch visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCoth visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCoth visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MArcsin visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MArcsin visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MArccos visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MArccos visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MArctan visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MArctan visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MDeterminant visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MDeterminant visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MTranspose visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MTranspose visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MQuotient visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MQuotient visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MDivide visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MDivide visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MPower visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MPower visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MRem visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MRem visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MImplies visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MImplies visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSetdiff visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSetdiff visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MFn visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MFn visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MCompose visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MCompose visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MPlus visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MPlus visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MTimes visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MTimes visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMax visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMax visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMin visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMin visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MGcd visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MGcd visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MAnd visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MAnd visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MOr visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MOr visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MXor visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MXor visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MUnion visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MUnion visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MIntersect visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MIntersect visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMean visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMean visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSdev visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSdev visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MVariance visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MVariance visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMedian visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMedian visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMode visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMode visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSelector visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSelector visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MRoot visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MRoot visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMinus visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMinus visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLog visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLog visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MInt visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MInt visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MDiff visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MDiff visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MPartialdiff visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MPartialdiff visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSum visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSum visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MProduct visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MProduct visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLimit visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLimit visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MMoment visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MMoment visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MExists visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MExists visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MForall visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MForall visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MNeq visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MNeq visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MIn visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MIn visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MNotin visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MNotin visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MNotsubset visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MNotsubset visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MNotprsubset visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MNotprsubset visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MTendsto visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MTendsto visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MEq visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MEq visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLeq visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLeq visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MLt visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MLt visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MGeq visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MGeq visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MGt visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MGt visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MSubset visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MSubset visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(MPrsubset visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(MPrsubset visitable);

    /**
     * Visits this node for enter behavior.
     *
     * @param visitable
     */
    void enter(RString visitable);

    /**
     * Visits this node for leave behavior.
     *
     * @param visitable
     */
    void leave(RString visitable);
}
