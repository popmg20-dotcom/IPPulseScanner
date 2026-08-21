package io.netty.handler.ssl;

import defpackage.vp1;
import io.netty.util.internal.PlatformDependent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class Conscrypt {
    private static final Method IS_CONSCRYPT_SSLENGINE;

    static {
        Method method;
        if ((PlatformDependent.javaVersion() < 8 || PlatformDependent.javaVersion() >= 15) && !PlatformDependent.isAndroid()) {
            method = null;
        } else {
            try {
                Class.forName("org.conscrypt.OpenSSLProvider", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).newInstance();
                method = Class.forName("org.conscrypt.Conscrypt", true, PlatformDependent.getClassLoader(ConscryptAlpnSslEngine.class)).getMethod("isConscrypt", SSLEngine.class);
            } catch (Throwable unused) {
                method = null;
            }
        }
        IS_CONSCRYPT_SSLENGINE = method;
    }

    private Conscrypt() {
    }

    public static boolean isAvailable() {
        return IS_CONSCRYPT_SSLENGINE != null;
    }

    public static boolean isEngineSupported(SSLEngine sSLEngine) {
        try {
            Method method = IS_CONSCRYPT_SSLENGINE;
            if (method != null) {
                if (((Boolean) method.invoke(null, sSLEngine)).booleanValue()) {
                    return true;
                }
            }
            return false;
        } catch (IllegalAccessException unused) {
            return false;
        } catch (InvocationTargetException e) {
            vp1.p(e);
            return false;
        }
    }
}
