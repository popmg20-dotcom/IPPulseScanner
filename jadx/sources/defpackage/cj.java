package defpackage;

import android.content.Context;
import android.view.MenuItem;
import com.getsurfboard.R;
import com.google.android.material.navigation.NavigationView;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cj implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ cj(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.pl1
    public final Object a() {
        MenuItem checkedItem;
        int i = this.b;
        int i2 = 0;
        xl4 xl4Var = xl4.a;
        Object obj = this.f;
        switch (i) {
            case 0:
                z00 z00Var = (z00) obj;
                if (z00Var.v() instanceof ps2) {
                    z00Var.d(null);
                }
                return xl4Var;
            case 1:
                xh0 xh0Var = (xh0) obj;
                wh2 wh2Var = new wh2(xh0Var.requireContext());
                wh2Var.x(R.string.abnormal_traffic);
                ((p6) wh2Var.z).g = vo.p(63, xh0Var.getString(R.string.tls_handshake_time_error));
                wh2Var.w(R.string.check_system_time, new uh0(i2, xh0Var));
                wh2Var.u(R.string.i_got_it, null);
                u6 u6VarH = wh2Var.h();
                u6VarH.setOnShowListener(new vh0(xh0Var));
                u6VarH.show();
                return xl4Var;
            case 2:
                tf2 tf2Var = (tf2) obj;
                ed4 ed4Var = tf2Var.b;
                ed4Var.getClass();
                up2 up2Var = (up2) ed4Var.z;
                if (up2Var == null || up2Var.getSelectedItemId() != R.id.navigation_dashboard) {
                    ed4 ed4Var2 = tf2Var.b;
                    ed4Var2.getClass();
                    up2 up2Var2 = (up2) ed4Var2.z;
                    if (up2Var2 != null) {
                        up2Var2.setSelectedItemId(R.id.navigation_dashboard);
                    }
                }
                ed4 ed4Var3 = tf2Var.b;
                ed4Var3.getClass();
                NavigationView navigationView = (NavigationView) ed4Var3.A;
                if (navigationView == null || (checkedItem = navigationView.getCheckedItem()) == null || checkedItem.getItemId() != R.id.navigation_dashboard) {
                    ed4 ed4Var4 = tf2Var.b;
                    ed4Var4.getClass();
                    NavigationView navigationView2 = (NavigationView) ed4Var4.A;
                    if (navigationView2 != null) {
                        navigationView2.setCheckedItem(R.id.navigation_dashboard);
                    }
                }
                xh0 xh0Var2 = tf2Var.z;
                if (xh0Var2 != null) {
                    Context contextRequireContext = tf2Var.requireContext();
                    contextRequireContext.getClass();
                    xh0Var2.j(contextRequireContext);
                }
                return xl4Var;
            case 3:
                ((zb3) obj).j(false, false);
                p95.C(R.string.generate_qrcode_failed, new Object[0]);
                return xl4Var;
            case 4:
                ij3 ij3VarU = oj0.a.u();
                oj3 oj3Var = (oj3) obj;
                String strO = ha0.o("%", oj3Var.a, "%");
                String str = oj3Var.b;
                String str2 = oj3Var.c;
                String str3 = oj3Var.d;
                ij3VarU.getClass();
                return new hj3(new sl3("SELECT * FROM requests WHERE (packageName LIKE ? OR proxy LIKE ? OR rule LIKE ? OR server LIKE ?) AND (? IS NULL OR packageName = ?)AND (? IS NULL OR proxy = ?)AND (? IS NULL OR rule = ?)ORDER BY id DESC", new sr1(strO, str, str2, str3)), ij3VarU, ij3VarU.a, new String[]{"requests"});
            case 5:
                ((b84) obj).j(false, false);
                return xl4Var;
            default:
                return new qc0[((zf1[]) obj).length];
        }
    }
}
