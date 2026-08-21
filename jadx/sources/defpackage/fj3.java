package defpackage;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class fj3 {
    public static final int a;
    public static final int b;
    public static final int c;
    public static final int d;
    public static final int e;
    public static final int f;
    public static final int g;
    public static final int h;

    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        a = atomicInteger.getAndIncrement();
        b = atomicInteger.getAndIncrement();
        c = atomicInteger.getAndIncrement();
        d = atomicInteger.getAndIncrement();
        e = atomicInteger.getAndIncrement();
        f = atomicInteger.getAndIncrement();
        g = atomicInteger.getAndIncrement();
        h = atomicInteger.getAndIncrement();
    }
}
