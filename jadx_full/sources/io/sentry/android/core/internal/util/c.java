package io.sentry.android.core.internal.util;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c implements io.sentry.transport.f {
    public static final c b = new c();

    @Override // io.sentry.transport.f
    public long c() {
        return SystemClock.uptimeMillis();
    }
}
