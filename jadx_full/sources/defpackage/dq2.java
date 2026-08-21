package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class dq2 extends h2 {
    public final /* synthetic */ int d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ eq2 f;

    public dq2(eq2 eq2Var, int i, boolean z) {
        this.f = eq2Var;
        this.d = i;
        this.e = z;
    }

    @Override // defpackage.h2
    public final void d(View view, p2 p2Var) {
        this.a.onInitializeAccessibilityNodeInfo(view, p2Var.a);
        mq2 mq2Var = this.f.g;
        int i = this.d;
        int i2 = i;
        for (int i3 = 0; i3 < i; i3++) {
            if (mq2Var.X.d(i3) == 2 || mq2Var.X.d(i3) == 3) {
                i2--;
            }
        }
        p2Var.k(o2.a(i2, 1, 1, this.e, 1, view.isSelected()));
    }
}
