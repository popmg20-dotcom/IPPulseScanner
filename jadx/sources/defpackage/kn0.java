package defpackage;

import java.util.zip.Deflater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class kn0 extends z90 {
    public byte[] f;
    public Deflater z;

    @Override // defpackage.z90
    public final void g() {
        Deflater deflater = this.z;
        if (!deflater.finished()) {
            deflater.finish();
            while (!deflater.finished()) {
                byte[] bArr = this.f;
                int iDeflate = deflater.deflate(bArr, 0, bArr.length);
                if (iDeflate > 0) {
                    super.write(bArr, 0, iDeflate);
                }
            }
        }
        deflater.end();
        super.g();
    }

    @Override // defpackage.z90, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        Deflater deflater = this.z;
        deflater.setInput(bArr, i, i2);
        while (!deflater.needsInput()) {
            byte[] bArr2 = this.f;
            int iDeflate = deflater.deflate(bArr2, 0, bArr2.length);
            if (iDeflate > 0) {
                super.write(bArr2, 0, iDeflate);
            }
        }
    }

    @Override // defpackage.z90, java.io.OutputStream
    public final void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // defpackage.z90, java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }
}
