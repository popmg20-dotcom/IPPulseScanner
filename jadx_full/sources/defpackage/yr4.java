package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class yr4 extends as4 {
    public final int e;
    public final int f;

    public yr4(int i, int i2, int i3, int i4, int i5, int i6) {
        super(i3, i4, i5, i6);
        this.e = i;
        this.f = i2;
    }

    @Override // defpackage.as4
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yr4)) {
            return false;
        }
        yr4 yr4Var = (yr4) obj;
        return this.e == yr4Var.e && this.f == yr4Var.f && this.a == yr4Var.a && this.b == yr4Var.b && this.c == yr4Var.c && this.d == yr4Var.d;
    }

    @Override // defpackage.as4
    public final int hashCode() {
        return super.hashCode() + this.e + this.f;
    }

    public final String toString() {
        return q44.c0("ViewportHint.Access(\n            |    pageOffset=" + this.e + ",\n            |    indexInPage=" + this.f + ",\n            |    presentedItemsBefore=" + this.a + ",\n            |    presentedItemsAfter=" + this.b + ",\n            |    originalPageOffsetFirst=" + this.c + ",\n            |    originalPageOffsetLast=" + this.d + ",\n            |)");
    }
}
