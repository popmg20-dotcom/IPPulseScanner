package io.sentry.android.core;

import android.os.ProfilingResult;
import io.sentry.p5;
import j$.util.function.Consumer$CC;
import java.io.File;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l1 implements Consumer {
    public final /* synthetic */ int a;
    public final /* synthetic */ m1 b;

    public /* synthetic */ l1(m1 m1Var, int i) {
        this.a = i;
        this.b = m1Var;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        int i = this.a;
        m1 m1Var = this.b;
        switch (i) {
            case 0:
                ProfilingResult profilingResult = (ProfilingResult) obj;
                m1Var.a.h(p5.DEBUG, "Perfetto ProfilingResult received: errorCode=%d, filePath=%s", Integer.valueOf(profilingResult.getErrorCode()), profilingResult.getResultFilePath());
                synchronized (m1Var.e) {
                    try {
                        m1Var.f = profilingResult;
                        Consumer consumer = m1Var.g;
                        if (consumer != null) {
                            consumer.accept(m1Var.c(profilingResult));
                            m1Var.g = null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return;
            default:
                File file = (File) obj;
                if (file == null || file.delete()) {
                    return;
                }
                m1Var.a.h(p5.WARNING, "Failed to delete late Perfetto trace file %s", file.getPath());
                return;
        }
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        int i = this.a;
        return Consumer$CC.$default$andThen(this, consumer);
    }
}
