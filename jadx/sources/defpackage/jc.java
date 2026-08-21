package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import io.sentry.android.core.cache.a;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class jc {
    public final TextView a;
    public cb0 b;
    public cb0 c;
    public cb0 d;
    public cb0 e;
    public cb0 f;
    public cb0 g;
    public cb0 h;
    public final rc i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    public jc(TextView textView) {
        this.a = textView;
        this.i = new rc(textView);
    }

    public static cb0 c(Context context, db dbVar, int i) {
        ColorStateList colorStateListI;
        synchronized (dbVar) {
            colorStateListI = dbVar.a.i(context, i);
        }
        if (colorStateListI == null) {
            return null;
        }
        cb0 cb0Var = new cb0();
        cb0Var.b = true;
        cb0Var.c = colorStateListI;
        return cb0Var;
    }

    public static void h(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 || inputConnection == null) {
            return;
        }
        CharSequence text = textView.getText();
        if (i >= 30) {
            j2.m(editorInfo, text);
            return;
        }
        text.getClass();
        if (i >= 30) {
            j2.m(editorInfo, text);
            return;
        }
        int i2 = editorInfo.initialSelStart;
        int i3 = editorInfo.initialSelEnd;
        int i4 = i2 > i3 ? i3 : i2;
        if (i2 <= i3) {
            i2 = i3;
        }
        int length = text.length();
        if (i4 < 0 || i2 > length) {
            e11.c(editorInfo, null, 0, 0);
            return;
        }
        int i5 = editorInfo.inputType & 4095;
        if (i5 == 129 || i5 == 225 || i5 == 18) {
            e11.c(editorInfo, null, 0, 0);
            return;
        }
        if (length <= 2048) {
            e11.c(editorInfo, text, i4, i2);
            return;
        }
        int i6 = i2 - i4;
        int i7 = i6 > 1024 ? 0 : i6;
        int i8 = 2048 - i7;
        int iMin = Math.min(text.length() - i2, i8 - Math.min(i4, (int) (((double) i8) * 0.8d)));
        int iMin2 = Math.min(i4, i8 - iMin);
        int i9 = i4 - iMin2;
        if (Character.isLowSurrogate(text.charAt(i9))) {
            i9++;
            iMin2--;
        }
        if (Character.isHighSurrogate(text.charAt((i2 + iMin) - 1))) {
            iMin--;
        }
        int i10 = iMin2 + i7;
        e11.c(editorInfo, i7 != i6 ? TextUtils.concat(text.subSequence(i9, i9 + iMin2), text.subSequence(i2, iMin + i2)) : text.subSequence(i9, i10 + iMin + i9), iMin2, i10);
    }

    public final void a(Drawable drawable, cb0 cb0Var) {
        if (drawable == null || cb0Var == null) {
            return;
        }
        int[] drawableState = this.a.getDrawableState();
        PorterDuff.Mode mode = db.b;
        ck3.o(drawable, cb0Var, drawableState);
    }

    public final void b() {
        cb0 cb0Var = this.b;
        TextView textView = this.a;
        if (cb0Var != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public final ColorStateList d() {
        cb0 cb0Var = this.h;
        if (cb0Var != null) {
            return (ColorStateList) cb0Var.c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        cb0 cb0Var = this.h;
        if (cb0Var != null) {
            return (PorterDuff.Mode) cb0Var.d;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:244:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:259:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r25, int r26) {
        /*
            Method dump skipped, instruction units count: 1037
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.jc.f(android.util.AttributeSet, int):void");
    }

    public final void g(Context context, int i) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, cd3.x);
        n02 n02Var = new n02(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        n(context, n02Var);
        if (Build.VERSION.SDK_INT >= 26 && typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            hc.d(textView, string);
        }
        n02Var.K();
        Typeface typeface = this.l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.j);
        }
    }

    public final void i(int i, int i2, int i3, int i4) {
        rc rcVar = this.i;
        if (rcVar.j()) {
            DisplayMetrics displayMetrics = rcVar.j.getResources().getDisplayMetrics();
            rcVar.k(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (rcVar.h()) {
                rcVar.a();
            }
        }
    }

    public final void j(int[] iArr, int i) {
        rc rcVar = this.i;
        if (rcVar.j()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = rcVar.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                rcVar.f = rc.b(iArrCopyOf);
                if (!rcVar.i()) {
                    a.c(Arrays.toString(iArr), "None of the preset sizes is valid: ");
                    return;
                }
            } else {
                rcVar.g = false;
            }
            if (rcVar.h()) {
                rcVar.a();
            }
        }
    }

    public final void k(int i) {
        rc rcVar = this.i;
        if (rcVar.j()) {
            if (i == 0) {
                rcVar.a = 0;
                rcVar.d = -1.0f;
                rcVar.e = -1.0f;
                rcVar.c = -1.0f;
                rcVar.f = new int[0];
                rcVar.b = false;
                return;
            }
            if (i != 1) {
                xe.k(dw2.A(i, "Unknown auto-size text type: "));
                return;
            }
            DisplayMetrics displayMetrics = rcVar.j.getResources().getDisplayMetrics();
            rcVar.k(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (rcVar.h()) {
                rcVar.a();
            }
        }
    }

    public final void l(ColorStateList colorStateList) {
        cb0 cb0Var = this.h;
        if (cb0Var == null) {
            cb0Var = new cb0();
            this.h = cb0Var;
        }
        cb0 cb0Var2 = cb0Var;
        cb0Var.c = colorStateList;
        cb0Var.b = colorStateList != null;
        this.b = cb0Var2;
        this.c = cb0Var2;
        this.d = cb0Var2;
        this.e = cb0Var2;
        this.f = cb0Var2;
        this.g = cb0Var2;
    }

    public final void m(PorterDuff.Mode mode) {
        cb0 cb0Var = this.h;
        if (cb0Var == null) {
            cb0Var = new cb0();
            this.h = cb0Var;
        }
        cb0 cb0Var2 = cb0Var;
        cb0Var.d = mode;
        cb0Var.a = mode != null;
        this.b = cb0Var2;
        this.c = cb0Var2;
        this.d = cb0Var2;
        this.e = cb0Var2;
        this.f = cb0Var2;
        this.g = cb0Var2;
    }

    public final void n(Context context, n02 n02Var) {
        String string;
        int i = this.j;
        TypedArray typedArray = (TypedArray) n02Var.z;
        this.j = typedArray.getInt(2, i);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int i3 = typedArray.getInt(11, -1);
            this.k = i3;
            if (i3 != -1) {
                this.j &= 2;
            }
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.m = false;
                int i4 = typedArray.getInt(1, 1);
                if (i4 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (i4 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = typedArray.hasValue(12) ? 12 : 10;
        int i6 = this.k;
        int i7 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceR = n02Var.r(i5, this.j, new dc(this, i6, i7, new WeakReference(this.a)));
                if (typefaceR != null) {
                    if (i2 < 28 || this.k == -1) {
                        this.l = typefaceR;
                    } else {
                        this.l = ic.a(Typeface.create(typefaceR, 0), this.k, (this.j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (string = typedArray.getString(i5)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.k == -1) {
            this.l = Typeface.create(string, this.j);
        } else {
            this.l = ic.a(Typeface.create(string, 0), this.k, (this.j & 2) != 0);
        }
    }
}
