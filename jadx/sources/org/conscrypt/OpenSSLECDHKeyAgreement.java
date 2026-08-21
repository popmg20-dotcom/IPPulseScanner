package org.conscrypt;

import defpackage.dw2;
import defpackage.xe;
import defpackage.zo2;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.conscrypt.NativeRef;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class OpenSSLECDHKeyAgreement extends KeyAgreementSpi {
    private int mExpectedResultLength;
    private OpenSSLKey mOpenSslPrivateKey;
    private byte[] mResult;

    private void checkCompleted() {
        if (this.mResult != null) {
            return;
        }
        xe.q("Key agreement not completed");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException {
        if (this.mOpenSslPrivateKey == null) {
            xe.q("Not initialized");
            return null;
        }
        if (!z) {
            xe.q("ECDH only has one phase");
            return null;
        }
        if (key == null) {
            zo2.u("key == null");
            return null;
        }
        if (!(key instanceof PublicKey)) {
            throw new InvalidKeyException("Not a public key: " + key.getClass());
        }
        OpenSSLKey openSSLKeyFromPublicKey = OpenSSLKey.fromPublicKey((PublicKey) key);
        byte[] bArr = new byte[this.mExpectedResultLength];
        int iECDH_compute_key = NativeCrypto.ECDH_compute_key(bArr, 0, openSSLKeyFromPublicKey.getNativeRef(), this.mOpenSslPrivateKey.getNativeRef());
        if (iECDH_compute_key == -1) {
            zo2.w(dw2.A(iECDH_compute_key, "Engine returned "));
            return null;
        }
        int i = this.mExpectedResultLength;
        if (iECDH_compute_key != i) {
            if (iECDH_compute_key >= i) {
                throw new RuntimeException("Engine produced a longer than expected result. Expected: " + this.mExpectedResultLength + ", actual: " + iECDH_compute_key);
            }
            byte[] bArr2 = this.mResult;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            bArr = new byte[iECDH_compute_key];
        }
        this.mResult = bArr;
        return null;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws ShortBufferWithoutStackTraceException {
        checkCompleted();
        int length = bArr.length - i;
        byte[] bArr2 = this.mResult;
        if (bArr2.length <= length) {
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            return this.mResult.length;
        }
        throw new ShortBufferWithoutStackTraceException("Needed: " + this.mResult.length + ", available: " + length);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key == null) {
            zo2.u("key == null");
            return;
        }
        if (key instanceof PrivateKey) {
            OpenSSLKey openSSLKeyFromPrivateKey = OpenSSLKey.fromPrivateKey((PrivateKey) key);
            this.mExpectedResultLength = (NativeCrypto.EC_GROUP_get_degree(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(openSSLKeyFromPrivateKey.getNativeRef()))) + 7) / 8;
            this.mOpenSslPrivateKey = openSSLKeyFromPrivateKey;
        } else {
            throw new InvalidKeyException("Not a private key: " + key.getClass());
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        checkCompleted();
        return this.mResult;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) {
        checkCompleted();
        return new SecretKeySpec(engineGenerateSecret(), str);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            engineInit(key, secureRandom);
            return;
        }
        throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
    }
}
