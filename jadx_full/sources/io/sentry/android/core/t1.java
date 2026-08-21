package io.sentry.android.core;

import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-605be6ced3201ebf27d05845df89146b03500986a7a8ae40fc58e667db41f02f */
/* JADX INFO: loaded from: classes.dex */
public final class t1 extends defpackage.m0 {
    @Override // defpackage.m0
    public final void u(boolean z) {
        super.u(z);
        if (z) {
            d("android.webkit.WebView");
            d("android.widget.VideoView");
            d("androidx.camera.view.PreviewView");
            d("androidx.media3.ui.PlayerView");
            d("com.google.android.exoplayer2.ui.PlayerView");
            d("com.google.android.exoplayer2.ui.StyledPlayerView");
            return;
        }
        CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet) this.a;
        copyOnWriteArraySet.remove("android.webkit.WebView");
        copyOnWriteArraySet.remove("android.widget.VideoView");
        copyOnWriteArraySet.remove("androidx.camera.view.PreviewView");
        copyOnWriteArraySet.remove("androidx.media3.ui.PlayerView");
        copyOnWriteArraySet.remove("com.google.android.exoplayer2.ui.PlayerView");
        copyOnWriteArraySet.remove("com.google.android.exoplayer2.ui.StyledPlayerView");
    }

    @Override // defpackage.m0
    public final void y() {
    }
}
