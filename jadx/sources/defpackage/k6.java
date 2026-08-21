package defpackage;

import java.io.ByteArrayOutputStream;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class k6 extends v40 {
    public int A;
    public byte[] z;

    @Override // defpackage.v40
    public final void g() {
        int i = this.A;
        if (i != 0) {
            super.write(this.z, 0, i);
            this.A = 0;
        }
        qt qtVar = ((l) this.f).f;
        if (((ByteArrayOutputStream) qtVar.d).size() > 0) {
            qtVar.g(0);
        }
        byte[] bArr = new byte[10];
        System.arraycopy(((Mac) qtVar.c).doFinal(), 0, bArr, 0, 10);
        py4 py4Var = this.b;
        py4Var.getClass();
        py4Var.write(bArr, 0, 10);
        super.g();
    }

    @Override // defpackage.v40
    public final s41 n(yy4 yy4Var, char[] cArr, boolean z) {
        l lVar = new l(cArr, yy4Var.f, z);
        py4 py4Var = this.b;
        py4Var.write(lVar.A0);
        py4Var.write(lVar.z0);
        return lVar;
    }

    @Override // defpackage.v40, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.A;
        int i5 = 16 - i4;
        byte[] bArr2 = this.z;
        if (i2 < i5) {
            System.arraycopy(bArr, i, bArr2, i4, i2);
            this.A += i2;
            return;
        }
        System.arraycopy(bArr, i, bArr2, i4, 16 - i4);
        super.write(bArr2, 0, bArr2.length);
        int i6 = 16 - this.A;
        int i7 = i2 - i6;
        this.A = 0;
        if (i7 != 0 && (i3 = i7 % 16) != 0) {
            System.arraycopy(bArr, (i7 + i6) - i3, bArr2, 0, i3);
            this.A = i3;
            i7 -= i3;
        }
        super.write(bArr, i6, i7);
    }

    @Override // defpackage.v40, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // defpackage.v40, java.io.OutputStream
    public final void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
