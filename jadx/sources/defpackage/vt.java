package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class vt extends zt {
    public final int X;
    public final int Y;

    public vt(int i, int i2, byte[] bArr) {
        super(bArr);
        zt.b(i, i + i2, bArr.length);
        this.X = i;
        this.Y = i2;
    }

    @Override // defpackage.zt
    public final byte a(int i) {
        int i2 = this.Y;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.f[this.X + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(dw2.A(i, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(fw.s(i, i2, "Index > length: ", ", "));
    }

    @Override // defpackage.zt
    public final void d(int i, byte[] bArr) {
        System.arraycopy(this.f, this.X, bArr, 0, i);
    }

    @Override // defpackage.zt
    public final int e() {
        return this.X;
    }

    @Override // defpackage.zt
    public final byte f(int i) {
        return this.f[this.X + i];
    }

    @Override // defpackage.zt
    public final int size() {
        return this.Y;
    }
}
