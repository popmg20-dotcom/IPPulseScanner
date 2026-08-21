package defpackage;

import android.view.View;
import com.getsurfboard.ui.activity.HostsListActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class et1 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ HostsListActivity f;

    public /* synthetic */ et1(HostsListActivity hostsListActivity, int i) {
        this.b = i;
        this.f = hostsListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        HostsListActivity hostsListActivity = this.f;
        switch (i) {
            case 0:
                int i2 = HostsListActivity.a1;
                hostsListActivity.b().d();
                break;
            case 1:
                int i3 = HostsListActivity.a1;
                hostsListActivity.x(null, false);
                break;
            case 2:
                int i4 = HostsListActivity.a1;
                hostsListActivity.x(view, true);
                break;
            default:
                int i5 = HostsListActivity.a1;
                vs4 vs4Var = (vs4) ws4.c.d();
                if (vs4Var != null && vs4Var.b) {
                    hostsListActivity.Z0 = true;
                    zw1.d(hostsListActivity);
                    break;
                }
                break;
        }
    }
}
