package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class tz3 implements Cloneable {
    public /* synthetic */ int[] b;
    public /* synthetic */ Object[] f;
    public /* synthetic */ int z;

    public tz3() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.b = new int[i4];
        this.f = new Object[i4];
    }

    public final void a(int i, Object obj) {
        int i2 = this.z;
        if (i2 != 0 && i <= this.b[i2 - 1]) {
            c(i, obj);
            return;
        }
        if (i2 >= this.b.length) {
            int i3 = (i2 + 1) * 4;
            int i4 = 4;
            while (true) {
                if (i4 >= 32) {
                    break;
                }
                int i5 = (1 << i4) - 12;
                if (i3 <= i5) {
                    i3 = i5;
                    break;
                }
                i4++;
            }
            int i6 = i3 / 4;
            this.b = Arrays.copyOf(this.b, i6);
            this.f = Arrays.copyOf(this.f, i6);
        }
        this.b[i2] = i;
        this.f[i2] = obj;
        this.z = i2 + 1;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final tz3 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        objClone.getClass();
        tz3 tz3Var = (tz3) objClone;
        tz3Var.b = (int[]) this.b.clone();
        tz3Var.f = (Object[]) this.f.clone();
        return tz3Var;
    }

    public final void c(int i, Object obj) {
        int iB = co4.b(this.z, i, this.b);
        if (iB >= 0) {
            this.f[iB] = obj;
            return;
        }
        int i2 = ~iB;
        int i3 = this.z;
        if (i2 < i3) {
            Object[] objArr = this.f;
            if (objArr[i2] == vf2.Y) {
                this.b[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (i3 >= this.b.length) {
            int i4 = (i3 + 1) * 4;
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
            int i7 = i4 / 4;
            this.b = Arrays.copyOf(this.b, i7);
            this.f = Arrays.copyOf(this.f, i7);
        }
        int i8 = this.z;
        if (i8 - i2 != 0) {
            int[] iArr = this.b;
            int i9 = i2 + 1;
            qe.e0(iArr, i9, iArr, i2, i8);
            Object[] objArr2 = this.f;
            qe.c0(i9, i2, this.z, objArr2, objArr2);
        }
        this.b[i2] = i;
        this.f[i2] = obj;
        this.z++;
    }

    public final Object d(int i) {
        Object[] objArr = this.f;
        if (i < objArr.length) {
            return objArr[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final String toString() {
        int i = this.z;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        int i2 = this.z;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(this.b[i3]);
            sb.append('=');
            Object objD = d(i3);
            if (objD != this) {
                sb.append(objD);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
