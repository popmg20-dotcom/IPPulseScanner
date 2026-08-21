package defpackage;

import android.animation.ObjectAnimator;
import android.view.View;
import com.getsurfboard.R;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xa1 extends vg4 {
    public static final String[] Y0 = {"android:visibility:visibility", "android:visibility:parent"};
    public final int X0;

    public xa1() {
        this.X0 = 3;
    }

    public static void U(hh4 hh4Var) {
        int visibility = hh4Var.b.getVisibility();
        HashMap map = hh4Var.a;
        map.put("android:visibility:visibility", Integer.valueOf(visibility));
        map.put("android:visibility:parent", hh4Var.b.getParent());
        int[] iArr = new int[2];
        hh4Var.b.getLocationOnScreen(iArr);
        map.put("android:visibility:screenLocation", iArr);
    }

    public static float W(hh4 hh4Var, float f) {
        Float f2;
        return (hh4Var == null || (f2 = (Float) hh4Var.a.get("android:fade:transitionAlpha")) == null) ? f : f2.floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.js4 X(defpackage.hh4 r8, defpackage.hh4 r9) {
        /*
            js4 r0 = new js4
            r0.<init>()
            r1 = 0
            r0.a = r1
            r0.b = r1
            r2 = 0
            r3 = -1
            java.lang.String r4 = "android:visibility:parent"
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.c = r7
            java.lang.Object r6 = r6.get(r4)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L33
        L2f:
            r0.c = r3
            r0.e = r2
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r2 = r6.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.d = r2
            java.lang.Object r2 = r6.get(r4)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L56
        L52:
            r0.d = r3
            r0.f = r2
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.c
            int r9 = r0.d
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.e
            android.view.ViewGroup r4 = r0.f
            if (r3 != r4) goto L68
            goto L9f
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.b = r1
            r0.a = r2
            return r0
        L71:
            if (r9 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L78:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            r0.b = r1
            r0.a = r2
            return r0
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9f
            r0.b = r2
            r0.a = r2
            return r0
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.d
            if (r8 != 0) goto L95
            r0.b = r2
            r0.a = r2
            return r0
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.c
            if (r8 != 0) goto L9f
            r0.b = r1
            r0.a = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xa1.X(hh4, hh4):js4");
    }

    public final ObjectAnimator V(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        or4.a.V(view, f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, or4.b, f2);
        wa1 wa1Var = new wa1(view);
        objectAnimatorOfFloat.addListener(wa1Var);
        r().a(wa1Var);
        return objectAnimatorOfFloat;
    }

    @Override // defpackage.vg4
    public final void e(hh4 hh4Var) {
        U(hh4Var);
    }

    @Override // defpackage.vg4
    public final void h(hh4 hh4Var) {
        U(hh4Var);
        Float fValueOf = (Float) hh4Var.b.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            if (hh4Var.b.getVisibility() == 0) {
                fValueOf = Float.valueOf(or4.a.B(hh4Var.b));
            } else {
                fValueOf = Float.valueOf(0.0f);
            }
        }
        hh4Var.a.put("android:fade:transitionAlpha", fValueOf);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        if (X(q(r1, false), v(r1, false)).a != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0215  */
    @Override // defpackage.vg4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.animation.Animator l(android.view.ViewGroup r24, defpackage.hh4 r25, defpackage.hh4 r26) {
        /*
            Method dump skipped, instruction units count: 729
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.xa1.l(android.view.ViewGroup, hh4, hh4):android.animation.Animator");
    }

    @Override // defpackage.vg4
    public final String[] u() {
        return Y0;
    }

    @Override // defpackage.vg4
    public final boolean x() {
        return true;
    }

    @Override // defpackage.vg4
    public final boolean y(hh4 hh4Var, hh4 hh4Var2) {
        if (hh4Var == null && hh4Var2 == null) {
            return false;
        }
        if (hh4Var != null && hh4Var2 != null && hh4Var2.a.containsKey("android:visibility:visibility") != hh4Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        js4 js4VarX = X(hh4Var, hh4Var2);
        if (js4VarX.a) {
            return js4VarX.c == 0 || js4VarX.d == 0;
        }
        return false;
    }

    public xa1(int i) {
        this();
        this.X0 = i;
    }
}
