package io.sentry;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements ThreadFactory {
    public final /* synthetic */ int b;
    public int f;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.b) {
            case 0:
                StringBuilder sb = new StringBuilder("SentryHostnameCache-");
                int i = this.f;
                this.f = i + 1;
                sb.append(i);
                Thread thread = new Thread(runnable, sb.toString());
                thread.setDaemon(true);
                return thread;
            case 1:
                StringBuilder sb2 = new StringBuilder("SentryExecutorServiceThreadFactory-");
                int i2 = this.f;
                this.f = i2 + 1;
                sb2.append(i2);
                i5 i5Var = new i5(runnable, sb2.toString());
                i5Var.setDaemon(true);
                return i5Var;
            case 2:
                runnable.getClass();
                StringBuilder sb3 = new StringBuilder("SentryReplayIntegration-");
                int i3 = this.f;
                this.f = i3 + 1;
                sb3.append(i3);
                Thread thread2 = new Thread(runnable, sb3.toString());
                thread2.setDaemon(true);
                return thread2;
            case 3:
                runnable.getClass();
                StringBuilder sb4 = new StringBuilder("SentryReplayPersister-");
                int i4 = this.f;
                this.f = i4 + 1;
                sb4.append(i4);
                Thread thread3 = new Thread(runnable, sb4.toString());
                thread3.setDaemon(true);
                return thread3;
            default:
                StringBuilder sb5 = new StringBuilder("SentryAsyncConnection-");
                int i5 = this.f;
                this.f = i5 + 1;
                sb5.append(i5);
                Thread thread4 = new Thread(runnable, sb5.toString());
                thread4.setDaemon(true);
                return thread4;
        }
    }
}
