package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dt4 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ lu2 f;
    public final /* synthetic */ String z;

    public /* synthetic */ dt4(lu2 lu2Var, String str, int i) {
        this.b = i;
        this.f = lu2Var;
        this.z = str;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) throws IOException {
        kk3 kk3VarB;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        String str = this.z;
        lu2 lu2Var = this.f;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        switch (i) {
            case 0:
                if (!zBooleanValue) {
                    dv1 dv1Var = new dv1();
                    dv1Var.c(null, str);
                    ck0 ck0Var = new ck0(lu2Var, dv1Var.a());
                    kk3VarB = ck0Var.b(new ig0(2, ck0Var, (Object) null));
                    try {
                        ck0.a(kk3VarB);
                        kk3VarB.close();
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                return xl4Var;
            default:
                if (zBooleanValue) {
                    dv1 dv1Var2 = new dv1();
                    dv1Var2.c(null, str);
                    ck0 ck0Var2 = new ck0(lu2Var, dv1Var2.a());
                    kk3VarB = ck0Var2.b(new ak0(ck0Var2, 0));
                    try {
                        ck0.a(kk3VarB);
                        if (kk3VarB.A == 207) {
                            throw new qu1(kk3VarB);
                        }
                        kk3VarB.close();
                    } finally {
                    }
                }
                return xl4Var;
        }
    }
}
