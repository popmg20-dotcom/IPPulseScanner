package defpackage;

import io.netty.channel.internal.ChannelUtils;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class hu1 implements lz3 {
    public int A;
    public int X;
    public int Y;
    public final he3 b;
    public int f;
    public int z;

    public hu1(he3 he3Var) {
        this.b = he3Var;
    }

    @Override // defpackage.lz3
    public final de4 i() {
        return this.b.b.i();
    }

    @Override // defpackage.lz3
    public final long t0(hp hpVar, long j) throws IOException {
        int i;
        int iC;
        hpVar.getClass();
        do {
            int i2 = this.X;
            he3 he3Var = this.b;
            if (i2 == 0) {
                he3Var.Z(this.Y);
                this.Y = 0;
                if ((this.z & 4) == 0) {
                    i = this.A;
                    int iL = hz4.l(he3Var);
                    this.X = iL;
                    this.f = iL;
                    int iS = he3Var.s() & 255;
                    this.z = he3Var.s() & 255;
                    Logger logger = iu1.A;
                    if (logger.isLoggable(Level.FINE)) {
                        bu buVar = xt1.a;
                        logger.fine(xt1.b(this.A, this.f, iS, true, this.z));
                    }
                    iC = he3Var.C() & ChannelUtils.WRITE_STATUS_SNDBUF_FULL;
                    this.A = iC;
                    if (iS != 9) {
                        throw new IOException(iS + " != TYPE_CONTINUATION");
                    }
                }
            } else {
                long jT0 = he3Var.t0(hpVar, Math.min(j, i2));
                if (jT0 != -1) {
                    this.X -= (int) jT0;
                    return jT0;
                }
            }
            return -1L;
        } while (iC == i);
        vp1.i("TYPE_CONTINUATION streamId changed");
        return 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
