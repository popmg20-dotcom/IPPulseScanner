package j$.util.stream;

import j$.util.Collection;
import j$.util.List;
import j$.util.Objects;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes2.dex */
public final class f6 extends x5 {
    public ArrayList d;

    @Override // java.util.function.Consumer
    /* JADX INFO: renamed from: accept */
    public final void n(Object obj) {
        this.d.add(obj);
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final void c(long j) {
        if (j < 2147483639) {
            this.d = j >= 0 ? new ArrayList((int) j) : new ArrayList();
        } else {
            j$.time.h.c("Stream size exceeds max array size");
        }
    }

    @Override // j$.util.stream.f5, j$.util.stream.j5
    public final void end() {
        List.EL.sort(this.d, this.b);
        long size = this.d.size();
        j5 j5Var = this.a;
        j5Var.c(size);
        boolean z = this.c;
        ArrayList arrayList = this.d;
        if (z) {
            int size2 = arrayList.size();
            int i = 0;
            while (i < size2) {
                Object obj = arrayList.get(i);
                i++;
                if (j5Var.e()) {
                    break;
                } else {
                    j5Var.n(obj);
                }
            }
        } else {
            Objects.requireNonNull(j5Var);
            Collection.EL.a(arrayList, new j$.util.p(9, j5Var));
        }
        j5Var.end();
        this.d = null;
    }
}
