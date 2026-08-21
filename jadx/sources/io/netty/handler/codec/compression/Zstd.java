package io.netty.handler.codec.compression;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Zstd {
    private static final Throwable cause;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) Zstd.class);

    static {
        try {
            Class.forName("com.github.luben.zstd.Zstd", false, PlatformDependent.getClassLoader(Zstd.class));
            e = null;
        } catch (ClassNotFoundException e) {
            e = e;
            logger.debug("zstd-jni not in the classpath; Zstd support will be unavailable.");
        } catch (Throwable th) {
            e = th;
            logger.debug("Failed to load zstd-jni; Zstd support will be unavailable.", (Throwable) e);
        }
        cause = e;
    }

    private Zstd() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws Throwable {
        Throwable th = cause;
        if (th != null) {
            throw th;
        }
    }

    public static boolean isAvailable() {
        return cause == null;
    }
}
