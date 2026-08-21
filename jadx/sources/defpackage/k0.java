package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k0 implements Cloneable {
    public boolean A = false;
    public int X;
    public String Y;
    public final short[] Z;
    public final int b;
    public final int f;
    public final boolean z;

    public k0(String str, int i, int i2, short[] sArr) {
        boolean z = false;
        byte[] bytes = str.getBytes();
        this.X = du.d(0, bytes.length, bytes);
        this.Y = str;
        this.b = i;
        this.f = i2;
        if (i == i2 && i == 1) {
            z = true;
        }
        this.z = z;
        this.Z = sArr;
    }

    public static void b(v92 v92Var) {
        int[] iArr = {0};
        int i = 0;
        while (true) {
            int[][] iArr2 = ek0.c;
            if (i >= 26) {
                return;
            }
            int[] iArr3 = iArr2[i];
            iArr[0] = iArr3[1];
            k01.j(iArr3[0], iArr, 1, v92Var);
            int[] iArr4 = iArr2[i];
            iArr[0] = iArr4[0];
            k01.j(iArr4[1], iArr, 1, v92Var);
            i++;
        }
    }

    public static g20[] c(int i, byte[] bArr) {
        int i2 = bArr[i] & 255;
        return (65 > i2 || i2 > 90) ? (97 > i2 || i2 > 122) ? g20.A : new g20[]{g20.g(1, i2 - 32)} : new g20[]{g20.g(1, i2 + 32)};
    }

    public static void d(byte[] bArr, ue2 ue2Var, byte[] bArr2) {
        byte[] bArr3 = ek0.b;
        int i = ue2Var.b;
        bArr2[0] = bArr3[bArr[i] & 255];
        ue2Var.b = i + 1;
    }

    public static boolean i(int i) {
        return i < 128;
    }

    public static boolean p(int i) {
        return i == 12 || i == 5 || i == 7;
    }

    public final int A(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int i4 = 0;
        while (true) {
            int i5 = i3 - 1;
            if (i3 <= 0) {
                return 0;
            }
            if (i >= i2) {
                return bArr2[i4];
            }
            int iU = bArr2[i4] - u(i, i2, bArr);
            if (iU != 0) {
                return iU;
            }
            i4++;
            i += r(i, i2, bArr);
            i3 = i5;
        }
    }

    public byte[] B() {
        return null;
    }

    public void a(int i, v92 v92Var) {
        b(v92Var);
    }

    public g20[] e(int i, byte[] bArr, int i2, int i3) {
        return c(i2, bArr);
    }

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public abstract int f(int i, int i2, byte[] bArr);

    public abstract int g(int i);

    public abstract int[] h(int i, b7 b7Var);

    public final int hashCode() {
        return this.X;
    }

    public abstract boolean j(int i, int i2);

    public final boolean k(int i, int i2) {
        return (this.Z[i] & (1 << i2)) != 0;
    }

    public final boolean l(int i, int i2, byte[] bArr) {
        return j(u(i, i2, bArr), 12);
    }

    public boolean m(int i, int i2, byte[] bArr) {
        return i < i2 && bArr[i] == 10;
    }

    public abstract boolean n(byte[] bArr);

    public final boolean o(int i) {
        return i(i) && j(i, 12);
    }

    public abstract int q(int i, int i2, int i3, byte[] bArr);

    public abstract int r(int i, int i2, byte[] bArr);

    public int t(int i, byte[] bArr, ue2 ue2Var, int i2, byte[] bArr2) {
        d(bArr, ue2Var, bArr2);
        return 1;
    }

    public final String toString() {
        return this.Y;
    }

    public abstract int u(int i, int i2, byte[] bArr);

    public final int v(int i, int i2, int i3, byte[] bArr) {
        if (i2 <= i) {
            return -1;
        }
        return q(i, i2 - 1, i3, bArr);
    }

    public int w(byte[] bArr, int i, int i2) {
        Integer num = (Integer) j23.c.b(i, i2, bArr);
        if (num != null) {
            return num.intValue();
        }
        du duVar = q41.f;
        throw new w30(i, i2 - i, bArr);
    }

    public final k0 x(byte[] bArr) {
        try {
            k0 k0Var = (k0) clone();
            k0Var.getClass();
            k0Var.X = du.d(0, bArr.length, bArr);
            k0Var.Y = new String(bArr);
            return k0Var;
        } catch (CloneNotSupportedException unused) {
            du duVar = q41.f;
            new String(bArr);
            throw new r41("could not replicate <%n> encoding");
        }
    }

    public final int y(int i, int i2, int i3, byte[] bArr) {
        while (i != -1) {
            int i4 = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            if (i <= 0) {
                return -1;
            }
            i = q(0, i - 1, i2, bArr);
            i3 = i4;
        }
        return i;
    }

    public abstract int z(int i, int i2, byte[] bArr);
}
