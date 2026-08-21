package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d8 {
    public float a;
    public float b;

    public /* synthetic */ d8(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public float a(hg0 hg0Var) {
        hg0Var.getClass();
        float fA = hg0Var.a();
        float f = this.a;
        float fB = hg0Var.b();
        float f2 = this.b;
        float fA2 = eo4.a(fA - f, fB - f2);
        float[] fArr = hg0Var.a;
        float fA3 = fA2 - eo4.a(fArr[0] - f, fArr[1] - f2);
        float f3 = eo4.c;
        float fD = eo4.d(fA3, f3);
        if (fD > f3 - 1.0E-4f) {
            return 0.0f;
        }
        return fD;
    }

    public d8() {
    }
}
