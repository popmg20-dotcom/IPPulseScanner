package io.netty.handler.ssl;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OpenSslContextOption<T> extends SslContextOption<T> {
    public static final OpenSslContextOption<Boolean> USE_TASKS = new OpenSslContextOption<>("USE_TASKS");
    public static final OpenSslContextOption<Boolean> TLS_FALSE_START = new OpenSslContextOption<>("TLS_FALSE_START");
    public static final OpenSslContextOption<OpenSslPrivateKeyMethod> PRIVATE_KEY_METHOD = new OpenSslContextOption<>("PRIVATE_KEY_METHOD");
    public static final OpenSslContextOption<OpenSslAsyncPrivateKeyMethod> ASYNC_PRIVATE_KEY_METHOD = new OpenSslContextOption<>("ASYNC_PRIVATE_KEY_METHOD");
    public static final OpenSslContextOption<OpenSslCertificateCompressionConfig> CERTIFICATE_COMPRESSION_ALGORITHMS = new OpenSslContextOption<>("CERTIFICATE_COMPRESSION_ALGORITHMS");

    private OpenSslContextOption(String str) {
        super(str);
    }
}
