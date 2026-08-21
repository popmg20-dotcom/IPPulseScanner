package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ll1 implements f64 {
    public final boolean A;
    public final boolean X;
    public final n84 Y;
    public boolean Z;
    public final Context b;
    public final String f;
    public final t6 z;

    public ll1(Context context, String str, t6 t6Var, boolean z, boolean z2) {
        context.getClass();
        t6Var.getClass();
        this.b = context;
        this.f = str;
        this.z = t6Var;
        this.A = z;
        this.X = z2;
        this.Y = new n84(new fn(4, this));
    }

    @Override // defpackage.f64
    public final gl1 T() {
        return ((kl1) this.Y.getValue()).g(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        n84 n84Var = this.Y;
        if (n84Var.c()) {
            ((kl1) n84Var.getValue()).close();
        }
    }

    @Override // defpackage.f64
    public final String getDatabaseName() {
        return this.f;
    }

    @Override // defpackage.f64
    public final void setWriteAheadLoggingEnabled(boolean z) {
        n84 n84Var = this.Y;
        if (n84Var.c()) {
            ((kl1) n84Var.getValue()).setWriteAheadLoggingEnabled(z);
        }
        this.Z = z;
    }
}
