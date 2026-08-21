package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class OnEnterRule {
    public final EnterAction action;
    public final RegExPattern afterText;
    public final RegExPattern beforeText;
    public final RegExPattern previousLineText;

    public OnEnterRule(String str, String str2, String str3, EnterAction enterAction) {
        this.beforeText = RegExPattern.of(str);
        this.afterText = str2 == null ? null : RegExPattern.of(str2);
        this.previousLineText = str3 != null ? RegExPattern.of(str3) : null;
        this.action = enterAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("beforeText=");
        sb.append(this.beforeText);
        sb.append(", ");
        sb.append("afterText=");
        sb.append(this.afterText);
        sb.append(", ");
        sb.append("previousLineText=");
        sb.append(this.previousLineText);
        sb.append(", ");
        sb.append("action=");
        sb.append(this.action);
    }

    public String toString() {
        return m44.e(this, new dg(10, this));
    }

    public OnEnterRule(RegExPattern regExPattern, RegExPattern regExPattern2, RegExPattern regExPattern3, EnterAction enterAction) {
        this.beforeText = regExPattern;
        this.afterText = regExPattern2;
        this.previousLineText = regExPattern3;
        this.action = enterAction;
    }
}
