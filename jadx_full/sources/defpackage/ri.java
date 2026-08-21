package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.EditText;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.fragment.settings.OverrideSettingsFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ri implements TextWatcher {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public ri(u6 u6Var, w7 w7Var) {
        this.b = 4;
        this.z = u6Var;
        this.f = w7Var;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) throws UnknownHostException {
        int i = this.b;
        Object obj = this.z;
        Object obj2 = this.f;
        switch (i) {
            case 1:
                po1 po1Var = (po1) obj2;
                iv1 iv1Var = (iv1) obj;
                MaterialButton materialButton = (MaterialButton) iv1Var.X;
                TextInputLayout textInputLayout = (TextInputLayout) iv1Var.f;
                String string = editable != null ? editable.toString() : null;
                if (string == null || string.length() == 0 || w44.j0(string, "https://", false) || w44.j0(string, "http://", false)) {
                    textInputLayout.setError(null);
                    materialButton.setEnabled(true);
                } else {
                    ko1 ko1Var = ko1.a;
                    if (string.equals(ko1.b.getString("file_name", null)) || string.equals(po1Var.J0)) {
                        textInputLayout.setError(null);
                        materialButton.setEnabled(true);
                    } else {
                        textInputLayout.setError(po1Var.getString(R.string.geoip_database_url_format_error));
                        materialButton.setEnabled(false);
                    }
                }
                if (!n12.c(string, po1Var.J0)) {
                    po1Var.J0 = null;
                }
                po1.n(iv1Var);
                break;
            case 2:
                qo1 qo1Var = (qo1) obj;
                TextInputLayout textInputLayout2 = (TextInputLayout) ((zf2) obj2).f;
                String string2 = editable != null ? editable.toString() : null;
                if (string2 == null || string2.length() == 0) {
                    textInputLayout2.setError(null);
                    textInputLayout2.setHelperText(null);
                } else if (!xz1.b(string2)) {
                    textInputLayout2.setError(qo1Var.getString(R.string.invalid_ip_format));
                    textInputLayout2.setHelperText(null);
                } else {
                    textInputLayout2.setError(null);
                    InetAddress byName = InetAddress.getByName(string2);
                    zm1 zm1Var = an1.a;
                    byName.getClass();
                    String strD = zm1Var.d(byName);
                    if (strD != null) {
                        textInputLayout2.setHelperText(qo1Var.getString(R.string.ip_location_template, ha0.o(strD, " ", ji0.g(strD))));
                    } else {
                        textInputLayout2.setHelperText(qo1Var.getString(R.string.unknown_address));
                    }
                }
                break;
            case 3:
                OverrideSettingsFragment overrideSettingsFragment = (OverrideSettingsFragment) obj2;
                EditText editText = (EditText) obj;
                if (!overrideSettingsFragment.validatePortRange(editable)) {
                    ViewParent parent = editText.getParent().getParent();
                    parent.getClass();
                    ((TextInputLayout) parent).setError(overrideSettingsFragment.getString(R.string.setting_override_lan_share_port_hint));
                } else {
                    ViewParent parent2 = editText.getParent().getParent();
                    parent2.getClass();
                    ((TextInputLayout) parent2).setError("");
                }
                break;
            case 4:
                TextInputLayout textInputLayout3 = (TextInputLayout) ((w7) obj2).f;
                s6 s6Var = ((u6) obj).Z;
                if (editable != null && p44.x0(editable)) {
                    s6Var.j.setEnabled(false);
                } else if (editable != null && p44.p0(editable, '/')) {
                    textInputLayout3.setError(ContextUtilsKt.k(R.string.slash_not_allowed_in_profile_name));
                    s6Var.j.setEnabled(false);
                } else {
                    e1 e1Var = d73.a;
                    if (!d73.g(String.valueOf(editable)).exists()) {
                        textInputLayout3.setErrorEnabled(false);
                        s6Var.j.setEnabled(true);
                    } else {
                        textInputLayout3.setError(ContextUtilsKt.k(R.string.profile_name_existed));
                        s6Var.j.setEnabled(false);
                    }
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int i4 = this.b;
        Object obj = this.f;
        Object obj2 = this.z;
        switch (i4) {
            case 0:
                eg0 eg0Var = (eg0) obj;
                ((TextInputLayout) eg0Var.z).setError(null);
                Button button = ((u6) obj2).Z.j;
                Editable text = ((TextInputEditText) eg0Var.f).getText();
                button.setEnabled(!(text == null || text.length() == 0));
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            default:
                m31.c((u6) obj2, (Set) obj);
                break;
        }
    }

    public /* synthetic */ ri(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    public ri(m31 m31Var, u6 u6Var, Set set) {
        this.b = 5;
        this.z = u6Var;
        this.f = set;
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void d(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void e(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void f(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void g(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void h(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void i(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void j(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void k(int i, int i2, int i3, CharSequence charSequence) {
    }

    private final void l(int i, int i2, int i3, CharSequence charSequence) {
    }
}
