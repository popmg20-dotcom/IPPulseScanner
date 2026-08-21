package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoClosingPairConditional extends AutoClosingPair {
    public final List<String> notIn;

    public AutoClosingPairConditional(String str, String str2, List<String> list) {
        super(str, str2);
        this.notIn = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("open=");
        sb.append(this.open);
        sb.append(", ");
        sb.append("close=");
        sb.append(this.close);
        sb.append(", ");
        sb.append("notIn=");
        sb.append(this.notIn);
    }

    @Override // org.eclipse.tm4e.languageconfiguration.internal.model.CharacterPair
    public String toString() {
        return m44.e(this, new dg(0, this));
    }
}
