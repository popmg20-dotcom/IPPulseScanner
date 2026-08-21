package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class FoldingRules {
    public final RegExPattern markersEnd;
    public final RegExPattern markersStart;
    public final boolean offSide;

    public FoldingRules(boolean z, RegExPattern regExPattern, RegExPattern regExPattern2) {
        this.offSide = z;
        this.markersStart = regExPattern;
        this.markersEnd = regExPattern2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("markersStart=");
        sb.append(this.markersStart);
        sb.append(", ");
        sb.append("markersEnd=");
        sb.append(this.markersEnd);
        sb.append(", ");
        sb.append("offSide=");
        sb.append(this.offSide);
    }

    public String toString() {
        return m44.e(this, new dg(5, this));
    }
}
