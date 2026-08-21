package org.conscrypt;

import defpackage.xe;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OpenSSLContextImpl extends SSLContextSpi {
    private static DefaultSSLContextImpl defaultSslContextImpl;
    private final ClientSessionContext clientSessionContext;
    private final String[] protocols;
    private final ServerSessionContext serverSessionContext;
    SSLParametersImpl sslParameters;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class TLSv1 extends OpenSSLContextImpl {
        public TLSv1() {
            super(NativeCrypto.TLSV1_PROTOCOLS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class TLSv11 extends OpenSSLContextImpl {
        public TLSv11() {
            super(NativeCrypto.TLSV11_PROTOCOLS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class TLSv12 extends OpenSSLContextImpl {
        public TLSv12() {
            super(NativeCrypto.TLSV12_PROTOCOLS);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class TLSv13 extends OpenSSLContextImpl {
        public TLSv13() {
            super(NativeCrypto.TLSV13_PROTOCOLS);
        }
    }

    public OpenSSLContextImpl(String[] strArr, boolean z) {
        ClientSessionContext clientSessionContext;
        ServerSessionContext serverSessionContext;
        synchronized (DefaultSSLContextImpl.class) {
            try {
                this.protocols = null;
                DefaultSSLContextImpl defaultSSLContextImpl = defaultSslContextImpl;
                if (defaultSSLContextImpl == null) {
                    clientSessionContext = new ClientSessionContext();
                    this.clientSessionContext = clientSessionContext;
                    serverSessionContext = new ServerSessionContext();
                    this.serverSessionContext = serverSessionContext;
                    defaultSslContextImpl = (DefaultSSLContextImpl) this;
                } else {
                    clientSessionContext = (ClientSessionContext) defaultSSLContextImpl.engineGetClientSessionContext();
                    this.clientSessionContext = clientSessionContext;
                    serverSessionContext = (ServerSessionContext) defaultSslContextImpl.engineGetServerSessionContext();
                    this.serverSessionContext = serverSessionContext;
                }
                this.sslParameters = new SSLParametersImpl(defaultSslContextImpl.getKeyManagers(), defaultSslContextImpl.getTrustManagers(), (SecureRandom) null, clientSessionContext, serverSessionContext, strArr);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static OpenSSLContextImpl getPreferred() {
        return new TLSv13();
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine(String str, int i) {
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (sSLParametersImpl == null) {
            xe.q("SSLContext is not initialized.");
            return null;
        }
        SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.clone();
        sSLParametersImpl2.setUseClientMode(false);
        return Platform.wrapEngine(new ConscryptEngine(str, i, sSLParametersImpl2));
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetClientSessionContext() {
        return this.clientSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSessionContext engineGetServerSessionContext() {
        return this.serverSessionContext;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (this.sslParameters != null) {
            return new OpenSSLServerSocketFactoryImpl(this.sslParameters);
        }
        xe.q("SSLContext is not initialized.");
        return null;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLSocketFactory engineGetSocketFactory() {
        if (this.sslParameters != null) {
            return Platform.wrapSocketFactoryIfNeeded(new OpenSSLSocketFactoryImpl(this.sslParameters));
        }
        xe.q("SSLContext is not initialized.");
        return null;
    }

    @Override // javax.net.ssl.SSLContextSpi
    public void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        this.sslParameters = new SSLParametersImpl(keyManagerArr, trustManagerArr, secureRandom, this.clientSessionContext, this.serverSessionContext, this.protocols);
    }

    @Override // javax.net.ssl.SSLContextSpi
    public SSLEngine engineCreateSSLEngine() {
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (sSLParametersImpl != null) {
            SSLParametersImpl sSLParametersImpl2 = (SSLParametersImpl) sSLParametersImpl.clone();
            sSLParametersImpl2.setUseClientMode(false);
            return Platform.wrapEngine(new ConscryptEngine(sSLParametersImpl2));
        }
        xe.q("SSLContext is not initialized.");
        return null;
    }

    public OpenSSLContextImpl(String[] strArr) {
        this.protocols = strArr;
        this.clientSessionContext = new ClientSessionContext();
        this.serverSessionContext = new ServerSessionContext();
    }
}
