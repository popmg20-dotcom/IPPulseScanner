package defpackage;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.i;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gu0 extends mj1 {
    public final /* synthetic */ mj1 b;
    public final /* synthetic */ i f;

    public gu0(i iVar, mj1 mj1Var) {
        this.f = iVar;
        this.b = mj1Var;
    }

    @Override // defpackage.mj1
    public final View e(int i) {
        mj1 mj1Var = this.b;
        if (mj1Var.i()) {
            return mj1Var.e(i);
        }
        Dialog dialog = this.f.C0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // defpackage.mj1
    public final boolean i() {
        return this.b.i() || this.f.G0;
    }
}
