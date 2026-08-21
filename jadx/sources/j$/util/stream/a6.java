package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class a6 extends w5 {
    public q6 c;

    @Override // j$.util.stream.i5, j$.util.stream.j5
    public final void accept(long j) {
        this.c.accept(j);
    }

    @Override // j$.util.stream.e5, j$.util.stream.j5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = j > 0 ? new q6((int) j) : new q6();
        } else {
            j$.time.h.c("Stream size exceeds max array size");
        }
    }

    @Override // j$.util.stream.e5, j$.util.stream.j5
    public final void end() {
        long[] jArr = (long[]) this.c.b();
        Arrays.sort(jArr);
        long length = jArr.length;
        j5 j5Var = this.a;
        j5Var.c(length);
        int i = 0;
        if (this.b) {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                if (j5Var.e()) {
                    break;
                }
                j5Var.accept(j);
                i++;
            }
        } else {
            int length3 = jArr.length;
            while (i < length3) {
                j5Var.accept(jArr[i]);
                i++;
            }
        }
        j5Var.end();
    }
}
