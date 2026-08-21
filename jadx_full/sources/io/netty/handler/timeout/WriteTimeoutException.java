package io.netty.handler.timeout;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class WriteTimeoutException extends TimeoutException {
    public static final WriteTimeoutException INSTANCE;
    private static final long serialVersionUID = -144786655770296065L;

    static {
        INSTANCE = PlatformDependent.javaVersion() >= 7 ? new WriteTimeoutException(true) : new WriteTimeoutException();
    }

    public WriteTimeoutException(String str) {
        super(str, false);
    }

    public WriteTimeoutException() {
    }

    private WriteTimeoutException(boolean z) {
        super(null, z);
    }
}
