package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.android.material.progressindicator.LinearProgressIndicator;
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
public final /* synthetic */ class p73 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ d83 f;

    public /* synthetic */ p73(d83 d83Var, int i) {
        this.b = i;
        this.f = d83Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        tk3 tk3Var;
        List listK;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        d83 d83Var = this.f;
        switch (i) {
            case 0:
                ji0.B(uf2.t(d83Var), null, null, new dh0(null, d83Var, ((Boolean) obj).booleanValue()), 3);
                return xl4Var;
            case 1:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                y3 y3Var = d83Var.b;
                if (zBooleanValue) {
                    y3Var.getClass();
                    ((LinearProgressIndicator) y3Var.g).e();
                } else {
                    y3Var.getClass();
                    ((LinearProgressIndicator) y3Var.g).b();
                }
                return xl4Var;
            case 2:
                List list = (List) obj;
                bx0 bx0Var = d83Var.A;
                list.getClass();
                bx0Var.s(d83.n(list), new ga1(17, d83Var));
                y3 y3Var2 = d83Var.b;
                y3Var2.getClass();
                ((LinearProgressIndicator) y3Var2.g).setVisibility(8);
                y3 y3Var3 = d83Var.b;
                y3Var3.getClass();
                ((LinearLayoutCompat) y3Var3.b).setVisibility(list.isEmpty() ? 0 : 8);
                return xl4Var;
            case 3:
                if (!((Boolean) obj).booleanValue() && d83Var.f) {
                    d83Var.f = false;
                    t53 t53Var = (t53) d73.c.d();
                    if (t53Var != null) {
                        Context contextRequireContext = d83Var.requireContext();
                        contextRequireContext.getClass();
                        try {
                            HashMap mapW = ji0.w(t53Var);
                            if (t23.c(R.string.setting_override_lan_share_key, false)) {
                                String str = n12.c(t23.u(), t23.b[0]) ? "0.0.0.0" : "127.0.0.1";
                                listK = e70.K(new InetSocketAddress(str, t23.s()), new InetSocketAddress(str, t23.v()));
                            } else {
                                listK = null;
                            }
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (ls1 ls1Var : oj0.a.s().a()) {
                                try {
                                    String str2 = ls1Var.f;
                                    List listL0 = p44.L0(ls1Var.z, new String[]{","}, 6);
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
                            Intent intent = new Intent(contextRequireContext, (Class<?>) SurfboardVpn.class);
                            k2.l(new FileOutputStream(zw1.b()), t53Var);
                            intent.putExtra("start", true);
                            intent.putExtra("vpn_config", rs4Var);
                            if (yw1.G0) {
                                try {
                                    v9.z(contextRequireContext, intent);
                                    y3 y3Var4 = d83Var.b;
                                    y3Var4.getClass();
                                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) y3Var4.a;
                                    coordinatorLayout.getClass();
                                    r25.R(coordinatorLayout, R.string.vpn_restarted, new Object[0]);
                                } catch (SecurityException e2) {
                                    tk3Var = new tk3(e2);
                                    y3 y3Var5 = d83Var.b;
                                    y3Var5.getClass();
                                    CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) y3Var5.a;
                                    coordinatorLayout2.getClass();
                                    Throwable thA = uk3.a(tk3Var);
                                    thA.getClass();
                                    r25.S(coordinatorLayout2, r25.D(thA));
                                }
                            } else {
                                try {
                                    contextRequireContext.startService(intent);
                                    y3 y3Var42 = d83Var.b;
                                    y3Var42.getClass();
                                    CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) y3Var42.a;
                                    coordinatorLayout3.getClass();
                                    r25.R(coordinatorLayout3, R.string.vpn_restarted, new Object[0]);
                                } catch (Exception e3) {
                                    tk3Var = new tk3(e3);
                                    y3 y3Var52 = d83Var.b;
                                    y3Var52.getClass();
                                    CoordinatorLayout coordinatorLayout22 = (CoordinatorLayout) y3Var52.a;
                                    coordinatorLayout22.getClass();
                                    Throwable thA2 = uk3.a(tk3Var);
                                    thA2.getClass();
                                    r25.S(coordinatorLayout22, r25.D(thA2));
                                }
                            }
                        } catch (Exception e4) {
                            tk3Var = new tk3(e4);
                        }
                    }
                }
                return xl4Var;
            default:
                t53 t53Var2 = (t53) obj;
                if (t53Var2 != null) {
                    y3 y3Var6 = d83Var.b;
                    bx0 bx0Var2 = d83Var.A;
                    y3Var6.getClass();
                    RecyclerView recyclerView = (RecyclerView) y3Var6.j;
                    int i2 = 0;
                    while (i2 < recyclerView.getChildCount()) {
                        int i3 = i2 + 1;
                        View childAt = recyclerView.getChildAt(i2);
                        if (childAt == null) {
                            throw new IndexOutOfBoundsException();
                        }
                        y3 y3Var7 = d83Var.b;
                        y3Var7.getClass();
                        rg3 rg3VarN = ((RecyclerView) y3Var7.j).N(childAt);
                        if (rg3VarN instanceof z63) {
                            d83Var.b.getClass();
                            rg3 rg3VarO = RecyclerView.O(childAt);
                            int iB = rg3VarO != null ? rg3VarO.b() : -1;
                            if (iB != -1) {
                                zk zkVar = (zk) bx0Var2.d.f.get(iB);
                                RadioButton radioButton = (RadioButton) ((z63) rg3VarN).u.i;
                                if (n12.c(t53Var2.b, zkVar.getName())) {
                                    if (!radioButton.isChecked()) {
                                        radioButton.setChecked(true);
                                        bx0Var2.e(iB);
                                    }
                                } else if (radioButton.isChecked()) {
                                    radioButton.setChecked(false);
                                    bx0Var2.e(iB);
                                }
                            }
                        }
                        i2 = i3;
                    }
                }
                return xl4Var;
        }
    }
}
