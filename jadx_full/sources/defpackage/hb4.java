package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class hb4 {
    public static final ha1 a;

    static {
        ha1 ha1Var = new ha1(28);
        ha1Var.f = null;
        a = ha1Var;
    }

    public static float[] a(int i) {
        float[] fArr;
        ha1 ha1Var = a;
        synchronized (ha1Var) {
            fArr = (float[]) ha1Var.f;
            ha1Var.f = null;
        }
        return (fArr == null || fArr.length < i) ? new float[i] : fArr;
    }

    public static void b(float[] fArr) {
        ha1 ha1Var = a;
        if (fArr.length > 1000) {
            return;
        }
        synchronized (ha1Var) {
            ha1Var.f = fArr;
        }
    }
}
