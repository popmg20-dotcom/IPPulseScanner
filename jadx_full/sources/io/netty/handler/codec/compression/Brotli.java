package io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.Brotli4jLoader;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class Brotli {
    private static final ClassNotFoundException CNFE;
    private static Throwable cause;
    private static final InternalLogger logger;

    static {
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance((Class<?>) Brotli.class);
        logger = internalLoggerFactory;
        try {
            Class.forName("com.aayushatharva.brotli4j.Brotli4jLoader", false, PlatformDependent.getClassLoader(Brotli.class));
            e = null;
        } catch (ClassNotFoundException e) {
            e = e;
            internalLoggerFactory = logger;
            internalLoggerFactory.debug("brotli4j not in the classpath; Brotli support will be unavailable.");
        }
        CNFE = e;
        if (e == null) {
            Throwable unavailabilityCause = Brotli4jLoader.getUnavailabilityCause();
            cause = unavailabilityCause;
            if (unavailabilityCause != null) {
                internalLoggerFactory.debug("Failed to load brotli4j; Brotli support will be unavailable.", unavailabilityCause);
            }
        }
    }

    private Brotli() {
    }

    public static Throwable cause() {
        return cause;
    }

    public static void ensureAvailability() throws ClassNotFoundException {
        ClassNotFoundException classNotFoundException = CNFE;
        if (classNotFoundException != null) {
            throw classNotFoundException;
        }
        Brotli4jLoader.ensureAvailability();
    }

    public static boolean isAvailable() {
        return CNFE == null && Brotli4jLoader.isAvailable();
    }
}
