package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import com.google.android.material.snackbar.SnackbarContentLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class kl extends AnimatorListenerAdapter {
    public final /* synthetic */ int a;
    public final /* synthetic */ sl b;

    public /* synthetic */ kl(sl slVar, int i) {
        this.a = i;
        this.b = slVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i = this.a;
        sl slVar = this.b;
        switch (i) {
            case 0:
                slVar.c();
                break;
            case 1:
                slVar.d();
                break;
            case 2:
                slVar.c();
                break;
            default:
                slVar.d();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        int i = this.a;
        sl slVar = this.b;
        switch (i) {
            case 1:
                SnackbarContentLayout snackbarContentLayout = slVar.j;
                int i2 = slVar.c;
                int i3 = slVar.a;
                int i4 = i2 - i3;
                snackbarContentLayout.b.setAlpha(0.0f);
                long j = i3;
                ViewPropertyAnimator duration = snackbarContentLayout.b.animate().alpha(1.0f).setDuration(j);
                TimeInterpolator timeInterpolator = snackbarContentLayout.A;
                long j2 = i4;
                duration.setInterpolator(timeInterpolator).setStartDelay(j2).start();
                if (snackbarContentLayout.f.getVisibility() == 0) {
                    snackbarContentLayout.f.setAlpha(0.0f);
                    snackbarContentLayout.f.animate().alpha(1.0f).setDuration(j).setInterpolator(timeInterpolator).setStartDelay(j2).start();
                }
                break;
            case 2:
                SnackbarContentLayout snackbarContentLayout2 = slVar.j;
                int i5 = slVar.b;
                snackbarContentLayout2.b.setAlpha(1.0f);
                long j3 = i5;
                ViewPropertyAnimator duration2 = snackbarContentLayout2.b.animate().alpha(0.0f).setDuration(j3);
                TimeInterpolator timeInterpolator2 = snackbarContentLayout2.A;
                duration2.setInterpolator(timeInterpolator2).setStartDelay(0L).start();
                if (snackbarContentLayout2.f.getVisibility() == 0) {
                    snackbarContentLayout2.f.setAlpha(1.0f);
                    snackbarContentLayout2.f.animate().alpha(0.0f).setDuration(j3).setInterpolator(timeInterpolator2).setStartDelay(0L).start();
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ kl(sl slVar, int i, int i2) {
        this.a = i2;
        this.b = slVar;
    }
}
