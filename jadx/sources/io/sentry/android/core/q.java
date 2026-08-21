package io.sentry.android.core;

import io.sentry.p5;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class q implements io.sentry.util.e {
    public final /* synthetic */ int b;
    public final /* synthetic */ SentryAndroidOptions f;

    public /* synthetic */ q(SentryAndroidOptions sentryAndroidOptions, int i) {
        this.b = i;
        this.f = sentryAndroidOptions;
    }

    @Override // io.sentry.util.e
    public Object e() {
        int i = this.b;
        SentryAndroidOptions sentryAndroidOptions = this.f;
        switch (i) {
            case 0:
                return sentryAndroidOptions.getExecutorService();
            case 1:
                return sentryAndroidOptions.getExecutorService();
            case 2:
                List list = io.sentry.android.core.cache.c.B0;
                String outboxPath = sentryAndroidOptions.getOutboxPath();
                boolean z = false;
                if (outboxPath != null) {
                    File file = new File(outboxPath, "startup_crash");
                    try {
                        boolean zExists = file.exists();
                        if (zExists && !file.delete()) {
                            sentryAndroidOptions.getLogger().h(p5.ERROR, "Failed to delete the startup crash marker file. %s.", file.getAbsolutePath());
                        }
                        z = zExists;
                    } catch (Throwable th) {
                        sentryAndroidOptions.getLogger().d(p5.ERROR, "Error reading/deleting the startup crash marker file on the disk", th);
                    }
                    break;
                } else {
                    sentryAndroidOptions.getLogger().h(p5.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
                }
                return Boolean.valueOf(z);
            default:
                return sentryAndroidOptions.getExecutorService();
        }
    }
}
