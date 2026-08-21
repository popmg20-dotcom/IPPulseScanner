package io.sentry.android.core.performance;

import android.os.SystemClock;
import io.sentry.u5;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class h implements Comparable {
    public long A;
    public String b;
    public long f;
    public long z;

    public final long a() {
        if (e()) {
            return this.A - this.z;
        }
        return 0L;
    }

    public final u5 b() {
        if (d()) {
            return new u5(this.f * 1000000);
        }
        return null;
    }

    public final boolean c() {
        return this.A == 0;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f, ((h) obj).f);
    }

    public final boolean d() {
        return this.z != 0;
    }

    public final boolean e() {
        return this.A != 0;
    }

    public final void f(long j) {
        this.z = j;
        this.f = System.currentTimeMillis() - (SystemClock.uptimeMillis() - this.z);
    }
}
