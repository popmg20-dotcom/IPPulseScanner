package defpackage;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class bf1 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ cf1 f;

    public /* synthetic */ bf1(cf1 cf1Var, int i) {
        this.b = i;
        this.f = cf1Var;
    }

    /* JADX WARN: Finally extract failed */
    private final void a() {
        eh ehVarL;
        int i;
        cf1 cf1Var = this.f;
        cf1Var.getClass();
        synchronized (cf1.k) {
            try {
                ze1 ze1Var = cf1Var.a;
                ze1Var.a();
                eg0 eg0VarS = eg0.s(ze1Var.a);
                try {
                    ehVarL = cf1Var.c.L();
                    int i2 = ehVarL.b;
                    i = 1;
                    if (i2 == 2 || i2 == 1) {
                        String strF = cf1Var.f(ehVarL);
                        v62 v62Var = cf1Var.c;
                        dh dhVarA = ehVarL.a();
                        dhVarA.a = strF;
                        dhVarA.b = 3;
                        ehVarL = dhVarA.a();
                        v62Var.D(ehVarL);
                    }
                    if (eg0VarS != null) {
                        eg0VarS.R();
                    }
                } catch (Throwable th) {
                    if (eg0VarS != null) {
                        eg0VarS.R();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        cf1Var.i(ehVarL);
        cf1Var.g.execute(new bf1(cf1Var, i));
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        eh ehVarL;
        eh ehVarG;
        switch (this.b) {
            case 0:
                a();
                return;
            default:
                cf1 cf1Var = this.f;
                cf1Var.getClass();
                synchronized (cf1.k) {
                    try {
                        ze1 ze1Var = cf1Var.a;
                        ze1Var.a();
                        eg0 eg0VarS = eg0.s(ze1Var.a);
                        try {
                            ehVarL = cf1Var.c.L();
                            if (eg0VarS != null) {
                                eg0VarS.R();
                            }
                        } catch (Throwable th) {
                            if (eg0VarS != null) {
                                eg0VarS.R();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    int i = ehVarL.b;
                    if (i == 5) {
                        ehVarG = cf1Var.g(ehVarL);
                    } else {
                        if (i == 3) {
                            ehVarG = cf1Var.g(ehVarL);
                        } else {
                            if (!TextUtils.isEmpty(ehVarL.c) && ehVarL.f + ehVarL.e >= (System.currentTimeMillis() / 1000) + 3600) {
                                return;
                            }
                            ehVarG = cf1Var.b(ehVarL);
                        }
                    }
                    cf1Var.e(ehVarG);
                    cf1Var.k(ehVarL, ehVarG);
                    if (ehVarG.b == 4) {
                        cf1Var.j(ehVarG.a);
                    }
                    int i2 = ehVarG.b;
                    if (i2 == 5) {
                        new ef1();
                        cf1Var.h();
                        return;
                    } else if (i2 != 2 && i2 != 1) {
                        cf1Var.i(ehVarG);
                        return;
                    } else {
                        new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.");
                        cf1Var.h();
                        return;
                    }
                } catch (ef1 unused) {
                    cf1Var.h();
                    return;
                }
        }
    }
}
