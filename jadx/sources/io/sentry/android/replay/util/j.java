package io.sentry.android.replay.util;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class j implements Runnable {
    public final String b;
    public final /* synthetic */ Runnable f;

    public j(Runnable runnable, String str) {
        runnable.getClass();
        this.b = str;
        this.f = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f.run();
    }
}
