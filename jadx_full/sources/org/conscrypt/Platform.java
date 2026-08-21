package org.conscrypt;

import android.os.Build;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import defpackage.ha0;
import defpackage.l0;
import defpackage.vp1;
import defpackage.zo2;
import io.sentry.android.core.a1;
import io.sentry.p6;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.security.AlgorithmParameters;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.ct.CTLogStore;
import org.conscrypt.ct.CTPolicy;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
final class Platform {
    private static final String TAG = "Conscrypt";
    private static Method m_getCurveName;

    static {
        try {
            Method declaredMethod = ECParameterSpec.class.getDeclaredMethod("getCurveName", null);
            m_getCurveName = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (Exception unused) {
        }
    }

    private Platform() {
    }

    public static void blockGuardOnNetwork() {
        BlockGuard.getThreadPolicy().onNetwork();
    }

    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, Socket.class, abstractConscryptSocket) || checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, String.class, abstractConscryptSocket.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, AbstractConscryptSocket abstractConscryptSocket) throws CertificateException {
        if (checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, Socket.class, abstractConscryptSocket) || checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, String.class, abstractConscryptSocket.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    private static boolean checkTrusted(String str, X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str2, Class<?> cls, Object obj) throws CertificateException {
        try {
            x509TrustManager.getClass().getMethod(str, X509Certificate[].class, String.class, cls).invoke(x509TrustManager, x509CertificateArr, str2, obj);
            return true;
        } catch (IllegalAccessException | NoSuchMethodException unused) {
            return false;
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof CertificateException) {
                throw ((CertificateException) e.getCause());
            }
            vp1.p(e.getCause());
            return false;
        }
    }

    public static void closeGuardClose(Object obj) {
        ((CloseGuard) obj).close();
    }

    public static CloseGuard closeGuardGet() {
        return CloseGuard.get();
    }

    public static void closeGuardOpen(Object obj, String str) {
        ((CloseGuard) obj).open(str);
    }

    public static void closeGuardWarnIfOpen(Object obj) {
        ((CloseGuard) obj).warnIfOpen();
    }

    public static ConscryptEngineSocket createEngineSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) {
        return Build.VERSION.SDK_INT >= 24 ? new Java8EngineSocket(str, i, inetAddress, i2, sSLParametersImpl) : new ConscryptEngineSocket(str, i, inetAddress, i2, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(String str, int i, InetAddress inetAddress, int i2, SSLParametersImpl sSLParametersImpl) {
        return Build.VERSION.SDK_INT >= 24 ? new Java8FileDescriptorSocket(str, i, inetAddress, i2, sSLParametersImpl) : new ConscryptFileDescriptorSocket(str, i, inetAddress, i2, sSLParametersImpl);
    }

    public static GCMParameters fromGCMParameterSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        Class<?> cls;
        try {
            cls = Class.forName("javax.crypto.spec.GCMParameterSpec");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null && cls.isAssignableFrom(algorithmParameterSpec.getClass())) {
            try {
                return new GCMParameters(((Integer) cls.getMethod("getTLen", null).invoke(algorithmParameterSpec, null)).intValue(), (byte[]) cls.getMethod("getIV", null).invoke(algorithmParameterSpec, null));
            } catch (IllegalAccessException e) {
                zo2.o("GCMParameterSpec lacks expected methods", e);
                return null;
            } catch (NoSuchMethodException e2) {
                zo2.o("GCMParameterSpec lacks expected methods", e2);
            } catch (InvocationTargetException e3) {
                zo2.o("Could not fetch GCM parameters", e3.getTargetException());
                return null;
            }
        }
        return null;
    }

    public static AlgorithmParameterSpec fromGCMParameters(AlgorithmParameters algorithmParameters) {
        Class<?> cls;
        try {
            cls = Class.forName("javax.crypto.spec.GCMParameterSpec");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return algorithmParameters.getParameterSpec(cls);
            } catch (InvalidParameterSpecException unused2) {
            }
        }
        return null;
    }

    private static Class<?> getClass(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            try {
                return Class.forName(strArr[i]);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getCurveName(ECParameterSpec eCParameterSpec) {
        Method method = m_getCurveName;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(eCParameterSpec, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static KeyStore getDefaultCertKeyStore() throws KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
        try {
            keyStore.load(null, null);
            return keyStore;
        } catch (IOException e) {
            throw new KeyStoreException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new KeyStoreException(e2);
        } catch (CertificateException e3) {
            throw new KeyStoreException(e3);
        }
    }

    public static ConscryptHostnameVerifier getDefaultHostnameVerifier() {
        return OkHostnameVerifier.strictInstance();
    }

    public static String getDefaultProviderName() {
        return TAG;
    }

    public static String getEndpointIdentificationAlgorithm(SSLParameters sSLParameters) {
        return null;
    }

    public static FileDescriptor getFileDescriptor(Socket socket) {
        try {
            Field declaredField = Socket.class.getDeclaredField("impl");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(socket);
            Field declaredField2 = SocketImpl.class.getDeclaredField("fd");
            declaredField2.setAccessible(true);
            return (FileDescriptor) declaredField2.get(obj);
        } catch (Exception e) {
            zo2.o("Can't get FileDescriptor from socket", e);
            return null;
        }
    }

    public static FileDescriptor getFileDescriptorFromSSLSocket(AbstractConscryptSocket abstractConscryptSocket) {
        return getFileDescriptor(abstractConscryptSocket);
    }

    public static String getHostStringFromInetSocketAddress(InetSocketAddress inetSocketAddress) {
        if (Build.VERSION.SDK_INT > 23) {
            try {
                return (String) InetSocketAddress.class.getDeclaredMethod("getHostString", null).invoke(inetSocketAddress, null);
            } catch (InvocationTargetException e) {
                vp1.p(e);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getOriginalHostNameFromInetAddress(InetAddress inetAddress) {
        if (Build.VERSION.SDK_INT > 27) {
            try {
                Method declaredMethod = InetAddress.class.getDeclaredMethod("holder", null);
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredMethod("getOriginalHostName", null);
                declaredMethod2.setAccessible(true);
                String str = (String) declaredMethod2.invoke(declaredMethod.invoke(inetAddress, null), null);
                return str == null ? inetAddress.getHostAddress() : str;
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException unused) {
            } catch (InvocationTargetException e) {
                zo2.o("Failed to get originalHostName", e);
                return null;
            }
        }
        return inetAddress.getHostAddress();
    }

    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        try {
            getSSLParametersFromImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT >= 24) {
                setParametersSniHostname(sSLParameters, sSLParametersImpl, abstractConscryptSocket);
            }
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e) {
            vp1.p(e.getCause());
        }
    }

    private static void getSSLParametersFromImpl(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl) throws IllegalAccessException, InvocationTargetException {
        sSLParameters.getClass().getMethod("setEndpointIdentificationAlgorithm", String.class).invoke(sSLParameters, sSLParametersImpl.getEndpointIdentificationAlgorithm());
        sSLParameters.getClass().getMethod("setUseCipherSuitesOrder", Boolean.TYPE).invoke(sSLParameters, Boolean.valueOf(sSLParametersImpl.getUseCipherSuitesOrder()));
    }

    private static String getSniHostnameFromParams(SSLParameters sSLParameters) {
        List list = (List) sSLParameters.getClass().getMethod("getServerNames", null).invoke(sSLParameters, null);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SNIServerName sNIServerNameF = vp1.f(it.next());
                if (sNIServerNameF.getType() == 0) {
                    return vp1.c(sNIServerNameF).getAsciiName();
                }
            }
        }
        return null;
    }

    public static boolean isCTVerificationRequired(String str) {
        boolean zBooleanValue = false;
        if (str == null) {
            return false;
        }
        String property = Security.getProperty("conscrypt.ct.enable");
        if (property != null && Boolean.valueOf(property).booleanValue()) {
            List<String> listAsList = Arrays.asList(str.split("\\."));
            Collections.reverse(listAsList);
            String strO = "conscrypt.ct.enforce";
            for (String str2 : listAsList) {
                String property2 = Security.getProperty(strO.concat(p6.DEFAULT_PROPAGATION_TARGETS));
                if (property2 != null) {
                    zBooleanValue = Boolean.valueOf(property2).booleanValue();
                }
                strO = ha0.o(strO, ".", str2);
            }
            String property3 = Security.getProperty(strO);
            if (property3 != null) {
                return Boolean.valueOf(property3).booleanValue();
            }
        }
        return zBooleanValue;
    }

    public static void logEvent(String str) {
        try {
            Class<?> cls = Class.forName("android.os.Process");
            Integer num = (Integer) cls.getMethod("myUid", null).invoke(cls.getDeclaredConstructor(null).newInstance(null), null);
            num.intValue();
            Class<?> cls2 = Class.forName("android.util.EventLog");
            cls2.getMethod("writeEvent", Integer.TYPE, Object[].class).invoke(cls2.getDeclaredConstructor(null).newInstance(null), 1397638484, new Object[]{"conscrypt", num, str});
        } catch (Exception unused) {
        }
    }

    private static void logStackTraceSnippet(String str, Throwable th) {
        a1.n(TAG, str);
        StackTraceElement[] stackTrace = th.getStackTrace();
        for (int i = 0; i < 2 && i < stackTrace.length; i++) {
            a1.n(TAG, "\tat " + stackTrace[i].toString());
        }
    }

    public static CertBlocklist newDefaultBlocklist() {
        return null;
    }

    public static ConscryptCertStore newDefaultCertStore() {
        return null;
    }

    public static CTLogStore newDefaultLogStore() {
        return null;
    }

    public static CTPolicy newDefaultPolicy(CTLogStore cTLogStore) {
        return null;
    }

    public static String oidToAlgorithmName(String str) {
        try {
            try {
                Method declaredMethod = Class.forName("org.apache.harmony.security.utils.AlgNameMapper").getDeclaredMethod("map2AlgName", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, str);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                vp1.p(e);
                return null;
            } catch (Exception unused) {
                Class<?> cls = Class.forName("sun.security.x509.AlgorithmId");
                Method declaredMethod2 = cls.getDeclaredMethod("get", String.class);
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("getName", null);
                declaredMethod3.setAccessible(true);
                return (String) declaredMethod3.invoke(declaredMethod2.invoke(null, str), null);
            }
        } catch (InvocationTargetException e2) {
            Throwable cause2 = e2.getCause();
            if (cause2 instanceof RuntimeException) {
                throw ((RuntimeException) cause2);
            }
            if (cause2 instanceof Error) {
                throw ((Error) cause2);
            }
            vp1.p(e2);
            return null;
        } catch (Exception unused2) {
            return str;
        }
    }

    public static boolean provideTrustManagerByDefault() {
        return false;
    }

    public static boolean serverNamePermitted(SSLParametersImpl sSLParametersImpl, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return serverNamePermittedInternal(sSLParametersImpl, str);
        }
        return true;
    }

    private static boolean serverNamePermittedInternal(SSLParametersImpl sSLParametersImpl, String str) {
        Collection<SNIMatcher> sNIMatchers = sSLParametersImpl.getSNIMatchers();
        if (sNIMatchers == null || sNIMatchers.isEmpty()) {
            return true;
        }
        Iterator<SNIMatcher> it = sNIMatchers.iterator();
        while (it.hasNext()) {
            if (vp1.d(it.next()).matches(l0.s(str))) {
                return true;
            }
        }
        return false;
    }

    public static void setCurveName(ECParameterSpec eCParameterSpec, String str) {
        try {
            eCParameterSpec.getClass().getDeclaredMethod("setCurveName", String.class).invoke(eCParameterSpec, str);
        } catch (Exception unused) {
        }
    }

    private static void setParametersSniHostname(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sSLParametersImpl.getUseSni() && AddressUtils.isValidSniHostname(abstractConscryptSocket.getHostname())) {
            Method method = sSLParameters.getClass().getMethod("setServerNames", List.class);
            l0.c();
            method.invoke(sSLParameters, Collections.singletonList(l0.s(abstractConscryptSocket.getHostname())));
        }
    }

    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, AbstractConscryptSocket abstractConscryptSocket) {
        String sniHostnameFromParams;
        try {
            setSSLParametersOnImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT < 24 || (sniHostnameFromParams = getSniHostnameFromParams(sSLParameters)) == null) {
                return;
            }
            abstractConscryptSocket.setHostname(sniHostnameFromParams);
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e) {
            vp1.p(e.getCause());
        }
    }

    private static void setSSLParametersOnImpl(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl) {
        sSLParametersImpl.setEndpointIdentificationAlgorithm((String) sSLParameters.getClass().getMethod("getEndpointIdentificationAlgorithm", null).invoke(sSLParameters, null));
        sSLParametersImpl.setUseCipherSuitesOrder(((Boolean) sSLParameters.getClass().getMethod("getUseCipherSuitesOrder", null).invoke(sSLParameters, null)).booleanValue());
    }

    public static void setSocketWriteTimeout(Socket socket, long j) {
        try {
            FileDescriptor fileDescriptor = getFileDescriptor(socket);
            if (fileDescriptor == null || !fileDescriptor.valid()) {
                throw new SocketException("Socket closed");
            }
            Class<?> cls = getClass("android.system.StructTimeval", "libcore.io.StructTimeval");
            if (cls == null) {
                a1.n(TAG, "StructTimeval == null; not setting socket write timeout");
                return;
            }
            Method declaredMethod = cls.getDeclaredMethod("fromMillis", Long.TYPE);
            if (declaredMethod == null) {
                a1.n(TAG, "fromMillis == null; not setting socket write timeout");
                return;
            }
            Object objInvoke = declaredMethod.invoke(null, Long.valueOf(j));
            Field field = Class.forName("libcore.io.Libcore").getField("os");
            if (field == null) {
                a1.n(TAG, "os == null; not setting socket write timeout");
                return;
            }
            Object obj = field.get(null);
            if (obj == null) {
                a1.n(TAG, "instance_os == null; not setting socket write timeout");
                return;
            }
            Class<?> cls2 = getClass("android.system.OsConstants", "libcore.io.OsConstants");
            if (cls2 == null) {
                a1.n(TAG, "OsConstants == null; not setting socket write timeout");
                return;
            }
            Field field2 = cls2.getField("SOL_SOCKET");
            if (field2 == null) {
                a1.n(TAG, "SOL_SOCKET == null; not setting socket write timeout");
                return;
            }
            Field field3 = cls2.getField("SO_SNDTIMEO");
            if (field3 == null) {
                a1.n(TAG, "SO_SNDTIMEO == null; not setting socket write timeout");
                return;
            }
            Class<?> cls3 = obj.getClass();
            Class<?> cls4 = Integer.TYPE;
            Method method = cls3.getMethod("setsockoptTimeval", FileDescriptor.class, cls4, cls4, cls);
            if (method == null) {
                a1.n(TAG, "setsockoptTimeval == null; not setting socket write timeout");
            } else {
                method.invoke(obj, fileDescriptor, field2.get(null), field3.get(null), objInvoke);
            }
        } catch (Exception e) {
            logStackTraceSnippet("Could not set socket write timeout: " + e, e);
            for (Throwable cause = e.getCause(); cause != null; cause = cause.getCause()) {
                logStackTraceSnippet("Caused by: " + cause, cause);
            }
        }
    }

    public static boolean supportsConscryptCertStore() {
        return false;
    }

    public static boolean supportsX509ExtendedTrustManager() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static AlgorithmParameterSpec toGCMParameterSpec(int i, byte[] bArr) {
        Class<?> cls;
        try {
            cls = Class.forName("javax.crypto.spec.GCMParameterSpec");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls != null) {
            try {
                return (AlgorithmParameterSpec) cls.getConstructor(Integer.TYPE, byte[].class).newInstance(Integer.valueOf(i), bArr);
            } catch (IllegalAccessException e) {
                e = e;
                logStackTraceSnippet("Can't find GCMParameterSpec class", e);
                return null;
            } catch (IllegalArgumentException e2) {
                e = e2;
                logStackTraceSnippet("Can't find GCMParameterSpec class", e);
                return null;
            } catch (InstantiationException e3) {
                e = e3;
                logStackTraceSnippet("Can't find GCMParameterSpec class", e);
                return null;
            } catch (NoSuchMethodException e4) {
                e = e4;
                logStackTraceSnippet("Can't find GCMParameterSpec class", e);
                return null;
            } catch (InvocationTargetException e5) {
                logStackTraceSnippet("Can't find GCMParameterSpec class", e5.getCause());
            }
        }
        return null;
    }

    public static OpenSSLKey wrapRsaKey(PrivateKey privateKey) {
        return null;
    }

    public static SSLSession wrapSSLSession(ExternalSession externalSession) {
        return Build.VERSION.SDK_INT >= 24 ? new Java8ExtendedSSLSession(externalSession) : externalSession;
    }

    public static void getSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        try {
            getSSLParametersFromImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT >= 24) {
                setParametersSniHostname(sSLParameters, sSLParametersImpl, conscryptEngine);
            }
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e) {
            vp1.p(e.getCause());
        }
    }

    public static void setSSLParameters(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) {
        String sniHostnameFromParams;
        try {
            setSSLParametersOnImpl(sSLParameters, sSLParametersImpl);
            if (Build.VERSION.SDK_INT < 24 || (sniHostnameFromParams = getSniHostnameFromParams(sSLParameters)) == null) {
                return;
            }
            conscryptEngine.setHostname(sniHostnameFromParams);
        } catch (IllegalAccessException | NoSuchMethodException unused) {
        } catch (InvocationTargetException e) {
            vp1.p(e.getCause());
        }
    }

    public static ConscryptEngineSocket createEngineSocket(String str, int i, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(str, i, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(str, i, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(String str, int i, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(str, i, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(str, i, sSLParametersImpl);
    }

    public static void checkClientTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, SSLEngine.class, conscryptEngine) || checkTrusted("checkClientTrusted", x509TrustManager, x509CertificateArr, str, String.class, conscryptEngine.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    public static void checkServerTrusted(X509TrustManager x509TrustManager, X509Certificate[] x509CertificateArr, String str, ConscryptEngine conscryptEngine) throws CertificateException {
        if (checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, SSLEngine.class, conscryptEngine) || checkTrusted("checkServerTrusted", x509TrustManager, x509CertificateArr, str, String.class, conscryptEngine.getHandshakeSession().getPeerHost())) {
            return;
        }
        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    public static ConscryptEngineSocket createEngineSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(inetAddress, i, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(inetAddress, i, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(InetAddress inetAddress, int i, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(inetAddress, i, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(inetAddress, i, sSLParametersImpl);
    }

    public static ConscryptEngineSocket createEngineSocket(SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(sSLParametersImpl);
        }
        return new ConscryptEngineSocket(sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(sSLParametersImpl);
    }

    public static ConscryptEngineSocket createEngineSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(inetAddress, i, inetAddress2, i2, sSLParametersImpl);
    }

    public static ConscryptEngineSocket createEngineSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8EngineSocket(socket, str, i, z, sSLParametersImpl);
        }
        return new ConscryptEngineSocket(socket, str, i, z, sSLParametersImpl);
    }

    public static ConscryptFileDescriptorSocket createFileDescriptorSocket(Socket socket, String str, int i, boolean z, SSLParametersImpl sSLParametersImpl) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new Java8FileDescriptorSocket(socket, str, i, z, sSLParametersImpl);
        }
        return new ConscryptFileDescriptorSocket(socket, str, i, z, sSLParametersImpl);
    }

    private static void setParametersSniHostname(SSLParameters sSLParameters, SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (sSLParametersImpl.getUseSni() && AddressUtils.isValidSniHostname(conscryptEngine.getHostname())) {
            Method method = sSLParameters.getClass().getMethod("setServerNames", List.class);
            l0.c();
            method.invoke(sSLParameters, Collections.singletonList(l0.s(conscryptEngine.getHostname())));
        }
    }

    public static void setup() {
    }

    public static SSLEngine unwrapEngine(SSLEngine sSLEngine) {
        return sSLEngine;
    }

    public static SSLEngine wrapEngine(ConscryptEngine conscryptEngine) {
        return conscryptEngine;
    }

    public static SSLSocketFactory wrapSocketFactoryIfNeeded(OpenSSLSocketFactoryImpl openSSLSocketFactoryImpl) {
        return openSSLSocketFactoryImpl;
    }

    public static void setEndpointIdentificationAlgorithm(SSLParameters sSLParameters, String str) {
    }
}
