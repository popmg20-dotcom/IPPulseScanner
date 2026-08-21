package defpackage;

import android.animation.ObjectAnimator;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wa2 extends m0 {
    public static final xk i = new xk(15, Float.class, "animationFraction");
    public ObjectAnimator c;
    public final ub1 d;
    public final eb2 e;
    public int f;
    public boolean g;
    public float h;

    public wa2(eb2 eb2Var) {
        super(3);
        this.f = 1;
        this.e = eb2Var;
        this.d = new ub1();
    }

    public final void A() {
        if (this.c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, i, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (this.e.n * 333.0f));
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new d3(9, this));
        }
    }

    public final void B() {
        this.g = true;
        this.f = 1;
        for (yx0 yx0Var : (ArrayList) this.b) {
            eb2 eb2Var = this.e;
            yx0Var.c = eb2Var.e[0];
            yx0Var.d = eb2Var.i / 2;
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
        this.c.setDuration((long) (this.e.n * 333.0f));
        B();
    }

    @Override // defpackage.m0
    public final void x() {
        A();
        B();
        this.c.start();
    }

    @Override // defpackage.m0
    public final void r() {
    }

    @Override // defpackage.m0
    public final void z() {
    }

    @Override // defpackage.m0
    public final void q(cl clVar) {
    }
}
