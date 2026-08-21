package defpackage;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class b95 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ tg5 b;
    public final /* synthetic */ Bundle c;
    public final /* synthetic */ i95 d;

    public /* synthetic */ b95(i95 i95Var, tg5 tg5Var, Bundle bundle, int i) {
        this.a = i;
        this.b = tg5Var;
        this.c = bundle;
        this.d = i95Var;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        int i = this.a;
        Bundle bundle = this.c;
        tg5 tg5Var = this.b;
        i95 i95Var = this.d;
        switch (i) {
            case 0:
                ff5 ff5Var = i95Var.c;
                ff5Var.x();
                return ff5Var.b0(bundle, tg5Var);
            default:
                ff5 ff5Var2 = i95Var.c;
                ff5Var2.x();
                return ff5Var2.b0(bundle, tg5Var);
        }
    }
}
