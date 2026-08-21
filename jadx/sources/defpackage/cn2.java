package defpackage;

import android.os.Bundle;
import androidx.preference.MultiSelectListPreference;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class cn2 extends e33 {
    public final HashSet P0 = new HashSet();
    public boolean Q0;
    public CharSequence[] R0;
    public CharSequence[] S0;

    @Override // defpackage.e33, androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashSet hashSet = this.P0;
        if (bundle != null) {
            hashSet.clear();
            hashSet.addAll(bundle.getStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values"));
            this.Q0 = bundle.getBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", false);
            this.R0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries");
            this.S0 = bundle.getCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues");
            return;
        }
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) n();
        CharSequence[] charSequenceArr = multiSelectListPreference.k1;
        CharSequence[] charSequenceArr2 = multiSelectListPreference.l1;
        if (charSequenceArr == null || charSequenceArr2 == null) {
            xe.q("MultiSelectListPreference requires an entries array and an entryValues array.");
            return;
        }
        hashSet.clear();
        hashSet.addAll(multiSelectListPreference.m1);
        this.Q0 = false;
        this.R0 = multiSelectListPreference.k1;
        this.S0 = charSequenceArr2;
    }

    @Override // defpackage.e33, androidx.fragment.app.i, androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putStringArrayList("MultiSelectListPreferenceDialogFragmentCompat.values", new ArrayList<>(this.P0));
        bundle.putBoolean("MultiSelectListPreferenceDialogFragmentCompat.changed", this.Q0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entries", this.R0);
        bundle.putCharSequenceArray("MultiSelectListPreferenceDialogFragmentCompat.entryValues", this.S0);
    }

    @Override // defpackage.e33
    public final void p(boolean z) {
        if (z && this.Q0) {
            MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) n();
            HashSet hashSet = this.P0;
            if (multiSelectListPreference.a(hashSet)) {
                multiSelectListPreference.A(hashSet);
            }
        }
        this.Q0 = false;
    }

    @Override // defpackage.e33
    public final void q(t6 t6Var) {
        int length = this.S0.length;
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            zArr[i] = this.P0.contains(this.S0[i].toString());
        }
        CharSequence[] charSequenceArr = this.R0;
        bn2 bn2Var = new bn2(this);
        p6 p6Var = (p6) t6Var.z;
        p6Var.r = charSequenceArr;
        p6Var.A = bn2Var;
        p6Var.w = zArr;
        p6Var.x = true;
    }
}
