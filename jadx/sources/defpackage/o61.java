package defpackage;

import java.io.IOException;
import java.net.ProtocolException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class o61 extends zi1 {
    public boolean A;
    public long X;
    public boolean Y;
    public boolean Z;
    public final long f;
    public final /* synthetic */ ue1 y0;
    public final boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o61(ue1 ue1Var, vx3 vx3Var, long j, boolean z) {
        super(vx3Var);
        vx3Var.getClass();
        this.y0 = ue1Var;
        this.f = j;
        this.z = z;
        this.Y = z;
    }

    @Override // defpackage.vx3
    public final void a0(hp hpVar, long j) throws IOException {
        if (this.Z) {
            xe.q("closed");
            return;
        }
        long j2 = this.f;
        if (j2 != -1 && this.X + j > j2) {
            StringBuilder sbC = fw.C("expected ", " bytes but received ", j2);
            sbC.append(this.X + j);
            throw new ProtocolException(sbC.toString());
        }
        try {
            if (this.Y) {
                this.Y = false;
            }
            this.b.a0(hpVar, j);
            this.X += j;
        } catch (IOException e) {
            IOException iOExceptionG = g(e);
            iOExceptionG.getClass();
            throw iOExceptionG;
        }
    }

    @Override // defpackage.zi1, defpackage.vx3, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        if (this.Z) {
            return;
        }
        this.Z = true;
        long j = this.f;
        if (j != -1 && this.X != j) {
            throw new ProtocolException("unexpected end of stream");
        }
        try {
            super.close();
            g(null);
        } catch (IOException e) {
            IOException iOExceptionG = g(e);
            iOExceptionG.getClass();
            throw iOExceptionG;
        }
    }

    @Override // defpackage.zi1, defpackage.vx3, java.io.Flushable
    public final void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e) {
            IOException iOExceptionG = g(e);
            iOExceptionG.getClass();
            throw iOExceptionG;
        }
    }

    public final IOException g(IOException iOException) {
        if (this.A) {
            return iOException;
        }
        this.A = true;
        return ue1.a(this.y0, this.z, iOException, 4);
    }
}
