package defpackage;

import io.netty.handler.codec.dns.DnsRecord;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class he3 implements cq {
    public final lz3 b;
    public final hp f;
    public boolean z;

    public he3(lz3 lz3Var) {
        lz3Var.getClass();
        this.b = lz3Var;
        this.f = new hp();
    }

    @Override // defpackage.cq
    public final byte[] B() {
        lz3 lz3Var = this.b;
        hp hpVar = this.f;
        hpVar.A(lz3Var);
        return hpVar.X(hpVar.f);
    }

    public final int C() {
        X(4L);
        return this.f.j0();
    }

    @Override // defpackage.cq
    public final int D(qw2 qw2Var) throws EOFException {
        qw2Var.getClass();
        if (this.z) {
            xe.q("closed");
            return 0;
        }
        while (true) {
            hp hpVar = this.f;
            int iC = b.c(hpVar, qw2Var, true);
            if (iC != -2) {
                if (iC != -1) {
                    hpVar.z0(qw2Var.b[iC].d());
                    return iC;
                }
            } else if (this.b.t0(hpVar, 8192L) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // defpackage.cq
    public final InputStream E0() {
        return new gp(this, 2);
    }

    public final int F() {
        X(4L);
        int iJ0 = this.f.j0();
        return ((iJ0 & DnsRecord.CLASS_ANY) << 24) | (((-16777216) & iJ0) >>> 24) | ((16711680 & iJ0) >>> 8) | ((65280 & iJ0) << 8);
    }

    public final long I() throws EOFException {
        char c;
        char c2;
        long jJ0;
        X(8L);
        hp hpVar = this.f;
        if (hpVar.f < 8) {
            throw new EOFException();
        }
        rr3 rr3Var = hpVar.b;
        rr3Var.getClass();
        int i = rr3Var.b;
        int i2 = rr3Var.c;
        if (i2 - i < 8) {
            jJ0 = ((((long) hpVar.j0()) & 4294967295L) << 32) | (4294967295L & ((long) hpVar.j0()));
            c = 24;
            c2 = '(';
        } else {
            byte[] bArr = rr3Var.a;
            c = 24;
            c2 = '(';
            int i3 = i + 7;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
            int i4 = i + 8;
            jJ0 = j | (((long) bArr[i3]) & 255);
            hpVar.f -= 8;
            if (i4 == i2) {
                hpVar.b = rr3Var.a();
                tr3.a(rr3Var);
            } else {
                rr3Var.b = i4;
            }
        }
        return ((jJ0 & 255) << 56) | (((-72057594037927936L) & jJ0) >>> 56) | ((71776119061217280L & jJ0) >>> c2) | ((280375465082880L & jJ0) >>> c) | ((1095216660480L & jJ0) >>> 8) | ((4278190080L & jJ0) << 8) | ((16711680 & jJ0) << c) | ((65280 & jJ0) << c2);
    }

    public final short M() {
        X(2L);
        return this.f.n0();
    }

    public final short N() {
        X(2L);
        return this.f.q0();
    }

    public final String Q(long j) {
        X(j);
        return this.f.r0(j, y30.a);
    }

    public final String U(long j) {
        if (j < 0) {
            e04.f(ha0.j(j, "limit < 0: "));
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jN = n((byte) 10, 0L, j2);
        hp hpVar = this.f;
        if (jN != -1) {
            return b.b(hpVar, jN);
        }
        if (j2 < Long.MAX_VALUE && request(j2) && hpVar.C(j2 - 1) == 13 && request(j2 + 1) && hpVar.C(j2) == 10) {
            return b.b(hpVar, j2);
        }
        hp hpVar2 = new hp();
        hpVar.n(hpVar2, 0L, Math.min(32L, hpVar.f));
        throw new EOFException("\\n not found: limit=" + Math.min(hpVar.f, j) + " content=" + hpVar2.Z(hpVar2.f).e() + (char) 8230);
    }

    @Override // defpackage.cq
    public final String W(Charset charset) {
        charset.getClass();
        lz3 lz3Var = this.b;
        hp hpVar = this.f;
        hpVar.A(lz3Var);
        return hpVar.r0(hpVar.f, charset);
    }

    public final void X(long j) {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    public final void Z(long j) {
        if (this.z) {
            xe.q("closed");
            return;
        }
        while (j > 0) {
            hp hpVar = this.f;
            if (hpVar.f == 0 && this.b.t0(hpVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, hpVar.f);
            hpVar.z0(jMin);
            j -= jMin;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public final void close() {
        if (this.z) {
            return;
        }
        this.z = true;
        this.b.close();
        hp hpVar = this.f;
        hpVar.z0(hpVar.f);
    }

    @Override // defpackage.cq
    public final bu f0() {
        lz3 lz3Var = this.b;
        hp hpVar = this.f;
        hpVar.A(lz3Var);
        return hpVar.Z(hpVar.f);
    }

    public final boolean g() {
        if (this.z) {
            xe.q("closed");
            return false;
        }
        hp hpVar = this.f;
        return hpVar.x() && this.b.t0(hpVar, 8192L) == -1;
    }

    @Override // defpackage.cq
    public final hp h() {
        return this.f;
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.b.i();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.z;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ef A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long n(byte r23, long r24, long r26) {
        /*
            Method dump skipped, instruction units count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.he3.n(byte, long, long):long");
    }

    @Override // defpackage.cq
    public final he3 peek() {
        return new he3(new a13(this));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        hp hpVar = this.f;
        if (hpVar.f == 0 && this.b.t0(hpVar, 8192L) == -1) {
            return -1;
        }
        return hpVar.read(byteBuffer);
    }

    @Override // defpackage.cq
    public final boolean request(long j) {
        hp hpVar;
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return false;
        }
        if (this.z) {
            xe.q("closed");
            return false;
        }
        do {
            hpVar = this.f;
            if (hpVar.f >= j) {
                return true;
            }
        } while (this.b.t0(hpVar, 8192L) != -1);
        return false;
    }

    public final byte s() {
        X(1L);
        return this.f.U();
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) {
        hpVar.getClass();
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.z) {
            xe.q("closed");
            return 0L;
        }
        hp hpVar2 = this.f;
        if (hpVar2.f == 0) {
            if (j == 0) {
                return 0L;
            }
            if (this.b.t0(hpVar2, 8192L) == -1) {
                return -1L;
            }
        }
        return hpVar2.t0(hpVar, Math.min(j, hpVar2.f));
    }

    public final String toString() {
        return "buffer(" + this.b + ')';
    }

    @Override // defpackage.cq
    public final long u0(ge3 ge3Var) {
        hp hpVar;
        long j = 0;
        while (true) {
            lz3 lz3Var = this.b;
            hpVar = this.f;
            if (lz3Var.t0(hpVar, 8192L) == -1) {
                break;
            }
            long jG = hpVar.g();
            if (jG > 0) {
                j += jG;
                ge3Var.a0(hpVar, jG);
            }
        }
        long j2 = hpVar.f;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        ge3Var.a0(hpVar, j2);
        return j3;
    }

    public final bu x(long j) {
        X(j);
        return this.f.Z(j);
    }
}
