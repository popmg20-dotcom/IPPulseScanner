package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class e80 {
    public final Optional a;
    public final String b;
    public final int c;

    public e80(c80 c80Var) {
        Optional optional = c80Var.a;
        Optional optional2 = c80Var.b;
        String str = c80Var.d;
        int i = c80Var.c;
        Objects.requireNonNull(optional);
        this.a = optional;
        Objects.requireNonNull(optional2);
        Objects.requireNonNull(str);
        this.b = str;
        if (i == 0) {
            throw null;
        }
        this.c = i;
    }

    public final String toString() {
        StringBuilder sbD = fw.D("<", e80.class.getName(), " (type=");
        sbD.append(fw.K(this.c));
        sbD.append(", value=");
        sbD.append(this.b);
        sbD.append(")>");
        return sbD.toString();
    }
}
