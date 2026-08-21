package defpackage;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class m53 {
    public static final String a = ue2.i("ProcessUtils");

    public static final boolean a(Context context, na0 na0Var) {
        String strK;
        Object next;
        Object objInvoke;
        context.getClass();
        na0Var.getClass();
        if (Build.VERSION.SDK_INT >= 28) {
            strK = u9.k();
        } else {
            strK = null;
            try {
                Method declaredMethod = Class.forName("android.app.ActivityThread", false, xw4.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
                declaredMethod.setAccessible(true);
                objInvoke = declaredMethod.invoke(null, null);
                objInvoke.getClass();
            } catch (Throwable th) {
                ue2.g().d(a, "Unable to check ActivityThread for processName", th);
            }
            if (objInvoke instanceof String) {
                strK = (String) objInvoke;
            } else {
                int iMyPid = Process.myPid();
                Object systemService = context.getSystemService("activity");
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
                        strK = runningAppProcessInfo.processName;
                    }
                }
            }
        }
        return n12.c(strK, context.getApplicationInfo().processName);
    }
}
