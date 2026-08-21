package defpackage;

import com.getsurfboard.ui.activity.HostsListActivity;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ht1 extends r82 implements pl1 {
    public final /* synthetic */ int f;
    public final /* synthetic */ HostsListActivity z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ht1(HostsListActivity hostsListActivity, int i) {
        super(0);
        this.f = i;
        this.z = hostsListActivity;
    }

    @Override // defpackage.pl1
    public final Object a() {
        int i = this.f;
        HostsListActivity hostsListActivity = this.z;
        switch (i) {
            case 0:
                return (mq4) hostsListActivity.K0.getValue();
            case 1:
                return hostsListActivity.getViewModelStore();
            default:
                return hostsListActivity.getDefaultViewModelCreationExtras();
        }
    }
}
