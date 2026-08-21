package io.sentry.android.core.performance;

import android.view.Window;
import defpackage.iy;
import io.sentry.android.core.internal.gestures.j;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class i extends j {
    public final iy f;

    public i(Window.Callback callback, iy iyVar) {
        super(callback);
        this.f = iyVar;
    }

    @Override // io.sentry.android.core.internal.gestures.j, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        this.f.run();
    }
}
