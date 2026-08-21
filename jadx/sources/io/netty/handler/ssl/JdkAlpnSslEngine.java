package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import j$.util.function.BiConsumer$CC;
import j$.util.function.BiFunction$CC;
import java.nio.ByteBuffer;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class JdkAlpnSslEngine extends JdkSslEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AlpnSelector alpnSelector;
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListener selectionListener;

    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public final class AlpnSelector implements BiFunction<SSLEngine, List<String>, String> {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private boolean called;
        private final JdkApplicationProtocolNegotiator.ProtocolSelector selector;

        public AlpnSelector(JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector) {
            this.selector = protocolSelector;
        }

        public /* synthetic */ BiFunction andThen(Function function) {
            return BiFunction$CC.$default$andThen(this, function);
        }

        @Override // java.util.function.BiFunction
        public String apply(SSLEngine sSLEngine, List<String> list) {
            this.called = true;
            try {
                String strSelect = this.selector.select(list);
                return strSelect == null ? "" : strSelect;
            } catch (Exception unused) {
                return null;
            }
        }

        public void checkUnsupported() {
            if (!this.called && JdkAlpnSslEngine.this.getApplicationProtocol().isEmpty()) {
                this.selector.unsupported();
            }
        }
    }

    public JdkAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z, BiConsumer<SSLEngine, AlpnSelector> biConsumer, BiConsumer<SSLEngine, List<String>> biConsumer2) {
        super(sSLEngine);
        if (!z) {
            this.selectionListener = jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols());
            this.alpnSelector = null;
            biConsumer2.accept(sSLEngine, jdkApplicationProtocolNegotiator.protocols());
        } else {
            this.selectionListener = null;
            AlpnSelector alpnSelector = new AlpnSelector(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())));
            this.alpnSelector = alpnSelector;
            biConsumer.accept(sSLEngine, alpnSelector);
        }
    }

    private SSLEngineResult verifyProtocolSelection(SSLEngineResult sSLEngineResult) throws SSLHandshakeException {
        if (sSLEngineResult.getHandshakeStatus() == SSLEngineResult.HandshakeStatus.FINISHED) {
            AlpnSelector alpnSelector = this.alpnSelector;
            if (alpnSelector == null) {
                try {
                    String applicationProtocol = getApplicationProtocol();
                    boolean zIsEmpty = applicationProtocol.isEmpty();
                    JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolSelectionListener = this.selectionListener;
                    if (zIsEmpty) {
                        protocolSelectionListener.unsupported();
                        return sSLEngineResult;
                    }
                    protocolSelectionListener.selected(applicationProtocol);
                    return sSLEngineResult;
                } catch (Throwable th) {
                    throw SslUtils.toSSLHandshakeException(th);
                }
            }
            alpnSelector.checkUnsupported();
        }
        return sSLEngineResult;
    }

    @Override // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return JdkAlpnSslUtils.getApplicationProtocol(getWrappedEngine());
    }

    @Override // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocol(getWrappedEngine());
    }

    @Override // javax.net.ssl.SSLEngine
    public BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return JdkAlpnSslUtils.getHandshakeApplicationProtocolSelector(getWrappedEngine());
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        String applicationProtocol = getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(getWrappedEngine(), biFunction);
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBuffer2));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        return verifyProtocolSelection(super.wrap(byteBuffer, byteBuffer2));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBufferArr));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) {
        return verifyProtocolSelection(super.wrap(byteBufferArr, byteBuffer));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) {
        return verifyProtocolSelection(super.unwrap(byteBuffer, byteBufferArr, i, i2));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) {
        return verifyProtocolSelection(super.wrap(byteBufferArr, i, i2, byteBuffer));
    }

    @Override // io.netty.handler.ssl.JdkSslEngine
    public void setNegotiatedApplicationProtocol(String str) {
    }

    public JdkAlpnSslEngine(SSLEngine sSLEngine, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        this(sSLEngine, jdkApplicationProtocolNegotiator, z, new BiConsumer<SSLEngine, AlpnSelector>() { // from class: io.netty.handler.ssl.JdkAlpnSslEngine.1
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }

            @Override // java.util.function.BiConsumer
            public void accept(SSLEngine sSLEngine2, AlpnSelector alpnSelector) {
                JdkAlpnSslUtils.setHandshakeApplicationProtocolSelector(sSLEngine2, alpnSelector);
            }
        }, new BiConsumer<SSLEngine, List<String>>() { // from class: io.netty.handler.ssl.JdkAlpnSslEngine.2
            public /* synthetic */ BiConsumer andThen(BiConsumer biConsumer) {
                return BiConsumer$CC.$default$andThen(this, biConsumer);
            }

            @Override // java.util.function.BiConsumer
            public void accept(SSLEngine sSLEngine2, List<String> list) {
                JdkAlpnSslUtils.setApplicationProtocols(sSLEngine2, list);
            }
        });
    }
}
