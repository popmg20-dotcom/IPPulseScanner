package defpackage;

import android.animation.ObjectAnimator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a50 extends m0 {
    public static final int[] k = {0, 1350, 2700, 4050};
    public static final int[] l = {667, 2017, 3367, 4717};
    public static final int[] m = {1000, 2350, 3700, 5050};
    public static final xk n = new xk(6, Float.class, "animationFraction");
    public static final xk o = new xk(7, Float.class, "completeEndFraction");
    public ObjectAnimator c;
    public ObjectAnimator d;
    public final ub1 e;
    public final d50 f;
    public int g;
    public float h;
    public float i;
    public cl j;

    public a50(d50 d50Var) {
        super(1);
        this.g = 0;
        this.j = null;
        this.f = d50Var;
        this.e = new ub1();
    }

    public final void A() {
        ObjectAnimator objectAnimator = this.c;
        d50 d50Var = this.f;
        if (objectAnimator == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, n, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (d50Var.n * 5400.0f));
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new z40(this, 0));
        }
        if (this.d == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.d = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration((long) (d50Var.n * 333.0f));
            this.d.setInterpolator(this.e);
            this.d.addListener(new z40(this, 1));
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
        objectAnimator.setDuration((long) (d50Var.n * 5400.0f));
        this.d.setDuration((long) (d50Var.n * 333.0f));
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
