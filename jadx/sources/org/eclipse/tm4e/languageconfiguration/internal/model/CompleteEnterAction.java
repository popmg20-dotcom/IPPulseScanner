package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;
import org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class CompleteEnterAction extends EnterAction {
    public final String indentation;

    public CompleteEnterAction(EnterAction.IndentAction indentAction, String str, Integer num, String str2) {
        super(indentAction, str, num);
        this.indentation = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("indentAction=");
        sb.append(this.indentAction);
        sb.append(", ");
        sb.append("appendText=");
        sb.append(this.appendText);
        sb.append(", ");
        sb.append("removeText=");
        sb.append(this.removeText);
        sb.append(", ");
        sb.append("indentation=");
        sb.append(this.indentation);
    }

    @Override // org.eclipse.tm4e.languageconfiguration.internal.model.EnterAction
    public String toString() {
        return m44.e(this, new dg(3, this));
    }
}
