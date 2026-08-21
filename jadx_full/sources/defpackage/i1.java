package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class i1 implements m03 {
    public static final o91 a = o91.a();

    public static void b(nl2 nl2Var) throws s12 {
        if (nl2Var == null || nl2Var.c()) {
        } else {
            throw (nl2Var instanceof c1 ? a1.C((c1) nl2Var) : new vl4("Message was missing required fields.  (Lite runtime could not determine which fields were missing).")).a();
        }
    }

    public final nl2 c(byte[] bArr, int i, int i2, o91 o91Var) throws s12 {
        m60 m60VarD = m60.d(bArr, i, i2, false);
        nl2 nl2Var = (nl2) a(m60VarD, o91Var);
        m60VarD.a(0);
        b(nl2Var);
        return nl2Var;
    }
}
