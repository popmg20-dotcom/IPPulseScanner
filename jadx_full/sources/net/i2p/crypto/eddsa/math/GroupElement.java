package net.i2p.crypto.eddsa.math;

import defpackage.s53;
import defpackage.vp1;
import defpackage.xe;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import net.i2p.crypto.eddsa.Utils;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class GroupElement implements Serializable {
    public final FieldElement A;
    public final FieldElement X;
    public final FieldElement Y;
    public final GroupElement[][] Z;
    public final Curve b;
    public final Representation f;
    public final GroupElement[] y0;
    public final FieldElement z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
    public static final class Representation {
        public static final Representation A;
        public static final Representation X;
        public static final Representation Y;
        public static final /* synthetic */ Representation[] Z;
        public static final Representation b;
        public static final Representation f;
        public static final Representation z;

        static {
            Representation representation = new Representation("P2", 0);
            b = representation;
            Representation representation2 = new Representation("P3", 1);
            f = representation2;
            Representation representation3 = new Representation("P3PrecomputedDouble", 2);
            z = representation3;
            Representation representation4 = new Representation("P1P1", 3);
            A = representation4;
            Representation representation5 = new Representation("PRECOMP", 4);
            X = representation5;
            Representation representation6 = new Representation("CACHED", 5);
            Y = representation6;
            Z = new Representation[]{representation, representation2, representation3, representation4, representation5, representation6};
        }

        public static Representation valueOf(String str) {
            return (Representation) Enum.valueOf(Representation.class, str);
        }

        public static Representation[] values() {
            return (Representation[]) Z.clone();
        }
    }

    public GroupElement(Curve curve, byte[] bArr, boolean z) {
        Representation representation;
        Field field = curve.b;
        FieldElement fieldElementB = field.X.b(bArr);
        FieldElement fieldElementJ = fieldElementB.j();
        FieldElement fieldElementM = fieldElementJ.m();
        FieldElement fieldElementB2 = fieldElementJ.g(curve.f).b();
        FieldElement fieldElementG = fieldElementB2.j().g(fieldElementB2);
        FieldElement fieldElementG2 = fieldElementG.g(fieldElementM).g(fieldElementG.j().g(fieldElementB2).g(fieldElementM).i());
        FieldElement fieldElementG3 = fieldElementG2.j().g(fieldElementB2);
        if (fieldElementG3.l(fieldElementM).f()) {
            if (fieldElementG3.a(fieldElementM).f()) {
                xe.k("not a valid GroupElement");
                throw null;
            }
            fieldElementG2 = fieldElementG2.g(curve.A);
        }
        fieldElementG2 = ((fieldElementG2.b.X.c(fieldElementG2)[0] & 1) != 0 ? 1 : 0) != ((bArr[31] >> 7) & 1) ? fieldElementG2.h() : fieldElementG2;
        this.b = curve;
        Representation representation2 = Representation.f;
        this.f = representation2;
        this.z = fieldElementG2;
        this.A = fieldElementB;
        this.X = field.f;
        this.Y = fieldElementG2.g(fieldElementB);
        if (!z) {
            this.Z = null;
            this.y0 = null;
            return;
        }
        GroupElement[][] groupElementArr = (GroupElement[][]) Array.newInstance((Class<?>) GroupElement.class, 32, 8);
        GroupElement groupElementM = this;
        int i = 0;
        for (int i2 = 32; i < i2; i2 = 32) {
            int i3 = 0;
            GroupElement groupElementM2 = groupElementM;
            while (true) {
                representation = Representation.Y;
                if (i3 >= 8) {
                    break;
                }
                FieldElement fieldElementE = groupElementM2.X.e();
                FieldElement fieldElementG4 = groupElementM2.z.g(fieldElementE);
                FieldElement fieldElementG5 = groupElementM2.A.g(fieldElementE);
                groupElementArr[i][i3] = g(curve, fieldElementG5.a(fieldElementG4), fieldElementG5.l(fieldElementG4), fieldElementG4.g(fieldElementG5).g(curve.z));
                groupElementM2 = groupElementM2.a(groupElementM.m(representation)).m(representation2);
                i3++;
            }
            for (int i4 = 0; i4 < 8; i4++) {
                groupElementM = groupElementM.a(groupElementM.m(representation)).m(representation2);
            }
            i++;
        }
        this.Z = groupElementArr;
        this.y0 = h();
    }

    public static GroupElement f(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        return new GroupElement(curve, Representation.A, fieldElement, fieldElement2, fieldElement3, fieldElement4, false);
    }

    public static GroupElement g(Curve curve, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3) {
        return new GroupElement(curve, Representation.X, fieldElement, fieldElement2, fieldElement3, null, false);
    }

    public static byte[] k(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & (bArr[i2 >> 3] >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr2[i3] = (byte) (b2 + (b << i4));
                            bArr2[i] = 0;
                        } else if (b2 - (b << i4) >= -15) {
                            bArr2[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                }
                                bArr2[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    public final GroupElement a(GroupElement groupElement) {
        if (this.f != Representation.f) {
            vp1.q();
            return null;
        }
        if (groupElement.f != Representation.Y) {
            s53.d();
            return null;
        }
        FieldElement fieldElement = this.A;
        FieldElement fieldElement2 = this.z;
        FieldElement fieldElementA = fieldElement.a(fieldElement2);
        FieldElement fieldElementL = fieldElement.l(fieldElement2);
        FieldElement fieldElementG = fieldElementA.g(groupElement.z);
        FieldElement fieldElementG2 = fieldElementL.g(groupElement.A);
        FieldElement fieldElementG3 = groupElement.Y.g(this.Y);
        FieldElement fieldElementG4 = this.X.g(groupElement.X);
        FieldElement fieldElementA2 = fieldElementG4.a(fieldElementG4);
        return f(this.b, fieldElementG.l(fieldElementG2), fieldElementG.a(fieldElementG2), fieldElementA2.a(fieldElementG3), fieldElementA2.l(fieldElementG3));
    }

    public final GroupElement b(GroupElement groupElement, int i) {
        return g(this.b, this.z.c(groupElement.z, i), this.A.c(groupElement.A, i), this.X.c(groupElement.X, i));
    }

    public final GroupElement c() {
        int iOrdinal = this.f.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            vp1.q();
            return null;
        }
        FieldElement fieldElement = this.z;
        FieldElement fieldElementJ = fieldElement.j();
        FieldElement fieldElement2 = this.A;
        FieldElement fieldElementJ2 = fieldElement2.j();
        FieldElement fieldElementK = this.X.k();
        FieldElement fieldElementJ3 = fieldElement.a(fieldElement2).j();
        FieldElement fieldElementA = fieldElementJ2.a(fieldElementJ);
        FieldElement fieldElementL = fieldElementJ2.l(fieldElementJ);
        return f(this.b, fieldElementJ3.l(fieldElementA), fieldElementA, fieldElementL, fieldElementK.l(fieldElementL));
    }

    public final GroupElement d(GroupElement groupElement) {
        if (this.f != Representation.f) {
            vp1.q();
            return null;
        }
        if (groupElement.f != Representation.X) {
            s53.d();
            return null;
        }
        FieldElement fieldElement = this.A;
        FieldElement fieldElement2 = this.z;
        FieldElement fieldElementA = fieldElement.a(fieldElement2);
        FieldElement fieldElementL = fieldElement.l(fieldElement2);
        FieldElement fieldElementG = fieldElementA.g(groupElement.z);
        FieldElement fieldElementG2 = fieldElementL.g(groupElement.A);
        FieldElement fieldElementG3 = groupElement.X.g(this.Y);
        FieldElement fieldElement3 = this.X;
        FieldElement fieldElementA2 = fieldElement3.a(fieldElement3);
        return f(this.b, fieldElementG.l(fieldElementG2), fieldElementG.a(fieldElementG2), fieldElementA2.a(fieldElementG3), fieldElementA2.l(fieldElementG3));
    }

    public final GroupElement e(GroupElement groupElement) {
        if (this.f != Representation.f) {
            vp1.q();
            return null;
        }
        if (groupElement.f != Representation.X) {
            s53.d();
            return null;
        }
        FieldElement fieldElement = this.A;
        FieldElement fieldElement2 = this.z;
        FieldElement fieldElementA = fieldElement.a(fieldElement2);
        FieldElement fieldElementL = fieldElement.l(fieldElement2);
        FieldElement fieldElementG = fieldElementA.g(groupElement.A);
        FieldElement fieldElementG2 = fieldElementL.g(groupElement.z);
        FieldElement fieldElementG3 = groupElement.X.g(this.Y);
        FieldElement fieldElement3 = this.X;
        FieldElement fieldElementA2 = fieldElement3.a(fieldElement3);
        return f(this.b, fieldElementG.l(fieldElementG2), fieldElementG.a(fieldElementG2), fieldElementA2.l(fieldElementG3), fieldElementA2.a(fieldElementG3));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof GroupElement) {
                GroupElement groupElementM = (GroupElement) obj;
                Representation representation = groupElementM.f;
                Representation representation2 = this.f;
                if (!representation2.equals(representation)) {
                    try {
                        groupElementM = groupElementM.m(representation2);
                    } catch (RuntimeException unused) {
                        return false;
                    }
                }
                FieldElement fieldElement = groupElementM.Y;
                FieldElement fieldElement2 = groupElementM.A;
                FieldElement fieldElement3 = groupElementM.z;
                FieldElement fieldElement4 = groupElementM.X;
                int iOrdinal = representation2.ordinal();
                FieldElement fieldElement5 = this.z;
                FieldElement fieldElement6 = this.A;
                FieldElement fieldElement7 = this.X;
                if (iOrdinal == 0 || iOrdinal == 1) {
                    if (!fieldElement7.equals(fieldElement4)) {
                        FieldElement fieldElementG = fieldElement5.g(fieldElement4);
                        FieldElement fieldElementG2 = fieldElement6.g(fieldElement4);
                        FieldElement fieldElementG3 = fieldElement3.g(fieldElement7);
                        FieldElement fieldElementG4 = fieldElement2.g(fieldElement7);
                        if (!fieldElementG.equals(fieldElementG3) || !fieldElementG2.equals(fieldElementG4)) {
                        }
                    } else if (!fieldElement5.equals(fieldElement3) || !fieldElement6.equals(fieldElement2)) {
                    }
                } else {
                    if (iOrdinal == 3) {
                        return m(Representation.b).equals(groupElementM);
                    }
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            boolean zEquals = fieldElement7.equals(fieldElement4);
                            FieldElement fieldElement8 = this.Y;
                            if (!zEquals) {
                                FieldElement fieldElementG5 = fieldElement5.g(fieldElement4);
                                FieldElement fieldElementG6 = fieldElement6.g(fieldElement4);
                                FieldElement fieldElementG7 = fieldElement8.g(fieldElement4);
                                FieldElement fieldElementG8 = fieldElement3.g(fieldElement7);
                                FieldElement fieldElementG9 = fieldElement2.g(fieldElement7);
                                FieldElement fieldElementG10 = fieldElement.g(fieldElement7);
                                if (!fieldElementG5.equals(fieldElementG8) || !fieldElementG6.equals(fieldElementG9) || !fieldElementG7.equals(fieldElementG10)) {
                                }
                            } else if (!fieldElement5.equals(fieldElement3) || !fieldElement6.equals(fieldElement2) || !fieldElement8.equals(fieldElement)) {
                            }
                        }
                    } else if (!fieldElement5.equals(fieldElement3) || !fieldElement6.equals(fieldElement2) || !fieldElement7.equals(fieldElement4)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final GroupElement[] h() {
        GroupElement[] groupElementArr = new GroupElement[8];
        GroupElement groupElementM = this;
        for (int i = 0; i < 8; i++) {
            FieldElement fieldElementE = groupElementM.X.e();
            FieldElement fieldElementG = groupElementM.z.g(fieldElementE);
            FieldElement fieldElementG2 = groupElementM.A.g(fieldElementE);
            FieldElement fieldElementA = fieldElementG2.a(fieldElementG);
            FieldElement fieldElementL = fieldElementG2.l(fieldElementG);
            FieldElement fieldElementG3 = fieldElementG.g(fieldElementG2);
            Curve curve = this.b;
            groupElementArr[i] = g(curve, fieldElementA, fieldElementL, fieldElementG3.g(curve.z));
            Representation representation = Representation.Y;
            GroupElement groupElementA = a(groupElementM.m(representation));
            Representation representation2 = Representation.f;
            groupElementM = a(groupElementA.m(representation2).m(representation)).m(representation2);
        }
        return groupElementArr;
    }

    public final int hashCode() {
        return Arrays.hashCode(l());
    }

    public final GroupElement i(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 * 2;
            bArr2[i3] = (byte) (bArr[i2] & 15);
            bArr2[i3 + 1] = (byte) ((bArr[i2] >> 4) & 15);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr2[i4] + i5);
            bArr2[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr2[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr2[63] = (byte) (bArr2[63] + i5);
        Curve curve = this.b;
        Representation representation = Representation.f;
        GroupElement groupElementA = curve.a(representation);
        for (i = 1; i < 64; i += 2) {
            groupElementA = groupElementA.d(j(i / 2, bArr2[i])).m(representation);
        }
        GroupElement groupElementC = groupElementA.c();
        Representation representation2 = Representation.b;
        GroupElement groupElementM = groupElementC.m(representation2).c().m(representation2).c().m(representation2).c().m(representation);
        for (int i7 = 0; i7 < 64; i7 += 2) {
            groupElementM = groupElementM.d(j(i7 / 2, bArr2[i7])).m(representation);
        }
        return groupElementM;
    }

    public final GroupElement j(int i, int i2) {
        int i3 = (i2 >> 8) & 1;
        int i4 = i2 - (((-i3) & i2) << 1);
        Representation representation = Representation.X;
        Curve curve = this.b;
        GroupElement groupElementA = curve.a(representation);
        GroupElement[][] groupElementArr = this.Z;
        GroupElement groupElementB = groupElementA.b(groupElementArr[i][0], Utils.a(i4, 1)).b(groupElementArr[i][1], Utils.a(i4, 2)).b(groupElementArr[i][2], Utils.a(i4, 3)).b(groupElementArr[i][3], Utils.a(i4, 4)).b(groupElementArr[i][4], Utils.a(i4, 5)).b(groupElementArr[i][5], Utils.a(i4, 6)).b(groupElementArr[i][6], Utils.a(i4, 7)).b(groupElementArr[i][7], Utils.a(i4, 8));
        return groupElementB.b(g(curve, groupElementB.A, groupElementB.z, groupElementB.X.h()), i3);
    }

    public final byte[] l() {
        int iOrdinal = this.f.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            return m(Representation.b).l();
        }
        FieldElement fieldElementE = this.X.e();
        FieldElement fieldElementG = this.z.g(fieldElementE);
        FieldElement fieldElementG2 = this.A.g(fieldElementE);
        byte[] bArrC = fieldElementG2.b.X.c(fieldElementG2);
        bArrC[31] = (byte) (bArrC[31] | ((1 & fieldElementG.b.X.c(fieldElementG)[0]) != 0 ? (byte) -128 : (byte) 0));
        return bArrC;
    }

    public final GroupElement m(Representation representation) {
        int iOrdinal = this.f.ordinal();
        Representation representation2 = Representation.b;
        Curve curve = this.b;
        FieldElement fieldElement = this.X;
        FieldElement fieldElement2 = this.A;
        FieldElement fieldElement3 = this.z;
        if (iOrdinal == 0) {
            if (representation.ordinal() == 0) {
                return new GroupElement(curve, representation2, fieldElement3, fieldElement2, fieldElement, null, false);
            }
            s53.d();
            return null;
        }
        Representation representation3 = Representation.Y;
        Representation representation4 = Representation.f;
        FieldElement fieldElement4 = this.Y;
        if (iOrdinal == 1) {
            int iOrdinal2 = representation.ordinal();
            if (iOrdinal2 == 0) {
                return new GroupElement(curve, representation2, fieldElement3, fieldElement2, fieldElement, null, false);
            }
            if (iOrdinal2 == 1) {
                return new GroupElement(this.b, representation4, this.z, this.A, this.X, this.Y, false);
            }
            if (iOrdinal2 == 5) {
                return new GroupElement(curve, representation3, fieldElement2.a(fieldElement3), fieldElement2.l(fieldElement3), fieldElement, fieldElement4.g(curve.z), false);
            }
            s53.d();
            return null;
        }
        if (iOrdinal != 3) {
            if (iOrdinal == 4) {
                if (representation.ordinal() == 4) {
                    return g(curve, fieldElement3, fieldElement2, fieldElement);
                }
                s53.d();
                return null;
            }
            if (iOrdinal != 5) {
                vp1.q();
                return null;
            }
            if (representation.ordinal() == 5) {
                return new GroupElement(curve, representation3, fieldElement3, fieldElement2, fieldElement, fieldElement4, false);
            }
            s53.d();
            return null;
        }
        int iOrdinal3 = representation.ordinal();
        if (iOrdinal3 == 0) {
            return new GroupElement(curve, representation2, fieldElement3.g(fieldElement4), fieldElement2.g(fieldElement), fieldElement.g(fieldElement4), null, false);
        }
        if (iOrdinal3 == 1) {
            return new GroupElement(this.b, representation4, fieldElement3.g(fieldElement4), fieldElement2.g(fieldElement), fieldElement.g(fieldElement4), fieldElement3.g(fieldElement2), false);
        }
        if (iOrdinal3 != 2) {
            if (iOrdinal3 == 3) {
                return f(curve, fieldElement3, fieldElement2, fieldElement, fieldElement4);
            }
            s53.d();
            return null;
        }
        return new GroupElement(this.b, representation4, fieldElement3.g(fieldElement4), fieldElement2.g(fieldElement), fieldElement.g(fieldElement4), fieldElement3.g(fieldElement2), true);
    }

    public final String toString() {
        return "[GroupElement\nX=" + this.z + "\nY=" + this.A + "\nZ=" + this.X + "\nT=" + this.Y + "\n]";
    }

    public GroupElement(Curve curve, Representation representation, FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4, boolean z) {
        this.b = curve;
        this.f = representation;
        this.z = fieldElement;
        this.A = fieldElement2;
        this.X = fieldElement3;
        this.Y = fieldElement4;
        this.Z = null;
        this.y0 = z ? h() : null;
    }
}
