package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oj4 {
    public final Class a;
    public final nj4[] b;
    public final int c;

    public oj4(Class cls, nj4[] nj4VarArr, int i) {
        this.a = cls;
        this.b = nj4VarArr;
        this.c = (cls.hashCode() * 31) + i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != oj4.class) {
            return false;
        }
        oj4 oj4Var = (oj4) obj;
        if (this.c == oj4Var.c && this.a == oj4Var.a) {
            nj4[] nj4VarArr = oj4Var.b;
            nj4[] nj4VarArr2 = this.b;
            int length = nj4VarArr2.length;
            if (length == nj4VarArr.length) {
                for (int i = 0; i < length; i++) {
                    if (!Objects.equals(nj4VarArr2[i], nj4VarArr[i])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return this.a.getName().concat("<>");
    }
}
