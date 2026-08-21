package defpackage;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final defpackage.u03 d(defpackage.hp r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f.d(hp, boolean):u03");
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
