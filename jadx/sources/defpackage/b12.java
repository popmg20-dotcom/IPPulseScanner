package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class b12 extends z02 {
    public static final b12 A = new b12(1, 0, 1);

    @Override // defpackage.z02
    public final boolean equals(Object obj) {
        if (!(obj instanceof b12)) {
            return false;
        }
        if (isEmpty() && ((b12) obj).isEmpty()) {
            return true;
        }
        b12 b12Var = (b12) obj;
        return this.b == b12Var.b && this.f == b12Var.f;
    }

    @Override // defpackage.z02
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.b * 31) + this.f;
    }

    @Override // defpackage.z02
    public final boolean isEmpty() {
        return this.b > this.f;
    }

    @Override // defpackage.z02
    public final String toString() {
        return this.b + ".." + this.f;
    }
}
