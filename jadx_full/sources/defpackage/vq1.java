package defpackage;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vq1 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public vq1(i95 i95Var, z25 z25Var, String str) {
        this.a = 2;
        this.b = i95Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                ((Runnable) obj).run();
                return null;
            case 1:
                return new ha5(((x75) obj).E0);
            default:
                ff5 ff5Var = ((i95) obj).c;
                ff5Var.x();
                z65 z65Var = ff5Var.y0;
                ff5.R(z65Var);
                z65Var.V0();
                throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public /* synthetic */ vq1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }
}
