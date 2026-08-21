package defpackage;

import android.content.pm.PackageInfo;
import android.widget.CompoundButton;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ni implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ni(zf2 zf2Var, r90 r90Var, u6 u6Var) {
        this.a = 0;
        this.b = r90Var;
        this.c = u6Var;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        LinkedHashMap linkedHashMap;
        Set setKeySet;
        ArrayList arrayList;
        vs4 vs4Var;
        int i = this.a;
        Object obj = this.c;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                compoundButton.getClass();
                zf2.q0((r90) obj2, (u6) obj);
                break;
            case 1:
                xs xsVar = (xs) obj2;
                zs zsVar = (zs) obj;
                compoundButton.getClass();
                boolean z2 = xsVar.c;
                PackageInfo packageInfo = xsVar.a;
                if (z2 != z) {
                    xsVar.c = z;
                    if (z) {
                        boolean zH = t23.H();
                        String str = packageInfo.packageName;
                        str.getClass();
                        HashSet hashSetE = t23.e(zH);
                        d70.V(hashSetE, new String[]{str});
                        t23.w(zH, hashSetE);
                    } else {
                        boolean zH2 = t23.H();
                        String str2 = packageInfo.packageName;
                        str2.getClass();
                        HashSet hashSetE2 = t23.e(zH2);
                        hashSetE2.removeAll(qe.t0(new String[]{str2}));
                        t23.w(zH2, hashSetE2);
                    }
                    BypassConfigActivity bypassConfigActivity = (BypassConfigActivity) zsVar.f.f;
                    int i2 = BypassConfigActivity.Y0;
                    bypassConfigActivity.D();
                    bypassConfigActivity.z();
                    List list = bypassConfigActivity.X0.d.f;
                    list.getClass();
                    bypassConfigActivity.E(list);
                }
                break;
            default:
                zk zkVar = (zk) obj2;
                bx0 bx0Var = (bx0) obj;
                compoundButton.getClass();
                if (z && (zkVar instanceof t53)) {
                    int iB = bx0Var.b();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= iB) {
                            i3 = -1;
                        } else if (!n12.c(((zk) bx0Var.q(i3)).getName(), i73.a())) {
                            i3++;
                        }
                    }
                    t53 t53Var = (t53) zkVar;
                    String str3 = t53Var.b;
                    xb5.c("profile item " + str3 + " checked");
                    wn1 wn1Var = (wn1) bx0Var.f;
                    if (wn1Var != null && (vs4Var = (vs4) ws4.c.d()) != null && vs4Var.b) {
                        ((d83) wn1Var.f).f = true;
                    }
                    on2 on2Var = d73.c;
                    t53 t53Var2 = (t53) on2Var.d();
                    if (t53Var2 != null && (arrayList = t53Var2.J0) != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            fx3.g((tn3) it.next());
                        }
                    }
                    if (t53Var2 != null && (linkedHashMap = t53Var2.F0) != null && (setKeySet = linkedHashMap.keySet()) != null) {
                        Iterator it2 = setKeySet.iterator();
                        while (it2.hasNext()) {
                            ((ss1) it2.next()).E();
                        }
                    }
                    i73.b(str3);
                    on2Var.l(t53Var);
                    if (i3 != -1) {
                        bx0Var.e(i3);
                    }
                    break;
                }
                break;
        }
    }

    public /* synthetic */ ni(int i, rb2 rb2Var, Object obj) {
        this.a = i;
        this.b = obj;
        this.c = rb2Var;
    }
}
