package defpackage;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gb2 {
    public static boolean q = false;
    public final w43 d;
    public final ed4 m;
    public ke p;
    public int a = 1000;
    public boolean b = false;
    public int c = 0;
    public int e = 32;
    public int f = 32;
    public boolean h = false;
    public boolean[] i = new boolean[32];
    public int j = 1;
    public int k = 0;
    public int l = 32;
    public jz3[] n = new jz3[1000];
    public int o = 0;
    public ke[] g = new ke[32];

    public gb2() {
        s();
        ed4 ed4Var = new ed4((char) 0, 7);
        ed4Var.f = new c23();
        ed4Var.z = new c23();
        ed4Var.A = new jz3[32];
        this.m = ed4Var;
        w43 w43Var = new w43(ed4Var);
        w43Var.f = new jz3[128];
        w43Var.g = new jz3[128];
        w43Var.h = 0;
        w43Var.i = new v62(15, w43Var);
        this.d = w43Var;
        this.p = new ke(ed4Var);
    }

    public static int n(Object obj) {
        jz3 jz3Var = ((lb0) obj).i;
        if (jz3Var != null) {
            return (int) (jz3Var.X + 0.5f);
        }
        return 0;
    }

    public final jz3 a(int i) {
        c23 c23Var = (c23) this.m.z;
        int i2 = c23Var.b;
        Object obj = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = c23Var.a;
            Object obj2 = objArr[i3];
            objArr[i3] = null;
            c23Var.b = i3;
            obj = obj2;
        }
        jz3 jz3Var = (jz3) obj;
        if (jz3Var == null) {
            jz3Var = new jz3(i);
            jz3Var.C0 = i;
        } else {
            jz3Var.c();
            jz3Var.C0 = i;
        }
        int i4 = this.o;
        int i5 = this.a;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.a = i6;
            this.n = (jz3[]) Arrays.copyOf(this.n, i6);
        }
        jz3[] jz3VarArr = this.n;
        int i7 = this.o;
        this.o = i7 + 1;
        jz3VarArr[i7] = jz3Var;
        return jz3Var;
    }

    public final void b(jz3 jz3Var, jz3 jz3Var2, int i, float f, jz3 jz3Var3, jz3 jz3Var4, int i2, int i3) {
        ke keVarL = l();
        if (jz3Var2 == jz3Var3) {
            keVarL.d.g(jz3Var, 1.0f);
            keVarL.d.g(jz3Var4, 1.0f);
            keVarL.d.g(jz3Var2, -2.0f);
        } else {
            ce ceVar = keVarL.d;
            if (f == 0.5f) {
                ceVar.g(jz3Var, 1.0f);
                keVarL.d.g(jz3Var2, -1.0f);
                keVarL.d.g(jz3Var3, -1.0f);
                keVarL.d.g(jz3Var4, 1.0f);
                if (i > 0 || i2 > 0) {
                    keVarL.b = (-i) + i2;
                }
            } else if (f <= 0.0f) {
                ceVar.g(jz3Var, -1.0f);
                keVarL.d.g(jz3Var2, 1.0f);
                keVarL.b = i;
            } else if (f >= 1.0f) {
                ceVar.g(jz3Var4, -1.0f);
                keVarL.d.g(jz3Var3, 1.0f);
                keVarL.b = -i2;
            } else {
                float f2 = 1.0f - f;
                ceVar.g(jz3Var, f2 * 1.0f);
                keVarL.d.g(jz3Var2, f2 * (-1.0f));
                keVarL.d.g(jz3Var3, (-1.0f) * f);
                keVarL.d.g(jz3Var4, 1.0f * f);
                if (i > 0 || i2 > 0) {
                    keVarL.b = (i2 * f) + ((-i) * f2);
                }
            }
        }
        if (i3 != 8) {
            keVarL.a(this, i3);
        }
        c(keVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(ke keVar) {
        boolean z;
        boolean z2;
        jz3 jz3Var;
        jz3 jz3VarF;
        if (this.k + 1 >= this.l || this.j + 1 >= this.f) {
            o();
        }
        if (keVar.e) {
            z = false;
        } else {
            ArrayList arrayList = keVar.c;
            if (this.g.length != 0) {
                boolean z3 = false;
                while (!z3) {
                    int iD = keVar.d.d();
                    for (int i = 0; i < iD; i++) {
                        jz3 jz3VarE = keVar.d.e(i);
                        if (jz3VarE.z != -1 || jz3VarE.Y) {
                            arrayList.add(jz3VarE);
                        }
                    }
                    int size = arrayList.size();
                    if (size > 0) {
                        for (int i2 = 0; i2 < size; i2++) {
                            jz3 jz3Var2 = (jz3) arrayList.get(i2);
                            if (jz3Var2.Y) {
                                keVar.h(this, jz3Var2, true);
                            } else {
                                keVar.i(this, this.g[jz3Var2.z], true);
                            }
                        }
                        arrayList.clear();
                    } else {
                        z3 = true;
                    }
                }
                if (keVar.a != null && keVar.d.d() == 0) {
                    keVar.e = true;
                    this.b = true;
                }
            }
            if (keVar.e()) {
                return;
            }
            float f = keVar.b;
            float f2 = 0.0f;
            if (f < 0.0f) {
                keVar.b = f * (-1.0f);
                ce ceVar = keVar.d;
                int i3 = ceVar.h;
                for (int i4 = 0; i3 != -1 && i4 < ceVar.a; i4++) {
                    float[] fArr = ceVar.g;
                    fArr[i3] = fArr[i3] * (-1.0f);
                    i3 = ceVar.f[i3];
                }
            }
            int iD2 = keVar.d.d();
            float f3 = 0.0f;
            float f4 = 0.0f;
            jz3 jz3Var3 = null;
            jz3 jz3Var4 = null;
            int i5 = 0;
            boolean z4 = false;
            boolean z5 = false;
            while (i5 < iD2) {
                float f5 = keVar.d.f(i5);
                jz3 jz3VarE2 = keVar.d.e(i5);
                float f6 = f2;
                if (jz3VarE2.C0 == 1) {
                    if (jz3Var3 == null) {
                        z4 = jz3VarE2.B0 <= 1;
                    } else if (f3 > f5) {
                        if (jz3VarE2.B0 <= 1) {
                        }
                    } else if (z4 || jz3VarE2.B0 > 1) {
                    }
                    jz3Var3 = jz3VarE2;
                    f3 = f5;
                } else if (jz3Var3 == null && f5 < f6) {
                    if (jz3Var4 == null) {
                        z5 = jz3VarE2.B0 <= 1;
                    } else if (f4 > f5) {
                        if (jz3VarE2.B0 <= 1) {
                        }
                    } else if (z5 || jz3VarE2.B0 > 1) {
                    }
                    jz3Var4 = jz3VarE2;
                    f4 = f5;
                }
                i5++;
                f2 = f6;
            }
            float f7 = f2;
            if (jz3Var3 == null) {
                jz3Var3 = jz3Var4;
            }
            if (jz3Var3 == null) {
                z2 = true;
            } else {
                keVar.g(jz3Var3);
                z2 = false;
            }
            if (keVar.d.d() == 0) {
                keVar.e = true;
            }
            if (z2) {
                if (this.j + 1 >= this.f) {
                    o();
                }
                jz3 jz3VarA = a(3);
                int i6 = this.c + 1;
                this.c = i6;
                this.j++;
                jz3VarA.f = i6;
                ed4 ed4Var = this.m;
                ((jz3[]) ed4Var.A)[i6] = jz3VarA;
                keVar.a = jz3VarA;
                int i7 = this.k;
                h(keVar);
                if (this.k == i7 + 1) {
                    ke keVar2 = this.p;
                    keVar2.a = null;
                    keVar2.d.b();
                    for (int i8 = 0; i8 < keVar.d.d(); i8++) {
                        keVar2.d.a(keVar.d.e(i8), keVar.d.f(i8), true);
                    }
                    r(this.p);
                    if (jz3VarA.z == -1) {
                        if (keVar.a == jz3VarA && (jz3VarF = keVar.f(null, jz3VarA)) != null) {
                            keVar.g(jz3VarF);
                        }
                        if (!keVar.e) {
                            keVar.a.e(this, keVar);
                        }
                        ((c23) ed4Var.f).b(keVar);
                        this.k--;
                    }
                    z = true;
                }
                jz3Var = keVar.a;
                if (jz3Var != null) {
                }
            } else {
                z = false;
                jz3Var = keVar.a;
                if (jz3Var != null) {
                    return;
                }
                if (jz3Var.C0 != 1 && keVar.b < f7) {
                    return;
                }
            }
        }
        if (z) {
            return;
        }
        h(keVar);
    }

    public final void d(jz3 jz3Var, int i) {
        int i2 = jz3Var.z;
        if (i2 == -1) {
            jz3Var.d(this, i);
            for (int i3 = 0; i3 < this.c + 1; i3++) {
                jz3 jz3Var2 = ((jz3[]) this.m.A)[i3];
            }
            return;
        }
        if (i2 == -1) {
            ke keVarL = l();
            keVarL.a = jz3Var;
            float f = i;
            jz3Var.X = f;
            keVarL.b = f;
            keVarL.e = true;
            c(keVarL);
            return;
        }
        ke keVar = this.g[i2];
        if (keVar.e) {
            keVar.b = i;
            return;
        }
        if (keVar.d.d() == 0) {
            keVar.e = true;
            keVar.b = i;
            return;
        }
        ke keVarL2 = l();
        if (i < 0) {
            keVarL2.b = i * (-1);
            keVarL2.d.g(jz3Var, 1.0f);
        } else {
            keVarL2.b = i;
            keVarL2.d.g(jz3Var, -1.0f);
        }
        c(keVarL2);
    }

    public final void e(jz3 jz3Var, jz3 jz3Var2, int i, int i2) {
        if (i2 == 8 && jz3Var2.Y && jz3Var.z == -1) {
            jz3Var.d(this, jz3Var2.X + i);
            return;
        }
        ke keVarL = l();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            keVarL.b = i;
        }
        ce ceVar = keVarL.d;
        if (z) {
            ceVar.g(jz3Var, 1.0f);
            keVarL.d.g(jz3Var2, -1.0f);
        } else {
            ceVar.g(jz3Var, -1.0f);
            keVarL.d.g(jz3Var2, 1.0f);
        }
        if (i2 != 8) {
            keVarL.a(this, i2);
        }
        c(keVarL);
    }

    public final void f(jz3 jz3Var, jz3 jz3Var2, int i, int i2) {
        ke keVarL = l();
        jz3 jz3VarM = m();
        jz3VarM.A = 0;
        keVarL.b(jz3Var, jz3Var2, jz3VarM, i);
        if (i2 != 8) {
            keVarL.d.g(j(i2), (int) (keVarL.d.c(jz3VarM) * (-1.0f)));
        }
        c(keVarL);
    }

    public final void g(jz3 jz3Var, jz3 jz3Var2, int i, int i2) {
        ke keVarL = l();
        jz3 jz3VarM = m();
        jz3VarM.A = 0;
        keVarL.c(jz3Var, jz3Var2, jz3VarM, i);
        if (i2 != 8) {
            keVarL.d.g(j(i2), (int) (keVarL.d.c(jz3VarM) * (-1.0f)));
        }
        c(keVarL);
    }

    public final void h(ke keVar) {
        int i;
        if (keVar.e) {
            keVar.a.d(this, keVar.b);
        } else {
            ke[] keVarArr = this.g;
            int i2 = this.k;
            keVarArr[i2] = keVar;
            jz3 jz3Var = keVar.a;
            jz3Var.z = i2;
            this.k = i2 + 1;
            jz3Var.e(this, keVar);
        }
        if (this.b) {
            int i3 = 0;
            while (i3 < this.k) {
                if (this.g[i3] == null) {
                    System.out.println("WTF");
                }
                ke keVar2 = this.g[i3];
                if (keVar2 != null && keVar2.e) {
                    keVar2.a.d(this, keVar2.b);
                    ((c23) this.m.f).b(keVar2);
                    this.g[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.k;
                        if (i4 >= i) {
                            break;
                        }
                        ke[] keVarArr2 = this.g;
                        int i6 = i4 - 1;
                        ke keVar3 = keVarArr2[i4];
                        keVarArr2[i6] = keVar3;
                        jz3 jz3Var2 = keVar3.a;
                        if (jz3Var2.z == i4) {
                            jz3Var2.z = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.g[i5] = null;
                    }
                    this.k = i - 1;
                    i3--;
                }
                i3++;
            }
            this.b = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.k; i++) {
            ke keVar = this.g[i];
            keVar.a.X = keVar.b;
        }
    }

    public final jz3 j(int i) {
        if (this.j + 1 >= this.f) {
            o();
        }
        jz3 jz3VarA = a(4);
        float[] fArr = jz3VarA.y0;
        int i2 = this.c + 1;
        this.c = i2;
        this.j++;
        jz3VarA.f = i2;
        jz3VarA.A = i;
        ((jz3[]) this.m.A)[i2] = jz3VarA;
        w43 w43Var = this.d;
        w43Var.i.f = jz3VarA;
        Arrays.fill(fArr, 0.0f);
        fArr[jz3VarA.A] = 1.0f;
        w43Var.j(jz3VarA);
        return jz3VarA;
    }

    public final jz3 k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.j + 1 >= this.f) {
            o();
        }
        if (!(obj instanceof lb0)) {
            return null;
        }
        lb0 lb0Var = (lb0) obj;
        jz3 jz3Var = lb0Var.i;
        if (jz3Var == null) {
            lb0Var.h();
            jz3Var = lb0Var.i;
        }
        int i = jz3Var.f;
        ed4 ed4Var = this.m;
        if (i != -1 && i <= this.c && ((jz3[]) ed4Var.A)[i] != null) {
            return jz3Var;
        }
        if (i != -1) {
            jz3Var.c();
        }
        int i2 = this.c + 1;
        this.c = i2;
        this.j++;
        jz3Var.f = i2;
        jz3Var.C0 = 1;
        ((jz3[]) ed4Var.A)[i2] = jz3Var;
        return jz3Var;
    }

    public final ke l() {
        Object obj;
        ed4 ed4Var = this.m;
        c23 c23Var = (c23) ed4Var.f;
        int i = c23Var.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = c23Var.a;
            obj = objArr[i2];
            objArr[i2] = null;
            c23Var.b = i2;
        } else {
            obj = null;
        }
        ke keVar = (ke) obj;
        if (keVar == null) {
            return new ke(ed4Var);
        }
        keVar.a = null;
        keVar.d.b();
        keVar.b = 0.0f;
        keVar.e = false;
        return keVar;
    }

    public final jz3 m() {
        if (this.j + 1 >= this.f) {
            o();
        }
        jz3 jz3VarA = a(3);
        int i = this.c + 1;
        this.c = i;
        this.j++;
        jz3VarA.f = i;
        ((jz3[]) this.m.A)[i] = jz3VarA;
        return jz3VarA;
    }

    public final void o() {
        int i = this.e * 2;
        this.e = i;
        this.g = (ke[]) Arrays.copyOf(this.g, i);
        ed4 ed4Var = this.m;
        ed4Var.A = (jz3[]) Arrays.copyOf((jz3[]) ed4Var.A, this.e);
        int i2 = this.e;
        this.i = new boolean[i2];
        this.f = i2;
        this.l = i2;
    }

    public final void p() {
        w43 w43Var = this.d;
        if (w43Var.e()) {
            i();
            return;
        }
        if (!this.h) {
            q(w43Var);
            return;
        }
        for (int i = 0; i < this.k; i++) {
            if (!this.g[i].e) {
                q(w43Var);
                return;
            }
        }
        i();
    }

    public final void q(w43 w43Var) {
        int i = 0;
        while (true) {
            if (i >= this.k) {
                break;
            }
            ke keVar = this.g[i];
            int i2 = 1;
            if (keVar.a.C0 != 1) {
                float f = 0.0f;
                if (keVar.b < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = -1;
                        int i5 = -1;
                        int i6 = 0;
                        int i7 = 0;
                        while (i6 < this.k) {
                            ke keVar2 = this.g[i6];
                            if (keVar2.a.C0 != i2 && !keVar2.e && keVar2.b < f) {
                                int iD = keVar2.d.d();
                                int i8 = 0;
                                while (i8 < iD) {
                                    jz3 jz3VarE = keVar2.d.e(i8);
                                    float fC = keVar2.d.c(jz3VarE);
                                    if (fC > f) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f3 = jz3VarE.Z[i9] / fC;
                                            if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i5 = jz3VarE.f;
                                                i4 = i6;
                                                f2 = f3;
                                            }
                                        }
                                    }
                                    i8++;
                                    f = 0.0f;
                                }
                            }
                            i6++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i4 != -1) {
                            ke keVar3 = this.g[i4];
                            keVar3.a.z = -1;
                            keVar3.g(((jz3[]) this.m.A)[i5]);
                            jz3 jz3Var = keVar3.a;
                            jz3Var.z = i4;
                            jz3Var.e(this, keVar3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.j / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                }
            }
            i++;
        }
        r(w43Var);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0091 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(ke keVar) {
        boolean z;
        int i = 0;
        for (int i2 = 0; i2 < this.j; i2++) {
            this.i[i2] = false;
        }
        boolean z2 = false;
        int i3 = 0;
        while (!z2) {
            i3++;
            if (i3 >= this.j * 2) {
                return;
            }
            jz3 jz3Var = keVar.a;
            if (jz3Var != null) {
                this.i[jz3Var.f] = true;
            }
            jz3 jz3VarD = keVar.d(this.i);
            if (jz3VarD != null) {
                boolean[] zArr = this.i;
                int i4 = jz3VarD.f;
                if (zArr[i4]) {
                    return;
                } else {
                    zArr[i4] = true;
                }
            }
            if (jz3VarD != null) {
                float f = Float.MAX_VALUE;
                int i5 = i;
                int i6 = -1;
                while (i5 < this.k) {
                    ke keVar2 = this.g[i5];
                    if (keVar2.a.C0 != 1 && !keVar2.e) {
                        ce ceVar = keVar2.d;
                        int i7 = ceVar.h;
                        if (i7 == -1) {
                            z = false;
                            if (!z) {
                                float fC = keVar2.d.c(jz3VarD);
                                if (fC < 0.0f) {
                                    float f2 = (-keVar2.b) / fC;
                                    if (f2 < f) {
                                        i6 = i5;
                                        f = f2;
                                    }
                                }
                            }
                        } else {
                            for (int i8 = i; i7 != -1 && i8 < ceVar.a; i8++) {
                                if (ceVar.e[i7] == jz3VarD.f) {
                                    z = true;
                                    break;
                                }
                                i7 = ceVar.f[i7];
                            }
                            z = false;
                            if (!z) {
                            }
                        }
                    }
                    i5++;
                    i = 0;
                }
                if (i6 > -1) {
                    ke keVar3 = this.g[i6];
                    keVar3.a.z = -1;
                    keVar3.g(jz3VarD);
                    jz3 jz3Var2 = keVar3.a;
                    jz3Var2.z = i6;
                    jz3Var2.e(this, keVar3);
                }
            } else {
                z2 = true;
            }
            i = 0;
        }
    }

    public final void s() {
        for (int i = 0; i < this.k; i++) {
            ke keVar = this.g[i];
            if (keVar != null) {
                ((c23) this.m.f).b(keVar);
            }
            this.g[i] = null;
        }
    }

    public final void t() {
        ed4 ed4Var;
        int i = 0;
        while (true) {
            ed4Var = this.m;
            jz3[] jz3VarArr = (jz3[]) ed4Var.A;
            if (i >= jz3VarArr.length) {
                break;
            }
            jz3 jz3Var = jz3VarArr[i];
            if (jz3Var != null) {
                jz3Var.c();
            }
            i++;
        }
        c23 c23Var = (c23) ed4Var.z;
        jz3[] jz3VarArr2 = this.n;
        int length = this.o;
        c23Var.getClass();
        if (length > jz3VarArr2.length) {
            length = jz3VarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            jz3 jz3Var2 = jz3VarArr2[i2];
            int i3 = c23Var.b;
            Object[] objArr = c23Var.a;
            if (i3 < objArr.length) {
                objArr[i3] = jz3Var2;
                c23Var.b = i3 + 1;
            }
        }
        this.o = 0;
        Arrays.fill((jz3[]) ed4Var.A, (Object) null);
        this.c = 0;
        w43 w43Var = this.d;
        w43Var.h = 0;
        w43Var.b = 0.0f;
        this.j = 1;
        for (int i4 = 0; i4 < this.k; i4++) {
            ke keVar = this.g[i4];
        }
        s();
        this.k = 0;
        this.p = new ke(ed4Var);
    }
}
