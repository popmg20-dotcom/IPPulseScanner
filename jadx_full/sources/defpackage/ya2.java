package defpackage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.getsurfboard.R;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ya2 extends m0 {
    public static final int[] k = {533, 567, 850, 750};
    public static final int[] l = {1267, 1000, 333, 0};
    public static final xk m = new xk(16, Float.class, "animationFraction");
    public ObjectAnimator c;
    public ObjectAnimator d;
    public final Interpolator[] e;
    public final eb2 f;
    public int g;
    public boolean h;
    public float i;
    public cl j;

    public ya2(Context context, eb2 eb2Var) {
        super(2);
        this.g = 0;
        this.j = null;
        this.f = eb2Var;
        this.e = new Interpolator[]{AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line1_head_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line1_tail_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line2_head_interpolator), AnimationUtils.loadInterpolator(context, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    public final void A() {
        ObjectAnimator objectAnimator = this.c;
        eb2 eb2Var = this.f;
        xk xkVar = m;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, xkVar, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (eb2Var.n * 1800.0f));
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new xa2(this, 0));
        }
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, xkVar, 1.0f);
            this.d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration((long) (eb2Var.n * 1800.0f));
            this.d.setInterpolator(null);
            this.d.addListener(new xa2(this, 1));
        }
    }

    public final void B() {
        this.g = 0;
        Iterator it = ((ArrayList) this.b).iterator();
        while (it.hasNext()) {
            ((yx0) it.next()).c = this.f.e[0];
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
        eb2 eb2Var = this.f;
        objectAnimator.setDuration((long) (eb2Var.n * 1800.0f));
        this.d.setDuration((long) (eb2Var.n * 1800.0f));
        B();
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
        e();
        if (((rz1) this.a).isVisible()) {
            this.d.setFloatValues(this.i, 1.0f);
            this.d.setDuration((long) ((1.0f - this.i) * 1800.0f));
            this.d.start();
        }
    }

    @Override // defpackage.m0
    public final void x() {
        A();
        B();
        this.c.start();
    }

    @Override // defpackage.m0
    public final void z() {
        this.j = null;
    }
}
