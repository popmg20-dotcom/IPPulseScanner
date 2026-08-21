package defpackage;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class z3 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ z3(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                c4.d((c4) obj2, (View) obj, valueAnimator);
                return;
            case 1:
                AppBarLayout appBarLayout = (AppBarLayout) obj2;
                int i2 = AppBarLayout.U0;
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ((yi2) obj).o(fFloatValue);
                Drawable drawable = appBarLayout.Q0;
                if (drawable instanceof yi2) {
                    ((yi2) drawable).o(fFloatValue);
                }
                Iterator it = appBarLayout.K0.iterator();
                if (it.hasNext()) {
                    throw dw2.z(it);
                }
                Iterator it2 = appBarLayout.L0.iterator();
                if (it2.hasNext()) {
                    throw dw2.z(it2);
                }
                return;
            default:
                tt0 tt0Var = (tt0) obj2;
                el elVar = (el) obj;
                if (elVar.b(true) && elVar.m != 0 && tt0Var.isVisible()) {
                    tt0Var.invalidateSelf();
                    return;
                }
                return;
        }
    }
}
