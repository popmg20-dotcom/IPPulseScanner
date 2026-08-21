package defpackage;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class v41 {
    public final /* synthetic */ x41 a;

    public v41(x41 x41Var) {
        this.a = x41Var;
    }

    public final void a(TextInputLayout textInputLayout) {
        x41 x41Var = this.a;
        u41 u41Var = x41Var.P0;
        if (x41Var.M0 == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = x41Var.M0;
        if (editText != null) {
            editText.removeTextChangedListener(u41Var);
            if (x41Var.M0.getOnFocusChangeListener() == x41Var.a().e()) {
                x41Var.M0.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        x41Var.M0 = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(u41Var);
        }
        x41Var.a().l(x41Var.M0);
        x41Var.j(x41Var.a());
    }
}
