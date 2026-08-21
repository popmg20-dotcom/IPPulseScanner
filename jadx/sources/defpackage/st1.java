package defpackage;

import java.io.IOException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class st1 extends qt1 {
    public long X;
    public boolean Y;
    public final /* synthetic */ wt1 Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public st1(wt1 wt1Var, ev1 ev1Var) {
        super(wt1Var, ev1Var);
        ev1Var.getClass();
        this.Z = wt1Var;
        this.X = -1L;
        this.Y = true;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        boolean zG;
        if (this.z) {
            return;
        }
        if (this.Y) {
            TimeZone timeZone = jz4.a;
            TimeUnit.MILLISECONDS.getClass();
            try {
                zG = jz4.g(this, 100);
            } catch (IOException unused) {
                zG = false;
            }
            if (!zG) {
                this.Z.b.d();
                g(wt1.f);
            }
        }
        this.z = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c9, code lost:
    
        if (r18.Y == false) goto L48;
     */
    @Override // defpackage.qt1, defpackage.lz3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long t0(defpackage.hp r19, long r20) throws java.net.ProtocolException {
        /*
            Method dump skipped, instruction units count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.st1.t0(hp, long):long");
    }
}
