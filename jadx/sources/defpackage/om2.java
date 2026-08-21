package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class om2 {
    public static final om2 e = new om2();
    public final int[] a = new int[929];
    public final int[] b = new int[929];
    public final v62 c;
    public final v62 d;

    public om2() {
        int i = 1;
        for (int i2 = 0; i2 < 929; i2++) {
            this.a[i2] = i;
            i = (i * 3) % 929;
        }
        for (int i3 = 0; i3 < 928; i3++) {
            this.b[this.a[i3]] = i3;
        }
        this.c = new v62(this, new int[]{0});
        this.d = new v62(this, new int[]{1});
    }

    public final int a(int i, int i2) {
        return (i + i2) % 929;
    }

    public final int b(int i) {
        if (i == 0) {
            throw new ArithmeticException();
        }
        return this.a[928 - this.b[i]];
    }

    public final int c(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.b;
        return this.a[(iArr[i] + iArr[i2]) % 928];
    }
}
