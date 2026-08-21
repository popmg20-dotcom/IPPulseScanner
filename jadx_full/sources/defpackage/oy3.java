package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.snackbar.SnackbarContentLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class oy3 extends sl {
    public static final int[] D = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    public final AccessibilityManager B;
    public boolean C;

    public oy3(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        super(context, viewGroup, snackbarContentLayout, snackbarContentLayout2);
        this.B = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static oy3 g(View view, int i, int i2) {
        return h(view, view.getResources().getText(i), i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x002c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x002a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[LOOP:0: B:3:0x0002->B:35:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static oy3 h(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (view instanceof CoordinatorLayout) {
                viewGroup = (ViewGroup) view;
                break;
            }
            if (!(view instanceof FrameLayout)) {
                if (view == null) {
                    Object parent = view.getParent();
                    view = parent instanceof View ? (View) parent : null;
                }
                if (view != null) {
                    viewGroup = viewGroup2;
                    break;
                }
            } else {
                if (view.getId() == 16908290) {
                    viewGroup = (ViewGroup) view;
                    break;
                }
                viewGroup2 = (ViewGroup) view;
                if (view == null) {
                }
                if (view != null) {
                }
            }
        }
        if (viewGroup == null) {
            xe.k("No suitable parent found from the given view. Please provide a valid view.");
            return null;
        }
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(D);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) layoutInflaterFrom.inflate((resourceId == -1 || resourceId2 == -1) ? R.layout.design_layout_snackbar_include : R.layout.mtrl_layout_snackbar_include, viewGroup, false);
        oy3 oy3Var = new oy3(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
        ((SnackbarContentLayout) oy3Var.i.getChildAt(0)).getMessageView().setText(charSequence);
        oy3Var.k = i;
        return oy3Var;
    }

    public final void i(int i, View.OnClickListener onClickListener) {
        CharSequence text = this.h.getText(i);
        Button actionView = ((SnackbarContentLayout) this.i.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(text)) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.C = false;
        } else {
            this.C = true;
            actionView.setVisibility(0);
            actionView.setText(text);
            actionView.setOnClickListener(new kd(7, this, onClickListener));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        iv1 iv1VarQ = iv1.q();
        AccessibilityManager accessibilityManager = this.B;
        int recommendedTimeoutMillis = this.k;
        boolean z = false;
        if (recommendedTimeoutMillis == -2) {
            recommendedTimeoutMillis = -2;
        } else {
            int i = Build.VERSION.SDK_INT;
            boolean z2 = this.C;
            if (i >= 29) {
                recommendedTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(recommendedTimeoutMillis, (z2 ? 4 : 0) | 3);
            } else if (z2 && accessibilityManager.isTouchExplorationEnabled()) {
            }
        }
        pl plVar = this.u;
        synchronized (iv1VarQ.f) {
            try {
                if (iv1VarQ.r(plVar)) {
                    qy3 qy3Var = (qy3) iv1VarQ.A;
                    qy3Var.b = recommendedTimeoutMillis;
                    ((Handler) iv1VarQ.z).removeCallbacksAndMessages(qy3Var);
                    iv1VarQ.C((qy3) iv1VarQ.A);
                    return;
                }
                qy3 qy3Var2 = (qy3) iv1VarQ.X;
                if (qy3Var2 != null && qy3Var2.a.get() == plVar) {
                    z = true;
                }
                if (z) {
                    ((qy3) iv1VarQ.X).b = recommendedTimeoutMillis;
                } else {
                    iv1VarQ.X = new qy3(recommendedTimeoutMillis, plVar);
                }
                qy3 qy3Var3 = (qy3) iv1VarQ.A;
                if (qy3Var3 == null || !iv1VarQ.g(qy3Var3, 4)) {
                    iv1VarQ.A = null;
                    iv1VarQ.D();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
