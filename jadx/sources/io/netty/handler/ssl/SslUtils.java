package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.util.NetUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.DesugarCollections;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.KeyManagementException;
import java.security.Provider;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class SslUtils {
    static final String[] DEFAULT_CIPHER_SUITES;
    static final String[] DEFAULT_TLSV13_CIPHER_SUITES;
    static final int GMSSL_PROTOCOL_VERSION = 257;
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    static final int NOT_ENCRYPTED = -2;
    static final int NOT_ENOUGH_DATA = -1;
    static final int SSL_CONTENT_TYPE_ALERT = 21;
    static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
    static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    static final int SSL_RECORD_HEADER_LENGTH = 5;
    static final String[] TLSV13_CIPHER_SUITES;
    private static final boolean TLSV1_3_JDK_DEFAULT_ENABLED;
    private static final boolean TLSV1_3_JDK_SUPPORTED;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SslUtils.class);
    static final Set<String> TLSV13_CIPHERS = DesugarCollections.unmodifiableSet(new LinkedHashSet(Arrays.asList(Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256, Ciphers.TLS_AES_128_GCM_SHA256, "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256")));

    static {
        String[] strArr = {Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384};
        TLSV13_CIPHER_SUITES = strArr;
        boolean zIsTLSv13SupportedByJDK0 = isTLSv13SupportedByJDK0(null);
        TLSV1_3_JDK_SUPPORTED = zIsTLSv13SupportedByJDK0;
        TLSV1_3_JDK_DEFAULT_ENABLED = isTLSv13EnabledByJDK0(null);
        if (zIsTLSv13SupportedByJDK0) {
            DEFAULT_TLSV13_CIPHER_SUITES = strArr;
        } else {
            strArr = EmptyArrays.EMPTY_STRINGS;
            DEFAULT_TLSV13_CIPHER_SUITES = strArr;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384);
        linkedHashSet.add(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA);
        linkedHashSet.add(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA);
        Collections.addAll(linkedHashSet, strArr);
        DEFAULT_CIPHER_SUITES = (String[]) linkedHashSet.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    private SslUtils() {
    }

    public static void addIfSupported(Set<String> set, List<String> list, String... strArr) {
        for (String str : strArr) {
            if (set.contains(str)) {
                list.add(str);
            }
        }
    }

    public static boolean arrayContains(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0076 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int getEncryptedPacketLength(java.nio.ByteBuffer r7) {
        /*
            int r0 = r7.position()
            byte r1 = r7.get(r0)
            short r1 = unsignedByte(r1)
            r2 = 1
            r3 = 0
            switch(r1) {
                case 20: goto L13;
                case 21: goto L13;
                case 22: goto L13;
                case 23: goto L13;
                case 24: goto L13;
                default: goto L11;
            }
        L11:
            r1 = r3
            goto L14
        L13:
            r1 = r2
        L14:
            r4 = 3
            if (r1 == 0) goto L3b
            int r5 = r0 + 1
            byte r6 = r7.get(r5)
            short r6 = unsignedByte(r6)
            if (r6 == r4) goto L2e
            short r5 = r7.getShort(r5)
            r6 = 257(0x101, float:3.6E-43)
            if (r5 != r6) goto L2c
            goto L2e
        L2c:
            r5 = r3
            goto L3d
        L2e:
            int r5 = r0 + 3
            int r5 = unsignedShortBE(r7, r5)
            r6 = 5
            int r5 = r5 + r6
            if (r5 > r6) goto L39
            goto L3d
        L39:
            r3 = r1
            goto L3d
        L3b:
            r5 = r3
            goto L39
        L3d:
            if (r3 != 0) goto L76
            byte r1 = r7.get(r0)
            short r1 = unsignedByte(r1)
            r1 = r1 & 128(0x80, float:1.8E-43)
            r3 = 2
            if (r1 == 0) goto L4e
            r1 = r3
            goto L4f
        L4e:
            r1 = r4
        L4f:
            int r5 = r0 + r1
            int r5 = r5 + r2
            byte r2 = r7.get(r5)
            short r2 = unsignedByte(r2)
            if (r2 == r3) goto L61
            if (r2 != r4) goto L5f
            goto L61
        L5f:
            r7 = -2
            return r7
        L61:
            if (r1 != r3) goto L6b
            short r7 = shortBE(r7, r0)
            r7 = r7 & 32767(0x7fff, float:4.5916E-41)
            int r7 = r7 + r3
            goto L72
        L6b:
            short r7 = shortBE(r7, r0)
            r7 = r7 & 16383(0x3fff, float:2.2957E-41)
            int r7 = r7 + r4
        L72:
            if (r7 > r1) goto L75
            r7 = -1
        L75:
            return r7
        L76:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslUtils.getEncryptedPacketLength(java.nio.ByteBuffer):int");
    }

    public static SSLContext getSSLContext(String str) throws KeyManagementException {
        SSLContext sSLContext = StringUtil.isNullOrEmpty(str) ? SSLContext.getInstance(getTlsVersion()) : SSLContext.getInstance(getTlsVersion(), str);
        sSLContext.init(null, new TrustManager[0], null);
        return sSLContext;
    }

    private static String getTlsVersion() {
        return TLSV1_3_JDK_SUPPORTED ? SslProtocols.TLS_v1_3 : SslProtocols.TLS_v1_2;
    }

    public static void handleHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z) {
        channelHandlerContext.flush();
        if (z) {
            channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(th));
        }
        channelHandlerContext.close();
    }

    public static boolean isTLSv13Cipher(String str) {
        return TLSV13_CIPHERS.contains(str);
    }

    public static boolean isTLSv13EnabledByJDK(Provider provider) {
        return provider == null ? TLSV1_3_JDK_DEFAULT_ENABLED : isTLSv13EnabledByJDK0(provider);
    }

    private static boolean isTLSv13EnabledByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getDefaultSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable th) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} enables TLSv1.3 by default, assuming no", provider, th);
            return false;
        }
    }

    public static boolean isTLSv13SupportedByJDK(Provider provider) {
        return provider == null ? TLSV1_3_JDK_SUPPORTED : isTLSv13SupportedByJDK0(provider);
    }

    private static boolean isTLSv13SupportedByJDK0(Provider provider) {
        try {
            return arrayContains(newInitContext(provider).getSupportedSSLParameters().getProtocols(), SslProtocols.TLS_v1_3);
        } catch (Throwable th) {
            logger.debug("Unable to detect if JDK SSLEngine with provider {} supports TLSv1.3, assuming no", provider, th);
            return false;
        }
    }

    public static boolean isValidHostNameForSNI(String str) {
        return (str == null || str.indexOf(46) <= 0 || str.endsWith(".") || str.startsWith("/") || NetUtil.isValidIpV4Address(str) || NetUtil.isValidIpV6Address(str)) ? false : true;
    }

    private static SSLContext newInitContext(Provider provider) throws KeyManagementException {
        SSLContext sSLContext = provider == null ? SSLContext.getInstance("TLS") : SSLContext.getInstance("TLS", provider);
        sSLContext.init(null, new TrustManager[0], null);
        return sSLContext;
    }

    private static short shortBE(ByteBuffer byteBuffer, int i) {
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? byteBuffer.getShort(i) : ByteBufUtil.swapShort(byteBuffer.getShort(i));
    }

    public static ByteBuf toBase64(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        ByteBuf byteBufEncode = Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), true, Base64Dialect.STANDARD, byteBufAllocator);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return byteBufEncode;
    }

    public static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        return th instanceof SSLHandshakeException ? (SSLHandshakeException) th : (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    private static short unsignedByte(byte b) {
        return (short) (b & 255);
    }

    private static int unsignedShortBE(ByteBuf byteBuf, int i) {
        int unsignedShort = byteBuf.getUnsignedShort(i);
        return byteBuf.order() == ByteOrder.LITTLE_ENDIAN ? Integer.reverseBytes(unsignedShort) >>> 16 : unsignedShort;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, Iterable<String> iterable) {
        if (list.isEmpty()) {
            for (String str : iterable) {
                if (!str.startsWith("SSL_") && !str.contains("_RC4_")) {
                    list.add(str);
                }
            }
        }
    }

    public static void zeroout(ByteBuf byteBuf) {
        if (byteBuf.isReadOnly()) {
            return;
        }
        byteBuf.setZero(0, byteBuf.capacity());
    }

    public static void zerooutAndRelease(ByteBuf byteBuf) {
        zeroout(byteBuf);
        byteBuf.release();
    }

    private static int unsignedShortBE(ByteBuffer byteBuffer, int i) {
        return shortBE(byteBuffer, i) & 65535;
    }

    private static short shortBE(ByteBuf byteBuf, int i) {
        short s = byteBuf.getShort(i);
        return byteBuf.order() == ByteOrder.LITTLE_ENDIAN ? Short.reverseBytes(s) : s;
    }

    public static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, String... strArr) {
        useFallbackCiphersIfDefaultIsEmpty(list, Arrays.asList(strArr));
    }

    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer = byteBufferArr[i];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        while (true) {
            int i2 = i + 1;
            ByteBuffer byteBufferDuplicate = byteBufferArr[i].duplicate();
            if (byteBufferDuplicate.remaining() > byteBufferAllocate.remaining()) {
                byteBufferDuplicate.limit(byteBufferAllocate.remaining() + byteBufferDuplicate.position());
            }
            byteBufferAllocate.put(byteBufferDuplicate);
            if (!byteBufferAllocate.hasRemaining()) {
                byteBufferAllocate.flip();
                return getEncryptedPacketLength(byteBufferAllocate);
            }
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int getEncryptedPacketLength(io.netty.buffer.ByteBuf r6, int r7) {
        /*
            short r0 = r6.getUnsignedByte(r7)
            r1 = 1
            r2 = 0
            switch(r0) {
                case 20: goto Lb;
                case 21: goto Lb;
                case 22: goto Lb;
                case 23: goto Lb;
                case 24: goto Lb;
                default: goto L9;
            }
        L9:
            r0 = r2
            goto Lc
        Lb:
            r0 = r1
        Lc:
            r3 = 3
            if (r0 == 0) goto L2f
            int r4 = r7 + 1
            short r5 = r6.getUnsignedByte(r4)
            if (r5 == r3) goto L22
            short r4 = r6.getShort(r4)
            r5 = 257(0x101, float:3.6E-43)
            if (r4 != r5) goto L20
            goto L22
        L20:
            r4 = r2
            goto L31
        L22:
            int r4 = r7 + 3
            int r4 = unsignedShortBE(r6, r4)
            r5 = 5
            int r4 = r4 + r5
            if (r4 > r5) goto L2d
            goto L31
        L2d:
            r2 = r0
            goto L31
        L2f:
            r4 = r2
            goto L2d
        L31:
            if (r2 != 0) goto L62
            short r0 = r6.getUnsignedByte(r7)
            r0 = r0 & 128(0x80, float:1.8E-43)
            r2 = 2
            if (r0 == 0) goto L3e
            r0 = r2
            goto L3f
        L3e:
            r0 = r3
        L3f:
            int r4 = r7 + r0
            int r4 = r4 + r1
            short r1 = r6.getUnsignedByte(r4)
            if (r1 == r2) goto L4d
            if (r1 != r3) goto L4b
            goto L4d
        L4b:
            r6 = -2
            return r6
        L4d:
            if (r0 != r2) goto L57
            short r6 = shortBE(r6, r7)
            r6 = r6 & 32767(0x7fff, float:4.5916E-41)
            int r6 = r6 + r2
            goto L5e
        L57:
            short r6 = shortBE(r6, r7)
            r6 = r6 & 16383(0x3fff, float:2.2957E-41)
            int r6 = r6 + r3
        L5e:
            if (r6 > r0) goto L61
            r6 = -1
        L61:
            return r6
        L62:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslUtils.getEncryptedPacketLength(io.netty.buffer.ByteBuf, int):int");
    }
}
