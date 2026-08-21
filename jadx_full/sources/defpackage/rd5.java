package defpackage;

import j$.util.Objects;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rd5 implements Runnable {
    public final long b;
    public final long f;
    public final /* synthetic */ ca5 z;

    public rd5(ca5 ca5Var, long j, long j2) {
        Objects.requireNonNull(ca5Var);
        this.z = ca5Var;
        this.b = j;
        this.f = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        f85 f85Var = ((k85) ((zd5) this.z.b).f).Z;
        k85.h(f85Var);
        f85Var.e1(new qz4(6, this));
    }
}
