package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class fe5 {
    public static final fe5 f = new fe5(0, new int[0], new Object[0], false);
    public int a;
    public int[] b;
    public Object[] c;
    public int d = -1;
    public boolean e;

    public fe5(int i, int[] iArr, Object[] objArr, boolean z) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
        this.e = z;
    }

    public static fe5 a() {
        return new fe5(0, new int[8], new Object[8], true);
    }

    public final void b(ub4 ub4Var) throws a60 {
        if (this.a != 0) {
            for (int i = 0; i < this.a; i++) {
                int i2 = this.b[i];
                Object obj = this.c[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    ((kb5) ub4Var.b).g(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    ((kb5) ub4Var.b).h(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    kb5 kb5Var = (kb5) ub4Var.b;
                    kb5Var.l((i4 << 3) | 2);
                    kb5Var.i((hb5) obj);
                } else if (i3 == 3) {
                    ((kb5) ub4Var.b).c(i4, 3);
                    ((fe5) obj).b(ub4Var);
                    ((kb5) ub4Var.b).c(i4, 4);
                } else {
                    if (i3 != 5) {
                        vp1.p(new oc5());
                        return;
                    }
                    ((kb5) ub4Var.b).f(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final int c() {
        int iR;
        int iA;
        int iR2;
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int iP = 0;
        for (int i2 = 0; i2 < this.a; i2++) {
            int i3 = this.b[i2];
            int i4 = i3 >>> 3;
            int i5 = i3 & 7;
            if (i5 != 0) {
                if (i5 == 1) {
                    ((Long) this.c[i2]).getClass();
                    iR2 = kb5.r(i4 << 3) + 8;
                } else if (i5 == 2) {
                    int i6 = i4 << 3;
                    hb5 hb5Var = (hb5) this.c[i2];
                    int iR3 = kb5.r(i6);
                    int iC = hb5Var.c();
                    iP = qe4.p(iC, iC, iR3, iP);
                } else if (i5 == 3) {
                    int iR4 = kb5.r(i4 << 3);
                    iR = iR4 + iR4;
                    iA = ((fe5) this.c[i2]).c();
                } else {
                    if (i5 != 5) {
                        zo2.q(new oc5());
                        return 0;
                    }
                    ((Integer) this.c[i2]).getClass();
                    iR2 = kb5.r(i4 << 3) + 4;
                }
                iP = iR2 + iP;
            } else {
                int i7 = i4 << 3;
                long jLongValue = ((Long) this.c[i2]).longValue();
                iR = kb5.r(i7);
                iA = kb5.a(jLongValue);
            }
            iP = iA + iR + iP;
        }
        this.d = iP;
        return iP;
    }

    public final void d(int i, Object obj) {
        if (!this.e) {
            vp1.q();
            return;
        }
        e(this.a + 1);
        int[] iArr = this.b;
        int i2 = this.a;
        iArr[i2] = i;
        this.c[i2] = obj;
        this.a = i2 + 1;
    }

    public final void e(int i) {
        int[] iArr = this.b;
        if (i > iArr.length) {
            int i2 = this.a;
            int i3 = (i2 / 2) + i2;
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.b = Arrays.copyOf(iArr, i);
            this.c = Arrays.copyOf(this.c, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof fe5)) {
            fe5 fe5Var = (fe5) obj;
            int i = this.a;
            if (i == fe5Var.a) {
                int[] iArr = this.b;
                int[] iArr2 = fe5Var.b;
                int i2 = 0;
                while (true) {
                    if (i2 >= i) {
                        Object[] objArr = this.c;
                        Object[] objArr2 = fe5Var.c;
                        int i3 = this.a;
                        for (int i4 = 0; i4 < i3; i4++) {
                            if (objArr[i4].equals(objArr2[i4])) {
                            }
                        }
                        return true;
                    }
                    if (iArr[i2] != iArr2[i2]) {
                        break;
                    }
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.a;
        int i2 = i + 527;
        int[] iArr = this.b;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int iP = fw.p(i2, 31, i3, 31);
        Object[] objArr = this.c;
        int i5 = this.a;
        for (int i6 = 0; i6 < i5; i6++) {
            iHashCode = (iHashCode * 31) + objArr[i6].hashCode();
        }
        return iP + iHashCode;
    }
}
