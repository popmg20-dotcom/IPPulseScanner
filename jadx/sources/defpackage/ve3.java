package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ve3 {
    public final le3 a;
    public final ArrayList b;
    public final int c;
    public final ue1 d;
    public final cm2 e;
    public final int f;
    public final int g;
    public final int h;
    public int i;

    public ve3(le3 le3Var, ArrayList arrayList, int i, ue1 ue1Var, cm2 cm2Var, int i2, int i3, int i4) {
        cm2Var.getClass();
        this.a = le3Var;
        this.b = arrayList;
        this.c = i;
        this.d = ue1Var;
        this.e = cm2Var;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    public static ve3 a(ve3 ve3Var, int i, ue1 ue1Var, cm2 cm2Var, int i2) {
        if ((i2 & 1) != 0) {
            i = ve3Var.c;
        }
        int i3 = i;
        if ((i2 & 2) != 0) {
            ue1Var = ve3Var.d;
        }
        ue1 ue1Var2 = ue1Var;
        if ((i2 & 4) != 0) {
            cm2Var = ve3Var.e;
        }
        cm2 cm2Var2 = cm2Var;
        int i4 = ve3Var.f;
        int i5 = ve3Var.g;
        int i6 = ve3Var.h;
        cm2Var2.getClass();
        return new ve3(ve3Var.a, ve3Var.b, i3, ue1Var2, cm2Var2, i4, i5, i6);
    }

    public final kk3 b(cm2 cm2Var) {
        cm2Var.getClass();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = this.c;
        if (i >= size) {
            xe.q("Check failed.");
            return null;
        }
        this.i++;
        ue1 ue1Var = this.d;
        if (ue1Var != null) {
            ye3 ye3VarK = ((s61) ue1Var.z).k();
            ev1 ev1Var = (ev1) cm2Var.f;
            ye3VarK.getClass();
            ev1Var.getClass();
            ev1 ev1Var2 = ye3VarK.i.i;
            if (ev1Var.e != ev1Var2.e || !n12.c(ev1Var.d, ev1Var2.d)) {
                ad0.j("network interceptor ", arrayList.get(i - 1), " must retain the same host and port");
                return null;
            }
            if (this.i != 1) {
                ad0.j("network interceptor ", arrayList.get(i - 1), " must call proceed() exactly once");
                return null;
            }
        }
        int i2 = i + 1;
        ve3 ve3VarA = a(this, i2, null, cm2Var, 58);
        e12 e12Var = (e12) arrayList.get(i);
        kk3 kk3VarA = e12Var.a(ve3VarA);
        if (kk3VarA == null) {
            throw new NullPointerException("interceptor " + e12Var + " returned null");
        }
        if (ue1Var == null || i2 >= arrayList.size() || ve3VarA.i == 1) {
            return kk3VarA;
        }
        ad0.j("network interceptor ", e12Var, " must call proceed() exactly once");
        return null;
    }
}
