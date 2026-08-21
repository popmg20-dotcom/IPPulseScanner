package io.sentry.android.core;

import android.app.ApplicationExitInfo;
import defpackage.sb0;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.sentry.f5;
import io.sentry.p5;
import io.sentry.x3;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class c0 implements n0 {
    public final SentryAndroidOptions a;

    public c0(SentryAndroidOptions sentryAndroidOptions) {
        this.a = sentryAndroidOptions;
    }

    @Override // io.sentry.android.core.n0
    public final int a() {
        return 6;
    }

    @Override // io.sentry.android.core.n0
    public final Long b() {
        return io.sentry.android.core.cache.c.h(this.a, "last_anr_report", "ANR");
    }

    @Override // io.sentry.android.core.n0
    public final String c() {
        return "ANR";
    }

    @Override // io.sentry.android.core.n0
    public final boolean d() {
        return this.a.isReportHistoricalAnrs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.sentry.android.core.n0
    public final io.sentry.m e(ApplicationExitInfo applicationExitInfo, boolean z) {
        x3 x3Var;
        byte[] bArr;
        SentryAndroidOptions sentryAndroidOptions = this.a;
        long timestamp = applicationExitInfo.getTimestamp();
        boolean z2 = applicationExitInfo.getImportance() != 100;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            try {
                if (traceInputStream == 0) {
                    x3Var = new x3(d0.NO_DUMP);
                    traceInputStream = traceInputStream;
                    if (traceInputStream != 0) {
                        traceInputStream.close();
                        traceInputStream = traceInputStream;
                    }
                } else {
                    byte[] bArrO = io.sentry.config.a.o(traceInputStream);
                    traceInputStream.close();
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bArrO)));
                        try {
                            ArrayList arrayList = new ArrayList();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                io.sentry.android.core.internal.threaddump.a aVar = new io.sentry.android.core.internal.threaddump.a();
                                aVar.a = line;
                                arrayList.add(aVar);
                            }
                            sb0 sb0Var = new sb0(arrayList);
                            io.sentry.android.core.internal.threaddump.b bVar = new io.sentry.android.core.internal.threaddump.b(sentryAndroidOptions, z2);
                            bVar.d(sb0Var);
                            ArrayList arrayList2 = bVar.f;
                            ArrayList arrayList3 = new ArrayList(bVar.e.values());
                            io.sentry.protocol.c cVar = (io.sentry.protocol.c) bVar.g.f;
                            if (arrayList2.isEmpty()) {
                                x3Var = new x3(d0.NO_DUMP);
                                bufferedReader.close();
                                traceInputStream = bufferedReader;
                            } else {
                                x3 x3Var2 = new x3(d0.DUMP, bArrO, arrayList2, arrayList3, cVar);
                                bufferedReader.close();
                                x3Var = x3Var2;
                                traceInputStream = bufferedReader;
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to parse ANR thread dump", th);
                        d0 d0Var = d0.ERROR;
                        x3Var = new x3(d0Var, bArrO);
                        traceInputStream = d0Var;
                    }
                }
            } finally {
            }
        } catch (Throwable th2) {
            sentryAndroidOptions.getLogger().d(p5.WARNING, "Failed to read ANR thread dump", th2);
            x3Var = new x3(d0.NO_DUMP);
        }
        d0 d0Var2 = (d0) x3Var.b;
        if (d0Var2 == d0.NO_DUMP) {
            sentryAndroidOptions.getLogger().h(p5.WARNING, "Not reporting ANR event as there was no thread dump for the ANR %s", applicationExitInfo.toString());
            return null;
        }
        b0 b0Var = new b0(sentryAndroidOptions.getFlushTimeoutMillis(), sentryAndroidOptions.getLogger(), timestamp, z, z2);
        io.sentry.l0 l0VarF = io.sentry.util.b.f(b0Var);
        f5 f5Var = new f5();
        if (d0Var2 == d0.ERROR) {
            io.sentry.protocol.p pVar = new io.sentry.protocol.p();
            pVar.b = "Sentry Android SDK failed to parse system thread dump for this ANR. We recommend enabling [SentryOptions.isAttachAnrThreadDump] option to attach the thread dump as plain text and report this issue on GitHub.";
            f5Var.H0 = pVar;
        } else if (d0Var2 == d0.DUMP) {
            f5Var.J0 = new io.sentry.g2((ArrayList) x3Var.d);
            ArrayList arrayList4 = (ArrayList) x3Var.a;
            if (arrayList4 != null) {
                io.sentry.protocol.f fVar = new io.sentry.protocol.f();
                fVar.b(arrayList4);
                f5Var.E0 = fVar;
            }
            io.sentry.protocol.c cVar2 = (io.sentry.protocol.c) x3Var.e;
            if (cVar2 != null) {
                f5Var.f.k(cVar2, "art");
            }
        }
        f5Var.L0 = p5.FATAL;
        f5Var.G0 = new Date(timestamp);
        if (sentryAndroidOptions.isAttachAnrThreadDump() && (bArr = (byte[]) x3Var.c) != null) {
            l0VarF.f = new io.sentry.a("thread-dump.txt", HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE, bArr);
        }
        return new io.sentry.m(2, f5Var, l0VarF, b0Var);
    }
}
