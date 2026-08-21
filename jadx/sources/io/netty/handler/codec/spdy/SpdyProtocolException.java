package io.netty.handler.codec.spdy;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.ThrowableUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class SpdyProtocolException extends Exception {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = 7870000537743847264L;

    private SpdyProtocolException(String str, boolean z) {
        super(str, null, false, true);
    }

    public static SpdyProtocolException newStatic(String str, Class<?> cls, String str2) {
        return (SpdyProtocolException) ThrowableUtil.unknownStackTrace(PlatformDependent.javaVersion() >= 7 ? new StacklessSpdyProtocolException(str, true) : new StacklessSpdyProtocolException(str), cls, str2);
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class StacklessSpdyProtocolException extends SpdyProtocolException {
        private static final long serialVersionUID = -6302754207557485099L;

        public StacklessSpdyProtocolException(String str, boolean z) {
            super(str, z);
        }

        public StacklessSpdyProtocolException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
        }
    }

    public SpdyProtocolException() {
    }

    public SpdyProtocolException(String str, Throwable th) {
        super(str, th);
    }

    public SpdyProtocolException(String str) {
        super(str);
    }

    public SpdyProtocolException(Throwable th) {
        super(th);
    }
}
