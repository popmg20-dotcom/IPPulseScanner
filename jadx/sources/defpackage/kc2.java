package defpackage;

import android.os.Bundle;
import androidx.preference.ListPreference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class kc2 extends e33 {
    public int P0;
    public CharSequence[] Q0;
    public CharSequence[] R0;

    @Override // defpackage.e33, androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.P0 = bundle.getInt("ListPreferenceDialogFragment.index", 0);
            this.Q0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entries");
            this.R0 = bundle.getCharSequenceArray("ListPreferenceDialogFragment.entryValues");
            return;
        }
        ListPreference listPreference = (ListPreference) n();
        if (listPreference.k1 == null || listPreference.l1 == null) {
            xe.q("ListPreference requires an entries array and an entryValues array.");
            return;
        }
        this.P0 = listPreference.A(listPreference.m1);
        this.Q0 = listPreference.k1;
        this.R0 = listPreference.l1;
    }

    @Override // defpackage.e33, androidx.fragment.app.i, androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("ListPreferenceDialogFragment.index", this.P0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entries", this.Q0);
        bundle.putCharSequenceArray("ListPreferenceDialogFragment.entryValues", this.R0);
    }

    @Override // defpackage.e33
    public final void p(boolean z) {
        int i;
        if (!z || (i = this.P0) < 0) {
            return;
        }
        String string = this.R0[i].toString();
        ListPreference listPreference = (ListPreference) n();
        if (listPreference.a(string)) {
            listPreference.setValue(string);
        }
    }

    @Override // defpackage.e33
    public final void q(t6 t6Var) {
        CharSequence[] charSequenceArr = this.Q0;
        int i = this.P0;
        uh0 uh0Var = new uh0(1, this);
        p6 p6Var = (p6) t6Var.z;
        p6Var.r = charSequenceArr;
        p6Var.t = uh0Var;
        p6Var.z = i;
        p6Var.y = true;
        t6Var.q(null, null);
    }
}
