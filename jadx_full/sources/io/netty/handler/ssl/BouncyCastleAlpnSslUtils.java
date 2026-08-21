package io.netty.handler.ssl;

import defpackage.ha0;
import defpackage.vp1;
import defpackage.zo2;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import j$.util.function.BiFunction$CC;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class BouncyCastleAlpnSslUtils {
    private static final Class BC_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method BC_APPLICATION_PROTOCOL_SELECTOR_SELECT;
    private static final Class BC_SSL_PARAMETERS;
    private static final Method GET_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL;
    private static final Method GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_APPLICATION_PROTOCOLS;
    private static final Method SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR;
    private static final Method SET_PARAMETERS;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) BouncyCastleAlpnSslUtils.class);

    static {
        Method method;
        Method method2;
        final Class<?> cls;
        Method method3;
        Method method4;
        Method method5;
        Method method6;
        Method method7;
        Class<?> cls2 = null;
        try {
            final Class<?> cls3 = Class.forName("org.bouncycastle.jsse.BCSSLEngine");
            final Class<?> cls4 = Class.forName("org.bouncycastle.jsse.BCSSLParameters");
            Object objNewInstance = cls4.newInstance();
            cls = Class.forName("org.bouncycastle.jsse.BCApplicationProtocolSelector");
            method3 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.1
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls.getMethod("select", Object.class, List.class);
                }
            });
            SSLEngine sSLEngineCreateSSLEngine = SslUtils.getSSLContext("BCJSSE").createSSLEngine();
            method4 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.2
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls3.getMethod("setParameters", cls4);
                }
            });
            method4.invoke(sSLEngineCreateSSLEngine, objNewInstance);
            method6 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.3
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls4.getMethod("setApplicationProtocols", String[].class);
                }
            });
            method6.invoke(objNewInstance, EmptyArrays.EMPTY_STRINGS);
            method2 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.4
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls3.getMethod("getApplicationProtocol", null);
                }
            });
            method2.invoke(sSLEngineCreateSSLEngine, null);
            method5 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.5
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls3.getMethod("getHandshakeApplicationProtocol", null);
                }
            });
            method5.invoke(sSLEngineCreateSSLEngine, null);
            method7 = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.6
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls3.getMethod("setBCHandshakeApplicationProtocolSelector", cls);
                }
            });
            method = (Method) AccessController.doPrivileged(new PrivilegedExceptionAction<Method>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.7
                @Override // java.security.PrivilegedExceptionAction
                public Method run() {
                    return cls3.getMethod("getBCHandshakeApplicationProtocolSelector", null);
                }
            });
            method.invoke(sSLEngineCreateSSLEngine, null);
            cls2 = cls4;
        } catch (Throwable th) {
            logger.error("Unable to initialize BouncyCastleAlpnSslUtils.", th);
            method = null;
            method2 = null;
            cls = null;
            method3 = null;
            method4 = null;
            method5 = null;
            method6 = null;
            method7 = null;
        }
        BC_SSL_PARAMETERS = cls2;
        SET_PARAMETERS = method4;
        SET_APPLICATION_PROTOCOLS = method6;
        GET_APPLICATION_PROTOCOL = method2;
        GET_HANDSHAKE_APPLICATION_PROTOCOL = method5;
        SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method7;
        GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR = method;
        BC_APPLICATION_PROTOCOL_SELECTOR_SELECT = method3;
        BC_APPLICATION_PROTOCOL_SELECTOR = cls;
    }

    private BouncyCastleAlpnSslUtils() {
    }

    public static String getApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_APPLICATION_PROTOCOL.invoke(sSLEngine, null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            zo2.q(e2);
            return null;
        }
    }

    public static String getHandshakeApplicationProtocol(SSLEngine sSLEngine) {
        try {
            return (String) GET_HANDSHAKE_APPLICATION_PROTOCOL.invoke(sSLEngine, null);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            zo2.q(e2);
            return null;
        }
    }

    public static BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector(SSLEngine sSLEngine) {
        try {
            final Object objInvoke = GET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, null);
            return new BiFunction<SSLEngine, List<String>, String>() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.9
                public /* synthetic */ BiFunction andThen(Function function) {
                    return BiFunction$CC.$default$andThen(this, function);
                }

                @Override // java.util.function.BiFunction
                public String apply(SSLEngine sSLEngine2, List<String> list) {
                    try {
                        return (String) BouncyCastleAlpnSslUtils.BC_APPLICATION_PROTOCOL_SELECTOR_SELECT.invoke(objInvoke, sSLEngine2, list);
                    } catch (Exception e) {
                        zo2.o("Could not call getHandshakeApplicationProtocolSelector", e);
                        return null;
                    }
                }
            };
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            zo2.q(e2);
            return null;
        }
    }

    public static void setApplicationProtocols(SSLEngine sSLEngine, List<String> list) {
        SSLParameters sSLParameters = sSLEngine.getSSLParameters();
        String[] strArr = (String[]) list.toArray(EmptyArrays.EMPTY_STRINGS);
        try {
            Object objNewInstance = BC_SSL_PARAMETERS.newInstance();
            SET_APPLICATION_PROTOCOLS.invoke(objNewInstance, strArr);
            SET_PARAMETERS.invoke(sSLEngine, objNewInstance);
            sSLEngine.setSSLParameters(sSLParameters);
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            zo2.q(e2);
        }
    }

    public static void setHandshakeApplicationProtocolSelector(SSLEngine sSLEngine, final BiFunction<SSLEngine, List<String>, String> biFunction) {
        try {
            SET_HANDSHAKE_APPLICATION_PROTOCOL_SELECTOR.invoke(sSLEngine, Proxy.newProxyInstance(BouncyCastleAlpnSslUtils.class.getClassLoader(), new Class[]{BC_APPLICATION_PROTOCOL_SELECTOR}, new InvocationHandler() { // from class: io.netty.handler.ssl.BouncyCastleAlpnSslUtils.8
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (!method.getName().equals("select")) {
                        vp1.n(ha0.o("Method '", method.getName(), "' not supported."));
                        return null;
                    }
                    try {
                        return biFunction.apply((SSLEngine) objArr[0], (List) objArr[1]);
                    } catch (ClassCastException e) {
                        zo2.o("BCApplicationProtocolSelector select method parameter of invalid type.", e);
                        return null;
                    }
                }
            }));
        } catch (UnsupportedOperationException e) {
            throw e;
        } catch (Exception e2) {
            zo2.q(e2);
        }
    }
}
