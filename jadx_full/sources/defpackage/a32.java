package defpackage;

import android.content.Context;
import android.os.Process;
import io.sentry.android.core.a1;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a32 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ b32 f;

    public /* synthetic */ a32(b32 b32Var, int i) {
        this.b = i;
        this.f = b32Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        int i = this.b;
        b32 b32Var = this.f;
        switch (i) {
            case 0:
                sf0 sf0Var = (sf0) obj;
                sf0Var.getClass();
                a1.o(dh3.a(b32.class).c(), "CorruptionException in " + b32Var.a + " DataStore running in process " + Process.myPid(), sf0Var);
                return new rn2(true);
            default:
                Context context = (Context) obj;
                context.getClass();
                String str = b32Var.a;
                LinkedHashSet linkedHashSet = qv3.a;
                linkedHashSet.getClass();
                return p95.x(new ov3(context, str, rv3.a, new gd(linkedHashSet, null, 17), new pv3(3, null)));
        }
    }
}
