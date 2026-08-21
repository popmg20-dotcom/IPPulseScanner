package defpackage;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import java.util.WeakHashMap;

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
    */
    public final float a(float f, float f2, float f3, int i) {
        float fB;
        float interpolation;
        float fB2 = b(this.X[i] * f2, 0.0f, this.Y[i]);
        float fC = c(f2 - f, fB2) - c(f, fB2);
        AccelerateInterpolator accelerateInterpolator = this.f;
        if (fC < 0.0f) {
            interpolation = -accelerateInterpolator.getInterpolation(-fC);
        } else {
            if (fC <= 0.0f) {
                fB = 0.0f;
                if (fB != 0.0f) {
                    return 0.0f;
                }
                float f4 = this.y0[i];
                float f5 = this.z0[i];
                float f6 = this.A0[i];
                float f7 = f4 * f3;
                return fB > 0.0f ? b(fB * f7, f5, f6) : -b((-fB) * f7, f5, f6);
            }
            interpolation = accelerateInterpolator.getInterpolation(fC);
        }
        fB = b(interpolation, -1.0f, 1.0f);
        if (fB != 0.0f) {
        }
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
    */
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        if (this.F0) {
            int actionMasked = motionEvent.getActionMasked();
            int i2 = 1;
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                    }
                }
                d();
                return false;
            }
            this.D0 = true;
            this.B0 = false;
            float x = motionEvent.getX();
            float width = view.getWidth();
            jy0 jy0Var = this.z;
            float fA = a(x, width, jy0Var.getWidth(), 0);
            float fA2 = a(motionEvent.getY(), view.getHeight(), jy0Var.getHeight(), 1);
            hg hgVar = this.b;
            hgVar.c = fA;
            hgVar.d = fA2;
            if (!this.E0 && e()) {
                f33 f33Var = this.A;
                if (f33Var == null) {
                    f33Var = new f33(i2, this);
                    this.A = f33Var;
                }
                this.E0 = true;
                this.C0 = true;
                if (this.B0 || (i = this.Z) <= 0) {
                    f33Var.run();
                } else {
                    long j = i;
                    WeakHashMap weakHashMap = wp4.a;
                    jy0Var.postOnAnimationDelayed(f33Var, j);
                }
                this.B0 = true;
            }
        }
        return false;
    }
}
