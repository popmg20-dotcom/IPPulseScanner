package io.sentry.android.core.internal.util;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import defpackage.hw;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class d implements io.sentry.util.thread.a {
    public static final d a;
    public static volatile long b;

    static {
        d dVar = new d();
        new Handler(Looper.getMainLooper()).post(new hw(3));
        a = dVar;
        b = Process.myTid();
    }

    public static long d(Thread thread) {
        return Build.VERSION.SDK_INT >= 36 ? thread.threadId() : thread.getId();
    }

    @Override // io.sentry.util.thread.a
    public final String a() {
        return c() ? "main" : Thread.currentThread().getName();
    }

    @Override // io.sentry.util.thread.a
    public final long b() {
        return Process.myTid();
    }

    @Override // io.sentry.util.thread.a
    public final boolean c() {
        return d(Looper.getMainLooper().getThread()) == d(Thread.currentThread());
    }
}
