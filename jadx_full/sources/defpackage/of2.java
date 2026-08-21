package defpackage;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import com.getsurfboard.ui.activity.MainActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class of2 implements mu2 {
    public final /* synthetic */ MainActivity b;

    public /* synthetic */ of2(MainActivity mainActivity) {
        this.b = mainActivity;
    }

    @Override // defpackage.mu2
    public bv4 Z(View view, bv4 bv4Var) {
        int i = MainActivity.T0;
        view.getClass();
        yu4 yu4Var = bv4Var.a;
        cp1 cp1Var = this.b.S0;
        if (cp1Var == null) {
            n12.T("binding");
            throw null;
        }
        FrameLayout frameLayout = (FrameLayout) cp1Var.f;
        frameLayout.setPadding(yu4Var.h(519).a, frameLayout.getPaddingTop(), yu4Var.h(519).c, frameLayout.getPaddingBottom());
        return bv4Var;
    }

    public void a(wn1 wn1Var) {
        int i = MainActivity.T0;
        v62 v62Var = (v62) wn1Var.f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(v62Var.C(), (Property<ViewGroup, Float>) View.SCALE_X, 1.0f, 3.0f);
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat.addListener(new pf2(0, wn1Var, this.b));
        objectAnimatorOfFloat.start();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(v62Var.C(), (Property<ViewGroup, Float>) View.SCALE_Y, 1.0f, 3.0f);
        objectAnimatorOfFloat2.setDuration(800L);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateInterpolator());
        objectAnimatorOfFloat2.start();
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(v62Var.C(), (Property<ViewGroup, Float>) View.ALPHA, 1.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(800L);
        objectAnimatorOfFloat3.start();
    }
}
