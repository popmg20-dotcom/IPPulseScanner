package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import io.sentry.android.core.u;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z95 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ib5 f;

    public /* synthetic */ z95(ib5 ib5Var, int i) {
        this.b = i;
        this.f = ib5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ib5 ib5Var = this.f;
        switch (i) {
            case 0:
                ib5Var.s1();
                break;
            case 1:
                o75 o75Var = ib5Var.L0;
                k85 k85Var = o75Var.a;
                f85 f85Var = k85Var.Z;
                ib5 ib5Var2 = k85Var.D0;
                l75 l75Var = k85Var.X;
                k85.h(f85Var);
                f85Var.V0();
                if (o75Var.d()) {
                    if (o75Var.c()) {
                        k85.f(l75Var);
                        l75Var.Q0.C(null);
                        Bundle bundle = new Bundle();
                        bundle.putString("source", "(not set)");
                        bundle.putString("medium", "(not set)");
                        bundle.putString("_cis", "intent");
                        bundle.putLong("_cc", 1L);
                        k85.g(ib5Var2);
                        ib5Var2.c1("auto", "_cmpx", bundle);
                    } else {
                        k85.f(l75Var);
                        ue1 ue1Var = l75Var.Q0;
                        String strB = ue1Var.B();
                        if (TextUtils.isEmpty(strB)) {
                            t65 t65Var = k85Var.Y;
                            k85.h(t65Var);
                            t65Var.A0.a("Cache still valid but referrer not found");
                        } else {
                            long j = 3600000;
                            long jA = l75Var.R0.a() / 3600000;
                            Uri uri = Uri.parse(strB);
                            Bundle bundle2 = new Bundle();
                            Pair pair = new Pair(uri.getPath(), bundle2);
                            for (String str : uri.getQueryParameterNames()) {
                                bundle2.putString(str, uri.getQueryParameter(str));
                                j = j;
                            }
                            ((Bundle) pair.second).putLong("_cc", (jA - 1) * j);
                            Object obj = pair.first;
                            String str2 = obj == null ? "app" : (String) obj;
                            k85.g(ib5Var2);
                            ib5Var2.c1(str2, "_cmp", (Bundle) pair.second);
                        }
                        ue1Var.C(null);
                    }
                    k85.f(l75Var);
                    l75Var.R0.b(0L);
                    break;
                }
                break;
            case 2:
                ib5Var.V0();
                k85 k85Var2 = (k85) ib5Var.f;
                l75 l75Var2 = k85Var2.X;
                t65 t65Var2 = k85Var2.Y;
                k85.f(l75Var2);
                f75 f75Var = l75Var2.N0;
                if (f75Var.a()) {
                    k85.h(t65Var2);
                    t65Var2.G0.a("Deferred Deep Link already retrieved. Not fetching again.");
                } else {
                    u uVar = l75Var2.O0;
                    long jA2 = uVar.a();
                    uVar.b(1 + jA2);
                    if (jA2 >= 5) {
                        k85.h(t65Var2);
                        t65Var2.C0.a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                        f75Var.b(true);
                    } else {
                        ba5 ba5Var = ib5Var.N0;
                        if (ba5Var == null) {
                            ba5Var = new ba5(ib5Var, k85Var2, 3, false);
                            ib5Var.N0 = ba5Var;
                        }
                        ba5Var.b(0L);
                    }
                }
                break;
            default:
                ib5Var.s1();
                break;
        }
    }
}
