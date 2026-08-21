package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hs2 {
    public final ds2 a;
    public final ds2 b;

    public hs2(ds2 ds2Var, ds2 ds2Var2) {
        Objects.requireNonNull(ds2Var2, "value Node must be provided");
        this.a = ds2Var;
        this.b = ds2Var2;
    }

    public final String toString() {
        return "<NodeTuple keyNode=" + this.a + "; valueNode=" + this.b + ">";
    }
}
