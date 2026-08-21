package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n15 implements d25 {
    public final d25 b;
    public final String f;

    public n15(String str) {
        this.b = d25.q0;
        this.f = str;
    }

    @Override // defpackage.d25
    public final Boolean d() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // defpackage.d25
    public final Iterator e() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n15)) {
            return false;
        }
        n15 n15Var = (n15) obj;
        return this.f.equals(n15Var.f) && this.b.equals(n15Var.b);
    }

    @Override // defpackage.d25
    public final d25 f(String str, ih4 ih4Var, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // defpackage.d25
    public final Double g() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override // defpackage.d25
    public final String h() {
        throw new IllegalStateException("Control is not a String");
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.f.hashCode() * 31);
    }

    @Override // defpackage.d25
    public final d25 i() {
        return new n15(this.f, this.b.i());
    }

    public n15(String str, d25 d25Var) {
        this.b = d25Var;
        this.f = str;
    }
}
