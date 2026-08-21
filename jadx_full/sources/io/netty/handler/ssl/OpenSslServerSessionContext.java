package io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
        super(referenceCountedOpenSslContext, openSslKeyMaterialProvider, SSL.SSL_SESS_CACHE_SERVER, new OpenSslSessionCache(referenceCountedOpenSslContext.engineMap));
    }

    public boolean setSessionIdContext(byte[] bArr) {
        Lock lockWriteLock = this.context.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            return SSLContext.setSessionIdContext(this.context.ctx, bArr);
        } finally {
            lockWriteLock.unlock();
        }
    }
}
