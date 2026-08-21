package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hx4 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ long f;
    public final /* synthetic */ String z;

    public /* synthetic */ hx4(long j, String str, int i) {
        this.b = i;
        this.f = j;
        this.z = str;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws Exception {
        io3 io3VarD0;
        int i = this.b;
        String str = this.z;
        long j = this.f;
        go3 go3Var = (go3) obj;
        switch (i) {
            case 0:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("UPDATE workspec SET schedule_requested_at=? WHERE id=?");
                try {
                    io3VarD0.j(1, j);
                    io3VarD0.K(2, str);
                    io3VarD0.C0();
                    int iC = r25.C(go3Var);
                    io3VarD0.close();
                    return Integer.valueOf(iC);
                } finally {
                }
            default:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("UPDATE workspec SET last_enqueue_time=? WHERE id=?");
                try {
                    io3VarD0.j(1, j);
                    io3VarD0.K(2, str);
                    io3VarD0.C0();
                    io3VarD0.close();
                    return xl4.a;
                } finally {
                }
        }
    }
}
