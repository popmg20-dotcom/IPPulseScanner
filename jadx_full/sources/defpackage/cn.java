package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class cn implements Cloneable {
    public int[] A;
    public int b;
    public int f;
    public int z;

    public cn(int i, int i2) {
        if (i < 1 || i2 < 1) {
            xe.k("Both dimensions must be greater than 0");
            throw null;
        }
        this.b = i;
        this.f = i2;
        int i3 = (i + 31) / 32;
        this.z = i3;
        this.A = new int[i3 * i2];
    }

    public final void a(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.z);
        int[] iArr = this.A;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public final boolean b(int i, int i2) {
        return ((this.A[(i / 32) + (i2 * this.z)] >>> (i & 31)) & 1) != 0;
    }

    public final bn c(bn bnVar, int i) {
        int i2 = bnVar.f;
        int i3 = this.b;
        if (i2 < i3) {
            bnVar = new bn(i3);
        } else {
            int length = bnVar.b.length;
            for (int i4 = 0; i4 < length; i4++) {
                bnVar.b[i4] = 0;
            }
        }
        int i5 = i * this.z;
        for (int i6 = 0; i6 < this.z; i6++) {
            bnVar.b[(i6 * 32) / 32] = this.A[i5 + i6];
        }
        return bnVar;
    }

    public final Object clone() {
        int i = this.b;
        int i2 = this.f;
        int i3 = this.z;
        int[] iArr = (int[]) this.A.clone();
        cn cnVar = new cn();
        cnVar.b = i;
        cnVar.f = i2;
        cnVar.z = i3;
        cnVar.A = iArr;
        return cnVar;
    }

    public final void d() {
        bn bnVar = new bn(this.b);
        bn bnVar2 = new bn(this.b);
        int i = (this.f + 1) / 2;
        for (int i2 = 0; i2 < i; i2++) {
            bnVar = c(bnVar, i2);
            int i3 = (this.f - 1) - i2;
            bnVar2 = c(bnVar2, i3);
            bnVar.i();
            bnVar2.i();
            int[] iArr = bnVar2.b;
            int[] iArr2 = this.A;
            int i4 = this.z;
            System.arraycopy(iArr, 0, iArr2, i2 * i4, i4);
            int[] iArr3 = bnVar.b;
            int[] iArr4 = this.A;
            int i5 = this.z;
            System.arraycopy(iArr3, 0, iArr4, i3 * i5, i5);
        }
    }

    public final void e() {
        int i = this.f;
        int i2 = this.b;
        int i3 = (i + 31) / 32;
        int[] iArr = new int[i3 * i2];
        for (int i4 = 0; i4 < this.f; i4++) {
            for (int i5 = 0; i5 < this.b; i5++) {
                if (((this.A[(i5 / 32) + (this.z * i4)] >>> (i5 & 31)) & 1) != 0) {
                    int i6 = (i4 / 32) + (((i2 - 1) - i5) * i3);
                    iArr[i6] = iArr[i6] | (1 << (i4 & 31));
                }
            }
        }
        this.b = i;
        this.f = i2;
        this.z = i3;
        this.A = iArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof cn)) {
            return false;
        }
        cn cnVar = (cn) obj;
        return this.b == cnVar.b && this.f == cnVar.f && this.z == cnVar.z && Arrays.equals(this.A, cnVar.A);
    }

    public final void f(int i, int i2) {
        int i3 = (i / 32) + (i2 * this.z);
        int[] iArr = this.A;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public final void g(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            xe.k("Left and top must be nonnegative");
            return;
        }
        if (i4 < 1 || i3 < 1) {
            xe.k("Height and width must be at least 1");
            return;
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.f || i5 > this.b) {
            xe.k("The region must fit inside the matrix");
            return;
        }
        while (i2 < i6) {
            int i7 = this.z * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.A;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public final int hashCode() {
        int i = this.b;
        return Arrays.hashCode(this.A) + ((((fw.p(i, 31, i, 31) + this.f) * 31) + this.z) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.b + 1) * this.f);
        for (int i = 0; i < this.f; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                sb.append(b(i2, i) ? "X " : "  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
