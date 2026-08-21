package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkAlpnSslEngine;
import j$.util.function.BiConsumer$CC;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class BouncyCastleAlpnSslEngine extends JdkAlpnSslEngine {
    public BouncyCastleAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        super(sSLEngine, jdkApplicationProtocolNegotiator, z, new BiConsumer<SSLEngine, JdkAlpnSslEngine.AlpnSelector>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslEngine.1
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }

            @Override // java.util.function.BiConsumer
            public void accept(SSLEngine sSLEngine2, JdkAlpnSslEngine.AlpnSelector alpnSelector) {
                BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine2, alpnSelector);
            }
        }, new BiConsumer<SSLEngine, List<String>>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslEngine.2
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }

            @Override // java.util.function.BiConsumer
            public void accept(SSLEngine sSLEngine2, List<String> list) {
                BouncyCastleAlpnSslUtils.setApplicationProtocols(sSLEngine2, list);
            }
        });
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return BouncyCastleAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkAlpnSslEngine, javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        BouncyCastleAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), biFunction);
    }
}
