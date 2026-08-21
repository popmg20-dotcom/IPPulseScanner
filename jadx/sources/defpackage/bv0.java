package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class bv0 implements mv1 {
    public final long[] b;
    public final int f;

    public bv0(long[] jArr, int i) {
        this.b = jArr;
        this.f = i;
    }

    @Override // defpackage.mv1
    public final int j() {
        return this.b.length;
    }

    @Override // defpackage.mv1
    public final int m(int i) {
        return (int) (this.b[i] >> 32);
    }

    @Override // defpackage.mv1
    public final int r(int i) {
        return i == this.b.length + (-1) ? this.f : m(i + 1);
    }

    @Override // defpackage.mv1
    public final boolean t(int i) {
        return (((int) (4294967295L & this.b[i])) & 1) == 1;
    }
}
