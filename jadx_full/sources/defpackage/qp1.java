package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.o;
import com.getsurfboard.R;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class qp1 extends o {
    public u6 b;
    public boolean f;

    public final void j() {
        this.f = true;
        ji0.B(uf2.t(this), null, null, new mt(this, null, 6), 3);
    }

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        wh2 wh2Var = new wh2(requireContext());
        p6 p6Var = (p6) wh2Var.z;
        p6Var.v = null;
        p6Var.u = R.layout.dialog_loading;
        p6Var.o = new DialogInterface.OnCancelListener() { // from class: op1
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                this.b.j();
            }
        };
        this.b = wh2Var.r();
        boolean z = nj3.a;
        y3 y3Var = nj3.e;
        oj1 oj1Var = new oj1(5, this);
        yc1 yc1Var = new yc1("https://timeline.google.com/maps/timeline", oj1Var, oj1Var, 2);
        yc1Var.C0 = this;
        y3Var.a(yc1Var);
    }

    @Override // androidx.fragment.app.o
    public final void onDestroy() {
        boolean z = nj3.a;
        nj3.e.d(this);
        u6 u6Var = this.b;
        if (u6Var != null) {
            u6Var.dismiss();
        }
        this.b = null;
        super.onDestroy();
    }
}
