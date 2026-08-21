package defpackage;

import io.netty.handler.ssl.OpenSslSessionTicketKey;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class zz0 extends nk4 {
    public static final int[] j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};
    public static final int[] k = {1, 1, 1, 1, 1, 1};
    public static final int[][] l = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    public final /* synthetic */ int h;
    public final int[] i;

    public zz0(int i) {
        this.h = i;
        switch (i) {
            case 1:
                this.i = new int[4];
                break;
            case 2:
                this.i = new int[4];
                break;
            default:
                this.i = new int[4];
                break;
        }
    }

    @Override // defpackage.nk4
    public boolean f(String str) {
        switch (this.h) {
            case 1:
                char[] cArr = new char[6];
                str.getChars(1, 7, cArr, 0);
                StringBuilder sb = new StringBuilder(12);
                sb.append(str.charAt(0));
                char c = cArr[5];
                switch (c) {
                    case OpenSslSessionTicketKey.TICKET_KEY_SIZE /* 48 */:
                    case '1':
                    case '2':
                        sb.append(cArr, 0, 2);
                        sb.append(c);
                        sb.append("0000");
                        sb.append(cArr, 2, 3);
                        break;
                    case '3':
                        sb.append(cArr, 0, 3);
                        sb.append("00000");
                        sb.append(cArr, 3, 2);
                        break;
                    case '4':
                        sb.append(cArr, 0, 4);
                        sb.append("00000");
                        sb.append(cArr[4]);
                        break;
                    default:
                        sb.append(cArr, 0, 5);
                        sb.append("0000");
                        sb.append(c);
                        break;
                }
                if (str.length() >= 8) {
                    sb.append(str.charAt(7));
                }
                return super.f(sb.toString());
            default:
                return super.f(str);
        }
    }

    @Override // defpackage.nk4
    public int[] h(bn bnVar, int i) {
        switch (this.h) {
            case 1:
                return nk4.k(bnVar, i, true, k, new int[6]);
            default:
                return super.h(bnVar, i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.nk4
    public final int i(bn bnVar, int[] iArr, StringBuilder sb) throws qs2 {
        int i = this.h;
        int[][] iArr2 = nk4.g;
        int[] iArr3 = nk4.e;
        int[][] iArr4 = nk4.f;
        int i2 = 1;
        int[] iArr5 = this.i;
        switch (i) {
            case 0:
                iArr5[0] = 0;
                iArr5[1] = 0;
                iArr5[2] = 0;
                iArr5[3] = 0;
                int i3 = bnVar.f;
                int i4 = iArr[1];
                int i5 = 0;
                int i6 = 0;
                for (int i7 = 6; i5 < i7 && i4 < i3; i7 = 6) {
                    int iG = nk4.g(bnVar, iArr5, i4, iArr2);
                    sb.append((char) ((iG % 10) + 48));
                    int i8 = i2;
                    for (int i9 : iArr5) {
                        i4 += i9;
                    }
                    if (iG >= 10) {
                        i6 |= i8 << (5 - i5);
                    }
                    i5++;
                    i2 = i8;
                }
                boolean z = i2;
                for (int i10 = 0; i10 < 10; i10++) {
                    if (i6 == j[i10]) {
                        sb.insert(0, (char) (i10 + 48));
                        int i11 = nk4.k(bnVar, i4, z, iArr3, new int[5])[z ? 1 : 0];
                        for (int i12 = 0; i12 < 6 && i11 < i3; i12++) {
                            sb.append((char) (nk4.g(bnVar, iArr5, i11, iArr4) + 48));
                            for (int i13 : iArr5) {
                                i11 += i13;
                            }
                        }
                        return i11;
                    }
                }
                throw qs2.a();
            case 1:
                iArr5[0] = 0;
                iArr5[1] = 0;
                iArr5[2] = 0;
                iArr5[3] = 0;
                int i14 = bnVar.f;
                int i15 = iArr[1];
                int i16 = 0;
                for (int i17 = 0; i17 < 6 && i15 < i14; i17++) {
                    int iG2 = nk4.g(bnVar, iArr5, i15, iArr2);
                    sb.append((char) ((iG2 % 10) + 48));
                    for (int i18 : iArr5) {
                        i15 += i18;
                    }
                    if (iG2 >= 10) {
                        i16 |= 1 << (5 - i17);
                    }
                }
                for (int i19 = 0; i19 <= 1; i19++) {
                    for (int i20 = 0; i20 < 10; i20++) {
                        if (i16 == l[i19][i20]) {
                            sb.insert(0, (char) (i19 + 48));
                            sb.append((char) (i20 + 48));
                            return i15;
                        }
                    }
                }
                throw qs2.a();
            default:
                iArr5[0] = 0;
                iArr5[1] = 0;
                iArr5[2] = 0;
                iArr5[3] = 0;
                int i21 = bnVar.f;
                int i22 = iArr[1];
                for (int i23 = 0; i23 < 4 && i22 < i21; i23++) {
                    sb.append((char) (nk4.g(bnVar, iArr5, i22, iArr4) + 48));
                    for (int i24 : iArr5) {
                        i22 += i24;
                    }
                }
                int i25 = nk4.k(bnVar, i22, true, iArr3, new int[5])[1];
                for (int i26 = 0; i26 < 4 && i25 < i21; i26++) {
                    sb.append((char) (nk4.g(bnVar, iArr5, i25, iArr4) + 48));
                    for (int i27 : iArr5) {
                        i25 += i27;
                    }
                }
                return i25;
        }
    }

    @Override // defpackage.nk4
    public final sj m() {
        switch (this.h) {
            case 0:
                return sj.y0;
            case 1:
                return sj.G0;
            default:
                return sj.Z;
        }
    }
}
