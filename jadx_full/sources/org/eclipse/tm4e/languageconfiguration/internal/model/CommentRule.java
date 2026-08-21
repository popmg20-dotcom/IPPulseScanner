package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class CommentRule {
    public final CharacterPair blockComment;
    public final String lineComment;

    public CommentRule(String str, CharacterPair characterPair) {
        this.lineComment = str;
        this.blockComment = characterPair;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("lineComment=");
        sb.append(this.lineComment);
        sb.append(", ");
        sb.append("blockComment=");
        sb.append(this.blockComment);
    }

    public String toString() {
        return m44.e(this, new dg(2, this));
    }
}
