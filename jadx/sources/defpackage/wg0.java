package defpackage;

import android.graphics.Canvas;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wg0 extends xg0 {
    @Override // defpackage.yi2
    public final void f(Canvas canvas) {
        if (this.Y0.r.isEmpty()) {
            super.f(canvas);
            return;
        }
        canvas.save();
        int i = Build.VERSION.SDK_INT;
        vg0 vg0Var = this.Y0;
        if (i >= 26) {
            canvas.clipOutRect(vg0Var.r);
        } else {
            canvas.clipRect(vg0Var.r, Region.Op.DIFFERENCE);
        }
        super.f(canvas);
        canvas.restore();
    }
}
