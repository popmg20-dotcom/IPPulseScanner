package defpackage;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.os.Process;
import com.tencent.mars.xlog.Xlog;
import io.sentry.android.core.a1;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class g81 {
    public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public static final Map b = fh2.V(new e03(1, "EXIT_SELF"), new e03(2, "SIGNALED"), new e03(3, "LOW_MEMORY"), new e03(4, "APP CRASH(EXCEPTION)"), new e03(5, "APP CRASH(NATIVE)"), new e03(6, "ANR"), new e03(7, "INITIALIZATION FAILURE"), new e03(8, "PERMISSION CHANGE"), new e03(9, "EXCESSIVE RESOURCE USAGE"), new e03(10, "USER REQUESTED"), new e03(11, "USER STOPPED"), new e03(12, "DEPENDENCY DIED"), new e03(13, "OTHER KILLS BY SYSTEM"), new e03(14, "FREEZER"));

    public static ApplicationExitInfo a(ActivityManager activityManager, long j, int i) {
        Object next;
        Iterator it = c(activityManager).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) next;
            if (applicationExitInfo.getTimestamp() == j && applicationExitInfo.getPid() == i) {
                break;
            }
        }
        return (ApplicationExitInfo) next;
    }

    public static String b(long j) {
        String str;
        SimpleDateFormat simpleDateFormat = a;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(new Date(j));
        }
        str.getClass();
        return str;
    }

    public static List c(ActivityManager activityManager) {
        try {
            List<ApplicationExitInfo> historicalProcessExitReasons = activityManager.getHistoricalProcessExitReasons(null, 0, 0);
            historicalProcessExitReasons.getClass();
            return d70.u0(historicalProcessExitReasons, new f81());
        } catch (Exception e) {
            String strN = ha0.n("failed to load exit infos: ", e.getMessage());
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "ExitInfoUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("ExitInfoUtils", strN, null);
            }
            return g41.b;
        }
    }

    public static byte[] d(ApplicationExitInfo applicationExitInfo) {
        InputStream traceInputStream;
        applicationExitInfo.getClass();
        try {
            traceInputStream = applicationExitInfo.getTraceInputStream();
        } catch (Exception e) {
            String strN = ha0.n("failed to open trace: ", e.getMessage());
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "ExitInfoUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN);
            }
            if (((Boolean) le2.a.a()).booleanValue() && !fy4.b) {
                a1.o("ExitInfoUtils", strN, null);
            }
            traceInputStream = null;
        }
        if (traceInputStream == null) {
            return null;
        }
        try {
            try {
                byte[] bArrS = l72.S(traceInputStream);
                traceInputStream.close();
                return bArrS;
            } finally {
            }
        } catch (Exception e2) {
            String strN2 = ha0.n("failed to read trace: ", e2.getMessage());
            if (fy4.b) {
                Xlog.logWrite2(0L, 3, "ExitInfoUtils", "", "", 0, Process.myPid(), Process.myTid(), le2.b, strN2);
            }
            if (!((Boolean) le2.a.a()).booleanValue() || fy4.b) {
                return null;
            }
            a1.o("ExitInfoUtils", strN2, null);
            return null;
        }
    }

    public static String e(int i) {
        String str = (String) b.get(Integer.valueOf(i));
        return str == null ? "UNKNOWN" : str;
    }
}
