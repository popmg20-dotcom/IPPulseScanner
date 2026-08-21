package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EnterAction {
    public String appendText;
    public final IndentAction indentAction;
    public final Integer removeText;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public enum IndentAction {
        None,
        Indent,
        IndentOutdent,
        Outdent;

        public static IndentAction get(String str) {
            if (str == null) {
                return None;
            }
            switch (str) {
            }
            return None;
        }
    }

    public EnterAction(IndentAction indentAction, String str, Integer num) {
        this.indentAction = indentAction;
        this.appendText = str;
        this.removeText = num;
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
    }

    public String toString() {
        return m44.e(this, new dg(4, this));
    }

    public EnterAction(IndentAction indentAction) {
        this(indentAction, null, null);
    }
}
