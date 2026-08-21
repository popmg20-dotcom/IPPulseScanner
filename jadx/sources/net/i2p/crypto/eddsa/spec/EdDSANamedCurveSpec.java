package net.i2p.crypto.eddsa.spec;

import net.i2p.crypto.eddsa.math.Curve;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519ScalarOps;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSANamedCurveSpec extends EdDSAParameterSpec {
    public final String X;

    public EdDSANamedCurveSpec(Curve curve, Ed25519ScalarOps ed25519ScalarOps, GroupElement groupElement) {
        super(curve, ed25519ScalarOps, groupElement);
        this.X = "Ed25519";
    }
}
