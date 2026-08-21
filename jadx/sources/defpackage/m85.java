package defpackage;

import j$.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class m85 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public m85(ff5 ff5Var, tg5 tg5Var) {
        this.a = 2;
        this.c = tg5Var;
        Objects.requireNonNull(ff5Var);
        this.b = ff5Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        Object obj = this.b;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                ff5 ff5Var = ((i95) obj).c;
                ff5Var.x();
                m25 m25Var = ff5Var.z;
                ff5.R(m25Var);
                return m25Var.Q1((String) obj2);
            case 1:
                ff5 ff5Var2 = ((i95) obj).c;
                ff5Var2.x();
                return new c25(ff5Var2.n0(((tg5) obj2).b));
            default:
                tg5 tg5Var = (tg5) obj2;
                String str = tg5Var.b;
                tj4.i(str);
                ff5 ff5Var3 = (ff5) obj;
                t95 t95VarA = ff5Var3.a(str);
                r95 r95Var = r95.ANALYTICS_STORAGE;
                if (t95VarA.i(r95Var) && t95.c(100, tg5Var.J0).i(r95Var)) {
                    return ff5Var3.a0(tg5Var).E();
                }
                ff5Var3.n().H0.a("Analytics storage consent denied. Returning null app instance id");
                return null;
        }
    }

    public /* synthetic */ m85(i95 i95Var, Object obj, int i) {
        this.a = i;
        this.c = obj;
        this.b = i95Var;
    }
}
