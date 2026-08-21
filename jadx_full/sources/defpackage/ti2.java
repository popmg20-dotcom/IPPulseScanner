package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import io.sentry.android.core.a1;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ti2 extends vg4 {
    public static final String[] i1 = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final iv1 j1 = new iv1(new d8(0.0f, 0.25f), new d8(0.0f, 1.0f), new d8(0.0f, 1.0f), new d8(0.0f, 0.75f), 22);
    public static final iv1 k1 = new iv1(new d8(0.6f, 0.9f), new d8(0.0f, 1.0f), new d8(0.0f, 0.9f), new d8(0.3f, 0.9f), 22);
    public static final iv1 l1 = new iv1(new d8(0.1f, 0.4f), new d8(0.1f, 1.0f), new d8(0.1f, 1.0f), new d8(0.1f, 0.9f), 22);
    public static final iv1 m1 = new iv1(new d8(0.6f, 0.9f), new d8(0.0f, 0.9f), new d8(0.0f, 0.9f), new d8(0.2f, 0.9f), 22);
    public final boolean Y0;
    public View d1;
    public View e1;
    public final boolean f1;
    public float g1;
    public float h1;
    public boolean X0 = false;
    public int Z0 = R.id.content;
    public final int a1 = -1;
    public final int b1 = -1;
    public int c1 = 1375731712;

    public ti2(Context context, boolean z) {
        this.Y0 = false;
        this.f1 = Build.VERSION.SDK_INT >= 28;
        this.g1 = -1.0f;
        this.h1 = -1.0f;
        V(context, z);
        this.Y0 = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void U(hh4 hh4Var, View view, int i) {
        RectF rectFB;
        ou3 shapeAppearanceModel;
        if (i != -1) {
            View view2 = hh4Var.b;
            RectF rectF = eh4.a;
            View viewFindViewById = view2.findViewById(i);
            if (viewFindViewById == null) {
                viewFindViewById = eh4.a(view2, i);
            }
            hh4Var.b = viewFindViewById;
        } else if (view != null) {
            hh4Var.b = view;
        } else if (hh4Var.b.getTag(com.getsurfboard.R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view3 = (View) hh4Var.b.getTag(com.getsurfboard.R.id.mtrl_motion_snapshot_view);
            hh4Var.b.setTag(com.getsurfboard.R.id.mtrl_motion_snapshot_view, null);
            hh4Var.b = view3;
        }
        View view4 = hh4Var.b;
        HashMap map = hh4Var.a;
        if (!view4.isLaidOut() && view4.getWidth() == 0 && view4.getHeight() == 0) {
            return;
        }
        if (view4.getParent() == null) {
            RectF rectF2 = eh4.a;
            rectFB = new RectF(view4.getLeft(), view4.getTop(), view4.getRight(), view4.getBottom());
        } else {
            rectFB = eh4.b(view4);
        }
        map.put("materialContainerTransition:bounds", rectFB);
        if (view4.getTag(com.getsurfboard.R.id.mtrl_motion_snapshot_view) instanceof ou3) {
            shapeAppearanceModel = (ou3) view4.getTag(com.getsurfboard.R.id.mtrl_motion_snapshot_view);
        } else {
            Context context = view4.getContext();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{com.getsurfboard.R.attr.transitionShapeAppearance});
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            typedArrayObtainStyledAttributes.recycle();
            if (resourceId != -1) {
                shapeAppearanceModel = ou3.f(context, resourceId, 0).b();
            } else if (view4 instanceof yu3) {
                shapeAppearanceModel = ((yu3) view4).getShapeAppearanceModel();
            } else {
                cm3 cm3Var = new cm3();
                cm3 cm3Var2 = new cm3();
                cm3 cm3Var3 = new cm3();
                cm3 cm3Var4 = new cm3();
                a0 a0Var = new a0(0.0f);
                a0 a0Var2 = new a0(0.0f);
                a0 a0Var3 = new a0(0.0f);
                a0 a0Var4 = new a0(0.0f);
                k01 k01Var = new k01(0);
                k01 k01Var2 = new k01(0);
                k01 k01Var3 = new k01(0);
                k01 k01Var4 = new k01(0);
                ou3 ou3Var = new ou3();
                ou3Var.a = cm3Var;
                ou3Var.b = cm3Var2;
                ou3Var.c = cm3Var3;
                ou3Var.d = cm3Var4;
                ou3Var.e = a0Var;
                ou3Var.f = a0Var2;
                ou3Var.g = a0Var3;
                ou3Var.h = a0Var4;
                ou3Var.i = k01Var;
                ou3Var.j = k01Var2;
                ou3Var.k = k01Var3;
                ou3Var.l = k01Var4;
                shapeAppearanceModel = ou3Var;
            }
        }
        qy1 qy1VarL = shapeAppearanceModel.l();
        qy1VarL.e = mi3.b(rectFB, shapeAppearanceModel.e);
        qy1VarL.f = mi3.b(rectFB, shapeAppearanceModel.f);
        qy1VarL.h = mi3.b(rectFB, shapeAppearanceModel.h);
        qy1VarL.g = mi3.b(rectFB, shapeAppearanceModel.g);
        map.put("materialContainerTransition:shapeAppearance", qy1VarL.b());
    }

    @Override // defpackage.vg4
    public final void P(ek0 ek0Var) {
        super.P(ek0Var);
        this.X0 = true;
    }

    public final void V(Context context, boolean z) {
        int iC;
        ub1 ub1Var = t8.b;
        RectF rectF = eh4.a;
        if (this.A == null) {
            this.A = l72.W(context, com.getsurfboard.R.attr.motionEasingEmphasizedInterpolator, ub1Var);
        }
        int i = z ? com.getsurfboard.R.attr.motionDurationLong2 : com.getsurfboard.R.attr.motionDurationMedium4;
        if (this.z == -1 && (iC = ek0.C(context, i, -1)) != -1) {
            this.z = iC;
        }
        if (this.X0) {
            return;
        }
        TypedValue typedValue = new TypedValue();
        ek0 z03Var = null;
        if (context.getTheme().resolveAttribute(com.getsurfboard.R.attr.motionPath, typedValue, true)) {
            int i2 = typedValue.type;
            if (i2 == 16) {
                int i3 = typedValue.data;
                if (i3 != 0) {
                    if (i3 != 1) {
                        xe.k(dw2.A(i3, "Invalid motion path type: "));
                        return;
                    }
                    z03Var = new yh2();
                }
            } else {
                if (i2 != 3) {
                    xe.k("Motion path theme attribute must either be an enum value or path data string");
                    return;
                }
                z03Var = new z03(n12.t(String.valueOf(typedValue.string)));
            }
        }
        if (z03Var != null) {
            P(z03Var);
        }
    }

    @Override // defpackage.vg4
    public final void e(hh4 hh4Var) {
        U(hh4Var, this.e1, this.b1);
    }

    @Override // defpackage.vg4
    public final void h(hh4 hh4Var) {
        U(hh4Var, this.d1, this.a1);
    }

    @Override // defpackage.vg4
    public final Animator l(ViewGroup viewGroup, hh4 hh4Var, hh4 hh4Var2) {
        View viewA;
        RectF rectF;
        iv1 iv1Var;
        View view = null;
        if (hh4Var != null) {
            HashMap map = hh4Var.a;
            if (hh4Var2 != null) {
                HashMap map2 = hh4Var2.a;
                RectF rectF2 = (RectF) map.get("materialContainerTransition:bounds");
                ou3 ou3Var = (ou3) map.get("materialContainerTransition:shapeAppearance");
                if (rectF2 != null && ou3Var != null) {
                    RectF rectF3 = (RectF) map2.get("materialContainerTransition:bounds");
                    ou3 ou3Var2 = (ou3) map2.get("materialContainerTransition:shapeAppearance");
                    if (rectF3 == null || ou3Var2 == null) {
                        a1.n("ti2", "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                        return null;
                    }
                    View view2 = hh4Var.b;
                    View view3 = hh4Var2.b;
                    View view4 = view3.getParent() != null ? view3 : view2;
                    if (this.Z0 == view4.getId()) {
                        viewA = (View) view4.getParent();
                        view = view4;
                    } else {
                        viewA = eh4.a(view4, this.Z0);
                    }
                    RectF rectFB = eh4.b(viewA);
                    float f = -rectFB.left;
                    float f2 = -rectFB.top;
                    if (view != null) {
                        rectF = eh4.b(view);
                        rectF.offset(f, f2);
                    } else {
                        rectF = new RectF(0.0f, 0.0f, viewA.getWidth(), viewA.getHeight());
                    }
                    rectF2.offset(f, f2);
                    rectF3.offset(f, f2);
                    boolean z = rectF3.height() * rectF3.width() > rectF2.height() * rectF2.width();
                    if (!this.Y0) {
                        V(view4.getContext(), z);
                    }
                    ek0 ek0Var = this.P0;
                    float elevation = this.g1;
                    if (elevation == -1.0f) {
                        elevation = view2.getElevation();
                    }
                    float f3 = elevation;
                    float elevation2 = this.h1;
                    if (elevation2 == -1.0f) {
                        elevation2 = view3.getElevation();
                    }
                    float f4 = elevation2;
                    int i = this.c1;
                    za1 za1Var = z ? bb1.a : bb1.b;
                    float fWidth = rectF2.width();
                    float fHeight = rectF2.height();
                    float fWidth2 = rectF3.width();
                    float fHeight2 = rectF3.height();
                    hf1 hf1Var = (!z ? (fWidth2 * fHeight) / fWidth >= fHeight2 : (fHeight2 * fWidth) / fWidth2 >= fHeight) ? jf1.b : jf1.a;
                    if (this.P0 instanceof yh2) {
                        iv1 iv1Var2 = z ? l1 : m1;
                        iv1Var = new iv1((d8) iv1Var2.f, (d8) iv1Var2.z, (d8) iv1Var2.A, (d8) iv1Var2.X, 22);
                    } else {
                        iv1 iv1Var3 = z ? j1 : k1;
                        iv1Var = new iv1((d8) iv1Var3.f, (d8) iv1Var3.z, (d8) iv1Var3.A, (d8) iv1Var3.X, 22);
                    }
                    ri2 ri2Var = new ri2(ek0Var, view2, rectF2, ou3Var, f3, view3, rectF3, ou3Var2, f4, i, z, this.f1, za1Var, hf1Var, iv1Var);
                    ri2Var.setBounds(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
                    ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    valueAnimatorOfFloat.addUpdateListener(new io(4, ri2Var));
                    a(new qi2(this, viewA, ri2Var, view2, view3));
                    return valueAnimatorOfFloat;
                }
                a1.n("ti2", "Skipping due to null start bounds. Ensure start view is laid out and measured.");
            }
        }
        return null;
    }

    @Override // defpackage.vg4
    public final String[] u() {
        return i1;
    }
}
