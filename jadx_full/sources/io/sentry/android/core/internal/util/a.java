package io.sentry.android.core.internal.util;

import android.net.ConnectivityManager;
import io.sentry.android.core.j0;
import io.sentry.r0;
import io.sentry.s0;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ b f;

    public /* synthetic */ a(b bVar, int i) {
        this.b = i;
        this.f = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        io.sentry.util.a aVar;
        int i = this.b;
        b bVar = this.f;
        switch (i) {
            case 0:
                bVar.U(true);
                aVar = b.E0;
                aVar.g();
                try {
                    b.F0.clear();
                    aVar.close();
                    io.sentry.util.a aVar2 = b.C0;
                    aVar2.g();
                    try {
                        b.D0 = null;
                        aVar2.close();
                        j0.X.x(bVar);
                        return;
                    } catch (Throwable th) {
                        try {
                            aVar2.close();
                            break;
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } finally {
                    try {
                        aVar.close();
                        break;
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
            case 1:
                bVar.x();
                return;
            case 2:
                bVar.U(false);
                return;
            default:
                bVar.X(null);
                r0 r0VarC = bVar.C();
                if (r0VarC == r0.DISCONNECTED) {
                    bVar.B0.set(false);
                    aVar = b.E0;
                    aVar.g();
                    try {
                        Iterator it = b.F0.iterator();
                        while (it.hasNext()) {
                            ((ConnectivityManager.NetworkCallback) it.next()).onLost(null);
                            break;
                        }
                        aVar.close();
                    } catch (Throwable th4) {
                        try {
                            break;
                        } catch (Throwable th32) {
                        }
                        throw th4;
                    }
                }
                io.sentry.util.a aVar3 = bVar.Y;
                aVar3.g();
                try {
                    Iterator it2 = bVar.X.iterator();
                    while (it2.hasNext()) {
                        ((s0) it2.next()).s(r0VarC);
                        break;
                    }
                    aVar3.close();
                    bVar.x();
                    return;
                } catch (Throwable th5) {
                    try {
                        aVar3.close();
                        break;
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
        }
    }
}
