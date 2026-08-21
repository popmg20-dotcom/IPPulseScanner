package defpackage;

import androidx.fragment.app.u;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.OverrideDoHActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gt1 extends ru2 {
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gt1(int i, Object obj) {
        super(false);
        this.d = i;
        this.e = obj;
    }

    @Override // defpackage.ru2
    public final void b() {
        int i = this.d;
        Object obj = this.e;
        switch (i) {
            case 0:
                ((HostsListActivity) obj).x(null, false);
                return;
            case 1:
                se2 se2Var = (se2) obj;
                te2 te2Var = se2Var.b;
                if (te2Var == null) {
                    n12.T("binding");
                    throw null;
                }
                te2Var.f.setAdapter(null);
                if (se2Var.getParentFragmentManager().H() <= 0) {
                    se2Var.requireActivity().finishAfterTransition();
                    return;
                }
                u parentFragmentManager = se2Var.getParentFragmentManager();
                parentFragmentManager.getClass();
                parentFragmentManager.x(new zj1(parentFragmentManager, -1, 0), false);
                return;
            case 2:
                ((am1) obj).g(this);
                return;
            case 3:
                ((OverrideDoHActivity) obj).z(null, false);
                return;
            default:
                ((d83) obj).q(false);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ gt1(int i, Object obj, boolean z) {
        super(true);
        this.d = i;
        this.e = obj;
    }
}
