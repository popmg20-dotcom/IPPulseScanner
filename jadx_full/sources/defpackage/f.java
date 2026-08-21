package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static final bu a;
    public static final bu b;
    public static final bu c;
    public static final bu d;
    public static final bu e;

    static {
        bu buVar = bu.A;
        a = t60.n("/");
        b = t60.n("\\");
        c = t60.n("/\\");
        d = t60.n(".");
        e = t60.n("..");
    }

    public static final u03 a(u03 u03Var, u03 u03Var2, boolean z) {
        u03Var2.getClass();
        if (c(u03Var2) != -1 || u03Var2.e() != null) {
            return u03Var2;
        }
        bu buVarB = b(u03Var);
        if (buVarB == null && (buVarB = b(u03Var2)) == null) {
            buVarB = f(u03.f);
        }
        hp hpVar = new hp();
        hpVar.I0(u03Var.b);
        if (hpVar.f > 0) {
            hpVar.I0(buVarB);
        }
        hpVar.I0(u03Var2.b);
        return d(hpVar, z);
    }

    public static final bu b(u03 u03Var) {
        bu buVar = u03Var.b;
        bu buVar2 = a;
        if (bu.g(buVar, buVar2) != -1) {
            return buVar2;
        }
        bu buVar3 = u03Var.b;
        bu buVar4 = b;
        if (bu.g(buVar3, buVar4) != -1) {
            return buVar4;
        }
        return null;
    }

    public static final int c(u03 u03Var) {
        bu buVar = u03Var.b;
        if (buVar.d() != 0) {
            if (buVar.i(0) != 47) {
                if (buVar.i(0) == 92) {
                    if (buVar.d() > 2 && buVar.i(1) == 92) {
                        bu buVar2 = b;
                        buVar2.getClass();
                        int iF = buVar.f(2, buVar2.h());
                        return iF == -1 ? buVar.d() : iF;
                    }
                } else if (buVar.d() > 2 && buVar.i(1) == 58 && buVar.i(2) == 92) {
                    char cI = (char) buVar.i(0);
                    if ('a' <= cI && cI < '{') {
                        return 3;
                    }
                    if ('A' <= cI && cI < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x011c A[EDGE_INSN: B:101:0x011c->B:84:0x011c BREAK  A[LOOP:1: B:53:0x00ab->B:116:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final u03 d(hp hpVar, boolean z) {
        bu buVar;
        long j;
        char C;
        boolean zX;
        bu buVar2;
        int size;
        int i;
        bu buVarZ;
        hp hpVar2 = new hp();
        bu buVarE = null;
        int i2 = 0;
        while (true) {
            if (!hpVar.Q(a)) {
                buVar = b;
                if (!hpVar.Q(buVar)) {
                    break;
                }
            }
            byte bU = hpVar.U();
            if (buVarE == null) {
                buVarE = e(bU);
            }
            i2++;
        }
        boolean z2 = i2 >= 2 && n12.c(buVarE, buVar);
        bu buVar3 = c;
        if (z2) {
            buVarE.getClass();
            hpVar2.I0(buVarE);
            hpVar2.I0(buVarE);
        } else {
            if (i2 <= 0) {
                long jN = hpVar.N(buVar3);
                if (buVarE == null) {
                    buVarE = jN == -1 ? f(u03.f) : e(hpVar.C(jN));
                }
                if (n12.c(buVarE, buVar) && hpVar.f >= 2) {
                    j = -1;
                    if (hpVar.C(1L) == 58 && (('a' <= (C = (char) hpVar.C(0L)) && C < '{') || ('A' <= C && C < '['))) {
                        if (jN == 2) {
                            hpVar2.a0(hpVar, 3L);
                        } else {
                            hpVar2.a0(hpVar, 2L);
                        }
                    }
                }
                boolean z3 = hpVar2.f <= 0;
                ArrayList arrayList = new ArrayList();
                while (true) {
                    zX = hpVar.x();
                    buVar2 = d;
                    if (!zX) {
                        break;
                    }
                    long jN2 = hpVar.N(buVar3);
                    if (jN2 == j) {
                        buVarZ = hpVar.Z(hpVar.f);
                    } else {
                        buVarZ = hpVar.Z(jN2);
                        hpVar.U();
                    }
                    bu buVar4 = e;
                    if (n12.c(buVarZ, buVar4)) {
                        if (!z3 || !arrayList.isEmpty()) {
                            if (!z || (!z3 && (arrayList.isEmpty() || n12.c(d70.k0(arrayList), buVar4)))) {
                                arrayList.add(buVarZ);
                            } else if (!z2 || arrayList.size() != 1) {
                                if (!arrayList.isEmpty()) {
                                    arrayList.remove(arrayList.size() - 1);
                                }
                            }
                        }
                    } else if (!n12.c(buVarZ, buVar2) && !n12.c(buVarZ, bu.A)) {
                        arrayList.add(buVarZ);
                    }
                }
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    if (i > 0) {
                        hpVar2.I0(buVarE);
                    }
                    hpVar2.I0((bu) arrayList.get(i));
                }
                if (hpVar2.f == 0) {
                    hpVar2.I0(buVar2);
                }
                return new u03(hpVar2.Z(hpVar2.f));
            }
            buVarE.getClass();
            hpVar2.I0(buVarE);
        }
        j = -1;
        if (hpVar2.f <= 0) {
        }
        ArrayList arrayList2 = new ArrayList();
        while (true) {
            zX = hpVar.x();
            buVar2 = d;
            if (!zX) {
            }
        }
        size = arrayList2.size();
        while (i < size) {
        }
        if (hpVar2.f == 0) {
        }
        return new u03(hpVar2.Z(hpVar2.f));
    }

    public static final bu e(byte b2) {
        if (b2 == 47) {
            return a;
        }
        if (b2 == 92) {
            return b;
        }
        xe.k(dw2.A(b2, "not a directory separator: "));
        return null;
    }

    public static final bu f(String str) {
        if (n12.c(str, "/")) {
            return a;
        }
        if (n12.c(str, "\\")) {
            return b;
        }
        xe.k(ha0.n("not a directory separator: ", str));
        return null;
    }
}
