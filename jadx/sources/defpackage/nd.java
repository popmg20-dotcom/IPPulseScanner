package defpackage;

import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import androidx.core.widget.NestedScrollView;
import com.getsurfboard.ui.activity.AppThemeConfigActivity;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.google.android.material.divider.MaterialDivider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nd implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ int a;
    public int b;
    public final /* synthetic */ ca c;

    public /* synthetic */ nd(ca caVar, int i) {
        this.a = i;
        this.c = caVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        int i = this.a;
        ca caVar = this.c;
        switch (i) {
            case 0:
                AppThemeConfigActivity appThemeConfigActivity = (AppThemeConfigActivity) caVar;
                y3 y3Var = appThemeConfigActivity.S0;
                if (y3Var == null) {
                    n12.T("binding");
                    throw null;
                }
                int scrollY = ((NestedScrollView) y3Var.j).getScrollY();
                if (scrollY == 0) {
                    y3 y3Var2 = appThemeConfigActivity.S0;
                    if (y3Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = ((MaterialDivider) y3Var2.k).animate();
                    viewPropertyAnimatorAnimate.cancel();
                    viewPropertyAnimatorAnimate.alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    y3 y3Var3 = appThemeConfigActivity.S0;
                    if (y3Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate2 = ((MaterialDivider) y3Var3.k).animate();
                    viewPropertyAnimatorAnimate2.cancel();
                    viewPropertyAnimatorAnimate2.alpha(1.0f).setDuration(100L).start();
                }
                this.b = scrollY;
                return;
            default:
                NATDetectActivity nATDetectActivity = (NATDetectActivity) caVar;
                h4 h4Var = nATDetectActivity.S0;
                if (h4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                int scrollY2 = ((NestedScrollView) h4Var.g).getScrollY();
                if (scrollY2 == 0) {
                    h4 h4Var2 = nATDetectActivity.S0;
                    if (h4Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate3 = ((MaterialDivider) h4Var2.j).animate();
                    viewPropertyAnimatorAnimate3.cancel();
                    viewPropertyAnimatorAnimate3.alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    h4 h4Var3 = nATDetectActivity.S0;
                    if (h4Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate4 = ((MaterialDivider) h4Var3.j).animate();
                    viewPropertyAnimatorAnimate4.cancel();
                    viewPropertyAnimatorAnimate4.alpha(1.0f).setDuration(100L).start();
                }
                this.b = scrollY2;
                return;
        }
    }
}
