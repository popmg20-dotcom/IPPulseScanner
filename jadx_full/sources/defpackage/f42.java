package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f42 {
    public static final br1 a = new br1("COMPLETING_ALREADY", 3);
    public static final br1 b = new br1("COMPLETING_WAITING_CHILDREN", 3);
    public static final br1 c = new br1("COMPLETING_RETRY", 3);
    public static final br1 d = new br1("TOO_LATE_TO_CANCEL", 3);
    public static final br1 e = new br1("SEALED", 3);
    public static final a41 f = new a41(false);
    public static final a41 g = new a41(true);

    public static final Object a(Object obj) {
        pz1 pz1Var = obj instanceof pz1 ? (pz1) obj : null;
        return pz1Var != null ? pz1Var.a : obj;
    }
}
