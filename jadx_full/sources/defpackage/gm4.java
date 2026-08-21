package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gm4 extends ef0 {
    public static final gm4 z = new gm4();

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        gm0.A.z.n(runnable, true, false);
    }

    @Override // defpackage.ef0
    public final void n0(cf0 cf0Var, Runnable runnable) {
        gm0.A.z.n(runnable, true, true);
    }

    @Override // defpackage.ef0
    public final ef0 r0(int i) {
        vf2.d(i);
        return i >= bb4.d ? this : super.r0(i);
    }

    @Override // defpackage.ef0
    public final String toString() {
        return "Dispatchers.IO";
    }
}
