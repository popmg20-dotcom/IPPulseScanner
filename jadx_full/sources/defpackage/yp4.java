package defpackage;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yp4 implements Interpolator {
    public final /* synthetic */ zp4 a;

    public yp4(zp4 zp4Var) {
        this.a = zp4Var;
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return this.a.w.getInterpolation(f);
    }
}
