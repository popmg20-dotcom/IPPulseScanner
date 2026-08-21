package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tb5 implements Runnable {
    public final /* synthetic */ boolean A;
    public final /* synthetic */ yb5 X;
    public final /* synthetic */ rb5 b;
    public final /* synthetic */ rb5 f;
    public final /* synthetic */ long z;

    public tb5(yb5 yb5Var, rb5 rb5Var, rb5 rb5Var2, long j, boolean z) {
        this.b = rb5Var;
        this.f = rb5Var2;
        this.z = j;
        this.A = z;
        this.X = yb5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.X.f1(this.b, this.f, this.z, this.A, null);
    }
}
