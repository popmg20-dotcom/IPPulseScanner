package defpackage;

import android.R;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.preference.EditTextPreference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class n01 extends e33 {
    public EditText P0;
    public CharSequence Q0;
    public final f33 R0 = new f33(8, this);
    public long S0 = -1;

    @Override // defpackage.e33
    public final void o(View view) {
        super.o(view);
        EditText editText = (EditText) view.findViewById(R.id.edit);
        this.P0 = editText;
        if (editText == null) {
            xe.q("Dialog view must contain an EditText with id @android:id/edit");
            return;
        }
        editText.requestFocus();
        this.P0.setText(this.Q0);
        EditText editText2 = this.P0;
        editText2.setSelection(editText2.getText().length());
        if (((EditTextPreference) n()).l1 != null) {
            ((EditTextPreference) n()).l1.a(this.P0);
        }
    }

    @Override // defpackage.e33, androidx.fragment.app.i, androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.Q0 = ((EditTextPreference) n()).k1;
        } else {
            this.Q0 = bundle.getCharSequence("EditTextPreferenceDialogFragment.text");
        }
    }

    @Override // defpackage.e33, androidx.fragment.app.i, androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("EditTextPreferenceDialogFragment.text", this.Q0);
    }

    @Override // defpackage.e33
    public final void p(boolean z) {
        if (z) {
            String string = this.P0.getText().toString();
            EditTextPreference editTextPreference = (EditTextPreference) n();
            if (editTextPreference.a(string)) {
                editTextPreference.A(string);
            }
        }
    }

    public final void r() {
        long j = this.S0;
        if (j == -1 || j + 1000 <= SystemClock.currentThreadTimeMillis()) {
            return;
        }
        EditText editText = this.P0;
        if (editText == null || !editText.isFocused()) {
            this.S0 = -1L;
            return;
        }
        if (((InputMethodManager) this.P0.getContext().getSystemService("input_method")).showSoftInput(this.P0, 0)) {
            this.S0 = -1L;
            return;
        }
        EditText editText2 = this.P0;
        f33 f33Var = this.R0;
        editText2.removeCallbacks(f33Var);
        this.P0.postDelayed(f33Var, 50L);
    }
}
