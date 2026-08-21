package io.sentry;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public enum q6 implements k2 {
    SESSION,
    BUFFER;

    @Override // io.sentry.k2
    public void serialize(n3 n3Var, ILogger iLogger) {
        ((io.sentry.internal.debugmeta.c) n3Var).y(name().toLowerCase(Locale.ROOT));
    }
}
