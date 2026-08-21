package net.i2p.crypto.eddsa;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class KeyFactory extends KeyFactorySpi {
    @Override // java.security.KeyFactorySpi
    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        byte b;
        int i;
        int i2;
        if (keySpec instanceof EdDSAPrivateKeySpec) {
            return new EdDSAPrivateKey((EdDSAPrivateKeySpec) keySpec);
        }
        if (!(keySpec instanceof PKCS8EncodedKeySpec)) {
            throw new InvalidKeySpecException("key spec not recognised: " + keySpec.getClass());
        }
        byte[] encoded = ((PKCS8EncodedKeySpec) keySpec).getEncoded();
        try {
            byte b2 = encoded[11];
            if (b2 == 100) {
                i = 49;
                b = 8;
            } else {
                if (b2 != 112) {
                    throw new InvalidKeySpecException("unsupported key spec");
                }
                if (encoded[6] == 7) {
                    i = 50;
                    b = 7;
                } else {
                    b = 5;
                    i = 48;
                }
            }
            if (encoded.length != i) {
                throw new InvalidKeySpecException("invalid key spec length");
            }
            if (encoded[0] != 48 || encoded[1] != i - 2 || encoded[2] != 2 || encoded[3] != 1 || encoded[4] != 0 || encoded[5] != 48 || encoded[6] != b || encoded[7] != 6 || encoded[8] != 3 || encoded[9] != 43 || encoded[10] != 101) {
                throw new InvalidKeySpecException("unsupported key spec");
            }
            int i3 = 14;
            if (b2 != 100) {
                if (b != 7) {
                    i3 = 12;
                } else if (encoded[12] != 5 || encoded[13] != 0) {
                    throw new InvalidKeySpecException("unsupported key spec");
                }
                int i4 = i3 + 1;
                if (encoded[i3] == 4) {
                    i2 = encoded[i4] == 34 ? i3 + 2 : 15;
                }
                throw new InvalidKeySpecException("unsupported key spec");
            }
            if (encoded[12] != 10 || encoded[13] != 1 || encoded[14] != 1) {
                throw new InvalidKeySpecException("unsupported key spec");
            }
            int i5 = i2 + 1;
            if (encoded[i2] == 4) {
                int i6 = i2 + 2;
                if (encoded[i5] == 32) {
                    byte[] bArr = new byte[32];
                    System.arraycopy(encoded, i6, bArr, 0, 32);
                    return new EdDSAPrivateKey(new EdDSAPrivateKeySpec(bArr, EdDSANamedCurveTable.a));
                }
            }
            throw new InvalidKeySpecException("unsupported key spec");
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidKeySpecException(e);
        }
    }

    @Override // java.security.KeyFactorySpi
    public final PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof EdDSAPublicKeySpec) {
            return new EdDSAPublicKey((EdDSAPublicKeySpec) keySpec);
        }
        if (keySpec instanceof X509EncodedKeySpec) {
            return new EdDSAPublicKey((X509EncodedKeySpec) keySpec);
        }
        throw new InvalidKeySpecException("key spec not recognised: " + keySpec.getClass());
    }

    @Override // java.security.KeyFactorySpi
    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        EdDSAPrivateKey edDSAPrivateKey;
        EdDSAParameterSpec edDSAParameterSpec;
        if (cls.isAssignableFrom(EdDSAPublicKeySpec.class) && (key instanceof EdDSAPublicKey)) {
            EdDSAPublicKey edDSAPublicKey = (EdDSAPublicKey) key;
            EdDSAParameterSpec edDSAParameterSpec2 = edDSAPublicKey.A;
            if (edDSAParameterSpec2 != null) {
                return new EdDSAPublicKeySpec(edDSAPublicKey.b, edDSAParameterSpec2);
            }
        } else if (cls.isAssignableFrom(EdDSAPrivateKeySpec.class) && (key instanceof EdDSAPrivateKey) && (edDSAParameterSpec = (edDSAPrivateKey = (EdDSAPrivateKey) key).Y) != null) {
            return new EdDSAPrivateKeySpec(edDSAPrivateKey.b, edDSAPrivateKey.f, edDSAPrivateKey.z, edDSAPrivateKey.A, edDSAParameterSpec);
        }
        throw new InvalidKeySpecException("not implemented yet " + key + " " + cls);
    }

    @Override // java.security.KeyFactorySpi
    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        throw new InvalidKeyException("No other EdDSA key providers known");
    }
}
