package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.oy3 h(android.view.View r7, java.lang.CharSequence r8, int r9) {
        /*
            r0 = 0
            r1 = r0
        L2:
            boolean r2 = r7 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            if (r2 == 0) goto L9
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L2d
        L9:
            boolean r2 = r7 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L1c
            int r1 = r7.getId()
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            if (r1 != r2) goto L19
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            goto L2d
        L19:
            r1 = r7
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L1c:
            if (r7 == 0) goto L2a
            android.view.ViewParent r7 = r7.getParent()
            boolean r2 = r7 instanceof android.view.View
            if (r2 == 0) goto L29
            android.view.View r7 = (android.view.View) r7
            goto L2a
        L29:
            r7 = r0
        L2a:
            if (r7 != 0) goto L2
            r7 = r1
        L2d:
            if (r7 == 0) goto L73
            android.content.Context r0 = r7.getContext()
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r0)
            int[] r2 = defpackage.oy3.D
            android.content.res.TypedArray r2 = r0.obtainStyledAttributes(r2)
            r3 = 0
            r4 = -1
            int r5 = r2.getResourceId(r3, r4)
            r6 = 1
            int r6 = r2.getResourceId(r6, r4)
            r2.recycle()
            if (r5 == r4) goto L53
            if (r6 == r4) goto L53
            r2 = 2131558572(0x7f0d00ac, float:1.8742464E38)
            goto L56
        L53:
            r2 = 2131558451(0x7f0d0033, float:1.8742218E38)
        L56:
            android.view.View r1 = r1.inflate(r2, r7, r3)
            com.google.android.material.snackbar.SnackbarContentLayout r1 = (com.google.android.material.snackbar.SnackbarContentLayout) r1
            oy3 r2 = new oy3
            r2.<init>(r0, r7, r1, r1)
            rl r7 = r2.i
            android.view.View r7 = r7.getChildAt(r3)
            com.google.android.material.snackbar.SnackbarContentLayout r7 = (com.google.android.material.snackbar.SnackbarContentLayout) r7
            android.widget.TextView r7 = r7.getMessageView()
            r7.setText(r8)
            r2.k = r9
            return r2
        L73:
            java.lang.String r7 = "No suitable parent found from the given view. Please provide a valid view."
            defpackage.xe.k(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oy3.h(android.view.View, java.lang.CharSequence, int):oy3");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            r9 = this;
            iv1 r0 = defpackage.iv1.q()
            android.view.accessibility.AccessibilityManager r1 = r9.B
            int r2 = r9.k
            r3 = 0
            r4 = 4
            r5 = -2
            if (r2 != r5) goto Le
            goto L2a
        Le:
            int r6 = android.os.Build.VERSION.SDK_INT
            boolean r7 = r9.C
            r8 = 29
            if (r6 < r8) goto L22
            if (r7 == 0) goto L1a
            r5 = r4
            goto L1b
        L1a:
            r5 = r3
        L1b:
            r5 = r5 | 3
            int r2 = r1.getRecommendedTimeoutMillis(r2, r5)
            goto L2b
        L22:
            if (r7 == 0) goto L2b
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L2b
        L2a:
            r2 = r5
        L2b:
            pl r9 = r9.u
            java.lang.Object r1 = r0.f
            monitor-enter(r1)
            boolean r5 = r0.r(r9)     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L4e
            java.lang.Object r9 = r0.A     // Catch: java.lang.Throwable -> L4c
            qy3 r9 = (defpackage.qy3) r9     // Catch: java.lang.Throwable -> L4c
            r9.b = r2     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r2 = r0.z     // Catch: java.lang.Throwable -> L4c
            android.os.Handler r2 = (android.os.Handler) r2     // Catch: java.lang.Throwable -> L4c
            r2.removeCallbacksAndMessages(r9)     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r9 = r0.A     // Catch: java.lang.Throwable -> L4c
            qy3 r9 = (defpackage.qy3) r9     // Catch: java.lang.Throwable -> L4c
            r0.C(r9)     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4c
            return
        L4c:
            r9 = move-exception
            goto L83
        L4e:
            java.lang.Object r5 = r0.X     // Catch: java.lang.Throwable -> L4c
            qy3 r5 = (defpackage.qy3) r5     // Catch: java.lang.Throwable -> L4c
            if (r5 == 0) goto L5d
            java.lang.ref.WeakReference r5 = r5.a     // Catch: java.lang.Throwable -> L4c
            java.lang.Object r5 = r5.get()     // Catch: java.lang.Throwable -> L4c
            if (r5 != r9) goto L5d
            r3 = 1
        L5d:
            if (r3 == 0) goto L66
            java.lang.Object r9 = r0.X     // Catch: java.lang.Throwable -> L4c
            qy3 r9 = (defpackage.qy3) r9     // Catch: java.lang.Throwable -> L4c
            r9.b = r2     // Catch: java.lang.Throwable -> L4c
            goto L6d
        L66:
            qy3 r3 = new qy3     // Catch: java.lang.Throwable -> L4c
            r3.<init>(r2, r9)     // Catch: java.lang.Throwable -> L4c
            r0.X = r3     // Catch: java.lang.Throwable -> L4c
        L6d:
            java.lang.Object r9 = r0.A     // Catch: java.lang.Throwable -> L4c
            qy3 r9 = (defpackage.qy3) r9     // Catch: java.lang.Throwable -> L4c
            if (r9 == 0) goto L7b
            boolean r9 = r0.g(r9, r4)     // Catch: java.lang.Throwable -> L4c
            if (r9 == 0) goto L7b
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4c
            return
        L7b:
            r9 = 0
            r0.A = r9     // Catch: java.lang.Throwable -> L4c
            r0.D()     // Catch: java.lang.Throwable -> L4c
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4c
            return
        L83:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L4c
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oy3.j():void");
    }
}
