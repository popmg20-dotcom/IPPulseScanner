package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class fw2 extends h0 {
    public static final fw2 Y = new fw2();
    public final String X = n12.g("hostkeys-prove-00@openssh.com", "No request identifier");

    public fw2() {
        Objects.requireNonNull(lp.e, "No public keys extractor");
    }

    @Override // defpackage.k70
    public final String toString() {
        return this.X;
    }
}
