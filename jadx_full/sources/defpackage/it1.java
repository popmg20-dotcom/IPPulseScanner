package defpackage;

import android.widget.EditText;
import androidx.fragment.app.FragmentContainerView;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.OverrideDoHActivity;
import com.getsurfboard.ui.fragment.AddDoHFragment;
import com.getsurfboard.ui.fragment.AddHostFragment;
import com.getsurfboard.ui.fragment.ProfileAddMethodsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.android.material.textview.MaterialTextView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class it1 implements tg4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ it1(int i, Object obj, boolean z) {
        this.a = i;
        this.c = obj;
        this.b = z;
    }

    @Override // defpackage.tg4
    public final void a(vg4 vg4Var) {
        switch (this.a) {
            case 0:
                throw null;
            case 1:
                throw null;
            default:
                throw null;
        }
    }

    @Override // defpackage.tg4
    public final void b(vg4 vg4Var) {
        int i = this.a;
        vg4Var.getClass();
    }

    @Override // defpackage.tg4
    public final void c(vg4 vg4Var) {
        int i = this.a;
        boolean z = this.b;
        Object obj = this.c;
        vg4Var.getClass();
        switch (i) {
            case 0:
                HostsListActivity hostsListActivity = (HostsListActivity) obj;
                j80 j80Var = hostsListActivity.S0;
                if (j80Var == null) {
                    n12.T("binding");
                    throw null;
                }
                AddHostFragment addHostFragment = (AddHostFragment) ((FragmentContainerView) j80Var.b).getFragment();
                if (z) {
                    EditText editText = ((TextInputLayout) addHostFragment.l().a).getEditText();
                    if (editText != null) {
                        editText.setSelection(editText.length());
                        editText.requestFocus();
                        ContextUtilsKt.m().showSoftInput(editText, 1);
                        return;
                    }
                    return;
                }
                hostsListActivity.V0 = null;
                j80 j80Var2 = hostsListActivity.S0;
                if (j80Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((FloatingActionButton) j80Var2.a).f(true);
                j80 j80Var3 = hostsListActivity.S0;
                if (j80Var3 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((FloatingActionButton) j80Var3.a).requestFocus();
                EditText editText2 = ((TextInputLayout) addHostFragment.l().a).getEditText();
                if (editText2 != null) {
                    editText2.setText("");
                }
                ((TextInputEditText) addHostFragment.l().i).setText("");
                ((MaterialAutoCompleteTextView) addHostFragment.l().h).setText("");
                addHostFragment.f = null;
                addHostFragment.j();
                return;
            case 1:
                OverrideDoHActivity overrideDoHActivity = (OverrideDoHActivity) obj;
                uf4 uf4Var = overrideDoHActivity.S0;
                if (uf4Var == null) {
                    n12.T("binding");
                    throw null;
                }
                AddDoHFragment addDoHFragment = (AddDoHFragment) ((FragmentContainerView) uf4Var.b).getFragment();
                if (z) {
                    return;
                }
                overrideDoHActivity.U0 = null;
                uf4 uf4Var2 = overrideDoHActivity.S0;
                if (uf4Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((FloatingActionButton) uf4Var2.c).f(true);
                uf4 uf4Var3 = overrideDoHActivity.S0;
                if (uf4Var3 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((FloatingActionButton) uf4Var3.c).requestFocus();
                iv1 iv1Var = addDoHFragment.b;
                iv1Var.getClass();
                ((MaterialAutoCompleteTextView) iv1Var.A).setText("");
                addDoHFragment.j(-1, null);
                return;
            default:
                y3 y3Var = ((d83) obj).b;
                if (y3Var == null) {
                    return;
                }
                if (!z) {
                    ((FloatingActionButton) y3Var.d).requestFocus();
                    return;
                }
                iv1 iv1Var2 = ((ProfileAddMethodsFragment) ((FragmentContainerView) y3Var.e).getFragment()).b;
                iv1Var2.getClass();
                ((MaterialTextView) iv1Var2.X).requestFocus();
                return;
        }
    }

    @Override // defpackage.tg4
    public final void d(vg4 vg4Var) {
        switch (this.a) {
            case 0:
                vg4Var.getClass();
                break;
            case 1:
                vg4Var.getClass();
                break;
            default:
                vg4Var.getClass();
                break;
        }
    }

    @Override // defpackage.tg4
    public final void e(vg4 vg4Var) {
        switch (this.a) {
            case 0:
                c(vg4Var);
                break;
            case 1:
                c(vg4Var);
                break;
            default:
                c(vg4Var);
                break;
        }
    }

    @Override // defpackage.tg4
    public final void f(vg4 vg4Var) {
        int i = this.a;
        vg4Var.getClass();
    }

    @Override // defpackage.tg4
    public final void g(vg4 vg4Var) {
        int i = this.a;
        vg4Var.getClass();
    }
}
