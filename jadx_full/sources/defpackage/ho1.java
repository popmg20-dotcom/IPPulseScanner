package defpackage;

import io.netty.util.internal.StringUtil;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ho1 {
    public static final ho1 h = new ho1(4201, 4096, 1);
    public static final ho1 i = new ho1(1033, 1024, 1);
    public static final ho1 j;
    public static final ho1 k;
    public static final ho1 l;
    public static final ho1 m;
    public static final ho1 n;
    public static final ho1 o;
    public final int[] a;
    public final int[] b;
    public final io1 c;
    public final io1 d;
    public final int e;
    public final int f;
    public final int g;

    static {
        ho1 ho1Var = new ho1(67, 64, 1);
        j = ho1Var;
        k = new ho1(19, 16, 1);
        l = new ho1(285, 256, 0);
        ho1 ho1Var2 = new ho1(301, 256, 1);
        m = ho1Var2;
        n = ho1Var2;
        o = ho1Var;
    }

    public ho1(int i2, int i3, int i4) {
        this.f = i2;
        this.e = i3;
        this.g = i4;
        this.a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.a[i7]] = i7;
        }
        this.c = new io1(this, new int[]{0});
        this.d = new io1(this, new int[]{1});
    }

    public final io1 a(int i2, int i3) {
        if (i2 < 0) {
            s53.d();
            return null;
        }
        if (i3 == 0) {
            return this.c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new io1(this, iArr);
    }

    public final int b(int i2) {
        if (i2 == 0) {
            throw new ArithmeticException();
        }
        return this.a[(this.e - this.b[i2]) - 1];
    }

    public final int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.b;
        return this.a[(iArr[i2] + iArr[i3]) % (this.e - 1)];
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f));
        sb.append(StringUtil.COMMA);
        return ha0.p(sb, this.e, ')');
    }
}
