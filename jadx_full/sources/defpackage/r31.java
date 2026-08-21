package defpackage;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r31 implements InputFilter {
    public final TextView a;
    public q31 b;

    public r31(TextView textView) {
        this.a = textView;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
    
        if (r1 != 3) goto L27;
     */
    @Override // android.text.InputFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        TextView textView = this.a;
        if (!textView.isInEditMode()) {
            int iB = k31.a().b();
            if (iB != 0) {
                if (iB == 1) {
                    if ((i4 != 0 || i3 != 0 || spanned.length() != 0 || charSequence != textView.getText()) && charSequence != null) {
                        if (i != 0 || i2 != charSequence.length()) {
                            charSequence = charSequence.subSequence(i, i2);
                        }
                        return k31.a().e(0, charSequence.length(), charSequence);
                    }
                }
            }
            k31 k31VarA = k31.a();
            q31 q31Var = this.b;
            if (q31Var == null) {
                q31Var = new q31(textView, this);
                this.b = q31Var;
            }
            k31VarA.f(q31Var);
            return charSequence;
        }
        return charSequence;
    }
}
