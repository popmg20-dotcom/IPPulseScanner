package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ru4 extends qu4 {
    public t02 r;

    public ru4(bv4 bv4Var, WindowInsets windowInsets) {
        super(bv4Var, windowInsets);
        this.r = null;
    }

    @Override // defpackage.yu4
    public bv4 b() {
        return bv4.g(this.c.consumeStableInsets(), null);
    }

    @Override // defpackage.yu4
    public bv4 c() {
        return bv4.g(this.c.consumeSystemWindowInsets(), null);
    }

    @Override // defpackage.yu4
    public final t02 k() {
        t02 t02Var = this.r;
        if (t02Var != null) {
            return t02Var;
        }
        WindowInsets windowInsets = this.c;
        t02 t02VarC = t02.c(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        this.r = t02VarC;
        return t02VarC;
    }

    @Override // defpackage.yu4
    public boolean r() {
        return this.c.isConsumed();
    }

    @Override // defpackage.yu4
    public void x(t02 t02Var) {
        this.r = t02Var;
    }
}
