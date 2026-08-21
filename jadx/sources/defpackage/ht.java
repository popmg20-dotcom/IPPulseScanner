package defpackage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.activity.BypassConfigActivity;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ht extends v74 implements Function2 {
    public int A0;
    public final /* synthetic */ BypassConfigActivity B0;
    public HashSet X;
    public BypassConfigActivity Y;
    public boolean Z;
    public boolean y0;
    public boolean z0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ht(BypassConfigActivity bypassConfigActivity, ge0 ge0Var) {
        super(2, ge0Var);
        this.B0 = bypassConfigActivity;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object k(Object obj, Object obj2) {
        return ((ht) n((ge0) obj2, (lf0) obj)).p(xl4.a);
    }

    @Override // defpackage.kk
    public final ge0 n(ge0 ge0Var, Object obj) {
        return new ht(this.B0, ge0Var);
    }

    @Override // defpackage.kk
    public final Object p(Object obj) {
        HashSet hashSetE;
        boolean zD;
        boolean zD2;
        Object objB0;
        boolean z;
        BypassConfigActivity bypassConfigActivity;
        boolean z2;
        boolean z3;
        int i = this.A0;
        BypassConfigActivity bypassConfigActivity2 = this.B0;
        int i2 = 0;
        int i3 = 1;
        try {
            if (i == 0) {
                n12.S(obj);
                hashSetE = t23.e(t23.H());
                zD = t23.d("hide_system_apps", false);
                boolean zD3 = t23.d("hide_offline_apps", true);
                zD2 = t23.d("hide_disabled_apps", true);
                this.X = hashSetE;
                this.Y = bypassConfigActivity2;
                this.Z = zD;
                this.y0 = zD3;
                this.z0 = zD2;
                this.A0 = 1;
                int i4 = BypassConfigActivity.Y0;
                objB0 = ji0.b0(qv0.a, new gt(bypassConfigActivity2, null, 0), this);
                mf0 mf0Var = mf0.b;
                if (objB0 == mf0Var) {
                    return mf0Var;
                }
                z = zD3;
                bypassConfigActivity = bypassConfigActivity2;
            } else {
                if (i != 1) {
                    xe.q("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                boolean z4 = this.z0;
                z = this.y0;
                zD = this.Z;
                bypassConfigActivity = this.Y;
                HashSet hashSet = this.X;
                n12.S(obj);
                zD2 = z4;
                hashSetE = hashSet;
                objB0 = obj;
            }
            ArrayList<PackageInfo> arrayList = new ArrayList();
            for (Object obj2 : (Iterable) objB0) {
                PackageInfo packageInfo = (PackageInfo) obj2;
                try {
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    if (applicationInfo != null) {
                        int i5 = (applicationInfo.flags & i3) != 0 ? i3 : i2;
                        boolean z5 = applicationInfo.enabled;
                        String[] strArr = packageInfo.requestedPermissions;
                        if (strArr != null) {
                            int length = strArr.length;
                            while (i2 < length) {
                                z2 = z;
                                try {
                                    if (n12.c(strArr[i2], "android.permission.INTERNET")) {
                                        z3 = true;
                                        break;
                                    }
                                    i2++;
                                    z = z2;
                                } catch (PackageManager.NameNotFoundException e) {
                                    e = e;
                                    e.printStackTrace();
                                }
                            }
                            z2 = z;
                            z3 = false;
                            if (n12.c(packageInfo.packageName, bypassConfigActivity2.getPackageName()) && (!zD || i5 == 0)) {
                                if (!zD2) {
                                    z5 = true;
                                }
                                if (z5) {
                                    if (!z2) {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        arrayList.add(obj2);
                                    }
                                }
                            }
                        } else {
                            z2 = z;
                            z3 = false;
                            if (n12.c(packageInfo.packageName, bypassConfigActivity2.getPackageName())) {
                            }
                        }
                    } else {
                        z2 = z;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    e = e2;
                    z2 = z;
                }
                i2 = 0;
                z = z2;
                i3 = 1;
            }
            ArrayList arrayList2 = new ArrayList(f70.Q(10, arrayList));
            for (PackageInfo packageInfo2 : arrayList) {
                boolean zContains = hashSetE.contains(packageInfo2.packageName);
                ApplicationInfo applicationInfo2 = packageInfo2.applicationInfo;
                CharSequence applicationLabel = applicationInfo2 != null ? ContextUtilsKt.h().getApplicationLabel(applicationInfo2) : packageInfo2.packageName;
                applicationLabel.getClass();
                arrayList2.add(new xs(packageInfo2, applicationLabel, zContains));
            }
            int i6 = BypassConfigActivity.Y0;
            return bypassConfigActivity.B(arrayList2);
        } catch (SecurityException e3) {
            e3.printStackTrace();
            return g41.b;
        }
    }
}
