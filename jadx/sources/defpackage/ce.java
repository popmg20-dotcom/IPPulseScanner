package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ce {
    public final ke b;
    public final ed4 c;
    public int a = 0;
    public int d = 8;
    public int[] e = new int[8];
    public int[] f = new int[8];
    public float[] g = new float[8];
    public int h = -1;
    public int i = -1;
    public boolean j = false;

    public ce(ke keVar, ed4 ed4Var) {
        this.b = keVar;
        this.c = ed4Var;
    }

    public final void a(jz3 jz3Var, float f, boolean z) {
        int[] iArr;
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.h;
            ke keVar = this.b;
            if (i == -1) {
                this.h = 0;
                this.g[0] = f;
                this.e[0] = jz3Var.f;
                this.f[0] = -1;
                jz3Var.B0++;
                jz3Var.a(keVar);
                this.a++;
                if (this.j) {
                    return;
                }
                int i2 = this.i + 1;
                this.i = i2;
                int[] iArr2 = this.e;
                if (i2 >= iArr2.length) {
                    this.j = true;
                    this.i = iArr2.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.a; i4++) {
                int i5 = this.e[i];
                int i6 = jz3Var.f;
                if (i5 == i6) {
                    float[] fArr = this.g;
                    float f2 = fArr[i] + f;
                    if (f2 > -0.001f && f2 < 0.001f) {
                        f2 = 0.0f;
                    }
                    fArr[i] = f2;
                    if (f2 == 0.0f) {
                        int i7 = this.h;
                        int[] iArr3 = this.f;
                        if (i == i7) {
                            this.h = iArr3[i];
                        } else {
                            iArr3[i3] = iArr3[i];
                        }
                        if (z) {
                            jz3Var.b(keVar);
                        }
                        if (this.j) {
                            this.i = i;
                        }
                        jz3Var.B0--;
                        this.a--;
                        return;
                    }
                    return;
                }
                if (i5 < i6) {
                    i3 = i;
                }
                i = this.f[i];
            }
            int length = this.i;
            int i8 = length + 1;
            if (this.j) {
                int[] iArr4 = this.e;
                if (iArr4[length] != -1) {
                    length = iArr4.length;
                }
            } else {
                length = i8;
            }
            int[] iArr5 = this.e;
            if (length >= iArr5.length && this.a < iArr5.length) {
                int i9 = 0;
                while (true) {
                    iArr = this.e;
                    if (i9 >= iArr.length) {
                        iArr5 = iArr;
                        break;
                    } else {
                        if (iArr[i9] == -1) {
                            length = i9;
                            break;
                        }
                        i9++;
                    }
                }
            } else {
                iArr = iArr5;
            }
            if (length >= iArr.length) {
                length = iArr.length;
                int i10 = this.d * 2;
                this.d = i10;
                this.j = false;
                this.i = length - 1;
                this.g = Arrays.copyOf(this.g, i10);
                this.e = Arrays.copyOf(this.e, this.d);
                this.f = Arrays.copyOf(this.f, this.d);
            }
            this.e[length] = jz3Var.f;
            this.g[length] = f;
            int[] iArr6 = this.f;
            if (i3 != -1) {
                iArr6[length] = iArr6[i3];
                iArr6[i3] = length;
            } else {
                iArr6[length] = this.h;
                this.h = length;
            }
            jz3Var.B0++;
            jz3Var.a(keVar);
            this.a++;
            if (!this.j) {
                this.i++;
            }
            int i11 = this.i;
            int[] iArr7 = this.e;
            if (i11 >= iArr7.length) {
                this.j = true;
                this.i = iArr7.length - 1;
            }
        }
    }

    public final void b() {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            jz3 jz3Var = ((jz3[]) this.c.A)[this.e[i]];
            if (jz3Var != null) {
                jz3Var.b(this.b);
            }
            i = this.f[i];
        }
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.a = 0;
    }

    public final float c(jz3 jz3Var) {
        int i = this.h;
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            if (this.e[i] == jz3Var.f) {
                return this.g[i];
            }
            i = this.f[i];
        }
        return 0.0f;
    }

    public final int d() {
        return this.a;
    }

    public final jz3 e(int i) {
        int i2 = this.h;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return ((jz3[]) this.c.A)[this.e[i2]];
            }
            i2 = this.f[i2];
        }
        return null;
    }

    public final float f(int i) {
        int i2 = this.h;
        for (int i3 = 0; i2 != -1 && i3 < this.a; i3++) {
            if (i3 == i) {
                return this.g[i2];
            }
            i2 = this.f[i2];
        }
        return 0.0f;
    }

    public final void g(jz3 jz3Var, float f) {
        int[] iArr;
        if (f == 0.0f) {
            h(jz3Var, true);
            return;
        }
        int i = this.h;
        ke keVar = this.b;
        if (i == -1) {
            this.h = 0;
            this.g[0] = f;
            this.e[0] = jz3Var.f;
            this.f[0] = -1;
            jz3Var.B0++;
            jz3Var.a(keVar);
            this.a++;
            if (this.j) {
                return;
            }
            int i2 = this.i + 1;
            this.i = i2;
            int[] iArr2 = this.e;
            if (i2 >= iArr2.length) {
                this.j = true;
                this.i = iArr2.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.a; i4++) {
            int i5 = this.e[i];
            int i6 = jz3Var.f;
            if (i5 == i6) {
                this.g[i] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f[i];
        }
        int length = this.i;
        int i7 = length + 1;
        if (this.j) {
            int[] iArr3 = this.e;
            if (iArr3[length] != -1) {
                length = iArr3.length;
            }
        } else {
            length = i7;
        }
        int[] iArr4 = this.e;
        if (length >= iArr4.length && this.a < iArr4.length) {
            int i8 = 0;
            while (true) {
                iArr = this.e;
                if (i8 >= iArr.length) {
                    iArr4 = iArr;
                    break;
                } else {
                    if (iArr[i8] == -1) {
                        length = i8;
                        break;
                    }
                    i8++;
                }
            }
        } else {
            iArr = iArr4;
        }
        if (length >= iArr.length) {
            length = iArr.length;
            int i9 = this.d * 2;
            this.d = i9;
            this.j = false;
            this.i = length - 1;
            this.g = Arrays.copyOf(this.g, i9);
            this.e = Arrays.copyOf(this.e, this.d);
            this.f = Arrays.copyOf(this.f, this.d);
        }
        this.e[length] = jz3Var.f;
        this.g[length] = f;
        int[] iArr5 = this.f;
        if (i3 != -1) {
            iArr5[length] = iArr5[i3];
            iArr5[i3] = length;
        } else {
            iArr5[length] = this.h;
            this.h = length;
        }
        jz3Var.B0++;
        jz3Var.a(keVar);
        int i10 = this.a + 1;
        this.a = i10;
        if (!this.j) {
            this.i++;
        }
        int[] iArr6 = this.e;
        if (i10 >= iArr6.length) {
            this.j = true;
        }
        if (this.i >= iArr6.length) {
            this.j = true;
            this.i = iArr6.length - 1;
        }
    }

    public final float h(jz3 jz3Var, boolean z) {
        int i = this.h;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.a) {
            if (this.e[i] == jz3Var.f) {
                int i4 = this.h;
                int[] iArr = this.f;
                if (i == i4) {
                    this.h = iArr[i];
                } else {
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    jz3Var.b(this.b);
                }
                jz3Var.B0--;
                this.a--;
                this.e[i] = -1;
                if (this.j) {
                    this.i = i;
                }
                return this.g[i];
            }
            i2++;
            i3 = i;
            i = this.f[i];
        }
        return 0.0f;
    }

    public final String toString() {
        int i = this.h;
        String string = "";
        for (int i2 = 0; i != -1 && i2 < this.a; i2++) {
            StringBuilder sb = new StringBuilder(string.concat(" -> ") + this.g[i] + " : ");
            sb.append(((jz3[]) this.c.A)[this.e[i]]);
            string = sb.toString();
            i = this.f[i];
        }
        return string;
    }
}
