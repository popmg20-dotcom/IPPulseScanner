package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vv {
    public Object a;
    public yv b;
    public wj3 c;
    public boolean d;

    public final void a(Runnable runnable, Executor executor) {
        wj3 wj3Var = this.c;
        if (wj3Var != null) {
            wj3Var.a(runnable, executor);
        }
    }

    public final boolean b(Object obj) {
        this.d = true;
        yv yvVar = this.b;
        boolean z = yvVar != null && yvVar.f.j(obj);
        if (z) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
        return z;
    }

    public final void c() {
        this.d = true;
        yv yvVar = this.b;
        if (yvVar == null || !yvVar.f.cancel(true)) {
            return;
        }
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public final boolean d(Throwable th) {
        this.d = true;
        yv yvVar = this.b;
        boolean z = yvVar != null && yvVar.f.k(th);
        if (z) {
            this.a = null;
            this.b = null;
            this.c = null;
        }
        return z;
    }

    public final void finalize() {
        wj3 wj3Var;
        yv yvVar = this.b;
        if (yvVar != null && !yvVar.f.isDone()) {
            yvVar.b(new q1("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a, 1));
        }
        if (this.d || (wj3Var = this.c) == null) {
            return;
        }
        wj3Var.j(null);
    }
}
