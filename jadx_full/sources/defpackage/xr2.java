package defpackage;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class xr2 extends v40 {
    public final /* synthetic */ int z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xr2(py4 py4Var, yy4 yy4Var, char[] cArr, boolean z, int i) {
        super(py4Var, yy4Var, cArr, z);
        this.z = i;
    }

    @Override // defpackage.v40
    public final s41 n(yy4 yy4Var, char[] cArr, boolean z) {
        switch (this.z) {
            case 0:
                return new d7(25);
            default:
                e24 e24Var = new e24(cArr, yy4Var.l ? (yr2.y(yy4Var.j) & 65535) << 16 : yy4Var.h, z);
                this.b.write((byte[]) e24Var.z);
                return e24Var;
        }
    }

    @Override // defpackage.v40, java.io.OutputStream
    public void write(int i) {
        switch (this.z) {
            case 1:
                super.write(new byte[]{(byte) i}, 0, 1);
                break;
            default:
                super.write(i);
                break;
        }
    }

    @Override // defpackage.v40, java.io.OutputStream
    public void write(byte[] bArr) {
        switch (this.z) {
            case 1:
                super.write(bArr, 0, bArr.length);
                break;
            default:
                super.write(bArr);
                break;
        }
    }
}
