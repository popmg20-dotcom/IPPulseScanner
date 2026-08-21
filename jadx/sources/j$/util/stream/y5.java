package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class y5 extends u5 {
    public m6 c;

    @Override // j$.util.stream.g5, j$.util.stream.j5
    public final void accept(double d) {
        this.c.accept(d);
    }

    @Override // j$.util.stream.c5, j$.util.stream.j5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = j > 0 ? new m6((int) j) : new m6();
        } else {
            j$.time.h.c("Stream size exceeds max array size");
        }
    }

    @Override // j$.util.stream.c5, j$.util.stream.j5
    public final void end() {
        double[] dArr = (double[]) this.c.b();
        Arrays.sort(dArr);
        long length = dArr.length;
        j5 j5Var = this.a;
        j5Var.c(length);
        int i = 0;
        if (this.b) {
            int length2 = dArr.length;
            while (i < length2) {
                double d = dArr[i];
                if (j5Var.e()) {
                    break;
                }
                j5Var.accept(d);
                i++;
            }
        } else {
            int length3 = dArr.length;
            while (i < length3) {
                j5Var.accept(dArr[i]);
                i++;
            }
        }
        j5Var.end();
    }
}
