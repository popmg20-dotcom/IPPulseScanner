package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t03 extends y41 {
    public final int e;
    public EditText f;
    public final mk g;

    public t03(x41 x41Var, int i) {
        super(x41Var);
        this.e = R.drawable.design_password_eye;
        this.g = new mk(15, this);
        if (i != 0) {
            this.e = i;
        }
    }

    @Override // defpackage.y41
    public final void b() {
        p();
    }

    @Override // defpackage.y41
    public final int c() {
        return R.string.password_toggle_content_description;
    }

    @Override // defpackage.y41
    public final int d() {
        return this.e;
    }

    @Override // defpackage.y41
    public final View.OnClickListener f() {
        return this.g;
    }

    @Override // defpackage.y41
    public final boolean j() {
        return true;
    }

    @Override // defpackage.y41
    public final boolean k() {
        EditText editText = this.f;
        return !(editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod));
    }

    @Override // defpackage.y41
    public final void l(EditText editText) {
        this.f = editText;
        p();
    }

    @Override // defpackage.y41
    public final void q() {
        EditText editText = this.f;
        if (editText != null) {
            if (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224) {
                this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }

    @Override // defpackage.y41
    public final void r() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
