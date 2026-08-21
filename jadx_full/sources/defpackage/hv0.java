package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class hv0 implements Closeable {
    public final gv0 b;
    public boolean f;
    public final /* synthetic */ jv0 z;

    public hv0(jv0 jv0Var, gv0 gv0Var) {
        this.z = jv0Var;
        this.b = gv0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f) {
            return;
        }
        this.f = true;
        jv0 jv0Var = this.z;
        synchronized (jv0Var) {
            gv0 gv0Var = this.b;
            int i = gv0Var.h - 1;
            gv0Var.h = i;
            if (i == 0 && gv0Var.f) {
                uh3 uh3Var = jv0.H0;
                jv0Var.Q(gv0Var);
            }
        }
    }
}
