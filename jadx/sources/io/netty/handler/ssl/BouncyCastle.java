package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class BouncyCastle {
    private static final boolean BOUNCY_CASTLE_ON_CLASSPATH;

    static {
        boolean z;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        BOUNCY_CASTLE_ON_CLASSPATH = z;
    }

    private BouncyCastle() {
    }

    public static boolean isAvailable() {
        return BOUNCY_CASTLE_ON_CLASSPATH;
    }

    public static boolean isInUse(SSLEngine sSLEngine) {
        return sSLEngine.getClass().getPackage().getName().startsWith("org.bouncycastle.jsse.provider");
    }
}
