package defpackage;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.impl.WorkDatabase;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textfield.TextInputLayout;
import com.tencent.mars.xlog.Xlog;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qi implements pl1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ qi(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    private final Object c() {
        int i;
        long jA;
        mu1[] mu1VarArr;
        kt ktVar = (kt) this.f;
        gu3 gu3Var = (gu3) this.z;
        bh3 bh3Var = new bh3();
        fu1 fu1Var = (fu1) ktVar.z;
        synchronized (fu1Var.N0) {
            synchronized (fu1Var) {
                try {
                    gu3 gu3Var2 = fu1Var.I0;
                    gu3 gu3Var3 = new gu3();
                    gu3Var2.getClass();
                    for (int i2 = 0; i2 < 10; i2++) {
                        if (((1 << i2) & gu3Var2.a) != 0) {
                            gu3Var3.b(i2, gu3Var2.b[i2]);
                        }
                    }
                    for (int i3 = 0; i3 < 10; i3++) {
                        if (((1 << i3) & gu3Var.a) != 0) {
                            gu3Var3.b(i3, gu3Var.b[i3]);
                        }
                    }
                    bh3Var.b = gu3Var3;
                    jA = ((long) gu3Var3.a()) - ((long) gu3Var2.a());
                    mu1VarArr = (jA == 0 || fu1Var.f.isEmpty()) ? null : (mu1[]) fu1Var.f.values().toArray(new mu1[0]);
                    gu3 gu3Var4 = (gu3) bh3Var.b;
                    gu3Var4.getClass();
                    fu1Var.I0 = gu3Var4;
                    za4.c(fu1Var.A0, fu1Var.z + " onSettings", new qi(6, fu1Var, bh3Var));
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                fu1Var.N0.g((gu3) bh3Var.b);
            } catch (IOException e) {
                t51 t51Var = t51.PROTOCOL_ERROR;
                fu1Var.g(t51Var, t51Var, e);
            }
        }
        if (mu1VarArr != null) {
            for (mu1 mu1Var : mu1VarArr) {
                synchronized (mu1Var) {
                    mu1Var.X += jA;
                    if (jA > 0) {
                        mu1Var.notifyAll();
                    }
                }
            }
        }
        return xl4.a;
    }

    private final Object d() {
        gj gjVar = (gj) this.f;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.z;
        synchronized (kv3.b) {
            LinkedHashMap linkedHashMap = kv3.c;
            linkedHashMap.remove(gjVar);
            if (linkedHashMap.isEmpty()) {
                ue2.g().a(mw4.a, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(kv3.a);
                kv3.f = false;
                kv3.d = null;
                kv3.e = false;
            }
        }
        return xl4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0114  */
    @Override // defpackage.pl1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a() {
        int i = 19;
        int i2 = 4;
        switch (this.b) {
            case 0:
                ((TextInputLayout) ((eg0) this.f).z).setError(((Button) this.z).getContext().getString(R.string.backup_wrong_password));
                return xl4.a;
            case 1:
                hk hkVar = (hk) this.f;
                gk gkVar = (gk) this.z;
                bc0 bc0Var = hkVar.a;
                synchronized (bc0Var.c) {
                    if (bc0Var.d.remove(gkVar) && bc0Var.d.isEmpty()) {
                        bc0Var.d();
                    }
                    break;
                }
                return xl4.a;
            case 2:
                xw4 xw4Var = (xw4) this.f;
                UUID uuid = (UUID) this.z;
                WorkDatabase workDatabase = xw4Var.c;
                workDatabase.getClass();
                workDatabase.p(new fn(i, new s7(15, xw4Var, uuid)));
                fq3.b(xw4Var.b, xw4Var.c, xw4Var.e);
                return xl4.a;
            case 3:
                String str = (String) this.f;
                xw4 xw4Var2 = (xw4) this.z;
                WorkDatabase workDatabase2 = xw4Var2.c;
                workDatabase2.getClass();
                workDatabase2.p(new fn(i, new b0(i2, workDatabase2, str, xw4Var2)));
                fq3.b(xw4Var2.b, workDatabase2, xw4Var2.e);
                return xl4.a;
            case 4:
                fu1 fu1Var = (fu1) this.f;
                mu1 mu1Var = (mu1) this.z;
                try {
                    fu1Var.b.b(mu1Var);
                    break;
                } catch (IOException e) {
                    k13 k13Var = k13.a;
                    k13.a.i(4, "Http2Connection.Listener failure for " + fu1Var.z, e);
                    try {
                        mu1Var.d(t51.PROTOCOL_ERROR, e);
                        break;
                    } catch (IOException unused) {
                    }
                }
                return xl4.a;
            case 5:
                return c();
            case 6:
                fu1 fu1Var2 = (fu1) this.f;
                fu1Var2.b.a(fu1Var2, (gu3) ((bh3) this.z).b);
                return xl4.a;
            case 7:
                RecentRequestsActivity recentRequestsActivity = (RecentRequestsActivity) this.f;
                mf3 mf3Var = (mf3) this.z;
                j80 j80Var = recentRequestsActivity.S0;
                if (j80Var == null) {
                    n12.T("binding");
                    throw null;
                }
                ((LoadingIndicator) j80Var.d).setVisibility(8);
                j80 j80Var2 = recentRequestsActivity.S0;
                if (j80Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((Toolbar) j80Var2.g).setSubtitle(ContextUtilsKt.i(R.plurals.requests_items, mf3Var.b()));
                if (recentRequestsActivity.W0) {
                    j80 j80Var3 = recentRequestsActivity.S0;
                    if (j80Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    if (((RecyclerView) j80Var3.c).getScrollState() != 1) {
                        j80 j80Var4 = recentRequestsActivity.S0;
                        if (j80Var4 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ag3 layoutManager = ((RecyclerView) j80Var4.c).getLayoutManager();
                        layoutManager.getClass();
                        ((LinearLayoutManager) layoutManager).w0(0);
                        recentRequestsActivity.W0 = false;
                        j80 j80Var5 = recentRequestsActivity.S0;
                        if (j80Var5 == null) {
                            n12.T("binding");
                            throw null;
                        }
                        ((RecyclerView) j80Var5.c).setItemAnimator(null);
                    }
                } else {
                    j80 j80Var6 = recentRequestsActivity.S0;
                    if (j80Var6 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((RecyclerView) j80Var6.c).setItemAnimator(new yl0());
                }
                return xl4.a;
            case 8:
                uh3 uh3Var = (uh3) this.f;
                String str2 = (String) this.z;
                Matcher matcher = uh3Var.b.matcher(str2);
                matcher.getClass();
                return p95.k(matcher, 0, str2);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                return d();
            case 10:
                t53 t53Var = (t53) this.f;
                SurfboardVpn surfboardVpn = (SurfboardVpn) this.z;
                int i3 = SurfboardVpn.I0;
                if (!t53Var.k(surfboardVpn.j(), false)) {
                    String strO = ha0.o("selected profile ", t53Var.b, " changed, notify user to restart vpn");
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "SurfboardVpn", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strO);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("SurfboardVpn", strO, null);
                    }
                    new Handler(Looper.getMainLooper()).post(new ga1(6, new t4(26)));
                }
                return xl4.a;
            default:
                ((ot4) ((wn1) this.f).f).b((e74) this.z);
                return xl4.a;
        }
    }
}
