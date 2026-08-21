package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s50 implements View.OnFocusChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ y41 b;

    public /* synthetic */ s50(y41 y41Var, int i) {
        this.a = i;
        this.b = y41Var;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        int i = this.a;
        y41 y41Var = this.b;
        switch (i) {
            case 0:
                v50 v50Var = (v50) y41Var;
                v50Var.s(v50Var.t());
                break;
            default:
                uy0 uy0Var = (uy0) y41Var;
                uy0Var.l = z;
                uy0Var.p();
                if (!z) {
                    uy0Var.s(false);
                    uy0Var.m = false;
                }
                break;
        }
    }
}
