package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class mo4 extends lo4 {
    public v03[] a;
    public String b;
    public int c;

    public mo4(mo4 mo4Var) {
        this.a = null;
        this.c = 0;
        this.b = mo4Var.b;
        this.a = n12.v(mo4Var.a);
    }

    public v03[] getPathData() {
        return this.a;
    }

    public String getPathName() {
        return this.b;
    }

    public void setPathData(v03[] v03VarArr) {
        if (!n12.f(this.a, v03VarArr)) {
            this.a = n12.v(v03VarArr);
            return;
        }
        v03[] v03VarArr2 = this.a;
        for (int i = 0; i < v03VarArr.length; i++) {
            v03VarArr2[i].a = v03VarArr[i].a;
            int i2 = 0;
            while (true) {
                float[] fArr = v03VarArr[i].b;
                if (i2 < fArr.length) {
                    v03VarArr2[i].b[i2] = fArr[i2];
                    i2++;
                }
            }
        }
    }

    public mo4() {
        this.a = null;
        this.c = 0;
    }
}
