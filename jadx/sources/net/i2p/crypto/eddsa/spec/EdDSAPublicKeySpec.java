package net.i2p.crypto.eddsa.spec;

import defpackage.xe;
import java.security.spec.KeySpec;
import net.i2p.crypto.eddsa.math.Curve;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.GroupElement;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSAPublicKeySpec implements KeySpec {
    public final GroupElement b;
    public final EdDSAParameterSpec f;

    public EdDSAPublicKeySpec(byte[] bArr, EdDSAParameterSpec edDSAParameterSpec) {
        int length = bArr.length;
        Curve curve = edDSAParameterSpec.b;
        Field field = curve.b;
        if (length != 32) {
            xe.k("public-key length is wrong");
            throw null;
        }
        this.b = new GroupElement(curve, bArr, false);
        this.f = edDSAParameterSpec;
    }

    public EdDSAPublicKeySpec(GroupElement groupElement, EdDSAParameterSpec edDSAParameterSpec) {
        this.b = groupElement;
        this.f = edDSAParameterSpec;
    }
}
