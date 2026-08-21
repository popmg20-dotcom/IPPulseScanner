package net.i2p.crypto.eddsa;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGeneratorSpi;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Locale;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.spec.EdDSAGenParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveSpec;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;
import net.i2p.crypto.eddsa.spec.EdDSAPublicKeySpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class KeyPairGenerator extends KeyPairGeneratorSpi {
    public static final Hashtable c;
    public EdDSAParameterSpec a;
    public SecureRandom b;

    static {
        Hashtable hashtable = new Hashtable();
        c = hashtable;
        hashtable.put(256, new EdDSAGenParameterSpec());
    }

    @Override // java.security.KeyPairGeneratorSpi
    public final KeyPair generateKeyPair() {
        Field field = this.a.b.b;
        byte[] bArr = new byte[32];
        this.b.nextBytes(bArr);
        EdDSAPrivateKeySpec edDSAPrivateKeySpec = new EdDSAPrivateKeySpec(bArr, this.a);
        return new KeyPair(new EdDSAPublicKey(new EdDSAPublicKeySpec(edDSAPrivateKeySpec.A, this.a)), new EdDSAPrivateKey(edDSAPrivateKeySpec));
    }

    @Override // java.security.KeyPairGeneratorSpi
    public final void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof EdDSAParameterSpec) {
            this.a = (EdDSAParameterSpec) algorithmParameterSpec;
        } else {
            if (!(algorithmParameterSpec instanceof EdDSAGenParameterSpec)) {
                throw new InvalidAlgorithmParameterException("parameter object not a EdDSAParameterSpec");
            }
            EdDSANamedCurveSpec edDSANamedCurveSpec = (EdDSANamedCurveSpec) EdDSANamedCurveTable.b.get("Ed25519".toLowerCase(Locale.ENGLISH));
            if (edDSANamedCurveSpec == null) {
                throw new InvalidAlgorithmParameterException("unknown curve name: ".concat("Ed25519"));
            }
            this.a = edDSANamedCurveSpec;
        }
        this.b = secureRandom;
    }

    @Override // java.security.KeyPairGeneratorSpi
    public final void initialize(int i, SecureRandom secureRandom) {
        AlgorithmParameterSpec algorithmParameterSpec = (AlgorithmParameterSpec) c.get(Integer.valueOf(i));
        if (algorithmParameterSpec != null) {
            try {
                initialize(algorithmParameterSpec, secureRandom);
                return;
            } catch (InvalidAlgorithmParameterException unused) {
                throw new InvalidParameterException("key type not configurable.");
            }
        }
        throw new InvalidParameterException("unknown key type.");
    }
}
