package net.i2p.crypto.eddsa.spec;

import defpackage.xe;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.GroupElement;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class EdDSAPrivateKeySpec implements KeySpec {
    public final GroupElement A;
    public final EdDSAParameterSpec X;
    public final byte[] b;
    public final byte[] f;
    public final byte[] z;

    public EdDSAPrivateKeySpec(byte[] bArr, EdDSAParameterSpec edDSAParameterSpec) {
        int length = bArr.length;
        Field field = edDSAParameterSpec.b.b;
        if (length != 32) {
            xe.k("seed length is wrong");
            throw null;
        }
        this.X = edDSAParameterSpec;
        this.b = bArr;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(edDSAParameterSpec.f);
            Field field2 = edDSAParameterSpec.b.b;
            byte[] bArrDigest = messageDigest.digest(bArr);
            this.f = bArrDigest;
            bArrDigest[0] = (byte) (bArrDigest[0] & 248);
            byte b = (byte) (bArrDigest[31] & 63);
            bArrDigest[31] = b;
            bArrDigest[31] = (byte) (b | 64);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDigest, 0, 32);
            this.z = bArrCopyOfRange;
            this.A = edDSAParameterSpec.A.i(bArrCopyOfRange);
        } catch (NoSuchAlgorithmException unused) {
            xe.k("Unsupported hash algorithm");
            throw null;
        }
    }

    public EdDSAPrivateKeySpec(byte[] bArr, byte[] bArr2, byte[] bArr3, GroupElement groupElement, EdDSAParameterSpec edDSAParameterSpec) {
        this.b = bArr;
        this.f = bArr2;
        this.z = bArr3;
        this.A = groupElement;
        this.X = edDSAParameterSpec;
    }
}
