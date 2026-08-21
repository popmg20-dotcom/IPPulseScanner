package defpackage;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ur3 extends bu {
    public final transient byte[][] X;
    public final transient int[] Y;

    public ur3(byte[][] bArr, int[] iArr) {
        super(bu.A.b);
        this.X = bArr;
        this.Y = iArr;
    }

    @Override // defpackage.bu
    public final String a() {
        return u().a();
    }

    @Override // defpackage.bu
    public final bu c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.X;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.Y;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(bArr[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest.getClass();
        return new bu(bArrDigest);
    }

    @Override // defpackage.bu
    public final int d() {
        return this.Y[this.X.length - 1];
    }

    @Override // defpackage.bu
    public final String e() {
        return u().e();
    }

    @Override // defpackage.bu
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof bu) {
            bu buVar = (bu) obj;
            if (buVar.d() == d() && m(0, buVar, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.bu
    public final int f(int i, byte[] bArr) {
        bArr.getClass();
        return u().f(i, bArr);
    }

    @Override // defpackage.bu
    public final byte[] h() {
        return t();
    }

    @Override // defpackage.bu
    public final int hashCode() {
        int i = this.f;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.X;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.Y;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr2 = bArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.f = i3;
        return i3;
    }

    @Override // defpackage.bu
    public final byte i(int i) {
        byte[][] bArr = this.X;
        int length = bArr.length - 1;
        int[] iArr = this.Y;
        l72.f(iArr[length], i, 1L);
        int iR = n12.R(this, i);
        return bArr[iR][(i - (iR == 0 ? 0 : iArr[iR - 1])) + iArr[bArr.length + iR]];
    }

    @Override // defpackage.bu
    public final int j(byte[] bArr) {
        bArr.getClass();
        return u().j(bArr);
    }

    @Override // defpackage.bu
    public final boolean l(int i, int i2, int i3, byte[] bArr) {
        bArr.getClass();
        if (i >= 0 && i <= d() - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
            int i4 = i3 + i;
            int iR = n12.R(this, i);
            while (i < i4) {
                int[] iArr = this.Y;
                int i5 = iR == 0 ? 0 : iArr[iR - 1];
                int i6 = iArr[iR] - i5;
                byte[][] bArr2 = this.X;
                int i7 = iArr[bArr2.length + iR];
                int iMin = Math.min(i4, i6 + i5) - i;
                if (l72.b(bArr2[iR], (i - i5) + i7, i2, bArr, iMin)) {
                    i2 += iMin;
                    i += iMin;
                    iR++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.bu
    public final boolean m(int i, bu buVar, int i2) {
        buVar.getClass();
        if (i >= 0 && i <= d() - i2) {
            int i3 = i2 + i;
            int iR = n12.R(this, i);
            int i4 = 0;
            while (i < i3) {
                int[] iArr = this.Y;
                int i5 = iR == 0 ? 0 : iArr[iR - 1];
                int i6 = iArr[iR] - i5;
                byte[][] bArr = this.X;
                int i7 = iArr[bArr.length + iR];
                int iMin = Math.min(i3, i6 + i5) - i;
                if (buVar.l(i4, (i - i5) + i7, iMin, bArr[iR])) {
                    i4 += iMin;
                    i += iMin;
                    iR++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.bu
    public final String n(Charset charset) {
        charset.getClass();
        return u().n(charset);
    }

    @Override // defpackage.bu
    public final bu o(int i, int i2) {
        if (i2 == -1234567890) {
            i2 = d();
        }
        if (i < 0) {
            e04.f(ha0.k("beginIndex=", i, " < 0"));
            return null;
        }
        if (i2 > d()) {
            StringBuilder sbD = dw2.D("endIndex=", i2, " > length(");
            sbD.append(d());
            sbD.append(')');
            throw new IllegalArgumentException(sbD.toString().toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            e04.f(fw.s(i2, i, "endIndex=", " < beginIndex="));
            return null;
        }
        if (i == 0 && i2 == d()) {
            return this;
        }
        if (i == i2) {
            return bu.A;
        }
        int iR = n12.R(this, i);
        int iR2 = n12.R(this, i2 - 1);
        byte[][] bArr = this.X;
        byte[][] bArr2 = (byte[][]) qe.i0(bArr, iR, iR2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.Y;
        if (iR <= iR2) {
            int i4 = iR;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(iArr2[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr2.length] = iArr2[bArr.length + i4];
                if (i4 == iR2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iR != 0 ? iArr2[iR - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i - i7) + iArr[length];
        return new ur3(bArr2, iArr);
    }

    @Override // defpackage.bu
    public final bu q() {
        return u().q();
    }

    @Override // defpackage.bu
    public final void s(hp hpVar, int i) {
        int iR = n12.R(this, 0);
        int i2 = 0;
        while (i2 < i) {
            int[] iArr = this.Y;
            int i3 = iR == 0 ? 0 : iArr[iR - 1];
            int i4 = iArr[iR] - i3;
            byte[][] bArr = this.X;
            int i5 = iArr[bArr.length + iR];
            int iMin = Math.min(i, i4 + i3) - i2;
            int i6 = (i2 - i3) + i5;
            rr3 rr3Var = new rr3(bArr[iR], i6, i6 + iMin, true);
            rr3 rr3Var2 = hpVar.b;
            if (rr3Var2 == null) {
                rr3Var.g = rr3Var;
                rr3Var.f = rr3Var;
                hpVar.b = rr3Var;
            } else {
                rr3 rr3Var3 = rr3Var2.g;
                rr3Var3.getClass();
                rr3Var3.b(rr3Var);
            }
            i2 += iMin;
            iR++;
        }
        hpVar.f += (long) i;
    }

    public final byte[] t() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.X;
        int length = bArr2.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.Y;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            qe.d0(bArr2[i], i3, i4, bArr, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // defpackage.bu
    public final String toString() {
        return u().toString();
    }

    public final bu u() {
        return new bu(t());
    }
}
