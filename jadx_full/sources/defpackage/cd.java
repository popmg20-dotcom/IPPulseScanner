package defpackage;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentContainerView;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import com.getsurfboard.ui.activity.HostsListActivity;
import com.getsurfboard.ui.activity.NATDetectActivity;
import com.getsurfboard.ui.activity.RecentRequestsActivity;
import com.getsurfboard.ui.activity.TrafficListActivity;
import com.getsurfboard.ui.fragment.AddHostFragment;
import com.getsurfboard.ui.fragment.settings.AppSettingsFragment;
import com.getsurfboard.vpn.Jni;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tencent.mars.xlog.Xlog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cd implements Function2 {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object f;

    public /* synthetic */ cd(int i, Object obj) {
        this.b = i;
        this.f = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0180  */
    @Override // kotlin.jvm.functions.Function2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object k(Object obj, Object obj2) {
        Object next;
        e03 e03Var;
        Object next2;
        int i = this.b;
        xl4 xl4Var = xl4.a;
        v32 v32Var = null;
        Object obj3 = this.f;
        switch (i) {
            case 0:
                return AppSettingsFragment.onViewCreated$lambda$10$0((AppSettingsFragment) obj3, (Set) obj, (char[]) obj2);
            case 1:
                int i2 = BypassConfigActivity.Y0;
                return Integer.valueOf(new ApplicationInfo.DisplayNameComparator(((BypassConfigActivity) obj3).getPackageManager()).compare(((xs) obj).a.applicationInfo, ((xs) obj2).a.applicationInfo));
            case 2:
                HostsListActivity hostsListActivity = (HostsListActivity) obj3;
                View view = (View) obj;
                ls1 ls1Var = (ls1) obj2;
                int i3 = HostsListActivity.a1;
                view.getClass();
                ls1Var.getClass();
                hostsListActivity.V0 = view;
                j80 j80Var = hostsListActivity.S0;
                if (j80Var == null) {
                    n12.T("binding");
                    throw null;
                }
                AddHostFragment addHostFragment = (AddHostFragment) ((FragmentContainerView) j80Var.b).getFragment();
                addHostFragment.f = ls1Var;
                addHostFragment.j();
                hostsListActivity.x(view, true);
                j80 j80Var2 = hostsListActivity.S0;
                if (j80Var2 != null) {
                    ((FloatingActionButton) j80Var2.a).d(true);
                    return xl4Var;
                }
                n12.T("binding");
                throw null;
            case 3:
                return ((Jni) obj3).analyzeProtocol(((Integer) obj).intValue(), ((Integer) obj2).intValue());
            case 4:
                NATDetectActivity nATDetectActivity = (NATDetectActivity) obj3;
                String str = (String) obj;
                String str2 = (String) obj2;
                if (str != null) {
                    String strO = ha0.o(str, ": ", str2);
                    int i4 = NATDetectActivity.V0;
                    nATDetectActivity.x(strO);
                } else {
                    int i5 = NATDetectActivity.V0;
                    nATDetectActivity.x(str2);
                }
                return xl4Var;
            case 5:
                String str3 = (String) obj2;
                ((View) obj).getClass();
                str3.getClass();
                Bundle bundle = new Bundle();
                bundle.putString("proxy_name", str3);
                kb3 kb3Var = new kb3();
                kb3Var.setArguments(bundle);
                kb3Var.m(((ya3) obj3).getChildFragmentManager(), null);
                return Boolean.TRUE;
            case 6:
                int iIntValue = ((Integer) obj).intValue();
                af0 af0Var = (af0) obj2;
                bf0 key = af0Var.getKey();
                af0 af0VarZ = ((mo3) obj3).X.Z(key);
                if (key != pr1.X) {
                    iIntValue = af0Var != af0VarZ ? Integer.MIN_VALUE : iIntValue + 1;
                } else {
                    v32 v32Var2 = (v32) af0VarZ;
                    v32 parent = (v32) af0Var;
                    while (parent != null) {
                        if (parent != v32Var2 && (parent instanceof iq3)) {
                            g40 g40Var = (g40) re.a.getObjectVolatile((iq3) parent, e42.b);
                            parent = g40Var != null ? g40Var.getParent() : null;
                        } else {
                            v32Var = parent;
                            if (v32Var == v32Var2) {
                                throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + v32Var + ", expected child of " + v32Var2 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                            }
                            if (v32Var2 != null) {
                            }
                        }
                    }
                    if (v32Var == v32Var2) {
                    }
                }
                return Integer.valueOf(iIntValue);
            case 7:
                List list = (List) obj3;
                CharSequence charSequence = (CharSequence) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                charSequence.getClass();
                if (list.size() == 1) {
                    int size = list.size();
                    if (size == 0) {
                        e04.h("List is empty.");
                        return null;
                    }
                    if (size != 1) {
                        xe.k("List has more than one element.");
                        return null;
                    }
                    String str4 = (String) list.get(0);
                    int iV0 = p44.v0(charSequence, str4, iIntValue2, false, 4);
                    e03Var = iV0 < 0 ? null : new e03(Integer.valueOf(iV0), str4);
                } else {
                    if (iIntValue2 < 0) {
                        iIntValue2 = 0;
                    }
                    b12 b12Var = new b12(iIntValue2, charSequence.length(), 1);
                    boolean z = charSequence instanceof String;
                    int i6 = b12Var.z;
                    int i7 = b12Var.f;
                    if (z) {
                        if ((i6 > 0 && iIntValue2 <= i7) || (i6 < 0 && i7 <= iIntValue2)) {
                            while (true) {
                                Iterator it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        next2 = it.next();
                                        String str5 = (String) next2;
                                        if (str5.regionMatches(0, (String) charSequence, iIntValue2, str5.length())) {
                                        }
                                    } else {
                                        next2 = null;
                                    }
                                }
                                String str6 = (String) next2;
                                if (str6 != null) {
                                    e03Var = new e03(Integer.valueOf(iIntValue2), str6);
                                } else if (iIntValue2 != i7) {
                                    iIntValue2 += i6;
                                }
                            }
                        }
                    } else if ((i6 > 0 && iIntValue2 <= i7) || (i6 < 0 && i7 <= iIntValue2)) {
                        int i8 = iIntValue2;
                        while (true) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    next = it2.next();
                                    String str7 = (String) next;
                                    if (p44.E0(str7, false, 0, charSequence, i8, str7.length())) {
                                    }
                                } else {
                                    next = null;
                                }
                            }
                            String str8 = (String) next;
                            if (str8 != null) {
                                e03Var = new e03(Integer.valueOf(i8), str8);
                            } else if (i8 != i7) {
                                i8 += i6;
                            }
                        }
                    }
                }
                if (e03Var != null) {
                    return new e03(e03Var.b, Integer.valueOf(((String) e03Var.f).length()));
                }
                return null;
            case 8:
                CharSequence charSequence2 = (CharSequence) obj;
                int iIntValue3 = ((Integer) obj2).intValue();
                charSequence2.getClass();
                int iW0 = p44.w0(charSequence2, (char[]) obj3, iIntValue3, false);
                if (iW0 < 0) {
                    return null;
                }
                return new e03(Integer.valueOf(iW0), 1);
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                TrafficListActivity trafficListActivity = (TrafficListActivity) obj3;
                String str9 = (String) obj2;
                int i9 = TrafficListActivity.V0;
                ((pd) obj).getClass();
                str9.getClass();
                Intent intent = new Intent(trafficListActivity, (Class<?>) RecentRequestsActivity.class);
                intent.putExtra("package_name", str9);
                trafficListActivity.startActivity(intent);
                return xl4Var;
            default:
                ArrayList arrayList = (ArrayList) obj3;
                String str10 = (String) obj;
                String str11 = (String) obj2;
                if (w44.d0(str10, ".conf", false)) {
                    arrayList.add(new e03(str10, str11));
                }
                return xl4Var;
        }
    }
}
