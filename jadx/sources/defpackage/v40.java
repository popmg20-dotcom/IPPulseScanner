package defpackage;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v40 extends OutputStream {
    public final py4 b;
    public final s41 f;

    public v40(py4 py4Var, yy4 yy4Var, char[] cArr, boolean z) {
        this.b = py4Var;
        this.f = n(yy4Var, cArr, z);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.b.getClass();
    }

    public void g() {
        this.b.z = true;
    }

    public abstract s41 n(yy4 yy4Var, char[] cArr, boolean z);

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f.b(i, i2, bArr);
        this.b.write(bArr, i, i2);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.b.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.b.write(i);
    }
}
