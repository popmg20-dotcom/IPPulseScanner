package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            boolean r0 = r3.e1
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r3.f1
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r3.f1
            r4.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r3.e1
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.g1
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.g1
            r4.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.g()
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L3e
            r4.setText(r3)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r3 = r4.getVisibility()
            if (r1 == r3) goto L4c
            r4.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.B(android.view.View):void");
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
