package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.fragment.card.NetworkSpeedFragment;
import com.getsurfboard.ui.fragment.card.TrafficUsageFragment;
import com.getsurfboard.ui.receiver.BootCompleteReceiver;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.getsurfboard.vpn.Jni;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zn implements hu2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ zn(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    @Override // defpackage.hu2
    public final void b(Object obj) {
        HashMap map;
        switch (this.b) {
            case 0:
                BootCompleteReceiver bootCompleteReceiver = (BootCompleteReceiver) this.f;
                t53 t53Var = (t53) obj;
                int i = BootCompleteReceiver.b;
                if (t53Var == null) {
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "BootCompleteReceiver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "observer return null");
                    }
                    if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                        return;
                    }
                    Log.d("BootCompleteReceiver", "observer return null", null);
                    return;
                }
                String strN = ha0.n("onSelectedProfileLoaded: ", t53Var.b);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "BootCompleteReceiver", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("BootCompleteReceiver", strN, null);
                }
                d73.c.j(bootCompleteReceiver.a);
                try {
                    ContextUtilsKt.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("surfboard:///start")).setPackage(ContextUtilsKt.getContext().getPackageName()).addFlags(268435456));
                    return;
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                    return;
                } catch (NullPointerException e2) {
                    e2.printStackTrace();
                    return;
                } catch (SecurityException e3) {
                    e3.printStackTrace();
                    return;
                }
            case 1:
                ((q53) this.f).e(obj);
                return;
            case 2:
                Jni jni = (Jni) this.f;
                eg4 eg4Var = (eg4) obj;
                eg4Var.getClass();
                jni.a.h(eg4Var);
                return;
            case 3:
                n02 n02Var = (n02) this.f;
                ad2 ad2Var = (ad2) obj;
                synchronized (((HashMap) n02Var.z)) {
                    map = new HashMap((HashMap) n02Var.z);
                    break;
                }
                for (Map.Entry entry : map.entrySet()) {
                    ((Executor) entry.getValue()).execute(new xy0(6, entry, ad2Var));
                }
                return;
            case 4:
                ((f0) this.f).g(obj);
                return;
            case 5:
                NetworkSpeedFragment networkSpeedFragment = (NetworkSpeedFragment) this.f;
                eg4 eg4Var2 = (eg4) obj;
                eg4Var2.getClass();
                if (t23.E()) {
                    eu euVarQ = ji0.q(eg4Var2.c, false);
                    cm2 cm2Var = networkSpeedFragment.z;
                    cm2Var.getClass();
                    ((MaterialTextView) cm2Var.Z).setText(euVarQ.a);
                    cm2 cm2Var2 = networkSpeedFragment.z;
                    cm2Var2.getClass();
                    ((TextView) cm2Var2.Y).setText(euVarQ.b.concat("/s"));
                    eu euVarQ2 = ji0.q(eg4Var2.d, false);
                    cm2 cm2Var3 = networkSpeedFragment.z;
                    cm2Var3.getClass();
                    ((MaterialTextView) cm2Var3.A).setText(euVarQ2.a);
                    cm2 cm2Var4 = networkSpeedFragment.z;
                    cm2Var4.getClass();
                    ((TextView) cm2Var4.z).setText(euVarQ2.b.concat("/s"));
                    return;
                }
                eu euVarQ3 = ji0.q(eg4Var2.g, false);
                cm2 cm2Var5 = networkSpeedFragment.z;
                cm2Var5.getClass();
                ((MaterialTextView) cm2Var5.Z).setText(euVarQ3.a);
                cm2 cm2Var6 = networkSpeedFragment.z;
                cm2Var6.getClass();
                ((TextView) cm2Var6.Y).setText(euVarQ3.b.concat("/s"));
                eu euVarQ4 = ji0.q(eg4Var2.h, false);
                cm2 cm2Var7 = networkSpeedFragment.z;
                cm2Var7.getClass();
                ((MaterialTextView) cm2Var7.A).setText(euVarQ4.a);
                cm2 cm2Var8 = networkSpeedFragment.z;
                cm2Var8.getClass();
                ((TextView) cm2Var8.z).setText(euVarQ4.b.concat("/s"));
                return;
            case 6:
                cb3 cb3Var = (cb3) this.f;
                xw2 xw2Var = (xw2) obj;
                xw2Var.getClass();
                t53 t53Var2 = (t53) d73.c.d();
                int i2 = 4;
                if (t53Var2 == null) {
                    uf4 uf4Var = cb3Var.b;
                    uf4Var.getClass();
                    ((TextView) uf4Var.c).setVisibility(0);
                    uf4 uf4Var2 = cb3Var.b;
                    uf4Var2.getClass();
                    ((TabLayout) uf4Var2.d).setVisibility(4);
                    uf4 uf4Var3 = cb3Var.b;
                    uf4Var3.getClass();
                    ((ViewPager2) uf4Var3.a).setVisibility(4);
                    uf4 uf4Var4 = cb3Var.b;
                    uf4Var4.getClass();
                    ((ViewPager2) uf4Var4.a).setAdapter(null);
                    uf4 uf4Var5 = cb3Var.b;
                    uf4Var5.getClass();
                    ((FloatingActionButton) uf4Var5.e).d(true);
                    return;
                }
                String str = t53Var2.b;
                if (xw2Var == xw2.z) {
                    boolean zIsEmpty = t53Var2.I0.f.isEmpty();
                    uf4 uf4Var6 = cb3Var.b;
                    if (zIsEmpty) {
                        uf4Var6.getClass();
                        ((TextView) uf4Var6.c).setVisibility(0);
                        uf4 uf4Var7 = cb3Var.b;
                        uf4Var7.getClass();
                        ((TabLayout) uf4Var7.d).setVisibility(4);
                        uf4 uf4Var8 = cb3Var.b;
                        uf4Var8.getClass();
                        ((ViewPager2) uf4Var8.a).setVisibility(4);
                        uf4 uf4Var9 = cb3Var.b;
                        uf4Var9.getClass();
                        ((FloatingActionButton) uf4Var9.e).d(true);
                        return;
                    }
                    uf4Var6.getClass();
                    ((TextView) uf4Var6.c).setVisibility(4);
                    uf4 uf4Var10 = cb3Var.b;
                    uf4Var10.getClass();
                    ((TabLayout) uf4Var10.d).setVisibility(0);
                    uf4 uf4Var11 = cb3Var.b;
                    uf4Var11.getClass();
                    ((ViewPager2) uf4Var11.a).setVisibility(0);
                    vs4 vs4Var = (vs4) ws4.c.d();
                    if (vs4Var != null) {
                        if (vs4Var.b && n12.c(vs4Var.a, str)) {
                            uf4 uf4Var12 = cb3Var.b;
                            uf4Var12.getClass();
                            ((FloatingActionButton) uf4Var12.e).f(true);
                        } else {
                            uf4 uf4Var13 = cb3Var.b;
                            uf4Var13.getClass();
                            ((FloatingActionButton) uf4Var13.e).d(true);
                        }
                    }
                    List listX = p95.x(t53Var2.I0);
                    cb3Var.f = new ra3(cb3Var, str, listX);
                    uf4 uf4Var14 = cb3Var.b;
                    uf4Var14.getClass();
                    ((ViewPager2) uf4Var14.a).setAdapter(cb3Var.f);
                    uf4 uf4Var15 = cb3Var.b;
                    uf4Var15.getClass();
                    TabLayout tabLayout = (TabLayout) uf4Var15.d;
                    uf4 uf4Var16 = cb3Var.b;
                    uf4Var16.getClass();
                    new wt2(tabLayout, (ViewPager2) uf4Var16.a, new o73(i2, listX)).a();
                    cb3Var.j(listX);
                    return;
                }
                if (xw2Var == xw2.b) {
                    Collection collectionValues = t53Var2.H0.values();
                    collectionValues.getClass();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : collectionValues) {
                        if (!((na3) obj2).T()) {
                            arrayList.add(obj2);
                        }
                    }
                    boolean zIsEmpty2 = arrayList.isEmpty();
                    uf4 uf4Var17 = cb3Var.b;
                    if (zIsEmpty2) {
                        uf4Var17.getClass();
                        ((TextView) uf4Var17.c).setVisibility(0);
                        uf4 uf4Var18 = cb3Var.b;
                        uf4Var18.getClass();
                        ((TabLayout) uf4Var18.d).setVisibility(4);
                        uf4 uf4Var19 = cb3Var.b;
                        uf4Var19.getClass();
                        ((ViewPager2) uf4Var19.a).setVisibility(4);
                        uf4 uf4Var20 = cb3Var.b;
                        uf4Var20.getClass();
                        ((FloatingActionButton) uf4Var20.e).d(true);
                        return;
                    }
                    uf4Var17.getClass();
                    ((TextView) uf4Var17.c).setVisibility(4);
                    uf4 uf4Var21 = cb3Var.b;
                    uf4Var21.getClass();
                    ((TabLayout) uf4Var21.d).setVisibility(0);
                    uf4 uf4Var22 = cb3Var.b;
                    uf4Var22.getClass();
                    ((ViewPager2) uf4Var22.a).setVisibility(0);
                    vs4 vs4Var2 = (vs4) ws4.c.d();
                    if (vs4Var2 != null) {
                        if (vs4Var2.b && n12.c(vs4Var2.a, str)) {
                            uf4 uf4Var23 = cb3Var.b;
                            uf4Var23.getClass();
                            ((FloatingActionButton) uf4Var23.e).f(true);
                        } else {
                            uf4 uf4Var24 = cb3Var.b;
                            uf4Var24.getClass();
                            ((FloatingActionButton) uf4Var24.e).d(true);
                        }
                    }
                    cb3Var.f = new ra3(cb3Var, str, arrayList);
                    uf4 uf4Var25 = cb3Var.b;
                    uf4Var25.getClass();
                    ((ViewPager2) uf4Var25.a).setAdapter(cb3Var.f);
                    uf4 uf4Var26 = cb3Var.b;
                    uf4Var26.getClass();
                    TabLayout tabLayout2 = (TabLayout) uf4Var26.d;
                    uf4 uf4Var27 = cb3Var.b;
                    uf4Var27.getClass();
                    new wt2(tabLayout2, (ViewPager2) uf4Var27.a, new o73(5, arrayList)).a();
                    cb3Var.j(arrayList);
                    return;
                }
                return;
            case 7:
                SurfboardVpn surfboardVpn = (SurfboardVpn) this.f;
                t53 t53Var3 = (t53) obj;
                int i3 = SurfboardVpn.I0;
                vs4 vs4Var3 = (vs4) ws4.c.d();
                if (vs4Var3 == null || !vs4Var3.b) {
                    return;
                }
                if (t53Var3 == null) {
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "SurfboardVpn", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop vpn due to selected profile is null");
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("SurfboardVpn", "stop vpn due to selected profile is null", null);
                    }
                    zw1.d(surfboardVpn);
                    return;
                }
                String str2 = t53Var3.b;
                t53 t53Var4 = surfboardVpn.z;
                if (n12.c(str2, t53Var4 != null ? t53Var4.b : null)) {
                    ez4.X("profile_cmp", new qi(10, t53Var3, surfboardVpn));
                    return;
                }
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SurfboardVpn", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "stop vpn due to selected profile changed");
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SurfboardVpn", "stop vpn due to selected profile changed", null);
                }
                zw1.d(surfboardVpn);
                return;
            default:
                TrafficUsageFragment trafficUsageFragment = (TrafficUsageFragment) this.f;
                ((eg4) obj).getClass();
                eg4 eg4Var3 = (eg4) dg4.p.d();
                if (eg4Var3 != null) {
                    if (t23.E()) {
                        eu euVarQ5 = ji0.q(eg4Var3.a, false);
                        v92 v92Var = trafficUsageFragment.f;
                        v92Var.getClass();
                        ((MaterialTextView) v92Var.A).setText(p44.D0(euVarQ5.b, 2, ' '));
                        v92 v92Var2 = trafficUsageFragment.f;
                        v92Var2.getClass();
                        ((MaterialTextView) v92Var2.X).setText("↑ ".concat(euVarQ5.a));
                        eu euVarQ6 = ji0.q(eg4Var3.b, false);
                        v92 v92Var3 = trafficUsageFragment.f;
                        v92Var3.getClass();
                        ((MaterialTextView) v92Var3.f).setText(p44.D0(euVarQ6.b, 2, ' '));
                        v92 v92Var4 = trafficUsageFragment.f;
                        v92Var4.getClass();
                        ((MaterialTextView) v92Var4.z).setText("↓ ".concat(euVarQ6.a));
                        return;
                    }
                    eu euVarQ7 = ji0.q(eg4Var3.e, false);
                    v92 v92Var5 = trafficUsageFragment.f;
                    v92Var5.getClass();
                    ((MaterialTextView) v92Var5.A).setText(p44.D0(euVarQ7.b, 2, ' '));
                    v92 v92Var6 = trafficUsageFragment.f;
                    v92Var6.getClass();
                    ((MaterialTextView) v92Var6.X).setText("↑ ".concat(euVarQ7.a));
                    eu euVarQ8 = ji0.q(eg4Var3.f, false);
                    v92 v92Var7 = trafficUsageFragment.f;
                    v92Var7.getClass();
                    ((MaterialTextView) v92Var7.f).setText(p44.D0(euVarQ8.b, 2, ' '));
                    v92 v92Var8 = trafficUsageFragment.f;
                    v92Var8.getClass();
                    ((MaterialTextView) v92Var8.z).setText("↓ ".concat(euVarQ8.a));
                    return;
                }
                return;
        }
    }
}
