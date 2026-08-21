package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ly2 extends mm1 implements pl1 {
    public final /* synthetic */ int y0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ly2(int i, Object obj, Class cls, String str, String str2, int i2, int i3) {
        super(i, obj, cls, str, str2, i2);
        this.y0 = i3;
    }

    @Override // defpackage.pl1
    public final Object a() throws Exception {
        int i = this.y0;
        xl4 xl4Var = xl4.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                ((oy2) obj).c.J(Boolean.TRUE);
                return xl4Var;
            case 1:
                ((oy2) obj).c.J(Boolean.FALSE);
                return xl4Var;
            case 2:
                ((oy2) obj).c.J(Boolean.FALSE);
                return xl4Var;
            default:
                pl3 pl3Var = (pl3) obj;
                ce0 ce0Var = pl3Var.a;
                if (ce0Var == null) {
                    n12.T("coroutineScope");
                    throw null;
                }
                p95.e(ce0Var);
                pl3Var.g();
                ew ewVar = pl3Var.d;
                if (ewVar != null) {
                    ((va0) ewVar.f).close();
                    return xl4Var;
                }
                n12.T("connectionManager");
                throw null;
        }
    }
}
