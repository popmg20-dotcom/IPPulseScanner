package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vt4 extends tj4 implements f3 {
    public static final AccelerateInterpolator J = new AccelerateInterpolator();
    public static final DecelerateInterpolator K = new DecelerateInterpolator();
    public boolean A;
    public boolean B;
    public boolean C;
    public dr4 D;
    public boolean E;
    public boolean F;
    public final tt4 G;
    public final tt4 H;
    public final jf4 I;
    public Context l;
    public Context m;
    public ActionBarOverlayLayout n;
    public ActionBarContainer o;
    public rk0 p;
    public ActionBarContextView q;
    public final View r;
    public boolean s;
    public ut4 t;
    public ut4 u;
    public lb v;
    public boolean w;
    public final ArrayList x;
    public int y;
    public boolean z;

    public vt4(Activity activity, boolean z) {
        new ArrayList();
        this.x = new ArrayList();
        this.y = 0;
        this.z = true;
        this.C = true;
        this.G = new tt4(this, 0);
        this.H = new tt4(this, 1);
        this.I = new jf4(3, this);
        View decorView = activity.getWindow().getDecorView();
        q0(decorView);
        if (z) {
            return;
        }
        this.r = decorView.findViewById(R.id.content);
    }

    @Override // defpackage.tj4
    public final int C() {
        return ((mf4) this.p).b;
    }

    @Override // defpackage.tj4
    public final Context F() {
        Context context = this.m;
        if (context != null) {
            return context;
        }
        TypedValue typedValue = new TypedValue();
        this.l.getTheme().resolveAttribute(com.getsurfboard.R.attr.actionBarWidgetTheme, typedValue, true);
        int i = typedValue.resourceId;
        if (i != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.l, i);
            this.m = contextThemeWrapper;
            return contextThemeWrapper;
        }
        Context context2 = this.l;
        this.m = context2;
        return context2;
    }

    @Override // defpackage.tj4
    public final void Q() {
        r0(this.l.getResources().getBoolean(com.getsurfboard.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // defpackage.tj4
    public final boolean S(int i, KeyEvent keyEvent) {
        nk2 nk2Var;
        ut4 ut4Var = this.t;
        if (ut4Var == null || (nk2Var = ut4Var.A) == null) {
            return false;
        }
        nk2Var.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return nk2Var.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.tj4
    public final void Z(boolean z) {
        if (this.s) {
            return;
        }
        int i = z ? 4 : 0;
        mf4 mf4Var = (mf4) this.p;
        int i2 = mf4Var.b;
        this.s = true;
        mf4Var.a((i & 4) | (i2 & (-5)));
    }

    @Override // defpackage.tj4
    public final void b0(boolean z) {
        dr4 dr4Var;
        this.E = z;
        if (z || (dr4Var = this.D) == null) {
            return;
        }
        dr4Var.a();
    }

    @Override // defpackage.tj4
    public final void c0(CharSequence charSequence) {
        mf4 mf4Var = (mf4) this.p;
        if (mf4Var.g) {
            return;
        }
        Toolbar toolbar = mf4Var.a;
        mf4Var.h = charSequence;
        if ((mf4Var.b & 8) != 0) {
            toolbar.setTitle(charSequence);
            if (mf4Var.g) {
                wp4.o(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // defpackage.tj4
    public final u3 e0(lb lbVar) {
        ut4 ut4Var = this.t;
        if (ut4Var != null) {
            ut4Var.a();
        }
        this.n.setHideOnContentScrollEnabled(false);
        this.q.e();
        ut4 ut4Var2 = new ut4(this, this.q.getContext(), lbVar);
        nk2 nk2Var = ut4Var2.A;
        nk2Var.y();
        try {
            if (!((iv1) ut4Var2.X.f).v(ut4Var2, nk2Var)) {
                return null;
            }
            this.t = ut4Var2;
            ut4Var2.g();
            this.q.c(ut4Var2);
            p0(true);
            return ut4Var2;
        } finally {
            nk2Var.x();
        }
    }

    public final void p0(boolean z) {
        cr4 cr4VarI;
        cr4 cr4VarI2;
        boolean z2 = this.B;
        if (z) {
            if (!z2) {
                this.B = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.n;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                s0(false);
            }
        } else if (z2) {
            this.B = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.n;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            s0(false);
        }
        boolean zIsLaidOut = this.o.isLaidOut();
        rk0 rk0Var = this.p;
        if (!zIsLaidOut) {
            if (z) {
                ((mf4) rk0Var).a.setVisibility(4);
                this.q.setVisibility(0);
                return;
            } else {
                ((mf4) rk0Var).a.setVisibility(0);
                this.q.setVisibility(8);
                return;
            }
        }
        if (z) {
            mf4 mf4Var = (mf4) rk0Var;
            cr4VarI = wp4.a(mf4Var.a);
            cr4VarI.a(0.0f);
            cr4VarI.c(100L);
            cr4VarI.d(new lf4(mf4Var, 4));
            cr4VarI2 = this.q.i(0, 200L);
        } else {
            mf4 mf4Var2 = (mf4) rk0Var;
            cr4 cr4VarA = wp4.a(mf4Var2.a);
            cr4VarA.a(1.0f);
            cr4VarA.c(200L);
            cr4VarA.d(new lf4(mf4Var2, 0));
            cr4VarI = this.q.i(8, 100L);
            cr4VarI2 = cr4VarA;
        }
        dr4 dr4Var = new dr4();
        ArrayList arrayList = dr4Var.a;
        arrayList.add(cr4VarI);
        View view = (View) cr4VarI.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) cr4VarI2.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(cr4VarI2);
        dr4Var.b();
    }

    @Override // defpackage.tj4
    public final boolean q() {
        ff4 ff4Var;
        rk0 rk0Var = this.p;
        if (rk0Var == null || (ff4Var = ((mf4) rk0Var).a.g1) == null || ff4Var.f == null) {
            return false;
        }
        ff4 ff4Var2 = ((mf4) rk0Var).a.g1;
        sk2 sk2Var = ff4Var2 == null ? null : ff4Var2.f;
        if (sk2Var == null) {
            return true;
        }
        sk2Var.collapseActionView();
        return true;
    }

    public final void q0(View view) {
        rk0 wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(com.getsurfboard.R.id.decor_content_parent);
        this.n = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(com.getsurfboard.R.id.action_bar);
        if (callbackFindViewById instanceof rk0) {
            wrapper = (rk0) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.p = wrapper;
        this.q = (ActionBarContextView) view.findViewById(com.getsurfboard.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(com.getsurfboard.R.id.action_bar_container);
        this.o = actionBarContainer;
        rk0 rk0Var = this.p;
        if (rk0Var == null || this.q == null || actionBarContainer == null) {
            xe.q(vt4.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
            return;
        }
        Context context = ((mf4) rk0Var).a.getContext();
        this.l = context;
        if ((((mf4) this.p).b & 4) != 0) {
            this.s = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.p.getClass();
        r0(context.getResources().getBoolean(com.getsurfboard.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.l.obtainStyledAttributes(null, cd3.a, com.getsurfboard.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.n;
            if (!actionBarOverlayLayout2.A0) {
                xe.q("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                return;
            } else {
                this.F = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            }
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.o;
            WeakHashMap weakHashMap = wp4.a;
            actionBarContainer2.setElevation(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void r0(boolean z) {
        if (z) {
            this.o.setTabContainer(null);
            ((mf4) this.p).getClass();
        } else {
            ((mf4) this.p).getClass();
            this.o.setTabContainer(null);
        }
        this.p.getClass();
        ((mf4) this.p).a.setCollapsible(false);
        this.n.setHasNonEmbeddedTabs(false);
    }

    public final void s0(boolean z) {
        boolean z2 = this.B || !this.A;
        boolean z3 = this.C;
        jf4 jf4Var = this.I;
        View view = this.r;
        if (!z2) {
            if (z3) {
                this.C = false;
                dr4 dr4Var = this.D;
                if (dr4Var != null) {
                    dr4Var.a();
                }
                int i = this.y;
                tt4 tt4Var = this.G;
                if (i != 0 || (!this.E && !z)) {
                    tt4Var.c();
                    return;
                }
                this.o.setAlpha(1.0f);
                this.o.setTransitioning(true);
                dr4 dr4Var2 = new dr4();
                float f = -this.o.getHeight();
                if (z) {
                    this.o.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                cr4 cr4VarA = wp4.a(this.o);
                cr4VarA.e(f);
                View view2 = (View) cr4VarA.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(jf4Var != null ? new rt0(jf4Var, view2) : null);
                }
                boolean z4 = dr4Var2.e;
                ArrayList arrayList = dr4Var2.a;
                if (!z4) {
                    arrayList.add(cr4VarA);
                }
                if (this.z && view != null) {
                    cr4 cr4VarA2 = wp4.a(view);
                    cr4VarA2.e(f);
                    if (!dr4Var2.e) {
                        arrayList.add(cr4VarA2);
                    }
                }
                boolean z5 = dr4Var2.e;
                if (!z5) {
                    dr4Var2.c = J;
                }
                if (!z5) {
                    dr4Var2.b = 250L;
                }
                if (!z5) {
                    dr4Var2.d = tt4Var;
                }
                this.D = dr4Var2;
                dr4Var2.b();
                return;
            }
            return;
        }
        if (z3) {
            return;
        }
        this.C = true;
        dr4 dr4Var3 = this.D;
        if (dr4Var3 != null) {
            dr4Var3.a();
        }
        this.o.setVisibility(0);
        int i2 = this.y;
        tt4 tt4Var2 = this.H;
        if (i2 == 0 && (this.E || z)) {
            this.o.setTranslationY(0.0f);
            float f2 = -this.o.getHeight();
            if (z) {
                this.o.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.o.setTranslationY(f2);
            dr4 dr4Var4 = new dr4();
            cr4 cr4VarA3 = wp4.a(this.o);
            cr4VarA3.e(0.0f);
            View view3 = (View) cr4VarA3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(jf4Var != null ? new rt0(jf4Var, view3) : null);
            }
            boolean z6 = dr4Var4.e;
            ArrayList arrayList2 = dr4Var4.a;
            if (!z6) {
                arrayList2.add(cr4VarA3);
            }
            if (this.z && view != null) {
                view.setTranslationY(f2);
                cr4 cr4VarA4 = wp4.a(view);
                cr4VarA4.e(0.0f);
                if (!dr4Var4.e) {
                    arrayList2.add(cr4VarA4);
                }
            }
            boolean z7 = dr4Var4.e;
            if (!z7) {
                dr4Var4.c = K;
            }
            if (!z7) {
                dr4Var4.b = 250L;
            }
            if (!z7) {
                dr4Var4.d = tt4Var2;
            }
            this.D = dr4Var4;
            dr4Var4.b();
        } else {
            this.o.setAlpha(1.0f);
            this.o.setTranslationY(0.0f);
            if (this.z && view != null) {
                view.setTranslationY(0.0f);
            }
            tt4Var2.c();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.n;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = wp4.a;
            actionBarOverlayLayout.requestApplyInsets();
        }
    }

    @Override // defpackage.tj4
    public final void w(boolean z) {
        if (z == this.w) {
            return;
        }
        this.w = z;
        ArrayList arrayList = this.x;
        if (arrayList.size() > 0) {
            throw qe4.r(arrayList, 0);
        }
    }

    public vt4(Dialog dialog) {
        new ArrayList();
        this.x = new ArrayList();
        this.y = 0;
        this.z = true;
        this.C = true;
        this.G = new tt4(this, 0);
        this.H = new tt4(this, 1);
        this.I = new jf4(3, this);
        q0(dialog.getWindow().getDecorView());
    }
}
