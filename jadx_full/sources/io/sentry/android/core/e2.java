package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import io.sentry.p5;
import java.nio.charset.Charset;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class e2 extends BroadcastReceiver {
    public final io.sentry.f1 a;
    public final SentryAndroidOptions b;
    public final io.sentry.android.core.internal.util.f c = new io.sentry.android.core.internal.util.f(60000, 0);
    public final char[] d = new char[64];
    public final /* synthetic */ SystemEventsBreadcrumbsIntegration e;

    public e2(SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration, io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions) {
        this.e = systemEventsBreadcrumbsIntegration;
        this.a = f1Var;
        this.b = sentryAndroidOptions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
    
        r2 = r13;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onReceive(Context context, Intent intent) {
        d2 d2Var;
        Bundle extras;
        int i;
        String action = intent.getAction();
        boolean zEquals = "android.intent.action.BATTERY_CHANGED".equals(action);
        SentryAndroidOptions sentryAndroidOptions = this.b;
        String str = null;
        if (!zEquals) {
            d2Var = null;
        } else {
            if (this.c.a()) {
                return;
            }
            Float fB = u0.b(intent, sentryAndroidOptions);
            d2Var = new d2(fB != null ? Integer.valueOf(fB.intValue()) : null, u0.d(intent, sentryAndroidOptions));
            SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration = this.e;
            if (d2Var.equals(systemEventsBreadcrumbsIntegration.C0)) {
                return;
            } else {
                systemEventsBreadcrumbsIntegration.C0 = d2Var;
            }
        }
        io.sentry.g gVar = new io.sentry.g(System.currentTimeMillis());
        gVar.X = "system";
        gVar.Z = "device.event";
        if (action != null) {
            int length = action.length();
            char[] cArr = this.d;
            int length2 = cArr.length;
            int i2 = length - 1;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                char cCharAt = action.charAt(i2);
                if (cCharAt == '.') {
                    str = new String(cArr, length2, cArr.length - length2);
                    break;
                }
                if (length2 == 0) {
                    Charset charset = io.sentry.util.p.a;
                    int iLastIndexOf = action.lastIndexOf(".");
                    if (iLastIndexOf < 0 || action.length() <= (i = iLastIndexOf + 1)) {
                        break;
                    } else {
                        str = action.substring(i);
                    }
                } else {
                    length2--;
                    cArr[length2] = cCharAt;
                    i2--;
                }
            }
        }
        if (str != null) {
            gVar.d(str, "action");
        }
        if (d2Var != null) {
            Integer num = d2Var.a;
            if (num != null) {
                gVar.d(num, "level");
            }
            Boolean bool = d2Var.b;
            if (bool != null) {
                gVar.d(bool, "charging");
            }
        } else if (sentryAndroidOptions.isEnableSystemEventBreadcrumbsExtras() && (extras = intent.getExtras()) != null && !extras.isEmpty()) {
            HashMap map = new HashMap(extras.size());
            for (String str2 : extras.keySet()) {
                try {
                    Object obj = extras.get(str2);
                    if (obj != null) {
                        map.put(str2, obj.toString());
                    }
                } catch (Throwable th) {
                    sentryAndroidOptions.getLogger().b(p5.ERROR, th, "%s key of the %s action threw an error.", str2, action);
                }
            }
            gVar.d(map, "extras");
        }
        gVar.z0 = p5.INFO;
        io.sentry.l0 l0Var = new io.sentry.l0();
        l0Var.d(intent, "android:intent");
        this.a.c(gVar, l0Var);
    }
}
