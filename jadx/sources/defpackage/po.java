package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class po extends bb {
    public FrameLayout A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public oo E0;
    public boolean F0;
    public n02 G0;
    public no H0;
    public BottomSheetBehavior Z;
    public FrameLayout y0;
    public CoordinatorLayout z0;

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
        if (this.Z == null) {
            f();
        }
        super.cancel();
    }

    public final void f() {
        if (this.y0 == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.y0 = frameLayout;
            this.z0 = (CoordinatorLayout) this.y0.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.y0.findViewById(R.id.design_bottom_sheet);
            this.A0 = frameLayout2;
            BottomSheetBehavior bottomSheetBehaviorD = BottomSheetBehavior.D(frameLayout2);
            this.Z = bottomSheetBehaviorD;
            no noVar = this.H0;
            ArrayList arrayList = bottomSheetBehaviorD.s1;
            if (!arrayList.contains(noVar)) {
                arrayList.add(noVar);
            }
            this.Z.L(this.B0);
            this.G0 = new n02(this.Z, this.A0);
        }
    }

    public final FrameLayout g(View view, int i, ViewGroup.LayoutParams layoutParams) {
        f();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.y0.findViewById(R.id.coordinator);
        if (i != 0 && view == null) {
            view = getLayoutInflater().inflate(i, (ViewGroup) coordinatorLayout, false);
        }
        if (this.F0) {
            FrameLayout frameLayout = this.y0;
            zf2 zf2Var = new zf2(9, this);
            WeakHashMap weakHashMap = wp4.a;
            mp4.c(frameLayout, zf2Var);
        }
        this.A0.removeAllViews();
        FrameLayout frameLayout2 = this.A0;
        if (layoutParams == null) {
            frameLayout2.addView(view);
        } else {
            frameLayout2.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new c3(2, this));
        wp4.n(this.A0, new ol(1, this));
        this.A0.setOnTouchListener(new ql(1));
        return this.y0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    @Override // android.app.Dialog, android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r6 = this;
            super.onAttachedToWindow()
            android.view.Window r0 = r6.getWindow()
            r1 = 0
            if (r0 == 0) goto L43
            boolean r2 = r6.F0
            r3 = 1
            if (r2 == 0) goto L25
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 35
            if (r2 >= r4) goto L1a
            int r2 = r0.getNavigationBarColor()
            goto L1b
        L1a:
            r2 = r1
        L1b:
            int r2 = android.graphics.Color.alpha(r2)
            r4 = 255(0xff, float:3.57E-43)
            if (r2 >= r4) goto L25
            r2 = r3
            goto L26
        L25:
            r2 = r1
        L26:
            android.widget.FrameLayout r4 = r6.y0
            if (r4 == 0) goto L2f
            r5 = r2 ^ 1
            r4.setFitsSystemWindows(r5)
        L2f:
            androidx.coordinatorlayout.widget.CoordinatorLayout r4 = r6.z0
            if (r4 == 0) goto L38
            r5 = r2 ^ 1
            r4.setFitsSystemWindows(r5)
        L38:
            r2 = r2 ^ r3
            defpackage.v9.v(r0, r2)
            oo r2 = r6.E0
            if (r2 == 0) goto L43
            r2.e(r0)
        L43:
            n02 r0 = r6.G0
            if (r0 != 0) goto L48
            goto L63
        L48:
            java.lang.Object r2 = r0.A
            android.view.View r2 = (android.view.View) r2
            boolean r6 = r6.B0
            java.lang.Object r3 = r0.f
            bi2 r3 = (defpackage.bi2) r3
            if (r6 == 0) goto L5e
            if (r3 == 0) goto L63
            java.lang.Object r6 = r0.z
            ai2 r6 = (defpackage.ai2) r6
            r3.b(r6, r2, r1)
            return
        L5e:
            if (r3 == 0) goto L63
            r3.c(r2)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.po.onAttachedToWindow():void");
    }

    @Override // defpackage.bb, defpackage.l90, android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            if (Build.VERSION.SDK_INT < 35) {
                window.setStatusBarColor(0);
            }
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        bi2 bi2Var;
        oo ooVar = this.E0;
        if (ooVar != null) {
            ooVar.e(null);
        }
        n02 n02Var = this.G0;
        if (n02Var == null || (bi2Var = (bi2) n02Var.f) == null) {
            return;
        }
        bi2Var.c((View) n02Var.A);
    }

    @Override // defpackage.l90, android.app.Dialog
    public final void onStart() {
        super.onStart();
        BottomSheetBehavior bottomSheetBehavior = this.Z;
        if (bottomSheetBehavior == null || bottomSheetBehavior.f1 != 5) {
            return;
        }
        bottomSheetBehavior.N(4);
    }

    @Override // android.app.Dialog
    public final void setCancelable(boolean z) {
        n02 n02Var;
        super.setCancelable(z);
        if (this.B0 != z) {
            this.B0 = z;
            BottomSheetBehavior bottomSheetBehavior = this.Z;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.L(z);
            }
            if (getWindow() == null || (n02Var = this.G0) == null) {
                return;
            }
            View view = (View) n02Var.A;
            boolean z2 = this.B0;
            bi2 bi2Var = (bi2) n02Var.f;
            if (z2) {
                if (bi2Var != null) {
                    bi2Var.b((ai2) n02Var.z, view, false);
                }
            } else if (bi2Var != null) {
                bi2Var.c(view);
            }
        }
    }

    @Override // android.app.Dialog
    public final void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.B0) {
            this.B0 = true;
        }
        this.C0 = z;
        this.D0 = true;
    }

    @Override // defpackage.bb, defpackage.l90, android.app.Dialog
    public final void setContentView(View view) {
        super.setContentView(g(view, 0, null));
    }

    @Override // defpackage.bb, defpackage.l90, android.app.Dialog
    public final void setContentView(int i) {
        super.setContentView(g(null, i, null));
    }

    @Override // defpackage.bb, defpackage.l90, android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(g(view, 0, layoutParams));
    }
}
