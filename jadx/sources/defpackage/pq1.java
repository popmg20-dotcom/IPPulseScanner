package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pq1 implements lz3 {
    public final zz1 A;
    public final CRC32 X;
    public byte b;
    public final he3 f;
    public final Inflater z;

    public pq1(cq cqVar) {
        cqVar.getClass();
        he3 he3Var = new he3(cqVar);
        this.f = he3Var;
        Inflater inflater = new Inflater(true);
        this.z = inflater;
        this.A = new zz1(he3Var, inflater);
        this.X = new CRC32();
    }

    public static void g(int i, int i2, String str) throws IOException {
        if (i2 == i) {
            return;
        }
        StringBuilder sbQ = ha0.q(str, ": actual 0x");
        sbQ.append(p44.D0(l72.Z(i2), 8, '0'));
        sbQ.append(" != expected 0x");
        sbQ.append(p44.D0(l72.Z(i), 8, '0'));
        throw new IOException(sbQ.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.A.close();
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.f.b.i();
    }

    public final void n(hp hpVar, long j, long j2) {
        rr3 rr3Var = hpVar.b;
        rr3Var.getClass();
        while (true) {
            long j3 = rr3Var.c - rr3Var.b;
            if (j < j3) {
                break;
            }
            j -= j3;
            rr3Var = rr3Var.f;
            rr3Var.getClass();
        }
        while (j2 > 0) {
            int i = (int) (((long) rr3Var.b) + j);
            int iMin = (int) Math.min(rr3Var.c - i, j2);
            this.X.update(rr3Var.a, i, iMin);
            j2 -= (long) iMin;
            rr3Var = rr3Var.f;
            rr3Var.getClass();
            j = 0;
        }
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) throws IOException {
        byte b;
        hp hpVar2;
        pq1 pq1Var = this;
        he3 he3Var = pq1Var.f;
        hp hpVar3 = he3Var.f;
        hpVar.getClass();
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        byte b2 = pq1Var.b;
        CRC32 crc32 = pq1Var.X;
        if (b2 == 0) {
            he3Var.X(10L);
            byte bC = hpVar3.C(3L);
            boolean z = ((bC >> 1) & 1) == 1;
            if (z) {
                pq1Var.n(hpVar3, 0L, 10L);
            }
            g(8075, he3Var.M(), "ID1ID2");
            he3Var.Z(8L);
            if (((bC >> 2) & 1) == 1) {
                he3Var.X(2L);
                if (z) {
                    n(hpVar3, 0L, 2L);
                }
                long jQ0 = hpVar3.q0() & 65535;
                he3Var.X(jQ0);
                if (z) {
                    n(hpVar3, 0L, jQ0);
                }
                hpVar2 = hpVar3;
                he3Var.Z(jQ0);
            } else {
                hpVar2 = hpVar3;
            }
            if (((bC >> 3) & 1) == 1) {
                long jN = he3Var.n((byte) 0, 0L, Long.MAX_VALUE);
                if (jN == -1) {
                    throw new EOFException();
                }
                if (z) {
                    n(hpVar2, 0L, jN + 1);
                }
                he3Var.Z(jN + 1);
            }
            if (((bC >> 4) & 1) == 1) {
                long jN2 = he3Var.n((byte) 0, 0L, Long.MAX_VALUE);
                if (jN2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    pq1Var = this;
                    pq1Var.n(hpVar2, 0L, jN2 + 1);
                } else {
                    pq1Var = this;
                }
                he3Var.Z(jN2 + 1);
            } else {
                pq1Var = this;
            }
            if (z) {
                g(he3Var.N(), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            pq1Var.b = (byte) 1;
            b2 = 1;
        }
        if (b2 == 1) {
            long j2 = hpVar.f;
            long jT0 = pq1Var.A.t0(hpVar, j);
            if (jT0 != -1) {
                pq1Var.n(hpVar, j2, jT0);
                return jT0;
            }
            b = 2;
            pq1Var.b = (byte) 2;
            b2 = 2;
        } else {
            b = 2;
        }
        if (b2 == b) {
            g(he3Var.F(), (int) crc32.getValue(), "CRC");
            g(he3Var.F(), (int) pq1Var.z.getBytesWritten(), "ISIZE");
            pq1Var.b = (byte) 3;
            if (!he3Var.g()) {
                vp1.i("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }
}
