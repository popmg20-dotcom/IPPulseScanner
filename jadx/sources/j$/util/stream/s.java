package j$.util.stream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends z {
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(a aVar, int i, int i2) {
        super(aVar, i);
        this.l = i2;
    }

    @Override // j$.util.stream.a
    public final j5 J(int i, j5 j5Var) {
        switch (this.l) {
            case 0:
                return new r(this, j5Var, 0);
            case 1:
                return j5Var;
            case 2:
                return new r(this, j5Var, 3);
            case 3:
                return new u0(1, j5Var);
            case 4:
                return new u0(this, j5Var, 4);
            case 5:
                return new c1(j5Var);
            default:
                return new c1(this, j5Var, 3);
        }
    }
}
