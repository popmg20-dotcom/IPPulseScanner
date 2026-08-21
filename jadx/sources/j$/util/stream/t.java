package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends z0 {
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(a aVar, int i, int i2) {
        super(aVar, i);
        this.l = i2;
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new r(this, j5Var, 1);
            case 1:
                return new u0(this, j5Var, 2);
            case 2:
                return j5Var;
            default:
                return new c1(this, j5Var, 2);
        }
    }
}
