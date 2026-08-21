package defpackage;

import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.view.WindowMetrics;
import com.getsurfboard.base.ContextUtilsKt;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.tencent.mars.xlog.Xlog;
import io.sentry.d1;
import io.sentry.h4;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ad0 implements st2, h4, l4, n90 {
    public final /* synthetic */ int b;

    public /* synthetic */ ad0(int i) {
        this.b = i;
    }

    public static /* bridge */ /* synthetic */ Class c() {
        return WindowMetrics.class;
    }

    public static /* synthetic */ void e(int i, int i2, Object obj, String str) {
        throw new IllegalArgumentException(str + i + obj + i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(Object obj, int i, String str) {
        throw new IllegalArgumentException((str + obj + ((char) i)).toString());
    }

    public static /* synthetic */ void i(Object obj, String str) {
        throw new t80(str + obj);
    }

    public static /* synthetic */ void j(String str, Object obj, Object obj2) {
        throw new IllegalStateException((str + obj + obj2).toString());
    }

    public static /* synthetic */ void k(String str, Object obj, Object obj2, Object obj3) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3);
    }

    public static /* synthetic */ void l(StringBuilder sb, Object obj) {
        sb.append(" with ");
        sb.append(obj);
        throw new ClassCastException(sb.toString());
    }

    public static /* synthetic */ void o(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    @Override // defpackage.st2
    public Object a() {
        switch (this.b) {
            case 0:
                return new ConcurrentSkipListMap();
            case 1:
                return new ArrayList();
            case 2:
                return new LinkedHashSet();
            case 3:
                return new TreeSet();
            default:
                return new ArrayDeque();
        }
    }

    @Override // defpackage.n90
    public Object g(rk3 rk3Var) {
        switch (this.b) {
            case 11:
                Set setE = rk3Var.e(zg.class);
                cp1 cp1Var = cp1.z;
                if (cp1Var == null) {
                    synchronized (cp1.class) {
                        try {
                            cp1Var = cp1.z;
                            if (cp1Var == null) {
                                cp1Var = new cp1(0);
                                cp1.z = cp1Var;
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return new an0(setE, cp1Var);
            default:
                return (ScheduledExecutorService) ExecutorsRegistrar.a.get();
        }
    }

    @Override // defpackage.l4
    public void h(Object obj) {
        String str = "notificationPermission result " + ((Boolean) obj);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "DashboardFragment", "", "", 0, Process.myPid(), Process.myTid(), le2.b, str);
        }
        if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
            return;
        }
        Log.d("DashboardFragment", str, null);
    }

    @Override // io.sentry.h4
    public void m(d1 d1Var) {
        String string;
        String str = "unknown";
        d1Var.getClass();
        try {
            try {
                try {
                    string = Settings.Secure.getString(ContextUtilsKt.getContext().getContentResolver(), "android_id");
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    d1Var.j("device.id", "unknown");
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                string = "unknown";
            } catch (SecurityException e3) {
                e3.printStackTrace();
                string = "unknown";
            }
            d1Var.j("device.id", string);
        } catch (IllegalStateException e4) {
            e4.printStackTrace();
            d1Var.j("device.id", "unknown");
        }
        String[] strArr = Build.SUPPORTED_ABIS;
        strArr.getClass();
        d1Var.j("device.abis", qe.o0(strArr, null, 63));
        d1Var.j("device.brand", Build.BRAND);
        d1Var.j("device.model", Build.MODEL);
        d1Var.j("device.product", Build.PRODUCT);
        d1Var.j("rom.fingerprint", Build.FINGERPRINT);
        String strR = xb5.r();
        if (strR != null && strR.length() != 0) {
            str = strR;
        }
        d1Var.j("operator", str);
    }
}
