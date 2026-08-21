package net.i2p.crypto.eddsa.math;

import defpackage.jb0;
import java.io.Serializable;
import net.i2p.crypto.eddsa.math.ed25519.Ed25519LittleEndianEncoding;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class Field implements Serializable {
    public final FieldElement A;
    public final Ed25519LittleEndianEncoding X;
    public final FieldElement b;
    public final FieldElement f;
    public final FieldElement z;

    public Field(byte[] bArr, Ed25519LittleEndianEncoding ed25519LittleEndianEncoding) {
        this.X = ed25519LittleEndianEncoding;
        ed25519LittleEndianEncoding.a(this);
        FieldElement fieldElementB = ed25519LittleEndianEncoding.b(bArr);
        this.z = fieldElementB;
        this.b = ed25519LittleEndianEncoding.b(jb0.a);
        this.f = ed25519LittleEndianEncoding.b(jb0.b);
        FieldElement fieldElementB2 = ed25519LittleEndianEncoding.b(jb0.c);
        ed25519LittleEndianEncoding.b(jb0.d);
        FieldElement fieldElementB3 = ed25519LittleEndianEncoding.b(jb0.e);
        FieldElement fieldElementB4 = ed25519LittleEndianEncoding.b(jb0.f);
        fieldElementB.l(fieldElementB2);
        this.A = fieldElementB.l(fieldElementB3).d(fieldElementB4);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Field) && this.z.equals(((Field) obj).z);
    }

    public final int hashCode() {
        return this.z.hashCode();
    }
}
