package io.sentry;

import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class r3 {
    public final io.sentry.protocol.w a;
    public final io.sentry.protocol.w b;
    public final ConcurrentHashMap c;
    public final File d;
    public final double e;
    public String f;

    public r3(io.sentry.protocol.w wVar, io.sentry.protocol.w wVar2, HashMap map, File file, w4 w4Var) {
        this.a = wVar;
        this.b = wVar2;
        this.c = new ConcurrentHashMap(map);
        this.d = file;
        this.e = w4Var.d() / 1.0E9d;
    }
}
