package io.sentry.util;

import defpackage.re;
import io.sentry.k1;
import java.util.concurrent.locks.ReentrantLock;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k1 {
    public static final /* synthetic */ long f = re.a.objectFieldOffset(a.class.getDeclaredField("b"));
    public volatile ReentrantLock b;

    @Override // java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.b;
        b.r(reentrantLock, "close() called before acquire()");
        reentrantLock.unlock();
    }

    public final void g() {
        ReentrantLock reentrantLock = this.b;
        if (reentrantLock == null) {
            ReentrantLock reentrantLock2 = new ReentrantLock();
            while (true) {
                Unsafe unsafe = re.a;
                long j = f;
                a aVar = this;
                if (unsafe.compareAndSwapObject(aVar, j, (Object) null, reentrantLock2)) {
                    reentrantLock = reentrantLock2;
                    break;
                } else {
                    if (unsafe.getObjectVolatile(aVar, j) != null) {
                        reentrantLock = aVar.b;
                        b.r(reentrantLock, "lock must have been set by the winning thread");
                        break;
                    }
                    this = aVar;
                }
            }
        }
        reentrantLock.lock();
    }
}
