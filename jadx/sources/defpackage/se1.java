package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class se1 {
    public final int a;
    public final int[] b;
    public final xk3[] c;

    public se1(int i, int i2, int i3, int i4, int[] iArr) {
        this.a = i;
        this.b = iArr;
        float f = i4;
        this.c = new xk3[]{new xk3(i2, f), new xk3(i3, f)};
    }

    public final boolean equals(Object obj) {
        return (obj instanceof se1) && this.a == ((se1) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }
}
