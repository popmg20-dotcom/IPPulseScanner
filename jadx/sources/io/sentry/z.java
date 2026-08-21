package io.sentry;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public final f1 a;
    public final ILogger b;
    public final long c;
    public final g7 d;

    public z(f1 f1Var, ILogger iLogger, long j, int i) {
        this.a = f1Var;
        this.b = iLogger;
        this.c = j;
        this.d = new g7(new i(i));
    }

    public abstract boolean a(String str);

    public abstract void b(File file, l0 l0Var);
}
