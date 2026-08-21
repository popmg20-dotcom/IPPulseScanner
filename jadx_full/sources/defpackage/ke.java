package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ke {
    public final ce d;
    public jz3 a = null;
    public float b = 0.0f;
    public final ArrayList c = new ArrayList();
    public boolean e = false;

    public ke(ed4 ed4Var) {
        this.d = new ce(this, ed4Var);
    }

    public final void a(gb2 gb2Var, int i) {
        jz3 jz3VarJ = gb2Var.j(i);
        ce ceVar = this.d;
        ceVar.g(jz3VarJ, 1.0f);
        ceVar.g(gb2Var.j(i), -1.0f);
    }

    public final void b(jz3 jz3Var, jz3 jz3Var2, jz3 jz3Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        ce ceVar = this.d;
        if (z) {
            ceVar.g(jz3Var, 1.0f);
            ceVar.g(jz3Var2, -1.0f);
            ceVar.g(jz3Var3, -1.0f);
        } else {
            ceVar.g(jz3Var, -1.0f);
            ceVar.g(jz3Var2, 1.0f);
            ceVar.g(jz3Var3, 1.0f);
        }
    }

    public final void c(jz3 jz3Var, jz3 jz3Var2, jz3 jz3Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        ce ceVar = this.d;
        if (z) {
            ceVar.g(jz3Var, 1.0f);
            ceVar.g(jz3Var2, -1.0f);
            ceVar.g(jz3Var3, 1.0f);
        } else {
            ceVar.g(jz3Var, -1.0f);
            ceVar.g(jz3Var2, 1.0f);
            ceVar.g(jz3Var3, -1.0f);
        }
    }

    public jz3 d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.a == null && this.b == 0.0f && this.d.d() == 0;
    }

    public final jz3 f(boolean[] zArr, jz3 jz3Var) {
        int i;
        ce ceVar = this.d;
        int iD = ceVar.d();
        jz3 jz3Var2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < iD; i2++) {
            float f2 = ceVar.f(i2);
            if (f2 < 0.0f) {
                jz3 jz3VarE = ceVar.e(i2);
                if ((zArr == null || !zArr[jz3VarE.f]) && jz3VarE != jz3Var && (((i = jz3VarE.C0) == 3 || i == 4) && f2 < f)) {
                    f = f2;
                    jz3Var2 = jz3VarE;
                }
            }
        }
        return jz3Var2;
    }

    public final void g(jz3 jz3Var) {
        jz3 jz3Var2 = this.a;
        ce ceVar = this.d;
        if (jz3Var2 != null) {
            ceVar.g(jz3Var2, -1.0f);
            this.a.z = -1;
            this.a = null;
        }
        float fH = ceVar.h(jz3Var, true) * (-1.0f);
        this.a = jz3Var;
        if (fH == 1.0f) {
            return;
        }
        this.b /= fH;
        int i = ceVar.h;
        for (int i2 = 0; i != -1 && i2 < ceVar.a; i2++) {
            float[] fArr = ceVar.g;
            fArr[i] = fArr[i] / fH;
            i = ceVar.f[i];
        }
    }

    public final void h(gb2 gb2Var, jz3 jz3Var, boolean z) {
        if (jz3Var.Y) {
            ce ceVar = this.d;
            float fC = ceVar.c(jz3Var);
            this.b = (jz3Var.X * fC) + this.b;
            ceVar.h(jz3Var, z);
            if (z) {
                jz3Var.b(this);
            }
            if (ceVar.d() == 0) {
                this.e = true;
                gb2Var.b = true;
            }
        }
    }

    public void i(gb2 gb2Var, ke keVar, boolean z) {
        ce ceVar = this.d;
        ceVar.getClass();
        float fC = ceVar.c(keVar.a);
        ceVar.h(keVar.a, z);
        ce ceVar2 = keVar.d;
        int iD = ceVar2.d();
        for (int i = 0; i < iD; i++) {
            jz3 jz3VarE = ceVar2.e(i);
            ceVar.a(jz3VarE, ceVar2.c(jz3VarE) * fC, z);
        }
        this.b = (keVar.b * fC) + this.b;
        if (z) {
            keVar.a.b(this);
        }
        if (this.a == null || ceVar.d() != 0) {
            return;
        }
        this.e = true;
        gb2Var.b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        boolean z;
        String strConcat = (this.a == null ? "0" : "" + this.a).concat(" = ");
        if (this.b != 0.0f) {
            strConcat = strConcat + this.b;
            z = true;
        } else {
            z = false;
        }
        ce ceVar = this.d;
        int iD = ceVar.d();
        for (int i = 0; i < iD; i++) {
            jz3 jz3VarE = ceVar.e(i);
            if (jz3VarE != null) {
                float f = ceVar.f(i);
                if (f != 0.0f) {
                    String string = jz3VarE.toString();
                    if (!z) {
                        if (f < 0.0f) {
                            strConcat = strConcat.concat("- ");
                            f *= -1.0f;
                        }
                        strConcat = f == 1.0f ? strConcat.concat(string) : strConcat + f + " " + string;
                        z = true;
                    } else if (f > 0.0f) {
                        strConcat = strConcat.concat(" + ");
                        if (f == 1.0f) {
                        }
                        z = true;
                    } else {
                        strConcat = strConcat.concat(" - ");
                        f *= -1.0f;
                        if (f == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
        }
        return !z ? strConcat.concat("0.0") : strConcat;
    }
}
