package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class wb4 implements TextWatcher {
    public int b;
    public final /* synthetic */ EditText f;
    public final /* synthetic */ TextInputLayout z;

    public wb4(TextInputLayout textInputLayout, EditText editText) {
        this.z = textInputLayout;
        this.f = editText;
        this.b = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.z;
        textInputLayout.w(!textInputLayout.S1, false);
        if (textInputLayout.F0) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.N0) {
            textInputLayout.x(editable);
        }
        EditText editText = this.f;
        int lineCount = editText.getLineCount();
        int i = this.b;
        if (lineCount != i) {
            if (lineCount < i) {
                int minimumHeight = editText.getMinimumHeight();
                int i2 = textInputLayout.L1;
                if (minimumHeight != i2) {
                    editText.setMinimumHeight(i2);
                }
            }
            this.b = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
