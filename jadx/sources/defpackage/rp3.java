package defpackage;

import j$.util.Objects;
import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rp3 extends re4 {
    public final String c;
    public final boolean d;
    public final qp3 e;

    public rp3(String str, boolean z, qp3 qp3Var, Optional optional, Optional optional2) {
        super(optional, optional2);
        this.c = str;
        this.d = z;
        Objects.requireNonNull(qp3Var);
        this.e = qp3Var;
    }

    @Override // defpackage.re4
    public final int a() {
        return 16;
    }

    @Override // defpackage.re4
    public final String toString() {
        return "<scalar> plain=" + this.d + " style=" + this.e + " value=" + this.c;
    }
}
