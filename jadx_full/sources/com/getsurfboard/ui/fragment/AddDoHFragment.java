package com.getsurfboard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.fragment.app.p;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import com.getsurfboard.ui.fragment.AddDoHFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;
import defpackage.iv1;
import defpackage.p5;
import defpackage.tj4;
import defpackage.vf2;
import defpackage.zo2;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AddDoHFragment extends o {
    public iv1 b;
    public int f = -1;
    public p5 z = p5.b;

    public final void j(int i, String str) {
        this.f = i;
        p5 p5Var = p5.f;
        this.z = str != null ? p5Var : p5.b;
        if (isAdded()) {
            iv1 iv1Var = this.b;
            iv1Var.getClass();
            MaterialTextView materialTextView = (MaterialTextView) iv1Var.X;
            p5 p5Var2 = this.z;
            int i2 = R.string.add;
            materialTextView.setText(p5Var2 == p5Var ? R.string.edit : R.string.add);
            iv1 iv1Var2 = this.b;
            iv1Var2.getClass();
            MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) iv1Var2.A;
            if (str == null) {
                str = "";
            }
            materialAutoCompleteTextView.setText(str);
            iv1 iv1Var3 = this.b;
            iv1Var3.getClass();
            MaterialButton materialButton = (MaterialButton) iv1Var3.z;
            if (this.z == p5Var) {
                i2 = R.string.save;
            }
            materialButton.setText(i2);
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_add_doh, viewGroup, false);
        int i = R.id.btn_cancel;
        MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.btn_cancel);
        if (materialButton != null) {
            i = R.id.btn_save;
            MaterialButton materialButton2 = (MaterialButton) vf2.l(viewInflate, R.id.btn_save);
            if (materialButton2 != null) {
                i = R.id.edit_text;
                MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) vf2.l(viewInflate, R.id.edit_text);
                if (materialAutoCompleteTextView != null) {
                    i = R.id.text_input_layout;
                    if (((TextInputLayout) vf2.l(viewInflate, R.id.text_input_layout)) != null) {
                        i = R.id.title;
                        MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.title);
                        if (materialTextView != null) {
                            MaterialCardView materialCardView = (MaterialCardView) viewInflate;
                            this.b = new iv1(materialCardView, materialButton, materialButton2, materialAutoCompleteTextView, materialTextView, 16);
                            materialCardView.getClass();
                            return materialCardView;
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putInt("index", this.f);
        bundle.putString(RtspHeaders.Values.MODE, this.z.name());
        iv1 iv1Var = this.b;
        iv1Var.getClass();
        bundle.putString(RtspHeaders.Values.URL, ((MaterialAutoCompleteTextView) iv1Var.A).getText().toString());
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        if (bundle != null) {
            this.f = bundle.getInt("index", -1);
            String string = bundle.getString(RtspHeaders.Values.MODE, "NEW");
            string.getClass();
            this.z = p5.valueOf(string);
            j(this.f, bundle.getString(RtspHeaders.Values.URL));
        }
        iv1 iv1Var = this.b;
        iv1Var.getClass();
        ((MaterialAutoCompleteTextView) iv1Var.A).setAdapter(new ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, tj4.H() ? tj4.d : tj4.e));
        iv1 iv1Var2 = this.b;
        iv1Var2.getClass();
        final int i = 0;
        ((MaterialButton) iv1Var2.f).setOnClickListener(new View.OnClickListener(this) { // from class: o5
            public final /* synthetic */ AddDoHFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i2 = i;
                AddDoHFragment addDoHFragment = this.f;
                switch (i2) {
                    case 0:
                        p activity = addDoHFragment.getActivity();
                        OverrideDoHActivity overrideDoHActivity = activity instanceof OverrideDoHActivity ? (OverrideDoHActivity) activity : null;
                        if (overrideDoHActivity != null) {
                            overrideDoHActivity.z(null, false);
                            return;
                        }
                        return;
                    default:
                        iv1 iv1Var3 = addDoHFragment.b;
                        iv1Var3.getClass();
                        String string2 = p44.U0(((MaterialAutoCompleteTextView) iv1Var3.A).getText().toString()).toString();
                        if (p44.x0(string2)) {
                            return;
                        }
                        p activity2 = addDoHFragment.getActivity();
                        OverrideDoHActivity overrideDoHActivity2 = activity2 instanceof OverrideDoHActivity ? (OverrideDoHActivity) activity2 : null;
                        if (overrideDoHActivity2 != null) {
                            p5 p5Var = addDoHFragment.z;
                            int i3 = addDoHFragment.f;
                            p5Var.getClass();
                            try {
                                if (w44.j0(string2, "https://", false)) {
                                    if (n12.c(URI.create(string2).getScheme(), "https")) {
                                        if (p5Var == p5.b && overrideDoHActivity2.T0.contains(string2)) {
                                            uf4 uf4Var = overrideDoHActivity2.S0;
                                            if (uf4Var == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) uf4Var.f;
                                            coordinatorLayout.getClass();
                                            r25.R(coordinatorLayout, R.string.doh_server_existed, new Object[0]);
                                            return;
                                        }
                                        t6 t6Var = new t6(overrideDoHActivity2);
                                        p6 p6Var = (p6) t6Var.z;
                                        p6Var.v = null;
                                        p6Var.u = R.layout.dialog_verify_doh;
                                        p6Var.n = false;
                                        ji0.B(uf2.t(overrideDoHActivity2), null, null, new ux2(string2, System.currentTimeMillis(), t6Var.r(), p5Var, i3, overrideDoHActivity2, null), 3);
                                        return;
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            uf4 uf4Var2 = overrideDoHActivity2.S0;
                            if (uf4Var2 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) uf4Var2.f;
                            coordinatorLayout2.getClass();
                            r25.R(coordinatorLayout2, R.string.setting_override_doh_format_error, new Object[0]);
                            return;
                        }
                        return;
                }
            }
        });
        iv1 iv1Var3 = this.b;
        iv1Var3.getClass();
        final int i2 = 1;
        ((MaterialButton) iv1Var3.z).setOnClickListener(new View.OnClickListener(this) { // from class: o5
            public final /* synthetic */ AddDoHFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                int i22 = i2;
                AddDoHFragment addDoHFragment = this.f;
                switch (i22) {
                    case 0:
                        p activity = addDoHFragment.getActivity();
                        OverrideDoHActivity overrideDoHActivity = activity instanceof OverrideDoHActivity ? (OverrideDoHActivity) activity : null;
                        if (overrideDoHActivity != null) {
                            overrideDoHActivity.z(null, false);
                            return;
                        }
                        return;
                    default:
                        iv1 iv1Var32 = addDoHFragment.b;
                        iv1Var32.getClass();
                        String string2 = p44.U0(((MaterialAutoCompleteTextView) iv1Var32.A).getText().toString()).toString();
                        if (p44.x0(string2)) {
                            return;
                        }
                        p activity2 = addDoHFragment.getActivity();
                        OverrideDoHActivity overrideDoHActivity2 = activity2 instanceof OverrideDoHActivity ? (OverrideDoHActivity) activity2 : null;
                        if (overrideDoHActivity2 != null) {
                            p5 p5Var = addDoHFragment.z;
                            int i3 = addDoHFragment.f;
                            p5Var.getClass();
                            try {
                                if (w44.j0(string2, "https://", false)) {
                                    if (n12.c(URI.create(string2).getScheme(), "https")) {
                                        if (p5Var == p5.b && overrideDoHActivity2.T0.contains(string2)) {
                                            uf4 uf4Var = overrideDoHActivity2.S0;
                                            if (uf4Var == null) {
                                                n12.T("binding");
                                                throw null;
                                            }
                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) uf4Var.f;
                                            coordinatorLayout.getClass();
                                            r25.R(coordinatorLayout, R.string.doh_server_existed, new Object[0]);
                                            return;
                                        }
                                        t6 t6Var = new t6(overrideDoHActivity2);
                                        p6 p6Var = (p6) t6Var.z;
                                        p6Var.v = null;
                                        p6Var.u = R.layout.dialog_verify_doh;
                                        p6Var.n = false;
                                        ji0.B(uf2.t(overrideDoHActivity2), null, null, new ux2(string2, System.currentTimeMillis(), t6Var.r(), p5Var, i3, overrideDoHActivity2, null), 3);
                                        return;
                                    }
                                }
                            } catch (Exception unused) {
                            }
                            uf4 uf4Var2 = overrideDoHActivity2.S0;
                            if (uf4Var2 == null) {
                                n12.T("binding");
                                throw null;
                            }
                            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) uf4Var2.f;
                            coordinatorLayout2.getClass();
                            r25.R(coordinatorLayout2, R.string.setting_override_doh_format_error, new Object[0]);
                            return;
                        }
                        return;
                }
            }
        });
    }
}
