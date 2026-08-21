package defpackage;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class pl0 extends y61 implements Executor {
    public static final ef0 A;
    public static final pl0 z = new pl0();

    static {
        gm4 gm4Var = gm4.z;
        int i = p94.a;
        if (64 >= i) {
            i = 64;
        }
        A = gm4Var.r0(co4.Z(i, 12, "kotlinx.coroutines.io.parallelism"));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        j0(c41.b, runnable);
    }

    @Override // defpackage.ef0
    public final void j0(cf0 cf0Var, Runnable runnable) {
        A.j0(cf0Var, runnable);
    }

    @Override // defpackage.ef0
    public final void n0(cf0 cf0Var, Runnable runnable) {
        A.n0(cf0Var, runnable);
    }

    @Override // defpackage.ef0
    public final ef0 r0(int i) {
        return gm4.z.r0(1);
    }

    @Override // defpackage.ef0
    public final String toString() {
        return "Dispatchers.IO";
    }
}
