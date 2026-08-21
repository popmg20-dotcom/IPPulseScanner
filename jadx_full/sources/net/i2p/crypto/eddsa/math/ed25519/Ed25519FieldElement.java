package net.i2p.crypto.eddsa.math.ed25519;

import defpackage.xe;
import java.util.Arrays;
import net.i2p.crypto.eddsa.Utils;
import net.i2p.crypto.eddsa.math.Field;
import net.i2p.crypto.eddsa.math.FieldElement;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class Ed25519FieldElement extends FieldElement {
    public static final byte[] z = new byte[32];
    public final int[] f;

    public Ed25519FieldElement(Field field, int[] iArr) {
        super(field);
        if (iArr.length == 10) {
            this.f = iArr;
        } else {
            xe.k("Invalid radix-2^51 representation");
            throw null;
        }
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement a(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).f;
        int[] iArr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr2[i] = this.f[i] + iArr[i];
        }
        return new Ed25519FieldElement(this.b, iArr2);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement c(FieldElement fieldElement, int i) {
        Ed25519FieldElement ed25519FieldElement = (Ed25519FieldElement) fieldElement;
        int i2 = -i;
        int[] iArr = new int[10];
        for (int i3 = 0; i3 < 10; i3++) {
            int[] iArr2 = this.f;
            int i4 = iArr2[i3];
            iArr[i3] = i4;
            iArr[i3] = ((iArr2[i3] ^ ed25519FieldElement.f[i3]) & i2) ^ i4;
        }
        return new Ed25519FieldElement(this.b, iArr);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement e() {
        FieldElement fieldElementJ = j();
        FieldElement fieldElementG = g(fieldElementJ.j().j());
        FieldElement fieldElementG2 = fieldElementJ.g(fieldElementG);
        FieldElement fieldElementG3 = fieldElementG.g(fieldElementG2.j());
        FieldElement fieldElementJ2 = fieldElementG3.j();
        for (int i = 1; i < 5; i++) {
            fieldElementJ2 = fieldElementJ2.j();
        }
        FieldElement fieldElementG4 = fieldElementJ2.g(fieldElementG3);
        FieldElement fieldElementJ3 = fieldElementG4.j();
        for (int i2 = 1; i2 < 10; i2++) {
            fieldElementJ3 = fieldElementJ3.j();
        }
        FieldElement fieldElementG5 = fieldElementJ3.g(fieldElementG4);
        FieldElement fieldElementJ4 = fieldElementG5.j();
        for (int i3 = 1; i3 < 20; i3++) {
            fieldElementJ4 = fieldElementJ4.j();
        }
        FieldElement fieldElementJ5 = fieldElementJ4.g(fieldElementG5).j();
        for (int i4 = 1; i4 < 10; i4++) {
            fieldElementJ5 = fieldElementJ5.j();
        }
        FieldElement fieldElementG6 = fieldElementJ5.g(fieldElementG4);
        FieldElement fieldElementJ6 = fieldElementG6.j();
        for (int i5 = 1; i5 < 50; i5++) {
            fieldElementJ6 = fieldElementJ6.j();
        }
        FieldElement fieldElementG7 = fieldElementJ6.g(fieldElementG6);
        FieldElement fieldElementJ7 = fieldElementG7.j();
        for (int i6 = 1; i6 < 100; i6++) {
            fieldElementJ7 = fieldElementJ7.j();
        }
        FieldElement fieldElementJ8 = fieldElementJ7.g(fieldElementG7).j();
        for (int i7 = 1; i7 < 50; i7++) {
            fieldElementJ8 = fieldElementJ8.j();
        }
        FieldElement fieldElementJ9 = fieldElementJ8.g(fieldElementG6).j();
        for (int i8 = 1; i8 < 5; i8++) {
            fieldElementJ9 = fieldElementJ9.j();
        }
        return fieldElementJ9.g(fieldElementG2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Ed25519FieldElement) {
            Ed25519FieldElement ed25519FieldElement = (Ed25519FieldElement) obj;
            byte[] bArrC = this.b.X.c(this);
            byte[] bArrC2 = ed25519FieldElement.b.X.c(ed25519FieldElement);
            int i = 0;
            for (int i2 = 0; i2 < 32; i2++) {
                i |= bArrC[i2] ^ bArrC2[i2];
            }
            if (1 == Utils.a(i, 0)) {
                return true;
            }
        }
        return false;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final boolean f() {
        byte[] bArrC = this.b.X.c(this);
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            i |= bArrC[i2] ^ z[i2];
        }
        return Utils.a(i, 0) == 0;
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement g(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).f;
        int i = iArr[1];
        int i2 = i * 19;
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = i4 * 19;
        int i6 = iArr[4];
        int i7 = i6 * 19;
        int i8 = iArr[5];
        int i9 = iArr[6];
        int i10 = i9 * 19;
        int i11 = iArr[7];
        int i12 = iArr[8];
        int i13 = iArr[9];
        int[] iArr2 = this.f;
        int i14 = iArr2[1];
        int i15 = i14 * 2;
        int i16 = iArr2[3];
        int i17 = iArr2[5];
        int i18 = i17 * 2;
        int i19 = iArr2[7];
        int i20 = i19 * 2;
        int i21 = iArr2[9];
        int i22 = i21 * 2;
        long j = iArr2[0];
        long j2 = iArr[0];
        long j3 = j * j2;
        long j4 = i;
        long j5 = j * j4;
        long j6 = i3;
        long j7 = j * j6;
        long j8 = i4;
        long j9 = i6;
        long j10 = i8;
        long j11 = i9;
        long j12 = j * j11;
        long j13 = i11;
        long j14 = j * j13;
        long j15 = i12;
        long j16 = j * j15;
        long j17 = ((long) i13) * j;
        long j18 = i14;
        long j19 = i15;
        long j20 = j19 * j4;
        long j21 = j19 * j8;
        long j22 = j19 * j10;
        long j23 = j19 * j13;
        long j24 = i13 * 19;
        long j25 = j19 * j24;
        long j26 = iArr2[2];
        long j27 = j26 * j2;
        long j28 = j26 * j4;
        long j29 = j26 * j6;
        long j30 = j26 * j8;
        long j31 = j26 * j9;
        long j32 = j26 * j10;
        long j33 = j26 * j11;
        long j34 = j13 * j26;
        long j35 = i12 * 19;
        long j36 = j26 * j35;
        long j37 = j26 * j24;
        long j38 = i16;
        long j39 = j38 * j2;
        long j40 = i16 * 2;
        long j41 = j38 * j6;
        long j42 = j40 * j8;
        long j43 = j38 * j9;
        long j44 = j40 * j10;
        long j45 = j11 * j38;
        long j46 = i11 * 19;
        long j47 = j40 * j46;
        long j48 = j38 * j35;
        long j49 = iArr2[4];
        long j50 = j49 * j2;
        long j51 = j49 * j4;
        long j52 = j49 * j6;
        long j53 = j49 * j8;
        long j54 = j49 * j9;
        long j55 = j10 * j49;
        long j56 = i10;
        long j57 = j49 * j56;
        long j58 = j49 * j46;
        long j59 = j49 * j35;
        long j60 = j49 * j24;
        long j61 = i17;
        long j62 = j61 * j2;
        long j63 = i18;
        long j64 = j63 * j4;
        long j65 = j61 * j6;
        long j66 = j63 * j8;
        long j67 = j61 * j9;
        long j68 = i8 * 19;
        long j69 = j63 * j68;
        long j70 = j61 * j56;
        long j71 = j63 * j46;
        long j72 = j61 * j35;
        long j73 = j63 * j24;
        long j74 = iArr2[6];
        long j75 = j74 * j2;
        long j76 = j74 * j4;
        long j77 = j74 * j6;
        long j78 = j8 * j74;
        long j79 = i7;
        long j80 = j74 * j79;
        long j81 = j74 * j68;
        long j82 = j74 * j56;
        long j83 = j74 * j46;
        long j84 = j74 * j35;
        long j85 = j74 * j24;
        long j86 = i19;
        long j87 = j86 * j2;
        long j88 = i20;
        long j89 = j88 * j4;
        long j90 = j6 * j86;
        long j91 = i5;
        long j92 = j88 * j91;
        long j93 = j86 * j79;
        long j94 = j88 * j68;
        long j95 = j86 * j56;
        long j96 = j88 * j46;
        long j97 = j86 * j35;
        long j98 = j88 * j24;
        long j99 = iArr2[8];
        long j100 = j99 * j2;
        long j101 = j4 * j99;
        long j102 = i3 * 19;
        long j103 = j99 * j102;
        long j104 = j99 * j91;
        long j105 = j99 * j79;
        long j106 = j99 * j68;
        long j107 = j99 * j56;
        long j108 = j99 * j46;
        long j109 = j99 * j35;
        long j110 = j99 * j24;
        long j111 = i21;
        long j112 = j2 * j111;
        long j113 = i22;
        long j114 = j3 + j25 + j36 + j47 + j57 + j69 + j80 + j92 + j103 + (((long) i2) * j113);
        long j115 = j5 + (j18 * j2) + j37 + j48 + j58 + j70 + j81 + j93 + j104;
        long j116 = j7 + j20 + j27 + (j40 * j24) + j59 + j71 + j82 + j94 + j105;
        long j117 = (j * j8) + (j18 * j6) + j28 + j39 + j60 + j72 + j83 + j95 + j106;
        long j118 = (j * j9) + j21 + j29 + (j40 * j4) + j50 + j73 + j84 + j96 + j107 + (j68 * j113);
        long j119 = (j * j10) + (j18 * j9) + j30 + j41 + j51 + j62 + j85 + j97 + j108;
        long j120 = j14 + (j18 * j11) + j32 + j43 + j53 + j65 + j76 + j87 + j110 + (j111 * j35);
        long j121 = j17 + (j18 * j15) + j34 + j45 + j55 + j67 + j78 + j90 + j101 + j112;
        long j122 = (j114 + 33554432) >> 26;
        long j123 = j115 + (j111 * j102) + j122;
        long j124 = j114 - (j122 << 26);
        long j125 = (j118 + 33554432) >> 26;
        long j126 = j119 + (j111 * j56) + j125;
        long j127 = (j123 + 16777216) >> 25;
        long j128 = j116 + (j91 * j113) + j127;
        long j129 = j123 - (j127 << 25);
        long j130 = (j126 + 16777216) >> 25;
        long j131 = j12 + j22 + j31 + j42 + j52 + j64 + j75 + j98 + j109 + (j46 * j113) + j130;
        long j132 = j126 - (j130 << 25);
        long j133 = (j128 + 33554432) >> 26;
        long j134 = j117 + (j79 * j111) + j133;
        long j135 = (j131 + 33554432) >> 26;
        long j136 = j120 + j135;
        long j137 = (j134 + 16777216) >> 25;
        long j138 = (j118 - (j125 << 26)) + j137;
        long j139 = (j136 + 16777216) >> 25;
        long j140 = j16 + j23 + j33 + j44 + j54 + j66 + j77 + j89 + j100 + (j24 * j113) + j139;
        long j141 = (j138 + 33554432) >> 26;
        long j142 = j132 + j141;
        long j143 = j138 - (j141 << 26);
        long j144 = (j140 + 33554432) >> 26;
        long j145 = j121 + j144;
        long j146 = j140 - (j144 << 26);
        long j147 = (j145 + 16777216) >> 25;
        long j148 = (19 * j147) + j124;
        long j149 = j145 - (j147 << 25);
        long j150 = (j148 + 33554432) >> 26;
        return new Ed25519FieldElement(this.b, new int[]{(int) (j148 - (j150 << 26)), (int) (j129 + j150), (int) (j128 - (j133 << 26)), (int) (j134 - (j137 << 25)), (int) j143, (int) j142, (int) (j131 - (j135 << 26)), (int) (j136 - (j139 << 25)), (int) j146, (int) j149});
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement h() {
        int[] iArr = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr[i] = -this.f[i];
        }
        return new Ed25519FieldElement(this.b, iArr);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f);
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement i() {
        FieldElement fieldElementJ = j();
        FieldElement fieldElementG = g(fieldElementJ.j().j());
        FieldElement fieldElementG2 = fieldElementG.g(fieldElementJ.g(fieldElementG).j());
        FieldElement fieldElementJ2 = fieldElementG2.j();
        for (int i = 1; i < 5; i++) {
            fieldElementJ2 = fieldElementJ2.j();
        }
        FieldElement fieldElementG3 = fieldElementJ2.g(fieldElementG2);
        FieldElement fieldElementJ3 = fieldElementG3.j();
        for (int i2 = 1; i2 < 10; i2++) {
            fieldElementJ3 = fieldElementJ3.j();
        }
        FieldElement fieldElementG4 = fieldElementJ3.g(fieldElementG3);
        FieldElement fieldElementJ4 = fieldElementG4.j();
        for (int i3 = 1; i3 < 20; i3++) {
            fieldElementJ4 = fieldElementJ4.j();
        }
        FieldElement fieldElementJ5 = fieldElementJ4.g(fieldElementG4).j();
        for (int i4 = 1; i4 < 10; i4++) {
            fieldElementJ5 = fieldElementJ5.j();
        }
        FieldElement fieldElementG5 = fieldElementJ5.g(fieldElementG3);
        FieldElement fieldElementJ6 = fieldElementG5.j();
        for (int i5 = 1; i5 < 50; i5++) {
            fieldElementJ6 = fieldElementJ6.j();
        }
        FieldElement fieldElementG6 = fieldElementJ6.g(fieldElementG5);
        FieldElement fieldElementJ7 = fieldElementG6.j();
        for (int i6 = 1; i6 < 100; i6++) {
            fieldElementJ7 = fieldElementJ7.j();
        }
        FieldElement fieldElementJ8 = fieldElementJ7.g(fieldElementG6).j();
        for (int i7 = 1; i7 < 50; i7++) {
            fieldElementJ8 = fieldElementJ8.j();
        }
        return g(fieldElementJ8.g(fieldElementG5).j().j());
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement j() {
        int[] iArr = this.f;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i2 * 2;
        int i12 = i4 * 2;
        int i13 = i6 * 2;
        int i14 = i8 * 2;
        int i15 = i6 * 38;
        int i16 = i8 * 38;
        long j = i;
        long j2 = j * j;
        long j3 = i * 2;
        long j4 = i2;
        long j5 = j3 * j4;
        long j6 = i3;
        long j7 = j3 * j6;
        long j8 = i4;
        long j9 = j3 * j8;
        long j10 = i5;
        long j11 = j3 * j10;
        long j12 = i6;
        long j13 = j3 * j12;
        long j14 = i7;
        long j15 = j3 * j14;
        long j16 = i8;
        long j17 = j3 * j16;
        long j18 = i9;
        long j19 = j3 * j18;
        long j20 = i10;
        long j21 = j3 * j20;
        long j22 = i11;
        long j23 = j4 * j22;
        long j24 = j22 * j6;
        long j25 = i12;
        long j26 = j22 * j25;
        long j27 = j22 * j10;
        long j28 = i13;
        long j29 = j22 * j28;
        long j30 = j22 * j14;
        long j31 = i14;
        long j32 = j22 * j31;
        long j33 = j22 * j18;
        long j34 = i10 * 38;
        long j35 = j22 * j34;
        long j36 = j6 * j6;
        long j37 = i3 * 2;
        long j38 = j37 * j8;
        long j39 = j37 * j10;
        long j40 = j37 * j12;
        long j41 = j37 * j14;
        long j42 = j37 * j16;
        long j43 = i9 * 19;
        long j44 = j37 * j43;
        long j45 = j6 * j34;
        long j46 = j8 * j25;
        long j47 = j25 * j10;
        long j48 = j25 * j28;
        long j49 = j25 * j14;
        long j50 = i16;
        long j51 = j25 * j50;
        long j52 = j25 * j43;
        long j53 = j25 * j34;
        long j54 = j10 * j10;
        long j55 = i5 * 2;
        long j56 = j55 * j12;
        long j57 = i7 * 19;
        long j58 = j10 * j50;
        long j59 = j57 * j14;
        long j60 = j14 * j50;
        long j61 = j2 + j35 + j44 + j51 + (j55 * j57) + (((long) i15) * j12);
        long j62 = j9 + j24 + (j10 * j34) + (j28 * j43) + j60;
        long j63 = j11 + j26 + j36 + (j28 * j34) + (((long) (i7 * 2)) * j43) + (j16 * j50);
        long j64 = (j61 + 33554432) >> 26;
        long j65 = j5 + j45 + j52 + j58 + (j28 * j57) + j64;
        long j66 = j61 - (j64 << 26);
        long j67 = (j63 + 33554432) >> 26;
        long j68 = j13 + j27 + j38 + (j14 * j34) + (j31 * j43) + j67;
        long j69 = (j65 + 16777216) >> 25;
        long j70 = j7 + j23 + j53 + (j55 * j43) + (j28 * j50) + j59 + j69;
        long j71 = j65 - (j69 << 25);
        long j72 = (j68 + 16777216) >> 25;
        long j73 = j15 + j29 + j39 + j46 + (j31 * j34) + (j43 * j18) + j72;
        long j74 = j68 - (j72 << 25);
        long j75 = (j70 + 33554432) >> 26;
        long j76 = j62 + j75;
        long j77 = (j73 + 33554432) >> 26;
        long j78 = j17 + j30 + j40 + j47 + (j18 * j34) + j77;
        long j79 = (j76 + 16777216) >> 25;
        long j80 = (j63 - (j67 << 26)) + j79;
        long j81 = (j78 + 16777216) >> 25;
        long j82 = j19 + j32 + j41 + j48 + j54 + (j20 * j34) + j81;
        long j83 = j78 - (j81 << 25);
        long j84 = (j80 + 33554432) >> 26;
        long j85 = j74 + j84;
        long j86 = j80 - (j84 << 26);
        long j87 = (j82 + 33554432) >> 26;
        long j88 = j21 + j33 + j42 + j49 + j56 + j87;
        long j89 = j82 - (j87 << 26);
        long j90 = (j88 + 16777216) >> 25;
        long j91 = (19 * j90) + j66;
        long j92 = j88 - (j90 << 25);
        long j93 = (j91 + 33554432) >> 26;
        return new Ed25519FieldElement(this.b, new int[]{(int) (j91 - (j93 << 26)), (int) (j71 + j93), (int) (j70 - (j75 << 26)), (int) (j76 - (j79 << 25)), (int) j86, (int) j85, (int) (j73 - (j77 << 26)), (int) j83, (int) j89, (int) j92});
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement k() {
        int[] iArr = this.f;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i2 * 2;
        int i12 = i4 * 2;
        int i13 = i6 * 2;
        int i14 = i8 * 2;
        int i15 = i6 * 38;
        int i16 = i8 * 38;
        long j = i;
        long j2 = j * j;
        long j3 = i * 2;
        long j4 = i2;
        long j5 = j3 * j4;
        long j6 = i3;
        long j7 = j3 * j6;
        long j8 = i4;
        long j9 = j3 * j8;
        long j10 = i5;
        long j11 = j3 * j10;
        long j12 = i6;
        long j13 = j3 * j12;
        long j14 = i7;
        long j15 = j3 * j14;
        long j16 = i8;
        long j17 = j3 * j16;
        long j18 = i9;
        long j19 = j3 * j18;
        long j20 = i10;
        long j21 = j3 * j20;
        long j22 = i11;
        long j23 = j4 * j22;
        long j24 = j22 * j6;
        long j25 = i12;
        long j26 = j22 * j25;
        long j27 = j22 * j10;
        long j28 = i13;
        long j29 = j22 * j28;
        long j30 = j22 * j14;
        long j31 = i14;
        long j32 = j22 * j31;
        long j33 = j22 * j18;
        long j34 = i10 * 38;
        long j35 = j22 * j34;
        long j36 = j6 * j6;
        long j37 = i3 * 2;
        long j38 = j37 * j8;
        long j39 = j37 * j10;
        long j40 = j37 * j12;
        long j41 = j37 * j14;
        long j42 = j37 * j16;
        long j43 = i9 * 19;
        long j44 = j37 * j43;
        long j45 = j6 * j34;
        long j46 = j8 * j25;
        long j47 = j25 * j10;
        long j48 = j25 * j28;
        long j49 = j25 * j14;
        long j50 = i16;
        long j51 = j25 * j50;
        long j52 = j25 * j43;
        long j53 = j25 * j34;
        long j54 = j10 * j10;
        long j55 = i5 * 2;
        long j56 = j55 * j12;
        long j57 = i7 * 19;
        long j58 = j10 * j50;
        long j59 = j57 * j14;
        long j60 = j14 * j50;
        long j61 = j2 + j35 + j44 + j51 + (j55 * j57) + (((long) i15) * j12);
        long j62 = j5 + j45 + j52 + j58 + (j28 * j57);
        long j63 = j7 + j23 + j53 + (j55 * j43) + (j28 * j50) + j59;
        long j64 = j9 + j24 + (j10 * j34) + (j28 * j43) + j60;
        long j65 = j11 + j26 + j36 + (j28 * j34) + (((long) (i7 * 2)) * j43) + (j16 * j50);
        long j66 = j13 + j27 + j38 + (j14 * j34) + (j31 * j43);
        long j67 = j15 + j29 + j39 + j46 + (j31 * j34) + (j43 * j18);
        long j68 = j17 + j30 + j40 + j47 + (j18 * j34);
        long j69 = j19 + j32 + j41 + j48 + j54 + (j20 * j34);
        long j70 = j21 + j33 + j42 + j49 + j56;
        long j71 = j61 + j61;
        long j72 = j65 + j65;
        long j73 = (j71 + 33554432) >> 26;
        long j74 = j62 + j62 + j73;
        long j75 = j71 - (j73 << 26);
        long j76 = (j72 + 33554432) >> 26;
        long j77 = j66 + j66 + j76;
        long j78 = (j74 + 16777216) >> 25;
        long j79 = j63 + j63 + j78;
        long j80 = j74 - (j78 << 25);
        long j81 = (j77 + 16777216) >> 25;
        long j82 = j67 + j67 + j81;
        long j83 = j77 - (j81 << 25);
        long j84 = (j79 + 33554432) >> 26;
        long j85 = j64 + j64 + j84;
        long j86 = (j82 + 33554432) >> 26;
        long j87 = j68 + j68 + j86;
        long j88 = (j85 + 16777216) >> 25;
        long j89 = (j72 - (j76 << 26)) + j88;
        long j90 = (j87 + 16777216) >> 25;
        long j91 = j69 + j69 + j90;
        long j92 = j87 - (j90 << 25);
        long j93 = (j89 + 33554432) >> 26;
        long j94 = j83 + j93;
        long j95 = j89 - (j93 << 26);
        long j96 = (j91 + 33554432) >> 26;
        long j97 = j70 + j70 + j96;
        long j98 = j91 - (j96 << 26);
        long j99 = (j97 + 16777216) >> 25;
        long j100 = (19 * j99) + j75;
        long j101 = j97 - (j99 << 25);
        long j102 = (j100 + 33554432) >> 26;
        return new Ed25519FieldElement(this.b, new int[]{(int) (j100 - (j102 << 26)), (int) (j80 + j102), (int) (j79 - (j84 << 26)), (int) (j85 - (j88 << 25)), (int) j95, (int) j94, (int) (j82 - (j86 << 26)), (int) j92, (int) j98, (int) j101});
    }

    @Override // net.i2p.crypto.eddsa.math.FieldElement
    public final FieldElement l(FieldElement fieldElement) {
        int[] iArr = ((Ed25519FieldElement) fieldElement).f;
        int[] iArr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr2[i] = this.f[i] - iArr[i];
        }
        return new Ed25519FieldElement(this.b, iArr2);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[Ed25519FieldElement val=");
        byte[] bArrC = this.b.X.c(this);
        StringBuilder sb2 = new StringBuilder(64);
        for (int i = 0; i < 32; i++) {
            byte b = bArrC[i];
            sb2.append(Character.forDigit((b & 240) >> 4, 16));
            sb2.append(Character.forDigit(b & 15, 16));
        }
        sb.append(sb2.toString());
        sb.append("]");
        return sb.toString();
    }
}
