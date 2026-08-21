package defpackage;

import android.content.Context;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.getsurfboard.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kh0 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ xh0 f;

    public /* synthetic */ kh0(xh0 xh0Var, int i) {
        this.b = i;
        this.f = xh0Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        vs4 vs4Var;
        int i = this.b;
        ge0 ge0Var = null;
        int i2 = 1;
        xl4 xl4Var = xl4.a;
        xh0 xh0Var = this.f;
        switch (i) {
            case 0:
                t53 t53Var = (t53) obj;
                j80 j80Var = xh0Var.b;
                j80Var.getClass();
                ((ExtendedFloatingActionButton) j80Var.b).setVisibility(t53Var == null ? 8 : 0);
                break;
            case 1:
                yo4 yo4Var = (yo4) obj;
                if (yo4Var != null) {
                    String str = yo4Var.a;
                    if (!n12.c(t23.o("viewed_new_version", null), str)) {
                        j80 j80Var2 = xh0Var.b;
                        j80Var2.getClass();
                        oy3 oy3VarH = oy3.h((CoordinatorLayout) j80Var2.a, xh0Var.getString(R.string.setting_check_update_summary_template, str, yo4Var.b), -2);
                        oy3VarH.i(R.string.view, new mk(3, yo4Var));
                        th0 th0Var = new th0(yo4Var);
                        ArrayList arrayList = oy3VarH.s;
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            oy3VarH.s = arrayList;
                        }
                        arrayList.add(th0Var);
                        oy3VarH.j();
                    }
                }
                break;
            case 2:
                xh0.k(xh0Var, (Boolean) obj);
                break;
            case 3:
                if (((ei0) obj).a == i24.f) {
                    Context contextRequireContext = xh0Var.requireContext();
                    contextRequireContext.getClass();
                    uf2.f(contextRequireContext, xh0Var, new kh0(xh0Var, i2));
                }
                break;
            case 4:
                f33 f33Var = xh0Var.X;
                boolean z = ((vs4) obj).b;
                j80 j80Var3 = xh0Var.b;
                if (!z) {
                    j80Var3.getClass();
                    ((ExtendedFloatingActionButton) j80Var3.b).removeCallbacks(f33Var);
                } else {
                    j80Var3.getClass();
                    ((ExtendedFloatingActionButton) j80Var3.b).post(f33Var);
                }
                break;
            case 5:
                j80 j80Var4 = xh0Var.b;
                j80Var4.getClass();
                ((ExtendedFloatingActionButton) j80Var4.b).setEnabled(!((Boolean) obj).booleanValue());
                break;
            default:
                if (((Boolean) obj).booleanValue() && (vs4Var = (vs4) ws4.c.d()) != null && vs4Var.b && !xh0Var.Z) {
                    ji0.B(uf2.t(xh0Var), null, null, new sh0(xh0Var, ge0Var, i2), 3);
                }
                break;
        }
        return xl4Var;
    }
}
