package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class f {
    public final long a;
    public final int c;
    public final AtomicInteger b = new AtomicInteger(0);
    public final AtomicLong d = new AtomicLong(0);

    public f(long j, int i) {
        this.a = j;
        this.c = i <= 0 ? 1 : i;
    }

    public final boolean a() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        AtomicLong atomicLong = this.d;
        long j = atomicLong.get();
        AtomicInteger atomicInteger = this.b;
        if (j == 0 || atomicLong.get() + this.a <= jUptimeMillis) {
            atomicInteger.set(0);
            atomicLong.set(jUptimeMillis);
            return false;
        }
        if (atomicInteger.incrementAndGet() < this.c) {
            return false;
        }
        atomicInteger.set(0);
        return true;
    }
}
