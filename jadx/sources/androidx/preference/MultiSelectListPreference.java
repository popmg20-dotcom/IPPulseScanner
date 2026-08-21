package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import com.getsurfboard.R;
import defpackage.ad3;
import defpackage.an2;
import defpackage.l72;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class MultiSelectListPreference extends DialogPreference {
    public final CharSequence[] k1;
    public final CharSequence[] l1;
    public final HashSet m1;

    /* JADX WARN: Illegal instructions before constructor call */
    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        int iP = l72.p(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle);
        super(context, attributeSet, iP);
        this.m1 = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ad3.f, iP, 0);
        CharSequence[] textArray = typedArrayObtainStyledAttributes.getTextArray(2);
        this.k1 = textArray == null ? typedArrayObtainStyledAttributes.getTextArray(0) : textArray;
        CharSequence[] textArray2 = typedArrayObtainStyledAttributes.getTextArray(3);
        this.l1 = textArray2 == null ? typedArrayObtainStyledAttributes.getTextArray(1) : textArray2;
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void A(Set set) {
        HashSet hashSet = this.m1;
        hashSet.clear();
        hashSet.addAll(set);
        if (z()) {
            boolean z = z();
            String str = this.C0;
            if (!set.equals(z ? this.f.c().getStringSet(str, null) : null)) {
                SharedPreferences.Editor editorA = this.f.a();
                editorA.putStringSet(str, set);
                if (!this.f.e) {
                    editorA.apply();
                }
            }
        }
        i();
    }

    @Override // androidx.preference.Preference
    public final Object p(TypedArray typedArray, int i) {
        CharSequence[] textArray = typedArray.getTextArray(i);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    public final void q(Parcelable parcelable) {
        if (!parcelable.getClass().equals(an2.class)) {
            super.q(parcelable);
            return;
        }
        an2 an2Var = (an2) parcelable;
        super.q(an2Var.getSuperState());
        A(an2Var.b);
    }

    @Override // androidx.preference.Preference
    public final Parcelable r() {
        super.r();
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.I0) {
            return absSavedState;
        }
        an2 an2Var = new an2();
        an2Var.b = this.m1;
        return an2Var;
    }

    @Override // androidx.preference.Preference
    public final void s(Object obj) {
        Set<String> stringSet = (Set) obj;
        if (z()) {
            stringSet = this.f.c().getStringSet(this.C0, stringSet);
        }
        A(stringSet);
    }
}
