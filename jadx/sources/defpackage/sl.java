package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import com.getsurfboard.R;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.SnackbarContentLayout;
import io.sentry.android.core.a1;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class sl {
    public final int a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final ViewGroup g;
    public final Context h;
    public final rl i;
    public final SnackbarContentLayout j;
    public int k;
    public final nl l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public ArrayList s;
    public final AccessibilityManager t;
    public final pl u = new pl(this);
    public static final ub1 v = t8.b;
    public static final LinearInterpolator w = t8.a;
    public static final tb1 x = t8.d;
    public static final int[] z = {R.attr.snackbarStyle};
    public static final String A = sl.class.getSimpleName();
    public static final Handler y = new Handler(Looper.getMainLooper(), new ml());

    public sl(Context context, ViewGroup viewGroup, View view, SnackbarContentLayout snackbarContentLayout) {
        int i = 0;
        this.l = new nl(this, i);
        if (view == null) {
            xe.k("Transient bottom bar must have non-null content");
            throw null;
        }
        if (snackbarContentLayout == null) {
            xe.k("Transient bottom bar must have non-null callback");
            throw null;
        }
        this.g = viewGroup;
        this.j = snackbarContentLayout;
        this.h = context;
        fx3.f(context, fx3.f, "Theme.AppCompat");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(z);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        rl rlVar = (rl) layoutInflaterFrom.inflate(resourceId != -1 ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar, viewGroup, false);
        this.i = rlVar;
        rlVar.setBaseTransientBottomBar(this);
        if (view instanceof SnackbarContentLayout) {
            SnackbarContentLayout snackbarContentLayout2 = (SnackbarContentLayout) view;
            float actionTextColorAlpha = rlVar.getActionTextColorAlpha();
            if (actionTextColorAlpha != 1.0f) {
                snackbarContentLayout2.f.setTextColor(n12.I(n12.A(snackbarContentLayout2, R.attr.colorSurface), actionTextColorAlpha, snackbarContentLayout2.f.getCurrentTextColor()));
            }
            snackbarContentLayout2.setMaxInlineActionWidth(rlVar.getMaxInlineActionWidth());
        }
        rlVar.addView(view);
        rlVar.setAccessibilityLiveRegion(1);
        rlVar.setImportantForAccessibility(1);
        rlVar.setFitsSystemWindows(true);
        w7 w7Var = new w7(11, this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(rlVar, w7Var);
        wp4.n(rlVar, new ol(i, this));
        this.t = (AccessibilityManager) context.getSystemService("accessibility");
        this.c = ek0.C(context, R.attr.motionDurationLong2, 250);
        this.a = ek0.C(context, R.attr.motionDurationLong2, 150);
        this.b = ek0.C(context, R.attr.motionDurationMedium1, 75);
        this.d = l72.W(context, R.attr.motionEasingEmphasizedInterpolator, w);
        this.f = l72.W(context, R.attr.motionEasingEmphasizedInterpolator, x);
        this.e = l72.W(context, R.attr.motionEasingEmphasizedInterpolator, v);
    }

    public final void a(int i) {
        iv1 iv1VarQ = iv1.q();
        pl plVar = this.u;
        synchronized (iv1VarQ.f) {
            try {
                if (iv1VarQ.r(plVar)) {
                    iv1VarQ.g((qy3) iv1VarQ.A, i);
                } else {
                    qy3 qy3Var = (qy3) iv1VarQ.X;
                    if (qy3Var != null && qy3Var.a.get() == plVar) {
                        iv1VarQ.g((qy3) iv1VarQ.X, i);
                    }
                }
            } finally {
            }
        }
    }

    public final void b() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = this.i.getRootWindowInsets()) == null) {
            return;
        }
        this.p = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
        f();
    }

    public final void c() {
        iv1 iv1VarQ = iv1.q();
        pl plVar = this.u;
        synchronized (iv1VarQ.f) {
            try {
                if (iv1VarQ.r(plVar)) {
                    iv1VarQ.A = null;
                    if (((qy3) iv1VarQ.X) != null) {
                        iv1VarQ.D();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList = this.s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((th0) this.s.get(size)).getClass();
            }
        }
        ViewParent parent = this.i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.i);
        }
    }

    public final void d() {
        iv1 iv1VarQ = iv1.q();
        pl plVar = this.u;
        synchronized (iv1VarQ.f) {
            try {
                if (iv1VarQ.r(plVar)) {
                    iv1VarQ.C((qy3) iv1VarQ.A);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ArrayList arrayList = this.s;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                th0 th0Var = (th0) this.s.get(size);
                th0Var.getClass();
                String str = th0Var.a.a;
                String[] strArr = t23.a;
                str.getClass();
                SharedPreferences.Editor editorEdit = t23.l().edit();
                editorEdit.putString("viewed_new_version", str);
                editorEdit.apply();
            }
        }
    }

    public final void e() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z2 = true;
        AccessibilityManager accessibilityManager = this.t;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z2 = false;
        }
        rl rlVar = this.i;
        if (z2) {
            rlVar.post(new nl(this, 2));
            return;
        }
        if (rlVar.getParent() != null) {
            rlVar.setVisibility(0);
        }
        d();
    }

    public final void f() {
        rl rlVar = this.i;
        ViewGroup.LayoutParams layoutParams = rlVar.getLayoutParams();
        boolean z2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        String str = A;
        if (!z2) {
            a1.n(str, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (rlVar.D0 == null) {
            a1.n(str, "Unable to update margins because original view margins are not set");
            return;
        }
        if (rlVar.getParent() == null) {
            return;
        }
        int i = this.m;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = rlVar.D0;
        int i2 = rect.bottom + i;
        int i3 = rect.left + this.n;
        int i4 = rect.right + this.o;
        int i5 = rect.top;
        boolean z3 = (marginLayoutParams.bottomMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.topMargin == i5) ? false : true;
        if (z3) {
            marginLayoutParams.bottomMargin = i2;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i4;
            marginLayoutParams.topMargin = i5;
            rlVar.requestLayout();
        }
        if ((z3 || this.q != this.p) && Build.VERSION.SDK_INT >= 29 && this.p > 0) {
            ViewGroup.LayoutParams layoutParams2 = rlVar.getLayoutParams();
            if ((layoutParams2 instanceof te0) && (((te0) layoutParams2).a instanceof SwipeDismissBehavior)) {
                nl nlVar = this.l;
                rlVar.removeCallbacks(nlVar);
                rlVar.post(nlVar);
            }
        }
    }
}
