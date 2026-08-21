package defpackage;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.transformation.ExpandableBehavior;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i81 implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ ExpandableBehavior A;
    public final /* synthetic */ View b;
    public final /* synthetic */ int f;
    public final /* synthetic */ j81 z;

    public i81(ExpandableBehavior expandableBehavior, View view, int i, j81 j81Var) {
        this.A = expandableBehavior;
        this.b = view;
        this.f = i;
        this.z = j81Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        View view = this.b;
        view.getViewTreeObserver().removeOnPreDrawListener(this);
        ExpandableBehavior expandableBehavior = this.A;
        if (expandableBehavior.b == this.f) {
            Object obj = this.z;
            expandableBehavior.w((View) obj, view, ((FloatingActionButton) obj).I0.a, false);
        }
        return false;
    }
}
