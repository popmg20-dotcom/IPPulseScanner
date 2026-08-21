package defpackage;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ui2 extends wg4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ui2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.wg4, android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        View view;
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Drawable background = ((Window) obj).getDecorView().getBackground();
                if (background != null) {
                    background.mutate().clearColorFilter();
                    break;
                }
                break;
            case 2:
                Activity activity = (Activity) obj;
                WeakReference weakReference = vi2.c;
                if (weakReference != null && (view = (View) weakReference.get()) != null) {
                    view.setAlpha(1.0f);
                    vi2.c = null;
                }
                activity.finish();
                activity.overridePendingTransition(0, 0);
                break;
        }
    }

    @Override // defpackage.wg4, android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                vi2.a((Window) obj);
                break;
            case 1:
                vi2.a((Window) obj);
                break;
        }
    }
}
