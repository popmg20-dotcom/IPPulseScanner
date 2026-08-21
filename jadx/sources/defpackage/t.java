package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends kx3 {
    public static final t z0 = new t("ASCII-8BIT", ek0.a, ek0.b);

    @Override // defpackage.k0
    public final byte[] B() {
        return this.y0;
    }

    @Override // defpackage.k0
    public final boolean j(int i, int i2) {
        if (i < 128) {
            return k(i, i2);
        }
        return false;
    }
}
