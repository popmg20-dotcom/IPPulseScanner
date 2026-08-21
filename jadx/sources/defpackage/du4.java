package defpackage;

import android.view.View;
import android.view.WindowInsetsAnimation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class du4 extends eu4 {
    public final WindowInsetsAnimation e;

    public du4(WindowInsetsAnimation windowInsetsAnimation) {
        super(0, null, 0L);
        this.e = windowInsetsAnimation;
    }

    public static t02 f(WindowInsetsAnimation.Bounds bounds) {
        return t02.d(bounds.getUpperBound());
    }

    public static t02 g(WindowInsetsAnimation.Bounds bounds) {
        return t02.d(bounds.getLowerBound());
    }

    public static void h(View view, k70 k70Var) {
        view.setWindowInsetsAnimationCallback(new cu4(k70Var));
    }

    @Override // defpackage.eu4
    public final float a() {
        return this.e.getAlpha();
    }

    @Override // defpackage.eu4
    public final long b() {
        return this.e.getDurationMillis();
    }

    @Override // defpackage.eu4
    public final float c() {
        return this.e.getInterpolatedFraction();
    }

    @Override // defpackage.eu4
    public final int d() {
        return this.e.getTypeMask();
    }

    @Override // defpackage.eu4
    public final void e(float f) {
        this.e.setFraction(f);
    }
}
