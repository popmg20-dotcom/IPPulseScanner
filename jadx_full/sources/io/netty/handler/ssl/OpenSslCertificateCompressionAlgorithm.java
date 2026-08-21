package io.netty.handler.ssl;

import javax.net.ssl.SSLEngine;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public interface OpenSslCertificateCompressionAlgorithm {
    int algorithmId();

    byte[] compress(SSLEngine sSLEngine, byte[] bArr);

    byte[] decompress(SSLEngine sSLEngine, int i, byte[] bArr);
}
