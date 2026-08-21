package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public class z02 implements Iterable, z72 {
    public final int b;
    public final int f;
    public final int z;

    public z02(int i, int i2, int i3) {
        if (i3 == 0) {
            xe.k("Step must be non-zero.");
            throw null;
        }
        if (i3 == Integer.MIN_VALUE) {
            xe.k("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.b = i;
        this.f = ye.z(i, i2, i3);
        this.z = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z02)) {
            return false;
        }
        if (isEmpty() && ((z02) obj).isEmpty()) {
            return true;
        }
        z02 z02Var = (z02) obj;
        return this.b == z02Var.b && this.f == z02Var.f && this.z == z02Var.z;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.b * 31) + this.f) * 31) + this.z;
    }

    public boolean isEmpty() {
        int i = this.f;
        int i2 = this.z;
        int i3 = this.b;
        return i2 > 0 ? i3 > i : i3 < i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a12(this.b, this.f, this.z);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.f;
        int i2 = this.z;
        int i3 = this.b;
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i2);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i2);
        }
        return sb.toString();
    }
}
