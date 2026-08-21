package net.i2p.crypto.eddsa.spec;

import defpackage.xe;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import net.i2p.crypto.eddsa.math.Curve;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519ScalarOps;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSAParameterSpec implements AlgorithmParameterSpec, Serializable {
    public final GroupElement A;
    public final Curve b;
    public final String f;
    public final Ed25519ScalarOps z;

    public EdDSAParameterSpec(Curve curve, Ed25519ScalarOps ed25519ScalarOps, GroupElement groupElement) {
        try {
            if (64 != MessageDigest.getInstance("SHA-512").getDigestLength()) {
                throw new IllegalArgumentException("Hash output is not 2b-bit");
            }
            this.b = curve;
            this.f = "SHA-512";
            this.z = ed25519ScalarOps;
            this.A = groupElement;
        } catch (NoSuchAlgorithmException unused) {
            xe.k("Unsupported hash algorithm");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EdDSAParameterSpec)) {
            return false;
        }
        EdDSAParameterSpec edDSAParameterSpec = (EdDSAParameterSpec) obj;
        return this.f.equals(edDSAParameterSpec.f) && this.b.equals(edDSAParameterSpec.b) && this.A.equals(edDSAParameterSpec.A);
    }

    public final int hashCode() {
        return this.A.hashCode() ^ (this.f.hashCode() ^ this.b.hashCode());
    }
}
