package io.sentry.android.core;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import io.sentry.ILogger;
import io.sentry.p5;
import io.sentry.p6;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements io.sentry.transport.h, io.sentry.q0 {
    public static final q0 f = new q0();
    public Object b;

    public q0(int i) {
        switch (i) {
            case 4:
                this.b = new Handler(Looper.getMainLooper());
                break;
            default:
                this.b = new io.sentry.util.a();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean a() {
        boolean z;
        try {
            if (!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) {
                String str = Build.FINGERPRINT;
                if (str.startsWith("generic") || str.startsWith("unknown")) {
                    z = true;
                } else {
                    String str2 = Build.HARDWARE;
                    if (!str2.contains("goldfish") && !str2.contains("ranchu")) {
                        String str3 = Build.MODEL;
                        if (!str3.contains("google_sdk") && !str3.contains("Emulator") && !str3.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion")) {
                            String str4 = Build.PRODUCT;
                            if (!str4.contains("sdk_google") && !str4.contains("google_sdk") && !str4.contains("sdk") && !str4.contains("sdk_x86") && !str4.contains("vbox86p") && !str4.contains("emulator") && !str4.contains("simulator")) {
                                z = false;
                            }
                        }
                    }
                }
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            ((ILogger) this.b).d(p5.ERROR, "Error checking whether application is running in an emulator.", th);
            return null;
        }
    }

    public void b(Activity activity) {
        WeakReference weakReference = (WeakReference) this.b;
        if (weakReference == null || weakReference.get() != activity) {
            this.b = new WeakReference(activity);
        }
    }

    @Override // io.sentry.transport.h
    public boolean isConnected() {
        int i = y.a[((p6) this.b).getConnectionStatusProvider().d0().ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    public q0(ILogger iLogger) {
        io.sentry.util.b.r(iLogger, "The ILogger object is required.");
        this.b = iLogger;
    }
}
