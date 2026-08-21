package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lf1 extends aj1 {
    public long A;
    public final long f;
    public final boolean z;

    public lf1(lz3 lz3Var, long j, boolean z) {
        super(lz3Var);
        this.f = j;
        this.z = z;
    }

    @Override // defpackage.aj1, defpackage.lz3
    public final long t0(hp hpVar, long j) throws IOException {
        hpVar.getClass();
        long j2 = this.A;
        long j3 = this.f;
        if (j2 > j3) {
            j = 0;
        } else if (this.z) {
            long j4 = j3 - j2;
            if (j4 == 0) {
                return -1L;
            }
            j = Math.min(j, j4);
        }
        long jT0 = this.b.t0(hpVar, j);
        if (jT0 != -1) {
            this.A += jT0;
        }
        long j5 = this.A;
        if ((j5 >= j3 || jT0 != -1) && j5 <= j3) {
            return jT0;
        }
        if (jT0 > 0 && j5 > j3) {
            long j6 = hpVar.f - (j5 - j3);
            hp hpVar2 = new hp();
            hpVar2.A(hpVar);
            hpVar.a0(hpVar2, j6);
            hpVar2.z0(hpVar2.f);
        }
        StringBuilder sbC = fw.C("expected ", " bytes but got ", j3);
        sbC.append(this.A);
        throw new IOException(sbC.toString());
    }
}
