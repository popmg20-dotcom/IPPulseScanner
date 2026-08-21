package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ge3 implements bq {
    public final vx3 b;
    public final hp f;
    public boolean z;

    public ge3(vx3 vx3Var) {
        vx3Var.getClass();
        this.b = vx3Var;
        this.f = new hp();
    }

    @Override // defpackage.bq
    public final long A(lz3 lz3Var) {
        long j = 0;
        while (true) {
            long jT0 = ((q02) lz3Var).t0(this.f, 8192L);
            if (jT0 == -1) {
                return j;
            }
            j += jT0;
            g();
        }
    }

    @Override // defpackage.bq
    public final bq A0(bu buVar) {
        buVar.getClass();
        if (this.z) {
            xe.q("closed");
            return null;
        }
        this.f.I0(buVar);
        g();
        return this;
    }

    @Override // defpackage.bq
    public final bq P(int i, byte[] bArr) {
        if (this.z) {
            xe.q("closed");
            return null;
        }
        this.f.H0(i, bArr);
        g();
        return this;
    }

    @Override // defpackage.bq
    public final bq S(String str) {
        str.getClass();
        if (this.z) {
            xe.q("closed");
            return null;
        }
        this.f.Q0(str);
        g();
        return this;
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) {
        hpVar.getClass();
        if (this.z) {
            xe.q("closed");
        } else {
            this.f.a0(hpVar, j);
            g();
        }
    }

    @Override // defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        vx3 vx3Var = this.b;
        if (this.z) {
            return;
        }
        try {
            hp hpVar = this.f;
            long j = hpVar.f;
            if (j > 0) {
                vx3Var.a0(hpVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            vx3Var.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.z = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // defpackage.vx3, java.io.Flushable
    public final void flush() {
        if (this.z) {
            xe.q("closed");
            return;
        }
        hp hpVar = this.f;
        long j = hpVar.f;
        vx3 vx3Var = this.b;
        if (j > 0) {
            vx3Var.a0(hpVar, j);
        }
        vx3Var.flush();
    }

    public final bq g() {
        if (this.z) {
            xe.q("closed");
            return null;
        }
        hp hpVar = this.f;
        long jG = hpVar.g();
        if (jG > 0) {
            this.b.a0(hpVar, jG);
        }
        return this;
    }

    @Override // defpackage.vx3
    public final de4 i() {
        return this.b.i();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.z;
    }

    public final bq n(long j) {
        if (this.z) {
            xe.q("closed");
            return null;
        }
        this.f.K0(j);
        g();
        return this;
    }

    public final bq s(int i) {
        if (this.z) {
            xe.q("closed");
            return null;
        }
        this.f.M0(i);
        g();
        return this;
    }

    public final String toString() {
        return "buffer(" + this.b + ')';
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) {
        byteBuffer.getClass();
        if (this.z) {
            xe.q("closed");
            return 0;
        }
        int iWrite = this.f.write(byteBuffer);
        g();
        return iWrite;
    }

    @Override // defpackage.bq
    public final bq writeByte(int i) {
        if (this.z) {
            xe.q("closed");
            return null;
        }
        this.f.J0(i);
        g();
        return this;
    }
}
