package defpackage;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nz0 extends c1 {
    public final kd1 A;
    public final ft0[] X;
    public final cm4 Y;
    public int Z = -1;
    public final ws0 z;

    public nz0(ws0 ws0Var, kd1 kd1Var, ft0[] ft0VarArr, cm4 cm4Var) {
        this.z = ws0Var;
        this.A = kd1Var;
        this.X = ft0VarArr;
        this.Y = cm4Var;
    }

    public static nz0 v(ws0 ws0Var) {
        return new nz0(ws0Var, kd1.d, new ft0[ws0Var.f.C0.size()], cm4.f);
    }

    @Override // defpackage.ql2, defpackage.ol2
    public final c1 a() {
        return v(this.z);
    }

    @Override // defpackage.ql2
    public final boolean b(ft0 ft0Var) {
        if (ft0Var.B0 == this.z) {
            return this.A.i(ft0Var);
        }
        xe.k("FieldDescriptor does not match message type.");
        return false;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        Iterator it = this.z.m().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            kd1 kd1Var = this.A;
            if (!zHasNext) {
                return kd1Var.j();
            }
            ft0 ft0Var = (ft0) it.next();
            if (ft0Var.z() && !kd1Var.i(ft0Var)) {
                return false;
            }
        }
    }

    @Override // defpackage.nl2
    public final void d(q60 q60Var) throws a60 {
        boolean z = this.z.n().Z;
        cm4 cm4Var = this.Y;
        kd1 kd1Var = this.A;
        if (!z) {
            jy3 jy3Var = kd1Var.a;
            int i = jy3Var.f;
            for (int i2 = 0; i2 < i; i2++) {
                ly3 ly3VarC = jy3Var.c(i2);
                kd1.r((ft0) ly3VarC.b, ly3VarC.f, q60Var);
            }
            for (Map.Entry entry : jy3Var.d()) {
                kd1.r((ft0) entry.getKey(), entry.getValue(), q60Var);
            }
            cm4Var.d(q60Var);
            return;
        }
        jy3 jy3Var2 = kd1Var.a;
        int i3 = jy3Var2.f;
        for (int i4 = 0; i4 < i3; i4++) {
            kd1.s(jy3Var2.c(i4), q60Var);
        }
        Iterator it = jy3Var2.d().iterator();
        while (it.hasNext()) {
            kd1.s((Map.Entry) it.next(), q60Var);
        }
        TreeMap treeMap = cm4Var.b;
        if (treeMap.isEmpty()) {
            return;
        }
        for (Map.Entry entry2 : treeMap.entrySet()) {
            am4 am4Var = (am4) entry2.getValue();
            int iIntValue = ((Integer) entry2.getKey()).intValue();
            for (int i5 = 0; i5 < am4Var.d.size(); i5++) {
                q60Var.v(iIntValue, (zt) am4Var.d.get(i5));
            }
        }
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: e */
    public final ml2 u() {
        mz0 mz0Var = new mz0(this.z);
        mz0Var.K(this);
        return mz0Var;
    }

    @Override // defpackage.ql2
    public final ws0 f() {
        return this.z;
    }

    @Override // defpackage.nl2
    public final int h() {
        int iH;
        int i = this.Z;
        if (i != -1) {
            return i;
        }
        boolean z = this.z.n().Z;
        cm4 cm4Var = this.Y;
        kd1 kd1Var = this.A;
        if (z) {
            jy3 jy3Var = kd1Var.a;
            int i2 = jy3Var.f;
            int i3 = 0;
            int iG = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                iG += kd1.g(jy3Var.c(i4));
            }
            Iterator it = jy3Var.d().iterator();
            while (it.hasNext()) {
                iG += kd1.g((Map.Entry) it.next());
            }
            TreeMap treeMap = cm4Var.b;
            if (!treeMap.isEmpty()) {
                int i5 = 0;
                for (Map.Entry entry : treeMap.entrySet()) {
                    am4 am4Var = (am4) entry.getValue();
                    int iIntValue = ((Integer) entry.getKey()).intValue();
                    int iC = 0;
                    for (int i6 = 0; i6 < am4Var.d.size(); i6++) {
                        iC += q60.c(3, (zt) am4Var.d.get(i6)) + q60.i(2, iIntValue) + (q60.h(1) * 2);
                    }
                    i5 += iC;
                }
                i3 = i5;
            }
            iH = iG + i3;
        } else {
            iH = cm4Var.h() + kd1Var.h();
        }
        this.Z = iH;
        return iH;
    }

    @Override // defpackage.ql2
    public final cm4 i() {
        return this.Y;
    }

    @Override // defpackage.nl2
    /* JADX INFO: renamed from: k */
    public final ml2 r() {
        return new mz0(this.z);
    }

    @Override // defpackage.ql2
    public final Map l() {
        return this.A.f();
    }

    @Override // defpackage.nl2
    public final m03 m() {
        return new lz0(this);
    }

    @Override // defpackage.ql2
    public final Object n(ft0 ft0Var) {
        if (ft0Var.B0 != this.z) {
            xe.k("FieldDescriptor does not match message type.");
            return null;
        }
        Object objB = this.A.a.get(ft0Var);
        if (objB instanceof d92) {
            objB = ((d92) objB).b();
        }
        return objB == null ? ft0Var.y() ? Collections.EMPTY_LIST : ft0Var.r().b == ct0.MESSAGE ? v(ft0Var.p()) : ft0Var.k() : objB;
    }

    @Override // defpackage.c1
    public final a1 r() {
        return new mz0(this.z);
    }

    @Override // defpackage.c1
    public final a1 u() {
        mz0 mz0Var = new mz0(this.z);
        mz0Var.K(this);
        return mz0Var;
    }

    @Override // defpackage.ol2
    public final nl2 a() {
        return v(this.z);
    }
}
