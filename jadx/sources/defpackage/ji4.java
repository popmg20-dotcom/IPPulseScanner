package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public class ji4 extends hi4 {
    @Override // defpackage.hi4
    public final Object b(r62 r62Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        r62Var.B0();
        while (r62Var.hasNext()) {
            try {
                arrayList.add(Integer.valueOf(r62Var.nextInt()));
            } catch (NumberFormatException e) {
                throw new l52(e);
            }
        }
        r62Var.w0();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // defpackage.hi4
    public final void c(v72 v72Var, Object obj) throws IOException {
        v72Var.B0();
        int length = ((AtomicIntegerArray) obj).length();
        for (int i = 0; i < length; i++) {
            v72Var.U(r5.get(i));
        }
        v72Var.w0();
    }
}
