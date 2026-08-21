package defpackage;

import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f31 extends fx3 {
    public final /* synthetic */ g31 X;

    public f31(g31 g31Var) {
        this.X = g31Var;
    }

    @Override // defpackage.fx3
    public final void x(Throwable th) {
        this.X.a.d(th);
    }

    @Override // defpackage.fx3
    public final void y(iv1 iv1Var) {
        g31 g31Var = this.X;
        g31Var.c = iv1Var;
        iv1 iv1Var2 = g31Var.c;
        k31 k31Var = g31Var.a;
        g31Var.b = new ed4(iv1Var2, k31Var.g, k31Var.i, Build.VERSION.SDK_INT >= 34 ? o31.a() : gb4.K());
        k31 k31Var2 = g31Var.a;
        ArrayList arrayList = new ArrayList();
        k31Var2.a.writeLock().lock();
        try {
            k31Var2.c = 1;
            arrayList.addAll(k31Var2.b);
            k31Var2.b.clear();
            k31Var2.a.writeLock().unlock();
            k31Var2.d.post(new zv(arrayList, k31Var2.c, (Throwable) null));
        } catch (Throwable th) {
            k31Var2.a.writeLock().unlock();
            throw th;
        }
    }
}
