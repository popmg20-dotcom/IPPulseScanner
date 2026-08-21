package org.conscrypt;

import defpackage.dw2;
import defpackage.ha0;
import defpackage.zo2;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class OpenSSLECKeyPairGenerator extends KeyPairGenerator {
    private static final String ALGORITHM = "EC";
    private static final int DEFAULT_KEY_SIZE = 256;
    private static final Map<Integer, String> SIZE_TO_CURVE_NAME;
    private OpenSSLECGroupContext group;

    static {
        HashMap map = new HashMap();
        SIZE_TO_CURVE_NAME = map;
        map.put(224, "secp224r1");
        map.put(256, "prime256v1");
        map.put(384, "secp384r1");
        map.put(521, "secp521r1");
    }

    public OpenSSLECKeyPairGenerator() {
        super(ALGORITHM);
    }

    public static void assertCurvesAreValid() {
        ArrayList arrayList = new ArrayList();
        for (String str : SIZE_TO_CURVE_NAME.values()) {
            if (OpenSSLECGroupContext.getCurveByName(str) == null) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            return;
        }
        throw new AssertionError("Invalid curve names: " + Arrays.toString(arrayList.toArray()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        OpenSSLECGroupContext openSSLECGroupContext = this.group;
        if (openSSLECGroupContext == null) {
            String str = SIZE_TO_CURVE_NAME.get(256);
            OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(str);
            this.group = curveByName;
            if (curveByName == null) {
                zo2.w(ha0.n("Curve not recognized: ", str));
                return null;
            }
            openSSLECGroupContext = curveByName;
        }
        OpenSSLKey openSSLKey = new OpenSSLKey(NativeCrypto.EC_KEY_generate_key(openSSLECGroupContext.getNativeRef()));
        return new KeyPair(new OpenSSLECPublicKey(this.group, openSSLKey), new OpenSSLECPrivateKey(this.group, openSSLKey));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof ECParameterSpec) {
            this.group = OpenSSLECGroupContext.getInstance((ECParameterSpec) algorithmParameterSpec);
            return;
        }
        if (!(algorithmParameterSpec instanceof ECGenParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter must be ECParameterSpec or ECGenParameterSpec");
        }
        String name = ((ECGenParameterSpec) algorithmParameterSpec).getName();
        OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(name);
        if (curveByName == null) {
            throw new InvalidAlgorithmParameterException(ha0.n("unknown curve name: ", name));
        }
        this.group = curveByName;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        String str = SIZE_TO_CURVE_NAME.get(Integer.valueOf(i));
        if (str != null) {
            OpenSSLECGroupContext curveByName = OpenSSLECGroupContext.getCurveByName(str);
            if (curveByName != null) {
                this.group = curveByName;
                return;
            }
            throw new InvalidParameterException("unknown curve ".concat(str));
        }
        throw new InvalidParameterException(dw2.A(i, "unknown key size "));
    }
}
