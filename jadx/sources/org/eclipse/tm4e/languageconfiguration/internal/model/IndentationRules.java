package org.eclipse.tm4e.languageconfiguration.internal.model;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class IndentationRules {
    public final RegExPattern decreaseIndentPattern;
    public final RegExPattern increaseIndentPattern;
    public final RegExPattern indentNextLinePattern;
    public final RegExPattern unIndentedLinePattern;

    public IndentationRules(RegExPattern regExPattern, RegExPattern regExPattern2, RegExPattern regExPattern3, RegExPattern regExPattern4) {
        this.decreaseIndentPattern = regExPattern;
        this.increaseIndentPattern = regExPattern2;
        this.indentNextLinePattern = regExPattern3;
        this.unIndentedLinePattern = regExPattern4;
    }
}
