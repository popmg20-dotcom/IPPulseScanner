package io.sentry.android.core;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
final class ApplicationNotResponding extends RuntimeException {
    public final Thread b;

    public ApplicationNotResponding(String str, Thread thread) {
        super(str);
        io.sentry.util.b.r(thread, "Thread must be provided.");
        this.b = thread;
        setStackTrace(thread.getStackTrace());
    }

    public ApplicationNotResponding(String str) {
        super(str);
        this.b = null;
    }
}
