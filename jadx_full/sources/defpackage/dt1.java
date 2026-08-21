package defpackage;

import android.content.Intent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.textview.MaterialTextView;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dt1 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ HostsListActivity f;

    public /* synthetic */ dt1(HostsListActivity hostsListActivity, int i) {
        this.b = i;
        this.f = hostsListActivity;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ae  */
    @Override // defpackage.am1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Object obj) {
        tk3 tk3Var;
        j80 j80Var;
        List listK;
        j80 j80Var2;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        HostsListActivity hostsListActivity = this.f;
        switch (i) {
            case 0:
                ls1 ls1Var = (ls1) obj;
                int i2 = HostsListActivity.a1;
                ls1Var.getClass();
                os1 os1VarS = oj0.a.s();
                os1VarS.getClass();
                ke0.r(os1VarS.a, false, true, new ms1(os1VarS, ls1Var, 1));
                j80 j80Var3 = hostsListActivity.S0;
                if (j80Var3 == null) {
                    n12.T("binding");
                    throw null;
                }
                oy3 oy3VarH = oy3.h((CoordinatorLayout) j80Var3.f, hostsListActivity.getString(R.string.host_deleted_template, ls1Var.f), -1);
                oy3VarH.i(R.string.undo, new mk(12, ls1Var));
                oy3VarH.j();
                return xl4Var;
            case 1:
                List list = (List) obj;
                if (!hostsListActivity.U0) {
                    hostsListActivity.W0.r(list);
                    boolean zIsEmpty = list.isEmpty();
                    j80 j80Var4 = hostsListActivity.S0;
                    if (j80Var4 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((RecyclerView) j80Var4.e).setVisibility(!zIsEmpty ? 0 : 8);
                    j80 j80Var5 = hostsListActivity.S0;
                    if (j80Var5 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((MaterialTextView) j80Var5.c).setVisibility(zIsEmpty ? 0 : 8);
                }
                return xl4Var;
            default:
                int i3 = HostsListActivity.a1;
                if (!((Boolean) obj).booleanValue() && hostsListActivity.Z0) {
                    hostsListActivity.Z0 = false;
                    t53 t53Var = (t53) d73.c.d();
                    if (t53Var != null) {
                        try {
                            HashMap mapW = ji0.w(t53Var);
                            if (t23.c(R.string.setting_override_lan_share_key, false)) {
                                String str = n12.c(t23.u(), t23.b[0]) ? "0.0.0.0" : "127.0.0.1";
                                listK = e70.K(new InetSocketAddress(str, t23.s()), new InetSocketAddress(str, t23.v()));
                            } else {
                                listK = null;
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (ls1 ls1Var2 : oj0.a.s().a()) {
                                try {
                                    String str2 = ls1Var2.f;
                                    List listL0 = p44.L0(ls1Var2.z, new String[]{","}, 6);
                                    ArrayList arrayList = new ArrayList(f70.Q(10, listL0));
                                    Iterator it = listL0.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(p44.U0((String) it.next()).toString());
                                        break;
                                    }
                                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                                    e03 e03VarG = ye.g(str2, (String[]) Arrays.copyOf(strArr, strArr.length), null, null, null);
                                    linkedHashMap.put(e03VarG.b, e03VarG.f);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            boolean zH = t23.q() ? t23.H() : false;
                            Set setE = t23.q() ? t23.e(zH) : k41.b;
                            boolean z = yw1.G0;
                            Object objD = t23.d.d();
                            objD.getClass();
                            rs4 rs4Var = new rs4((xw2) objD, mapW, zH, setE, t23.c(R.string.setting_allow_lan_key, false), t23.c(R.string.setting_auto_fix_dns_poisoning_key, true), t23.i(), t23.c(R.string.setting_bypass_tls_verify_key, false), t23.c(R.string.setting_force_udp_relay_key, false), t23.c(R.string.setting_force_remote_dns_key, true), listK, t23.r(), t23.t(), t23.c(R.string.setting_allow_bypass_key, true), t23.a(), t23.G(), t23.c(R.string.setting_tcp_keep_alive_key, false), t23.j(), linkedHashMap, t23.b());
                            Intent intent = new Intent(hostsListActivity, (Class<?>) SurfboardVpn.class);
                            k2.l(new FileOutputStream(zw1.b()), t53Var);
                            intent.putExtra("start", true);
                            intent.putExtra("vpn_config", rs4Var);
                            if (yw1.G0) {
                                try {
                                    v9.z(hostsListActivity, intent);
                                    j80Var2 = hostsListActivity.S0;
                                    if (j80Var2 != null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var2.f;
                                    coordinatorLayout.getClass();
                                    r25.R(coordinatorLayout, R.string.vpn_restarted, new Object[0]);
                                } catch (SecurityException e2) {
                                    tk3Var = new tk3(e2);
                                    j80Var = hostsListActivity.S0;
                                    if (j80Var == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) j80Var.f;
                                    coordinatorLayout2.getClass();
                                    Throwable thA = uk3.a(tk3Var);
                                    thA.getClass();
                                    r25.S(coordinatorLayout2, r25.D(thA));
                                }
                            } else {
                                try {
                                    hostsListActivity.startService(intent);
                                    j80Var2 = hostsListActivity.S0;
                                    if (j80Var2 != null) {
                                    }
                                } catch (Exception e3) {
                                    tk3Var = new tk3(e3);
                                    j80Var = hostsListActivity.S0;
                                    if (j80Var == null) {
                                        n12.T("binding");
                                        throw null;
                                    }
                                    CoordinatorLayout coordinatorLayout22 = (CoordinatorLayout) j80Var.f;
                                    coordinatorLayout22.getClass();
                                    Throwable thA2 = uk3.a(tk3Var);
                                    thA2.getClass();
                                    r25.S(coordinatorLayout22, r25.D(thA2));
                                }
                            }
                        } catch (Exception e4) {
                            tk3Var = new tk3(e4);
                            j80Var = hostsListActivity.S0;
                            if (j80Var == null) {
                                n12.T("binding");
                                throw null;
                            }
                        }
                    }
                }
                return xl4Var;
        }
    }
}
