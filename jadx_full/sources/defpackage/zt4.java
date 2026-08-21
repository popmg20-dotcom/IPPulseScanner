package defpackage;

import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zt4 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ fu4 a;
    public final /* synthetic */ bv4 b;
    public final /* synthetic */ bv4 c;
    public final /* synthetic */ int d;
    public final /* synthetic */ View e;

    public zt4(fu4 fu4Var, bv4 bv4Var, bv4 bv4Var2, int i, View view) {
        this.a = fu4Var;
        this.b = bv4Var;
        this.c = bv4Var2;
        this.d = i;
        this.e = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float animatedFraction = valueAnimator.getAnimatedFraction();
        fu4 fu4Var = this.a;
        eu4 eu4Var = fu4Var.a;
        eu4Var.e(animatedFraction);
        float fC = eu4Var.c();
        PathInterpolator pathInterpolator = bu4.e;
        int i = Build.VERSION.SDK_INT;
        bv4 bv4Var = this.b;
        pu4 ou4Var = i >= 36 ? new ou4(bv4Var) : i >= 35 ? new nu4(bv4Var) : i >= 34 ? new mu4(bv4Var) : i >= 31 ? new lu4(bv4Var) : i >= 30 ? new ku4(bv4Var) : i >= 29 ? new ju4(bv4Var) : new iu4(bv4Var);
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            int i3 = this.d & i2;
            yu4 yu4Var = bv4Var.a;
            if (i3 == 0) {
                ou4Var.d(i2, yu4Var.h(i2));
            } else {
                t02 t02VarH = yu4Var.h(i2);
                t02 t02VarH2 = this.c.a.h(i2);
                float f = 1.0f - fC;
                ou4Var.d(i2, bv4.e(t02VarH, (int) (((double) ((t02VarH.a - t02VarH2.a) * f)) + 0.5d), (int) (((double) ((t02VarH.b - t02VarH2.b) * f)) + 0.5d), (int) (((double) ((t02VarH.c - t02VarH2.c) * f)) + 0.5d), (int) (((double) ((t02VarH.d - t02VarH2.d) * f)) + 0.5d)));
            }
        }
        bu4.h(this.e, ou4Var.b(), Collections.singletonList(fu4Var));
    }
}
