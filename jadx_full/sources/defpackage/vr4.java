package defpackage;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vr4 extends ur4 {
    @Override // defpackage.co4
    public final float B(View view) {
        return view.getTransitionAlpha();
    }

    @Override // defpackage.co4
    public final void V(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // defpackage.ur4
    public final void h0(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // defpackage.ur4
    public final void i0(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // defpackage.ur4
    public final void j0(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // defpackage.ur4
    public final void k0(ViewGroup viewGroup, Matrix matrix) {
        viewGroup.transformMatrixToLocal(matrix);
    }
}
