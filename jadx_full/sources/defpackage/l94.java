package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l94 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ String f;
    public final /* synthetic */ int z;

    public /* synthetic */ l94(int i, String str) {
        this.b = 2;
        this.z = i;
        this.f = str;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws Exception {
        io3 io3VarD0;
        k94 k94Var;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        String str = this.f;
        int i2 = this.z;
        go3 go3Var = (go3) obj;
        switch (i) {
            case 0:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.j(2, i2);
                    int iP = p95.p(io3VarD0, "work_spec_id");
                    int iP2 = p95.p(io3VarD0, "generation");
                    int iP3 = p95.p(io3VarD0, "system_id");
                    if (io3VarD0.C0()) {
                        k94Var = new k94(io3VarD0.e0(iP), (int) io3VarD0.getLong(iP2), (int) io3VarD0.getLong(iP3));
                        break;
                    } else {
                        k94Var = null;
                    }
                    return k94Var;
                } finally {
                }
            case 1:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)");
                try {
                    io3VarD0.K(1, str);
                    io3VarD0.j(2, i2);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
            default:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("UPDATE workspec SET stop_reason=? WHERE id=?");
                try {
                    io3VarD0.j(1, i2);
                    io3VarD0.K(2, str);
                    io3VarD0.C0();
                    return xl4Var;
                } finally {
                }
        }
    }

    public /* synthetic */ l94(String str, int i, int i2) {
        this.b = i2;
        this.f = str;
        this.z = i;
    }
}
