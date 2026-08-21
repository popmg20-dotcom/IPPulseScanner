package defpackage;

import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i8 extends ez4 {
    public final ObjectAnimator k;
    public final boolean l;

    public i8(AnimationDrawable animationDrawable, boolean z, boolean z2) {
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        int i = z ? numberOfFrames - 1 : 0;
        int i2 = z ? 0 : numberOfFrames - 1;
        j8 j8Var = new j8();
        int numberOfFrames2 = animationDrawable.getNumberOfFrames();
        j8Var.b = numberOfFrames2;
        int[] iArr = j8Var.a;
        if (iArr == null || iArr.length < numberOfFrames2) {
            iArr = new int[numberOfFrames2];
            j8Var.a = iArr;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < numberOfFrames2; i4++) {
            int duration = animationDrawable.getDuration(z ? (numberOfFrames2 - i4) - 1 : i4);
            iArr[i4] = duration;
            i3 += duration;
        }
        j8Var.c = i3;
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
        objectAnimatorOfInt.setAutoCancel(true);
        objectAnimatorOfInt.setDuration(j8Var.c);
        objectAnimatorOfInt.setInterpolator(j8Var);
        this.l = z2;
        this.k = objectAnimatorOfInt;
    }

    @Override // defpackage.ez4
    public final void T() {
        this.k.reverse();
    }

    @Override // defpackage.ez4
    public final void V() {
        this.k.start();
    }

    @Override // defpackage.ez4
    public final void W() {
        this.k.cancel();
    }

    @Override // defpackage.ez4
    public final boolean i() {
        return this.l;
    }
}
