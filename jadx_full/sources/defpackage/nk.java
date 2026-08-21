package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.preference.Preference;
import com.getsurfboard.R;
import com.getsurfboard.ui.service.SurfboardVpn;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class nk extends j33 {
    private final int preferenceResId;
    private final v23 restartListener = new lk(this);
    private boolean restartVpn;

    public nk(int i) {
        this.preferenceResId = i;
    }

    public static final void j(nk nkVar, Boolean bool) {
        tk3 tk3Var;
        List listK;
        if (bool.booleanValue() || !nkVar.restartVpn) {
            return;
        }
        nkVar.restartVpn = false;
        t53 t53Var = (t53) d73.c.d();
        if (t53Var == null) {
            return;
        }
        Context contextRequireContext = nkVar.requireContext();
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
                    p95.C(R.string.vpn_restarted, new Object[0]);
                } catch (SecurityException e2) {
                    tk3Var = new tk3(e2);
                    Throwable thA = uk3.a(tk3Var);
                    thA.getClass();
                    p95.D(r25.D(thA));
                }
            }
            try {
                contextRequireContext.startService(intent);
                p95.C(R.string.vpn_restarted, new Object[0]);
            } catch (Exception e3) {
                tk3Var = new tk3(e3);
                Throwable thA2 = uk3.a(tk3Var);
                thA2.getClass();
                p95.D(r25.D(thA2));
            }
        } catch (Exception e4) {
            tk3Var = new tk3(e4);
        }
    }

    public static final void k(nk nkVar, View view) {
        vs4 vs4Var = (vs4) ws4.c.d();
        if (vs4Var == null || !vs4Var.b) {
            return;
        }
        nkVar.restartVpn = true;
        Context context = view.getContext();
        context.getClass();
        zw1.d(context);
    }

    public final v23 getRestartListener() {
        return this.restartListener;
    }

    public abstract Set getRestartVPNPreferenceKeys();

    @Override // defpackage.j33
    public void onCreatePreferences(Bundle bundle, String str) {
        setPreferencesFromResource(this.preferenceResId, str);
    }

    @Override // defpackage.j33, androidx.fragment.app.o
    public void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        lk lkVar = new lk(this);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(view, lkVar);
        getListView().setItemAnimator(null);
        getListView().setClipToPadding(false);
        Iterator it = getRestartVPNPreferenceKeys().iterator();
        while (it.hasNext()) {
            Preference preferenceFindPreference = findPreference(getString(((Number) it.next()).intValue()));
            if (preferenceFindPreference != null) {
                preferenceFindPreference.X = this.restartListener;
            }
        }
        ws4.a.e(getViewLifecycleOwner(), new x3(1, new f0(3, this)));
    }

    public final void promptRestartVPN() {
        vs4 vs4Var = (vs4) ws4.c.d();
        if (vs4Var == null || !vs4Var.b || getView() == null) {
            return;
        }
        if (co4.H()) {
            p95.C(R.string.restart_vpn_to_make_changes_take_effect, new Object[0]);
            return;
        }
        oy3 oy3VarG = oy3.g(requireView(), R.string.restart_vpn_to_make_changes_take_effect, 0);
        oy3VarG.i(R.string.restart, new mk(0, this));
        oy3VarG.j();
    }
}
