package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class rd1 extends o0 {
    public int u;
    public int v;
    public byte[] w;
    public long x;
    public String y;

    public rd1() {
        this.a = 3;
    }

    @Override // defpackage.o0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || rd1.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        rd1 rd1Var = (rd1) obj;
        ly4 ly4Var = this.q;
        long j = ly4Var != null ? ly4Var.f : this.x;
        ly4 ly4Var2 = rd1Var.q;
        return j == (ly4Var2 != null ? ly4Var2.f : rd1Var.x);
    }

    public final int hashCode() {
        String str = this.m;
        ly4 ly4Var = this.q;
        return Objects.hash(str, Long.valueOf(ly4Var != null ? ly4Var.f : this.x));
    }

    public final String toString() {
        return this.m;
    }
}
