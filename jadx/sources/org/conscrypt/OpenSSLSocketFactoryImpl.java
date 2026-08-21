package org.conscrypt;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.KeyManagementException;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
final class OpenSSLSocketFactoryImpl extends SSLSocketFactory {
    private static boolean useEngineSocketByDefault = SSLUtils.USE_ENGINE_SOCKET_BY_DEFAULT;
    private final IOException instantiationException;
    private final SSLParametersImpl sslParameters;
    private boolean useEngineSocket;

    public OpenSSLSocketFactoryImpl() {
        IOException iOException;
        this.useEngineSocket = useEngineSocketByDefault;
        SSLParametersImpl sSLParametersImpl = null;
        try {
            iOException = null;
            sSLParametersImpl = SSLParametersImpl.getDefault();
        } catch (KeyManagementException e) {
            iOException = new IOException("Delayed instantiation exception:", e);
        }
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = iOException;
    }

    private boolean hasFileDescriptor(Socket socket) {
        try {
            Platform.getFileDescriptor(socket);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static void setUseEngineSocketByDefault(boolean z) {
        useEngineSocketByDefault = z;
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        if (socketFactory instanceof OpenSSLSocketFactoryImpl) {
            ((OpenSSLSocketFactoryImpl) socketFactory).setUseEngineSocket(z);
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws SocketException {
        Preconditions.checkNotNull(socket, "socket");
        if (socket.isConnected()) {
            return (this.useEngineSocket || !hasFileDescriptor(socket)) ? Platform.createEngineSocket(socket, str, i, z, (SSLParametersImpl) this.sslParameters.clone()) : Platform.createFileDescriptorSocket(socket, str, i, z, (SSLParametersImpl) this.sslParameters.clone());
        }
        throw new SocketException("Socket is not connected.");
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    public void setUseEngineSocket(boolean z) {
        this.useEngineSocket = z;
    }

    public OpenSSLSocketFactoryImpl(SSLParametersImpl sSLParametersImpl) {
        this.useEngineSocket = useEngineSocketByDefault;
        this.sslParameters = sSLParametersImpl;
        this.instantiationException = null;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        boolean z = this.useEngineSocket;
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (z) {
            return Platform.createEngineSocket(str, i, (SSLParametersImpl) sSLParametersImpl.clone());
        }
        return Platform.createFileDescriptorSocket(str, i, (SSLParametersImpl) sSLParametersImpl.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        boolean z = this.useEngineSocket;
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (z) {
            return Platform.createEngineSocket(str, i, inetAddress, i2, (SSLParametersImpl) sSLParametersImpl.clone());
        }
        return Platform.createFileDescriptorSocket(str, i, inetAddress, i2, (SSLParametersImpl) sSLParametersImpl.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        boolean z = this.useEngineSocket;
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (z) {
            return Platform.createEngineSocket(inetAddress, i, (SSLParametersImpl) sSLParametersImpl.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i, (SSLParametersImpl) sSLParametersImpl.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        boolean z = this.useEngineSocket;
        SSLParametersImpl sSLParametersImpl = this.sslParameters;
        if (z) {
            return Platform.createEngineSocket(inetAddress, i, inetAddress2, i2, (SSLParametersImpl) sSLParametersImpl.clone());
        }
        return Platform.createFileDescriptorSocket(inetAddress, i, inetAddress2, i2, (SSLParametersImpl) sSLParametersImpl.clone());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        IOException iOException = this.instantiationException;
        if (iOException == null) {
            boolean z = this.useEngineSocket;
            SSLParametersImpl sSLParametersImpl = this.sslParameters;
            if (z) {
                return Platform.createEngineSocket((SSLParametersImpl) sSLParametersImpl.clone());
            }
            return Platform.createFileDescriptorSocket((SSLParametersImpl) sSLParametersImpl.clone());
        }
        throw iOException;
    }
}
