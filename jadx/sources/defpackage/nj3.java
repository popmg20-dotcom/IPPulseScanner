package defpackage;

import android.os.Process;
import android.util.Log;
import com.getsurfboard.base.ContextUtilsKt;
import com.tencent.mars.xlog.Xlog;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class nj3 {
    public static boolean a;
    public static pl1 b = new t4(19);
    public static final lu2 c;
    public static final lu2 d;
    public static final y3 e;
    public static final y3 f;

    static {
        wn1 wn1Var = new wn1(11, new CookieManager(new lv3(ContextUtilsKt.getContext()), CookiePolicy.ACCEPT_ALL));
        mj3 mj3Var = new mj3();
        SSLContext sSLContext = SSLContext.getInstance("SSL");
        sSLContext.init(null, new mj3[]{mj3Var}, new SecureRandom());
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        ku2 ku2Var = new ku2();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        timeUnit.getClass();
        ku2Var.y = jz4.b(10L, timeUnit);
        ku2Var.z = jz4.b(10L, timeUnit);
        ku2Var.A = jz4.b(10L, timeUnit);
        ku2Var.k = wn1Var;
        lu2 lu2Var = new lu2(ku2Var);
        c = lu2Var;
        ku2 ku2Var2 = new ku2();
        ku2Var2.y = jz4.b(10L, timeUnit);
        ku2Var2.z = jz4.b(10L, timeUnit);
        ku2Var2.A = jz4.b(10L, timeUnit);
        socketFactory.getClass();
        if (!socketFactory.equals(ku2Var2.q) || mj3Var != ku2Var2.r) {
            ku2Var2.D = null;
        }
        ku2Var2.q = socketFactory;
        k13 k13Var = k13.a;
        ku2Var2.w = k13.a.c(mj3Var);
        ku2Var2.r = mj3Var;
        ku2Var2.k = wn1Var;
        lu2 lu2Var2 = new lu2(ku2Var2);
        d = lu2Var2;
        v62 v62Var = new v62(lu2Var);
        v62 v62Var2 = new v62(lu2Var2);
        e = ez4.L(ContextUtilsKt.getContext(), v62Var);
        f = ez4.L(ContextUtilsKt.getContext(), v62Var2);
    }

    public static void a(pl1 pl1Var) {
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "RequestManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, "evictAll");
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("RequestManager", "evictAll", null);
        }
        ez4.X("evictAll", new yq1(2, pl1Var));
    }

    public static String b(String str, boolean z) {
        str.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strConcat = "fetchExternalResourceSync START: ".concat(str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "RequestManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strConcat);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("RequestManager", strConcat, null);
        }
        n84 n84Var = pu1.a;
        ku2 ku2VarA = (z ? d : c).a();
        if (!tj4.G()) {
            ku2VarA.a(new vp1(3));
        }
        kk3 kk3VarE = new le3(new lu2(ku2VarA), pu1.a(str)).e();
        if (!kk3VarE.H0) {
            vp1.i(dw2.A(kk3VarE.A, "HTTP "));
            return null;
        }
        String strC = kk3VarE.Z.C();
        int length = strC.length();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        StringBuilder sb = new StringBuilder("fetchExternalResourceSync DONE: ");
        sb.append(length);
        sb.append(" bytes, ");
        sb.append(jCurrentTimeMillis2);
        String strY = fw.y(sb, "ms — ", str);
        if (fy4.b) {
            Xlog.logWrite2(0L, 1, "RequestManager", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strY);
        }
        if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
            Log.d("RequestManager", strY, null);
        }
        return strC;
    }
}
