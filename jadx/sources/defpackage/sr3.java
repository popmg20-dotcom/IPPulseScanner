package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sr3 extends ga0 implements ps2 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater X = AtomicIntegerFieldUpdater.newUpdater(sr3.class, "cleanedAndPointers$volatile");
    public static final /* synthetic */ long Y = re.a.objectFieldOffset(sr3.class.getDeclaredField("cleanedAndPointers$volatile"));
    public final long A;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public sr3(long j, sr3 sr3Var, int i) {
        super(sr3Var);
        this.A = j;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // defpackage.ga0
    public final boolean d() {
        return re.a.getIntVolatile(this, Y) == g() && c() != null;
    }

    public final boolean f() {
        return X.addAndGet(this, -65536) == g() && c() != null;
    }

    public abstract int g();

    public abstract void h(int i, cf0 cf0Var);

    public final void i() {
        if (X.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        while (true) {
            Unsafe unsafe = re.a;
            long j = Y;
            int intVolatile = unsafe.getIntVolatile(this, j);
            if (intVolatile == this.g() && this.c() != null) {
                return false;
            }
            sr3 sr3Var = this;
            if (unsafe.compareAndSwapInt(sr3Var, j, intVolatile, intVolatile + 65536)) {
                return true;
            }
            this = sr3Var;
        }
    }
}
