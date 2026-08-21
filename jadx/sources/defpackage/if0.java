package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes3.dex */
public final class if0 extends Thread {
    public long A;
    public long X;
    public int Y;
    public boolean Z;
    public final dx4 b;
    public final bh3 f;
    private volatile int indexInArray;
    private volatile Object nextParkedWorker;
    private volatile /* synthetic */ int workerCtl$volatile;
    public final /* synthetic */ kf0 y0;
    public jf0 z;
    public static final /* synthetic */ AtomicIntegerFieldUpdater z0 = AtomicIntegerFieldUpdater.newUpdater(if0.class, "workerCtl$volatile");
    public static final /* synthetic */ long A0 = re.a.objectFieldOffset(if0.class.getDeclaredField("workerCtl$volatile"));

    public if0(kf0 kf0Var, int i) {
        this.y0 = kf0Var;
        setDaemon(true);
        setContextClassLoader(kf0.class.getClassLoader());
        this.b = new dx4();
        this.f = new bh3();
        this.z = jf0.A;
        this.nextParkedWorker = kf0.B0;
        int iNanoTime = (int) System.nanoTime();
        this.Y = iNanoTime == 0 ? 42 : iNanoTime;
        f(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        r1 = r4.getIntVolatile(r11, defpackage.dx4.e);
        r2 = r4.getIntVolatile(r11, defpackage.dx4.g);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
    
        if (r1 == r2) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (defpackage.re.a.getIntVolatile(r11, defpackage.dx4.d) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0064, code lost:
    
        r2 = r2 - 1;
        r4 = r11.d(r2, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (r4 == null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r8 = r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.va4 a(boolean r17) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.if0.a(boolean):va4");
    }

    public final int b() {
        return this.indexInArray;
    }

    public final Object c() {
        return this.nextParkedWorker;
    }

    public final int d(int i) {
        int i2 = this.Y;
        int i3 = i2 ^ (i2 << 13);
        int i4 = i3 ^ (i3 >> 17);
        int i5 = i4 ^ (i4 << 5);
        this.Y = i5;
        int i6 = i - 1;
        return (i6 & i) == 0 ? i6 & i5 : (Integer.MAX_VALUE & i5) % i;
    }

    public final va4 e() {
        int iD = d(2);
        kf0 kf0Var = this.y0;
        fp1 fp1Var = kf0Var.Y;
        fp1 fp1Var2 = kf0Var.X;
        if (iD == 0) {
            va4 va4Var = (va4) fp1Var2.d();
            return va4Var != null ? va4Var : (va4) fp1Var.d();
        }
        va4 va4Var2 = (va4) fp1Var.d();
        return va4Var2 != null ? va4Var2 : (va4) fp1Var2.d();
    }

    public final void f(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.y0.A);
        sb.append("-worker-");
        sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
        setName(sb.toString());
        this.indexInArray = i;
    }

    public final void g(Object obj) {
        this.nextParkedWorker = obj;
    }

    public final boolean h(jf0 jf0Var) {
        jf0 jf0Var2 = this.z;
        boolean z = jf0Var2 == jf0.b;
        if (z) {
            kf0.z0.addAndGet(this.y0, 4398046511104L);
        }
        if (jf0Var2 != jf0Var) {
            this.z = jf0Var;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        r7 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00aa, code lost:
    
        r1 = -2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.va4 i(int r29) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.if0.i(int):va4");
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0004, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0004, code lost:
    
        continue;
     */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.if0.run():void");
    }
}
