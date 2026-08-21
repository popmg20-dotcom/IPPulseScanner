package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w43 extends ke {
    public jz3[] f;
    public jz3[] g;
    public int h;
    public v62 i;

    @Override // defpackage.ke
    public final jz3 d(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.h; i2++) {
            jz3[] jz3VarArr = this.f;
            jz3 jz3Var = jz3VarArr[i2];
            if (!zArr[jz3Var.f]) {
                v62 v62Var = this.i;
                v62Var.f = jz3Var;
                int i3 = 8;
                if (i == -1) {
                    while (i3 >= 0) {
                        float f = ((jz3) v62Var.f).y0[i3];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i2;
                                break;
                            }
                            i3--;
                        }
                    }
                } else {
                    jz3 jz3Var2 = jz3VarArr[i];
                    while (true) {
                        if (i3 >= 0) {
                            float f2 = jz3Var2.y0[i3];
                            float f3 = ((jz3) v62Var.f).y0[i3];
                            if (f3 == f2) {
                                i3--;
                            } else if (f3 < f2) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f[i];
    }

    @Override // defpackage.ke
    public final boolean e() {
        return this.h == 0;
    }

    @Override // defpackage.ke
    public final void i(gb2 gb2Var, ke keVar, boolean z) {
        jz3 jz3Var = keVar.a;
        if (jz3Var == null) {
            return;
        }
        float[] fArr = jz3Var.y0;
        ce ceVar = keVar.d;
        int iD = ceVar.d();
        for (int i = 0; i < iD; i++) {
            jz3 jz3VarE = ceVar.e(i);
            float f = ceVar.f(i);
            v62 v62Var = this.i;
            v62Var.f = jz3VarE;
            if (jz3VarE.b) {
                boolean z2 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = ((jz3) v62Var.f).y0;
                    float f2 = (fArr[i2] * f) + fArr2[i2];
                    fArr2[i2] = f2;
                    if (Math.abs(f2) < 1.0E-4f) {
                        ((jz3) v62Var.f).y0[i2] = 0.0f;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    ((w43) v62Var.z).k((jz3) v62Var.f);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f3 = fArr[i3];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        ((jz3) v62Var.f).y0[i3] = f4;
                    } else {
                        ((jz3) v62Var.f).y0[i3] = 0.0f;
                    }
                }
                j(jz3VarE);
            }
            this.b = (keVar.b * f) + this.b;
        }
        k(jz3Var);
    }

    public final void j(jz3 jz3Var) {
        int i;
        jz3[] jz3VarArr;
        int i2 = this.h + 1;
        jz3[] jz3VarArr2 = this.f;
        if (i2 > jz3VarArr2.length) {
            jz3[] jz3VarArr3 = (jz3[]) Arrays.copyOf(jz3VarArr2, jz3VarArr2.length * 2);
            this.f = jz3VarArr3;
            this.g = (jz3[]) Arrays.copyOf(jz3VarArr3, jz3VarArr3.length * 2);
        }
        jz3[] jz3VarArr4 = this.f;
        int i3 = this.h;
        jz3VarArr4[i3] = jz3Var;
        int i4 = i3 + 1;
        this.h = i4;
        if (i4 > 1 && jz3VarArr4[i3].f > jz3Var.f) {
            int i5 = 0;
            while (true) {
                i = this.h;
                jz3VarArr = this.g;
                if (i5 >= i) {
                    break;
                }
                jz3VarArr[i5] = this.f[i5];
                i5++;
            }
            Arrays.sort(jz3VarArr, 0, i, new e1(17));
            for (int i6 = 0; i6 < this.h; i6++) {
                this.f[i6] = this.g[i6];
            }
        }
        jz3Var.b = true;
        jz3Var.a(this);
    }

    public final void k(jz3 jz3Var) {
        int i = 0;
        while (i < this.h) {
            if (this.f[i] == jz3Var) {
                while (true) {
                    int i2 = this.h;
                    if (i >= i2 - 1) {
                        this.h = i2 - 1;
                        jz3Var.b = false;
                        return;
                    } else {
                        jz3[] jz3VarArr = this.f;
                        int i3 = i + 1;
                        jz3VarArr[i] = jz3VarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.ke
    public final String toString() {
        v62 v62Var = this.i;
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.h; i++) {
            v62Var.f = this.f[i];
            str = str + v62Var + " ";
        }
        return str;
    }
}
