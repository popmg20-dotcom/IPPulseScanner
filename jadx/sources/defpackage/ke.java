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
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            jz3 r0 = r10.a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            jz3 r1 = r10.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = r0.concat(r1)
            float r1 = r10.b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L36
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            float r0 = r10.b
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r4
            goto L37
        L36:
            r1 = r3
        L37:
            ce r10 = r10.d
            int r5 = r10.d()
        L3d:
            if (r3 >= r5) goto L96
            jz3 r6 = r10.e(r3)
            if (r6 != 0) goto L46
            goto L93
        L46:
            float r7 = r10.f(r3)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L4f
            goto L93
        L4f:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L63
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L73
            java.lang.String r1 = "- "
            java.lang.String r0 = r0.concat(r1)
        L61:
            float r7 = r7 * r9
            goto L73
        L63:
            if (r8 <= 0) goto L6c
            java.lang.String r1 = " + "
            java.lang.String r0 = r0.concat(r1)
            goto L73
        L6c:
            java.lang.String r1 = " - "
            java.lang.String r0 = r0.concat(r1)
            goto L61
        L73:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L7e
            java.lang.String r0 = r0.concat(r6)
            goto L92
        L7e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L92:
            r1 = r4
        L93:
            int r3 = r3 + 1
            goto L3d
        L96:
            if (r1 != 0) goto L9f
            java.lang.String r10 = "0.0"
            java.lang.String r10 = r0.concat(r10)
            return r10
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ke.toString():java.lang.String");
    }
}
