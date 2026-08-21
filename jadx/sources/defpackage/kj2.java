package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kj2 {
    public final hg0 a;
    public final float b;
    public float c;
    public float d;
    public final /* synthetic */ lj2 e;

    public kj2(lj2 lj2Var, hg0 hg0Var, float f, float f2) {
        hg0Var.getClass();
        this.e = lj2Var;
        this.a = hg0Var;
        if (f2 < f) {
            xe.k("endOutlineProgress is expected to be equal or greater than startOutlineProgress");
            throw null;
        }
        this.b = lj2Var.b.a(hg0Var);
        this.c = f;
        this.d = f2;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [c8] */
    public final e03 a(float f) {
        float fT = gb4.t(f, this.c, this.d);
        float f2 = this.d;
        float f3 = this.c;
        float f4 = (fT - f3) / (f2 - f3);
        lj2 lj2Var = this.e;
        final d8 d8Var = lj2Var.b;
        final float f5 = f4 * this.b;
        d8Var.getClass();
        final hg0 hg0Var = this.a;
        hg0Var.getClass();
        float[] fArr = hg0Var.a;
        final float fA = eo4.a(fArr[0] - d8Var.a, fArr[1] - d8Var.b);
        ?? r5 = new Object() { // from class: c8
            public final float a(float f6) {
                hg0 hg0Var2 = hg0Var;
                hg0Var2.getClass();
                d8 d8Var2 = d8Var;
                d8Var2.getClass();
                long jC = hg0Var2.c(f6);
                return Math.abs(eo4.d(eo4.a(yr2.H(jC) - d8Var2.a, yr2.I(jC) - d8Var2.b) - fA, eo4.c) - f5);
            }
        };
        float f6 = 0.0f;
        float f7 = 1.0f;
        while (f7 - f6 > 1.0E-5f) {
            float f8 = ((2.0f * f6) + f7) / 3.0f;
            float f9 = ((2.0f * f7) + f6) / 3.0f;
            if (r5.a(f8) < r5.a(f9)) {
                f7 = f9;
            } else {
                f6 = f8;
            }
        }
        float f10 = (f6 + f7) / 2.0f;
        if (0.0f > f10 || f10 > 1.0f) {
            xe.k("Cubic cut point is expected to be between 0 and 1");
            return null;
        }
        e03 e03VarD = hg0Var.d(f10);
        return new e03(new kj2(lj2Var, (hg0) e03VarD.b, this.c, fT), new kj2(lj2Var, (hg0) e03VarD.f, fT, this.d));
    }

    public final String toString() {
        return "MeasuredCubic(outlineProgress=[" + this.c + " .. " + this.d + "], size=" + this.b + ", cubic=" + this.a + ')';
    }
}
