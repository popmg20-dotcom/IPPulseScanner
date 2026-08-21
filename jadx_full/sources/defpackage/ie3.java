package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ie3 implements Runnable {
    public final sv b;
    public volatile AtomicInteger f = new AtomicInteger(0);
    public final /* synthetic */ le3 z;

    public ie3(le3 le3Var, sv svVar) {
        this.z = le3Var;
        this.b = svVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        iv1 iv1Var;
        String strConcat = "OkHttp ".concat(((ev1) this.z.f.f).h());
        le3 le3Var = this.z;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            le3Var.A.h();
            boolean z = false;
            try {
                try {
                    try {
                        this.b.t(le3Var, le3Var.g());
                        iv1Var = le3Var.b.a;
                    } catch (IOException e) {
                        e = e;
                        z = true;
                        if (z) {
                            k13 k13Var = k13.a;
                            k13 k13Var2 = k13.a;
                            StringBuilder sb = new StringBuilder("Callback failure for ");
                            sb.append((le3Var.G0 ? "canceled " : "") + "call to " + ((ev1) le3Var.f.f).h());
                            k13Var2.i(4, sb.toString(), e);
                        } else {
                            this.b.o(le3Var, e);
                        }
                        iv1Var = le3Var.b.a;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        le3Var.c();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            iOException.initCause(th);
                            this.b.o(le3Var, iOException);
                        }
                        if (!(th instanceof InterruptedException)) {
                            throw th;
                        }
                        Thread.currentThread().interrupt();
                        iv1Var = le3Var.b.a;
                    }
                } catch (Throwable th2) {
                    iv1 iv1Var2 = le3Var.b.a;
                    iv1Var2.getClass();
                    iv1.y(iv1Var2, null, null, this, 3);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
            iv1Var.getClass();
            iv1.y(iv1Var, null, null, this, 3);
        } finally {
            threadCurrentThread.setName(name);
        }
    }
}
