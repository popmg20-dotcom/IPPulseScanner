package defpackage;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.o;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class ek extends o {
    public final p10 b;

    public ek(p10 p10Var) {
        this.b = p10Var;
    }

    @Override // androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        ji0.B(uf2.t(this), null, null, new hj(this, view, null, 1), 3);
        Object parent = view.getParent();
        parent.getClass();
        int i = 0;
        ((View) parent).setVisibility(t23.f(this.b) ? 0 : 8);
        view.setOnLongClickListener(new dk(i, this, view));
    }
}
