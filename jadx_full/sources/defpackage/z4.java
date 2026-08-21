package defpackage;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z4 extends d31 {
    public final Set b;
    public final boolean c;

    public z4(String str, Set set, boolean z) {
        super(str);
        this.b = set;
        this.c = z;
    }

    @Override // defpackage.d31
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z4) || !super.equals(obj)) {
            return false;
        }
        z4 z4Var = (z4) obj;
        return this.b.equals(z4Var.b) && this.c == z4Var.c;
    }

    @Override // defpackage.d31
    public final int hashCode() {
        return ((this.b.hashCode() + (super.hashCode() * 31)) * 31) + (this.c ? 1231 : 1237);
    }

    public final String toString() {
        return "ActivityRule:{tag={" + a() + "},filters={" + this.b + "}, alwaysExpand={" + this.c + "}}";
    }
}
