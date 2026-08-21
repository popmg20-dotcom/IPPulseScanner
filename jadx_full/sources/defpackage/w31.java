package defpackage;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w31 extends tj4 {
    public final v31 l;

    public w31(TextView textView) {
        this.l = new v31(textView);
    }

    @Override // defpackage.tj4
    public final InputFilter[] D(InputFilter[] inputFilterArr) {
        return !(k31.k != null) ? inputFilterArr : this.l.D(inputFilterArr);
    }

    @Override // defpackage.tj4
    public final boolean J() {
        return this.l.n;
    }

    @Override // defpackage.tj4
    public final void Y(boolean z) {
        if (k31.k != null) {
            this.l.Y(z);
        }
    }

    @Override // defpackage.tj4
    public final void a0(boolean z) {
        boolean z2 = k31.k != null;
        v31 v31Var = this.l;
        if (z2) {
            v31Var.a0(z);
        } else {
            v31Var.n = z;
        }
    }

    @Override // defpackage.tj4
    public final TransformationMethod m0(TransformationMethod transformationMethod) {
        return !(k31.k != null) ? transformationMethod : this.l.m0(transformationMethod);
    }
}
