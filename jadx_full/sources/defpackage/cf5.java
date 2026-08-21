package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cf5 {
    public final ff5 a;
    public int b = 1;
    public long c = a();

    public cf5(ff5 ff5Var) {
        this.a = ff5Var;
    }

    public final long a() {
        ff5 ff5Var = this.a;
        tj4.i(ff5Var);
        long jLongValue = ((Long) r55.v.a(null)).longValue();
        long jLongValue2 = ((Long) r55.w.a(null)).longValue();
        for (int i = 1; i < this.b; i++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        ff5Var.z0().getClass();
        return Math.min(jLongValue, jLongValue2) + System.currentTimeMillis();
    }
}
