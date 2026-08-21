package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import io.sentry.android.core.a1;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class u95 {
    public static UserManager a;
    public static volatile boolean b = !a();

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0039, code lost:
    
        r5 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context) {
        boolean z;
        if (b) {
            return true;
        }
        synchronized (u95.class) {
            try {
                if (b) {
                    return true;
                }
                int i = 1;
                while (true) {
                    z = false;
                    if (i > 2) {
                        break;
                    }
                    UserManager userManager = a;
                    if (userManager == null) {
                        userManager = (UserManager) context.getSystemService(UserManager.class);
                        a = userManager;
                    }
                    if (userManager == null) {
                        z = true;
                        break;
                    }
                    try {
                        if (userManager.isUserUnlocked()) {
                            break;
                        }
                        if (!userManager.isUserRunning(Process.myUserHandle())) {
                            break;
                        }
                    } catch (NullPointerException e) {
                        a1.o("DirectBootUtils", "Failed to check if user is unlocked.", e);
                        a = null;
                        i++;
                    }
                }
                if (z) {
                    a = null;
                }
                if (z) {
                    b = true;
                }
                return z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
