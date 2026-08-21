package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class lj1 extends AnimationSet implements Runnable {
    public boolean A;
    public boolean X;
    public final ViewGroup b;
    public final View f;
    public boolean z;

    public lj1(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.X = true;
        this.b = viewGroup;
        this.f = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.X = true;
        if (this.z) {
            return !this.A;
        }
        if (!super.getTransformation(j, transformation)) {
            this.z = true;
            pv2.a(this.b, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.z;
        ViewGroup viewGroup = this.b;
        if (z || !this.X) {
            viewGroup.endViewTransition(this.f);
            this.A = true;
        } else {
            this.X = false;
            viewGroup.post(this);
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.X = true;
        if (this.z) {
            return !this.A;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.z = true;
            pv2.a(this.b, this);
        }
        return true;
    }
}
