package defpackage;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.i;
import com.getsurfboard.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qo1 extends i {
    @Override // androidx.fragment.app.i
    public final Dialog k() {
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_geoip_query, (ViewGroup) null, false);
        int i = R.id.close;
        MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.close);
        if (materialButton != null) {
            i = R.id.edit_text;
            TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.edit_text);
            if (textInputLayout != null) {
                i = R.id.title;
                if (((TextView) vf2.l(viewInflate, R.id.title)) != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                    zf2 zf2Var = new zf2(constraintLayout, materialButton, textInputLayout);
                    materialButton.setOnClickListener(new mk(11, this));
                    EditText editText = textInputLayout.getEditText();
                    if (editText != null) {
                        editText.addTextChangedListener(new ri(2, zf2Var, this));
                    }
                    wh2 wh2Var = new wh2(requireContext());
                    wh2Var.y(constraintLayout);
                    return wh2Var.h();
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }
}
