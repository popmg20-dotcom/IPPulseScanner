package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vg0 extends wi2 {
    public final RectF r;

    public vg0(vg0 vg0Var) {
        super(vg0Var);
        this.r = vg0Var.r;
    }

    @Override // defpackage.wi2, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        wg0 wg0Var = new wg0(this);
        wg0Var.Y0 = this;
        wg0Var.invalidateSelf();
        return wg0Var;
    }

    public vg0(ou3 ou3Var, RectF rectF) {
        super(ou3Var);
        this.r = rectF;
    }
}
