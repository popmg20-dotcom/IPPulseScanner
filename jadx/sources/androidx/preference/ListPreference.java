package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.jc2;
import defpackage.l72;
import defpackage.t60;
import defpackage.y23;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ListPreference extends DialogPreference {
    public CharSequence[] k1;
    public CharSequence[] l1;
    public String m1;
    public String n1;
    public boolean o1;

    public ListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.e, i, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.k1 = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.l1 = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        if (typedArrayObtainStyledAttributes.getBoolean(4, typedArrayObtainStyledAttributes.getBoolean(4, false))) {
            t60 t60Var = t60.B0;
            if (t60Var == null) {
                t60Var = new t60();
                t60.B0 = t60Var;
            }
            this.c1 = t60Var;
            i();
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, ad3.g, i, 0);
        String string = typedArrayObtainStyledAttributes2.getString(33);
        this.n1 = string == null ? typedArrayObtainStyledAttributes2.getString(7) : string;
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final int A(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.l1) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.l1[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public void B(CharSequence[] charSequenceArr) {
        this.k1 = charSequenceArr;
    }

    @Override // androidx.preference.Preference
    public final CharSequence g() {
        CharSequence[] charSequenceArr;
        y23 y23Var = this.c1;
        if (y23Var != null) {
            return y23Var.e(this);
        }
        int iA = A(this.m1);
        CharSequence charSequence = (iA < 0 || (charSequenceArr = this.k1) == null) ? null : charSequenceArr[iA];
        CharSequence charSequenceG = super.g();
        String str = this.n1;
        if (str != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            String str2 = String.format(str, charSequence);
            if (!TextUtils.equals(str2, charSequenceG)) {
                a1.n("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceG;
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(jc2.class)) {
            super.q(parcelable);
            return;
        }
        jc2 jc2Var = (jc2) parcelable;
        super.q(jc2Var.getSuperState());
        setValue(jc2Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        super.r();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.I0) {
            return absSavedState;
        }
        jc2 jc2Var = new jc2();
        jc2Var.b = this.m1;
        return jc2Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        setValue(f((String) obj));
    }

    public final void setValue(String str) {
        boolean zEquals = TextUtils.equals(this.m1, str);
        if (zEquals && this.o1) {
            return;
        }
        this.m1 = str;
        this.o1 = true;
        u(str);
        if (zEquals) {
            return;
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final void w(CharSequence charSequence) {
        super.w(charSequence);
        if (charSequence == null) {
            this.n1 = null;
        } else {
            this.n1 = charSequence.toString();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, l72.p(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
