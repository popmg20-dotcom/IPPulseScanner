package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class ae2 {
    public static final br1 e;
    public static final /* synthetic */ long f;
    public static final /* synthetic */ long g;
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;

    static {
        Unsafe unsafe = re.a;
        f = unsafe.objectFieldOffset(ae2.class.getDeclaredField("_next$volatile"));
        g = unsafe.objectFieldOffset(ae2.class.getDeclaredField("_state$volatile"));
        e = new br1("REMOVE_FROZEN", 3);
    }

    public ae2(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            xe.q("Check failed.");
            throw null;
        }
        if ((i & i2) == 0) {
            return;
        }
        xe.q("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        ae2 ae2Var = this;
        while (true) {
            Unsafe unsafe = re.a;
            long j = g;
            long longVolatile = unsafe.getLongVolatile(ae2Var, j);
            if ((3458764513820540928L & longVolatile) != 0) {
                return (2305843009213693952L & longVolatile) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & longVolatile);
            int i2 = (int) ((1152921503533105152L & longVolatile) >> 30);
            int i3 = ae2Var.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = ae2Var.b;
            AtomicReferenceArray atomicReferenceArray = ae2Var.d;
            if (z || atomicReferenceArray.get(i2 & i3) == null) {
                if (unsafe.compareAndSwapLong(ae2Var, g, longVolatile, ((-1152921503533105153L) & longVolatile) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i2 & i3, obj);
                    ae2 ae2VarC = this;
                    while ((re.a.getLongVolatile(ae2VarC, j) & 1152921504606846976L) != 0) {
                        ae2VarC = ae2VarC.c();
                        AtomicReferenceArray atomicReferenceArray2 = ae2VarC.d;
                        int i4 = ae2VarC.c & i2;
                        Object obj2 = atomicReferenceArray2.get(i4);
                        if ((obj2 instanceof zd2) && ((zd2) obj2).a == i2) {
                            atomicReferenceArray2.set(i4, obj);
                        } else {
                            ae2VarC = null;
                        }
                        if (ae2VarC == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                ae2Var = this;
            } else {
                int i5 = ae2Var.a;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final boolean b() {
        while (true) {
            long longVolatile = re.a.getLongVolatile(this, g);
            if ((longVolatile & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & longVolatile) != 0) {
                return false;
            }
            ae2 ae2Var = this;
            if (re.a.compareAndSwapLong(ae2Var, g, longVolatile, longVolatile | 2305843009213693952L)) {
                return true;
            }
            this = ae2Var;
        }
    }

    public final ae2 c() {
        long j;
        Unsafe unsafe;
        while (true) {
            Unsafe unsafe2 = re.a;
            long j2 = g;
            long longVolatile = unsafe2.getLongVolatile(this, j2);
            if ((longVolatile & 1152921504606846976L) != 0) {
                j = longVolatile;
                break;
            }
            j = 1152921504606846976L | longVolatile;
            if (unsafe2.compareAndSwapLong(this, j2, longVolatile, j)) {
                break;
            }
        }
        while (true) {
            Unsafe unsafe3 = re.a;
            long j3 = f;
            ae2 ae2Var = (ae2) unsafe3.getObjectVolatile(this, j3);
            if (ae2Var != null) {
                return ae2Var;
            }
            ae2 ae2Var2 = new ae2(this.a * 2, this.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object zd2Var = this.d.get(i4);
                if (zd2Var == null) {
                    zd2Var = new zd2(i);
                }
                ae2Var2.d.set(ae2Var2.c & i, zd2Var);
                i++;
            }
            re.a.putLongVolatile(ae2Var2, g, j & (-1152921504606846977L));
            do {
                unsafe = re.a;
                if (unsafe.compareAndSwapObject(this, f, (Object) null, ae2Var2)) {
                    break;
                }
            } while (unsafe.getObjectVolatile(this, j3) == null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0044, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d() {
        ae2 ae2VarC = this;
        while (true) {
            Unsafe unsafe = re.a;
            long j = g;
            long longVolatile = unsafe.getLongVolatile(ae2VarC, j);
            if ((longVolatile & 1152921504606846976L) != 0) {
                return e;
            }
            int i = (int) (longVolatile & 1073741823);
            int i2 = ae2VarC.c;
            int i3 = ((int) ((1152921503533105152L & longVolatile) >> 30)) & i2;
            int i4 = i2 & i;
            if (i3 == i4) {
                break;
            }
            AtomicReferenceArray atomicReferenceArray = ae2VarC.d;
            Object obj = atomicReferenceArray.get(i4);
            boolean z = ae2VarC.b;
            if (obj == null) {
                if (z) {
                    break;
                }
            } else {
                if (obj instanceof zd2) {
                    break;
                }
                long j2 = (i + 1) & 1073741823;
                if (unsafe.compareAndSwapLong(ae2VarC, j, longVolatile, (longVolatile & (-1073741824)) | j2)) {
                    atomicReferenceArray.set(i4, null);
                    return obj;
                }
                ae2VarC = this;
                if (z) {
                    while (true) {
                        Unsafe unsafe2 = re.a;
                        long j3 = g;
                        long longVolatile2 = unsafe2.getLongVolatile(ae2VarC, j3);
                        int i5 = (int) (longVolatile2 & 1073741823);
                        if ((longVolatile2 & 1152921504606846976L) != 0) {
                            ae2VarC = ae2VarC.c();
                        } else {
                            if (unsafe2.compareAndSwapLong(ae2VarC, j3, longVolatile2, (longVolatile2 & (-1073741824)) | j2)) {
                                ae2VarC.d.set(ae2VarC.c & i5, null);
                                ae2VarC = null;
                            } else {
                                continue;
                            }
                        }
                        if (ae2VarC == null) {
                            return obj;
                        }
                    }
                }
            }
        }
    }
}
