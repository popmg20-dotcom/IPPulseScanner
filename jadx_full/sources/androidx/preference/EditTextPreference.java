package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.l01;
import defpackage.l72;
import defpackage.m01;
import defpackage.wl3;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public String k1;
    public l01 l1;

    /* JADX WARN: Illegal instructions before constructor call */
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        int iP = l72.p(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle);
        super(context, attributeSet, iP);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.d, iP, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(0, typedArrayObtainStyledAttributes.getBoolean(0, false))) {
            wl3 wl3Var = wl3.A0;
            if (wl3Var == null) {
                wl3Var = new wl3(15);
                wl3.A0 = wl3Var;
            }
            this.c1 = wl3Var;
            i();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(String str) {
        boolean zY = y();
        this.k1 = str;
        u(str);
        boolean zY2 = y();
        if (zY2 != zY) {
            j(zY2);
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(m01.class)) {
            super.q(parcelable);
            return;
        }
        m01 m01Var = (m01) parcelable;
        super.q(m01Var.getSuperState());
        A(m01Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        super.r();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.I0) {
            return absSavedState;
        }
        m01 m01Var = new m01();
        m01Var.b = this.k1;
        return m01Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        A(f((String) obj));
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        return TextUtils.isEmpty(this.k1) || super.y();
    }
}
