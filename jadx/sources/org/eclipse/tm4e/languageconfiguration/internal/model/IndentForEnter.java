package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class IndentForEnter {
    public final String afterEnter;
    public final String beforeEnter;

    public IndentForEnter(String str, String str2) {
        this.beforeEnter = str;
        this.afterEnter = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("beforeEnter=");
        sb.append(this.beforeEnter);
        sb.append(", ");
        sb.append("afterEnter=");
        sb.append(this.afterEnter);
    }

    public String toString() {
        return m44.e(this, new dg(7, this));
    }
}
