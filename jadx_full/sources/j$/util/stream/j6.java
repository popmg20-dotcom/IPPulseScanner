package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class j6 extends x5 {
    public Object[] d;
    public int e;

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Object[] objArr = this.d;
        int i = this.e;
        this.e = i + 1;
        objArr[i] = obj;
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final void c(long j) {
        if (j < 2147483639) {
            this.d = new Object[(int) j];
        } else {
            j$.time.h.c("Stream size exceeds max array size");
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final void end() {
        int i = 0;
        Arrays.sort(this.d, 0, this.e, this.b);
        long j = this.e;
        j5 j5Var = this.a;
        j5Var.c(j);
        if (this.c) {
            while (i < this.e && !j5Var.e()) {
                j5Var.accept(this.d[i]);
                i++;
            }
        } else {
            while (i < this.e) {
                j5Var.accept(this.d[i]);
                i++;
            }
        }
        j5Var.end();
        this.d = null;
    }
}
