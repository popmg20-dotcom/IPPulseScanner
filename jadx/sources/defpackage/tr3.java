package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tr3 {
    public static final rr3 a = new rr3(new byte[0], 0, 0, false);
    public static final int b;
    public static final AtomicReference[] c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        c = atomicReferenceArr;
    }

    public static final void a(rr3 rr3Var) {
        rr3Var.getClass();
        if (rr3Var.f != null || rr3Var.g != null) {
            xe.k("Failed requirement.");
            return;
        }
        if (rr3Var.d) {
            return;
        }
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (((long) b) - 1))];
        rr3 rr3Var2 = a;
        rr3 rr3Var3 = (rr3) atomicReference.getAndSet(rr3Var2);
        if (rr3Var3 == rr3Var2) {
            return;
        }
        int i = rr3Var3 != null ? rr3Var3.c : 0;
        if (i >= 65536) {
            atomicReference.set(rr3Var3);
            return;
        }
        rr3Var.f = rr3Var3;
        rr3Var.b = 0;
        rr3Var.c = i + 8192;
        atomicReference.set(rr3Var);
    }

    public static final rr3 b() {
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (((long) b) - 1))];
        rr3 rr3Var = a;
        rr3 rr3Var2 = (rr3) atomicReference.getAndSet(rr3Var);
        if (rr3Var2 == rr3Var) {
            return new rr3();
        }
        if (rr3Var2 == null) {
            atomicReference.set(null);
            return new rr3();
        }
        atomicReference.set(rr3Var2.f);
        rr3Var2.f = null;
        rr3Var2.c = 0;
        return rr3Var2;
    }
}
