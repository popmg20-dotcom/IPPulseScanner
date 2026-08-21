package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class ff2 implements Cloneable {
    public /* synthetic */ int A;
    public /* synthetic */ boolean b;
    public /* synthetic */ long[] f;
    public /* synthetic */ Object[] z;

    public ff2() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.f = new long[i4];
        this.z = new Object[i4];
    }

    public final void a(Long l, long j) {
        int i = this.A;
        if (i != 0 && j <= this.f[i - 1]) {
            h(j, l);
            return;
        }
        if (this.b) {
            long[] jArr = this.f;
            if (i >= jArr.length) {
                Object[] objArr = this.z;
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    Object obj = objArr[i3];
                    if (obj != gb4.e) {
                        if (i3 != i2) {
                            jArr[i2] = jArr[i3];
                            objArr[i2] = obj;
                            objArr[i3] = null;
                        }
                        i2++;
                    }
                }
                this.b = false;
                this.A = i2;
                i = i2;
            }
        }
        if (i >= this.f.length) {
            int i4 = (i + 1) * 8;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 8;
            this.f = Arrays.copyOf(this.f, i7);
            this.z = Arrays.copyOf(this.z, i7);
        }
        this.f[i] = j;
        this.z[i] = l;
        this.A = i + 1;
    }

    public final void b() {
        int i = this.A;
        Object[] objArr = this.z;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.A = 0;
        this.b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final ff2 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        ff2 ff2Var = (ff2) objClone;
        ff2Var.f = (long[]) this.f.clone();
        ff2Var.z = (Object[]) this.z.clone();
        return ff2Var;
    }

    public final Object d(long j) {
        Object obj;
        int iC = co4.c(this.f, this.A, j);
        if (iC < 0 || (obj = this.z[iC]) == gb4.e) {
            return null;
        }
        return obj;
    }

    public final Object e(long j) {
        Object obj;
        int iC = co4.c(this.f, this.A, j);
        if (iC < 0 || (obj = this.z[iC]) == gb4.e) {
            return -1L;
        }
        return obj;
    }

    public final int f(long j) {
        if (this.b) {
            int i = this.A;
            long[] jArr = this.f;
            Object[] objArr = this.z;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != gb4.e) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.b = false;
            this.A = i2;
        }
        return co4.c(this.f, this.A, j);
    }

    public final long g(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.A)) {
            xe.k(dw2.A(i, "Expected index to be within 0..size()-1, but was "));
            return 0L;
        }
        if (this.b) {
            long[] jArr = this.f;
            Object[] objArr = this.z;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != gb4.e) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.b = false;
            this.A = i3;
        }
        return this.f[i];
    }

    public final void h(long j, Object obj) {
        Object obj2 = gb4.e;
        int iC = co4.c(this.f, this.A, j);
        if (iC >= 0) {
            this.z[iC] = obj;
            return;
        }
        int i = ~iC;
        int i2 = this.A;
        if (i < i2) {
            Object[] objArr = this.z;
            if (objArr[i] == obj2) {
                this.f[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.b) {
            long[] jArr = this.f;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.z;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.b = false;
                this.A = i3;
                i = ~co4.c(this.f, i3, j);
            }
        }
        int i5 = this.A;
        if (i5 >= this.f.length) {
            int i6 = (i5 + 1) * 8;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 8;
            this.f = Arrays.copyOf(this.f, i9);
            this.z = Arrays.copyOf(this.z, i9);
        }
        int i10 = this.A - i;
        if (i10 != 0) {
            long[] jArr2 = this.f;
            int i11 = i + 1;
            jArr2.getClass();
            System.arraycopy(jArr2, i, jArr2, i11, i10);
            Object[] objArr3 = this.z;
            qe.c0(i11, i, this.A, objArr3, objArr3);
        }
        this.f[i] = j;
        this.z[i] = obj;
        this.A++;
    }

    public final void i(long j) {
        int iC = co4.c(this.f, this.A, j);
        if (iC >= 0) {
            Object[] objArr = this.z;
            Object obj = objArr[iC];
            Object obj2 = gb4.e;
            if (obj != obj2) {
                objArr[iC] = obj2;
                this.b = true;
            }
        }
    }

    public final int j() {
        if (this.b) {
            int i = this.A;
            long[] jArr = this.f;
            Object[] objArr = this.z;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != gb4.e) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.b = false;
            this.A = i2;
        }
        return this.A;
    }

    public final Object k(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.A)) {
            xe.k(dw2.A(i, "Expected index to be within 0..size()-1, but was "));
            return null;
        }
        if (this.b) {
            long[] jArr = this.f;
            Object[] objArr = this.z;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != gb4.e) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.b = false;
            this.A = i3;
        }
        return this.z[i];
    }

    public final String toString() {
        if (j() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.A * 28);
        sb.append('{');
        int i = this.A;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(g(i2));
            sb.append('=');
            Object objK = k(i2);
            if (objK != sb) {
                sb.append(objK);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
