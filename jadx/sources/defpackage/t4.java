package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;
import androidx.window.extensions.layout.WindowLayoutComponent;
import com.getsurfboard.R;
import com.getsurfboard.base.ContextUtilsKt;
import com.getsurfboard.ui.SurfboardApp;
import com.getsurfboard.ui.service.SurfboardVpn;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mars.xlog.Xlog;
import io.netty.handler.codec.http.websocketx.extensions.compression.PerMessageDeflateServerExtensionHandshaker;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.conscrypt.FileClientSessionCache;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t4 implements pl1 {
    public final /* synthetic */ int b;

    public /* synthetic */ t4(int i) {
        this.b = i;
    }

    @Override // defpackage.pl1
    public final Object a() throws NoSuchMethodException, UnknownHostException {
        Class<?> returnType;
        WindowLayoutComponent windowLayoutComponentA;
        boolean z = false;
        switch (this.b) {
            case 0:
                return Integer.valueOf(id3.f.b(2147418112) + 65536);
            case 1:
                return FirebaseAnalytics.getInstance(ContextUtilsKt.getContext());
            case 2:
                return new Handler(Looper.getMainLooper());
            case 3:
                return i73.a();
            case 4:
                Context context = ContextUtilsKt.getContext();
                return context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
            case 5:
                try {
                    Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Throwable unused) {
                    return null;
                }
            case 6:
                try {
                    Method method = (Method) gl1.A.getValue();
                    if (method == null || (returnType = method.getReturnType()) == null) {
                        return null;
                    }
                    Class<?> cls = Integer.TYPE;
                    return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
                } catch (Throwable unused2) {
                    return null;
                }
            case 7:
                lu2 lu2Var = new lu2(new ku2());
                dv1 dv1Var = new dv1();
                dv1Var.c(null, "https://doh.pub/dns-query");
                ev1 ev1VarA = dv1Var.a();
                InetAddress byName = InetAddress.getByName("1.12.12.12");
                byName.getClass();
                InetAddress byName2 = InetAddress.getByName("120.53.53.53");
                byName2.getClass();
                List listS0 = qe.s0(new InetAddress[]{byName, byName2});
                ku2 ku2VarA = lu2Var.a();
                pj2 pj2Var = pw0.z;
                ku2VarA.a(new lb(ev1VarA.d, listS0));
                return new pw0(new lu2(ku2VarA), ev1VarA);
            case 8:
                return new lu2(new ku2());
            case Xlog.COMPRESS_LEVEL9 /* 9 */:
                try {
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    declaredField3.setAccessible(true);
                    return new wy1(declaredField3, declaredField, declaredField2);
                } catch (NoSuchFieldException unused3) {
                    return vy1.a;
                }
            case 10:
                return xl4.a;
            case 11:
                return xl4.a;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                on2 on2Var = ws4.h;
                Object objD = on2Var.d();
                Boolean bool = Boolean.TRUE;
                if (!n12.c(objD, bool)) {
                    on2Var.i(bool);
                }
                return xl4.a;
            case 13:
                return Boolean.FALSE;
            case 14:
                cr2.e();
                cr2.b();
                return xl4.a;
            case PerMessageDeflateServerExtensionHandshaker.MAX_WINDOW_SIZE /* 15 */:
                cr2.e();
                cr2.b();
                return xl4.a;
            case 16:
                return Boolean.valueOf(t23.c(R.string.setting_logout_output_key, false));
            case 17:
                return new on2(t23.m());
            case 18:
                cr2.e();
                return xl4.a;
            case 19:
                return 5000;
            case 20:
                Method method2 = d31.class.getMethod("a", null);
                if (dw2.H(method2) && method2.getReturnType().equals(String.class)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            case 21:
                int i = SurfboardApp.A;
                ke0.r(oj0.a.u().a, false, true, new ji(27));
                return xl4.a;
            case 22:
                int i2 = SurfboardApp.A;
                return Integer.valueOf(t23.h());
            case 23:
                int i3 = SurfboardApp.A;
                return Boolean.valueOf(t23.i());
            case 24:
                SurfboardApp.d();
                return xl4.a;
            case 25:
                int i4 = SurfboardApp.A;
                cr2.e();
                return xl4.a;
            case 26:
                int i5 = SurfboardVpn.I0;
                p95.C(R.string.profile_content_changed_detected, new Object[0]);
                return xl4.a;
            case 27:
                dg4.b = 0L;
                dg4.c = 0L;
                dg4.d = 0L;
                dg4.e = 0L;
                dg4.f = 0L;
                dg4.g = 0L;
                dg4.h = 0L;
                dg4.i = 0L;
                dg4.j.clear();
                dg4.k.clear();
                dg4.l.clear();
                dg4.m.clear();
                dg4.n = true;
                while (dg4.n) {
                    synchronized (dg4.a) {
                        dg4.r.run();
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused4) {
                    }
                }
                return xl4.a;
            case 28:
                return Boolean.TRUE;
            default:
                try {
                    ClassLoader classLoader = yt4.class.getClassLoader();
                    zo3 zo3Var = classLoader != null ? new zo3(classLoader, new cp1(classLoader)) : null;
                    if (zo3Var == null || (windowLayoutComponentA = zo3Var.a()) == null) {
                        return null;
                    }
                    cp1 cp1Var = new cp1(classLoader);
                    int iA = y91.a();
                    return iA >= 9 ? new x91(windowLayoutComponentA, cp1Var) : iA >= 6 ? new w91(windowLayoutComponentA, cp1Var) : iA >= 2 ? new v91(windowLayoutComponentA, cp1Var) : iA == 1 ? new u91(windowLayoutComponentA, cp1Var) : new s91();
                } catch (Throwable unused5) {
                    return null;
                }
        }
    }

    public /* synthetic */ t4(y12 y12Var, int i) {
        this.b = i;
    }
}
