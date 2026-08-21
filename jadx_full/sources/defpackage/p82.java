package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import com.getsurfboard.ui.fragment.settings.VpnSettingsFragment;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p82 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ View b;

    public /* synthetic */ p82(View view, int i) {
        this.a = i;
        this.b = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        int i = this.a;
        View view = this.b;
        switch (i) {
            case 0:
                view.setTranslationX((1.0f - valueAnimator.getAnimatedFraction()) * (-30.0f));
                break;
            default:
                VpnSettingsFragment.playFlickAnimation$lambda$0(view, valueAnimator);
                break;
        }
    }
}
