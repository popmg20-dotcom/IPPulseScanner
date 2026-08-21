package defpackage;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class mk3 extends Reader {
    public InputStreamReader A;
    public final cq b;
    public final Charset f;
    public boolean z;

    public mk3(cq cqVar, Charset charset) {
        cqVar.getClass();
        charset.getClass();
        this.b = cqVar;
        this.f = charset;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.z = true;
        InputStreamReader inputStreamReader = this.A;
        if (inputStreamReader != null) {
            inputStreamReader.close();
        } else {
            this.b.close();
        }
    }

    @Override // java.io.Reader
    public final int read(char[] cArr, int i, int i2) throws IOException {
        cArr.getClass();
        if (this.z) {
            vp1.i("Stream closed");
            return 0;
        }
        InputStreamReader inputStreamReader = this.A;
        if (inputStreamReader == null) {
            cq cqVar = this.b;
            inputStreamReader = new InputStreamReader(cqVar.E0(), jz4.f(cqVar, this.f));
            this.A = inputStreamReader;
        }
        return inputStreamReader.read(cArr, i, i2);
    }
}
