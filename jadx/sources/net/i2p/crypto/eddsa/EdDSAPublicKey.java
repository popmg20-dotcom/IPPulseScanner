package net.i2p.crypto.eddsa;

import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSAPublicKey implements EdDSAKey, PublicKey {
    public final EdDSAParameterSpec A;
    public final GroupElement b;
    public GroupElement f;
    public final byte[] z;

    /* JADX WARN: Illegal instructions before constructor call */
    public EdDSAPublicKey(X509EncodedKeySpec x509EncodedKeySpec) throws InvalidKeySpecException {
        int i;
        byte[] encoded = x509EncodedKeySpec.getEncoded();
        byte b = 8;
        try {
            byte b2 = encoded[8];
            if (b2 == 100) {
                i = 47;
            } else {
                if (b2 != 112) {
                    throw new InvalidKeySpecException("unsupported key spec");
                }
                if (encoded[3] == 7) {
                    i = 46;
                    b = 7;
                } else {
                    i = 44;
                    b = 5;
                }
            }
            if (encoded.length != i) {
                throw new InvalidKeySpecException("invalid key spec length");
            }
            if (encoded[0] != 48 || encoded[1] != i - 2 || encoded[2] != 48 || encoded[3] != b || encoded[4] != 6 || encoded[5] != 3 || encoded[6] != 43 || encoded[7] != 101) {
                throw new InvalidKeySpecException("unsupported key spec");
            }
            int i2 = 11;
            if (b2 == 100) {
                if (encoded[9] != 10 || encoded[10] != 1 || encoded[11] != 1) {
                    throw new InvalidKeySpecException("unsupported key spec");
                }
                i2 = 12;
            } else if (b != 7) {
                i2 = 9;
            } else if (encoded[9] != 5 || encoded[10] != 0) {
                throw new InvalidKeySpecException("unsupported key spec");
            }
            int i3 = i2 + 1;
            if (encoded[i2] == 3) {
                int i4 = i2 + 2;
                if (encoded[i3] == 33) {
                    int i5 = i2 + 3;
                    if (encoded[i4] == 0) {
                        byte[] bArr = new byte[32];
                        System.arraycopy(encoded, i5, bArr, 0, 32);
                        this(new EdDSAPublicKeySpec(bArr, EdDSANamedCurveTable.a));
                        return;
                    }
                }
            }
            throw new InvalidKeySpecException("unsupported key spec");
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidKeySpecException(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EdDSAPublicKey)) {
            return false;
        }
        EdDSAPublicKey edDSAPublicKey = (EdDSAPublicKey) obj;
        return Arrays.equals(this.z, edDSAPublicKey.z) && this.A.equals(edDSAPublicKey.A);
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "EdDSA";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        if (!this.A.equals(EdDSANamedCurveTable.a)) {
            return null;
        }
        byte[] bArr = this.z;
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 12];
        bArr2[0] = 48;
        bArr2[1] = (byte) (length + 10);
        bArr2[2] = 48;
        bArr2[3] = 5;
        bArr2[4] = 6;
        bArr2[5] = 3;
        bArr2[6] = 43;
        bArr2[7] = 101;
        bArr2[8] = 112;
        bArr2[9] = 3;
        bArr2[10] = (byte) (bArr.length + 1);
        bArr2[11] = 0;
        System.arraycopy(bArr, 0, bArr2, 12, bArr.length);
        return bArr2;
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "X.509";
    }

    @Override // net.i2p.crypto.eddsa.EdDSAKey
    public final EdDSAParameterSpec getParams() {
        return this.A;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.z);
    }

    public EdDSAPublicKey(EdDSAPublicKeySpec edDSAPublicKeySpec) {
        this.f = null;
        GroupElement groupElement = edDSAPublicKeySpec.b;
        this.b = groupElement;
        this.z = groupElement.l();
        this.A = edDSAPublicKeySpec.f;
    }
}
