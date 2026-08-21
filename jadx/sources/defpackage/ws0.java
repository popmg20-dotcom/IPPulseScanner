package defpackage;

import j$.util.DesugarCollections;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ws0 extends it0 {
    public final String A;
    public final ft0[] A0;
    public final kt0[] B0;
    public final int C0;
    public final int[] D0;
    public final int[] E0;
    public final it0 X;
    public final ws0[] Y;
    public final zs0[] Z;
    public final yo0 f;
    public final ft0[] y0;
    public volatile or0 z;
    public final ft0[] z0;

    public ws0(yo0 yo0Var, gt0 gt0Var, ws0 ws0Var) throws xs0 {
        if (ws0Var == null) {
            this.X = gt0Var;
        } else {
            this.X = ws0Var;
        }
        this.f = yo0Var;
        this.A = mt0.b(gt0Var, ws0Var, yo0Var.H());
        this.B0 = yo0Var.C0.size() > 0 ? new kt0[yo0Var.C0.size()] : mt0.g;
        int i = 0;
        for (int i2 = 0; i2 < yo0Var.C0.size(); i2++) {
            this.B0[i2] = new kt0((yr0) yo0Var.C0.get(i2), this, i2);
        }
        this.Y = yo0Var.z0.size() > 0 ? new ws0[yo0Var.z0.size()] : mt0.c;
        for (int i3 = 0; i3 < yo0Var.z0.size(); i3++) {
            this.Y[i3] = new ws0((yo0) yo0Var.z0.get(i3), gt0Var, this);
        }
        this.Z = yo0Var.A0.size() > 0 ? new zs0[yo0Var.A0.size()] : mt0.e;
        for (int i4 = 0; i4 < yo0Var.A0.size(); i4++) {
            this.Z[i4] = new zs0((fp0) yo0Var.A0.get(i4), gt0Var, this);
        }
        this.y0 = yo0Var.Z.size() > 0 ? new ft0[yo0Var.Z.size()] : mt0.d;
        for (int i5 = 0; i5 < yo0Var.Z.size(); i5++) {
            this.y0[i5] = new ft0((rq0) yo0Var.Z.get(i5), gt0Var, this, i5, false);
        }
        this.z0 = yo0Var.Z.size() > 0 ? (ft0[]) this.y0.clone() : mt0.d;
        this.A0 = yo0Var.y0.size() > 0 ? new ft0[yo0Var.y0.size()] : mt0.d;
        for (int i6 = 0; i6 < yo0Var.y0.size(); i6++) {
            this.A0[i6] = new ft0((rq0) yo0Var.y0.get(i6), gt0Var, this, i6, true);
        }
        for (int i7 = 0; i7 < yo0Var.C0.size(); i7++) {
            kt0 kt0Var = this.B0[i7];
            kt0Var.Z = new ft0[kt0Var.Y];
            kt0Var.Y = 0;
        }
        for (int i8 = 0; i8 < yo0Var.Z.size(); i8++) {
            ft0 ft0Var = this.y0[i8];
            kt0 kt0Var2 = ft0Var.C0;
            if (kt0Var2 != null) {
                ft0[] ft0VarArr = kt0Var2.Z;
                int i9 = kt0Var2.Y;
                kt0Var2.Y = i9 + 1;
                ft0VarArr[i9] = ft0Var;
            }
        }
        int i10 = 0;
        for (kt0 kt0Var3 : this.B0) {
            ft0[] ft0VarArr2 = kt0Var3.Z;
            if (ft0VarArr2.length == 1 && ft0VarArr2[0].y0) {
                i10++;
            } else if (i10 > 0) {
                throw new xs0(this, "Synthetic oneofs must come last.");
            }
        }
        this.C0 = this.B0.length - i10;
        gt0Var.z0.e(this);
        if (yo0Var.B0.size() <= 0) {
            int[] iArr = mt0.b;
            this.D0 = iArr;
            this.E0 = iArr;
            return;
        }
        this.D0 = new int[yo0Var.B0.size()];
        this.E0 = new int[yo0Var.B0.size()];
        for (uo0 uo0Var : yo0Var.B0) {
            this.D0[i] = uo0Var.Y;
            this.E0[i] = uo0Var.Z;
            i++;
        }
        Arrays.sort(this.D0);
        Arrays.sort(this.E0);
    }

    @Override // defpackage.it0
    public final gt0 c() {
        return this.X.c();
    }

    @Override // defpackage.it0
    public final String d() {
        return this.A;
    }

    @Override // defpackage.it0
    public final it0 e() {
        return this.X;
    }

    @Override // defpackage.it0
    public final String getName() {
        return this.f.H();
    }

    @Override // defpackage.it0
    public final c1 h() {
        return this.f;
    }

    public final void j() throws xs0 {
        for (ws0 ws0Var : this.Y) {
            ws0Var.j();
        }
        for (ft0 ft0Var : this.y0) {
            at0 at0Var = ft0.F0;
            ft0Var.j();
        }
        ft0[] ft0VarArr = this.z0;
        Arrays.sort(ft0VarArr);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= ft0VarArr.length) {
                for (ft0 ft0Var2 : this.A0) {
                    at0 at0Var2 = ft0.F0;
                    ft0Var2.j();
                }
                return;
            }
            ft0 ft0Var3 = ft0VarArr[i];
            ft0 ft0Var4 = ft0VarArr[i2];
            if (ft0Var3.z.Z == ft0Var4.z.Z) {
                throw new xs0(ft0Var4, "Field number " + ft0Var4.z.Z + " has already been used in \"" + ft0Var4.B0.A + "\" by field \"" + ft0Var3.z.L() + "\".");
            }
            i = i2;
        }
    }

    public final ft0 k(String str) {
        it0 it0VarN = this.X.c().z0.n(3, this.A + '.' + str);
        if (it0VarN instanceof ft0) {
            return (ft0) it0VarN;
        }
        return null;
    }

    public final ft0 l(int i) {
        ft0[] ft0VarArr = this.z0;
        return (ft0) mt0.a(ft0VarArr, ft0VarArr.length, ft0.F0, i);
    }

    public final List m() {
        return DesugarCollections.unmodifiableList(Arrays.asList(this.y0));
    }

    public final or0 n() {
        if (this.z == null) {
            or0 or0VarJ = this.f.J();
            if (or0VarJ.O()) {
                nr0 nr0VarR = or0VarJ.u();
                nr0VarR.Y &= -33;
                nr0VarR.C0 = null;
                ue1 ue1Var = nr0VarR.D0;
                if (ue1Var != null) {
                    ue1Var.b = null;
                    nr0VarR.D0 = null;
                }
                nr0VarR.S();
                or0VarJ = nr0VarR.q();
                if (!or0VarJ.c()) {
                    throw a1.C(or0VarJ);
                }
            }
            synchronized (this) {
                try {
                    if (this.z == null) {
                        this.z = or0VarJ;
                    }
                } finally {
                }
            }
        }
        return this.z;
    }

    public final void o() {
        g(this.f.J().K());
        for (ws0 ws0Var : this.Y) {
            ws0Var.o();
        }
        for (zs0 zs0Var : this.Z) {
            zs0Var.k();
        }
        for (kt0 kt0Var : this.B0) {
            kt0Var.g(kt0Var.z.J().K());
        }
        for (ft0 ft0Var : this.y0) {
            at0 at0Var = ft0.F0;
            ft0Var.g(ft0Var.z.N().L());
        }
        for (ft0 ft0Var2 : this.A0) {
            at0 at0Var2 = ft0.F0;
            ft0Var2.g(ft0Var2.z.N().L());
        }
    }

    public ws0(String str) {
        String strSubstring;
        String strSubstring2;
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring2 = str.substring(iLastIndexOf + 1);
            strSubstring = str.substring(0, iLastIndexOf);
        } else {
            strSubstring = "";
            strSubstring2 = str;
        }
        ro0 ro0VarN = yo0.I0.u();
        ro0VarN.Y = strSubstring2;
        ro0VarN.X |= 1;
        ro0VarN.S();
        to0 to0VarL = uo0.A0.u();
        to0VarL.Y = 1;
        to0VarL.X |= 1;
        to0VarL.S();
        to0VarL.Z = 536870912;
        to0VarL.X |= 2;
        to0VarL.S();
        uo0 uo0VarU = to0VarL.q();
        if (uo0VarU.c()) {
            ro0VarN.V();
            ro0VarN.B0.add(uo0VarU);
            ro0VarN.S();
            yo0 yo0VarU = ro0VarN.q();
            if (yo0VarU.c()) {
                this.f = yo0VarU;
                this.A = str;
                this.Y = mt0.c;
                this.Z = mt0.e;
                ft0[] ft0VarArr = mt0.d;
                this.y0 = ft0VarArr;
                this.z0 = ft0VarArr;
                this.A0 = ft0VarArr;
                this.B0 = mt0.g;
                this.C0 = 0;
                this.X = new gt0(strSubstring, this);
                this.D0 = new int[]{1};
                this.E0 = new int[]{536870912};
                return;
            }
            throw a1.C(yo0VarU);
        }
        throw a1.C(uo0VarU);
    }
}
