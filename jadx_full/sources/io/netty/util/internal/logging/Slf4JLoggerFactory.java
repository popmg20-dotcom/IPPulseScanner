package io.netty.util.internal.logging;

import defpackage.go2;
import defpackage.we2;
import defpackage.xe2;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class Slf4JLoggerFactory extends InternalLoggerFactory {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final InternalLoggerFactory INSTANCE = new Slf4JLoggerFactory();

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class NopInstanceHolder {
        private static final InternalLoggerFactory INSTANCE_WITH_NOP_CHECK = new Slf4JLoggerFactory(true);

        private NopInstanceHolder() {
        }
    }

    public Slf4JLoggerFactory(boolean z) {
        if (xe2.b() instanceof go2) {
            throw new NoClassDefFoundError("NOPLoggerFactory not supported");
        }
    }

    public static InternalLoggerFactory getInstanceWithNopCheck() {
        return NopInstanceHolder.INSTANCE_WITH_NOP_CHECK;
    }

    public static InternalLogger wrapLogger(we2 we2Var) {
        return new Slf4JLogger(we2Var);
    }

    @Override // io.netty.util.internal.logging.InternalLoggerFactory
    public InternalLogger newInstance(String str) {
        return wrapLogger(xe2.d(str));
    }

    @Deprecated
    public Slf4JLoggerFactory() {
    }
}
