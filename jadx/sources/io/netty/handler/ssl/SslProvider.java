package io.netty.handler.ssl;

import defpackage.s53;
import java.security.Provider;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum SslProvider {
    JDK,
    OPENSSL,
    OPENSSL_REFCNT;

    /* JADX INFO: renamed from: io.netty.handler.ssl.SslProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] iArr = new int[SslProvider.values().length];
            $SwitchMap$io$netty$handler$ssl$SslProvider = iArr;
            try {
                iArr[SslProvider.JDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL_REFCNT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean isAlpnSupported(SslProvider sslProvider) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return JdkAlpnApplicationProtocolNegotiator.isAlpnSupported();
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isAlpnSupported();
        }
        s53.s(sslProvider, "Unknown SslProvider: ");
        return false;
    }

    public static boolean isTlsv13EnabledByDefault(SslProvider sslProvider, Provider provider) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return SslUtils.isTLSv13EnabledByJDK(provider);
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        s53.s(sslProvider, "Unknown SslProvider: ");
        return false;
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider, Provider provider) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i == 1) {
            return SslUtils.isTLSv13SupportedByJDK(provider);
        }
        if (i == 2 || i == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        s53.s(sslProvider, "Unknown SslProvider: ");
        return false;
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider) {
        return isTlsv13Supported(sslProvider, null);
    }
}
