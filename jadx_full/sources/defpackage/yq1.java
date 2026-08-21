package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yq1 implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ pl1 f;

    public /* synthetic */ yq1(int i, pl1 pl1Var) {
        this.b = i;
        this.f = pl1Var;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.b;
        pl1 pl1Var = this.f;
        switch (i) {
            case 0:
                try {
                    return (List) pl1Var.a();
                } catch (SSLPeerUnverifiedException unused) {
                    return g41.b;
                }
            case 1:
                pl1Var.a();
                return xl4.a;
            default:
                y3 y3Var = nj3.e;
                synchronized (((HashSet) y3Var.d)) {
                    try {
                        Iterator it = ((HashSet) y3Var.d).iterator();
                        while (it.hasNext()) {
                            ((aj3) it.next()).b();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                nj3.f.c(new s53(16));
                nj3.c.E.l0();
                nj3.d.E.l0();
                a4 a4Var = new a4(1, pl1Var);
                Handler handler = yd4.a;
                if (n12.c(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                    a4Var.run();
                } else {
                    yd4.a.post(a4Var);
                }
                return xl4.a;
        }
    }
}
