package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class rb4 implements Comparable {
    public final Object b;
    public final c1 f;
    public final ft0 z;

    public rb4(ft0 ft0Var, Object obj) {
        if (obj instanceof c1) {
            this.f = (c1) obj;
        } else {
            this.b = obj;
        }
        this.z = ft0Var.p().k("key");
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ft0 ft0Var;
        rb4 rb4Var = (rb4) obj;
        Object objN = null;
        ft0 ft0Var2 = this.z;
        c1 c1Var = this.f;
        Object objN2 = (c1Var == null || ft0Var2 == null) ? null : c1Var.n(ft0Var2);
        c1 c1Var2 = rb4Var.f;
        if (c1Var2 != null && (ft0Var = rb4Var.z) != null) {
            objN = c1Var2.n(ft0Var);
        }
        if (objN2 == null && objN == null) {
            return 0;
        }
        if (objN2 == null) {
            return -1;
        }
        if (objN == null) {
            return 1;
        }
        int iOrdinal = ft0Var2.r().b.ordinal();
        if (iOrdinal == 0) {
            return ((Integer) objN2).compareTo((Integer) objN);
        }
        if (iOrdinal == 1) {
            return ((Long) objN2).compareTo((Long) objN);
        }
        if (iOrdinal == 4) {
            return ((Boolean) objN2).compareTo((Boolean) objN);
        }
        if (iOrdinal != 5) {
            return 0;
        }
        return ((String) objN2).compareTo((String) objN);
    }
}
