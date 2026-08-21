package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class el {
    public int a;
    public int b;
    public float c;
    public boolean d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;

    public el(Context context, AttributeSet attributeSet, int i, int i2) {
        this.e = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        fx3.c(context, attributeSet, i, i2);
        int[] iArr = rc3.d;
        fx3.e(context, attributeSet, iArr, i, i2, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        this.a = l72.s(context, typedArrayObtainStyledAttributes, 10, dimensionPixelSize);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue != null) {
            int i3 = typedValuePeekValue.type;
            if (i3 == 5) {
                this.b = Math.min(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArrayObtainStyledAttributes.getResources().getDisplayMetrics()), this.a / 2);
                this.d = false;
            } else if (i3 == 6) {
                this.c = Math.min(typedValuePeekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.d = true;
            }
        }
        this.g = typedArrayObtainStyledAttributes.getInt(6, 0);
        this.h = typedArrayObtainStyledAttributes.getInt(1, 0);
        this.i = typedArrayObtainStyledAttributes.getDimensionPixelSize(4, 0);
        int iAbs = Math.abs(typedArrayObtainStyledAttributes.getDimensionPixelSize(15, 0));
        this.j = Math.abs(typedArrayObtainStyledAttributes.getDimensionPixelSize(16, iAbs));
        this.k = Math.abs(typedArrayObtainStyledAttributes.getDimensionPixelSize(17, iAbs));
        this.l = Math.abs(typedArrayObtainStyledAttributes.getDimensionPixelSize(11, 0));
        this.m = typedArrayObtainStyledAttributes.getDimensionPixelSize(14, 0);
        this.n = typedArrayObtainStyledAttributes.getFloat(2, 1.0f);
        this.o = typedArrayObtainStyledAttributes.getFloat(13, 0.1f);
        this.p = typedArrayObtainStyledAttributes.getFloat(12, 0.9f);
        if (!typedArrayObtainStyledAttributes.hasValue(3)) {
            this.e = new int[]{n12.z(context, R.attr.colorPrimary, -1)};
        } else if (typedArrayObtainStyledAttributes.peekValue(3).type != 1) {
            this.e = new int[]{typedArrayObtainStyledAttributes.getColor(3, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(typedArrayObtainStyledAttributes.getResourceId(3, -1));
            this.e = intArray;
            if (intArray.length == 0) {
                xe.k("indicatorColors cannot be empty when indicatorColor is not used.");
                throw null;
            }
        }
        if (typedArrayObtainStyledAttributes.hasValue(8)) {
            this.f = typedArrayObtainStyledAttributes.getColor(8, -1);
        } else {
            this.f = this.e[0];
            TypedArray typedArrayObtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
            float f = typedArrayObtainStyledAttributes2.getFloat(0, 0.2f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f = n12.n(this.f, (int) (f * 255.0f));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final int a() {
        return this.d ? (int) (this.a * this.c) : this.b;
    }

    public final boolean b(boolean z) {
        if (this.l <= 0) {
            return false;
        }
        if (z || this.k <= 0) {
            return z && this.j > 0;
        }
        return true;
    }

    public boolean c() {
        return this.d && this.c == 0.5f;
    }

    public void d() {
        if (this.i >= 0) {
            return;
        }
        xe.k("indicatorTrackGapSize must be >= 0.");
    }
}
