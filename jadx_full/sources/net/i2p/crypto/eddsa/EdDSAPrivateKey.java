package net.i2p.crypto.eddsa;

import java.security.PrivateKey;
import java.util.Arrays;
import net.i2p.crypto.eddsa.math.GroupElement;
import net.i2p.crypto.eddsa.spec.EdDSANamedCurveTable;
import net.i2p.crypto.eddsa.spec.EdDSAParameterSpec;
import net.i2p.crypto.eddsa.spec.EdDSAPrivateKeySpec;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSAPrivateKey implements EdDSAKey, PrivateKey {
    public final GroupElement A;
    public final byte[] X;
    public final EdDSAParameterSpec Y;
    public final byte[] b;
    public final byte[] f;
    public final byte[] z;

    public EdDSAPrivateKey(EdDSAPrivateKeySpec edDSAPrivateKeySpec) {
        this.b = edDSAPrivateKeySpec.b;
        this.f = edDSAPrivateKeySpec.f;
        this.z = edDSAPrivateKeySpec.z;
        GroupElement groupElement = edDSAPrivateKeySpec.A;
        this.A = groupElement;
        this.X = groupElement.l();
        this.Y = edDSAPrivateKeySpec.X;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EdDSAPrivateKey)) {
            return false;
        }
        EdDSAPrivateKey edDSAPrivateKey = (EdDSAPrivateKey) obj;
        return Arrays.equals(this.b, edDSAPrivateKey.b) && this.Y.equals(edDSAPrivateKey.Y);
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "EdDSA";
    }

    @Override // java.security.Key
    public final byte[] getEncoded() {
        if (!this.Y.equals(EdDSANamedCurveTable.a)) {
            return null;
        }
        byte[] bArr = this.b;
        int length = bArr.length;
        byte[] bArr2 = new byte[length + 16];
        bArr2[0] = 48;
        bArr2[1] = (byte) (length + 14);
        bArr2[2] = 2;
        bArr2[3] = 1;
        bArr2[4] = 0;
        bArr2[5] = 48;
        bArr2[6] = 5;
        bArr2[7] = 6;
        bArr2[8] = 3;
        bArr2[9] = 43;
        bArr2[10] = 101;
        bArr2[11] = 112;
        bArr2[12] = 4;
        bArr2[13] = (byte) (bArr.length + 2);
        bArr2[14] = 4;
        bArr2[15] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    @Override // java.security.Key
    public final String getFormat() {
        return "PKCS#8";
    }

    @Override // net.i2p.crypto.eddsa.EdDSAKey
    public final EdDSAParameterSpec getParams() {
        return this.Y;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b);
    }
}
