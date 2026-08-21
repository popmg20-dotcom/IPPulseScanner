package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class gp extends InputStream {
    public final /* synthetic */ int b;
    public final Object f;

    public gp(ByteBuffer byteBuffer) {
        this.b = 1;
        this.f = byteBuffer;
    }

    @Override // java.io.InputStream
    public final int available() throws IOException {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                return (int) Math.min(((hp) obj).f, 2147483647L);
            case 1:
                return ((ByteBuffer) obj).remaining();
            default:
                he3 he3Var = (he3) obj;
                if (!he3Var.z) {
                    return (int) Math.min(he3Var.f.f, 2147483647L);
                }
                vp1.i("closed");
                return 0;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        switch (this.b) {
            case 0:
                break;
            case 1:
            default:
                super.close();
                break;
            case 2:
                ((he3) this.f).close();
                break;
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.b;
        Object obj = this.f;
        switch (i3) {
            case 0:
                bArr.getClass();
                return ((hp) obj).read(bArr, i, i2);
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                if (!byteBuffer.hasRemaining()) {
                    return -1;
                }
                int iMin = Math.min(i2, byteBuffer.remaining());
                byteBuffer.get(bArr, i, iMin);
                return iMin;
            default:
                bArr.getClass();
                he3 he3Var = (he3) obj;
                hp hpVar = he3Var.f;
                if (he3Var.z) {
                    vp1.i("closed");
                    return 0;
                }
                l72.f(bArr.length, i, i2);
                if (hpVar.f == 0 && he3Var.b.t0(hpVar, 8192L) == -1) {
                    return -1;
                }
                return hpVar.read(bArr, i, i2);
        }
    }

    public String toString() {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                return ((hp) obj) + ".inputStream()";
            case 1:
            default:
                return super.toString();
            case 2:
                return ((he3) obj) + ".inputStream()";
        }
    }

    @Override // java.io.InputStream
    public long transferTo(OutputStream outputStream) throws IOException {
        switch (this.b) {
            case 2:
                outputStream.getClass();
                he3 he3Var = (he3) this.f;
                hp hpVar = he3Var.f;
                if (he3Var.z) {
                    vp1.i("closed");
                    return 0L;
                }
                long j = 0;
                while (true) {
                    if (hpVar.f == 0 && he3Var.b.t0(hpVar, 8192L) == -1) {
                        return j;
                    }
                    long j2 = hpVar.f;
                    j += j2;
                    hpVar.O0(outputStream, j2);
                }
                break;
            default:
                return super.transferTo(outputStream);
        }
    }

    public /* synthetic */ gp(cq cqVar, int i) {
        this.b = i;
        this.f = cqVar;
    }

    private final void g() {
    }

    @Override // java.io.InputStream
    public final int read() throws IOException {
        int i = this.b;
        Object obj = this.f;
        switch (i) {
            case 0:
                hp hpVar = (hp) obj;
                if (hpVar.f > 0) {
                    return hpVar.U() & 255;
                }
                return -1;
            case 1:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                if (byteBuffer.hasRemaining()) {
                    return byteBuffer.get() & 255;
                }
                return -1;
            default:
                he3 he3Var = (he3) obj;
                hp hpVar2 = he3Var.f;
                if (he3Var.z) {
                    vp1.i("closed");
                    return 0;
                }
                if (hpVar2.f == 0 && he3Var.b.t0(hpVar2, 8192L) == -1) {
                    return -1;
                }
                return hpVar2.U() & 255;
        }
    }
}
