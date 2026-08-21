package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ta3 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ String f;
    public final /* synthetic */ String z;

    public /* synthetic */ ta3(String str, String str2, int i) {
        this.b = i;
        this.f = str;
        this.z = str2;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws Exception {
        io3 io3VarD0;
        int i = this.b;
        String str = this.z;
        String str2 = this.f;
        go3 go3Var = (go3) obj;
        switch (i) {
            case 0:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("SELECT selection FROM proxy_group_selection WHERE profileName = ? AND groupName = ?");
                try {
                    io3VarD0.K(1, str2);
                    io3VarD0.K(2, str);
                    String strE0 = null;
                    if (io3VarD0.C0() && !io3VarD0.isNull(0)) {
                        strE0 = io3VarD0.e0(0);
                        break;
                    }
                    return strE0;
                } finally {
                }
            default:
                go3Var.getClass();
                io3VarD0 = go3Var.D0("UPDATE proxy_group_selection SET profileName = ? WHERE profileName = ?");
                try {
                    io3VarD0.K(1, str2);
                    io3VarD0.K(2, str);
                    io3VarD0.C0();
                    io3VarD0.close();
                    return xl4.a;
                } finally {
                }
        }
    }
}
