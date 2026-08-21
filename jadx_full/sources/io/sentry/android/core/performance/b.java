package io.sentry.android.core.performance;

import android.os.Looper;
import io.sentry.n1;
import io.sentry.u1;
import io.sentry.w4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final String a;
    public w4 b = null;
    public w4 c = null;
    public n1 d = null;
    public n1 e = null;

    public b(String str) {
        this.a = str;
    }

    public static n1 a(n1 n1Var, String str, w4 w4Var) {
        n1 n1VarC = n1Var.c(str, w4Var, u1.SENTRY);
        n1VarC.h(Long.valueOf(io.sentry.android.core.internal.util.d.d(Looper.getMainLooper().getThread())), "thread.id");
        n1VarC.h("main", "thread.name");
        Boolean bool = Boolean.TRUE;
        n1VarC.h(bool, "ui.contributes_to_ttid");
        n1VarC.h(bool, "ui.contributes_to_ttfd");
        return n1VarC;
    }
}
