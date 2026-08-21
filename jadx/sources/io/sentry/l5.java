package io.sentry;

import j$.time.Instant;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class l5 extends w4 {
    public final Instant b = Instant.now();

    @Override // io.sentry.w4
    public final long d() {
        Instant instant = this.b;
        return (instant.getEpochSecond() * 1000000000) + ((long) instant.getNano());
    }
}
