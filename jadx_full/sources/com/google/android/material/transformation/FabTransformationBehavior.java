package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.eg0;
import defpackage.k40;
import defpackage.p95;
import defpackage.rm2;
import defpackage.sm2;
import defpackage.t60;
import defpackage.t8;
import defpackage.ta1;
import defpackage.te0;
import defpackage.xe;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final RectF A;
    public final RectF X;
    public final int[] Y;
    public float Z;
    public float y0;
    public final Rect z;

    public FabTransformationBehavior() {
        this.z = new Rect();
        this.A = new RectF();
        this.X = new RectF();
        this.Y = new int[2];
    }

    public static float B(eg0 eg0Var, sm2 sm2Var, float f) {
        long j = sm2Var.a;
        long j2 = sm2Var.b;
        sm2 sm2VarF = ((rm2) eg0Var.f).f("expansion");
        return t8.a(f, 0.0f, sm2Var.b().getInterpolation((((sm2VarF.a + sm2VarF.b) + 17) - j) / j2));
    }

    public static Pair y(float f, float f2, boolean z, eg0 eg0Var) {
        sm2 sm2VarF;
        sm2 sm2VarF2;
        if (f == 0.0f || f2 == 0.0f) {
            sm2VarF = ((rm2) eg0Var.f).f("translationXLinear");
            sm2VarF2 = ((rm2) eg0Var.f).f("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            sm2VarF = ((rm2) eg0Var.f).f("translationXCurveDownwards");
            sm2VarF2 = ((rm2) eg0Var.f).f("translationYCurveDownwards");
        } else {
            sm2VarF = ((rm2) eg0Var.f).f("translationXCurveUpwards");
            sm2VarF2 = ((rm2) eg0Var.f).f("translationYCurveUpwards");
        }
        return new Pair(sm2VarF, sm2VarF2);
    }

    public final float A(View view, View view2, t60 t60Var) {
        RectF rectF = this.A;
        C(view, rectF);
        rectF.offset(this.Z, this.y0);
        RectF rectF2 = this.X;
        C(view2, rectF2);
        t60Var.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void C(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.Y);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public abstract eg0 D(Context context, boolean z);

    @Override // com.google.android.material.transformation.ExpandableBehavior, defpackage.qe0
    public final boolean f(View view, View view2) {
        int expandedComponentIdHint;
        if (view.getVisibility() != 8) {
            return (view2 instanceof FloatingActionButton) && ((expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint()) == 0 || expandedComponentIdHint == view.getId());
        }
        xe.q("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        return false;
    }

    @Override // defpackage.qe0
    public final void g(te0 te0Var) {
        if (te0Var.h == 0) {
            te0Var.h = 80;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public final AnimatorSet x(View view, View view2, boolean z, boolean z2) {
        ObjectAnimator objectAnimatorOfFloat;
        float f;
        ObjectAnimator objectAnimatorOfFloat2;
        ObjectAnimator objectAnimatorOfFloat3;
        ObjectAnimator objectAnimatorOfFloat4;
        Property property = View.TRANSLATION_Y;
        Property property2 = View.TRANSLATION_X;
        eg0 eg0VarD = D(view2.getContext(), z);
        if (z) {
            this.Z = view.getTranslationX();
            this.y0 = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float elevation = view2.getElevation() - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        ((rm2) eg0VarD.f).f("elevation").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        float fZ = z(view, view2, (t60) eg0VarD.z);
        float fA = A(view, view2, (t60) eg0VarD.z);
        Pair pairY = y(fZ, fA, z, eg0VarD);
        sm2 sm2Var = (sm2) pairY.first;
        sm2 sm2Var2 = (sm2) pairY.second;
        RectF rectF = this.A;
        if (z) {
            f = 0.0f;
            if (!z2) {
                view2.setTranslationX(-fZ);
                view2.setTranslationY(-fA);
            }
            ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property2, 0.0f);
            ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, 0.0f);
            float fB = B(eg0VarD, sm2Var, -fZ);
            float fB2 = B(eg0VarD, sm2Var2, -fA);
            Rect rect = this.z;
            view2.getWindowVisibleDisplayFrame(rect);
            rectF.set(rect);
            RectF rectF2 = this.X;
            C(view2, rectF2);
            rectF2.offset(fB, fB2);
            rectF2.intersect(rectF);
            rectF.set(rectF2);
            objectAnimatorOfFloat3 = objectAnimatorOfFloat6;
            objectAnimatorOfFloat2 = objectAnimatorOfFloat5;
        } else {
            f = 0.0f;
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property2, -fZ);
            objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) property, -fA);
        }
        sm2Var.a(objectAnimatorOfFloat2);
        sm2Var2.a(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat3);
        rectF.width();
        rectF.height();
        float fZ2 = z(view, view2, (t60) eg0VarD.z);
        float fA2 = A(view, view2, (t60) eg0VarD.z);
        Pair pairY2 = y(fZ2, fA2, z, eg0VarD);
        sm2 sm2Var3 = (sm2) pairY2.first;
        sm2 sm2Var4 = (sm2) pairY2.second;
        if (!z) {
            fZ2 = this.Z;
        }
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fZ2);
        if (!z) {
            fA2 = this.y0;
        }
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fA2);
        sm2Var3.a(objectAnimatorOfFloat7);
        sm2Var4.a(objectAnimatorOfFloat8);
        arrayList.add(objectAnimatorOfFloat7);
        arrayList.add(objectAnimatorOfFloat8);
        if (view2 instanceof ViewGroup) {
            View viewFindViewById = view2.findViewById(R.id.mtrl_child_content_container);
            ViewGroup viewGroup = viewFindViewById != null ? viewFindViewById instanceof ViewGroup ? (ViewGroup) viewFindViewById : null : (ViewGroup) view2;
            if (viewGroup != null) {
                if (z) {
                    if (!z2) {
                        k40.a.set(viewGroup, Float.valueOf(f));
                    }
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, k40.a, 1.0f);
                } else {
                    objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(viewGroup, k40.a, f);
                }
                ((rm2) eg0VarD.f).f("contentFade").a(objectAnimatorOfFloat4);
                arrayList.add(objectAnimatorOfFloat4);
            }
        }
        AnimatorSet animatorSet = new AnimatorSet();
        p95.z(animatorSet, arrayList);
        animatorSet.addListener(new ta1(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public final float z(View view, View view2, t60 t60Var) {
        RectF rectF = this.A;
        C(view, rectF);
        rectF.offset(this.Z, this.y0);
        RectF rectF2 = this.X;
        C(view2, rectF2);
        t60Var.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = new Rect();
        this.A = new RectF();
        this.X = new RectF();
        this.Y = new int[2];
    }
}
