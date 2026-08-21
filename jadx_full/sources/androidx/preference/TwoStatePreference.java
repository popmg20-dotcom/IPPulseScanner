package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import android.widget.TextView;
import defpackage.di4;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean e1;
    public CharSequence f1;
    public CharSequence g1;
    public boolean h1;
    public boolean i1;

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public final void A(boolean z) {
        boolean z2 = this.e1 != z;
        if (z2 || !this.h1) {
            this.e1 = z;
            this.h1 = true;
            if (z()) {
                boolean z3 = !z;
                boolean z4 = z();
                String str = this.C0;
                if (z4) {
                    z3 = this.f.c().getBoolean(str, z3);
                }
                if (z != z3) {
                    SharedPreferences.Editor editorA = this.f.a();
                    editorA.putBoolean(str, z);
                    if (!this.f.e) {
                        editorA.apply();
                    }
                }
            }
            if (z2) {
                j(y());
                i();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void B(View view) {
        boolean z;
        int i;
        if (!(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        if (this.e1 && !TextUtils.isEmpty(this.f1)) {
            textView.setText(this.f1);
        } else {
            if (this.e1 || TextUtils.isEmpty(this.g1)) {
                z = true;
                if (z) {
                    CharSequence charSequenceG = g();
                    if (!TextUtils.isEmpty(charSequenceG)) {
                        textView.setText(charSequenceG);
                        z = false;
                    }
                }
                i = z ? 8 : 0;
                if (i == textView.getVisibility()) {
                    textView.setVisibility(i);
                    return;
                }
                return;
            }
            textView.setText(this.g1);
        }
        z = false;
        if (z) {
        }
        if (z) {
        }
        if (i == textView.getVisibility()) {
        }
    }

    @Override // androidx.preference.Preference
    public final void n() {
        boolean z = !this.e1;
        if (a(Boolean.valueOf(z))) {
            A(z);
        }
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(di4.class)) {
            super.q(parcelable);
            return;
        }
        di4 di4Var = (di4) parcelable;
        super.q(di4Var.getSuperState());
        A(di4Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        super.r();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.I0) {
            return absSavedState;
        }
        di4 di4Var = new di4();
        di4Var.b = this.e1;
        return di4Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (z()) {
            zBooleanValue = this.f.c().getBoolean(this.C0, zBooleanValue);
        }
        A(zBooleanValue);
    }

    @Override // androidx.preference.Preference
    public final boolean y() {
        boolean z = this.i1;
        boolean z2 = this.e1;
        if (!z) {
            z2 = !z2;
        }
        return z2 || super.y();
    }
}
