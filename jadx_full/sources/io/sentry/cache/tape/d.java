package io.sentry.cache.tape;

import defpackage.xe;
import defpackage.y81;
import defpackage.zo2;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d extends f {
    public final i b;
    public final y81 f = new y81();
    public final e z;

    public d(i iVar, e eVar) {
        this.b = iVar;
        this.z = eVar;
    }

    @Override // io.sentry.cache.tape.f
    public final void clear() throws IOException {
        this.b.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.b.close();
    }

    @Override // io.sentry.cache.tape.f
    public final void g(Object obj) throws IOException {
        long j;
        long j2;
        long j3;
        long jZ;
        long j4;
        long j5;
        y81 y81Var = this.f;
        y81Var.reset();
        this.z.c(obj, y81Var);
        i iVar = this.b;
        byte[] bArr = iVar.Z;
        byte[] bArrG = y81Var.g();
        int size = y81Var.size();
        if (bArrG == null) {
            zo2.n("data == null");
            return;
        }
        if (size < 0 || size > bArrG.length) {
            throw new IndexOutOfBoundsException();
        }
        if (iVar.A0) {
            xe.q("closed");
            return;
        }
        int i = iVar.z0;
        if (i != -1 && iVar.A == i) {
            iVar.I(1);
        }
        long j6 = ((long) size) + 4;
        long j7 = iVar.z;
        if (iVar.A == 0) {
            j = 4;
            j3 = 32;
            j2 = 32;
        } else {
            g gVar = iVar.Y;
            long j8 = gVar.a;
            j = 4;
            long j9 = iVar.X.a;
            int i2 = gVar.b;
            if (j8 >= j9) {
                j3 = (j8 - j9) + 4 + ((long) i2) + 32;
                j2 = 32;
            } else {
                j2 = 32;
                j3 = (((j8 + 4) + ((long) i2)) + j7) - j9;
            }
        }
        long j10 = j7 - j3;
        if (j10 < j6) {
            do {
                j10 += j7;
                j7 <<= 1;
            } while (j10 < j6);
            iVar.b.setLength(j7);
            iVar.b.getChannel().force(true);
            g gVar2 = iVar.Y;
            long jZ2 = iVar.Z(gVar2.a + j + ((long) gVar2.b));
            if (jZ2 <= iVar.X.a) {
                FileChannel channel = iVar.b.getChannel();
                channel.position(iVar.z);
                j4 = jZ2 - j2;
                if (channel.transferTo(32L, j4, channel) != j4) {
                    xe.i("Copied insufficient number of bytes!");
                    return;
                }
            } else {
                j4 = 0;
            }
            long j11 = iVar.Y.a;
            long j12 = iVar.X.a;
            if (j11 < j12) {
                long j13 = (iVar.z + j11) - j2;
                j5 = j7;
                iVar.c0(j5, iVar.A, j12, j13);
                iVar.Y = new g(j13, iVar.Y.b);
            } else {
                j5 = j7;
                iVar.c0(j5, iVar.A, j12, j11);
            }
            iVar.z = j5;
            long j14 = j2;
            long j15 = j4;
            while (j15 > 0) {
                int iMin = (int) Math.min(j15, 4096L);
                iVar.X(j14, iMin, i.B0);
                long j16 = iMin;
                j15 -= j16;
                j14 += j16;
            }
        }
        boolean z = iVar.A == 0;
        if (z) {
            jZ = j2;
        } else {
            g gVar3 = iVar.Y;
            jZ = iVar.Z(gVar3.a + j + ((long) gVar3.b));
        }
        g gVar4 = new g(jZ, size);
        i.i0(0, size, bArr);
        iVar.X(jZ, 4, bArr);
        iVar.X(jZ + j, size, bArrG);
        iVar.c0(iVar.z, iVar.A + 1, z ? jZ : iVar.X.a, jZ);
        iVar.Y = gVar4;
        iVar.A++;
        iVar.y0++;
        if (z) {
            iVar.X = gVar4;
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this, new h(this.b));
    }

    @Override // io.sentry.cache.tape.f
    public final int size() {
        return this.b.A;
    }

    public final String toString() {
        return "FileObjectQueue{queueFile=" + this.b + '}';
    }

    @Override // io.sentry.cache.tape.f
    public final void x(int i) throws IOException {
        this.b.I(i);
    }
}
