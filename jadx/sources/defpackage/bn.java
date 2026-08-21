package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bn implements Cloneable {
    public static final int[] z = new int[0];
    public int[] b;
    public int f;

    public bn(int i) {
        this.f = i;
        this.b = new int[(i + 31) / 32];
    }

    public final void a(boolean z2) {
        c(this.f + 1);
        if (z2) {
            int[] iArr = this.b;
            int i = this.f;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f++;
    }

    public final void b(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            xe.k("Num bits must be between 0 and 32");
            return;
        }
        int i3 = this.f;
        c(i3 + i2);
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            if (((1 << i4) & i) != 0) {
                int[] iArr = this.b;
                int i5 = i3 / 32;
                iArr[i5] = iArr[i5] | (1 << (i3 & 31));
            }
            i3++;
        }
        this.f = i3;
    }

    public final void c(int i) {
        if (i > this.b.length * 32) {
            int[] iArr = new int[(((int) Math.ceil(i / 0.75f)) + 31) / 32];
            int[] iArr2 = this.b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            this.b = iArr;
        }
    }

    public final Object clone() {
        int[] iArr = (int[]) this.b.clone();
        int i = this.f;
        bn bnVar = new bn();
        bnVar.b = iArr;
        bnVar.f = i;
        return bnVar;
    }

    public final boolean d(int i) {
        return (this.b[i / 32] & (1 << (i & 31))) != 0;
    }

    public final int e(int i) {
        int i2 = this.f;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & this.b[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.b;
            if (i3 == iArr.length) {
                return this.f;
            }
            i4 = iArr[i3];
        }
        return Math.min(Integer.numberOfTrailingZeros(i4) + (i3 * 32), this.f);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bn)) {
            return false;
        }
        bn bnVar = (bn) obj;
        return this.f == bnVar.f && Arrays.equals(this.b, bnVar.b);
    }

    public final int f(int i) {
        int i2 = this.f;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & (~this.b[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.b;
            if (i3 == iArr.length) {
                return this.f;
            }
            i4 = ~iArr[i3];
        }
        return Math.min(Integer.numberOfTrailingZeros(i4) + (i3 * 32), this.f);
    }

    public final int g() {
        return (this.f + 7) / 8;
    }

    public final boolean h(int i, int i2) {
        if (i2 < i || i < 0 || i2 > this.f) {
            s53.d();
            return false;
        }
        if (i2 != i) {
            int i3 = i2 - 1;
            int i4 = i / 32;
            int i5 = i3 / 32;
            int i6 = i4;
            while (i6 <= i5) {
                if ((((2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i & 31))) & this.b[i6]) != 0) {
                    return false;
                }
                i6++;
            }
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.b) + (this.f * 31);
    }

    public final void i() {
        int[] iArr = new int[this.b.length];
        int i = (this.f - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i - i3] = Integer.reverse(this.b[i3]);
        }
        int i4 = this.f;
        int i5 = i2 * 32;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i] = i7;
        }
        this.b = iArr;
    }

    public final void j(int i) {
        int[] iArr = this.b;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public final String toString() {
        int i = this.f;
        StringBuilder sb = new StringBuilder((i / 8) + i + 1);
        for (int i2 = 0; i2 < this.f; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(d(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public bn() {
        this.f = 0;
        this.b = z;
    }
}
