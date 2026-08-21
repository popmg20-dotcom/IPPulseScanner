package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class gq1 extends hi4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ hi4 b;

    public /* synthetic */ gq1(hi4 hi4Var, int i) {
        this.a = i;
        this.b = hi4Var;
    }

    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        int i = this.a;
        hi4 hi4Var = this.b;
        switch (i) {
            case 0:
                return new AtomicLong(((Number) hi4Var.b(r62Var)).longValue());
            default:
                ArrayList arrayList = new ArrayList();
                r62Var.B0();
                while (r62Var.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) hi4Var.b(r62Var)).longValue()));
                }
                r62Var.w0();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
        }
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        int i = this.a;
        hi4 hi4Var = this.b;
        switch (i) {
            case 0:
                hi4Var.c(v72Var, Long.valueOf(((AtomicLong) obj).get()));
                break;
            default:
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                v72Var.B0();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    hi4Var.c(v72Var, Long.valueOf(atomicLongArray.get(i2)));
                }
                v72Var.w0();
                break;
        }
    }
}
