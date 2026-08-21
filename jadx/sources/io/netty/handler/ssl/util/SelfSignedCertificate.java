package io.netty.handler.ssl.util;

import defpackage.ha0;
import defpackage.xe;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class SelfSignedCertificate {
    private final X509Certificate cert;
    private final File certificate;
    private final PrivateKey key;
    private final File privateKey;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) SelfSignedCertificate.class);
    private static final Date DEFAULT_NOT_BEFORE = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotBefore", System.currentTimeMillis() - 31536000000L));
    private static final Date DEFAULT_NOT_AFTER = new Date(SystemPropertyUtil.getLong("io.netty.selfSignedCertificate.defaultNotAfter", 253402300799000L));
    private static final int DEFAULT_KEY_LENGTH_BITS = SystemPropertyUtil.getInt("io.netty.handler.ssl.util.selfSignedKeyStrength", 2048);

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i, Date date, Date date2, String str2) throws Throwable {
        CertificateException certificateException;
        String[] strArrGenerate;
        Throwable th;
        Exception exc;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (!"EC".equalsIgnoreCase(str2) && !"RSA".equalsIgnoreCase(str2)) {
            xe.k(ha0.n("Algorithm not valid: ", str2));
            throw null;
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(str2);
            keyPairGenerator.initialize(i, secureRandom);
            KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
            try {
                strArrGenerate = BouncyCastleSelfSignedCertGenerator.generate(str, keyPairGenerateKeyPair, secureRandom, date, date2, str2);
            } finally {
                try {
                } catch (Throwable th2) {
                }
            }
            File file = new File(strArrGenerate[0]);
            this.certificate = file;
            this.privateKey = new File(strArrGenerate[1]);
            this.key = keyPairGenerateKeyPair.getPrivate();
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (Exception e) {
                    exc = e;
                }
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                this.cert = (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (logger.isWarnEnabled()) {
                        logger.warn("Failed to close a file: " + this.certificate, (Throwable) e2);
                    }
                }
            } catch (Exception e3) {
                exc = e3;
                fileInputStream2 = fileInputStream;
                throw new CertificateEncodingException(exc);
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 == null) {
                    throw th;
                }
                try {
                    fileInputStream2.close();
                    throw th;
                } catch (IOException e4) {
                    if (!logger.isWarnEnabled()) {
                        throw th;
                    }
                    logger.warn("Failed to close a file: " + this.certificate, (Throwable) e4);
                    throw th;
                }
            }
        } catch (NoSuchAlgorithmException e5) {
            throw new Error(e5);
        }
    }

    public static String[] newSelfSignedCertificate(String str, PrivateKey privateKey, X509Certificate x509Certificate) throws IOException {
        ByteBuf byteBufWrappedBuffer = Unpooled.wrappedBuffer(privateKey.getEncoded());
        try {
            ByteBuf byteBufEncode = Base64.encode(byteBufWrappedBuffer, true);
            try {
                StringBuilder sb = new StringBuilder("-----BEGIN PRIVATE KEY-----\n");
                Charset charset = CharsetUtil.US_ASCII;
                sb.append(byteBufEncode.toString(charset));
                sb.append("\n-----END PRIVATE KEY-----\n");
                String string = sb.toString();
                byteBufWrappedBuffer.release();
                String strReplaceAll = str.replaceAll("[^\\w.-]", "x");
                File fileCreateTempFile = PlatformDependent.createTempFile("keyutil_" + strReplaceAll + '_', ".key", null);
                fileCreateTempFile.deleteOnExit();
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    fileOutputStream.write(string.getBytes(charset));
                    fileOutputStream.close();
                    byteBufWrappedBuffer = Unpooled.wrappedBuffer(x509Certificate.getEncoded());
                    try {
                        try {
                            String str2 = "-----BEGIN CERTIFICATE-----\n" + Base64.encode(byteBufWrappedBuffer, true).toString(charset) + "\n-----END CERTIFICATE-----\n";
                            byteBufWrappedBuffer.release();
                            File fileCreateTempFile2 = PlatformDependent.createTempFile("keyutil_" + strReplaceAll + '_', ".crt", null);
                            fileCreateTempFile2.deleteOnExit();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(fileCreateTempFile2);
                            try {
                                fileOutputStream2.write(str2.getBytes(charset));
                                fileOutputStream2.close();
                                return new String[]{fileCreateTempFile2.getPath(), fileCreateTempFile.getPath()};
                            } catch (Throwable th) {
                                safeClose(fileCreateTempFile2, fileOutputStream2);
                                safeDelete(fileCreateTempFile2);
                                safeDelete(fileCreateTempFile);
                                throw th;
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    safeClose(fileCreateTempFile, fileOutputStream);
                    safeDelete(fileCreateTempFile);
                    throw th2;
                }
            } finally {
            }
        } finally {
        }
    }

    private static void safeClose(File file, OutputStream outputStream) {
        try {
            outputStream.close();
        } catch (IOException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a file: " + file, (Throwable) e);
            }
        }
    }

    private static void safeDelete(File file) {
        if (file.delete()) {
            return;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isWarnEnabled()) {
            internalLogger.warn("Failed to delete a file: " + file);
        }
    }

    public X509Certificate cert() {
        return this.cert;
    }

    public File certificate() {
        return this.certificate;
    }

    public void delete() {
        safeDelete(this.certificate);
        safeDelete(this.privateKey);
    }

    public PrivateKey key() {
        return this.key;
    }

    public File privateKey() {
        return this.privateKey;
    }

    public SelfSignedCertificate(Date date, Date date2) {
        this("localhost", date, date2, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(Date date, Date date2, String str, int i) {
        this("localhost", date, date2, str, i);
    }

    public SelfSignedCertificate(String str) {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }

    public SelfSignedCertificate(String str, String str2, int i) {
        this(str, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2, i);
    }

    public SelfSignedCertificate(String str, Date date, Date date2) {
        this(str, ThreadLocalInsecureRandom.current(), DEFAULT_KEY_LENGTH_BITS, date, date2, "RSA");
    }

    public SelfSignedCertificate(String str, Date date, Date date2, String str2, int i) {
        this(str, ThreadLocalInsecureRandom.current(), i, date, date2, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i) {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA");
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, String str2, int i) {
        this(str, secureRandom, i, DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, str2);
    }

    public SelfSignedCertificate(String str, SecureRandom secureRandom, int i, Date date, Date date2) {
        this(str, secureRandom, i, date, date2, "RSA");
    }

    public SelfSignedCertificate() {
        this(DEFAULT_NOT_BEFORE, DEFAULT_NOT_AFTER, "RSA", DEFAULT_KEY_LENGTH_BITS);
    }
}
