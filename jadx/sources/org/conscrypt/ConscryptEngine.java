package org.conscrypt;

import defpackage.ha0;
import defpackage.vp1;
import defpackage.xe;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECKey;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import javax.crypto.SecretKey;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import org.conscrypt.ExternalSession;
import org.conscrypt.NativeCrypto;
import org.conscrypt.NativeRef;
import org.conscrypt.NativeSsl;
import org.conscrypt.SSLParametersImpl;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
final class ConscryptEngine extends AbstractConscryptEngine implements NativeCrypto.SSLHandshakeCallbacks, SSLParametersImpl.AliasChooser, SSLParametersImpl.PSKCallbacks {
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static BufferAllocator defaultBufferAllocator;
    private ActiveSession activeSession;
    private BufferAllocator bufferAllocator;
    private OpenSSLKey channelIdPrivateKey;
    private SessionSnapshot closedSession;
    private final SSLSession externalSession;
    private boolean handshakeFinished;
    private HandshakeListener handshakeListener;
    private ByteBuffer lazyDirectBuffer;
    private int maxSealOverhead;
    private final NativeSsl.BioWrapper networkBio;
    private String peerHostname;
    private final PeerInfoProvider peerInfoProvider;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private final NativeSsl ssl;
    private final SSLParametersImpl sslParameters;
    private int state;

    static {
        SSLEngineResult.Status status = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        NEED_UNWRAP_OK = new SSLEngineResult(status, handshakeStatus, 0, 0);
        SSLEngineResult.Status status2 = SSLEngineResult.Status.CLOSED;
        NEED_UNWRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus, 0, 0);
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        NEED_WRAP_OK = new SSLEngineResult(status, handshakeStatus2, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus2, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(status2, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        defaultBufferAllocator = null;
    }

    public ConscryptEngine(SSLParametersImpl sSLParametersImpl, PeerInfoProvider peerInfoProvider, SSLParametersImpl.AliasChooser aliasChooser) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = (PeerInfoProvider) Preconditions.checkNotNull(peerInfoProvider, "peerInfoProvider");
        NativeSsl nativeSslNewSsl = newSsl(sSLParametersImpl, this, aliasChooser);
        this.ssl = nativeSslNewSsl;
        this.networkBio = nativeSslNewSsl.newBio();
    }

    private void beginHandshakeInternal() throws SSLHandshakeException {
        NativeSslSession cachedSession;
        int i = this.state;
        if (i == 0) {
            xe.q("Client/server mode must be set before handshake");
            return;
        }
        if (i != 1) {
            if (i == 6 || i == 7 || i == 8) {
                throw new SSLHandshakeException("Engine has already been closed");
            }
            return;
        }
        transitionTo(2);
        try {
            try {
                this.ssl.initialize(getHostname(), this.channelIdPrivateKey);
                if (getUseClientMode() && (cachedSession = clientSessionContext().getCachedSession(getHostname(), getPeerPort(), this.sslParameters)) != null) {
                    cachedSession.offerToResume(this.ssl);
                }
                this.maxSealOverhead = this.ssl.getMaxSealOverhead();
                handshake();
            } catch (IOException e) {
                if (e.getMessage().contains("unexpected CCS")) {
                    Platform.logEvent("ssl_unexpected_ccs: host=" + getPeerHost());
                }
                closeAll();
                throw SSLUtils.toSSLHandshakeException(e);
            }
        } catch (Throwable th) {
            closeAndFreeResources();
            throw th;
        }
    }

    private static int calcDstsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        int iRemaining = 0;
        for (int i3 = 0; i3 < byteBufferArr.length; i3++) {
            ByteBuffer byteBuffer = byteBufferArr[i3];
            Preconditions.checkArgument(byteBuffer != null, "dsts[%d] is null", Integer.valueOf(i3));
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            if (i3 >= i && i3 < i + i2) {
                iRemaining += byteBuffer.remaining();
            }
        }
        return iRemaining;
    }

    private static long calcSrcsLength(ByteBuffer[] byteBufferArr, int i, int i2) {
        long jRemaining = 0;
        while (i < i2) {
            ByteBuffer byteBuffer = byteBufferArr[i];
            if (byteBuffer == null) {
                xe.k(ha0.k("srcs[", i, "] is null"));
                return 0L;
            }
            jRemaining += (long) byteBuffer.remaining();
            i++;
        }
        return jRemaining;
    }

    private ClientSessionContext clientSessionContext() {
        return this.sslParameters.getClientSessionContext();
    }

    private void closeAll() {
        closeOutbound();
        closeInbound();
    }

    private void closeAndFreeResources() {
        transitionTo(8);
        NativeSsl nativeSsl = this.ssl;
        if (nativeSsl != null) {
            nativeSsl.close();
        }
        NativeSsl.BioWrapper bioWrapper = this.networkBio;
        if (bioWrapper != null) {
            bioWrapper.close();
        }
    }

    private SSLException convertException(Throwable th) {
        return ((th instanceof SSLHandshakeException) || !this.handshakeFinished) ? SSLUtils.toSSLHandshakeException(th) : SSLUtils.toSSLException(th);
    }

    private long directByteBufferAddress(ByteBuffer byteBuffer, int i) {
        return NativeCrypto.getDirectBufferAddress(byteBuffer) + ((long) i);
    }

    private void finishHandshake() {
        this.handshakeFinished = true;
        HandshakeListener handshakeListener = this.handshakeListener;
        if (handshakeListener != null) {
            handshakeListener.onHandshakeFinished();
        }
    }

    private void freeIfDone() {
        if (isInboundDone() && isOutboundDone()) {
            closeAndFreeResources();
        }
    }

    public static BufferAllocator getDefaultBufferAllocator() {
        return defaultBufferAllocator;
    }

    private SSLEngineResult.Status getEngineStatus() {
        int i = this.state;
        return (i == 6 || i == 7 || i == 8) ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatusInternal() {
        if (this.handshakeFinished) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        switch (this.state) {
            case 0:
            case 1:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            case 2:
                return pendingStatus(pendingOutboundEncryptedBytes());
            case 3:
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            default:
                xe.d(this.state, "Unexpected engine state: ");
                return null;
        }
    }

    private ByteBuffer getOrCreateLazyDirectBuffer() {
        ByteBuffer byteBufferAllocateDirect = this.lazyDirectBuffer;
        if (byteBufferAllocateDirect == null) {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(Math.max(16384, 16709));
            this.lazyDirectBuffer = byteBufferAllocateDirect;
        }
        byteBufferAllocateDirect.clear();
        return this.lazyDirectBuffer;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLHandshakeException {
        try {
            try {
                int iDoHandshake = this.ssl.doHandshake();
                if (iDoHandshake == 2) {
                    return pendingStatus(pendingOutboundEncryptedBytes());
                }
                if (iDoHandshake == 3) {
                    return SSLEngineResult.HandshakeStatus.NEED_WRAP;
                }
                this.activeSession.onPeerCertificateAvailable(getPeerHost(), getPeerPort());
                finishHandshake();
                return SSLEngineResult.HandshakeStatus.FINISHED;
            } catch (IOException e) {
                closeAll();
                throw e;
            }
        } catch (Exception e2) {
            throw SSLUtils.toSSLHandshakeException(e2);
        }
    }

    private boolean isHandshakeStarted() {
        int i = this.state;
        return (i == 0 || i == 1) ? false : true;
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) {
        return (this.handshakeFinished || handshakeStatus != SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) ? handshakeStatus : handshake();
    }

    private SSLEngineResult newResult(int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) {
        SSLEngineResult.Status engineStatus = getEngineStatus();
        if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
            handshakeStatus = getHandshakeStatusInternal();
        }
        return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
    }

    private static NativeSsl newSsl(SSLParametersImpl sSLParametersImpl, ConscryptEngine conscryptEngine, SSLParametersImpl.AliasChooser aliasChooser) {
        try {
            return NativeSsl.newInstance(sSLParametersImpl, conscryptEngine, aliasChooser, conscryptEngine);
        } catch (SSLException e) {
            vp1.p(e);
            return null;
        }
    }

    private SSLException newSslExceptionWithMessage(String str) {
        return !this.handshakeFinished ? new SSLException(str) : new SSLHandshakeException(str);
    }

    private int pendingInboundCleartextBytes() {
        return this.ssl.getPendingReadableBytes();
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i) {
        return i > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private ConscryptSession provideAfterHandshakeSession() {
        return this.state < 2 ? SSLNullSession.getNullSession() : provideSession();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideHandshakeSession() {
        ConscryptSession nullSession;
        synchronized (this.ssl) {
            try {
                nullSession = this.state == 2 ? this.activeSession : SSLNullSession.getNullSession();
            } catch (Throwable th) {
                throw th;
            }
        }
        return nullSession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConscryptSession provideSession() {
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i == 8) {
                    ConscryptSession nullSession = this.closedSession;
                    if (nullSession == null) {
                        nullSession = SSLNullSession.getNullSession();
                    }
                    return nullSession;
                }
                if (i < 3) {
                    return SSLNullSession.getNullSession();
                }
                return this.activeSession;
            } finally {
            }
        }
    }

    private int readEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            if (byteBuffer.remaining() < i) {
                return 0;
            }
            int iMin = Math.min(i, byteBuffer.limit() - iPosition);
            if (!byteBuffer.isDirect()) {
                return readEncryptedDataHeap(byteBuffer, iMin);
            }
            int encryptedDataDirect = readEncryptedDataDirect(byteBuffer, iPosition, iMin);
            if (encryptedDataDirect <= 0) {
                return encryptedDataDirect;
            }
            byteBuffer.position(iPosition + encryptedDataDirect);
            return encryptedDataDirect;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.networkBio.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readEncryptedDataHeap(ByteBuffer byteBuffer, int i) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int encryptedDataDirect = readEncryptedDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i, orCreateLazyDirectBuffer.remaining()));
            if (encryptedDataDirect > 0) {
                orCreateLazyDirectBuffer.position(encryptedDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return encryptedDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    private SSLEngineResult readPendingBytesFromBIO(ByteBuffer byteBuffer, int i, int i2, SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        try {
            int iPendingOutboundEncryptedBytes = pendingOutboundEncryptedBytes();
            if (iPendingOutboundEncryptedBytes <= 0) {
                return null;
            }
            if (byteBuffer.remaining() < iPendingOutboundEncryptedBytes) {
                SSLEngineResult.Status status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                    handshakeStatus = getHandshakeStatus(iPendingOutboundEncryptedBytes);
                }
                return new SSLEngineResult(status, mayFinishHandshake(handshakeStatus), i, i2);
            }
            int encryptedData = readEncryptedData(byteBuffer, iPendingOutboundEncryptedBytes);
            if (encryptedData <= 0) {
                NativeCrypto.SSL_clear_error();
            } else {
                i2 += encryptedData;
                iPendingOutboundEncryptedBytes -= encryptedData;
            }
            SSLEngineResult.Status engineStatus = getEngineStatus();
            if (handshakeStatus != SSLEngineResult.HandshakeStatus.FINISHED) {
                handshakeStatus = getHandshakeStatus(iPendingOutboundEncryptedBytes);
            }
            return new SSLEngineResult(engineStatus, mayFinishHandshake(handshakeStatus), i, i2);
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            int iMin = Math.min(16709, byteBuffer.limit() - iPosition);
            if (!byteBuffer.isDirect()) {
                return readPlaintextDataHeap(byteBuffer, iMin);
            }
            int plaintextDataDirect = readPlaintextDataDirect(byteBuffer, iPosition, iMin);
            if (plaintextDataDirect <= 0) {
                return plaintextDataDirect;
            }
            byteBuffer.position(iPosition + plaintextDataDirect);
            return plaintextDataDirect;
        } catch (CertificateException e) {
            throw convertException(e);
        }
    }

    private int readPlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.ssl.readDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int readPlaintextDataHeap(ByteBuffer byteBuffer, int i) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int plaintextDataDirect = readPlaintextDataDirect(orCreateLazyDirectBuffer, 0, Math.min(i, orCreateLazyDirectBuffer.remaining()));
            if (plaintextDataDirect > 0) {
                orCreateLazyDirectBuffer.position(plaintextDataDirect);
                orCreateLazyDirectBuffer.flip();
                byteBuffer.put(orCreateLazyDirectBuffer);
            }
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return plaintextDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    private void sendSSLShutdown() {
        try {
            this.ssl.shutdown();
        } catch (IOException unused) {
        }
    }

    private AbstractSessionContext sessionContext() {
        return this.sslParameters.getSessionContext();
    }

    public static void setDefaultBufferAllocator(BufferAllocator bufferAllocator) {
        defaultBufferAllocator = bufferAllocator;
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private void transitionTo(int i) {
        int i2;
        if (i == 2) {
            this.handshakeFinished = false;
            this.activeSession = new ActiveSession(this.ssl, this.sslParameters.getSessionContext());
        } else if (i == 8 && !this.ssl.isClosed() && (i2 = this.state) >= 2 && i2 < 8) {
            this.closedSession = new SessionSnapshot(this.activeSession);
        }
        this.state = i;
    }

    private int writeEncryptedData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            int iWriteEncryptedDataDirect = byteBuffer.isDirect() ? writeEncryptedDataDirect(byteBuffer, iPosition, i) : writeEncryptedDataHeap(byteBuffer, iPosition, i);
            if (iWriteEncryptedDataDirect > 0) {
                byteBuffer.position(iPosition + iWriteEncryptedDataDirect);
            }
            return iWriteEncryptedDataDirect;
        } catch (IOException e) {
            closeAll();
            throw new SSLException(e);
        }
    }

    private int writeEncryptedDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.networkBio.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writeEncryptedDataHeap(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int iLimit = byteBuffer.limit();
            int iMin = Math.min(Math.min(iLimit - i, i2), orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i + iMin);
            orCreateLazyDirectBuffer.put(byteBuffer);
            byteBuffer.limit(iLimit);
            byteBuffer.position(i);
            int iWriteEncryptedDataDirect = writeEncryptedDataDirect(orCreateLazyDirectBuffer, 0, iMin);
            byteBuffer.position(i);
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return iWriteEncryptedDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i) throws SSLException {
        try {
            int iPosition = byteBuffer.position();
            int iWritePlaintextDataDirect = byteBuffer.isDirect() ? writePlaintextDataDirect(byteBuffer, iPosition, i) : writePlaintextDataHeap(byteBuffer, iPosition, i);
            if (iWritePlaintextDataDirect > 0) {
                byteBuffer.position(iPosition + iWritePlaintextDataDirect);
            }
            return iWritePlaintextDataDirect;
        } catch (Exception e) {
            throw convertException(e);
        }
    }

    private int writePlaintextDataDirect(ByteBuffer byteBuffer, int i, int i2) {
        return this.ssl.writeDirectByteBuffer(directByteBufferAddress(byteBuffer, i), i2);
    }

    private int writePlaintextDataHeap(ByteBuffer byteBuffer, int i, int i2) {
        ByteBuffer orCreateLazyDirectBuffer;
        AllocatedBuffer allocatedBufferAllocateDirectBuffer = null;
        try {
            BufferAllocator bufferAllocator = this.bufferAllocator;
            if (bufferAllocator != null) {
                allocatedBufferAllocateDirectBuffer = bufferAllocator.allocateDirectBuffer(i2);
                orCreateLazyDirectBuffer = allocatedBufferAllocateDirectBuffer.nioBuffer();
            } else {
                orCreateLazyDirectBuffer = getOrCreateLazyDirectBuffer();
            }
            int iLimit = byteBuffer.limit();
            int iMin = Math.min(i2, orCreateLazyDirectBuffer.remaining());
            byteBuffer.limit(i + iMin);
            orCreateLazyDirectBuffer.put(byteBuffer);
            orCreateLazyDirectBuffer.flip();
            byteBuffer.limit(iLimit);
            byteBuffer.position(i);
            int iWritePlaintextDataDirect = writePlaintextDataDirect(orCreateLazyDirectBuffer, 0, iMin);
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            return iWritePlaintextDataDirect;
        } catch (Throwable th) {
            if (allocatedBufferAllocateDirectBuffer != null) {
                allocatedBufferAllocateDirectBuffer.release();
            }
            throw th;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() {
        synchronized (this.ssl) {
            beginHandshakeInternal();
        }
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseClientAlias(X509KeyManager x509KeyManager, X500Principal[] x500PrincipalArr, String[] strArr) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, x500PrincipalArr, this) : x509KeyManager.chooseClientAlias(strArr, x500PrincipalArr, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseClientPSKIdentity(PSKKeyManager pSKKeyManager, String str) {
        return pSKKeyManager.chooseClientKeyIdentity(str, this);
    }

    @Override // org.conscrypt.SSLParametersImpl.AliasChooser
    public String chooseServerAlias(X509KeyManager x509KeyManager, String str) {
        return x509KeyManager instanceof X509ExtendedKeyManager ? ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, null, this) : x509KeyManager.chooseServerAlias(str, null, null);
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public String chooseServerPSKIdentityHint(PSKKeyManager pSKKeyManager) {
        return pSKKeyManager.chooseServerKeyIdentityHint(this);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void clientCertificateRequested(byte[] bArr, int[] iArr, byte[][] bArr2) {
        this.ssl.chooseClientCertificate(bArr, iArr, bArr2);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int clientPSKKeyRequested(String str, byte[] bArr, byte[] bArr2) {
        return this.ssl.clientPSKKeyRequested(str, bArr, bArr2);
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() {
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i != 8 && i != 6) {
                    if (isHandshakeStarted()) {
                        if (this.state == 7) {
                            transitionTo(8);
                        } else {
                            transitionTo(6);
                        }
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            } finally {
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        synchronized (this.ssl) {
            try {
                int i = this.state;
                if (i != 8 && i != 7) {
                    if (isHandshakeStarted()) {
                        if (this.state == 6) {
                            transitionTo(8);
                        } else {
                            transitionTo(7);
                        }
                        sendSSLShutdown();
                        freeIfDone();
                    } else {
                        closeAndFreeResources();
                    }
                }
            } finally {
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] exportKeyingMaterial(String str, byte[] bArr, int i) {
        synchronized (this.ssl) {
            int i2 = this.state;
            if (i2 >= 3 && i2 != 8) {
                return this.ssl.exportKeyingMaterial(str, bArr, i);
            }
            return null;
        }
    }

    public void finalize() throws Throwable {
        try {
            closeAndFreeResources();
        } finally {
            super.finalize();
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return provideAfterHandshakeSession().getApplicationProtocol();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String[] getApplicationProtocols() {
        return this.sslParameters.getApplicationProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getChannelId() {
        byte[] tlsChannelId;
        synchronized (this.ssl) {
            try {
                if (getUseClientMode()) {
                    throw new IllegalStateException("Not allowed in client mode");
                }
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Channel ID is only available after handshake completes");
                }
                tlsChannelId = this.ssl.getTlsChannelId();
            } catch (Throwable th) {
                throw th;
            }
        }
        return tlsChannelId;
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.sslParameters.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.sslParameters.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.sslParameters.getEnabledProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        String applicationProtocol;
        synchronized (this.ssl) {
            try {
                applicationProtocol = this.state >= 2 ? getApplicationProtocol() : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus handshakeStatusInternal;
        synchronized (this.ssl) {
            handshakeStatusInternal = getHandshakeStatusInternal();
        }
        return handshakeStatusInternal;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public String getHostname() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostname();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.sslParameters.getNeedClientAuth();
    }

    @Override // org.conscrypt.SSLParametersImpl.PSKCallbacks
    public SecretKey getPSKKey(PSKKeyManager pSKKeyManager, String str, String str2) {
        return pSKKeyManager.getKey(str, str2, this);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public String getPeerHost() {
        String str = this.peerHostname;
        return str != null ? str : this.peerInfoProvider.getHostnameOrIP();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.peerInfoProvider.getPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        SSLParameters sSLParameters = super.getSSLParameters();
        Platform.getSSLParameters(sSLParameters, this.sslParameters, this);
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.externalSession;
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return NativeCrypto.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return NativeCrypto.getSupportedProtocols();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public byte[] getTlsUnique() {
        return this.ssl.getTlsUnique();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.sslParameters.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.sslParameters.getWantClientAuth();
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLSession handshakeSession() {
        synchronized (this.ssl) {
            try {
                if (this.state != 2) {
                    return null;
                }
                return Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.2
                    @Override // org.conscrypt.ExternalSession.Provider
                    public ConscryptSession provideSession() {
                        return ConscryptEngine.this.provideHandshakeSession();
                    }
                }));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isInboundDone() {
        /*
            r3 = this;
            org.conscrypt.NativeSsl r0 = r3.ssl
            monitor-enter(r0)
            int r1 = r3.state     // Catch: java.lang.Throwable -> L15
            r2 = 8
            if (r1 == r2) goto L17
            r2 = 6
            if (r1 == r2) goto L17
            org.conscrypt.NativeSsl r1 = r3.ssl     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.wasShutdownReceived()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L1f
            goto L17
        L15:
            r3 = move-exception
            goto L22
        L17:
            int r3 = r3.pendingInboundCleartextBytes()     // Catch: java.lang.Throwable -> L15
            if (r3 != 0) goto L1f
            r3 = 1
            goto L20
        L1f:
            r3 = 0
        L20:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r3
        L22:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngine.isInboundDone():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean isOutboundDone() {
        /*
            r3 = this;
            org.conscrypt.NativeSsl r0 = r3.ssl
            monitor-enter(r0)
            int r1 = r3.state     // Catch: java.lang.Throwable -> L15
            r2 = 8
            if (r1 == r2) goto L17
            r2 = 7
            if (r1 == r2) goto L17
            org.conscrypt.NativeSsl r1 = r3.ssl     // Catch: java.lang.Throwable -> L15
            boolean r1 = r1.wasShutdownSent()     // Catch: java.lang.Throwable -> L15
            if (r1 == 0) goto L1f
            goto L17
        L15:
            r3 = move-exception
            goto L22
        L17:
            int r3 = r3.pendingOutboundEncryptedBytes()     // Catch: java.lang.Throwable -> L15
            if (r3 != 0) goto L1f
            r3 = 1
            goto L20
        L1f:
            r3 = 0
        L20:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            return r3
        L22:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L15
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngine.isOutboundDone():boolean");
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public int maxSealOverhead() {
        return this.maxSealOverhead;
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onNewSessionEstablished(long j) {
        try {
            NativeCrypto.SSL_SESSION_up_ref(j);
            sessionContext().cacheSession(NativeSslSession.newInstance(new NativeRef.SSL_SESSION(j), this.activeSession));
        } catch (Exception unused) {
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void onSSLStateChange(int i, int i2) {
        synchronized (this.ssl) {
            try {
                if (i == 16) {
                    transitionTo(2);
                } else if (i == 32) {
                    int i3 = this.state;
                    if (i3 != 2 && i3 != 4) {
                        throw new IllegalStateException("Completed handshake while in mode " + this.state);
                    }
                    transitionTo(3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int pendingOutboundEncryptedBytes() {
        return this.networkBio.getPendingWrittenBytes();
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int selectApplicationProtocol(byte[] bArr) {
        ApplicationProtocolSelectorAdapter applicationProtocolSelector = this.sslParameters.getApplicationProtocolSelector();
        if (applicationProtocolSelector == null) {
            return 3;
        }
        return applicationProtocolSelector.selectApplicationProtocol(bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void serverCertificateRequested() {
        synchronized (this.ssl) {
            this.ssl.configureServerCertificate();
        }
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public int serverPSKKeyRequested(String str, String str2, byte[] bArr) {
        return this.ssl.serverPSKKeyRequested(str, str2, bArr);
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public long serverSessionRequested(byte[] bArr) {
        return 0L;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocolSelector(ApplicationProtocolSelector applicationProtocolSelector) {
        setApplicationProtocolSelector(applicationProtocolSelector == null ? null : new ApplicationProtocolSelectorAdapter(this, applicationProtocolSelector));
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setApplicationProtocols(String[] strArr) {
        this.sslParameters.setApplicationProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setBufferAllocator(BufferAllocator bufferAllocator) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not set buffer allocator after the initial handshake has begun.");
                }
                this.bufferAllocator = bufferAllocator;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdEnabled(boolean z) {
        synchronized (this.ssl) {
            try {
                if (getUseClientMode()) {
                    throw new IllegalStateException("Not allowed in client mode");
                }
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not enable/disable Channel ID after the initial handshake has begun.");
                }
                this.sslParameters.channelIdEnabled = z;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setChannelIdPrivateKey(PrivateKey privateKey) {
        if (!getUseClientMode()) {
            xe.q("Not allowed in server mode");
            return;
        }
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Could not change Channel ID private key after the initial handshake has begun.");
                }
                SSLParametersImpl sSLParametersImpl = this.sslParameters;
                if (privateKey == null) {
                    sSLParametersImpl.channelIdEnabled = false;
                    this.channelIdPrivateKey = null;
                    return;
                }
                sSLParametersImpl.channelIdEnabled = true;
                try {
                    ECParameterSpec params = privateKey instanceof ECKey ? ((ECKey) privateKey).getParams() : null;
                    if (params == null) {
                        params = OpenSSLECGroupContext.getCurveByName("prime256v1").getECParameterSpec();
                    }
                    this.channelIdPrivateKey = OpenSSLKey.fromECPrivateKeyForTLSStackOnly(privateKey, params);
                } catch (InvalidKeyException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z) {
        this.sslParameters.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.sslParameters.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.sslParameters.setEnabledProtocols(strArr);
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHandshakeListener(HandshakeListener handshakeListener) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalStateException("Handshake listener must be set before starting the handshake.");
                }
                this.handshakeListener = handshakeListener;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setHostname(String str) {
        this.sslParameters.setUseSni(str != null);
        this.peerHostname = str;
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z) {
        this.sslParameters.setNeedClientAuth(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        super.setSSLParameters(sSLParameters);
        Platform.setSSLParameters(sSLParameters, this.sslParameters, this);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z) {
        synchronized (this.ssl) {
            try {
                if (isHandshakeStarted()) {
                    throw new IllegalArgumentException("Can not change mode after handshake: state == " + this.state);
                }
                transitionTo(1);
                this.sslParameters.setUseClientMode(z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public void setUseSessionTickets(boolean z) {
        this.sslParameters.setUseSessionTickets(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z) {
        this.sslParameters.setWantClientAuth(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0145 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, IOException -> 0x0106, blocks: (B:12:0x002c, B:26:0x0050, B:28:0x0056, B:30:0x005e, B:31:0x0060, B:33:0x0062, B:35:0x0066, B:36:0x0068, B:38:0x006a, B:47:0x0080, B:48:0x008b, B:50:0x008d, B:52:0x0093, B:54:0x0098, B:55:0x00a3, B:67:0x00c2, B:69:0x00ca, B:85:0x00ec, B:93:0x0103, B:88:0x00f5, B:90:0x00fb, B:104:0x0114, B:105:0x011d, B:106:0x011e, B:107:0x0122, B:109:0x0124, B:111:0x0131, B:113:0x0136, B:114:0x0139, B:112:0x0134, B:118:0x0141, B:120:0x0145, B:122:0x014b, B:126:0x0158, B:127:0x015f, B:125:0x0154, B:129:0x0161, B:130:0x0165, B:132:0x0167, B:133:0x016e, B:116:0x013b, B:134:0x016f, B:135:0x0173, B:70:0x00cd, B:72:0x00d7, B:79:0x00e2, B:57:0x00a5, B:58:0x00ac, B:60:0x00af, B:61:0x00ba, B:20:0x003a, B:21:0x0048, B:25:0x004d, B:137:0x0175, B:138:0x017c), top: B:146:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x014b A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, IOException -> 0x0106, blocks: (B:12:0x002c, B:26:0x0050, B:28:0x0056, B:30:0x005e, B:31:0x0060, B:33:0x0062, B:35:0x0066, B:36:0x0068, B:38:0x006a, B:47:0x0080, B:48:0x008b, B:50:0x008d, B:52:0x0093, B:54:0x0098, B:55:0x00a3, B:67:0x00c2, B:69:0x00ca, B:85:0x00ec, B:93:0x0103, B:88:0x00f5, B:90:0x00fb, B:104:0x0114, B:105:0x011d, B:106:0x011e, B:107:0x0122, B:109:0x0124, B:111:0x0131, B:113:0x0136, B:114:0x0139, B:112:0x0134, B:118:0x0141, B:120:0x0145, B:122:0x014b, B:126:0x0158, B:127:0x015f, B:125:0x0154, B:129:0x0161, B:130:0x0165, B:132:0x0167, B:133:0x016e, B:116:0x013b, B:134:0x016f, B:135:0x0173, B:70:0x00cd, B:72:0x00d7, B:79:0x00e2, B:57:0x00a5, B:58:0x00ac, B:60:0x00af, B:61:0x00ba, B:20:0x003a, B:21:0x0048, B:25:0x004d, B:137:0x0175, B:138:0x017c), top: B:146:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0161 A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, IOException -> 0x0106, blocks: (B:12:0x002c, B:26:0x0050, B:28:0x0056, B:30:0x005e, B:31:0x0060, B:33:0x0062, B:35:0x0066, B:36:0x0068, B:38:0x006a, B:47:0x0080, B:48:0x008b, B:50:0x008d, B:52:0x0093, B:54:0x0098, B:55:0x00a3, B:67:0x00c2, B:69:0x00ca, B:85:0x00ec, B:93:0x0103, B:88:0x00f5, B:90:0x00fb, B:104:0x0114, B:105:0x011d, B:106:0x011e, B:107:0x0122, B:109:0x0124, B:111:0x0131, B:113:0x0136, B:114:0x0139, B:112:0x0134, B:118:0x0141, B:120:0x0145, B:122:0x014b, B:126:0x0158, B:127:0x015f, B:125:0x0154, B:129:0x0161, B:130:0x0165, B:132:0x0167, B:133:0x016e, B:116:0x013b, B:134:0x016f, B:135:0x0173, B:70:0x00cd, B:72:0x00d7, B:79:0x00e2, B:57:0x00a5, B:58:0x00ac, B:60:0x00af, B:61:0x00ba, B:20:0x003a, B:21:0x0048, B:25:0x004d, B:137:0x0175, B:138:0x017c), top: B:146:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[LOOP:0: B:67:0x00c2->B:150:?, LOOP_END, SYNTHETIC] */
    @Override // org.conscrypt.AbstractConscryptEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public javax.net.ssl.SSLEngineResult unwrap(java.nio.ByteBuffer[] r10, int r11, int r12, java.nio.ByteBuffer[] r13, int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.conscrypt.ConscryptEngine.unwrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer[], int, int):javax.net.ssl.SSLEngineResult");
    }

    @Override // org.conscrypt.NativeCrypto.SSLHandshakeCallbacks
    public void verifyCertificateChain(byte[][] bArr, String str) throws CertificateException {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    X509Certificate[] x509CertificateArrDecodeX509CertificateChain = SSLUtils.decodeX509CertificateChain(bArr);
                    X509TrustManager x509TrustManager = this.sslParameters.getX509TrustManager();
                    if (x509TrustManager == null) {
                        throw new CertificateException("No X.509 TrustManager");
                    }
                    this.activeSession.onPeerCertificatesReceived(getPeerHost(), getPeerPort(), x509CertificateArrDecodeX509CertificateChain);
                    if (getUseClientMode()) {
                        Platform.checkServerTrusted(x509TrustManager, x509CertificateArrDecodeX509CertificateChain, str, this);
                        return;
                    } else {
                        Platform.checkClientTrusted(x509TrustManager, x509CertificateArrDecodeX509CertificateChain, x509CertificateArrDecodeX509CertificateChain[0].getPublicKey().getAlgorithm(), this);
                        return;
                    }
                }
            } catch (CertificateException e) {
                throw e;
            } catch (Exception e2) {
                throw new CertificateException(e2);
            }
        }
        throw new CertificateException("Peer sent no certificate");
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i, int i2, ByteBuffer byteBuffer) {
        int iBytesProduced;
        int iWritePlaintextData;
        SSLEngineResult pendingBytesFromBIO;
        boolean z = true;
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBuffer != null, "dst is null");
        int i3 = i + i2;
        Preconditions.checkPositionIndexes(i, i3, byteBufferArr.length);
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        if (i != 0 || i2 != byteBufferArr.length) {
            byteBufferArr = (ByteBuffer[]) Arrays.copyOfRange(byteBufferArr, i, i3);
        }
        BufferUtils.checkNotNull(byteBufferArr);
        synchronized (this.ssl) {
            try {
                int i4 = this.state;
                if (i4 == 0) {
                    throw new IllegalStateException("Client/server mode must be set before calling wrap");
                }
                if (i4 == 1) {
                    beginHandshakeInternal();
                } else if (i4 == 7 || i4 == 8) {
                    SSLEngineResult pendingBytesFromBIO2 = readPendingBytesFromBIO(byteBuffer, 0, 0, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING);
                    if (pendingBytesFromBIO2 == null) {
                        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, getHandshakeStatusInternal(), 0, 0);
                    }
                    freeIfDone();
                    return pendingBytesFromBIO2;
                }
                SSLEngineResult.HandshakeStatus handshakeStatusHandshake = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                if (!this.handshakeFinished) {
                    handshakeStatusHandshake = handshake();
                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                        return NEED_UNWRAP_OK;
                    }
                    if (this.state == 8) {
                        return NEED_UNWRAP_CLOSED;
                    }
                }
                int iMin = (int) Math.min(BufferUtils.remaining(byteBufferArr), DefaultHttpDataFactory.MINSIZE);
                if (byteBuffer.remaining() < SSLUtils.calculateOutNetBufSize(iMin)) {
                    return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatusInternal(), 0, 0);
                }
                if (iMin > 0) {
                    ByteBuffer bufferLargerThan = BufferUtils.getBufferLargerThan(byteBufferArr, 16384);
                    if (bufferLargerThan == null) {
                        bufferLargerThan = BufferUtils.copyNoConsume(byteBufferArr, getOrCreateLazyDirectBuffer(), 16384);
                    } else {
                        z = false;
                    }
                    iWritePlaintextData = writePlaintextData(bufferLargerThan, Math.min(16384, bufferLargerThan.remaining()));
                    if (iWritePlaintextData <= 0) {
                        int error = this.ssl.getError(iWritePlaintextData);
                        if (error == 2) {
                            SSLEngineResult pendingBytesFromBIO3 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatusHandshake);
                            if (pendingBytesFromBIO3 == null) {
                                pendingBytesFromBIO3 = new SSLEngineResult(getEngineStatus(), SSLEngineResult.HandshakeStatus.NEED_UNWRAP, 0, 0);
                            }
                            return pendingBytesFromBIO3;
                        }
                        if (error == 3) {
                            SSLEngineResult pendingBytesFromBIO4 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatusHandshake);
                            if (pendingBytesFromBIO4 == null) {
                                pendingBytesFromBIO4 = NEED_WRAP_CLOSED;
                            }
                            return pendingBytesFromBIO4;
                        }
                        if (error != 6) {
                            closeAll();
                            throw newSslExceptionWithMessage("SSL_write: error " + error);
                        }
                        closeAll();
                        SSLEngineResult pendingBytesFromBIO5 = readPendingBytesFromBIO(byteBuffer, 0, 0, handshakeStatusHandshake);
                        if (pendingBytesFromBIO5 == null) {
                            pendingBytesFromBIO5 = CLOSED_NOT_HANDSHAKING;
                        }
                        return pendingBytesFromBIO5;
                    }
                    if (z) {
                        BufferUtils.consume(byteBufferArr, iWritePlaintextData);
                    }
                    SSLEngineResult pendingBytesFromBIO6 = readPendingBytesFromBIO(byteBuffer, iWritePlaintextData, 0, handshakeStatusHandshake);
                    if (pendingBytesFromBIO6 == null) {
                        iBytesProduced = 0;
                    } else {
                        if (pendingBytesFromBIO6.getStatus() != SSLEngineResult.Status.OK) {
                            return pendingBytesFromBIO6;
                        }
                        iBytesProduced = pendingBytesFromBIO6.bytesProduced();
                    }
                } else {
                    iBytesProduced = 0;
                    iWritePlaintextData = 0;
                }
                return (iWritePlaintextData != 0 || (pendingBytesFromBIO = readPendingBytesFromBIO(byteBuffer, 0, iBytesProduced, handshakeStatusHandshake)) == null) ? newResult(iWritePlaintextData, iBytesProduced, handshakeStatusHandshake) : pendingBytesFromBIO;
            } finally {
            }
        }
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i) {
        return !this.handshakeFinished ? pendingStatus(i) : SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    public void setApplicationProtocolSelector(ApplicationProtocolSelectorAdapter applicationProtocolSelectorAdapter) {
        this.sslParameters.setApplicationProtocolSelector(applicationProtocolSelectorAdapter);
    }

    public ConscryptEngine(String str, int i, SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.forHostAndPort(str, i);
        NativeSsl nativeSslNewSsl = newSsl(sSLParametersImpl, this, this);
        this.ssl = nativeSslNewSsl;
        this.networkBio = nativeSslNewSsl.newBio();
    }

    public ConscryptEngine(SSLParametersImpl sSLParametersImpl) {
        this.bufferAllocator = defaultBufferAllocator;
        this.state = 0;
        this.externalSession = Platform.wrapSSLSession(new ExternalSession(new ExternalSession.Provider() { // from class: org.conscrypt.ConscryptEngine.1
            @Override // org.conscrypt.ExternalSession.Provider
            public ConscryptSession provideSession() {
                return ConscryptEngine.this.provideSession();
            }
        }));
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        this.sslParameters = sSLParametersImpl;
        this.peerInfoProvider = PeerInfoProvider.nullProvider();
        NativeSsl nativeSslNewSsl = newSsl(sSLParametersImpl, this, this);
        this.ssl = nativeSslNewSsl;
        this.networkBio = nativeSslNewSsl.newBio();
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        SSLEngineResult sSLEngineResultWrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultWrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultWrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
        SSLEngineResult sSLEngineResultUnwrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
                } finally {
                    resetSingleSrcBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultUnwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) {
        ConscryptEngine conscryptEngine;
        SSLEngineResult sSLEngineResultUnwrap;
        synchronized (this.ssl) {
            try {
                try {
                    conscryptEngine = this;
                    try {
                        sSLEngineResultUnwrap = conscryptEngine.unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i, i2);
                        conscryptEngine.resetSingleSrcBuffer();
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        conscryptEngine.resetSingleSrcBuffer();
                        throw th2;
                    }
                } finally {
                }
            } catch (Throwable th3) {
                th = th3;
                conscryptEngine = this;
            }
        }
        return sSLEngineResultUnwrap;
    }

    @Override // org.conscrypt.AbstractConscryptEngine
    public SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) {
        Preconditions.checkArgument(byteBufferArr != null, "srcs is null");
        Preconditions.checkArgument(byteBufferArr2 != null, "dsts is null");
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // org.conscrypt.AbstractConscryptEngine, javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        SSLEngineResult sSLEngineResultUnwrap;
        synchronized (this.ssl) {
            try {
                try {
                    sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
                } finally {
                    resetSingleSrcBuffer();
                    resetSingleDstBuffer();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sSLEngineResultUnwrap;
    }
}
