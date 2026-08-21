package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class pi1 implements Comparable {
    public final String A;
    public final int b;
    public final int f;
    public final String z;

    public pi1(int i, int i2, String str, String str2) {
        str.getClass();
        str2.getClass();
        this.b = i;
        this.f = i2;
        this.z = str;
        this.A = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        pi1 pi1Var = (pi1) obj;
        pi1Var.getClass();
        int i = this.b - pi1Var.b;
        return i == 0 ? this.f - pi1Var.f : i;
    }
}
