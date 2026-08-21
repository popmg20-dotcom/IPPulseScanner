package defpackage;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.u;
import com.getsurfboard.R;
import com.getsurfboard.ui.SurfboardApp;
import com.getsurfboard.ui.activity.ProfileEditorActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.getsurfboard.ui.fragment.card.ActiveConnectionsFragment;
import com.getsurfboard.ui.fragment.card.DnsFragment;
import com.getsurfboard.ui.fragment.card.PrivateIPFragment;
import com.getsurfboard.ui.fragment.card.SSHDumpFragment;
import com.getsurfboard.ui.fragment.card.TrafficUsageFragment;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import j$.util.DesugarCollections;
import j$.util.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ f0(yn2 yn2Var, xn2 xn2Var) {
        this.b = 13;
        this.f = yn2Var;
    }

    @Override // defpackage.am1
    public final Object g(Object obj) {
        boolean zV;
        Integer num;
        int i = this.b;
        boolean z = false;
        z = false;
        z = false;
        z = false;
        boolean z2 = false;
        z = false;
        int i2 = 1;
        LinkedHashMap linkedHashMap = null;
        Object obj2 = this.f;
        switch (i) {
            case 0:
                return obj == ((g0) obj2) ? "(this Collection)" : String.valueOf(obj);
            case 1:
                ha1 ha1Var = ((ActiveConnectionsFragment) obj2).f;
                ha1Var.getClass();
                ((MaterialTextView) ha1Var.f).setText(String.valueOf((Integer) obj));
                return xl4.a;
            case 2:
                vf vfVar = (vf) obj2;
                b80 b80Var = (b80) obj;
                b80Var.getClass();
                m24 m24Var = vfVar.c;
                um1 um1Var = vfVar.l;
                if (((Boolean) m24Var.i()).booleanValue()) {
                    Handler handler = (Handler) vfVar.k.getValue();
                    handler.removeCallbacks(um1Var);
                    ((AtomicReference) um1Var.f).set(b80Var);
                    handler.post(um1Var);
                } else {
                    Iterator it = vfVar.i.iterator();
                    while (it.hasNext()) {
                        ((am1) it.next()).g(b80Var);
                    }
                }
                return xl4.a;
            case 3:
                nk.j((nk) obj2, (Boolean) obj);
                return xl4.a;
            case 4:
                ((hv3) ((v92) obj2).f).p(null);
                return xl4.a;
            case 5:
                ((hx3) obj2).b(null);
                return xl4.a;
            case 6:
                ((jv0) obj2).B0 = true;
                return xl4.a;
            case 7:
                DnsFragment dnsFragment = (DnsFragment) obj2;
                ei0 ei0Var = (ei0) obj;
                i24 i24Var = ei0Var.a;
                Object obj3 = ei0Var.b;
                int iOrdinal = i24Var.ordinal();
                if (iOrdinal == 0) {
                    dnsFragment.z = false;
                    nj1 nj1Var = dnsFragment.f;
                    nj1Var.getClass();
                    nj1Var.b.setVisibility(0);
                    nj1 nj1Var2 = dnsFragment.f;
                    nj1Var2.getClass();
                    nj1Var2.c.setVisibility(8);
                    nj1 nj1Var3 = dnsFragment.f;
                    nj1Var3.getClass();
                    nj1Var3.a.setText("");
                    nj1 nj1Var4 = dnsFragment.f;
                    nj1Var4.getClass();
                    nj1Var4.a.setOnLongClickListener(null);
                } else if (iOrdinal == 1) {
                    CharSequence charSequence = (CharSequence) obj3;
                    if (charSequence == null || p44.x0(charSequence)) {
                        dnsFragment.z = false;
                        nj1 nj1Var5 = dnsFragment.f;
                        nj1Var5.getClass();
                        nj1Var5.b.setVisibility(8);
                        nj1 nj1Var6 = dnsFragment.f;
                        nj1Var6.getClass();
                        nj1Var6.c.setVisibility(8);
                        nj1 nj1Var7 = dnsFragment.f;
                        nj1Var7.getClass();
                        nj1Var7.a.setText(R.string.no_network);
                        nj1 nj1Var8 = dnsFragment.f;
                        nj1Var8.getClass();
                        nj1Var8.a.setOnLongClickListener(null);
                    } else {
                        obj3.getClass();
                        String str = (String) obj3;
                        dnsFragment.z = true;
                        nj1 nj1Var9 = dnsFragment.f;
                        nj1Var9.getClass();
                        nj1Var9.b.setVisibility(8);
                        nj1 nj1Var10 = dnsFragment.f;
                        nj1Var10.getClass();
                        nj1Var10.c.setVisibility(8);
                        nj1 nj1Var11 = dnsFragment.f;
                        nj1Var11.getClass();
                        nj1Var11.a.setText(vo.p(0, w44.i0(p44.C0(str), " ", "&nbsp;")));
                        nj1 nj1Var12 = dnsFragment.f;
                        nj1Var12.getClass();
                        nj1Var12.a.setOnLongClickListener(new ow0(z ? 1 : 0, str));
                    }
                } else {
                    if (iOrdinal != 2) {
                        g.d();
                        return null;
                    }
                    if (!dnsFragment.z) {
                        dnsFragment.z = false;
                        nj1 nj1Var13 = dnsFragment.f;
                        nj1Var13.getClass();
                        nj1Var13.b.setVisibility(8);
                        nj1 nj1Var14 = dnsFragment.f;
                        nj1Var14.getClass();
                        nj1Var14.c.setVisibility(0);
                        nj1 nj1Var15 = dnsFragment.f;
                        nj1Var15.getClass();
                        nj1Var15.a.setText("");
                        nj1 nj1Var16 = dnsFragment.f;
                        nj1Var16.getClass();
                        nj1Var16.a.setOnLongClickListener(null);
                    }
                }
                return xl4.a;
            case 8:
                ArrayList<String> arrayList = (ArrayList) obj2;
                List list = (List) obj;
                if (arrayList.isEmpty()) {
                    z = true;
                } else {
                    for (String str2 : arrayList) {
                        if (list == null || !list.isEmpty()) {
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                if (n12.c(((zk) it2.next()).getName(), str2)) {
                                }
                                break;
                            }
                        }
                    }
                    z = true;
                }
                return Boolean.valueOf(z);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                tr1 tr1Var = (tr1) obj2;
                rn2 rn2Var = (rn2) obj;
                u33 u33Var = tr1.c;
                Map mapA = rn2Var.a();
                LinkedHashMap linkedHashMap2 = rn2Var.a;
                Iterator it3 = mapA.entrySet().iterator();
                long j = 0;
                while (true) {
                    if (it3.hasNext()) {
                        Map.Entry entry = (Map.Entry) it3.next();
                        if (entry.getValue() instanceof Set) {
                            u33 u33Var2 = (u33) entry.getKey();
                            Set set = (Set) entry.getValue();
                            String strD = tr1Var.d(System.currentTimeMillis());
                            if (set.contains(strD)) {
                                Object[] objArr = {strD};
                                HashSet hashSet = new HashSet(1);
                                Object obj4 = objArr[0];
                                Objects.requireNonNull(obj4);
                                if (hashSet.add(obj4)) {
                                    rn2Var.c(u33Var2, DesugarCollections.unmodifiableSet(hashSet));
                                    j++;
                                } else {
                                    vp1.h(obj4, "duplicate element: ");
                                }
                            } else {
                                u33Var2.getClass();
                                rn2Var.b();
                                linkedHashMap2.remove(u33Var2);
                            }
                        }
                    } else if (j == 0) {
                        u33Var.getClass();
                        rn2Var.b();
                        linkedHashMap2.remove(u33Var);
                    } else {
                        rn2Var.c(u33Var, Long.valueOf(j));
                    }
                }
                return null;
            case 10:
                return ((n00) obj2).m;
            case 11:
                vg3 vg3Var = (vg3) obj2;
                vg3Var.n.getClass();
                vg3Var.l(obj);
                return xl4.a;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return ((th2) obj2).b(((Integer) obj).intValue());
            case 13:
                ((yn2) obj2).n(null);
                return xl4.a;
            case 14:
                qx2.a((qx2) obj2, (List) obj);
                return xl4.a;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                ev1 ev1Var = (ev1) obj2;
                me0 me0Var = (me0) obj;
                me0Var.getClass();
                String str3 = me0Var.d;
                ev1Var.getClass();
                boolean z3 = me0Var.i;
                String str4 = ev1Var.d;
                if (z3) {
                    zV = n12.c(str4, str3);
                } else {
                    Pattern pattern = me0.k;
                    zV = yr2.v(str4, str3);
                }
                if (zV) {
                    String str5 = me0Var.e;
                    String strB = ev1Var.b();
                    if ((strB.equals(str5) || (w44.j0(strB, str5, false) && (w44.d0(str5, "/", false) || strB.charAt(str5.length()) == '/'))) && (!me0Var.f || ev1Var.f())) {
                        z2 = true;
                    }
                }
                return Boolean.valueOf(z2);
            case 16:
                PrivateIPFragment privateIPFragment = (PrivateIPFragment) obj2;
                ei0 ei0Var2 = (ei0) obj;
                int iOrdinal2 = ei0Var2.a.ordinal();
                if (iOrdinal2 == 0) {
                    nj1 nj1Var17 = privateIPFragment.f;
                    nj1Var17.getClass();
                    nj1Var17.b.setVisibility(0);
                    nj1 nj1Var18 = privateIPFragment.f;
                    nj1Var18.getClass();
                    nj1Var18.c.setVisibility(8);
                    nj1 nj1Var19 = privateIPFragment.f;
                    nj1Var19.getClass();
                    nj1Var19.a.setText("");
                    nj1 nj1Var20 = privateIPFragment.f;
                    nj1Var20.getClass();
                    nj1Var20.a.setOnLongClickListener(null);
                } else if (iOrdinal2 == 1) {
                    Object obj5 = ei0Var2.b;
                    if (obj5 != null) {
                        String str6 = (String) obj5;
                        nj1 nj1Var21 = privateIPFragment.f;
                        nj1Var21.getClass();
                        nj1Var21.b.setVisibility(8);
                        nj1 nj1Var22 = privateIPFragment.f;
                        nj1Var22.getClass();
                        nj1Var22.c.setVisibility(8);
                        nj1 nj1Var23 = privateIPFragment.f;
                        nj1Var23.getClass();
                        nj1Var23.a.setText(vo.p(0, w44.i0(p44.C0(str6), " ", "&nbsp;")));
                        nj1 nj1Var24 = privateIPFragment.f;
                        nj1Var24.getClass();
                        nj1Var24.a.setOnLongClickListener(new ow0(i2, str6));
                    } else {
                        nj1 nj1Var25 = privateIPFragment.f;
                        nj1Var25.getClass();
                        nj1Var25.b.setVisibility(8);
                        nj1 nj1Var26 = privateIPFragment.f;
                        nj1Var26.getClass();
                        nj1Var26.c.setVisibility(8);
                        nj1 nj1Var27 = privateIPFragment.f;
                        nj1Var27.getClass();
                        nj1Var27.a.setText(R.string.no_network);
                        nj1 nj1Var28 = privateIPFragment.f;
                        nj1Var28.getClass();
                        nj1Var28.a.setOnLongClickListener(null);
                    }
                } else {
                    if (iOrdinal2 != 2) {
                        g.d();
                        return null;
                    }
                    nj1 nj1Var29 = privateIPFragment.f;
                    nj1Var29.getClass();
                    nj1Var29.b.setVisibility(8);
                    nj1 nj1Var30 = privateIPFragment.f;
                    nj1Var30.getClass();
                    nj1Var30.c.setVisibility(0);
                    nj1 nj1Var31 = privateIPFragment.f;
                    nj1Var31.getClass();
                    nj1Var31.a.setText("");
                    nj1 nj1Var32 = privateIPFragment.f;
                    nj1Var32.getClass();
                    nj1Var32.a.setOnLongClickListener(null);
                }
                return xl4.a;
            case 17:
                ProfileEditorActivity profileEditorActivity = (ProfileEditorActivity) obj2;
                ru2 ru2Var = (ru2) obj;
                int i3 = ProfileEditorActivity.Y0;
                xl4 xl4Var = xl4.a;
                ru2Var.getClass();
                if (profileEditorActivity.V0) {
                    profileEditorActivity.x();
                } else {
                    cm2 cm2Var = profileEditorActivity.S0;
                    if (cm2Var == null) {
                        n12.T("binding");
                        throw null;
                    }
                    jl4 jl4Var = ((CodeEditor) cm2Var.z).J1.z0;
                    if (!jl4Var.f || jl4Var.Y <= 0) {
                        ru2Var.e();
                        profileEditorActivity.b().d();
                    } else {
                        wh2 wh2Var = new wh2(profileEditorActivity);
                        ((p6) wh2Var.z).e = profileEditorActivity.T0;
                        wh2Var.t(R.string.save_profile_prompt);
                        wh2Var.w(R.string.save, new y5(3, profileEditorActivity));
                        wh2Var.v(R.string.exit_without_saving, new li(6, ru2Var, profileEditorActivity));
                        wh2Var.u(R.string.cancel, null);
                        wh2Var.r();
                    }
                }
                return xl4Var;
            case 18:
                bh3 bh3Var = (bh3) obj2;
                t53 t53Var = (t53) obj;
                t53Var.getClass();
                String strN = ha0.n("selected profile decoded: ", t53Var.b);
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("ProfileManager", strN, null);
                }
                d73.c.i(t53Var);
                bh3Var.b = t53Var;
                return xl4.a;
            case 19:
                rj2 rj2Var = (rj2) obj2;
                List<sa3> list2 = (List) obj;
                if (!list2.isEmpty()) {
                    int iU = fh2.U(f70.Q(10, list2));
                    if (iU < 16) {
                        iU = 16;
                    }
                    linkedHashMap = new LinkedHashMap(iU);
                    for (sa3 sa3Var : list2) {
                        linkedHashMap.put(sa3Var.b, sa3Var.c);
                    }
                }
                rj2Var.l(linkedHashMap);
                return xl4.a;
            case 20:
                RecentRequestsActivity recentRequestsActivity = (RecentRequestsActivity) obj2;
                ru2 ru2Var2 = (ru2) obj;
                int i4 = RecentRequestsActivity.X0;
                ru2Var2.getClass();
                SearchView searchView = recentRequestsActivity.T0;
                if (searchView == null || searchView.j1) {
                    ru2Var2.e();
                    recentRequestsActivity.b().d();
                } else {
                    searchView.r(true);
                    SearchView searchView2 = recentRequestsActivity.T0;
                    if (searchView2 != null) {
                        searchView2.setIconified(true);
                    }
                }
                return xl4.a;
            case 21:
                gl1 gl1Var = (gl1) obj;
                gl1Var.getClass();
                ((ew) obj2).g = gl1Var;
                return xl4.a;
            case 22:
                ((go3) obj).getClass();
                return ((pl1) obj2).a();
            case 23:
                io3 io3Var = (io3) obj;
                io3Var.getClass();
                ((am1) obj2).g(new an(io3Var));
                return xl4.a;
            case 24:
                SSHDumpFragment sSHDumpFragment = (SSHDumpFragment) obj2;
                if (jo3.a[((ei0) obj).a.ordinal()] == 1 && (num = (Integer) ws4.g.d()) != null) {
                    oj1 oj1Var = sSHDumpFragment.b;
                    oj1Var.getClass();
                    TextView textView = (TextView) oj1Var.f;
                    String strA = l72.A();
                    if (strA == null) {
                        strA = "0.0.0.0";
                    }
                    textView.setText(sSHDumpFragment.getString(R.string.sshdump_running_template, strA, num));
                }
                return xl4.a;
            case 25:
                es3 es3Var = (es3) obj2;
                int iIntValue = ((Integer) obj).intValue();
                u parentFragmentManager = es3Var.getParentFragmentManager();
                Bundle bundle = new Bundle();
                bundle.putInt("proxy_group_selection", iIntValue);
                xj1 xj1Var = (xj1) parentFragmentManager.n.get("proxy_group_selection");
                if (xj1Var == null || xj1Var.a.b().compareTo(q92.A) < 0) {
                    parentFragmentManager.m.put("proxy_group_selection", bundle);
                } else {
                    xj1Var.b.a(bundle);
                }
                if (u.M(2)) {
                    Log.v("FragmentManager", "Setting fragment result with key proxy_group_selection and result " + bundle);
                }
                Dialog dialog = es3Var.C0;
                if (dialog instanceof po) {
                    po poVar = (po) dialog;
                    if (poVar.Z == null) {
                        poVar.f();
                    }
                    boolean z4 = poVar.Z.a1;
                }
                es3Var.j(false, false);
                return xl4.a;
            case 26:
                obj.getClass();
                return ((t4) obj2).a();
            case 27:
                xw4 xw4Var = (xw4) obj2;
                int i5 = SurfboardApp.A;
                if (((vs4) obj).b) {
                    ez4.X("requestDelAll", new t4(21));
                    if (t23.c(R.string.setting_update_profiles_after_vpn_established_key, false)) {
                        new Handler(Looper.getMainLooper()).postDelayed(new f33(23, xw4Var), 10000L);
                    }
                }
                return xl4.a;
            case 28:
                List list3 = (List) obj;
                int i6 = TrafficListActivity.V0;
                list3.getClass();
                ((TrafficListActivity) obj2).x(list3, null);
                return xl4.a;
            default:
                TrafficUsageFragment trafficUsageFragment = (TrafficUsageFragment) obj2;
                zn znVar = trafficUsageFragment.z;
                if (((vs4) obj).b) {
                    dg4.p.e(trafficUsageFragment.getViewLifecycleOwner(), znVar);
                } else {
                    dg4.p.j(znVar);
                    v92 v92Var = trafficUsageFragment.f;
                    v92Var.getClass();
                    ((MaterialTextView) v92Var.A).setText(" B");
                    v92 v92Var2 = trafficUsageFragment.f;
                    v92Var2.getClass();
                    ((MaterialTextView) v92Var2.X).setText("↑ 0");
                    v92 v92Var3 = trafficUsageFragment.f;
                    v92Var3.getClass();
                    ((MaterialTextView) v92Var3.f).setText(" B");
                    v92 v92Var4 = trafficUsageFragment.f;
                    v92Var4.getClass();
                    ((MaterialTextView) v92Var4.z).setText("↓ 0");
                }
                return xl4.a;
        }
    }

    public /* synthetic */ f0(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }
}
