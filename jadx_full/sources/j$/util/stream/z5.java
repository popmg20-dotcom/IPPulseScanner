package j$.util.stream;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class z5 extends v5 {
    public o6 c;

    @Override // j$.util.stream.h5, java.util.function.IntConsumer
    public final void accept(int i) {
        this.c.accept(i);
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public final void c(long j) {
        if (j < 2147483639) {
            this.c = j > 0 ? new o6((int) j) : new o6();
        } else {
            j$.time.h.c("Stream size exceeds max array size");
        }
    }

    @Override // j$.util.stream.d5, j$.util.stream.j5
    public final void end() {
        int[] iArr = (int[]) this.c.b();
        Arrays.sort(iArr);
        long length = iArr.length;
        j5 j5Var = this.a;
        j5Var.c(length);
        int i = 0;
        if (this.b) {
            int length2 = iArr.length;
            while (i < length2) {
                int i2 = iArr[i];
                if (j5Var.e()) {
                    break;
                }
                j5Var.accept(i2);
                i++;
            }
        } else {
            int length3 = iArr.length;
            while (i < length3) {
                j5Var.accept(iArr[i]);
                i++;
            }
        }
        j5Var.end();
    }
}
