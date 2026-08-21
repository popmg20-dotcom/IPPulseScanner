package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wa4 {
    public final wt2 a = new wt2();

    public final void a(Exception exc) {
        wt2 wt2Var = this.a;
        tj4.j(exc, "Exception must not be null");
        synchronized (wt2Var.b) {
            try {
                if (wt2Var.c) {
                    return;
                }
                wt2Var.c = true;
                wt2Var.a = exc;
                ((fa5) wt2Var.d).y(wt2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Object obj) {
        wt2 wt2Var = this.a;
        synchronized (wt2Var.b) {
            try {
                if (wt2Var.c) {
                    return;
                }
                wt2Var.c = true;
                wt2Var.e = obj;
                ((fa5) wt2Var.d).y(wt2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
