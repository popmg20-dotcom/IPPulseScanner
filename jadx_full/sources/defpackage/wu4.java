package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class wu4 extends vu4 {
    public static final bv4 w = bv4.g(WindowInsets.CONSUMED, null);

    public wu4(bv4 bv4Var, WindowInsets windowInsets) {
        super(bv4Var, windowInsets);
    }

    @Override // defpackage.uu4, defpackage.qu4, defpackage.yu4
    public t02 h(int i) {
        return t02.d(this.c.getInsets(av4.a(i)));
    }

    @Override // defpackage.uu4, defpackage.qu4, defpackage.yu4
    public t02 i(int i) {
        return t02.d(this.c.getInsetsIgnoringVisibility(av4.a(i)));
    }

    @Override // defpackage.uu4, defpackage.qu4, defpackage.yu4
    public boolean t(int i) {
        return this.c.isVisible(av4.a(i));
    }

    @Override // defpackage.qu4, defpackage.yu4
    public void o(View view) {
    }
}
