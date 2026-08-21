package defpackage;

import android.app.Dialog;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.fragment.app.i;
import com.getsurfboard.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class iz1 extends i {
    @Override // androidx.fragment.app.i
    public final Dialog k() {
        Editable text;
        EditText editText;
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_import_profile_url, (ViewGroup) null, false);
        TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.edit);
        if (textInputLayout == null) {
            zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(R.id.edit)));
            return null;
        }
        FrameLayout frameLayout = (FrameLayout) viewInflate;
        cp1 cp1Var = new cp1(frameLayout, textInputLayout);
        CharSequence charSequenceO = co4.O();
        if (charSequenceO != null) {
            CharSequence charSequenceU0 = p44.U0(charSequenceO);
            if (new gn4(yr2.e).a(charSequenceU0.toString()) && (editText = textInputLayout.getEditText()) != null) {
                editText.setText(charSequenceU0);
            }
        }
        wh2 wh2Var = new wh2(requireContext());
        wh2Var.x(R.string.import_from_url);
        wh2Var.y(frameLayout);
        wh2Var.u(R.string.cancel, new ph0(2));
        wh2Var.w(R.string.import_text, new li(5, cp1Var, this));
        u6 u6VarH = wh2Var.h();
        EditText editText2 = textInputLayout.getEditText();
        if (editText2 != null && (text = editText2.getText()) != null && text.length() == 0) {
            Window window = u6VarH.getWindow();
            if (window != null) {
                window.setSoftInputMode(4);
            }
            textInputLayout.requestFocus();
        }
        return u6VarH;
    }
}
