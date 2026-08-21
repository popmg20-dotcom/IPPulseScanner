package io.netty.handler.ssl;

import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
interface OpenSslSession extends SSLSession {
    OpenSslSessionContext getSessionContext();

    void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j, long j2);

    OpenSslSessionId sessionId();

    void setLocalCertificate(Certificate[] certificateArr);

    void setSessionId(OpenSslSessionId openSslSessionId);

    void tryExpandApplicationBufferSize(int i);
}
