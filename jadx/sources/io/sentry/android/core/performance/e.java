package io.sentry.android.core.performance;

import android.os.MessageQueue;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements MessageQueue.IdleHandler {
    public final /* synthetic */ g a;

    @Override // android.os.MessageQueue.IdleHandler
    public final boolean queueIdle() {
        this.a.d();
        return false;
    }
}
