package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class p61 extends aj1 {
    public long A;
    public boolean X;
    public boolean Y;
    public boolean Z;
    public final long f;
    public final /* synthetic */ ue1 y0;
    public final boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p61(ue1 ue1Var, lz3 lz3Var, long j, boolean z) {
        super(lz3Var);
        lz3Var.getClass();
        this.y0 = ue1Var;
        this.f = j;
        this.z = z;
        this.X = true;
        if (j == 0) {
            g(null);
        }
    }

    @Override // defpackage.aj1, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.Z) {
            return;
        }
        this.Z = true;
        try {
            super.close();
            g(null);
        } catch (IOException e) {
            IOException iOExceptionG = g(e);
            iOExceptionG.getClass();
            throw iOExceptionG;
        }
    }

    public final IOException g(IOException iOException) {
        if (this.Y) {
            return iOException;
        }
        this.Y = true;
        if (iOException == null && this.X) {
            this.X = false;
        }
        return ue1.a(this.y0, this.z, iOException, 8);
    }

    @Override // defpackage.aj1, defpackage.lz3
    public final long t0(hp hpVar, long j) throws IOException {
        ue1 ue1Var = this.y0;
        hpVar.getClass();
        if (this.Z) {
            xe.q("closed");
            return 0L;
        }
        try {
            long jT0 = this.b.t0(hpVar, j);
            if (this.X) {
                this.X = false;
            }
            if (jT0 == -1) {
                g(null);
                return -1L;
            }
            long j2 = this.A + jT0;
            long j3 = this.f;
            if (j3 == -1 || j2 <= j3) {
                this.A = j2;
                if (((r61) ue1Var.A).b()) {
                    g(null);
                }
                return jT0;
            }
            throw new ProtocolException("expected " + j3 + " bytes but received " + j2);
        } catch (IOException e) {
            IOException iOExceptionG = g(e);
            iOExceptionG.getClass();
            throw iOExceptionG;
        }
    }
}
