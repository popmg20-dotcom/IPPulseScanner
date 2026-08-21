package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class sb implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ sb(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Activity activity;
        int i = this.b;
        boolean z = false;
        Object obj = this.f;
        switch (i) {
            case 0:
                bc bcVar = (bc) obj;
                if (!bcVar.getInternalPopup().b()) {
                    bcVar.z0.n(bcVar.getTextDirection(), bcVar.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = bcVar.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
                break;
            case 1:
                yb ybVar = (yb) obj;
                bc bcVar2 = ybVar.Y0;
                if (bcVar2.isAttachedToWindow() && bcVar2.getGlobalVisibleRect(ybVar.W0)) {
                    ybVar.r();
                    ybVar.g();
                } else {
                    ybVar.dismiss();
                }
                break;
            case 2:
                f20 f20Var = (f20) obj;
                ArrayList arrayList = f20Var.y0;
                if (f20Var.b() && arrayList.size() > 0 && !((e20) arrayList.get(0)).a.P0) {
                    View view = f20Var.F0;
                    if (view != null && view.isShown()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((e20) it.next()).a.g();
                        }
                    } else {
                        f20Var.dismiss();
                    }
                    break;
                }
                break;
            case 3:
                NavigationView navigationView = (NavigationView) obj;
                int[] iArr = navigationView.F0;
                navigationView.getLocationOnScreen(iArr);
                boolean z2 = iArr[1] == 0;
                mq2 mq2Var = navigationView.C0;
                if (mq2Var.O0 != z2) {
                    mq2Var.O0 = z2;
                    int i2 = (mq2Var.f.getChildCount() <= 0 && mq2Var.O0) ? mq2Var.Q0 : 0;
                    NavigationMenuView navigationMenuView = mq2Var.b;
                    navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
                }
                navigationView.setDrawTopInsetForeground(z2 && navigationView.I0);
                boolean z3 = navigationView.getLayoutDirection() == 1;
                int i3 = iArr[0];
                navigationView.setDrawLeftInsetForeground((i3 == 0 || navigationView.getWidth() + i3 == 0) && (!z3 ? !navigationView.K0 : !navigationView.L0));
                Context context = navigationView.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        activity = null;
                    } else if (context instanceof Activity) {
                        activity = (Activity) context;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
                if (activity != null) {
                    Rect rectI = ke0.i(activity);
                    navigationView.setDrawBottomInsetForeground((rectI.height() - navigationView.getHeight() == iArr[1]) && (Color.alpha(Build.VERSION.SDK_INT < 35 ? activity.getWindow().getNavigationBarColor() : 0) != 0) && navigationView.J0);
                    if ((rectI.width() == iArr[0] || rectI.width() - navigationView.getWidth() == iArr[0]) && (!z3 ? navigationView.L0 : navigationView.K0)) {
                        z = true;
                    }
                    navigationView.setDrawRightInsetForeground(z);
                }
                break;
            default:
                f24 f24Var = (f24) obj;
                el2 el2Var = f24Var.y0;
                if (f24Var.b() && !el2Var.P0) {
                    View view2 = f24Var.D0;
                    if (view2 != null && view2.isShown()) {
                        el2Var.g();
                    } else {
                        f24Var.dismiss();
                    }
                    break;
                }
                break;
        }
    }
}
