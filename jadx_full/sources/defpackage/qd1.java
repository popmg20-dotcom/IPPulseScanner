package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class qd1 implements lz3 {
    public final w72 b;
    public long f;
    public boolean z;

    public qd1(w72 w72Var, long j) {
        this.b = w72Var;
        this.f = j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        w72 w72Var = this.b;
        if (this.z) {
            return;
        }
        this.z = true;
        ReentrantLock reentrantLock = w72Var.z;
        reentrantLock.lock();
        try {
            int i = w72Var.f - 1;
            w72Var.f = i;
            if (i == 0) {
                if (w72Var.b) {
                    synchronized (w72Var) {
                        w72Var.A.close();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return de4.d;
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) {
        long j2;
        long j3;
        int i;
        hpVar.getClass();
        if (this.z) {
            xe.q("closed");
            return 0L;
        }
        w72 w72Var = this.b;
        long j4 = this.f;
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        long j5 = j + j4;
        long j6 = j4;
        while (true) {
            if (j6 >= j5) {
                j2 = -1;
                break;
            }
            rr3 rr3VarG0 = hpVar.G0(1);
            byte[] bArr = rr3VarG0.a;
            int i2 = rr3VarG0.c;
            j2 = -1;
            int iMin = (int) Math.min(j5 - j6, 8192 - i2);
            synchronized (w72Var) {
                bArr.getClass();
                w72Var.A.seek(j6);
                i = 0;
                while (true) {
                    if (i >= iMin) {
                        break;
                    }
                    int i3 = w72Var.A.read(bArr, i2, iMin - i);
                    if (i3 != -1) {
                        i += i3;
                    } else if (i == 0) {
                        i = -1;
                    }
                }
            }
            if (i == -1) {
                if (rr3VarG0.b == rr3VarG0.c) {
                    hpVar.b = rr3VarG0.a();
                    tr3.a(rr3VarG0);
                }
                if (j4 == j6) {
                    j3 = -1;
                }
            } else {
                rr3VarG0.c += i;
                long j7 = i;
                j6 += j7;
                hpVar.f += j7;
            }
        }
        j3 = j6 - j4;
        if (j3 != j2) {
            this.f += j3;
        }
        return j3;
    }
}
