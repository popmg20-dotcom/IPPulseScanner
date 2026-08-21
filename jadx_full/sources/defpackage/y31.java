package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class y31 implements TextWatcher {
    public final EditText b;
    public x31 f;
    public boolean z = true;

    public y31(EditText editText) {
        this.b = editText;
    }

    public static void a(EditText editText, int i) {
        int length;
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            k31 k31VarA = k31.a();
            if (editableText == null) {
                length = 0;
            } else {
                k31VarA.getClass();
                length = editableText.length();
            }
            k31VarA.e(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) throws Throwable {
        EditText editText = this.b;
        if (editText.isInEditMode() || !this.z || k31.k == null || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iB = k31.a().b();
        if (iB != 0) {
            if (iB == 1) {
                k31.a().e(i, i3 + i, (Spannable) charSequence);
                return;
            } else if (iB != 3) {
                return;
            }
        }
        k31 k31VarA = k31.a();
        x31 x31Var = this.f;
        if (x31Var == null) {
            x31Var = new x31(editText);
            this.f = x31Var;
        }
        k31VarA.f(x31Var);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
