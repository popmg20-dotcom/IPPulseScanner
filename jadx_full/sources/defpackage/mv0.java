package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class mv0 {
    public static final br1 a = new br1("UNDEFINED", 3);
    public static final br1 b = new br1("REUSABLE_CLAIMED", 3);

    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[Catch: all -> 0x0069, DONT_GENERATE, TryCatch #2 {all -> 0x0069, blocks: (B:16:0x0049, B:18:0x0057, B:20:0x005d, B:33:0x008d, B:23:0x006b, B:25:0x0079, B:30:0x0084, B:32:0x008a, B:38:0x009a, B:41:0x00a3, B:40:0x00a0, B:28:0x007f), top: B:54:0x0049, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(ge0 ge0Var, Object obj) {
        v32 v32Var;
        if (!(ge0Var instanceof lv0)) {
            ge0Var.d(obj);
            return;
        }
        lv0 lv0Var = (lv0) ge0Var;
        ef0 ef0Var = lv0Var.A;
        ie0 ie0Var = lv0Var.X;
        Throwable thA = uk3.a(obj);
        Object r80Var = thA == null ? obj : new r80(thA, false);
        if (c(ef0Var, ie0Var.j())) {
            lv0Var.Y = r80Var;
            lv0Var.z = 1;
            b(ef0Var, ie0Var.j(), lv0Var);
            return;
        }
        b61 b61VarA = qd4.a();
        if (b61VarA.z >= 4294967296L) {
            lv0Var.Y = r80Var;
            lv0Var.z = 1;
            b61VarA.z0(lv0Var);
            return;
        }
        b61VarA.F0(true);
        try {
            v32Var = (v32) ie0Var.j().Z(pr1.X);
        } finally {
            try {
            } finally {
            }
        }
        if (v32Var == null || v32Var.isActive()) {
            Object obj2 = lv0Var.Z;
            cf0 cf0VarJ = ie0Var.j();
            Object objC = nd4.c(cf0VarJ, obj2);
            bl4 bl4VarC0 = objC != nd4.a ? co4.c0(ie0Var, cf0VarJ, objC) : null;
            try {
                ie0Var.d(obj);
            } finally {
                if (bl4VarC0 == null || bl4VarC0.n0()) {
                    nd4.a(cf0VarJ, objC);
                }
            }
        }
        lv0Var.d(n12.r(v32Var.F()));
        while (b61VarA.H0()) {
        }
    }

    public static final void b(ef0 ef0Var, cf0 cf0Var, Runnable runnable) {
        try {
            ef0Var.j0(cf0Var, runnable);
        } catch (Throwable th) {
            throw new kv0(th, ef0Var, cf0Var);
        }
    }

    public static final boolean c(ef0 ef0Var, cf0 cf0Var) throws kv0 {
        try {
            return ef0Var.q0(cf0Var);
        } catch (Throwable th) {
            throw new kv0(th, ef0Var, cf0Var);
        }
    }
}
