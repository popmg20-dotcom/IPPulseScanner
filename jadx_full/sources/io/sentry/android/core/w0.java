package io.sentry.android.core;

import android.os.FileObserver;
import defpackage.fw;
import io.sentry.ILogger;
import io.sentry.o3;
import io.sentry.p5;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends FileObserver {
    public final String a;
    public final o3 b;
    public final ILogger c;
    public final long d;

    public w0(String str, o3 o3Var, ILogger iLogger, long j) {
        super(str);
        this.a = str;
        this.b = o3Var;
        io.sentry.util.b.r(iLogger, "Logger is required.");
        this.c = iLogger;
        this.d = j;
    }

    @Override // android.os.FileObserver
    public final void onEvent(int i, String str) {
        if (str == null || i != 8) {
            return;
        }
        p5 p5Var = p5.DEBUG;
        String str2 = this.a;
        Object[] objArr = {Integer.valueOf(i), str2, str};
        ILogger iLogger = this.c;
        iLogger.h(p5Var, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", objArr);
        this.b.b(new File(fw.y(new StringBuilder(str2), File.separator, str)), io.sentry.util.b.f(new v0(this.d, iLogger)));
    }
}
