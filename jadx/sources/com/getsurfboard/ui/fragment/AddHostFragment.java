package com.getsurfboard.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.o;
import androidx.fragment.app.p;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.fragment.AddHostFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.co4;
import defpackage.ek0;
import defpackage.et1;
import defpackage.f70;
import defpackage.h4;
import defpackage.j51;
import defpackage.j80;
import defpackage.ls1;
import defpackage.n12;
import defpackage.oy3;
import defpackage.p44;
import defpackage.p95;
import defpackage.t5;
import defpackage.tj4;
import defpackage.u5;
import defpackage.v5;
import defpackage.vf2;
import defpackage.vs4;
import defpackage.w0;
import defpackage.w44;
import defpackage.ws4;
import defpackage.zo2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class AddHostFragment extends o {
    public h4 b;
    public ls1 f;

    public final void j() {
        ls1 ls1Var = this.f;
        u5 u5Var = u5.z;
        if (ls1Var == null) {
            ((MaterialAutoCompleteTextView) l().e).setText((CharSequence) getString(R.string.host_type_ip), false);
            o(u5Var);
            return;
        }
        String strF0 = ls1Var.z;
        EditText editText = ((TextInputLayout) l().a).getEditText();
        if (editText != null) {
            editText.setText(ls1Var.f);
        }
        if (w44.j0(strF0, "server:https://", false)) {
            u5Var = u5.X;
        } else if (w44.j0(strF0, "server:", false)) {
            u5Var = u5.A;
        }
        ((MaterialAutoCompleteTextView) l().e).setText((CharSequence) getString(u5Var.b), false);
        o(u5Var);
        int iOrdinal = u5Var.ordinal();
        if (iOrdinal == 2 || iOrdinal == 3) {
            strF0 = p44.F0(strF0, "server:");
        }
        m().setText(strF0);
    }

    public final void k(boolean z) {
        p activity = getActivity();
        if (activity == null || !(activity instanceof HostsListActivity)) {
            return;
        }
        HostsListActivity hostsListActivity = (HostsListActivity) activity;
        hostsListActivity.x(null, false);
        if (z) {
            if (co4.H()) {
                p95.C(R.string.restart_vpn_to_make_changes_take_effect, new Object[0]);
                return;
            }
            vs4 vs4Var = (vs4) ws4.c.d();
            if (vs4Var == null || !vs4Var.b) {
                return;
            }
            j80 j80Var = hostsListActivity.S0;
            if (j80Var == null) {
                n12.T("binding");
                throw null;
            }
            oy3 oy3VarG = oy3.g((CoordinatorLayout) j80Var.f, R.string.restart_vpn_to_make_changes_take_effect, 0);
            oy3VarG.i(R.string.restart, new et1(hostsListActivity, 3));
            oy3VarG.j();
        }
    }

    public final h4 l() {
        h4 h4Var = this.b;
        if (h4Var != null) {
            return h4Var;
        }
        n12.T("binding");
        throw null;
    }

    public final EditText m() {
        return ((TextInputLayout) l().g).getVisibility() == 0 ? (MaterialAutoCompleteTextView) l().h : (TextInputEditText) l().i;
    }

    public final TextInputLayout n() {
        return ((TextInputLayout) l().g).getVisibility() == 0 ? (TextInputLayout) l().g : (TextInputLayout) l().f;
    }

    public final void o(u5 u5Var) {
        boolean z = u5Var == u5.A || u5Var == u5.X;
        ((TextInputLayout) l().f).setVisibility(!z ? 0 : 8);
        ((TextInputLayout) l().g).setVisibility(z ? 0 : 8);
        n().setHint(getString(u5Var.f));
        m().setText("");
        n().setError(null);
        if (z) {
            int iOrdinal = u5Var.ordinal();
            ((MaterialAutoCompleteTextView) l().h).setAdapter(new ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, iOrdinal != 2 ? iOrdinal != 3 ? new String[0] : tj4.H() ? tj4.d : tj4.e : tj4.f));
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_add_host, viewGroup, false);
        int i = R.id.add_host_title;
        if (((TextView) vf2.l(viewInflate, R.id.add_host_title)) != null) {
            i = R.id.cancel;
            MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.cancel);
            if (materialButton != null) {
                i = R.id.host_key;
                TextInputLayout textInputLayout = (TextInputLayout) vf2.l(viewInflate, R.id.host_key);
                if (textInputLayout != null) {
                    i = R.id.host_type;
                    TextInputLayout textInputLayout2 = (TextInputLayout) vf2.l(viewInflate, R.id.host_type);
                    if (textInputLayout2 != null) {
                        i = R.id.host_type_input;
                        MaterialAutoCompleteTextView materialAutoCompleteTextView = (MaterialAutoCompleteTextView) vf2.l(viewInflate, R.id.host_type_input);
                        if (materialAutoCompleteTextView != null) {
                            i = R.id.host_value;
                            TextInputLayout textInputLayout3 = (TextInputLayout) vf2.l(viewInflate, R.id.host_value);
                            if (textInputLayout3 != null) {
                                i = R.id.host_value_container;
                                if (((FrameLayout) vf2.l(viewInflate, R.id.host_value_container)) != null) {
                                    i = R.id.host_value_dropdown;
                                    TextInputLayout textInputLayout4 = (TextInputLayout) vf2.l(viewInflate, R.id.host_value_dropdown);
                                    if (textInputLayout4 != null) {
                                        i = R.id.host_value_dropdown_input;
                                        MaterialAutoCompleteTextView materialAutoCompleteTextView2 = (MaterialAutoCompleteTextView) vf2.l(viewInflate, R.id.host_value_dropdown_input);
                                        if (materialAutoCompleteTextView2 != null) {
                                            i = R.id.host_value_input;
                                            TextInputEditText textInputEditText = (TextInputEditText) vf2.l(viewInflate, R.id.host_value_input);
                                            if (textInputEditText != null) {
                                                i = R.id.save;
                                                MaterialButton materialButton2 = (MaterialButton) vf2.l(viewInflate, R.id.save);
                                                if (materialButton2 != null) {
                                                    this.b = new h4((MaterialCardView) viewInflate, materialButton, textInputLayout, textInputLayout2, materialAutoCompleteTextView, textInputLayout3, textInputLayout4, materialAutoCompleteTextView2, textInputEditText, materialButton2);
                                                    MaterialCardView materialCardView = (MaterialCardView) l().b;
                                                    materialCardView.getClass();
                                                    return materialCardView;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putParcelable("host", this.f);
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        j51 j51Var = u5.Z;
        ArrayList arrayList = new ArrayList(f70.Q(10, j51Var));
        Iterator it = j51Var.iterator();
        while (true) {
            w0 w0Var = (w0) it;
            if (!w0Var.hasNext()) {
                break;
            } else {
                arrayList.add(getString(((u5) w0Var.next()).b));
            }
        }
        final int i = 0;
        String[] strArr = (String[]) arrayList.toArray(new String[0]);
        ((MaterialAutoCompleteTextView) l().e).setAdapter(new ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, strArr));
        ((MaterialAutoCompleteTextView) l().e).setText((CharSequence) strArr[0], false);
        ((MaterialAutoCompleteTextView) l().e).setOnItemClickListener(new t5(0, this, j51Var));
        ((MaterialButton) l().c).setOnClickListener(new View.OnClickListener(this) { // from class: s5
            public final /* synthetic */ AddHostFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Object next;
                int i2 = i;
                AddHostFragment addHostFragment = this.f;
                switch (i2) {
                    case 0:
                        addHostFragment.k(false);
                        break;
                    default:
                        EditText editText = ((TextInputLayout) addHostFragment.l().a).getEditText();
                        editText.getClass();
                        String string = editText.getText().toString();
                        String string2 = addHostFragment.m().getText().toString();
                        String string3 = ((MaterialAutoCompleteTextView) addHostFragment.l().e).getText().toString();
                        Iterator it2 = u5.Z.iterator();
                        while (true) {
                            w0 w0Var2 = (w0) it2;
                            if (w0Var2.hasNext()) {
                                next = w0Var2.next();
                                if (n12.c(addHostFragment.getString(((u5) next).b), string3)) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        u5 u5Var = (u5) next;
                        if (u5Var != null) {
                            int iOrdinal = u5Var.ordinal();
                            if (iOrdinal != 2) {
                                if (iOrdinal == 3) {
                                    string2 = ha0.n("server:", string2);
                                }
                            } else if (!w44.j0(string2, "server:", false)) {
                                string2 = "server:".concat(string2);
                            }
                        }
                        try {
                            List listL0 = p44.L0(string2, new String[]{","}, 6);
                            ArrayList arrayList2 = new ArrayList(f70.Q(10, listL0));
                            Iterator it3 = listL0.iterator();
                            while (it3.hasNext()) {
                                arrayList2.add(p44.U0((String) it3.next()).toString());
                            }
                            String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                            ye.g(string, (String[]) Arrays.copyOf(strArr2, strArr2.length), null, null, null);
                            os1 os1VarS = oj0.a.s();
                            ls1 ls1Var = addHostFragment.f;
                            ke0.r(os1VarS.a, false, true, new ms1(os1VarS, new ls1(string, ls1Var != null ? ls1Var.b : 0, string2), 0));
                            addHostFragment.k(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                            TextInputLayout textInputLayoutN = addHostFragment.n();
                            String message = e.getMessage();
                            if (message == null) {
                                message = addHostFragment.getString(R.string.unknown_error);
                                message.getClass();
                            }
                            textInputLayoutN.setError(message);
                        }
                        break;
                }
            }
        });
        EditText editText = ((TextInputLayout) l().a).getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new v5(this, 0));
        }
        final int i2 = 1;
        ((TextInputEditText) l().i).addTextChangedListener(new v5(this, 1));
        ((MaterialAutoCompleteTextView) l().h).addTextChangedListener(new v5(this, 2));
        ((MaterialButton) l().j).setOnClickListener(new View.OnClickListener(this) { // from class: s5
            public final /* synthetic */ AddHostFragment f;

            {
                this.f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Object next;
                int i22 = i2;
                AddHostFragment addHostFragment = this.f;
                switch (i22) {
                    case 0:
                        addHostFragment.k(false);
                        break;
                    default:
                        EditText editText2 = ((TextInputLayout) addHostFragment.l().a).getEditText();
                        editText2.getClass();
                        String string = editText2.getText().toString();
                        String string2 = addHostFragment.m().getText().toString();
                        String string3 = ((MaterialAutoCompleteTextView) addHostFragment.l().e).getText().toString();
                        Iterator it2 = u5.Z.iterator();
                        while (true) {
                            w0 w0Var2 = (w0) it2;
                            if (w0Var2.hasNext()) {
                                next = w0Var2.next();
                                if (n12.c(addHostFragment.getString(((u5) next).b), string3)) {
                                }
                            } else {
                                next = null;
                            }
                        }
                        u5 u5Var = (u5) next;
                        if (u5Var != null) {
                            int iOrdinal = u5Var.ordinal();
                            if (iOrdinal != 2) {
                                if (iOrdinal == 3) {
                                    string2 = ha0.n("server:", string2);
                                }
                            } else if (!w44.j0(string2, "server:", false)) {
                                string2 = "server:".concat(string2);
                            }
                        }
                        try {
                            List listL0 = p44.L0(string2, new String[]{","}, 6);
                            ArrayList arrayList2 = new ArrayList(f70.Q(10, listL0));
                            Iterator it3 = listL0.iterator();
                            while (it3.hasNext()) {
                                arrayList2.add(p44.U0((String) it3.next()).toString());
                            }
                            String[] strArr2 = (String[]) arrayList2.toArray(new String[0]);
                            ye.g(string, (String[]) Arrays.copyOf(strArr2, strArr2.length), null, null, null);
                            os1 os1VarS = oj0.a.s();
                            ls1 ls1Var = addHostFragment.f;
                            ke0.r(os1VarS.a, false, true, new ms1(os1VarS, new ls1(string, ls1Var != null ? ls1Var.b : 0, string2), 0));
                            addHostFragment.k(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                            TextInputLayout textInputLayoutN = addHostFragment.n();
                            String message = e.getMessage();
                            if (message == null) {
                                message = addHostFragment.getString(R.string.unknown_error);
                                message.getClass();
                            }
                            textInputLayoutN.setError(message);
                        }
                        break;
                }
            }
        });
        if (bundle != null) {
            this.f = (ls1) ek0.o(bundle, "host", ls1.class);
            j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p() {
        /*
            r2 = this;
            h4 r0 = r2.l()
            android.view.View r0 = r0.j
            com.google.android.material.button.MaterialButton r0 = (com.google.android.material.button.MaterialButton) r0
            h4 r1 = r2.l()
            android.view.View r1 = r1.a
            com.google.android.material.textfield.TextInputLayout r1 = (com.google.android.material.textfield.TextInputLayout) r1
            android.widget.EditText r1 = r1.getEditText()
            r1.getClass()
            android.text.Editable r1 = r1.getText()
            r1.getClass()
            boolean r1 = defpackage.p44.x0(r1)
            if (r1 != 0) goto L37
            android.widget.EditText r2 = r2.m()
            android.text.Editable r2 = r2.getText()
            if (r2 == 0) goto L37
            boolean r2 = defpackage.p44.x0(r2)
            r1 = 1
            r2 = r2 ^ r1
            if (r2 != r1) goto L37
            goto L38
        L37:
            r1 = 0
        L38:
            r0.setEnabled(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getsurfboard.ui.fragment.AddHostFragment.p():void");
    }
}
