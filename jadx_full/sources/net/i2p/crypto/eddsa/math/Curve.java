package net.i2p.crypto.eddsa.math;

import java.io.Serializable;
import net.i2p.crypto.eddsa.math.GroupElement;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class Curve implements Serializable {
    public final FieldElement A;
    public final GroupElement X;
    public final GroupElement Y;
    public final GroupElement Z;
    public final Field b;
    public final FieldElement f;
    public final GroupElement y0;
    public final FieldElement z;

    public Curve(Field field, byte[] bArr, FieldElement fieldElement) {
        this.b = field;
        FieldElement fieldElementB = field.X.b(bArr);
        this.f = fieldElementB;
        this.z = fieldElementB.a(fieldElementB);
        this.A = fieldElement;
        FieldElement fieldElement2 = field.b;
        FieldElement fieldElement3 = field.f;
        this.X = new GroupElement(this, GroupElement.Representation.b, fieldElement2, fieldElement3, fieldElement3, null, false);
        GroupElement.Representation representation = GroupElement.Representation.f;
        this.Y = new GroupElement(this, representation, fieldElement2, fieldElement3, fieldElement3, fieldElement2, false);
        this.Z = new GroupElement(this, representation, fieldElement2, fieldElement3, fieldElement3, fieldElement2, true);
        this.y0 = GroupElement.g(this, fieldElement3, fieldElement3, fieldElement2);
    }

    public final GroupElement a(GroupElement.Representation representation) {
        int iOrdinal = representation.ordinal();
        if (iOrdinal == 0) {
            return this.X;
        }
        if (iOrdinal == 1) {
            return this.Y;
        }
        if (iOrdinal == 2) {
            return this.Z;
        }
        if (iOrdinal != 4) {
            return null;
        }
        return this.y0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Curve)) {
            return false;
        }
        Curve curve = (Curve) obj;
        return this.b.equals(curve.b) && this.f.equals(curve.f) && this.A.equals(curve.A);
    }

    public final int hashCode() {
        return this.A.hashCode() ^ (this.b.z.hashCode() ^ this.f.hashCode());
    }
}
