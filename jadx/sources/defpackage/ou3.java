package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ou3 implements nu3 {
    public static final mi3 m = new mi3(0.5f);
    public fx3 a = new cm3();
    public fx3 b = new cm3();
    public fx3 c = new cm3();
    public fx3 d = new cm3();
    public ye0 e = new a0(0.0f);
    public ye0 f = new a0(0.0f);
    public ye0 g = new a0(0.0f);
    public ye0 h = new a0(0.0f);
    public k01 i;
    public k01 j;
    public k01 k;
    public k01 l;

    public ou3() {
        int i = 0;
        this.i = new k01(i);
        this.j = new k01(i);
        this.k = new k01(i);
        this.l = new k01(i);
    }

    public static qy1 f(Context context, int i, int i2) {
        return g(context, i, i2, new a0(0.0f));
    }

    public static qy1 g(Context context, int i, int i2, ye0 ye0Var) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
        if (i2 != 0) {
            contextThemeWrapper.getTheme().applyStyle(i2, true);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(rc3.L);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(0, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(3, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(4, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(2, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(1, i3);
            ye0 ye0VarJ = j(typedArrayObtainStyledAttributes, 5, ye0Var);
            ye0 ye0VarJ2 = j(typedArrayObtainStyledAttributes, 8, ye0VarJ);
            ye0 ye0VarJ3 = j(typedArrayObtainStyledAttributes, 9, ye0VarJ);
            ye0 ye0VarJ4 = j(typedArrayObtainStyledAttributes, 7, ye0VarJ);
            ye0 ye0VarJ5 = j(typedArrayObtainStyledAttributes, 6, ye0VarJ);
            qy1 qy1Var = new qy1();
            qy1Var.a = uf2.k(i4);
            qy1Var.e = ye0VarJ2;
            qy1Var.b = uf2.k(i5);
            qy1Var.f = ye0VarJ3;
            qy1Var.c = uf2.k(i6);
            qy1Var.g = ye0VarJ4;
            qy1Var.d = uf2.k(i7);
            qy1Var.h = ye0VarJ5;
            return qy1Var;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static qy1 h(Context context, AttributeSet attributeSet, int i, int i2) {
        return i(context, attributeSet, i, i2, new a0(0.0f));
    }

    public static qy1 i(Context context, AttributeSet attributeSet, int i, int i2, ye0 ye0Var) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, rc3.z, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return g(context, resourceId, resourceId2, ye0Var);
    }

    public static ye0 j(TypedArray typedArray, int i, ye0 ye0Var) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue != null) {
            int i2 = typedValuePeekValue.type;
            if (i2 == 5) {
                return new a0(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new mi3(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return ye0Var;
    }

    @Override // defpackage.nu3
    public final ou3 a(float f) {
        qy1 qy1VarL = l();
        qy1VarL.e = new a0(f);
        qy1VarL.f = new a0(f);
        qy1VarL.g = new a0(f);
        qy1VarL.h = new a0(f);
        return qy1VarL.b();
    }

    @Override // defpackage.nu3
    public final ou3[] c() {
        return new ou3[]{this};
    }

    @Override // defpackage.nu3
    public final boolean e() {
        return false;
    }

    public final boolean k(RectF rectF) {
        boolean z = this.l.getClass().equals(k01.class) && this.j.getClass().equals(k01.class) && this.i.getClass().equals(k01.class) && this.k.getClass().equals(k01.class);
        float fA = this.e.a(rectF);
        return z && ((this.f.a(rectF) > fA ? 1 : (this.f.a(rectF) == fA ? 0 : -1)) == 0 && (this.h.a(rectF) > fA ? 1 : (this.h.a(rectF) == fA ? 0 : -1)) == 0 && (this.g.a(rectF) > fA ? 1 : (this.g.a(rectF) == fA ? 0 : -1)) == 0) && (this.b instanceof cm3) && (this.a instanceof cm3) && (this.c instanceof cm3) && (this.d instanceof cm3);
    }

    public final qy1 l() {
        qy1 qy1Var = new qy1();
        qy1Var.a = this.a;
        qy1Var.b = this.b;
        qy1Var.c = this.c;
        qy1Var.d = this.d;
        qy1Var.e = this.e;
        qy1Var.f = this.f;
        qy1Var.g = this.g;
        qy1Var.h = this.h;
        qy1Var.i = this.i;
        qy1Var.j = this.j;
        qy1Var.k = this.k;
        qy1Var.l = this.l;
        return qy1Var;
    }

    public final String toString() {
        return "[" + this.e + ", " + this.f + ", " + this.g + ", " + this.h + "]";
    }

    @Override // defpackage.nu3
    public final ou3 d() {
        return this;
    }

    @Override // defpackage.nu3
    public final ou3 b(int[] iArr) {
        return this;
    }
}
