package defpackage;

import android.app.StatusBarManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.service.quicksettings.TileService;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.o;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.service.SurfboardTile;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.getsurfboard.ui.widget.MetroLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.divider.MaterialDivider;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import j$.util.function.Consumer$CC;
import java.io.FileOutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class xh0 extends o implements jv2 {
    public r4 A;
    public final f33 X = new f33(4, this);
    public final jh0 Y = new jh0(this, 0);
    public boolean Z;
    public j80 b;
    public r4 f;
    public r4 z;

    public static final void k(final xh0 xh0Var, Boolean bool) {
        StatusBarManager statusBarManager;
        NetworkInfo activeNetworkInfo;
        Network network;
        LinkProperties linkProperties;
        int i = 2;
        int i2 = 0;
        if (!n12.c(bool, Boolean.TRUE)) {
            j80 j80Var = xh0Var.b;
            j80Var.getClass();
            ((ExtendedFloatingActionButton) j80Var.b).v(2);
            j80 j80Var2 = xh0Var.b;
            j80Var2.getClass();
            ((ExtendedFloatingActionButton) j80Var2.b).setIconResource(R.drawable.ic_round_play_arrow_24);
            j80 j80Var3 = xh0Var.b;
            j80Var3.getClass();
            ((ExtendedFloatingActionButton) j80Var3.b).setText(R.string.empty);
            j80 j80Var4 = xh0Var.b;
            j80Var4.getClass();
            ((ExtendedFloatingActionButton) j80Var4.b).setContentDescription(xh0Var.getString(R.string.start_vpn));
            xh0Var.Z = false;
            return;
        }
        if (!t23.c(R.string.setting_accessibility_mode_key, false)) {
            j80 j80Var5 = xh0Var.b;
            j80Var5.getClass();
            ((ExtendedFloatingActionButton) j80Var5.b).setText(R.string.starting);
            j80 j80Var6 = xh0Var.b;
            j80Var6.getClass();
            ((ExtendedFloatingActionButton) j80Var6.b).v(3);
        }
        j80 j80Var7 = xh0Var.b;
        j80Var7.getClass();
        ((ExtendedFloatingActionButton) j80Var7.b).setIconResource(R.drawable.ic_round_stop_24);
        if (xh0Var.getContext() == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && (activeNetworkInfo = ContextUtilsKt.b().getActiveNetworkInfo()) != null) {
            Network[] allNetworks = ContextUtilsKt.b().getAllNetworks();
            allNetworks.getClass();
            int length = allNetworks.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    network = null;
                    break;
                }
                network = allNetworks[i3];
                if (l72.N(ContextUtilsKt.b().getNetworkInfo(network), activeNetworkInfo)) {
                    break;
                } else {
                    i3++;
                }
            }
            if (network != null && (linkProperties = ContextUtilsKt.b().getLinkProperties(network)) != null && linkProperties.isPrivateDnsActive() && kx0.c().e(linkProperties.getPrivateDnsServerName())) {
                wh2 wh2Var = new wh2(xh0Var.requireContext());
                wh2Var.x(R.string.warning);
                String string = xh0Var.getString(R.string.dot_enabled, xh0Var.getString(R.string.app_name), xh0Var.getString(R.string.app_name));
                p6 p6Var = (p6) wh2Var.z;
                p6Var.g = string;
                p6Var.p = new np1(xh0Var, i);
                wh2Var.w(R.string.go_to_settings, new mh0(xh0Var, i2));
                wh2Var.u(R.string.cancel, null);
                wh2Var.r();
                return;
            }
        }
        if (!t23.c(R.string.setting_disable_check_notification_key, false) && !new vs2(ContextUtilsKt.getContext()).a() && !t23.c(R.string.setting_hide_status_bar_icon_and_notification_key, false)) {
            if (t23.c(R.string.setting_disable_check_notification_key, false) || new vs2(ContextUtilsKt.getContext()).a() || t23.c(R.string.setting_hide_status_bar_icon_and_notification_key, false)) {
                return;
            }
            j80 j80Var8 = xh0Var.b;
            j80Var8.getClass();
            oy3 oy3VarH = oy3.h((CoordinatorLayout) j80Var8.a, xh0Var.getString(R.string.notification_disabled, xh0Var.getString(R.string.app_name)), -2);
            oy3VarH.i.setAnimationMode(0);
            oy3VarH.i(R.string.go_and_check, new lh0(xh0Var, i));
            oy3VarH.j();
            return;
        }
        if (Build.VERSION.SDK_INT < 33 || t23.d("add_quick_tile_prompt_displayed", false) || t23.d("quick_tile_added", false) || (statusBarManager = (StatusBarManager) xh0Var.requireContext().getSystemService(StatusBarManager.class)) == null) {
            return;
        }
        final ComponentName componentName = new ComponentName(xh0Var.requireContext(), (Class<?>) SurfboardTile.class);
        final ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        statusBarManager.requestAddTileService(componentName, xh0Var.getString(R.string.start_vpn), Icon.createWithResource(xh0Var.requireContext(), R.drawable.ic_tile), executorServiceNewSingleThreadExecutor, new Consumer() { // from class: oh0
            @Override // java.util.function.Consumer
            /* JADX INFO: renamed from: accept */
            public final void n(Object obj) {
                xh0.n(this.a, componentName, executorServiceNewSingleThreadExecutor, (Integer) obj);
            }

            public /* synthetic */ Consumer andThen(Consumer consumer) {
                return Consumer$CC.$default$andThen(this, consumer);
            }
        });
        SharedPreferences.Editor editorEdit = t23.l().edit();
        editorEdit.putBoolean("add_quick_tile_prompt_displayed", true);
        editorEdit.apply();
    }

    public static final void l(final xh0 xh0Var, uk3 uk3Var) {
        Object obj = uk3Var.b;
        final int i = 0;
        if (obj instanceof tk3) {
            Throwable thA = uk3.a(obj);
            if (thA != null) {
                thA.printStackTrace();
            }
            j80 j80Var = xh0Var.b;
            j80Var.getClass();
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var.a;
            coordinatorLayout.getClass();
            r25.R(coordinatorLayout, R.string.prepare_vpn_failed, new Object[0]);
            return;
        }
        n12.S(obj);
        final int i2 = 1;
        if (!((Boolean) obj).booleanValue()) {
            Context contextRequireContext = xh0Var.requireContext();
            contextRequireContext.getClass();
            try {
                PackageManager packageManagerH = ContextUtilsKt.h();
                String string = Settings.Secure.getString(contextRequireContext.getContentResolver(), "always_on_vpn_app");
                if (string != null) {
                    CharSequence applicationLabel = packageManagerH.getApplicationLabel(k2.a(packageManagerH, string));
                    applicationLabel.getClass();
                    Intent intent = new Intent("android.net.vpn.SETTINGS");
                    intent.setFlags(intent.getFlags() + 268435456);
                    if (intent.resolveActivity(packageManagerH) != null) {
                        wh2 wh2Var = new wh2(contextRequireContext);
                        wh2Var.x(R.string.get_vpn_permission_failed);
                        ((p6) wh2Var.z).g = xh0Var.getString(R.string.always_on_vpn_occupied, applicationLabel);
                        wh2Var.u(R.string.cancel, null);
                        wh2Var.w(R.string.go_and_check, new li(3, xh0Var, intent));
                        wh2Var.r();
                    }
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
            j80 j80Var2 = xh0Var.b;
            j80Var2.getClass();
            CoordinatorLayout coordinatorLayout2 = (CoordinatorLayout) j80Var2.a;
            coordinatorLayout2.getClass();
            r25.R(coordinatorLayout2, R.string.prepare_vpn_failed, new Object[0]);
            return;
        }
        final t53 t53Var = (t53) d73.c.d();
        if (t53Var == null) {
            j80 j80Var3 = xh0Var.b;
            j80Var3.getClass();
            CoordinatorLayout coordinatorLayout3 = (CoordinatorLayout) j80Var3.a;
            coordinatorLayout3.getClass();
            r25.R(coordinatorLayout3, R.string.no_valid_profiles_existed, new Object[0]);
            return;
        }
        ArrayList<tn3> arrayList = t53Var.J0;
        if (Build.VERSION.SDK_INT >= 27) {
            if (arrayList == null || !arrayList.isEmpty()) {
                for (tn3 tn3Var : arrayList) {
                    if ((tn3Var instanceof nn3) || (tn3Var instanceof kn3)) {
                        break;
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : arrayList) {
                if (obj2 instanceof jn3) {
                    arrayList2.add(obj2);
                }
            }
            Iterator it = arrayList2.iterator();
            loop1: while (true) {
                if (it.hasNext()) {
                    List<tn3> list = ((jn3) it.next()).z;
                    if (list == null || !list.isEmpty()) {
                        for (tn3 tn3Var2 : list) {
                            if ((tn3Var2 instanceof nn3) || (tn3Var2 instanceof kn3)) {
                                break loop1;
                            }
                        }
                    }
                } else {
                    Collection collectionValues = t53Var.H0.values();
                    collectionValues.getClass();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj3 : collectionValues) {
                        if (obj3 instanceof la3) {
                            arrayList3.add(obj3);
                        }
                    }
                    if (!arrayList3.isEmpty()) {
                        Iterator it2 = arrayList3.iterator();
                        while (it2.hasNext()) {
                            Set<qn3> setKeySet = ((la3) it2.next()).A.keySet();
                            setKeySet.getClass();
                            if (!setKeySet.isEmpty()) {
                                for (qn3 qn3Var : setKeySet) {
                                    if ((qn3Var instanceof nn3) || (qn3Var instanceof kn3)) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            boolean z = v9.a(xh0Var.requireContext(), "android.permission.ACCESS_FINE_LOCATION") == 0;
            int i3 = Build.VERSION.SDK_INT;
            boolean z2 = i3 < 29 || v9.a(xh0Var.requireContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
            if (!z) {
                wh2 wh2Var2 = new wh2(xh0Var.requireContext());
                wh2Var2.x(R.string.permission_requirement);
                wh2Var2.t(R.string.gps_permission_request);
                wh2Var2.w(R.string.grant_permission, new mh0(xh0Var, i2));
                wh2Var2.v(R.string.ignore_and_continue, new DialogInterface.OnClickListener(xh0Var) { // from class: nh0
                    public final /* synthetic */ xh0 f;

                    {
                        this.f = xh0Var;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i4) {
                        int i5 = i;
                        t53 t53Var2 = t53Var;
                        xh0 xh0Var2 = this.f;
                        switch (i5) {
                            case 0:
                                Context contextRequireContext2 = xh0Var2.requireContext();
                                contextRequireContext2.getClass();
                                xh0Var2.m(contextRequireContext2, t53Var2);
                                break;
                            default:
                                Context contextRequireContext3 = xh0Var2.requireContext();
                                contextRequireContext3.getClass();
                                xh0Var2.m(contextRequireContext3, t53Var2);
                                break;
                        }
                    }
                });
                wh2Var2.u(R.string.cancel, null);
                wh2Var2.r();
                return;
            }
            if (i3 < 29 || z2) {
                Context contextRequireContext2 = xh0Var.requireContext();
                contextRequireContext2.getClass();
                xh0Var.m(contextRequireContext2, t53Var);
                return;
            }
            wh2 wh2Var3 = new wh2(xh0Var.requireContext());
            wh2Var3.x(R.string.permission_requirement);
            ((p6) wh2Var3.z).g = xh0Var.getString(R.string.background_gps_permission_request_template, xh0Var.getString(R.string.app_name), i3 >= 30 ? ContextUtilsKt.h().getBackgroundPermissionOptionLabel() : xh0Var.getString(R.string.allow_all_the_time));
            wh2Var3.w(R.string.grant_permission, new mh0(xh0Var, 2));
            wh2Var3.v(R.string.ignore_and_continue, new DialogInterface.OnClickListener(xh0Var) { // from class: nh0
                public final /* synthetic */ xh0 f;

                {
                    this.f = xh0Var;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    int i5 = i2;
                    t53 t53Var2 = t53Var;
                    xh0 xh0Var2 = this.f;
                    switch (i5) {
                        case 0:
                            Context contextRequireContext22 = xh0Var2.requireContext();
                            contextRequireContext22.getClass();
                            xh0Var2.m(contextRequireContext22, t53Var2);
                            break;
                        default:
                            Context contextRequireContext3 = xh0Var2.requireContext();
                            contextRequireContext3.getClass();
                            xh0Var2.m(contextRequireContext3, t53Var2);
                            break;
                    }
                }
            });
            wh2Var3.u(R.string.cancel, null);
            wh2Var3.r();
            return;
        }
        Context contextRequireContext3 = xh0Var.requireContext();
        contextRequireContext3.getClass();
        xh0Var.m(contextRequireContext3, t53Var);
    }

    public static final void n(xh0 xh0Var, ComponentName componentName, ExecutorService executorService, Integer num) {
        Context context = xh0Var.getContext();
        if (context == null) {
            return;
        }
        if (num != null && num.intValue() == 2) {
            TileService.requestListeningState(context, componentName);
            t23.C(true);
        } else if (num != null && num.intValue() == 1) {
            t23.C(true);
        } else if (num != null && num.intValue() == 0) {
            t23.C(false);
        }
        executorService.shutdown();
    }

    @Override // defpackage.jv2
    public final void c() {
        j80 j80Var = this.b;
        if (j80Var != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) j80Var.d;
            nestedScrollView.u(0 - nestedScrollView.getScrollX(), 0 - nestedScrollView.getScrollY(), ContextUtilsKt.getContext().getResources().getInteger(android.R.integer.config_shortAnimTime), false);
        }
    }

    public final void j(Context context) {
        ji0.B(uf2.t(this), null, null, new hj(this, context, null, 10), 3);
    }

    public final void m(Context context, t53 t53Var) {
        xh0 xh0Var;
        tk3 tk3Var;
        List listK;
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
            Intent intent = new Intent(context, (Class<?>) SurfboardVpn.class);
            k2.l(new FileOutputStream(zw1.b()), t53Var);
            intent.putExtra("start", true);
            intent.putExtra("vpn_config", rs4Var);
            if (yw1.G0) {
                try {
                    v9.z(context, intent);
                    return;
                } catch (SecurityException e2) {
                    tk3Var = new tk3(e2);
                    xh0Var = this;
                }
            } else {
                xh0Var = this;
                try {
                    context.startService(intent);
                    return;
                } catch (Exception e3) {
                    tk3Var = new tk3(e3);
                }
            }
        } catch (Exception e4) {
            xh0Var = this;
            tk3Var = new tk3(e4);
        }
        j80 j80Var = xh0Var.b;
        j80Var.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var.a;
        coordinatorLayout.getClass();
        Throwable thA = uk3.a(tk3Var);
        thA.getClass();
        r25.S(coordinatorLayout, r25.D(thA));
    }

    @Override // androidx.fragment.app.o
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r4 r4VarRegisterForActivityResult = registerForActivityResult(new ss4(), this.Y);
        r4VarRegisterForActivityResult.getClass();
        this.f = r4VarRegisterForActivityResult;
        int i = 5;
        r4 r4VarRegisterForActivityResult2 = registerForActivityResult(new n4(i), new jh0(this, 4));
        r4VarRegisterForActivityResult2.getClass();
        this.z = r4VarRegisterForActivityResult2;
        r4 r4VarRegisterForActivityResult3 = registerForActivityResult(new n4(i), new ad0(7));
        r4VarRegisterForActivityResult3.getClass();
        this.A = r4VarRegisterForActivityResult3;
        if (bundle != null) {
            this.Z = bundle.getBoolean("system_time_error_dialog_shown");
        }
    }

    @Override // androidx.fragment.app.o
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View viewInflate = layoutInflater.inflate(R.layout.fragment_dashboard, viewGroup, false);
        int i = R.id.appbar;
        if (((AppBarLayout) vf2.l(viewInflate, R.id.appbar)) != null) {
            i = R.id.fab;
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) vf2.l(viewInflate, R.id.fab);
            if (extendedFloatingActionButton != null) {
                i = R.id.include_dashboard;
                View viewL = vf2.l(viewInflate, R.id.include_dashboard);
                if (viewL != null) {
                    int i2 = R.id.active_connections;
                    if (((FragmentContainerView) vf2.l(viewL, R.id.active_connections)) != null) {
                        i2 = R.id.dns;
                        if (((FragmentContainerView) vf2.l(viewL, R.id.dns)) != null) {
                            i2 = R.id.local_proxy;
                            if (((FragmentContainerView) vf2.l(viewL, R.id.local_proxy)) != null) {
                                i2 = R.id.outbound_mode;
                                if (((FragmentContainerView) vf2.l(viewL, R.id.outbound_mode)) != null) {
                                    i2 = R.id.private_ip;
                                    if (((FragmentContainerView) vf2.l(viewL, R.id.private_ip)) != null) {
                                        i2 = R.id.public_ip;
                                        if (((FragmentContainerView) vf2.l(viewL, R.id.public_ip)) != null) {
                                            i2 = R.id.speed_spark;
                                            if (((FragmentContainerView) vf2.l(viewL, R.id.speed_spark)) != null) {
                                                i2 = R.id.sshdump;
                                                if (((FragmentContainerView) vf2.l(viewL, R.id.sshdump)) != null) {
                                                    i2 = R.id.traffic_usage;
                                                    if (((FragmentContainerView) vf2.l(viewL, R.id.traffic_usage)) != null) {
                                                        oj1 oj1Var = new oj1(8, (MetroLayout) viewL);
                                                        i = R.id.scroll_view;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) vf2.l(viewInflate, R.id.scroll_view);
                                                        if (nestedScrollView != null) {
                                                            i = R.id.toggle_cards;
                                                            MaterialButton materialButton = (MaterialButton) vf2.l(viewInflate, R.id.toggle_cards);
                                                            if (materialButton != null) {
                                                                i = R.id.toggle_cards_container;
                                                                LinearLayout linearLayout = (LinearLayout) vf2.l(viewInflate, R.id.toggle_cards_container);
                                                                if (linearLayout != null) {
                                                                    i = R.id.toolbar;
                                                                    Toolbar toolbar = (Toolbar) vf2.l(viewInflate, R.id.toolbar);
                                                                    if (toolbar != null) {
                                                                        i = R.id.toolbar_divider;
                                                                        MaterialDivider materialDivider = (MaterialDivider) vf2.l(viewInflate, R.id.toolbar_divider);
                                                                        if (materialDivider != null) {
                                                                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) viewInflate;
                                                                            this.b = new j80(coordinatorLayout, extendedFloatingActionButton, oj1Var, nestedScrollView, materialButton, linearLayout, toolbar, materialDivider);
                                                                            coordinatorLayout.getClass();
                                                                            return coordinatorLayout;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    zo2.n("Missing required view with ID: ".concat(viewL.getResources().getResourceName(i2)));
                    return null;
                }
            }
        }
        zo2.n("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
        return null;
    }

    @Override // androidx.fragment.app.o
    public final void onDestroyView() {
        j80 j80Var = this.b;
        j80Var.getClass();
        ((ExtendedFloatingActionButton) j80Var.b).removeCallbacks(this.X);
        boolean z = nj3.a;
        nj3.e.d(this);
        super.onDestroyView();
        this.b = null;
    }

    @Override // androidx.fragment.app.o
    public final void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        cr2.e();
        cr2.b();
    }

    @Override // androidx.fragment.app.o
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.getClass();
        bundle.putBoolean("system_time_error_dialog_shown", this.Z);
    }

    @Override // androidx.fragment.app.o
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        int i = 2;
        int i2 = 0;
        ws4.a.e(getViewLifecycleOwner(), new yh0(0, new kh0(this, i)));
        ws4.c.e(getViewLifecycleOwner(), new yh0(0, new kh0(this, 4)));
        ws4.b.e(getViewLifecycleOwner(), new yh0(0, new kh0(this, 5)));
        ws4.h.e(getViewLifecycleOwner(), new yh0(0, new kh0(this, 6)));
        d73.c.e(getViewLifecycleOwner(), new yh0(0, new kh0(this, i2)));
        j80 j80Var = this.b;
        j80Var.getClass();
        ((ExtendedFloatingActionButton) j80Var.b).setOnClickListener(new lh0(this, i2));
        j80 j80Var2 = this.b;
        j80Var2.getClass();
        Menu menu = ((Toolbar) j80Var2.g).getMenu();
        int i3 = 1;
        if (menu instanceof nk2) {
            ((nk2) menu).s = true;
        }
        j80 j80Var3 = this.b;
        j80Var3.getClass();
        ((Toolbar) j80Var3.g).setOnMenuItemClickListener(new jh0(this, i3));
        j80 j80Var4 = this.b;
        j80Var4.getClass();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) j80Var4.a;
        jh0 jh0Var = new jh0(this, i);
        WeakHashMap weakHashMap = wp4.a;
        mp4.c(coordinatorLayout, jh0Var);
        j80 j80Var5 = this.b;
        j80Var5.getClass();
        int i4 = 3;
        ((NestedScrollView) j80Var5.d).setOnScrollChangeListener(new jh0(this, i4));
        j80 j80Var6 = this.b;
        j80Var6.getClass();
        ((MaterialButton) j80Var6.e).setOnClickListener(new lh0(this, i3));
        ji0.B(uf2.t(this), null, null, new sh0(this, null, i2), 3);
        if (bundle == null && !t23.d("location_permission_explanation_viewed", false)) {
            j80 j80Var7 = this.b;
            j80Var7.getClass();
            oy3 oy3VarG = oy3.g((CoordinatorLayout) j80Var7.a, R.string.location_permission_usage_explanation, -2);
            oy3VarG.i(R.string.view, new lh0(this, i4));
            oy3VarG.j();
        }
        j80 j80Var8 = this.b;
        j80Var8.getClass();
        ((LinearLayout) j80Var8.f).post(new qh0(this, i2));
        cr2.a.e(getViewLifecycleOwner(), new yh0(0, new kh0(this, i4)));
    }
}
