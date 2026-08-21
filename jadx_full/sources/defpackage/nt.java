package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.fragment.app.a;
import androidx.fragment.app.o;
import androidx.fragment.app.u;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.getsurfboard.R;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.fragment.MemoryUsageFragment;
import com.getsurfboard.ui.fragment.settings.TwoPanePreferenceFragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.loadingindicator.LoadingIndicator;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nt implements pl1 {
    public final /* synthetic */ Object A;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;
    public final /* synthetic */ Object z;

    public /* synthetic */ nt(int i, Object obj, Object obj2, Object obj3) {
        this.b = i;
        this.f = obj;
        this.z = obj2;
        this.A = obj3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [ge0] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.fragment.app.o, d83] */
    @Override // defpackage.pl1
    public final Object a() {
        String str;
        List list;
        int i = this.b;
        ?? r3 = 0;
        x53 x53Var = null;
        xl4 xl4Var = xl4.a;
        Object obj = this.A;
        Object obj2 = this.z;
        Object obj3 = this.f;
        switch (i) {
            case 0:
                bh3 bh3Var = (bh3) obj2;
                BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) obj3;
                y3 y3Var = bypassConfigActivity.S0;
                if (y3Var == null) {
                    n12.T("binding");
                    throw null;
                }
                ((LoadingIndicator) y3Var.h).setVisibility(0);
                y3 y3Var2 = bypassConfigActivity.S0;
                if (y3Var2 == null) {
                    n12.T("binding");
                    throw null;
                }
                ((Toolbar) y3Var2.c).setSubtitle(bypassConfigActivity.getString(R.string.loading));
                String str2 = bypassConfigActivity.U0;
                if (str2 != null) {
                    Iterable iterable = (Iterable) bh3Var.b;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj4 : iterable) {
                        xs xsVar = (xs) obj4;
                        if (!p44.o0(xsVar.b, str2, true)) {
                            String str3 = xsVar.a.packageName;
                            str3.getClass();
                            if (p44.o0(str3, str2, true)) {
                            }
                        }
                        arrayList.add(obj4);
                    }
                    bh3Var.b = arrayList;
                }
                if (((List) bh3Var.b).isEmpty() && ((str = bypassConfigActivity.U0) == null || str.length() == 0)) {
                    y3 y3Var3 = bypassConfigActivity.S0;
                    if (y3Var3 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((TextView) y3Var3.f).setVisibility(0);
                    y3 y3Var4 = bypassConfigActivity.S0;
                    if (y3Var4 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((MaterialButton) y3Var4.e).setVisibility(0);
                } else {
                    y3 y3Var5 = bypassConfigActivity.S0;
                    if (y3Var5 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((TextView) y3Var5.f).setVisibility(8);
                    y3 y3Var6 = bypassConfigActivity.S0;
                    if (y3Var6 == null) {
                        n12.T("binding");
                        throw null;
                    }
                    ((MaterialButton) y3Var6.e).setVisibility(8);
                }
                bypassConfigActivity.E((List) bh3Var.b);
                bypassConfigActivity.X0.s((List) bh3Var.b, new g33(bypassConfigActivity, bh3Var, (Runnable) obj, 1, false));
                return xl4Var;
            case 1:
                aa1 aa1Var = (aa1) obj;
                ma1 ma1Var = (ma1) obj2;
                List list2 = (List) d73.b.d();
                int i2 = 3;
                if (list2 != null) {
                    ArrayList arrayListB0 = d70.b0(t53.class, list2);
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj5 : arrayListB0) {
                        if (ma1.j(aa1Var, (t53) obj5)) {
                            arrayList2.add(obj5);
                        }
                    }
                    ArrayList arrayList3 = new ArrayList(f70.Q(10, arrayList2));
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList3.add(((t53) it.next()).b);
                    }
                    ji0.B((lf0) obj3, null, null, new mt((String[]) arrayList3.toArray(new String[0]), r3, i2), 3);
                }
                vs4 vs4Var = (vs4) ws4.c.d();
                if (vs4Var != null && vs4Var.b && (list = (List) d73.b.d()) != null) {
                    Iterator it2 = d70.b0(t53.class, list).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next = it2.next();
                            if (n12.c(((t53) next).b, vs4Var.a)) {
                                r3 = next;
                            }
                        }
                    }
                    t53 t53Var = (t53) r3;
                    if (t53Var != null && ma1.j(aa1Var, t53Var)) {
                        if (co4.H()) {
                            p95.C(R.string.restart_vpn_to_make_changes_take_effect, new Object[0]);
                        } else {
                            oy3 oy3VarG = oy3.g(ma1Var.requireView(), R.string.restart_vpn_to_make_changes_take_effect, 0);
                            oy3VarG.i(R.string.restart, new c3(i2, ma1Var));
                            oy3VarG.j();
                        }
                    }
                }
                return xl4Var;
            case 2:
                View view = (View) obj2;
                File file = (File) obj3;
                if (file != null) {
                    Uri uriC = FileProvider.c(view.getContext(), view.getContext().getPackageName() + ".files_provider", file);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.STREAM", uriC);
                    intent.setType(HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
                    intent.addFlags(1);
                    try {
                        view.getContext().startActivity(Intent.createChooser(intent, ((MemoryUsageFragment) obj).getString(R.string.share_hprof)));
                    } catch (ActivityNotFoundException e) {
                        e.printStackTrace();
                        p95.C(R.string.share_failed, new Object[0]);
                    }
                    break;
                } else {
                    p95.C(R.string.unknown_error, new Object[0]);
                }
                return xl4Var;
            case 3:
                d83 d83Var = (d83) obj3;
                y3 y3Var7 = d83Var.b;
                y3Var7.getClass();
                ((LinearProgressIndicator) y3Var7.g).b();
                List list3 = (List) obj2;
                if (!list3.isEmpty()) {
                    Throwable th = (Throwable) d70.d0(list3);
                    CharSequence text = ((Context) obj).getText(R.string.profile_decode_error);
                    text.getClass();
                    d83Var.o(th, text, null, null, null);
                }
                return xl4Var;
            case 4:
                ?? r8 = (d83) obj2;
                Throwable th2 = (Throwable) obj3;
                if (th2 instanceof x53) {
                    x53Var = (x53) th2;
                } else {
                    Throwable cause = th2.getCause();
                    if (cause instanceof x53) {
                        x53Var = (x53) cause;
                    }
                }
                if (x53Var != null) {
                    String str4 = x53Var.b;
                    String string = r8.getString(R.string.unknown_error);
                    string.getClass();
                    String str5 = (String) obj;
                    r8.o(x53Var, string, str5, str4, new x73(r8, str5, str4, x53Var));
                } else {
                    String string2 = r8.getString(R.string.unknown_error);
                    string2.getClass();
                    r8.o(th2, string2, null, null, null);
                }
                return xl4Var;
            default:
                TwoPanePreferenceFragment twoPanePreferenceFragment = (TwoPanePreferenceFragment) obj3;
                tj1 tj1VarJ = twoPanePreferenceFragment.getChildFragmentManager().J();
                twoPanePreferenceFragment.requireContext().getClassLoader();
                o oVarA = tj1VarJ.a((String) obj2);
                oVarA.getClass();
                String str6 = (String) obj;
                if (str6 != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("highlight_key", str6);
                    oVarA.setArguments(bundle);
                }
                if (twoPanePreferenceFragment.getChildFragmentManager().H() > 0) {
                    a aVarG = twoPanePreferenceFragment.getChildFragmentManager().G();
                    aVarG.getClass();
                    twoPanePreferenceFragment.getChildFragmentManager().T(aVarG.t, false);
                }
                u childFragmentManager = twoPanePreferenceFragment.getChildFragmentManager();
                childFragmentManager.getClass();
                a aVar = new a(childFragmentManager);
                aVar.p = true;
                aVar.k(oVarA, R.id.preferences_detail);
                if (((SlidingPaneLayout) twoPanePreferenceFragment.requireView()).d()) {
                    aVar.f = 4099;
                }
                ((SlidingPaneLayout) twoPanePreferenceFragment.requireView()).e();
                aVar.e();
                return xl4Var;
        }
    }
}
