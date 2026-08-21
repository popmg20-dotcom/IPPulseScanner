package defpackage;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.o;
import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;
import com.getsurfboard.R;
import com.getsurfboard.ui.SurfboardApp;
import com.getsurfboard.ui.fragment.card.LocalProxyFragment;
import com.getsurfboard.ui.fragment.card.NetworkSpeedFragment;
import com.getsurfboard.ui.fragment.card.SSHDumpFragment;
import com.getsurfboard.ui.fragment.settings.OthersSettingsFragment;
import com.getsurfboard.ui.widget.SparklineView;
import com.getsurfboard.vpn.Jni;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.textview.MaterialTextView;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import io.sentry.android.core.a1;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Proxy;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gj implements am1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ gj(int i, Object obj, Object obj2) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0271  */
    @Override // defpackage.am1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Object obj) throws Exception {
        io3 io3VarD0;
        String str;
        int i;
        io3 io3VarD02;
        int i2 = 8;
        int i3 = 0;
        switch (this.b) {
            case 0:
                jj jjVar = (jj) this.f;
                k03 k03Var = (k03) this.z;
                Set set = (Set) obj;
                o oVar = jjVar.a;
                Context contextRequireContext = oVar.requireContext();
                contextRequireContext.getClass();
                View viewInflate = LayoutInflater.from(contextRequireContext).inflate(R.layout.dialog_backup_progress, (ViewGroup) null, false);
                int i4 = R.id.progress;
                if (((ProgressBar) vf2.l(viewInflate, R.id.progress)) != null) {
                    i4 = R.id.stage;
                    MaterialTextView materialTextView = (MaterialTextView) vf2.l(viewInflate, R.id.stage);
                    if (materialTextView != null) {
                        materialTextView.setText(R.string.backup_import);
                        wh2 wh2Var = new wh2(contextRequireContext);
                        wh2Var.x(R.string.backup_import);
                        wh2Var.y((LinearLayout) viewInflate);
                        ((p6) wh2Var.z).n = false;
                        u6 u6VarR = wh2Var.r();
                        da2 viewLifecycleOwner = oVar.getViewLifecycleOwner();
                        viewLifecycleOwner.getClass();
                        ji0.B(uf2.t(viewLifecycleOwner), null, null, new hd(u6VarR, jjVar, (ge0) null, k03Var, set), 3);
                        return xl4.a;
                    }
                }
                zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i4)));
                return null;
            case 1:
                mo0 mo0Var = (mo0) this.f;
                go0 go0Var = (go0) this.z;
                go3 go3Var = (go3) obj;
                go3Var.getClass();
                mo0Var.b.J(go3Var, go0Var);
                return xl4.a;
            case 2:
                b31.d((g91) this.f, (b31) this.z, (List) obj);
                return xl4.a;
            case 3:
                String str2 = (String) this.f;
                e03 e03Var = (e03) this.z;
                List<zk> list = (List) obj;
                if (list == null || !list.isEmpty()) {
                    for (zk zkVar : list) {
                        if (n12.c(zkVar.getName(), str2)) {
                            t53 t53Var = zkVar instanceof t53 ? (t53) zkVar : null;
                            if (t53Var == null || t53Var.f != ((t53) e03Var.b).f) {
                            }
                        }
                    }
                    z = false;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                bh3 bh3Var = (bh3) this.f;
                String str3 = (String) this.z;
                List list2 = (List) obj;
                if (list2 == null || !list2.isEmpty()) {
                    Iterator it = list2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (n12.c(((zk) it.next()).getName(), bh3Var.b)) {
                                if (!list2.isEmpty()) {
                                    Iterator it2 = list2.iterator();
                                    while (it2.hasNext()) {
                                        if (n12.c(((zk) it2.next()).getName(), str3)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 5:
                ((tq1) this.f).z.removeCallbacks((xy0) this.z);
                return xl4.a;
            case 6:
                os1 os1Var = (os1) this.f;
                ArrayList arrayList = (ArrayList) this.z;
                go3 go3Var2 = (go3) obj;
                go3Var2.getClass();
                lo0 lo0Var = os1Var.b;
                io3VarD0 = go3Var2.D0("INSERT OR REPLACE INTO `hosts` (`id`,`key`,`value`) VALUES (nullif(?, 0),?,?)");
                try {
                    for (Object obj2 : arrayList) {
                        if (obj2 != null) {
                            lo0Var.h(io3VarD0, obj2);
                            io3VarD0.C0();
                            io3VarD0.reset();
                        }
                        break;
                    }
                    vf2.e(io3VarD0, null);
                    return xl4.a;
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            case 7:
                Jni.j((Jni) this.f, (k93) this.z, (byte[]) obj);
                return xl4.a;
            case 8:
                View view = (View) this.f;
                LocalProxyFragment localProxyFragment = (LocalProxyFragment) this.z;
                Map map = (Map) obj;
                Object parent = view.getParent();
                parent.getClass();
                View view2 = (View) parent;
                map.getClass();
                if (!map.isEmpty() && t23.f(p10.X)) {
                    i2 = 0;
                }
                view2.setVisibility(i2);
                for (Map.Entry entry : map.entrySet()) {
                    if (((Proxy) entry.getKey()).type() == Proxy.Type.HTTP) {
                        Object value = entry.getValue();
                        eg0 eg0Var = localProxyFragment.f;
                        if (value == null) {
                            eg0Var.getClass();
                            MaterialTextView materialTextView2 = (MaterialTextView) eg0Var.f;
                            SocketAddress socketAddressAddress = ((Proxy) entry.getKey()).address();
                            socketAddressAddress.getClass();
                            String strG0 = tj4.g0(socketAddressAddress);
                            String strA = l72.A();
                            if (strA == null) {
                                strA = "0.0.0.0";
                            }
                            materialTextView2.setText(w44.i0(strG0, "0.0.0.0", strA));
                        } else {
                            eg0Var.getClass();
                            MaterialTextView materialTextView3 = (MaterialTextView) eg0Var.f;
                            Throwable th = (Throwable) entry.getValue();
                            materialTextView3.setText(th != null ? th.getMessage() : null);
                        }
                    } else if (((Proxy) entry.getKey()).type() == Proxy.Type.SOCKS) {
                        Object value2 = entry.getValue();
                        eg0 eg0Var2 = localProxyFragment.f;
                        if (value2 == null) {
                            eg0Var2.getClass();
                            MaterialTextView materialTextView4 = (MaterialTextView) eg0Var2.z;
                            SocketAddress socketAddressAddress2 = ((Proxy) entry.getKey()).address();
                            socketAddressAddress2.getClass();
                            String strG02 = tj4.g0(socketAddressAddress2);
                            String strA2 = l72.A();
                            if (strA2 == null) {
                                strA2 = "0.0.0.0";
                            }
                            materialTextView4.setText(w44.i0(strG02, "0.0.0.0", strA2));
                        } else {
                            eg0Var2.getClass();
                            MaterialTextView materialTextView5 = (MaterialTextView) eg0Var2.z;
                            Throwable th2 = (Throwable) entry.getValue();
                            materialTextView5.setText(th2 != null ? th2.getMessage() : null);
                        }
                    }
                }
                return xl4.a;
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                ((z14) this.f).g(null);
                ((q53) this.z).e((qc0) obj);
                return xl4.a;
            case 10:
                NetworkSpeedFragment networkSpeedFragment = (NetworkSpeedFragment) this.f;
                View view3 = (View) this.z;
                vs4 vs4Var = (vs4) obj;
                networkSpeedFragment.j();
                zn znVar = networkSpeedFragment.z0;
                f33 f33Var = networkSpeedFragment.y0;
                cm2 cm2Var = networkSpeedFragment.z;
                cm2Var.getClass();
                ((SparklineView) cm2Var.X).setValues(networkSpeedFragment.A);
                if (vs4Var == null || !vs4Var.b) {
                    dg4.p.j(znVar);
                    view3.removeCallbacks(f33Var);
                } else {
                    dg4.p.e(networkSpeedFragment.getViewLifecycleOwner(), znVar);
                    view3.removeCallbacks(f33Var);
                    view3.post(f33Var);
                }
                return xl4.a;
            case 11:
                return OthersSettingsFragment.onResume$lambda$0((Preference) this.f, (OthersSettingsFragment) this.z, (yo4) obj);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                a33 a33Var = (a33) this.f;
                z23 z23Var = (z23) this.z;
                go3 go3Var3 = (go3) obj;
                go3Var3.getClass();
                a33Var.b.J(go3Var3, z23Var);
                return xl4.a;
            case 13:
                zg3 zg3Var = (zg3) this.f;
                pl1 pl1Var = (pl1) this.z;
                String str4 = (String) obj;
                str4.getClass();
                int i5 = zg3Var.b + 1;
                zg3Var.b = i5;
                if (i5 % 1000 == 0 && pl1Var != null) {
                    pl1Var.a();
                }
                return Boolean.valueOf((str4.length() <= 0 || p44.M0(str4, '#') || p44.M0(str4, ';') || w44.j0(str4, "//", false)) ? false : true);
            case 14:
                File file = (File) this.f;
                List list3 = (List) this.z;
                t53 t53Var2 = (t53) obj;
                t53Var2.getClass();
                try {
                    ji0.w(t53Var2);
                    t53Var2.M0 = file.lastModified();
                    list3.add(t53Var2);
                    String str5 = "onSuccess: " + t53Var2.b;
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 1, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str5);
                        str = str5;
                    } else {
                        str = str5;
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        Log.d("ProfileManager", str, null);
                    }
                    return xl4.a;
                } catch (Exception e) {
                    String str6 = t53Var2.b + " " + e.getMessage();
                    if (fy4.b) {
                        Xlog.logWrite2(0L, 4, "ProfileManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str6);
                    }
                    if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                        a1.e("ProfileManager", str6, null);
                    }
                    return Boolean.valueOf(list3.add(new p12(t53Var2.b, file.lastModified(), t53Var2.f, t53Var2.z, e.getMessage())));
                }
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                d83 d83Var = (d83) this.f;
                ji0.B(uf2.t(d83Var), null, null, new oo1(d83Var, (List) this.z, ((Boolean) obj).booleanValue(), (ge0) null, 3), 3);
                return xl4.a;
            case 16:
                ua3 ua3Var = (ua3) this.f;
                sa3[] sa3VarArr = (sa3[]) this.z;
                go3 go3Var4 = (go3) obj;
                go3Var4.getClass();
                lo0 lo0Var2 = ua3Var.b;
                io3VarD0 = go3Var4.D0("INSERT OR REPLACE INTO `proxy_group_selection` (`profileName`,`groupName`,`selection`) VALUES (?,?,?)");
                while (i3 < sa3VarArr.length) {
                    try {
                        int i6 = i3 + 1;
                        try {
                            sa3 sa3Var = sa3VarArr[i3];
                            if (sa3Var != null) {
                                lo0Var2.h(io3VarD0, sa3Var);
                                io3VarD0.C0();
                                io3VarD0.reset();
                            }
                            i3 = i6;
                        } catch (ArrayIndexOutOfBoundsException e2) {
                            throw new NoSuchElementException(e2.getMessage());
                        }
                    } catch (Throwable th3) {
                    }
                }
                vf2.e(io3VarD0, null);
                return xl4.a;
            case 17:
                ya3 ya3Var = (ya3) this.f;
                t53 t53Var3 = (t53) this.z;
                String str7 = (String) obj;
                if (str7 != null) {
                    pa3 pa3Var = ya3Var.z;
                    na3 na3Var = ya3Var.y0;
                    if (pa3Var == null) {
                        if (na3Var == null) {
                            n12.T("proxyGroup");
                            throw null;
                        }
                        ya3Var.z = new pa3(t53Var3, na3Var, str7, ya3Var.Y, new cd(5, ya3Var));
                        ed4 ed4Var = ya3Var.b;
                        ed4Var.getClass();
                        ((RecyclerView) ed4Var.A).setAdapter(ya3Var.z);
                        ed4 ed4Var2 = ya3Var.b;
                        ed4Var2.getClass();
                        ((LoadingIndicator) ed4Var2.z).setVisibility(8);
                    } else {
                        if (na3Var == null) {
                            n12.T("proxyGroup");
                            throw null;
                        }
                        if (!(na3Var instanceof ja3)) {
                            List list4 = pa3Var.d.f;
                            list4.getClass();
                            Iterator it3 = list4.iterator();
                            int i7 = 0;
                            while (true) {
                                i = -1;
                                if (!it3.hasNext()) {
                                    i7 = -1;
                                } else if (!n12.c(((f82) it3.next()).z, pa3Var.g)) {
                                    i7++;
                                }
                            }
                            List list5 = pa3Var.d.f;
                            list5.getClass();
                            Iterator it4 = list5.iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    if (n12.c(((f82) it4.next()).z, str7)) {
                                        i = i3;
                                    } else {
                                        i3++;
                                    }
                                }
                            }
                            if (i7 != i) {
                                pa3Var.g = str7;
                                pa3Var.a.d(i7, 1, Boolean.FALSE);
                                pa3Var.a.d(i, 1, Boolean.TRUE);
                            }
                        }
                    }
                } else {
                    na3 na3Var2 = ya3Var.y0;
                    if (na3Var2 == null) {
                        n12.T("proxyGroup");
                        throw null;
                    }
                    if (!(na3Var2 instanceof ja3)) {
                        String str8 = ya3Var.Z;
                        if (str8 == null) {
                            n12.T("profileName");
                            throw null;
                        }
                        String strU = fw.u("can not find selection for ", str8, ": ", na3Var2.getName());
                        if (fy4.b) {
                            Xlog.logWrite2(0L, 4, "ProxyGroupTabFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strU);
                        }
                        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                            a1.e("ProxyGroupTabFragment", strU, null);
                        }
                    }
                }
                return xl4.a;
            case 18:
                ij3 ij3Var = (ij3) this.f;
                zi3 zi3Var = (zi3) this.z;
                go3 go3Var5 = (go3) obj;
                go3Var5.getClass();
                ij3Var.b.J(go3Var5, zi3Var);
                return xl4.a;
            case 19:
                View view4 = (View) this.f;
                SSHDumpFragment sSHDumpFragment = (SSHDumpFragment) this.z;
                Integer num = (Integer) obj;
                if (num == null) {
                    Object parent2 = view4.getParent();
                    parent2.getClass();
                    ((View) parent2).setVisibility(8);
                } else {
                    Object parent3 = view4.getParent();
                    parent3.getClass();
                    ((View) parent3).setVisibility(0);
                    oj1 oj1Var = sSHDumpFragment.b;
                    oj1Var.getClass();
                    TextView textView = (TextView) oj1Var.f;
                    String strA3 = l72.A();
                    textView.setText(sSHDumpFragment.getString(R.string.sshdump_running_template, strA3 != null ? strA3 : "0.0.0.0", num));
                }
                return xl4.a;
            case 20:
                xg3 xg3Var = (xg3) this.f;
                xw4 xw4Var = (xw4) this.z;
                List<zk> list6 = (List) obj;
                int i8 = SurfboardApp.A;
                String strA4 = dw2.A(list6.size(), "profile list refresh: ");
                if (fy4.b) {
                    Xlog.logWrite2(0L, 1, "SurfboardApp", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strA4);
                }
                if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                    Log.d("SurfboardApp", strA4, null);
                }
                ArrayList arrayList2 = new ArrayList(f70.Q(10, list6));
                for (zk zkVar2 : list6) {
                    tj4.z(zkVar2, xw4Var, false);
                    arrayList2.add(zkVar2.getName());
                }
                if (!xg3Var.b) {
                    for (String str9 : t23.k()) {
                        if (!arrayList2.contains(str9)) {
                            t23.F(str9);
                        }
                    }
                }
                xg3Var.b = false;
                return xl4.a;
            case 21:
                m94 m94Var = (m94) this.f;
                k94 k94Var = (k94) this.z;
                go3 go3Var6 = (go3) obj;
                go3Var6.getClass();
                m94Var.b.J(go3Var6, k94Var);
                return xl4.a;
            case 22:
                e03 e03Var2 = (e03) this.f;
                bh3 bh3Var2 = (bh3) this.z;
                InputStream inputStream = (InputStream) obj;
                if (inputStream != null) {
                    Charset charset = y30.a;
                    String strT = l72.T(new BufferedReader(new InputStreamReader(inputStream, charset), 8192));
                    String strG03 = p44.G0(".conf", (String) e03Var2.b);
                    byte[] bytes = strT.getBytes(charset);
                    bytes.getClass();
                    Serializable serializableJ = c63.j(strG03, new ByteArrayInputStream(bytes), k01.A, t60.Y, vd3.A, null);
                    Throwable thA = uk3.a(serializableJ);
                    if (thA == null) {
                        bh3Var2.b = (e03) serializableJ;
                    } else {
                        thA.printStackTrace();
                    }
                }
                return xl4.a;
            case 23:
                ax4 ax4Var = (ax4) this.f;
                zw4 zw4Var = (zw4) this.z;
                go3 go3Var7 = (go3) obj;
                go3Var7.getClass();
                ax4Var.b.J(go3Var7, zw4Var);
                return xl4.a;
            case 24:
                ww4 ww4Var = (ww4) this.f;
                String str10 = (String) this.z;
                go3 go3Var8 = (go3) obj;
                go3Var8.getClass();
                io3VarD02 = go3Var8.D0("UPDATE workspec SET state=? WHERE id=?");
                try {
                    io3VarD02.j(1, uf2.Q(ww4Var));
                    io3VarD02.K(2, str10);
                    io3VarD02.C0();
                    int iC = r25.C(go3Var8);
                    io3VarD02.close();
                    return Integer.valueOf(iC);
                } finally {
                }
            case 25:
                di0 di0Var = (di0) this.f;
                String str11 = (String) this.z;
                go3 go3Var9 = (go3) obj;
                go3Var9.getClass();
                io3VarD02 = go3Var9.D0("UPDATE workspec SET output=? WHERE id=?");
                try {
                    di0 di0Var2 = di0.b;
                    io3VarD02.k(1, ek0.F(di0Var));
                    io3VarD02.K(2, str11);
                    io3VarD02.C0();
                    io3VarD02.close();
                    return xl4.a;
                } finally {
                }
            default:
                lx4 lx4Var = (lx4) this.f;
                kx4 kx4Var = (kx4) this.z;
                go3 go3Var10 = (go3) obj;
                go3Var10.getClass();
                lx4Var.b.J(go3Var10, kx4Var);
                return xl4.a;
        }
    }
}
