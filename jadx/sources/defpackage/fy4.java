package defpackage;

import android.app.ActivityManager;
import android.os.Process;
import com.getsurfboard.ui.SurfboardApp;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fy4 {
    public static final fy4 a = new fy4();
    public static volatile boolean b;

    public static String a(SurfboardApp surfboardApp) {
        Object next;
        String str = null;
        try {
            int iMyPid = Process.myPid();
            Object systemService = surfboardApp.getSystemService("activity");
            systemService.getClass();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<T> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (((ActivityManager.RunningAppProcessInfo) next).pid == iMyPid) {
                        break;
                    }
                }
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) next;
                if (runningAppProcessInfo != null) {
                    str = runningAppProcessInfo.processName;
                }
            }
        } catch (Exception unused) {
        }
        String strP0 = str != null ? p44.P0(str, ':', "main") : "main";
        Pattern patternCompile = Pattern.compile("[^A-Za-z0-9_]");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strP0).replaceAll("_");
        strReplaceAll.getClass();
        return strReplaceAll;
    }
}
