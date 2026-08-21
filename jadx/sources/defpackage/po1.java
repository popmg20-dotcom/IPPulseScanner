package defpackage;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.i;
import com.getsurfboard.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textfield.TextInputLayout;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class po1 extends i {
    public final r4 H0;
    public iv1 I0;
    public String J0;

    public po1() {
        r4 r4VarRegisterForActivityResult = registerForActivityResult(new n4(2), new jd(14, this));
        r4VarRegisterForActivityResult.getClass();
        this.H0 = r4VarRegisterForActivityResult;
    }

    public static void n(iv1 iv1Var) {
        Editable text;
        EditText editText = ((TextInputLayout) iv1Var.f).getEditText();
        String string = (editText == null || (text = editText.getText()) == null) ? null : text.toString();
        ko1 ko1Var = ko1.a;
        String string2 = ko1.b.getString(RtspHeaders.Values.URL, null);
        ((MaterialButton) iv1Var.X).setText(string2 != null && n12.c(string, string2) ? R.string.update : R.string.save);
    }

    @Override // androidx.fragment.app.i
    public final Dialog k() {
        EditText editText;
        final int i = 0;
        View viewInflate = getLayoutInflater().inflate(R.layout.dialog_geoip_config, (ViewGroup) null, false);
        int i2 = R.id.cancel;
        MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.cancel);
        if (materialButton != null) {
            i2 = R.id.edit_text;
            TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.edit_text);
            if (textInputLayout != null) {
                i2 = R.id.import_file;
                MaterialButton materialButton2 = (MaterialButton) vf2.l(viewInflate, R.id.import_file);
                if (materialButton2 != null) {
                    i2 = R.id.last_update;
                    TextView textView = (TextView) vf2.l(viewInflate, R.id.last_update);
                    if (textView != null) {
                        i2 = R.id.loading;
                        LoadingIndicator loadingIndicator = (LoadingIndicator) vf2.l(viewInflate, R.id.loading);
                        if (loadingIndicator != null) {
                            i2 = R.id.save;
                            MaterialButton materialButton3 = (MaterialButton) vf2.l(viewInflate, R.id.save);
                            if (materialButton3 != null) {
                                i2 = R.id.title;
                                if (((TextView) vf2.l(viewInflate, R.id.title)) != null) {
                                    ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate;
                                    iv1 iv1Var = new iv1(constraintLayout, materialButton, textInputLayout, materialButton2, textView, loadingIndicator, materialButton3);
                                    this.I0 = iv1Var;
                                    materialButton.setOnClickListener(new View.OnClickListener(this) { // from class: lo1
                                        public final /* synthetic */ po1 f;

                                        {
                                            this.f = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            int i3 = i;
                                            po1 po1Var = this.f;
                                            switch (i3) {
                                                case 0:
                                                    Dialog dialog = po1Var.C0;
                                                    if (dialog != null) {
                                                        dialog.cancel();
                                                    }
                                                    break;
                                                default:
                                                    po1Var.H0.a(new String[]{"*/*"});
                                                    break;
                                            }
                                        }
                                    });
                                    materialButton3.setOnClickListener(new kd(3, iv1Var, this));
                                    final int i3 = 1;
                                    materialButton2.setOnClickListener(new View.OnClickListener(this) { // from class: lo1
                                        public final /* synthetic */ po1 f;

                                        {
                                            this.f = this;
                                        }

                                        @Override // android.view.View.OnClickListener
                                        public final void onClick(View view) {
                                            int i32 = i3;
                                            po1 po1Var = this.f;
                                            switch (i32) {
                                                case 0:
                                                    Dialog dialog = po1Var.C0;
                                                    if (dialog != null) {
                                                        dialog.cancel();
                                                    }
                                                    break;
                                                default:
                                                    po1Var.H0.a(new String[]{"*/*"});
                                                    break;
                                            }
                                        }
                                    });
                                    EditText editText2 = textInputLayout.getEditText();
                                    if (editText2 != null) {
                                        editText2.addTextChangedListener(new ri(i3, this, iv1Var));
                                    }
                                    ko1 ko1Var = ko1.a;
                                    File file = ko1.e;
                                    Long lValueOf = file.exists() ? Long.valueOf(file.lastModified()) : null;
                                    if (lValueOf != null) {
                                        long jLongValue = lValueOf.longValue();
                                        textView.setVisibility(0);
                                        textView.setText(getString(R.string.last_modified_template, DateUtils.getRelativeTimeSpanString(jLongValue)));
                                    }
                                    SharedPreferences sharedPreferences = ko1.b;
                                    String string = sharedPreferences.getString(RtspHeaders.Values.URL, null);
                                    String string2 = sharedPreferences.getString("file_name", null);
                                    if (string2 != null) {
                                        EditText editText3 = textInputLayout.getEditText();
                                        if (editText3 != null) {
                                            editText3.setText(string2);
                                        }
                                    } else if (string != null && (editText = textInputLayout.getEditText()) != null) {
                                        editText.setText(string);
                                    }
                                    n(iv1Var);
                                    wh2 wh2Var = new wh2(requireContext());
                                    wh2Var.y(constraintLayout);
                                    return wh2Var.h();
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        return null;
    }
}
