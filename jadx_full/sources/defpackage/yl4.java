package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yl4 implements ml2 {
    public TreeMap b;

    public static yl4 p() {
        yl4 yl4Var = new yl4();
        yl4Var.b = new TreeMap();
        return yl4Var;
    }

    @Override // defpackage.ml2
    public final ml2 F(byte[] bArr, int i, int i2, o91 o91Var) throws s12 {
        u(i, i2, bArr);
        return this;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: I */
    public final nl2 q() {
        return p();
    }

    @Override // defpackage.ml2
    public final ml2 M(m60 m60Var, o91 o91Var) {
        v(m60Var);
        return this;
    }

    @Override // defpackage.ol2
    public final boolean c() {
        return true;
    }

    public final Object clone() {
        cm4 cm4Var = cm4.f;
        yl4 yl4VarP = p();
        for (Map.Entry entry : this.b.entrySet()) {
            yl4VarP.b.put((Integer) entry.getKey(), ((zl4) entry.getValue()).clone());
        }
        return yl4VarP;
    }

    @Override // defpackage.ml2
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final cm4 p() {
        TreeMap treeMap = this.b;
        if (treeMap.isEmpty()) {
            return cm4.f;
        }
        TreeMap treeMap2 = new TreeMap();
        for (Map.Entry entry : treeMap.entrySet()) {
            treeMap2.put((Integer) entry.getKey(), ((zl4) entry.getValue()).a());
        }
        return new cm4(treeMap2);
    }

    public final zl4 q(int i) {
        TreeMap treeMap = this.b;
        if (i == 0) {
            return null;
        }
        zl4 zl4Var = (zl4) treeMap.get(Integer.valueOf(i));
        if (zl4Var != null) {
            return zl4Var;
        }
        int i2 = am4.f;
        zl4 zl4Var2 = new zl4();
        treeMap.put(Integer.valueOf(i), zl4Var2);
        return zl4Var2;
    }

    public final void r(int i, am4 am4Var) {
        TreeMap treeMap = this.b;
        if (i <= 0) {
            a71.d(i, " is not a valid field number.");
            return;
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            q(i).c(am4Var);
            return;
        }
        if (i <= 0) {
            a71.d(i, " is not a valid field number.");
            return;
        }
        Integer numValueOf = Integer.valueOf(i);
        int i2 = am4.f;
        zl4 zl4Var = new zl4();
        zl4Var.c(am4Var);
        treeMap.put(numValueOf, zl4Var);
    }

    @Override // defpackage.ml2
    public final /* bridge */ /* synthetic */ ml2 s(int i, int i2, byte[] bArr) throws s12 {
        u(i, i2, bArr);
        return this;
    }

    public final boolean t(int i, m60 m60Var) throws s12 {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zl4 zl4VarQ = q(i2);
            long jP = m60Var.p();
            am4 am4Var = zl4VarQ.a;
            if (am4Var.a == null) {
                am4Var.a = new ze2();
            }
            zl4VarQ.a.a.d(jP);
            return true;
        }
        if (i3 == 1) {
            zl4 zl4VarQ2 = q(i2);
            long jN = m60Var.n();
            am4 am4Var2 = zl4VarQ2.a;
            if (am4Var2.c == null) {
                am4Var2.c = new ze2();
            }
            zl4VarQ2.a.c.d(jN);
            return true;
        }
        if (i3 == 2) {
            zl4 zl4VarQ3 = q(i2);
            zt ztVarH = m60Var.h();
            am4 am4Var3 = zl4VarQ3.a;
            if (am4Var3.d == null) {
                am4Var3.d = new ArrayList();
            }
            zl4VarQ3.a.d.add(ztVarH);
            return true;
        }
        if (i3 == 3) {
            cm4 cm4Var = cm4.f;
            yl4 yl4VarP = p();
            m60Var.i(i2, yl4VarP, l91.h);
            zl4 zl4VarQ4 = q(i2);
            cm4 cm4VarP = yl4VarP.p();
            am4 am4Var4 = zl4VarQ4.a;
            if (am4Var4.e == null) {
                am4Var4.e = new ArrayList();
            }
            zl4VarQ4.a.e.add(cm4VarP);
            return true;
        }
        if (i3 == 4) {
            if (m60Var.b == 0) {
                m60Var.a(0);
            }
            return false;
        }
        if (i3 != 5) {
            throw new q12("Protocol message tag had invalid wire type.");
        }
        zl4 zl4VarQ5 = q(i2);
        int iM = m60Var.m();
        am4 am4Var5 = zl4VarQ5.a;
        if (am4Var5.b == null) {
            am4Var5.b = new x02();
        }
        zl4VarQ5.a.b.d(iM);
        return true;
    }

    public final void u(int i, int i2, byte[] bArr) throws s12 {
        try {
            m60 m60VarD = m60.d(bArr, i, i2, false);
            v(m60VarD);
            m60VarD.a(0);
        } catch (s12 e) {
            throw e;
        } catch (IOException e2) {
            zo2.o("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public final void v(m60 m60Var) {
        int iS;
        do {
            iS = m60Var.s();
            if (iS == 0) {
                return;
            }
        } while (t(iS, m60Var));
    }

    public final void w(cm4 cm4Var) {
        if (cm4Var != cm4.f) {
            for (Map.Entry entry : cm4Var.b.entrySet()) {
                r(((Integer) entry.getKey()).intValue(), (am4) entry.getValue());
            }
        }
    }

    public final void x(int i, int i2) {
        if (i <= 0) {
            a71.d(i, " is not a valid field number.");
            return;
        }
        zl4 zl4VarQ = q(i);
        long j = i2;
        am4 am4Var = zl4VarQ.a;
        if (am4Var.a == null) {
            am4Var.a = new ze2();
        }
        zl4VarQ.a.a.d(j);
    }
}
