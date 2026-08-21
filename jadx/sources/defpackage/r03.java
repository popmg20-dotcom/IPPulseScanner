package defpackage;

import j$.util.Optional;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class r03 implements r53 {
    public final /* synthetic */ int a;
    public final boolean b;
    public final /* synthetic */ s03 c;

    public /* synthetic */ r03(s03 s03Var, boolean z, int i) {
        this.a = i;
        this.c = s03Var;
        this.b = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.r53
    public final x51 a() {
        int i = this.a;
        int i2 = 9;
        s03 s03Var = this.c;
        boolean z = this.b;
        int i3 = 10;
        boolean z2 = false;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        int i4 = 1;
        char c = 1;
        char c2 = 1;
        char c3 = 1;
        char c4 = 1;
        switch (i) {
            case 0:
                vd1 vd1Var = s03Var.z;
                aq3 aq3Var = s03Var.b;
                if (aq3Var.c(20)) {
                    s03Var.Y = Optional.of(new r03(s03Var, z, objArr2 == true ? 1 : 0));
                    return s03.g((f80) aq3Var.next());
                }
                if (!aq3Var.c(11)) {
                    if (!z) {
                        if (!aq3Var.c(10)) {
                            re4 re4VarO = aq3Var.o();
                            throw new v90("while parsing a flow mapping", s03Var.b(), "expected ',' or '}', but got ".concat(qe4.u(re4VarO.a())), re4VarO.a, null);
                        }
                        aq3Var.next();
                        if (aq3Var.c(20)) {
                            s03Var.Y = Optional.of(new r03(s03Var, c == true ? 1 : 0, objArr == true ? 1 : 0));
                            return s03.g((f80) aq3Var.next());
                        }
                    }
                    if (aq3Var.c(15)) {
                        re4 next = aq3Var.next();
                        int i5 = 12;
                        if (aq3Var.d(21, 10, 11)) {
                            s03Var.Y = Optional.of(new o03(s03Var, i5));
                            return s03.f(next.b);
                        }
                        vd1Var.c(new o03(s03Var, i5));
                        return s03Var.d(false, false);
                    }
                    if (!aq3Var.c(11)) {
                        vd1Var.c(new o03(s03Var, i3));
                        return s03Var.d(false, false);
                    }
                }
                re4 next2 = aq3Var.next();
                bh2 bh2Var = new bh2(next2.a, next2.b, 0);
                s03Var.b();
                if (aq3Var.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i2));
                } else {
                    s03Var.Y = Optional.of((r53) vd1Var.b());
                }
                return bh2Var;
            default:
                vd1 vd1Var2 = s03Var.z;
                aq3 aq3Var2 = s03Var.b;
                if (aq3Var2.c(20)) {
                    s03Var.Y = Optional.of(new r03(s03Var, z, i4));
                    return s03.g((f80) aq3Var2.next());
                }
                if (!aq3Var2.c(13)) {
                    if (!z) {
                        if (!aq3Var2.c(10)) {
                            re4 re4VarO2 = aq3Var2.o();
                            throw new v90("while parsing a flow sequence", s03Var.b(), "expected ',' or ']', but got ".concat(qe4.u(re4VarO2.a())), re4VarO2.a, null);
                        }
                        aq3Var2.next();
                        if (aq3Var2.c(20)) {
                            s03Var.Y = Optional.of(new r03(s03Var, c4 == true ? 1 : 0, c3 == true ? 1 : 0));
                            return s03.g((f80) aq3Var2.next());
                        }
                    }
                    if (aq3Var2.c(15)) {
                        re4 re4VarO3 = aq3Var2.o();
                        eh2 eh2Var = new eh2(Optional.empty(), Optional.empty(), true, 1, re4VarO3.a, re4VarO3.b);
                        s03Var.Y = Optional.of(new o03(s03Var, 14));
                        return eh2Var;
                    }
                    if (!aq3Var2.c(13)) {
                        vd1Var2.c(new r03(s03Var, z2, c2 == true ? 1 : 0));
                        return s03Var.d(false, false);
                    }
                }
                re4 next3 = aq3Var2.next();
                bh2 bh2Var2 = new bh2(next3.a, next3.b, 1);
                if (aq3Var2.c(20)) {
                    s03Var.Y = Optional.of(new o03(s03Var, i2));
                } else {
                    s03Var.Y = Optional.of((r53) vd1Var2.b());
                }
                s03Var.b();
                return bh2Var2;
        }
    }
}
