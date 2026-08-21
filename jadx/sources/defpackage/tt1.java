package defpackage;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class tt1 extends qt1 {
    public long X;
    public final /* synthetic */ wt1 Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tt1(wt1 wt1Var, ev1 ev1Var, long j) {
        super(wt1Var, ev1Var);
        ev1Var.getClass();
        this.Y = wt1Var;
        this.X = j;
        if (j == 0) {
            g(lr1.f);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zG;
        if (this.z) {
            return;
        }
        if (this.X != 0) {
            TimeZone timeZone = jz4.a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zG = jz4.g(this, 100);
            } catch (IOException unused) {
                zG = false;
            }
            if (!zG) {
                this.Y.b.d();
                g(wt1.f);
            }
        }
        this.z = true;
    }

    @Override // defpackage.qt1, defpackage.lz3
    public final long t0(hp hpVar, long j) throws ProtocolException {
        hpVar.getClass();
        if (j < 0) {
            e04.f(ha0.j(j, "byteCount < 0: "));
            return 0L;
        }
        if (this.z) {
            xe.q("closed");
            return 0L;
        }
        long j2 = this.X;
        if (j2 == 0) {
            return -1L;
        }
        long jT0 = super.t0(hpVar, Math.min(j2, j));
        if (jT0 == -1) {
            this.Y.b.d();
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            g(wt1.f);
            throw protocolException;
        }
        long j3 = this.X - jT0;
        this.X = j3;
        if (j3 == 0) {
            g(lr1.f);
        }
        return jT0;
    }
}
