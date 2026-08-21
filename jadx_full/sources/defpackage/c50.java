package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import com.getsurfboard.R;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c50 extends m0 {
    public static final ub1 k = t8.b;
    public static final int[] l = {0, 1500, 3000, 4500};
    public static final float[] m = {0.1f, 0.87f};
    public static final xk n = new xk(8, Float.class, "animationFraction");
    public static final xk o = new xk(9, Float.class, "completeEndFraction");
    public ObjectAnimator c;
    public ObjectAnimator d;
    public final TimeInterpolator e;
    public final d50 f;
    public int g;
    public float h;
    public float i;
    public cl j;

    public c50(Context context, d50 d50Var) {
        super(1);
        this.g = 0;
        this.j = null;
        this.f = d50Var;
        this.e = l72.W(context, R.attr.motionEasingStandardInterpolator, k);
    }

    public final void A() {
        ObjectAnimator objectAnimator = this.c;
        d50 d50Var = this.f;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, n, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (d50Var.n * 6000.0f));
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new b50(this, 0));
        }
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration((long) (d50Var.n * 500.0f));
            this.d.addListener(new b50(this, 1));
        }
    }

    @Override // defpackage.m0
    public final void e() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // defpackage.m0
    public final void n() {
        A();
        ObjectAnimator objectAnimator = this.c;
        d50 d50Var = this.f;
        objectAnimator.setDuration((long) (d50Var.n * 6000.0f));
        this.d.setDuration((long) (d50Var.n * 500.0f));
        this.g = 0;
        ((yx0) ((ArrayList) this.b).get(0)).c = d50Var.e[0];
        this.i = 0.0f;
    }

    @Override // defpackage.m0
    public final void q(cl clVar) {
        this.j = clVar;
    }

    @Override // defpackage.m0
    public final void r() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator == null || objectAnimator.isRunning()) {
            return;
        }
        if (((rz1) this.a).isVisible()) {
            this.d.start();
        } else {
            e();
        }
    }

    @Override // defpackage.m0
    public final void x() {
        A();
        this.g = 0;
        ((yx0) ((ArrayList) this.b).get(0)).c = this.f.e[0];
        this.i = 0.0f;
        this.c.start();
    }

    @Override // defpackage.m0
    public final void z() {
        this.j = null;
    }
}
