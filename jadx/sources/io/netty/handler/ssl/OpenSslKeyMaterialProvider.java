package io.netty.handler.ssl;

import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.internal.tcnative.SSL;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509KeyManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
class OpenSslKeyMaterialProvider {
    private final X509KeyManager keyManager;
    private final String password;

    public OpenSslKeyMaterialProvider(X509KeyManager x509KeyManager, String str) {
        this.keyManager = x509KeyManager;
        this.password = str;
    }

    public static void validateKeyMaterialSupported(X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws Throwable {
        validateSupported(x509CertificateArr);
        validateSupported(privateKey, str);
    }

    private static void validateSupported(X509Certificate[] x509CertificateArr) throws Throwable {
        long bio;
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            return;
        }
        long j = 0;
        PemEncoded pem = null;
        try {
            try {
                UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
                pem = PemX509Certificate.toPEM(unpooledByteBufAllocator, true, x509CertificateArr);
                bio = ReferenceCountedOpenSslContext.toBIO(unpooledByteBufAllocator, pem.retain());
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            long x509Chain = SSL.parseX509Chain(bio);
            SSL.freeBIO(bio);
            if (x509Chain != 0) {
                SSL.freeX509Chain(x509Chain);
            }
            pem.release();
        } catch (Exception e2) {
            e = e2;
            throw new SSLException("Certificate type not supported", e);
        } catch (Throwable th2) {
            th = th2;
            j = bio;
            SSL.freeBIO(j);
            if (pem != null) {
                pem.release();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.netty.handler.ssl.OpenSslKeyMaterial chooseKeyMaterial(io.netty.buffer.ByteBufAllocator r17, java.lang.String r18) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            javax.net.ssl.X509KeyManager r3 = r0.keyManager
            java.security.cert.X509Certificate[] r9 = r3.getCertificateChain(r2)
            if (r9 == 0) goto L81
            int r3 = r9.length
            if (r3 != 0) goto L13
            goto L81
        L13:
            javax.net.ssl.X509KeyManager r3 = r0.keyManager
            java.security.PrivateKey r2 = r3.getPrivateKey(r2)
            r3 = 1
            io.netty.handler.ssl.PemEncoded r3 = io.netty.handler.ssl.PemX509Certificate.toPEM(r1, r3, r9)
            r10 = 0
            io.netty.handler.ssl.PemEncoded r4 = r3.retain()     // Catch: java.lang.Throwable -> L64
            long r12 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r1, r4)     // Catch: java.lang.Throwable -> L64
            long r5 = io.netty.internal.tcnative.SSL.parseX509Chain(r12)     // Catch: java.lang.Throwable -> L60
            boolean r4 = r2 instanceof io.netty.handler.ssl.OpenSslPrivateKey     // Catch: java.lang.Throwable -> L37
            if (r4 == 0) goto L3b
            io.netty.handler.ssl.OpenSslPrivateKey r2 = (io.netty.handler.ssl.OpenSslPrivateKey) r2     // Catch: java.lang.Throwable -> L37
            io.netty.handler.ssl.OpenSslKeyMaterial r0 = r2.newKeyMaterial(r5, r9)     // Catch: java.lang.Throwable -> L37
            goto L51
        L37:
            r0 = move-exception
            r7 = r10
        L39:
            r14 = r7
            goto L69
        L3b:
            long r14 = io.netty.handler.ssl.ReferenceCountedOpenSslContext.toBIO(r1, r2)     // Catch: java.lang.Throwable -> L37
            if (r2 != 0) goto L43
            r7 = r10
            goto L4a
        L43:
            java.lang.String r0 = r0.password     // Catch: java.lang.Throwable -> L5d
            long r0 = io.netty.internal.tcnative.SSL.parsePrivateKey(r14, r0)     // Catch: java.lang.Throwable -> L5d
            r7 = r0
        L4a:
            io.netty.handler.ssl.DefaultOpenSslKeyMaterial r4 = new io.netty.handler.ssl.DefaultOpenSslKeyMaterial     // Catch: java.lang.Throwable -> L5b
            r4.<init>(r5, r7, r9)     // Catch: java.lang.Throwable -> L5b
            r0 = r4
            r10 = r14
        L51:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r10)
            r3.release()
            return r0
        L5b:
            r0 = move-exception
            goto L69
        L5d:
            r0 = move-exception
            r7 = r10
            goto L69
        L60:
            r0 = move-exception
            r5 = r10
            r7 = r5
            goto L39
        L64:
            r0 = move-exception
            r5 = r10
            r7 = r5
            r12 = r7
            r14 = r12
        L69:
            io.netty.internal.tcnative.SSL.freeBIO(r12)
            io.netty.internal.tcnative.SSL.freeBIO(r14)
            int r1 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r1 == 0) goto L76
            io.netty.internal.tcnative.SSL.freeX509Chain(r5)
        L76:
            int r1 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r1 == 0) goto L7d
            io.netty.internal.tcnative.SSL.freePrivateKey(r7)
        L7d:
            r3.release()
            throw r0
        L81:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.OpenSslKeyMaterialProvider.chooseKeyMaterial(io.netty.buffer.ByteBufAllocator, java.lang.String):io.netty.handler.ssl.OpenSslKeyMaterial");
    }

    public X509KeyManager keyManager() {
        return this.keyManager;
    }

    public void destroy() {
    }

    private static void validateSupported(PrivateKey privateKey, String str) throws Throwable {
        long bio;
        if (privateKey == null) {
            return;
        }
        long j = 0;
        try {
            try {
                bio = ReferenceCountedOpenSslContext.toBIO(UnpooledByteBufAllocator.DEFAULT, privateKey);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            long privateKey2 = SSL.parsePrivateKey(bio, str);
            SSL.freeBIO(bio);
            if (privateKey2 != 0) {
                SSL.freePrivateKey(privateKey2);
            }
        } catch (Exception e2) {
            e = e2;
            throw new SSLException("PrivateKey type not supported " + privateKey.getFormat(), e);
        } catch (Throwable th2) {
            th = th2;
            j = bio;
            SSL.freeBIO(j);
            throw th;
        }
    }
}
