package defpackage;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class lu1 extends xf {
    public final /* synthetic */ mu1 n;

    public lu1(mu1 mu1Var) {
        this.n = mu1Var;
    }

    @Override // defpackage.xf
    public final void j() {
        this.n.f(t51.CANCEL);
        fu1 fu1Var = this.n.f;
        synchronized (fu1Var) {
            long j = fu1Var.E0;
            long j2 = fu1Var.D0;
            if (j < j2) {
                return;
            }
            fu1Var.D0 = j2 + 1;
            fu1Var.F0 = System.nanoTime() + 1000000000;
            za4.c(fu1Var.y0, fw.y(new StringBuilder(), fu1Var.z, " ping"), new fn(7, fu1Var));
        }
    }

    public final void k() {
        if (i()) {
            throw new SocketTimeoutException(RtspHeaders.Values.TIMEOUT);
        }
    }
}
