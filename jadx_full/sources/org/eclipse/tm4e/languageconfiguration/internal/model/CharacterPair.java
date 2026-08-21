package org.eclipse.tm4e.languageconfiguration.internal.model;

import defpackage.dg;
import defpackage.m44;
import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class CharacterPair {
    public final String close;
    public final String open;

    public CharacterPair(String str, String str2) {
        this.open = str;
        this.close = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$toString$0(StringBuilder sb) {
        sb.append("open=");
        sb.append(this.open);
        sb.append(", ");
        sb.append("close=");
        sb.append(this.close);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CharacterPair characterPair = (CharacterPair) obj;
            if (Objects.equals(this.open, characterPair.open) && Objects.equals(this.close, characterPair.close)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.open, this.close);
    }

    public String toString() {
        return m44.e(this, new dg(1, this));
    }
}
