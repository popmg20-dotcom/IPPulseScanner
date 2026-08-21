package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class dn {
    public static final int b;
    public final int[] a = new int[8];

    static {
        int i = 32;
        int i2 = 0;
        while (true) {
            i >>>= 1;
            if (i == 0) {
                b = i2;
                return;
            }
            i2++;
        }
    }

    public final boolean a(int i) {
        return (this.a[i >>> b] & (1 << (i % 256))) != 0;
    }

    public final void b(int i) {
        int i2 = i >>> b;
        int[] iArr = this.a;
        iArr[i2] = (~(1 << (i % 256))) & iArr[i2];
    }

    public final void c() {
        for (int i = 0; i < 8; i++) {
            int[] iArr = this.a;
            iArr[i] = ~iArr[i];
        }
    }

    public final void d(dn dnVar) {
        for (int i = 0; i < 8; i++) {
            dnVar.a[i] = ~this.a[i];
        }
    }

    public final boolean e() {
        for (int i = 0; i < 8; i++) {
            if (this.a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public final int f() {
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (a(i2)) {
                i++;
            }
        }
        return i;
    }

    public final void g(int i) {
        int i2 = i >>> b;
        int[] iArr = this.a;
        iArr[i2] = (1 << (i % 256)) | iArr[i2];
    }

    public final void h(up3 up3Var, int i) {
        if (a(i)) {
            up3Var.b();
        }
        g(i);
    }

    public final void i(up3 up3Var, int i, int i2) {
        while (i <= i2 && i < 256) {
            if (up3Var != null && a(i)) {
                up3Var.b();
            }
            g(i);
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BitSet");
        for (int i = 0; i < 256; i++) {
            if (i % 64 == 0) {
                sb.append("\n  ");
            }
            sb.append(a(i) ? "1" : "0");
        }
        return sb.toString();
    }
}
