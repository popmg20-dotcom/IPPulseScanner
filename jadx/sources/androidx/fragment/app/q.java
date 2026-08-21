package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q implements View.OnAttachStateChangeListener {
    public final /* synthetic */ x b;
    public final /* synthetic */ r f;

    public q(r rVar, x xVar) {
        this.f = rVar;
        this.b = xVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        x xVar = this.b;
        o oVar = xVar.c;
        xVar.k();
        h.j((ViewGroup) oVar.mView.getParent(), this.f.b).i();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
