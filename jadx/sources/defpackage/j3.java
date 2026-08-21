package defpackage;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j3 extends yi1 {
    public final /* synthetic */ int A0 = 0;
    public final /* synthetic */ View B0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.B0 = actionMenuItemView;
    }

    @Override // defpackage.yi1
    public final wv3 b() {
        l3 l3Var;
        int i = this.A0;
        View view = this.B0;
        switch (i) {
            case 0:
                k3 k3Var = ((ActionMenuItemView) view).G0;
                if (k3Var == null || (l3Var = ((m3) k3Var).a.L0) == null) {
                    return null;
                }
                return l3Var.a();
            default:
                l3 l3Var2 = ((n3) view).A.K0;
                if (l3Var2 == null) {
                    return null;
                }
                return l3Var2.a();
        }
    }

    @Override // defpackage.yi1
    public final boolean c() {
        wv3 wv3VarB;
        int i = this.A0;
        View view = this.B0;
        switch (i) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) view;
                mk2 mk2Var = actionMenuItemView.E0;
                if (mk2Var == null || !mk2Var.a(actionMenuItemView.B0) || (wv3VarB = b()) == null || !wv3VarB.b()) {
                }
                break;
            default:
                ((n3) view).A.n();
                break;
        }
        return true;
    }

    @Override // defpackage.yi1
    public boolean d() {
        switch (this.A0) {
            case 1:
                q3 q3Var = ((n3) this.B0).A;
                if (q3Var.M0 != null) {
                    return false;
                }
                q3Var.g();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j3(n3 n3Var, n3 n3Var2) {
        super(n3Var2);
        this.B0 = n3Var;
    }
}
