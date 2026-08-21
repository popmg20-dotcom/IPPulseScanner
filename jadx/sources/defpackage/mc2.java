package defpackage;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class mc2 implements View.OnTouchListener {
    public static final int H0 = ViewConfiguration.getTapTimeout();
    public f33 A;
    public final float[] A0;
    public boolean B0;
    public boolean C0;
    public boolean D0;
    public boolean E0;
    public boolean F0;
    public final jy0 G0;
    public final float[] X;
    public final float[] Y;
    public final int Z;
    public final hg b;
    public final AccelerateInterpolator f;
    public final float[] y0;
    public final jy0 z;
    public final float[] z0;

    public mc2(jy0 jy0Var) {
        hg hgVar = new hg();
        hgVar.e = Long.MIN_VALUE;
        hgVar.g = -1L;
        hgVar.f = 0L;
        this.b = hgVar;
        this.f = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.X = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.Y = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.y0 = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.z0 = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.A0 = fArr5;
        this.z = jy0Var;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = ((int) ((1575.0f * f) + 0.5f)) / 1000.0f;
        fArr5[0] = f2;
        fArr5[1] = f2;
        float f3 = ((int) ((f * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f3;
        fArr4[1] = f3;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.Z = H0;
        hgVar.a = 500;
        hgVar.b = 500;
        this.G0 = jy0Var;
    }

    public static float b(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.X
            r0 = r0[r7]
            float[] r1 = r3.Y
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.y0
            r0 = r0[r7]
            float[] r1 = r3.z0
            r1 = r1[r7]
            float[] r3 = r3.A0
            r3 = r3[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            return r3
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r3 = -r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mc2.a(float, float, float, int):float");
    }

    public final float c(float f, float f2) {
        if (f2 != 0.0f && f < f2) {
            if (f >= 0.0f) {
                return 1.0f - (f / f2);
            }
            if (this.E0) {
                return 1.0f;
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.C0) {
            this.E0 = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        hg hgVar = this.b;
        int i2 = (int) (jCurrentAnimationTimeMillis - hgVar.e);
        int i3 = hgVar.b;
        if (i2 > i3) {
            i = i3;
        } else if (i2 >= 0) {
            i = i2;
        }
        hgVar.i = i;
        hgVar.h = hgVar.a(jCurrentAnimationTimeMillis);
        hgVar.g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        jy0 jy0Var;
        int count;
        hg hgVar = this.b;
        float f = hgVar.d;
        int iAbs = (int) (f / Math.abs(f));
        Math.abs(hgVar.c);
        if (iAbs != 0 && (count = (jy0Var = this.G0).getCount()) != 0) {
            int childCount = jy0Var.getChildCount();
            int firstVisiblePosition = jy0Var.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && jy0Var.getChildAt(0).getTop() >= 0)) : !(i >= count && jy0Var.getChildAt(childCount - 1).getBottom() <= jy0Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.F0
            r1 = 0
            if (r0 != 0) goto L7
            goto L78
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L78
        L17:
            r7.d()
            return r1
        L1b:
            r7.D0 = r2
            r7.B0 = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            jy0 r4 = r7.z
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            hg r9 = r7.b
            r9.c = r0
            r9.d = r8
            boolean r8 = r7.E0
            if (r8 != 0) goto L78
            boolean r8 = r7.e()
            if (r8 == 0) goto L78
            f33 r8 = r7.A
            if (r8 != 0) goto L60
            f33 r8 = new f33
            r8.<init>(r2, r7)
            r7.A = r8
        L60:
            r7.E0 = r2
            r7.C0 = r2
            boolean r9 = r7.B0
            if (r9 != 0) goto L73
            int r9 = r7.Z
            if (r9 <= 0) goto L73
            long r5 = (long) r9
            java.util.WeakHashMap r9 = defpackage.wp4.a
            r4.postOnAnimationDelayed(r8, r5)
            goto L76
        L73:
            r8.run()
        L76:
            r7.B0 = r2
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mc2.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
