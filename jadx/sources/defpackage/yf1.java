package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yf1 {
    public ou3 a;
    public xf1 b;
    public RippleDrawable c;
    public bo d;
    public RippleDrawable e;
    public boolean f;
    public float h;
    public float i;
    public float j;
    public int k;
    public StateListAnimator l;
    public Animator m;
    public rm2 n;
    public rm2 o;
    public int q;
    public final FloatingActionButton s;
    public final zf2 t;
    public static final tb1 y = t8.c;
    public static final int z = R.attr.motionDurationLong2;
    public static final int A = R.attr.motionEasingEmphasizedInterpolator;
    public static final int B = R.attr.motionDurationMedium1;
    public static final int C = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    public static final int[] D = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    public static final int[] E = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] F = {android.R.attr.state_focused, android.R.attr.state_enabled};
    public static final int[] G = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    public static final int[] H = {android.R.attr.state_enabled};
    public static final int[] I = new int[0];
    public boolean g = true;
    public float p = 1.0f;
    public int r = 0;
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public final RectF w = new RectF();
    public final Matrix x = new Matrix();

    public yf1(FloatingActionButton floatingActionButton, zf2 zf2Var) {
        this.s = floatingActionButton;
        this.t = zf2Var;
    }

    public final void a(float f, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.s.getDrawable();
        if (drawable == null || this.q == 0) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        RectF rectF = this.v;
        rectF.set(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        float f2 = this.q;
        RectF rectF2 = this.w;
        rectF2.set(0.0f, 0.0f, f2, f2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        float f3 = this.q / 2.0f;
        matrix.postScale(f, f, f3, f3);
    }

    public final AnimatorSet b(rm2 rm2Var, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        Property property = View.ALPHA;
        float[] fArr = {f};
        FloatingActionButton floatingActionButton = this.s;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) property, fArr);
        rm2Var.f("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        rm2Var.f("scale").a(objectAnimatorOfFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            objectAnimatorOfFloat2.setEvaluator(new v8(1));
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        rm2Var.f("scale").a(objectAnimatorOfFloat3);
        if (i == 26) {
            objectAnimatorOfFloat3.setEvaluator(new v8(1));
        }
        arrayList.add(objectAnimatorOfFloat3);
        Matrix matrix = this.x;
        a(f3, matrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(floatingActionButton, new fy1(), new wf1(this), new Matrix(matrix));
        rm2Var.f("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        p95.z(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(final float f, final float f2, final float f3, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        FloatingActionButton floatingActionButton = this.s;
        final float alpha = floatingActionButton.getAlpha();
        final float scaleX = floatingActionButton.getScaleX();
        final float scaleY = floatingActionButton.getScaleY();
        final float f4 = this.p;
        final Matrix matrix = new Matrix(this.x);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: uf1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                yf1 yf1Var = this.a;
                FloatingActionButton floatingActionButton2 = yf1Var.s;
                floatingActionButton2.setAlpha(t8.b(alpha, f, 0.0f, 0.2f, fFloatValue));
                float f5 = scaleX;
                float f6 = f2;
                floatingActionButton2.setScaleX(t8.a(f5, f6, fFloatValue));
                floatingActionButton2.setScaleY(t8.a(scaleY, f6, fFloatValue));
                float f7 = f4;
                float f8 = f3;
                yf1Var.p = t8.a(f7, f8, fFloatValue);
                float fA = t8.a(f7, f8, fFloatValue);
                Matrix matrix2 = matrix;
                yf1Var.a(fA, matrix2);
                floatingActionButton2.setImageMatrix(matrix2);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        p95.z(animatorSet, arrayList);
        animatorSet.setDuration(ek0.C(floatingActionButton.getContext(), i, floatingActionButton.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(l72.W(floatingActionButton.getContext(), i2, t8.b));
        return animatorSet;
    }

    public final AnimatorSet d(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        FloatingActionButton floatingActionButton = this.s;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(y);
        return animatorSet;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e(float f, float f2, float f3) {
        FloatingActionButton floatingActionButton = this.s;
        if (floatingActionButton.getStateListAnimator() == this.l) {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(D, d(f, f3));
            stateListAnimator.addState(E, d(f, f2));
            stateListAnimator.addState(F, d(f, f2));
            stateListAnimator.addState(G, d(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L));
            if (Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(y);
            stateListAnimator.addState(H, animatorSet);
            stateListAnimator.addState(I, d(0.0f, 0.0f));
            this.l = stateListAnimator;
            floatingActionButton.setStateListAnimator(stateListAnimator);
        }
        if (((FloatingActionButton) this.t.f).E0 || (this.f && floatingActionButton.getSizeDimension() < this.k)) {
            h();
        }
    }

    public final void g(ou3 ou3Var) {
        this.a = ou3Var;
        xf1 xf1Var = this.b;
        if (xf1Var != null) {
            xf1Var.setShapeAppearanceModel(ou3Var);
        }
        Drawable.Callback callback = this.c;
        if (callback instanceof yu3) {
            ((yu3) callback).setShapeAppearanceModel(ou3Var);
        }
        bo boVar = this.d;
        if (boVar != null) {
            boVar.o = ou3Var;
            boVar.invalidateSelf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r11 = this;
            zf2 r0 = r11.t
            java.lang.Object r1 = r0.f
            com.google.android.material.floatingactionbutton.FloatingActionButton r1 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r1
            boolean r2 = r1.E0
            boolean r3 = r11.f
            android.graphics.Rect r4 = r11.u
            com.google.android.material.floatingactionbutton.FloatingActionButton r5 = r11.s
            r6 = 0
            if (r2 == 0) goto L48
            if (r3 == 0) goto L20
            int r2 = r11.k
            int r3 = r5.getSizeDimension()
            int r2 = r2 - r3
            int r2 = r2 / 2
            int r6 = java.lang.Math.max(r2, r6)
        L20:
            boolean r2 = r11.g
            if (r2 == 0) goto L2c
            float r2 = r5.getElevation()
            float r3 = r11.j
            float r2 = r2 + r3
            goto L2d
        L2c:
            r2 = 0
        L2d:
            double r7 = (double) r2
            double r7 = java.lang.Math.ceil(r7)
            int r3 = (int) r7
            int r3 = java.lang.Math.max(r6, r3)
            r7 = 1069547520(0x3fc00000, float:1.5)
            float r2 = r2 * r7
            double r7 = (double) r2
            double r7 = java.lang.Math.ceil(r7)
            int r2 = (int) r7
            int r2 = java.lang.Math.max(r6, r2)
            r4.set(r3, r2, r3, r2)
            goto L60
        L48:
            if (r3 == 0) goto L5d
            int r2 = r5.getSizeDimension()
            int r3 = r11.k
            if (r2 >= r3) goto L5d
            int r2 = r5.getSizeDimension()
            int r3 = r3 - r2
            int r3 = r3 / 2
            r4.set(r3, r3, r3, r3)
            goto L60
        L5d:
            r4.set(r6, r6, r6, r6)
        L60:
            android.graphics.drawable.RippleDrawable r2 = r11.e
            java.lang.String r3 = "Didn't initialize content background"
            defpackage.r25.i(r2, r3)
            java.lang.Object r0 = r0.f
            com.google.android.material.floatingactionbutton.FloatingActionButton r0 = (com.google.android.material.floatingactionbutton.FloatingActionButton) r0
            boolean r0 = r0.E0
            if (r0 != 0) goto L84
            boolean r0 = r11.f
            if (r0 == 0) goto L7c
            int r0 = r5.getSizeDimension()
            int r2 = r11.k
            if (r0 >= r2) goto L7c
            goto L84
        L7c:
            android.graphics.drawable.RippleDrawable r11 = r11.e
            if (r11 == 0) goto L96
            com.google.android.material.floatingactionbutton.FloatingActionButton.b(r1, r11)
            goto L96
        L84:
            android.graphics.drawable.InsetDrawable r5 = new android.graphics.drawable.InsetDrawable
            android.graphics.drawable.RippleDrawable r6 = r11.e
            int r7 = r4.left
            int r8 = r4.top
            int r9 = r4.right
            int r10 = r4.bottom
            r5.<init>(r6, r7, r8, r9, r10)
            com.google.android.material.floatingactionbutton.FloatingActionButton.b(r1, r5)
        L96:
            int r11 = r4.left
            int r0 = r4.top
            int r2 = r4.right
            int r3 = r4.bottom
            android.graphics.Rect r4 = r1.F0
            r4.set(r11, r0, r2, r3)
            int r4 = r1.C0
            int r11 = r11 + r4
            int r0 = r0 + r4
            int r2 = r2 + r4
            int r3 = r3 + r4
            r1.setPadding(r11, r0, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yf1.h():void");
    }

    public final void f() {
    }
}
