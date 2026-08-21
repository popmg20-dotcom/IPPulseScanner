package defpackage;

import java.util.Collection;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class sr1 implements am1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ Object X;
    public final /* synthetic */ int b = 1;
    public final /* synthetic */ String f;
    public final /* synthetic */ String z;

    public /* synthetic */ sr1(tr1 tr1Var, String str, String str2, u33 u33Var) {
        this.A = tr1Var;
        this.f = str;
        this.z = str2;
        this.X = u33Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        switch (this.b) {
            case 0:
                tr1 tr1Var = (tr1) this.A;
                String str = this.f;
                String str2 = this.z;
                u33 u33Var = (u33) this.X;
                rn2 rn2Var = (rn2) obj;
                tr1Var.getClass();
                u33 u33Var2 = tr1.d;
                if (((String) xb5.t(rn2Var, u33Var2, "")).equals(str)) {
                    u33 u33VarE = tr1Var.e(rn2Var, str);
                    if (u33VarE == null || u33VarE.a.equals(str2)) {
                        return null;
                    }
                    synchronized (tr1Var) {
                        tr1Var.f(rn2Var, str);
                        HashSet hashSet = new HashSet((Collection) xb5.t(rn2Var, u33Var, new HashSet()));
                        hashSet.add(str);
                        rn2Var.d(u33Var, hashSet);
                    }
                    return null;
                }
                u33 u33Var3 = tr1.c;
                long jLongValue = ((Long) xb5.t(rn2Var, u33Var3, 0L)).longValue();
                if (jLongValue + 1 == 30) {
                    jLongValue = tr1Var.a(rn2Var);
                }
                HashSet hashSet2 = new HashSet((Collection) xb5.t(rn2Var, u33Var, new HashSet()));
                hashSet2.add(str);
                rn2Var.d(u33Var, hashSet2);
                rn2Var.d(u33Var3, Long.valueOf(jLongValue + 1));
                rn2Var.d(u33Var2, str);
                return null;
            default:
                String str3 = this.f;
                String str4 = this.z;
                String str5 = (String) this.A;
                String str6 = (String) this.X;
                io3 io3Var = (io3) obj;
                io3Var.getClass();
                io3Var.K(1, str3);
                io3Var.K(2, str3);
                io3Var.K(3, str3);
                io3Var.K(4, str3);
                if (str4 == null) {
                    io3Var.l(5);
                } else {
                    io3Var.K(5, str4);
                }
                if (str4 == null) {
                    io3Var.l(6);
                } else {
                    io3Var.K(6, str4);
                }
                if (str5 == null) {
                    io3Var.l(7);
                } else {
                    io3Var.K(7, str5);
                }
                if (str5 == null) {
                    io3Var.l(8);
                } else {
                    io3Var.K(8, str5);
                }
                if (str6 == null) {
                    io3Var.l(9);
                } else {
                    io3Var.K(9, str6);
                }
                if (str6 == null) {
                    io3Var.l(10);
                } else {
                    io3Var.K(10, str6);
                }
                return xl4.a;
        }
    }

    public /* synthetic */ sr1(String str, String str2, String str3, String str4) {
        this.f = str;
        this.z = str2;
        this.A = str3;
        this.X = str4;
    }
}
