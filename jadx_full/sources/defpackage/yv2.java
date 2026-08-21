package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class yv2 extends zv2 {
    @Override // defpackage.zv2
    public final int a(int i) {
        int i2 = this.b;
        if (i == i2 || (i >= 0 && i < i2)) {
            return i;
        }
        d(i, i2 - 1, "Char");
        throw null;
    }

    @Override // defpackage.zv2
    public final int b(int i) {
        int i2 = this.b;
        if (i == i2 || (i >= 0 && i < i2)) {
            return i;
        }
        d(i, i2 - 1, "Byte");
        throw null;
    }
}
