package defpackage;

import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.google.android.material.divider.MaterialDivider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class z71 extends fg3 {
    public final /* synthetic */ int a;
    public int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ z71(int i, Object obj) {
        this.a = i;
        this.c = obj;
    }

    @Override // defpackage.fg3
    public final void b(RecyclerView recyclerView, int i, int i2) {
        int i3 = this.a;
        Object obj = this.c;
        switch (i3) {
            case 0:
                a81 a81Var = (a81) obj;
                int iComputeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset == 0) {
                    v92 v92Var = a81Var.b;
                    v92Var.getClass();
                    ((MaterialDivider) v92Var.X).animate().alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    v92 v92Var2 = a81Var.b;
                    v92Var2.getClass();
                    ((MaterialDivider) v92Var2.X).animate().alpha(1.0f).setDuration(100L).start();
                }
                this.b = iComputeVerticalScrollOffset;
                return;
            case 1:
                HostsListActivity hostsListActivity = (HostsListActivity) obj;
                int iComputeVerticalScrollOffset2 = recyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset2 == 0) {
                    j80 j80Var = hostsListActivity.S0;
                    if (j80Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = ((MaterialDivider) j80Var.h).animate();
                    viewPropertyAnimatorAnimate.cancel();
                    viewPropertyAnimatorAnimate.alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    j80 j80Var2 = hostsListActivity.S0;
                    if (j80Var2 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate2 = ((MaterialDivider) j80Var2.h).animate();
                    viewPropertyAnimatorAnimate2.cancel();
                    viewPropertyAnimatorAnimate2.alpha(1.0f).setDuration(100L).start();
                }
                this.b = iComputeVerticalScrollOffset2;
                return;
            case 2:
                d83 d83Var = (d83) obj;
                int iComputeVerticalScrollOffset3 = recyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset3 == 0) {
                    y3 y3Var = d83Var.b;
                    y3Var.getClass();
                    ((MaterialDivider) y3Var.k).animate().alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    y3 y3Var2 = d83Var.b;
                    y3Var2.getClass();
                    ((MaterialDivider) y3Var2.k).animate().alpha(1.0f).setDuration(100L).start();
                }
                this.b = iComputeVerticalScrollOffset3;
                return;
            case 3:
                RecentRequestsActivity recentRequestsActivity = (RecentRequestsActivity) obj;
                int iComputeVerticalScrollOffset4 = recyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset4 == 0) {
                    j80 j80Var3 = recentRequestsActivity.S0;
                    if (j80Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((MaterialDivider) j80Var3.h).animate().alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    j80 j80Var4 = recentRequestsActivity.S0;
                    if (j80Var4 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((MaterialDivider) j80Var4.h).animate().alpha(1.0f).setDuration(100L).start();
                }
                this.b = iComputeVerticalScrollOffset4;
                return;
            case 4:
                nf4 nf4Var = (nf4) obj;
                int iComputeVerticalScrollOffset5 = recyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset5 == 0) {
                    eg0 eg0Var = nf4Var.b;
                    eg0Var.getClass();
                    ((MaterialDivider) eg0Var.z).animate().alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    eg0 eg0Var2 = nf4Var.b;
                    eg0Var2.getClass();
                    ((MaterialDivider) eg0Var2.z).animate().alpha(1.0f).setDuration(100L).start();
                }
                this.b = iComputeVerticalScrollOffset5;
                return;
            default:
                TrafficListActivity trafficListActivity = (TrafficListActivity) obj;
                int iComputeVerticalScrollOffset6 = recyclerView.computeVerticalScrollOffset();
                if (iComputeVerticalScrollOffset6 == 0) {
                    v92 v92Var3 = trafficListActivity.S0;
                    if (v92Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate3 = ((MaterialDivider) v92Var3.X).animate();
                    viewPropertyAnimatorAnimate3.cancel();
                    viewPropertyAnimatorAnimate3.alpha(0.0f).setDuration(100L).start();
                } else if (this.b == 0) {
                    v92 v92Var4 = trafficListActivity.S0;
                    if (v92Var4 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ViewPropertyAnimator viewPropertyAnimatorAnimate4 = ((MaterialDivider) v92Var4.X).animate();
                    viewPropertyAnimatorAnimate4.cancel();
                    viewPropertyAnimatorAnimate4.alpha(1.0f).setDuration(100L).start();
                }
                this.b = iComputeVerticalScrollOffset6;
                return;
        }
    }
}
