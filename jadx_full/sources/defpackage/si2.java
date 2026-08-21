package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.transition.ArcMotion;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import io.sentry.android.core.a1;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class si2 extends Transition {
    public static final String[] E0 = {"materialContainerTransition:bounds", "materialContainerTransition:shapeAppearance"};
    public static final iv1 F0 = new iv1(new d8(0.0f, 0.25f), new d8(0.0f, 1.0f), new d8(0.0f, 1.0f), new d8(0.0f, 0.75f), 21);
    public static final iv1 G0 = new iv1(new d8(0.6f, 0.9f), new d8(0.0f, 1.0f), new d8(0.0f, 0.9f), new d8(0.3f, 0.9f), 21);
    public static final iv1 H0 = new iv1(new d8(0.1f, 0.4f), new d8(0.1f, 1.0f), new d8(0.1f, 1.0f), new d8(0.1f, 0.9f), 21);
    public static final iv1 I0 = new iv1(new d8(0.6f, 0.9f), new d8(0.0f, 0.9f), new d8(0.0f, 0.9f), new d8(0.2f, 0.9f), 21);
    public int A;
    public int A0;
    public boolean B0;
    public float C0;
    public float D0;
    public int X;
    public int Y;
    public int Z;
    public boolean b;
    public boolean f;
    public int y0;
    public boolean z;
    public int z0;

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(TransitionValues transitionValues, int i) {
        RectF rectFB;
        ou3 shapeAppearanceModel;
        if (i != -1) {
            View view = transitionValues.view;
            RectF rectF = fh4.a;
            View viewFindViewById = view.findViewById(i);
            if (viewFindViewById == null) {
                viewFindViewById = fh4.a(view, i);
            }
            transitionValues.view = viewFindViewById;
        } else if (transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view) instanceof View) {
            View view2 = (View) transitionValues.view.getTag(R.id.mtrl_motion_snapshot_view);
            transitionValues.view.setTag(R.id.mtrl_motion_snapshot_view, null);
            transitionValues.view = view2;
        }
        View view3 = transitionValues.view;
        if (!view3.isLaidOut() && view3.getWidth() == 0 && view3.getHeight() == 0) {
            return;
        }
        if (view3.getParent() == null) {
            RectF rectF2 = fh4.a;
            rectFB = new RectF(view3.getLeft(), view3.getTop(), view3.getRight(), view3.getBottom());
        } else {
            rectFB = fh4.b(view3);
        }
        transitionValues.values.put("materialContainerTransition:bounds", rectFB);
        Map map = transitionValues.values;
        if (view3.getTag(R.id.mtrl_motion_snapshot_view) instanceof ou3) {
            shapeAppearanceModel = (ou3) view3.getTag(R.id.mtrl_motion_snapshot_view);
        } else {
            Context context = view3.getContext();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(new int[]{R.attr.transitionShapeAppearance});
            int i2 = 0;
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
            typedArrayObtainStyledAttributes.recycle();
            if (resourceId != -1) {
                shapeAppearanceModel = ou3.f(context, resourceId, 0).b();
            } else if (view3 instanceof yu3) {
                shapeAppearanceModel = ((yu3) view3).getShapeAppearanceModel();
            } else {
                cm3 cm3Var = new cm3();
                cm3 cm3Var2 = new cm3();
                cm3 cm3Var3 = new cm3();
                cm3 cm3Var4 = new cm3();
                a0 a0Var = new a0(0.0f);
                a0 a0Var2 = new a0(0.0f);
                a0 a0Var3 = new a0(0.0f);
                a0 a0Var4 = new a0(0.0f);
                k01 k01Var = new k01(i2);
                k01 k01Var2 = new k01(i2);
                k01 k01Var3 = new k01(i2);
                k01 k01Var4 = new k01(i2);
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

    public final void b(Context context, boolean z) {
        int iC;
        ub1 ub1Var = t8.b;
        RectF rectF = fh4.a;
        if (getInterpolator() == null) {
            setInterpolator(l72.W(context, R.attr.motionEasingEmphasizedInterpolator, ub1Var));
        }
        int i = z ? R.attr.motionDurationLong2 : R.attr.motionDurationMedium4;
        if (getDuration() == -1 && (iC = ek0.C(context, i, -1)) != -1) {
            setDuration(iC);
        }
        if (this.f) {
            return;
        }
        TypedValue typedValue = new TypedValue();
        PathMotion patternPathMotion = null;
        if (context.getTheme().resolveAttribute(R.attr.motionPath, typedValue, true)) {
            int i2 = typedValue.type;
            if (i2 == 16) {
                int i3 = typedValue.data;
                if (i3 != 0) {
                    if (i3 != 1) {
                        xe.k(dw2.A(i3, "Invalid motion path type: "));
                        return;
                    }
                    patternPathMotion = new xh2();
                }
            } else {
                if (i2 != 3) {
                    xe.k("Motion path theme attribute must either be an enum value or path data string");
                    return;
                }
                patternPathMotion = new PatternPathMotion(n12.t(String.valueOf(typedValue.string)));
            }
        }
        if (patternPathMotion != null) {
            setPathMotion(patternPathMotion);
        }
    }

    @Override // android.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        a(transitionValues, this.Y);
    }

    @Override // android.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        a(transitionValues, this.X);
    }

    @Override // android.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View viewA;
        RectF rectF;
        iv1 iv1Var;
        int i = this.A;
        View view = null;
        if (transitionValues != null && transitionValues2 != null) {
            RectF rectF2 = (RectF) transitionValues.values.get("materialContainerTransition:bounds");
            ou3 ou3Var = (ou3) transitionValues.values.get("materialContainerTransition:shapeAppearance");
            if (rectF2 != null && ou3Var != null) {
                RectF rectF3 = (RectF) transitionValues2.values.get("materialContainerTransition:bounds");
                ou3 ou3Var2 = (ou3) transitionValues2.values.get("materialContainerTransition:shapeAppearance");
                if (rectF3 == null || ou3Var2 == null) {
                    a1.n("si2", "Skipping due to null end bounds. Ensure end view is laid out and measured.");
                    return null;
                }
                View view2 = transitionValues.view;
                View view3 = transitionValues2.view;
                View view4 = view3.getParent() != null ? view3 : view2;
                if (i == view4.getId()) {
                    viewA = (View) view4.getParent();
                    view = view4;
                } else {
                    viewA = fh4.a(view4, i);
                }
                RectF rectFB = fh4.b(viewA);
                float f = -rectFB.left;
                float f2 = -rectFB.top;
                if (view != null) {
                    rectF = fh4.b(view);
                    rectF.offset(f, f2);
                } else {
                    rectF = new RectF(0.0f, 0.0f, viewA.getWidth(), viewA.getHeight());
                }
                rectF2.offset(f, f2);
                rectF3.offset(f, f2);
                boolean z = rectF3.height() * rectF3.width() > rectF2.height() * rectF2.width();
                if (!this.z) {
                    b(view4.getContext(), z);
                }
                PathMotion pathMotion = getPathMotion();
                float elevation = this.C0;
                if (elevation == -1.0f) {
                    elevation = view2.getElevation();
                }
                float f3 = elevation;
                float elevation2 = this.D0;
                if (elevation2 == -1.0f) {
                    elevation2 = view3.getElevation();
                }
                float f4 = elevation2;
                int i2 = this.Z;
                int i3 = this.y0;
                int i4 = this.z0;
                int i5 = this.A0;
                boolean z2 = this.B0;
                ya1 ya1Var = z ? ab1.a : ab1.b;
                float fWidth = rectF2.width();
                float fHeight = rectF2.height();
                float fWidth2 = rectF3.width();
                float fHeight2 = rectF3.height();
                gf1 gf1Var = (!z ? (fWidth2 * fHeight) / fWidth >= fHeight2 : (fHeight2 * fWidth) / fWidth2 >= fHeight) ? if1.b : if1.a;
                PathMotion pathMotion2 = getPathMotion();
                if ((pathMotion2 instanceof ArcMotion) || (pathMotion2 instanceof xh2)) {
                    iv1 iv1Var2 = z ? H0 : I0;
                    iv1Var = new iv1((d8) iv1Var2.f, (d8) iv1Var2.z, (d8) iv1Var2.A, (d8) iv1Var2.X, 21);
                } else {
                    iv1 iv1Var3 = z ? F0 : G0;
                    iv1Var = new iv1((d8) iv1Var3.f, (d8) iv1Var3.z, (d8) iv1Var3.A, (d8) iv1Var3.X, 21);
                }
                ri2 ri2Var = new ri2(pathMotion, view2, rectF2, ou3Var, f3, view3, rectF3, ou3Var2, f4, i2, i3, i4, i5, z, z2, ya1Var, gf1Var, iv1Var);
                ri2Var.setBounds(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                valueAnimatorOfFloat.addUpdateListener(new io(3, ri2Var));
                addListener(new pi2(this, viewA, ri2Var, view2, view3));
                return valueAnimatorOfFloat;
            }
            a1.n("si2", "Skipping due to null start bounds. Ensure start view is laid out and measured.");
        }
        return null;
    }

    @Override // android.transition.Transition
    public final String[] getTransitionProperties() {
        return E0;
    }

    @Override // android.transition.Transition
    public final void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f = true;
    }
}
