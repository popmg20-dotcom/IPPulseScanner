package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class z12 extends y32 {
    public static final /* synthetic */ long Y = re.a.objectFieldOffset(z12.class.getDeclaredField("_invoked$volatile"));
    public final x12 X;
    private volatile /* synthetic */ int _invoked$volatile;

    public z12(x12 x12Var) {
        this.X = x12Var;
    }

    @Override // defpackage.y32
    public final boolean l() {
        return true;
    }

    @Override // defpackage.y32
    public final void m(Throwable th) {
        if (re.a.compareAndSwapInt(this, Y, 0, 1)) {
            this.X.g(th);
        }
    }
}
