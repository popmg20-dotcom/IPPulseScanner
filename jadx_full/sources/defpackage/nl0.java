package defpackage;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nl0 implements qr1, rr1 {
    public final a92 a;
    public final Context b;
    public final da3 c;
    public final Set d;
    public final Executor e;

    public nl0(Context context, String str, Set set, da3 da3Var, Executor executor) {
        this.a = new a92(new q90(1, context, str));
        this.d = set;
        this.e = executor;
        this.c = da3Var;
        this.b = context;
    }

    public final wt2 a() {
        if (!p95.v(this.b)) {
            wt2 wt2Var = new wt2();
            wt2Var.g("");
            return wt2Var;
        }
        ml0 ml0Var = new ml0(this, 0);
        Executor executor = this.e;
        tj4.j(executor, "Executor must not be null");
        wt2 wt2Var2 = new wt2();
        executor.execute(new um1(27, wt2Var2, ml0Var));
        return wt2Var2;
    }

    public final void b() {
        if (this.d.size() <= 0) {
            new wt2().g(null);
            return;
        }
        if (!p95.v(this.b)) {
            new wt2().g(null);
            return;
        }
        ml0 ml0Var = new ml0(this, 1);
        Executor executor = this.e;
        tj4.j(executor, "Executor must not be null");
        executor.execute(new um1(27, new wt2(), ml0Var));
    }
}
