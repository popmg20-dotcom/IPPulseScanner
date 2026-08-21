package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class c61 extends e61 {
    public final /* synthetic */ g61 A;
    public final z00 z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c61(g61 g61Var, long j, z00 z00Var) {
        super(j);
        this.A = g61Var;
        this.z = z00Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.z.F(this.A);
    }

    @Override // defpackage.e61
    public final String toString() {
        return super.toString() + this.z;
    }
}
