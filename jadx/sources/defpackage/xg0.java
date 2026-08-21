package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class xg0 extends yi2 {
    public static final /* synthetic */ int Z0 = 0;
    public vg0 Y0;

    @Override // defpackage.yi2, android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.Y0 = new vg0(this.Y0);
        return this;
    }

    public final void z(float f, float f2, float f3, float f4) {
        RectF rectF = this.Y0.r;
        if (f == rectF.left && f2 == rectF.top && f3 == rectF.right && f4 == rectF.bottom) {
            return;
        }
        rectF.set(f, f2, f3, f4);
        invalidateSelf();
    }
}
