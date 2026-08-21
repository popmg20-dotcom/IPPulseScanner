package io.netty.handler.ssl;

import defpackage.ha0;
import defpackage.xe;
import io.netty.internal.tcnative.CertificateVerifier;
import java.security.cert.CertificateException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class OpenSslCertificateException extends CertificateException {
    private static final long serialVersionUID = 5542675253797129798L;
    private final int errorCode;

    public OpenSslCertificateException(String str, int i) {
        super(str);
        this.errorCode = checkErrorCode(i);
    }

    private static int checkErrorCode(int i) {
        if (!OpenSsl.isAvailable() || CertificateVerifier.isValid(i)) {
            return i;
        }
        xe.k(ha0.k("errorCode '", i, "' invalid, see https://www.openssl.org/docs/man1.0.2/apps/verify.html."));
        return 0;
    }

    public int errorCode() {
        return this.errorCode;
    }

    public OpenSslCertificateException(int i) {
        this((String) null, i);
    }

    public OpenSslCertificateException(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = checkErrorCode(i);
    }

    public OpenSslCertificateException(Throwable th, int i) {
        this(null, th, i);
    }
}
